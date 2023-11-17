import 'package:qr_scan/src/models/server_response.dart';
import 'package:qr_scan/src/service/main_service.dart';

class ServiceProvider {
  static MainService mainService = MainService();
  Future<ServerResponse> uploadScan(String scan) async {
    final type = scan.contains('WIFI') ? 0 : 1;
    final response =
        await mainService.serviceRequest('/scan', {'info': scan, 'type': type});
    return response;
  }
}
