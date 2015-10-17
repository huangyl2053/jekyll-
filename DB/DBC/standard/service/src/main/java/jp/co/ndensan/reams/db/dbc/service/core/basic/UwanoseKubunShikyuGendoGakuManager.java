/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.UwanoseKubunShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7113UwanoseKubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7113UwanoseKubunShikyuGendoGakuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 上乗せ居宅サービス区分支給限度額を管理するクラスです。
 */
public class UwanoseKubunShikyuGendoGakuManager {

    private final DbT7113UwanoseKubunShikyuGendoGakuDac dac;

    /**
     * コンストラクタです。
     */
    public UwanoseKubunShikyuGendoGakuManager() {
        dac = InstanceProvider.create(DbT7113UwanoseKubunShikyuGendoGakuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7113UwanoseKubunShikyuGendoGakuDac}
     */
    UwanoseKubunShikyuGendoGakuManager(DbT7113UwanoseKubunShikyuGendoGakuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する上乗せ居宅サービス区分支給限度額を返します。
     *
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return UwanoseKubunShikyuGendoGaku
     */
    @Transaction
    public UwanoseKubunShikyuGendoGaku get上乗せ居宅サービス区分支給限度額(
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT7113UwanoseKubunShikyuGendoGakuEntity entity = dac.selectByKey(
                要介護状態区分,
                適用開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new UwanoseKubunShikyuGendoGaku(entity);
    }

    /**
     * 上乗せ居宅サービス区分支給限度額を全件返します。
     *
     * @return List<UwanoseKubunShikyuGendoGaku>
     */
    @Transaction
    public List<UwanoseKubunShikyuGendoGaku> get上乗せ居宅サービス区分支給限度額一覧() {
        List<UwanoseKubunShikyuGendoGaku> businessList = new ArrayList<>();

        for (DbT7113UwanoseKubunShikyuGendoGakuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new UwanoseKubunShikyuGendoGaku(entity));
        }

        return businessList;
    }

    /**
     * 上乗せ居宅サービス区分支給限度額{@link UwanoseKubunShikyuGendoGaku}を保存します。
     *
     * @param 上乗せ居宅サービス区分支給限度額 {@link UwanoseKubunShikyuGendoGaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save上乗せ居宅サービス区分支給限度額(UwanoseKubunShikyuGendoGaku 上乗せ居宅サービス区分支給限度額) {
        requireNonNull(上乗せ居宅サービス区分支給限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("上乗せ居宅サービス区分支給限度額"));
        if (!上乗せ居宅サービス区分支給限度額.hasChanged()) {
            return false;
        }
        return 1 == dac.save(上乗せ居宅サービス区分支給限度額.toEntity());
    }
}
