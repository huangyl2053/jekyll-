/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 事業者番号を表すクラスです
 *
 * @author N1013 松本直樹
 */
public class JigyoshaNo implements IDbColumnMappable {

    private final RString 事業者番号;

    /**
     * コンストラクタです
     *
     * @param 事業者番号 事業者番号
     */
    public JigyoshaNo(RString 事業者番号) {
        this.事業者番号 = 事業者番号;
    }

    /**
     * 事業者番号を取得します
     *
     * @return 事業者番号
     */
    @Override
    public RString getColumnValue() {
        return 事業者番号;
    }
}
