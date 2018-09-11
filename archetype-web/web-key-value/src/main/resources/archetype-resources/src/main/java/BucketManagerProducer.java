/*
 * Copyright (c) 2018 Otávio Santana and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 *
 * Contributors:
 *
 * Otavio Santana
 */
package $package;

import org.jnosql.diana.api.key.BucketManager;
import org.jnosql.diana.api.key.BucketManagerFactory;
import org.jnosql.diana.api.key.KeyValueConfiguration;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class BucketManagerProducer {

    private static final String BUCKET = "developers";

    private BucketManagerFactory<BucketManager> managerFactory;

    @PostConstruct
    public void init() {
        KeyValueConfiguration<?> configuration = getConfiguration();
        managerFactory = configuration.get();
    }

    @Produces
    public BucketManager getManager() {
        return managerFactory.getBucketManager(BUCKET);

    }

    private KeyValueConfiguration<?> getConfiguration() {
        throw new UnsupportedOperationException("Don't forget to add a driver as dependency and set its implementation here.");
    }
}