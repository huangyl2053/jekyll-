/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteiChosaTokkijikoEntity;
import jp.co.ndensan.reams.ur.urz.persistence.basic.IDeletable;
import jp.co.ndensan.reams.ur.urz.persistence.basic.IInsertable;
import jp.co.ndensan.reams.ur.urz.persistence.basic.IUpdatable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定調査特記情報のデータアクセスインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface INinteichosaTokkijikoDac extends
        IInsertable<DbT5010NinteiChosaTokkijikoEntity>,
        IUpdatable<DbT5010NinteiChosaTokkijikoEntity>,
        IDeletable<DbT5010NinteiChosaTokkijikoEntity> {

    /**
     * 引数の条件に該当する要介護認定調査特記情報エンティティを取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査履歴番号 認定調査履歴番号
     * @return 要介護認定調査特記情報エンティティ
     */
    @Transaction
    DbT5010NinteiChosaTokkijikoEntity select(RString 申請書管理番号, int 認定調査履歴番号);

    /**
     * 引数の要介護認定調査特記情報エンティティを追加、または更新します。
     *
     * @param entity 要介護認定調査特記情報エンティティ
     * @return 追加、または更新結果
     */
    @Transaction
    int insertOrUpdate(DbT5010NinteiChosaTokkijikoEntity entity);
}
