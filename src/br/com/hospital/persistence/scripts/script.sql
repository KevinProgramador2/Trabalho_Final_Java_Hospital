CREATE DATABASE hospital;

CREATE TABLE hospital (
  id_hospital SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  cnpj VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE credenciamento (
  id_credenciamento SERIAL NOT NULL,
  dataCredenciamento TIMESTAMP NOT NULL,
  hospital_id INT NOT NULL,
  planoSaude_id INT NOT NULL,

  UNIQUE(hospital_id, planoSaude_id),
  CONSTRAINT fk_credencial_hospital FOREIGN KEY hospital_id REFERENCES hospital(id_hospital)
    ON DELETE RESTRICT,
  CONSTRAINT fk_credencial_plano FOREIGN KEY planoSaude_id REFERENCES planoSaude(id_planoSaude)
    ON DELETE RESTRICT
);

CREATE TABLE planoSaude (
  id_planoSaude SERIAL PRIMARY KEY,
  nome VARCHAR(50) UNIQUE NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  cobertura VARCHAR(50) NOT NULL
);

CREATE TABLE pessoa (
  id_pessoa SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  cpf VARCHAR(20) UNIQUE NOT NULL,
  telefone VARCHAR(20),
  endereco VARCHAR(50),
  dataNascimento DATE NOT NULL
);

CREATE TABLE paciente (
  id_paciente SERIAL PRIMARY KEY,
  pessoa_id INT NOT NULL,

  CONSTRAINT fk_paciente_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id_pessoa)
    ON DELETE RESTRICT
);

CREATE TABLE medico (
  id_medico SERIAL PRIMARY KEY,
  crm VARCHAR(20) UNIQUE NOT NULL,
  especialidade VARCHAR(50) NOT NULL,
  pessoa_id INT NOT NULL,

  CONSTRAINT fk_medico_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id_pessoa)
    ON DELETE RESTRICT
);

CREATE TABLE enfermeiro (
  id_enfermeiro SERIAL PRIMARY KEY,
  cre VARCHAR(20) UNIQUE NOT NULL,
  turno VARCHAR(20) NOT NULL,
  pessoa_id INT NOT NULL,
  ala_id INT,
  chefe_id INT,

  CONSTRAINT fk_enfermeiro_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id_pessoa)
    ON DELETE RESTRICT,     
  CONSTRAINT fk_enfermeiro_chefe FOREIGN KEY (chefe_id) REFERENCES enfermeiro(id_enfermeiro)
    ON DELETE RESTRICT
);

CREATE TABLE ala (
  id_ala SERIAL PRIMARY KEY,
  tipo VARCHAR(50) NOT NULL,
  leitosDisponiveis INT NOT NULL,
  hospital_id INT NOT NULL,
  responsavel_id INT UNIQUE NOT NULL,

  CONSTRAINT fk_ala_hospital FOREIGN KEY (hospital_id) REFERENCES hospital(id_hospital)
    ON DELETE RESTRICT
);

CREATE TABLE leito (
  id_leito SERIAL PRIMARY KEY,
  identificador VARCHAR(50) UNIQUE NOT NULL,
  statusLeito VARCHAR(20) NOT NULL,
  ala_id INT NOT NULL,

  CONSTRAINT fk_leito_ala FOREIGN KEY (ala_id) REFERENCES ala(id_ala)
    ON DELETE RESTRICT
);

CREATE TABLE atendimento (
  id_atendimento SERIAL PRIMARY KEY,
  dataAtendimento TIMESTAMP NOT NULL,
  tipo VARCHAR(20) NOT NULL,
  statusAtendimento VARCHAR(20) NOT NULL,
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
  nome VARCHAR(50) NOT NULL
);

CREATE TABLE prescricao (
  id_prescricao SERIAL PRIMARY KEY,
  dataPrescricao DATE NOT NULL,
  dosagem VARCHAR(50) NOT NULL,
  quantidade INT NOT NULL,
  atendimento_id INT NOT NULL,
  medicamento_id INT NOT NULL,

  CONSTRAINT fk_prescricao_atendimento FOREIGN KEY (atendimento_id) REFERENCES atendimento(id_atendimento)
    ON DELETE RESTRICT,
  CONSTRAINT fk_prescricao_medicamento FOREIGN KEY (medicamento_id) REFERENCES medicamento(id_medicamento)
    ON DELETE RESTRICT
);

CREATE TABLE laboratorio (
  id_laboratorio SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  tipo VARCHAR(20) NOT NULL
);

CREATE TABLE exame (
  id_exame SERIAL PRIMARY KEY,
  tipo VARCHAR(50) NOT NULL,
  custo DECIMAL(10,2) NOT NULL,
  descricao TEXT,          
  dataSolicitacao TIMESTAMP NOT NULL,
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

CREATE TABLE laudo (
  id_laudo SERIAL PRIMARY KEY,
  resultado VARCHAR(30) NOT NULL,
  descricao TEXT,
  data_resultado TIMESTAMP NOT NULL,
  exame_id INT NOT NULL,

  CONSTRAINT fk_laudo_exame FOREIGN KEY (exame_id) REFERENCES exame(id_exame)
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
CREATE UNIQUE INDEX unico_paciente_internado
ON internacao (paciente_id)
WHERE data_saida IS NULL;
CREATE UNIQUE INDEX unico_leito_ocupado
ON internacao (leito_id)
WHERE data_saida IS NULL;

CREATE TABLE servico (
  id_servico SERIAL PRIMARY KEY,
  tipo VARCHAR(20) NOT NULL,
  atendimento_id INT null,
  exame_id INT NULL,
  internacao_id INT NULL,

  CONSTRAINT fk_servico_atendimento FOREIGN KEY (atendimento_id) REFERENCES atendimento(id_atendimento)
    ON DELETE RESTRICT,
  CONSTRAINT fk_servico_exame FOREIGN KEY (exame_id) REFERENCES exame(id_exame)
    ON DELETE RESTRICT,
  CONSTRAINT fk_servico_internacao FOREIGN KEY (internacao_id) REFERENCES internacao(id_internacao)
    ON DELETE RESTRICT,
  CONSTRAINT chk_tipo_servico CHECK (
    (atendimento_id IS NOT NULL AND exame_id IS NULL AND internacao_id IS NULL)
    OR
    (exame_id IS NOT NULL AND atendimento_id IS NULL AND internacao_id IS NULL)
    OR
    (internacao_id IS NOT NULL AND atendimento_id IS NULL AND exame_id IS NULL)
  )
);

CREATE TABLE cliente (
  id_cliente SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  paciente_id INT NULL,
  planoSaude_id INT NULL,

  CONSTRAINT fk_cliente_paciente FOREIGN KEY (paciente_id) REFERENCES paciente(id_paciente)
    ON DELETE RESTRICT,
  CONSTRAINT fk_cliente_planoSaude FOREIGN KEY (planoSaude_id) REFERENCES planoSaude(id_planoSaude)
    ON DELETE RESTRICT,
  CONSTRAINT chk_cliente CHECK (
    (paciente_id IS NOT NULL AND planoSaude_id IS NULL)
    OR
    (planoSaude_id IS NOT NULL AND paciente_id IS NULL)
  )
);

CREATE TABLE fatura (
  id_fatura SERIAL PRIMARY KEY,
  numero VARCHAR(50) UNIQUE NOT NULL,
  valor DECIMAL(10,2) NOT NULL CHECK (valor >= 0),
  dataEmissao DATE NOT NULL,
  dataVencimento DATE NOT NULL,
  statusCobranca VARCHAR(20) NOT NULL,
  formaPagamento VARCHAR(20) NOT NULL,
  servico_id INT NOT NULL,
  cliente_id INT NOT NULL,
  emissor_id INT NOT NULL,

  CONSTRAINT fk_fatura_servico FOREIGN KEY (servico_id) REFERENCES servico(id_servico)
    ON DELETE RESTRICT,
  CONSTRAINT fk_fatura_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id_cliente)
    ON DELETE RESTRICT,
  CONSTRAINT fk_fatura_emissor FOREIGN KEY (emissor_id) REFERENCES hospital(id_hospital)
    ON DELETE RESTRICT
);

CREATE TABLE notaFiscal (
  id_notaFiscal SERIAL PRIMARY KEY,
  emissor VARCHAR(50) NOT NULL,
  cliente VARCHAR(50) NOT NULL,
  descricao TEXT,          
  valorBruto DECIMAL(10,2) NOT NULL,
  iss DECIMAL(10,2) NOT NULL,
  pis DECIMAL(10,2) NOT NULL,
  cofins DECIMAL(10,2) NOT NULL,
  irpj DECIMAL(10,2) NOT NULL,
  csll DECIMAL(10,2) NOT NULL,
  fatura_id INT UNIQUE NOT NULL,

  CONSTRAINT fk_notaFiscal_fatura FOREIGN KEY (fatura_id) REFERENCES fatura(id_fatura)
    ON DELETE RESTRICT
);

