CREATE SEQUENCE IF NOT EXISTS my_seq;
CREATE TABLE IF NOT EXISTS poll (
	id INT PRIMARY KEY DEFAULT NEXTVAL('my_seq'),
	name VARCHAR(25) NOT NULL,
	description VARCHAR(50) NOT NULL,
	email VARCHAR(320) NOT NULL,
	create_date DATE DEFAULT CURRENT_DATE,
	timer SMALLINT,
	start_date TIMESTAMP,
	link VARCHAR(255),
	status VARCHAR(25),
	is_public BOOLEAN DEFAULT TRUE
);
CREATE TABLE IF NOT EXISTS question (
	id INT PRIMARY KEY DEFAULT NEXTVAL('my_seq'),
	poll_id INT NOT NULL,
	question_content VARCHAR(255) NOT NULL,
	CONSTRAINT fk_question_poll_id FOREIGN KEY (poll_id) REFERENCES poll(id)
);
CREATE TABLE IF NOT EXISTS possible_answers (
	id INT PRIMARY KEY DEFAULT NEXTVAL('my_seq'),
	question_id INT NOT NULL,
	possible_answers_content VARCHAR(255) NOT NULL,
	CONSTRAINT fk_possible_answers_question_id FOREIGN KEY (question_id) REFERENCES question(id)
);
CREATE TABLE IF NOT EXISTS user_answers (
	id INT PRIMARY KEY DEFAULT NEXTVAL('my_seq'),
	possible_answers_id INT NOT NULL,
	question_id INT NOT NULL,
	user_answers_content VARCHAR(255) NOT NULL,
	CONSTRAINT fk_user_answers_question_id FOREIGN KEY (question_id) REFERENCES question(id),
    CONSTRAINT fk_user_answer_possible_answers_id FOREIGN KEY (possible_answers_id) REFERENCES possible_answers(id)
);