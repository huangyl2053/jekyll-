/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.view.DbV2502KaigoShotoku;
import static jp.co.ndensan.reams.db.dbz.entity.db.view.DbV2502KaigoShotoku.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.view.DbV2502KaigoShotoku.shoriYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.view.DbV2502KaigoShotoku.shotokuNendo;
import jp.co.ndensan.reams.db.dbz.entity.db.view.DbV2502KaigoShotokuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護所得のデータアクセスクラスです。
 */
public class DbV2502KaigoShotokuAliveDac implements ISaveable<DbV2502KaigoShotokuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * キーで介護所得Aliveを取得します。
     *
     * @param 識別コード 識別コード
     * @param 所得年度 所得年度
     * @param 所得基準年月日 所得基準年月日
     * @return DbV2502KaigoShotokuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV2502KaigoShotokuEntity selectByKey(ShikibetsuCode 識別コード, FlexibleYear 所得年度, YMDHMS 所得基準年月日) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(所得年度, UrSystemErrorMessages.値がnull.getReplacedMessage("所得年度"));
        requireNonNull(所得基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("所得基準年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV2502KaigoShotoku.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(shotokuNendo, 所得年度),
                                leq(shoriYMD, 所得基準年月日))).
                limit(1).
                toObject(DbV2502KaigoShotokuEntity.class);
    }

    /**
     * 介護所得Aliveを全件返します。
     *
     * @return DbV2002FukaEntityの{@code list}
     */
    @Transaction
    public List<DbV2502KaigoShotokuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV2502KaigoShotoku.class).
                toList(DbV2502KaigoShotokuEntity.class);
    }

    /**
     * DbV2502KaigoShotokuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbV2502KaigoShotokuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護所得Aliveエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
