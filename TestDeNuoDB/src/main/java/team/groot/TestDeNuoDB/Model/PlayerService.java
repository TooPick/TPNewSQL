package team.groot.TestDeNuoDB.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository pr;
	@Autowired
	private TeamRepository tr;
	
	public String getAllPlayer() throws JsonProcessingException {
		List<Player> players = (List<Player>) pr.findAll();
		return new ObjectMapper().writeValueAsString(players); // Renvoi la liste de player en format json
	}
	
	public String getPlayerById(Long id) throws JsonProcessingException {
		Player player = pr.findOne(id);
		return new ObjectMapper().writeValueAsString(player);
	}
	
	public String addPlayer(String FirstName, String LastName, Long teamId) throws JsonProcessingException {
		Player player = new Player(FirstName, LastName, tr.findOne(teamId));
		pr.save(player);
		return new ObjectMapper().writeValueAsString(player);
	}
	
	public String removePlayer(Long id) throws JsonProcessingException {
		Player player = pr.findOne(id);
		pr.delete(player);
		return new ObjectMapper().writeValueAsString(player);
	}
}
