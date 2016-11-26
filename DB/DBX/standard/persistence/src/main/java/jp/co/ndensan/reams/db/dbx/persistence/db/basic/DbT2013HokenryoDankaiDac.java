/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankai;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankai.dankaiIndex;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankai.dankaiKubun;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankai.fukaNendo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankai.rankuKubun;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 保険料段階のデータアクセスクラスです。
 *
 * @reamsid_L DBB-9020-130 sunhaidi
 */
public class DbT2013HokenryoDankaiDac implements ISaveable<DbT2013HokenryoDankaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで保険料段階を取得します。
     *
     * @param 賦課年度 FukaNendo
     * @param 段階インデックス DankaiIndex
     * @param ランク区分 RankuKubun
     * @return DbT2013HokenryoDankaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2013HokenryoDankaiEntity selectByKey(
            FlexibleYear 賦課年度,
            RString 段階インデックス,
            RString ランク区分) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(段階インデックス, UrSystemErrorMessages.値がnull.getReplacedMessage("段階インデックス"));
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2013HokenryoDankai.class).
                where(and(
                        eq(fukaNendo, 賦課年度),
                        eq(dankaiIndex, 段階インデックス),
                        eq(rankuKubun, ランク区分))).
                toObject(DbT2013HokenryoDankaiEntity.class);
    }

    /**
     * 引数のキーに合致する保険料段階を返します。
     *
     * @param 賦課年度 FukaNendo
     * @param 段階区分 段階区分
     * @return DbT2013HokenryoDankaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2013HokenryoDankaiEntity selectBy段階区分(
            FlexibleYear 賦課年度,
            RString 段階区分) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(段階区分, UrSystemErrorMessages.値がnull.getReplacedMessage("段階区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT2013HokenryoDankaiEntity> list = accessor.select().
                table(DbT2013HokenryoDankai.class).
                where(and(
                        eq(fukaNendo, 賦課年度),
                        eq(dankaiKubun, 段階区分))).
                toList(DbT2013HokenryoDankaiEntity.class);

        return !list.isEmpty() ? list.get(0) : null;
    }

    /**
     * 保険料段階を全件返します。
     *
     * @return List<DbT2013HokenryoDankaiEntity>
     */
    @Transaction
    public List<DbT2013HokenryoDankaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2013HokenryoDankai.class).
                toList(DbT2013HokenryoDankaiEntity.class);
    }

    /**
     * 引数のキーに合致する保険料段階を返します。
     *
     * @param 賦課年度 FukaNendo
     * @param ランク区分 ランク区分
     * @return DbT2013HokenryoDankaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT2013HokenryoDankaiEntity> selectByランク区分(
            FlexibleYear 賦課年度,
            RString ランク区分) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2013HokenryoDankai.class).
                where(and(
                        eq(fukaNendo, 賦課年度),
                        eq(rankuKubun, ランク区分))).
                toList(DbT2013HokenryoDankaiEntity.class);
    }

    /**
     * DbT2013HokenryoDankaiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2013HokenryoDankaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料段階エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 保険料段階を全件返します。
     *
     * @param 賦課年度 FlexibleYear
     * @return List<DbT2013HokenryoDankaiEntity>
     */
    @Transaction
    public List<DbT2013HokenryoDankaiEntity> selectDankaiByFukaNendo(
            FlexibleYear 賦課年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2013HokenryoDankai.class).
                where((eq(fukaNendo, 賦課年度))).
                toList(DbT2013HokenryoDankaiEntity.class);
    }

    /**
     * 保険料段階を全件返します。
     *
     * @param 賦課年度 FlexibleYear
     * @return List<DbT2013HokenryoDankaiEntity>
     */
    @Transaction
    public List<DbT2013HokenryoDankaiEntity> get保険料ランク別制御情報(
            FlexibleYear 賦課年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2013HokenryoDankai.class).
                where((eq(fukaNendo, 賦課年度))).
                order(by(fukaNendo, Order.ASC),
                        by(rankuKubun, Order.ASC),
                        by(dankaiIndex, Order.ASC)).
                toList(DbT2013HokenryoDankaiEntity.class);
    }
}
