/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.0.67-community-nt : Database - est
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`est` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `est`;

/*Table structure for table `game` */

DROP TABLE IF EXISTS `game`;

CREATE TABLE `game` (
  `username` varchar(100) default NULL,
  `game_id` int(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `game` */

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `email` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  `usertype` varchar(100) default NULL,
  `status` varchar(100) default 'offline',
  `id` int(100) NOT NULL auto_increment,
  `playing` int(10) default NULL,
  `high_score` int(10) unsigned default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`email`,`password`,`usertype`,`status`,`id`,`playing`,`high_score`) values ('rajat.sharma830@gmail.com','rajat','admin','online',1,1,0),('shubham@gmail.com','shubham','player','offline',2,0,4),('rajat830','rajat830','player','online',3,1,4),('player1','player1','player','online',4,0,0),('player2','player2','player','offline',5,0,0),('player3','player3','player','online',6,0,0),('player15@gmail.com','player15','player',NULL,7,0,0),('player16@gmail.com','player16','player','offline',8,0,1);

/*Table structure for table `playgame` */

DROP TABLE IF EXISTS `playgame`;

CREATE TABLE `playgame` (
  `primary_image` int(100) default NULL,
  `game_id` int(100) default NULL,
  `score` int(100) default NULL,
  `completed` int(100) default '0',
  `secondary_images_p1` varchar(100) default NULL,
  `secondary_image_p2` varchar(100) default NULL,
  `secondary_image_5` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `playgame` */

insert  into `playgame`(`primary_image`,`game_id`,`score`,`completed`,`secondary_images_p1`,`secondary_image_p2`,`secondary_image_5`) values (7,540,NULL,2,'11,3','11,3','15,13,2,11,3'),(3,6934,NULL,2,'10,6','6','10,14,6,7,1');

/*Table structure for table `registration` */

DROP TABLE IF EXISTS `registration`;

CREATE TABLE `registration` (
  `fullName` varchar(100) default NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) default NULL,
  `dateOfBirth` varchar(100) default NULL,
  `gender` varchar(100) default NULL,
  PRIMARY KEY  (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `registration` */

insert  into `registration`(`fullName`,`email`,`password`,`dateOfBirth`,`gender`) values ('player15','player15@gmail.com','player15','1998-12-12','Male'),('player16','player16@gmail.com','player16','1233-12-12','Male');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
