/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHoho;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHoho.fukaNendo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHoho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHoho.honNenkinCode;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHoho.honNenkinNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHoho.kariNenkinCode;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHoho.kariNenkinNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHoho.rirekiNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHoho.tokuchoTeishiNichiji;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護徴収方法のデータアクセスクラスです。
 *
 * @reamsid_L DBB-1760-010 sunhui
 */
public class DbT2001ChoshuHohoDac implements ISaveable<DbT2001ChoshuHohoEntity> {

    @InjectSession
    private SqlSession session;
    private static final RString メッセージ_基礎年金番号 = new RString("基礎年金番号");
    private static final RString メッセージ_年金コード = new RString("年金コード");

    /**
     * 主キーで介護徴収方法を取得します。
     *
     * @param 賦課年度 FukaNendo
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbT2001ChoshuHohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2001ChoshuHohoEntity selectByKey(
            FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2001ChoshuHoho.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT2001ChoshuHohoEntity.class);
    }

    /**
     * 介護徴収方法を全件返します。
     *
     * @return List<DbT2001ChoshuHohoEntity>
     */
    @Transaction
    public List<DbT2001ChoshuHohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2001ChoshuHoho.class).
                toList(DbT2001ChoshuHohoEntity.class);
    }

    /**
     * 引数の条件に一致する介護徴収方法を取得します。
     *
     * @param 賦課年度 FukaNendo
     * @param 被保険者番号 HihokenshaNo
     * @return DbT2001ChoshuHohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2001ChoshuHohoEntity select(
            FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2001ChoshuHoho.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                eq(hihokenshaNo, 被保険者番号))).
                order(by(rirekiNo, Order.DESC)).
                limit(1).
                toObject(DbT2001ChoshuHohoEntity.class);
    }

    /**
     * DbT2001ChoshuHohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2001ChoshuHohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護徴収方法エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 仮徴収被保険者番号を取得します。
     *
     * @param 基礎年金番号 RString
     * @param 年金コード RString
     * @return DbT2001ChoshuHohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2001ChoshuHohoEntity get仮徴収被保険者番号(RString 基礎年金番号, RString 年金コード) throws NullPointerException {
        requireNonNull(基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_基礎年金番号.toString()));
        requireNonNull(年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_年金コード.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(hihokenshaNo).
                table(DbT2001ChoshuHoho.class).
                where(and(
                                eq(kariNenkinNo, 基礎年金番号),
                                eq(kariNenkinCode, 年金コード))).
                order(by(fukaNendo, Order.DESC), by(rirekiNo, Order.DESC)).
                limit(1).
                toObject(DbT2001ChoshuHohoEntity.class);
    }

    /**
     * 本徴収被保険者番号を取得します。
     *
     * @param 基礎年金番号 RString
     * @param 年金コード RString
     * @return DbT2001ChoshuHohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2001ChoshuHohoEntity get本徴収被保険者番号(RString 基礎年金番号, RString 年金コード) throws NullPointerException {
        requireNonNull(基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_基礎年金番号.toString()));
        requireNonNull(年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_年金コード.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(hihokenshaNo).
                table(DbT2001ChoshuHoho.class).
                where(and(
                                eq(honNenkinNo, 基礎年金番号),
                                eq(honNenkinCode, 年金コード))).
                order(by(fukaNendo, Order.DESC), by(rirekiNo, Order.DESC)).
                limit(1).
                toObject(DbT2001ChoshuHohoEntity.class);
    }

    /**
     * 介護徴収方法を全件返します。
     *
     * @param 賦課年度 FlexibleYear
     * @param 抽出開始日時 RDateTime
     * @param 抽出終了日時 RDateTime
     * @return List<DbT2001ChoshuHohoEntity>
     */
    @Transaction
    public List<DbT2001ChoshuHohoEntity> get徴収方法の異動(FlexibleYear 賦課年度, RDateTime 抽出開始日時,
            RDateTime 抽出終了日時) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2001ChoshuHoho.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                leq(抽出開始日時, tokuchoTeishiNichiji),
                                leq(tokuchoTeishiNichiji, 抽出終了日時))).
                toList(DbT2001ChoshuHohoEntity.class);
    }
}
