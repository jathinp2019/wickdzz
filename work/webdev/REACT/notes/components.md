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

 Now How do you DIstinguish between `JSX` and `Component` ?
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