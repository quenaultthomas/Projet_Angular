package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGestionnaireDao;
import fr.adaming.model.Category;
import fr.adaming.model.Product;


@Service("gestioServBean")
@Transactional
public class GestionnaireServiceImpl implements IGestionnaireService {
	
	@Autowired
	private IGestionnaireDao gestioDao;
	
	
	
	/**
	 * @param gestioDao the gestioDao to set
	 */
	public void setGestioDao(IGestionnaireDao gestioDao) {
		this.gestioDao = gestioDao;
	}
	

	/** Méthodes concernant les categories*/

	@Override
	public Category addCategoryService(Category c) {
		return gestioDao.addCategoryDao(c);
		
	}

	@Override
	public void delCategoryService(int id) {
		gestioDao.delCategoryDao(id);
		
	}

	@Override
	public Category upCategoryService(Category c) {
		return gestioDao.upCategoryDao(c);
		
	}

	@Override
	public List<Category> getAllCategoriesService() {
		return gestioDao.getAllCategoriesDao();
	}

	@Override
	public Category getCategoryByIdService(int id) {
		return gestioDao.getCategoryByIdDao(id);
	}
	
	
	/** Méthodes concernant les produits*/
	
	@Override
	public Product addProductService(Product p) {
		return gestioDao.addProductDao(p);
		
	}

	@Override
	public void delProduitService(int id) {
		gestioDao.delProduitDao(id);
		
	}

	@Override
	public Product upProduitService(Product p) {
		return gestioDao.upProduitDao(p);
		
	}

	@Override
	public List<Product> getAllProductsService() {
		return gestioDao.getAllProductsDao();
	}

	@Override
	public Product getProductByIdService(int id) {
		return gestioDao.getProductByIdDao(id);
	}

	@Override
	public List<Product> SearchByKeyWordsProductService(String keyWord) {
		return gestioDao.SearchByKeyWordsProductDao(keyWord);
	}

	@Override
	public List<Product> SearchByIdCategorieService(int id_c) {
		return gestioDao.SearchByIdCategorieDao(id_c);
	}

	
	

	
	

}
