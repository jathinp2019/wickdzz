import React from "react";
import ReactDOM from "react-dom";
import "./style.css"; // importing css

function Header() {
  return <div className="header">Heading</div>;
}
ReactDOM.render(<Header />, document.getElementById("root"));
