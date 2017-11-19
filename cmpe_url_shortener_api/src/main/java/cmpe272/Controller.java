package cmpe272;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class Controller {

	@Autowired
    private UrlRepository repository;

//https://stackoverflow.com/questions/16232833/how-to-respond-with-http-400-error-in-a-spring-mvc-responsebody-method-returnin
    
    
    @RequestMapping(method = RequestMethod.DELETE, value="/api/v1/url/{shortURL}")
    public ResponseEntity<Response> deleteURL(@PathVariable String shortURL) {

    		try {
    			String oURL = repository.findBysURL(shortURL).get(0).oURL;
    			System.out.println(oURL);
    			
    			UrlMap urlMap = new UrlMap();
    			urlMap.sURL = shortURL;
    			urlMap.oURL = oURL;
    			String id = repository.findBysURL(urlMap.sURL).get(0).id;
    			repository.delete(id);
    			return new ResponseEntity<>(null, HttpStatus.OK);
    			
    		} catch (Exception e) {
    			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    		}
    }
    
    @RequestMapping(method = RequestMethod.PUT, value="/api/v1/url/shorten/{shortURL}") 
    public ResponseEntity<Response> putURL (@RequestBody UrlMap input, @PathVariable String shortURL){
    		try {
    			String oURL = input.oURL;
    			String sURL = shortURL;
    			List<UrlMap> repositoryList = repository.findAll();
    			
    			if (input.oURL == null) {
    				return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    			}
    			    			
    			for(UrlMap urlmap_object: repositoryList) {
    				if (urlmap_object.sURL.equals(sURL)) {
        				repository.delete(urlmap_object.id);
    				}
    			}
    			
    			UrlMap putUrlMap = new UrlMap(oURL, sURL);
    			repository.save(putUrlMap);
    		
    			return new ResponseEntity<>(new Response(sURL, oURL, ""), HttpStatus.ACCEPTED); //202
    		} catch(Exception e) {
    			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    		}
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/url/shorten")
    public ResponseEntity<Response> shorternURL(@RequestBody UrlMap input) {
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
    		
    			UrlMap urlMap = new UrlMap(oURL, sURL);
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
    
  
    
}
