
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3067KyufuhiTuchiHosei;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3067KyufuhiTuchiHosei.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3067KyufuhiTuchiHosei.jigyoshoNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3067KyufuhiTuchiHosei.serviceShuruiCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3067KyufuhiTuchiHosei.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3067KyufuhiTuchiHosei.shokisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3067KyufuhiTuchiHosei.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3067KyufuhiTuchiHoseiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付費通知補正のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3067KyufuhiTuchiHoseiDac implements IModifiable<DbT3067KyufuhiTuchiHoseiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付費通知補正を取得します。
     *
     * @param 証記載保険者番号 ShokisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 事業所番号 JigyoshoNo
     * @param サービス種類コード ServiceShuruiCode
     * @param 処理日時 ShoriTimestamp
     * @return DbT3067KyufuhiTuchiHoseiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3067KyufuhiTuchiHoseiEntity selectByKey(
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            ServiceShuruiCode サービス種類コード,
            RDateTime 処理日時) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3067KyufuhiTuchiHosei.class).
                where(and(
                                eq(shokisaiHokenshaNo, 証記載保険者番号),
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(jigyoshoNo, 事業所番号),
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3067KyufuhiTuchiHoseiEntity.class);
    }

    /**
     * 給付費通知補正を全件返します。
     *
     * @return List<DbT3067KyufuhiTuchiHoseiEntity>
     */
    @Transaction
    public List<DbT3067KyufuhiTuchiHoseiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3067KyufuhiTuchiHosei.class).
                toList(DbT3067KyufuhiTuchiHoseiEntity.class);
    }

    /**
     * 給付費通知補正を追加します。
     *
     * @param entity 給付費通知補正
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3067KyufuhiTuchiHoseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 給付費通知補正をDBに更新します。
     *
     * @param entity 給付費通知補正
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3067KyufuhiTuchiHoseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 給付費通知補正をDBから削除します。（論理削除）
     *
     * @param entity 給付費通知補正
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3067KyufuhiTuchiHoseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 給付費通知補正を物理削除。
     *
     * @param entity 給付費通知補正
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3067KyufuhiTuchiHoseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
