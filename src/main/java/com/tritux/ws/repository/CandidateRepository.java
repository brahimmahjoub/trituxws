package com.tritux.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tritux.ws.model.Candidate;

/**
 * A simple repository for Candidate entity extend the JpaRepository interface
 * provided by spring contain some methods that must not be implemented. Method's example:
 * 
 * <ul>
 * <li>save()</li>
 * <li>merge()</li>
 * <li>...</li>
 * </ul>
 * 
 * @author Brahim Mahjoub (brahimmahjoub@yahoo.fr)
 *
 */

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	public void delete(Candidate candidate);

	public Candidate findByEmail(String email);

}
