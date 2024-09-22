


create table country (
     ID char(2) primary key,
    NAME varchar(30)   not null
);

create table customer
(
    CUSTOMER_ID         int auto_increment
        primary key,
    CUSTOMER_TYPE       enum ('PP', 'PM')                                                           not null,
    shortName          varchar(60)                                                                 null,
    GENDER              enum ('MALE', 'FEMALE')                                                     null,
    DATE_BIRTH_CREATION date                                                                        null,
    ADDRESS             varchar(60)                                                                 null,
    POST_CODE           int                                                                         null,
    LEGAL_DOC_NAME      enum ('CIN', 'PASSEPORT', 'CARTE_SEJOUR', 'REGISTRE_COMMERCE', 'ID_FISCAL') not null,
    LEGAL_ID            varchar(30)                                                                 null,
    NATIONALITY         char(2)                                                                    not null,
    ACCOUNT_OFFICER     int                                                                         null,
    TEL                 varchar(20)                                                                 null,
    MAIL                varchar(30)                                                                 null,
    FOREIGN KEY(NATIONALITY) REFERENCES country(ID)

);

create table currency (
    ID char(3)   primary key,
    NAME  varchar(10)  not null
);


create table deptaccountofficer
(
    ID   int  auto_increment     primary key,
    NAME varchar(50) not null
);

create table account
(
    ID              int auto_increment
        primary key,
    CUSTOMER_ID int not null,
    ACCOUNT_OFFICER int                          not null,
    ACCOUNT_TITLE   char(60)                      null,
    CURRENCY        char(3)                       null,
    CATEGORY        varchar(20)                   null,
    WORKING_BALANCE decimal(10, 4) default 0.0000 null,
    OPENING_DATE    date                          null,
    CLOSURE_DATE    date                          null,
    FOREIGN KEY(CUSTOMER_ID) REFERENCES customer(CUSTOMER_ID) ,
    FOREIGN KEY(CURRENCY) REFERENCES currency(ID),
    FOREIGN KEY(ACCOUNT_OFFICER) REFERENCES deptaccountofficer (ID)
);


create table user
(
     matricule int auto_increment primary key,
    Nom       varchar(20) null,
    Prenom    varchar(20) null,
    Agence    int         null,
    Mail      varchar(30) null,
    password  varchar(12) null,
        FOREIGN KEY(Agence) REFERENCES deptaccountofficer(ID)


);