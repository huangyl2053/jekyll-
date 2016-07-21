/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.core.nyuryokushikibetsuno.NyuryokuShikibetsuNoShokan3Keta;
import jp.co.ndensan.reams.db.dbc.definition.core.shikibetsubangokubun.ShikibetsubangoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikibetsunokubon.ShikibetsuNoKubon;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanri;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanri.hyoujiJun;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanri.kyufuBunruiKubun;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanri.kyufujissekiKubun;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanri.shikibetsuNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanri.shikibetsuNoKubon;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanri.tekiyoKaishiYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanri.tekiyoShuryoYM;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
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
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.substr;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 基準収入額適用管理のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 xicongwang
 */
public class DbT3118ShikibetsuNoKanriDac implements ISaveable<DbT3118ShikibetsuNoKanriEntity> {

    private static final int SHIKIBETSUNO_START = 1;
    private static final int SHIKIBETSUNO_END = 3;
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final RString 定数_3 = new RString("3");
    private static final RString MSG_NAME_SHIKIBETSUNO = new RString("識別番号");
    private static final RString MSG_NAME_SERVICETEIKYOYM = new RString("サービス提供年月");

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで基準収入額適用管理を取得します。
     *
     * @param 識別番号 識別番号
     * @param 適用開始年月 適用開始年月
     * @return DbT3118ShikibetsuNoKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3118ShikibetsuNoKanriEntity selectByKey(
            RString 識別番号,
            FlexibleYearMonth 適用開始年月) throws NullPointerException {
        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("識別番号"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3118ShikibetsuNoKanri.class).
                where(and(
                                eq(shikibetsuNo, 識別番号),
                                eq(tekiyoKaishiYM, 適用開始年月))).
                toObject(DbT3118ShikibetsuNoKanriEntity.class);
    }

    /**
     * 基準収入額適用管理を全件返します。
     *
     * @return List<DbT3118ShikibetsuNoKanriEntity>
     */
    @Transaction
    public List<DbT3118ShikibetsuNoKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3118ShikibetsuNoKanri.class).
                toList(DbT3118ShikibetsuNoKanriEntity.class);
    }

    /**
     * DbT3118ShikibetsuNoKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3118ShikibetsuNoKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("基準収入額適用管理エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 被保険者番号で受給者台帳を取得します。
     *
     * @param 識別番号区分 識別番号区分
     * @param 適用年月 適用年月
     * @return DbT3118ShikibetsuNoKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3118ShikibetsuNoKanriEntity select交換情報識別番号(RString 識別番号区分,
            FlexibleYearMonth 適用年月) {
        requireNonNull(識別番号区分, UrSystemErrorMessages.値がnull.getReplacedMessage("識別番号区分"));
        requireNonNull(適用年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3118ShikibetsuNoKanri.class).
                where(and(
                                eq(shikibetsuNoKubon, 識別番号区分),
                                leq(tekiyoKaishiYM, 適用年月),
                                leq(適用年月, tekiyoShuryoYM))).
                toObject(DbT3118ShikibetsuNoKanriEntity.class);

    }

    /**
     * 識別番号管理情報取得を取得します。
     *
     * @param 識別番号 識別番号
     * @param サービス提供年月 サービス提供年月
     * @return DbT3118ShikibetsuNoKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public DbT3118ShikibetsuNoKanriEntity select識別番号管理(RString 識別番号, FlexibleYearMonth サービス提供年月)
            throws NullPointerException {
        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_NAME_SHIKIBETSUNO.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_NAME_SERVICETEIKYOYM.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3118ShikibetsuNoKanri.class).
                where(and(
                                eq(shikibetsuNo, 識別番号),
                                leq(tekiyoKaishiYM, サービス提供年月),
                                leq(サービス提供年月, tekiyoShuryoYM))).
                toObject(DbT3118ShikibetsuNoKanriEntity.class);
    }

    /**
     * 識別番号管理情報取得を取得します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return List<DbT3118ShikibetsuNoKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public List<DbT3118ShikibetsuNoKanriEntity> select識別番号管理(FlexibleYearMonth サービス提供年月)
            throws NullPointerException {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_NAME_SERVICETEIKYOYM.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3118ShikibetsuNoKanri.class).
                where(and(
                                not(eq(substr(shikibetsuNo, SHIKIBETSUNO_START, SHIKIBETSUNO_END),
                                                NyuryokuShikibetsuNoShokan3Keta.福祉用具販売費.getコード())),
                                not(eq(substr(shikibetsuNo, SHIKIBETSUNO_START, SHIKIBETSUNO_END),
                                                NyuryokuShikibetsuNoShokan3Keta.住宅改修費.getコード())),
                                eq(shikibetsuNoKubon, ShikibetsubangoKubun.入力識別番号.getコード()),
                                leq(tekiyoKaishiYM, サービス提供年月),
                                leq(サービス提供年月, tekiyoShuryoYM)
                        )).order(by(hyoujiJun, Order.ASC)).toList(DbT3118ShikibetsuNoKanriEntity.class);
    }

    /**
     * 略称を取得する。
     *
     * @param 識別番号 識別番号
     * @param サービス提供年月 サービス提供年月
     * @param 識別番号区分 識別番号区分
     * @return RString 略称
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3118ShikibetsuNoKanriEntity select略称(RString 識別番号, FlexibleYearMonth サービス提供年月, RString 識別番号区分)
            throws NullPointerException {

        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_NAME_SHIKIBETSUNO.toString()));
        requireNonNull(サービス提供年月,
                UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_NAME_SERVICETEIKYOYM.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3118ShikibetsuNoKanri.class).
                where(and(
                                eq(shikibetsuNo, 識別番号),
                                leq(tekiyoKaishiYM, サービス提供年月),
                                leq(サービス提供年月, tekiyoShuryoYM),
                                eq(shikibetsuNoKubon, 識別番号区分))).
                toObject(DbT3118ShikibetsuNoKanriEntity.class);
    }

    /**
     * 様式名称取得
     *
     * @param サービス提供年月 サービス提供年月
     * @return List<DbT3118ShikibetsuNoKanriEntity>
     */
    public List<DbT3118ShikibetsuNoKanriEntity> select様式名称(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_NAME_SERVICETEIKYOYM.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3118ShikibetsuNoKanri.class).
                where(and(
                                or(eq(shikibetsuNo, new RString("21D1")),
                                        eq(shikibetsuNo, new RString("21D2"))),
                                leq(tekiyoKaishiYM, サービス提供年月),
                                leq(サービス提供年月, tekiyoShuryoYM),
                                eq(shikibetsuNoKubon, ShikibetsuNoKubon.入力識別番号.getコード()))).
                toList(DbT3118ShikibetsuNoKanriEntity.class);
    }

    /**
     * 様式名称とコードを取得する。
     *
     * @param サービス提供年月 FlexibleYearMonth
     * @return List<DbT3118ShikibetsuNoKanriEntity>
     */
    public List<DbT3118ShikibetsuNoKanriEntity> select様式名称とコード(FlexibleYearMonth サービス提供年月) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3118ShikibetsuNoKanri.class).
                where(and(
                                leq(tekiyoKaishiYM, サービス提供年月),
                                leq(サービス提供年月, tekiyoShuryoYM),
                                eq(shikibetsuNoKubon, 定数_2),
                                eq(kyufujissekiKubun, 定数_2),
                                or(
                                        eq(kyufuBunruiKubun, 定数_1),
                                        eq(kyufuBunruiKubun, 定数_2),
                                        eq(kyufuBunruiKubun, 定数_3)))).
                toList(DbT3118ShikibetsuNoKanriEntity.class);
    }
}
