import React from "react";
import Home from './components/Home.js';
import AddArticle from './components/addArticle.js';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";

export default function App() {
    return (
        <Router>
            <div>
                <h1><Link to="/">Louise Home</Link></h1>
                <Link to="/addArticle">Add Article</Link>
                <Switch>
                    <Route exact path="/">
                        <Home/>
                    </Route>
                    <Route path="/addArticle">
                        <AA />
                    </Route>
                </Switch>
            </div>
        </Router>
    );
}

function AA() {
    return (
        <AddArticle />
    );
}