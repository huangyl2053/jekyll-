/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyo.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyo.idoKubunCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyo.idoYMD;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyo.jukyushaIdoJiyu;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyo.logicalDeletedFlag;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyo.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyo.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.lt;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者異動送付のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-030 quxiaodong
 */
public class DbT3001JukyushaIdoRenrakuhyoDac implements ISaveable<DbT3001JukyushaIdoRenrakuhyoEntity> {

    @InjectSession
    private SqlSession session;

    private static final boolean 論理削除フラグ = false;
    private static final RString 異動日 = new RString("異動年月日");
    private static final RString 被保険番号 = new RString("被保険者番号");
    private static final RString 履歴号 = new RString("履歴番号");
    private static final int ONE = 1;

    /**
     * 主キーで受給者異動送付を取得します。
     *
     * @param 異動年月日 IdoYMD
     * @param 異動区分コード IdoKubunCode
     * @param 受給者異動事由 JukyushaIdoJiyu
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbT3001JukyushaIdoRenrakuhyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3001JukyushaIdoRenrakuhyoEntity selectByKey(
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
                table(DbT3001JukyushaIdoRenrakuhyo.class).
                where(and(
                                eq(idoYMD, 異動年月日),
                                eq(idoKubunCode, 異動区分コード),
                                eq(jukyushaIdoJiyu, 受給者異動事由),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3001JukyushaIdoRenrakuhyoEntity.class);
    }

    /**
     * 受給者異動送付を全件返します。
     *
     * @return List<DbT3001JukyushaIdoRenrakuhyoEntity>
     */
    @Transaction
    public List<DbT3001JukyushaIdoRenrakuhyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3001JukyushaIdoRenrakuhyo.class).
                toList(DbT3001JukyushaIdoRenrakuhyoEntity.class);
    }

    /**
     * 受給者異動送付を全件返します。
     *
     * @param 被保番号 hiHokenshaNo
     * @param 異動日 idoYMD
     * @return List<DbT3001JukyushaIdoRenrakuhyoEntity>
     */
    @Transaction
    public DbT3001JukyushaIdoRenrakuhyoEntity select登録した受給者異動情報の取得(RString 被保番号, RString 異動日) {
        requireNonNull(被保番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3001JukyushaIdoRenrakuhyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保番号),
                                eq(idoYMD, 異動日),
                                eq(logicalDeletedFlag, 論理削除フラグ),
                                eq(rirekiNo, ONE))).
                toObject(DbT3001JukyushaIdoRenrakuhyoEntity.class);
    }

    /**
     * 受給者異動送付を全件返します。
     *
     * @param 被保険者番号 hiHokenshaNo
     * @param 異動日 idoYMD
     * @return List<DbT3001JukyushaIdoRenrakuhyoEntity>
     */
    @Transaction
    public DbT3001JukyushaIdoRenrakuhyoEntity select異動区分(RString 被保険者番号, RString 異動日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(idoKubunCode).
                table(DbT3001JukyushaIdoRenrakuhyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                lt(idoYMD, 異動日))).
                order(by(DbT3001JukyushaIdoRenrakuhyo.idoYMD, Order.DESC)).
                limit(1).
                toObject(DbT3001JukyushaIdoRenrakuhyoEntity.class);
    }

    /**
     * count受給者異動送付テーブルを検索して既存の異動日を判断します。
     *
     * @param 被保険者番号 hiHokenshaNo
     * @param 異動日 idoYMD
     * @return List<DbT3001JukyushaIdoRenrakuhyoEntity>
     */
    @Transaction
    public int selectCount(RString 被保険者番号, RString 異動日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3001JukyushaIdoRenrakuhyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(idoYMD, 異動日))).
                getCount();
    }

    /**
     * count受給者異動送付テーブルを検索して既存の異動日を判断します。
     *
     * @param 被保険者番号 hiHokenshaNo
     * @param 異動年月日 idoYMD
     * @param 履歴番号 int
     * @param 論理削除フラグ boolean
     * @return DbT3001JukyushaIdoRenrakuhyoEntity
     */
    @Transaction
    public int selectCountByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動年月日,
            int 履歴番号,
            boolean 論理削除フラグ) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険番号.toString()));
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage(異動日.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(履歴号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3001JukyushaIdoRenrakuhyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(idoYMD, 異動年月日),
                                eq(rirekiNo, 履歴番号),
                                eq(logicalDeletedFlag, 論理削除フラグ))).
                getCount();
    }

    /**
     * 受給者異動送付を全件返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動年月日 FlexibleDate
     * @return DbT3001JukyushaIdoRenrakuhyoEntity
     */
    @Transaction
    public DbT3001JukyushaIdoRenrakuhyoEntity selectAllByTwoKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動年月日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3001JukyushaIdoRenrakuhyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(idoYMD, 異動年月日))).
                order(by(DbT3001JukyushaIdoRenrakuhyo.rirekiNo, Order.DESC)).
                limit(1).
                toObject(DbT3001JukyushaIdoRenrakuhyoEntity.class);
    }

    /**
     * 被保険者番号が一致して、異動年月日単位にMAX（履歴番号）であって、かつ、MAX（履歴番号） である情報のみ対象とする。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動年月日 FlexibleDate
     * @return DbT3001JukyushaIdoRenrakuhyoEntity
     */
    @Transaction
    public DbT3001JukyushaIdoRenrakuhyoEntity selectMaxRirekiNoByMaxIdoYMD(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動年月日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険番号.toString()));
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage(異動日.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(rirekiNo), idoYMD).
                table(DbT3001JukyushaIdoRenrakuhyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                lt(idoYMD, 異動年月日),
                                eq(logicalDeletedFlag, false))).
                groupBy(idoYMD).
                toObject(DbT3001JukyushaIdoRenrakuhyoEntity.class);
    }

    /**
     * 被保険者番号が一致して、異動年月日単位にMAX（履歴番号）であって、かつ、MAX（履歴番号） である情報のみ対象とする。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動年月日 FlexibleDate
     * @return DbT3001JukyushaIdoRenrakuhyoEntity
     */
    @Transaction
    public DbT3001JukyushaIdoRenrakuhyoEntity selectMaxRirekiNoByMinIdoYMD(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動年月日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険番号.toString()));
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage(異動日.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(rirekiNo), idoYMD).
                table(DbT3001JukyushaIdoRenrakuhyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                lt(異動年月日, idoYMD),
                                eq(logicalDeletedFlag, false))).
                groupBy(idoYMD).
                toObject(DbT3001JukyushaIdoRenrakuhyoEntity.class);
    }

    /**
     * DbT3001JukyushaIdoRenrakuhyoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3001JukyushaIdoRenrakuhyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者異動送付エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 受給者訂正情報の取得します。
     *
     * @param 被保険者番号 RString
     * @param 異動日 RString
     * @param 論理削除フラグ boolean
     * @param 履歴番号 int
     * @return List<DbT3001JukyushaIdoRenrakuhyoEntity>
     */
    @Transaction
    public DbT3001JukyushaIdoRenrakuhyoEntity select受給者訂正情報(RString 被保険者番号, RString 異動日,
            boolean 論理削除フラグ, int 履歴番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3001JukyushaIdoRenrakuhyo.class).
                where(getiTrueFalseCriteria(被保険者番号, 異動日, 論理削除フラグ, 履歴番号)).
                toObject(DbT3001JukyushaIdoRenrakuhyoEntity.class);
    }

    private ITrueFalseCriteria getiTrueFalseCriteria(RString 被保険者番号, RString 異動日,
            boolean 論理削除フラグ, int 履歴番号) {
        ITrueFalseCriteria iTrueFalseCriteria;
        if (被保険者番号 != null && 異動日 != null) {
            iTrueFalseCriteria = and(
                    eq(hiHokenshaNo, 被保険者番号),
                    eq(idoYMD, 異動日),
                    eq(logicalDeletedFlag, 論理削除フラグ),
                    eq(rirekiNo, 履歴番号));
        } else if (被保険者番号 != null && 異動日 == null) {
            iTrueFalseCriteria = and(
                    eq(hiHokenshaNo, 被保険者番号),
                    eq(logicalDeletedFlag, 論理削除フラグ),
                    eq(rirekiNo, 履歴番号));

        } else if (被保険者番号 == null && 異動日 != null) {
            iTrueFalseCriteria = and(
                    eq(idoYMD, 異動日),
                    eq(logicalDeletedFlag, 論理削除フラグ),
                    eq(rirekiNo, 履歴番号));
        } else {
            iTrueFalseCriteria = and(
                    eq(logicalDeletedFlag, 論理削除フラグ),
                    eq(rirekiNo, 履歴番号));
        }
        return iTrueFalseCriteria;
    }
}
