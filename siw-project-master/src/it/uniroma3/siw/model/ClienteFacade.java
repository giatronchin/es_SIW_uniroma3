package it.uniroma3.siw.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless(name="clienteFacade")
public class ClienteFacade {
	
	@PersistenceContext(unitName="progetto")
	private EntityManager em;
	
	public ClienteFacade() {
	}
	
	public Cliente creaCliente(String nome,String nickname,String password, String cognome, String email) {

		Cliente c = new Cliente(nome, nickname, password, cognome, email);
		this.em.persist(c);		
		return c;
	}
	
	public List<Cliente> getAllClienti() {

		try {
			TypedQuery<Cliente> q = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
			return q.getResultList();
		} 
		catch (Exception e) {
			String q = "La lista dei clienti � vuota";
			System.out.println(q);
			return null;
		}
	}
	
	public Cliente getClienteByID(long id) {

		try {
			TypedQuery<Cliente> q = em.createQuery("SELECT c FROM Cliente c WHERE c.id =: id", Cliente.class);
			q.setParameter("id", id);
			return q.getSingleResult();
		} 

		catch (Exception e) {
			String q = "Il cliente selezionato con " +id+ " non esiste";
			System.out.println(q);
			return null;
		}
	}

	public Cliente getClienteByEmail(String email) {

		try {
			TypedQuery<Cliente> q = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.email =: email", Cliente.class);
			q.setParameter("email", email);
			return q.getSingleResult();
		}

		catch (Exception e) {
			String q = "Il cliente con mail " +email+ " non � presente nel database";
			System.out.println(q);
			return null;
		}
	}

	
	public Cliente trovaClienteByEmailPwd(String email, String password) {
		
		try {
			TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.email =: email AND c.password =: password", Cliente.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			return query.getSingleResult();
		}
		
		catch (Exception e) {
				String q = "Il cliente con mail " +email+ " non � presente nel database";
				System.out.println(q);
				return null;
			}
		}

	public void updateCliente(Cliente c) {
		em.merge(c);
	}
	
	public void deleteCliente(Cliente c) {
		em.remove(c);
	}

	public void deleteClienteById(long id) {
		Cliente c = em.find(Cliente.class, id);
		deleteCliente(c);
	}
}
