package it.polito.tdp.imdb.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.imdb.db.ImdbDAO;

public class Model {

	ImdbDAO dao = new ImdbDAO();
	Graph<Director, DefaultWeightedEdge> grafo;
	
	public String creaGrafo(int anno) {
		grafo= new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(this.grafo, dao.getDirectorsAnno(anno));
		for(Arco a : dao.getArchi(anno)) {
			Graphs.addEdge(this.grafo, a.getD1(), a.getD2(), a.getPeso());
		}
		return String.format("Grafo creato con %d vertici e %d archi",
				this.grafo.vertexSet().size(), this.grafo.edgeSet().size());
	}

	public List<Director> getDirectors(int anno) {
		// TODO Auto-generated method stub
		List<Director> ret = dao.getDirectorsAnno(anno);
		Collections.sort(ret);
		return ret ;
	}

	public String getAdiacenti(Director selezionato) {
		List<Adiacente> adiacenti = new ArrayList<>();
		String res="";
		for(Director d : Graphs.neighborListOf(this.grafo, selezionato)) {
			Adiacente temp = new Adiacente(d, 0);
			adiacenti.add(temp);
		}
		for(Adiacente a : adiacenti) {
			a.peso= (int) this.grafo.getEdgeWeight(this.grafo.getEdge(selezionato, a.d));
			res= res + a.toString();
		}
		
		return res;
	}

}
