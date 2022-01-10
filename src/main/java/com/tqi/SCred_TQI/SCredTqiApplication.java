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
			SpringApplication.run(SCredTqiApplication.class, args);
	}

}
