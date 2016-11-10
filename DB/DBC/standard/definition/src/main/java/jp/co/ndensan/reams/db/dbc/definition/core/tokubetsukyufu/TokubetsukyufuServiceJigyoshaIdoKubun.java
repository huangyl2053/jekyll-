/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.tokubetsukyufu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別給付_サービス事業者_異動区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liuwei2
 */
public enum TokubetsukyufuServiceJigyoshaIdoKubun {

    /**
     * コード:01 名称:新規 略称:定義なし
     */
    新規("01", "新規"),
    /**
     * コード:02 名称:変更 略称:定義なし
     */
    変更("02", "変更"),
    /**
     * コード:03 名称:終了 略称:定義なし
     */
    終了("02", "終了");

    private final RString code;

    private final RString fullName;

    private TokubetsukyufuServiceJigyoshaIdoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特別給付_サービス事業者_異動区分のコードを返します。
     *
     * @return 特別給付_サービス事業者_異動区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特別給付_サービス事業者_異動区分の名称を返します。
     *
     * @return 特別給付_サービス事業者_異動区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特別給付_サービス事業者_異動区分のコードと一致する内容を探します。
     *
     * @param code 特別給付_サービス事業者_異動区分のコード
     * @return {@code code} に対応する特別給付_サービス事業者_異動区分
     */
    public static TokubetsukyufuServiceJigyoshaIdoKubun toValue(RString code) {

        for (TokubetsukyufuServiceJigyoshaIdoKubun kubun : TokubetsukyufuServiceJigyoshaIdoKubun.values()) {
            if (kubun.code.equals(code)) {
                return kubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特別給付_サービス事業者_異動区分"));
    }
}
