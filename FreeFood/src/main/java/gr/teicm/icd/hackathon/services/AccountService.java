package gr.teicm.icd.hackathon.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import gr.teicm.icd.hackathon.configs.SpringMongoConfig;
import gr.teicm.icd.hackathon.models.Account;

@Service
public class AccountService {
	
	public AccountService() {

	}
	
	public boolean insertAccount(Account account) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		Query query = new Query();
		query.addCriteria(Criteria.where("accUsername").is(account.getUsername()));

		if(mongoOperation.exists(query, Account.class)){
			return false;
		}
		else {
			account.addRole("ROLE_USER");
			mongoOperation.insert(account);
			return true;
		}
	}
}
