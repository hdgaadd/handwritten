package org.codeman.subclasses;

import org.codeman.AbstractLoadBalance;
import org.codeman.model.Instance;

import java.security.SecureRandom;
import java.util.List;

/**
 * @author hdgaadd
 * created on 2022/10/25
 */
public class CustomLoadBalance extends AbstractLoadBalance<Instance> {

    public Instance doLoad(final List<Instance> instances) {
        return instances.get(0);
    }
}
