/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 開催場所コードを表すクラスです
 *
 * @author N1013 松本直樹
 */
public class KaisaiBashoCode implements IDbColumnMappable {

    private final RString 開催場所コード;

    /**
     * コンストラクタです
     *
     * @param 開催場所コード 開催場所コード
     */
    public KaisaiBashoCode(RString 開催場所コード) {
        this.開催場所コード = 開催場所コード;
    }

    /**
     * 事業者番号を取得します
     *
     * @return 開催場所コード
     */
    @Override
    public RString getColumnValue() {
        return 開催場所コード;
    }
}
