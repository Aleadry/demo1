package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.example.po.User;

public class Test {
	
	
	@PersistenceContext
	EntityManager em;

	public static void main(String[] args) {
		// 1. 创建EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo7");

		// 2. 创建EntityManager
		EntityManager entityManager = factory.createEntityManager();

		add(entityManager);
//		search(entityManager, "tom");
//		delete(entityManager,1);
//		update(entityManager,1,"asssasdf");

		// 6. 关闭EntityManager
		entityManager.close();
		
		// 7. 关闭EntityManagerFactory
		factory.close();
	}

	public static void add(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// 4. 持久化操作
		User user = new User();
		user.setUsername("jack1");
		user.setPassword("123456");
		

		// 添加user到数据库，相当于hibernate的save();
		entityManager.persist(user);

		// 5. 提交事务
		transaction.commit();

	}

	@SuppressWarnings("unchecked")
	public static void search(EntityManager entityManager, String name) {

		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		List<User> list = entityManager.createQuery("SELECT u FROM User u WHERE u.userName LIKE ?1").setParameter(1, name).getResultList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
	public static void update(EntityManager entityManager,int id,String name) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		User user=entityManager.find(User.class,id);
//		entityManager.clear();
		user.setUsername(name);
		user.setId(user.getId());
		user.setPassword("asdasd");
		user.setAuthorityList(null);
		entityManager.merge(user);
		transaction.commit();
		}
	public static void delete(EntityManager entityManager,int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		User user=entityManager.find(User.class,id);
		entityManager.remove(user);
		entityManager.getTransaction().commit();
	}
}
