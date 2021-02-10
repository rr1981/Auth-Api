package cucumber;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.auth.model.UserToken;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidateStepDefinition extends AbstractSpringTest {

	public String token = "";
	Map<String, Object> params = new HashMap<String, Object>();
	ResponseEntity<UserToken> res = null;
	HttpEntity<?> requestEntity = null;
	ResponseEntity<String> response = null;
	String url;

	@Given("User has logged in using userName {string} and password {string}")
	public void user_has_logged_in_using_user_name_and_password(String name, String pass) {
		// Write code here that turns the phrase above into concrete actions
		params.put("userName", name);
		params.put("password", pass);
		requestEntity = new HttpEntity<>(params);
		url = this.URL + ":" + this.port + "/authapp/login";
		res = this.loginRESTCall(url, HttpMethod.POST, requestEntity);
		this.token = res.getBody().getAuthToken();
	}

	@And("made a get call to \\/validate")
	public void made_a_get_call_to_validate() {
		// Write code here that turns the phrase above into concrete actions
		requestEntity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		requestEntity = new HttpEntity<>(headers);
		url = this.URL + ":" + this.port + "/authapp/validate";
		response = this.validateRestCall(url, HttpMethod.GET, requestEntity);
	}

	@Then("session should be validated")
	public void session_should_be_validated() {
		// Write code here that turns the phrase above into concrete actions
		assertNotNull(res.getBody());
	}

	@Then("Http status code as {string} should be returned")
	public void http_status_code_as_should_be_returned(String code) {
		// Write code here that turns the phrase above into concrete actions\
		assertEquals(Integer.parseInt(code), res.getStatusCodeValue());
	}

}
