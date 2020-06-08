import React, { Component } from 'react'
import {Editor} from 'react-draft-wysiwyg'
import {EditorState} from 'draft-js'
import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css';
import {postData} from '../modules/postData.js'

class NewArticle extends Component{
    constructor(props){
        super(props);
        this.state = {
            ATitle:"",
            contentState:{}
        };
        this.onChange = this.onChange.bind(this)
        this.onContentStateChange = this.onContentStateChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
    }

    onContentStateChange(contentState) {
        this.setState({ contentState,});
        console.log(contentState.blocks[0].text)
    }

    onChange(e) {
        this.setState({ ATitle: e.target.value });
        console.log(e.target.value)
    }

    onSubmit(e) {
        e.preventDefault();
        // get our form data out of state
        let { ATitle, contentState } = this.state;

        // axios.post('http://localhost:8080/api/blog/addBlog', { ATitle, editorState })
        //     .then((result) => {
        //         console.log(result)
        //     });

        let data = JSON.parse(`{"title":"${ATitle}","body":"${contentState.blocks[0].text}"}`)
        postData('http://localhost:8080/api/blog/addBlog', data)
            .then(data => console.log(data)) // JSON from `response.json()` call
            .catch(error => console.error(error))

    }

    render(){
        const { contentState } = this.state;
        return(
            <div className="add-article">
                <form onSubmit={this.onSubmit}>
                    <p>Add article name:</p>
                    <input
                        type="text"
                        id="atitle"
                        name="atitle"
                        onChange={this.onChange}
                    />
                    <br/><br/>
                    <p>Add article:</p>
                    <Editor
                        // initialContentState={contentState}
                        wrapperClassName="demo-wrapper"
                        editorClassName="demo-editor"
                        onContentStateChange={this.onContentStateChange}
                    />
                    <br/>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
        )
    }
}
export default NewArticle


