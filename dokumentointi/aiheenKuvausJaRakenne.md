## Aiheen kuvaus ja rakenne

**Aihe:** Ristinolla. 

Toteutetaan Ristinolla-peli. 

Peli� pelataan 3x3 -kokoisella ruudukolla. Tavoitteena on saada kolme risti� tai ympyr�� samalle pysty-, vaaka- tai vinoriville 3x3 -kokoisessa ruudukossa.




**K�ytt�j�t:** 

- Pelaaja

**K�ytt�j�n toiminnot:**

- Merkitsee ristin / ympyr�n haluamaansa ruutuun
- Aloittaa uuden pelin

**Luokkakaavio:**


![Luokkakaavio](dokumentointi/XOLuokkakaavio.png)


**Sekvenssikaaviot**


![Risti ruutuun](RistiRuutuun.png)

![Uusi peli](PelaajaAloittaaUudenPelin.png)

![Ristin piirtyminen](RistinPiirtyminen.png)


**Rakennekuvaus**

Peli koostuu kahdesta logiikkaluokasta, Ruutu ja Ruudukko, kahdesta enum -tyyppisest� luokasta, PelinTila ja Merkki, ja Koordinaatit-luokasta.
Ruudukko on kaksiulotteinen taulukko ja se koostuu Ruutu-olioista. Ruudulla on koordinaatit ja Merkki-enumluokan avulla m��ritelt�v� tila, eli se sijaitsee tietyss� kohtaa ruudukkoa ja sen tila voi olla 
risti, nolla tai tyhj�. PelinTila -enumluokan avulla voi m��ritt��, onko peli kesken vai p��ttyik� peli jomman kumman merkin voittoon tai tasapeliin.


Pelin k�ytt�liittym� koostuu XOIkkuna-luokasta, joka sis�lt�� pelialustan (XOAlusta) ja valikon (XOValikko). Pelialustalle piirtyy koko peli.
Alustaan liittyy my�s pelaajalle v�littyv� viesti pelin tilasta ja vuoroista. 
Pelialustaan liittyy my�s MouseListener-rajapinnan toteuttava MerkinPiirtaja, joka k�sittelee hiiren klikkauksen ruudukossa.
Valikkoon liittyv�t hiiren klikkauksen k�sittelev�t luokat UudenPelinAloittaja ja PelinSulkija. UudenPelinAloittaja aloittaa nimens� mukaisesti uuden pelin ja PelinSulkija taas lopettaa pelin ja sulkee ikkunan.


