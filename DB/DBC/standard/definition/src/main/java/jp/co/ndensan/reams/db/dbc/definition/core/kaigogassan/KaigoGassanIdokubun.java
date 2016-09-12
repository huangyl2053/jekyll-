/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_異動区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 huzongcheng
 */
public enum KaigoGassanIdokubun {

    /**
     * コード:1 名称:新規 略称:定義なし
     */
    新規("1", "新規"),
    /**
     * コード:2 名称:変更 略称:定義なし
     */
    変更("2", "変更"),
    /**
     * コード:3 名称:仮データ 略称:定義なし
     */
    仮データ("3", "仮データ");

    private final RString code;
    private final RString fullName;

    private KaigoGassanIdokubun(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 介護合算_異動区分のコードを返します。
     *
     * @return 介護合算_異動区分のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 介護合算_異動区分の名称を返します。
     *
     * @return 介護合算_異動区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_異動区分のコードと一致する内容を探します。
     *
     * @param code 介護合算_異動区分のコード
     * @return {@code code} に対応する介護合算_異動区分
     */
    public static KaigoGassanIdokubun toValue(RString code) {
        for (KaigoGassanIdokubun kaigogassanidokubun : KaigoGassanIdokubun.values()) {
            if (kaigogassanidokubun.code.equals(code)) {
                return kaigogassanidokubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_異動区分"));
    }
}
