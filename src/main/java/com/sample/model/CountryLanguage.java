package com.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "country_language")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageID id;

    @Column(name = "is_official")
    private boolean isOfficial;


    public CountryLanguageID getId() {
        return id;
    }

    public void setId(CountryLanguageID id) {
        this.id = id;
    }

    public boolean getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(boolean isOfficial) {
        this.isOfficial = isOfficial;
    }

}
