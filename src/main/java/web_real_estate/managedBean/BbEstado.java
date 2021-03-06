package web_real_estate.managedBean;

import web_real_estate.model.dao.HibernateDAO;
import web_real_estate.model.dao.InterfaceDAO;
import web_real_estate.model.entities.Estado;
import web_real_estate.util.FacesContextUtil;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbEstado")
@RequestScoped
public class BbEstado  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public List<Estado> getEstados() {
        InterfaceDAO<Estado> estadoDAO = new HibernateDAO<Estado>(Estado.class, FacesContextUtil.getRequestSession());
        return estadoDAO.getEntities();
    }	
}