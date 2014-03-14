/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書作成依頼情報を管理するインターフェースです。
 *
 * @author N8187 久保田 英男
 */
public interface IShujiiIkenshoIraiJohoDac {

    /**
     * 申請書管理番号で指定された主治医意見書作成依頼情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @return 主治医意見書作成依頼情報エンティティ
     */
    // TODO N8187 久保田英男 主治医意見書作成依頼履歴番号は業務クラスとして作成予定。クラスが作成されたら修正を行う。 2014/3月末まで
    @Transaction
    DbT5011ShujiiIkenshoIraiJohoEntity select(ShinseishoKanriNo 申請書管理番号, int 主治医意見書作成依頼履歴番号);
}
