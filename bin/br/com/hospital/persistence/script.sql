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
  PRIMARY KEY (hospital_id, plano_id),
  FOREIGN KEY (hospital_id) REFERENCES hospital(id),
  FOREIGN KEY (plano_id) REFERENCES plano(id)
);

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
  FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),
  FOREIGN KEY (chefe_id) REFERENCES enfermeira(id)
);

CREATE TABLE ala (
  id INT PRIMARY KEY,
  tipo VARCHAR(50) NOT NULL,
  numero_leitos_disponiveis INT NOT NULL,
  hospital_id INT NOT NULL,
  enfermeira_id INT UNIQUE NOT NULL,
  FOREIGN KEY (hospital_id) REFERENCES hospital(id),
  FOREIGN KEY (enfermeira_id) REFERENCES enfermeira(id)
);

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
  FOREIGN KEY (paciente_id) REFERENCES paciente(id),
  FOREIGN KEY (medico_id) REFERENCES medico(id)
);

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
  FOREIGN KEY (atendimento_id) REFERENCES atendimento(id),
  FOREIGN KEY (medicamento_id) REFERENCES medicamento(id)
);

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
  FOREIGN KEY (paciente_id) REFERENCES paciente(id),
  FOREIGN KEY (medico_id) REFERENCES medico(id),
  FOREIGN KEY (laboratorio_id) REFERENCES laboratorio(id)
);

CREATE TABLE internacao (
  id INT PRIMARY KEY,
  data_entrada DATE NOT NULL,
  data_saida DATE,          
  paciente_id INT NOT NULL,
  leito_id INT NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id),
  FOREIGN KEY (leito_id) REFERENCES leito(id)
);

CREATE TABLE fatura (
  id INT PRIMARY KEY,
  numero VARCHAR(50) UNIQUE NOT NULL,
  valor DECIMAL(10,2) NOT NULL CHECK (valor >= 0),
  data_emissao DATE NOT NULL,
  data_vencimento DATE NOT NULL,
  status VARCHAR(30) NOT NULL,
  forma_pagamento VARCHAR(30),
  paciente_id INT NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

CREATE TABLE nota_fiscal (
  id INT PRIMARY KEY,
  nome_emissor VARCHAR(100) NOT NULL,
  nome_paciente VARCHAR(100) NOT NULL,
  descricao TEXT,          
  valor_bruto DECIMAL(10,2) NOT NULL,
  iss DECIMAL(10,2) NOT NULL,
  pis DECIMAL(10,2) NOT NULL,
  cofins DECIMAL(10,2) NOT NULL,
  irpj DECIMAL(10,2) NOT NULL,
  csll DECIMAL(10,2) NOT NULL,
  fatura_id INT UNIQUE NOT NULL,
  FOREIGN KEY (fatura_id) REFERENCES fatura(id)
);
\\comentario