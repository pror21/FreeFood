package gr.teicm.icd.hackathon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import gr.teicm.icd.hackathon.models.FoodMark;

@Repository
public interface FoodMarkRepository extends MongoRepository<FoodMark, String> {

	@Query("{ 'acc.id' :  ?0 }")
	FoodMark findByAccId(String id);
}
