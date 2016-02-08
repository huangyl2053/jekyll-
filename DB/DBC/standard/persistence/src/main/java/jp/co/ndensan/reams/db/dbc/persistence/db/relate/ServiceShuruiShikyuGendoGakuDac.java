/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ServiceShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7111ServiceShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7111ServiceShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7111ServiceShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * サービス種類支給限度額のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class ServiceShuruiShikyuGendoGakuDac implements IModifiable<ServiceShuruiShikyuGendoGaku> {

    @InjectSession
    private SqlSession session;
    private final DbT7111ServiceShuruiShikyuGendoGakuDac サービス種類支給限度額Dac = InstanceProvider.create(DbT7111ServiceShuruiShikyuGendoGakuDac.class);

    /**
     * サービス種類支給限度額情報をキー検索で１件返します。
     *
     * @param サービス種類コード サービス種類コード
     * @param 要介護状態区分 要介護状態区分
     * @param 適用開始年月 適用開始年月
     * @param 履歴番号 履歴番号
     * @return ServiceShuruiShikyuGendoGaku
     */
    @Transaction
    public Optional<ServiceShuruiShikyuGendoGaku> selectByKey(ServiceShuruiCode サービス種類コード,
            IYokaigoJotaiKubun 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {

        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        return Optional.ofNullable(create(サービス種類支給限度額Dac.selectByKey(サービス種類コード, 要介護状態区分.getCode(), 適用開始年月, 履歴番号)));
    }

    /**
     * サービス種類支給限度額を全件返します。
     *
     * @return List<ServiceShuruiShikyuGendoGaku>
     */
    @Transaction
    public IItemList<ServiceShuruiShikyuGendoGaku> selectAll() {

        List<DbT7111ServiceShuruiShikyuGendoGakuEntity> サービス種類支給限度額List = サービス種類支給限度額Dac.selectAll();
        List<ServiceShuruiShikyuGendoGaku> list = new ArrayList<>();

        for (DbT7111ServiceShuruiShikyuGendoGakuEntity サービス種類支給限度額 : サービス種類支給限度額List) {
            list.add(create(サービス種類支給限度額));
        }
        IItemList<ServiceShuruiShikyuGendoGaku> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * サービス種類支給限度額情報のリストをキー検索で返します。
     *
     * @param 要介護状態区分 要介護状態区分
     * @param 基準日 基準日
     * @return JukyushaDaicho
     */
    @Transaction
    public IItemList<ServiceShuruiShikyuGendoGaku> selectサービス種類支給限度額リスト(IYokaigoJotaiKubun 要介護状態区分,
            FlexibleDate 基準日) {

        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7111ServiceShuruiShikyuGendoGakuEntity> サービス種類支給限度額List;
        サービス種類支給限度額List = accessor.select().
                table(DbT7111ServiceShuruiShikyuGendoGaku.class).
                where(and(
                                eq(DbT7111ServiceShuruiShikyuGendoGaku.yoKaigoJotaiKubun, 要介護状態区分.getCode()),
                                leq(DbT7111ServiceShuruiShikyuGendoGaku.tekiyoKaishiYM, 基準日.getYearMonth()))).
                order(by(DbT7111ServiceShuruiShikyuGendoGaku.rirekiNo, Order.DESC)).
                toList(DbT7111ServiceShuruiShikyuGendoGakuEntity.class);

        List<ServiceShuruiShikyuGendoGaku> list = new ArrayList<>();

        for (DbT7111ServiceShuruiShikyuGendoGakuEntity サービス種類支給限度額 : サービス種類支給限度額List) {
            list.add(create(サービス種類支給限度額));
        }
        IItemList<ServiceShuruiShikyuGendoGaku> サービス種類支給限度額リスト = ItemList.of(list);

        return サービス種類支給限度額リスト;
    }

    /**
     * サービス種類支給限度額情報のリストをキー検索で返します。
     *
     * @param 要介護状態区分 要介護状態区分
     * @return JukyushaDaicho
     */
    @Transaction
    public IItemList<ServiceShuruiShikyuGendoGaku> selectサービス種類支給限度額リスト(IYokaigoJotaiKubun 要介護状態区分) {

        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7111ServiceShuruiShikyuGendoGakuEntity> サービス種類支給限度額List;
        サービス種類支給限度額List = accessor.select().
                table(DbT7111ServiceShuruiShikyuGendoGaku.class).
                where(eq(DbT7111ServiceShuruiShikyuGendoGaku.yoKaigoJotaiKubun, 要介護状態区分.getCode())).
                order(by(DbT7111ServiceShuruiShikyuGendoGaku.rirekiNo, Order.DESC)).
                toList(DbT7111ServiceShuruiShikyuGendoGakuEntity.class);

        List<ServiceShuruiShikyuGendoGaku> list = new ArrayList<>();

        for (DbT7111ServiceShuruiShikyuGendoGakuEntity サービス種類支給限度額 : サービス種類支給限度額List) {
            list.add(create(サービス種類支給限度額));
        }
        IItemList<ServiceShuruiShikyuGendoGaku> サービス種類支給限度額リスト = ItemList.of(list);

        return サービス種類支給限度額リスト;
    }

    private ServiceShuruiShikyuGendoGaku create(DbT7111ServiceShuruiShikyuGendoGakuEntity サービス種類支給限度額エンティティ) {
        if (サービス種類支給限度額エンティティ == null) {
            return null;
        }

        return new ServiceShuruiShikyuGendoGaku(サービス種類支給限度額エンティティ);
    }

    @Override
    public int insert(ServiceShuruiShikyuGendoGaku data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = サービス種類支給限度額Dac.save(data.toEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(ServiceShuruiShikyuGendoGaku data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = サービス種類支給限度額Dac.save(data.toEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(ServiceShuruiShikyuGendoGaku data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = サービス種類支給限度額Dac.save(data.toEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data ServiceShuruiShikyuGendoGaku
     * @return int 件数
     */
    public int deletePhysical(ServiceShuruiShikyuGendoGaku data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = サービス種類支給限度額Dac.save(data.toEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

}
