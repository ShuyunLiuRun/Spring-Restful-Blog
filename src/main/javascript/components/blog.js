import React from 'react'
// import SingleBlog from './singleBlog.js'
// import {
//     BrowserRouter as Router,
//     Switch,
//     Route,
//     Link,
//     useRouteMatch
// } from "react-router-dom";
//
// let url  = useRouteMatch();
//
// const Blog = ({title,body,id}) =>
//     <Router>
//     <div className="single-blog">
//         <h3 className="blog-title"><Link to={`${url}/${title}`}>{title}</Link></h3>
//         <hr className="hr-blogTitle"/>
//         <p>{body}</p>
//
//         <Switch>
//             <Route path={`${url}/${title}`}>
//                 <SingleBlog blogId={id}/>
//             </Route>
//         </Switch>
//     </div>
//     </Router>

const Blog = ({title,body,id}) =>

    <div className="single-blog">
        <h3 className="blog-title" id={id}>{title}</h3>
        <hr className="hr-blogTitle"/>
        <p>{body}</p>
    </div>


export default Blog