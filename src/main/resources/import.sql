insert into aircraft (is_available, model, passenger_capacity, range_fuel_tank) values(1, '8I', 70, 2000);
insert into aircraft (is_available, model, passenger_capacity, range_fuel_tank) values(1, '8F', 70, 2000);
insert into aircraft (is_available, model, passenger_capacity, range_fuel_tank) values(1, 'BBJ', 70, 2000);
insert into aircraft (is_available, model, passenger_capacity, range_fuel_tank) values(1, '300F', 70, 2000);
insert into aircraft (is_available, model, passenger_capacity, range_fuel_tank) values(1, 'KC-767', 70, 2000);
insert into aircraft (is_available, model, passenger_capacity, range_fuel_tank) values(1, 'E-767', 70, 2000);
insert into aircraft (is_available, model, passenger_capacity, range_fuel_tank) values(1, '200LR', 70, 2000);
insert into aircraft (is_available, model, passenger_capacity, range_fuel_tank) values(1, '300ER', 70, 2000);

insert into address (country, city) values ('El Salvador','San Salvador');
insert into address (country, city) values ('Honduras','Tegucigalpa');
insert into address (country, city) values ('Nicaragua','Managua');
insert into address (country, city) values ('Panama','Panama City');
insert into address (country, city) values ('Costa Rica','San José');

insert into airport (name, id_address) values('Monseñor Óscar Arnulfo Romero International Airport', 1);
insert into airport (name, id_address) values('Toncontin International Airport', 2);
insert into airport (name, id_address) values('Augusto C. Sandino International Airport', 3);
insert into airport (name, id_address) values('Tocumen International Airport', 4);
insert into airport (name, id_address) values('Juan Santamaría International Airport', 5);

insert into operation_permission (id_aircraft, id_airport) values (1,1);
insert into operation_permission (id_aircraft, id_airport) values (2,1);
insert into operation_permission (id_aircraft, id_airport) values (3,1);
insert into operation_permission (id_aircraft, id_airport) values (4,1);
insert into operation_permission (id_aircraft, id_airport) values (5,1);
insert into operation_permission (id_aircraft, id_airport) values (6,1);
insert into operation_permission (id_aircraft, id_airport) values (7,1);
insert into operation_permission (id_aircraft, id_airport) values (8,1);

insert into airline (name) values('Albatros Airlines');
insert into airline (name) values('Iberia');
insert into airline (name) values('American Airlines');
insert into airline (name) values('Southwest Airlines');
insert into airline (name) values('JetBlue Airways');

insert into flight (current_state_text, date_time_arrival, date_time_departure, expected_date_time_arrival, flight_number, id_aircraft, id_airline, id_destination_airport, id_origin_airport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'AH 34', 1, 1,1,2);
insert into flight (current_state_text, date_time_arrival, date_time_departure, expected_date_time_arrival, flight_number, id_aircraft, id_airline, id_destination_airport, id_origin_airport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'KJ34', 2, 1,1,2);
insert into flight (current_state_text, date_time_arrival, date_time_departure, expected_date_time_arrival, flight_number, id_aircraft, id_airline, id_destination_airport, id_origin_airport) values('LANDED', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'YH 56', 4, 1,1,3);
insert into flight (current_state_text, date_time_arrival, date_time_departure, expected_date_time_arrival, flight_number, id_aircraft, id_airline, id_destination_airport, id_origin_airport) values('STAND_BY', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'RT 44', 1, 1,1,3);
insert into flight (current_state_text, date_time_arrival, date_time_departure, expected_date_time_arrival, flight_number, id_aircraft, id_airline, id_destination_airport, id_origin_airport) values('STAND_BY', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'HF 87', 4, 1,1,2);
insert into flight (current_state_text, date_time_arrival, date_time_departure, expected_date_time_arrival, flight_number, id_aircraft, id_airline, id_destination_airport, id_origin_airport) values('LANDED', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'JK 55', 1, 1,1,4);
insert into flight (current_state_text, date_time_arrival, date_time_departure, expected_date_time_arrival, flight_number, id_aircraft, id_airline, id_destination_airport, id_origin_airport) values('LANDED', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'DD 44', 1, 3,1,2);
insert into flight (current_state_text, date_time_arrival, date_time_departure, expected_date_time_arrival, flight_number, id_aircraft, id_airline, id_destination_airport, id_origin_airport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'DGD 543', 1, 1,1,4);
insert into flight (current_state_text, date_time_arrival, date_time_departure, expected_date_time_arrival, flight_number, id_aircraft, id_airline, id_destination_airport, id_origin_airport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'SR 64', 3, 1,1,4);
insert into flight (current_state_text, date_time_arrival, date_time_departure, expected_date_time_arrival, flight_number, id_aircraft, id_airline, id_destination_airport, id_origin_airport) values('ON_FLIGHT', null, '2021-01-03 10:00:00', '2021-01-04 20:00:00', 'DH 36', 1, 1,1,2);