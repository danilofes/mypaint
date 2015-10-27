package principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import figuras.Figura;

public class AreaDeDesenho extends JPanel {

	private List<Figura> figuras;
	private Figura figuraTemporaria;
	
	public AreaDeDesenho() {
		this.figuras = new ArrayList<Figura>();
		this.setPreferredSize(new Dimension(600, 400));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// desenha algumas figuras
		g.setColor(Color.BLUE);
		for (Figura f : figuras) {
			f.desenha(g);
		}
		if (figuraTemporaria != null) {
			figuraTemporaria.desenha(g);
		}
	}

	public void adicionaFigura(Figura f) {
		this.figuras.add(f);
	}

	public Figura getFiguraTemporaria() {
		return figuraTemporaria;
	}

	public void setFiguraTemporaria(Figura figuraTemporaria) {
		this.figuraTemporaria = figuraTemporaria;
	}
}
