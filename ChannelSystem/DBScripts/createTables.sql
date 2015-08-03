-- Start of DDL Script for Table CHANNEL_SYSTEM.CHAINFO_MM_CHANNELINFO
-- Generated 3-Aug-2015 10:04:17 from CHANNEL_SYSTEM@XE

CREATE TABLE chainfo_mm_channelinfo
    (channelinfo_id                 VARCHAR2(20) NOT NULL,
    customer_number                VARCHAR2(50) NOT NULL,
    doctor_number                  VARCHAR2(20) NOT NULL,
    create_date                    TIMESTAMP (6),
    time_slot                      VARCHAR2(20),
    location                       VARCHAR2(20))
  PCTFREE     10
  INITRANS    1
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
  NOCACHE
  MONITORING
  NOPARALLEL
  LOGGING
/





-- Constraints for CHAINFO_MM_CHANNELINFO

ALTER TABLE chainfo_mm_channelinfo
ADD PRIMARY KEY (channelinfo_id)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/


-- End of DDL Script for Table CHANNEL_SYSTEM.CHAINFO_MM_CHANNELINFO

-- Start of DDL Script for Table CHANNEL_SYSTEM.CHAINFO_MM_MEDICALINFO
-- Generated 3-Aug-2015 10:04:17 from CHANNEL_SYSTEM@XE

CREATE TABLE chainfo_mm_medicalinfo
    (medicalinfo_id                 VARCHAR2(20) NOT NULL,
    customer_number                VARCHAR2(50) NOT NULL,
    doctor_number                  VARCHAR2(20) NOT NULL,
    create_date                    TIMESTAMP (6),
    time_slot                      VARCHAR2(500),
    location                       VARCHAR2(500))
  PCTFREE     10
  INITRANS    1
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
  NOCACHE
  MONITORING
  NOPARALLEL
  LOGGING
/





-- Constraints for CHAINFO_MM_MEDICALINFO

ALTER TABLE chainfo_mm_medicalinfo
ADD PRIMARY KEY (medicalinfo_id)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/


-- End of DDL Script for Table CHANNEL_SYSTEM.CHAINFO_MM_MEDICALINFO

-- Start of DDL Script for Table CHANNEL_SYSTEM.CUSMM_CUSTOMER
-- Generated 3-Aug-2015 10:04:17 from CHANNEL_SYSTEM@XE

CREATE TABLE cusmm_customer
    (customer_id                    NUMBER(19,0) NOT NULL,
    customer_number                VARCHAR2(50) NOT NULL,
    title                          VARCHAR2(20),
    first_name                     VARCHAR2(255),
    last_name                      VARCHAR2(255),
    gender                         VARCHAR2(10),
    office_tele                    VARCHAR2(20),
    mobile                         VARCHAR2(20),
    email                          VARCHAR2(100),
    idn_number                     VARCHAR2(100),
    address                        VARCHAR2(500))
  PCTFREE     10
  INITRANS    1
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
  NOCACHE
  MONITORING
  NOPARALLEL
  LOGGING
/





-- Constraints for CUSMM_CUSTOMER

ALTER TABLE cusmm_customer
ADD PRIMARY KEY (customer_id)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/

ALTER TABLE cusmm_customer
ADD UNIQUE (customer_number)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/


-- End of DDL Script for Table CHANNEL_SYSTEM.CUSMM_CUSTOMER

-- Start of DDL Script for Table CHANNEL_SYSTEM.CUSMM_LOGINPROFILE
-- Generated 3-Aug-2015 10:04:17 from CHANNEL_SYSTEM@XE

CREATE TABLE cusmm_loginprofile
    (customer_id                    NUMBER(19,0) NOT NULL,
    login_name                     VARCHAR2(150),
    password                       VARCHAR2(255),
    status                         NUMBER(10,0),
    failed_attempt                 NUMBER(10,0) DEFAULT 0,
    password_exp_date              TIMESTAMP (6),
    last_login_time                TIMESTAMP (6))
  PCTFREE     10
  INITRANS    1
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
  NOCACHE
  MONITORING
  NOPARALLEL
  LOGGING
/





-- Constraints for CUSMM_LOGINPROFILE

ALTER TABLE cusmm_loginprofile
ADD PRIMARY KEY (customer_id)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/

ALTER TABLE cusmm_loginprofile
ADD UNIQUE (login_name)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/


-- End of DDL Script for Table CHANNEL_SYSTEM.CUSMM_LOGINPROFILE

-- Start of DDL Script for Table CHANNEL_SYSTEM.DOCMM_DOCTOR
-- Generated 3-Aug-2015 10:04:17 from CHANNEL_SYSTEM@XE

CREATE TABLE docmm_doctor
    (doctor_id                      NUMBER(19,0) NOT NULL,
    doctor_number                  VARCHAR2(50) NOT NULL,
    title                          VARCHAR2(20),
    first_name                     VARCHAR2(255),
    last_name                      VARCHAR2(255),
    gender                         VARCHAR2(10),
    office_tele                    VARCHAR2(20),
    mobile                         VARCHAR2(20),
    email                          VARCHAR2(100),
    idn_number                     VARCHAR2(100),
    address                        VARCHAR2(500),
    speciality                     VARCHAR2(500))
  PCTFREE     10
  INITRANS    1
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
  NOCACHE
  MONITORING
  NOPARALLEL
  LOGGING
/





-- Constraints for DOCMM_DOCTOR

ALTER TABLE docmm_doctor
ADD PRIMARY KEY (doctor_id)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/

ALTER TABLE docmm_doctor
ADD UNIQUE (doctor_number)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/


-- End of DDL Script for Table CHANNEL_SYSTEM.DOCMM_DOCTOR

-- Start of DDL Script for Table CHANNEL_SYSTEM.DOCMM_LOGINPROFILE
-- Generated 3-Aug-2015 10:04:17 from CHANNEL_SYSTEM@XE

CREATE TABLE docmm_loginprofile
    (doctor_id                      NUMBER(19,0) NOT NULL,
    login_name                     VARCHAR2(150),
    password                       VARCHAR2(255),
    status                         VARCHAR2(10),
    failed_attempt                 NUMBER(10,0) DEFAULT 0,
    password_exp_date              TIMESTAMP (6),
    last_login_time                TIMESTAMP (6))
  PCTFREE     10
  INITRANS    1
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
  NOCACHE
  MONITORING
  NOPARALLEL
  LOGGING
/





-- Constraints for DOCMM_LOGINPROFILE

ALTER TABLE docmm_loginprofile
ADD PRIMARY KEY (doctor_id)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/

ALTER TABLE docmm_loginprofile
ADD UNIQUE (login_name)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/


-- End of DDL Script for Table CHANNEL_SYSTEM.DOCMM_LOGINPROFILE

-- Start of DDL Script for Table CHANNEL_SYSTEM.MEDINFO_MM_MEDICALINFO
-- Generated 3-Aug-2015 10:04:17 from CHANNEL_SYSTEM@XE

CREATE TABLE medinfo_mm_medicalinfo
    (medicalinfo_id                 VARCHAR2(20) NOT NULL,
    customer_number                VARCHAR2(50) NOT NULL,
    doctor_number                  VARCHAR2(20) NOT NULL,
    create_date                    TIMESTAMP (6),
    time_slot                      VARCHAR2(500),
    location                       VARCHAR2(500))
  PCTFREE     10
  INITRANS    1
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
  NOCACHE
  MONITORING
  NOPARALLEL
  LOGGING
/





-- Constraints for MEDINFO_MM_MEDICALINFO

ALTER TABLE medinfo_mm_medicalinfo
ADD PRIMARY KEY (medicalinfo_id)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/


-- End of DDL Script for Table CHANNEL_SYSTEM.MEDINFO_MM_MEDICALINFO

-- Start of DDL Script for Table CHANNEL_SYSTEM.USERMM_LOGINPROFILE
-- Generated 3-Aug-2015 10:04:18 from CHANNEL_SYSTEM@XE

CREATE TABLE usermm_loginprofile
    (user_id                        NUMBER(19,0) NOT NULL,
    login_name                     VARCHAR2(150),
    password                       VARCHAR2(255),
    status                         NUMBER(10,0),
    failed_attempt                 NUMBER(10,0) DEFAULT 0,
    password_exp_date              TIMESTAMP (6),
    last_login_time                TIMESTAMP (6))
  PCTFREE     10
  INITRANS    1
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
  NOCACHE
  MONITORING
  NOPARALLEL
  LOGGING
/





-- Constraints for USERMM_LOGINPROFILE

ALTER TABLE usermm_loginprofile
ADD PRIMARY KEY (user_id)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/

ALTER TABLE usermm_loginprofile
ADD UNIQUE (login_name)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/


-- End of DDL Script for Table CHANNEL_SYSTEM.USERMM_LOGINPROFILE

-- Start of DDL Script for Table CHANNEL_SYSTEM.USERMM_USER
-- Generated 3-Aug-2015 10:04:18 from CHANNEL_SYSTEM@XE

CREATE TABLE usermm_user
    (user_id                        NUMBER(19,0) NOT NULL,
    user_number                    VARCHAR2(50) NOT NULL,
    user_type                      NUMBER(10,0) NOT NULL,
    title                          VARCHAR2(20),
    first_name                     VARCHAR2(255),
    last_name                      VARCHAR2(255),
    gender                         VARCHAR2(10),
    office_tele                    VARCHAR2(20),
    mobile                         VARCHAR2(20),
    email                          VARCHAR2(100),
    idn_number                     VARCHAR2(100),
    address                        VARCHAR2(500))
  PCTFREE     10
  INITRANS    1
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
  NOCACHE
  MONITORING
  NOPARALLEL
  LOGGING
/





-- Constraints for USERMM_USER

ALTER TABLE usermm_user
ADD PRIMARY KEY (user_id)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/

ALTER TABLE usermm_user
ADD UNIQUE (user_number)
USING INDEX
  PCTFREE     10
  INITRANS    2
  MAXTRANS    255
  TABLESPACE  tbs_perm_01
  STORAGE   (
    INITIAL     65536
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
/


-- End of DDL Script for Table CHANNEL_SYSTEM.USERMM_USER

