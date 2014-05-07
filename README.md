app - Aplikacja mobilna - Android
===
## Użyte technologie:
- Baza danych - SQLite
- Silnik - Java + Android SDK
- Widoki - XML

## Struktura plików:
- assets/ - katalog chwilowo nieużywany
- bin/ - katalog z wygenerowanymi plikami użytkowymi 
- gen/ - katalog z plikami z adresami zmiennych i elementów
- libs/ - katalog z bibliotekami
- res/ - katalog z zasobami
	- drawable-hdpi/ - katalog zawierający obrazy dla wysokich rozdzielczości
	- drawable-ldpi/ - katalog zawierający obrazy dla niskich rozdzielczości
	- drawable-mdpi/ - katalog zawierający obrazy dla średnich rozdzielczości
	- drawable-xhdpi/ - katalog zawierający obrazy dla bardzo wysokich rozdzielczości
	- layout/ - katalog zawierający widoki (pliki XML)
		- activity_history.xml - widok prezentujący historyczne dane
		- activity_login.xml - widok logowania - ekran startowy
		- activity_menu.xml - widok menu
		- activity_start.xml - widok prezentujący aktualne dane
		- activity_update.xml - widok aktualizacji danych
		- button.xml - ustawienia przycisku
	- menu/ - katalog zawierający pliki menu
	- raw/ - katalg zawierający pliki z danymi
	- values/, values-large/, values-v11/, values-x14/ - katalogi zawierające pliki ze zmiennymi
- src/ - katalog z plikami źródłowymi (com/example/sas/)
	- Database.java - tworzenie bazy danych
	- DBConnector.java - przesyłanie danych serwer - aplikacja
	- DBHandler.java - obsługa bazy danych
	- GraphViewData.java - przechowywanie danych do wykresu
	- HistoryActivity.java - obsługa widoku 
	- LoginActivity.java - obsługa widoku 
	- MenuActivity.java - obsługa widoku 
	- RWFile.java - 
	- StartActivity.java - obsługa widoku 
	- UpdateActivity.java - obsługa widoku 
- AndroidManifest.xml - ważny plik - zawiera deklarację użytych widoków i pozwolenia

##### hAMW