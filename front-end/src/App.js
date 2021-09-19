import React, { Component } from "react";
import AddJob from "./Components/addJob/AddJob";
import {Link, Switch, Route, BrowserRouter as Router } from "react-router-dom";
import ViewJob from "./Components/viewJob/ViewJob";
import './App.css';

class App extends Component {
  render() {
    return (
      <Router>
        <div>
          <h1 className="header">Gender-decoder application</h1>
          <nav className="topnav">
              <Link to={'/'} className="nav-link">Add Job </Link>
              <Link to={'/view'} className="nav-link">View Jobs</Link>
          </nav>
          <Switch>
              <Route exact path='/' component={AddJob} />
              <Route path='/view' component={ViewJob} />
          </Switch>
        </div>
      </Router>
    );
  }
}

export default App;

