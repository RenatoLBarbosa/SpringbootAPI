INSERT INTO player (nameplayer) VALUES ('p1');
INSERT INTO player (nameplayer) VALUES ('p2');
INSERT INTO language (lang) VALUES ('Ingles');
INSERT INTO language (lang) VALUES ('Portugues');
INSERT INTO language (lang) VALUES ('Japones');
INSERT INTO card (namecard,edition,lang_idlang,foil,price) VALUES ('card1','edt1',2,'true','123.12');
INSERT INTO card (namecard,edition,lang_idlang,foil,price) VALUES ('card2','edt2',2,'false','123.32');
INSERT INTO lists (namelist,idplayer_idplayer,qtdcard,idcard_idcard,pricelist) VALUES ('list1',2,2,1,'12.0');
INSERT INTO lists (namelist,idplayer_idplayer,qtdcard,idcard_idcard,pricelist) VALUES ('list2',1,1,1,'2.0');
COMMIT;

