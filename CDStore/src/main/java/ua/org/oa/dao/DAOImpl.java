package ua.org.oa.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import ua.org.oa.model.Disc;
import ua.org.oa.model.Genre;

import java.util.List;

@Transactional
public class DAOImpl implements DAO {

	private SessionFactory sessionFactory;

	public DAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public <T> T save(final T o) {

		return (T) sessionFactory.getCurrentSession().save(o);
	}

	public <T> boolean delete(final Class<T> type, final Integer id) {

		System.out.println("delete method");
		Disc disc = (Disc) sessionFactory.getCurrentSession().get(type, id);
		sessionFactory.getCurrentSession().delete(disc);

		return true;

	}

	@SuppressWarnings("unchecked")
	public <T> T get(final Class<T> type, final Integer id) {
		return (T) sessionFactory.getCurrentSession().get(type, id);
	}

	public <T> void saveOrUpdate(final T o) {
		sessionFactory.getCurrentSession().saveOrUpdate(o);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(final Class<T> type) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria crit = session.createCriteria(type);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Disc> findByNameDisc(String name) {

		return sessionFactory
				.getCurrentSession()
				.createCriteria(Disc.class)
				.add(Restrictions.like("name", name, MatchMode.ANYWHERE)
						.ignoreCase()).list();
	}

	@SuppressWarnings("unchecked")
	public List<Disc> search(String name, String typeID, String genreID) {
		if (typeID.equals("0")) {
			return sessionFactory
					.getCurrentSession()
					.createCriteria(Disc.class)
					.add(Restrictions.like("name", name, MatchMode.ANYWHERE)
							.ignoreCase()).list();
		} else if (genreID.equals("0")) {
			return sessionFactory
					.getCurrentSession()
					.createCriteria(Disc.class)
					.add(Restrictions.like("name", name, MatchMode.ANYWHERE)
							.ignoreCase())
					.add(Restrictions.like("type.id", Integer.parseInt(typeID)))
					.list();
		} else {
			return sessionFactory
					.getCurrentSession()
					.createCriteria(Disc.class)
					.add(Restrictions.like("name", name, MatchMode.ANYWHERE)
							.ignoreCase())
					.add(Restrictions.like("type.id", Integer.parseInt(typeID)))
					.add(Restrictions.like("genre.id",
							Integer.parseInt(genreID))).list();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Genre> findByTypeID(String typeID) {
		return sessionFactory.getCurrentSession().createCriteria(Genre.class)
				.add(Restrictions.like("type.id", Integer.parseInt(typeID)))
				.list();
	}

	public Disc getLastDisc(final Integer genreid) {

		List list = sessionFactory.getCurrentSession()
				.createCriteria(Disc.class).addOrder(Order.desc("id"))
				.setMaxResults(1).add(Restrictions.like("genre.id", genreid))
				.add(Restrictions.isNotNull("image")).list();

		return (Disc) list.get(0);
	}

}