package web_real_estate.managedBean;

import web_real_estate.model.dao.HibernateDAO;
import web_real_estate.model.dao.InterfaceDAO;
import web_real_estate.model.entities.Cidade;
import web_real_estate.util.FacesContextUtil;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbCidade")
@RequestScoped
public class BbCidade  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<Cidade> cidades;

    public List<Cidade> getCidades() {
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO.getEntities();
    }
}
