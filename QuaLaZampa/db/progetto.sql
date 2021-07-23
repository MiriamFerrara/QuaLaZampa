create schema progetto;
use progetto;
create table prodotti (
id_prodotto int primary key auto_increment,
nome varchar (50) not null,
disponibilita enum ("SI", "NO") not null,
quantita int default 0,
iva_prodotti float default 0.22,
descrizione varchar (700) not null,
prezzo_base float default 0,
pat varchar(500) not null
);

insert into prodotti (nome, disponibilita, quantita, descrizione, prezzo_base, pat) values ("Purina crocchette cane", "SI", 500, "crocchette a manzo per cane da 2kg", 14.55, "C:\\Users\\utente\\Desktop\\TSW progetto\\QuaLaZampa\\Esercizio_Ferrara_Schettino_Ceccarelli\\WebContent\\image\\Purina_crocchette_cane.png");
insert into prodotti (nome, disponibilita, quantita, descrizione, prezzo_base, pat) values ("Purina crocchette gatto", "SI", 500, "crocchette al pollo per gatti da 2kg", 14.55, "C:\\Users\\utente\\Desktop\\TSW progetto\\QuaLaZampa\\Esercizio_Ferrara_Schettino_Ceccarelli\\WebContent\\image\\Purina_crocchette_gatto.png");
insert into prodotti (nome, disponibilita, quantita, descrizione, prezzo_base, pat) values ("Cuccia per gatto", "SI", 500, "Cuccia per gatto Small 47x13cm", 10.25, "C:\\Users\\utente\\Desktop\\TSW progetto\\QuaLaZampa\\Esercizio_Ferrara_Schettino_Ceccarelli\\WebContent\\image\\Cuccia_per_gatto.jpg");
insert into prodotti (nome, disponibilita, quantita, descrizione, prezzo_base, pat) values ("Salviette detergenti", "SI", 500, "Salviette detergenti zampe cane", 3.99, "C:\\Users\\utente\\Desktop\\TSW progetto\\QuaLaZampa\\Esercizio_Ferrara_Schettino_Ceccarelli\\WebContent\\image\\Salviette_detergenti_per_animali.jpg");
insert into prodotti (nome, disponibilita, quantita, descrizione, prezzo_base, pat) values ("Altalena per uccelli", "SI", 500, "Altalena in legno per uccelli", 5.85, "C:\\Users\\utente\\Desktop\\TSW progetto\\QuaLaZampa\\Esercizio_Ferrara_Schettino_Ceccarelli\\WebContent\\image\\altalenaBird.jpg");
insert into prodotti (nome, disponibilita, quantita, descrizione, prezzo_base, pat) values ("Gioco per  Uccelli", "SI", 500, "Gioco per Uccelli in Legno con scaletta", 10.35, "C:\\Users\\utente\\Desktop\\TSW progetto\\QuaLaZampa\\Esercizio_Ferrara_Schettino_Ceccarelli\\WebContent\\image\\Attrezzi_Pappagalli.jpg");
insert into prodotti (nome, disponibilita, quantita, descrizione, prezzo_base, pat) values ("Casetta Coniglio", "SI", 500, "Casetta per Coniglio in legno", 37.99, "C:\\Users\\utente\\Desktop\\TSW progetto\\QuaLaZampa\\Esercizio_Ferrara_Schettino_Ceccarelli\\WebContent\\image\\casetta_legno_coniglio.jpg");
insert into prodotti (nome, disponibilita, quantita, descrizione, prezzo_base, pat) values ("Gabbia per criceti", "SI", 500, "Gabbia per criceti size 49x34x42cm", 20.63, "C:\\Users\\utente\\Desktop\\TSW progetto\\QuaLaZampa\\Esercizio_Ferrara_Schettino_Ceccarelli\\WebContent\\image\\GabbiaCriceti.jpg");

create table cliente (
username varchar(25) not null,
id_cliente int primary key auto_increment,
e_mail varchar (25) not null,
password varchar (50) not null,
amministratore enum ("SI", "NO") not null
);

insert into cliente (username, e_mail, password, amministratore) values ("Alfonso", "a@gmail.com", "admin1", "SI");
insert into cliente (username, e_mail, password, amministratore) values ("Sabrina", "s@gmail.com", "admin2", "NO");
insert into cliente (username, e_mail, password, amministratore) values ("Miriam", "m@gmail.com", "admin3", "NO");

create table dati_anagrafici (
nome varchar(25) not null,
cognome varchar(25) not null,
telefono varchar(25) not null,
cf varchar (50) primary key,
id_cliente_dati int,
foreign key (id_cliente_dati) references cliente (id_cliente) ON DELETE SET NULL ON UPDATE CASCADE
);

insert into dati_anagrafici values ("Luigi", "Greco", "081123456", "LG15P9KUP", 1);
insert into dati_anagrafici values ("Sabrina", "Ceccarelli", "389557419", "CR145PK79S9", 2);
insert into dati_anagrafici values ("Miriam", "Ferrara", "0818745983", "TV45GT74T7", 3);

create table indirizzo_spedizione (
via varchar(50) not null,
id_spedizione int primary key auto_increment,
citta varchar(25) not null,
provincia varchar(25) not null,
cap varchar(25) not null,
 id_cliente_indirizzo int,
 foreign key (id_cliente_indirizzo) references cliente (id_cliente) ON DELETE SET NULL ON UPDATE CASCADE
);

insert into indirizzo_spedizione (via, citta, provincia, cap, id_cliente_indirizzo) values ("via Garibaldi n.19", "Pompei", "Napoli", "80045", 2);
insert into indirizzo_spedizione (via, citta, provincia, cap, id_cliente_indirizzo) values ("via Giuseppe Verdi n.15", "Fisciano", "Salerno", "8084", 3);

create table acquista (
id_cliente_acquista int,
id_prodotto_acquista int,
foreign key (id_cliente_acquista) references cliente (id_cliente) ON DELETE SET NULL ON UPDATE CASCADE,
foreign key (id_prodotto_acquista) references prodotti (id_prodotto) ON DELETE SET NULL ON UPDATE CASCADE
);

create table ordine (
id_ordine int primary key auto_increment,
prezzo_totale float not null,
stato_ordine varchar (25) not null,
data_ordine date not null
);

insert into ordine (prezzo_totale, stato_ordine, data_ordine) values (15.69, "acquistato", '2021-07-01');
insert into ordine (prezzo_totale, stato_ordine, data_ordine) values (15.69, "acquistato", '2021-08-01');
insert into ordine (prezzo_totale, stato_ordine, data_ordine) values (15.69, "acquistato", '2021-09-01');
insert into ordine (prezzo_totale, stato_ordine, data_ordine) values (15.69, "acquistato", '2021-10-05');
insert into ordine (prezzo_totale, stato_ordine, data_ordine) values (15.69, "acquistato", '2021-11-10');

create table effettua (
id_cliente_effettua int,
id_ordine_effettua int,
foreign key (id_cliente_effettua) references cliente (id_cliente) ON DELETE SET NULL ON UPDATE CASCADE,
foreign key (id_ordine_effettua) references ordine (id_ordine) ON DELETE SET NULL ON UPDATE CASCADE
);

create table inserito (
iva_inserito float default 0.22,
quantita_inserito int not null,
prezzo_inserito float not null,
id_prodotto_inserito int,
id_ordine_inserito int,
foreign key (id_prodotto_inserito) references prodotti (id_prodotto) ON DELETE SET NULL ON UPDATE CASCADE,
foreign key (id_ordine_inserito) references ordine (id_ordine) ON DELETE SET NULL ON UPDATE CASCADE
);

create table catalogo(

id_catalogo int auto_increment primary key,
id_prodotto_catalogo int,
informazioni varchar (700),
categoria varchar(100),
quantita_prodotto int,
foreign key (id_prodotto_catalogo) references prodotti(id_prodotto) on delete set null on update cascade

);

insert into catalogo (id_prodotto_catalogo,informazioni,categoria,quantita_prodotto) values (1,"crocchette a manzo per cane da 2kg","cane",500);
insert into catalogo (id_prodotto_catalogo,informazioni,categoria,quantita_prodotto) values (2,"crocchette al pollo per gatti da 2kg","gatto",500);
insert into catalogo (id_prodotto_catalogo,informazioni,categoria,quantita_prodotto) values (3, "Cuccia per gatto Small 47x13cm","gatto",500);
insert into catalogo (id_prodotto_catalogo,informazioni,categoria,quantita_prodotto) values (4,"Salviette detergenti zampe cane","cane",500);
insert into catalogo (id_prodotto_catalogo,informazioni,categoria,quantita_prodotto) values (5,"Altalena per uccelli","uccelli",500);
insert into catalogo (id_prodotto_catalogo,informazioni,categoria,quantita_prodotto) values (6,"Gioco per  Uccelli","uccelli",500);
insert into catalogo (id_prodotto_catalogo,informazioni,categoria,quantita_prodotto) values (7,"Casetta Coniglio","animali piccola taglia",500);
insert into catalogo (id_prodotto_catalogo,informazioni,categoria,quantita_prodotto) values (8,"Gabbia per criceti","animali piccola taglia",500);

create table pagamento(
id_pagamento int auto_increment primary key,
iva_prodotto_pagamento float not null,
info_metodo varchar(70) not null,
data_pagmento date not null,
importo float not null,
quantita_pagamento int not null,
id_ordine_pagamento int,
foreign key (id_ordine_pagamento) references ordine(id_ordine) on delete set null on update cascade
);

create table spedizione(
id_spedizione int auto_increment primary key,
data_spedizione date not null,
spese float not null,
info_metodo varchar (500) not null,
id_ordine_spedizione int,
foreign key (id_ordine_spedizione) references ordine(id_ordine) on delete set null on update cascade
);