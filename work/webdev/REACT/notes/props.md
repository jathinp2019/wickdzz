
# Component Interaction
- A React application can contain dozens, or even hundreds, of components.
- Each component might be small and relatively unremarkable on its own. When combined, however, they can form enormous, fantastically complex ecosystems of information.
- In other words, React apps are made out of components, but what makes React special isn’t components themselves. What makes React special is the ways in which components interact.

## Component returning components
```jsx
//file1
export class cl1 extends Reacct.Component {
  render(){
    return <h1>Class1</h1>
  }
}

//remember to import,export as in Js

//file2
import cl1 from 'file1.js'
class cl2 extends React.Component {
  render(){
    return <cl1 />
  }
}
```

# Props
- another way that components can interact: `a component can pass information to another component` and this info that is passed is known as `props`.
- Every component has something called `props.`
  - A component’s props is an object. It holds information about that component.
  - To see a component’s props object, you use the expression `this.props`
- These should be `immutable` nor they should be changed in the body of a function
  
```jsx
render(){
    <h1>Props here </h1>
    console.log(this.props)
}
```
- We can pass messages in componetns by giving it an attribute
- Let’s say that you want to pass a component the message, "This is some top secret info.". Here’s how you could do it:
  - Values that arent string are wrapped by curly braces 
```jsx
<Example message="This is some top secret info." />

// values that arent string: 
<Greeting myInfo={["top", "secret", "lol"]} />

<Greeting name="Frarthur" town="Flundon" age={2} haunted={false} />
```
### Rendering the prop
- we can render the prop of a component by using `this.props.propName`
```jsx
class cmp1 extends React.Component {

    render(){
        return <h1>{this.props.name}</h1> //Vaishakh will be inserted here
    }
}

ReactDOM.render(<cmp1 name="Vaishakh" />, target)
```

## Pass props From Component To Component
- The most common use of props is to pass information to a component, from a different component.

Greeting.js
```jsx
// Greeting.js
import React from'react'

export class Greeting extends React.Component {
    return <h2>My Name is {this.props.name}</h2>
    // name is the attribute
}
```
App.js
```jsx
import React from 'react'
import ReactDOM from 'react-dom'
import {Greeting} from './Greeting'

class App extends React.Component {
    return (
        <h1> This is App Component passing info to Greeting Component</h1>
        <Greeting name="Vaishakh" />
    )
}

ReactDOM.render(<App />,target)
```

## Decision Making using props
- Props are also used in decison making and deciding what to be renderd according to the condition
- the prop however isn't shown in the UI, but then just used for decision making
```jsx
// Greeting.js

import React from 'react';
import ReactDOM from 'react-dom';

export class Greeting extends React.Component {
    // signedIn used for decision making onlyy
  render() {
  	if (this.props.signedIn === false) {
  	  return <h1>GO AWAY</h1>;
  	} else {
  	  return <h1>Hi there, {this.props.name}!</h1>;
  	}
  }
}
```

```jsx
//App.js 

import React from 'react';
import ReactDOM from 'react-dom';
import { Greeting } from './Greeting';

class App extends React.Component {
  render() {
    return (
      <div>
        <h1>
          Hullo and, "Welcome to The Newzz," "On Line!"
        </h1>
        <Greeting name="Alison" signedIn={true} />

        <article>
          Latest:  where is my phone?
        </article>
      </div>
    );
  }
// Notice that signedIn propisnt being rendered anywhere, but only used for decision

}

ReactDOM.render(
  <App />, 
  document.getElementById('app')
);
```

### Event Handlers in a Component Class
-  pass an event handler function as a prop. However, you have to define an event handler before you can pass one anywhere
  
```jsx
// Talker.js

import React from 'react';
import ReactDOM from 'react-dom';
import { Button } from './Button';


class Talker extends React.Component {
  talk () { // function for event-handling

  // Note that it doesnt need `function` keyword
	let speech = '';
  for (let i = 0; i < 10000; i++) {
    speech += 'blah ';
  }
  alert(speech);
} 

render() {
    return <Button onClick={this.talk} />;
    // calling the event handler
  }
}

ReactDOM.render(
  <Talker />,
  document.getElementById('app')
);
```

#### Passing the Handler
- the handler should be passed from `Talker.js` to `Button.js` as a `prop`

```jsx
//Talker.js

import React from 'react';
import ReactDOM from 'react-dom';
import { Button } from './Button';

class Talker extends React.Component {
  talk() {
    let speech = '';
    for (let i = 0; i < 10000; i++) {
      speech += 'blah ';
    }
    alert(speech);
  }
  
  render() {
    return <Button talk={this.talk} />; 
    //passing the function as a prop
  }
}

```

```jsx
// Button.js
import React from 'react';

export class Button extends React.Component {
  render() {

    //recieving the function as a prop

    return (
      <button onClick = {this.props.talk}>
        Click me!
      </button>
    );
  }
}
```

`Passing multiple handlers`
- You can pass in multiple event handlers as props to the child component, then to choose a specific one to attach to it you can utilize something like a ternary statement.

- For example, say that you have a component whose button should run different code based on its state. We can pass the functions to the child component, then from the child component, use a ternary statement that will attach one of the two functions based on its state.

The parent component might look like the following, which passes two event handlers to its child component.
```jsx
class Parent extends React.Component {
  handleClickOne() {
    // Code
  }
  
  handleClickTwo() {
    // Code
  }
  
  render() {
    return <Child onClickOne={this.handleClickOne} 
                  onClickTwo={this.handleClickTwo} />;
  }
}
```

Then, the child component will receive both event handlers, and attach one of them to itself, based on its state.

```jsx
class Child extends React.Component {
  render() {
    return (
      <button onClick={this.state.value == someValue ? 
                       this.props.onClickOne : this.props.onClickTwo}>
        Click me!
      </button>
    );
  }
}
```

## this.props.children
- Every component’s `props` object has a property named `children`.
- `this.props.children` will return everything in between a component’s opening and closing JSX tags.
- Now Note that we always mentioned components as `< Component />` , but `<Component> </ Component>` is alsoo used

```jsx
// here h1 is the child 
<Mycomponent>
  <h1>Hey there <h1>
</ Mycomponent>
``` 
- this.props.children would return everything in between `<MyComponent>` and `</MyComponent>`
- If a component has more than one child between its JSX tags, then `this.props.children` will return those children in an `array`. However, if a component has only one child, then this.props.children will return the single child, not wrapped in an array.

```jsx
// App.js

import React from 'react';
import ReactDOM from 'react-dom';
import { List } from './List';

class App extends React.Component {
  render() {
    return (
      <div>
        <List type='Living Musician'>
          <li>Sachiko M</li>
          <li>Harvey Sid Fisher</li>
        </List>

        <List type='Living Cat Musician'>
          <li>Nora the Piano Cat</li>
        </List>
      </div>
    );
  }
}

ReactDOM.render(
  <App />, 
  document.getElementById('app')
);
```

```jsx
// List.js

import React from 'react';

export class List extends React.Component {
  render() {
    let titleText = `Favorite ${this.props.type}`;
    if (this.props.children instanceof Array) {
    	titleText += 's';
    }

    //using this.props.children
    return (
      <div>
        <h1>{titleText}</h1>
        <ul> {this.props.children} </ul>
      </div>
    );
  }
}
```

## defaultProps:
- Props that would appear if no prop is passed in the component
- if any prop is passed int the component , then that prop is rendered rather than the default one

```jsx
class Button extends React.Component {
  render() {
    return (
      <button>
        {this.props.text}
      </button>
    );
  }
}

// defaultProps:
Button.defaultProps = {text : "I am a button"}

ReactDOM.render(
  <Button />, // since no prop is being passed, the defaultProps would be rendered 

  document.getElementById('app')
);
```