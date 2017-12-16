package cmpe272;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="*", allowedHeaders="*", value="*")
@RestController
public class Controller {

	@Autowired
    private UrlRepository repository;

//https://stackoverflow.com/questions/16232833/how-to-respond-with-http-400-error-in-a-spring-mvc-responsebody-method-returnin
    
   
    @RequestMapping(method = RequestMethod.DELETE, value="/api/v1/url/{shortURL}")
    public ResponseEntity<Response> deleteURL(@RequestHeader(value="X-Forwarded-User") String user, @PathVariable String shortURL) {
    	if (user.equals(null) || user.isEmpty() == true) {
    		return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    	}
    	
		try {
			UrlMap map = repository.findBysURL(shortURL).get(0);

			if (!map.userName.equals(user)) {
				// User is different
				return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
			}
			UrlMap urlMap = new UrlMap(map.oURL, map.sURL, user);
			String id = repository.findBysURL(urlMap.sURL).get(0).id;
			repository.delete(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
			
		} catch (Exception e) {
			e.getMessage();
			Response res = new Response("", "", e.toString());
			return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
		}
    }
    
    @RequestMapping(method = RequestMethod.PUT, value="/api/v1/url/shorten/{shortURL}") 
    public ResponseEntity<Response> putURL (@RequestHeader(value="X-Forwarded-User") String user, @RequestBody UrlMap input, @PathVariable String shortURL){
    	if (user.equals(null) || user.isEmpty() == true) {
    		return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    	}
    	try {
    			String oURL = input.oURL;
    			String sURL = shortURL;
    			
    			if (input.oURL == null) {
    				return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    			}
    			
    			// Find object by short URL
    			List<UrlMap> repositoryList = repository.findBysURL(sURL);
    		
    			    			
    			for(UrlMap urlmap_object: repositoryList) {
    				// Found the object
    				if (urlmap_object.sURL.equals(sURL)) {
    					// User is the same as the user trying to update
    					if (urlmap_object.userName.equals(user)) {
    						repository.delete(urlmap_object.id);
    						
    						// Do update
    						UrlMap putUrlMap = new UrlMap(oURL, sURL, user);
    		    			repository.save(putUrlMap);
    		    		
    		    			return new ResponseEntity<>(new Response(sURL, oURL, ""), HttpStatus.ACCEPTED); //202
    					} else {
    						// User is different
    						return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    					}
    				}
    			}
    			
    			// Object is not found
    			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    		} catch(Exception e) {
    			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    		}
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/url/shorten")
    public ResponseEntity<Response> shorternURL(@RequestHeader(value="X-Forwarded-User") String user, @RequestBody UrlMap input) {
    	if (user.equals(null) || user.isEmpty() == true) {
    		return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    	}
		try {
			String oURL = input.oURL;
			if (oURL.equals("") || oURL == null) {
				return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			}
		
			if (!repository.findByoURL(oURL).isEmpty()) {
				return new ResponseEntity<>(new Response(repository.findByoURL(oURL).get(0).sURL, oURL, ""), HttpStatus.ACCEPTED);
			}
		
			String sURL = GenerateHash.getHash(oURL);

			if (!repository.findBysURL(sURL).isEmpty()) {
				long salt = System.currentTimeMillis();
				sURL = GenerateHash.getHash(oURL + salt);
			}
		
			UrlMap urlMap = new UrlMap(oURL, sURL, user);
			repository.save(urlMap);
			return new ResponseEntity<>(new Response(sURL, oURL, ""), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		} 	
    }
   
    @RequestMapping("/api/v1/url/{shortURL}")
    public ResponseEntity<String> expandShortURL(@PathVariable String shortURL) {
		if (repository.findBysURL(shortURL).isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location",repository.findBysURL(shortURL).get(0).oURL);    

		
		return new ResponseEntity<>(headers, HttpStatus.PERMANENT_REDIRECT);
    }
    
    @RequestMapping("/api/v1/urls")
    public ResponseEntity<List<Response>> getUrls(@RequestHeader(value="X-Forwarded-User") String user) {
    	if (user.equals(null) || user.isEmpty() == true) {
    		return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    	}
    	
    	List<UrlMap> map = repository.findByuserName(user);
    	if (map.isEmpty() == true) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
    	
    	List<Response> responses = new ArrayList<Response>();
    	for (UrlMap entry : map) {
    		Response resp = new Response(entry.sURL, entry.oURL, "");
    		responses.add(resp);
    	
    	}
    	MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    	headers.add("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Forwarded-User, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
		return new ResponseEntity<>(responses, headers, HttpStatus.OK);
    }
    
}
