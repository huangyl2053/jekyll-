/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.yokaigonintei.shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選択された被保険者区分を表す列挙型です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public enum HihokenshaKubun {

    /**
     * コード:0 名称:すべて選択 略称:定義なし
     */
    すべて選択("0", "すべて選択"),
    /**
     * コード:1 名称:第１号被保険者 略称:定義なし
     */
    第１号被保険者("1", "第１号被保険者"),
    /**
     * コード:2 名称:第２号被保険者 略称:定義なし
     */
    第２号被保険者("2", "第２号被保険者"),
    /**
     * コード:3 名称:その他 略称:定義なし
     */
    その他("3", "その他"),
    /**
     * コード:4 名称:第１号被保険者と第２号被保険者 略称:定義なし
     */
    第１号と第２号("4", "第１号被保険者と第２号被保険者"),
    /**
     * コード:5 名称:第１号被保険者とその他 略称:定義なし
     */
    第１号とその他("5", "第１号被保険者とその他"),
    /**
     * コード:6 名称:第２号被保険者とその他 略称:定義なし
     */
    第２号とその他("6", "第２号被保険者とその他"),
    /**
     * コード:7 名称:選択なし 略称:定義なし
     */
    選択なし("7", "選択なし");

    private final RString code;
    private final RString fullName;

    private HihokenshaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 被保険者区分コードのコードを返します。
     *
     * @return 被保険者区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 被保険者区分コードの名称を返します。
     *
     * @return 被保険者区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 被保険者区分コードのコードと一致する内容を探します。
     *
     * @param code 被保険者区分コードのコード
     * @return {@code code} に対応する被保険者区分コード
     */
    public static HihokenshaKubun toValue(RString code) {

        for (HihokenshaKubun hihokenshaKubun : HihokenshaKubun.values()) {
            if (hihokenshaKubun.code.equals(code)) {
                return hihokenshaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("被保険者区分"));
    }
}
