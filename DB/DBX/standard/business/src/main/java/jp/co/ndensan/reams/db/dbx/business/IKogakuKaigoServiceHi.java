/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費情報の振る舞いを定義します。
 *
 * <p>
 * ■主要メソッド
 * <ul>
 * <li>{@link #get償還後利用者負担額() } … 保持している利用者負担額から支給高額介護サービス費を引いた金額を返します。</li>
 * </ul>
 * </p>
 *
 * @author N9943 王 永康
 * @jpName 高額介護サービス費インタフェース
 * @bizDomain 介護
 * @category 高額介護給付費
 * @subCategory
 * @mainClass
 * @reference
 */
public interface IKogakuKaigoServiceHi {

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    RString get被保険者番号();

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    FlexibleYearMonth getサービス提供年月();

    /**
     * 支給高額介護サービス費を返します。
     *
     * @return 支給高額介護サービス費
     */
    Decimal get支給高額介護サービス費();

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    Decimal get利用者負担額();

    /**
     * 償還後利用者負担額を返します。
     *
     * @return 償還後利用者負担額
     */
    Decimal get償還後利用者負担額();
}
