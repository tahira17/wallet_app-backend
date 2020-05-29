package com.eadlab.wallet_app.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    private String accnumber;
    @Size(max=100)
    private String desp;
    @Min(1)
    @Max(3)
    private Integer priority;
private Double curr_balance;
@PrePersist
    public void setbal(){
    this.curr_balance=new Double(0);
}

}
