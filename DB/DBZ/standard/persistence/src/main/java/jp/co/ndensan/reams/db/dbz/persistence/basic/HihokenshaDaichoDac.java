/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * DbT1001HihokenshaDaichoへのデータアクセスクラスです。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaDaichoDac implements IInsertable<DbT1001HihokenshaDaichoEntity>, IDeletable<DbT1001HihokenshaDaichoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 市町村コードから、指定した市町村の被保険者台帳情報を検索します。
     *
     * @param 市町村コード {@link LasdecCode 市町村コード}
     * @return
     * {@link DbT1001HihokenshaDaichoEntity 被保険者台帳管理Entity}の{@link List リスト}
     */
    @Transaction
    public List<DbT1001HihokenshaDaichoEntity> selectAll(LasdecCode 市町村コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> entities = accessor.
                select().
                table(DbT1001HihokenshaDaicho.class).
                where(eq(shichosonCode, 市町村コード)).
                order(by(shoriTimestamp, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);
        return entities;
    }

    /**
     * 検索条件を指定して、その条件に合致する被保険者台帳情報を検索します。
     *
     * @param 検索条件 {@link ITrueFalseCriteria 検索条件}
     * @return
     * {@link DbT1001HihokenshaDaichoEntity 被保険者台帳管理Entity}の{@link List リスト}
     */
    @Transaction
    public List<DbT1001HihokenshaDaichoEntity> selectAll(ITrueFalseCriteria 検索条件) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> entities = accessor.
                select().
                table(DbT1001HihokenshaDaicho.class).
                where(検索条件).
                order(by(shoriTimestamp, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);
        return entities;
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
                order(by(shoriTimestamp, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);
        return entities.isEmpty() ? null : entities.get(0);
    }

    /**
     * 指定の{@link LasdecCode 市町村コード}と{@link KaigoHihokenshaNo 被保険者番号}から特定される被保険者の、
     * 直近の資格情報を検索します。
     *
     * @param 市町村コード {@link LasdecCode 市町村コード}
     * @param 被保険者番号 {@link KaigoHihokenshaNo 被保険者番号}
     * @return 直近の資格情報を保持した{@link DbT1001HihokenshaDaichoEntity 被保険者台帳Entity}
     */
    public DbT1001HihokenshaDaichoEntity selectLatestOfPerson(LasdecCode 市町村コード, KaigoHihokenshaNo 被保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> entities = accessor.
                select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(eq(shichosonCode, 市町村コード), eq(hihokenshaNo, 被保険者番号))).
                order(by(shoriTimestamp, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);
        return entities.isEmpty() ? null : entities.get(0);
    }

    /**
     * 主キーから被保険者台帳を検索します。
     *
     * @param 市町村コード {@link LasdecCode 市町村コード}
     * @param 識別コード {@link ShikibetsuCode 識別コード}
     * @param 処理日時 {@link RDateTime 処理日時}
     * @return {@link DbT1001HihokenshaDaichoEntity 被保険者台帳Entity}
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity selectFromKey(LasdecCode 市町村コード, ShikibetsuCode 識別コード, YMDHMS 処理日時) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        DbT1001HihokenshaDaichoEntity entity = accessor.
                select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(eq(shichosonCode, 市町村コード), eq(shikibetsuCode, 識別コード), eq(shoriTimestamp, 処理日時))).
                order(by(shoriTimestamp, Order.DESC)).
                toObject(DbT1001HihokenshaDaichoEntity.class);
        return entity;
    }

    @Override
    @Transaction
    public int insert(DbT1001HihokenshaDaichoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(data).execute();
    }

    @Override
    @Transaction
    public int delete(DbT1001HihokenshaDaichoEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(data).execute();
    }
}
