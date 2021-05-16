# Province Data Editor

Sovellus on työkalu helpottamaan bittikarttapohjaisen strategiapelin JSON-tiedostoihin tallennettujen olioiden tarkastelua ja muokkausta. 

## Vaatimukset

Java versio 11.

## Dokumentaatio

[Käyttöohje](https://github.com/JAndersin/ot-harjoitustyo/blob/main/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/JAndersin/ot-harjoitustyo/blob/main/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/JAndersin/ot-harjoitustyo/blob/main/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/JAndersin/ot-harjoitustyo/blob/main/dokumentaatio/arkkitehtuuri.md)

## Komentorivinkomennot

```
mvn test
```

Suorittaa testit.

```
mvn jacoco:report
```

Luo testikattavauusraportin kohteeseen "target/site/jacoco.

```
mvn package
```

Luo suositettavan .jar tiedoston "ot-harjoitustyo-1.0-SNAPSHOT.jar" kohteeseen "target"

```
mvn javadoc:javadoc
```

Luo javadocin kohteeseen "target/site/apidocs.

```
 mvn jxr:jxr checkstyle:checkstyle
```

Luo checkstyleraportin kohteeseen "target/site"




