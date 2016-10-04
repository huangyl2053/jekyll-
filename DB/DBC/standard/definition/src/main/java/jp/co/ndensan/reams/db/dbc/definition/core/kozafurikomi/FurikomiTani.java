/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込単位を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 x_lilh
 */
public enum FurikomiTani {

    /**
     * コード:1 名称:償還高額同時 略称:定義なし
     */
    償還高額同時("1", "償還高額同時"),
    /**
     * コード:2 名称:償還高額個別 略称:定義なし
     */
    償還高額個別("2", "償還高額個別");

    private final RString code;
    private final RString fullName;

    private FurikomiTani(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 振込単位のコードを返します。
     *
     * @return 振込単位のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 振込単位の名称を返します。
     *
     * @return 振込単位の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 振込単位のコードと一致する内容を探します。
     *
     * @param code 振込単位のコード
     * @return {@code code} に対応する振込単位名称
     */
    public static FurikomiTani toValue(RString code) {

        for (FurikomiTani furikomiTani : FurikomiTani.values()) {
            if (furikomiTani.code.equals(code)) {
                return furikomiTani;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("振込単位"));
    }
}
