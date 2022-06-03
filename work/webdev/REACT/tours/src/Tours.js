import React from "react";
import Tour from "./Tour";
const Tours = ({ tours, removeTour }) => {
  return (
    //getting the total tour list
    <section>
      <div className="title">
        <h2>tours</h2>
        <div className="underline"></div>
        <div>
          {tours.map((tour) => {
            return (
              <Tour key={tour.id} {...tour} removeTour={removeTour}></Tour>
            );
          })}
        </div>
      </div>
    </section>
  );
};

export default Tours;
