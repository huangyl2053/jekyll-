/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_支給申請区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 huzongcheng
 */
public enum KaigoGassan_ShinseiKbn {

    /**
     * コード:1 名称:新規 略称:定義なし
     */
    新規("1", "新規"),
    /**
     * コード:2 名称:変更 略称:定義なし
     */
    変更("2", "変更"),
    /**
     * コード:3 名称:取り下げ 略称:定義なし
     */
    取り下げ("3", "取下げ");

    private final RString code;
    private final RString fullName;

    private KaigoGassan_ShinseiKbn(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 介護合算_支給申請区分のコードを返します。
     *
     * @return 介護合算_支給申請区分のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 介護合算_支給申請区分の名称を返します。
     *
     * @return 介護合算_支給申請区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_支給申請区分のコードと一致する内容を探します。
     *
     * @param code 介護合算_支給申請区分のコード
     * @return {@code code} に対応する介護合算_支給申請区分
     */
    public static KaigoGassan_ShinseiKbn toValue(RString code) {
        for (KaigoGassan_ShinseiKbn kaigogassanidokubun : KaigoGassan_ShinseiKbn.values()) {
            if (kaigogassanidokubun.code.equals(code)) {
                return kaigogassanidokubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_支給申請区分"));
    }

    /**
     * 介護合算_支給申請区分の名称と一致する内容を探します。
     *
     * @param name 名称
     * @return 名称に対応する介護合算_支給申請区分
     */
    public static KaigoGassan_ShinseiKbn valueof(RString name) {
        for (KaigoGassan_ShinseiKbn kaigogassanidokubun : KaigoGassan_ShinseiKbn.values()) {
            if (kaigogassanidokubun.fullName.equals(name)) {
                return kaigogassanidokubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_支給申請区分"));
    }
}
