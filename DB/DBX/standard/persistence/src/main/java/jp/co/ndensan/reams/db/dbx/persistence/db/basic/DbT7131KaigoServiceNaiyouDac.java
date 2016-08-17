/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyou;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyou.rirekiNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyou.serviceKoumokuCd;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyou.serviceShuruiCd;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyou.teikyoKaishiYM;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyou.teikyoShuryoYM;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * 介護サービス内容のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 xicongwang
 */
public class DbT7131KaigoServiceNaiyouDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護サービス内容を取得します。
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     * @param 提供開始年月 提供開始年月
     * @param 履歴番号 履歴番号
     * @return DbT7131KaigoServiceNaiyouEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7131KaigoServiceNaiyouEntity selectByKey(
            ServiceShuruiCode サービス種類コード,
            RString サービス項目コード,
            FlexibleYearMonth 提供開始年月,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7131KaigoServiceNaiyou.class).
                where(and(
                                eq(serviceShuruiCd, サービス種類コード),
                                eq(serviceKoumokuCd, サービス項目コード),
                                eq(teikyoKaishiYM, 提供開始年月),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT7131KaigoServiceNaiyouEntity.class);
    }

    /**
     * 介護サービス内容を全件返します。
     *
     * @return DbT7131KaigoServiceNaiyouEntityの{@code list}
     */
    @Transaction
    public List<DbT7131KaigoServiceNaiyouEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7131KaigoServiceNaiyou.class).
                toList(DbT7131KaigoServiceNaiyouEntity.class);
    }

    /**
     * DbT7131KaigoServiceNaiyouEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save(DbT7131KaigoServiceNaiyouEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス内容エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * サービスコードのフォーカスアウトです。
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     * @param 提供開始年月 提供開始年月
     * @return DbT7131KaigoServiceNaiyouEntity
     * @throws NullPointerException NullPointerException
     */
    public List<DbT7131KaigoServiceNaiyouEntity> getサービス内容(ServiceShuruiCode サービス種類コード,
            RString サービス項目コード, FlexibleYearMonth 提供開始年月) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7131KaigoServiceNaiyou.class).
                where(and(eq(DbT7131KaigoServiceNaiyou.serviceShuruiCd, サービス種類コード),
                                eq(DbT7131KaigoServiceNaiyou.serviceKoumokuCd, サービス項目コード),
                                leq(DbT7131KaigoServiceNaiyou.teikyoKaishiYM, 提供開始年月),
                                leq(提供開始年月, DbT7131KaigoServiceNaiyou.teikyoShuryoYM))).
                toList(DbT7131KaigoServiceNaiyouEntity.class);

    }

    /**
     * サービスコードのフォーカスアウトです。
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     * @return List<DbT7131KaigoServiceNaiyouEntity>
     * @throws NullPointerException NullPointerException
     */
    public List<DbT7131KaigoServiceNaiyouEntity> getサービス情報(ServiceShuruiCode サービス種類コード,
            RString サービス項目コード) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7131KaigoServiceNaiyou.class).
                where(and(eq(DbT7131KaigoServiceNaiyou.serviceShuruiCd, サービス種類コード),
                                eq(DbT7131KaigoServiceNaiyou.serviceKoumokuCd, サービス項目コード))).
                toList(DbT7131KaigoServiceNaiyouEntity.class);
    }

    /**
     * キーで介護サービス内容を取得します。
     *
     * @param サービス年月 サービス年月
     * @return DbT7131KaigoServiceNaiyouEntity
     */
    @Transaction
    public DbT7131KaigoServiceNaiyouEntity select介護サービス(FlexibleYearMonth サービス年月) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7131KaigoServiceNaiyou.class).
                where(and(
                                eq(serviceShuruiCd, new KaigoServiceShuruiCode("50")),
                                eq(serviceKoumokuCd, new RString("9901")),
                                leq(teikyoKaishiYM, サービス年月),
                                leq(サービス年月, teikyoShuryoYM))).
                order(by(rirekiNo, Order.DESC)).limit(1).
                toObject(DbT7131KaigoServiceNaiyouEntity.class);
    }

    /**
     * サービスコード情報取得
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     * @param 基準年月 基準年月
     * @return List<DbT7131KaigoServiceNaiyouEntity>
     */
    @Transaction
    public List<DbT7131KaigoServiceNaiyouEntity> selectサービスコード情報(
            KaigoServiceShuruiCode サービス種類コード,
            RString サービス項目コード,
            FlexibleYearMonth 基準年月) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7131KaigoServiceNaiyou.class).
                where(and(
                                eq(serviceShuruiCd, サービス種類コード),
                                eq(serviceKoumokuCd, サービス項目コード),
                                leq(teikyoKaishiYM, 基準年月),
                                leq(基準年月, teikyoShuryoYM)))
                .order(by(serviceShuruiCd, Order.ASC), by(serviceKoumokuCd, Order.ASC))
                .toList(DbT7131KaigoServiceNaiyouEntity.class);
    }
}
