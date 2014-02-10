/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 審査会開催場所が存在する地区コードを表すクラスです
 *
 * @author N1013 松本直樹
 */
public class KaisaiBashoChikuCode implements IDbColumnMappable {

    private final RString 開催場所地区コード;

    /**
     * コンストラクタです
     *
     * @param 開催場所地区コード 開催場所地区コード
     */
    public KaisaiBashoChikuCode(RString 開催場所地区コード) {
        this.開催場所地区コード = 開催場所地区コード;
    }

    /**
     * 開催場所地区コードを取得します
     *
     * @return 開催場所地区コード
     */
    @Override
    public RString getColumnValue() {
        return 開催場所地区コード;
    }
}
