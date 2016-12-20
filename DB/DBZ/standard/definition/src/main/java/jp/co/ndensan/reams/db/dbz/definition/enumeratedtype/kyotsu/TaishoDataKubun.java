/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 基本運用の対象データ範囲を定義した列挙型です。
 *
 * @author n3521 星野 正明
 */
public enum TaishoDataKubun implements IRStringConvertable {

    /**
     * 未処理分であることを表します。
     */
    未処理("1"),
    /**
     * 完了可能分であることを表します。
     */
    完了可能("2"),
    /**
     * すべて であることを表します。
     */
    すべて("3");
    private final RString code;

    private TaishoDataKubun(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return this.code;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }

}
