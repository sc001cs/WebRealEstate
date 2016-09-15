package web_real_estate.model.entities;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.xml.ws.soap.Addressing;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="users")
public class Users implements Serializable {

    private static final long serialVersionUID =  1L;

    @Id
    @GeneratedValue
    @Column(name="id_user", nullable=false)
    private Integer idUser;

    @Column (name="name", nullable = false, length = 80 )
    private String fullName;

    @Column (name="email", nullable = false, length = 80 )
    private String email;

    @Column (name="phone", nullable = false, length = 15 )
    private String phone;

    @Column (name="CPF", nullable = false, length = 14 )
    private String cpf;

    @Column (name="date_register", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRegister;

    @Column (name="date_birth", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateBirth;

    @Column(name = "username", unique=true, length = 25)
    private String username;

    @Column(name = "password", length = 40)
    private String password;

    @Column(name = "role", length = 36)
    private String role;

    @OneToOne(mappedBy = "users", fetch = FetchType.LAZY)
    @ForeignKey(name="id_user_foreign")
    private Address address;

    @ManyToOne(optional=false)
    @ForeignKey(name = "id_gender_foreign")
    @JoinColumn(name="id_gender", referencedColumnName = "id_gender")
    private Gender gender;

    public Users(String fullName, String email, String phone, String cpf, Date dateRegister, Date dateBirth, String username, String password, String role, Address address, Gender gender) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
        this.dateRegister = dateRegister;
        this.dateBirth = dateBirth;
        this.username = username;
        this.password = password;
        this.role = role;
        this.address = address;
        this.gender = gender;
    }

    public Users() {
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (idUser != null ? !idUser.equals(users.idUser) : users.idUser != null) return false;
        if (fullName != null ? !fullName.equals(users.fullName) : users.fullName != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (phone != null ? !phone.equals(users.phone) : users.phone != null) return false;
        if (cpf != null ? !cpf.equals(users.cpf) : users.cpf != null) return false;
        if (dateRegister != null ? !dateRegister.equals(users.dateRegister) : users.dateRegister != null) return false;
        if (dateBirth != null ? !dateBirth.equals(users.dateBirth) : users.dateBirth != null) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (role != null ? !role.equals(users.role) : users.role != null) return false;
        if (address != null ? !address.equals(users.address) : users.address != null) return false;
        return gender != null ? gender.equals(users.gender) : users.gender == null;

    }

    @Override
    public int hashCode() {
        int result = idUser != null ? idUser.hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (dateRegister != null ? dateRegister.hashCode() : 0);
        result = 31 * result + (dateBirth != null ? dateBirth.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}
