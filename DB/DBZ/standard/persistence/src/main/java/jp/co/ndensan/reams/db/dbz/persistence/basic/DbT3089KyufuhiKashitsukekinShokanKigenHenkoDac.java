/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenko;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenko.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenko.kashitsukeKanriNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenko.shokanKigenEnchoUketsukeYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenko.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付費貸付金償還期限変更のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3089KyufuhiKashitsukekinShokanKigenHenkoDac implements IModifiable<DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付費貸付金償還期限変更を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 貸付管理番号 KashitsukeKanriNo
     * @param 償還期限延長受付年月日 ShokanKigenEnchoUketsukeYMD
     * @param 処理日時 ShoriTimestamp
     * @return DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 貸付管理番号,
            FlexibleDate 償還期限延長受付年月日,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        requireNonNull(償還期限延長受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限延長受付年月日"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3089KyufuhiKashitsukekinShokanKigenHenko.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kashitsukeKanriNo, 貸付管理番号),
                                eq(shokanKigenEnchoUketsukeYMD, 償還期限延長受付年月日),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity.class);
    }

    /**
     * 給付費貸付金償還期限変更を全件返します。
     *
     * @return List<DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity>
     */
    @Transaction
    public List<DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3089KyufuhiKashitsukekinShokanKigenHenko.class).
                toList(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
