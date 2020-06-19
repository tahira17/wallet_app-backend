package com.eadlab.wallet_app.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name acha not be blank")
    @Size(min =2, max=30)
    private String name;

    @Size(min =2, max=30)
    private String accountnumber;
    @Size(max=100)
    private String description;
    @Min(1)
    @Max(3)
    private Integer priority;
private Double currentbalance;

@OneToMany (cascade = CascadeType.ALL , fetch =FetchType.LAZY, mappedBy = "wallet", orphanRemoval = false)
@JsonIgnore
private List<Transaction> transactions;

@PrePersist
    public void setbal(){
    this.currentbalance=new Double(0);
}

}
