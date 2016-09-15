package web_real_estate.model.entities;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="gender")
public class Gender implements Serializable {

    private static final long serialVersionUID =  1L;

    @Id
    @GeneratedValue
    @Column(name="id_gender",nullable=false)
    private Integer idSexo;

    @Column(name="description", unique=true, nullable=false, length=9)
    private String descricao;

    @OneToMany(mappedBy = "gender", fetch = FetchType.LAZY)
    @ForeignKey(name = "id_gender_foreign")
    private List<Users> users;

    public Gender(String descricao, List<Users> users) {
        this.descricao = descricao;
        this.users = users;
    }

    public Gender() {
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gender gender = (Gender) o;

        if (idSexo != null ? !idSexo.equals(gender.idSexo) : gender.idSexo != null) return false;
        if (descricao != null ? !descricao.equals(gender.descricao) : gender.descricao != null) return false;
        return users != null ? users.equals(gender.users) : gender.users == null;

    }

    @Override
    public int hashCode() {
        int result = idSexo != null ? idSexo.hashCode() : 0;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }
}
