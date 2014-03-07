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
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5022RenkeiyoDataSofuKiroku;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 連携用データ送付記録を管理するデータアクセスです。
 *
 * @author n8107 千秋雄
 */
public class RenkeiyoDataSofuKirokuDac implements IRenkeiyoDataSofuKirokuDac {

    @InjectSession
    private SqlSession session;
    private final DbAccessor accessor = new DbAccessor(session);

    @Override
    public DbT5022RenkeiyoDataSofuKirokuEntity select(RString 申請書管理番号) {

        return accessor.select().table(DbT5022RenkeiyoDataSofuKiroku.class).
                where(eq(DbT5022RenkeiyoDataSofuKiroku.shinseishoKanriNo, 申請書管理番号)).
                toObject(DbT5022RenkeiyoDataSofuKirokuEntity.class);
    }

    @Override
    public List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(RString 被保険者番号) {

        List<DbT5022RenkeiyoDataSofuKirokuEntity> list = accessor.select()
                .table(DbT5022RenkeiyoDataSofuKiroku.class)
                .where(eq(DbT5022RenkeiyoDataSofuKiroku.hihokenshaNo, 被保険者番号))
                .order(by(DbT5022RenkeiyoDataSofuKiroku.hikiwatashiNichiji, Order.DESC),
                        by(DbT5022RenkeiyoDataSofuKiroku.shinseishoKanriNo, Order.ASC))
                .toList(DbT5022RenkeiyoDataSofuKirokuEntity.class);

        return list;
    }

    @Override
    public List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(NinteiShinseijiKubun 認定申請時区分) {

        List<DbT5022RenkeiyoDataSofuKirokuEntity> list = accessor.select()
                .table(DbT5022RenkeiyoDataSofuKiroku.class)
                .where(eq(DbT5022RenkeiyoDataSofuKiroku.ninteiShinseiShinseijiKubun, 認定申請時区分))
                .order(by(DbT5022RenkeiyoDataSofuKiroku.hikiwatashiNichiji, Order.DESC),
                        by(DbT5022RenkeiyoDataSofuKiroku.shinseishoKanriNo, Order.ASC))
                .toList(DbT5022RenkeiyoDataSofuKirokuEntity.class);

        return list;
    }

    @Override
    public List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(HikiwatashiKubun 引渡し区分) {

        List<DbT5022RenkeiyoDataSofuKirokuEntity> list = accessor.select()
                .table(DbT5022RenkeiyoDataSofuKiroku.class)
                .where(eq(DbT5022RenkeiyoDataSofuKiroku.hikiwatashiKubun, 引渡し区分))
                .order(by(DbT5022RenkeiyoDataSofuKiroku.shinseishoKanriNo, Order.ASC),
                        by(DbT5022RenkeiyoDataSofuKiroku.hihokenshaNo, Order.ASC))
                .toList(DbT5022RenkeiyoDataSofuKirokuEntity.class);

        return list;
    }

    @Override
    public List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(RDateTime 引渡し日時) {

        List<DbT5022RenkeiyoDataSofuKirokuEntity> list = accessor.select()
                .table(DbT5022RenkeiyoDataSofuKiroku.class)
                .where(eq(DbT5022RenkeiyoDataSofuKiroku.hikiwatashiNichiji, 引渡し日時))
                .order(by(DbT5022RenkeiyoDataSofuKiroku.shinseishoKanriNo, Order.ASC),
                        by(DbT5022RenkeiyoDataSofuKiroku.hihokenshaNo, Order.ASC))
                .toList(DbT5022RenkeiyoDataSofuKirokuEntity.class);

        return list;
    }

    @Override
    public List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(SaiSoufuKubun 再送付区分) {

        List<DbT5022RenkeiyoDataSofuKirokuEntity> list = accessor.select()
                .table(DbT5022RenkeiyoDataSofuKiroku.class)
                .where(eq(DbT5022RenkeiyoDataSofuKiroku.saiSoufuKubun, 再送付区分))
                .order(by(DbT5022RenkeiyoDataSofuKiroku.hikiwatashiNichiji, Order.DESC),
                        by(DbT5022RenkeiyoDataSofuKiroku.shinseishoKanriNo, Order.ASC),
                        by(DbT5022RenkeiyoDataSofuKiroku.hihokenshaNo, Order.ASC))
                .toList(DbT5022RenkeiyoDataSofuKirokuEntity.class);

        return list;
    }

    @Override
    public List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(SaiChousaSoufuKubun 再調査送付区分) {

        List<DbT5022RenkeiyoDataSofuKirokuEntity> list = accessor.select()
                .table(DbT5022RenkeiyoDataSofuKiroku.class)
                .where(eq(DbT5022RenkeiyoDataSofuKiroku.saiChousaSoufuKubun, 再調査送付区分))
                .order(by(DbT5022RenkeiyoDataSofuKiroku.hikiwatashiNichiji, Order.DESC),
                        by(DbT5022RenkeiyoDataSofuKiroku.shinseishoKanriNo, Order.ASC),
                        by(DbT5022RenkeiyoDataSofuKiroku.hihokenshaNo, Order.ASC))
                .toList(DbT5022RenkeiyoDataSofuKirokuEntity.class);

        return list;
    }

    @Override
    public List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(SaiIkenshoSoufuKubun 再意見書送付区分) {

        List<DbT5022RenkeiyoDataSofuKirokuEntity> list = accessor.select()
                .table(DbT5022RenkeiyoDataSofuKiroku.class)
                .where(eq(DbT5022RenkeiyoDataSofuKiroku.saiIkenshoSoufuKubun, 再意見書送付区分))
                .order(by(DbT5022RenkeiyoDataSofuKiroku.hikiwatashiNichiji, Order.DESC),
                        by(DbT5022RenkeiyoDataSofuKiroku.shinseishoKanriNo, Order.ASC),
                        by(DbT5022RenkeiyoDataSofuKiroku.hihokenshaNo, Order.ASC))
                .toList(DbT5022RenkeiyoDataSofuKirokuEntity.class);

        return list;
    }

    /**
     * 連携用データ送付記録を新規追加・更新します。
     *
     * @param entity 連携用データ送付記録エンティティ
     * @return 追加更新結果
     */
    @Override
    public int insertOrUpdate(DbT5022RenkeiyoDataSofuKirokuEntity entity) {

        if (getMatchRowCount(entity) == 0) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }

    /**
     * 連携用データ送付記録を新規追加します。
     *
     * @param data 連携用データ送付記録エンティティ
     * @return 追加結果
     */
    @Override
    public int insert(DbT5022RenkeiyoDataSofuKirokuEntity data) {
        return accessor.insert(data).execute();
    }

    /**
     * 連携用データ送付記録を更新します.
     *
     * @param data 連携用データ送付記録エンティティ
     * @return 更新結果
     */
    @Override
    public int update(DbT5022RenkeiyoDataSofuKirokuEntity data) {
        return accessor.update(data).execute();
    }

    /**
     * 連携用データ送付記録を削除します。
     *
     * @param data 連携用データ送付記録エンティティ
     * @return 削除結果
     */
    @Override
    public int delete(DbT5022RenkeiyoDataSofuKirokuEntity data) {
        return accessor.delete(data).execute();
    }

    /**
     * 連携用データ送付記録の件数を取得します。
     *
     * @param entity 連携用データ送付記録エンティティ
     * @return 取得件数
     */
    private int getMatchRowCount(DbT5022RenkeiyoDataSofuKirokuEntity entity) {

        return accessor.
                select().
                table(DbT5022RenkeiyoDataSofuKiroku.class).
                where(eq(DbT5022RenkeiyoDataSofuKiroku.hikiwatashiKubun, entity.getHikiwatashiKubun())).getCount();
    }
}
