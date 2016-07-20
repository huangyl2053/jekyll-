/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaicho;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaicho.edaNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaicho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaicho.idoYMD;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 被保険者台帳管理Aliveのデータアクセスクラスです。
 *
 * @reamsid_L DBA-1300-030 lishengli
 */
public class DbV1001HihokenshaDaichoAliveDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで被保険者台帳管理Aliveを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 IdoYMD
     * @param 枝番 EdaNo
     * @return DbV1001HihokenshaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV1001HihokenshaDaichoEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動日,
            RString 枝番) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(idoYMD, 異動日),
                                eq(edaNo, 枝番))).
                toObject(DbV1001HihokenshaDaichoEntity.class);
    }

    /**
     * 被保険者台帳管理Aliveを全件返します。
     *
     * @return List<DbV1001HihokenshaDaichoEntity>
     */
    @Transaction
    public List<DbV1001HihokenshaDaichoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1001HihokenshaDaicho.class).
                toList(DbV1001HihokenshaDaichoEntity.class);
    }

    /**
     * DbV1001HihokenshaDaichoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save(DbV1001HihokenshaDaichoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳管理Aliveエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 被保険者番号により、最新の被保険者台帳情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return DbV1001HihokenshaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV1001HihokenshaDaichoEntity get最新の被保険者台帳情報(HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1001HihokenshaDaicho.class).
                where(eq(hihokenshaNo, 被保険者番号)).
                toObject(DbV1001HihokenshaDaichoEntity.class);
    }

    /**
     * 被保険者番号により、被保険者台帳管理Aliveを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<DbV1001HihokenshaDaichoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV1001HihokenshaDaichoEntity get被保険者台帳情報(HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1001HihokenshaDaicho.class).
                where(eq(hihokenshaNo, 被保険者番号))
                .order(by(DbV1001HihokenshaDaicho.idoYMD, Order.DESC), by(DbV1001HihokenshaDaicho.edaNo, Order.DESC)).limit(1).
                toObject(DbV1001HihokenshaDaichoEntity.class);
    }

    /**
     * 被保険者番号により、被保険者台帳管理Aliveを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<DbV1001HihokenshaDaichoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV1001HihokenshaDaichoEntity get被保険者台帳(HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1001HihokenshaDaicho.class).
                where(eq(hihokenshaNo, 被保険者番号)).
                toObject(DbV1001HihokenshaDaichoEntity.class);
    }
}
