/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_国保続柄を表す列挙型です。
 *
 * @reamsid_L DBC-3103-020 fuyanling
 */
public enum KaigoGassan_Kokuho_Zokugara {

    /**
     * コード:1 名称:世帯主 略称:定義なし
     */
    一般("1", "世帯主"),
    /**
     * コード:2 名称:擬制世帯主 略称:定義なし
     */
    低所得("2", "擬制世帯主"),
    /**
     * コード:3 名称:世帯員 略称:定義なし
     */
    上位所得者("3", "世帯員");

    private final RString code;
    private final RString fullName;

    private KaigoGassan_Kokuho_Zokugara(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 介護合算_国保続柄のコードを返します。
     *
     * @return 介護合算_国保続柄のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 介護合算_国保続柄の名称を返します。
     *
     * @return 介護合算_国保続柄の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_国保続柄のコードと一致する内容を探します。
     *
     * @param code 介護合算_国保続柄のコード
     * @return {@code code} に対応する介護合算_国保続柄
     */
    public static KaigoGassan_Kokuho_Zokugara toValue(RString code) {
        for (KaigoGassan_Kokuho_Zokugara kaigogassanidokubun : KaigoGassan_Kokuho_Zokugara.values()) {
            if (kaigogassanidokubun.code.equals(code)) {
                return kaigogassanidokubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_国保続柄"));
    }
}
