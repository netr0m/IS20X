# Hvordan koble til database

## Blir du bedt om passord, prøv "0verwatch1.0"

### For Windows
1. Last ned og installer PuTTY (https://the.earth.li/~sgtatham/putty/latest/x86/putty-0.67-installer.msi)
2. Last ned .ppk-nøkkel fra denne lenken: https://drive.google.com/open?id=0B1wH2cPQ19oCdXVraktDd2syRlU
3. Kjør PuTTY: Følg denne guiden, og legg inn disse verdiene:

4. I feltet "Host Name:", skriv inn "overwatch.bitnamiapp.com", og i feltet "Saved Sessions:", skriv inn "overwatch.bitnamiapp.com". Trykk "Save"
5. I menyen på venstre side, velg "Connection" -> "Data". Under "Login details", skriv inn "bitnami" under "Auto-login username"
6. I menyen, under "Connection", velg "SSH" -> "Auth". Under "Authentication Parameters", velg filen du lastet ned i steg 2 (ppk-nøkkelen)
7. I menyen, under "Connection" -> "SSH", velg Tunnels. Under "Add new forwarded port:", skriv inn "33306" i feltet for "Source port", og "localhost:3306" i feltet for "Destination". Trykk deretter "Add".
8. Gå tilbake til "Session", øverst i menyen, og trykk "Save".

### For Mac/OSX
1. Last ned .pem-nøkkel fra denne lenken: https://drive.google.com/open?id=0B1wH2cPQ19oCNk9nNG9NaWU4NEU
2. Åpne terminalen: Skriv inn: "chmod 600 bitnami-hosting(1).pem"
3. Logg inn på serveren ved å skrive følgenden i terminalen: "ssh -i bitnami-hosting(1).pem bitnami@overwatch.bitnamiapp.com"
4. Lag en tunnel til din lokale maskin ved å skrive følgende i terminalen: "ssh -v -N -L 3306:127.0.0.1:33306 -i bitnami-hosting(1).pem bitnami@overwatch.bitnamiapp.com"

## Siste steg, gjelder for alle:
1. Åpne MySQL WorkBench
2. Under "Connection Name:" Skriv inn "Overwatch".
3. Under "Hostname:" Skriv inn "localhost".
4. Under "Port:" Skriv inn "33306"
5. "Username:" "root"
6. Trykk "Test Connection". Passordet du skal skrive inn her er "0verwatch1.0"

### Nå kan du laste ned og teste programmet, det kan lastes ned fra GitHuben vår i branchen kalt "Morten"
