import React from "react";
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
import Home from './components/Home.js'


export default function App() {
    return(
        <Router>
            <div className="home">
                <p><link to="/">Home</link></p>
            <hr/>

            <Switch>
                <Route exact path="/">
                    <Home/>
                </Route>
            </Switch>
            </div>
        </Router>
    )
}

function Home() {
    return(
        <Home/>
    )
}