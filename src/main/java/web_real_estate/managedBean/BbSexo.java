package web_real_estate.managedBean;

import web_real_estate.model.dao.HibernateDAO;
import web_real_estate.model.dao.InterfaceDAO;
import web_real_estate.model.entities.Sexo;
import web_real_estate.util.FacesContextUtil;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbSexo")
@RequestScoped
public class BbSexo  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<Sexo> getSexos(){
        InterfaceDAO<Sexo> sexoDAO = new HibernateDAO<Sexo>(Sexo.class, FacesContextUtil.getRequestSession());
        return sexoDAO.getEntities();
    }
    
}
