/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.HikiwatashiKubun;
import jp.co.ndensan.reams.db.dbe.definition.NinteiShinseijiKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiChousaSoufuKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiIkenshoSoufuKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiSoufuKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5022RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 連携用データ送付記録を管理するインターフェースです。
 *
 * @author n8107 千秋雄
 */
public interface IRenkeiyoDataSofuKirokuDac extends
        IReplaceable<DbT5022RenkeiyoDataSofuKirokuEntity>, IDeletable<DbT5022RenkeiyoDataSofuKirokuEntity> {

    /**
     * 申請書管理番号を指定して連携用データ送付記録を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 連携用データ送付記録情報エンティティ
     */
    @Transaction
    DbT5022RenkeiyoDataSofuKirokuEntity select(RString 申請書管理番号);

    /**
     * 被保険者番号を指定して連携用データ送付記録を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 連携用データ送付記録情報エンティティ
     */
    @Transaction
    List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(RString 被保険者番号);

    /**
     * 認定申請時区分を指定して連携用データ送付記録を取得します。
     *
     * @param 認定申請時区分 認定申請時区分
     * @return 連携用データ送付記録情報エンティティ
     */
    @Transaction
    List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(NinteiShinseijiKubun 認定申請時区分);

    /**
     * 引渡し区分を指定して連携用データ送付記録を取得します。
     *
     * @param 引渡し区分 引渡し区分
     * @return 連携用データ送付記録情報エンティティ
     */
    @Transaction
    List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(HikiwatashiKubun 引渡し区分);

    /**
     * 引渡し日時を指定して連携用データ送付記録を取得します。
     *
     * @param 引渡し日時 引渡し日時
     * @return 連携用データ送付記録情報エンティティ
     */
    @Transaction
    List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(RDateTime 引渡し日時);

    /**
     * 再送付区分を指定して連携用データ送付記録を取得します。
     *
     * @param 再送付区分 再送付区分
     * @return 連携用データ送付記録情報エンティティ
     */
    @Transaction
    List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(SaiSoufuKubun 再送付区分);

    /**
     * 再調査送付区分を指定して連携用データ送付記録を取得します。
     *
     * @param 再調査送付区分 再調査送付区分
     * @return 連携用データ送付記録情報エンティティ
     */
    @Transaction
    List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(SaiChousaSoufuKubun 再調査送付区分);

    /**
     * 再意見書送付区分を指定して連携用データ送付記録を取得します。
     *
     * @param 再意見書送付区分 再意見書送付区分
     * @return 連携用データ送付記録情報エンティティ
     */
    @Transaction
    List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(SaiIkenshoSoufuKubun 再意見書送付区分);

    /**
     * 連携用データ送付記録情報に対し追加・更新を行います。
     *
     * @param entity 連携用データ送付記録情報エンティティ
     * @return 更新・追加結果
     */
    @Transaction
    @Override
    int insertOrUpdate(DbT5022RenkeiyoDataSofuKirokuEntity entity);

    /**
     * 連携用データ送付記録を削除します。
     *
     * @param data 連携用データ送付記録エンティティ
     * @return 削除結果
     */
    @Transaction
    @Override
    int delete(DbT5022RenkeiyoDataSofuKirokuEntity data);
}
