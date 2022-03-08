INSERT INTO poll(poll_name, description, email, create_date, timer, start_date, link, status, is_public) VALUES ('Zdrowe odżywianie','Ankieta o zdrowym trybie życia.', 'student1@gmail.com',now(), 1, now(), 'www.ankiety.pl/poll1/ankieta-zdrowy-styl-zycia', 'DRAFT', FALSE);

INSERT INTO question(poll_id, question_content) VALUES (1,'Ile posiłków jesz dziennie?');

INSERT INTO possible_answers(question_id, possible_answers_content) VALUES (2,'powyżej 5'), (2,'3 posiłki'), (2,'poniżej 3');

INSERT INTO question(poll_id, question_content) VALUES (1,'Które posiłki jesz zazwyczaj?');

INSERT INTO possible_answers(question_id, possible_answers_content) VALUES (6,'śniadanie'), (6,'obiad'), (6,'kolacje');

INSERT INTO user_answers(possible_answers_id, question_id, user_answers_content)
VALUES (4,2,'3 posiłki'),  (8,6,' zazwyczaj tylko obiad');