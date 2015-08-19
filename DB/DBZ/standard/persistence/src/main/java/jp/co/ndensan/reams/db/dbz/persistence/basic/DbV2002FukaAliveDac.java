/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV2002Fuka;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV2002Fuka.choteiNendo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV2002Fuka.fukaNendo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV2002Fuka.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV2002Fuka.tsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV2002FukaEntity;
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
 * 賦課Aliveのデータアクセスクラスです。
 */
public class DbV2002FukaAliveDac implements ISaveable<DbV2002FukaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで賦課Aliveを取得します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @return DbV2002FukaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV2002FukaEntity selectByKey(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV2002Fuka.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(fukaNendo, 賦課年度),
                                eq(tsuchishoNo, 通知書番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbV2002FukaEntity.class);
    }

    /**
     * 賦課Aliveを全件返します。
     *
     * @return DbV2002FukaEntityの{@code list}
     */
    @Transaction
    public List<DbV2002FukaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV2002Fuka.class).
                toList(DbV2002FukaEntity.class);
    }

    /**
     * DbV2002FukaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbV2002FukaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課Aliveエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
