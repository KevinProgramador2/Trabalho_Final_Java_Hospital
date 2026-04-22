-- ==========================================
-- 1. TABELAS INDEPENDENTES (Nível 0)
-- ==========================================

-- Inserindo Pessoas (Pacientes, Médicos e Enfermeiros)
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

