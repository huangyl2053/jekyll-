/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import jp.co.ndensan.reams.db.dbx.entity.basic.DbV3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額介護サービス費のデータアクセスインターフェースです。
 *
 * @author N9943 王 永康
 * @jpName 高額介護サービス費Dacインタフェース
 * @bizDomain 介護
 * @category 高額介護給付費
 * @subCategory
 * @mainClass
 * @reference
 */
public interface IKogakuKaigoServiceHiDac {

    /**
     * 引数に該当する高額介護サービス費エンティティリストを取得します。
     *
     * @param 識別コード 識別コード
     * @param 対象年月 対象年月
     * @return 高額介護サービス費エンティティ
     */
    @Transaction
    DbV3057KogakuShikyuHanteiKekkaEntity select(RString 識別コード, FlexibleYearMonth 対象年月);
}
