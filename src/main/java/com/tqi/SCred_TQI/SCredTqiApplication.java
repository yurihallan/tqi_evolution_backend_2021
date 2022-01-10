package com.tqi.SCred_TQI;

import com.sun.istack.NotNull;
import com.tqi.SCred_TQI.entity.Cliente;
import com.tqi.SCred_TQI.entity.Emprestimo;
import com.tqi.SCred_TQI.entity.Endereco;
import com.tqi.SCred_TQI.repository.ClienteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SCredTqiApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext configurableApplicationContext =
			SpringApplication.run(SCredTqiApplication.class, args);
		ClienteRepository clienteRepository = configurableApplicationContext.getBean(ClienteRepository.class);



//		Cliente cliente = new Cliente("TesteMapper", "mapper@gamil","1234564845","222456231","45612355",3100);
//
//
//		Endereco endereco1 = new Endereco("rua mapper", "Osasco", "SP", cliente);
////		Endereco endereco2 = new Endereco("rua test55", "São jorge", "RJ", cliente);
//		List<Endereco> enderecos = Arrays.asList(endereco1);
//
//
//		Emprestimo emprestimo1 = new Emprestimo(2500,LocalDate.now().plusMonths(4),40,cliente);
////		Emprestimo emprestimo2 = new Emprestimo(6500,LocalDate.now(),18,cliente);
//		List<Emprestimo> emprestimos = Arrays.asList(emprestimo1);
//
//		cliente.setEnderecos(enderecos);
//		cliente.setEmprestimos(emprestimos);
//		clienteRepository.save(cliente);


	}

}
