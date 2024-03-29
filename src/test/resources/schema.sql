CREATE SEQUENCE FIGHTER_SEQ START WITH 1 INCREMENT BY 1;
CREATE TABLE FIGHTER
(
    FIGHTER_ID      NUMBER default FIGHTER_SEQ.nextval primary key not null,
    FIRST_NAME      VARCHAR2(30) not null,
    LAST_NAME       VARCHAR2(30) not null,
    STAGE_NAME      VARCHAR2(30),
    HEIGHT_CM       VARCHAR2(30) not null,
    GENDER          VARCHAR2(30) not null,
    TOTAL_FIGHTS    NUMBER  ,
    WINS            NUMBER  ,
    LOSSES          NUMBER  ,
    DRAWS           NUMBER  ,
    COUNTRY_ORIGIN  VARCHAR2(30) not null,
    COUNTRY_LIVING  VARCHAR2(30) not null,
    CLUB            VARCHAR2(30) not null,
    BIRTH_DATE      DATE,
    FIGHTER_STATUS  VARCHAR2(30) not null
);

CREATE SEQUENCE FIGHT_SEQ START WITH 1 INCREMENT BY 1;
CREATE TABLE FIGHT_INFO
(
    FIGHT_ID        NUMBER default FIGHT_SEQ.nextval primary key not null,
    FIGHTER_ID      NUMBER,
    OPPONENT_ID     NUMBER,
    RESULT          VARCHAR2(30) NOT NULL,
    FIGHT_DAY       DATE,
    LOCATION        VARCHAR2(30) not null,
    ARENA           VARCHAR2(30) not null,
    WEIGHT          VARCHAR2(30) not null,
    FIGHT_ORG       VARCHAR2(30) not null,
    foreign key (FIGHTER_ID) references FIGHTER(FIGHTER_ID)
);

CREATE TABLE FIGHT_ORGANISATIONS
(
    ORG_ID          NUMBER primary key,
    CITY            VARCHAR2(30) not null,
    ARENA           VARCHAR2(30) not null,
    COUNTRY         VARCHAR2(30) not null,
    ORG_NAME        VARCHAR2(30) not null
);
