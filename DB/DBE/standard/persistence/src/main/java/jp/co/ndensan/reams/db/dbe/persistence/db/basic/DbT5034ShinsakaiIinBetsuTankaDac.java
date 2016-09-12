/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5034ShinsakaiIinBetsuTanka;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5034ShinsakaiIinBetsuTanka.ShinsakaiIinCode;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5034ShinsakaiIinBetsuTanka.kaishiYM;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5034ShinsakaiIinBetsuTanka.shuryoYM;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5034ShinsakaiIinBetsuTankaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会委員別単価のデータアクセスクラスです。
 *
 * @reamsid_L DBE-9999-011 dingyi
 */
public class DbT5034ShinsakaiIinBetsuTankaDac implements ISaveable<DbT5034ShinsakaiIinBetsuTankaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護認定審査会委員別単価を取得します。
     *
     * @param 介護認定審査会委員コード ShinsakaiIinCode
     * @param 開始年月 KaishiYM
     * @param 終了年月 ShuryoYM
     * @return DbT5034ShinsakaiIinBetsuTankaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5034ShinsakaiIinBetsuTankaEntity selectByKey(
            RString 介護認定審査会委員コード,
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月) throws NullPointerException {
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));
        requireNonNull(終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5034ShinsakaiIinBetsuTanka.class).
                where(and(
                                eq(ShinsakaiIinCode, 介護認定審査会委員コード),
                                eq(kaishiYM, 開始年月),
                                eq(shuryoYM, 終了年月))).
                toObject(DbT5034ShinsakaiIinBetsuTankaEntity.class);
    }

    /**
     * 介護認定審査会委員別単価を全件返します。
     *
     * @return List<DbT5034ShinsakaiIinBetsuTankaEntity>
     */
    @Transaction
    public List<DbT5034ShinsakaiIinBetsuTankaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5034ShinsakaiIinBetsuTanka.class).
                toList(DbT5034ShinsakaiIinBetsuTankaEntity.class);
    }

    /**
     * 介護認定審査会委員別単価を全件返します（識別子降順）。
     *
     * @return List<DbT5034ShinsakaiIinBetsuTankaEntity>
     */
    @Transaction
    public List<DbT5034ShinsakaiIinBetsuTankaEntity> selectAllOrderBy() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5034ShinsakaiIinBetsuTanka.class).
                order(by(ShinsakaiIinCode, Order.DESC),
                        by(kaishiYM, Order.DESC),
                        by(shuryoYM, Order.DESC)).
                toList(DbT5034ShinsakaiIinBetsuTankaEntity.class);
    }

    /**
     * DbT5034ShinsakaiIinBetsuTankaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5034ShinsakaiIinBetsuTankaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員別単価エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT5034ShinsakaiIinBetsuTankaEntityを物理削除します。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Transaction
    public int saveOrDeletePhysicalBy(DbT5034ShinsakaiIinBetsuTankaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員別単価エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
