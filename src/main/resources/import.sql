insert into Aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, '8I', 70, 2000);
insert into Aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, '8F', 70, 2000);
insert into Aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, 'BBJ', 70, 2000);
insert into Aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, '300F', 70, 2000);
insert into Aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, 'KC-767', 70, 2000);
insert into Aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, 'E-767', 70, 2000);
insert into Aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, '200LR', 70, 2000);
insert into Aircraft (isAvailable, model, passengerCapacity, rangeFuelTank) values(1, '300ER', 70, 2000);

insert into Address (country, city) values ('El Salvador','San Salvador');
insert into Address (country, city) values ('Honduras','Tegucigalpa');
insert into Address (country, city) values ('Nicaragua','Managua');
insert into Address (country, city) values ('Panama','Panama City');
insert into Address (country, city) values ('Costa Rica','San José');

insert into Airport (name, idAddress) values('Monseñor Óscar Arnulfo Romero', 1);
insert into Airport (name, idAddress) values('Toncontin', 2);
insert into Airport (name, idAddress) values('Augusto C. Sandino', 3);
insert into Airport (name, idAddress) values('Tocumen', 4);
insert into Airport (name, idAddress) values('Juan Santamaría', 5);

insert into OperationPermission (idAircraft, idAirport) values (1,1);
insert into OperationPermission (idAircraft, idAirport) values (2,1);
insert into OperationPermission (idAircraft, idAirport) values (3,1);
insert into OperationPermission (idAircraft, idAirport) values (4,1);
insert into OperationPermission (idAircraft, idAirport) values (5,1);
insert into OperationPermission (idAircraft, idAirport) values (6,1);
insert into OperationPermission (idAircraft, idAirport) values (7,1);
insert into OperationPermission (idAircraft, idAirport) values (8,1);

insert into Airline (name) values('Albatros Airlines');
insert into Airline (name) values('Iberia');
insert into Airline (name) values('American Airlines');
insert into Airline (name) values('Southwest Airlines');
insert into Airline (name) values('JetBlue Airways');

insert into Flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'AH 34', 1, 1,1,2);
insert into Flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'KJ34', 2, 1,1,2);
insert into Flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('LANDED', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'YH 56', 4, 1,1,3);
insert into Flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('STAND_BY', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'RT 44', 1, 1,1,3);
insert into Flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('STAND_BY', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'HF 87', 4, 1,1,2);
insert into Flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('LANDED', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'JK 55', 1, 1,1,4);
insert into Flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('LANDED', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'DD 44', 1, 3,1,2);
insert into Flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'DGD 543', 1, 1,1,4);
insert into Flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'SR 64', 3, 1,1,4);
insert into Flight (currentStateText, dateTimeArrival, dateTimeDeparture, expectedDateTimeArrival, flightNumber, idAircraft, idAirline, idDestinationAirport, idOriginAirport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'DH 36', 1, 1,1,2);