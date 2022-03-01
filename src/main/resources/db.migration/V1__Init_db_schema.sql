CREATE TABLE IF NOT EXISTS poll (
	poll_id BIGINT GENERATED ALWAYS AS IDENTITY,
	poll_name VARCHAR(25) NOT NULL,
	description VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL,
	create_date DATE,
	timer INT,
	start_date DATE,
	link VARCHAR(200),
	status VARCHAR(25),
	is_public boolean DEFAULT true,
 	PRIMARY KEY (poll_id)
);


CREATE TABLE IF NOT EXISTS question (
	question_id BIGINT GENERATED ALWAYS AS IDENTITY,
	poll_id int NOT NULL,
	question_content VARCHAR(200) NOT NULL,
	PRIMARY KEY (question_id),
	CONSTRAINT fk_poll_id FOREIGN KEY (poll_id) REFERENCES poll(poll_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS possible_answers (
	possible_answers_id BIGINT GENERATED ALWAYS AS IDENTITY,
	question_id int NOT NULL,
	possible_answers_content VARCHAR(200) NOT NULL,
	PRIMARY KEY (possible_answers_id),
	CONSTRAINT fk_question_id FOREIGN KEY (question_id) REFERENCES question(question_id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS user_answers (
	user_answers_id BIGINT GENERATED ALWAYS AS IDENTITY,
	possible_answers_id int NOT NULL,
	question_id int NOT NULL,
	user_answers_content VARCHAR(200) NOT NULL,
	PRIMARY KEY (user_answers_id),
	CONSTRAINT fk_question_id FOREIGN KEY (question_id) REFERENCES question(question_id) ON DELETE CASCADE,
    CONSTRAINT fk_possible_answers_id FOREIGN KEY (possible_answers_id) REFERENCES possible_answers(possible_answers_id) ON DELETE CASCADE
);
CREATE IF NOT EXISTS SEQUENCE poll_id_seq OWNED BY poll.poll_id;
CREATE IF NOT EXISTS  SEQUENCE question_id_seq OWNED BY question.question_id;
CREATE IF NOT EXISTS SEQUENCE possible_answers_id_seq OWNED BY possible_answers.possible_answers_id;
CREATE IF NOT EXISTS SEQUENCE user_answers_id_seq OWNED BY user_answers.user_answers_id;
