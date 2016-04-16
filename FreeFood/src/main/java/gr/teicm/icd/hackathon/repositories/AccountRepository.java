package gr.teicm.icd.hackathon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import gr.teicm.icd.hackathon.models.Account;

public interface AccountRepository extends MongoRepository<Account, String> {

	Account findByUsername(String username);

}