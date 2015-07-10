/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2012HokenryoRank;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2012HokenryoRank.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;

/**
 * 保険料ランクのデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class DbT2012HokenryoRankDac implements IModifiable<DbT2012HokenryoRankEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで保険料ランクを取得します。
     *
     * @param 賦課年度 FukaNendo
     * @param 市町村コード ShichosonCode
     * @return DbT2012HokenryoRankEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2012HokenryoRankEntity selectByKey(
            FukaNendo 賦課年度,
            LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2012HokenryoRank.class).
                where(and(
                                eq(fukaNendo, 賦課年度.value()),
                                eq(shichosonCode, 市町村コード))).
                toObject(DbT2012HokenryoRankEntity.class);
    }

    /**
     * 保険料ランクを全件返します。
     *
     * @return List<DbT2012HokenryoRankEntity>
     */
    @Transaction
    public List<DbT2012HokenryoRankEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2012HokenryoRank.class).
                toList(DbT2012HokenryoRankEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT2012HokenryoRankEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT2012HokenryoRankEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT2012HokenryoRankEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    /**
     * 物理削除を行います。
     *
     * @param entity DbT2012HokenryoRankEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT2012HokenryoRankEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
