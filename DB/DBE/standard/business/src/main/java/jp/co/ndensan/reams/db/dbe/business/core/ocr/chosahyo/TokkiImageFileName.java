/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.KomokuNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項のイメージファイル名と対応する項目の番号のペアを持ちます。
 */
public final class TokkiImageFileName {

    private final RString theValue;
    private final KomokuNo theKomokuNo;

    TokkiImageFileName(RString theValue, KomokuNo komokuNo) {
        this.theValue = theValue;
        this.theKomokuNo = komokuNo;
    }

    /**
     * @return ファイル名の値
     */
    public RString value() {
        return this.theValue;
    }

    /**
     * @return 項目番号
     */
    public KomokuNo komokuNo() {
        return this.theKomokuNo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.theValue);
        hash = 79 * hash + Objects.hashCode(this.theKomokuNo);
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
        final TokkiImageFileName other = (TokkiImageFileName) obj;
        if (!Objects.equals(this.theValue, other.theValue)) {
            return false;
        }
        return Objects.equals(this.theKomokuNo, other.theKomokuNo);
    }

    @Override
    public String toString() {
        return "TokkiImageFileName{" + "theValue=" + theValue + ", theKomokuNo=" + theKomokuNo + '}';
    }
}
