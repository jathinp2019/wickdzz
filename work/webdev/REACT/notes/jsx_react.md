## Making a project: 
Creating a react app
- npx create-react-app app_name
The create-react-app will set up everything you need to run a React application.

- npm start (inside the app_name folder) (localhost:3000)
  To start the react app


## Editing
- first-react-app\src\App.js is the file where all the initial code is set up

## JSX (Javascript Syntax eXtension)
- JSX is a syntax extension for JavaScript. It was written to be used with React. JSX code looks a lot like HTML.
- In this case, it means that JSX is not valid JavaScript. Web browsers can’t read it! It needs to be compiled before it reaches the web browser

- JSX elements are treated as JavaScript expressions ... That means that a JSX element can be saved in a variable, passed to a function, stored in an object or array, etc

```JSX
const p1 = <p> Hi </p>
```

- JSX elements can have attributes, just like HTML elements can.
  
```JSX
const p1 = <p id="large">foo</p>
```

- Nesting - use parenthesis to nest the code
```JSX
 const nesting = (
   <a>
     <h1>
       Nested Code
     </h1>
   </a>
 );
```
### Note: A jsx element can have "only  1 " outer element
i.e
this is an invalid code... as it has more than 2 parent elements
```JSX
const paragraphs = (
  <p id="child1">I am a paragraph.</p> 
  <p id="child2">I, too, am a paragraph.</p>
);
```
BUT, this code is valid as it has only 1 parent and 2 child

```JSX
const paragraphs = (
  <div id="parent">
    <p id="child1">I am a paragraph.</p> 
    <p id="child2">I, too, am a paragraph.</p>
  </div>
);
```
- The first opening tag and the final closing tag of a JSX expression must belong to the same JSX element!
- If you notice that a JSX expression has multiple outer elements, the solution is usually simple: wrap the JSX expression in a `<div></div>`

Check <a href="notes\jsx_react.md">RENDERING</a> in React

## ClassName 
I React we use `className` , just `class` in html

```jsx
//In HTML 
<h1 class="big">Hey</h1>
```

```jsx
//In JSX
<h1 className="big">Hey</h1>
```
This is because JSX gets translated into JavaScript, and class is a reserved word in JavaScript.

When JSX is rendered, JSX className attributes are automatically rendered as class attributes.

<br>

## Self-Closing Tags
When you write a self-closing tag in HTML, it is optional to include a forward-slash immediately before the final angle-bracket:

```js
<img> <img/>
<br>  <br/>
```

But in REACT, self closing tags MUST end with `\`
```js
Fine in JSX:
<br />

NOT FINE AT ALL in JSX:
<br >
```

<br>

## Javascript in JSX
Any javascript code can be written inside JSX by using `{}`
```jsx
Any code writen inside `{}` is treated as javascript

const H1=<h1>2+3</h1>
ReactDOM.render(H1,target)
// "2+3" will be the output 

const H2=<h1>{ 2+3 }</h1>
ReactDOM.render(H2,target)
// 5 will be the output 
```
The curly braces themselves won’t be treated as JSX nor as JavaScript. They are markers that signal the beginning and end of a JavaScript injection into JSX, similar to the quotation marks that signal the boundaries of a string.

We can access variables while inside of a JSX expression, even if those variables were declared on the outside.
```jsx
const theBestString = 'Yo globallly';

ReactDOM.render(<h1>{theBestString}</h1>, document.getElementById('app'));
```

#### Object prop. and variables:
When writing JSX, it’s common to use variables to set attributes.
```jsx
const src="blah/blah"
const img=<img src= {src} />
```

Object properties are also often used to set attributes:
```jsx
const prop = {
  name:"ukwitis",
  age:"20"
}

const obj = (<p>
Name: {prop.name}
Age : {prop.age}
</p>)
```

### EventListeners:
Create an event listener by giving a JSX element a special attribute. Here’s an example:

```JSX
<img onClick={myFunc} />
```
`Note:`  Camelcase is being used for eventListeners

```js
`onclick` in HTML
`onClick` in JSX
```

## Conditonals in JSX
- `If` statements cannot be injected in JSX
```jsx
// @ this is invalid

const h = (
  <h1>
    {
      if (purchase.complete) {
        'Thank you!'
      }
    }
  </h1>
);
```

BUT performing a if statement outside the jsx expression is valid
```jsx
let text;

if (id==1) text="hi 1"
else text="hi 2"

const h1 = <h1>{text}</h1>
```

One more method of if Statements is by using `&&`
```jsx
const tasty = (
  <ul>
    <li>Applesauce</li>
    { !baby && <li>Pizza</li> }
    { age > 15 && <li>Brussels Sprouts</li> }
    { age > 20 && <li>Oysters</li> }
    { age > 25 && <li>Grappa</li> }
  </ul>
);
//if lhs == true , rhs is added/rendered
```

### Keys in React:
A `key` is a JSX attribute. The attribute’s name is key. The attribute’s value should be something unique, similar to an id attribute.

Keys don’t do anything that you can see! React uses them internally to keep track of lists. If you don’t use keys when you’re supposed to, React might accidentally scramble your list-items into the wrong order.

```jsx
<ul>
  <li key="li-01">Example1</li>
  <li key="li-02">Example2</li>
  <li key="li-03">Example3</li>
</ul>
```


# React.createElement
You can write React code without using JSX at all!

In React, you won't be using `document.createElement`.
However, we saw how it works because it shares some similarities with `React.createElement` but it's not the same thing.

- `document.createElement` returns a DOM element (for example a div or an h1). Whereas `React.createElement` returns an object that represents the DOM element.
The object looks something like this:
```jsx
const element = React.createElement("h1");
//returns an object similar to this one:
{
  type: 'h1',
  props: {}
}
```
  - The reason why React.createElement returns an object rather than the DOM element itself is because React operates a `Virtual DOM`. 
  - So React.createElement returns an object rather than a DOM element because this allows React to do some performance optimizations (such as the Virtual DOM)

`Note: ` when a JSX element is compiled, it transforms into a `React.createElement()` call.

```jsx
//Syntax
React.createElement(type, {props},children)

eg:- 
let welcome = React.createElement(
  "h1",
  { className:"welcome" ,style: { color: "red" } },
  `Welcome to react world`
);
```

`Note:` 
 the `DOM` is used in React applications, but `it isn’t part of React`. After all, the DOM is also used in countless non-React applications.
 Methods imported from `react` are only for pure React purposes, such as creating components or writing JSX elements.