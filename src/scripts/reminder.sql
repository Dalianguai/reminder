create table reminder_request (
	id int not null auto_increment primary key ,
	owner varchar(30) not null,
	subject varchar(100) not null,
	description text,
	rep boolean not null ,
	daily boolean not null,
	weekly boolean not null,
	monthlyByDay boolean not null,
	monthlyByDate boolean not null,
	startDay date not null,
	endDay date not null,
	createDate date not null
);

create index ind_req_owner on reminder_request(owner);

create table reminder_member (
	id int not null auto_increment primary key,
	request_id int not null,
	name varchar(30) not null,
	constraint fk_request_id foreign key (request_id) references reminder_request(id)
);

create index ind_req_id on reminder_member(request_id);
create unique index ind_req_name on reminder_member(request_id, name);

create table reminder_entry (
	id int not null auto_increment primary key,
	request_id int not null,
	day date not null,
	bSent boolean not null,
	sentDay date,
	constraint fk_reminder_entry_request_id foreign key (request_id) references reminder_request(id)
);

create index ind_req_rem_ent_id on reminder_entry(day);
