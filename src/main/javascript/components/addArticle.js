import React from 'react'

const AddArticle = ()=>
    <div className="add-article">
        <form>
            <p>Add article name:</p>
            <input type="text" id="new-title" name="new-title"/><br/><br/>
            <p>Add article:</p>
            <textarea id="new-article" name="new-article" rows="32" cols="190" placeholder="type your article here..."/><br/>
            <input type="submit" value="Submit"/>
        </form>
    </div>

export default AddArticle