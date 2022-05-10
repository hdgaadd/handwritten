package org.codeman.session;

/**
 * @author hdgaadd
 * Created on 2022/02/25
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
