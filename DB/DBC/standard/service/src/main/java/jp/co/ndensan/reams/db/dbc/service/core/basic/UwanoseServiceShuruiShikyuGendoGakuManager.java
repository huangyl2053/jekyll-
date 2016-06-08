/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.UwanoseServiceShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7114UwanoseServiceShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 上乗せサービス種類支給限度額を管理するクラスです。
 */
public class UwanoseServiceShuruiShikyuGendoGakuManager {

    private final DbT7114UwanoseServiceShuruiShikyuGendoGakuDac dac;

    /**
     * コンストラクタです。
     */
    public UwanoseServiceShuruiShikyuGendoGakuManager() {
        dac = InstanceProvider.create(DbT7114UwanoseServiceShuruiShikyuGendoGakuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7114UwanoseServiceShuruiShikyuGendoGakuDac}
     */
    UwanoseServiceShuruiShikyuGendoGakuManager(DbT7114UwanoseServiceShuruiShikyuGendoGakuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する上乗せサービス種類支給限度額を返します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return UwanoseServiceShuruiShikyuGendoGaku
     */
    @Transaction
    public UwanoseServiceShuruiShikyuGendoGaku get上乗せサービス種類支給限度額(
            ServiceShuruiCode サービス種類コード,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity entity = dac.selectByKey(
                サービス種類コード,
                要介護状態区分,
                適用開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new UwanoseServiceShuruiShikyuGendoGaku(entity);
    }

    /**
     * 上乗せサービス種類支給限度額を全件返します。
     *
     * @return List<UwanoseServiceShuruiShikyuGendoGaku>
     */
    @Transaction
    public List<UwanoseServiceShuruiShikyuGendoGaku> get上乗せサービス種類支給限度額一覧() {
        List<UwanoseServiceShuruiShikyuGendoGaku> businessList = new ArrayList<>();

        for (DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new UwanoseServiceShuruiShikyuGendoGaku(entity));
        }

        return businessList;
    }

    /**
     * 上乗せサービス種類支給限度額{@link UwanoseServiceShuruiShikyuGendoGaku}を保存します。
     *
     * @param 上乗せサービス種類支給限度額 {@link UwanoseServiceShuruiShikyuGendoGaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save上乗せサービス種類支給限度額(UwanoseServiceShuruiShikyuGendoGaku 上乗せサービス種類支給限度額) {
        requireNonNull(上乗せサービス種類支給限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("上乗せサービス種類支給限度額"));
        if (!上乗せサービス種類支給限度額.hasChanged()) {
            return false;
        }
        return 1 == dac.save(上乗せサービス種類支給限度額.toEntity());
    }
}
