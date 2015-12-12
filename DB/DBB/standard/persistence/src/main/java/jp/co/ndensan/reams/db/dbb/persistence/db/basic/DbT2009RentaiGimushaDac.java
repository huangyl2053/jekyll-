/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.rentainofugimusha.DbT2009RentaiGimusha;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.rentainofugimusha.DbT2009RentaiGimusha.*;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.rentainofugimusha.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 連帯納付義務者のデータアクセスクラスです。
 */
public class DbT2009RentaiGimushaDac implements ISaveable<DbT2009RentaiGimushaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで連帯納付義務者を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbT2009RentaiGimushaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2009RentaiGimushaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2009RentaiGimusha.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT2009RentaiGimushaEntity.class);
    }

    /**
     * 連帯納付義務者を全件返します。
     *
     * @return List<DbT2009RentaiGimushaEntity>
     */
    @Transaction
    public List<DbT2009RentaiGimushaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2009RentaiGimusha.class).
                toList(DbT2009RentaiGimushaEntity.class);
    }

    /**
     * DbT2009RentaiGimushaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2009RentaiGimushaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("連帯納付義務者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
