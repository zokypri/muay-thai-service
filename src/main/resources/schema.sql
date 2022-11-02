CREATE TABLE FIGHTERS
(
    FIGHTER_ID      NUMBER primary key,
    FIRST_NAME      VARCHAR2(30) not null,
    LAST_NAME       VARCHAR2(30) not null,
    STAGE_NAME      VARCHAR2(30),
    HEIGHT_CM       VARCHAR2(30) not null,
    GENDER          VARCHAR2(30) not null,
    TOTAL_FIGHTS    NUMBER  ,
    WINS            NUMBER  ,
    LOSSES          NUMBER  ,
    DRAWS           NUMBER  ,
    NO_CONTESTS     NUMBER  ,
    WINS_KO         NUMBER  ,
    WINS_DECISION   NUMBER  ,
    LOSSES_KO       NUMBER  ,
    LOSSES_DECISION NUMBER  ,
    COUNTRY_ORIGIN  VARCHAR2(30) not null,
    COUNTRY_LIVING  VARCHAR2(30) not null,
    CITY            VARCHAR2(30) not null,
    CLUB            VARCHAR2(30) not null,
    FIGHT_ORG       VARCHAR2(30) not null,
    RANKING         VARCHAR2(30)  ,
    PRIMARY_WEIGHT  VARCHAR2(30) not null,
    BIRTH_DATE      DATE,
    FIGHTER_STATUS  VARCHAR2(30) not null
);

CREATE TABLE FIGHT_INFO
(
    FIGHT_ID        NUMBER primary key,
    FIGHTER_ID      NUMBER,
    OPPONENT_ID     NUMBER,
    FIGHT_NUMBER    NUMBER,
    RESULT          VARCHAR2(30),
    ROUND_KO        NUMBER,
    KO_TIME         VARCHAR2(30),
    FIGHT_DAY       DATE,
    LOCATION        VARCHAR2(30) not null,
    ARENA           VARCHAR2(30) not null,
    WEIGHT          VARCHAR2(30) not null,
    FIGHT_ORG       VARCHAR2(30) not null,
    foreign key (FIGHTER_ID) references FIGHTERS(FIGHTER_ID)
);

CREATE TABLE FIGHT_ORGANISATIONS
(
    ORG_ID          NUMBER primary key,
    CITY            VARCHAR2(30) not null,
    ARENA           VARCHAR2(30) not null,
    COUNTRY         VARCHAR2(30) not null,
    ORG_NAME        VARCHAR2(30) not null
);
