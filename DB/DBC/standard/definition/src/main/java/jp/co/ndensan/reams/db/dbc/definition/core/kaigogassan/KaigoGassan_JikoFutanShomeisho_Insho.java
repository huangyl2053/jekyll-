/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_自己負担額証明書_印書を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 zhujun
 */
public enum KaigoGassan_JikoFutanShomeisho_Insho {

    /**
     * コード:1 名称:1:単票発行分を除く 略称:定義なし
     */
    単票発行分を除く("1", "単票発行分を除く"),
    /**
     * コード:2 名称:2:単票発行分も含める 略称:定義なし
     */
    単票発行分も含める("2", "単票発行分も含める"),
    /**
     * コード:3 名称:3:未発行分のみ 略称:定義なし
     */
    未発行分のみ("3", "未発行分のみ");

    private final RString code;
    private final RString fullName;

    private KaigoGassan_JikoFutanShomeisho_Insho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護合算_自己負担額証明書_印書のコードを返します。
     *
     * @return 介護合算_自己負担額証明書_印書のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_自己負担額証明書_印書の名称を返します。
     *
     * @return 介護合算_自己負担額証明書_印書の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_自己負担額証明書_印書のコードと一致する内容を探します。
     *
     * @param code 介護合算_自己負担額証明書_印書のコード
     * @return {@code code} に対応する介護合算_自己負担額証明書_印書
     */
    public static KaigoGassan_JikoFutanShomeisho_Insho toValue(RString code) {

        for (KaigoGassan_JikoFutanShomeisho_Insho insho : KaigoGassan_JikoFutanShomeisho_Insho.values()) {
            if (insho.code.equals(code)) {
                return insho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_自己負担額証明書_印書"));
    }
}
