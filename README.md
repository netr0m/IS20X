=======
# IS20X - HOW2GITTUTORIALS.RU/GITMASTER
Repository for gruppe 4, IS-202, UiA.

**Gruppemedlemmer:** Morten Amundsen.jar, Svenn-Roger Sørensen.zip, Vegard Aven Sætre.tar, Anders Skrøder.exe, Oscar Lindberg.dmg, Erlend Kasin.mp3

Hvis du skal laste opp noe, f.eks. noe du selv har jobbet på, sørg for å være på din egen branch før du pusher.

- Develop branch er for felles arbeid.
- Master branch er kun til endelig arbeid.

Hvis du ønsker å laste opp til din egen branch med cmd/git bash, MÅ du endre på hvilken branch du bruker. (Dette må gjøres hver gang du åpner git bash). Dette gjøres ved å skrive følgende:

```sh
git checkout dittBranchNavn
- f.eks.: git checkout morten
```

Sjekk deretter at det står følgende i kommandovinduet:
```sh
IS20X (dittBranchNavn)
```

Legg ønsket fil i lokal mappe og skriv følgende i cmd:
```sh
- git add .
- git commit -m "Skriv en kommentar inne i hermetegn"
- git push
```

Hvis noen gjør endringer i develop-branchen må den lokale mappen på din PC synkroniseres på nytt. Skriv:
```sh
- git fetch
- git pull
```
>>>>>>> refs/remotes/origin/master
>>>>>>> refs/remotes/origin/develop
