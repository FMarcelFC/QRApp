// ignore_for_file: use_build_context_synchronously

import 'package:flutter/material.dart';
import 'package:flutter_barcode_scanner/flutter_barcode_scanner.dart';
import 'package:qr_scan/src/providers/service_provider.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'QR Scanner',
        debugShowCheckedModeBanner: false,
        home: QRScanner());
  }
}

class QRScanner extends StatelessWidget {
  QRScanner({super.key});
  final ServiceProvider serviceProvider = ServiceProvider();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFFAAF26),
      body: Center(
        child: MaterialButton(
            shape:
                RoundedRectangleBorder(borderRadius: BorderRadius.circular(5)),
            color: Colors.white,
            onPressed: () async {
              String barcodeScanRes = await FlutterBarcodeScanner.scanBarcode(
                  '#3D8BEF', 'Cancelar', false, ScanMode.QR);
              if (barcodeScanRes == '-1') {
                return;
              }
              final response = await serviceProvider.uploadScan(barcodeScanRes);
              final snackBar = SnackBar(
                backgroundColor: Theme.of(context).colorScheme.primary,
                duration: const Duration(seconds: 3),
                content: Text(response.msg.toString()),
                action: SnackBarAction(
                  label: 'Aceptar',
                  onPressed: () {},
                ),
              );
              ScaffoldMessenger.of(context).showSnackBar(snackBar);
            },
            child: Container(
              padding: EdgeInsets.symmetric(
                  horizontal: MediaQuery.of(context).size.width / 6,
                  vertical: 13),
              child: const Text(
                'Scan QR',
                style: TextStyle(
                  color: Colors.black,
                  fontSize: 16,
                ),
              ),
            )),
      ),
    );
  }
}
