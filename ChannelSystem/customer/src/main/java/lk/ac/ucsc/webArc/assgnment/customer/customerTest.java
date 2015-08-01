package lk.ac.ucsc.webArc.assgnment.customer;

import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerFactory;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerManager;
import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.Customer;
import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.LoginProfile;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by chamindah on 7/27/2015.
 */
public class customerTest {

    public static  void main(String [] args){
        try {
            CustomerFactory customerFactory = CustomerFactory.getInstance();
            CustomerManager customerManager =customerFactory.getCustomerManager();
            Customer customer =customerManager.getEmptyCustomer("Cus_00001");
            customer.setAddress("634/38, Govinna Road, Athurugiriya");
            customer.setCustomerId(1);
            customer.setEmail("chamhetti@gmail.com");
            customer.setFirstName("Chaminda");
            customer.setGender("M");
            customer.setIdCardNumber("79163686v");
            customer.setLastName("Hettigoda");
            customer.setMobile("0722308043");
            customer.setOfficeTele("011234563");
            customer.setTitle("Mr.");
            LoginProfile loginProfile =customerManager.getEmptyLoginProfile();
            loginProfile.setCustomerId(customer.getCustomerId());
            loginProfile.setFailedAttemptCount(0);
            loginProfile.setLoginName(customer.getEmail());
            loginProfile.setPassword("123");
            loginProfile.setPasswordExpDate(new Date());
            loginProfile.setSmsPinNumber("");
            loginProfile.setStatus(1);
            customer.setLoginProfile(loginProfile);
            customerManager.addCustomer(customer);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
