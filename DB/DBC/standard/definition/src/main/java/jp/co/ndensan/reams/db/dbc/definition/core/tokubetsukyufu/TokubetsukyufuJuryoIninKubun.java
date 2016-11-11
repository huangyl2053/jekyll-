/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.tokubetsukyufu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別給付_受領委任区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liuwei2
 */
public enum TokubetsukyufuJuryoIninKubun {

    /**
     * コード:0 名称:無 略称:定義なし
     */
    無("0", "無"),
    /**
     * コード:1 名称:有 略称:定義なし
     */
    有("1", "有");

    private final RString code;
    private final RString fullName;

    private TokubetsukyufuJuryoIninKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特別給付_受領委任区分のコードを返します。
     *
     * @return 特別給付_受領委任区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特別給付_受領委任区分の名称を返します。
     *
     * @return 特別給付_受領委任区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特別給付_受領委任区分のコードと一致する内容を探します。
     *
     * @param code 特別給付_受領委任区分のコード
     * @return {@code code} に対応する特別給付_受領委任区分
     */
    public static TokubetsukyufuJuryoIninKubun toValue(RString code) {

        for (TokubetsukyufuJuryoIninKubun kubun : TokubetsukyufuJuryoIninKubun.values()) {
            if (kubun.code.equals(code)) {
                return kubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特別給付_受領委任区分"));
    }
}
