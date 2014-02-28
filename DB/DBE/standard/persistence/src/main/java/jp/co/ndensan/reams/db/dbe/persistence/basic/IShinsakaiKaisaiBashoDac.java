/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.IReplaceable;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 審査会開催情報テーブルから情報を取得するクラスのインターフェースです。
 *
 * @author N1013 松本直樹
 */
public interface IShinsakaiKaisaiBashoDac
        extends IReplaceable<DbT5104ShinsakaiKaisaiBashoJohoEntity>, IDeletable<DbT5104ShinsakaiKaisaiBashoJohoEntity> {

    /**
     * 審査会開催場所コードを指定して、審査会開催場所情報を取得します。
     *
     * @param 審査会開催場所 審査会開催場所
     * @return 審査会開催場所Entity
     */
    @Transaction
    DbT5104ShinsakaiKaisaiBashoJohoEntity select(ShinsakaiKaisaiBashoCode 審査会開催場所);

    /**
     * 審査会開催場所コード、開催場所状況を指定して、審査会開催場所情報を取得します。
     *
     * @param 審査会開催場所 審査会開催場所
     * @param 開催場所状況 審査会開催場所状況
     * @return 審査会開催場所Entity
     */
    @Transaction
    DbT5104ShinsakaiKaisaiBashoJohoEntity select(ShinsakaiKaisaiBashoCode 審査会開催場所, ShinsakaiKaisaiBashoJokyo 開催場所状況);

    /**
     * 審査会開催場所テーブルにある全件を取得します。
     *
     * @return 審査会開催場所Entityリスト
     */
    @Transaction
    List<DbT5104ShinsakaiKaisaiBashoJohoEntity> selectAll();

    /**
     * 審査会開催場所テーブルにある有効な開催場所を全件取得します。
     *
     * @param 開催場所状況 開催場所状況
     * @return 審査会開催場所Entityリスト
     */
    @Transaction
    List<DbT5104ShinsakaiKaisaiBashoJohoEntity> selectAll(ShinsakaiKaisaiBashoJokyo 開催場所状況);
}
