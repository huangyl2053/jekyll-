/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3092KyufuhiKashitsukeKinChoshu;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3092KyufuhiKashitsukeKinChoshu.*;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3092KyufuhiKashitsukeKinChoshuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付費貸付金徴収のデータアクセスクラスです。
 */
public class DbT3092KyufuhiKashitsukeKinChoshuDac implements ISaveable<DbT3092KyufuhiKashitsukeKinChoshuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付費貸付金徴収を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 貸付管理番号 KashitsukeKanriNo
     * @param 履歴番号 RirekiNo
     * @return DbT3092KyufuhiKashitsukeKinChoshuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3092KyufuhiKashitsukeKinChoshuEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 貸付管理番号,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3092KyufuhiKashitsukeKinChoshu.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kashitsukeKanriNo, 貸付管理番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3092KyufuhiKashitsukeKinChoshuEntity.class);
    }

    /**
     * 給付費貸付金徴収を全件返します。
     *
     * @return List<DbT3092KyufuhiKashitsukeKinChoshuEntity>
     */
    @Transaction
    public List<DbT3092KyufuhiKashitsukeKinChoshuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3092KyufuhiKashitsukeKinChoshu.class).
                toList(DbT3092KyufuhiKashitsukeKinChoshuEntity.class);
    }

    /**
     * DbT3092KyufuhiKashitsukeKinChoshuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3092KyufuhiKashitsukeKinChoshuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金徴収エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
