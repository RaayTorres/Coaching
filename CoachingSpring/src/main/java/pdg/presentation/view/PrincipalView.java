package pdg.presentation.view;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import pdg.utilities.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
@ViewScoped
@ManagedBean(name = "PrincipalView")
public class PrincipalView {


	public String clientesAction() {
		return "/XHTML/gestionCoacheeView.xhtml";
	}
	
	public String perfilAction() {
		return "/XHTML/coach.xhtml";
	}
	public String pagosAction() {
		return "/XHTML/principal.xhtml";
	}
	public String procesosAction() {
		return "/XHTML/procCoachingListDataTable.xhtml";
	}
	
	
	 private List<String> images;
     
	    @PostConstruct
	    public void init() {
	        images = new ArrayList<String>();
	        for (int i = 1; i <= 12; i++) {
	            images.add("icon" + i + ".png");
	        }
	    }
	 
	    public List<String> getImages() {
	        return images;
	    }
	
	 
	}


