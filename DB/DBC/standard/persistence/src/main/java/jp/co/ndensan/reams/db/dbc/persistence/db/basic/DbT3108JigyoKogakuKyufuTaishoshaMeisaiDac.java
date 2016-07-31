/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisai;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisai.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisai.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisai.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisai.serviceShuruiCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisai.serviceTeikyoYM;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業高額介護サービス費給付対象者明細のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 quxiaodong
 */
public class DbT3108JigyoKogakuKyufuTaishoshaMeisaiDac implements ISaveable<DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで事業高額介護サービス費給付対象者明細を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 事業者番号 JigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @param 履歴番号 RirekiNo
     * @return DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業者番号,
            ServiceShuruiCode サービス種類コード,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3108JigyoKogakuKyufuTaishoshaMeisai.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(jigyoshaNo, 事業者番号),
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity.class);
    }

    /**
     * 事業高額介護サービス費給付対象者明細を全件返します。
     *
     * @return List<DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity>
     */
    @Transaction
    public List<DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3108JigyoKogakuKyufuTaishoshaMeisai.class).
                toList(DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity.class);
    }

    /**
     * 事業高額介護サービス費給付対象者明細を全件返します
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @return DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity> selectAllByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3108JigyoKogakuKyufuTaishoshaMeisai.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月))).
                toList(DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity.class);
    }

    /**
     * DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額介護サービス費給付対象者明細エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntityEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int delete(DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額介護サービス費給付対象者明細エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
