INSERT INTO poll(name, description, email, create_date, timer, start_date, link, status, is_public)
VALUES ('Zdrowe odżywianie','Ankieta o zdrowym trybie życia.', 'student1@gmail.com',now(), 1, now(), 'www.ankiety.pl/poll1/ankieta-zdrowy-styl-zycia', 'DRAFT', FALSE);

INSERT INTO question(poll_id, question_content)
VALUES ((SELECT id FROM public.poll WHERE name = 'Zdrowe odżywianie'), 'Ile posiłków jesz dziennie?');

INSERT INTO possible_answers(question_id, possible_answers_content)
VALUES((SELECT  id FROM public.question WHERE question_content = 'Ile posiłków jesz dziennie?'), 'powyżej 5'),
      ((SELECT id FROM public.question WHERE question_content = 'Ile posiłków jesz dziennie?'), '3 posiłki'),
      ((SELECT id FROM public.question WHERE question_content = 'Ile posiłków jesz dziennie?'), 'poniżej 3');

INSERT INTO question(poll_id, question_content)
VALUES ((SELECT id FROM public.poll WHERE name = 'Zdrowe odżywianie'),'Które posiłki jesz zazwyczaj?');

INSERT INTO possible_answers(question_id, possible_answers_content)
VALUES((SELECT  id FROM public.question WHERE question_content = 'Które posiłki jesz zazwyczaj?'),'śniadanie'),
      ((SELECT  id FROM public.question WHERE question_content = 'Które posiłki jesz zazwyczaj?'),'obiad'),
      ((SELECT  id FROM public.question WHERE question_content = 'Które posiłki jesz zazwyczaj?'),'kolacje');

INSERT INTO user_answers(possible_answers_id, question_id, user_answers_content)
VALUES ((SELECT  id FROM public.possible_answers WHERE possible_answers_content = '3 posiłki'),(SELECT  id FROM public.question WHERE question_content = 'Ile posiłków jesz dziennie?'),'3 posiłki'),
       ((SELECT  id FROM public.possible_answers WHERE possible_answers_content = 'obiad'),(SELECT  id FROM public.question WHERE question_content = 'Które posiłki jesz zazwyczaj?'),' zazwyczaj tylko obiad');