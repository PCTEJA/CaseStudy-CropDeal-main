package com.cropdeal.dealerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdeal.dealerservice.models.Dealer;
import com.cropdeal.dealerservice.repository.DealerRepository;

@Service
public class DealerServiceImpl implements DealerService {
	@Autowired
	private DealerRepository dealerRepo;

	@Override
	public List<Dealer> findAll() {
		return dealerRepo.findAll();
	}

	@Override
	public Optional<Dealer> getdealerById(String id) {
		return dealerRepo.findById(id);
	}

	@Override
	public Dealer addDealer(Dealer dealer) {
		return dealerRepo.insert(dealer);
	}

	@Override
	public Dealer updateDealer(Dealer dealer) {
		return dealerRepo.save(dealer);
	}

	@Override
	public String deleteById(String id) {
		dealerRepo.deleteById(id);
		return "dealer deleted having id " + id;
	}

}
