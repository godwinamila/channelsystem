package org.ucsc.channel.doctor.service;

import java.util.List;

import org.ucsc.channel.doctor.model.DoctorDO;
import org.ucsc.channel.doctor.util.SampleDataUtil;

public class DoctorService{
	
	public List<DoctorDO> getAllDocotors(){
		return SampleDataUtil.getSampleDoctors();
	}

}