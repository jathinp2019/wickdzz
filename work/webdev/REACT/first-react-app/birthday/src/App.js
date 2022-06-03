import React, { useState } from "react";
import data from "./data";
import List from "./List";
function App() {
  const [people, setPeople] = useState(data);
  console.log(people);
  return (
    <main>
      <section className="container">
        <h3> {people.length} birthdays today</h3>

        <List people={people} />
        {/* passing array props */}

        <button
          onClick={() => {
            console.log("click");
            setPeople([]);
            // people = [empty array] on click
          }}
        >
          Clear All
        </button>
      </section>
    </main>
  );
}

export default App;
