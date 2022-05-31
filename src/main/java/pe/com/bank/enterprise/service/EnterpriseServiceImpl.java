package pe.com.bank.enterprise.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.bank.enterprise.client.PersonEnterpriseRestClient;
import pe.com.bank.enterprise.entity.Enterprise;
import pe.com.bank.enterprise.repository.EnterpriseRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class EnterpriseServiceImpl implements EnterpriseService{
	
	PersonEnterpriseRestClient  personEnterpriseRestClient;
	EnterpriseRepository enterpriseRepository;
    
    private static final Logger log = LoggerFactory.getLogger(EnterpriseServiceImpl.class);

    public Mono<Enterprise> addEnterprise(Enterprise enterprise){
    	log.info("addEnterprise");    	
    	return enterpriseRepository.save(enterprise).doOnNext(enterpriseSaved -> log.info("Enterprise id :"+enterprise.getId()+" Saved"));
    }
    
    public Flux<Enterprise> getEnterprises(){
    	log.info("getEnterprises");  
       return enterpriseRepository.findAll().doOnNext(enterprise -> log.info("Enterprise id :"+enterprise.getId()));
    }
    
    public Mono<Enterprise> getEnterpriseById(String id){
    	log.info("getEnterpriseById");  
    	return enterpriseRepository.findById(id).doOnNext(enterprise -> log.info("Enterprise id :"+enterprise.getId()));
    }
    
    public Mono<Enterprise> updateEnterprise(Enterprise enterpriseUpdate, String id){
    	log.info("updateEnterprise"); 
    	return enterpriseRepository.findById(id).flatMap(enterprise -> {
    		
    		enterprise.setRazonSocial(enterpriseUpdate.getRazonSocial() != null ? enterpriseUpdate.getRazonSocial():enterprise.getRazonSocial());
    		enterprise.setRuc(enterpriseUpdate.getRuc() != null ? enterpriseUpdate.getRuc():enterprise.getRuc());
    		enterprise.setAddress(enterpriseUpdate.getAddress() != null ? enterpriseUpdate.getAddress():enterprise.getAddress());
    		enterprise.setCustomerId(enterpriseUpdate.getCustomerId() != null ? enterpriseUpdate.getCustomerId():enterprise.getCustomerId());
    			    		
    		return enterpriseRepository.save(enterprise);
 
    	}).doOnNext(enterprise -> log.info("Enterprise id :"+enterprise.getId()+" Updated"));
    }
    
    public Mono<Void> deleteEnterpriseById(String id){
    	log.info("deleteEnterpriseById"); 
    	return enterpriseRepository.deleteById(id);
    }

    /*
	public Flux<Person> getPersonByEnterpriseId(String id) {
		
		return this.getEnterpriseById(id).flatMap(enterprise -> {
			
			personEnterpriseRestClient.
			enterprise.
			return 
		})
	}
	
*/
}
