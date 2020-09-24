package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import pe.edu.upc.daointerface.IVaccineDao;
import pe.edu.upc.entity.Vaccine;

public class VaccineDaoImpl implements Serializable, IVaccineDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "demo02")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Vaccine vac) {
		try {
			em.persist(vac);
		} catch (Exception e) {
			System.out.println("Error al insertar vacuna");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vaccine> list() {
		List<Vaccine> lista = new ArrayList<Vaccine>();
		try {
			Query q = em.createQuery("from Vaccine v");
			lista = (List<Vaccine>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar vacuna");
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vaccine> findByNameVaccine(Vaccine vac) {
		List<Vaccine> lista = new ArrayList<Vaccine>();
		try {
			Query q = em.createQuery("from Vaccine v where v.nameVaccine like ?1");
			q.setParameter(1,"%"+ vac.getNameVaccine()+"%");
			lista = (List<Vaccine>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar vacuna");
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void delete(int idVaccine) {
		Vaccine v = new Vaccine();
		try {
			v = em.getReference(Vaccine.class,  idVaccine);
			em.remove(v);
		} catch (Exception e) {
			System.out.println("Error al eliminar vacuna");
		}
	}
	
	@Transactional
	@Override
	public void update(Vaccine vac) {
		try {
			em.merge(vac);
		} catch (Exception e) {
			System.out.println("Error al editar vacuna");
		}
	}

	

}