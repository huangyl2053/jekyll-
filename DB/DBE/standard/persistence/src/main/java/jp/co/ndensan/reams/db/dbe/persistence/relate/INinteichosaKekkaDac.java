/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定調査結果のデータアクセスインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface INinteichosaKekkaDac {

    /**
     * 引数の条件に該当する要介護認定調査結果エンティティを取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査履歴番号 認定調査履歴番号
     * @return 要介護認定調査結果エンティティ
     */
    @Transaction
    NinteichosaKekkaEntity select(RString 申請書管理番号, int 認定調査履歴番号);

    /**
     * 指定した要介護認定調査結果エンティティを追加、または更新します。
     *
     * @param entity 要介護認定調査結果エンティティ
     * @return 追加、または更新が成功した場合はtrueを返します。
     */
    @Transaction
    boolean insertOrUpdate(NinteichosaKekkaEntity entity);

    /**
     * 指定した要介護認定調査結果エンティティを追加します。
     *
     * @param entity 要介護認定調査結果エンティティ
     * @return 追加が成功した場合はtrueを返します。
     */
    @Transaction
    boolean insert(NinteichosaKekkaEntity entity);

    /**
     * 指定した要介護認定調査結果エンティティを更新します。
     *
     * @param entity 要介護認定調査結果エンティティ
     * @return 更新が成功した場合はtrueを返します。
     */
    @Transaction
    boolean update(NinteichosaKekkaEntity entity);

    /**
     * 指定した要介護認定調査結果エンティティを削除します。
     *
     * @param entity 要介護認定調査結果エンティティ
     * @return 削除が成功した場合はtrueを返します。
     */
    @Transaction
    boolean delete(NinteichosaKekkaEntity entity);
}
