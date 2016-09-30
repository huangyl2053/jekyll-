/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 口座名寄せ方法を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 donghj
 */
public enum KozaNayoseHoho {

    /**
     * コード:1 名称:しない 略称:定義なし
     */
    しない("0", "しない"),
    /**
     * コード:2 名称:被保険者毎に同一口座で名寄せする 略称:定義なし
     */
    被保険者毎に同一口座で名寄せする("1", "被保険者毎に同一口座で名寄せする"),
    /**
     * コード:3 名称:同一口座で名寄せする 略称:定義なし
     */
    同一口座で名寄せする("2", "同一口座で名寄せする");

    private final RString code;
    private final RString fullName;

    private KozaNayoseHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 口座名寄せ方法のコードを返します。
     *
     * @return 口座名寄せ方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 口座名寄せ方法の名称を返します。
     *
     * @return 口座名寄せ方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 口座名寄せ方法のコードと一致する内容を探します。
     *
     * @param code 口座名寄せ方法のコード
     * @return {@code code} に対応する口座名寄せ方法名称
     */
    public static KozaNayoseHoho toValue(RString code) {

        for (KozaNayoseHoho kozaNayoseHoho : KozaNayoseHoho.values()) {
            if (kozaNayoseHoho.code.equals(code)) {
                return kozaNayoseHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("口座名寄せ方法"));
    }

}
