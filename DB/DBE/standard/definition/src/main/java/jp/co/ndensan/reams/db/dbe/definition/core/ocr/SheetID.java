/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ocr;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * シートIDです。
 */
public class SheetID {

    /**
     * 空の値です。
     */
    public static final SheetID EMPTY;

    static {
        EMPTY = new SheetID(RString.EMPTY);
    }

    public final RString theValue;

    /**
     * @param value シートIDの値
     */
    public SheetID(RString value) {
        this.theValue = value;
    }

    /**
     * @return 値
     */
    public RString value() {
        return this.theValue;
    }

    /**
     * @return カタログファイルの検索時に用いる下8桁の値
     */
    public RString get帳票一連ID下8桁() {
        int length = value().length();
        int beginIndex = length - 8;
        return this.value().substringEmptyOnError(beginIndex < 0 ? 0 : beginIndex, length);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.theValue);
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
        final SheetID other = (SheetID) obj;
        return true;
    }
}
