import React from 'react';
import { useState } from "react";

function Welcome() {

  const [countries, setCountries] = useState([]);
  var countriesAll = fetch("http://localhost:3002/");

  countriesAll.then((res) => {
    return res.json();
  }).then((result) => {
    setCountries(Object.entries(result));
  });

  var list = countries.map((country, index, arr) =>
    <ElementList key={index} index={index} info={country[1]} code={country[0]} />
  );

  return (<div id='wrapper'><h1>This is the list of countries:</h1>
    <table>
      <thead>
        <tr><th>&nbsp;</th><th>Code</th><th>Info</th></tr>
      </thead><tbody>
        {list}
      </tbody>
    </table>
  </div>);


}

function ElementList(prop) {
  const showInfo = (info) => {
    alert(info);
  }
  return <tr onClick={() => { showInfo(prop.info) }} ><td>{prop.index + 1}</td><td>{prop.code}</td><td>{prop.info}</td></tr>;

}

export default Welcome;
