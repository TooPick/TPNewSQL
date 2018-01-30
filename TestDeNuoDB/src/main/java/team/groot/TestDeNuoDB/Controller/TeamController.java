package team.groot.TestDeNuoDB.Controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import team.groot.TestDeNuoDB.Model.TeamService;

@RestController
public class TeamController {
	
	@Autowired
	private TeamService ts;
	
	@GetMapping("/team")
	public String api(
			@RequestParam(value = "action", required = false) String action,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name) throws JsonProcessingException, ParseException {
		String result = "";
		if(action != null) {
			switch (action) {
			case "lookup":
				result = ts.getAllTeams();
				break;
			case "lookOne":
				result = ts.getTeamById(new Long(id));
				break;
			case "add":
				result = ts.addTeam(name);
				break;
			case "remove":
				result = ts.removeTeam(new Long(id));
				break;
			default:
				break;
			}
		}

		return result;
	}

}
