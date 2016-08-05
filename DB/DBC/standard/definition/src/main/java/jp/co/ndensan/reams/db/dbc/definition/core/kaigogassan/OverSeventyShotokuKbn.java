/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_70歳以上の者に係る所得区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 huzongcheng
 */
public enum OverSeventyShotokuKbn {

    /**
     * コード:1 名称:一般 略称:定義なし
     */
    一般("1", "一般"),
    /**
     * コード:2 名称:上位所得者 略称:定義なし
     */
    上位所得者("2", "上位所得者"),
    /**
     * コード:3 名称:低所得者Ⅱ 略称:定義なし
     */
    低所得者Ⅱ("3", "低所得者Ⅱ"),
    /**
     * コード:4 名称:低所得者Ⅰ 略称:定義なし
     */
    低所得者Ⅰ("5", "低所得者Ⅰ");

    private final RString code;
    private final RString fullName;

    private OverSeventyShotokuKbn(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 介護合算_70歳以上の者に係る所得区分のコードを返します。
     *
     * @return 介護合算_70歳以上の者に係る所得区分のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 介護合算_70歳以上の者に係る所得区分の名称を返します。
     *
     * @return 介護合算_70歳以上の者に係る所得区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_70歳以上の者に係る所得区分のコードと一致する内容を探します。
     *
     * @param code 介護合算_70歳以上の者に係る所得区分のコード
     * @return {@code code} に対応する介護合算_70歳以上の者に係る所得区分
     */
    public static OverSeventyShotokuKbn toValue(RString code) {
        for (OverSeventyShotokuKbn kaigogassanidokubun : OverSeventyShotokuKbn.values()) {
            if (kaigogassanidokubun.code.equals(code)) {
                return kaigogassanidokubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_70歳以上の者に係る所得区分"));
    }
}
