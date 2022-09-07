# react-native-zavalabs-scanner

Bismillah,

this modul is best library for barcode scanning with ZXING improved by ZAVALABS

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

## Support SDK 31

## Getting started

```$ npm install react-native-zavalabs-scanner --save```

## Mostly automatic installation

```$ react-native link react-native-zavalabs-scanner```

## Usage 

#### App.js 

```
import React, { useState } from 'react'
import { StyleSheet, Text, View, TouchableOpacity } from 'react-native'
import ZavalabsScanner from 'react-native-zavalabs-scanner'


export default function App() {

  const [barcode, setBarcode] = useState('');

  const openScanner = () => {
    ZavalabsScanner.showBarcodeReader(result => {
      console.log('barcode : ', result)
      setBarcode(result);
    });
  };

  return (
    <View style={styles.container}>
      <TouchableOpacity onPress={openScanner} style={styles.button}>
        <Text style={styles.textScan}>SCAN BARCODE</Text>
      </TouchableOpacity>
      <View style={styles.row}>
        <Text style={styles.textResult}>Result</Text>
        <Text style={styles.textDot}>:</Text>
        <Text style={styles.textBarcode}>{barcode}</Text>
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
    justifyContent: 'center',
  },
  button: {
    padding: 15,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#044cc2',
    borderRadius: 10,
  },
  textResult: {
    flex: 0.3,
    fontSize: 20,
    color: 'black'
  },
  textDot: {
    flex: 0.2,
    fontSize: 20,
    color: 'black'
  },
  textBarcode: {
    flex: 1,
    fontSize: 30,
    color: 'black'
  },
  textScan: {
    fontSize: 20,
    color: 'white'
  },
  row: {
    padding: 10,
    flexDirection: 'row'
  }
})
```