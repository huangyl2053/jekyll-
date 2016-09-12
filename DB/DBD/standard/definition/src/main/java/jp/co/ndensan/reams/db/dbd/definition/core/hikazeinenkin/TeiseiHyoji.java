/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 訂正表示を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 liangbc
 */
public enum TeiseiHyoji {

    /**
     * コード:0 名称:初回回付 略称:定義なし
     */
    初回回付("0", "初回回付"),
    /**
     * コード:1 名称:月次回付 略称:定義なし
     */
    月次回付("1", "月次回付");

    private final RString code;
    private final RString fullName;

    private TeiseiHyoji(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 訂正表示のコードを返します。
     *
     * @return 訂正表示のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 訂正表示の名称を返します。
     *
     * @return 訂正表示の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 訂正表示のコードと一致する内容を探します。
     *
     * @param code 訂正表示のコード
     * @return {@code code} に対応する訂正表示
     */
    public static TeiseiHyoji toValue(RString code) {
        for (TeiseiHyoji teiseiHyoji : TeiseiHyoji.values()) {
            if (teiseiHyoji.code.equals(code)) {
                return teiseiHyoji;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("訂正表示"));
    }
}
