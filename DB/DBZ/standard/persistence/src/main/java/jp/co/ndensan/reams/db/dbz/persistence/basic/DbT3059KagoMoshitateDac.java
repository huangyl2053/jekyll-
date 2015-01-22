/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3059KagoMoshitate;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3059KagoMoshitate.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3059KagoMoshitate.jigyoshoNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3059KagoMoshitate.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3059KagoMoshitate.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3059KagoMoshitateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 過誤申立のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3059KagoMoshitateDac implements IModifiable<DbT3059KagoMoshitateEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで過誤申立を取得します。
     *
     * @param 事業所番号 JigyoshoNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 処理日時 ShoriTimestamp
     * @return DbT3059KagoMoshitateEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3059KagoMoshitateEntity selectByKey(
            JigyoshaNo 事業所番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3059KagoMoshitate.class).
                where(and(
                                eq(jigyoshoNo, 事業所番号),
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3059KagoMoshitateEntity.class);
    }

    /**
     * 過誤申立を全件返します。
     *
     * @return List<DbT3059KagoMoshitateEntity>
     */
    @Transaction
    public List<DbT3059KagoMoshitateEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3059KagoMoshitate.class).
                toList(DbT3059KagoMoshitateEntity.class);
    }

    /**
     * 過誤申立を追加します。
     *
     * @param entity 過誤申立
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3059KagoMoshitateEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 過誤申立をDBに更新します。
     *
     * @param entity 過誤申立
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3059KagoMoshitateEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 過誤申立をDBから削除します。（論理削除）
     *
     * @param entity 過誤申立
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3059KagoMoshitateEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 過誤申立を物理削除。
     *
     * @param entity 過誤申立
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3059KagoMoshitateEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
