/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3012YoboKeikakuJikoSakuseiGokei;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3012YoboKeikakuJikoSakuseiGokei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3012YoboKeikakuJikoSakuseiGokei.kyotakuServiceKubun;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3012YoboKeikakuJikoSakuseiGokei.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3012YoboKeikakuJikoSakuseiGokei.serviceShuruiCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3012YoboKeikakuJikoSakuseiGokei.serviceTeikyoJigyoshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3012YoboKeikakuJikoSakuseiGokei.taishoYM;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3012YoboKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 予防給付計画自己作成合計のデータアクセスクラスです。
 */
public class DbT3012YoboKeikakuJikoSakuseiGokeiDac implements ISaveable<DbT3012YoboKeikakuJikoSakuseiGokeiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで予防給付計画自己作成合計を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 TaishoYM
     * @param 履歴番号 RirekiNo
     * @param 居宅サービス区分 KyotakuServiceKubun
     * @param サービス提供事業者番号 ServiceTeikyoJigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @return DbT3012YoboKeikakuJikoSakuseiGokeiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3012YoboKeikakuJikoSakuseiGokeiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号,
            RString 居宅サービス区分,
            JigyoshaNo サービス提供事業者番号,
            ServiceShuruiCode サービス種類コード) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(居宅サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分"));
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3012YoboKeikakuJikoSakuseiGokei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoYM, 対象年月),
                                eq(rirekiNo, 履歴番号),
                                eq(kyotakuServiceKubun, 居宅サービス区分),
                                eq(serviceTeikyoJigyoshaNo, サービス提供事業者番号),
                                eq(serviceShuruiCode, サービス種類コード))).
                toObject(DbT3012YoboKeikakuJikoSakuseiGokeiEntity.class);
    }

    /**
     * 予防給付計画自己作成合計を全件返します。
     *
     * @return List<DbT3012YoboKeikakuJikoSakuseiGokeiEntity>
     */
    @Transaction
    public List<DbT3012YoboKeikakuJikoSakuseiGokeiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3012YoboKeikakuJikoSakuseiGokei.class).
                toList(DbT3012YoboKeikakuJikoSakuseiGokeiEntity.class);
    }

    /**
     * DbT3012YoboKeikakuJikoSakuseiGokeiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3012YoboKeikakuJikoSakuseiGokeiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("予防給付計画自己作成合計エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
