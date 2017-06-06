/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.createtarget;

import java.util.Objects;

/**
 * NCI認定情報のキーです。
 */
public final class NCINinteiKey {

    private static final int MIN_EDABAN = 0;
    private static final int MAX_EDABAN = 9;
    private final NCINinteiSubKey subKey;
    private final int 枝番;

    private NCINinteiKey(NCINinteiSubKey subKey) {
        this.subKey = subKey;
        this.枝番 = MIN_EDABAN;
    }

    /**
     * @param subKey {@link NCINinteiSubKey}
     * @return 最初のキー
     */
    static NCINinteiKey first(NCINinteiSubKey subKey) {
        return new NCINinteiKey(subKey);
    }

    private NCINinteiKey(NCINinteiKey key) {
        this.subKey = key.subKey;
        this.枝番 = key.枝番 + 1;
    }

    /**
     * @return 次のキーを返します。
     */
    public NCINinteiKey next() {
        return new NCINinteiKey(this);
    }

    /**
     * @return 正常なキーである場合、{@code true}.
     */
    public boolean isValid() {
        return MIN_EDABAN <= this.枝番 && this.枝番 <= MAX_EDABAN;
    }

    /**
     * @return 枝番
     */
    public int edaban() {
        return this.枝番;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.subKey);
        hash = 11 * hash + this.枝番;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NCINinteiKey other = (NCINinteiKey) obj;
        if (!Objects.equals(this.subKey, other.subKey)) {
            return false;
        }
        return this.枝番 == other.枝番;
    }

}
