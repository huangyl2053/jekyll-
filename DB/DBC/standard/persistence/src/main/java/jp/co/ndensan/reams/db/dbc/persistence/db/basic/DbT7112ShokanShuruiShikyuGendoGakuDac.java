/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyosha.rirekiNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7112ShokanShuruiShikyuGendoGaku;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7112ShokanShuruiShikyuGendoGaku.shikyuGendoTaniSu;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7112ShokanShuruiShikyuGendoGaku.tekiyoShuryoYM;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7112ShokanShuruiShikyuGendoGakuEntity;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7119ServiceCode.serviceShuruiCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7119ServiceCode.tekiyoKaishiYM;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.substr;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払い給付種類支給限度額のデータアクセスクラスです。
 */
public class DbT7112ShokanShuruiShikyuGendoGakuDac implements ISaveable<DbT7112ShokanShuruiShikyuGendoGakuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで償還払い給付種類支給限度額を取得します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return DbT7112ShokanShuruiShikyuGendoGakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7112ShokanShuruiShikyuGendoGakuEntity selectByKey(
            ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) throws NullPointerException {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7112ShokanShuruiShikyuGendoGaku.class).
                where(and(
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(tekiyoKaishiYM, 適用開始年月),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT7112ShokanShuruiShikyuGendoGakuEntity.class);
    }

    /**
     * 償還払い給付種類支給限度額を全件返します。
     *
     * @return List<DbT7112ShokanShuruiShikyuGendoGakuEntity>
     */
    @Transaction
    public List<DbT7112ShokanShuruiShikyuGendoGakuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7112ShokanShuruiShikyuGendoGaku.class).
                toList(DbT7112ShokanShuruiShikyuGendoGakuEntity.class);
    }

    /**
     * DbT7112ShokanShuruiShikyuGendoGakuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7112ShokanShuruiShikyuGendoGakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払い給付種類支給限度額エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 償還払い給付種類支給限度額テーブルからデータを抽出する。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param サービス提供年月 FlexibleYearMonth
     * @return Decimal
     */
    public Decimal select支給限度単位数(ServiceShuruiCode サービス種類コード, FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(shikyuGendoTaniSu).
                table(DbT7112ShokanShuruiShikyuGendoGaku.class).
                where(and(
                                eq(serviceShuruiCode, サービス種類コード),
                                leq(tekiyoKaishiYM, サービス提供年月),
                                leq(サービス提供年月, tekiyoShuryoYM))).
                order(
                        by(tekiyoKaishiYM, Order.DESC),
                        by(rirekiNo, Order.DESC)).
                limit(1).
                toObject(Decimal.class);
    }
    
    public Decimal get償還払い給付種類支給限度額(ServiceShuruiCode サービス種類コード, FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7112ShokanShuruiShikyuGendoGaku.class).
                where(and(
                                eq(serviceShuruiCode, サービス種類コード)
                        ,or(and(leq(tekiyoShuryoYM, null),
                                leq(tekiyoKaishiYM, サービス提供年月)),and(leq(substr(tekiyoKaishiYM,0,6), サービス提供年月),
                                leq(サービス提供年月, tekiyoShuryoYM)))
                )).
                order(
                        by(tekiyoKaishiYM, Order.DESC),
                        by(rirekiNo, Order.DESC)).
                limit(1).
                toObject(Decimal.class);
    }
}
