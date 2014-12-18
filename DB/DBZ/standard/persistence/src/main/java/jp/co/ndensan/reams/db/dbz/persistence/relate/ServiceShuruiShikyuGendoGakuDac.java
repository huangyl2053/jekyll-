/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7111ServiceShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7111ServiceShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.model.ServiceShuruiShikyuGendoGakuModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7111ServiceShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
public class ServiceShuruiShikyuGendoGakuDac implements IModifiable<ServiceShuruiShikyuGendoGakuModel> {

    @InjectSession
    private SqlSession session;
    private final DbT7111ServiceShuruiShikyuGendoGakuDac サービス種類支給限度額Dac = InstanceProvider.create(DbT7111ServiceShuruiShikyuGendoGakuDac.class);

    /**
     * サービス種類支給限度額情報をキー検索で１件返します。
     *
     * @param サービス種類コード サービス種類コード
     * @param 要介護状態区分 要介護状態区分
     * @param 適用開始年月 適用開始年月
     * @param 処理日時 処理日時
     * @return ServiceShuruiShikyuGendoGakuModel
     */
    @Transaction
    public ServiceShuruiShikyuGendoGakuModel selectByKey(ServiceShuruiCode サービス種類コード,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            YMDHMS 処理日時) {

        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        return createModel(サービス種類支給限度額Dac.selectByKey(サービス種類コード, 要介護状態区分, 適用開始年月, 処理日時));
    }

    /**
     * サービス種類支給限度額を全件返します。
     *
     * @return List<ServiceShuruiShikyuGendoGakuModel>
     */
    @Transaction
    public IItemList<ServiceShuruiShikyuGendoGakuModel> selectAll() {

        List<DbT7111ServiceShuruiShikyuGendoGakuEntity> サービス種類支給限度額List = サービス種類支給限度額Dac.selectAll();
        List<ServiceShuruiShikyuGendoGakuModel> list = new ArrayList<>();

        for (DbT7111ServiceShuruiShikyuGendoGakuEntity サービス種類支給限度額 : サービス種類支給限度額List) {
            list.add(createModel(サービス種類支給限度額));
        }
        IItemList<ServiceShuruiShikyuGendoGakuModel> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * サービス種類支給限度額情報のリストをキー検索で返します。
     *
     * @param 要介護状態区分 要介護状態区分
     * @param 基準日 基準日
     * @return JukyushaDaichoModel
     */
    @Transaction
    public IItemList<ServiceShuruiShikyuGendoGakuModel> selectサービス種類支給限度額リスト(RString 要介護状態区分,
            FlexibleDate 基準日) {

        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7111ServiceShuruiShikyuGendoGakuEntity> サービス種類支給限度額List;
        サービス種類支給限度額List = accessor.select().
                table(DbT7111ServiceShuruiShikyuGendoGaku.class).
                where(and(
                                eq(DbT7111ServiceShuruiShikyuGendoGaku.yoKaigoJotaiKubun, 要介護状態区分),
                                leq(DbT7111ServiceShuruiShikyuGendoGaku.tekiyoKaishuYM, 基準日.getYearMonth()))).
                order(by(DbT7111ServiceShuruiShikyuGendoGaku.shoriTimestamp, Order.DESC)).
                toList(DbT7111ServiceShuruiShikyuGendoGakuEntity.class);

        List<ServiceShuruiShikyuGendoGakuModel> list = new ArrayList<>();

        for (DbT7111ServiceShuruiShikyuGendoGakuEntity サービス種類支給限度額 : サービス種類支給限度額List) {
            list.add(createModel(サービス種類支給限度額));
        }
        IItemList<ServiceShuruiShikyuGendoGakuModel> サービス種類支給限度額リスト = ItemList.of(list);

        return サービス種類支給限度額リスト;
    }

    /**
     * サービス種類支給限度額情報のリストをキー検索で返します。
     *
     * @param 要介護状態区分 要介護状態区分
     * @return JukyushaDaichoModel
     */
    @Transaction
    public IItemList<ServiceShuruiShikyuGendoGakuModel> selectサービス種類支給限度額リスト(RString 要介護状態区分) {

        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT7111ServiceShuruiShikyuGendoGakuEntity> サービス種類支給限度額List;
        サービス種類支給限度額List = accessor.select().
                table(DbT7111ServiceShuruiShikyuGendoGaku.class).
                where(eq(DbT7111ServiceShuruiShikyuGendoGaku.yoKaigoJotaiKubun, 要介護状態区分)).
                order(by(DbT7111ServiceShuruiShikyuGendoGaku.shoriTimestamp, Order.DESC)).
                toList(DbT7111ServiceShuruiShikyuGendoGakuEntity.class);

        List<ServiceShuruiShikyuGendoGakuModel> list = new ArrayList<>();

        for (DbT7111ServiceShuruiShikyuGendoGakuEntity サービス種類支給限度額 : サービス種類支給限度額List) {
            list.add(createModel(サービス種類支給限度額));
        }
        IItemList<ServiceShuruiShikyuGendoGakuModel> サービス種類支給限度額リスト = ItemList.of(list);

        return サービス種類支給限度額リスト;
    }

    private ServiceShuruiShikyuGendoGakuModel createModel(DbT7111ServiceShuruiShikyuGendoGakuEntity サービス種類支給限度額エンティティ) {
        if (サービス種類支給限度額エンティティ == null) {
            return null;
        }

        return new ServiceShuruiShikyuGendoGakuModel(サービス種類支給限度額エンティティ);
    }

    @Override
    public int insert(ServiceShuruiShikyuGendoGakuModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = サービス種類支給限度額Dac.insert(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(ServiceShuruiShikyuGendoGakuModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = サービス種類支給限度額Dac.update(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(ServiceShuruiShikyuGendoGakuModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = サービス種類支給限度額Dac.delete(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data ServiceShuruiShikyuGendoGakuModel
     * @return int 件数
     */
    public int deletePhysical(ServiceShuruiShikyuGendoGakuModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = サービス種類支給限度額Dac.deletePhysical(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

}
