package in.sbms.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	
	@GetMapping("/welcome")
	public String welcomeMsg()
	{
		return "WELCOME TO BIHAR";
	}
	
	@GetMapping("/greet")
	public String greetMsg()
	{
		return "GOOD MORNING";
	}

}
