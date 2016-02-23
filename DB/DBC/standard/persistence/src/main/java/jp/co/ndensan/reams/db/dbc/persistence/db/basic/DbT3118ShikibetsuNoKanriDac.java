/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.core.shikibetsunokubon.ShikibetsuNoKubon;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanri;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanri.hyoujiJun;
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
 */
public class DbT3118ShikibetsuNoKanriDac implements ISaveable<DbT3118ShikibetsuNoKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで基準収入額適用管理を取得します。
     *
     * @param 識別番号
     * @param 適用開始年月
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
     * @param 識別番号区分
     * @param 適用年月
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
     *
     * @param 識別番号
     * @param サービス提供年月
     * @return DbT3118ShikibetsuNoKanriEntity
     * @throws NullPointerException
     */
    public DbT3118ShikibetsuNoKanriEntity select識別番号管理(RString 識別番号, FlexibleYearMonth サービス提供年月)
            throws NullPointerException {
        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("識別番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));

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
     *
     * @param サービス提供年月
     * @param 福祉用具販売費
     * @param 住宅改修費
     * @return
     * @throws NullPointerException
     */
    public List<DbT3118ShikibetsuNoKanriEntity> select識別番号管理(FlexibleYearMonth サービス提供年月)
            throws NullPointerException {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3118ShikibetsuNoKanri.class).
                where(and(
                                not(eq(substr(shikibetsuNo, 1, 3), "21C")),
                                not(eq(substr(shikibetsuNo, 1, 3), "21D")),
                                eq(shikibetsuNoKubon, "2"),
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
     * @throws NullPointerException
     */
    @Transaction
    public DbT3118ShikibetsuNoKanriEntity select略称(RString 識別番号, FlexibleYearMonth サービス提供年月, RString 識別番号区分)
            throws NullPointerException {

        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("識別番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));

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
     * @param サービス提供年月
     * @return List<DbT3118ShikibetsuNoKanriEntity>
     */
    public List<DbT3118ShikibetsuNoKanriEntity> select様式名称(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));

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
}
