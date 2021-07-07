package com.example.SpringWithKotlin

import com.example.SpringWithKotlin.model.Bank
import com.example.SpringWithKotlin.model.repository.BankRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class SpringWithKotlinApplication {

	@Bean
	fun restTemplate (builder:RestTemplateBuilder):RestTemplate = builder.build()

	@Bean
	fun init(repository: BankRepository) = CommandLineRunner {

		//insert default Account
		if (repository.findAllByAccountCode(accountCode = "@@@").isEmpty){
			repository.save(Bank(1,"@@@",15.5,1))
		}
	}
}



fun main(args: Array<String>) {
	runApplication<SpringWithKotlinApplication>(*args)
}