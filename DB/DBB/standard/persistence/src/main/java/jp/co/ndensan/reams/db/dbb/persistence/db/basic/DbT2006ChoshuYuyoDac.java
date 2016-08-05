/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyo.choteiNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyo.fukaNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyo.rirekiNo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyo.tsuchishoNo;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護賦課徴収猶予のデータアクセスクラスです。
 *
 * @reamsid_L DBB-9999-012 xicongwang
 */
public class DbT2006ChoshuYuyoDac implements ISaveable<DbT2006ChoshuYuyoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護賦課徴収猶予を取得します。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @param 履歴番号 RirekiNo
     * @return DbT2006ChoshuYuyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2006ChoshuYuyoEntity selectByKey(
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
                table(DbT2006ChoshuYuyo.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(fukaNendo, 賦課年度),
                                eq(tsuchishoNo, 通知書番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT2006ChoshuYuyoEntity.class);
    }

    /**
     * 介護賦課徴収猶予を全件返します。
     *
     * @return List<DbT2006ChoshuYuyoEntity>
     */
    @Transaction
    public List<DbT2006ChoshuYuyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2006ChoshuYuyo.class).
                toList(DbT2006ChoshuYuyoEntity.class);
    }

    /**
     * DbT2006ChoshuYuyoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2006ChoshuYuyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課徴収猶予エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT2006ChoshuYuyoEntityを削除します。物理削除する。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Transaction
    public int delete(DbT2006ChoshuYuyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課徴収猶予エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 主キーで介護賦課徴収猶予を取得します。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @return DbT2006ChoshuYuyoEntity
     */
    @Transaction
    public DbT2006ChoshuYuyoEntity get徴収猶予の情報(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2006ChoshuYuyo.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(fukaNendo, 賦課年度),
                                eq(tsuchishoNo, 通知書番号))).
                order(by(rirekiNo, Order.DESC)).limit(1).
                toObject(DbT2006ChoshuYuyoEntity.class);
    }
}
