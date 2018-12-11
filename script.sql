create table if not exists User
(
  id         int auto_increment
    primary key,
  login      varchar(200) not null,
  password   varchar(255) not null,
  email      varchar(250) not null,
  beep       varchar(20)  null,
  department varchar(200) not null,
  name       varchar(250) not null,
  type       varchar(20)  not null,
  cellphone  varchar(20)  null
);

create table if not exists Patient
(
  id              int auto_increment
    primary key,
  firstName       varchar(200) not null,
  lastName        varchar(200) not null,
  age             int          not null,
  address         varchar(200) not null,
  roomNumber      varchar(200) not null,
  emergencyNumber varchar(200) not null,
  department      varchar(200) not null,
  doctorId        int          not null,
  nurseId         int          null,
  gender          varchar(20)  null,
  constraint fk_patient_doctor
    foreign key (doctorId) references User (id)
      on delete cascade,
  constraint fk_patient_nurse
    foreign key (nurseId) references User (id)
      on delete cascade
);

create table if not exists PatientRecords
(
  id        int auto_increment
    primary key,
  date      datetime     not null,
  nurseId   int          null,
  patientId int          not null,
  type      varchar(200) not null,
  details   varchar(200) null,
  category  varchar(200) not null,
  constraint fk_nurse
    foreign key (nurseId) references User (id)
      on delete cascade,
  constraint fk_patient
    foreign key (patientId) references Patient (id)
      on delete cascade
);


