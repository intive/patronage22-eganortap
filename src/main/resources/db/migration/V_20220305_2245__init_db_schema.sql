CREATE SEQUENCE IF NOT EXISTS my_seq;
CREATE TABLE IF NOT EXISTS poll (
	poll_id INT DEFAULT NEXTVAL('my_seq'),
	poll_name VARCHAR(25) NOT NULL,
	description VARCHAR(250) NOT NULL,
	email VARCHAR(100) NOT NULL,
	create_date TIMESTAMP,
	timer INT,
	start_date TIMESTAMP,
	link VARCHAR(200),
	status VARCHAR(25),
	is_public BOOLEAN DEFAULT FALSE,
 	PRIMARY KEY (poll_id)
);
CREATE TABLE IF NOT EXISTS question (
	question_id INT DEFAULT NEXTVAL('my_seq'),
	poll_id INT NOT NULL,
	question_content VARCHAR(200) NOT NULL,
	PRIMARY KEY (question_id),
	CONSTRAINT fk_poll_id FOREIGN KEY (poll_id) REFERENCES poll(poll_id)
);
CREATE TABLE IF NOT EXISTS possible_answers (
	possible_answers_id INT DEFAULT NEXTVAL('my_seq'),
	question_id INT NOT NULL,
	possible_answers_content VARCHAR(200) NOT NULL,
	PRIMARY KEY (possible_answers_id),
	CONSTRAINT fk_question_id FOREIGN KEY (question_id) REFERENCES question(question_id)
);
CREATE TABLE IF NOT EXISTS user_answers (
	user_answers_id INT DEFAULT NEXTVAL('my_seq'),
	possible_answers_id INT NOT NULL,
	question_id INT NOT NULL,
	user_answers_content VARCHAR(200) NOT NULL,
	PRIMARY KEY (user_answers_id),
	CONSTRAINT fk_question_id FOREIGN KEY (question_id) REFERENCES question(question_id),
    CONSTRAINT fk_possible_answers_id FOREIGN KEY (possible_answers_id) REFERENCES possible_answers(possible_answers_id)
);
