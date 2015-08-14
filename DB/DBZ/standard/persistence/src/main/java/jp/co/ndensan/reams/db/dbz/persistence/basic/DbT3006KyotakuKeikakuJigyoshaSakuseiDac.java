/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakusei;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakusei.hihokenshano;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakusei.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakusei.taishoYM;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画事業者作成のデータアクセスクラスです。
 */
public class DbT3006KyotakuKeikakuJigyoshaSakuseiDac implements ISaveable<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで居宅給付計画事業者作成を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 TaishoYM
     * @param 履歴番号 RirekiNo
     * @return DbT3006KyotakuKeikakuJigyoshaSakuseiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3006KyotakuKeikakuJigyoshaSakuseiEntity selectByKey(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3006KyotakuKeikakuJigyoshaSakusei.class).
                where(and(
                                eq(hihokenshano, 被保険者番号),
                                eq(taishoYM, 対象年月),
                                eq(rirekiNo, 履歴番号))).
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

    /**
     * DbT3006KyotakuKeikakuJigyoshaSakuseiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画事業者作成エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
