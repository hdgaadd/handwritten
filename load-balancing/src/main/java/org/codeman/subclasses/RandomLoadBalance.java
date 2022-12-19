package org.codeman.subclasses;

import org.codeman.AbstractLoadBalance;
import org.codeman.model.Instance;

import java.security.SecureRandom;
import java.util.List;

/**
 * @author hdgaadd
 * created on 2022/10/25
 */
public class RandomLoadBalance extends AbstractLoadBalance<Instance> {

    SecureRandom RANDOM = new SecureRandom();

    public Instance doLoad(final List<Instance> instances) {
        return instances.get(RANDOM.nextInt(instances.size()));
    }
}
