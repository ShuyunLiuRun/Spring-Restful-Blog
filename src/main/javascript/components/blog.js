import React from 'react'

const Blog = ({title,body,id}) =>
    <div className="single-blog">
        <h3 className="blog-title" id={id}>{title}</h3>
        <p>{body}</p>
    </div>

export default Blog