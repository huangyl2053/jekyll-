/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ocr;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 *
 */
public enum TreatmentWhenTokkiRembanChofuku {

    /**
     *
     */
    上書きする("1"),
    /**
     *
     */
    上書きしない("2");

    private final RString theCode;

    private TreatmentWhenTokkiRembanChofuku(String code) {
        this.theCode = new RString(code);
    }

    /**
     * @return コード
     */
    public RString code() {
        return this.theCode;
    }

    /**
     * @param code コード
     * @return 指定のコードに該当する{@link TreatmentWhenTokkiRembanChofuku}
     */
    public static TreatmentWhenTokkiRembanChofuku toValue(RString code) {
        for (TreatmentWhenTokkiRembanChofuku v : values()) {
            if (v.theCode.equals(code)) {
                return v;
            }
        }
        throw new IllegalArgumentException(
                new RStringBuilder().append("指定のコードに該当する要素は存在しません。 code:").append(code).toString());
    }
}
