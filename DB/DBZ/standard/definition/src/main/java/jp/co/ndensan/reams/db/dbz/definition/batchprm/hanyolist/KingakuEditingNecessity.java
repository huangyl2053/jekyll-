/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト金額編集を表す列挙型です。
 *
 * @reamsid_L DBZ-4570-010 jinge
 */
public enum KingakuEditingNecessity {
    /**
     * コード:0 名称:不要 略称:定義なし
     */
    不要("0", "不要"),
    /**
     * コード:1 名称:必要 略称:定義なし
     */
    必要("1", "必要");

    private final RString code;
    private final RString fullName;

    private KingakuEditingNecessity(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 汎用リスト金額編集のコードを返します。
     *
     * @return 汎用リスト金額編集のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 汎用リスト金額編集の名称を返します。
     *
     * @return 汎用リスト金額編集の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 汎用リスト金額編集のコードと一致する内容を探します。
     *
     * @param code 汎用リスト金額編集のコード
     * @return {@code code} に対応する汎用リスト金額編集
     */
    public static KingakuEditingNecessity toValue(RString code) {
        for (KingakuEditingNecessity kingakuEditingNecessity : KingakuEditingNecessity.values()) {
            if (kingakuEditingNecessity.code.equals(code)) {
                return kingakuEditingNecessity;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("汎用リスト金額編集"));
    }
}
