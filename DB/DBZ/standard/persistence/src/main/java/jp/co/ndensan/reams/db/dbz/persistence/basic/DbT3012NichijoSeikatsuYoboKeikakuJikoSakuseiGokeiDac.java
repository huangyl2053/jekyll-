/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokei;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokei.shikibetsuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokei.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokei.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokei.taishoYM;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity;
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
 * 日常生活予防給付計画自己作成合計のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiDac implements IModifiable<DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで日常生活予防給付計画自己作成合計を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 識別コード ShikibetsuNo
     * @param 対象年月 TaishoYM
     * @param 処理日時 ShoriTimestamp
     * @return DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity selectByKey(
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
                table(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shikibetsuNo, 識別コード),
                                eq(taishoYM, 対象年月),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity.class);
    }

    /**
     * 日常生活予防給付計画自己作成合計を全件返します。
     *
     * @return List<DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity>
     */
    @Transaction
    public List<DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokei.class).
                toList(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
