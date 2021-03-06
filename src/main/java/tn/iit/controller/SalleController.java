package tn.iit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.iit.dao.SalleDAO;
import tn.iit.entity.Salle;
 
@RestController
@RequestMapping("api/salle")
@CrossOrigin(origins = "*", maxAge=0)
public class SalleController {

	@Autowired
	private SalleDAO salledao;

	@GetMapping 
	public List<Salle> list() {
		return salledao.findAll();

	}

	@PostMapping 
	public String add(@RequestBody Salle salle) {
		String result;
		if (salle.getId() == null) {
			result = " insere";
		} else {
			result = " modifie";
		}
		salledao.saveAndFlush(salle);
		return salle + result;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		Salle s = salledao.findOne(id);
		salledao.delete(id);
		return s + "supprime";

	}
	
	
	@GetMapping("/{id}") 
	public Salle showdetail(@PathVariable Integer id) {
		return salledao.findOne(id);
	}

}
