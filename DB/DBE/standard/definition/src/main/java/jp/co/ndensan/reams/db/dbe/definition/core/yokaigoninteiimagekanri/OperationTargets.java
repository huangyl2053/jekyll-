/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 複数の{@link OperationTarget}を保持します。
 */
public final class OperationTargets implements Iterable<OperationTarget> {

    private final Map<ImageType, OperationTarget> targets;

    private OperationTargets(Builder builder) {
        this.targets = builder.targets;
    }

    @Override
    public Iterator<OperationTarget> iterator() {
        return this.targets.values().iterator();
    }

    /**
     * @param imageType イメージの種類
     * @return 指定された種類のイメージを含む場合、{@code true}.
     */
    public boolean contains(ImageType imageType) {
        return this.targets.containsKey(imageType);
    }

    /**
     * {@link OperationTargets}のビルダです。
     */
    public static final class Builder {

        private final Map<ImageType, OperationTarget> targets;

        /**
         * インスタンスを生成します。
         */
        public Builder() {
            this.targets = new HashMap<>();
        }

        /**
         * @param type イメージの種類
         * @param deletionMethod 削除の方法
         * @return ビルダ
         */
        public Builder add(ImageType type, DeletionMethod deletionMethod) {
            this.targets.put(type, new OperationTarget(type, deletionMethod));
            return this;
        }

        /**
         * @return {@link OperationTargets}
         */
        public OperationTargets build() {
            return new OperationTargets(this);
        }
    }
}
