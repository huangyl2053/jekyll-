/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3037ShokanJuryoininMeisai;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3037ShokanJuryoininMeisai.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3037ShokanJuryoininMeisai.seiriNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3037ShokanJuryoininMeisai.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3037ShokanJuryoininMeisai.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3037ShokanJuryoininMeisaiEntity;
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
 * 償還払支給受領委任払明細のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3037ShokanJuryoininMeisaiDac implements IModifiable<DbT3037ShokanJuryoininMeisaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで償還払支給受領委任払明細を取得します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT3037ShokanJuryoininMeisaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3037ShokanJuryoininMeisaiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3037ShokanJuryoininMeisai.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNo, 整理番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3037ShokanJuryoininMeisaiEntity.class);
    }

    /**
     * 償還払支給受領委任払明細を全件返します。
     *
     * @return List<DbT3037ShokanJuryoininMeisaiEntity>
     */
    @Transaction
    public List<DbT3037ShokanJuryoininMeisaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3037ShokanJuryoininMeisai.class).
                toList(DbT3037ShokanJuryoininMeisaiEntity.class);
    }

    /**
     * 償還払支給受領委任払明細を追加します。
     *
     * @param entity 償還払支給受領委任払明細
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3037ShokanJuryoininMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 償還払支給受領委任払明細をDBに更新します。
     *
     * @param entity 償還払支給受領委任払明細
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3037ShokanJuryoininMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 償還払支給受領委任払明細をDBから削除します。（論理削除）
     *
     * @param entity 償還払支給受領委任払明細
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3037ShokanJuryoininMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 償還払支給受領委任払明細を物理削除。
     *
     * @param entity 償還払支給受領委任払明細
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3037ShokanJuryoininMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
