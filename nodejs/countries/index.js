const express = require('express')
const app = express()

const countryCodes = require('country-codes-list')
const port = 3000

const myCountryCodesObject = countryCodes.customList('countryCode', '[{countryCode}] {countryNameEn}: +{countryCallingCode} {officialLanguageCode} {region}')


app.get('/:countryCode', (req, res) => {
    var code = req.params["countryCode"];
    if (myCountryCodesObject[code] != undefined) {
        res.send(myCountryCodesObject[code]);
    } else {
        res.send({ "error": "The country code does not exist" });
    }
})

app.get('/', (req, res) => {
    res.send(myCountryCodesObject);
})

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})