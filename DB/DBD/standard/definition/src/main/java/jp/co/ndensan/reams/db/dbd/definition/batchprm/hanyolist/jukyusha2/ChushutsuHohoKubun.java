/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者台帳抽出方法区分を表す列挙型です。
 *
 * @reamsid_L DBD-1800-010 liwul
 */
public enum ChushutsuHohoKubun {

    /**
     * コード:1 名称:直近 略称:定義なし
     */
    直近("1", "直近"),
    /**
     * コード:2 名称:基準日 略称:定義なし
     */
    基準日("2", "基準日"),
    /**
     * コード:3 名称:範囲 略称:定義なし
     */
    範囲("3", "範囲");

    private final RString code;
    private final RString fullName;

    private ChushutsuHohoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 抽出方法区分のコードを返します。
     *
     * @return 抽出方法区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 抽出方法区分の名称を返します。
     *
     * @return 抽出方法区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 抽出方法区分のコードと一致する内容を探します。
     *
     * @param code 抽出方法区分のコード
     * @return {@code code} に対応する抽出方法区分
     */
    public static ChushutsuHohoKubun toValue(RString code) {
        for (ChushutsuHohoKubun chushutsuHohoKubun : ChushutsuHohoKubun.values()) {
            if (chushutsuHohoKubun.code.equals(code)) {
                return chushutsuHohoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("対応する抽出方法区分"));
    }
}
