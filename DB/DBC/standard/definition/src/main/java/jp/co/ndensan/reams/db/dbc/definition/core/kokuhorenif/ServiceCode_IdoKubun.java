/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービスコード_異動区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 zhaowei
 */
public enum ServiceCode_IdoKubun {

    /**
     * コード:1 名称:新規 略称:定義なし
     */
    新規("1", "新規"),
    /**
     * コード:2 名称:修正 略称:定義なし
     */
    修正("2", "修正"),
    /**
     * コード:3 名称:終了 略称:定義なし
     */
    終了("3", "終了");
    private final RString code;
    private final RString fullName;

    private ServiceCode_IdoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * サービスコード_異動区分のコードを返します。
     *
     * @return サービスコード_異動区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * サービスコード_異動区分の名称を返します。
     *
     * @return サービスコード_異動区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * サービスコード_異動区分のコードと一致する内容を探します。
     *
     * @param code サービスコード_異動区分のコード
     * @return {@code code} に対応するサービスコード_異動区分
     */
    public static ServiceCode_IdoKubun toValue(RString code) {

        for (ServiceCode_IdoKubun dataSaisoFlag : ServiceCode_IdoKubun.values()) {
            if (dataSaisoFlag.code.equals(code)) {
                return dataSaisoFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("サービスコード_異動区分"));
    }
}
