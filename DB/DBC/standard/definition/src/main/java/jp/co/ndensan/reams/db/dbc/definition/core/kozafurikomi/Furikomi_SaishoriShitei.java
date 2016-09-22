/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込_再処理指定を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 x_liuwei
 */
public enum Furikomi_SaishoriShitei {

    /**
     * コード:1 名称:再処理する 略称:定義なし
     */
    再処理("1", "再処理する");

    private final RString code;
    private final RString fullName;

    private Furikomi_SaishoriShitei(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 振込_再処理指定のコードを返します。
     *
     * @return 振込_再処理指定のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 振込_再処理指定の名称を返します。
     *
     * @return 振込_再処理指定の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 振込_再処理指定のコードと一致する内容を探します。
     *
     * @param code 振込_再処理指定のコード
     * @return {@code code} に対応する振込_再処理指定名称
     */
    public static Furikomi_SaishoriShitei toValue(RString code) {

        for (Furikomi_SaishoriShitei furikomi_SaishoriShitei : Furikomi_SaishoriShitei.values()) {
            if (furikomi_SaishoriShitei.code.equals(code)) {
                return furikomi_SaishoriShitei;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("振込_再処理指定"));
    }
}
