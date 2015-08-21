/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import jp.co.ndensan.reams.db.dbx.business.IKogakuKaigoServiceHi;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費の検索機能を提供するインタフェースです。
 * <p>
 * 処理の対象となるテーブルは、高額支給判定結果（DbV3057KogakuShikyuHanteiKekka）です。<br />
 * このインタフェースのインスタンスは、{@link KogakuKaigoServiceHiFinderFactory#getInstance() }
 * で取得してください。
 * </p>
 * <p>
 * ■関連クラス
 * <ul>
 * <li>{@link IKogakuKaigoServiceHi}</li>
 * </ul>
 * ■関連テーブル
 * <ul>
 * <li>{@link jp.co.ndensan.reams.ur.urd.entity.basic.DbV3057KogakuShikyuHanteiKekkaEntity}</li>
 * </ul>
 * </p>
 * <hr>
 *
 * @author N9943 王 永康
 * @jpName 高額介護サービス費取得インタフェース
 * @bizDomain 介護
 * @category 高額介護給付費
 * @subCategory
 * @mainClass ○
 * @reference
 */
public interface IKogakuKaigoServiceHiFinder {

    /**
     * 識別コード、対象年月に対する高額介護サービス費を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @return 高額介護サービス費
     */
    IKogakuKaigoServiceHi get支給情報(RString 被保険者番号, FlexibleYearMonth 対象年月);
}
