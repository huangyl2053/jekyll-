/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri;

import java.util.Objects;

/**
 * イメージ情報管理での、イメージ削除やイメージ出力の処理対象です。
 */
public final class OperationTarget {

    private final ImageType aType;
    private final DeletionMethod aDeletionMethod;

    OperationTarget(ImageType aType, DeletionMethod aDeletionMethod) {
        this.aType = aType;
        this.aDeletionMethod = aDeletionMethod;
    }

    /**
     * @return イメージの種類
     */
    public ImageType type() {
        return this.aType;
    }

    /**
     * @return 削除の方法
     */
    public DeletionMethod deletionMethod() {
        return this.aDeletionMethod;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.aType);
        hash = 41 * hash + Objects.hashCode(this.aDeletionMethod);
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
        final OperationTarget other = (OperationTarget) obj;
        if (this.aType != other.aType) {
            return false;
        }
        return this.aDeletionMethod == other.aDeletionMethod;
    }

}
