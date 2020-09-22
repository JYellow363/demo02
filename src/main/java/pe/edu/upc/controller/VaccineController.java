package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Laboratory;
import pe.edu.upc.entity.Vaccine;
import pe.edu.upc.serviceinterface.ILaboratoryService;
import pe.edu.upc.serviceinterface.IVaccineService;

@Named
@RequestScoped
public class VaccineController {
	@Inject
	private IVaccineService vS;
	@Inject
	private ILaboratoryService lS;

	private Laboratory laboratory;
	private Vaccine vaccine;

	List<Laboratory> listLaboratories;
	List<Vaccine> listVaccines;

	// Constructor
	@PostConstruct
	public void init() {
		this.laboratory = new Laboratory();
		this.vaccine = new Vaccine();
		this.listLaboratories = new ArrayList<Laboratory>();
		this.listVaccines = new ArrayList<Vaccine>();
		this.list();
		this.listLaboratories();
	}

	// métodos personalizados

	public String newVaccine() {
		this.setVaccine(new Vaccine());
		listLaboratories = lS.list();
		return "vaccine.xhtml";
	}

	public void insert() {
		try {

			vS.insert(vaccine);
			this.cleanVaccine();
			this.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void list() {
		try {
			listVaccines = vS.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void cleanVaccine() {
		this.init();
	}

	public void listLaboratories() {
		try {
			listLaboratories = lS.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	// get y set
	public Laboratory getLaboratory() {
		return laboratory;
	}

	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public List<Laboratory> getListLaboratories() {
		return listLaboratories;
	}

	public void setListLaboratories(List<Laboratory> listLaboratories) {
		this.listLaboratories = listLaboratories;
	}

	public List<Vaccine> getListVaccines() {
		return listVaccines;
	}

	public void setListVaccines(List<Vaccine> listVaccines) {
		this.listVaccines = listVaccines;
	}

}
