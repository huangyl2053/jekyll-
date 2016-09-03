/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_資格喪失事由を表す列挙型です。
 *
 * @reamsid_L DBC-3103-020 fuyanling
 */
public enum KaigoGassan_SoshitsuJiyu {

    /**
     * コード:1 名称:死亡 略称:定義なし
     */
    死亡("1", "死亡"),
    /**
     * コード:2 名称:海外移住 略称:定義なし
     */
    海外移住("2", "海外移住"),
    /**
     * コード:3 名称:生保適用 略称:定義なし
     */
    生保適用("3", "生保適用");

    private final RString code;
    private final RString fullName;

    private KaigoGassan_SoshitsuJiyu(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 介護合算_資格喪失事由のコードを返します。
     *
     * @return 介護合算_資格喪失事由のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 介護合算_資格喪失事由の名称を返します。
     *
     * @return 介護合算_資格喪失事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_資格喪失事由のコードと一致する内容を探します。
     *
     * @param code 介護合算_資格喪失事由のコード
     * @return {@code code} に対応する介護合算_資格喪失事由
     */
    public static KaigoGassan_SoshitsuJiyu toValue(RString code) {
        for (KaigoGassan_SoshitsuJiyu kaigogassanidokubun : KaigoGassan_SoshitsuJiyu.values()) {
            if (kaigogassanidokubun.code.equals(code)) {
                return kaigogassanidokubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_資格喪失事由"));
    }
}
