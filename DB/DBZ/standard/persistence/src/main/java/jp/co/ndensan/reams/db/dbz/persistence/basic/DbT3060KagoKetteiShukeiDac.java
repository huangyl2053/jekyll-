/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3060KagoKetteiShukei;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3060KagoKetteiShukei.hokenshaKubun;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3060KagoKetteiShukei.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3060KagoKetteiShukei.toriatsukaiYM;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3060KagoKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 過誤決定集計のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3060KagoKetteiShukeiDac implements IModifiable<DbT3060KagoKetteiShukeiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで過誤決定集計を取得します。
     *
     * @param 取扱年月 ToriatsukaiYM
     * @param 保険者区分 HokenshaKubun
     * @param 処理日時 ShoriTimestamp
     * @return DbT3060KagoKetteiShukeiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3060KagoKetteiShukeiEntity selectByKey(
            FlexibleYearMonth 取扱年月,
            RString 保険者区分,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3060KagoKetteiShukei.class).
                where(and(
                                eq(toriatsukaiYM, 取扱年月),
                                eq(hokenshaKubun, 保険者区分),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3060KagoKetteiShukeiEntity.class);
    }

    /**
     * 過誤決定集計を全件返します。
     *
     * @return List<DbT3060KagoKetteiShukeiEntity>
     */
    @Transaction
    public List<DbT3060KagoKetteiShukeiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3060KagoKetteiShukei.class).
                toList(DbT3060KagoKetteiShukeiEntity.class);
    }

    /**
     * 過誤決定集計を追加します。
     *
     * @param entity 過誤決定集計
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3060KagoKetteiShukeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 過誤決定集計をDBに更新します。
     *
     * @param entity 過誤決定集計
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3060KagoKetteiShukeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 過誤決定集計をDBから削除します。（論理削除）
     *
     * @param entity 過誤決定集計
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3060KagoKetteiShukeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 過誤決定集計を物理削除。
     *
     * @param entity 過誤決定集計
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3060KagoKetteiShukeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
