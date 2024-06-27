package com.ticket.GesTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ticket.GesTicket.repository")
//@ComponentScan(basePackages = "com.ticket.GesTicket")
public class GesTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(GesTicketApplication.class, args);
	}

}
