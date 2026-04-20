<<<<<<< HEAD
CREATE TABLE pessoa (
  id INT PRIMARY KEY,
  nome VARCHAR(100),
  cpf VARCHAR(14) UNIQUE
);



CREATE TABLE hospital (
  id INT PRIMARY KEY,
  nome VARCHAR(100),
  cnpj VARCHAR(18) UNIQUE
);



CREATE TABLE plano (
  id INT PRIMARY KEY,
  nome VARCHAR(100) UNIQUE,
  telefone VARCHAR(20),
  cobertura VARCHAR(50),
  data_credenciamento DATE
);






CREATE TABLE hospital_plano (
  hospital_id INT,
  plano_id INT,
=======
CREATE DATABASE trabalho_poo;

CREATE TABLE pessoa (
  id INT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) UNIQUE NOT NULL
);

CREATE TABLE hospital (
  id INT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cnpj VARCHAR(18) UNIQUE NOT NULL
);

CREATE TABLE plano (
  id INT PRIMARY KEY,
  nome VARCHAR(100) UNIQUE NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  cobertura VARCHAR(50) NOT NULL,
  data_credenciamento DATE NOT NULL
);

CREATE TABLE hospital_plano (
  hospital_id INT NOT NULL,
  plano_id INT NOT NULL,
>>>>>>> 7df133600304c8c7ecd772fe876c23abe73345bd
  PRIMARY KEY (hospital_id, plano_id),
  FOREIGN KEY (hospital_id) REFERENCES hospital(id),
  FOREIGN KEY (plano_id) REFERENCES plano(id)
);

<<<<<<< HEAD







CREATE TABLE paciente (
  id INT PRIMARY KEY,
  pessoa_id INT UNIQUE,
  FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);





CREATE TABLE medico (
  id INT PRIMARY KEY,
  crm VARCHAR(20) UNIQUE,
  especialidade VARCHAR(100),
  pessoa_id INT UNIQUE,
  FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);






CREATE TABLE enfermeira (
  id INT PRIMARY KEY,
  cre VARCHAR(20) UNIQUE,
  turno VARCHAR(20),
  pessoa_id INT UNIQUE,
  chefe_id INT,
=======
CREATE TABLE paciente (
  id INT PRIMARY KEY,
  pessoa_id INT UNIQUE NOT NULL,
  FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);

CREATE TABLE medico (
  id INT PRIMARY KEY,
  crm VARCHAR(20) UNIQUE NOT NULL,
  especialidade VARCHAR(100) NOT NULL,
  pessoa_id INT UNIQUE NOT NULL,
  FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);

CREATE TABLE enfermeira (
  id INT PRIMARY KEY,
  cre VARCHAR(20) UNIQUE NOT NULL,
  turno VARCHAR(20) NOT NULL,
  pessoa_id INT UNIQUE NOT NULL,
  chefe_id INT,             
>>>>>>> 7df133600304c8c7ecd772fe876c23abe73345bd
  FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),
  FOREIGN KEY (chefe_id) REFERENCES enfermeira(id)
);

<<<<<<< HEAD




CREATE TABLE ala (
  id INT PRIMARY KEY,
  tipo VARCHAR(50),
  numero_leitos_disponiveis INT,
  hospital_id INT,
  enfermeira_id INT UNIQUE,
=======
CREATE TABLE ala (
  id INT PRIMARY KEY,
  tipo VARCHAR(50) NOT NULL,
  numero_leitos_disponiveis INT NOT NULL,
  hospital_id INT NOT NULL,
  enfermeira_id INT UNIQUE NOT NULL,
>>>>>>> 7df133600304c8c7ecd772fe876c23abe73345bd
  FOREIGN KEY (hospital_id) REFERENCES hospital(id),
  FOREIGN KEY (enfermeira_id) REFERENCES enfermeira(id)
);

<<<<<<< HEAD



CREATE TABLE leito (
  id INT PRIMARY KEY,
  identificador VARCHAR(50) UNIQUE,
  status VARCHAR(30),
  ala_id INT,
  FOREIGN KEY (ala_id) REFERENCES ala(id)
);









CREATE TABLE atendimento (
  id INT PRIMARY KEY,
  data_hora TIMESTAMP,
  tipo VARCHAR(30),
  status VARCHAR(30),
  observacoes TEXT,
  paciente_id INT,
  medico_id INT,
=======
CREATE TABLE leito (
  id INT PRIMARY KEY,
  identificador VARCHAR(50) UNIQUE NOT NULL,
  status VARCHAR(30) NOT NULL,
  ala_id INT NOT NULL,
  FOREIGN KEY (ala_id) REFERENCES ala(id)
);

CREATE TABLE atendimento (
  id INT PRIMARY KEY,
  data_hora TIMESTAMP NOT NULL,
  tipo VARCHAR(30) NOT NULL,
  status VARCHAR(30) NOT NULL,
  observacoes TEXT,        
  paciente_id INT NOT NULL,
  medico_id INT NOT NULL,
>>>>>>> 7df133600304c8c7ecd772fe876c23abe73345bd
  FOREIGN KEY (paciente_id) REFERENCES paciente(id),
  FOREIGN KEY (medico_id) REFERENCES medico(id)
);

<<<<<<< HEAD





CREATE TABLE medicamento (
  id INT PRIMARY KEY,
  nome VARCHAR(100)
);




CREATE TABLE prescricao (
  id INT PRIMARY KEY,
  data DATE,
  dosagem VARCHAR(50),
  atendimento_id INT,
  medicamento_id INT,
=======
CREATE TABLE medicamento (
  id INT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE prescricao (
  id INT PRIMARY KEY,
  data DATE NOT NULL,
  dosagem VARCHAR(50) NOT NULL,
  atendimento_id INT NOT NULL,
  medicamento_id INT NOT NULL,
>>>>>>> 7df133600304c8c7ecd772fe876c23abe73345bd
  FOREIGN KEY (atendimento_id) REFERENCES atendimento(id),
  FOREIGN KEY (medicamento_id) REFERENCES medicamento(id)
);

<<<<<<< HEAD


CREATE TABLE laboratorio (
  id INT PRIMARY KEY,
  nome VARCHAR(100),
  tipo VARCHAR(30)
);






CREATE TABLE exame (
  id INT PRIMARY KEY,
  tipo VARCHAR(50),
  custo DECIMAL(10,2),
  descricao TEXT,
  resultado VARCHAR(30),
  data_solicitacao TIMESTAMP,
  data_resultado TIMESTAMP,
  arquivo_laudo VARCHAR(255),
  paciente_id INT,
  medico_id INT,
  laboratorio_id INT,
=======
CREATE TABLE laboratorio (
  id INT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  tipo VARCHAR(30) NOT NULL
);

CREATE TABLE exame (
  id INT PRIMARY KEY,
  tipo VARCHAR(50) NOT NULL,
  custo DECIMAL(10,2) NOT NULL,
  descricao TEXT,          
  resultado VARCHAR(30),     
  data_solicitacao TIMESTAMP NOT NULL,
  data_resultado TIMESTAMP, 
  arquivo_laudo VARCHAR(255),
  paciente_id INT NOT NULL,
  medico_id INT NOT NULL,
  laboratorio_id INT NOT NULL,
>>>>>>> 7df133600304c8c7ecd772fe876c23abe73345bd
  FOREIGN KEY (paciente_id) REFERENCES paciente(id),
  FOREIGN KEY (medico_id) REFERENCES medico(id),
  FOREIGN KEY (laboratorio_id) REFERENCES laboratorio(id)
);

<<<<<<< HEAD




CREATE TABLE internacao (
  id INT PRIMARY KEY,
  data_entrada DATE,
  data_saida DATE,
  paciente_id INT,
  leito_id INT,
=======
CREATE TABLE internacao (
  id INT PRIMARY KEY,
  data_entrada DATE NOT NULL,
  data_saida DATE,          
  paciente_id INT NOT NULL,
  leito_id INT NOT NULL,
>>>>>>> 7df133600304c8c7ecd772fe876c23abe73345bd
  FOREIGN KEY (paciente_id) REFERENCES paciente(id),
  FOREIGN KEY (leito_id) REFERENCES leito(id)
);

CREATE TABLE fatura (
  id INT PRIMARY KEY,
<<<<<<< HEAD
  numero VARCHAR(50) UNIQUE,
  valor DECIMAL(10,2),
  data_emissao DATE,
  data_vencimento DATE,
  status VARCHAR(30),
  forma_pagamento VARCHAR(30),
  paciente_id INT,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);
=======
  numero VARCHAR(50) UNIQUE NOT NULL,
  valor DECIMAL(10,2) NOT NULL CHECK (valor >= 0),
  data_emissao DATE NOT NULL,
  data_vencimento DATE NOT NULL,
  status VARCHAR(30) NOT NULL,
  forma_pagamento VARCHAR(30),
  paciente_id INT NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

>>>>>>> 7df133600304c8c7ecd772fe876c23abe73345bd
CREATE TABLE nota_fiscal (
  id INT PRIMARY KEY,
  nome_emissor VARCHAR(100) NOT NULL,
  nome_paciente VARCHAR(100) NOT NULL,
<<<<<<< HEAD
  descricao TEXT,
=======
  descricao TEXT,          
>>>>>>> 7df133600304c8c7ecd772fe876c23abe73345bd
  valor_bruto DECIMAL(10,2) NOT NULL,
  iss DECIMAL(10,2) NOT NULL,
  pis DECIMAL(10,2) NOT NULL,
  cofins DECIMAL(10,2) NOT NULL,
  irpj DECIMAL(10,2) NOT NULL,
  csll DECIMAL(10,2) NOT NULL,
  fatura_id INT UNIQUE NOT NULL,
  FOREIGN KEY (fatura_id) REFERENCES fatura(id)
<<<<<<< HEAD
);
=======
);
\\comentario
>>>>>>> 7df133600304c8c7ecd772fe876c23abe73345bd
