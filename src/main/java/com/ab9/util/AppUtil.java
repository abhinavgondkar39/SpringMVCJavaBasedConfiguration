package com.ab9.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppUtil {

	public static void cleanUpResources(Session session, Transaction tx) {
		// TODO Auto-generated method stub
		if(session!=null){
			session.flush();
			if(tx!=null){
				tx.commit();
				session.close();
			}
		}
		System.out.println("session and transaction clean");
	}
}
