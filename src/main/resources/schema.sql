CREATE TABLE FIGHTERS
(
    FIGHTER_ID      NUMBER primary key,
    FIRST_NAME      VARCHAR2(30) not null,
    LAST_NAME       VARCHAR2(30) not null,
    STAGE_NAME      VARCHAR2(30),
    HEIGHT_CM       VARCHAR2(30) not null,
    GENDER          VARCHAR2(30) not null,
    WINS            NUMBER,
    LOSSES          NUMBER,
    DRAWS           NUMBER,
    NO_CONTESTS     NUMBER,
    WINS_KO         NUMBER,
    WINS_DECISION   NUMBER,
    LOSSES_KO       NUMBER,
    LOSSES_DECISION NUMBER,
    COUNTRY_ORIGIN  VARCHAR2(30) not null,
    COUNTRY         VARCHAR2(30) not null,
    CITY            VARCHAR2(30) not null,
    CLUB            VARCHAR2(30) not null,
    FIGHT_ORG       VARCHAR2(30) not null,
    RANKING         VARCHAR2(30) not null,
    PRIMARY_WEIGHT  VARCHAR2(30) not null,
    BIRTH_DATE      DATE
);

CREATE TABLE FIGHT_HISTORY
(
    FIGHT_ID        NUMBER primary key,
    FIGHTER_ID      NUMBER,
    RESULT          VARCHAR2(30) not null,
    OPPONENT_ID     NUMBER,
    ROUND           NUMBER,
    KO_TIME         VARCHAR2(30),
    FIGHT_DAY       DATE,
    LOCATION        VARCHAR2(30) not null,
    ARENA           VARCHAR2(30) not null,
    WEIGHT          VARCHAR2(30) not null,
    ORGANISATION    VARCHAR2(30) not null,
    foreign key (FIGHTER_ID) references FIGHTERS(FIGHTER_ID)
);

CREATE TABLE NEXT_SCHEDULED_FIGHT
(
    FIGHTER_ID      NUMBER primary key,
    OPPONENT_ID     NUMBER,
    FIGHT_DAY       DATE,
    LOCATION        VARCHAR2(30) not null,
    ARENA           VARCHAR2(30) not null,
    WEIGHT          VARCHAR2(30) not null,
    ORGANISATION    VARCHAR2(30) not null,
    foreign key (FIGHTER_ID) references FIGHTERS(FIGHTER_ID)
);

CREATE TABLE FIGHT_ORGANISATIONS
(
    ID              NUMBER primary key,
    CITY            VARCHAR2(30) not null,
    ARENA           VARCHAR2(30) not null,
    COUNTRY         VARCHAR2(30) not null,
    ORG_NAME        VARCHAR2(30) not null
);
