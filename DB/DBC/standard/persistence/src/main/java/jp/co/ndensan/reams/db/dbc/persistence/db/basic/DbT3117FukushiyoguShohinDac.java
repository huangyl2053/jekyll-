/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3117FukushiyoguShohin;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3117FukushiyoguShohin.kanriKaishiYMD;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3117FukushiyoguShohin.kanriShuryoYMD;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3117FukushiyoguShohin.shohinNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3117FukushiyoguShohinEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 福祉用具商品名入力ガイドのデータアクセスクラスです。
 */
public class DbT3117FukushiyoguShohinDac implements ISaveable<DbT3117FukushiyoguShohinEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで福祉用具商品名入力ガイドを取得します。
     *
     * @param 商品番号 shohinNo
     * @param 管理開始年月日 kanriKaishiYMD
     * @return DbT3117FukushiyoguShohinEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3117FukushiyoguShohinEntity selectByKey(
            RString 商品番号,
            FlexibleDate 管理開始年月日) throws NullPointerException {
        requireNonNull(商品番号, UrSystemErrorMessages.値がnull.getReplacedMessage("商品番号"));
        requireNonNull(管理開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("管理開始年月日"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3117FukushiyoguShohin.class).
                where(and(
                                eq(shohinNo, 商品番号),
                                eq(kanriKaishiYMD, 管理開始年月日))).
                toObject(DbT3117FukushiyoguShohinEntity.class);
    }

    /**
     * 福祉用具商品名入力ガイドを全件返します。
     *
     * @return List<DbT3117FukushiyoguShohinEntity>
     */
    @Transaction
    public List<DbT3117FukushiyoguShohinEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3117FukushiyoguShohin.class).
                toList(DbT3117FukushiyoguShohinEntity.class);
    }

    /**
     * DbT3117FukushiyoguShohinEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3117FukushiyoguShohinEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具商品名入力ガイドエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT3117FukushiyoguShohinEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 件数
     */
    @Transaction
    public int saveOrDelete(DbT3117FukushiyoguShohinEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具商品名入力ガイドエンティティ"));

        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 検索で福祉用具商品名入力ガイドを取得します。
     *
     * @param 基準日 FlexibleDate
     * @return DbT3117FukushiyoguShohinEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3117FukushiyoguShohinEntity> selectList(
            FlexibleDate 基準日) throws NullPointerException {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3117FukushiyoguShohin.class).
                where(or(and(
                                        (isNULL(kanriShuryoYMD)),
                                        leq(kanriKaishiYMD, 基準日)),
                                and(
                                        leq(kanriKaishiYMD, 基準日),
                                        leq(基準日, kanriShuryoYMD)))).
                toList(DbT3117FukushiyoguShohinEntity.class);
    }
}
