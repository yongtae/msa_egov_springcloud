package msa.sample.catalogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CustomerApiServiceImpl implements CustomerApiService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	// customers 서비스가 에러 또는 지연시, Fallback 메소드를 호출
	@HystrixCommand(fallbackMethod = "getCustomerDetailFallback")
	public String getCustomerDetail(String customerId) {
		// TODO Auto-generated method stub
		
//		유레카 서버 등록된 클라이언트 정보 사용
//		customerService(클라이언트 이름, 대소문자 구분없음)는 
//		유레카 서버에 등록됨
		return restTemplate.getForObject("http://CUSTOMERSERVICE/customers/" + customerId, String.class);

		
		// 리본 설정값으로 테스트
//		return restTemplate.getForObject("http://customerHost/customers/" + customerId, String.class);

//		return restTemplate.getForObject("http://localhost:8082/customers/" + customerId, String.class);
	}

	public String getCustomerDetailFallback(String customerId, Throwable ex) {
		System.out.println("Error:" + ex.getMessage());
		return "고객정보 조회가 지연되고 있습니다.";
	}
}
