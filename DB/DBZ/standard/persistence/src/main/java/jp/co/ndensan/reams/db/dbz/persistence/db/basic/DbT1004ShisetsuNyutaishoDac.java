/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaisho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaisho.daichoShubetsu;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaisho.nyushoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaisho.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaisho.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaisho.taishoYMD;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Order.DESC;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.lt;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険施設入退所のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-021 linghuhang
 */
public class DbT1004ShisetsuNyutaishoDac implements ISaveable<DbT1004ShisetsuNyutaishoEntity> {

    private static final RString MSG_識別コード = new RString("識別コード");
    @InjectSession
    private SqlSession session;
    private static final int INT_3 = 3;
    private static final int INT_1 = 1;

    /**
     * 主キーで介護保険施設入退所を取得します。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     * @return DbT1004ShisetsuNyutaishoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1004ShisetsuNyutaishoEntity selectByKey(
            ShikibetsuCode 識別コード,
            int 履歴番号) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1004ShisetsuNyutaisho.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT1004ShisetsuNyutaishoEntity.class);
    }

    /**
     * 介護保険施設入退所を全件返します。
     *
     * @return DbT1004ShisetsuNyutaishoEntityの{@code list}
     */
    @Transaction
    public List<DbT1004ShisetsuNyutaishoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1004ShisetsuNyutaisho.class).
                toList(DbT1004ShisetsuNyutaishoEntity.class);
    }

    /**
     * 介護保険施設入退所を検索します。
     *
     * @param 適用日 適用日
     * @param 解除日 解除日
     * @return DbT1004ShisetsuNyutaishoEntityの{@code list}
     */
    @Transaction
    public List<DbT1004ShisetsuNyutaishoEntity> selectNyushoymdAndTaishoymd(FlexibleDate 適用日, FlexibleDate 解除日) {
        requireNonNull(適用日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用日"));
        requireNonNull(解除日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除日"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1004ShisetsuNyutaisho.class).
                where(not(or(and(lt(nyushoYMD, 適用日), leq(taishoYMD, 適用日)), and(leq(解除日, nyushoYMD), lt(解除日, taishoYMD))))).
                toList(DbT1004ShisetsuNyutaishoEntity.class);
    }

    /**
     * DbT1004ShisetsuNyutaishoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int saveByForDelete(DbT1004ShisetsuNyutaishoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険施設入退所エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT1004ShisetsuNyutaishoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT1004ShisetsuNyutaishoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険施設入退所エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 最大履歴番号を取得です。
     *
     * @return 最大履歴番号
     */
    public DbT1004ShisetsuNyutaishoEntity selectRirekiNoMax() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(rirekiNo)).
                table(DbT1004ShisetsuNyutaisho.class).toObject(DbT1004ShisetsuNyutaishoEntity.class);
    }

    /**
     * 識別コードにより、最大履歴番号を取得です。
     *
     * @param 識別コード ShikibetsuCode
     * @return 最大履歴番号
     */
    public DbT1004ShisetsuNyutaishoEntity get最大履歴番号(ShikibetsuCode 識別コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(rirekiNo)).
                table(DbT1004ShisetsuNyutaisho.class).
                where(eq(shikibetsuCode, 識別コード)).
                toObject(DbT1004ShisetsuNyutaishoEntity.class);
    }

    /**
     * 入退所日リストの取得です。
     *
     * @param 識別コード 識別コード
     * @param 台帳種別 台帳種別
     * @return 入退所日リスト
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public List<DbT1004ShisetsuNyutaishoEntity> get入退所日(ShikibetsuCode 識別コード,
            RString 台帳種別) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_識別コード.toString()));
        requireNonNull(台帳種別, UrSystemErrorMessages.値がnull.getReplacedMessage("台帳種別"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1004ShisetsuNyutaisho.class).
                where(and(eq(DbT1004ShisetsuNyutaisho.shikibetsuCode, 識別コード),
                                eq(DbT1004ShisetsuNyutaisho.daichoShubetsu, 台帳種別))).
                order(by(DbT1004ShisetsuNyutaisho.nyushoYMD)).
                toList(DbT1004ShisetsuNyutaishoEntity.class);
    }

    /**
     * 主キーで介護保険施設入退所を取得します。
     *
     * @param 識別コード 識別コード
     * @return List<DbT1004ShisetsuNyutaishoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1004ShisetsuNyutaishoEntity> selectFor施設入退所データ(
            ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1004ShisetsuNyutaisho.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(daichoShubetsu, DaichoType.被保険者.getコード()))).
                order(by(taishoYMD, DESC)).
                limit(INT_3).
                toList(DbT1004ShisetsuNyutaishoEntity.class);
    }

    /**
     * 施設入退所Orderの取得です。
     *
     * @param 識別コード 識別コード
     * @param 台帳種別 台帳種別
     * @return DbT1004ShisetsuNyutaishoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public DbT1004ShisetsuNyutaishoEntity get施設入退所Order(ShikibetsuCode 識別コード,
            RString 台帳種別) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_識別コード.toString()));
        requireNonNull(台帳種別, UrSystemErrorMessages.値がnull.getReplacedMessage("台帳種別"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1004ShisetsuNyutaisho.class).
                where(and(eq(DbT1004ShisetsuNyutaisho.shikibetsuCode, 識別コード),
                                eq(DbT1004ShisetsuNyutaisho.daichoShubetsu, 台帳種別))).
                order(by(DbT1004ShisetsuNyutaisho.rirekiNo)).
                limit(INT_1).
                toObject(DbT1004ShisetsuNyutaishoEntity.class);
    }

    /**
     * 識別コードにより、介護保険施設入退所の取得。
     *
     * @param 識別コード ShikibetsuCode
     * @return 介護保険施設入退所
     */
    public List<DbT1004ShisetsuNyutaishoEntity> get介護保険施設入退所(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1004ShisetsuNyutaisho.class).
                where(eq(shikibetsuCode, 識別コード)).
                order(by(shikibetsuCode), by(rirekiNo, Order.DESC)).
                toList(DbT1004ShisetsuNyutaishoEntity.class);
    }
}
