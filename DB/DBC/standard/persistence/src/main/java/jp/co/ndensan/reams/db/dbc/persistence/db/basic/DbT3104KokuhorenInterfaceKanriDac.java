/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.SofuTorikomiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanri;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanri.isDeleted;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanri.kokanShikibetsuNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanri.shoriJotaiKubun;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanri.shoriYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanri.sofuTorikomiKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
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
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 国保連インターフェース管理のデータアクセスクラスです。
 *
 * @reamsid_L DBC-0980-520 quxiaodong
 */
public class DbT3104KokuhorenInterfaceKanriDac implements ISaveable<DbT3104KokuhorenInterfaceKanriEntity> {

    @InjectSession
    private SqlSession session;

    private static final boolean 論理削除フラグ = false;

    /**
     * 主キーで国保連インターフェース管理を取得します(論理削除行ではない)。
     *
     * @param 処理状態区分 shoriJotaiKubun
     * @param 交換情報識別番号 KokanShikibetsuNo
     * @return DbT3104KokuhorenInterfaceKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3104KokuhorenInterfaceKanriEntity select(
            RString 処理状態区分,
            RString 交換情報識別番号) throws NullPointerException {
        requireNonNull(処理状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("処理状態区分"));
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3104KokuhorenInterfaceKanri.class).
                where(and(
                                eq(shoriJotaiKubun, 処理状態区分),
                                eq(kokanShikibetsuNo, 交換情報識別番号),
                                eq(isDeleted, 論理削除フラグ))).
                order(by(DbT3104KokuhorenInterfaceKanri.shoriYM, Order.DESC)).limit(1).
                toObject(DbT3104KokuhorenInterfaceKanriEntity.class);
    }

    /**
     * 主キーで国保連インターフェース管理を取得します。
     *
     * @param 処理年月 ShoriYM
     * @param 交換情報識別番号 KokanShikibetsuNo
     * @return DbT3104KokuhorenInterfaceKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3104KokuhorenInterfaceKanriEntity selectByKey(
            FlexibleYearMonth 処理年月,
            RString 交換情報識別番号) throws NullPointerException {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3104KokuhorenInterfaceKanri.class).
                where(and(
                                eq(shoriYM, 処理年月),
                                eq(kokanShikibetsuNo, 交換情報識別番号))).
                toObject(DbT3104KokuhorenInterfaceKanriEntity.class);
    }

    /**
     * 主キーで国保連インターフェース管理を取得します(論理削除行ではない)。
     *
     * @param 処理年月 ShoriYM
     * @param 交換情報識別番号 KokanShikibetsuNo
     * @return DbT3104KokuhorenInterfaceKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3104KokuhorenInterfaceKanriEntity selectByKeyUndeleted(
            FlexibleYearMonth 処理年月,
            RString 交換情報識別番号) throws NullPointerException {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3104KokuhorenInterfaceKanri.class).
                where(and(
                                eq(shoriYM, 処理年月),
                                eq(kokanShikibetsuNo, 交換情報識別番号),
                                eq(isDeleted, 論理削除フラグ))).
                toObject(DbT3104KokuhorenInterfaceKanriEntity.class);
    }

    /**
     * 国保連インターフェース管理を審査年月取得返します。
     *
     * @param 交換情報識別番号 RString
     * @return List<DbT3104KokuhorenInterfaceKanriEntity>
     */
    @Transaction
    public List<DbT3104KokuhorenInterfaceKanriEntity> selectSinsaYM(RString 交換情報識別番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(DbT3104KokuhorenInterfaceKanri.chushutsuKaishiTimestamp,
                DbT3104KokuhorenInterfaceKanri.chushutsuShuryoTimestamp).
                table(DbT3104KokuhorenInterfaceKanri.class).
                where(and(
                                eq(kokanShikibetsuNo, 交換情報識別番号),
                                eq(sofuTorikomiKubun, SofuTorikomiKubun.それ以外.getコード()),
                                or(eq(shoriJotaiKubun, ShoriJotaiKubun.処理前.getコード()), eq(shoriJotaiKubun, ShoriJotaiKubun.再処理前.getコード())))).
                order(by(DbT3104KokuhorenInterfaceKanri.shoriYM, Order.ASC)).
                toList(DbT3104KokuhorenInterfaceKanriEntity.class);
    }

    /**
     * 国保連インターフェース管理を審査年月取得返します。
     *
     * @param 交換情報識別番号 RString
     * @return DbT3104KokuhorenInterfaceKanriEntity
     */
    @Transaction
    public DbT3104KokuhorenInterfaceKanriEntity select国保連インターフェース管理処理が実行された最新のデータ(RString 交換情報識別番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3104KokuhorenInterfaceKanri.class).
                where(and(
                                eq(kokanShikibetsuNo, 交換情報識別番号),
                                eq(shoriJotaiKubun, ShoriJotaiKubun.終了.getコード()))).
                order(by(DbT3104KokuhorenInterfaceKanri.shoriYM, Order.DESC)).limit(1)
                .toObject(DbT3104KokuhorenInterfaceKanriEntity.class);
    }

    /**
     * 国保連インターフェース管理を全件返します。
     *
     * @return List<DbT3104KokuhorenInterfaceKanriEntity>
     */
    @Transaction
    public List<DbT3104KokuhorenInterfaceKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3104KokuhorenInterfaceKanri.class).
                toList(DbT3104KokuhorenInterfaceKanriEntity.class);
    }

    /**
     * 最大処理年月を取得します
     *
     * @return DbT3104KokuhorenInterfaceKanriEntity
     */
    public DbT3104KokuhorenInterfaceKanriEntity getMaxShoriYM() {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(DbT3104KokuhorenInterfaceKanri.shoriYM)).
                table(DbT3104KokuhorenInterfaceKanri.class).
                toObject(DbT3104KokuhorenInterfaceKanriEntity.class);
    }

    /**
     * DbT3104KokuhorenInterfaceKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3104KokuhorenInterfaceKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連インターフェース管理エンティティ"));

        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
//        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 国保連インターフェース管理取得返します。
     *
     * @param 交換情報識別番号 RString
     * @return List<DbT3104KokuhorenInterfaceKanriEntity>
     */
    @Transaction
    public List<DbT3104KokuhorenInterfaceKanriEntity> get国保連インターフェース管理(RString 交換情報識別番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3104KokuhorenInterfaceKanri.class).
                where(and(
                                eq(kokanShikibetsuNo, 交換情報識別番号),
                                eq(sofuTorikomiKubun, SofuTorikomiKubun.それ以外.getコード()))).
                order(by(DbT3104KokuhorenInterfaceKanri.shoriYM, Order.DESC)).
                toList(DbT3104KokuhorenInterfaceKanriEntity.class);
    }

    /**
     * 国保連インターフェース管理取得返します。
     *
     * @param 交換情報識別番号 RString
     * @param 処理年月 RString FlexibleYearMonth
     * @return List<DbT3104KokuhorenInterfaceKanriEntity>
     */
    @Transaction
    public List<DbT3104KokuhorenInterfaceKanriEntity> get国保連インターフェース管理_処理年月(
            RString 交換情報識別番号,
            FlexibleYearMonth 処理年月) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3104KokuhorenInterfaceKanri.class).
                where(and(
                                eq(kokanShikibetsuNo, 交換情報識別番号),
                                eq(shoriYM, 処理年月),
                                eq(sofuTorikomiKubun, SofuTorikomiKubun.それ以外.getコード()))).
                toList(DbT3104KokuhorenInterfaceKanriEntity.class);
    }
}
