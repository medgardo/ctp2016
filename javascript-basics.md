# Hacker Rank Review

## Question 8: Merge strings
```javascript
function mergeStrings(a, b) {
    var shortlen = (a.length < b.length) ? a.length : b.length;
    var res = '';

    for(var i=0; i<shortlen; i++) {
        res += a[i];
        res += b[i];
    }

    for(var i=shortlen; i<a.length; i++) {
        res += a[i];
    }
    for(var i=shortlen; i<b.length; i++) {
        res += b[i];
    }

    return res;
}
```

## Question 9: Double size 
```javascript
function doubleSize(a, b) {
    a.sort((a,b)=> a-b); // ES6 && in-place modification of list
    for(var i in a) {
        if(a[i] === b) {
            b *= 2;
        }
    }
    return b;
}
```

## Question 10: Sum them all
```javascript
function sum(numbers) {
    var sum = 0;
    for(var i in numbers) {
        sum += numbers[i];
    }
    return sum;
}
```




# JavaScript

## About JavaScript (ECMAScript, abbreviated ES)
JavaScript (JS) is a rapidly evolving language and today's applications depend on it. JavaScript is the only programming language supported across all modern web browsers. But since the release of Node.js, it has gained wide adoption as a general and server-side language as well.

The "JavaScript" name is trademarked by Oracle Corporation. 


## Some terms and acronyms to know

**ES6** and **ES2015** 
    both refer to the latest published standard of the language (in 2015). It added many new features and syntax that are not present in previous versions. Complete **ES6** support is still in progress as vendors update their software. Currently Chrome, Firefox, and Node are all close to 100% support.

**ES5**
    is the version currently *FULLY* supported by all major web browsers. It was published in 2009. Many older resources will refer to an ES5 style of writing JavaScript code. ES6 has changed a few of the preferred conventions. ES6 code can be transpiled to ES5 via compilers/transpilers such as *Babel.js*.

**Core JavaScript**
    refers to the syntax, expressions, statements, control flow, loops, the data types, and typing system for computing. This includes how to define objects and functions and their use.  It does not refer to any API's or host environments for accessing inputs and producing outputs. The host environments determines which inputs a JS program is allowed to receive, and what outputs it is allowed. The two primary JS host environments we will work with are the Web Browser (client-side) and in Node.js (server-side).

**Client-Side JavaScript**
    refers to JS programs that run within a Web Browser window. In this mode, the browser only provides API's for the language to access the document within the window (through the DOM: Document Object Model) and resources related to the document such as cookies. It does not allow programs to access other browser windows or any hardware resources on the computer.

**Server-Side JavaScript**
    refers to JS programs that run within a runtime that provides programs API's to access hardware and file resources on the computer such as the filesystem, networking sockets, keyboard, sound, cameras, etc. For this reason, runtime's like Node.js have become very popular for Web Application development as well as development on IoT devices and microprocessors such as Arduino's.

**V8 (JavaScript) Engine**
    an open source JavaScript engine developed by google to speed up JS performance, by compiling JS code into native machine code. It is used by various JS runtimes (such as the Chrome Browser, Node.js, MongoDB, etc.). The runtime adds the environment API's that JS programs are given access to.



## Resources and Documentation
https://developer.mozilla.org/en-US/docs/Web/JavaScript
    Mozilla Documentation (Core language and Client-Side (Web Browser) API's)
    **Very Useful** (ES5 and ES6)
    - Hint: search for "mdn javascript"

https://nodejs.org/en/docs/
    Node Documentation (Server-Side Node.js API's)
    **Very Useful**

http://www.ecmascript.org/
    Links to the standards bodies and publications.

## ES6 (ES2015) Specific Resources
https://babeljs.io/docs/learn-es2015/
    Great resource to learn new ES6 features

https://babeljs.io/
    An ES6 to ES5 compiler (or transpiler). Allows us to use ES6 syntax/features today.
    - Try the Online REPL: https://babeljs.io/repl/

https://kangax.github.io/compat-table/es6/
http://node.green/
    ES6 Browser and Server compatability tables




# Common JavaScript Gotchas

## identifiers (variable, funtion, or property names)
    - Can only contain alphanumeric characters [a-zA-Z0-9] and '$' and '_'
    - But CANNOT begin with a digit [0-9].
    - Are case sensitive

## Semicolons ';'
    - ALWAYS USE THEM
    - They are optional, but ommission can lead to very nasty bugs

## Always use Blocks '{ }'
    - It is a best practice to use {} around conditional and loop code.

## var
    - Always use *var*
    - Anytime you do not use **var**, the variable is scoped globally. Globals can lead to bugs.


## Coercion
JavaScript tries its best to do what you ask for and avoid errors, converting types, sometimes not what you expect. Learn the pecularities.

Example: Adding and Subtracting strings and numbers. In addition numbers are coerced into strings. For subtraction, strings are coerced into numbers.
```javascript
x = "The answer is " + 42 // "The answer is 42"
y = 42 + " is the answer" // "42 is the answer"

"37" - 7 // 30
"37" + 7 // "377"

"1.1" + "1.1" = "1.11.1"
(+"1.1") + (+"1.1") = 2.2  

parseInt("23") + 4 // 27
"23" + 4           // "234"
(+"23") + 4        // 27
```


## Avoid "new Array()"
Use the [] syntax instead
```javascript
var aList = [];
var bList = [2, 44, 6];
```


## Equal (==) vs Strict Equal (===)
Use Strict Equal (===), it's probably what you mean.
'===' ensures that values and types match
'==' applies coercion, such that (3 == '3') will result in true.


## Other topics to look into
Scoping: this, variable hoisting
Anonymous functions
switch


## JavaScript Style Guides and Gotchas
https://github.com/airbnb/javascript
https://github.com/airbnb/javascript/tree/master/es5
    Airbnb's JavaScript style guides for ES6 and ES5.
    - Follow these!

http://www.adequatelygood.com/JavaScript-Scoping-and-Hoisting.html
    **Variable Hoisting** article

https://github.com/stevekwan/best-practices/blob/master/javascript/gotchas.md
    **Common Gotchas**




