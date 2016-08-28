package edu.asu.diging.krake.core;

import java.util.List;

import edu.asu.diging.krake.core.impl.ContentLink;

public interface IDocument {

    public abstract String getCreator();

    public abstract void setCreator(String creator);

    public abstract String getTitle();

    public abstract void setTitle(String title);

    public abstract String getDate();

    public abstract void setDate(String date);

    public abstract List<ContentLink> getContentURIs();

    public abstract void setContentURIs(List<ContentLink> contentURIs);

    public abstract String getPresentationURI();

    public abstract void setPresentationURI(String presentationURI);

    public abstract String getRepositoryId();

    public abstract void setRepositoryId(String repositoryId);

}