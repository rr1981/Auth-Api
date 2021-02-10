package cucumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.auth.AuthApplication;
import com.auth.model.AuthResponse;
import com.auth.model.UserToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest(classes = AuthApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
public abstract class AbstractSpringTest {

	public static final String URL = "http://localhost";
	protected ObjectMapper mapper = new ObjectMapper(); 
	@LocalServerPort
	protected String port;
	@Autowired
	protected TestRestTemplate restTemplate;
	
	public TestRestTemplate getRestTemplate() {
		return restTemplate != null ? restTemplate : new TestRestTemplate();
	}

	public void setRestTemplate(TestRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public ResponseEntity<UserToken> loginRESTCall(String url, HttpMethod method, HttpEntity<?> requestEntity) {
		return getRestTemplate().exchange(url, method, requestEntity , UserToken.class);
	}
	
	public ResponseEntity<String> InvalidLoginRESTCall(String url, HttpMethod method, HttpEntity<?> requestEntity) {
		return getRestTemplate().exchange(url, method, requestEntity , String.class);
	}
	
	public ResponseEntity<String> validateRestCall(String url , HttpMethod method , HttpEntity<?> entity) {
		return getRestTemplate().exchange(url , method , entity , String.class);
	}

}
