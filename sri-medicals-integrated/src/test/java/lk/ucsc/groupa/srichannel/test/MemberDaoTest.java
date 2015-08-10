/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package lk.ucsc.groupa.srichannel.test;

import java.util.List;

import lk.ucsc.groupa.srichannel.data.StaffMemberDao;
import lk.ucsc.groupa.srichannel.model.StaffMember;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml",
                                   "classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class MemberDaoTest {
    @Autowired
    private StaffMemberDao staffMemberDao;

    @Test
    public void testFindById() {
        StaffMember staffMember = staffMemberDao.findById(0l);

        assertEquals("John Smith", staffMember.getName());
        assertEquals("john.smith@mailinator.com", staffMember.getEmail());
        assertEquals("2125551212", staffMember.getPhoneNumber());
        return;
    }

    @Test
    public void testFindByEmail() {
        StaffMember staffMember = staffMemberDao.findByEmail("john.smith@mailinator.com");

        assertEquals("John Smith", staffMember.getName());
        assertEquals("john.smith@mailinator.com", staffMember.getEmail());
        assertEquals("2125551212", staffMember.getPhoneNumber());
        return;
    }

    @Test
    public void testRegister() {
        StaffMember staffMember = new StaffMember();
        staffMember.setEmail("jane.doe@mailinator.com");
        staffMember.setName("Jane Doe");
        staffMember.setPhoneNumber("2125552121");

        staffMemberDao.register(staffMember);
        Long id = staffMember.getId();
        assertNotNull(id);

        assertEquals(2, staffMemberDao.findAllOrderedByName().size());
        StaffMember newMember = staffMemberDao.findById(id);

        assertEquals("Jane Doe", newMember.getName());
        assertEquals("jane.doe@mailinator.com", newMember.getEmail());
        assertEquals("2125552121", newMember.getPhoneNumber());
        return;
    }

    @Test
    public void testFindAllOrderedByName() {
        StaffMember staffMember = new StaffMember();
        staffMember.setEmail("jane.doe@mailinator.com");
        staffMember.setName("Jane Doe");
        staffMember.setPhoneNumber("2125552121");
        staffMemberDao.register(staffMember);

        List<StaffMember> staffMembers = staffMemberDao.findAllOrderedByName();
        assertEquals(2, staffMembers.size());
        StaffMember newMember = staffMembers.get(0);

        assertEquals("Jane Doe", newMember.getName());
        assertEquals("jane.doe@mailinator.com", newMember.getEmail());
        assertEquals("2125552121", newMember.getPhoneNumber());
        return;
    }
}
