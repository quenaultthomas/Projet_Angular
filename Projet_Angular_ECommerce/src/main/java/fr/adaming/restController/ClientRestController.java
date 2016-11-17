package fr.adaming.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Category;
import fr.adaming.model.Client;
import fr.adaming.model.Product;
import fr.adaming.service.IClientService;

@RestController 
@RequestMapping(value="/client")
public class ClientRestController {
	
		@Autowired
		IClientService clientService;
		
		@RequestMapping(value="/allCat", method=RequestMethod.GET,produces="application/json")
		public List<Category> getAllCat(){
			return clientService.GetAllCategorie();
		}
		
		@RequestMapping(value="/allProd", method=RequestMethod.GET,produces="application/json")
		public List<Product> getAllProd(){
			return clientService.SearchByAllProduits();
		}
		
		@RequestMapping(value="/prodByIdCat/{id}", method=RequestMethod.GET,produces="application/json")
		public List<Product> getProdByIdCat(@PathVariable("id") int id){
			return clientService.SearchByIdCategorie(id);
		}
		
		@RequestMapping(value="/addClient", method=RequestMethod.POST,produces="application/json")
		public Client addClient(@RequestBody Client client){
			
			return clientService.addClient(client);
		}
		
		@RequestMapping(value="/upClient", method=RequestMethod.PUT,produces="application/json")
		public Client upClient(@RequestBody Client client){
			
			return clientService.upClient(client);
			
		}
	
}

