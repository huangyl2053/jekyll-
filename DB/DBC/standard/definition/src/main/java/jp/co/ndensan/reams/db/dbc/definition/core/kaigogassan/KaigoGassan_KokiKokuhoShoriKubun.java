/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_後期国保処理区分列挙型です。
 *
 * @reamsid_L DBC-9999-022 wangxingpeng
 */
public enum KaigoGassan_KokiKokuhoShoriKubun {

    /**
     * コード:2 名称:後期分 略称:定義なし
     */
    後期分("2", "後期分"),
    /**
     * コード:1 名称:国保分 略称:定義なし
     */
    国保分("1", "国保分");

    private final RString code;
    private final RString fullName;

    private KaigoGassan_KokiKokuhoShoriKubun(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 介護合算_後期国保処理区分のコードを返します。
     *
     * @return 介護合算_後期国保処理区分のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 介護合算_後期国保処理区分の名称を返します。
     *
     * @return 介護合算_後期国保処理区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_後期国保処理区分のコードと一致する内容を探します。
     *
     * @param code 介護合算_後期国保処理区分のコード
     * @return {@code code} に対応する介護合算_後期国保処理区分
     */
    public static KaigoGassan_KokiKokuhoShoriKubun toValue(RString code) {
        for (KaigoGassan_KokiKokuhoShoriKubun kokikokuho : KaigoGassan_KokiKokuhoShoriKubun.values()) {
            if (kokikokuho.code.equals(code)) {
                return kokikokuho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_後期国保処理区分"));
    }

}
