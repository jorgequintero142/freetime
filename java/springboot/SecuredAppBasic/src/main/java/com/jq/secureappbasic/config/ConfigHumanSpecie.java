package com.jq.secureappbasic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jq.secureappbasic.model.HumanSpecie;
import com.jq.secureappbasic.service.HumanSpecieService;

@Configuration
public class ConfigHumanSpecie implements CommandLineRunner {

	@Autowired
	HumanSpecieService humanSpecieService;

	@Override
	public void run(String... args) throws Exception {
		HumanSpecie humanSpecie1 = new HumanSpecie("Homo sapiens",
				"Humans (Homo sapiens) are the most abundant and widespread species of primate, characterized by bipedalism and exceptional cognitive skills due to a large and complex brain.");
		HumanSpecie humanSpecie2 = new HumanSpecie("Homo antecessor",
				"Homo antecessor (Latin \"pioneer man\") is an extinct species of archaic human recorded in the Spanish Sierra de Atapuerca, a productive archaeological site, from 1.2 to 0.8 million years ago during the Early Pleistocene.");
		HumanSpecie humanSpecie3 = new HumanSpecie("Homo erectus",
				"Homo erectus (/ˌhoʊmoʊ əˈrɛktəs/; meaning \"upright man\") is an extinct species of archaic human from the Pleistocene, with its earliest occurrence about 2 million years ago");
		HumanSpecie humanSpecie4 = new HumanSpecie("Homo habilis",
				"Homo habilis (\"handy man\") is an extinct species of archaic human from the Early Pleistocene of East and South Africa about 2.31 million years ago to 1.65 million years ago (mya)");
		HumanSpecie humanSpecie5 = new HumanSpecie("Homo neanderthalensis",
				"Humans (Homo sapiens) are the most abundant and widespread species of primate, characterized by bipedalism and exceptional cognitive skills due to a large and complex brain.\");");

		humanSpecieService.save(humanSpecie1);
		humanSpecieService.save(humanSpecie2);
		humanSpecieService.save(humanSpecie3);
		humanSpecieService.save(humanSpecie4);
		humanSpecieService.save(humanSpecie5);

	}

}
