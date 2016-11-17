package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Category;
import fr.adaming.model.Product;

public interface IGestionnaireService {
	
	
/** Méthodes concernant les categories*/
	
	public Category addCategoryService(Category c);
	
	public void delCategoryService(int id);
	
	public Category upCategoryService(Category c);
	
	public List<Category> getAllCategoriesService();
	
	public Category getCategoryByIdService(int id);
	
	
	
	
	
	/** Méthodes concernant les produits*/
	
	public Product addProductService(Product p);
	
	public void delProduitService(int id);
	
	public Product upProduitService(Product p);
	
	public List<Product> getAllProductsService();
	
	public Product getProductByIdService(int id);
	
	public List<Product> SearchByKeyWordsProductService(String keyWord);
	
	public List<Product> SearchByIdCategorieService(int id_c);

}
