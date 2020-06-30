# SophistiPong
Klasična igra Pong rekreirana v Javi.

## Opis

Igra je sestavljena iz dveh igralcev, žogice in igrišča. Cilj igre je dati 'gol' nasprotniku, tako, da se žogica dotakne stranice za nasprotnikom.

Igra vsebuje nekaj napak in bi lahko rekli, da je to 'alpha' verzija.

V igro bi lahko izbolšali na naslednje načine:
- Igralci bi se lahko premikali tudi po x-smeri
- Natančnejši odboji 
- Dodatki ali 'Powerups'
- Možnost dati igro na pavzo

in še veliko več.

Ko poženemo Main.java se nam odpre naslednje okno:

![FirstPage](https://github.com/15minutOdmora/SophistiPong-Beta/blob/master/FirstPage.png)

Tukaj lahko nastavimo nekaj spremenljivk in sicer:
- Ball Size     = Velikost žoge (radij, 1 = 1px)
- Ball Speed    = Hitrost žoge 
- Player Height = Višina igralcev
- Player Speed  = Hitrost igralcev 
- Rebound spin  = Sprememba kota odboja v primeru, da se odbijajoč igralec premika
- Reset         = Poenostavi vse spremenljivke na začetne vrednosti
- Start Game    = Poženemo igro


![Game](https://github.com/15minutOdmora/SophistiPong-Beta/blob/master/Game.png)

Nekaj posebnosti v igri:
- Žoga je definirana parametrično, sestavljena iz spremenljivk Fi(kot) in v(Hitrost), pri odbojih spreminjamo le kot
- Igra deluje ne odvisno na spremenjene velikosti 
- Če se igralec ob odboju z žogo premika v določeno smer to vpliva na odbojni kot (npr. igralec se premika navzgor => odbojni kot bo nekoliko bolj gor usmerjen), in je tudi nastavljiv(Rebound Speed)



