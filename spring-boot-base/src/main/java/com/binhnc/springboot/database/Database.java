package com.binhnc.springboot.database;

import com.binhnc.springboot.model.Product;
import com.binhnc.springboot.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
docker run -d --rm --name mysql-spring-boot-tutorial \
-e MYSQL_ROOT_PASSWORD= \
-e MYSQL_USER= \
-e MYSQL_PASSWORD= \
-e MYSQL_DATABASE=test_db \
-p 3309:3306 \
-- volume mysql-spring-boot-tutorial-volume:/var/lib/mysql \
mysql:8.2.4
mysql:latest

mysql -h localhost -P 3309 --protocol=tcp -u root -p
* */
@Configuration
public class Database {
    // logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
               /* Product productA = new Product("Macbook", 2024, 2500.0, "");
                Product productB = new Product("Ipad", 2024, 2600.0, "");
                logger.info("Insert Data: " + productRepository.save(productA));
                logger.info("Insert Data: " + productRepository.save(productB));*/
            }
        };
    }
}
