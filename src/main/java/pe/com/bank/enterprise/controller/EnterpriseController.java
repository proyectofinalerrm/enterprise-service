package pe.com.bank.enterprise.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pe.com.bank.enterprise.entity.Enterprise;
import pe.com.bank.enterprise.service.EnterpriseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/v1")
public class EnterpriseController {
	
	   EnterpriseService enterpriseService;
	    
	    private static final Logger log = LoggerFactory.getLogger(EnterpriseController.class);
	    
	    @PostMapping
	    public Mono<Enterprise> addEnterprise(@RequestBody Enterprise enterprise){
	    	log.info("addEnterprise");
	    	return enterpriseService.addEnterprise(enterprise);
	    }
	    
	    @GetMapping
	    public Flux<Enterprise> getEnterprises() {
	    	log.info("getEnterprises");
	        return enterpriseService.getEnterprises();
	    }
	    
	    @GetMapping("/{id}")
	    public Mono<Enterprise> getEnterpriseId(@PathVariable String id){
	    	log.info("getEnterpriseId");
	    	return enterpriseService.getEnterpriseById(id);
	    }
	    
	    @PutMapping("/{id}")
	    public Mono<Enterprise> updateEnterpris(@RequestBody Enterprise enterpriseUpdate, @PathVariable String id){
	    	return enterpriseService.updateEnterprise(enterpriseUpdate, id);
	    }
	    	    
	    @DeleteMapping("/{id}")
	    public Mono<Void> deleteEnterpriseById(@PathVariable String id){
	    	return enterpriseService.deleteEnterpriseById(id);
	    }

}
