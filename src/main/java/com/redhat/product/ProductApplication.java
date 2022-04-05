package com.redhat.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ProductApplication {
	private static final Logger log = LoggerFactory.getLogger(ProductApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository repository) {
		return (args) -> {
			// save a few products
			repository.save(new Product("南山人壽新定期壽險(NTL2)",
					"投保年齡：15足歲~最高60歲\n依自身需求選擇繳費年期\n彈性改換保障，讓保障更長久\n"));
			repository.save(new Product("南山人壽新定期壽險附約(NTR2)",
					"投保年齡：15足歲~最高60歲\n依自身需求選擇繳費年期\n彈性改換保障，讓保障更長久\n"));
			repository.save(new Product("南山人壽不分紅一年期定期壽險附約(N1TR)",
					"投保年齡：15足歲~60歲\n續保至74歲之保單年度末\n依需求選擇繳別(年/半年/季/月)"));
			repository.save(new Product("南山人壽新活力康祥定期健康保險(NTDD)",
					"投保年齡：15足歲~40歲\n7項重大疾病，輕/重度均有保障\n加強人生黃金期的階段性保障"));
			repository.save(new Product("南山人壽愛家保要保人豁免保險費附約(WOP)",
					"投保年齡：14歲~65歲\n豁免條件真多元，主約附約皆豁免\n保障期間最長遠，萬全防護愛綿延"));

			// fetch all products
			log.info("Product found with findAll():");
			log.info("-------------------------------");
			for (Product product : repository.findAll()) {
				log.info(product.toString());
			}
			log.info("");

			// fetch an individual Product by ID
			Product product = repository.findById(1L);
			log.info("Product found with findById(1L):");
			log.info("--------------------------------");
			log.info(product.toString());
			log.info("");

			// fetch Product by last name
			log.info("Product found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByName("Jack").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (product bauer : repository.findByLastName("Bauer")) {
			// log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}
