/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KubunShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7109KubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7109KubunShikyuGendoGakuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅サービス区分支給限度額を管理するクラスです。
 */
public class KubunShikyuGendoGakuManager {

    private final DbT7109KubunShikyuGendoGakuDac dac;
    private static final RString 定値_要介護状態区分 = new RString("要介護状態区分");
    private static final RString 定値_適用開始年月 = new RString("適用開始年月");
    private static final RString 定値_履歴番号 = new RString("履歴番号");
    private static final RString 定値_居宅サービス区分支給限度額
            = new RString("居宅サービス区分支給限度額");

    /**
     * コンストラクタです。
     */
    public KubunShikyuGendoGakuManager() {
        dac = InstanceProvider.create(DbT7109KubunShikyuGendoGakuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7109KubunShikyuGendoGakuDac}
     */
    KubunShikyuGendoGakuManager(DbT7109KubunShikyuGendoGakuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する居宅サービス区分支給限度額を返します。
     *
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return KubunShikyuGendoGaku
     */
    @Transaction
    public KubunShikyuGendoGaku get居宅サービス区分支給限度額(
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_要介護状態区分.toString()));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_適用開始年月.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_履歴番号.toString()));

        DbT7109KubunShikyuGendoGakuEntity entity = dac.selectByKey(
                要介護状態区分,
                適用開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KubunShikyuGendoGaku(entity);
    }

    /**
     * 居宅サービス区分支給限度額を全件返します。
     *
     * @return List<KubunShikyuGendoGaku>
     */
    @Transaction
    public List<KubunShikyuGendoGaku> get居宅サービス区分支給限度額一覧() {
        List<KubunShikyuGendoGaku> businessList = new ArrayList<>();

        for (DbT7109KubunShikyuGendoGakuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KubunShikyuGendoGaku(entity));
        }

        return businessList;
    }

    /**
     * 居宅サービス区分支給限度額を全件返します。
     *
     * @return List<KubunShikyuGendoGaku>
     */
    @Transaction
    public List<KubunShikyuGendoGaku> get居宅サービス区分支給限度額一覧データ() {
        List<KubunShikyuGendoGaku> businessList = new ArrayList<>();

        for (DbT7109KubunShikyuGendoGakuEntity entity : dac.selectAllOrder()) {
            entity.initializeMd5();
            businessList.add(new KubunShikyuGendoGaku(entity));
        }

        return businessList;
    }

    /**
     * 居宅サービス区分支給限度額{@link KubunShikyuGendoGaku}を保存します。
     *
     * @param 居宅サービス区分支給限度額 {@link KubunShikyuGendoGaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save居宅サービス区分支給限度額(KubunShikyuGendoGaku 居宅サービス区分支給限度額) {
        requireNonNull(居宅サービス区分支給限度額,
                UrSystemErrorMessages.値がnull.getReplacedMessage(定値_居宅サービス区分支給限度額.toString()));
        if (!居宅サービス区分支給限度額.hasChanged()) {
            return false;
        }
        return 1 == dac.save(居宅サービス区分支給限度額.toEntity());
    }

    /**
     * 居宅サービス区分支給限度額{@link KubunShikyuGendoGaku}を保存します。
     *
     * @param 居宅サービス区分List {@link KubunShikyuGendoGaku}
     */
    @Transaction
    public void save居宅サービス区分List(List<KubunShikyuGendoGaku> 居宅サービス区分List) {
        if (!居宅サービス区分List.isEmpty()) {
            for (KubunShikyuGendoGaku 居宅サービス区分 : 居宅サービス区分List) {
                requireNonNull(居宅サービス区分,
                        UrSystemErrorMessages.値がnull.getReplacedMessage(定値_居宅サービス区分支給限度額.toString()));
                if (!居宅サービス区分.hasChanged()) {
                    continue;
                }
                dac.save(居宅サービス区分.toEntity());
            }
        }
    }

    /**
     * 居宅サービス区分支給限度額{@link KubunShikyuGendoGaku}を保存します。
     *
     * @param insert居宅List {@link KubunShikyuGendoGaku}
     * @param update居宅List {@link KubunShikyuGendoGaku}
     */
    @Transaction
    public void insertAndUpdate居宅(
            List<KubunShikyuGendoGaku> insert居宅List, List<KubunShikyuGendoGaku> update居宅List) {
        if (!insert居宅List.isEmpty()) {
            for (KubunShikyuGendoGaku insert居宅 : insert居宅List) {
                requireNonNull(insert居宅,
                        UrSystemErrorMessages.値がnull.getReplacedMessage(定値_居宅サービス区分支給限度額.toString()));
                dac.save(insert居宅.toEntity());
            }
        }
        if (!update居宅List.isEmpty()) {
            for (KubunShikyuGendoGaku update居宅 : update居宅List) {
                requireNonNull(update居宅,
                        UrSystemErrorMessages.値がnull.getReplacedMessage(定値_居宅サービス区分支給限度額.toString()));
                if (!update居宅.hasChanged()) {
                    return;
                }
                dac.save(update居宅.toEntity());
            }
        }
    }

    /**
     * 居宅サービス区分支給限度額{@link KubunShikyuGendoGaku}を保存します。
     *
     * @param delete居宅List {@link KubunShikyuGendoGaku}
     * @param update居宅List {@link KubunShikyuGendoGaku}
     */
    @Transaction
    public void deleteAndUpdate居宅(
            List<KubunShikyuGendoGaku> delete居宅List, List<KubunShikyuGendoGaku> update居宅List) {
        if (!delete居宅List.isEmpty()) {
            for (KubunShikyuGendoGaku delete居宅 : delete居宅List) {
                requireNonNull(delete居宅,
                        UrSystemErrorMessages.値がnull.getReplacedMessage(定値_居宅サービス区分支給限度額.toString()));
                if (delete居宅.hasChanged()) {
                    return;
                }
                dac.delete(delete居宅.toEntity());
            }
        }
        if (!update居宅List.isEmpty()) {
            for (KubunShikyuGendoGaku update居宅 : update居宅List) {
                requireNonNull(update居宅,
                        UrSystemErrorMessages.値がnull.getReplacedMessage(定値_居宅サービス区分支給限度額.toString()));
                if (!update居宅.hasChanged()) {
                    return;
                }
                dac.save(update居宅.toEntity());
            }
        }
    }

    /**
     * 主キーに合致する居宅サービス区分支給限度額を削除する。
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

        DbT7109KubunShikyuGendoGakuEntity entity = dac.selectByKey(
                要介護状態区分,
                適用開始年月,
                履歴番号);
        entity.initializeMd5();
        return 1 == dac.delete(entity);
    }
}
