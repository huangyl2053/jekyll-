/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_給付実績データ区分列挙型です。
 *
 * @reamsid_L DBC-9999-022 wangxingpeng
 */
public enum KaigoGassan_KyufuJissekiDataKubun {

    /**
     * コード:1 名称:国保連からの返却データ以外 略称:返却データ以外
     */
    国保連からの返却データ以外("0", "国保連からの返却データ以外", "返却データ以外"),
    /**
     * コード:1 名称:国保連からの返却データ 略称:返却データ
     */
    国保連からの返却データ("1", "国保連からの返却データ", "返却データ"),
    /**
     * コード:1 名称:国保連からの送付データ後期分 略称:後期分
     */
    国保連からの送付データ後期分("2", "国保連からの送付データ後期分", "後期分"),
    /**
     * コード:2 名称:国保連からの送付データ国保分 略称:国保分
     */
    国保連からの送付データ国保分("3", "国保連からの送付データ国保分", "国保分");
    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private KaigoGassan_KyufuJissekiDataKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 介護合算_給付実績データ区分のコードを返します。
     *
     * @return 介護合算_給付実績データ区分のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 介護合算_給付実績データ区分の名称を返します。
     *
     * @return 介護合算_給付実績データ区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_給付実績データ区分の略称を返します。
     *
     * @return 介護合算_給付実績データ区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 介護合算_給付実績データ区分のコードと一致する内容を探します。
     *
     * @param code 介護合算_給付実績データ区分のコード
     * @return {@code code} に対応する介護合算_給付実績データ区分
     */
    public static KaigoGassan_KyufuJissekiDataKubun toValue(RString code) {
        for (KaigoGassan_KyufuJissekiDataKubun kyufujisski : KaigoGassan_KyufuJissekiDataKubun.values()) {
            if (kyufujisski.code.equals(code)) {
                return kyufujisski;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_給付実績データ区分"));
    }

}
