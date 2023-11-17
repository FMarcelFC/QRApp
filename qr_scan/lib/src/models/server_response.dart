// To parse this JSON data, do
//
//     final serverResponse = serverResponseFromJson(jsonString);

import 'dart:convert';

ServerResponse serverResponseFromJson(String str) =>
    ServerResponse.fromJson(json.decode(str));

String serverResponseToJson(ServerResponse data) => json.encode(data.toJson());

class ServerResponse {
  ServerResponse({
    required this.error,
    required this.msg,
  });

  bool error;
  dynamic msg;

  factory ServerResponse.fromJson(Map<String, dynamic> json) => ServerResponse(
        error: json["error"],
        msg: json["msg"],
      );

  Map<String, dynamic> toJson() => {
        "error": error,
        "msg": msg,
      };
}
