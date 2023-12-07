package dev.tau.jdbcblog;

import dev.tau.jdbcblog.post.Post;
import dev.tau.jdbcblog.post.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JdbcBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcBlogApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostRepository repository) {
		return args -> {
			repository.save(new Post("101","Hölön Pölön","hölön-pölön", LocalDate.now(),10,"Spring Boot",null));
			List<Post> posts = repository.findAll();
			System.out.println(posts);


			Optional<Post> hello = repository.findBySlug("hölön-pölön");
			System.out.println(hello);
		};
	}
}
