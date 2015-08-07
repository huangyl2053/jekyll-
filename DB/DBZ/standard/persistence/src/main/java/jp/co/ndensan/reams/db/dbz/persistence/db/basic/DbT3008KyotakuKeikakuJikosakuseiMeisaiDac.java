/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3008KyotakuKeikakuJikosakuseiMeisai;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3008KyotakuKeikakuJikosakuseiMeisai.*;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画自己作成明細のデータアクセスクラスです。
 */
public class DbT3008KyotakuKeikakuJikosakuseiMeisaiDac implements ISaveable<DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで居宅給付計画自己作成明細を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 TaishoYM
     * @param 履歴番号 RirekiNo
     * @param 居宅サービス区分 KyotakuServiceKubun
     * @param サービス提供事業者番号 ServiceTeikyoJigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @param サービス項目コード ServiceKomokuCode
     * @return DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号,
            RString 居宅サービス区分,
            JigyoshaNo サービス提供事業者番号,
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(居宅サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分"));
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3008KyotakuKeikakuJikosakuseiMeisai.class).
                where(and(
                eq(hihokenshaNo, 被保険者番号),
                eq(taishoYM, 対象年月),
                eq(rirekiNo, 履歴番号),
                eq(kyotakuServiceKubun, 居宅サービス区分),
                eq(serviceTeikyoJigyoshaNo, サービス提供事業者番号),
                eq(serviceShuruiCode, サービス種類コード),
                eq(serviceKomokuCode, サービス項目コード))).
                toObject(DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity.class);
    }

    /**
     * 居宅給付計画自己作成明細を全件返します。
     *
     * @return List<DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity>
     */
    @Transaction
    public List<DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3008KyotakuKeikakuJikosakuseiMeisai.class).
                toList(DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity.class);
    }

    /**
     * DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成明細エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
