/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaisha;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaisha.isDeleted;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaisha.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaisha.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 資格取得除外者のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-021 zhangzhiming
 */
public class DbT1009ShikakuShutokuJogaishaDac implements ISaveable<DbT1009ShikakuShutokuJogaishaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで資格取得除外者を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return DbT1009ShikakuShutokuJogaishaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1009ShikakuShutokuJogaishaEntity selectByKey(
            ShikibetsuCode 識別コード,
            int 履歴番号) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1009ShikakuShutokuJogaisha.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT1009ShikakuShutokuJogaishaEntity.class);
    }

    /**
     * 識別コードで資格取得除外者を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return List<DbT1009ShikakuShutokuJogaishaEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1009ShikakuShutokuJogaishaEntity> selectBy識別コード(ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1009ShikakuShutokuJogaisha.class).
                where(eq(shikibetsuCode, 識別コード)).
                toList(DbT1009ShikakuShutokuJogaishaEntity.class);
    }

    /**
     * 資格取得除外者を全件返します。
     *
     * @return List<DbT1009ShikakuShutokuJogaishaEntity>
     */
    @Transaction
    public List<DbT1009ShikakuShutokuJogaishaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1009ShikakuShutokuJogaisha.class).
                toList(DbT1009ShikakuShutokuJogaishaEntity.class);
    }

    /**
     * 履歴番号を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return DbT1009ShikakuShutokuJogaishaEntity
     */
    @Transaction
    public DbT1009ShikakuShutokuJogaishaEntity select履歴番号(ShikibetsuCode 識別コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1009ShikakuShutokuJogaisha.class).
                where(
                        eq(shikibetsuCode, 識別コード)).
                order(by(rirekiNo, Order.DESC)).
                limit(1).
                toObject(DbT1009ShikakuShutokuJogaishaEntity.class);
    }

    /**
     * DbT1009ShikakuShutokuJogaishaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT1009ShikakuShutokuJogaishaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得除外者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 資格取得除外者一覧を全件返します。
     *
     * @return List<DbT1009ShikakuShutokuJogaishaEntity>
     */
    @Transaction
    public List<DbT1009ShikakuShutokuJogaishaEntity> select一覧() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1009ShikakuShutokuJogaisha.class).
                where(
                        eq(isDeleted, false)).
                order(by(rirekiNo, Order.ASC)).
                toList(DbT1009ShikakuShutokuJogaishaEntity.class);
    }
}
