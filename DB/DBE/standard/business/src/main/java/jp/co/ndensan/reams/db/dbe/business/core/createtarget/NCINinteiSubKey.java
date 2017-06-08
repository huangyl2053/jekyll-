/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.createtarget;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * NCI認定情報のキーです。
 */
final class NCINinteiSubKey {

    private final RString 保険者番号;
    private final RString 被保険者番号;
    private final RString 認定申請日;

    NCINinteiSubKey(RString 保険者番号, RString 被保険者番号, RString 認定申請日) {
        this.保険者番号 = 保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.認定申請日 = 認定申請日;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.保険者番号);
        hash = 73 * hash + Objects.hashCode(this.被保険者番号);
        hash = 73 * hash + Objects.hashCode(this.認定申請日);
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
        final NCINinteiSubKey other = (NCINinteiSubKey) obj;
        if (!Objects.equals(this.保険者番号, other.保険者番号)) {
            return false;
        }
        if (!Objects.equals(this.被保険者番号, other.被保険者番号)) {
            return false;
        }
        return Objects.equals(this.認定申請日, other.認定申請日);
    }

}
