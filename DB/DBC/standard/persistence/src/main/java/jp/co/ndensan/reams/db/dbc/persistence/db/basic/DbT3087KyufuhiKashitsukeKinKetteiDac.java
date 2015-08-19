/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3087KyufuhiKashitsukeKinKettei;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3087KyufuhiKashitsukeKinKettei.*;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3087KyufuhiKashitsukeKinKetteiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付費貸付金決定のデータアクセスクラスです。
 */
public class DbT3087KyufuhiKashitsukeKinKetteiDac implements ISaveable<DbT3087KyufuhiKashitsukeKinKetteiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付費貸付金決定を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 借入申請年月日 KariireShinseiYMD
     * @param 履歴番号 RirekiNo
     * @return DbT3087KyufuhiKashitsukeKinKetteiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3087KyufuhiKashitsukeKinKetteiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 借入申請年月日,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(借入申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3087KyufuhiKashitsukeKinKettei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kariireShinseiYMD, 借入申請年月日),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3087KyufuhiKashitsukeKinKetteiEntity.class);
    }

    /**
     * 給付費貸付金決定を全件返します。
     *
     * @return List<DbT3087KyufuhiKashitsukeKinKetteiEntity>
     */
    @Transaction
    public List<DbT3087KyufuhiKashitsukeKinKetteiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3087KyufuhiKashitsukeKinKettei.class).
                toList(DbT3087KyufuhiKashitsukeKinKetteiEntity.class);
    }

    /**
     * DbT3087KyufuhiKashitsukeKinKetteiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3087KyufuhiKashitsukeKinKetteiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金決定エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
