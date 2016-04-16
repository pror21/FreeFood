package gr.teicm.icd.hackathon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import gr.teicm.icd.hackathon.models.Account;
import gr.teicm.icd.hackathon.models.FoodMark;

public interface FoodMarkRepository extends MongoRepository<FoodMark, String> {

	FoodMark findByAcc(Account account);
}