/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNiss;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNiss.*;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
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
 * 予防給付計画自己作成短期利用日数のデータアクセスクラスです。
 */
public class DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuDac implements ISaveable<DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで予防給付計画自己作成短期利用日数を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 TaishoYM
     * @param 履歴番号 RirekiNo
     * @return DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNiss.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoYM, 対象年月),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity.class);
    }

    /**
     * 予防給付計画自己作成短期利用日数を全件返します。
     *
     * @return List<DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity>
     */
    @Transaction
    public List<DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNiss.class).
                toList(DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity.class);
    }

    /**
     * DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("予防給付計画自己作成短期利用日数エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
