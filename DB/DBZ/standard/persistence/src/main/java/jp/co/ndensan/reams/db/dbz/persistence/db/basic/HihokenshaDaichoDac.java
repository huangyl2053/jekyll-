/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.edaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.idoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IPersistable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳のデータアクセスクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaDaichoDac implements IPersistable<DbT1001HihokenshaDaichoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 被保険者台帳を全件返します。
     *
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    @Transaction
    public List<DbT1001HihokenshaDaichoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                toList(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 被保険者番号で被保険者台帳を取得します。
     *
     * @param 被保険者番号 {@link HihokenshaNo 被保険者番号}
     * @return IItemList<DbT1001HihokenshaDaichoEntity>
     */
    @Transaction
    public ItemList<DbT1001HihokenshaDaichoEntity> selectByKey(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> entities = accessor.
                select().
                table(DbT1001HihokenshaDaicho.class).
                where(eq(hihokenshaNo, 被保険者番号)).
                order(by(hihokenshaNo, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);
        return ItemList.of(entities);
    }

    /**
     * 被保険者番号、異動日で被保険者台帳を取得します。
     *
     * @param 被保険者番号 {@link HihokenshaNo 被保険者番号}
     * * @param 異動日 {@link FlexibleDate 異動日}
     * @return IItemList<DbT1001HihokenshaDaichoEntity>
     */
    @Transaction
    public ItemList<DbT1001HihokenshaDaichoEntity> selectByKey(HihokenshaNo 被保険者番号, FlexibleDate 異動日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> entities = accessor.
                select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(idoYMD, 異動日))).
                order(by(hihokenshaNo, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);
        return ItemList.of(entities);
    }

    /**
     * 被保険者番号、異動日、枝番から、指定した市町村の被保険者台帳情報を検索します。
     *
     * @param 被保険者番号 {@link HihokenshaNo 被保険者番号}
     * @param 異動日 {@link FlexibleDate 異動日}
     * @param 枝番 {@link RString 枝番}
     * @return
     * {@link DbT1001HihokenshaDaichoEntity 被保険者台帳管理Entity}の{@link List リスト}
     * @throws NullPointerException NullPointerException
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity selectByKey(HihokenshaNo 被保険者番号,
            FlexibleDate 異動日,
            RString 枝番) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(idoYMD, 異動日),
                                eq(edaNo, 枝番))).
                toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 指定の{@link LasdecCode 市町村コード}と{@link ShikibetsuCode 識別コード}から特定される個人の、
     * 直近の資格情報を検索します。
     *
     * @param 市町村コード {@link LasdecCode 市町村コード}
     * @param 識別コード {@link ShikibetsuCode 識別コード}
     * @return 直近の資格情報を保持した{@link DbT1001HihokenshaDaichoEntity 被保険者台帳Entity}
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity selectLatestOfPerson(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> entities = accessor.
                select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(eq(shichosonCode, 市町村コード), eq(shikibetsuCode, 識別コード))).
                order(by(idoYMD, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);
        return entities.isEmpty() ? null : entities.get(0);
    }

    /**
     * 指定の{@link LasdecCode 市町村コード}と{@link HihokenshaNo 被保険者番号}から特定される被保険者の、
     * 直近の資格情報を検索します。
     *
     * @param 市町村コード {@link LasdecCode 市町村コード}
     * @param 被保険者番号 {@link HihokenshaNo 被保険者番号}
     * @return 直近の資格情報を保持した{@link DbT1001HihokenshaDaichoEntity 被保険者台帳Entity}
     */
    public DbT1001HihokenshaDaichoEntity selectLatestOfPerson(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> entities = accessor.
                select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(eq(shichosonCode, 市町村コード), eq(hihokenshaNo, 被保険者番号))).
                order(by(idoYMD, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);
        return entities.isEmpty() ? null : entities.get(0);
    }

    @Override
    public int insert(DbT1001HihokenshaDaichoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT1001HihokenshaDaichoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT1001HihokenshaDaichoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

//    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
//    @Transaction
//    @Override
//    public int deletePhysical(DbT1001HihokenshaDaichoEntity entity) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.deletePhysical(entity).execute();
//    }
}
