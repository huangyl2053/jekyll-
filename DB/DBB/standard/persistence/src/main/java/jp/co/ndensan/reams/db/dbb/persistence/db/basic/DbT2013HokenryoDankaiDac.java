/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2013HokenryoDankai;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2013HokenryoDankai.dankaiIndex;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2013HokenryoDankai.fukaNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2013HokenryoDankai.rankuKubun;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.DankaiIndex;
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
 * 保険料段階のデータアクセスクラスです。
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
}
