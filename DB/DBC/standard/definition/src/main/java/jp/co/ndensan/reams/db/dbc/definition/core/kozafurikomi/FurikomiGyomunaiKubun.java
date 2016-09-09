/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込業務内区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 x_lilh
 */
public enum FurikomiGyomunaiKubun {

    /**
     * コード:1 名称:償還データ 略称:定義なし
     */
    償還("01", "償還データ"),
    /**
     * コード:2 名称:高額データ 略称:定義なし
     */
    高額("02", "高額データ"),
    /**
     * コード:2 名称:高額合算データ 略称:定義なし
     */
    高額合算("03", "高額合算データ"),
    /**
     * コード:2 名称:総合事業高額データ 略称:定義なし
     */
    事業高額("04", "総合事業高額データ"),
    /**
     * コード:2 名称:事業分高額合算データ 略称:定義なし
     */
    事業高額合算("05", "事業分高額合算データ"),
    /**
     * コード:2 名称:高額データ 略称:定義なし
     */
    償還高額("09", "償還・高額データ");

    private final RString code;
    private final RString fullName;

    private FurikomiGyomunaiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 振込業務内区分のコードを返します。
     *
     * @return 振込業務内区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 振込業務内区分の名称を返します。
     *
     * @return 振込業務内区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 振込業務内区分のコードと一致する内容を探します。
     *
     * @param code 振込業務内区分のコード
     * @return {@code code} に対応する振込業務内区分名称
     */
    public static FurikomiGyomunaiKubun toValue(RString code) {

        for (FurikomiGyomunaiKubun furikomiGyomunaiKubun : FurikomiGyomunaiKubun.values()) {
            if (furikomiGyomunaiKubun.code.equals(code)) {
                return furikomiGyomunaiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("振込業務内区分"));
    }
}
