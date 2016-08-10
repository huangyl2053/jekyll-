/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiService;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiService.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiService.serviceShuruiCode;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiService.yukoKaishiYMD;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiService.yukoShuryoYMD;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
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
 * 介護事業者指定サービスのデータアクセスクラスです。
 *
 * @reamsid_L DBX-9999-021 wanghui
 */
public class DbT7063KaigoJigyoshaShiteiServiceDac implements ISaveable<DbT7063KaigoJigyoshaShiteiServiceEntity> {

    @InjectSession
    private SqlSession session;
    private static final RString 事業者の番号 = new RString("事業者番号");
    private static final RString サービスの種類コード = new RString("サービス種類コード");
    private static final RString 有効の開始日 = new RString("有効開始日");
    private static final RString 有効の日 = new RString("有効日");
    private static final RString 介護事業者指定サービス = new RString("介護事業者指定サービス");

    /**
     * 主キーで介護事業者指定サービスを取得します。
     *
     * @param 事業者番号 JigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @param 有効開始日 YukoKaishiYMD
     * @return DbT7063KaigoJigyoshaShiteiServiceEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7063KaigoJigyoshaShiteiServiceEntity selectByKey(
            JigyoshaNo 事業者番号,
            ServiceShuruiCode サービス種類コード,
            FlexibleDate 有効開始日) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業者の番号.toString()));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サービスの種類コード.toString()));
        requireNonNull(有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage(有効の開始日.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7063KaigoJigyoshaShiteiService.class).
                where(and(
                                eq(jigyoshaNo, 事業者番号),
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(yukoKaishiYMD, 有効開始日))).
                toObject(DbT7063KaigoJigyoshaShiteiServiceEntity.class);
    }

    /**
     * 介護事業者指定サービスを全件返します。
     *
     * @return List<DbT7063KaigoJigyoshaShiteiServiceEntity>
     */
    @Transaction
    public List<DbT7063KaigoJigyoshaShiteiServiceEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7063KaigoJigyoshaShiteiService.class).
                toList(DbT7063KaigoJigyoshaShiteiServiceEntity.class);
    }

    /**
     * DbT7063KaigoJigyoshaShiteiServiceEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7063KaigoJigyoshaShiteiServiceEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(介護事業者指定サービス.toString()));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 事業者番号で介護事業者指定サービスを取得します。
     *
     * @param 事業者番号 JigyoshaNo
     * @return List<DbT7063KaigoJigyoshaShiteiServiceEntity>
     */
    public List<DbT7063KaigoJigyoshaShiteiServiceEntity> selectBy事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業者の番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7063KaigoJigyoshaShiteiService.class).
                where(eq(jigyoshaNo, 事業者番号)).
                toList(DbT7063KaigoJigyoshaShiteiServiceEntity.class);
    }

    /**
     * 主キーで介護事業者指定サービスを取得します。
     *
     * @param 事業者番号 JigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @param 有効開始日 YukoKaishiYMD
     * @return DbT7063KaigoJigyoshaShiteiServiceEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7063KaigoJigyoshaShiteiServiceEntity> select事業者サービス(
            RString 事業者番号,
            RString サービス種類コード,
            FlexibleDate 有効開始日) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業者の番号.toString()));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サービスの種類コード.toString()));
        requireNonNull(有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage(有効の開始日.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7063KaigoJigyoshaShiteiService.class).
                where(and(
                                eq(jigyoshaNo, 事業者番号),
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(yukoKaishiYMD, 有効開始日)))
                .toList(DbT7063KaigoJigyoshaShiteiServiceEntity.class);
    }

    /**
     * 主キーで介護事業者指定サービスを取得します。
     *
     * @param 事業者番号 JigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @param 有効日 YukoKaishiYMD
     * @return DbT7063KaigoJigyoshaShiteiServiceEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7063KaigoJigyoshaShiteiServiceEntity select事業者名称(
            RString 事業者番号,
            RString サービス種類コード,
            FlexibleDate 有効日) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業者の番号.toString()));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サービスの種類コード.toString()));
        requireNonNull(有効日, UrSystemErrorMessages.値がnull.getReplacedMessage(有効の日.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7063KaigoJigyoshaShiteiService.class).
                where(and(
                                eq(jigyoshaNo, 事業者番号),
                                leq(DbT7063KaigoJigyoshaShiteiService.yukoKaishiYMD, 有効日),
                                or(leq(有効日, DbT7063KaigoJigyoshaShiteiService.yukoShuryoYMD),
                                        isNULL(DbT7063KaigoJigyoshaShiteiService.yukoShuryoYMD)),
                                eq(serviceShuruiCode, サービス種類コード))).
                order(by(DbT7063KaigoJigyoshaShiteiService.yukoKaishiYMD, Order.DESC)).limit(1).
                toObject(DbT7063KaigoJigyoshaShiteiServiceEntity.class);
    }

    /**
     * 主キーで介護事業者指定サービスを削除します。
     *
     * @param entity 介護事業者指定サービス
     * @return 削除件数
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int delete(DbT7063KaigoJigyoshaShiteiServiceEntity entity) throws NullPointerException {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(介護事業者指定サービス.toString()));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 事業者名称の取得。
     *
     * @param 適用開始日 FlexibleDate
     * @param 事業者番号 JigyoshaNo
     * @return DbT7063KaigoJigyoshaShiteiServiceEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public DbT7063KaigoJigyoshaShiteiServiceEntity select_事業者名称(FlexibleDate 適用開始日, JigyoshaNo 事業者番号
    ) throws NullPointerException {
        requireNonNull(適用開始日, UrSystemErrorMessages.値がnull.getReplacedMessage(適用開始日.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業者番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7063KaigoJigyoshaShiteiService.class).
                where(and(
                                eq(jigyoshaNo, 事業者番号),
                                or(and(leq(yukoKaishiYMD, 適用開始日),
                                                leq(適用開始日, yukoShuryoYMD)),
                                        and(leq(yukoKaishiYMD, 適用開始日),
                                                isNULL(yukoShuryoYMD))),
                                or(eq(serviceShuruiCode, "43"),
                                        eq(serviceShuruiCode, " 46"))
                        )
                ).toObject(DbT7063KaigoJigyoshaShiteiServiceEntity.class);

    }
}
