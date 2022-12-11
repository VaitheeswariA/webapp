-- CREATE DATABASE bus_db;
-- DROP DATABASE bus_db;
-- USE bus_db;

-- -------Admin---------------------------
CREATE TABLE IF NOT EXISTS Admin
(
EmailId VARCHAR(35) NOT NULL PRIMARY KEY,
Password VARCHAR(10)
);

INSERT INTO Admin VALUES("admin@gmail.com","admin");
-- --------------------------------------------
CREATE TABLE IF NOT EXISTS TravelAdmin
(
Id INT NOT NULL PRIMARY KEY,
EmailId VARCHAR(35),
TravelsName VARCHAR(30),
Password VARCHAR(10)
);

INSERT INTO TravelAdmin VALUES
(1,"amirthamtravel@gmail.com","Amirtham Travels","amirtham"),
(2,"parveentravels@gmail.com","Parveen Travels","parveen"),
(3,"ntxpress@gmail.com","NT Xpress","ntxpress");
-- ---------Driver------------------------

CREATE TABLE IF NOT EXISTS Driver
(
DriverId INT NOT NULL AUTO_INCREMENT,
Name VARCHAR(30),
EmailId VARCHAR(35),
MobileNumber VARCHAR(12),
PRIMARY KEY(DriverId)
);

INSERT INTO Driver (Name,EmailId,MobileNumber) VALUES("Shiva","shiva@gmail.com","9098979695");
INSERT INTO Driver (Name,EmailId,MobileNumber) VALUES("Hari","hari@gmail.com","9000011119");
INSERT INTO Driver (Name,EmailId,MobileNumber) VALUES("Mega","mega@gmail.com","9111122229");
INSERT INTO Driver (Name,EmailId,MobileNumber) VALUES("Ayyappa","ayyappa@gmail.com","9222233339");
-- ----Passenger Related Tables-------------
CREATE TABLE IF NOT EXISTS Passenger
(
PassengerId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(30),
EmailId VARCHAR(35),
Password VARCHAR(10),
MobileNumber VARCHAR(12)
);

INSERT INTO Passenger (Name,EmailId,Password,MobileNumber) VALUES("Murugan","murugan@gmail.com","Murugan1","8787878787");
INSERT INTO Passenger (Name,EmailId,Password,MobileNumber) VALUES("Deepa","deepa@gmail.com","Deepa1","8686868686");
INSERT INTO Passenger (Name,EmailId,Password,MobileNumber) VALUES("Durga","durga@gmail.com","Durga1","8585858585");
INSERT INTO Passenger (Name,EmailId,Password,MobileNumber) VALUES("Anbu","anbu@gmail.com","Anbu1","8484848484");
INSERT INTO Passenger (Name,EmailId,Password,MobileNumber) VALUES("Suba","suba@gmail.com","Suba1","8383838383");

-- -----------Bus Details----------------------------

CREATE TABLE IF NOT EXISTS Bus
(
BusId INT NOT NULL AUTO_INCREMENT,
TravelId INT NOT NULL,
BusNumber VARCHAR(20),
BusType VARCHAR(6),
SeatTypeId INT,
Seats INT,
Rating INT,
PRIMARY KEY(BusId),
FOREIGN KEY(TravelId) REFERENCES TravelAdmin(Id)
);


INSERT INTO Bus (TravelId,BusNumber,BusType,SeatTypeId,Seats,Rating) VALUES(1,"TN74 TIN 4000","AC",2,15,4);
INSERT INTO Bus (TravelId,BusNumber,BusType,SeatTypeId,Seats,Rating) VALUES(1,"TN33 CBE 3333","AC",2,15,4);
INSERT INTO Bus (TravelId,BusNumber,BusType,SeatTypeId,Seats,Rating) VALUES(2,"TN74 TIN 7000","NON AC",1,24,4);
INSERT INTO Bus (TravelId,BusNumber,BusType,SeatTypeId,Seats,Rating) VALUES(2,"TN33 CBE 3000","NON AC",1,24,4);
INSERT INTO Bus (TravelId,BusNumber,BusType,SeatTypeId,Seats,Rating) VALUES(3,"TN74 TIN 4477","NON AC",1,24,3);
INSERT INTO Bus (TravelId,BusNumber,BusType,SeatTypeId,Seats,Rating) VALUES(3,"TN33 CBE 3300","NON AC",1,24,3);

CREATE TABLE IF NOT EXISTS SeatType
(
SeatTypeId INT NOT NULL AUTO_INCREMENT,
SeatType VARCHAR(30),
PRIMARY KEY(SeatTypeId)
);

INSERT INTO SeatType VALUES
(1,"Sleeper"),
(2,"SemiSleeper"),
(3,"SSS");


CREATE TABLE IF NOT EXISTS TripInfo
(
ScheduleId INT NOT NULL AUTO_INCREMENT,
BusId INT NOT NULL,
DriverId INT NOT NULL,
TripDate date NOT NULL, 
TripStartTime Time NOT NULL,
AvailableSeats INT NOT NULL,
PRIMARY KEY(ScheduleId),
CONSTRAINT Bus_fk FOREIGN KEY(BusId) REFERENCES Bus(BusId),
CONSTRAINT driver_fk FOREIGN KEY(DriverId) REFERENCES Driver(DriverId)                      
);                                                                                                                                                                                         

INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(1,1,'2022-10-24','18:00',15);
INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(2,2,'2022-10-24','20:00',15);
INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(3,3,'2022-10-24','22:30',24);
INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(4,4,'2022-10-26','22:30',24);
INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(2,2,'2022-10-30','20:00',15);

INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(1,1,'2022-12-31','22:30',24);
INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(2,2,'2022-12-01','20:00',15);
INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(3,3,'2022-12-02','22:30',24);
INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(4,4,'2022-12-03','22:30',24);

INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(1,1,'2022-12-04','22:30',24);
INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(2,2,'2022-12-05','20:00',15);
INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(3,3,'2022-12-06','22:30',24);
INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(4,4,'2022-12-07','22:30',24);


INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(1,1,'2022-12-08','22:30',24);
INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(2,2,'2022-12-09','20:00',15);
INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(3,3,'2022-12-10','22:30',24);
INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(4,4,'2022-12-11','22:30',24);

INSERT INTO TripInfo (BusId,DriverId,TripDate,TripStartTime,AvailableSeats) VALUES(3,3,'2022-12-31','22:30',24);

 SELECT * FROM TripInfo;
 SELECT * FROM routes;
 SELECT * FROM Bus;
CREATE TABLE Routes
(
RouteId INT NOT NULL AUTO_INCREMENT,
ScheduleId INT NOT NULL,
StartPlace VARCHAR(35) NOT NULL,
EndPlace VARCHAR(35) NOT NULL,
TravelStartDate DATE NOT NULL,
TravelEndDate DATE NOT NULL,
TravelStartTime TIME NOT NULL,
TravelEndTime TIME NOT NULL,
TravelFare DOUBLE NOT NULL,
TimeToReach DOUBLE NOT NULL,
PRIMARY KEY(RouteId),
CONSTRAINT TravelSchedule_fk2 FOREIGN KEY(ScheduleId) REFERENCES TripInfo(ScheduleId)
);

INSERT INTO Routes (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(1, "Chennai","Tenkasi",'2022-10-24','2022-10-25','18:00','07:00', 1500, 11);
INSERT INTO Routes (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(1, "Chennai","Alangulam",'2022-10-24','2022-10-25','18:00','06:30', 1300, 10.5);
INSERT INTO Routes (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(1, "Chennai","Tirunelveli",'2022-10-24','2022-10-25','18:00','06:00', 1000, 10);
INSERT INTO Routes  (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(1, "Chennai","Trichy",'2022-10-24','2022-10-25','18:00','23:00', 800, 5);
INSERT INTO Routes  (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(1, "Trichy","Tenkasi",'2022-10-24','2022-10-25','23:00','04:30', 700, 5.5);
INSERT INTO Routes  (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(1, "Chennai","Madurai",'2022-10-24','2022-10-25','18:00','01:30', 1000, 7.5);

INSERT INTO Routes (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(2, "Chennai","Tenkasi",'2022-10-30','2022-10-31','20:00','07:00', 1500, 11);
INSERT INTO Routes (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(2, "Chennai","Alangulam",'2022-10-30','2022-10-31','20:00','06:30', 1300, 10.5);
INSERT INTO Routes (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(2, "Chennai","Tirunelveli",'2022-10-30','2022-10-31','20:00','06:00', 1000, 10);
INSERT INTO Routes  (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(2, "Chennai","Trichy",'2022-10-30','2022-10-31','20:00','01:00', 800, 5);
INSERT INTO Routes  (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(2, "Trichy","Tenkasi",'2022-10-30','2022-10-31','01:00','05:30', 700, 5.5);
INSERT INTO Routes  (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(2, "Chennai","Madurai",'2022-10-30','2022-10-31','20:00','03:30', 1000, 7.5);
   
--- 
INSERT INTO Routes (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(9, "Chennai","Coimbatore",'2022-12-03','2022-12-04','20:00','05:00', 1200, 9);
INSERT INTO Routes (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(9, "Chennai","Vellore",'2022-12-03','2022-12-03','20:00','23:00', 500, 3);
INSERT INTO Routes (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(9, "Chennai","Salem",'2022-12-03','2022-12-04','20:00','02:00', 800, 6);
INSERT INTO Routes  (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(9, "Chennai","Erode",'2022-12-03','2022-12-04','20:00','03:00', 900, 7);
INSERT INTO Routes  (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(9, "Vellore","Tiruppur",'2022-12-03','2022-12-04','23:00','03:00', 700, 4);
INSERT INTO Routes  (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(9, "Vellore","Coimbatore",'2022-12-03','2022-12-04','23:00','05:30', 1000, 6);
   ----
   
INSERT INTO Routes (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(18, "Chennai","Tenkasi",'2022-12-31','2023-01-01','22:30','09:30', 1500, 11);
INSERT INTO Routes (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(18, "Chennai","Alangulam",'2022-12-31','2023-01-01','22:30','08:30', 1300, 10.5);
INSERT INTO Routes (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(18, "Chennai","Tirunelveli",'2022-12-31','2023-01-01','22:30','08:00', 1000, 10);
INSERT INTO Routes  (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(18, "Chennai","Trichy",'2022-12-31','2023-01-01','22:30','03:30', 800, 5);
INSERT INTO Routes  (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(18, "Trichy","Tenkasi",'2022-12-31','2023-01-01','22:30','04:00', 700, 5.5);
INSERT INTO Routes  (ScheduleId,StartPlace,EndPlace,TravelStartDate,TravelEndDate,TravelStartTime,TravelEndTime,TravelFare,TimeToReach) VALUES(18, "Chennai","Madurai",'2022-12-31','2023-01-01','22:30','06:00', 1000, 7.5);
   
   
-- INSERT INTO RouteMapping VALUES(2,1,"Vellore",400.00,2);
-- INSERT INTO RouteMapping VALUES(2,2,"Salem",800.00,5.20);
-- INSERT INTO RouteMapping VALUES(2,3,"Erode",900.00,6);
-- INSERT INTO RouteMapping VALUES(2,4,"Tiruppur",1000.00,7);
-- INSERT INTO RouteMapping VALUES(2,5,"Coimbatore",1400.00,8);
   
   
   
   
   
   
SELECT * FROM routes;
SELECT B.*,TA.*,T.*,R.* FROM TripInfo T INNER JOIN Routes R ON T.ScheduleId=R.ScheduleId
INNER JOIN Bus B ON B.BusId=T.BusId 
INNER JOIN TravelAdmin TA ON B.TravelId=TA.Id
WHERE R.StartPlace='Chennai' AND R.EndPlace='Tenkasi' AND R.TravelStartDate ='2022-10-30';


-- CREATE TABLE IF NOT EXISTS RouteMapping
-- (
-- RouteId INT NOT NULL,
-- RouteOrder INT,
-- StopName VARCHAR(20),
-- TravelFare DOUBLE,
-- TimeToReach DOUBLE,
-- PRIMARY KEY(RouteId,RouteOrder),
-- CONSTRAINT TS_fk FOREIGN KEY(RouteId) REFERENCES Routes(RouteId)
-- );

-- INSERT INTO RouteMapping VALUES(1,1,"Ariyalur",325.00,5);
-- INSERT INTO RouteMapping VALUES(1,2,"Trichy",500.00,5);
-- INSERT INTO RouteMapping VALUES(1,3,"Madurai",700.00,7.25);
-- INSERT INTO RouteMapping VALUES(1,4,"Virudhunagar",800.00,8.30);
-- INSERT INTO RouteMapping VALUES(1,5,"Sivakasi",900.0,9);
-- INSERT INTO RouteMapping VALUES(1,6,"Tenkasi",1100.00,10);

-- INSERT INTO RouteMapping VALUES(2,1,"Vellore",400.00,2);
-- INSERT INTO RouteMapping VALUES(2,2,"Salem",800.00,5.20);
-- INSERT INTO RouteMapping VALUES(2,3,"Erode",900.00,6);
-- INSERT INTO RouteMapping VALUES(2,4,"Tiruppur",1000.00,7);
-- INSERT INTO RouteMapping VALUES(2,5,"Coimbatore",1400.00,8);

-- INSERT INTO RouteMapping VALUES(3,1,"Perambalur",275.00,4.30);
-- INSERT INTO RouteMapping VALUES(3,2,"Trichy",560.00,5);
-- INSERT INTO RouteMapping VALUES(3,3,"Madurai",750.00,7.25);
-- INSERT INTO RouteMapping VALUES(3,4,"Tenkasi",1300.00,10);

-- INSERT INTO RouteMapping VALUES(4,1,"Vellore",250.00,2);
-- INSERT INTO RouteMapping VALUES(4,2,"Salem",600.00,5.20);
-- INSERT INTO RouteMapping VALUES(4,3,"Erode",700.00,6);
-- INSERT INTO RouteMapping VALUES(4,4,"Tiruppur",900.00,7);
-- INSERT INTO RouteMapping VALUES(4,5,"Coimbatore",1200.00,8);

CREATE TABLE IF NOT EXISTS BoardingPoints
(
BoardingPointId INT NOT NULL AUTO_INCREMENT,
RouteId INT NOT NULL,
BoardingOrder INT NOT NULL,
BoardingPlace VARCHAR(30),
BoardingTime Time NOT NULL,
PRIMARY KEY(BoardingPointId),
CONSTRAINT broute_fk1 FOREIGN KEY(RouteId) REFERENCES Routes(RouteId)
);

INSERT INTO BoardingPoints (RouteId,BoardingOrder,BoardingPlace,BoardingTime) VALUES
(1,1,"Tambaram",'18:00'),
(1,2,"Perungalathur",'18:10'),
(1,3,"SRM college",'18:40'),
(1,4,"Mahindhra City",'19:00'),
(1,5,"Chengalpattu",'19:20'),
(2,1,"Tambaram",'18:00'),
(2,2,"Perungalathur",'18:10'),
(2,3,"SRM college",'18:40'),
(2,4,"Mahindhra City",'19:00'),
(2,5,"Chengalpattu",'19:20'),
(3,1,"Tambaram",'18:00'),
(3,2,"Perungalathur",'18:10'),
(3,3,"SRM college",'18:40'),
(3,4,"Mahindhra City",'19:00'),
(3,5,"Chengalpattu",'19:20'),
(4,1,"Tambaram",'18:00'),
(4,2,"Perungalathur",'18:10'),
(4,3,"SRM college",'18:40'),
(4,4,"Mahindhra City",'19:00'),
(4,5,"Chengalpattu",'19:20'),
(5,1,"Trichy Bypass",'23:20'),
(5,2,"Trichy Bus Stand",'23:40'),
(6,1,"Tambaram",'18:00'),
(6,2,"Perungalathur",'18:10'),
(6,3,"SRM college",'18:40'),
(6,4,"Mahindhra City",'19:00'),
(6,5,"Chengalpattu",'19:20');

-- SELECT * FROM Routes;
-- SELECT * FROM BoardingPoints;
-- SELECT * From RouteMapping;
-- ------------Booked Details--------------------------
CREATE TABLE IF NOT EXISTS BookingDetails
(
TicketId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
BusId INT NOT NULL,
RouteId INT NOT NULL,
PassengerId INT NOT NULL,
BookedDate Date NOT NULL,
TravelDate Date NOT NULL,
BoardingTime TIME NOT NULL,
BoardingPoint VARCHAR(30) NOT NULL,
DroppingTime TIME NOT NULL,
DroppingPoint VARCHAR(30) NOT NULL,
TicketCount INT NOT NULL,
Fare DOUBLE NOT NULL,
BookingStatus VARCHAR(20),
CONSTRAINT p_fk FOREIGN KEY(PassengerId) REFERENCES Passenger(PassengerId)
);

INSERT INTO BookingDetails (BusId,RouteId,PassengerId,BookedDate,TravelDate,BoardingTime,BoardingPoint,DroppingTime,DroppingPoint,TicketCount,Fare,BookingStatus) VALUES(1,1,1,'2022-10-22','2022-10-24','18:10',"Perungalathur",'07:00',"Tenkasi",2,1800.00,"Confirmed");

CREATE TABLE IF NOT EXISTS BookedPassengers
(
TicketId INT NOT NULL,
SeatNumber INT,
PassengerName VARCHAR(30),
FOREIGN KEY(TicketId) REFERENCES BookingDetails(TicketId)
);

INSERT INTO BookedPassengers VALUES
(1,1,"Shruthi"),
(1,2,"Hemanth");
-- --------------
-- TA.TravelsName,TS.*,R.StartPlace as StartPlace,R.EndPlace as Destination,BP.BoardingPlace as BoardingPoint,RM.StopName as DroppingPoint
SELECT  B.*,TA.*,R.*,BP.*,RM.*,TS.*
FROM TravelSchedule TS INNER JOIN BoardingPoints BP ON TS.RouteId=BP.RouteId
INNER JOIN Routes R ON TS.RouteId=R.RouteId
INNER JOIN RouteMapping RM ON TS.RouteId=RM.RouteId 
INNER JOIN Bus B ON TS.BusId=B.BusId
INNER JOIN TravelAdmin TA ON B.TravelId=TA.Id
WHERE R.startPlace ="Chennai" AND RM.StopName="Trichy" ;-- AND TS.travelStartDate='2022-10-24' AND
-- TS.travelStartTime BETWEEN '18:00' AND '20:00';





SELECT * FROM Passenger;

SELECT BD.* FROM BookingDetails BD INNER JOIN BookedPassengers BPS ON BD.TicketId=BPS.TicketId
WHERE BD.PassengerId=1 ORDER BY BD.TicketId DESC;