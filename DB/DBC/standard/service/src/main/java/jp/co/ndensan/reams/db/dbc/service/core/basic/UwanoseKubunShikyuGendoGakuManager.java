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
    private static final RString 定値_要介護状態区分 = new RString("要介護状態区分");
    private static final RString 定値_適用開始年月 = new RString("適用開始年月");
    private static final RString 定値_履歴番号 = new RString("履歴番号");
    private static final RString 定値_上乗せ居宅サービス
            = new RString("上乗せ居宅サービス区分支給限度額");

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
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_要介護状態区分.toString()));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_適用開始年月.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_履歴番号.toString()));

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
     * 上乗せ居宅サービス区分支給限度額を全件返します。
     *
     * @return List<UwanoseKubunShikyuGendoGaku>
     */
    @Transaction
    public List<UwanoseKubunShikyuGendoGaku> get上乗せ居宅サービス区分支給限度額一覧データ() {
        List<UwanoseKubunShikyuGendoGaku> businessList = new ArrayList<>();

        for (DbT7113UwanoseKubunShikyuGendoGakuEntity entity : dac.selectAllOrder()) {
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
    public boolean save上乗せ居宅サービス区分支給限度額(
            UwanoseKubunShikyuGendoGaku 上乗せ居宅サービス区分支給限度額) {
        requireNonNull(上乗せ居宅サービス区分支給限度額,
                UrSystemErrorMessages.値がnull.getReplacedMessage(定値_上乗せ居宅サービス.toString()));
        if (!上乗せ居宅サービス区分支給限度額.hasChanged()) {
            return false;
        }
        return 1 == dac.save(上乗せ居宅サービス区分支給限度額.toEntity());
    }

    /**
     * 上乗せ居宅サービス区分支給限度額{@link UwanoseKubunShikyuGendoGaku}を保存します。
     *
     * @param 上乗せ居宅サービス区分List {@link UwanoseKubunShikyuGendoGaku}
     */
    @Transaction
    public void save上乗せ居宅サービス区分List(
            List<UwanoseKubunShikyuGendoGaku> 上乗せ居宅サービス区分List) {
        if (!上乗せ居宅サービス区分List.isEmpty()) {
            for (UwanoseKubunShikyuGendoGaku 上乗せ居宅サービス区分 : 上乗せ居宅サービス区分List) {
                requireNonNull(上乗せ居宅サービス区分,
                        UrSystemErrorMessages.値がnull.getReplacedMessage(定値_上乗せ居宅サービス.toString()));
                if (!上乗せ居宅サービス区分.hasChanged()) {
                    continue;
                }
                dac.save(上乗せ居宅サービス区分.toEntity());
            }
        }
    }

    /**
     * 上乗せ居宅サービス区分支給限度額{@link UwanoseKubunShikyuGendoGaku}を保存します。
     *
     * @param insert上乗せ居宅List {@link UwanoseKubunShikyuGendoGaku}
     * @param update上乗せ居宅List {@link UwanoseKubunShikyuGendoGaku}
     */
    @Transaction
    public void insertAndUpdate上乗せ居宅(
            List<UwanoseKubunShikyuGendoGaku> insert上乗せ居宅List,
            List<UwanoseKubunShikyuGendoGaku> update上乗せ居宅List) {
        if (!insert上乗せ居宅List.isEmpty()) {
            for (UwanoseKubunShikyuGendoGaku insert上乗せ居宅 : insert上乗せ居宅List) {
                requireNonNull(insert上乗せ居宅,
                        UrSystemErrorMessages.値がnull.getReplacedMessage(定値_上乗せ居宅サービス.toString()));
                dac.save(insert上乗せ居宅.toEntity());
            }
        }
        if (!update上乗せ居宅List.isEmpty()) {
            for (UwanoseKubunShikyuGendoGaku update上乗せ居宅 : update上乗せ居宅List) {
                requireNonNull(update上乗せ居宅,
                        UrSystemErrorMessages.値がnull.getReplacedMessage(定値_上乗せ居宅サービス.toString()));
                if (!update上乗せ居宅.hasChanged()) {
                    return;
                }
                dac.save(update上乗せ居宅.toEntity());
            }
        }
    }

    /**
     * 上乗せ居宅サービス区分支給限度額{@link UwanoseKubunShikyuGendoGaku}を保存します。
     *
     * @param delete上乗せ居宅List {@link UwanoseKubunShikyuGendoGaku}
     * @param update上乗せ居宅List {@link UwanoseKubunShikyuGendoGaku}
     */
    @Transaction
    public void deleteAndUpdate上乗せ居宅(
            List<UwanoseKubunShikyuGendoGaku> delete上乗せ居宅List,
            List<UwanoseKubunShikyuGendoGaku> update上乗せ居宅List) {
        if (!delete上乗せ居宅List.isEmpty()) {
            for (UwanoseKubunShikyuGendoGaku delete上乗せ居宅 : delete上乗せ居宅List) {
                requireNonNull(delete上乗せ居宅,
                        UrSystemErrorMessages.値がnull.getReplacedMessage(定値_上乗せ居宅サービス.toString()));
                if (delete上乗せ居宅.hasChanged()) {
                    return;
                }
                dac.delete(delete上乗せ居宅.toEntity());
            }
        }
        if (!update上乗せ居宅List.isEmpty()) {
            for (UwanoseKubunShikyuGendoGaku update上乗せ居宅 : update上乗せ居宅List) {
                requireNonNull(update上乗せ居宅,
                        UrSystemErrorMessages.値がnull.getReplacedMessage(定値_上乗せ居宅サービス.toString()));
                if (!update上乗せ居宅.hasChanged()) {
                    return;
                }
                dac.save(update上乗せ居宅.toEntity());
            }
        }
    }

    /**
     * 主キーに合致する上乗せ居宅サービス区分支給限度額を削除する。
     *
     * @param 要介護状態区分 RString
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return 更新が成功するかどうか
     */
    @Transaction
    public Boolean データを物理削除する(
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_要介護状態区分.toString()));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_適用開始年月.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_履歴番号.toString()));

        DbT7113UwanoseKubunShikyuGendoGakuEntity entity = dac.selectByKey(
                要介護状態区分,
                適用開始年月,
                履歴番号);
        entity.initializeMd5();
        return 1 == dac.delete(entity);
    }
}
