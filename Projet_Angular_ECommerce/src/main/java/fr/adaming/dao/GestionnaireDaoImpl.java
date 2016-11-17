package fr.adaming.dao;

import java.util.List;












import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Category;
import fr.adaming.model.Product;


@Repository
public class GestionnaireDaoImpl implements IGestionnaireDao {
	
	@Autowired
	private SessionFactory sf; 

	
	
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


	@Override
	public void addCategoryDao(Category c) {
		Session s = sf.getCurrentSession();
		s.save(c);
		
	}

	@Override
	public void delCategoryDao(int id) {
		Session s = sf.getCurrentSession();
		Category cat = (Category) s.get(Category.class, id);
		s.delete(cat);
		
	}

	@Override
	public void upCategoryDao(Category c) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategoriesDao() {
		Session s = sf.getCurrentSession();
		
		Query query = s.createQuery("FROM Category");
		return query.list();
	}

	@Override
	public Category getCategoryByIdDao(int id) {
		Session s = sf.getCurrentSession();
		
		Query query = s.createQuery("SELECT c FROM Category c WHERE c.id=:qId");
		query.setParameter("qId", id);
		Category cat = (Category) query.uniqueResult();
		
		return cat;
	}
	
	
	

	
	
	
	/** Méthodes concernants les produits*/
	
	
	
	@Override
	public void addProductDao(Product p) {
		Session s = sf.getCurrentSession();
		
		s.save(p);
		
	}

	@Override
	public void delProduitDao(int id) {
		Session s = sf.getCurrentSession();
		
		Product p = (Product) s.get(Product.class, id);
		s.delete(p);
		
	}

	@Override
	public void upProduitDao(Product p) {
		Session s = sf.getCurrentSession();
		
		s.saveOrUpdate(p);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProductsDao() {
		Session s = sf.getCurrentSession();
		
		Query query = s.createQuery("FROM Product");
		return query.list();
		
	}

	@Override
	public Product getProductByIdDao(int id) {
		Session s = sf.getCurrentSession();
		
		Product p = (Product) s.get(Product.class, id);
		return p;
	}

	


	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchByKeyWordsProductDao(String keyWord) {
		Session s = sf.getCurrentSession();
		
		Query req = s.createQuery("SELECT p FROM Product p WHERE p.nom like:kw or p.description like:kw");
		req.setParameter("kw", "%" + keyWord + "%");
		return req.list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchByIdCategorieDao(int id_c) {
		Session s = sf.getCurrentSession();
		
		Query query = s.createQuery("SELECT p FROM Product p WHERE p.ID_CATEGORIE=:qIdC");
		query.setParameter("qIdC", id_c);
		return query.list();
	}

}
