package pe.com.bank.enterprise.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import pe.com.bank.enterprise.entity.PersonEnterprise;
import reactor.core.publisher.Mono;

@Component
public class PersonEnterpriseRestClient {
	
	
	 private WebClient webClient;		
	  
	  public PersonEnterpriseRestClient(WebClient webClient) {
	        this.webClient = webClient;
	    }
	  
	  
	  @Value("${restClient.personEnterprisesUrl}")
	  private String personEnterpriseUrl;
	  
	  public Mono<PersonEnterprise> getPersonEnterprise(String enterpriseId){
		  
		  var url = UriComponentsBuilder.fromHttpUrl(personEnterpriseUrl)
	                .queryParam("enterpriseId", enterpriseId)
	                .buildAndExpand().toUriString();
		  
		  return  webClient
	                .get()
	                .uri(url)
	                .retrieve()
	                .bodyToMono(PersonEnterprise.class)
	                .log();
 
	  }  

}
