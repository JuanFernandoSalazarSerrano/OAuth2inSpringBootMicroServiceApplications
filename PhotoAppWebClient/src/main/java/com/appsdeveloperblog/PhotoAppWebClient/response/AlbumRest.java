/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.PhotoAppWebClient.response;

public class AlbumRest {
    private String userId;
    private String photoId;
    private String albumId;
    private String albumTitle;
    private String albumDescription;
    private String albumUrl;

    

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /**
     * @return the albumId
     */
    public String getalbumId() {
        return albumId;
    }

    /**
     * @param albumId the albumId to set
     */
    public void setalbumId(String albumId) {
        this.albumId = albumId;
    }

    /**
     * @return the albumId
     */
    public String getAlbumId() {
        return albumId;
    }

    /**
     * @param albumId the albumId to set
     */
    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    /**
     * @return the albumTitle
     */
    public String getalbumTitle() {
        return albumTitle;
    }

    /**
     * @param albumTitle the albumTitle to set
     */
    public void setalbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    /**
     * @return the albumDescription
     */
    public String getalbumDescription() {
        return albumDescription;
    }

    /**
     * @param albumDescription the albumDescription to set
     */
    public void setalbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }

    /**
     * @return the albumUrl
     */
    public String getalbumUrl() {
        return albumUrl;
    }

    /**
     * @param albumUrl the albumUrl to set
     */
    public void setalbumUrl(String albumUrl) {
        this.albumUrl = albumUrl;
    }

}
