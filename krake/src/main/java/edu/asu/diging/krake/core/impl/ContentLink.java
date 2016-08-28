package edu.asu.diging.krake.core.impl;

import edu.asu.diging.krake.core.IContentLink;

public class ContentLink implements IContentLink {

    private String type;
    private String URI;
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IContentLink#getType()
     */
    @Override
    public String getType() {
        return type;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IContentLink#setType(java.lang.String)
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IContentLink#getURI()
     */
    @Override
    public String getURI() {
        return URI;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.krake.core.impl.IContentLink#setURI(java.lang.String)
     */
    @Override
    public void setURI(String uRI) {
        URI = uRI;
    }
    
    
}
