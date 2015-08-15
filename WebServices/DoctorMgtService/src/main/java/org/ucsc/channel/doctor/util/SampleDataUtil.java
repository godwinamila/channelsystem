package org.ucsc.channel.doctor.util;

import java.util.ArrayList;
import java.util.List;

import org.ucsc.channel.doctor.model.DoctorDO;

public class SampleDataUtil {

	public static List<DoctorDO> getSampleDoctors(){
		
		List<DoctorDO> doctorList = new ArrayList<DoctorDO>();
		DoctorDO doc1 = new DoctorDO();
		doc1.setAddress("Colombo 05");
		doc1.setEmail("ananda@gmail.com");
		doc1.setFirstName("Ananda");
		doc1.setGender("Male");
		doc1.setIdn("IDN0001");
		doc1.setLastName("Perera");
		doc1.setMobile("+94772617271");
		doc1.setNumber("N0009012");
		doc1.setOffTelephone("+9411289786");
		doc1.setSpeciality("Orthopedic Surgeon");
		doc1.setTitle("Mr");
		
		DoctorDO doc2 = new DoctorDO();
		doc2.setAddress("Colombo 05");
		doc2.setEmail("hemantha@gmail.com");
		doc2.setFirstName("Hemantha");
		doc2.setGender("Male");
		doc2.setIdn("IDN0002");
		doc2.setLastName("Perera");
		doc2.setMobile("+94772127271");
		doc2.setNumber("N0009013");
		doc2.setOffTelephone("+94112892136");
		doc2.setSpeciality("Obstetric and Gynecology");
		doc2.setTitle("Mr");
		
		DoctorDO doc3 = new DoctorDO();
		doc3.setAddress("Maharagama");
		doc3.setEmail("balawardana@gmail.com");
		doc3.setFirstName("Jayantha");
		doc3.setGender("Male");
		doc3.setIdn("IDN0003");
		doc3.setLastName("Balawardhana");
		doc3.setMobile("+947726172121");
		doc3.setNumber("N0009013");
		doc3.setOffTelephone("+9411252786");
		doc3.setSpeciality("Oncologist");
		doc3.setTitle("Mr");
				
		doctorList.add(doc1);
		doctorList.add(doc2);
		doctorList.add(doc3);
		
		return doctorList;
	}
}
