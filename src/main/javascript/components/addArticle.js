import React, { Component } from 'react'
import {Editor} from 'react-draft-wysiwyg'
import {EditorState} from 'draft-js'
import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css';

class NewArticle extends Component{
    constructor(props){
        super(props)
        this.state = {
            atitle:'',
            editorState: EditorState.createEmpty(),

        };
        this.onChange = this.onChange.bind(this)
        this.onEditorStateChange = this.onEditorStateChange.bind(this)
    }

    onEditorStateChange(editorState) {
        this.setState({ editorState:editorState});
    }


    onChange(e) {
        this.setState({ [e.target.name]: e.target.value });
    }

    render(){

        return(
            <div className="add-article">
                <form>
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
                        EditorState={EditorState}
                        wrapperClassName="demo-wrapper"
                        editorClassName="demo-editor"
                        onEditorStateChagne={this.onEditorStateChange}
                    />
                    <br/>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
        )
    }
}
export default NewArticle


