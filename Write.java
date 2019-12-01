package com.example.dbtest;

public class Write {
    public String texttitle;
    public String editdetail;
    public String usertextreason;

    public Write(){

    }

    public Write(String texttitle, String editdetail,String usertextreason){
        this.texttitle=texttitle;
        this.editdetail=editdetail;
        this.usertextreason=usertextreason;
    }

    public String getTexttitle() {return texttitle; }

    public String getEditdetail() {
        return editdetail;
    }

    public String getUsertextreason() {return usertextreason;}
}
