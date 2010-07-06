package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StringLengthFunction extends AbstractFunction<Double> {

    private static final String FUNCTION_NAME = "string-length";


    public Atom<Double> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() == 1) {
            String string = (String) parameters.get(0).compute().getValue();
            return new Atom<Double>((double) string.length());
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}