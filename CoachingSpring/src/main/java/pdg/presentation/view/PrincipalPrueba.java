package pdg.presentation.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.commandbutton.CommandButton;

@ManagedBean
@ViewScoped
public class PrincipalPrueba  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CommandButton btnCoachee;
	private CommandButton btnCoach;
	
	
	
	
	public CommandButton getBtnCoachee() {
		return btnCoachee;
	}


	public void setBtnCoachee(CommandButton btnCoachee) {
		this.btnCoachee = btnCoachee;
	}


	public CommandButton getBtnCoach() {
		return btnCoach;
	}


	public void setBtnCoach(CommandButton btnCoach) {
		this.btnCoach = btnCoach;
	}


	public String mostrarCoachee() {
		System.out.println("Hola-------------------------------------------------------------------------------");
		return "/Coachee/tipoDocumento.xhtml";
	}
	
	
	public String mostrarCoach() {
		
		
		return "/Coach/parametro.xhtml";
	}
	
}
