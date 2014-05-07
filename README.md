app - Aplikacja mobilna - Android
===
## U�yte technologie:
- Baza danych - SQLite
- Silnik - Java + Android SDK
- Widoki - XML

## Struktura plik�w:
- assets/ - katalog chwilowo nieu�ywany
- bin/ - katalog z wygenerowanymi plikami u�ytkowymi 
- gen/ - katalog z plikami z adresami zmiennych i element�w
- libs/ - katalog z bibliotekami
- res/ - katalog z zasobami
	- drawable-hdpi/ - katalog zawieraj�cy obrazy dla wysokich rozdzielczo�ci
	- drawable-ldpi/ - katalog zawieraj�cy obrazy dla niskich rozdzielczo�ci
	- drawable-mdpi/ - katalog zawieraj�cy obrazy dla �rednich rozdzielczo�ci
	- drawable-xhdpi/ - katalog zawieraj�cy obrazy dla bardzo wysokich rozdzielczo�ci
	- layout/ - katalog zawieraj�cy widoki (pliki XML)
		- activity_history.xml - widok prezentuj�cy historyczne dane
		- activity_login.xml - widok logowania - ekran startowy
		- activity_menu.xml - widok menu
		- activity_start.xml - widok prezentuj�cy aktualne dane
		- activity_update.xml - widok aktualizacji danych
		- button.xml - ustawienia przycisku
	- menu/ - katalog zawieraj�cy pliki menu
	- raw/ - katalg zawieraj�cy pliki z danymi
	- values/, values-large/, values-v11/, values-x14/ - katalogi zawieraj�ce pliki ze zmiennymi
- src/ - katalog z plikami �r�d�owymi (com/example/sas/)
	- Database.java - tworzenie bazy danych
	- DBConnector.java - przesy�anie danych serwer - aplikacja
	- DBHandler.java - obs�uga bazy danych
	- GraphViewData.java - przechowywanie danych do wykresu
	- HistoryActivity.java - obs�uga widoku 
	- LoginActivity.java - obs�uga widoku 
	- MenuActivity.java - obs�uga widoku 
	- RWFile.java - 
	- StartActivity.java - obs�uga widoku 
	- UpdateActivity.java - obs�uga widoku 
- AndroidManifest.xml - wa�ny plik - zawiera deklaracj� u�ytych widok�w i pozwolenia

##### hAMW