/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaisha;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaisha.edaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaisha.idoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaisha.kaijoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaisha.logicalDeletedFlag;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaisha.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaisha.tekiyoYMD;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 適用除外者のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-021 zhangzhiming
 */
public class DbT1002TekiyoJogaishaDac implements ISaveable<DbT1002TekiyoJogaishaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで適用除外者を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 異動日 IdoYMD
     * @param 枝番 EdaNo
     * @return DbT1002TekiyoJogaishaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1002TekiyoJogaishaEntity selectByKey(
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1002TekiyoJogaisha.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(idoYMD, 異動日),
                                eq(edaNo, 枝番))).
                toObject(DbT1002TekiyoJogaishaEntity.class);
    }

    /**
     * 適用除外者を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 年齢到達日 年齢到達日
     * @return DbT1002TekiyoJogaishaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1002TekiyoJogaishaEntity> select適用除外者(
            ShikibetsuCode 識別コード,
            FlexibleDate 年齢到達日) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(年齢到達日, UrSystemErrorMessages.値がnull.getReplacedMessage("年齢到達日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        boolean 論理削除フラグ = false;

        return accessor.select().
                table(DbT1002TekiyoJogaisha.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                (or(
                                        and(leq(tekiyoYMD, 年齢到達日), leq(年齢到達日, kaijoYMD)),
                                        and(leq(tekiyoYMD, 年齢到達日), leq(kaijoYMD, null)))),
                                eq(logicalDeletedFlag, 論理削除フラグ))).
                toList(DbT1002TekiyoJogaishaEntity.class);
    }

    /**
     * 適用除外者で最大の異動日のレコード中で最大の枝番を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return DbT1002TekiyoJogaishaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1002TekiyoJogaishaEntity selectMaxByKey(
            ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1002TekiyoJogaisha.class).
                where(
                        eq(shikibetsuCode, 識別コード)).
                order(by(idoYMD, Order.DESC), by(edaNo, Order.DESC)).
                limit(1).
                toObject(DbT1002TekiyoJogaishaEntity.class);
    }

    /**
     * 適用除外者を全件返します。
     *
     * @return List<DbT1002TekiyoJogaishaEntity>
     */
    @Transaction
    public List<DbT1002TekiyoJogaishaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1002TekiyoJogaisha.class).
                toList(DbT1002TekiyoJogaishaEntity.class);
    }

    /**
     * DbT1002TekiyoJogaishaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT1002TekiyoJogaishaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 適用除外者を全件返します。
     *
     * @param 適用年月日 適用年月日
     * @param 識別コード 識別コード
     * @return List<DbT1002TekiyoJogaishaEntity>
     */
    @Transaction
    public List<DbT1002TekiyoJogaishaEntity> selectBy識別コードAnd適用年月日(FlexibleDate 適用年月日, ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1002TekiyoJogaisha.class).
                where(
                        and(eq(shikibetsuCode, 識別コード),
                                eq(tekiyoYMD, 適用年月日))).
                toList(DbT1002TekiyoJogaishaEntity.class);
    }
}
