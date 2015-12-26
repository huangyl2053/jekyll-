/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.kyotsu.rojinhokenjoho;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 老人保健の管理体系です。
 */
public enum RojinHokenKanriTaikei {

    /**
     * 住民コード体系
     */
    住民コード体系("1");
    private final RString aCode;

    private RojinHokenKanriTaikei(String code) {
        this.aCode = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return this.aCode;
    }

    static RojinHokenKanriTaikei toValue(RString code) {
        for (RojinHokenKanriTaikei t : values()) {
            if (Objects.equals(t.code(), code)) {
                return t;
            }
        }
        throw new IllegalArgumentException();
    }
}
