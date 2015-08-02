package lk.ucsc.groupa.srichannel.data;

import java.util.List;

import lk.ucsc.groupa.srichannel.model.Patient;

/**
 * 
 * @author lruhunage
 *
 */
public interface PatientDao {
	
	public Patient findById(Long id);

    public Patient findByEmail(String email);

    public void register(Patient patient);
    
    public List<Patient> findAllOrderedByName();

}
