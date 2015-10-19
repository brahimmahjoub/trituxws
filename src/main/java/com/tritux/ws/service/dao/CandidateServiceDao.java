package com.tritux.ws.service.dao;

import java.util.List;

import com.tritux.ws.model.Candidate;
import com.tritux.ws.validation.exception.EmailExistsException;

import javassist.NotFoundException;

/**
 * A simple CandidateServiceDao for Candidate entity provide some action:
 * 
 * <ul>
 * <li>addCandiate(): to add new candidate</li>
 * <li>findCandiate(): to find candidate</li>
 * <li>updateCandiate(): to update candidate information</li>
 * <li>removeCandiate(): to remove candidate</li>
 * </ul>
 * 
 * @author Brahim Mahjoub (brahimmahjoub@yahoo.fr)
 *
 */

public interface CandidateServiceDao {

	/*
	 * add new candidate and throw an exception if candidate email already exist
	 * 
	 * @param candidate object contain candidate information
	 */
	public Candidate addCandidate(Candidate candidate) throws EmailExistsException;

	/*
	 * find candidate by id
	 * 
	 * @param id candidate's id
	 */

	public Candidate findCandidate(Long id);

	/*
	 * find all candidates
	 * 
	 */

	public List<Candidate> findAllCandidates();

	/*
	 * update candidate information
	 * 
	 * @param id candidate's id
	 * 
	 * @param email new candidate's email
	 * 
	 * @param name candidate's name
	 * 
	 * @param surname candidate's surname
	 * 
	 * @param age candidate's age
	 */

	public Candidate updateCandidate(Long id, String email, String name, String surname, int age)
			throws NotFoundException;

	/*
	 * remove candidate
	 * 
	 * @param id candidate's id
	 */

	public void removeCandidate(Long id) throws NotFoundException;

}
