/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoKubunShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7117SogoJigyoKubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7117SogoJigyoKubunShikyuGendoGakuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護予防・日常生活支援総合事業区分支給限度額を管理するクラスです。
 *
 * @reamsid_L DBC-3363-010 xuxin
 */
public class SogoJigyoKubunShikyuGendoGakuManager {

    private final DbT7117SogoJigyoKubunShikyuGendoGakuDac dac;

    /**
     * コンストラクタです。
     */
    public SogoJigyoKubunShikyuGendoGakuManager() {
        dac = InstanceProvider.create(DbT7117SogoJigyoKubunShikyuGendoGakuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7117SogoJigyoKubunShikyuGendoGakuDac}
     */
    SogoJigyoKubunShikyuGendoGakuManager(DbT7117SogoJigyoKubunShikyuGendoGakuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護予防・日常生活支援総合事業区分支給限度額を返します。
     *
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return SogoJigyoKubunShikyuGendoGaku
     */
    @Transaction
    public SogoJigyoKubunShikyuGendoGaku get介護予防_日常生活支援総合事業区分支給限度額(
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity = dac.selectByKey(
                要介護状態区分,
                適用開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new SogoJigyoKubunShikyuGendoGaku(entity);
    }

    /**
     * 介護予防・日常生活支援総合事業区分支給限度額を全件返します。
     *
     * @return List<SogoJigyoKubunShikyuGendoGaku>
     */
    @Transaction
    public List<SogoJigyoKubunShikyuGendoGaku> get介護予防_日常生活支援総合事業区分支給限度額一覧() {
        List<SogoJigyoKubunShikyuGendoGaku> businessList = new ArrayList<>();

        for (DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new SogoJigyoKubunShikyuGendoGaku(entity));
        }

        return businessList;
    }

    /**
     * 介護予防・日常生活支援総合事業区分支給限度額適用開始日の降順を全件返します。
     *
     * @return List<SogoJigyoKubunShikyuGendoGaku>
     */
    @Transaction
    public List<SogoJigyoKubunShikyuGendoGaku> get介護予防_日常生活支援総合事業区分支給限度額_適用開始日の降順一覧() {

        List<SogoJigyoKubunShikyuGendoGaku> businessList = new ArrayList<>();
        for (DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity : dac.selectAllDesc()) {
            entity.initializeMd5();
            businessList.add(new SogoJigyoKubunShikyuGendoGaku(entity));
        }
        return businessList;
    }

    /**
     * 介護予防・日常生活支援総合事業区分支給限度額{@link SogoJigyoKubunShikyuGendoGaku}を保存します。
     *
     * @param 介護予防_日常生活支援総合事業区分支給限度額 {@link SogoJigyoKubunShikyuGendoGaku}
     * @return 更新結果
     */
    @Transaction
    public boolean save介護予防_日常生活支援総合事業区分支給限度額(SogoJigyoKubunShikyuGendoGaku 介護予防_日常生活支援総合事業区分支給限度額) {
        requireNonNull(介護予防_日常生活支援総合事業区分支給限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護予防・日常生活支援総合事業区分支給限度額"));
        if (!介護予防_日常生活支援総合事業区分支給限度額.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護予防_日常生活支援総合事業区分支給限度額.toEntity());
    }
}
