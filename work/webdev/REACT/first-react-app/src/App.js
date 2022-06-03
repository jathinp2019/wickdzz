import React from "react";
import "./style.css"; // importing css
import MovieCard from "./moviecard";
import SearchIcon from "./";

import { useState, useEffect } from "react";

const API_key = "http://www.omdbapi.com?apikey=bf3910b";

const movie = {
  Poster:
    "https://m.media-amazon.com/images/M/MV5BYjFhN2RjZTctMzA2Ni00NzE2LWJmYjMtNDAyYTllOTkyMmY3XkEyXkFqcGdeQXVyNTA0OTU0OTQ@._V1_SX300.jpg",
  Title: "Italian Spiderman",
  Type: "movie",
  Year: "2007",
  imdbID: "tt2705436",
};
const App = () => {
  const searchMovies = async (title) => {
    const response = await fetch(`${API_key}&s=${title}`);
    const data = await response.json();
    console.log(data.Search);
  };
  useEffect(() => {
    searchMovies("spiderman");
  }, []);

  return (
    <div>
      <h1>MovieLand</h1>
      <div className="search">
        <input
          placeholder="Search for movies"
          value="Superman"
          onChange={() => {}}
        />
        <img onChange={() => {}} />
      </div>

      <div className="container">
        {/* <div>
          <p>{movie.Year}</p>
          <img src={movie.Poster} alt={movie.Title} />
        </div>
        <div>
          <span>{movie.Type}</span>
          <h3>{movie.Title}</h3>
        </div> */}
        <MovieCard movie={movie} />
      </div>
    </div>
  );
};

export default App;

// bf3910b
