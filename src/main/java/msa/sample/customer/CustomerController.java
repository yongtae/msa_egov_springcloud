package msa.sample.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@GetMapping(path = "/{customerId}")
	public String getCustomerDetail(@PathVariable String customerId) {
//		hystrix 테스트
		//		throw new RuntimeException("I/O Exception");
	
		System.out.println("request customerId :" + customerId);
		return "[Customer id = " + customerId + " at " + System.currentTimeMillis() + "]";
	}

}
