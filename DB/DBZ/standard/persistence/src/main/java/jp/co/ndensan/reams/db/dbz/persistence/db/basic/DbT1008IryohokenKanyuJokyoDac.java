/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyo.iryoHokenKanyuYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyo.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyo.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyo.isDeleted;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険医療保険加入状況のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-020 suguangjun
 */
public class DbT1008IryohokenKanyuJokyoDac implements ISaveable<DbT1008IryohokenKanyuJokyoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護保険医療保険加入状況を取得します。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     * @return DbT1008IryohokenKanyuJokyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1008IryohokenKanyuJokyoEntity selectByKey(
            ShikibetsuCode 識別コード,
            int 履歴番号) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1008IryohokenKanyuJokyo.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT1008IryohokenKanyuJokyoEntity.class);
    }

    /**
     * 介護保険医療保険加入状況を全件返します。
     *
     * @return DbT1008IryohokenKanyuJokyoEntityの{@code list}
     */
    @Transaction
    public List<DbT1008IryohokenKanyuJokyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1008IryohokenKanyuJokyo.class).
                toList(DbT1008IryohokenKanyuJokyoEntity.class);
    }

    /**
     * DbT1008IryohokenKanyuJokyoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT1008IryohokenKanyuJokyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険医療保険加入状況エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT1008IryohokenKanyuJokyoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int saveOrDeletePhysicalBy(DbT1008IryohokenKanyuJokyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険医療保険加入状況エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 識別コードで介護保険医療保険加入状況を取得します。
     *
     * @param 識別コード 識別コード
     * @return DbT1008IryohokenKanyuJokyoEntity 介護保険医療保険加入状況情報
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1008IryohokenKanyuJokyoEntity selectByShikibetsuCode(
            ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1008IryohokenKanyuJokyo.class).
                where(eq(shikibetsuCode, 識別コード)).order(by(DbT1008IryohokenKanyuJokyo.iryoHokenKanyuYMD, Order.DESC))
                .limit(1).toObject(DbT1008IryohokenKanyuJokyoEntity.class);
    }

    /**
     * 介護保険医療保険加入状況を返します。
     *
     * @param 識別コード 識別コード
     * @return List<DbT1008IryohokenKanyuJokyoEntity>
     */
    public List<DbT1008IryohokenKanyuJokyoEntity> selectByCode(ShikibetsuCode 識別コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1008IryohokenKanyuJokyo.class).where(eq(shikibetsuCode, 識別コード))
                .order(new OrderBy(iryoHokenKanyuYMD, Order.DESC, NullsOrder.LAST)).
                toList(DbT1008IryohokenKanyuJokyoEntity.class);
    }

    /**
     * 識別コードで介護保険医療保険加入状況を取得します。
     *
     * @param 識別コード 識別コード
     * @return DbT1008IryohokenKanyuJokyoEntity 介護保険医療保険加入状況情報
     */
    @Transaction
    public DbT1008IryohokenKanyuJokyoEntity select医療保険加入状況ByShikibetsuCode(
            ShikibetsuCode 識別コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1008IryohokenKanyuJokyo.class).
                where(eq(shikibetsuCode, 識別コード)).
                order(by(rirekiNo, Order.DESC))
                .limit(1).toObject(DbT1008IryohokenKanyuJokyoEntity.class);
    }
    
    /**
     * 識別コードで最新介護保険医療保険加入状況を取得します。
     * 
     * @param 識別コード
     * @return DbT1008IryohokenKanyuJokyoEntity 介護保険医療保険加入状況情報
     */
    @Transaction
    public DbT1008IryohokenKanyuJokyoEntity select最新医療保険加入状況論理非削除ByShikibetsuCode(
            ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1008IryohokenKanyuJokyo.class).
                where(and(
                        eq(shikibetsuCode, 識別コード),
                        eq(isDeleted, false))).
                order(by(rirekiNo, Order.DESC)).
                limit(1).toObject(DbT1008IryohokenKanyuJokyoEntity.class);
    }

}
