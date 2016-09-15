package web_real_estate.model.entities;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id_address")
    private int idAddress;

    @Column(name = "complement")
    private Integer complement;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private Integer number;

    @Column(name = "zip")
    private int zip;

    @OneToOne(optional=true, fetch= FetchType.LAZY)
    @ForeignKey(name="id_user_foreign")
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private Users user;

    public Address(int idAddress, Integer complement, String street, Integer number, int zip, Users user) {
        this.idAddress = idAddress;
        this.complement = complement;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.user = user;
    }

    public Address() {
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public Integer getComplement() {
        return complement;
    }

    public void setComplement(Integer complement) {
        this.complement = complement;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (idAddress != address.idAddress) return false;
        if (zip != address.zip) return false;
        if (complement != null ? !complement.equals(address.complement) : address.complement != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (number != null ? !number.equals(address.number) : address.number != null) return false;
        return user != null ? user.equals(address.user) : address.user == null;

    }

    @Override
    public int hashCode() {
        int result = idAddress;
        result = 31 * result + (complement != null ? complement.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + zip;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
