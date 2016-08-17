/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofu;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofu.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofu.idoKubunCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofu.idoYMD;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofu.jukyushaIdoJiyu;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofu.logicalDeletedFlag;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofu.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofu.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofu.sofuYM;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.lt;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 共同処理用受給者異動償還送付のデータアクセスクラスです。
 *
 * @reamsid_L DBC-4390-020 xupeng
 */
public class DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac implements ISaveable<DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで共同処理用受給者異動償還送付を取得します。
     *
     * @param 異動年月日 IdoYMD
     * @param 異動区分コード IdoKubunCode
     * @param 受給者異動事由 JukyushaIdoJiyu
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity selectByKey(
            FlexibleDate 異動年月日,
            RString 異動区分コード,
            RString 受給者異動事由,
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        requireNonNull(異動区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動区分コード"));
        requireNonNull(受給者異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者異動事由"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3003KyodoShoriyoJukyushaIdoShokanSofu.class).
                where(and(
                                eq(idoYMD, 異動年月日),
                                eq(idoKubunCode, 異動区分コード),
                                eq(jukyushaIdoJiyu, 受給者異動事由),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity.class);
    }

    /**
     * 共同処理用受給者異動償還送付を全件返します。
     *
     * @return List<DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity>
     */
    @Transaction
    public List<DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3003KyodoShoriyoJukyushaIdoShokanSofu.class).
                toList(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity.class);
    }

    /**
     * DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("共同処理用受給者異動償還送付エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 共同処理用受給者異動償還送付を取得します。
     *
     * @param 異動年月日 IdoYMD
     * @param 被保険者番号 HiHokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @param 論理削除 boolean
     * @return DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity get償還送付(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動年月日,
            FlexibleYearMonth 対象年月,
            boolean 論理削除) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3003KyodoShoriyoJukyushaIdoShokanSofu.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(idoYMD, 異動年月日),
                                eq(sofuYM, 対象年月),
                                eq(logicalDeletedFlag, 論理削除))).
                order(new OrderBy(rirekiNo, Order.DESC, NullsOrder.LAST)).
                limit(1).
                toObject(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity.class);
    }

    /**
     * 主キーで共同処理用受給者異動償還送付を取得します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param 異動年月日 IdoYMD
     * @return List<DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity> selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動年月日) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3003KyodoShoriyoJukyushaIdoShokanSofu.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(idoYMD, 異動年月日),
                                eq(logicalDeletedFlag, false)))
                .order(by(rirekiNo, Order.DESC)).limit(2).
                toList(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity.class);
    }

    /**
     * count共同処理用受給者異動償還送付テーブルを検索して償還送付情報の異動日を判断します
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 FlexibleDate
     * @return int
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int select償還送付情報の異動日Count(HihokenshaNo 被保険者番号, FlexibleDate 異動日) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3003KyodoShoriyoJukyushaIdoShokanSofu.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(idoYMD, 異動日))).
                getCount();
    }

    /**
     * count共同処理用受給者異動償還送付テーブルを検索して償還送付情報の異動区分を判断します
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動区分 RString
     * @param 異動日 FlexibleDate
     * @return int
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int select償還送付情報の異動区分Count(HihokenshaNo 被保険者番号, RString 異動区分, FlexibleDate 異動日) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動区分, UrSystemErrorMessages.値がnull.getReplacedMessage("異動区分コード"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3003KyodoShoriyoJukyushaIdoShokanSofu.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                lt(idoYMD, 異動日),
                                eq(idoKubunCode, 異動区分))).
                getCount();
    }

    /**
     * 償還送付情報の履歴番号チェック
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 FlexibleDate
     * @return DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity get償還送付情報の履歴番号Max(HihokenshaNo 被保険者番号, FlexibleDate 異動日) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(rirekiNo)).
                table(DbT3003KyodoShoriyoJukyushaIdoShokanSofu.class).
                where(and(eq(hiHokenshaNo, 被保険者番号),
                                eq(idoYMD, 異動日))).
                groupBy(hiHokenshaNo, idoYMD).
                toObject(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity.class);
    }
}
