package st.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DemoClientAgent {
	
	@Value("${service.hello.url}")
	private String url;

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "helloFallback")
	public String helloRequest() {
		return restTemplate.getForEntity(url, String.class).getBody();
	}
	
	public String helloFallback() {
		return "Somethinig is wrong!";
	}

}
