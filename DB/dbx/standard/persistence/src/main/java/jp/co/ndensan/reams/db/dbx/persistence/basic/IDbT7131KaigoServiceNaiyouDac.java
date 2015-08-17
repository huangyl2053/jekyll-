/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.ur.urz.persistence.db.IDeletable;
import jp.co.ndensan.reams.ur.urz.persistence.db.IInsertable;
import jp.co.ndensan.reams.ur.urz.persistence.db.IUpdatable;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護サービス内容DACのインターフェースです。
 *
 * @author n8104 小玉　洋一
 * @jpName 介護サービス内容Dacインタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public interface IDbT7131KaigoServiceNaiyouDac extends
        IUpdatable<DbT7131KaigoServiceNaiyouEntity>, IInsertable<DbT7131KaigoServiceNaiyouEntity>, IDeletable<DbT7131KaigoServiceNaiyouEntity> {

    /**
     * 介護サービス内容から値を検索して取得します。
     *
     * @param criteria where条件句の基準
     * @return 証明書手数料テーブルのレコード
     */
    @Transaction
    List<DbT7131KaigoServiceNaiyouEntity> selectList(ITrueFalseCriteria criteria);

    /**
     * 介護サービス内容テーブルを挿入または更新します。
     *
     * @param kaigoServiceNaiyoEntity データベースに反映されるデータ
     * @return 更新した行の数
     */
    @Transaction
    int insertOrUpdate(DbT7131KaigoServiceNaiyouEntity kaigoServiceNaiyoEntity);

    /**
     * 介護サービス内容テーブルを削除します。
     *
     * @param kaigoServiceNaiyoEntity データベースに反映されるデータ
     * @return 削除した行の数
     */
    @Transaction
    @Override
    int delete(DbT7131KaigoServiceNaiyouEntity kaigoServiceNaiyoEntity);
}
