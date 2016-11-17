package fr.adaming.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Category;
import fr.adaming.service.IClientService;

public class ClientRestController {

	@RestController // Controller rest de Spring MVC
	public class PaysRestControler {
		
		@Autowired
		IClientService clientService;
		
		@RequestMapping(value="/allCat", method=RequestMethod.GET,produces="application/json")
		public List<Category> getAllCat(){
			return clientService.GetAllCategorie();
		}
	
}
}
