/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3092KyufuhiKashitsukeKinChoshu;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3092KyufuhiKashitsukeKinChoshu.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3092KyufuhiKashitsukeKinChoshu.kashitsukeKanriNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3092KyufuhiKashitsukeKinChoshu.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3092KyufuhiKashitsukeKinChoshuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付費貸付金徴収のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3092KyufuhiKashitsukeKinChoshuDac implements IModifiable<DbT3092KyufuhiKashitsukeKinChoshuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付費貸付金徴収を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 貸付管理番号 KashitsukeKanriNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT3092KyufuhiKashitsukeKinChoshuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3092KyufuhiKashitsukeKinChoshuEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 貸付管理番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3092KyufuhiKashitsukeKinChoshu.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kashitsukeKanriNo, 貸付管理番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3092KyufuhiKashitsukeKinChoshuEntity.class);
    }

    /**
     * 給付費貸付金徴収を全件返します。
     *
     * @return List<DbT3092KyufuhiKashitsukeKinChoshuEntity>
     */
    @Transaction
    public List<DbT3092KyufuhiKashitsukeKinChoshuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3092KyufuhiKashitsukeKinChoshu.class).
                toList(DbT3092KyufuhiKashitsukeKinChoshuEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3092KyufuhiKashitsukeKinChoshuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3092KyufuhiKashitsukeKinChoshuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3092KyufuhiKashitsukeKinChoshuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3092KyufuhiKashitsukeKinChoshuEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3092KyufuhiKashitsukeKinChoshuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
