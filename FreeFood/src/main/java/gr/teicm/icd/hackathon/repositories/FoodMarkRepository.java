package gr.teicm.icd.hackathon.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import gr.teicm.icd.hackathon.models.Account;
import gr.teicm.icd.hackathon.models.FoodMark;

@Repository
public interface FoodMarkRepository extends MongoRepository<FoodMark, String> {

	FoodMark findByAcc(Account account);
	List<FoodMark> findAll();
	
}