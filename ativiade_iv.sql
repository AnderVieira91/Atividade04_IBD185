CREATE DATABASE ATIVIDADE_IV;
USE ATIVIDADE_IV;

CREATE TABLE COM_COMPUTADOR(
	COM_ID				INT(13) 	NOT NULL,
	COM_MARCA			VARCHAR(30) NOT NULL,
	COM_PROCESSADOR		VARCHAR(30) NOT NULL,
	COM_MEMORIA			VARCHAR(30) NOT NULL,
	COM_ARMAZENAMENTO	VARCHAR(30) NOT NULL,
	CONSTRAINT COM_PK PRIMARY KEY (COM_ID)
	);