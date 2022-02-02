## Rendering in REACTJS
Rendering would simply mean making your code appear on the screen. <br>
eg:-
```JSX
import React from 'react';
import ReactDOM from 'react-dom';

ReactDOM.render(<h1>Hello world</h1>, document.getElementById('app'));
```
- `ReactDOM` is the name of a JavaScript library. 
- `ReactDOM.render()` is the most common way to render JSX. It takes a JSX expression, creates a corresponding tree of DOM nodes, and adds that tree to the DOM. That is the way to make a JSX expression appear onscreen. 
  - needs 2 arguments
    - 1st - JSX expression
    - 2ns - target element
  
  - `ReactDOM.render(jsx,target)` 

```JSX
import React from 'react';
import ReactDOM from 'react-dom';

const p = <p>Paragraph</p>;
ReactDOM.render(p,document.querySelector(".box"))
```

## The VIRTUAL DOM:
One special thing about ReactDOM.render() is that it only updates DOM elements that have changed.

That means that if you render the exact same thing twice in a row, the second render will do nothing 

```jsx
const hello = <h1>Hello world</h1>;
 
// This will add "Hello world" to the screen:
 
ReactDOM.render(hello, document.getElementById('app'));
 
// This won't do anything at all as the code is repeated again:
 
ReactDOM.render(hello, document.getElementById('app'));
```

In React, for every DOM object, there is a corresponding "virtual DOM object".
 A virtual DOM object is a representation of a DOM object, like a lightweight copy.

A virtual DOM object has the same properties as a real DOM object, but it lacks the real thing’s power to directly change what’s on the screen.
 
  - When you render a JSX element, every single virtual DOM object gets updated.

  - This sounds incredibly inefficient, but the cost is insignificant because the virtual DOM can update so quickly.

  - Once the virtual DOM has updated, then React compares the virtual DOM with a virtual DOM snapshot that was taken right before the update.

  - By comparing the new virtual DOM with a pre-update version, React figures out exactly which virtual DOM objects have changed. This process is called `diffing`.

  - Once React knows which virtual DOM objects have changed, then React updates those objects, and only those objects, on the real DOM
  
In summary, here’s what happens when you try to update the DOM in React:

- The entire virtual DOM gets updated.
- The virtual DOM gets compared to what it looked like before you updated it. React figures out which objects have changed.
- The changed objects, and the changed objects only, get updated on the real DOM.
- Changes on the real DOM cause the screen to change.