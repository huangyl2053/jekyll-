/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修申請区分を表す列挙型です。
 */
public enum JutakukaishuShinseiKubun {

    /**
     * コード:1 名称:事前申請 略称:定義なし
     */
    事前申請("1", "事前申請"),
    /**
     * コード:2 名称:支給申請 略称:定義なし
     */
    支給申請("2", "支給申請"),
    /**
     * コード:9 名称:取消 略称:定義なし
     */
    取消("9", "取消");

    private final RString code;
    private final RString fullName;

    private JutakukaishuShinseiKubun(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 住宅改修申請区分のコードを返します。
     *
     * @return 住宅改修申請区分のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 住宅改修申請区分の名称を返します。
     *
     * @return 住宅改修申請区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 住宅改修申請区分のコードと一致する内容を探します。
     *
     * @param code 住宅改修申請区分のコード
     * @return {@code code} に対応する住宅改修申請区分
     */
    public static JutakukaishuShinseiKubun toValue(RString code) {
        for (JutakukaishuShinseiKubun jutakukaishuShinseiKubun : JutakukaishuShinseiKubun.values()) {
            if (jutakukaishuShinseiKubun.code.equals(code)) {
                return jutakukaishuShinseiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("住宅改修申請区分"));
    }
}
