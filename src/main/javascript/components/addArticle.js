import React, { Component } from 'react'
import {Editor} from 'react-draft-wysiwyg'
import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css';

const AddArticle = ()=>
    <div className="add-article">
        <form>
            <p>Add article name:</p>
            <input type="text" id="new-title" name="new-title"/><br/><br/>
            <p>Add article:</p>
            <Editor
                wrapperClassName="demo-wrapper"
                editorClassName="demo-editor"
            />
            <br/>
            <input type="submit" value="Submit"/>
        </form>
    </div>

export default AddArticle