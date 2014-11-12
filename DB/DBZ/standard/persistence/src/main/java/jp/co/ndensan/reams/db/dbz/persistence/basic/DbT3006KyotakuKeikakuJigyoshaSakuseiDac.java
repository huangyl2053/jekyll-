/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakusei;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakusei.hihokenshano;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakusei.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakusei.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakusei.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakusei.taishoYM;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * 居宅給付計画事業者作成のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT3006KyotakuKeikakuJigyoshaSakuseiDac implements IModifiable<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで居宅給付計画事業者作成を取得します。
     *
     * @param 被保険者番号 Hihokenshano
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 対象年月 TaishoYM
     * @param 処理日時 ShoriTimestamp
     * @return DbT3006KyotakuKeikakuJigyoshaSakuseiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3006KyotakuKeikakuJigyoshaSakuseiEntity selectByKey(
            RString 被保険者番号,
            RString 証記載保険者番号,
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
                table(DbT3006KyotakuKeikakuJigyoshaSakusei.class).
                where(and(
                                eq(hihokenshano, 被保険者番号),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shikibetsuCode, 識別コード),
                                eq(taishoYM, 対象年月),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity.class);
    }

    /**
     * 居宅給付計画事業者作成を全件返します。
     *
     * @return List<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity>
     */
    @Transaction
    public List<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3006KyotakuKeikakuJigyoshaSakusei.class).
                toList(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3006KyotakuKeikakuJigyoshaSakuseiEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
