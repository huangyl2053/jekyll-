/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.NyushoJyokyo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 施設入退所の検索機能を提供するインタフェースです。
 * <p>
 * 処理の対象となるビュー・テーブルは、被保険者施設入退所、介護事業者、介護事業者代表者、介護事業者指定サービスです。<br/>
 * </p>
 * <p>
 * <br/>
 * ■関連ビュー・テーブル
 * <ul>
 * <li>{@link jp.co.ndensan.reams.ur.urf.entity.basic.DbV1004HihokenshaShisetsuNyutaishoEntity}</li>
 * <li>{@link jp.co.ndensan.reams.ur.urf.entity.basic.UrT0518KaigoJigyoshaEntity}</li>
 * <li>{@link jp.co.ndensan.reams.ur.urf.entity.basic.UrT0520KaigoJigyoshaDaihyoshaEntity}</li>
 * <li>{@link jp.co.ndensan.reams.ur.urf.entity.basic.UrT0521KaigoJigyoshaShiteiServiceEntity}</li>
 * </ul>
 * </p>
 * <hr>
 *
 * @author n8156 宮本 康
 * @jpName 施設入退所管理インタフェース
 * @bizDomain 介護
 * @category 施設入退所
 * @subCategory
 * @mainClass ○
 * @reference
 */
public interface IShisetsuNyutaishoFinder {

    /**
     * 識別コードを指定して該当する入所状況のリストを取得します。
     *
     * @param shikibetsuCd 識別コード
     *
     * @return 入所状況のリスト
     */
    List<NyushoJyokyo> get施設入退所ALL(ShikibetsuCode shikibetsuCd);
}
