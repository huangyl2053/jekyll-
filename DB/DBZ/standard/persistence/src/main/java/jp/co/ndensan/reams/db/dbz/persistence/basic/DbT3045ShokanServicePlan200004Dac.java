/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3045ShokanServicePlan200004;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3045ShokanServicePlan200004.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3045ShokanServicePlan200004.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3045ShokanServicePlan200004.seiriNp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3045ShokanServicePlan200004.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3045ShokanServicePlan200004.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3045ShokanServicePlan200004.yoshikiNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3045ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払請求サービス計画200004のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3045ShokanServicePlan200004Dac implements IModifiable<DbT3045ShokanServicePlan200004Entity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで償還払請求サービス計画200004を取得します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNp
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 YoshikiNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT3045ShokanServicePlan200004Entity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3045ShokanServicePlan200004Entity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RDateTime 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3045ShokanServicePlan200004.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(seiriNp, 整理番号),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yoshikiNo, 様式番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3045ShokanServicePlan200004Entity.class);
    }

    /**
     * 償還払請求サービス計画200004を全件返します。
     *
     * @return List<DbT3045ShokanServicePlan200004Entity>
     */
    @Transaction
    public List<DbT3045ShokanServicePlan200004Entity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3045ShokanServicePlan200004.class).
                toList(DbT3045ShokanServicePlan200004Entity.class);
    }

    /**
     * 償還払請求サービス計画200004を追加します。
     *
     * @param entity 償還払請求サービス計画200004
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3045ShokanServicePlan200004Entity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 償還払請求サービス計画200004をDBに更新します。
     *
     * @param entity 償還払請求サービス計画200004
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3045ShokanServicePlan200004Entity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 償還払請求サービス計画200004をDBから削除します。（論理削除）
     *
     * @param entity 償還払請求サービス計画200004
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3045ShokanServicePlan200004Entity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 償還払請求サービス計画200004を物理削除。
     *
     * @param entity 償還払請求サービス計画200004
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3045ShokanServicePlan200004Entity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
