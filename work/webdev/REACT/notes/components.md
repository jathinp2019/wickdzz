# Components
A component is a small, reusable chunk of code that is responsible for one job.

```jsx
import React from 'react';
import ReactDOM from 'react-dom';
 
class MyComponentClass extends React.Component {
  render() {
    return <h1>Hello world</h1>;
  }
};
 
ReactDOM.render(
  <MyComponentClass />,
  document.getElementById('app')
)
```

## What is `React.Component`?
- `React.Component` is a JavaScript `class`
- To create your own component class, you must `subclass React.Component`
  
### Class Implementation
- we can use a JavaScript class to define a new React component
- All class components will have some methods and properties in common (more on this later). Rather than rewriting those same properties over and over again every time, we extend the Component class from the React library.

A `component class` is like a factory that builds components. It builds these components by consulting a set of instructions, which you must provide. 

`Component Name must follow Capital CamelCasing`
  
```jsx
class ComponentName extends React.Component { //subclass
 // Component Name follows CamelCasing

    // ...function here
}

eg:-
class MyComponentClass extends React.Component{}
```

Now the `MyComponentClass` is a working component class! It’s ready to follow its instructions and make some React components.

### Component Instance
- To make a React component, you write a JSX element. Instead of naming your JSX element something like h1 or div like you’ve done before, give it the same name as a component class. Voilà, there’s your `component instance`! 
  - (Since Mycomponent Class is an object, we need to instantiate it to use it)
  
```jsx
<MyComponentClass />
// this is a component instance
// (Note: the name should be the name of the class itself)
```

 Now How do you Distinguish between `JSX` and `Component` ?
  - JSX uses capitalization to distinguish between the two! 
  - `Components` uses capital CamelCasing for naming purpose.
  - Component class names must begin with capital letters. In a JSX element, that capitalized first letter says, “I will be a component instance and not an HTML tag.”

### Rendering component and instances
- In order to render a component , that component needs to have a method named `render` and it is an inherited method
- To call a component’s `render` method, you pass that component to `ReactDOM.render()`
```jsx 
ReactDOM.render(
  <MyComponentClass />,
  document.getElementById('app')
);
```
- ReactDOM.render() will tell `<MyComponentClass />` to call its render method.
  - `<MyComponentClass />` will call its render method, which will return the JSX element `<h1>Hello world</h1>`
  - `ReactDOM.render()` will then take that resulting JSX element, and add it to the virtual DOM. This will make “Hello world” appear on the screen.

---

## Advanced JSX and Components
### Use Multiline JSX in a Component
- Wrapping JSX element into `()` and using `return` statement n th render function of a component class
  
```jsx
class multilineComponent extends React.Component {
  render(){

    return (
      <h1>Heading</h1>
      <p> this is a para </p>
      // ...etc
    )

    ReactDOM.render(
      <multilineComponent/> ,
      target
    )

  }
}
```

### Use a Variable Attribute in a Component
- Using `{}` i.e. `JS injections` inside render function 
  
```jsx 
import React from 'react'
import ReactDOM from 'react-dom'


const owl = {
  title: 'Excellent Owl',
  src: 'sm-src-here'
};

// Component class starts here:

class Owl extends React.Component {
  render() {
    return (
      <div> 
        <h1>{owl.title} </h1>
        <img src = {owl.src} alt = {owl.title} />
      </div>
    )
  }
}

ReactDOM.render(<Owl />,document.getElementById('app')  )
```

### Put Logic in a Render Function
- Login cfunctions can be added inside `render(){}`
```jsx
class Random extends React.Component {
  render() {
    const n = Math.floor(Math.random() * 10 + 1);
    return <h1>The number is {n}!</h1>;
  }
}
```

`Note:` The func. or calc. should be inside `render` only!!!
The following eg. is incorrect
```jsx 
class Random extends React.Component {
  // This should be in the render function:
  const n = Math.floor(Math.random() * 10 + 1);
 
  render() {
    return <h1>The number is {n}!</h1>;
  }
};
```

### Conditionals in Components 
- inside the render function, but before the return statement
```jsx
  import React from 'react';
import ReactDOM from 'react-dom';

const fiftyFifty = Math.random() < 0.5;

// New component class starts here:

class TonightsPlan extends React.Component {
  render(){
    if(fiftyFifty){
      return <h1>Tonight I'm going out WOOO</h1>
    }
    else return <h1>Tonight I'm going to bed WOOO</h1>
  }
}

//then render the component 
);
```

### this keyword
- used to refer to an instance it is being called by.
```jsx
import React from 'react';
import ReactDOM from 'react-dom';

class MyName extends React.Component {

get name(){ //getter function
  return 'whatever-your-name-is-goes-here'
}

  render() {
    return <h1> My name is {this.name} </h1>;
  }
}

ReactDOM.render(<MyName />, document.getElementById('app'));  
```

### Event Listener in Component
- same as evntListeners using external functions and `this`
  
```jsx
import React from 'react';
import ReactDOM from 'react-dom';

class Button extends React.Component {
  scream() {
    alert('AAAAAAAAHHH!!!!!');
  }

  render() {
    return <button onClick = {this.scream} >AAAAAH!</button>;
  }
}

ReactDOM.render( <Button />, document.getElementById('app'))
```