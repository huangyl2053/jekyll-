/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.ur.urz.persistence.db.IDeletable;
import jp.co.ndensan.reams.ur.urz.persistence.db.IInsertable;
import jp.co.ndensan.reams.ur.urz.persistence.db.IUpdatable;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護サービス種類DACのインターフェースです。
 *
 * @author n8104 小玉　洋一
 * @jpName 介護サービス種類Dacインタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public interface IDbT7130KaigoServiceShuruiDac extends
        IUpdatable<DbT7130KaigoServiceShuruiEntity>, IInsertable<DbT7130KaigoServiceShuruiEntity>, IDeletable<DbT7130KaigoServiceShuruiEntity> {

    /**
     * 介護サービス種類から値を検索して取得します。
     *
     * @param criteria 検索条件
     * @return 証明書手数料テーブルのレコード
     */
    @Transaction
    List<DbT7130KaigoServiceShuruiEntity> selectList(ITrueFalseCriteria criteria);

    /**
     * 介護サービス種類テーブルを挿入または更新します。
     *
     * @param kaigoServiceShuruiEntity データベースに反映されるデータ
     * @return 更新した行の数
     */
    @Transaction
    int insertOrUpdate(DbT7130KaigoServiceShuruiEntity kaigoServiceShuruiEntity);

    /**
     * 介護サービス種類テーブルを削除します。
     *
     * @param kaigoServiceShuruiEntity データベースに反映されるデータ
     * @return 削除した行の数
     */
    @Transaction
    @Override
    int delete(DbT7130KaigoServiceShuruiEntity kaigoServiceShuruiEntity);
}
