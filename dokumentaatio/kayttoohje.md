# Käyttöohje

Lataa tiedostot 
[ot-harjoitustyo-1.0-SNAPSHOT.jar](https://github.com/JAndersin/ot-harjoitustyo/releases/tag/viikko6) & 
[provinces.JSON](https://github.com/JAndersin/ot-harjoitustyo/releases/tag/viikko6)

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar ProvinceEditor.jar
```

## Sovelluksen käytön aloitus

Aluksi käyttäjän on valittava JSON-tiedosto johon haluaa tiedon tallentaa painamalla "Open JSON" painiketta. 
Sen jälkeen valitaan käytettävä bmp-muotoinen karttatiedosto painamalla "Open map".
Mikäli latasit tiedostot provinces.JSON ja map.bmp voit käyttää niitä.
Lopuksi painetaan "Continue"

## Provinssin tietojen muokkaus

Valitseaksesi minkä tahansa provinssin kartalta paina sitä hiiren vasemmalla painikkeella.
Sen jälkeen ohjelma tulostaa oikean laidan infoikkunaan siihen liittyvät tiedot mikäli ne ovat olemassa, muulloin arvot ovat vakiona "0" tai "null" nimen kohdalla.
Muokattuasi tietoja ne tallennetaan oikean laidan painikkeella "Tallenna", ohjelma tallentaa valitsemasi tiedoston päälle automaattisesti.

## JSON-tiedoston nollaus

JSON-tiedoston voi alustaa ohjelman käyttöön valitsemalla tiedosto ja sen jälkeen painamalla oikean laidan paniniketta "Nollaa kaikki tiedot"

## Uusien tiedostojen valinta ohjelman ollessa käynnissä

Voit valita oikean laidan "Open new JSON" ja "Open new map" painikkeilla lennosta uudet tiedostot.
