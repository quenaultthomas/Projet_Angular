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
	public void addCategoryService(Category c) {
		gestioDao.addCategoryDao(c);
		
	}

	@Override
	public void delCategoryService(int id) {
		gestioDao.delCategoryDao(id);
		
	}

	@Override
	public void upCategoryService(Category c) {
		gestioDao.upCategoryDao(c);
		
	}

	@Override
	public List<Category> getAllCategoriesService() {
		return gestioDao.getAllCategoriesDao();
	}

	@Override
	public Category getCategoryByIdService(int id) {
		return gestioDao.getCategoryByIdDao(id);
	}
	
	
	/** Méthodes concernant les categories*/
	
	@Override
	public void addProductService(Product p) {
		gestioDao.addProductDao(p);
		
	}

	@Override
	public void delProduitService(int id) {
		gestioDao.delProduitDao(id);
		
	}

	@Override
	public void upProduitService(Product p) {
		gestioDao.upProduitDao(p);
		
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
