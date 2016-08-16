/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.shunyugaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抽出条件列挙型です。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public enum ShutsuryokuJoken {

    /**
     * コード:0 名称:審査年月 略称:定義なし
     */
    審査年月("0001", "審査年月"),
    /**
     * コード:0 名称:被保険者番号 略称:定義なし
     */
    被保険者番号("0002", "被保険者番号"),
    /**
     * コード:1 名称:白紙 略称:定義なし
     */
    白紙("0003", "白紙");

    private final RString code;
    private final RString fullName;

    private ShutsuryokuJoken(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 抽出条件のコードを返します。
     *
     * @return 承認区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 抽出条件の名称を返します。
     *
     * @return 承認区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 抽出条件のコードと一致する内容を探します。
     *
     * @param code 承認区分のコード
     * @return {@code code} に対応する承認区分
     */
    public static ShutsuryokuJoken toValue(RString code) {

        for (ShutsuryokuJoken shutsuryokuJoken : ShutsuryokuJoken.values()) {
            if (shutsuryokuJoken.code.equals(code)) {
                return shutsuryokuJoken;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("承認区分"));
    }
}
