package com.api.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.api.entity.Book;

public class BookDAO implements Daok{

private SessionFactory factory = SessionUtil.getFactory();
	
	@SuppressWarnings("deprecation")
	@Override
	public void saveBook(Book book) {
		Transaction transaction = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.save(book);
			transaction.commit();
		} catch (Exception e) {
			if(transaction == null)
				transaction.rollback();
		}
	}
	

	@Override
	public Book getBookById(long id) {
		Transaction transaction = null;
		Book book = null;
		try(Session session = factory.openSession()) {
//			Session session = factory.openSession();
			transaction = session.beginTransaction();
			book = session.get(Book.class, id);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		Transaction transaction = null;
		List<Book> Books = null;
		try(Session session = factory.openSession()) {
//	     Session session = factory.openSession();
	     transaction = session.beginTransaction();
			Books = session.createNativeQuery("Select * from Book",Book.class).list();
			transaction.commit();
     	} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
		return Books;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int updateBook(int id, Book book) {
		if(id <=0)  
	         return 0;  
		 Session session = factory.openSession();
		  Transaction tx = session.beginTransaction();
	     
	      String hql = "update Book set name = :name, price=:price, description=:description where id = :id";
		  @SuppressWarnings({ "rawtypes" })
	      Query query = session.createQuery(hql);
	      query.setParameter("id",id);
	      query.setParameter("name",book.getName());
	      query.setParameter("price",book.getPrice());
	      query.setParameter("description",book.getDescription());
	      query.executeUpdate();
	      System.out.println("Rows affected: " );
	      tx.commit();
	      session.close();
	      return 200;
	}
	
	
	
	  
	@Override
	public int deleteBookById(int id) {
		   Session session = factory.openSession();
		    Transaction tx = session.beginTransaction();
		    String hql = "delete from Book where id = :id";
		    @SuppressWarnings({ "rawtypes", "deprecation" })
			Query query = session.createQuery(hql);
		    query.setParameter("id",id);
		    int rowCount = query.executeUpdate();
		    System.out.println("Rows affected: " + rowCount);
		    tx.commit();
		    session.close();
		    return rowCount;
	}

}
