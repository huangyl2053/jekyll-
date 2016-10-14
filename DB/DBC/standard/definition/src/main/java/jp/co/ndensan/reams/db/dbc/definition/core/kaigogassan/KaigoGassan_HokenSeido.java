/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_保険制度を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 huzongcheng
 */
public enum KaigoGassan_HokenSeido {

    /**
     * コード:1 名称:国保 略称:定義なし
     */
    国保("1", "国保"),
    /**
     * コード:2 名称:後期 略称:定義なし
     */
    後期("2", "後期"),
    /**
     * コード:3 名称:介護 略称:定義なし
     */
    介護("3", "介護"),
    /**
     * コード:4 名称:被用者 略称:定義なし
     */
    被用者("4", "被用者");

    private final RString code;
    private final RString fullName;

    private KaigoGassan_HokenSeido(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 介護合算_保険制度のコードを返します。
     *
     * @return 介護合算_保険制度のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 介護合算_保険制度の名称を返します。
     *
     * @return 介護合算_保険制度の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_保険制度のコードと一致する内容を探します。
     *
     * @param code 介護合算_保険制度のコード
     * @return {@code code} に対応する介護合算_保険制度
     */
    public static KaigoGassan_HokenSeido toValue(RString code) {
        for (KaigoGassan_HokenSeido kaigogassanidokubun : KaigoGassan_HokenSeido.values()) {
            if (kaigogassanidokubun.code.equals(code)) {
                return kaigogassanidokubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_保険制度"));
    }
}
