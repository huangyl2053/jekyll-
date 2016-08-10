/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyosha;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyosha.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyosha.yukoKaishiYMD;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 quxiaodong
 */
public class DbT7060KaigoJigyoshaDac implements ISaveable<DbT7060KaigoJigyoshaEntity> {

    private static final RString TXT事業者番号 = new RString("事業者番号");
    private static final RString TXT介護事業者エンティティ = new RString("介護事業者エンティティ");
    private static final RString TXTシステム日付 = new RString("システム日付");
    private static final RString TXT日付 = new RString("日付");
    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護事業者を取得します。
     *
     * @param 事業者番号 JigyoshaNo
     * @param 有効開始日 YukoKaishiYMD
     * @return DbT7060KaigoJigyoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7060KaigoJigyoshaEntity selectByKey(
            JigyoshaNo 事業者番号,
            FlexibleDate 有効開始日) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT事業者番号.toString()));
        requireNonNull(有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7060KaigoJigyosha.class).
                where(and(
                                eq(jigyoshaNo, 事業者番号),
                                eq(yukoKaishiYMD, 有効開始日))).
                toObject(DbT7060KaigoJigyoshaEntity.class);
    }

    /**
     * 介護事業者を全件返します。
     *
     * @return List<DbT7060KaigoJigyoshaEntity>
     */
    @Transaction
    public List<DbT7060KaigoJigyoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7060KaigoJigyosha.class).
                toList(DbT7060KaigoJigyoshaEntity.class);
    }

    /**
     * DbT7060KaigoJigyoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7060KaigoJigyoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT介護事業者エンティティ.toString()));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT7060KaigoJigyoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int saveOrDeletePhysicalBy(DbT7060KaigoJigyoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT介護事業者エンティティ.toString()));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 入所施設名称の取得。
     *
     * @param 事業者番号 JigyoshaNo
     * @return List<DbT7060KaigoJigyoshaEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7060KaigoJigyoshaEntity> select介護事業者(
            JigyoshaNo 事業者番号) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT事業者番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7060KaigoJigyosha.class).
                where(eq(DbT7060KaigoJigyosha.jigyoshaNo, 事業者番号)).
                order(by(yukoKaishiYMD, Order.DESC)).limit(1).
                toList(DbT7060KaigoJigyoshaEntity.class);
    }

    /**
     * 事業者名称の取得。
     *
     * @param 事業者番号 JigyoshaNo
     * @param 日付 FlexibleDate
     * @return List<DbT7060KaigoJigyoshaEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7060KaigoJigyoshaEntity select事業者の名称(
            JigyoshaNo 事業者番号,
            FlexibleDate 日付) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT事業者番号.toString()));
        requireNonNull(日付, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT日付.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7060KaigoJigyosha.class).
                where(and(
                                eq(DbT7060KaigoJigyosha.jigyoshaNo, 事業者番号),
                                leq(DbT7060KaigoJigyosha.yukoKaishiYMD, 日付),
                                or(leq(日付, DbT7060KaigoJigyosha.yukoShuryoYMD), isNULL(DbT7060KaigoJigyosha.yukoShuryoYMD))))
                .order(by(DbT7060KaigoJigyosha.yukoKaishiYMD, Order.DESC)).limit(1)
                .toObject(DbT7060KaigoJigyoshaEntity.class);
    }

    /**
     * 有効開始日が最新データの事業者名称の取得。
     *
     * @param 事業者番号 KaigoJigyoshaNo
     * @return List<DbT7060KaigoJigyoshaEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7060KaigoJigyoshaEntity> select事業者名称(JigyoshaNo 事業者番号) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT事業者番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7060KaigoJigyosha.class).
                where(eq(DbT7060KaigoJigyosha.jigyoshaNo, 事業者番号)).
                order(by(DbT7060KaigoJigyosha.yukoKaishiYMD, Order.DESC)).
                toList(DbT7060KaigoJigyoshaEntity.class);
    }

    /**
     * 事業者名称の取得。
     *
     * @param 事業者番号 JigyoshaNo
     * @param システム日付 FlexibleDate
     * @return DbT7060KaigoJigyoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public DbT7060KaigoJigyoshaEntity select事業者名称(JigyoshaNo 事業者番号,
            FlexibleDate システム日付) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT事業者番号.toString()));
        requireNonNull(システム日付, UrSystemErrorMessages.値がnull.getReplacedMessage(TXTシステム日付.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7060KaigoJigyosha.class).
                where(and(
                                eq(DbT7060KaigoJigyosha.jigyoshaNo, 事業者番号),
                                leq(DbT7060KaigoJigyosha.yukoKaishiYMD, システム日付),
                                eq(DbT7060KaigoJigyosha.isDeleted, false)))
                .order(by(DbT7060KaigoJigyosha.yukoKaishiYMD, Order.DESC)).limit(1)
                .toObject(DbT7060KaigoJigyoshaEntity.class);
    }

    /**
     * 入所施設名称の取得。
     *
     * @param 事業者番号 JigyoshaNo
     * @param システム日付 FlexibleDate
     * @return List<DbT7060KaigoJigyoshaEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7060KaigoJigyoshaEntity> select介護事業者(
            JigyoshaNo 事業者番号,
            FlexibleDate システム日付) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT事業者番号.toString()));
        requireNonNull(システム日付, UrSystemErrorMessages.値がnull.getReplacedMessage(TXTシステム日付.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7060KaigoJigyosha.class).
                where(and(
                                eq(DbT7060KaigoJigyosha.jigyoshaNo, 事業者番号),
                                leq(DbT7060KaigoJigyosha.yukoKaishiYMD, システム日付),
                                or(leq(システム日付, DbT7060KaigoJigyosha.yukoShuryoYMD), isNULL(DbT7060KaigoJigyosha.yukoShuryoYMD)))).
                toList(DbT7060KaigoJigyoshaEntity.class);
    }

    /**
     * 事業者名称の取得。
     *
     * @param 適用開始日 FlexibleDate
     * @param 事業者番号 JigyoshaNo
     * @return DbT7060KaigoJigyoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public DbT7060KaigoJigyoshaEntity select_事業者名称(FlexibleDate 適用開始日, JigyoshaNo 事業者番号
    ) throws NullPointerException {
        requireNonNull(適用開始日, UrSystemErrorMessages.値がnull.getReplacedMessage(適用開始日.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業者番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7060KaigoJigyosha.class).
                where(and(
                                eq(DbT7060KaigoJigyosha.jigyoshaNo, 事業者番号),
                                or(and(leq(DbT7060KaigoJigyosha.yukoKaishiYMD, 適用開始日), leq(適用開始日, DbT7060KaigoJigyosha.yukoShuryoYMD)),
                                        and(leq(DbT7060KaigoJigyosha.yukoKaishiYMD, 適用開始日), isNULL(DbT7060KaigoJigyosha.yukoShuryoYMD))
                                ))
                ).toObject(DbT7060KaigoJigyoshaEntity.class);

    }
}
