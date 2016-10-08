/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力方法列挙型です。
 *
 * @reamsid_L DBD-3930-011 liwul
 */
public enum Outputs {

    /**
     * コード:1 名称:帳票・CSV出力 略称:定義なし
     */
    帳票_CSV出力("1", "帳票・CSV出力"),
    /**
     * コード:2 名称:帳票のみ出力 略称:定義なし
     */
    帳票のみ出力("2", "帳票のみ出力"),
    /**
     * コード:3 名称:CSVのみ出力 略称:定義なし
     */
    CSVのみ出力("3", "CSVのみ出力");

    private final RString code;
    private final RString fullName;

    private Outputs(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 汎用リスト出力方法のコードと一致する内容を探します。
     *
     * @param code 汎用リスト出力方法のコード
     * @return {@code code} に対応する地区
     */
    public static Outputs toValue(RString code) {
        for (Outputs outputs : Outputs.values()) {
            if (outputs.code.equals(code)) {
                return outputs;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("地区"));
    }
}
