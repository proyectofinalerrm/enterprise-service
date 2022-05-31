package pe.com.bank.enterprise.service;

import pe.com.bank.enterprise.entity.Enterprise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EnterpriseService {
	
	 public Mono<Enterprise> addEnterprise(Enterprise enterprise);
	 public Flux<Enterprise> getEnterprises();
	 public Mono<Enterprise> getEnterpriseById(String id);
	 public Mono<Enterprise> updateEnterprise(Enterprise enterprise, String id);
	 public Mono<Void> deleteEnterpriseById(String id);
	 //public Flux <Enterprise> getPersonByEnterpriseId(String id);

}
