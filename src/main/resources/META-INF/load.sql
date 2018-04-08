INSERT INTO USERS (ID, FULL_NAME, EMAIL, PASSWORD, CONFIRMED) VALUES (-1, 'admin', 'admin', STRINGDECODE('x61Ey612Kl2gpFL56FT9weDnpSo4AV8j8+qx2AuTHdRyY036xxzTTrw10Wq3+4qQyB+XURPWx1ON\nxp3Y3pB37A=='), true);
INSERT INTO ROLES (ID, NAME, DESCRIPTION) VALUES (-1, 'admin', 'admin');
INSERT INTO ROLES (ID, NAME, DESCRIPTION) VALUES (-2, 'user', 'user');
INSERT INTO USERS_ROLES (USER_ID, ROLE_ID) VALUES (-1, -1);
INSERT INTO USERS_ROLES (USER_ID, ROLE_ID) VALUES (-1, -2);

insert into CATEGORY (ID, CODE, NAME)VALUES (1, 'FACE', 'For face');
insert into CATEGORY (ID, CODE, NAME)VALUES (2, 'BODY', 'For body');

INSERT INTO PRODUCER(ID, CODE, NAME) VALUES (1, '001', 'Organic People');
INSERT INTO PRODUCER(ID, CODE, NAME) VALUES (2, '002', 'Organic Kitchen');

INSERT INTO ITEM(ID, CODE, DESCRIPTION, CATEGORY_ID, CATEGORYDESCRIPTION, PRICE, PRODUCER_ID, PRODUCERNAME)
VALUES (1,1001,'Creme Rose',1,'For face',5,1,'Organic People');
INSERT INTO ITEM(ID, CODE, DESCRIPTION, CATEGORY_ID, CATEGORYDESCRIPTION, PRICE, PRODUCER_ID, PRODUCERNAME)
VALUES (2,1002,'Creme Pink',1,'For face',5,1,'Organic People');
INSERT INTO ITEM(ID, CODE, DESCRIPTION, CATEGORY_ID, CATEGORYDESCRIPTION, PRICE, PRODUCER_ID, PRODUCERNAME)
VALUES (3,1003,'Creme Waw',2,'For body',3,2,'Organic Kitchen');
INSERT INTO ITEM(ID, CODE, DESCRIPTION, CATEGORY_ID, CATEGORYDESCRIPTION, PRICE, PRODUCER_ID, PRODUCERNAME)
VALUES (4,1004,'Creme White',1,'For face',4,2,'Organic Kitchen');