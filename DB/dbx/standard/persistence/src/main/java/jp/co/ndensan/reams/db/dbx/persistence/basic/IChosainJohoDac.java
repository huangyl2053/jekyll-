/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 調査員情報DACの振る舞いを定義します。
 *
 * @author N2204 三井 沙織
 * @jpName 調査員情報Dacインタフェース
 * @bizDomain 介護
 * @category 認定調査員
 * @subCategory
 * @mainClass
 * @reference
 */
public interface IChosainJohoDac {

    /**
     * 指定された介護調査員番号の認定調査員を返します。
     *
     * @param 介護調査員番号 介護調査員番号
     * @return 調査員情報エンティティ
     */
    @Transaction
    ChosainJohoEntity selectByNumber(RString 介護調査員番号);

    /**
     * 指定された市町村コード、介護事業者番号、介護調査員番号に該当する認定調査員を返します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 介護調査員番号 介護調査員番号
     * @return 調査員情報エンティティ
     */
    @Transaction
    ChosainJohoEntity selectByAllKey(RString 市町村コード, KaigoJigyoshaNo 介護事業者番号, RString 介護調査員番号);

    /**
     * 指定された事業者に所属する認定調査員のリストを返します。
     *
     * @param 介護事業者番号 介護事業者番号
     * @return 調査員情報エンティティリスト
     */
    @Transaction
    List<ChosainJohoEntity> selectByJigyoshaCode(KaigoJigyoshaNo 介護事業者番号);
}
