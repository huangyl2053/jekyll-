/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokede;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokede.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokede.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokede.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokede.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokede.taishoYM;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画届出のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT3005KyotakuKeikakuTodokedeDac implements IModifiable<DbT3005KyotakuKeikakuTodokedeEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで居宅給付計画届出を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 対象年月 TaishoYM
     * @param 処理日時 ShoriTimestamp
     * @return DbT3005KyotakuKeikakuTodokedeEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3005KyotakuKeikakuTodokedeEntity selectByKey(
            HihokenshaNo 被保険者番号,
            HokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            FlexibleYearMonth 対象年月,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3005KyotakuKeikakuTodokede.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shikibetsuCode, 識別コード),
                                eq(taishoYM, 対象年月),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3005KyotakuKeikakuTodokedeEntity.class);
    }

    /**
     * 居宅給付計画届出を全件返します。
     *
     * @return List<DbT3005KyotakuKeikakuTodokedeEntity>
     */
    @Transaction
    public List<DbT3005KyotakuKeikakuTodokedeEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3005KyotakuKeikakuTodokede.class).
                toList(DbT3005KyotakuKeikakuTodokedeEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3005KyotakuKeikakuTodokedeEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3005KyotakuKeikakuTodokedeEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3005KyotakuKeikakuTodokedeEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3005KyotakuKeikakuTodokedeEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3005KyotakuKeikakuTodokedeEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
