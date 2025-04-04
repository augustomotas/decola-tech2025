package me.dio.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cpf;

    private String name;

    @OneToOne(cascade = CascadeType.ALL) //um nao existe sem o outro
    private Account account;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //fetch para puxar as features assim que vier a conta
    private List<Feature> features;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //fetch para puxar as features assim que vier a conta
    private List<Feature> news;

    public List<Feature> getNews() {
        return news;
    }

    public void setNews(List<Feature> news) {
        this.news = news;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Long getCpf() {
        return cpf;
    }
    public void setCpf(Long cpf) {
        this.cpf=cpf;
    }
}
