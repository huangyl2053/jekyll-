/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3088KyufuhiKashitsukekinShakuyoshoJuri;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3088KyufuhiKashitsukekinShakuyoshoJuri.*;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity;
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
 * 給付費貸付金借用書受理のデータアクセスクラスです。
 */
public class DbT3088KyufuhiKashitsukekinShakuyoshoJuriDac implements ISaveable<DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付費貸付金借用書受理を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 借入申請年月日 KariireShinseiYMD
     * @param 履歴番号 RirekiNo
     * @return DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 借入申請年月日,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(借入申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3088KyufuhiKashitsukekinShakuyoshoJuri.class).
                where(and(
                eq(hihokenshaNo, 被保険者番号),
                eq(kariireShinseiYMD, 借入申請年月日),
                eq(rirekiNo, 履歴番号))).
                toObject(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity.class);
    }

    /**
     * 給付費貸付金借用書受理を全件返します。
     *
     * @return List<DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity>
     */
    @Transaction
    public List<DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3088KyufuhiKashitsukekinShakuyoshoJuri.class).
                toList(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity.class);
    }

    /**
     * DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金借用書受理エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
