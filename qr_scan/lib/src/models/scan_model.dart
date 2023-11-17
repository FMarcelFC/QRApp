// To parse this JSON data, do
//
//     final scanResponse = scanResponseFromJson(jsonString);

import 'dart:convert';

ScanResponse scanResponseFromJson(String str) =>
    ScanResponse.fromJson(json.decode(str));

String scanResponseToJson(ScanResponse data) => json.encode(data.toJson());

class ScanResponse {
  int id;
  String info;
  int type;

  ScanResponse({
    required this.id,
    required this.info,
    required this.type,
  });

  factory ScanResponse.fromJson(Map<String, dynamic> json) => ScanResponse(
        id: json["id"],
        info: json["info"],
        type: json["type"],
      );

  Map<String, dynamic> toJson() => {
        "id": id,
        "info": info,
        "type": type,
      };
}
