INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: ostdpass
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'Sahak', 'Babayan', '712c57b679610adee58ac1855d3d3757f13b511b02415cfa5906a5b15e24f6bd', 'sahak.babayan');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'Admin', '712c57b679610adee58ac1855d3d3757f13b511b02415cfa5906a5b15e24f6bd', 'admin.admin');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);

-- Populate bank account table

INSERT INTO bank_account(id, account, iban, bank, bic) VALUES (1, 731334771421, 'CY17 1020 0128 1000 0012 0052 7611', 'Bank of America', 3242421);
INSERT INTO bank_account(id, account, iban, bank, bic) VALUES (2, 832334881752, 'NY13 0120 0128 0100 0012 0052 7624', 'HSBC', 5642422);
INSERT INTO bank_account(id, account, iban, bank, bic) VALUES (3, 933134991893, 'KL42 1020 0128 0010 0012 0052 7635', 'Zberbank', 8942423);
