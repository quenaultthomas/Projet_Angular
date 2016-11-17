package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Category;
import fr.adaming.model.Gestionnaire;
import fr.adaming.model.Product;


public interface IGestionnaireDao {
	
	
	
	/** Méthodes concernant les categories*/
	
	public Category addCategoryDao(Category c);
	
	public void delCategoryDao(int id);
	
	public Category upCategoryDao(Category c);
	
	public List<Category> getAllCategoriesDao();
	
	public Category getCategoryByIdDao(int id);
	
	
	
	
	
	/** Méthodes concernant les produits*/
	
	public Product addProductDao(Product p);
	
	public void delProduitDao(int id);
	
	public Product upProduitDao(Product p);
	
	public List<Product> getAllProductsDao();
	
	public Product getProductByIdDao(int id);
	
	public List<Product> SearchByKeyWordsProductDao(String keyWord);
	
	public List<Product> SearchByIdCategorieDao(int id_c);
	
		

}
