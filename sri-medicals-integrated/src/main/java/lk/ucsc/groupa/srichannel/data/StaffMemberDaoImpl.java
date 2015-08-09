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
package lk.ucsc.groupa.srichannel.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import lk.ucsc.groupa.srichannel.model.StaffMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StaffMemberDaoImpl implements StaffMemberDao {
    @Autowired
    private EntityManager em;

    public StaffMember findById(Long id) {
        return em.find(StaffMember.class, id);
    }

    public StaffMember findByEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<StaffMember> criteria = cb.createQuery(StaffMember.class);
        Root<StaffMember> staffMember = criteria.from(StaffMember.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(staffMember).where(cb.equal(staffMember.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<StaffMember> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<StaffMember> criteria = cb.createQuery(StaffMember.class);
        Root<StaffMember> staffMember = criteria.from(StaffMember.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(staffMember).orderBy(cb.asc(staffMember.get("name")));
        return em.createQuery(criteria).getResultList();
    }

    public void register(StaffMember staffMember) {
        em.persist(staffMember);
        return;
    }
}
