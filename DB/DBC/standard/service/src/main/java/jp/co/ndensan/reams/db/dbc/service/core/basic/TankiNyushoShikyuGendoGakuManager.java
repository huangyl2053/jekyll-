/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TankiNyushoShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7110TankiNyushoShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.basic.DbT7110TankiNyushoShikyuGendoGakuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 短期入所系支給限度額を管理するクラスです。
 */
public class TankiNyushoShikyuGendoGakuManager {

    private final DbT7110TankiNyushoShikyuGendoGakuDac dac;

    /**
     * コンストラクタです。
     */
    public TankiNyushoShikyuGendoGakuManager() {
        dac = InstanceProvider.create(DbT7110TankiNyushoShikyuGendoGakuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7110TankiNyushoShikyuGendoGakuDac}
     */
    TankiNyushoShikyuGendoGakuManager(DbT7110TankiNyushoShikyuGendoGakuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する短期入所系支給限度額を返します。
     *
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return TankiNyushoShikyuGendoGaku
     */
    @Transaction
    public TankiNyushoShikyuGendoGaku get短期入所系支給限度額(
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT7110TankiNyushoShikyuGendoGakuEntity entity = dac.selectByKey(
                要介護状態区分,
                適用開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new TankiNyushoShikyuGendoGaku(entity);
    }

    /**
     * 短期入所系支給限度額を全件返します。
     *
     * @return List<TankiNyushoShikyuGendoGaku>
     */
    @Transaction
    public List<TankiNyushoShikyuGendoGaku> get短期入所系支給限度額一覧() {
        List<TankiNyushoShikyuGendoGaku> businessList = new ArrayList<>();

        for (DbT7110TankiNyushoShikyuGendoGakuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new TankiNyushoShikyuGendoGaku(entity));
        }

        return businessList;
    }

    /**
     * 短期入所系支給限度額{@link TankiNyushoShikyuGendoGaku}を保存します。
     *
     * @param 短期入所系支給限度額 {@link TankiNyushoShikyuGendoGaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save短期入所系支給限度額(TankiNyushoShikyuGendoGaku 短期入所系支給限度額) {
        requireNonNull(短期入所系支給限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所系支給限度額"));
        if (!短期入所系支給限度額.hasChanged()) {
            return false;
        }
        return 1 == dac.save(短期入所系支給限度額.toEntity());
    }
}
