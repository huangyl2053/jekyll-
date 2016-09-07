/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2011RankJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2011RankJoho.fukaNendo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2011RankJoho.rankKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2011RankJohoEntity;
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
 * ランク情報のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-022 wangkanglei
 */
public class DbT2011RankJohoDac implements ISaveable<DbT2011RankJohoEntity> {

    @InjectSession
    private SqlSession session;
    private static final RString 賦課年度KEY = new RString("賦課年度");
    private static final RString ランク区分KEY = new RString("ランク区分");
    private static final RString ランク情報エンティティKEY = new RString("ランク情報エンティティ");

    /**
     * 主キーでランク情報を取得します。
     *
     * @param 賦課年度 FukaNendo
     * @param ランク区分 RankKubun
     * @return DbT2011RankJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2011RankJohoEntity selectByKey(
            FlexibleYear 賦課年度,
            RString ランク区分) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(賦課年度KEY.toString()));
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage(ランク区分KEY.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2011RankJoho.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                eq(rankKubun, ランク区分))).
                toObject(DbT2011RankJohoEntity.class);
    }

    /**
     * ランク情報を全件返します。
     *
     * @return List<DbT2011RankJohoEntity>
     */
    @Transaction
    public List<DbT2011RankJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2011RankJoho.class).
                toList(DbT2011RankJohoEntity.class);
    }

    /**
     * DbT2011RankJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2011RankJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(ランク情報エンティティKEY.toString()));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 賦課年度でランク情報を取得します。
     *
     * @param 賦課年度 FukaNendo
     * @return List<DbT2011RankJohoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT2011RankJohoEntity> selectBy賦課年度(FlexibleYear 賦課年度) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(賦課年度KEY.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2011RankJoho.class).
                where(eq(fukaNendo, 賦課年度)).
                order(by(rankKubun, Order.ASC)).
                toList(DbT2011RankJohoEntity.class);
    }
}
