/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanri;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanri.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanri.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanri.shotokuNendo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.in;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護所得のデータアクセスクラスです。
 */
public class DbT2008ShotokuKanriDac implements ISaveable<DbT2008ShotokuKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護所得を取得します。
     *
     * @param 所得年度 ShotokuNendo
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return DbT2008ShotokuKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2008ShotokuKanriEntity selectByKey(
            FlexibleYear 所得年度,
            ShikibetsuCode 識別コード,
            int 履歴番号) throws NullPointerException {
        requireNonNull(所得年度, UrSystemErrorMessages.値がnull.getReplacedMessage("所得年度"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2008ShotokuKanri.class).
                where(and(
                                eq(shotokuNendo, 所得年度),
                                eq(shikibetsuCode, 識別コード),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT2008ShotokuKanriEntity.class);
    }

    /**
     * 介護所得を全件返します。
     *
     * @return List<DbT2008ShotokuKanriEntity>
     */
    @Transaction
    public List<DbT2008ShotokuKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2008ShotokuKanri.class).
                toList(DbT2008ShotokuKanriEntity.class);
    }

    /**
     * 介護所得管理を検索します。
     *
     * @param 所得年度 ShotokuNendo
     * @param 識別コード ShikibetsuCode
     * @return DbT2008ShotokuKanriEntity
     */
    @Transaction
    public DbT2008ShotokuKanriEntity select介護所得管理(FlexibleYear 所得年度, ShikibetsuCode 識別コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT2008ShotokuKanri.class).
                where(and(
                                eq(shotokuNendo, 所得年度),
                                eq(shikibetsuCode, 識別コード))).
                toObject(DbT2008ShotokuKanriEntity.class);
    }

    /**
     * 介護所得管理制限を検索します。
     *
     * @param 所得年度 ShotokuNendo
     * @param 識別コード ShikibetsuCode
     * @return DbT2008ShotokuKanriEntity
     */
    @Transaction
    public DbT2008ShotokuKanriEntity select介護所得管理制限(FlexibleYear 所得年度, ShikibetsuCode 識別コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT2008ShotokuKanri.class).
                where(and(
                                eq(shotokuNendo, 所得年度),
                                eq(shikibetsuCode, 識別コード))).
                order(by(DbT2008ShotokuKanri.rirekiNo, Order.DESC)).limit(1).
                toObject(DbT2008ShotokuKanriEntity.class);
    }

    /**
     * DbT2008ShotokuKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2008ShotokuKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護所得エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 介護所得を全件返します。
     *
     * @param 所得年度 FlexibleYear
     * @param 識別コードList List<ShikibetsuCode>
     * @return List<DbT2008ShotokuKanriEntity>
     */
    @Transaction
    public List<DbT2008ShotokuKanriEntity> selectShikibetsuCode(FlexibleYear 所得年度, List<ShikibetsuCode> 識別コードList) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2008ShotokuKanri.class).
                where(and(
                                eq(shotokuNendo, 所得年度),
                                in(shikibetsuCode, 識別コードList))).
                toList(DbT2008ShotokuKanriEntity.class);
    }

    /**
     * selectBySomeKey
     *
     * @param 所得年度 FlexibleYear
     * @param 識別コード ShikibetsuCode
     * @return DbT2008ShotokuKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2008ShotokuKanriEntity selectBySomeKey(
            FlexibleYear 所得年度,
            ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(所得年度, UrSystemErrorMessages.値がnull.getReplacedMessage("所得年度"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(rirekiNo)).
                table(DbT2008ShotokuKanri.class).
                where(and(
                                eq(shotokuNendo, 所得年度),
                                eq(shikibetsuCode, 識別コード))).
                toObject(DbT2008ShotokuKanriEntity.class);
    }
}
