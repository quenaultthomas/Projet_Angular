package fr.adaming.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.model.Category;
import fr.adaming.model.Product;
import fr.adaming.service.IGestionnaireService;

public class ClasseTestFrancis {

	public static void main(String[] args) {
		String configLocation = "C:\\Users\\inti0297\\git\\Projet_SpringMVC\\Projet_Ecommerce\\src\\main\\webapp\\WEB-INF\\application-context.xml";
		 
        ApplicationContext context = new FileSystemXmlApplicationContext(configLocation);
        
        IGestionnaireService gestioService= (IGestionnaireService) context.getBean("gestioServBean");
        
//        Product p1 = new Product("Corida", "Album comprenant le titre la Corida", 1000, 18);
//        
//        Category cat= gestioService.getCategoryByIdService(4);
//        
//        p1.setCategorie(cat);
//        
//        gestioService.addProductService(p1);
        
        gestioService.delCategoryService(4);
        
        
//        Category c1 = new Category("CD", "Les albums de Francis");
//        gestioService.addCategoryService(c1);
//        
//        
//        
//        
//        Category c2 = gestioService.getCategoryByIdService(2);
//        c2.setNom("TShirt");
//        c2.setDescription("TShirt à l'effigie de notre chanteur favoris");
//        gestioService.upCategoryService(c2);
//        
//      Category c3 = gestioService.getCategoryByIdService(2);
//      Product p1 = new Product("Les beaux degats", "Album comprenant le titre la Corida", 500, 10);
//      p1.setCategorie(c3);
//      gestioService.addProductService(p1);
//      
//      gestioService.delCategoryService(2);
//      
//      List<Product> l2 = gestioService.getAllProductsService();
//      
//      for(Product prod1 : l2){
//      	System.out.println(prod1);
//      }
//        
//       gestioService.delCategoryService(3);
//        List<Category> l1 = gestioService.getAllCategoriesService();
//        for(Category cat1 : l1){
//        	System.out.println(cat1);
//        }
        

        
        
       

       
	}

}
