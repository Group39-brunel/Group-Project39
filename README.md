<p align="center">
  <img src="https://github.com/ciseng/gender-decoder-frontend/blob/master/src/Components/addJob/equality-people.png" alt="Gender-Decoder-App logo" width=320px/>
</p>


This is a simple app example for Year 2 projects in Computer Science, implementing the front-end of the Gender-Decoder-App using React.
It requires the back-end that was written for the Gender-Decoder-App, and provided in the labs.  

The original [Gender-Decoder App]( http://gender-decoder.katmatfield.com/) is written in python and also published as a [GitHub repository](https://github.com/lovedaybrooke/gender-decoder). This tool was inspired by [a research paper](http://gender-decoder.katmatfield.com/static/documents/Gaucher-Friesen-Kay-JPSP-Gendered-Wording-in-Job-ads.pdf) written by Danielle Gaucher, Justin Friesen, and Aaron C. Kay, Evidence That Gendered Wording in Job Advertisements Exists and Sustains Gender Inequality (Journal of Personality and Social Psychology, July 2011, Vol 101(1), p109-28).

# Backend
The backend was written using the Spring Boot Framework, and expects to access a MySQL database as defined in the application.properties file.
This file needs to be modified with correct database credentials for the back-end to work. 

# Frontend

The front-end part of the project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.<br />
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.<br />
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.<br />
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.<br />
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.<br />
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can’t go back!**

If you aren’t satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you’re on your own.

You don’t have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn’t feel obligated to use this feature. However we understand that this tool wouldn’t be useful if you couldn’t customize it when you are ready for it.
