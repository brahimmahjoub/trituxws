package com.tritux.ws.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tritux.ws.model.Candidate;
import com.tritux.ws.repository.CandidateRepository;
import com.tritux.ws.validation.exception.EmailExistsException;

import javassist.NotFoundException;

/**
 * CandidateServiceDaoImpl a simple service for Candidate entity implement the
 * CandidateServiceDao interface
 * 
 * 
 * @author Brahim Mahjoub (brahimmahjoub@yahoo.fr)
 *
 */

@Transactional
@Service
public class CandidateServiceDaoImpl implements CandidateServiceDao {

	@Autowired
	CandidateRepository candidateRepository;
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Candidate addCandidate(Candidate candidate) throws EmailExistsException {

		if (emailExist(candidate.getEmail())) {
			throw new EmailExistsException("Adress email already exist");
		}

		Candidate newCandidate = new Candidate();
		newCandidate.setEmail(candidate.getEmail());
		newCandidate.setName(candidate.getName());
		newCandidate.setSurname(candidate.getSurname());
		newCandidate.setAge(candidate.getAge());

		return candidateRepository.save(newCandidate);
	}

	@Override
	public Candidate findCandidate(Long id) {
		return candidateRepository.getOne(id);
	}

	@Override
	public List<Candidate> findAllCandidates() {
		return candidateRepository.findAll();
	}

	@Override
	public Candidate updateCandidate(Long id, String email, String name, String surname, int age)
			throws NotFoundException {
		Candidate candidate = candidateRepository.getOne(id);
		if (candidate == null) {
			throw new NotFoundException("Candidate not found with this id");
		}
		candidate.setEmail(email);
		candidate.setName(name);
		candidate.setSurname(surname);
		candidate.setAge(age);

		return entityManager.merge(candidate);
	}

	@Override
	public void removeCandidate(Long id) throws NotFoundException {
		Candidate candidate = entityManager.find(Candidate.class, id);
		if (candidate == null) {
			throw new NotFoundException("Candidate not found with this id");
		}
		candidateRepository.delete(candidate);
	}

	private boolean emailExist(String email) {
		Candidate candidate = candidateRepository.findByEmail(email);
		if (candidate != null) {
			return true;
		}
		return false;
	}

}
