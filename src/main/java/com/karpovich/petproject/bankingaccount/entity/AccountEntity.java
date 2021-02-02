package com.karpovich.petproject.bankingaccount.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "bank_account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal balance;

    @Column
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "accountEntity")
    private Set<TransactionEntity> transactionEntitySet;

    public AccountEntity(BigDecimal balance, AccountType type, UserEntity userEntity) {
        this.balance = balance;
        this.type = type;
        this.userEntity = userEntity;
    }

    public AccountEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Set<TransactionEntity> getTransactionHistoryEntitySet() {
        return transactionEntitySet;
    }

    public void setTransactionHistoryEntitySet(Set<TransactionEntity> transactionEntitySet) {
        this.transactionEntitySet = transactionEntitySet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", balance=" + balance +
                ", type=" + type +
                ", userEntity=" + userEntity +
                '}';
    }
}
