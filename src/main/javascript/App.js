import React, { Component } from 'react';
class App extends Component{
    constructor(props){
        super(props);
        this.state ={
            data:[],
            loaded:false,
            loading:false
        }
    }

    componentWillMount(){
        this.setState({loading:true});
        fetch('http://localhost:8080/api/blog',{
            method: 'GET'
        })
            .then(response => response.json())
            .then(blog => {
                this.setState({
                loaded:true,
                loading:false,
                data: blog
            })})
    }

    render(){
        const {data,loading,loaded} = this.state;
        return(loading) ?
            <div>Loading</div>:
            <ol className="blog-list">
                {data.map((blog,i) => {
                    const {title,body} = blog;
                    return <li key={i}>
                        <h3>{title}</h3>
                        <p>{body}</p>
                    </li>
                })}
            </ol>
    }
}
export default App;