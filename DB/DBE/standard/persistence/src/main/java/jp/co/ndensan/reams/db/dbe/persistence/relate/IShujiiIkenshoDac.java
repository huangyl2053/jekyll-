/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.relate.ShujiiIkenshoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書のデータアクセスインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IShujiiIkenshoDac {

    /**
     * 引数の条件に該当する主治医意見書エンティティを取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 意見書履歴番号 意見書履歴番号
     * @return 主治医意見書エンティティ
     */
    @Transaction
    ShujiiIkenshoEntity select(ShinseishoKanriNo 申請書管理番号, IkenshosakuseiIraiRirekiNo 意見書履歴番号);

    /**
     * 指定した主治医意見書エンティティを追加、または更新します。
     *
     * @param entity 主治医意見書エンティティ
     * @return 追加、または更新が成功した場合はtrueを返します。
     */
    @Transaction
    boolean insertOrUpdate(ShujiiIkenshoEntity entity);

    /**
     * 指定した主治医意見書エンティティを追加します。
     *
     * @param entity 主治医意見書エンティティ
     * @return 追加が成功した場合はtrueを返します。
     */
    @Transaction
    boolean insert(ShujiiIkenshoEntity entity);

    /**
     * 指定した主治医意見書エンティティを更新します。
     *
     * @param entity 主治医意見書エンティティ
     * @return 更新が成功した場合はtrueを返します。
     */
    @Transaction
    boolean update(ShujiiIkenshoEntity entity);

    /**
     * 指定した主治医意見書エンティティを削除します。
     *
     * @param entity 主治医意見書エンティティ
     * @return 削除が成功した場合はtrueを返します。
     */
    @Transaction
    boolean delete(ShujiiIkenshoEntity entity);
}
