/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 発番情報を表すクラスです
 *
 * @author N1013 松本直樹
 */
public class HatsubanJoho implements IDbColumnMappable {

    private RString 発番;
    private int 発番番号;

    /**
     * コンストラクタです
     *
     * @param 発番 発番
     */
    public HatsubanJoho(RString 発番) {
        this.発番 = 発番;
    }

    /**
     * 発番情報に＋１した値を返します
     *
     * @return
     */
    @Override
    public RString getColumnValue() {
        発番番号 = Integer.parseInt(発番.toString()) + 1;
        発番 = new RString(発番番号 + "");
        return 発番;
    }
}
