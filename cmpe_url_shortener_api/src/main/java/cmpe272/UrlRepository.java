package cmpe272;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<UrlMap, String> {
	public List<UrlMap> findBysURL(String sURL);
	public List<UrlMap> findByoURL(String oURL);
	public List<UrlMap> findAll();
}
