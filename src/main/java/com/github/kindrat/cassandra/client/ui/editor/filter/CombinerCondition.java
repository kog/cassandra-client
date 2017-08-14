package com.github.kindrat.cassandra.client.ui.editor.filter;

import com.github.kindrat.cassandra.client.filter.Operator;

import java.util.Optional;
import java.util.Set;

import static java.util.Arrays.stream;

public class CombinerCondition implements StateCondition {
    @Override
    public boolean isCurrentState(String[] words, Set<String> columnNames) {
        Optional<String> secondFromHead = wordAtPosition(words, -2);
        return secondFromHead.isPresent()
                && stream(Operator.values()).anyMatch(operator -> operator.getValue().equals(secondFromHead.get()));
    }

    @Override
    public State name() {
        return State.COMBINER;
    }
}