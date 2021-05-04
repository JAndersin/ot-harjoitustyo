# Käyttöohje

Lataa tiedostot 
[ot-harjoitustyo-1.0-SNAPSHOT.jar](https://github.com/JAndersin/ot-harjoitustyo/releases/tag/viikko6)
[provinces.JSON](https://github.com/JAndersin/ot-harjoitustyo/releases/tag/viikko6)

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar ot-harjoitustyo-1.0-SNAPSHOT.jar
```

## Sovelluksen käytön aloitus

Aluksi käyttäjän on valittava JSON-tiedosto johon haluaa tiedon tallentaa painamalla oikean laidan "Avaa" painiketta.

## Provinssin tietojen muokkaus

Käyttäjän valittua JSON-tiedosto voidaan siirtyä muokkaamaan kartan tietoja. Valitaan ensin hiiren vasemmalla painikkeella mikä tahansa provinssi kartalla.
Sen jälkeen ohjelma tulostaa oikean laidan infoikkunaan siihen liittyvät tiedot mikäli ne ovat olemassa, muulloin arvot ovat vakiona "0" tai "null" nimen kohdalla.
Muokattuasi tietoja ne tallennetaan oikean laidan painikkeella "Tallenna", ohjelma tallentaa valitsemasi tiedoston päälle automaattisesti.

## JSON-tiedoston nollaus

JSON-tiedoston voi alustaa ohjelman käyttöön valitsemalla tiedosto ja sen jälkeen painamalla oikean laidan paniniketta "Nollaa kaikki tiedot"
