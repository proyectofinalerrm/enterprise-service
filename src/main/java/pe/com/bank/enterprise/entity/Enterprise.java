package pe.com.bank.enterprise.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="enterprise")
public class Enterprise {
	
	@Id
	private String id;
	private String razonSocial;
	private String ruc;
	private String address;
	private String customerId;

}
