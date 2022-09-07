# react-native-zavalabs-scanner

The zxing module scanning barcodes in android.

This module abstracts the library zxing-android-embedded, developed by JourneyApps.

## Barcode formats:

- CODE 128
- UPC A
- UPC E
- EAN 8
- EAN 13
- RSS 14
- CODE 39
- CODE 93
- ITF
- RSS EXPANDED
- QR CODE
- DATA MATRIX
- PDF 417


## Getting started

```$ npm install react-native-zavalabs-scanner --save```

## Mostly automatic installation

```$ react-native link react-native-zavalabs-scanner```

## Manual installation 

Android
Update rn to 0.60.* and use autolink

## Usage 

#### App.js 

```
import React from "react";
import { Text, View, TouchableOpacity } from "react-native";
import ZavalabsScanner from "react-native-zavalabs-scanner";

const App = () => {
  const barcodeScanned = (data) => {
    console.log("Barcode ", data);
  };

  const handleClick = () => {
    ZavalabsScanner.showBarcodeReader(barcodeScanned);
  };

  return (
    <View>
      <TouchableOpacity
        onPress={() => handleClick()}
        style={{
          margin: 20,
          backgroundColor: "bluesky",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <Text style={{ fontSize: 30,color:'white',border-radius:10 }}>SCAN</Text>
      </TouchableOpacity>
    </View>
  );
};

export default App;
```