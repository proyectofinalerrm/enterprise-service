package pe.com.bank.enterprise.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.bank.enterprise.entity.Enterprise;

@Repository
public interface EnterpriseRepository extends ReactiveMongoRepository<Enterprise,String>{

}
