/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2011RankJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2011RankJoho.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;

/**
 * ランク情報のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class DbT2011RankJohoDac implements IModifiable<DbT2011RankJohoEntity> {

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
            RString ランク区分) throws NullPointerException {
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

    @Transaction
    @Override
    public int insert(DbT2011RankJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT2011RankJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT2011RankJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行います。
     *
     * @param entity DbT2011RankJohoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT2011RankJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
