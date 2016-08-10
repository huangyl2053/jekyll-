/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokurei;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokurei.edaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokurei.idoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokurei.kaijoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokurei.logicalDeletedFlag;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokurei.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokurei.tekiyoYMD;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 他市町村住所地特例のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-021 linghuhang
 */
public class DbT1003TashichosonJushochiTokureiDac implements ISaveable<DbT1003TashichosonJushochiTokureiEntity> {

    private static final RString 識別コード_TMP = new RString("識別コード");
    @InjectSession
    private SqlSession session;

    /**
     * 主キーで他市町村住所地特例を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 異動日 IdoYMD
     * @param 枝番 EdaNo
     * @return DbT1003TashichosonJushochiTokureiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1003TashichosonJushochiTokureiEntity selectByKey(
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1003TashichosonJushochiTokurei.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(idoYMD, 異動日),
                                eq(edaNo, 枝番))).
                toObject(DbT1003TashichosonJushochiTokureiEntity.class);
    }

    /**
     * 他市町村住所地特例を全件返します。
     *
     * @return List<DbT1003TashichosonJushochiTokureiEntity>
     */
    @Transaction
    public List<DbT1003TashichosonJushochiTokureiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1003TashichosonJushochiTokurei.class).
                toList(DbT1003TashichosonJushochiTokureiEntity.class);
    }

    /**
     * DbT1003TashichosonJushochiTokureiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT1003TashichosonJushochiTokureiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 最大枝番を取得です。
     *
     * @return 最大枝番
     */
    @Transaction
    public DbT1003TashichosonJushochiTokureiEntity selectEdaNoMax() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(edaNo)).
                table(DbT1003TashichosonJushochiTokurei.class).toObject(DbT1003TashichosonJushochiTokureiEntity.class);
    }

    /**
     * 識別コードと異動日により、最大枝番を取得です。
     *
     * @param 識別コード 識別コード
     * @param 異動日 異動日
     * @return 最大枝番
     */
    @Transaction
    public DbT1003TashichosonJushochiTokureiEntity get最大枝番(ShikibetsuCode 識別コード, FlexibleDate 異動日) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(edaNo)).
                table(DbT1003TashichosonJushochiTokurei.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(idoYMD, 異動日))).
                toObject(DbT1003TashichosonJushochiTokureiEntity.class);
    }

    /**
     * 他市町村住所地特例で異動日のレコード中で最大の枝番を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return DbT1003TashichosonJushochiTokureiEntity
     */
    @Transaction
    public DbT1003TashichosonJushochiTokureiEntity selectMaxByKey(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1003TashichosonJushochiTokurei.class).
                where(
                        eq(shikibetsuCode, 識別コード)).
                order(by(idoYMD, Order.DESC), by(edaNo, Order.DESC)).
                limit(1).
                toObject(DbT1003TashichosonJushochiTokureiEntity.class);
    }

    /**
     * 訂正対象の履歴を取得します。
     *
     * @param 識別コード 識別コード
     * @param 適用年月日 適用年月日
     * @return List<DbT1003TashichosonJushochiTokureiEntity>
     */
    @Transaction
    public List<DbT1003TashichosonJushochiTokureiEntity> get訂正対象の履歴(ShikibetsuCode 識別コード,
            FlexibleDate 適用年月日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード_TMP.toString()));
        requireNonNull(適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1003TashichosonJushochiTokurei.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(DbT1003TashichosonJushochiTokurei.tekiyoYMD, 適用年月日),
                                eq(DbT1003TashichosonJushochiTokurei.isDeleted, false))).
                toList(DbT1003TashichosonJushochiTokureiEntity.class);
    }

    /**
     * 他市町村住所地特例を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 年齢到達日 年齢到達日
     * @param 論理削除フラグ
     * @return List<DbT1003TashichosonJushochiTokureiEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1003TashichosonJushochiTokureiEntity> select他市町村住所地特例(
            ShikibetsuCode 識別コード,
            FlexibleDate 年齢到達日,
            boolean 論理削除フラグ) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(年齢到達日, UrSystemErrorMessages.値がnull.getReplacedMessage("年齢到達日"));
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1003TashichosonJushochiTokurei.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                (or(
                                        and(leq(tekiyoYMD, 年齢到達日), leq(年齢到達日, kaijoYMD)),
                                        and(leq(tekiyoYMD, 年齢到達日), leq(kaijoYMD, null)))),
                                eq(logicalDeletedFlag, 論理削除フラグ))).
                toList(DbT1003TashichosonJushochiTokureiEntity.class);
    }

}
