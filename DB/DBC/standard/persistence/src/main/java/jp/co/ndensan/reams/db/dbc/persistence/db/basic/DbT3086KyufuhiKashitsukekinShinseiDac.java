/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3086KyufuhiKashitsukekinShinsei;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3086KyufuhiKashitsukekinShinsei.*;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3086KyufuhiKashitsukekinShinseiEntity;
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
 * 給付費貸付金申請のデータアクセスクラスです。
 */
public class DbT3086KyufuhiKashitsukekinShinseiDac implements ISaveable<DbT3086KyufuhiKashitsukekinShinseiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付費貸付金申請を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 借入申請年月日 KariireShinseiYMD
     * @param 履歴番号 RirekiNo
     * @return DbT3086KyufuhiKashitsukekinShinseiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3086KyufuhiKashitsukekinShinseiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 借入申請年月日,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(借入申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3086KyufuhiKashitsukekinShinsei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kariireShinseiYMD, 借入申請年月日),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3086KyufuhiKashitsukekinShinseiEntity.class);
    }

    /**
     * 給付費貸付金申請を全件返します。
     *
     * @return List<DbT3086KyufuhiKashitsukekinShinseiEntity>
     */
    @Transaction
    public List<DbT3086KyufuhiKashitsukekinShinseiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3086KyufuhiKashitsukekinShinsei.class).
                toList(DbT3086KyufuhiKashitsukekinShinseiEntity.class);
    }

    /**
     * DbT3086KyufuhiKashitsukekinShinseiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3086KyufuhiKashitsukekinShinseiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金申請エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
