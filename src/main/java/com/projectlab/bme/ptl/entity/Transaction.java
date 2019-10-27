package com.projectlab.bme.ptl.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transaction_id;

    @Column(name = "transaction_name")
    private String transaction_name;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "transaction_week_id")
    private Week transaction_week_id;

    @Column(name = "transaction_amount")
    private int transaction_amount;

    @Column(name = "transaction_span")
    private int transaction_span;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.REFRESH
    })

    @JoinColumn(name = "transaction_atm_id")
    private Atm transaction_atm_id;

    public Atm getTransaction_atm_id() {
        return transaction_atm_id;
    }

    public void setTransaction_atm_id(Atm transaction_atm_id) {
        this.transaction_atm_id = transaction_atm_id;
    }

    public String getTransaction_name() {
        return transaction_name;
    }

    public void setTransaction_name(String transaction_name) {
        this.transaction_name = transaction_name;
    }

    public Week getTransaction_week_id() {
        return transaction_week_id;
    }

    public void setTransaction_week_id(Week transaction_week_id) {
        this.transaction_week_id = transaction_week_id;
    }

    public int getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(int transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public int getTransaction_span() {
        return transaction_span;
    }

    public void setTransaction_span(int transaction_span) {
        this.transaction_span = transaction_span;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", transaction_name='" + transaction_name + '\'' +
                ", transaction_week_id=" + transaction_week_id +
                ", transaction_amount=" + transaction_amount +
                ", transaction_span=" + transaction_span +
                '}';
    }
}
