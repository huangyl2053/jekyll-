/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3098TandokuJoseikinKyufuShinsei;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3098TandokuJoseikinKyufuShinsei.*;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3098TandokuJoseikinKyufuShinseiEntity;
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
 * 市町村単独助成金給付申請のデータアクセスクラスです。
 */
public class DbT3098TandokuJoseikinKyufuShinseiDac implements ISaveable<DbT3098TandokuJoseikinKyufuShinseiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで市町村単独助成金給付申請を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 受付年月日 UketsukeYMD
     * @param 履歴番号 RirekiNo
     * @return DbT3098TandokuJoseikinKyufuShinseiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3098TandokuJoseikinKyufuShinseiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3098TandokuJoseikinKyufuShinsei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(uketsukeYMD, 受付年月日),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3098TandokuJoseikinKyufuShinseiEntity.class);
    }

    /**
     * 市町村単独助成金給付申請を全件返します。
     *
     * @return List<DbT3098TandokuJoseikinKyufuShinseiEntity>
     */
    @Transaction
    public List<DbT3098TandokuJoseikinKyufuShinseiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3098TandokuJoseikinKyufuShinsei.class).
                toList(DbT3098TandokuJoseikinKyufuShinseiEntity.class);
    }

    /**
     * DbT3098TandokuJoseikinKyufuShinseiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3098TandokuJoseikinKyufuShinseiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成金給付申請エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
