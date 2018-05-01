package com.mo.test.sharding;

import io.shardingjdbc.core.api.algorithm.sharding.ShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;

import java.util.Collection;

/**
 * @author MoXingwang on 2018/4/30.
 */
public class CommonTabelComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection<String> collection, Collection<ShardingValue> collection1) {
        return null;
    }
}
