
INSERT INTO FIGHTER (FIGHTER_ID, FIRST_NAME, LAST_NAME, STAGE_NAME, HEIGHT_CM, TOTAL_FIGHTS, WINS, LOSSES, DRAWS,
                      COUNTRY_ORIGIN, COUNTRY_LIVING, CLUB, BIRTH_DATE, GENDER, FIGHTER_STATUS)
VALUES (8888, 'Smilla', 'Sundell', 'The Storm', 176, 80, 50, 0, 0,'Sweden', 'Thailand' , 'Fairtex',  DATE '2004-12-30', 'FEMALE','ACTIVE'),
       (8889, 'Sarel', 'De-jong', 'The Hunter', 174, 80, 40, 1, 1, 'Holland', 'Holland' , 'Team van der Giessen', DATE '2000-12-31', 'FEMALE', 'ACTIVE'),
       (8887, 'Josefine', 'Lindgren-Knutsson', 'Little Thunder', 168, 80, 40, 1, 1, 'Sweden', 'Sweden' , 'Allstar gym' , DATE '1997-12-31', 'FEMALE', 'INACTIVE'),
       (8890, 'Barbara', 'Aquilar', null, 172, 120, 60, 2, 1, 'Brazil', 'Thailand' , 'Phuket fight club', DATE '2001-12-31', 'FEMALE', 'ACTIVE');

INSERT INTO FIGHT_INFO(FIGHT_ID, FIGHTER_ID, RESULT, OPPONENT_ID, FIGHT_DAY, LOCATION, ARENA, WEIGHT, FIGHT_ORG)
VALUES (334, 8888, 'WIN', 33, DATE '2020-12-31', 'Koh Samui', 'SAMUI_INTERNATIONAL_STADIUM', 57, 'SAMUI INTERNATIONAL STADIUM'),
       (337, 8888, 'WIN', 99, DATE '2021-12-31', 'Bangkok', 'BANGKOK_ARENA', 57, 'SuperChamp'),
       (338, 8888, 'WIN', 2,  DATE '2022-06-22', 'Singapore', 'SINGI_STADIUM', 57, 'One Championship'),
       (335, 8889, 'WIN', 34, DATE '2022-12-31', 'Amsterdam', 'AMSTERDAM_STADIUM' ,60,  'Enfusion'),
       (336, 8890, 'WIN', 35, DATE '2022-12-31',  'Phuket', 'PHUKET_BOXING_STADIUM', 58,  'SuperChamp');

