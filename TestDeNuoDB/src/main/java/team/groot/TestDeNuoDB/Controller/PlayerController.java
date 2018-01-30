package team.groot.TestDeNuoDB.Controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import team.groot.TestDeNuoDB.Model.PlayerService;

@RestController
public class PlayerController {
	
	@Autowired
	private PlayerService ps;
	
	@GetMapping("/player")
	public String api(
			@RequestParam(value = "action", required = false) String action,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "FirstName", required = false) String FirstName,
			@RequestParam(value = "LastName", required = false) String LastName) throws JsonProcessingException, ParseException {
		String result = "";
		if(action != null) {
			switch (action) {
			case "lookup":
				result = ps.getAllPlayer();
				break;
			case "lookOne":
				result = ps.getPlayerById(new Long(id));
				break;
			case "add":
				result = ps.addPlayer(FirstName, LastName, new Long(id));
				break;
			case "remove":
				result = ps.removePlayer(new Long(id));
				break;
			default:
				break;
			}
		}

		return result;
	}

}
