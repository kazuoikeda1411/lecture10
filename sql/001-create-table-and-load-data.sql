DROP TABLE IF EXISTS medicalRecords;

CREATE TABLE medicalRecords (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  disease VARCHAR(20) NOT NULL,
  medical_condition VARCHAR(20) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO medicalRecords (id,name,disease,medical_condition) VALUES (1, "Sato","感冒","症状あり");
INSERT INTO medicalRecords (id,name,disease,medical_condition) VALUES (2, "Suzuki","糖尿病","症状なし");
INSERT INTO medicalRecords (id,name,disease,medical_condition) VALUES (3, "Takahashi","高血圧","症状なし");
INSERT INTO medicalRecords (id,name,disease,medical_condition) VALUES (4, "Tanaka","高脂血症","症状なし");
INSERT INTO medicalRecords (id,name,disease,medical_condition) VALUES (5, "Ito","感冒","症状あり");
INSERT INTO medicalRecords (id,name,disease,medical_condition) VALUES (6, "Watanabe","感冒","症状あり");
INSERT INTO medicalRecords (id,name,disease,medical_condition) VALUES (7, "Yamamoto","高脂血症","症状なし");
INSERT INTO medicalRecords (id,name,disease,medical_condition) VALUES (8, "Nakamura","高血圧","症状なし");
INSERT INTO medicalRecords (id,name,disease,medical_condition) VALUES (9, "Kobayashi","感冒","症状あり");
INSERT INTO medicalRecords (id,name,disease,medical_condition) VALUES (10, "Kato","高血圧","症状なし");

