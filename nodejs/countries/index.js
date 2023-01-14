const express = require('express')
const cors  = require('cors');

const app = express()
const port = process.env.PORT || 3000;


const countryCodes = require('country-codes-list')


const myCountryCodesObject = countryCodes.customList('countryCode', '[{countryCode}] {countryNameEn}: +{countryCallingCode} {officialLanguageCode} {region}')

app.use(cors());
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

module.exports = app;
