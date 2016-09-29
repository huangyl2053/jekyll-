/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連データ送付区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 jianglaisheng
 */
public enum KokuhorenDataSofuKubun {

    /**
     * コード:1 名称:送付済
     */
    送付済("1", "送付済");
    private final RString code;
    private final RString fullName;

    private KokuhorenDataSofuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 国保連データ送付区分のコードを返します。
     *
     * @return 国保連データ送付区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 国保連データ送付区分の名称を返します。
     *
     * @return 国保連データ送付区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 国保連データ送付区分のコードと一致する内容を探します。
     *
     * @param code 国保連データ送付区分のコード
     * @return {@code code} に対応する国保連データ送付区分
     */
    public static KokuhorenDataSofuKubun toValue(RString code) {

        for (KokuhorenDataSofuKubun kokuhorenDataSofuKubun : KokuhorenDataSofuKubun.values()) {
            if (kokuhorenDataSofuKubun.code.equals(code)) {
                return kokuhorenDataSofuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("国保連データ送付区分"));
    }

}
