create database crudhm;
use crudhm;

create table Musica(
	musicaID INT primary key,
    titulo varchar(255),
    album varchar(255),
    artista varchar(255)
);

create table Artista(
	artistaID INT primary key auto_increment,
    ArtistaNome varchar(255),
    idade INT
);

create table Gravadora(
	gravadoraID INT primary key auto_increment,
    gravadoraNome varchar(255),
    propriedade varchar(255)
);