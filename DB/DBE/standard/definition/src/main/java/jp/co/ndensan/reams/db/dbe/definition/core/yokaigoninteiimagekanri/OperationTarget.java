/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri;

import java.util.Objects;

/**
 *
 */
@lombok.AllArgsConstructor(access = lombok.AccessLevel.PACKAGE)
public class OperationTarget {

    private final ImageType aType;
    private final boolean deletesMaskOnlyFlag;

    public ImageType type() {
        return this.aType;
    }

    public boolean deletesMaskOnly() {
        return this.deletesMaskOnlyFlag;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.aType);
        hash = 67 * hash + (this.deletesMaskOnlyFlag ? 1 : 0);
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
        if (this.deletesMaskOnlyFlag != other.deletesMaskOnlyFlag) {
            return false;
        }
        return true;
    }

}
