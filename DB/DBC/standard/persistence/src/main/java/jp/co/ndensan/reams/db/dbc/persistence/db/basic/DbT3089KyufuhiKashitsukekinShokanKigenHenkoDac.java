/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenko;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenko.*;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付費貸付金償還期限変更のデータアクセスクラスです。
 */
public class DbT3089KyufuhiKashitsukekinShokanKigenHenkoDac implements ISaveable<DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付費貸付金償還期限変更を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 貸付管理番号 KashitsukeKanriNo
     * @param 償還期限延長受付年月日 ShokanKigenEnchoUketsukeYMD
     * @param 履歴番号 RirekiNo
     * @return DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 貸付管理番号,
            FlexibleDate 償還期限延長受付年月日,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        requireNonNull(償還期限延長受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限延長受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3089KyufuhiKashitsukekinShokanKigenHenko.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kashitsukeKanriNo, 貸付管理番号),
                                eq(shokanKigenEnchoUketsukeYMD, 償還期限延長受付年月日),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity.class);
    }

    /**
     * 給付費貸付金償還期限変更を全件返します。
     *
     * @return List<DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity>
     */
    @Transaction
    public List<DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3089KyufuhiKashitsukekinShokanKigenHenko.class).
                toList(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity.class);
    }

    /**
     * DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金償還期限変更エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
