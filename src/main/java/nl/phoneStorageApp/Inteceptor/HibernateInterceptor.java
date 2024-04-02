package nl.phoneStorageApp.Inteceptor;

import io.micronaut.aop.InterceptorBean;
import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.websocket.WebSocketSession;
import jakarta.inject.Singleton;
import nl.phoneStorageApp.model.ApplicationFacade;
import nl.phoneStorageApp.module.Action;
import nl.phoneStorageApp.persistance.utils.HibernateSessionManager;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Singleton
@InterceptorBean(Hibernate.class)
public class HibernateInterceptor implements MethodInterceptor<WebSocketSession, Action> {
    @Override
    public Action intercept(MethodInvocationContext<WebSocketSession, Action> context) {
        Session session = HibernateSessionManager.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Action result = null;

        try {
            result = context.proceed();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            ApplicationFacade.setInstance(null);
        }
        return result;
    }

}
