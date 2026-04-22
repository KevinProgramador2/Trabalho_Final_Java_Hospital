-- ==========================================
-- 1. TABELAS INDEPENDENTES (Nível 0)
-- ==========================================

-- Inserindo Pessoas (Pacientes, Médicos e Enfermeiros)

INSERT INTO hospital.pessoa (nome, cpf, telefone, endereco, datanascimento) VALUES 
('Arnaldo Antunes', '11122233344', '(21) 98888-1111', 'Rua das Flores, 10, Petrópolis', '1980-05-15'),
('Beatriz Cavalcante', '22233344455', '(21) 98888-2222', 'Av. Principal, 500, Centro', '1985-08-22'),
('Claudio Castro', '33344455566', '(21) 98888-3333', 'Rua B, 25, Quitandinha', '1978-03-10'),
('Daniela Escobar', '44455566677', '(21) 98888-4444', 'Rua C, 100, Bingen', '1992-12-01'),
('Eduardo Ferreira', '55566677788', '(24) 97777-5555', 'Rua do Imperador, 1200', '1995-07-20'),
('Fernanda Gomes', '66677788899', '(24) 97777-6666', 'Estrada da União, 45', '1988-02-28'),
('Gabriel Souza', '77788899900', '(21) 96666-7777', 'Rua Teresa, 80', '2000-01-15'),
('Helena Ipanema', '88899900011', '(21) 95555-8888', 'Av. Barão de Amazonas, 15', '1990-11-30'),
('Igor Justino', '99900011122', '(24) 94444-9999', 'Rua 16 de Março, 200', '1982-06-05'),
('Julia Kastro', '00011122233', '(21) 93333-0000', 'Rua Nelson de Sá Earp, 10', '1997-09-12');

INSERT INTO hospital.pessoa (id_pessoa, nome, cpf, telefone, endereco, datanascimento) VALUES
(11, 'Marcio Santos', '11122233301', '(24) 98888-0011', 'Estrada Bernardo Coutinho, 1200, Araras', '1975-03-12'),
(12, 'Ricardo Rocha', '22233344402', '(21) 98888-0022', 'Estrada da União e Indústria, 10000, Itaipava', '1972-08-25'),
(13, 'Alberto Amorim', '33344455503', '(24) 98888-0033', 'Rua Visconde de Taunay, 45, Retiro', '1968-11-10'),
(14, 'Ligia Queiroz', '44455566604', '(24) 98888-0044', 'Rua Cristovão Colombo, 40, Castelanea', '1978-01-30'),
(15, 'Roberto Ferreira', '55566677705', '(21) 98888-0055', 'Rua Vigário Corrêa, 150, Corrêas', '1972-05-20'),
(16, 'Antônio Soares', '66677788806', '(21) 98888-0066', 'Rua Bingen, 800, Bingen', '1980-02-28'),
(17, 'Fábio Lins', '77788899907', '(24) 96666-7777', 'Rua Doutor Thouzet, 22, Quitandinha', '1975-07-14'),
(18, 'Camila Braga', '88899900008', '(21) 95555-8888', 'Rua Mosela, 45, Mosela', '1982-12-05'),
(19, 'Bruno Garcia', '99900011109', '(24) 94444-9999', 'Rua Hyvio Naliato, 200, Cascatinha', '1970-06-15'),
(20, 'Juliana Vieira', '00011122210', '(21) 93333-0000', 'Rua Washington Luiz, 300, Valparaíso', '1979-09-12'),
(21, 'Marisa Antunes', '12312312301', '(21) 97777-1111', 'Rua 16 de Março, 44, Centro', '1977-02-27'),
(22, 'Raquel Rodrigues', '23423423402', '(24) 97777-2222', 'Rua Montecaseros, 12, Centro', '1985-12-18'),
(23, 'Clara Machado', '34534534503', '(24) 97777-3333', 'Rua Alberto Torres, 8, Centro', '1997-01-13'),
(24, 'Denise Mendes', '45645645604', '(21) 97777-4444', 'Estrada de Teresópolis, 50, Alto da Serra', '1993-02-07'),
(25, 'Elaine Silva', '56756756705', '(24) 97777-5555', 'Rua Duarte da Silveira, 30, Bingen', '1982-03-30'),
(26, 'Flávia Gomes', '67867867806', '(21) 97777-6666', 'Rua General Rondon, 2, Quitandinha', '1995-04-02'),
(27, 'Renata Duarte', '78978978907', '(24) 97777-7777', 'Rua Teresa, 400, Alto da Serra', '1979-05-15'),
(28, 'Heloísa Lima', '89089089008', '(24) 97777-8888', 'Rua Aureliano, 15, Centro', '1983-06-21'),
(29, 'Isabel Pereira', '90190190109', '(21) 97777-9999', 'Rua Coronel Veiga, 55, Ponte Fones', '1987-07-04'),
(30, 'Claudia Santana', '01201201210', '(21) 97777-0000', 'Estrada Mineira, 100, Corrêas', '1998-08-05'); 

-- Inserindo Planos de Saúde

INSERT INTO hospital.planosaude (nome, telefone, cobertura) VALUES 
('SulAmérica Saúde', '(21) 3003-1000', 'Nacional'),
('Unimed Rio', '(21) 4020-0123', 'Estadual'),
('Bradesco Saúde', '(11) 4004-2700', 'Nacional'),
('Amil Blue', '(11) 3004-1000', 'Regional'),
('SUS', '136', 'Total Nacional');

INSERT INTO hospital.planosaude (id_planosaude, nome, telefone, cobertura) VALUES
(6, 'Golden Cross', '(21) 2500-1000', 'Regional'),
(7, 'Intermédica', '(11) 3900-2000', 'Estadual'),
(8, 'Porto Seguro', '(21) 3003-9303', 'Nacional'),
(9, 'Assim Saúde', '(21) 2102-9797', 'Regional'),
(10, 'Prevent Senior', '(11) 3003-6200', 'Estadual'); 

-- Inserindo Hospitais
INSERT INTO hospital.hospital (id_hospital, nome, cnpj) VALUES
(1, 'Hospital Santa Teresa - Unidade Centro', '12345678000101'),
(2, 'Hospital Unidade Itaipava', '12345678000202'),
(3, 'Hospital Alcides Carneiro - Corrêas', '12345678000303'),
(4, 'UPA Centro Petrópolis', '12345678000404'),
(5, 'Hospital Unidade Bingen', '12345678000505'),
(6, 'Hospital Unidade Quitandinha', '12345678000606'),
(7, 'Hospital Regional de Araras', '12345678000707'),
(8, 'Hospital Unidade Cascatinha', '12345678000808'),
(9, 'Hospital Unidade Valparaíso', '12345678000909'),
(10, 'Hospital Memorial Petrópolis', '12345678001010'); 

-- Inserindo Laboratórios
INSERT INTO hospital.laboratorio (id_laboratorio, nome, tipo) VALUES
(1, 'Laboratório Central HST', 'interno'),
(2, 'Lab Exame Itaipava', 'externo'),
(3, 'Diagnósticos Petrópolis', 'externo'),
(4, 'Lab Imagem Corrêas', 'interno'),
(5, 'BioAnálise Bingen', 'externo'),
(6, 'Laboratório Quitandinha', 'interno'),
(7, 'Araras Lab', 'externo'),
(8, 'Cascatinha Diagnósticos', 'interno'),
(9, 'Valparaíso Lab', 'externo'),
(10, 'Memorial Lab', 'interno'); 

-- ==========================================
-- 2. TABELAS COM DEPENDÊNCIAS SIMPLES
-- ==========================================

-- Inserindo Pacientes
INSERT INTO hospital.paciente (pessoa_id) VALUES 
(5),
(6),
(7),
(8),
(9),
(10);

INSERT INTO hospital.paciente (id_paciente, pessoa_id) VALUES
(7, 1), (8, 2), (9, 3), (10, 4); 

-- Inserindo Médicos
INSERT INTO hospital.medico (crm, especialidade, pessoa_id) VALUES
('123456RJ', 'Cardiologia', 11),
('234567RJ', 'Cirurgia Geral', 12),
('345678RJ', 'Ortopedia', 13),
('456789RJ', 'Ginecologia', 14),
('567890RJ', 'Geriatria', 15),
('678901RJ', 'Oncologia', 16),
('789012RJ', 'Clínico Geral', 17),
('890123RJ', 'Pediatria', 18),
('901234RJ', 'Psiquiatria', 19), 
('012345RJ', 'Obstetrícia', 20); 

-- ==========================================
-- 3. RESOLUÇÃO DA DEPENDÊNCIA ALA <-> ENFERMEIRO
-- ==========================================

-- Passo 1: Inserir enfermeiros com ala_id NULL (Quebra o ciclo)
INSERT INTO hospital.enfermeiro (id_enfermeiro, cre, turno, pessoa_id, ala_id, chefe_id) VALUES
(1, 'CRE1010', 'Manhã', 21, NULL, NULL),
(2, 'CRE2020', 'Noite', 22, NULL, 1),    
(3, 'CRE3030', 'Manhã', 23, NULL, 1),    
(4, 'CRE4040', 'Tarde', 24, NULL, 1),    
(5, 'CRE5050', 'Manhã', 25, NULL, 1),    
(6, 'CRE6060', 'Noite', 26, NULL, 1),    
(7, 'CRE7070', 'Tarde', 27, NULL, 1),    
(8, 'CRE8080', 'Noite', 28, NULL, 1),    
(9, 'CRE9090', 'Manhã', 29, NULL, 1),    
(10, 'CRE0101', 'Tarde', 30, NULL, 1); 

-- Passo 2: Inserir as ALAS apontando para os responsáveis já inseridos
INSERT INTO hospital.ala (id_ala, tipo, leitosdisponiveis, hospital_id, responsavel_id) VALUES
(1, 'UTI', 10, 1, 1),        
(2, 'Pediatria', 15, 2, 2),   
(3, 'Enfermaria', 20, 3, 3),  
(4, 'Maternidade', 12, 4, 4), 
(5, 'Emergência', 20, 5, 5),  
(6, 'Cardiologia', 10, 6, 6), 
(7, 'Ortopedia', 12, 7, 7),   
(8, 'Oncologia', 10, 8, 8),   
(9, 'Geriatria', 15, 9, 9),   
(10, 'Psiquiatria', 10, 10, 10); 

-- Passo 3: Atualizar enfermeiros com as suas respectivas alas
UPDATE hospital.enfermeiro SET ala_id = 1 WHERE id_enfermeiro = 1;
UPDATE hospital.enfermeiro SET ala_id = 2 WHERE id_enfermeiro = 2;
UPDATE hospital.enfermeiro SET ala_id = 3 WHERE id_enfermeiro = 3;
UPDATE hospital.enfermeiro SET ala_id = 4 WHERE id_enfermeiro = 4;
UPDATE hospital.enfermeiro SET ala_id = 5 WHERE id_enfermeiro = 5;
UPDATE hospital.enfermeiro SET ala_id = 6 WHERE id_enfermeiro = 6;
UPDATE hospital.enfermeiro SET ala_id = 7 WHERE id_enfermeiro = 7;
UPDATE hospital.enfermeiro SET ala_id = 8 WHERE id_enfermeiro = 8;
UPDATE hospital.enfermeiro SET ala_id = 9 WHERE id_enfermeiro = 9;
UPDATE hospital.enfermeiro SET ala_id = 10 WHERE id_enfermeiro = 10; 

--Inserindo exames

INSERT INTO hospital.exame (id_exame, tipo, custo, descricao, datasolicitacao, paciente_id, medico_id, laboratorio_id) VALUES 
(1, 'Hemograma', 45.00, 'Rotina anual', '2026-04-20 08:30:00', 1, 7, 1), 
(2, 'Glicemia', 20.00, 'Controle de açúcar', '2026-04-21 07:15:00', 2, 5, 5),
(3, 'Raio-X Tórax', 120.00, 'Avaliação respiratória', '2026-04-21 09:45:00', 3, 3, 4),
(4, 'Urina EAS', 25.00, 'Rotina ginecológica', '2026-04-22 10:00:00', 4, 4, 2),
(5, 'Eletrocardiograma', 150.00, 'Risco cirúrgico', '2026-04-22 11:20:00', 5, 1, 3),
(6, 'Beta HCG', 60.00, 'Confirmação de gravidez', '2026-04-22 14:10:00', 6, 10, 6);

INSERT INTO hospital.exame (id_exame, tipo, custo, descricao, datasolicitacao, paciente_id, medico_id, laboratorio_id) VALUES 
(7, 'Ecocardiograma', 250.00, 'Avaliação de válvulas', '2026-04-22 08:00:00', 1, 1, 4),    
(8, 'Colesterol Total e Frações', 40.00, 'Perfil lipídico', '2026-04-22 08:15:00', 2, 7, 5),
(9, 'Papanicolau', 80.00, 'Preventivo anual', '2026-04-22 09:00:00', 4, 4, 2),            
(10, 'TC de Crânio', 450.00, 'Investigação de cefaleia', '2026-04-22 10:30:00', 3, 2, 3),  
(11, 'TSH e T4 Livre', 55.00, 'Função tireoidiana', '2026-04-22 11:00:00', 5, 5, 7),       
(12, 'PSA Livre e Total', 70.00, 'Rastreio próstata', '2026-04-22 13:45:00', 6, 7, 1),      
(13, 'Raio-X de Coluna', 110.00, 'Dor lombar', '2026-04-23 08:20:00', 1, 3, 8),             
(14, 'Endoscopia Digestiva', 350.00, 'Avaliação gástrica', '2026-04-23 09:30:00', 2, 2, 10),
(15, 'Eletroencefalograma', 180.00, 'Avaliação neurológica', '2026-04-23 10:15:00', 3, 9, 9),
(16, 'Ultrassonografia Morfológica', 220.00, 'Pré-natal', '2026-04-23 14:00:00', 4, 10, 4), 
(17, 'Vitamina D e B12', 90.00, 'Suplementação', '2026-04-24 07:30:00', 5, 5, 6),        
(18, 'Mamografia Digital', 150.00, 'Rastreio', '2026-04-24 09:00:00', 6, 4, 3),             
(19, 'Teste Ergométrico', 130.00, 'Avaliação física', '2026-04-24 10:45:00', 1, 1, 1),      
(20, 'Audiometria', 85.00, 'Avaliação auditiva', '2026-04-24 15:20:00', 2, 8, 2);

--Inserindo laudos

INSERT INTO hospital.laudo (id_laudo, resultado, descricao, data_resultado, exame_id) VALUES 
(1, 'Normal', 'Série branca e vermelha dentro da normalidade.', '2026-04-20 14:00:00', 1),
(2, 'Normal', 'Glicemia de jejum: 92 mg/dL.', '2026-04-21 11:30:00', 2),
(3, 'Alterado', 'Presença de infiltrado em base pulmonar direita.', '2026-04-21 15:20:00', 3),
(4, 'Normal', 'Ausência de nitritos ou bactérias.', '2026-04-22 16:45:00', 4),
(5, 'Normal', 'Ritmo sinusal regular, sem arritmias.', '2026-04-22 13:10:00', 5),
(6, 'Positivo', 'Beta HCG reagente. Compatível com 4 semanas.', '2026-04-22 18:00:00', 6),
(7, 'Normal', 'Frações de ejeção preservadas.', '2026-04-22 12:00:00', 7),
(8, 'Alterado', 'LDL elevado (160 mg/dL). Recomenda-se dieta.', '2026-04-22 17:30:00', 8),
(9, 'Normal', 'Ausência de células neoplásicas.', '2026-04-23 10:00:00', 9),
(10, 'Normal', 'Estruturas encefálicas sem desvios.', '2026-04-23 14:45:00', 10),
(11, 'Normal', 'Tireoide funcionando adequadamente.', '2026-04-23 16:00:00', 11),
(12, 'Normal', 'PSA total: 1.2 ng/mL.', '2026-04-23 17:20:00', 12),
(13, 'Alterado', 'Escoliose leve detectada em região lombar.', '2026-04-24 09:15:00', 13),
(14, 'Normal', 'Mucosa gástrica sem sinais de úlcera.', '2026-04-24 13:00:00', 14),
(15, 'Normal', 'Atividade elétrica cerebral padrão.', '2026-04-24 15:40:00', 15),
(16, 'Normal', 'Feto com batimentos e medidas normais.', '2026-04-24 16:30:00', 16),
(17, 'Alterado', 'Vitamina D abaixo do ideal (18 ng/mL).', '2026-04-25 08:00:00', 17),
(18, 'Normal', 'Tecido mamário sem calcificações.', '2026-04-25 10:10:00', 18),
(19, 'Normal', 'Capacidade aeróbica excelente para a idade.', '2026-04-25 11:50:00', 19),
(20, 'Normal', 'Limiares auditivos dentro da faixa normal.', '2026-04-25 16:40:00', 20);

--inserindo leitos

INSERT INTO hospital.leito (id_leito, identificador, statusleito, ala_id) VALUES 
(1, 'L-101', 'Ocupado', 1),   
(2, 'L-102', 'Livre', 1),     
(3, 'L-201', 'Ocupado', 2),   
(4, 'L-202', 'Manutenção', 2),
(5, 'L-301', 'Livre', 3),     
(6, 'L-302', 'Ocupado', 3),   
(7, 'L-401', 'Ocupado', 4),   
(8, 'L-402', 'Livre', 4),     
(9, 'L-501', 'Ocupado', 5),  
(10, 'L-502', 'Livre', 5),    
(11, 'L-601', 'Livre', 6),    
(12, 'L-602', 'Ocupado', 6),  
(13, 'L-701', 'Manutenção', 7),
(14, 'L-702', 'Livre', 7),    
(15, 'L-801', 'Ocupado', 8),  
(16, 'L-802', 'Livre', 8),    
(17, 'L-901', 'Livre', 9),    
(18, 'L-902', 'Ocupado', 9),  
(19, 'L-001', 'Ocupado', 10), 
(20, 'L-002', 'Livre', 10);   

--inserindo internaçao

INSERT INTO hospital.internacao (id_internacao, data_entrada, data_saida, paciente_id, leito_id) VALUES 
(1, '2026-04-10 10:00:00', '2026-04-15 14:30:00', 1, 1),
(2, '2026-04-12 08:00:00', '2026-04-14 10:00:00', 2, 3),
(3, '2026-04-18 15:20:00', NULL, 3, 6),
(4, '2026-04-20 09:00:00', NULL, 4, 7),
(5, '2026-04-21 11:00:00', NULL, 5, 9),
(6, '2026-04-15 13:00:00', '2026-04-20 09:00:00', 6, 12);

INSERT INTO hospital.internacao (id_internacao, data_entrada, data_saida, paciente_id, leito_id) VALUES 
(7, '2026-04-21 16:00:00', NULL, 7, 2),
(8, '2026-04-22 08:30:00', NULL, 8, 4),
(9, '2026-04-22 10:00:00', NULL, 9, 5),
(10, '2026-04-10 14:00:00', '2026-04-12 18:00:00', 10, 10);

--inserindo medicamento

INSERT INTO hospital.medicamento (nome) VALUES 
( 'Dipirona Monoidratada'),
( 'Paracetamol'),
( 'Amoxicilina'),
( 'Ibuprofeno'),
( 'Omeprazol'),
( 'Losartana Potássica'),
( 'Metformina'),
( 'Azitromicina'),
( 'Ceftriaxona'),
( 'Tramadol'),
( 'Dexametasona'),
( 'Insulina Glargina'),
( 'Cloreto de Sódio 0,9%'),
( 'Complexo B'),
( 'Soro Glicosado'),
( 'Adrenalina'),
( 'Morfina'),
( 'Diazepam'),
( 'Furosemida'),
( 'Salbutamol');

--inserindo atendimentos

INSERT INTO hospital.atendimento (id_atendimento, dataatendimento, tipo, statusatendimento, observacoes, paciente_id, medico_id) VALUES 
(1, '2026-04-20 08:00:00', 'Consulta', 'REALIZADO', 'Paciente apresenta sintomas de gripe.', 1, 7),
(2, '2026-04-20 09:30:00', 'Retorno', 'REALIZADO', 'Avaliação de exames laboratoriais.', 2, 5),
(3, '2026-04-21 10:00:00', 'Emergência', 'REALIZADO', 'Dor abdominal aguda.', 3, 2),
(4, '2026-04-21 14:00:00', 'Consulta', 'CANCELADO', 'Paciente não compareceu.', 4, 4),
(5, '2026-04-22 08:30:00', 'Check-up', 'REALIZADO', 'Avaliação cardiológica de rotina.', 5, 1),
(6, '2026-04-22 13:00:00', 'Pré-natal', 'REALIZADO', 'Acompanhamento gestacional.', 6, 10),
(7, '2026-04-23 09:00:00', 'Consulta', 'AGENDADO', 'Primeira consulta ortopédica.', 1, 3),
(8, '2026-04-23 11:00:00', 'Retorno', 'AGENDADO', 'Verificação de medicação.', 2, 7),
(9, '2026-04-23 15:30:00', 'Terapia', 'REALIZADO', 'Sessão de acompanhamento.', 3, 9),
(10, '2026-04-24 07:00:00', 'Consulta', 'AGENDADO', 'Avaliação geriátrica.', 5, 5),
(11, '2026-04-24 10:00:00', 'Consulta', 'CANCELADO', 'Médico com urgência externa.', 6, 1),
(12, '2026-04-24 16:00:00', 'Pós-operatório', 'REALIZADO', 'Retirada de pontos.', 2, 2),
(13, '2026-04-25 08:00:00', 'Consulta', 'AGENDADO', 'Rotina pediátrica.', 4, 8),
(14, '2026-04-25 09:00:00', 'Consulta', 'AGENDADO', 'Avaliação oncológica.', 6, 6),
(15, '2026-04-19 14:00:00', 'Consulta', 'REALIZADO', 'Encaminhamento para exames.', 4, 7);

--inserindo faturas

INSERT INTO hospital.fatura (numero, valor, dataemissao, datavencimento, statuscobranca, formapagamento, servico, paciente_id, planosaude_id) VALUES 
('FAT-001', 100.00, '2026-04-20', '2026-05-20', 'PENDENTE', 'Dinheiro', 'Consulta', 1, NULL);

INSERT INTO hospital.fatura (numero, valor, dataemissao, datavencimento, statuscobranca, formapagamento, servico, paciente_id, planosaude_id) VALUES 
('FAT-021', 55.00, '2026-04-20', '2026-05-20', 'PAGO', 'Pix', 'TSH e T4', 5, NULL),
('FAT-022', 70.00, '2026-04-20', '2026-05-20', 'EM_ANALISE', 'Boleto', 'PSA Livre', 6, NULL),
('FAT-023', 110.00, '2026-04-21', '2026-05-21', 'PENDENTE', 'Cartao', 'Raio-X Coluna', 1, NULL),
('FAT-024', 350.00, '2026-04-21', '2026-05-21', 'PAGO', 'Transfer', 'Endoscopia', 2, NULL),
('FAT-025', 180.00, '2026-04-21', '2026-05-21', 'EM_ANALISE', 'Debito', 'Eletroencef.', 3, NULL),
('FAT-026', 220.00, '2026-04-22', '2026-05-22', 'PAGO', 'Pix', 'Ultra Morfo.', 4, NULL),
('FAT-027', 90.00, '2026-04-22', '2026-05-22', 'PENDENTE', 'Boleto', 'Vit. D e B12', 5, NULL),
('FAT-028', 150.00, '2026-04-22', '2026-05-22', 'CANCELADO', 'Cartao', 'Mamografia', 6, NULL),
('FAT-029', 130.00, '2026-04-23', '2026-05-23', 'PAGO', 'Pix', 'Teste Ergom.', 1, NULL),
('FAT-030', 85.00, '2026-04-23', '2026-05-23', 'EM_ANALISE', 'Debito', 'Audiometria', 2, NULL),
('FAT-031', 300.00, '2026-04-23', '2026-05-23', 'PENDENTE', 'Boleto', 'Consulta Esp.', 3, NULL),
('FAT-032', 45.00, '2026-04-24', '2026-05-24', 'PAGO', 'Dinheiro', 'Hemograma', 4, NULL),
('FAT-033', 500.00, '2026-04-24', '2026-05-24', 'EM_ANALISE', 'Cartao', 'Sessao Terapia', 5, NULL),
('FAT-034', 60.00, '2026-04-24', '2026-05-24', 'CANCELADO', 'Pix', 'Beta HCG', 6, NULL),
('FAT-035', 1200.00, '2026-04-24', '2026-05-24', 'PENDENTE', 'Boleto', 'Internacao', 1, NULL);


--inserindo credenciamento

INSERT INTO hospital.credenciamento (datacredenciamento, hospital_id, planosaude_id) VALUES 
('2026-01-01', 1, 1),
('2026-01-01', 1, 2),
('2026-01-05', 2, 1),
('2026-01-10', 3, 1),
('2026-01-10', 3, 2),
('2026-01-15', 4, 1),
('2026-01-20', 5, 2),
('2026-02-01', 6, 1),
('2026-02-01', 6, 2),
('2026-02-10', 7, 1),
('2026-02-15', 8, 1),
('2026-03-01', 9, 2),
('2026-03-05', 10, 1),
('2026-03-05', 10, 2),
('2026-03-10', 1, 3);

--inserindo prescricao

INSERT INTO hospital.prescricao (dataprescricao, dosagem, quantidade, atendimento_id, medicamento_id) VALUES 
('2026-04-20', '500mg - 8 em 8 horas', 1, 1, 1),
('2026-04-20', '750mg - dose única', 1, 2, 2),
('2026-04-21', '1g - 12 em 12 horas', 2, 3, 3),
('2026-04-22', '400mg - 1 vez ao dia', 1, 5, 4),
('2026-04-22', '20mg - em jejum', 1, 6, 5),
('2026-04-23', '50mg - após o almoço', 1, 9, 6),
('2026-04-24', '100mg - 24 em 24 horas', 1, 12, 7),
('2026-04-19', '500mg - dose única', 1, 15, 8),
('2026-04-21', '2g - intravenoso', 1, 3, 9),
('2026-04-20', '10mg - se houver dor', 1, 1, 10);




