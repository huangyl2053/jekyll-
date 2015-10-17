/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ServiceShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7111ServiceShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7111ServiceShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * サービス種類支給限度額を管理するクラスです。
 */
public class ServiceShuruiShikyuGendoGakuManager {

    private final DbT7111ServiceShuruiShikyuGendoGakuDac dac;

    /**
     * コンストラクタです。
     */
    public ServiceShuruiShikyuGendoGakuManager() {
        dac = InstanceProvider.create(DbT7111ServiceShuruiShikyuGendoGakuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7111ServiceShuruiShikyuGendoGakuDac}
     */
    ServiceShuruiShikyuGendoGakuManager(DbT7111ServiceShuruiShikyuGendoGakuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致するサービス種類支給限度額を返します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishuYM
     * @param 履歴番号 RirekiNo
     * @return ServiceShuruiShikyuGendoGaku
     */
    @Transaction
    public ServiceShuruiShikyuGendoGaku getサービス種類支給限度額(
            ServiceShuruiCode サービス種類コード,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT7111ServiceShuruiShikyuGendoGakuEntity entity = dac.selectByKey(
                サービス種類コード,
                要介護状態区分,
                適用開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ServiceShuruiShikyuGendoGaku(entity);
    }

    /**
     * サービス種類支給限度額を全件返します。
     *
     * @return List<ServiceShuruiShikyuGendoGaku>
     */
    @Transaction
    public List<ServiceShuruiShikyuGendoGaku> getサービス種類支給限度額一覧() {
        List<ServiceShuruiShikyuGendoGaku> businessList = new ArrayList<>();

        for (DbT7111ServiceShuruiShikyuGendoGakuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ServiceShuruiShikyuGendoGaku(entity));
        }

        return businessList;
    }

    /**
     * サービス種類支給限度額{@link ServiceShuruiShikyuGendoGaku}を保存します。
     *
     * @param サービス種類支給限度額 {@link ServiceShuruiShikyuGendoGaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean saveサービス種類支給限度額(ServiceShuruiShikyuGendoGaku サービス種類支給限度額) {
        requireNonNull(サービス種類支給限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類支給限度額"));
        if (!サービス種類支給限度額.hasChanged()) {
            return false;
        }
        return 1 == dac.save(サービス種類支給限度額.toEntity());
    }
}
