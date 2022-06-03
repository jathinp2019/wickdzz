import React, { useState } from "react";

const Tour = ({ id, image, info, price, name, removeTour }) => {
  // return <h2>tour component</h2>;

  //rendering and interpreting individual tour
  const [readMore, setreadMore] = useState(false);

  return (
    <article className="single-tour">
      <img src={image} />
      <footer>
        <div className="tour-info">
          <h4>{name}</h4>
          <h4 className="tour-price">${price}</h4>
        </div>

        <p>
          {readMore ? info : `${info.substring(0, 200)}...`}
          <button onClick={() => setreadMore(!readMore)}>
            {readMore ? `Show less` : `Show more`}
          </button>
        </p>

        <button
          className="delete-btn"
          onClick={() => {
            removeTour(id);
            console.log("Not interested");
          }}
        >
          Not interested
        </button>
      </footer>
    </article>
  );
};

export default Tour;
