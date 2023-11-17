import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:qr_scan/src/models/server_response.dart';

class MainService {
  Future<ServerResponse> serviceRequest(String route,
      [Map<String, dynamic>? data]) async {
    final headers = <String, String>{
      'Content-Type': 'application/json; charset=UTF-8',
    };
    final api = Uri.parse("http://192.168.0.13:8000$route");
    try {
      final response =
          await http.post(api, headers: headers, body: jsonEncode(data));
      if (response.statusCode == 500) {
        throw Exception('Error interno de servidor');
      } else {
        final ServerResponse result = serverResponseFromJson(response.body);
        return result;
      }
    } catch (e) {
      final ServerResponse result =
          ServerResponse(error: true, msg: e.toString());
      return result;
    }
  }
}
