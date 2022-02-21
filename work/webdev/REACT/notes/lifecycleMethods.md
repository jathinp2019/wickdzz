# Component Life Cycle 
- React is a dynamic and declarative language. They get created, updated, removed , which is referred to as it's `lifecycle`
- There are `3 high level parts` in a components lifecycle: 
  - `Mounting` : When component is being initialized and put in the DOM for the first time
  - `Updating` : when the component updates as a result of changed state or changed props
  - `Unmounting` : when the component is being removed from the DOM
  
- It’s worth noting that `each component instance has its own lifecycle`. For example, if you have 3 buttons on a page, then there are 3 component instances,`each with its own lifecycle`. However, once a component instance is unmounted, that’s it—it will never be re-mounted, or updated again, or unmounted.
<img src="lifecycle.jpg">

### Full lifeCycle: 
`Mounting`: The methods that run during this phase, in order, are
- componentWillMount()
- render()
- componentDidMount()

`Updating`: This phase is the `main part of a component’s life`, and the following methods will be invoked repeatedly at each change,
- compoentWillRecieveProps()
- shouldComponentUpdate()
- render()
- componentDidUpdate()

`Unmounting`:This is when the component is removed from the DOM, and the only method run during this phase is
- componentWillUnmount()


# Life Cycle Methods
The most common and important lifeCycle methods are: `render()` and `constrctor()`

It isn't necessary that these lifecycle methods are 1-to-1 with the componets lifecycle
  - `constructor()` is only called during the `mounting` phase
  - `render()` is common for `mounting` and `updating`

## componentDidMount()
- runs in the `mounting` phase 
- Order :
  - constructor()
  - render()
  - componentDidMount()
  
-  it’s called after the component is rendered. This is where we’ll want to start our function which include for eg. setInterval(), etc... which needs continuous updates at the start of mounting itself

```jsx
// A clock code

import React from 'react'
import ReactDOM from 'react-dom'

class timer extends React.Component {
    constructor(props){
        super(props)

        this.state = {date : new Date()}
    }

    render(){
        return (
            <div>{this.state.date.toLocaleTimeString()}</div>
        )
    }
 
}
ReactDOM.render(<timer />,target)
```
- Now the timer is `static` . To make it `dynamic` we could add a setInterval()
- But where should we add this method?
  - Should we add it in the `mounting` or `updating` phase?

Logically : `updating`- we do not want to wait until the component is updated, but rather start the method when it is `mounted` itself!

- But now where to add in the mounting phase?
  - `render()`?
  - `constructor()`?

`Note:` It’s also generally a bad idea to set up any kind of side-effects in `render` and `constructor` (in constructor as  it violates something called the `Single Responsibility Principle`)

So both the optios are ruled out!!

So in such a situation, we use `componentDidMount()` when the method should execute once it is mounted or added along with the component instance

```jsx
// A clock code

import React from 'react'
import ReactDOM from 'react-dom'

class timer extends React.Component {
    constructor(props){
        super(props)

        this.state = {date : new Date()}
    }

    render(){
        return (
            <div>{this.state.date.toLocaleTimeString()}</div>
        )
    }

   // for continuous updation 
   componentDidMount(){
       setInterval(()=>{
           this.setState({date: new Date() })
       }, 1000)
   } // render() will be called automatically after this
  
}
ReactDOM.render(<timer />,target)
```

### Do the mounting lifecycle methods run more than once in a component’s life?
No, the mounting lifecycle methods `(excluding render)` are `only run once` in the entire life of a component.

This is because a component instance can only be mounted once and can never be mounted a second time. It is not possible to unmount and then “remount” a component, because once the component is unmounted it is permanently “destroyed” and cannot be mounted again.

## componentWillUnmount()
- In general, when a component produces a side-effect, you should remember to clean it up.
- At a high level, we want to continue to set up our setInterval() in componentDidMount(), but then we want to clear that interval when the clock is unmounted.
- `componentWillUnmount()` is called in the unmounting phase, right before the component is completely destroyed.

```jsx
import React from 'react';

export class Clock extends React.Component {
  constructor(props) {
    super(props);
    this.state = { date: new Date() };
  }
  render() {
    return <div>{this.state.date.toLocaleTimeString()}</div>;
  }

  componentDidMount() {
      
    const oneSecond = 1000;
    this.intervalID= setInterval(() => {
      this.setState({ date: new Date() });
    }, oneSecond);
  }

  componentWillUnmount(){
      // unmounting the clock function!

    clearInterval(this.intervalID)
  }
}
```