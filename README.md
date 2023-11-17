# QRApp
QR App that integrates a flutter module into an Android Java App, the Android app fetches from an API the QR scans made by the flutter module that uses the flutter_barcode_scanner plugin.

# Run the app

1. Clone the repository, open a command line and type:
```
cd qr_scan
```
1.1 Change the IP of the API endpoints, in the RetrofitService.java and in the main_service.dart respectively with your IP or the IP of the device where the web service is running.
2. Make sure you have the Flutter SDK installed, then type:
```
flutter pub get
```
3. Once you have installed the libraries, type:
```
flutter build aar
```
4. Once this process is finished, you should change in your settings_gradle of the android app, the line with the url to your local repo, this url appears in the output of the previous command, with the format
```
maven {
            url 'path/to/repo/QRApp/qr_scan/build/host/outputs/repo'
        }
```
5. Open the android app in Android Studio and run it in an android phone to use the QR scanner.
6. Make sure you have the [ws-tickets](https://github.com/FMarcelFC/ws-tickets) in the scan branch, running and connected to the MySQL server.
