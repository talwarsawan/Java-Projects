-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 25, 2015 at 08:35 AM
-- Server version: 5.6.24
-- PHP Version: 5.5.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbapt`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbadmin`
--

CREATE TABLE IF NOT EXISTS `tbadmin` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbadmin`
--

INSERT INTO `tbadmin` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tbans`
--

CREATE TABLE IF NOT EXISTS `tbans` (
  `rno` int(11) NOT NULL,
  `qid` int(11) NOT NULL,
  `ans` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbcat`
--

CREATE TABLE IF NOT EXISTS `tbcat` (
  `id` int(11) NOT NULL,
  `cname` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbcat`
--

INSERT INTO `tbcat` (`id`, `cname`) VALUES
(1, 'QUANTITATIVE'),
(2, 'VERBAL');

-- --------------------------------------------------------

--
-- Table structure for table `tblevel`
--

CREATE TABLE IF NOT EXISTS `tblevel` (
  `id` int(11) NOT NULL,
  `lname` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblevel`
--

INSERT INTO `tblevel` (`id`, `lname`) VALUES
(1, 'HIGH'),
(2, 'MEDIUM'),
(3, 'LOW');

-- --------------------------------------------------------

--
-- Table structure for table `tbques`
--

CREATE TABLE IF NOT EXISTS `tbques` (
  `id` int(11) NOT NULL,
  `qname` varchar(767) NOT NULL,
  `cid` int(11) NOT NULL,
  `lid` int(11) NOT NULL,
  `a` varchar(50) NOT NULL,
  `b` varchar(50) NOT NULL,
  `c` varchar(50) NOT NULL,
  `d` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  `solution` varchar(5000) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbques`
--

INSERT INTO `tbques` (`id`, `qname`, `cid`, `lid`, `a`, `b`, `c`, `d`, `correct`, `solution`) VALUES
(1, 'In a 300 m race A beats B by 22.5 m or 6 seconds. B''s time over the course is:', 1, 2, '86 sec', '80 sec', '76 sec', 'none of these', 'b', 'B runs	45	m in 6 sec.\r\n	2	\r\n  B covers 300 m in	 	6 x	2	x 300	 sec	= 80 sec.\r\n			45			\r\n'),
(2, ' Two bus tickets from city A to B and three tickets from city A to C cost Rs. 77 but three tickets from city A to B and two tickets from city A to C cost Rs. 73. \r\n   What are the fares for cities B and C from A ?', 1, 1, 'Rs. 4, Rs. 23', 'Rs. 13, Rs. 17', 'Rs. 15, Rs. 14', 'Rs. 17, Rs. 13', 'b', 'Let Rs. x be the fare of city B from city A and Rs. y be the fare of city C from city A.Then, 2x + 3y = 77 ...(i) and\r\n3x + 2y = 73 ...(ii)\r\nMultiplying (i) by 3 and (ii) by 2 and subtracting, we get: 5y = 85 or y = 17.\r\nPutting y = 17 in (i), we get: x = 13.'),
(3, '120, 99, 80, 63, 48, ?', 1, 2, '35', '38', '39', '40', 'a', 'The pattern is - 21, - 19, - 17, - 15,.....So, missing term = 48 - 13 = 35.'),
(4, ' 589654237, 89654237, 8965423, 965423, ?', 1, 1, ' 58965', '65423', ' 89654	', '96542', 'd', 'The digits are removed one by one from the beginning and the end in order alternately,so as to obtain the subsequent terms of the series.\r\n'),
(5, '34.95 + 240.016 + 23.98 = ?', 1, 1, '298.0946', '298.111', '298.946', '299.09', 'c', '   34.95\r\n  240.016\r\n + 23.98\r\n --------\r\n  298.946\r\n --------    \r\n'),
(6, 'A and B started a partnership business investing some amount in the ratio of 3 : 5. C joined then after six months with an amount equal to that of B. In what proportion should the profit at the end of one year be distributed among A, B and C?', 1, 3, '3 : 5 : 2', '3 : 5 : 5', '6 : 10 : 5', 'none of these', 'c', 'Let the initial investments of A and B be 3x and 5x.\r\nA : B : C = (3x x 12) : (5x x 12) : (5x x 6) = 36 : 60 : 30 = 6 : 10 : 5.\r\n'),
(7, 'Two trains, each 100 m long, moving in opposite directions, cross each other in 8 seconds. If one is moving twice as fast the other, then the speed of the faster train is:', 1, 3, '30 km/hr', '45 km/hr', '60 km/hr', '70 km/hr', 'c', 'Let the speed of the slower train be x m/sec.\r\nThen, speed of the faster train = 2x m/sec.\r\nRelative speed = (x + 2x) m/sec = 3x m/sec.\r\n 	(100 + 100)/8	= 3x\r\n	   \r\n  24x = 200\r\n  x =	25/3	.\r\n		\r\nSo, speed of the faster train =	50/3	m/sec\r\n		\r\n   =	 	50/3	x	18/5	 km/hr\r\n			\r\n   = 60 km/hr.\r\n'),
(8, 'A hollow iron pipe is 21 cm long and its external diameter is 8 cm. If the thickness of the pipe is 1 cm and iron weighs 8 g/cm3, then the weight of the pipe is:', 1, 3, '3.6 kg', '3.696 kg', '36 kg', '36.9 kg', 'b', 'External radius = 4 cm,\r\nInternal radius = 3 cm.\r\nVolume of iron	=	 	22/7	x [(4)2 - (3)2] x 21	 cm3\r\n	\r\n\r\n	=	 	22/7	x 7 x 1 x 21	 cm3\r\n				\r\n\r\n	= 462 cm3.\r\n  Weight of iron = (462 x 8) gm = 3696 gm = 3.696 kg.\r\n'),
(9, 'What will be the ratio between ages of Sam and Albert after 5 years?\r\n1.Sam''s present age is more than Albert''s present age by 4 years.\r\n2.Albert''s present age is 20 years.\r\n3.The ratio of Albert''s present age to Sam''s present age is 5 : 6.\r\n', 2, 2, 'Any two of I, II and III', 'II only', 'III only', 'I or III only', 'a', 'Clearly, any two of the given statements will give the answer and in each case, the third is redundant.\r\n  Correct answer is (A).\r\n'),
(10, 'In a certain store, the profit is 320% of the cost. If the cost increases by 25% but the selling price remains constant, approximately what percentage of the selling price is the profit?', 1, 2, '30%', '70%', '100%', '250%', 'b', 'Let C.P.= Rs. 100. Then, Profit = Rs. 320, S.P. = Rs. 420.\r\nNew C.P. = 125% of Rs. 100 = Rs. 125\r\nNew S.P. = Rs. 420.\r\nProfit = Rs. (420 - 125) = Rs. 295.\r\n  Required percentage =	 	295/420	x 100	 %	=	1475/21	% = 70% (approximately).\r\n						\r\n'),
(11, 'A can do a certain work in the same time in which B and C together can do it. If A and B together could do it in 10 days and C alone in 50 days, then B alone could do it in:', 1, 2, '15 days', '20 days', '25 days', '30 days', 'c', '(A + B)''s 1 day''s work =	1/10\r\n	\r\nC''s 1 day''s work =	1/50\r\n	\r\n(A + B + C)''s 1 day''s work =	 	1/10	+	1/50	 	=	6/50	=	3/25	. .... (i)\r\n				\r\nA''s 1 day''s work = (B + C)''s 1 day''s work .... (ii)\r\nFrom (i) and (ii), we get: 2 x (A''s 1 day''s work) =	3/25\r\n	\r\n  A''s 1 day''s work =	3/50	.\r\n	\r\n  B''s 1 day''s work	 	1/10	-	3/50	 	=	2/50	=	1/25	.\r\nSo, B alone could do the work in 25 days.\r\n'),
(12, 'X can do a piece of work in 40 days. He works at it for 8 days and then Y finished it in 16 days. How long will they together take to complete the work?', 1, 2, '13	(1/3)	days', '20 days', '26 days', '30 days', 'a', 'Work done by X in 8 days =	 	1	x 8	 	=	1	.\r\n		40				5	\r\nRemaining work =	 	1 -	1	 	=	4	.\r\n			5			5	\r\nNow,	4/5	work is done by Y in 16 days.\r\n		\r\nWhole work will be done by Y in	 	16 x	5	 	= 20 days.\r\n			4		\r\n  X''s 1 day''s work =	1	, Y''s 1 day''s work =	1	.\r\n	40		20	\r\n(X + Y)''s 1 day''s work =	 	1/40	+	1/20	 	=	3/40	.\r\n			\r\nHence, X and Y will together complete the work in	 	40	 	= 13	1	days.\r\n		3			3	\r\n'),
(13, 'What will be the fraction of 20%', 1, 1, '1/4', '1/5', '1/10', 'none of these', 'b', ''),
(14, 'What will be the fraction of 4%', 1, 1, '1/20', '1/50', '1/75', '1/25', 'd', ''),
(15, 'Evaluate \r\n?6084\r\n', 1, 1, '75', '70', '78', '86', 'c', ''),
(16, 'Find the HCF of 54, 288, 360', 1, 1, '18', '36', '54', '8', 'a', ''),
(17, 'Q) The train will leave at 8.30 pm, we "have been" ready by 7.30 pm so that we can reach the station. ', 2, 2, 'should have', 'are', 'must be', 'were', 'c', ''),
(18, 'Each sentence below is divided into three parts as three options. Point out the part with an error. If there is no error, choose the option no error.\r\n\r\nQ) He was told that the faults were basically mechanics in nature. \r\n\r\n', 2, 2, '. He was told that', '. the faults were basically', 'mechanics in nature', 'No error', 'c', 'He was told that the faults were basically mechanical in nature.'),
(19, 'Find the number, when 15 is subtracted from 7 times the number, the result is 10 more than twice of the number', 1, 3, '5', '3', '1', '0', 'a', ''),
(20, 'Q)  I can seem naive', 2, 2, '. I can', 'seem', 'naive', 'error', 'a', ' I may seem naive. '),
(21, 'Q)Grand Central Terminal, Park Avenue, New York is the world''s', 2, 3, 'largest railway station', 'highest railway station', 'longest railway station', 'None of the above', 'a', ''),
(22, 'Raju age after 15 years will be 5 times his age 5 years back, What is the present age of Raju', 1, 3, '11', '45', '10', '30', 'c', ''),
(23, 'The ratio between the present ages of P and Q is 6:7. If Q is 4 years old than P, what will be the ratio of the ages of P and Q after 4 years', 1, 3, '7:8 ', '7:9', '3:8 ', '5:8', 'a', ''),
(24, 'A train running at the speed of 60 km/hr crosses a pole in 9 seconds. What is the length of the train?', 1, 2, '120 m', '180 m', '324 m', '150 m', 'd', 'Speed= 		60 x 	5/18	m/sec 	= 		50/3 	m/sec.\r\n\r\n\r\nLength of the train = (Speed x Time) = 		50 /3	x 9 	m = 150 m'),
(25, 'The length of the bridge, which a train 130 metres long and travelling at 45 km/hr can cross in 30 seconds, is:', 1, 3, '225', '250', '245', '300', 'c', 'Speed = 		45 x 	5 	m/sec 	= 		25 	m/sec.\r\n                                         18 	                                                                   2\r\n\r\nTime = 30 sec.\r\n\r\nLet the length of bridge be x metres.\r\n\r\nThen, 	130 + x 	= 	25\r\n                   30 	2\r\n\r\n2(130 + x) = 750\r\n\r\nx = 245 m.\r\n'),
(26, 'A can do a work in 15 days and B in 20 days. If they work on it together for 4 days, then the fraction of the work that is left is :', 1, 2, '1/4', '1/10', '7/15', '8/15', 'd', 'A''s 1 day''s work = 	1/15\r\n\r\nB''s 1 day''s work = 	1/20\r\n\r\n(A + B)''s 1 day''s work = 	( 	1 /15	+ 	1 /20	) 	= 	7 /60	.\r\n                                                                 	                 	                             \r\n\r\n(A + B)''s 4 day''s work = 	( 	7 /60	x 4 	) 	= 	7 /15\r\n\r\nTherefore, Remaining work = 	( 	1 - 	7 /15	) 	= 	8 /15	.'),
(27, 'In order to obtain an income of Rs. 650 from 10% stock at Rs. 96, one must make an investment of:', 1, 3, '3240', '8000', '6550', '6240', 'd', 'o obtain Rs. 10, investment = Rs. 96.\r\n\r\nTo obtain Rs. 650, investment = Rs. 		96 /10	x 650 		= Rs. 6240\r\n'),
(28, ' What was the day of the week on 20 may, 1985 ?', 1, 3, 'monday', 'friday', 'thursday', 'tuesday', 'a', 'Here Number of odd days in 1600 years = 0\r\n\r\nNumber of odd days in 300 years from 1600 to 1900 = 5*3 = 2 week + 1 odd day= 1 odd day\r\n\r\nNumber of odd days in 84 years= 21 leap year + 63 days = 21*2 + 63*1 = 105 days = 0 odd days\r\n\r\nNumber of odd days in 20 may = 31 days of Jan. + 28 days of feb + 31 days of mar. + 30 days in april + 20 days in may = 140 days = 0 odd day\r\n\r\nSo total number of odd days = 0+1+0+0=1 = Monday\r\n                                                                     \r\n'),
(29, 'Q) One of the warmest winters on record has put consumers in the mood to spend money. Spending is likely to be the strongest in thirteen years. During the month of February, sales of existing single-family homes hit an annual record rate of 4.75 million.\r\n \r\nThis paragraph best supports the statement that', 2, 3, 'consumer spending will be higher thirteen years fr', 'more people buy houses in the month of February th', 'warm winter weather is likely to affect the rate o', 'there were about 4 million homes for sale during t', 'c', 'This is clearly the best answer because the paragraph directly states that warm weather affects consumers inclination to spend. It furthers states that the sales of single-family homes was at an all-time high. There is no support for choice a or b. Choice b is wrong because even though there were high sales for a particular February, this does not mean that sales are not higher in other months. Choice d presents a misleading figure of 4 million. The paragraph states that the record of 4.75 million was at an annual, not a monthly, rate. '),
(30, 'Today is tuesday. After 72 days, it will be ?', 1, 3, 'after 74 days', 'after 72 days', 'after 84 days', 'after 70 days', 'b', ' Tuesday will be repeated after each 7 days so, after at 70 day it will also be tuesday, so at 72 th day it will be friday'),
(31, 'Q) Choose the word which is most nearly the OPPOSITE in meaning as the word given??\r\n\r\nINEVITABLY ', 2, 2, ' Expectedly', 'Certainly', 'Mostly', ' Avoidably', 'd', ''),
(32, 'What was the day of the week on 28th May, 2006?', 1, 3, 'tuesday', 'monday', 'friday', 'sunday', 'd', '28 May, 2006 = (2005 years + Period from 1.1.2006 to 28.5.2006)\r\n\r\nOdd days in 1600 years = 0\r\n\r\nOdd days in 400 years = 0\r\n\r\n5 years = (4 ordinary years + 1 leap year) = (4 x 1 + 1 x 2) 6 odd days\r\n\r\nJan.  Feb.   March    April    May \r\n(31 +  28  +  31   +   30   +   28 ) = 148 days\r\n\r\n148 days = (21 weeks + 1 day) 1 odd day.\r\n\r\nTotal number of odd days = (0 + 0 + 6 + 1) = 7 0 odd day.\r\n\r\nGiven day is Sunday.	\r\n'),
(33, 'Brothers and sisters have I none, but that mans father is my fathers son. Who is that man?', 2, 2, 'your son', 'your nephew', 'your daughter', 'your causin', 'a', ''),
(34, '3, 5, 11, 14, 17, 21', 1, 1, '21', '14', '17', '3', 'b', '\r\nEach of the numbers except 14 is an odd number.\r\n\r\nThe number ''14'' is the only EVEN number.\r\n'),
(35, '\r\n396, 462, 572, 427, 671, 264', 1, 3, '462', '396', '427', '671', 'c', 'In each number except 427, the middle digit is the sum of other two.'),
(36, 'find odd one\r\n6, 9, 15, 21, 24, 28, 30', 1, 1, '6', '28', '24', '21', 'b', 'Each of the numbers except 28, is a multiple of 3.\r\n'),
(37, 'Find the greatest number that will divide 43, 91 and 183 so as to leave the same remainder in each case.', 1, 1, '4', '9', '7', '8', 'a', ' Required number = H.C.F. of (91 - 43), (183 - 91) and (183 - 43)= H.C.F. of 48, 92 and 140 = 4.'),
(38, 'The H.C.F. of two numbers is 23 and the other two factors of their L.C.M. are 13 and 14. The larger of the two numbers is:', 1, 2, '422', '22', '322', '600', 'c', ' Clearly, the numbers are (23 x 13) and (23 x 14).Larger number = (23 x 14) = 322.'),
(39, 'Six bells commence tolling together and toll at intervals of 2, 4, 6, 8 10 and 12 seconds respectively. In 30 minutes, how many times do they toll together ?', 1, 3, '15', '10', '16', '9', 'c', 'L.C.M. of 2, 4, 6, 8, 10, 12 is 120.So, the bells will toll together after every 120 seconds(2 minutes).In 30 minutes, they will toll together\r\n30/2+1=16 time'),
(40, 'Let N be the greatest number that will divide 1305, 4665 and 6905, leaving the same remainder in each case. Then sum of the digits in N is:', 1, 2, '4', '5', '6', '8', 'a', ' H.C.F. of (4665 - 1305), (6905 - 4665) and (6905 - 1305)= H.C.F. of 3360, 2240 and 5600 = 1120.\r\nSum of digits in N = ( 1 + 1 + 2 + 0 ) = 4'),
(41, 'The greatest number of four digits which is divisible by 15, 25, 40 and 75 is:', 1, 2, '9800', '8806', '9600', '9000', 'c', 'Greatest number of 4-digits is 9999.L.C.M. of 15, 25, 40 and 75 is 600.On dividing 9999 by 600, the remainder is 399.\r\nRequired number (9999 - 399) = 9600.'),
(42, '\r\nWhich one of the following is not a prime number?', 1, 1, '91', '71', '31', '61', 'a', '91 is divisible by 7. So, it is not a prime number.'),
(43, '\r\nA boat can travel with a speed of 13 km/hr in still water. If the speed of the stream is 4 km/hr, find the time taken by the boat to go 68 km downstream.', 1, 1, '3 hours', '4 hours', '2 hours', '5 hours', 'b', 'Speed downstream = (13 + 4) km/hr = 17 km/hr.Time taken to travel 68 km downstream=(68 /17	)hrs = 4 hrs.'),
(44, 'A man''s speed with the current is 15 km/hr and the speed of the current is 2.5 km/hr. The man''s speed against the current is:', 1, 3, '10 km/hr', '18.5 km/hr', '16.5 km/hr', '17 km/hr', 'a', 'Man''s rate in still water = (15 - 2.5) km/hr = 12.5 km/hr. Man''s rate against the current = (12.5 - 2.5) km/hr = 10 km/hr.\r\n'),
(45, 'In one hour, a boat goes 11 km/hr along the stream and 5 km/hr against the stream. The speed of the boat in still water (in km/hr) is:', 1, 2, '3 km/hr', '5 km/hr', '8 km/hr', '9 km/hr', 'c', 'Speed in still water = (11 + 5)/2 kmph = 8 kmph.\r\n'),
(46, 'A boat running downstream covers a distance of 16 km in 2 hours while for covering the same distance upstream, it takes 4 hours. What is the speed of the boat in still water?', 1, 3, '6km/hr', '7km/hr', '8km/hr', '1km/hr', 'a', 'Rate downstream = (16/2)kmph = 8 kmph.\r\n             Rate upstream = (16/4) kmph = 4 kmph.\r\n             Speed in still water =(8 + 4)/2 kmph = 6 kmph.'),
(47, '\r\nThe speed of a boat in still water in 15 km/hr and the rate of current is 3 km/hr. The distance travelled downstream in 12 minutes is:', 1, 2, '3.6 km', '4.2 km', '5km', ' 3 km', 'a', 'Speed downstream = (15 + 3) kmph = 18 kmph.\r\n             Distance travelled =(18x12)/60 km = 3.6 km.'),
(48, 'Ten years ago, P was half of Q in age. If the ratio of their present ages is 3:4, what will be the total of their present ages?', 1, 3, '30', '35', '25', '40', 'b', 'Let the present age of P and Q be 3x and 4x respectively.\r\n\r\n\r\n\r\nTen years ago, P was half of Q in age\r\n\r\n=> (3x – 10) = ½ (4x – 10)\r\n\r\n=> 6x – 20 = 4x – 10\r\n\r\n=> 2x = 10\r\n\r\n=> x = 5\r\n\r\n\r\n\r\ntotal of their present ages = 3x + 4x = 7x = 7 × 5 = 35\r\n'),
(49, 'A man''s age is 125% of what it was 10 years ago, but 83 1/3 % of what it will be after ten 10 years. What is his present age?\r\n', 1, 2, '50', '60', '10', '30', 'a', 'Let the age before 10 years = x\r\n\r\nThen 125x/100 = x + 10\r\n\r\n=>125x = 100x + 1000\r\n\r\n=> x = 1000/25 = 40\r\n\r\n\r\n\r\nPresent age = x + 10 = 40 +10 = 50\r\n'),
(50, 'The present ages of A,B and C are in proportions 4 : 7 : 9. Eight years ago, the sum of their ages was 56. What are their present ages (in years)?\r\n', 1, 2, 'Insufficient data', '16,28,30', '16, 28, 36', '16, 32,20', 'c', 'Let''s take the present age of A,B and C as 4x, 7x and 9x respectively\r\n\r\nThen\r\n\r\n(4x - 8) + (7x – 8) + (9x – 8) = 56\r\n\r\n=> 20x = 80\r\n\r\n=> x = 4\r\n\r\nHence the present age of A, B and C are 4×4, 7×4 and 9×4 respectively \r\n\r\nie, 16,28 and 36 respectively.\r\n'),
(51, 'If the length of a rectangle is halved and its breadth is tripled, what is the percentage change in its area?\r\n', 1, 3, '25 % Increase', '25 % decrease', '50 % Increase', '50 % decrease', 'c', 'Let original length = 100 and original breadth = 100\r\nThen original area = 100 × 100 = 10000\r\n\r\nLength of the rectangle is halved?\r\nNew length = Original length/2=100/2=50\r\nbreadth is tripled?\r\nNew breadth= Original breadth×3=100×3=300\r\nNew area = 50 × 300 = 15000\r\n\r\n\r\n\r\nIncrease in area = New Area - Original Area = 15000 - 10000= 5000\r\n\r\nPercentage of Increase in area = Increase in Area/Original Area×100=5000/10000×100=50%'),
(52, ' A rectangular parking space is marked out by painting three of its sides. If the length of the unpainted side is 9 feet, and the sum of the lengths of the painted sides is 37 feet, find out the area of the parking space in square feet?', 1, 3, '126 sq. ft.', '64 sq. ft.', '100 sq. ft.', '130 sq. ft.', 'a', 'Let l = 9 ft.\r\n\r\nThen l + 2b = 37\r\n=> 2b = 37 - l = 37 - 9 = 28\r\n=> b = 28/2 = 14 ft.\r\n\r\nArea = lb = 9 × 14 = 126 sq. ft.\r\n'),
(53, ' On what dates of April, 2001 did Wednesday fall?\r\n', 1, 3, '2nd, 9th, 16th, 23rd', '4th, 11th, 18th, 25th', ' 3rd, 10th, 17th, 24th', '1st, 8th, 15th, 22nd, 29th', 'b', 'We need to find out the day of 01-Apr-2001\r\n\r\n\r\n01-Apr-2001 = (2000 years + period from 1-Jan-2001 to 01-Apr-2001)\r\n\r\n\r\nWe know that number of odd days in 400 years = 0\r\n\r\nHence the number of odd days in 2000 years = 0 (Since 2000 is a perfect multiple of 400)\r\n\r\n\r\nDays from 1-Jan-2001 to 01-Apr-2001 = 31 (Jan) + 28 (Feb) + 31 (Mar) + 1(Apr) = 91\r\n\r\n91 days = 13 weeks = 0 odd day\r\n\r\n\r\nTotal number of odd days = (0 + 0) = 0 odd days\r\n\r\n\r\n0 odd day = Sunday. Hence 01-Apr-2001 is Sunday.\r\n\r\n\r\nHence first Wednesday of Apr 2011 comes in 04th and successive Wednesdays\r\n\r\ncome in 11th, 18th and 25th\r\n'),
(54, 'An accurate clock shows 8 o''clock in the morning. Through how may degrees will the hour hand rotate when the clock shows 2 o''clock in the afternoon?', 1, 3, '154°', '180°', '170°', '160°', 'b', 'We know that Angle traced by hour hand in 12 hrs = 360° \r\n\r\nFrom 8 to 2, there are 6 hours\r\nThe angle traced by the hour hand in 6 hours = 6×360/12=180°\r\n'),
(55, ' A bag contains 2 yellow, 3 green and 2 blue balls. Two balls are drawn at random. What is the probability that none of the balls drawn is blue?', 1, 1, '1/2	', ' 10/21', '9/11', '7/11', 'b', 'Total number of balls = 2 + 3 + 2 = 7\r\n\r\nLet S be the sample space.\r\nn(S) = Total number of ways of drawing 2 balls out of 7 = 7C2\r\n\r\nLet E = Event of drawing 2 balls , none of them is blue.\r\n\r\nn(E) = Number of ways of drawing 2 balls , none of them is blue\r\n= Number of ways of drawing 2 balls from the total 5 (=7-2) balls = 5C2\r\n(? There are two blue balls in the total 7 balls. Total number of non-blue balls = 7 - 2 = 5)\r\n\r\nP(E) = n(E)/n(S)=5C2/7C2=(5×4/2×1)(7×6/2×1)=5×4/7×6=10/21'),
(56, 'A sum of money at simple interest amounts to Rs. 815 in 3 years and to Rs. 854 in 4 years. The sum is :', 1, 1, '700', '800', '850', '698', 'd', 'Simple Interest (SI) for 1 year = 854-815 = 39\r\n\r\nSimple Interest (SI) for 3 years = 39 × 3 = 117\r\n\r\nPrincipal = 815 - 117 = Rs.698'),
(57, 'The total of the ages of Amar, Akbar and Anthony is 80 years. What was the total of their ages three years ago ?', 1, 2, '71', '73', '72', '76', 'a', 'Required sum = (80 - 3 x 3) years = (80 - 9) years = 71 years.'),
(58, '\r\nFind the odd man out	6, 9, 15, 21, 24, 28, 30\r\n', 1, 1, '28', '21', '24', '30', 'a', 'Each of the numbers except 28, is a multiple of 3.'),
(59, 'The simple interest and the true discount on a certain sum for a given time and at a given rate are Rs. 85 and Rs. 80 respectively. The sum is:', 1, 2, '1800', '1450', '1360', '8000', 'c', 'Sum =	S.I. x T.D.	=	85 x 80	= Rs. 1360.\r\n	(S.I.) - (T.D.)		(85 - 80)	\r\n'),
(60, '4.2 x 4.2 - 1.9 x 1.9	is equal to:\r\n2.3 x 6.1	\r\n', 1, 1, '0.5', '1.0', '22', '20', 'b', 'Given Expression =	(a2 - b2)	=	(a2 - b2)	= 1.\r\n	               (a + b)(a - b)		(a2 - b2)	\r\n\r\n'),
(61, '125,80,45,20,?', 1, 2, '5', '6', '7', '8', 'a', 'The pattern is - 45, - 35, - 25, .....So, missing term = 20 - 15 = 5.'),
(62, '2, 3, 5,7,11,?, 17', 1, 2, '12', '13', '14', '15', 'b', 'Clearly, the given series consists of prime numbers starting from 2. So, the missing term is the prime number after 11, which is 13.\r\n'),
(63, ' 2, 3, 3, 5, 10, 13, ?, 43, 172, 177?', 1, 1, '28', '38', '39', '40', 'c', 'The pattern is + 1, x 1, + 2, x 2, + 3, x 3, + 4, x 4, + 5.So, missing term = 13 x 3 = 39.\r\n'),
(64, 'Which of the following will not be a number of the series 1, 8, 27, 64, 125,.....?', 1, 1, '45', '52', '54', '55', 'c', 'The given sequence is a combination of two series: I. 13, 24, 35, 46, 57 and II. 32, 43, ?, 65, 76\r\nThe pattern in both I and II is + 11. So, missing term = 43 + 11 = 54.'),
(65, 'Q) Choose the word which is most nearly the SAME in meaning as the word given\r\n\r\nARDUOUS\r\n', 2, 2, 'Different', 'Hazardous', 'Difficult', 'Pleasurable', 'c', ''),
(66, 'Q) Which of the phrases (A), (B), (C) and  given below each sentence should replace the word/phrase printed in bold in the sentence to make it grammatically correct ? If the sentence is correct as it is given and no correction is required, leave it.\r\n\r\n Since the girl did not want to be disturbed while studying, she left the phone "off hooks".', 2, 2, 'of hook', 'off hooking', 'for the hook', 'off the hook', 'd', ''),
(67, 'Q) Choose the word which is most nearly the SAME in meaning as the word given\r\n DEGRADING ', 2, 2, ' Demeaning', 'Lowering', 'Corrupting', 'Minimizing', 'b', ''),
(68, 'Q) Choose the word which is most nearly the OPPOSITE in meaning as the word given\r\n\r\n VIABLE ', 2, 2, ' Rudimentary', 'Practical', 'Negative', ' Impossible', 'd', ''),
(69, '\r\n\r\nOn what date of Feb. 2007 did Saturday fall ?', 1, 3, ' 3.2.2007', ' 3.5.2007', ' 8.2.2007', ' 10.2.2007', 'a', 'For this find the day of 1.2.2007\r\n\r\n1600+400 years has 0 odd days\r\n\r\nFrom 2001 to 2006 there are 1 leap years + 5 ordinary years\r\n\r\nSo number of odd days = 1*2 + 5*1 = 2 + 5 = 7 = 1 week = 0 odd day\r\n\r\nNow from 1.1.2007 to 1.2.2007 number of days = 32 = 4 weeks + 4 odd days = 4 odd days\r\n\r\nSo, total number of odd days = 4, so 1.2.2007 will be thrusday\r\n\r\nNow saturday will be on 3.2.2007'),
(70, 'Q) Despite having passed out from school over ten years back, most schoolmates" has keep touch" with each other. \r\n', 2, 2, ' had kept in touch  ', '  keep touched   ', 'is keeping touch', ' are kept touched', 'a', ''),
(71, 'Q) Since the officer was overburdened with work, her colleague decided to "gave her hand"?', 2, 2, '  giving hands', 'give her a hand', 'giving her handful', 'gave her hands', 'b', ''),
(72, 'HCF of \r\n\r\n22×32×52,24×34×53×11\r\n', 1, 2, '24×34×53', '	24×34×53×11 ', '22×32×52 ', '2×3×5', 'c', ''),
(73, 'Simplfy \r\nb - [b -(a+b) - {b - (b - a+b)} + 2a]\r\n', 1, 1, 'a', '2a', '4a', '0', 'd', ''),
(74, 'Q)  Sleep is a necessity thing for us.', 2, 2, 'Sleep is ', 'a necessity', 'thing for us.', 'No error', 'b', 'Sleep is a necessary thing for us.'),
(75, '5004 / 139 - 6', 1, 1, '60', '20', '30', '10', 'c', ''),
(76, 'find the number, difference between number and its 3/5 is 50.', 1, 3, '120', '125', '130', '128', 'b', ''),
(77, 'Q)Entomology is the science that studies', 2, 3, 'Behavior of human beings', 'Insects', 'The origin and history of technical and scientific', 'The formation of rocks', 'b', ''),
(78, 'Q) Eritrea, which became the 182nd member of the UN in 1993, is in the continent of\r\n\r\n', 2, 3, 'ASIA', 'AFRICA', 'EUROPE', 'AUSTRALIA', 'b', ''),
(84, 'Q) Choose the word which is most nearly the SAME in meaning as the word given?\r\nTRANSITIONAL ', 2, 2, 'Extreme', 'Intermediate', 'Revolutionary', 'Changed', 'b', ''),
(86, '', 0, 0, '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbresult`
--

CREATE TABLE IF NOT EXISTS `tbresult` (
  `id` int(11) NOT NULL,
  `qid` int(10) NOT NULL,
  `answer` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbscore`
--

CREATE TABLE IF NOT EXISTS `tbscore` (
  `id` int(11) NOT NULL,
  `rno` varchar(10) NOT NULL,
  `cid` int(11) NOT NULL,
  `lid` int(11) NOT NULL,
  `net` double NOT NULL,
  `correct` int(11) NOT NULL,
  `incorrect` int(11) NOT NULL,
  `unattempted` int(11) NOT NULL,
  `percentage` double NOT NULL,
  `accuracy` double NOT NULL,
  `pattempt` double NOT NULL,
  `date` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbscore`
--

INSERT INTO `tbscore` (`id`, `rno`, `cid`, `lid`, `net`, `correct`, `incorrect`, `unattempted`, `percentage`, `accuracy`, `pattempt`, `date`, `time`) VALUES
(1, 'c012349', 2, 2, 4, 4, 0, 1, 80, 100, 80, 'Jul 21', '16:00'),
(2, 'c012349', 2, 2, 5, 5, 0, 0, 100, 100, 100, 'Jul 21', '16:01'),
(3, 'c012349', 2, 2, 2.75, 3, 1, 1, 55, 75, 80, 'Jul 21', '16:07'),
(4, 'c012349', 1, 1, 0, 1, 4, 0, 0, 20, 100, 'Jul 21', '16:08'),
(5, 'c012349', 2, 2, 4, 4, 0, 1, 80, 100, 80, 'Jul 21', '17:48'),
(6, 'c012349', 1, 1, 0.75, 1, 1, 3, 15, 50, 40, 'Jul 23', '14:31'),
(7, 'c012349', 2, 2, 4, 4, 0, 1, 80, 100, 80, 'Jul 23', '14:45'),
(8, 'c012349', 2, 2, 5, 5, 0, 0, 100, 100, 100, 'Jul 24', '20:18'),
(9, 'c012349', 2, 2, 1, 1, 0, 4, 20, 100, 20, 'Jul 24', '22:25');

-- --------------------------------------------------------

--
-- Table structure for table `tbstud`
--

CREATE TABLE IF NOT EXISTS `tbstud` (
  `id` int(11) NOT NULL,
  `rno` varchar(8) NOT NULL,
  `name` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `branch` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbstud`
--

INSERT INTO `tbstud` (`id`, `rno`, `name`, `contact`, `branch`, `email`, `username`, `password`) VALUES
(1, 'c012349', 'Saumya', '9478798815', 'CSE', 'saumya@gmail.com', 'saumya', 'ss947'),
(2, 'c012325', 'manav', '9569910102', 'cse', 'manavk@gmail.com', 'manav', 'mk956'),
(3, 'c012348', 'sapna', '9878765857', 'cse', 'sapnab@gmail.com', 'sapna', 'sb987'),
(6, 'CO12333', 'Nehal', '9876543', 'CSE', 'nehal@gmail.com', 'nehal', 'swarup'),
(7, 'c012323', 'Kritika', '9476786655', 'cse', 'kritika@gmail.com', 'kritika', 'ks947'),
(10, 'c013513', 'Barkha', '9988073652', 'ece', 'barkha@gmail.com', 'barkha', 'ba988'),
(11, 'c012343', 'Rushil', '7868798877', 'cse', 'rushil@gmail.com', 'rushil', 'rs868'),
(12, '', '', '', '', '', '', ''),
(13, '', '', '', '', '', '', ''),
(14, 'c012355', 'tavleen', '9878767654', 'cse', 'tavleen@gmail.com', 'tavleeen', 'tk987'),
(15, '', '', '', '', '', '', ''),
(16, '', '', '', '', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbcat`
--
ALTER TABLE `tbcat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tblevel`
--
ALTER TABLE `tblevel`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbques`
--
ALTER TABLE `tbques`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbresult`
--
ALTER TABLE `tbresult`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbscore`
--
ALTER TABLE `tbscore`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbstud`
--
ALTER TABLE `tbstud`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbcat`
--
ALTER TABLE `tbcat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tblevel`
--
ALTER TABLE `tblevel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbques`
--
ALTER TABLE `tbques`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=87;
--
-- AUTO_INCREMENT for table `tbresult`
--
ALTER TABLE `tbresult`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbscore`
--
ALTER TABLE `tbscore`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `tbstud`
--
ALTER TABLE `tbstud`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
