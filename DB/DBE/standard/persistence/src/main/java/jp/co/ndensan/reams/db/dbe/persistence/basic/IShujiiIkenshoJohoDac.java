/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5012ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書情報のデータアクセスインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IShujiiIkenshoJohoDac
        extends IReplaceable<DbT5012ShujiiIkenshoJohoEntity>, IDeletable<DbT5012ShujiiIkenshoJohoEntity> {

    /**
     * 引数の条件に該当する主治医意見書情報エンティティを取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 意見書履歴番号 意見書履歴番号
     * @return 主治医意見書情報エンティティ
     */
    @Transaction
    DbT5012ShujiiIkenshoJohoEntity select(ShinseishoKanriNo 申請書管理番号, IkenshosakuseiIraiRirekiNo 意見書履歴番号);
}
