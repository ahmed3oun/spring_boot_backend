package com.spring.recrutement.payload;

public class DocumentRequest {
    private String gouvernement_nom;

    private long siteRadio_id;


    private String typeDoc ;

    
    private String fileUrl ;

    


    

    public String getGouvernement_nom() {
        return gouvernement_nom;
    }


    public void setGouvernement_nom(String gouvernement_nom) {
        this.gouvernement_nom = gouvernement_nom;
    }


    public long getSiteRadio_id() {
        return siteRadio_id;
    }


    public void setSiteRadio_id(long siteRadio_id) {
        this.siteRadio_id = siteRadio_id;
    }


    public String getTypeDoc() {
        return typeDoc;
    }


    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }


    public String getFileUrl() {
        return fileUrl;
    }


    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    
}
