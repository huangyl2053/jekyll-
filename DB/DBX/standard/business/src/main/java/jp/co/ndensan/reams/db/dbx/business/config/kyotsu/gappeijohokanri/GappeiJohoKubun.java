/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このenumは、業務コンフィグ「合併情報管理_合併情報区分」の設定値に対応します。
 */
public enum GappeiJohoKubun {

    /**
     * 合併あり
     */
    合併あり("1"),
    /**
     * 合併なし
     */
    合併なし("0");

    private final RString code;

    private GappeiJohoKubun(String code) {
        this.code = new RString(code);
    }

    /**
     * 合併ありの場合、trueを返します。
     *
     * @return 合併ありの場合true.
     */
    public boolean has合併() {
        return this == 合併あり;
    }

    static GappeiJohoKubun toValue(RString code) {
        for (GappeiJohoKubun t : values()) {
            if (t.code.equals(code)) {
                return t;
            }
        }
        throw new IllegalArgumentException();
    }
}
