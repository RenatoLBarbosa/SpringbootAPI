
INSERT INTO list (namelist,idplayer_idplayer,qtdcard,idcard_idcard,pricelist) VALUES ('list1',2,2,1,12.0);
INSERT INTO list (namelist,idplayer_idplayer,qtdcard,idcard_idcard,pricelist) VALUES ('list2',1,1,1,2.0);
INSERT INTO card (namecard,edition,language_idlanguage,foil,price) VALUES ('card1','edt1',2,'true',123.12);
INSERT INTO card (namecard,edition,language_idlanguage,foil,price) VALUES ('card2','edt2',2,'false','123,32');
INSERT INTO language (language) VALUES ('Ingles');
INSERT INTO language (language) VALUES ('Portugues');
INSERT INTO language (language) VALUES ('Japones');
INSERT INTO player (nameplayer) VALUES ('p1');
INSERT INTO player (nameplayer) VALUES ('p2');
COMMIT;

