# Hooks
Hooks allow function components to have access to state and other React features. Because of this, `class components` are generally no longer needed.
- In the latest versions of React, `function components` can do everything that class components can do. In most cases, however, function components offer a more elegant, concise way of creating React components. 

### Function Components and props :
- Even function components can recieve props
- We do not have to use `this` as in class components to access props here.
```jsx
function Smcomponent(props){
    return (
        <div>props.propName</div>
    );
}

ReactDOM.render(<Smcomponent propName = 'vaishakh'/>, document.getElementById('app'))
```

### Purpose of Hooks
`Hooks` simply allows us to use `function components` instead of `class components` for ease of use
- React Hooks, plainly put, are functions that let us manage the `internal state of components` and `handle post-rendering side effects` directly from our `function components`.
- Hooks do not completely replace class components and don’t work inside classes — they let us use fancy React features `without classes`.

# State Hooks
## useState()
- The React useState Hook allows us to `track state` in a function component.
```jsx
import React , {useState} from 'react';
```

- On being called, it returns an array with 2 values: 
  - `current state` - current value of state
  - `state setter` - function that can be called to update the value of this state
```jsx
const [toggle, setToggle] = useState();
// using deferencing as it returns an array with 2 values
```
useState() :
```jsx
import React, { useState } from "react";
 
function Toggle() {
  const [toggle, setToggle] = useState();
 
  return (
    <div>
      <p>The toggle is {toggle}</p>
      <button onClick={() => setToggle("On")}>On</button>
      <button onClick={() => setToggle("Off")}>Off</button>
    </div>
  );
}
```
- Notice how the state setter function, setToggle(), is called by our onClick event listeners. To update the value of toggle and re-render this component with the new value, all we need to do is call the setToggle() function with the next state value as an argument.
- If using classes, we had to take care of binding , constructors ,etc... Hooks makes it easier as all these steps need not be taken care of!!