package unicam.idshackhub.controller;

import org.hibernate.Session;

import java.util.Arrays;
import java.util.List;
import unicam.idshackhub.controller.persistence.HibernateConnection;

public abstract class AbstractController<T> implements Controller<T> {
    private final HibernateConnection hibernateConnection;
    private final Class<T> entityClass;

    /**
     * Costruttore della classe astratta.
     *
     * @param entityClass la classe dell'entità che si intende gestire
     */
    protected AbstractController(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.hibernateConnection = HibernateConnection.getInstance();
    }

    /**
     * Aggiunge una nuova entità al database.
     *
     * @param transaction l'entità da aggiungere
     * @throws RuntimeException se si verifica un errore durante il salvataggio
     */
    @Override
    public void add(T transaction) {
        try (var session = hibernateConnection.openSession()) {
            session.beginTransaction();
            session.persist(transaction);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Rimuove un'entità dal database dato il suo ID.
     *
     * @param id l'identificativo dell'entità da rimuovere
     * @throws RuntimeException se l'entità non viene trovata o si verifica un errore durante l'eliminazione
     */
    @Override
    public void remove(long id) {
        try (var session = hibernateConnection.openSession()) {
            session.beginTransaction();
            T entity = find(session, id);
            session.remove(entity);
            session.getTransaction().commit();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Restituisce tutte le entità del tipo gestito presenti nel database.
     *
     * @return una lista di tutte le entità presenti
     * @throws RuntimeException se si verifica un errore durante la lettura
     */
    @Override
    public List<T> get() {
        String hql = "From "+ entityClass.getSimpleName();
        try(var session = hibernateConnection.openSession()) {
            return session.createQuery(hql, entityClass).getResultList();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Aggiorna un'entità esistente con i campi non nulli dell'entità fornita.
     *
     * @param id l'ID dell'entità da aggiornare
     * @param entity l'entità contenente i nuovi valori
     * @throws RuntimeException se l'entità non viene trovata o si verifica un errore durante l'aggiornamento
     */
    @Override
    public void update(long id, T entity) {
        try (var session = hibernateConnection.openSession()) {
            session.beginTransaction();
            T existingEntity = find(session, id);
            copyNonNullFields(entity, existingEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Copia tutti i campi non nulli dall'entità sorgente all'entità di destinazione,
     * escludendo il campo 'id'.
     *
     * @param source entità sorgente con i nuovi valori
     * @param target entità di destinazione da aggiornare
     * @throws RuntimeException se si verifica un errore di accesso tramite riflessione
     */
    private void copyNonNullFields(T source, T target) {
        Class<?> clazz = source.getClass();
        while (clazz != null && clazz != Object.class) {
            Arrays.stream(clazz.getDeclaredFields())
                    .filter(f -> !f.getName().equals("id"))
                    .forEach(field -> {
                        try {
                            field.setAccessible(true);
                            field.set(target, field.get(source));
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException("Failed to copy field: " + field.getName(), e);
                        }
                    });
            clazz = clazz.getSuperclass();
        }
    }

    /**
     * Cerca un'entità nel database tramite il suo ID.
     *
     * @param session la sessione Hibernate in uso
     * @param id l'ID dell'entità da cercare
     * @return l'entità trovata
     * @throws RuntimeException se l'entità non viene trovata
     */
    private T find(Session session, long id) {
        T entity = session.find(entityClass, id);
        if (entity == null) {
            throw new RuntimeException("Entity with id " + id + " not found");
        }
        return entity;
    }
}