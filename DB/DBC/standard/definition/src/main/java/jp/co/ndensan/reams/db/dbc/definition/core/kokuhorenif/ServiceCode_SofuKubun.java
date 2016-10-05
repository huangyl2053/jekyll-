/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービスコード_送付区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 zhaowei
 */
public enum ServiceCode_SofuKubun {

    /**
     * コード:1 名称:送付不要 略称:定義なし
     */
    送付不要("1", "送付不要"),
    /**
     * コード:2 名称:送付対象 略称:定義なし
     */
    送付対象("2", "送付対象"),
    /**
     * コード:3 名称:送付済み 略称:定義なし
     */
    送付済み("3", "送付済み");
    private final RString code;
    private final RString fullName;

    private ServiceCode_SofuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * サービスコード_送付区分のコードを返します。
     *
     * @return サービスコード_送付区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * サービスコード_送付区分の名称を返します。
     *
     * @return サービスコード_送付区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * サービスコード_送付区分のコードと一致する内容を探します。
     *
     * @param code サービスコード_送付区分のコード
     * @return {@code code} に対応するサービスコード_送付区分
     */
    public static ServiceCode_SofuKubun toValue(RString code) {

        for (ServiceCode_SofuKubun dataSaisoFlag : ServiceCode_SofuKubun.values()) {
            if (dataSaisoFlag.code.equals(code)) {
                return dataSaisoFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("サービスコード_送付区分"));
    }
}
