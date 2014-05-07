app - Aplikacja mobilna - Android
===
## U¿yte technologie:
- Baza danych - SQLite
- Silnik - Java + Android SDK
- Widoki - XML

## Struktura plików:
- assets/ - katalog chwilowo nieu¿ywany
- bin/ - katalog z wygenerowanymi plikami u¿ytkowymi 
- gen/ - katalog z plikami z adresami zmiennych i elementów
- libs/ - katalog z bibliotekami
- res/ - katalog z zasobami
	- drawable-hdpi/ - katalog zawieraj¹cy obrazy dla wysokich rozdzielczoœci
	- drawable-ldpi/ - katalog zawieraj¹cy obrazy dla niskich rozdzielczoœci
	- drawable-mdpi/ - katalog zawieraj¹cy obrazy dla œrednich rozdzielczoœci
	- drawable-xhdpi/ - katalog zawieraj¹cy obrazy dla bardzo wysokich rozdzielczoœci
	- layout/ - katalog zawieraj¹cy widoki (pliki XML)
		- activity_history.xml - widok prezentuj¹cy historyczne dane
		- activity_login.xml - widok logowania - ekran startowy
		- activity_menu.xml - widok menu
		- activity_start.xml - widok prezentuj¹cy aktualne dane
		- activity_update.xml - widok aktualizacji danych
		- button.xml - ustawienia przycisku
	- menu/ - katalog zawieraj¹cy pliki menu
	- raw/ - katalg zawieraj¹cy pliki z danymi
	- values/, values-large/, values-v11/, values-x14/ - katalogi zawieraj¹ce pliki ze zmiennymi
- src/ - katalog z plikami Ÿród³owymi (com/example/sas/)
	- Database.java - tworzenie bazy danych
	- DBConnector.java - przesy³anie danych serwer - aplikacja
	- DBHandler.java - obs³uga bazy danych
	- GraphViewData.java - przechowywanie danych do wykresu
	- HistoryActivity.java - obs³uga widoku 
	- LoginActivity.java - obs³uga widoku 
	- MenuActivity.java - obs³uga widoku 
	- RWFile.java - 
	- StartActivity.java - obs³uga widoku 
	- UpdateActivity.java - obs³uga widoku 
- AndroidManifest.xml - wa¿ny plik - zawiera deklaracjê u¿ytych widoków i pozwolenia

##### hAMW