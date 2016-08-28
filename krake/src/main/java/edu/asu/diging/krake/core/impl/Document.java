package edu.asu.diging.krake.core.impl;

import java.util.List;

import edu.asu.diging.krake.core.IDocument;

public class Document implements IDocument {

    private String creator;
    private String title;
    private String date;
    private List<ContentLink> contentURIs;
    private String presentationURI;
    private String repositoryId;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IDocument#getCreator()
     */
    @Override
    public String getCreator() {
        return creator;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IDocument#setCreator(java.lang.String)
     */
    @Override
    public void setCreator(String creator) {
        this.creator = creator;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IDocument#getTitle()
     */
    @Override
    public String getTitle() {
        return title;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IDocument#setTitle(java.lang.String)
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IDocument#getDate()
     */
    @Override
    public String getDate() {
        return date;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IDocument#setDate(java.lang.String)
     */
    @Override
    public void setDate(String date) {
        this.date = date;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IDocument#getContentURIs()
     */
    @Override
    public List<ContentLink> getContentURIs() {
        return contentURIs;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IDocument#setContentURIs(java.util.List)
     */
    @Override
    public void setContentURIs(List<ContentLink> contentURIs) {
        this.contentURIs = contentURIs;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IDocument#getPresentationURI()
     */
    @Override
    public String getPresentationURI() {
        return presentationURI;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IDocument#setPresentationURI(java.lang.String)
     */
    @Override
    public void setPresentationURI(String presentationURI) {
        this.presentationURI = presentationURI;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IDocument#getRepositoryId()
     */
    @Override
    public String getRepositoryId() {
        return repositoryId;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IDocument#setRepositoryId(java.lang.String)
     */
    @Override
    public void setRepositoryId(String repositoryId) {
        this.repositoryId = repositoryId;
    }
    
}
