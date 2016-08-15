/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kijunshunyugaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抽出期間radを表す列挙型です。
 *
 * @reamsid_L DBC-4610-010 qinzhen
 */
public enum ChushutsuKikan {

    /**
     * コード:0001 名称:申請年月日 略称:定義なし
     */
    申請年月日("0001", "申請年月日"),
    /**
     * コード:0002 名称:決定年月日 略称:定義なし
     */
    決定年月日("0002", "決定年月日");

    private final RString code;
    private final RString fullName;

    private ChushutsuKikan(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 抽出期間radのコードを返します。
     *
     * @return 抽出期間radのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 抽出期間radの名称を返します。
     *
     * @return 抽出期間radの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 抽出期間radのコードと一致する内容を探します。
     *
     * @param code 抽出期間radのコード
     * @return {@code code} に対応する抽出期間rad
     */
    public static ChushutsuKikan toValue(RString code) {

        for (ChushutsuKikan chushutsuKikan : ChushutsuKikan.values()) {
            if (chushutsuKikan.code.equals(code)) {
                return chushutsuKikan;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("抽出期間radのコード"));
    }

}
