/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3054KogakuKyufuTaishoshaMeisai;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3054KogakuKyufuTaishoshaMeisai.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3054KogakuKyufuTaishoshaMeisai.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3054KogakuKyufuTaishoshaMeisai.serviceShuruiCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3054KogakuKyufuTaishoshaMeisai.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3054KogakuKyufuTaishoshaMeisai.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額介護サービス費給付対象者明細のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3054KogakuKyufuTaishoshaMeisaiDac implements IModifiable<DbT3054KogakuKyufuTaishoshaMeisaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額介護サービス費給付対象者明細を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 事業者番号 JigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @param 処理日時 ShoriTimestamp
     * @return DbT3054KogakuKyufuTaishoshaMeisaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3054KogakuKyufuTaishoshaMeisaiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業者番号,
            ServiceShuruiCode サービス種類コード,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3054KogakuKyufuTaishoshaMeisai.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(jigyoshaNo, 事業者番号),
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3054KogakuKyufuTaishoshaMeisaiEntity.class);
    }

    /**
     * 高額介護サービス費給付対象者明細を全件返します。
     *
     * @return List<DbT3054KogakuKyufuTaishoshaMeisaiEntity>
     */
    @Transaction
    public List<DbT3054KogakuKyufuTaishoshaMeisaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3054KogakuKyufuTaishoshaMeisai.class).
                toList(DbT3054KogakuKyufuTaishoshaMeisaiEntity.class);
    }

    /**
     * 高額介護サービス費給付対象者明細を追加します。
     *
     * @param entity 高額介護サービス費給付対象者明細
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3054KogakuKyufuTaishoshaMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 高額介護サービス費給付対象者明細をDBに更新します。
     *
     * @param entity 高額介護サービス費給付対象者明細
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3054KogakuKyufuTaishoshaMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 高額介護サービス費給付対象者明細をDBから削除します。（論理削除）
     *
     * @param entity 高額介護サービス費給付対象者明細
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3054KogakuKyufuTaishoshaMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 高額介護サービス費給付対象者明細を物理削除。
     *
     * @param entity 高額介護サービス費給付対象者明細
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3054KogakuKyufuTaishoshaMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
