package com.tritux.ws.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tritux.ws.model.Candidate;
import com.tritux.ws.service.dao.CandidateServiceDao;
import com.tritux.ws.validation.exception.EmailExistsException;

import javassist.NotFoundException;

/**
 * @author Brahim Mahjoub (brahimmahjoub@yahoo.fr)
 *
 */

@Controller
public class CandidateController {

	@Autowired
	private CandidateServiceDao candidateService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "create";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model) {
		Candidate candidateInstance = candidateService.findCandidate(id);
		model.addAttribute("candidateInstance", candidateInstance);
		return "edit";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Candidate> candidatesList = candidateService.findAllCandidates();
		model.addAttribute("candidatesList", candidatesList);
		
		return "list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createCandidate(Candidate candidate, Model model, RedirectAttributes attributes) {
		Candidate newCandidate = null;
		try {
			newCandidate = candidateService.addCandidate(candidate);
			attributes.addFlashAttribute("created", "candidate has been created successfully");
		} catch (EmailExistsException e) {
			attributes.addFlashAttribute("error", "an error has been occured!!");
			e.printStackTrace();
		}
		return "redirect:/list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCandidate(Candidate candidate, @RequestParam(value = "id") Long id, Model model, RedirectAttributes attributes) {
		Candidate candidateInstance = null;
		try {
			candidateInstance = candidateService.updateCandidate(id, candidate.getEmail(), candidate.getName(),
					candidate.getSurname(), candidate.getAge());
			attributes.addFlashAttribute("updated", "candidate has been updated successfully");
		} catch (NotFoundException e) {
			attributes.addFlashAttribute("error", "an error has been occured!!");
			e.printStackTrace();
		}
		return "redirect:/show/" + id;
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String removeCandidate(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
		try {
			candidateService.removeCandidate(id);
			attributes.addFlashAttribute("removed", "candidate has been removed successfully");
		} catch (NotFoundException e) {
			attributes.addFlashAttribute("error", "an error has been occured!!");
			e.printStackTrace();
		}
		return "redirect:/list";
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String showCandidate(@PathVariable("id") Long id, Model model) {
		Candidate candidateInstance = candidateService.findCandidate(id);
		model.addAttribute("candidateInstance", candidateInstance);
		return "show";
	}

}
