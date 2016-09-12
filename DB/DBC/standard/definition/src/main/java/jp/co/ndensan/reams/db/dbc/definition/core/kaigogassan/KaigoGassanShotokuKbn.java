/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_所得区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 huzongcheng
 */
public enum KaigoGassanShotokuKbn {

    /**
     * コード:1 名称:一般 略称:定義なし
     */
    一般("1", "一般"),
    /**
     * コード:2 名称:低所得 略称:定義なし
     */
    低所得("2", "低所得"),
    /**
     * コード:3 名称:上位所得者 略称:定義なし
     */
    上位所得者("3", "上位所得者"),
    /**
     * コード:5 名称:区分ア 略称:定義なし
     */
    区分ア("5", "区分ア"),
    /**
     * コード:6 名称:区分イ 略称:定義なし
     */
    区分イ("6", "区分イ"),
    /**
     * コード:7 名称:区分ウ 略称:定義なし
     */
    区分ウ("7", "区分ウ"),
    /**
     * コード:8 名称:区分エ 略称:定義なし
     */
    区分エ("8", "区分エ"),
    /**
     * コード:9 名称:区分オ 略称:定義なし
     */
    区分オ("9", "区分オ"),
    /**
     * コード:"" 名称:区分ウ 略称:定義なし
     */
    国保被保険者以外("", "国保被保険者以外");

    private final RString code;
    private final RString fullName;

    private KaigoGassanShotokuKbn(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 介護合算_所得区分のコードを返します。
     *
     * @return 介護合算_所得区分のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 介護合算_所得区分の名称を返します。
     *
     * @return 介護合算_所得区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_所得区分のコードと一致する内容を探します。
     *
     * @param code 介護合算_所得区分のコード
     * @return {@code code} に対応する介護合算_所得区分
     */
    public static KaigoGassanShotokuKbn toValue(RString code) {
        for (KaigoGassanShotokuKbn kaigogassanidokubun : KaigoGassanShotokuKbn.values()) {
            if (kaigogassanidokubun.code.equals(code)) {
                return kaigogassanidokubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_所得区分"));
    }
}
