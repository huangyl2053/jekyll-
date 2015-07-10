/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisai;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisai.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisai.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisai.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisai.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisai.taishoYM;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity;
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
 * 日常生活予防給付計画自己作成明細のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiDac implements IModifiable<DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで日常生活予防給付計画自己作成明細を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 対象年月 TaishoYM
     * @param 処理日時 ShoriTimestamp
     * @return DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity selectByKey(
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
                table(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisai.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shikibetsuCode, 識別コード),
                                eq(taishoYM, 対象年月),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity.class);
    }

    /**
     * 日常生活予防給付計画自己作成明細を全件返します。
     *
     * @return List<DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity>
     */
    @Transaction
    public List<DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisai.class).
                toList(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
