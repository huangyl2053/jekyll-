/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 */
public final class OperationTargets implements Iterable<OperationTarget> {

    private final Set<OperationTarget> targets;

    private OperationTargets(Builder builder) {
        this.targets = builder.targets;
    }

    @Override
    public Iterator<OperationTarget> iterator() {
        return this.targets.iterator();
    }

    public static final class Builder {

        private final Set<OperationTarget> targets;

        public Builder() {
            this.targets = new HashSet<>();
        }

        public Builder add(ImageType type, boolean deletesMaskOnly) {
            this.targets.add(new OperationTarget(type, deletesMaskOnly));
            return this;
        }

        public OperationTargets build() {
            return new OperationTargets(this);
        }
    }
}
