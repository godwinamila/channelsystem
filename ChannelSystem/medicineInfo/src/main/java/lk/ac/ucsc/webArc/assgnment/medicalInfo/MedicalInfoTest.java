package lk.ac.ucsc.webArc.assgnment.medicalInfo;

import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.MedicalInfoFactory;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.MedicalInfoManager;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.beans.MedicalInfo;

import java.util.Date;

/**
 * Created by chamindah on 7/27/2015.
 */
public class MedicalInfoTest {
    public static void main(String[] args){
        try {
            MedicalInfoFactory channelInfoFactory = MedicalInfoFactory.getInstance();
            MedicalInfoManager channelInfoManager =channelInfoFactory.getMedicalInfoManager();
            MedicalInfo channelInfo=channelInfoManager.getEmptyMedicalInfo();
            //channelInfo.setMedicalInfoId("channel_1");
            channelInfo.setChannelId("cha_001");
            channelInfo.setCreateDate(new Date());
            channelInfo.setDoctorNumber("doc_00001");
            channelInfo.setDiagonasisInfo("Fever with cold");
            channelInfo.setPatientNumber("pat_000001");
            channelInfo.setPrescriptionInfo("paracetamol 500mg, Piriton 5mg, Amoxiline 250mg");
            channelInfoManager.addMedicalInfo(channelInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
