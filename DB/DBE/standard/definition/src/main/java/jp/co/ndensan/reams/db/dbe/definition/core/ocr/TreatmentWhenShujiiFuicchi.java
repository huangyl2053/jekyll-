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
public enum TreatmentWhenShujiiFuicchi {

    /**
     * エラーとする
     */
    エラーとする("1"),
    /**
     * エラーとしない
     */
    エラーとしない("2");

    private final RString theCode;

    private TreatmentWhenShujiiFuicchi(String code) {
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
     * @return 指定のコードに該当する{@link TreatmentWhenShujiiFuicchi}
     */
    public static TreatmentWhenShujiiFuicchi toValue(RString code) {
        for (TreatmentWhenShujiiFuicchi v : values()) {
            if (v.theCode.equals(code)) {
                return v;
            }
        }
        throw new IllegalArgumentException(
                new RStringBuilder().append("指定のコードに該当する要素は存在しません。 code:").append(code).toString());
    }
}
