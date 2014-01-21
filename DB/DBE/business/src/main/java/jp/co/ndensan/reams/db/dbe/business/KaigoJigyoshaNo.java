/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 介護事業者番号を表すクラスです
 *
 * @author N1013 松本直樹
 */
public class KaigoJigyoshaNo implements IDbColumnMappable {

    private final RString 介護事業者番号;

    /**
     * コンストラクタです
     *
     * @param 介護事業者番号 介護事業者番号
     */
    public KaigoJigyoshaNo(RString 介護事業者番号) {
        this.介護事業者番号 = 介護事業者番号;
    }

    /**
     * 介護事業者番号を取得します
     *
     * @return 介護事業者番号
     */
    @Override
    public RString getColumnValue() {
        return 介護事業者番号;
    }
}
