package gr.teicm.icd.hackathon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import gr.teicm.icd.hackathon.repositories.AccountRepository;

@Service
public class FoodMarkService {

	@Autowired
	private AccountRepository repository;

	@Autowired
	private SimpMessagingTemplate template;
	
	public FoodMarkService() {

	}
}
