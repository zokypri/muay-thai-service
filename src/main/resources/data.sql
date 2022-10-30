
INSERT INTO FIGHTERS (FIGHTER_ID, FIRST_NAME, LAST_NAME, STAGE_NAME, HEIGHT_CM, TOTAL_FIGHTS, WINS, LOSSES, DRAWS, NO_CONTESTS, WINS_KO, WINS_DECISION, LOSSES_KO, LOSSES_DECISION,
                      COUNTRY_ORIGIN, COUNTRY_LIVING, CITY, CLUB, FIGHT_ORG, RANKING, PRIMARY_WEIGHT, BIRTH_DATE, GENDER, FIGHTER_STATUS)
VALUES (8888, 'Smilla', 'Sundell', 'The Storm', 176, 80, 50, 0, 0, 0, 30, 20, 0, 0, 'Sweden', 'Thailand' ,'Pattaya', 'Fairtex' ,'One Championship', 'Champ', '59', DATE '2004-10-30', 'FEMALE','ACTIVE'),
       (8889, 'Sarel', 'De-jong', 'The Hunter', 174, 80, 40, 1, 1, 0, 22, 18, 0, 1, 'Holland', 'Holland' ,'Groningen', 'Team van der Giessen' ,'Enfusion', 'Champ', '59', DATE '2022-12-31', 'FEMALE', 'ACTIVE'),
       (8887, 'Josefine', 'Lindgren-Knutsson', 'Little Thunder', 168, 80, 40, 1, 1, 0, 22, 18, 0, 1, 'Sweden', 'Sweden' ,'Stockholm', 'Allstar gym' , 'NONE', 'NONE', '55', DATE '1997-12-31', 'FEMALE', 'INACTIVE'),
       (8890, 'Barbara', 'Aquilar', null, 172, 120, 60, 2, 1, 0, 23, 37, 0, 2, 'Brazil', 'Thailand' ,'Phuket', 'Phuket fight club', 'SuperChamp', '3', '59', DATE '2022-12-31', 'FEMALE', 'ACTIVE');

INSERT INTO FIGHT_HISTORY(FIGHT_ID, FIGHTER_ID, RESULT, OPPONENT_ID, ROUND, KO_TIME, FIGHT_DAY, LOCATION, ARENA, WEIGHT, FIGHT_ORG)
VALUES (334, 8888, 'WIN', 33, 4, '1,55', DATE '2022-12-31', 'Bangkok', 'ARENA', 57, 'One Championship'),
       (335, 8889, 'WIN', 34, 5, null, DATE '2022-12-31', 'Amsterdam', 'ARENA' ,60,  'Enfusion'),
       (336, 8890, 'WIN', 35, 2, '1,55', DATE '2022-12-31',  'Phuket', 'ARENA', 58,  'SuperChamp');

INSERT INTO NEXT_SCHEDULED_FIGHT(FIGHTER_ID, OPPONENT_ID, FIGHT_DAY, LOCATION, ARENA, WEIGHT, FIGHT_ORG)
VALUES (8888, 29, DATE '2022-12-31', 'Bangkok', 'ARENA', 57, 'One Championship'),
       (8889, 30, DATE '2022-12-31', 'Amsterdam', 'ARENA', 60,  'Enfusion'),
       (8890, 48,  DATE '2022-12-31', 'Phuket', 'ARENA', 58,  'SuperChamp');

INSERT INTO FIGHT_ORGANISATIONS(ID, CITY, ARENA, COUNTRY, ORG_NAME)
VALUES (8888,  'VARIOUS', 'VARIOUS', 'Singapore', 'One_Championship'),
       (8889, 'Bangkok', 'Omnoi Stadium', 'Thailand',  'Omnoi'),
       (8881, 'Bangkok', 'Lumpinee Stadium', 'Thailand',  'Lumpinee'),
       (8882, 'Bangkok', 'Rajadamnern Stadium', 'Thailand',  'Rajadamnern'),
       (8890, 'Phuket', 'Patong Boxing Stadium', 58,  'SuperChamp');
