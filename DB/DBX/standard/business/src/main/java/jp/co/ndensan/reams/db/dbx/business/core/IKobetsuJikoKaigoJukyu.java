/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.JukyushaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 個別事項の介護受給情報を表すインタフェースです。
 * <p>
 * ■主要メソッド
 * <ul>
 * <li>{@link #get受給者区分() get受給者区分} … 基準日と認定有効期間に応じた受給者区分(受給者、非受給者)を返します。</li>
 * </ul>
 * </p>
 * <hr>
 *
 * @author N2218 村松 優
 * @jpName 個別事項介護受給インタフェース
 * @bizDomain 介護
 * @category 個別事項
 * @subCategory
 * @mainClass
 * @reference
 */
public interface IKobetsuJikoKaigoJukyu extends Serializable {

    /**
     * 受給者区分を取得します。
     *
     * @return 受給者区分
     */
    JukyushaKubun get受給者区分();

    /**
     * 要介護状態区分を取得します。
     *
     * @return 要介護状態区分
     */
    YoKaigoJotaiKubun get要介護状態区分();

    /**
     * 認定有効開始日を取得します。
     *
     * @return 認定有効開始日
     */
    RDate get認定有効開始日();

    /**
     * 認定有効終了日を取得します。
     *
     * @return 認定有効終了日
     */
    RDate get認定有効終了日();

    /**
     * 受給認定年月日を取得します。
     *
     * @return 受給認定年月日
     */
    RDate get認定年月日();
}
