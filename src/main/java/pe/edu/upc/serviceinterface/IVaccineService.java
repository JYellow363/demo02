package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Vaccine;

public interface IVaccineService {
	public void insert(Vaccine vac);
	public List<Vaccine> list();
	public List<Vaccine> findByNameVaccine(Vaccine vac);
	public void delete(int idVaccine);
	public void update(Vaccine vac);
}
