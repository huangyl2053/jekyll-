/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5008NinteichosaKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定調査結果情報のデータアクセスインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface INinteichosaKekkaJohoDac
        extends IReplaceable<DbT5008NinteichosaKekkaJohoEntity>, IDeletable<DbT5008NinteichosaKekkaJohoEntity> {

    /**
     * 引数の条件に該当する要介護認定調査結果情報エンティティを取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査履歴番号 認定調査履歴番号
     * @return 要介護認定調査結果情報エンティティ
     */
    @Transaction
    DbT5008NinteichosaKekkaJohoEntity select(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査履歴番号);
}
