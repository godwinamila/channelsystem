package lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.facade;


import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.MedicalInfoManager;


import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.beans.MedicalInfo;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.exceptions.MedicalInfoException;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.beans.MedicalInfoBean;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.persistantImpl.MedicalInfoPersister;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * CustomerManagerFacade class implements all the services defined in the CustomerManager interface.
 * This class has a reference to the CustomerCacheFacade class that provides all the cache and physical storage related operations.
 * All the operations are done through CustomerCacheFacade.
 * <p/>
 * User: Hetti

 * Time: 2:34 PM
 */
public class MedicalInfoManagerFacade implements MedicalInfoManager {
    private static Logger logger = LoggerFactory.getLogger(MedicalInfoManagerFacade.class);


    private MedicalInfoPersister medicalInfoPersister;


    public MedicalInfoPersister getMedicalInfoPersister() {
        return medicalInfoPersister;
    }

    public void setMedicalInfoPersister(MedicalInfoPersister medicalInfoPersister) {
        this.medicalInfoPersister = medicalInfoPersister;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int addMedicalInfo(MedicalInfo medicalInfo) throws MedicalInfoException {
        logger.info("Adding the medicalInfo -{} to cache", medicalInfo);
        if (medicalInfo == null) {
            throw new MedicalInfoException("medicalInfo can't be null");
        }


        medicalInfoPersister.insert((MedicalInfoBean) medicalInfo);
        logger.debug("Adding medicalInfo process finished");
        return medicalInfo.getMedicalInfoId();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateMedicalInfo(MedicalInfo MedicalInfo) throws MedicalInfoException {
        logger.info("Update the MedicalInfo {}", MedicalInfo);
        if (MedicalInfo == null) {
            throw new MedicalInfoException("MedicalInfo can't be null");
        }

        medicalInfoPersister.update((MedicalInfoBean) MedicalInfo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void markMedicalInfoAsDeleted(String medicalInfoId) throws MedicalInfoException {
        logger.info("markMedicalInfoAsDeleted : MedicalInfoNumber : ", medicalInfoId);
        if (medicalInfoId == null || "".equalsIgnoreCase(medicalInfoId)) {
            throw new MedicalInfoException("MedicalInfo Number is Empty");
        }
        MedicalInfo medicalInfo =getMedicalInfo(medicalInfoId);
        medicalInfoPersister.deleteFromDB((MedicalInfoBean)medicalInfo);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MedicalInfo getMedicalInfo(String medicalInfoId) throws MedicalInfoException {
        logger.info("Getting the customer with customer number - {}", medicalInfoId);
        if (medicalInfoId == null || "".equalsIgnoreCase(medicalInfoId)) {
            throw new MedicalInfoException("Customer Number Can't be Null or Empty");
        }
        return medicalInfoPersister.load(medicalInfoId);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<MedicalInfo> getAllMedicalInfo() throws MedicalInfoException {
        logger.info("Getting All the channnelInfo");
        return medicalInfoPersister.loadAll();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public MedicalInfo getEmptyMedicalInfo() {
        return new MedicalInfoBean();
    }

    @Override
    public List<MedicalInfo> getMedicineInfoForCustomer(String customerNumber) throws MedicalInfoException {
        return medicalInfoPersister.getMedicineInfoForCustomer(customerNumber);
    }

    @Override
    public MedicalInfo getMedicalInfoForAppointment(String channelId) throws MedicalInfoException {
        return medicalInfoPersister.getMedicalInfoForAppointment(channelId);
    }

    @Override
    public List<MedicalInfo> getMedicineInfoForDoctor(String doctorNumber) throws MedicalInfoException {
        return medicalInfoPersister.getMedicineInfoForDoctor(doctorNumber);
    }
}
