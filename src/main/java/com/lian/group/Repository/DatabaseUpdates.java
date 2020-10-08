package com.lian.group.Repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DatabaseUpdates {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void alterMyTableAddMyColumn(String tableName, String columnName,
                                        String columnType) {

        String query = "ALTER TABLE `" + tableName + "` ADD COLUMN `" + columnName + "` " +
                columnType;

        entityManager.createNativeQuery(query).executeUpdate();
    }

    /**
     * Resource Add column
     * @param columnName
     * @param columnType
     */
    @Transactional
    public void alterResourceAddColumn( String columnName,
                                         String columnType) {

        String query = "ALTER TABLE `resource` ADD COLUMN `" + columnName + "` " +
                columnType + " AFTER `resource_name`";

        entityManager.createNativeQuery(query).executeUpdate();
    }

    /**
     * Resource drop column
     * @param columnName
     *
     */
    @Transactional
    public void alterResourceDropColumn( String columnName) {

        String query = "ALTER TABLE `resource` DROP COLUMN `" + columnName + "` ";

        entityManager.createNativeQuery(query).executeUpdate();
    }

    /**
     * truncate table
     */
    @Transactional
    public void truncateResource() {
//        SET FOREIGN_KEY_CHECKS = 0;
//        TRUNCATE TABLE TABLE_E;
//        SET FOREIGN_KEY_CHECKS = 1;

        String query1 = "SET FOREIGN_KEY_CHECKS = 0" ;
        String query2 = "TRUNCATE TABLE `resource`";
        String query3 =  "SET FOREIGN_KEY_CHECKS = 1";

        entityManager.createNativeQuery(query1).executeUpdate();
        entityManager.createNativeQuery(query2).executeUpdate();
        entityManager.createNativeQuery(query3).executeUpdate();
    }

    @Transactional
    public List getColumns(){
//        SELECT `COLUMN_NAME`
//        FROM `INFORMATION_SCHEMA`.`COLUMNS`
//        WHERE `TABLE_SCHEMA`='yourdatabasename'
//        AND `TABLE_NAME`='yourtablename';

//        SELECT COLUMN_NAME FROM INFORMATION_SCHEMA WHERE TABLE_NAME = 'my_table';

        String query ="SELECT `COLUMN_NAME` FROM `INFORMATION_SCHEMA`.`COLUMNS` WHERE `TABLE_SCHEMA`='project' AND `TABLE_NAME` = 'resource'";
//        System.out.println(entityManager.createNativeQuery(query).getResultList());
        return entityManager.createNativeQuery(query).getResultList();
    }
}
