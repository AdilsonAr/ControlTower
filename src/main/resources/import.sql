insert into aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, '8I', 70, 2000);
insert into aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, '8F', 70, 2000);
insert into aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, 'BBJ', 70, 2000);
insert into aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, '300F', 70, 2000);
insert into aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, 'KC-767', 70, 2000);
insert into aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, 'E-767', 70, 2000);
insert into aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, '200LR', 70, 2000);
insert into aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, '300ER', 70, 2000);

insert into address (country, city) values ('El Salvador','San Salvador');
insert into address (country, city) values ('Honduras','Tegucigalpa');
insert into address (country, city) values ('Nicaragua','Managua');
insert into address (country, city) values ('Panama','Panama City');
insert into address (country, city) values ('Costa Rica','San José');

insert into airport (name, idAddress) values('Monseñor Óscar Arnulfo Romero International Airport', 1);
insert into airport (name, idAddress) values('Toncontin International Airport', 2);
insert into airport (name, idAddress) values('Augusto C. Sandino International Airport', 3);
insert into airport (name, idAddress) values('Tocumen International Airport', 4);
insert into airport (name, idAddress) values('Juan Santamaría International Airport', 5);

insert into operationpermission (idAircraft, idAirport) values (1,1);
insert into operationpermission (idAircraft, idAirport) values (2,1);
insert into operationpermission (idAircraft, idAirport) values (3,1);
insert into operationpermission (idAircraft, idAirport) values (4,1);
insert into operationpermission (idAircraft, idAirport) values (5,1);
insert into operationpermission (idAircraft, idAirport) values (6,1);
insert into operationpermission (idAircraft, idAirport) values (7,1);
insert into operationpermission (idAircraft, idAirport) values (8,1);

insert into airline (name) values('Albatros Airlines');
insert into airline (name) values('Iberia');
insert into airline (name) values('American Airlines');
insert into airline (name) values('Southwest Airlines');
insert into airline (name) values('JetBlue Airways');

insert into flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'AH 34', 1, 1,1,2);
insert into flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'KJ34', 2, 1,1,2);
insert into flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('LANDED', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'YH 56', 4, 1,1,3);
insert into flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('STAND_BY', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'RT 44', 1, 1,1,3);
insert into flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('STAND_BY', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'HF 87', 4, 1,1,2);
insert into flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('LANDED', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'JK 55', 1, 1,1,4);
insert into flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('LANDED', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'DD 44', 1, 3,1,2);
insert into flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'DGD 543', 1, 1,1,4);
insert into flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'SR 64', 3, 1,1,4);
insert into flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'DH 36', 1, 1,1,2);