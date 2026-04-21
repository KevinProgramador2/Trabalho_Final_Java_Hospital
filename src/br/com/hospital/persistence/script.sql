CREATE DATABASE hospital;

CREATE TABLE hospital (
  id_hospital SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cnpj VARCHAR(18) UNIQUE NOT NULL
);

CREATE TABLE plano (
  id_plano SERIAL PRIMARY KEY,
  nome VARCHAR(100) UNIQUE NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  cobertura VARCHAR(50) NOT NULL,
  data_credenciamento DATE NOT NULL
);

CREATE TABLE paciente (
  id_paciente SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) UNIQUE NOT NULL
);

CREATE TABLE medico (
  id_medico SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) UNIQUE NOT NULL,
  crm VARCHAR(20) UNIQUE NOT NULL,
  especialidade VARCHAR(100) NOT NULL
);

CREATE TABLE enfermeiro (
  id_enfermeiro SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) UNIQUE NOT NULL,
  cre VARCHAR(20) UNIQUE NOT NULL,
  turno VARCHAR(20) NOT NULL,
  chefe_id INT,             
  CONSTRAINT fk_enfermeiro_chefe FOREIGN KEY (chefe_id) REFERENCES enfermeiro(id_enfermeiro)
    ON DELETE RESTRICT
);

CREATE TABLE ala (
  id_ala SERIAL PRIMARY KEY,
  tipo VARCHAR(50) NOT NULL,
  leitosDisponiveis INT NOT NULL,
  hospital_id INT NOT NULL,
  enfermeiro_id INT UNIQUE NOT NULL,
  CONSTRAINT fk_ala_hospital FOREIGN KEY (hospital_id) REFERENCES hospital(id_hospital)
    ON DELETE RESTRICT,
  CONSTRAINT fk_ala_enfermeiro FOREIGN KEY (enfermeiro_id) REFERENCES enfermeiro(id_enfermeiro)
    ON DELETE RESTRICT
);

CREATE TABLE leito (
  id_leito SERIAL PRIMARY KEY,
  identificador VARCHAR(50) UNIQUE NOT NULL,
  statusLeito VARCHAR(30) NOT NULL,
  ala_id INT NOT NULL,
  CONSTRAINT fk_leito_ala FOREIGN KEY (ala_id) REFERENCES ala(id_ala)
    ON DELETE RESTRICT
);

CREATE TABLE atendimento (
  id_atendimento SERIAL PRIMARY KEY,
  data_hora TIMESTAMP NOT NULL,
  tipo VARCHAR(30) NOT NULL,
  statusAtendimento VARCHAR(30) NOT NULL,
  observacoes TEXT,        
  paciente_id INT NOT NULL,
  medico_id INT NOT NULL,
  CONSTRAINT fk_atendimento_paciente FOREIGN KEY (paciente_id) REFERENCES paciente(id_paciente)
    ON DELETE RESTRICT,
  CONSTRAINT fk_atendimento_medico FOREIGN KEY (medico_id) REFERENCES medico(id_medico)
    ON DELETE RESTRICT
);

CREATE TABLE medicamento (
  id_medicamento SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE prescricao (
  id_prescricao SERIAL PRIMARY KEY,
  dataPrescricao DATE NOT NULL,
  dosagem VARCHAR(50) NOT NULL,
  atendimento_id INT NOT NULL,
  medicamento_id INT NOT NULL,
  CONSTRAINT fk_prescricao_atendimento FOREIGN KEY (atendimento_id) REFERENCES atendimento(id_atendimento)
    ON DELETE RESTRICT,
  CONSTRAINT fk_prescricao_medicamento FOREIGN KEY (medicamento_id) REFERENCES medicamento(id_medicamento)
    ON DELETE RESTRICT
);

CREATE TABLE laboratorio (
  id_laboratorio SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  tipo VARCHAR(30) NOT NULL
);

CREATE TABLE exame (
  id_exame SERIAL PRIMARY KEY,
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
  CONSTRAINT fk_exame_paciente FOREIGN KEY (paciente_id) REFERENCES paciente(id_paciente)
    ON DELETE RESTRICT,
  CONSTRAINT fk_exame_medico FOREIGN KEY (medico_id) REFERENCES medico(id_medico)
    ON DELETE RESTRICT,
  CONSTRAINT fk_exame_laboratorio FOREIGN KEY (laboratorio_id) REFERENCES laboratorio(id_laboratorio)
    ON DELETE RESTRICT
);

CREATE TABLE internacao (
  id_internacao SERIAL PRIMARY KEY,
  data_entrada DATE NOT NULL,
  data_saida DATE,          
  paciente_id INT NOT NULL,
  leito_id INT NOT NULL,
  CONSTRAINT fk_internacao_paciente FOREIGN KEY (paciente_id) REFERENCES paciente(id_paciente)
    ON DELETE RESTRICT,
  CONSTRAINT fk_internacao_leito FOREIGN KEY (leito_id) REFERENCES leito(id_leito)
    ON DELETE RESTRICT
);

CREATE TABLE fatura (
  id_fatura SERIAL PRIMARY KEY,
  numero VARCHAR(50) UNIQUE NOT NULL,
  valor DECIMAL(10,2) NOT NULL CHECK (valor >= 0),
  data_emissao DATE NOT NULL,
  data_vencimento DATE NOT NULL,
  status VARCHAR(30) NOT NULL,
  forma_pagamento VARCHAR(30),
  paciente_id INT NOT NULL,
  CONSTRAINT fk_fatura_paciente FOREIGN KEY (paciente_id) REFERENCES paciente(id_paciente)
    ON DELETE RESTRICT
);

CREATE TABLE notaFiscal (
  id_notaFiscal SERIAL PRIMARY KEY,
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
<<<<<<< HEAD
  FOREIGN KEY (fatura_id) REFERENCES fatura(id)
);
=======
  CONSTRAINT fk_notaFiscal_fatura FOREIGN KEY (fatura_id) REFERENCES fatura(id_fatura)
    ON DELETE RESTRICT
);
>>>>>>> c8ecf56dfbd74b510e24e961c4ab0867cbc62f99
