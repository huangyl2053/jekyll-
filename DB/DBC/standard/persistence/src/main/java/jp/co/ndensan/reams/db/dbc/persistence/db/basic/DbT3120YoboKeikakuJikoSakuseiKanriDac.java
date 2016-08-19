/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3119KyotakuKeikakuJikosakuseiKanri;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3119KyotakuKeikakuJikosakuseiKanri.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3119KyotakuKeikakuJikosakuseiKanri.kyotakuServiceKubun;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3119KyotakuKeikakuJikosakuseiKanri.meisaiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3119KyotakuKeikakuJikosakuseiKanri.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3119KyotakuKeikakuJikosakuseiKanri.riyoYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3119KyotakuKeikakuJikosakuseiKanri.taishoYM;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3120YoboKeikakuJikoSakuseiKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 予防給付計画自己作成管理のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 cuilin
 */
public class DbT3120YoboKeikakuJikoSakuseiKanriDac implements ISaveable<DbT3120YoboKeikakuJikoSakuseiKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで予防給付計画自己作成管理を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @param 利用年月 利用年月
     * @param 居宅サービス区分 居宅サービス区分
     * @param 明細番号 明細番号
     * @return DbT3120YoboKeikakuJikoSakuseiKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3120YoboKeikakuJikoSakuseiKanriEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号,
            FlexibleYearMonth 利用年月,
            RString 居宅サービス区分,
            int 明細番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(利用年月, UrSystemErrorMessages.値がnull.getReplacedMessage("利用年月"));
        requireNonNull(居宅サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3119KyotakuKeikakuJikosakuseiKanri.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoYM, 対象年月),
                                eq(rirekiNo, 履歴番号),
                                eq(riyoYM, 利用年月),
                                eq(kyotakuServiceKubun, 居宅サービス区分),
                                eq(meisaiNo, 明細番号))).
                toObject(DbT3120YoboKeikakuJikoSakuseiKanriEntity.class);
    }

    /**
     * 予防給付計画自己作成管理を全件返します。
     *
     * @return List<DbT3120YoboKeikakuJikoSakuseiKanriEntity>
     */
    @Transaction
    public List<DbT3120YoboKeikakuJikoSakuseiKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3119KyotakuKeikakuJikosakuseiKanri.class).
                toList(DbT3120YoboKeikakuJikoSakuseiKanriEntity.class);
    }

    /**
     * DbT3120YoboKeikakuJikoSakuseiKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3120YoboKeikakuJikoSakuseiKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("予防給付計画自己作成管理エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityを削除します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int delete(DbT3120YoboKeikakuJikoSakuseiKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("予防給付計画自己作成管理エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
