
INSERT INTO FIGHTERS (FIGHTER_ID, FIRST_NAME, LAST_NAME, STAGE_NAME, HEIGHT_CM, WINS, LOSSES, DRAWS, NO_CONTESTS, WINS_KO, WINS_DECISION, LOSSES_KO, LOSSES_DECISION,
                      COUNTRY, COUNTRY_ORIGIN, CITY, CLUB, FIGHT_ORG, RANKING, PRIMARY_WEIGHT, BIRTH_DATE, GENDER)
VALUES (8888, 'Smilla', 'Sundell', 'The Storm', 176, 50, null, null, null, 30, 20, null, null, 'Sweden', 'Thailand' ,'Pattaya', 'Fairtex' ,'One Championship', 'Champ', '59', DATE '2022-12-31', 'F'),
       (8889, 'Sarel', 'De-jong', 'The Hunter', 174, 40, 1, 1, null, 22, 18, null, 1, 'Holland', 'Holland' ,'Groningen', 'Team van der Giessen' ,'Enfusion', 'Champ', '59', DATE '2022-12-31', 'F'),
       (8890, 'Barbara', 'Aquilera', null, 172, 60, 2, 1, null, 23, 37, null, 2, 'Brazil', 'Thailand' ,'Phuket', 'Phuket fight club', 'SuperChamp', '3', '59', DATE '2022-12-31', 'F');

INSERT INTO FIGHT_HISTORY(FIGHT_ID, FIGHTER_ID, RESULT, OPPONENT_ID, ROUND, KO_TIME, FIGHT_DAY, LOCATION, ARENA, WEIGHT, ORGANISATION)
VALUES (334, 8888, 'WIN', 33, 4, '1,55', DATE '2022-12-31', 'Bangkok', 'ARENA', 57, 'One Championship'),
       (335, 8889, 'WIN', 34, 5, null, DATE '2022-12-31', 'Amsterdam', 'ARENA' ,60,  'Enfusion'),
       (336, 8890, 'WIN', 35, 2, '1,55', DATE '2022-12-31',  'Phuket', 'ARENA', 58,  'SuperChamp');

INSERT INTO NEXT_SCHEDULED_FIGHT(FIGHTER_ID, OPPONENT_ID, FIGHT_DAY, LOCATION, ARENA, WEIGHT, ORGANISATION)
VALUES (8888, 29, DATE '2022-12-31', 'Bangkok', 'ARENA', 57, 'One Championship'),
       (8889, 30, DATE '2022-12-31', 'Amsterdam', 'ARENA', 60,  'Enfusion'),
       (8890, 48,  DATE '2022-12-31', 'Phuket', 'ARENA', 58,  'SuperChamp');

INSERT INTO FIGHT_ORGANISATIONS(ID, CITY, ARENA, COUNTRY, ORG_NAME)
VALUES (8888,  'VARIOUS', 'VARIOUS', 'Singapore', 'One_Championship'),
       (8889, 'Bangkok', 'Omnoi Stadium', 'Thailand',  'Omnoi'),
       (8881, 'Bangkok', 'Lumpinee Stadium', 'Thailand',  'Lumpinee'),
       (8882, 'Bangkok', 'Rajadamnern Stadium', 'Thailand',  'Rajadamnern'),
       (8890, 'Phuket', 'Patong Boxing Stadium', 58,  'SuperChamp');