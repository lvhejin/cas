package org.apereo.cas.configuration.model.support.mongo;

import org.apereo.cas.configuration.support.RequiredProperty;
import org.apereo.cas.configuration.support.RequiresModule;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * This is {@link BaseMongoDbProperties}.
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@Getter
@Setter
@RequiresModule(name = "cas-server-support-mongo-core")
public abstract class BaseMongoDbProperties implements Serializable {

    private static final long serialVersionUID = -2471243083598934186L;

    /**
     * core connection-related settings.
     */
    private MongoDbConnections conns = new MongoDbConnections();

    /**
     * The connection uri to the mongodb instance.
     * This typically takes on the form of {@code mongodb://user:psw@ds135522.somewhere.com:35522/db}.
     * If not specified, will fallback onto other individual settings.
     * If specified, takes over all other settings where applicable.
     */
    @RequiredProperty
    private String clientUri = StringUtils.EMPTY;

    /**
     * MongoDb database port.
     */
    @RequiredProperty
    private int port = 27017;

    /**
     * MongoDb database user for authentication.
     */
    @RequiredProperty
    private String userId = StringUtils.EMPTY;

    /**
     * MongoDb database password for authentication.
     */
    @RequiredProperty
    private String password = StringUtils.EMPTY;

    /**
     * MongoDb database host for authentication.
     * Multiple host addresses may be defined, separated by comma.
     * If more than one host is defined, it is assumed that each host contains the port as well, if any.
     * Otherwise the configuration may fallback onto the port defined.
     */
    @RequiredProperty
    private String host = "localhost";

    /**
     * MongoDb database connection timeout.
     */
    private String timeout = "PT5S";

    /**
     * MongoDb database connection idle timeout.
     */
    private String idleTimeout = "PT30S";

    /**
     * Write concern describes the level of acknowledgement requested from
     * MongoDB for write operations to a standalone
     * mongo db or to replica sets or to sharded clusters. In sharded clusters,
     * mongo db instances will pass the write concern on to the shards.
     */
    private String writeConcern = "ACKNOWLEDGED";

    /**
     * MongoDb database instance name.
     */
    @RequiredProperty
    private String databaseName = StringUtils.EMPTY;

    /**
     * Whether the database socket connection should be tagged with keep-alive.
     */
    private boolean socketKeepAlive;

    /**
     * Name of the database to use for authentication.
     */
    private String authenticationDatabaseName;

    /**
     * A replica set in MongoDB is a group of {@code mongod} processes that maintain
     * the same data set. Replica sets provide redundancy and high availability, and are the basis for all production deployments.
     */
    private String replicaSet;

    /**
     * Whether connections require SSL.
     */
    private boolean sslEnabled;

    @Getter
    @Setter
    public static class MongoDbConnections implements Serializable {

        private static final long serialVersionUID = -2398415870062168474L;

        /**
         * Maximum number of connections to keep around.
         */
        private int lifetime = 60_000;

        /**
         * Total number of connections allowed per host.
         */
        private int perHost = 10;
    }
}
