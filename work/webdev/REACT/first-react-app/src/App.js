import logo from "./logo.svg";
import "./App.css";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>editing react js files</p>
        Learning REACT
      </header>
    </div>
  );
}

const people = ["Rowe", "Prevost", "Gare"];

const peopleLis = people.map((person, i) => (
  // expression goes here:
  <li key={"person_" + i}> {person} </li>
));

console.log(typeof peopleLis);
console.log(peopleLis);

export default App;
