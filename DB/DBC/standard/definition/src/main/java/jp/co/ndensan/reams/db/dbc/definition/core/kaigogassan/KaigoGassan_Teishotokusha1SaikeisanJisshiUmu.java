/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_低所得者Ⅰ再計算実施有無を表す列挙型です。
 *
 * @reamsid_L DBC-2670-040 lijian
 */
public enum KaigoGassan_Teishotokusha1SaikeisanJisshiUmu {

    /**
     * コード:1 名称:無し 略称:定義なし
     */
    無し("1", "無し"),
    /**
     * コード:2 名称:有り 略称:定義なし
     */
    有り("2", "有り");

    private final RString code;
    private final RString fullName;

    private KaigoGassan_Teishotokusha1SaikeisanJisshiUmu(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 介護合算_低所得者Ⅰ再計算実施有無のコードを返します。
     *
     * @return 介護合算_低所得者Ⅰ再計算実施有無のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 介護合算_低所得者Ⅰ再計算実施有無の名称を返します。
     *
     * @return 介護合算_低所得者Ⅰ再計算実施有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_低所得者Ⅰ再計算実施有無のコードと一致する内容を探します。
     *
     * @param code 介護合算_低所得者Ⅰ再計算実施有無のコード
     * @return {@code code} に対応する介護合算_低所得者Ⅰ再計算実施有無
     */
    public static KaigoGassan_Teishotokusha1SaikeisanJisshiUmu toValue(RString code) {
        for (KaigoGassan_Teishotokusha1SaikeisanJisshiUmu kaigogassanidokubun : KaigoGassan_Teishotokusha1SaikeisanJisshiUmu.values()) {
            if (kaigogassanidokubun.code.equals(code)) {
                return kaigogassanidokubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_低所得者Ⅰ再計算実施有無"));
    }

}
