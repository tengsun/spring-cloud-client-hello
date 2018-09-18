package st.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoClientController {

	@Autowired
	DemoClientAgent clientAgent;
	
	@RequestMapping(value = "/hello-client", method = RequestMethod.GET)
	public String helloClient() {
		return clientAgent.helloRequest();
	}
	
}
