/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医情報のデータアクセスインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IShujiiDac extends IReplaceable<DbT7012ShujiiJohoEntity>, IDeletable<DbT7012ShujiiJohoEntity> {

    /**
     * 引数の条件に該当する主治医情報エンティティを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護医療機関コード 介護医療機関コード
     * @param 介護医師コード 介護医師コード
     * @return 主治医情報エンティティ
     */
    @Transaction
    DbT7012ShujiiJohoEntity select(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード);

    int insertOrUpdate(DbT7012ShujiiJohoEntity entity);

    int insert(DbT7012ShujiiJohoEntity entity);

    int update(DbT7012ShujiiJohoEntity entity);

    int delete(DbT7012ShujiiJohoEntity entity);

}
