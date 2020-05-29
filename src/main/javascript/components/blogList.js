import React from 'react'
import DataComponent from './DataComponent.js'
import Blog from './blog'

const blogList = ({data}) =>
    <ol className="blog-list">
        {data.map((blog,i) => {
            return <li key={i}>
                <Blog {...blog}/>
            </li>
        })}
    </ol>

const BlogLists = DataComponent(
    blogList,"http://localhost:8080/api/blog"
)


export default BlogLists