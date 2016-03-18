/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002Fuka;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002Fuka.choteiNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002Fuka.choteiNichiji;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002Fuka.fukaNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002Fuka.rirekiNo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002Fuka.tsuchishoNo;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorList.hihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護賦課のデータアクセスクラスです。
 */
public class DbT2002FukaDac implements ISaveable<DbT2002FukaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護賦課を取得します。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @param 履歴番号 RirekiNo
     * @return DbT2002FukaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2002FukaEntity selectByKey(
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
                table(DbT2002Fuka.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(fukaNendo, 賦課年度),
                                eq(tsuchishoNo, 通知書番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT2002FukaEntity.class);
    }

    /**
     * キーで介護賦課を取得します。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 被保険者番号 HihokenshaNo
     * @param 調定日時 KoseiNichiji
     * @return DbT2002FukaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2002FukaEntity selectFor任意対象比較(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号,
            RDateTime 調定日時) throws NullPointerException {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(調定日時, UrSystemErrorMessages.値がnull.getReplacedMessage("調定日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT2002FukaEntity> list = accessor.select().
                table(DbT2002Fuka.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(fukaNendo, 賦課年度),
                                eq(hihokenshaNo, 被保険者番号),
                                leq(choteiNichiji, 調定日時))).
                order(by(rirekiNo, Order.DESC)).
                toList(DbT2002FukaEntity.class);

        return list.size() > 0 ? list.get(0) : null;
    }

    /**
     * ある被保険者の前年度分の賦課情報を取得します。
     *
     * @param 賦課年度 賦課年度.この前年の賦課を検索する。
     * @param 被保険者番号 対象の被保険者番号
     * @return 指定の賦課年度の前年度の、指定の被保険者に関する賦課の情報
     */
    public List<DbT2002FukaEntity> select賦課履歴On(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT2002Fuka.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                eq(hihokenshaNo, 被保険者番号))).
                toList(DbT2002FukaEntity.class);
    }

    /**
     * 介護賦課を全件返します。
     *
     * @return DbT2002FukaEntityの{@code list}
     */
    @Transaction
    public List<DbT2002FukaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2002Fuka.class).
                toList(DbT2002FukaEntity.class);
    }

    /**
     * DbT2002FukaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2002FukaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 介護賦課を返します。
     *
     * @param 通知書番号 通知書番号
     * @return DbT2002FukaEntityの{@code list}
     */
    @Transaction
    public List<DbT2002FukaEntity> select更正前のデータ(TsuchishoNo 通知書番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT2002Fuka.class).
                where(eq(tsuchishoNo, 通知書番号)).
                order(by(DbT2002Fuka.choteiNendo, Order.DESC), by(DbT2002Fuka.rirekiNo, Order.DESC)).
                toList(DbT2002FukaEntity.class);
    }
}
