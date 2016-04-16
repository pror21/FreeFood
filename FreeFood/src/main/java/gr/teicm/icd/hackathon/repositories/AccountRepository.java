package gr.teicm.icd.hackathon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import gr.teicm.icd.hackathon.models.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

	Account findByUsername(String username);

}