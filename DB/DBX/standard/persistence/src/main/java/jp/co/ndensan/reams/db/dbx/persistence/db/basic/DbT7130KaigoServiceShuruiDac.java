/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShurui;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShurui.serviceBunrruicode;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShurui.serviceShuruiCd;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShurui.serviceShuruiMeisho;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShurui.teikyoKaishiYM;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShurui.teikyoshuryoYM;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.in;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護サービス種類のデータアクセスクラスです。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
public class DbT7130KaigoServiceShuruiDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護サービス種類を取得します。
     *
     * @param サービス種類コード ServiceShuruiCd
     * @param 提供開始年月 TeikyoKaishiYM
     * @return DbT7130KaigoServiceShuruiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7130KaigoServiceShuruiEntity selectByKey(
            ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 提供開始年月) throws NullPointerException {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(and(
                                eq(serviceShuruiCd, サービス種類コード),
                                eq(teikyoKaishiYM, 提供開始年月))).
                toObject(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * 介護サービス種類を全件返します。
     *
     * @return List<DbT7130KaigoServiceShuruiEntity>
     */
    @Transaction
    public List<DbT7130KaigoServiceShuruiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                toList(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * 介護サービス種類を全件返します。
     *
     * @return List<DbT7130KaigoServiceShuruiEntity>
     */
    @Transaction
    public List<DbT7130KaigoServiceShuruiEntity> selectサービス種類登録() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                order(by(DbT7130KaigoServiceShurui.serviceShuruiCd, Order.ASC),
                        by(DbT7130KaigoServiceShurui.teikyoKaishiYM, Order.DESC)).
                toList(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * DbT7130KaigoServiceShuruiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save(DbT7130KaigoServiceShuruiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 主キーで介護サービス種類を取得します。
     *
     * @param makeShuruiCondition makeShuruiCondition
     * @return DbT7130KaigoServiceShuruiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7130KaigoServiceShuruiEntity> select(
            ITrueFalseCriteria makeShuruiCondition) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(makeShuruiCondition).order(by(DbT7130KaigoServiceShurui.serviceShuruiCd, Order.ASC)).
                toList(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * 主キーで介護サービス種類を取得します。
     *
     * @param サービス種類コード サービス種類コード
     * @param 提供開始年月 提供開始年月
     * @return DbT7130KaigoServiceShuruiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7130KaigoServiceShuruiEntity> selectByDate(
            ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 提供開始年月) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(and(eq(DbT7130KaigoServiceShurui.serviceShuruiCd, サービス種類コード),
                                leq(DbT7130KaigoServiceShurui.teikyoKaishiYM, 提供開始年月),
                                leq(提供開始年月, DbT7130KaigoServiceShurui.teikyoshuryoYM))).
                toList(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * 主キーで介護サービス種類を取得します。
     *
     * @param サービス種類コード サービス種類コード
     * @return DbT7130KaigoServiceShuruiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7130KaigoServiceShuruiEntity> selectByShuruiCode(
            ServiceShuruiCode サービス種類コード) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(eq(DbT7130KaigoServiceShurui.serviceShuruiCd, サービス種類コード)).
                toList(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * 介護サービス種類を全件返します。
     *
     * @param makeShuruiConditions ITrueFalseCriteria
     * @return List<DbT7130KaigoServiceShuruiEntity>
     */
    @Transaction
    public List<DbT7130KaigoServiceShuruiEntity> selectServiceShurui(ITrueFalseCriteria makeShuruiConditions) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(makeShuruiConditions).
                toList(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * サービス種類名称Andサービス種類略称を取得します。
     *
     * @param サービス種類 サービス種類
     * @return DbT7130KaigoServiceShuruiEntity
     */
    @Transaction
    public DbT7130KaigoServiceShuruiEntity getサービス種類名称Andサービス種類略称(RString サービス種類) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(and(eq(serviceShuruiCd, サービス種類),
                                leq(teikyoKaishiYM, RDate.getNowDate().getYearMonth()),
                                or(leq(RDate.getNowDate().getYearMonth(), teikyoshuryoYM), isNULL(teikyoshuryoYM)))).
                toObject(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * サービス種類名称とサービス種類略称を取得します。
     *
     * @param サービス種類 サービス種類
     * @param 提供開始年月 FlexibleYearMonth
     * @return DbT7130KaigoServiceShuruiEntity
     */
    @Transaction
    public DbT7130KaigoServiceShuruiEntity selectサービス種類名称Andサービス種類略称(RString サービス種類,
            FlexibleYearMonth 提供開始年月) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(and(eq(serviceShuruiCd, サービス種類),
                                leq(teikyoKaishiYM, 提供開始年月),
                                or(leq(提供開始年月, teikyoshuryoYM), isNULL(teikyoshuryoYM)))).
                toObject(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * 給付種類を取得します。
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス提供年月 サービス提供年月
     * @return DbT7130KaigoServiceShuruiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7130KaigoServiceShuruiEntity select給付種類(
            ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth サービス提供年月) throws NullPointerException {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(and(eq(DbT7130KaigoServiceShurui.serviceShuruiCd, サービス種類コード),
                                leq(DbT7130KaigoServiceShurui.teikyoKaishiYM, サービス提供年月),
                                or(leq(サービス提供年月, DbT7130KaigoServiceShurui.teikyoshuryoYM),
                                        isNULL(DbT7130KaigoServiceShurui.teikyoshuryoYM))))
                .toObject(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * サービス種類コードと名称を取得します。
     *
     * @return List<DbT7130KaigoServiceShuruiEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7130KaigoServiceShuruiEntity> getサービス種類コードと名称() throws NullPointerException {

        List<Code> list = new ArrayList<>();
        list.add(new Code(ServiceBunrui.総合事業.getコード()));
        list.add(new Code(ServiceBunrui.ケアマネジメント.getコード()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                selectSpecific(serviceShuruiCd, serviceShuruiMeisho).
                table(DbT7130KaigoServiceShurui.class).
                where(and(
                                isNULL(teikyoshuryoYM),
                                in(serviceBunrruicode, list))).
                order(by(DbT7130KaigoServiceShurui.serviceShuruiCd, Order.ASC)).
                toList(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * サービス種類支給限度額を全件返します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 適用期間From FlexibleYearMonth
     * @throws NullPointerException 引数のいずれかがnullの場合
     * @return List<DbT7130KaigoServiceShuruiEntity>
     */
    @Transaction
    public List<DbT7130KaigoServiceShuruiEntity> select介護サービス種類データ(
            ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 適用期間From) throws NullPointerException {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(適用期間From, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(and(
                                eq(serviceShuruiCd, サービス種類コード),
                                leq(serviceShuruiCd, 適用期間From)
                        )).
                order(by(DbT7130KaigoServiceShurui.serviceShuruiCd, Order.DESC)).
                toList(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * サービス種類名称Listを取得します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return List<DbT7130KaigoServiceShuruiEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7130KaigoServiceShuruiEntity> getサービス種類名称List(
            FlexibleYearMonth サービス提供年月) throws NullPointerException {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(and(
                                leq(DbT7130KaigoServiceShurui.teikyoKaishiYM, サービス提供年月),
                                leq(サービス提供年月, DbT7130KaigoServiceShurui.teikyoshuryoYM)
                        ))
                .toList(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * キーで介護サービス内容を取得します。
     *
     * @param list List<ServiceShuruiCode>
     * @return DbT7131KaigoServiceNaiyouEntity
     */
    @Transaction
    public DbT7130KaigoServiceShuruiEntity select介護サービス(List<ServiceShuruiCode> list) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(
                        in(serviceShuruiCd, list)).
                order(by(serviceShuruiCd, Order.ASC)).limit(1).
                toObject(DbT7130KaigoServiceShuruiEntity.class);
    }
}
