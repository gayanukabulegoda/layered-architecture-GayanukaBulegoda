drop database Blood_Donation_Management_System;

create database Blood_Donation_Management_System;

Use Blood_Donation_Management_System;

create table user (
    User_id varchar(10) primary key,
    Username varchar(15) not null,
    Password varchar(10) not null
);

create table employee (
    Emp_id varchar(10) primary key,
    User_id varchar(10) not null,
    Name varchar(15) not null,
    Address varchar(30) not null,
    Role varchar(20) not null,
    DOB date not null,
    constraint foreign key(User_id) references user(User_id) on UPDATE CASCADE on DELETE CASCADE
);

create table salary (
    Salary_id varchar(10) primary key,
    Emp_id varchar(10) not null,
    Amount int(10) not null,
    Month varchar(10) not null,
    Year varchar(10) not null,
    constraint foreign key(Emp_id) REFERENCES employee(Emp_id)on UPDATE CASCADE on DELETE CASCADE
);

create table attendance (
    Att_id varchar(10) primary key,
    Emp_id varchar(10) not null,
    Date date not null,
    Status varchar(10) not null,
   constraint foreign key(Emp_id) references employee(Emp_id)on UPDATE CASCADE on DELETE CASCADE
);

create table supplier (
    Sup_id varchar(10) primary key,
    User_id varchar(10) not null,
    Name varchar(15) not null,
    Address varchar(30) not null,
    Tel int(12) not null,
    constraint  foreign key(User_id) references user(User_id)on UPDATE CASCADE on DELETE CASCADE
);

create table supplier_Orders (
    SupOrder_id varchar(10) primary key,
    Sup_id varchar(10) not null,
    Date date not null,
    Amount varchar(10) not null,
    constraint foreign key(Sup_id) references supplier(Sup_id)on UPDATE CASCADE on DELETE CASCADE
);

create table medical_inventory (
     Med_id varchar(10) primary key,
     Date date not null,
     Blood_type varchar(10) not null
);

create table order_details (
     SupOrder_id varchar(10) not null,
     Med_id varchar(10) not null,
     Description varchar(20) not null,
     constraint foreign key(SupOrder_id) references supplier_Orders(SupOrder_id)on UPDATE CASCADE on DELETE CASCADE,
     constraint foreign key(Med_id) references medical_inventory(Med_id)on UPDATE CASCADE on DELETE CASCADE
);

create table needer (
     Needer_id varchar(10) primary key,
     User_id varchar(10) not null,
     Name varchar(15) not null,
     Address varchar(30) not null,
     Contact int(12) not null,
     Email varchar(20),
    constraint  foreign key(User_id) references user(User_id)on UPDATE CASCADE on DELETE CASCADE
);

create table needer_Request (
     Request_id varchar(10) primary key,
     Needer_id varchar(10) not null,
     Date date not null,
     Amount varchar(10) not null,
     constraint foreign key(Needer_id) references needer(Needer_id)on UPDATE CASCADE on DELETE CASCADE
);

create table donor (
     D_id varchar(10) primary key,
     F_name varchar(10) not null,
     L_name varchar(10),
     DOB date not null,
     Blood_type varchar(10) not null,
     Tel int(12),
     L_donate_date date
);

create table donation (
     Donation_id varchar(10) primary key,
     D_id varchar(10) ,
     Date date not null,
     Blood_type varchar(10) not null,
     Hemoglobin_level varchar(10) not null,
     constraint foreign key(D_id) references donor(D_id)on UPDATE CASCADE on DELETE CASCADE
);

create table blood_inventory (
    BloodBag_id varchar(10) primary key,
    Donation_id varchar(10) not null,
    Donation_date date not null,
    Ex_date date not null,
    Blood_type varchar(10) not null,
    constraint foreign key(Donation_id) references donation(Donation_id)on UPDATE CASCADE on DELETE CASCADE
);

create table request_details (
    NeeReq_id varchar(10) not null,
    BloodBag_id varchar(10) not null,
    Description varchar(20) not null,
    constraint foreign key(NeeReq_id) references needer_Request(Request_id) on UPDATE CASCADE on DELETE CASCADE,
    constraint foreign key(BloodBag_id) references blood_inventory(BloodBag_id)on UPDATE CASCADE on DELETE CASCADE
);
