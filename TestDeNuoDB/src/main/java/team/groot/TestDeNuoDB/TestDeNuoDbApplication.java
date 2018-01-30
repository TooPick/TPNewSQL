package team.groot.TestDeNuoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import team.groot.TestDeNuoDB.Model.PlayerService;
import team.groot.TestDeNuoDB.Model.TeamService;

@SpringBootApplication
public class TestDeNuoDbApplication {
	@Autowired
	public PlayerService ps;
	@Autowired
	public TeamService ts;

	public static void main(String[] args) {
		SpringApplication.run(TestDeNuoDbApplication.class, args);
	}
}
