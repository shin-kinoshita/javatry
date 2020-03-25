package org.docksidestage.javatry.basic.st6.dbms;

/**
 * @author subaru
 */
public abstract class St6AbstractSql {
    abstract String generatePagingQuery(int pageSize, int offset);

    public String buildPagingQuery(int pageSize, int pageNumber) {
        int offset = pageSize * (pageNumber - 1);
        return generatePagingQuery(pageSize, offset);
    }
}
