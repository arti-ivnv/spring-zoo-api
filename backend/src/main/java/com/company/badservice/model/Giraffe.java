package com.company.badservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.company.badservice.utils.interfaces.Animals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "t_giraffes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Giraffe implements Animals {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "giraffe_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "giraffe_name", nullable =  false)
    private String name;

    /**
     * Encrypted secret, is only decrypted if user knows passcode.
     */
    @Column(name = "giraffe_secrete")
    @Getter @Setter private String secret;

    @ManyToOne
    @JoinColumn(name = "zoo_id")
    @Getter @Setter public Zoo zoo;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
