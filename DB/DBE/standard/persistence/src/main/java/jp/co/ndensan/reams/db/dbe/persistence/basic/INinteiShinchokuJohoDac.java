/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IUpdatable;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定進捗情報を管理するインターフェースです。
 *
 * @author N8187 久保田 英男
 */
public interface INinteiShinchokuJohoDac extends IUpdatable<DbT5005NinteiShinchokuJohoEntity> {

    /**
     * 要介護認定進捗情報から、認定調査完了年月日が”00000000”のデータを取得する
     *
     * @return 要介護認定進捗情報データのリスト
     */
    @Transaction
    List<DbT5005NinteiShinchokuJohoEntity> select認定調査未完了();

    /**
     * 要介護認定進捗情報から、認定調査依頼完了年月日が”00000000”以上で、認定調査完了年月日が”00000000”のデータを取得する
     *
     * @return 要介護認定進捗情報データのリスト
     */
    @Transaction
    List<DbT5005NinteiShinchokuJohoEntity> select依頼済認定調査未完了();

    @Override
    int update(DbT5005NinteiShinchokuJohoEntity entity);
}
