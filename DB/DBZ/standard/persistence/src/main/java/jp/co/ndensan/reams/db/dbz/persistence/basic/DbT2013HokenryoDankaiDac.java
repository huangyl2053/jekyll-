/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.DankaiIndex;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2013HokenryoDankai;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2013HokenryoDankai.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;

/**
 * 保険料段階のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class DbT2013HokenryoDankaiDac implements IModifiable<DbT2013HokenryoDankaiEntity> {

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
            DankaiIndex 段階インデックス,
            RankKubun ランク区分) throws NullPointerException {
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

    @Transaction
    @Override
    public int insert(DbT2013HokenryoDankaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT2013HokenryoDankaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT2013HokenryoDankaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    /**
     * 物理削除を行います。
     *
     * @param entity DbT2013HokenryoDankaiEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT2013HokenryoDankaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
