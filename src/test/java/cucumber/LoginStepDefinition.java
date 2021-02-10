package cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap; 
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.auth.model.AuthResponse;
import com.auth.model.UserToken;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LoginStepDefinition extends AbstractSpringTest{
	
	private ResponseEntity<?> response = null;
	public HttpEntity<?> requestEntity = null;

	@Given("^User has entered userName \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_has_entered_userName_and_password(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("userName", arg1);
		requestMap.put("password", arg2);
		requestEntity = new HttpEntity<>(requestMap);		
	}

	@And("^made a post call for \"([^\"]*)\"$")
	public void made_a_post_call_for(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String url = this.URL+":"+this.port+"/authapp/login";
		this.response = this.loginRESTCall(url, HttpMethod.POST, requestEntity);
		log.info(this.response.getBody().toString());
		log.info(this.response.getStatusCode().toString());
	}
	
	@And("made a post call for {string} with wrong details")
	public void made_a_post_call_for_with_wrong_details(String string) {
	    // Write code here that turns the phrase above into concrete actions
		String url = this.URL+":"+this.port+"/authapp/login";
		this.response = this.InvalidLoginRESTCall(url, HttpMethod.POST, requestEntity);
	}

	@Then("^User should get a valid auth token$")
	public void user_should_get_a_valid_auth_token() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(200, this.response.getStatusCodeValue());		
	}
	
	@Then("User should get an exception")
	public void user_should_get_an_exception() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		log.info(this.response.toString());
		assertEquals(404, this.response.getStatusCodeValue());
	}
	

}
