
# Module 02: Class Notes

## Documentation

* Express.js
    - Web Framework
    - Documentation: [https://expressjs.com/en/4x/api.html](https://expressjs.com/en/4x/api.html)
    - Guide: Read about routing, which maps URL's to app functions in your Application: [https://expressjs.com/en/guide/routing.html](https://expressjs.com/en/guide/routing.html)
* Sequelize.js
    - Promise-based ORM
    - Documentation: [http://docs.sequelizejs.com/en/v3/](http://docs.sequelizejs.com/en/v3/)
    - Guide: Learn how to use Models: [http://docs.sequelizejs.com/en/v3/docs/models-usage/](http://docs.sequelizejs.com/en/v3/docs/models-usage/)
* Handlebars
    - View template engine (express-handlebars)
    - Documentation: [https://github.com/ericf/express-handlebars](https://github.com/ericf/express-handlebars)
    - We'll get into more details later in the semester.
* Mocha/Chai
    - Testing Framework (Mocha) and Assertion Library (Chai)
    - Documentation (Mocha): [https://mochajs.org/#getting-started](https://mochajs.org/#getting-started)
    - Documentation (Chai): [http://chaijs.com/](http://chaijs.com/)
    - We'll get into more details later in the semester.

## What we did in lecture

### Looked at `package.json`
This file stores all the dependencies for our application.

We will look into creating, updating, and using this file in a few weeks.

### Looked at `app.js`
`app.js` is our application entry point (like a `main()` function).

It explicitly includes and initializes all of the plugins and middleware we want to use, as well as our own components (models, controllers, views).

The `app.listen(3000)` statement at the end of the files begins the application event loop.

The app is now waiting and matching any HTTP URL requests to available routes. Those routes are in our controllers. The action functions for each route are also defined there. 

We follow a pattern of naming routes based on the controllers filename. All routes are relative to that filename.

### We took a look at the sign-up page

When we visit `/sign-up` with a GET, our application renders the form view. And when we submitted the form, a POST is sent, and we create the user using the model. Then we send a redirect to the profile page.

Look at the user model, and the use of sequelize api.

Look at the view templates we rendered as well.
