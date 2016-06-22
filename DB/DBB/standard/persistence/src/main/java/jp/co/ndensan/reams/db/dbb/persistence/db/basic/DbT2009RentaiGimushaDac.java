/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2009RentaiGimusha;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2009RentaiGimusha.endYMD;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2009RentaiGimusha.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2009RentaiGimusha.rirekiNo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2009RentaiGimusha.shikibetuCode;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2009RentaiGimusha.startYMD;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 連帯納付義務者のデータアクセスクラスです。
 *
 * @reamsid_L DBB-1640-020 lijunjun
 */
public class DbT2009RentaiGimushaDac implements ISaveable<DbT2009RentaiGimushaEntity> {

    private static final RString MSG_被保険者番号 = new RString("被保険者番号");

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで連帯納付義務者を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbT2009RentaiGimushaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2009RentaiGimushaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2009RentaiGimusha.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT2009RentaiGimushaEntity.class);
    }

    /**
     * 最新の連帯納付義務者を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return DbT2009RentaiGimushaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2009RentaiGimushaEntity selectBy最新連帯納付義務者(
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_被保険者番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2009RentaiGimusha.class).
                where(eq(hihokenshaNo, 被保険者番号)).
                order(by(rirekiNo, Order.DESC)).
                limit(1).
                toObject(DbT2009RentaiGimushaEntity.class);
    }

    /**
     * 連帯納付義務者宛名情報リストを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return DbT2009RentaiGimushaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT2009RentaiGimushaEntity> selectBy連帯納付義務者宛名情報リスト(
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_被保険者番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2009RentaiGimusha.class).
                where(eq(hihokenshaNo, 被保険者番号)).
                order(by(rirekiNo, Order.ASC)).
                toList(DbT2009RentaiGimushaEntity.class);
    }

    /**
     * 連帯納付義務者宛名情報_削除を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 Decimal
     * @param 識別コード ShikibetsuCode
     * @param 開始年月日 FlexibleDate
     * @param 終了年月日 FlexibleDate
     * @return 連帯納付義務者宛名情報
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2009RentaiGimushaEntity selectBy連帯納付義務者宛名情報_削除(
            HihokenshaNo 被保険者番号, Decimal 履歴番号, ShikibetsuCode 識別コード,
            FlexibleDate 開始年月日, FlexibleDate 終了年月日) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_被保険者番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2009RentaiGimusha.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号),
                                eq(shikibetuCode, 識別コード),
                                eq(startYMD, 開始年月日),
                                eq(endYMD, 終了年月日)))
                .toObject(DbT2009RentaiGimushaEntity.class);
    }

    /**
     * selectBy連帯納付義務者_履歴番号
     *
     * @param 被保険者番号 HihokenshaNo
     * @return DbT2009RentaiGimushaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2009RentaiGimushaEntity selectBy連帯納付義務者_履歴番号(
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_被保険者番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2009RentaiGimusha.class).
                where(
                        eq(hihokenshaNo, 被保険者番号))
                .order(by(rirekiNo, Order.DESC)).limit(1)
                .toObject(DbT2009RentaiGimushaEntity.class);
    }

    /**
     * 連帯納付義務者を全件返します。
     *
     * @return List<DbT2009RentaiGimushaEntity>
     */
    @Transaction
    public List<DbT2009RentaiGimushaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2009RentaiGimusha.class).
                toList(DbT2009RentaiGimushaEntity.class);
    }

    /**
     * DbT2009RentaiGimushaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2009RentaiGimushaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("連帯納付義務者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
//        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT2009RentaiGimushaEntityをdeleteします。
     *
     * @param entity DbT2009RentaiGimushaEntity
     * @return delete件数
     */
    @Transaction
    public int delete(DbT2009RentaiGimushaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("連帯納付義務者エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
