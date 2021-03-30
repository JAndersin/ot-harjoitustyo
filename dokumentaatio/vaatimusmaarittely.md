# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen tarkoitus on olla avustava graafinen työkalu strategiapeliprojektin kehityksessä. Pelissä kartta on jaettu pieniin osiin, olioihin joita kutsukaamme niitä tässä vaiheessa 'Provinsseiksi'. Provinssit yksilöidään kartasta (bittikartta) uniikkien väriarvojen perusteella ja niihin liittyen on tallennettuna tietoa muuttujina joita tallennetaan ja luetaan JSON-tiedostosta. Ongelmallista on, että pelissä täytyy kartan alkuasetelma alustaa pohjautuen kyseiseen JSON-tiedostoon ja se sisältää useita muuttujia sadoilla ellei tuhansilla olioilla, joten käsin sen luominen tai muokkaaminen jälkikäteen on hyvin työlästä. Tämän vaiheen nopeuttamiseen tämä työkalu tähtää antamalla käyttäjälle yksinkertaisen graafisen käyttöliittymän, jonka avulla voidaan valita kartalta yksi provinssi ja ohjelma näyttää siihen liittyvän tiedon sekä mahdollisuuden muokata ja tallentaa sitä. 

## Käyttöliittymäluonnos

Sovelluksen käyttöliittymä koostuu piirretystä kartasta sekä informaatioikkunasta.
<img src="https://raw.githubusercontent.com/JAndersin/ot-harjoitustyo/master/dokumentaatio/images/luonnos.png" width="1316">

## Perusversion tarjoama toiminnallisuus

- käyttäjä kykenee valitsemaan hiiren klikkauksella provinssin ohjelman piirtämältä kartalta

- käyttäjälle tulostetaan ohjelmassa provinssin tiedot

- käyttäjä pystyy muuttamaan annettuja tietoja

- käyttäjä kykenee tallentamaan muutetut tiedot

## Jatkokehitysideoita

Perusversion jälkeen järjestelmää täydennetään ajan salliessa esim. seuraavilla toiminnallisuuksilla

- uuden muuttujan lisäys