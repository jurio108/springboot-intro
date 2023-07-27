package com.blog.blog.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.blog.model.User;
import com.blog.blog.test.dto.TestJpqlDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Service
public class TestJpqlService {
  // EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpqlTest");
  // EntityManager entityManager = entityManagerFactory.createEntityManager();
  // EntityTransaction entityTransaction = entityManager.getTransaction();

  // public List<TestJpqlDto> testJpql() {
  //   List<TestJpqlDto> result = new ArrayList<>();

  //   try {
  //     entityTransaction.begin();

  //     // 쿼리 로직 어쩌고 저쩌고

  //     entityTransaction.commit();
  //   } catch (Exception e) {
  //     entityTransaction.rollback();
  //   } finally {
  //     entityManager.close();
  //     entityManagerFactory.close();
  //   }

  //   return result;
  // }

  @PersistenceContext
  private EntityManager em;

  @SuppressWarnings("unchecked")
  public List<TestJpqlDto> testJpql() {
    /**
     * ** RAW QUERY
     * 
     * select sum(case when role = 'ADMIN' then 1 else 0 end)   as cntAdmin,
     *        sum(case when role = 'MANAGER' then 1 else 0 end) as cntManager,
     *        sum(case when role = 'USER' then 1 else 0 end)    as cntUser
     *   from blog.user;
     */

    String jpql = 
      "select sum(case when a.role = 'ADMIN' then 1 else 0 end)   as cntAdmin,"
    + "       sum(case when a.role = 'MANAGER' then 1 else 0 end) as cntManager,"
    + "       sum(case when a.role = 'USER' then 1 else 0 end)    as cntUser"
    + "  from User a";
    
    // Query query = em.createNativeQuery(jpql, "countUserRoleMapping");
    Query query = em.createQuery(jpql);
    List<TestJpqlDto> result = query.getResultList();

    return result;
  }
}
