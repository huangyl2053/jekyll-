/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import static java.lang.Boolean.FALSE;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.edaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.hihokennshaKubunCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.ichigoShikakuShutokuYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.idoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.isDeleted;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.jushochitokureiKaijoJiyuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.jushochitokureiKaijoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.jushochitokureiTekiyoJiyuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.jushochitokureiTekiyoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.lastUpdateTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.logicalDeletedFlag;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.shikakuShutokuYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.shikakuSoshitsuYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.lt;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.substr;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳管理のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-021 linghuhang
 */
public class DbT1001HihokenshaDaichoDac implements ISaveable<DbT1001HihokenshaDaichoEntity> {

    private static final RString メッセージ_識別コード = new RString("識別コード");
    private static final RString メッセージ_被保険者番号 = new RString("被保険者番号");
    private static final RString メッセージ_サービス年月 = new RString("サービス年月");
    private static final RString メッセージ_異動日 = new RString("異動日");
    private static final RString 数字１ = new RString("1");
    private static final int 開始桁 = 1;
    private static final int 終了桁 = 6;
    @InjectSession
    private SqlSession session;

    /**
     * 主キーで被保険者台帳管理を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 IdoYMD
     * @param 枝番 EdaNo
     * @return DbT1001HihokenshaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動日,
            RString 枝番) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_被保険者番号.toString()));
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
     * 被保険者台帳管理を全件返します。
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
     * Max異動日
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @return DbT1001HihokenshaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity selectMax異動日(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_サービス年月.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                leq(substr(idoYMD, 開始桁, 終了桁), サービス年月),
                                eq(logicalDeletedFlag, false)
                        )).
                order(by(DbT1001HihokenshaDaicho.idoYMD, Order.DESC), by(DbT1001HihokenshaDaicho.edaNo, Order.DESC)).
                limit(1).
                toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * Min異動日
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @return DbT1001HihokenshaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity selectMin異動日(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_サービス年月.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                lt(サービス年月, substr(idoYMD, 開始桁, 終了桁)),
                                eq(logicalDeletedFlag, false)
                        )).
                order(by(DbT1001HihokenshaDaicho.idoYMD, Order.ASC), by(DbT1001HihokenshaDaicho.edaNo, Order.DESC)).
                limit(1).
                toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * DbT1001HihokenshaDaichoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT1001HihokenshaDaichoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳管理エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 住所地特例一覧データを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 取得日 取得日
     * @return 該当する被保険者台帳情報
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1001HihokenshaDaichoEntity> selectListHihokenshaNo(HihokenshaNo 被保険者番号,
            FlexibleDate 取得日) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_被保険者番号.toString()));
        requireNonNull(取得日, UrSystemErrorMessages.値がnull.getReplacedMessage("取得日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shikakuShutokuYMD, 取得日),
                                not(eq(logicalDeletedFlag, true)),
                                not(isNULL(jushochitokureiTekiyoYMD)),
                                not(eq(jushochitokureiTekiyoYMD, ""))
                        )).
                order(new OrderBy(idoYMD, Order.DESC, NullsOrder.LAST), new OrderBy(jushochitokureiKaijoYMD, Order.DESC, NullsOrder.LAST)).
                toList(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 住所地特例一覧データを取得します。
     *
     * @param 識別コード 識別コード
     * @param 取得日 取得日
     * @return 該当する被保険者台帳情報
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1001HihokenshaDaichoEntity> selectListShikibetsuCode(ShikibetsuCode 識別コード,
            FlexibleDate 取得日) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_識別コード.toString()));
        requireNonNull(取得日, UrSystemErrorMessages.値がnull.getReplacedMessage("取得日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(shikakuShutokuYMD, 取得日),
                                not(eq(logicalDeletedFlag, true)),
                                not(isNULL(jushochitokureiTekiyoYMD)),
                                not(eq(jushochitokureiTekiyoYMD, ""))
                        )).
                order(new OrderBy(idoYMD, Order.DESC, NullsOrder.LAST), new OrderBy(jushochitokureiKaijoYMD, Order.DESC, NullsOrder.LAST)).
                toList(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 得喪操作情報取得
     *
     * @param 被保険者番号 被保険者番号
     * @param 異動日 異動日
     * @param 枝番 枝番
     * @return DbT1001HihokenshaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public DbT1001HihokenshaDaichoEntity selectByHihokenshaNo(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動日,
            RString 枝番) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_被保険者番号.toString()));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(eq(hihokenshaNo, 被保険者番号),
                                eq(idoYMD, 異動日),
                                eq(edaNo, 枝番),
                                not(eq(logicalDeletedFlag, true))))
                .toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 住所地特例適用事由コードの1件を取得します。
     *
     * @param 住所地特例適用事由コード 住所地特例適用事由コード
     * @return 該当する被保険者台帳情報から最新1件
     */
    public List<DbT1001HihokenshaDaichoEntity> selectByShutokuJiyuDDL(RString 住所地特例適用事由コード) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(
                        eq(jushochitokureiTekiyoJiyuCode, 住所地特例適用事由コード)
                ).
                toList(DbT1001HihokenshaDaichoEntity.class);

    }

    /**
     * 住所地特例適用事由コードの1件を取得します。
     *
     * @param 住所地特例解除事由コード 住所地特例解除事由コード
     * @return 該当する被保険者台帳情報から最新1件
     */
    public List<DbT1001HihokenshaDaichoEntity> selectBySoshitsuJiyuDDL(RString 住所地特例解除事由コード) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(
                        eq(jushochitokureiKaijoJiyuCode, 住所地特例解除事由コード)
                ).
                toList(DbT1001HihokenshaDaichoEntity.class);

    }

    /**
     * 主キーで被保険者台帳管理を取得します。
     *
     * @param makeShuruiCondition 被保険者台帳管理の検索条件
     * @return DbT1001HihokenshaDaichoEntity 被保険者台帳管理情報
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1001HihokenshaDaichoEntity> select(
            ITrueFalseCriteria makeShuruiCondition) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(makeShuruiCondition).order(by(DbT1001HihokenshaDaicho.hihokenshaNo, Order.DESC),
                        by(DbT1001HihokenshaDaicho.idoYMD, Order.DESC),
                        by(DbT1001HihokenshaDaicho.edaNo, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 被保険者番号を取得します。
     *
     * @param 識別コード 識別コード
     * @return DbT1001HihokenshaDaichoEntity 被保険者台帳管理テーブルのエンティティ
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity selectHihokenshaNo(
            ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_識別コード.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(eq(shikibetsuCode, 識別コード)).
                order(new OrderBy(lastUpdateTimestamp, Order.DESC, NullsOrder.LAST)).
                limit(1).
                toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 被保険者番号、資格取得年月日、論理削除フラグで被保険者台帳を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 取得日 取得日
     * @return List<DbT1001HihokenshaDaichoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1001HihokenshaDaichoEntity> selectByHihokenshaNo(HihokenshaNo 被保険者番号, FlexibleDate 取得日)
            throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_被保険者番号.toString()));
        requireNonNull(取得日, UrSystemErrorMessages.値がnull.getReplacedMessage("取得日"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shikakuShutokuYMD, 取得日),
                                eq(logicalDeletedFlag, false))).
                toList(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 被保険者台帳管理By論理削除フラグAnd識別コードを取得します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @param 識別コード 識別コード
     * @return DbT1001HihokenshaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity select被保険者台帳管理By論理削除フラグAnd識別コード(
            boolean 論理削除フラグ,
            RString 識別コード) throws NullPointerException {

        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_識別コード.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(logicalDeletedFlag, 論理削除フラグ),
                                eq(shikibetsuCode, 識別コード))).
                order(new OrderBy(DbT1001HihokenshaDaicho.idoYMD, Order.DESC, NullsOrder.LAST),
                        new OrderBy(DbT1001HihokenshaDaicho.edaNo, Order.DESC, NullsOrder.LAST)).
                limit(1).
                toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 被保険者番号、論理削除フラグで被保険者台帳から最新データを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return DbT1001HihokenshaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity selectByHihokenshaNo(HihokenshaNo 被保険者番号)
            throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_被保険者番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(logicalDeletedFlag, false))).
                order(new OrderBy(DbT1001HihokenshaDaicho.idoYMD, Order.DESC, NullsOrder.LAST),
                        new OrderBy(DbT1001HihokenshaDaicho.edaNo, Order.DESC, NullsOrder.LAST)).
                limit(1).
                toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 市町村コードと被保険者番号を指定し、該当する被保険者台帳情報を取得します。 <br/>
     * 取得した結果は、異動日によりDescされた状態で取得され、listの先頭が最も最新の異動履歴になります。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return List<DbT1001HihokenshaDaichoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public List<DbT1001HihokenshaDaichoEntity> selectByHihokenshaNoAndShichosonCode(LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_被保険者番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(
                        and(
                                eq(shichosonCode, 市町村コード),
                                eq(hihokenshaNo, 被保険者番号)
                        )
                ).
                order(new OrderBy(idoYMD, Order.DESC, NullsOrder.LAST)).
                toList(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 市町村コードと識別コードを指定し、該当する被保険者台帳情報のなかから最新の1件を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @return 該当する被保険者台帳情報から最新1件
     */
    public DbT1001HihokenshaDaichoEntity selectForNewestHihokenshaDaichoData(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_識別コード.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(
                        and(
                                eq(shichosonCode, 市町村コード),
                                eq(shikibetsuCode, 識別コード)
                        )
                ).
                order(new OrderBy(idoYMD, Order.DESC, NullsOrder.LAST)).
                limit(1).
                toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 被保険者台帳情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    @Transaction
    public List<DbT1001HihokenshaDaichoEntity> get被保険者台帳情報(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                leq(idoYMD, new FlexibleDate(サービス提供年月.toDateString().toString() + "01")),
                                not(eq(logicalDeletedFlag, true)))).
                order(by(DbT1001HihokenshaDaicho.idoYMD, Order.DESC), by(DbT1001HihokenshaDaicho.edaNo, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 被保険者台帳管理情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    @Transaction
    public List<DbT1001HihokenshaDaichoEntity> get被保険者台帳管理情報(HihokenshaNo 被保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                not(eq(logicalDeletedFlag, true)))).
                order(by(DbT1001HihokenshaDaicho.idoYMD, Order.DESC), by(DbT1001HihokenshaDaicho.edaNo, Order.DESC)).
                toList(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 被保険者証資格証発行情報取得です。
     *
     * @param 被保険者番号 被保険者番号
     * @return DbT1001HihokenshaDaichoEntity
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity get被保険者証資格証発行情報(HihokenshaNo 被保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(logicalDeletedFlag, false))).order(by(idoYMD, Order.DESC), by(edaNo, Order.DESC)).limit(1)
                .toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 基準年月日と被保険者番号を指定し、該当する被保険者台帳情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準年月日 基準年月日
     * @return 該当する被保険者台帳情報
     */
    public DbT1001HihokenshaDaichoEntity selectByHihokenshaNoAndKijunDate(HihokenshaNo 被保険者番号, FlexibleDate 基準年月日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_被保険者番号.toString()));
        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT1001HihokenshaDaichoEntity> entityList = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(isDeleted, false),
                                leq(shikakuShutokuYMD, 基準年月日)
                        )).
                order(new OrderBy(idoYMD, Order.DESC, NullsOrder.LAST), new OrderBy(edaNo, Order.DESC, NullsOrder.LAST)).
                toList(DbT1001HihokenshaDaichoEntity.class);
        for (DbT1001HihokenshaDaichoEntity entity : entityList) {
            FlexibleDate shikakuSoshitsuYMD = entity.getShikakuSoshitsuYMD();
            FlexibleDate shikakuShutokuYMD = entity.getShikakuShutokuYMD();
            if (shikakuSoshitsuYMD != null && !shikakuSoshitsuYMD.isEmpty() && 基準年月日.isBefore(shikakuSoshitsuYMD)) {
                return entity;
            } else if (shikakuShutokuYMD != null && !shikakuShutokuYMD.isEmpty() && shikakuShutokuYMD.isBeforeOrEquals(基準年月日)) {
                return entity;
            }
        }
        return null;
    }

    /**
     * 基準年月日と識別コードを指定し、該当する被保険者台帳情報を取得します。
     *
     * @param 識別コード 識別コード
     * @param 基準年月日 基準年月日
     * @return 該当する被保険者台帳情報
     */
    public DbT1001HihokenshaDaichoEntity selectByShikibetsuCodeAndKijunDate(ShikibetsuCode 識別コード, FlexibleDate 基準年月日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_識別コード.toString()));
        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT1001HihokenshaDaichoEntity> entityList = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(isDeleted, false),
                                leq(shikakuShutokuYMD, 基準年月日))).
                order(new OrderBy(idoYMD, Order.DESC, NullsOrder.LAST), new OrderBy(edaNo, Order.DESC, NullsOrder.LAST)).
                toList(DbT1001HihokenshaDaichoEntity.class);
        for (DbT1001HihokenshaDaichoEntity entity : entityList) {
            FlexibleDate shikakuSoshitsuYMD = entity.getShikakuSoshitsuYMD();
            FlexibleDate shikakuShutokuYMD = entity.getShikakuShutokuYMD();
            if (shikakuSoshitsuYMD != null && !shikakuSoshitsuYMD.isEmpty() && 基準年月日.isBefore(shikakuSoshitsuYMD)) {
                return entity;
            } else if (shikakuShutokuYMD != null && !shikakuShutokuYMD.isEmpty() && shikakuShutokuYMD.isBeforeOrEquals(基準年月日)) {
                return entity;
            }
        }
        return null;
    }

    /**
     * 識別コードを指定し、該当する被保険者台帳情報のなかから最新の1件を取得します。
     *
     * @param 識別コード 識別コード
     * @return 該当する被保険者台帳情報から最新1件
     */
    public DbT1001HihokenshaDaichoEntity selectByShikibetsuCode(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_識別コード.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(isDeleted, false))).
                order(new OrderBy(idoYMD, Order.DESC, NullsOrder.LAST), new OrderBy(edaNo, Order.DESC, NullsOrder.LAST)).
                limit(1).
                toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 被保険者番号で被保険者台帳を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<DbT1001HihokenshaDaichoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity selectByHihokensha(HihokenshaNo 被保険者番号)
            throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_被保険者番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where((eq(hihokenshaNo, 被保険者番号))).order(by(idoYMD, Order.DESC), by(edaNo, Order.DESC)).
                limit(1).
                toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 異動日を指定し、該当する被保険者台帳情報のなかから最新の1件を取得します。
     *
     * @param 異動日 異動日
     * @return 該当する被保険者台帳情報から最新1件
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity selectBy異動日(FlexibleDate 異動日) {
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_異動日.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(
                        leq(idoYMD, 異動日)).
                order(new OrderBy(idoYMD, Order.DESC, NullsOrder.LAST)).
                limit(1).
                toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 資格の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 異動日 異動日
     * @param 被保険者区分コード 被保険者区分コード
     * @return DbT1001HihokenshaDaichoEntity
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity get資格の情報(HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード, FlexibleDate 異動日, RString 被保険者区分コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                leq(異動日, idoYMD),
                                not(eq(shikibetsuCode, 識別コード)),
                                eq(hihokennshaKubunCode, 被保険者区分コード))).
                order(new OrderBy(idoYMD, Order.DESC, NullsOrder.LAST)).
                limit(1).
                toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 被保険者番号、異動日で最大の枝番を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 IdoYMD
     * @return DbT1001HihokenshaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity selectMaxEdaNoByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動日) throws NullPointerException {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(edaNo)).
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(idoYMD, 異動日))).
                toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 被保険者番号、異動日で最大の枝番を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 被保険者区分コード hihokennshaKubunCode
     * @param システム日付 システム日付
     * @return DbT1001HihokenshaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1001HihokenshaDaichoEntity selectFor資格喪失フラグ(
            HihokenshaNo 被保険者番号,
            RString 被保険者区分コード,
            FlexibleDate システム日付) throws NullPointerException {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(hihokennshaKubunCode, 被保険者区分コード),
                                leq(ichigoShikakuShutokuYMD, システム日付),
                                or(isNULL(shikakuSoshitsuYMD), leq(システム日付, shikakuSoshitsuYMD)))).
                order(by(idoYMD, Order.DESC), by(edaNo, Order.DESC)).
                limit(1).
                toObject(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 資格の異動情報を取得します。
     *
     * @param 抽出開始日時 RDateTime
     * @param 抽出終了日時 RDateTime
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    @Transaction
    public List<DbT1001HihokenshaDaichoEntity> get資格の異動(RDateTime 抽出開始日時, RDateTime 抽出終了日時) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokennshaKubunCode, ShikakuKubun._１号.getコード()),
                                eq(logicalDeletedFlag, FALSE),
                                leq(抽出開始日時, lastUpdateTimestamp),
                                leq(lastUpdateTimestamp, 抽出終了日時)
                        )).toList(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 資格喪失者を取得する。
     *
     * @param 抽出開始日時 抽出開始日時
     * @param 抽出終了日時 抽出終了日時
     * @param 普徴仮算定賦課処理日時 普徴仮算定賦課処理日時
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    @Transaction
    public List<DbT1001HihokenshaDaichoEntity> get資格喪失者(RDateTime 抽出開始日時,
            RDateTime 抽出終了日時, RDateTime 普徴仮算定賦課処理日時) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        FlexibleDate 抽出開始日時の日付 = new FlexibleDate(抽出開始日時.getDate().toString());
        FlexibleDate 抽出終了日時の日付 = new FlexibleDate(抽出終了日時.getDate().toString());
        FlexibleDate 普徴仮算定賦課処理日時の日付 = new FlexibleDate(抽出開始日時.getDate().toString());
        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokennshaKubunCode, 数字１),
                                not(isNULL(shikakuSoshitsuYMD)),
                                not(eq(shikakuSoshitsuYMD, FlexibleDate.EMPTY)),
                                or(
                                        and(leq(抽出開始日時の日付, shikakuSoshitsuYMD),
                                                leq(shikakuSoshitsuYMD, 抽出終了日時の日付)),
                                        and(leq(抽出開始日時, lastUpdateTimestamp),
                                                leq(lastUpdateTimestamp, 抽出終了日時),
                                                leq(普徴仮算定賦課処理日時の日付, shikakuSoshitsuYMD),
                                                leq(shikakuSoshitsuYMD, 抽出終了日時の日付))
                                ),
                                eq(logicalDeletedFlag, false))
                ).
                toList(DbT1001HihokenshaDaichoEntity.class);
    }

    /**
     * 資格取得者を取得する。
     *
     * @param 抽出開始日時 抽出開始日時
     * @param 抽出終了日時 抽出終了日時
     * @param 普徴仮算定賦課処理日時 普徴仮算定賦課処理日時
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    @Transaction
    public List<DbT1001HihokenshaDaichoEntity> get資格取得者(RDateTime 抽出開始日時,
            RDateTime 抽出終了日時, RDateTime 普徴仮算定賦課処理日時) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        FlexibleDate 抽出開始日時の日付 = new FlexibleDate(抽出開始日時.getDate().toString());
        FlexibleDate 抽出終了日時の日付 = new FlexibleDate(抽出終了日時.getDate().toString());
        FlexibleDate 普徴仮算定賦課処理日時の日付 = new FlexibleDate(抽出開始日時.getDate().toString());
        return accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokennshaKubunCode, 数字１),
                                or(isNULL(shikakuSoshitsuYMD),
                                        eq(shikakuSoshitsuYMD, FlexibleDate.EMPTY)),
                                or(
                                        and(leq(抽出開始日時の日付, ichigoShikakuShutokuYMD),
                                                leq(ichigoShikakuShutokuYMD, 抽出終了日時の日付)),
                                        and(leq(抽出開始日時, lastUpdateTimestamp),
                                                leq(lastUpdateTimestamp, 抽出終了日時),
                                                leq(普徴仮算定賦課処理日時の日付, ichigoShikakuShutokuYMD),
                                                leq(ichigoShikakuShutokuYMD, 抽出終了日時の日付))
                                ),
                                eq(logicalDeletedFlag, false))
                ).
                toList(DbT1001HihokenshaDaichoEntity.class);
    }
}
