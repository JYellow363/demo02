package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerface.IVaccineDao;
import pe.edu.upc.entity.Vaccine;
import pe.edu.upc.serviceinterface.IVaccineService;

@Named
@RequestScoped
public class VaccineServiceImpl implements IVaccineService, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IVaccineDao vD;

	@Override
	public void insert(Vaccine vac) {
		vD.insert(vac);
	}

	@Override
	public List<Vaccine> list() {
		// TODO Auto-generated method stub
		return vD.list();
	}

	
}