package team.groot.TestDeNuoDB.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository tr;
	
	public String getAllTeams() throws JsonProcessingException {
		List<Team> teams = (List<Team>) tr.findAll();
		return new ObjectMapper().writeValueAsString(teams);
	}
	
	public String getTeamById(Long id) throws JsonProcessingException {
		Team team = tr.findOne(id);
		return new ObjectMapper().writeValueAsString(team);
	}
	
	public String addTeam(String name) throws JsonProcessingException {
		Team team = new Team(name);
		tr.save(team);
		return new ObjectMapper().writeValueAsString(team);
	}
	
	public String removeTeam(Long id) throws JsonProcessingException {
		Team team = tr.findOne(id);
		tr.delete(team);
		return new ObjectMapper().writeValueAsString(team);
	}
	
//	public String addPlayer(Long id, Player player) throws JsonProcessingException {
//		Team team = tr.findOne(id);
//		// TODO : ajouter un player à la team
//		return new ObjectMapper().writeValueAsString(team);
//	}
//	
//	public String removePlayer(Long id, Player player) throws JsonProcessingException {
//		Team team = tr.findOne(id);
//		// TODO : enlever un player à la team
//		return new ObjectMapper().writeValueAsString(team);
//	}

}
