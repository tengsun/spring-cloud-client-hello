package st.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoClientController {
	
	@Value("${service.hello.url}")
	private String url;

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value = "/hello-client", method = RequestMethod.GET)
	public String helloClient() {
		return restTemplate.getForEntity(url, String.class).getBody();
	}
	
}
