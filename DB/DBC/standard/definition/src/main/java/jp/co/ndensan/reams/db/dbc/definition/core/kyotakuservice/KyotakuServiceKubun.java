/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービス区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum KyotakuServiceKubun {

    /**
     * コード:1 名称:訪問通所 略称:定義なし
     */
    訪問通所("1", "訪問通所"),
    /**
     * コード:2 名称:短期入所 略称:定義なし
     */
    短期入所("2", "短期入所"),
    /**
     * コード:3 名称:居宅サービス 略称:定義なし
     */
    居宅サービス("3", "居宅サービス");

    private final RString code;
    private final RString fullName;

    private KyotakuServiceKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 居宅サービス区分を返します。
     *
     * @return 居宅サービス区分
     */
    public RString getコード() {
        return code;
    }

    /**
     * 居宅サービス区分の名称を返します。
     *
     * @return 居宅サービス区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 居宅サービス区分のコードと一致する内容を探します。
     *
     * @param code 居宅サービス区分コード
     * @return {@code code} に対応する居宅サービス区分
     */
    public static KyotakuServiceKubun toValue(RString code) {

        for (KyotakuServiceKubun kyotakuServiceKubun : KyotakuServiceKubun.values()) {
            if (kyotakuServiceKubun.code.equals(code)) {
                return kyotakuServiceKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("居宅サービス区分"));
    }
}
