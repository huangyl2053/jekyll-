/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険の定数クラスです。
 *
 * @author N8187 久保田 英男
 */
public final class YokaigoninteiDateConstants {

    public static final FlexibleDate 認定調査未完了年月日;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private YokaigoninteiDateConstants() {
    }

    static {
        認定調査未完了年月日 = new FlexibleDate(new RString("00000000"));
    }
}
