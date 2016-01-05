/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2011RankJoho;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2011RankJoho.fukaNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2011RankJoho.rankKubun;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ランク情報のデータアクセスクラスです。
 */
public class DbT2011RankJohoDac implements ISaveable<DbT2011RankJohoEntity> {

    @InjectSession
    private SqlSession session;

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
            RankKubun ランク区分) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));

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
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
