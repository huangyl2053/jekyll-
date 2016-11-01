/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4401IryohiKojo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4401IryohiKojo.dataKubun;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4401IryohiKojo.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4401IryohiKojo.kojoTaishoNen;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4401IryohiKojo.logicalDeletedFlag;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4401IryohiKojoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 医療費控除のデータアクセスクラスです。
 *
 * @reamsid_L DBD-9999-013 wangchao
 */
public class DbT4401IryohiKojoDac implements ISaveable<DbT4401IryohiKojoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで医療費控除を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 控除対象年 控除対象年
     * @param データ区分 データ区分
     * @return DbT4401IryohiKojoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4401IryohiKojoEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYear 控除対象年,
            RString データ区分) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(控除対象年, UrSystemErrorMessages.値がnull.getReplacedMessage("控除対象年"));
        requireNonNull(データ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("データ区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4401IryohiKojo.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kojoTaishoNen, 控除対象年),
                                eq(dataKubun, データ区分))).
                toObject(DbT4401IryohiKojoEntity.class);
    }

    /**
     * 医療費控除を全件返します。
     *
     * @return DbT4401IryohiKojoEntityの{@code list}
     */
    @Transaction
    public List<DbT4401IryohiKojoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4401IryohiKojo.class).
                toList(DbT4401IryohiKojoEntity.class);
    }

    /**
     * DbT4401IryohiKojoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4401IryohiKojoEntity entity
    ) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("医療費控除エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT4401IryohiKojoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int delete(DbT4401IryohiKojoEntity entity
    ) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("医療費控除エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 主キーで医療費控除を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param データ区分 データ区分
     * @return List<DbT4401IryohiKojoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT4401IryohiKojoEntity> select単票用医療費控除(
            HihokenshaNo 被保険者番号,
            RString データ区分) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(データ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("データ区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4401IryohiKojo.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(dataKubun, データ区分),
                                eq(logicalDeletedFlag, false))).
                order(by(kojoTaishoNen, Order.DESC)).
                toList(DbT4401IryohiKojoEntity.class);
    }

    /**
     * 主キーで医療費控除を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<DbT4401IryohiKojoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT4401IryohiKojoEntity> select医療費控除(HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4401IryohiKojo.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(logicalDeletedFlag, false))).
                order(by(kojoTaishoNen, Order.DESC),
                        by(dataKubun, Order.DESC)).
                toList(DbT4401IryohiKojoEntity.class);
    }
}
