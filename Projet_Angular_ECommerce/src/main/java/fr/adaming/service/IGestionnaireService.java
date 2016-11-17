package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Category;
import fr.adaming.model.Product;

public interface IGestionnaireService {
	
	
/** Méthodes concernant les categories*/
	
	public void addCategoryService(Category c);
	
	public void delCategoryService(int id);
	
	public void upCategoryService(Category c);
	
	public List<Category> getAllCategoriesService();
	
	public Category getCategoryByIdService(int id);
	
	
	
	
	
	/** Méthodes concernant les produits*/
	
	public void addProductService(Product p);
	
	public void delProduitService(int id);
	
	public void upProduitService(Product p);
	
	public List<Product> getAllProductsService();
	
	public Product getProductByIdService(int id);
	
	public List<Product> SearchByKeyWordsProductService(String keyWord);
	
	public List<Product> SearchByIdCategorieService(int id_c);

}
