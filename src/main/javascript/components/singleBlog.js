import React from 'react'
import DataComponent from './DataComponent.js'

const singleBlog = ({data})=>
    <div className="sb">
        <h1>{data.title}</h1>
        <p>{data.body}</p>
    </div>

const SingleBlog = ({blogId}) =>
    DataComponent(singleBlog,`http://localhost:8080/api/blog/getSingle/${blogId}`)