/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.fuka;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴分配集約システム
 */
public enum TokuchoBumpaiShuyakuSystem {

    /**
     * なし
     */
    なし("0"),
    /**
     * あり（国保／後期）
     */
    あり_国保_後期("1"),
    /**
     * あり（後期）
     */
    あり_後期("2");
    private final RString aCode;

    private TokuchoBumpaiShuyakuSystem(String code) {
        this.aCode = new RString(code);
    }

    /**
     * コードを返却します。
     *
     * @return コード
     */
    public RString code() {
        return this.aCode;
    }

    static TokuchoBumpaiShuyakuSystem toValue(RString code) {
        for (TokuchoBumpaiShuyakuSystem v : values()) {
            if (Objects.equals(v, code)) {
                return v;
            }
        }
        throw new IllegalArgumentException();
    }
}
