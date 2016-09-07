/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス識別コードを表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum ServiceShikibetsuCode {

    /**
     * コード:1 名称:指定サービス 略称:定義なし
     */
    指定サービス("1", "指定サービス"),
    /**
     * コード:2 名称:基準該当サービス 略称:定義なし
     */
    基準該当サービス("2", "基準該当サービス"),
    /**
     * コード:3 名称:相当サービス 略称:定義なし
     */
    相当サービス("3", "相当サービス"),
    /**
     * コード:4 名称:その他 略称:定義なし
     */
    その他("4", "その他"),
    /**
     * コード:5 名称:地域密着型サービス 略称:定義なし
     */
    地域密着型サービス("5", "地域密着型サービス"),
    /**
     * コード:6 名称:総合事業 略称:定義なし
     */
    総合事業("6", "総合事業");

    private final RString code;
    private final RString fullName;

    private ServiceShikibetsuCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * サービス識別コードを返します。
     *
     * @return サービス識別コード
     */
    public RString getコード() {
        return code;
    }

    /**
     * サービス識別コードの名称を返します。
     *
     * @return サービス識別コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * サービス識別コードのコードと一致する内容を探します。
     *
     * @param code サービス識別コード
     * @return {@code code} に対応するサービス識別コード
     */
    public static ServiceShikibetsuCode toValue(RString code) {

        for (ServiceShikibetsuCode serviceShikibetsuCode : ServiceShikibetsuCode.values()) {
            if (serviceShikibetsuCode.code.equals(code)) {
                return serviceShikibetsuCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("サービス識別コード"));
    }
}
