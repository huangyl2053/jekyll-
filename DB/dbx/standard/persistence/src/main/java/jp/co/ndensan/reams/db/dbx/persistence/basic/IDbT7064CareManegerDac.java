/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ケアマネージャDACの振る舞いを定義します。
 *
 * @author n9944 趙 春暉
 * @jpName ケアマネージャDacインタフェース
 * @bizDomain 介護
 * @category ケアマネージャ
 * @subCategory
 * @mainClass
 * @reference
 */
public interface IDbT7064CareManegerDac {

    /**
     * 指定された介護支援専門員番号のケアマネージャを返します。
     *
     * @param 介護支援専門員番号 介護支援専門員番号
     * @return 検索結果
     */
    @Transaction
    DbT7064CareManegerEntity selectByNumber(RString 介護支援専門員番号);

    /**
     * 指定された事業者に所属するケアマネージャのリストを返します。
     *
     * @param 介護事業者番号 介護事業者番号
     * @return 検索結果
     */
    @Transaction
    List<DbT7064CareManegerEntity> selectByJigyoshaCode(KaigoJigyoshaNo 介護事業者番号);
}
