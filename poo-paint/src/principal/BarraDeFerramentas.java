package principal;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class BarraDeFerramentas extends JToolBar {

	ButtonGroup grupo;
	private Ferramenta ferramenta;
	
	public BarraDeFerramentas() {
		super("Barra de Ferramentas");
		this.grupo = new ButtonGroup();
		
		Ferramenta[] ferramentas = new Ferramenta[]{
			new FerramentaElipse(this),
			new FerramentaRetangulo(this),
			new FerramentaLinha(this)
		};
		for (Ferramenta f : ferramentas) {
			criarBotao(f);
		}
		this.setFloatable(false);
	}

	private JToggleButton criarBotao(Ferramenta ferramenta) {
		JToggleButton botao = new JToggleButton(ferramenta.getNome());
		botao.addActionListener(ferramenta);
		grupo.add(botao);
		this.add(botao);
		if (ferramenta.ehFerramentaPadrao()) {
			botao.getModel().setPressed(true);
			this.ferramenta = ferramenta;
		}
		return botao;
	}
	
	public Ferramenta leFerramentaSelecionada() {
		return this.ferramenta;
	}

	public void setFerramentaAtiva(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}

}
