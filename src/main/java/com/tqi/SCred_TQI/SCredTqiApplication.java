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


		//String nome, String email, String CPF, String RG,
		// String senha, Integer renda, List<Endereco> enderecos
//		Cliente cliente = new Cliente("teste1", "gabriel@gamil","1234564845","789456231","123adsw",12315);
//
//
//		//		String rua, String bairro, String cidade, Cliente cliente
//		Endereco endereco1 = new Endereco("rua test12", "Maoa", "SP", cliente);
//		Endereco endereco2 = new Endereco("rua test55", "São jorge", "RJ", cliente);
//		List<Endereco> enderecos = Arrays.asList(endereco1,endereco2);
//
//		//		Long valor_emprestimo, LocalDate data_primeira_parcela, int qtd_parcelas, Cliente cliente
//		Emprestimo emprestimo1 = new Emprestimo(4000,LocalDate.now().plusMonths(4),40,cliente);
//		Emprestimo emprestimo2 = new Emprestimo(6500,LocalDate.now(),18,cliente);
//		List<Emprestimo> emprestimos = Arrays.asList(emprestimo1,emprestimo2);
//
//		cliente.setEnderecos(enderecos);
//		cliente.setEmprestimos(emprestimos);
//		clienteRepository.save(cliente);


	}

}
