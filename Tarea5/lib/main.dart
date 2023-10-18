import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int currentIndex = 0;
  int currentImageIndex = 0;
  List<String> backgroundImages = [
    "assets/fondo1.png",
    "assets/fondo2.png",
    // Fondos
  ];
  List<String> displayTexts = [
    "? ? ?",
    "IngenieroEnSistemaSaurio",
    // Textos
  ];
  List<String> centerImages = [
    "assets/descarga.png",
    "assets/ING.png",
    // Imágenes
  ];

  void changeTextAndBackground() {
    setState(() {
      currentIndex = (currentIndex + 1) % backgroundImages.length;
      currentImageIndex = (currentImageIndex + 1) % centerImages.length;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.red,
        title: Text("Primera APP Flutter"),
      ),
      body: Stack(
        children: <Widget>[
          Image.asset(
            backgroundImages[currentIndex], // Imagen de fondo actual
            width: double.infinity,
            height: double.infinity,
            fit: BoxFit.cover,
          ),
          Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Container(
                  width: 200,
                  height: 200,
                  color: Colors.blue.withOpacity(0.0), // Fondo del contenedor
                  child: Image.asset(
                    centerImages[currentImageIndex], // Ruta de la imagen actual
                    width: 100,
                    height: 100,
                  ),
                ),
                SizedBox(height: 20),
                Text(
                  displayTexts[currentIndex],
                  style: TextStyle(fontSize: 24, color: Colors.white),
                ),
                SizedBox(height: 20),
                ElevatedButton(
                  onPressed: changeTextAndBackground,
                  style: ElevatedButton.styleFrom(
                    primary: Colors.red,
                  ),
                  child: Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Icon(Icons.access_alarm),
                      Text(" Presione aquí"),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
