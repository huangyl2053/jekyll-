/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3088KyufuhiKashitsukekinShakuyoshoJuri;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3088KyufuhiKashitsukekinShakuyoshoJuri.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3088KyufuhiKashitsukekinShakuyoshoJuri.kariireShinseiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3088KyufuhiKashitsukekinShakuyoshoJuri.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付費貸付金借用書受理のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3088KyufuhiKashitsukekinShakuyoshoJuriDac implements IModifiable<DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付費貸付金借用書受理を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 借入申請年月日 KariireShinseiYMD
     * @param 処理日時 ShoriTimestamp
     * @return DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 借入申請年月日,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(借入申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請年月日"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3088KyufuhiKashitsukekinShakuyoshoJuri.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kariireShinseiYMD, 借入申請年月日),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity.class);
    }

    /**
     * 給付費貸付金借用書受理を全件返します。
     *
     * @return List<DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity>
     */
    @Transaction
    public List<DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3088KyufuhiKashitsukekinShakuyoshoJuri.class).
                toList(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
