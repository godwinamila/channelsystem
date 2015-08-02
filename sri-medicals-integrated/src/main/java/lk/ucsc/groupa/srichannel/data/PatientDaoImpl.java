package lk.ucsc.groupa.srichannel.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import lk.ucsc.groupa.srichannel.model.Patient;

@Repository
@Transactional
public class PatientDaoImpl implements PatientDao {

	@Autowired
	private EntityManager em;

	@Override
	public Patient findById(Long id) {
		return em.find(Patient.class, id);
	}

	@Override
	public Patient findByEmail(String email) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Patient> criteria = cb.createQuery(Patient.class);
		Root<Patient> patient = criteria.from(Patient.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		 */

		criteria.select(patient).where(cb.equal(patient.get("email"), email));
		return em.createQuery(criteria).getSingleResult();

	}

	@Override
	public void register(Patient patient) {
		em.persist(patient);
		return;

	}

	@Override
	public List<Patient> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Patient> criteria = cb.createQuery(Patient.class);
		Root<Patient> patient = criteria.from(Patient.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		 */

		criteria.select(patient).orderBy(cb.asc(patient.get("firstName")));
		return em.createQuery(criteria).getResultList();

	}

}
