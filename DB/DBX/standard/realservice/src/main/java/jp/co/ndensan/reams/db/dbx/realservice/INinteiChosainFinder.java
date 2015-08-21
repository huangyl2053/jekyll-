/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.INinteiChosain;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査員の検索機能を提供するインタフェースです。
 * <p>
 * 処理の対象となるテーブルは、調査員情報（ChosainJoho）です。<br/>
 * このインタフェースのインスタンスは、{@link NinteiChosainFinderFactory#getInstance() }
 * で取得してください。
 * </p>
 * <p>
 * <br/>
 * ■関連クラス
 * <ul>
 * <li>{@link IKaigoJigyoshaFinder}</li>
 * </ul>
 * ■関連テーブル
 * <ul>
 * <li>{@link jp.co.ndensan.reams.ur.urf.entity.basic.ChosainJohoEntity}</li>
 * </ul>
 * </p>
 * <hr>
 *
 * @author N2204 三井 沙織
 * @jpName 認定調査員取得インタフェース
 * @bizDomain 介護
 * @category 認定調査員
 * @subCategory
 * @mainClass ○
 * @reference
 */
public interface INinteiChosainFinder {

    /**
     * 指定した認定調査員番号に対応する認定調査員を取得します。
     *
     * @param 介護調査員番号 認定調査員番号
     *
     * @return 認定調査員
     */
    INinteiChosain get認定調査員(RString 介護調査員番号);

    /**
     * 指定した事業者に所属する認定調査員のリストを取得します。
     *
     * @param 所属事業者 所属事業者
     *
     * @return 認定調査員のリスト
     */
    List<INinteiChosain> get所属認定調査員(IKaigoJigyosha 所属事業者);
}
