- In real simple words:
  
whenever you define an `event handler that uses this`, you need to `add this.methodName = this.methodName.bind(this) to your constructor function`

```jsx
class MyComponent extends React.Component{
  constructor (props){
    super(props)
    this.state = {mood : 'good'}

    //using `this.methodName = this.methodName.bind(this)`
    this.changing = this.changing.bind(this)
  }

  changing(){
    this.setState({mood : 'bad'})
    // the method uses `this`
  }

  render() {
      // function callback without () NEEDS `binding`
    return (
      <button onClick={this.handleClick}>
      Click Me! 
      </button>
    );
  }
}
```
`Reason:`
- Generally, if you refer to a `method without ()` after it, such as onClick={this.handleClick}, you should `bind` that method.
- We have to be careful about `this` in javascript. Class method is `not bound by default`
-  If you `forget to bind this.handleClick` and pass it to onClick, this will be `undefined` when the function is actually called.
- It helps in enhancing the performance problem 

```jsx
class MyComponent extends React.Component{
  constructor (props){
    super(props)
    this.state = {mood : 'good'}
  }

  changing(){
    this.setState({mood : 'bad'})
    // the method uses `this`
  }

  render() {
    // function callback with () DOES NOT need `binding`
    return (
      <button onClick={() => this.changing}>
      Click Me! 
      </button>
    );
  }
}
```

`Note:` if any argument is also being passed, then bind it with the method name alsooo :
```jsx
this.methodName = this.methodName.bind(this,arg)
```


