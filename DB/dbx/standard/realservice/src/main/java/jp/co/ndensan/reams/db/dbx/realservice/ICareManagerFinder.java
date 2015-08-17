/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.ICareManager;
import jp.co.ndensan.reams.db.dbx.business.IKaigoJigyosha;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ケアマネージャの検索機能を提供するインタフェースです。
 * <p>
 * 処理の対象となるテーブルは、ケアマネージャ（UrT0524CareManeger）です。<br />
 * このインタフェースのインスタンスは、{@link CareManagerFinderFactory#getInstance() } で取得してください。
 * </p>
 * <p>
 * <br/>
 * ■関連クラス
 * <ul>
 * <li>{@link IKaigoJigyoshaFinder}</li>
 * </ul>
 * ■関連テーブル
 * <ul>
 * <li>{@link jp.co.ndensan.reams.ur.urf.entity.basic.UrT0524CareManegerEntity}</li>
 * </ul>
 * </p>
 * <hr>
 *
 * @author n9944 趙 春暉
 * @jpName ケアマネージャ取得インタフェース
 * @bizDomain 介護
 * @category ケアマネージャ
 * @subCategory
 * @mainClass ○
 * @reference
 */
public interface ICareManagerFinder {

    /**
     * 介護支援専門員番号を指定して該当するケアマネージャを取得します。
     *
     * @param 介護支援専門員番号 介護支援専門員番号
     *
     * @return ケアマネージャ
     */
    ICareManager getCareManager(RString 介護支援専門員番号);

    /**
     * 介護事業者を指定して所属するケアマネージャのリストを取得します。
     *
     * @param 所属事業者 所属事業者
     *
     * @return ケアマネージャのリスト
     */
    List<ICareManager> get所属ケアマネージャ(IKaigoJigyosha 所属事業者);
}
