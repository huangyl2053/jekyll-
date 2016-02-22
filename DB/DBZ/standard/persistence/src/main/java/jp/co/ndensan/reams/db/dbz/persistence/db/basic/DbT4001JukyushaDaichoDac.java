/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho.edaban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho.jukyuShinseiJiyu;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho.logicalDeletedFlag;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho.ninteiYukoKikanKaishiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho.ninteiYukoKikanShuryoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho.shinseiJokyoKubun;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho.yukoMukoKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳のデータアクセスクラスです。
 */
public class DbT4001JukyushaDaichoDac implements ISaveable<DbT4001JukyushaDaichoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで受給者台帳を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param 枝番 枝番
     * @param 受給申請事由 受給申請事由
     * @return DbT4001JukyushaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4001JukyushaDaichoEntity selectByKey(
            LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            RString 履歴番号,
            RString 枝番,
            ShikibetsuCode 受給申請事由) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        requireNonNull(受給申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給申請事由"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号),
                                eq(edaban, 枝番),
                                eq(jukyuShinseiJiyu, 受給申請事由))).
                toObject(DbT4001JukyushaDaichoEntity.class);
    }

    /**
     * 受給者台帳を全件返します。
     *
     * @return DbT4001JukyushaDaichoEntityの{@code list}
     */
    @Transaction
    public List<DbT4001JukyushaDaichoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                toList(DbT4001JukyushaDaichoEntity.class);
    }

    /**
     * DbT4001JukyushaDaichoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4001JukyushaDaichoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 被保険者番号をキーにして、受給者台帳．被保険者番号情報ある場合は、最新の履歴番号で、かつ、最大の枝番である情報を取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @return DbT4001JukyushaDaichoEntity 受給者台帳のデータ
     * @throws NullPointerException
     */
    @Transaction
    public DbT4001JukyushaDaichoEntity select受給者台帳(HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                not(eq(logicalDeletedFlag, true)))).
                order(by(rirekiNo, Order.DESC)).limit(1).
                toObject(DbT4001JukyushaDaichoEntity.class);
    }

    /**
     * 被保険者番号をキーにして、受給者台帳．被保険者番号情報ある場合は、最新の履歴番号で、かつ、最大の枝番である情報を取得する。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return DbT4001JukyushaDaichoEntity 受給者台帳のデータ
     * @throws NullPointerException
     */
    @Transaction
    public DbT4001JukyushaDaichoEntity select受給者台帳情報(LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(hihokenshaNo, 被保険者番号),
                                not(eq(logicalDeletedFlag, true)))).
                order(by(rirekiNo, Order.DESC), by(edaban, Order.DESC)).limit(1).
                toObject(DbT4001JukyushaDaichoEntity.class);
    }

    /**
     * 受給者台帳情報を取得する。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 有効無効区分 有効無効区分
     * @return DbT4001JukyushaDaichoEntity 受給者台帳のデータ
     * @throws NullPointerException
     */
    @Transaction
    public DbT4001JukyushaDaichoEntity select受給者台帳情報(LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            Code 有効無効区分) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(有効無効区分, UrSystemErrorMessages.値がnull.getReplacedMessage("有効無効区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(logicalDeletedFlag, false),
                                eq(yukoMukoKubun, 有効無効区分))).
                order(by(rirekiNo, Order.DESC), by(edaban, Order.DESC)).limit(1).
                toObject(DbT4001JukyushaDaichoEntity.class);
    }

    /**
     * 受給者台帳情報取得
     *
     * @param 被保険者番号
     * @param サービス年月
     * @return DbT4001JukyushaDaichoEntity
     * @throws NullPointerException
     */
    public DbT4001JukyushaDaichoEntity select受給者台帳情報(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス年月"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                leq(ninteiYukoKikanKaishiYMD, サービス提供年月),
                                leq(サービス提供年月, ninteiYukoKikanShuryoYMD),
                                eq(yukoMukoKubun, YukoMukoKubun.有効),
                                not(eq(logicalDeletedFlag, true)))).
                order(by(rirekiNo, Order.DESC), by(edaban, Order.DESC)).limit(1).
                toObject(DbT4001JukyushaDaichoEntity.class);
    }
    
    /**
     * 受給者台帳情報を取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param 有効無効区分 有効無効区分
     * @param 申請状況区分 申請状況区分
     * @return DbT4001JukyushaDaichoEntity 受給者台帳のデータ
     * @throws NullPointerException
     */
    @Transaction
    public List<DbT4001JukyushaDaichoEntity> select受給者台帳情報(HihokenshaNo 被保険者番号,
            Code 有効無効区分,
            Code 申請状況区分) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(有効無効区分, UrSystemErrorMessages.値がnull.getReplacedMessage("有効無効区分"));
        requireNonNull(申請状況区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請状況区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(logicalDeletedFlag, false),
                                eq(yukoMukoKubun, 有効無効区分),
                                eq(shinseiJokyoKubun, 申請状況区分))).
                order(by(rirekiNo, Order.DESC), by(edaban, Order.DESC)).
                toList(DbT4001JukyushaDaichoEntity.class);
    }
}
