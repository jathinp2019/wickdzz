import {React} from 'react';
import SearchIcon from "./search.svg"; // importing css

const MovieCard = (props) =>{
    // calling the parameter from props
    const movie = props.movies;
    return (
     <div>
       <div>
          <p>{movie.Year}</p>
          <img src={movie.Poster} alt={movie.Title} />
        </div>
        <div>
          <span>{movie.Type}</span>
          <h3>{movie.Title}</h3>
        </div>
     </div>
      );
}
export default MovieCard;