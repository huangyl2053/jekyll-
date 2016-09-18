/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7902FukaSearch;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7902FukaSearch.choteiNendo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7902FukaSearch.fukaNendo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7902FukaSearch.tsuchishoNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7902FukaSearch.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7902FukaSearchEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 賦課検索Aliveのデータアクセスクラスです。
 */
public class DbV7902FukaSearchAliveDac implements ISaveable<DbV7902FukaSearchEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで賦課検索Aliveを取得します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return DbV7902FukaSearchEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV7902FukaSearchEntity selectByKey(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号) throws NullPointerException {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV7902FukaSearch.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(fukaNendo, 賦課年度),
                                eq(tsuchishoNo, 通知書番号))).
                toObject(DbV7902FukaSearchEntity.class);
    }

    /**
     * 識別コードで検索した結果を賦課年度順にソートし、その1件目を取得します。
     *
     * @param 識別コード 識別コード
     * @return DbV7902FukaSearchEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV7902FukaSearchEntity selectBy識別コードOrderBy賦課年度(ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV7902FukaSearch.class).
                where(eq(shikibetsuCode, 識別コード)).
                order(new OrderBy(fukaNendo, Order.DESC, NullsOrder.LAST)).
                limit(1).
                toObject(DbV7902FukaSearchEntity.class);
    }

    /**
     * 賦課検索Aliveを全件返します。
     *
     * @return DbV7902FukaSearchEntityの{@code list}
     */
    @Transaction
    public List<DbV7902FukaSearchEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV7902FukaSearch.class).
                toList(DbV7902FukaSearchEntity.class);
    }

    /**
     * DbV7902FukaSearchEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbV7902FukaSearchEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課検索Aliveエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
