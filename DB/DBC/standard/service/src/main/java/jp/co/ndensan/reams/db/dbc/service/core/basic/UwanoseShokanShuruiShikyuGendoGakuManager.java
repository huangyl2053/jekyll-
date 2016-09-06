/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.UwanoseShokanShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 上乗せ償還払い給付種類支給限度額を管理するクラスです。
 */
public class UwanoseShokanShuruiShikyuGendoGakuManager {

    private final DbT7115UwanoseShokanShuruiShikyuGendoGakuDac dac;
    private static final RString 定値_サービス種類コード = new RString("サービス種類コード");
    private static final RString 定値_適用開始年月 = new RString("適用開始年月");
    private static final RString 定値_履歴番号 = new RString("履歴番号");
    private static final RString 定値_上乗せ償還払い給付種類支給限度額 = new RString("上乗せ償還払い給付種類支給限度額");

    /**
     * コンストラクタです。
     */
    public UwanoseShokanShuruiShikyuGendoGakuManager() {
        dac = InstanceProvider.create(DbT7115UwanoseShokanShuruiShikyuGendoGakuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7115UwanoseShokanShuruiShikyuGendoGakuDac}
     */
    UwanoseShokanShuruiShikyuGendoGakuManager(DbT7115UwanoseShokanShuruiShikyuGendoGakuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する上乗せ償還払い給付種類支給限度額を返します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return UwanoseShokanShuruiShikyuGendoGaku
     */
    @Transaction
    public UwanoseShokanShuruiShikyuGendoGaku get上乗せ償還払い給付種類支給限度額(
            ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_サービス種類コード.toString()));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_適用開始年月.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_履歴番号.toString()));

        DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity entity = dac.selectByKey(
                サービス種類コード,
                適用開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new UwanoseShokanShuruiShikyuGendoGaku(entity);
    }

    /**
     * キーに合致する上乗せ償還払い給付種類支給限度額を返します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @return ShokanShuruiShikyuGendoGaku
     */
    @Transaction
    public UwanoseShokanShuruiShikyuGendoGaku get上乗せ償還払い給付種類支給限度額ByValue(
            ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 適用開始年月) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_サービス種類コード.toString()));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_適用開始年月.toString()));

        DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity entity = dac.selectByValue(
                サービス種類コード,
                適用開始年月);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new UwanoseShokanShuruiShikyuGendoGaku(entity);
    }

    /**
     * 上乗せ償還払い給付種類支給限度額を全件返します。
     *
     * @return List<UwanoseShokanShuruiShikyuGendoGaku>
     */
    @Transaction
    public List<UwanoseShokanShuruiShikyuGendoGaku> get上乗せ償還払い給付種類支給限度額一覧() {
        List<UwanoseShokanShuruiShikyuGendoGaku> businessList = new ArrayList<>();

        for (DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new UwanoseShokanShuruiShikyuGendoGaku(entity));
        }

        return businessList;
    }

    /**
     * 上乗せ償還払い給付種類支給限度額を全件返します。
     *
     * @return List<UwanoseShokanShuruiShikyuGendoGaku>
     */
    @Transaction
    public List<UwanoseShokanShuruiShikyuGendoGaku> get上乗せ償還払い給付種類支給限度額データ() {
        List<UwanoseShokanShuruiShikyuGendoGaku> businessList = new ArrayList<>();

        for (DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity entity : dac.selectAllOrder()) {
            entity.initializeMd5();
            businessList.add(new UwanoseShokanShuruiShikyuGendoGaku(entity));
        }

        return businessList;
    }

    /**
     * 上乗せ償還払い給付種類支給限度額{@link UwanoseShokanShuruiShikyuGendoGaku}を保存します。
     *
     * @param 上乗せ償還払い給付種類支給限度額 {@link UwanoseShokanShuruiShikyuGendoGaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save上乗せ償還払い給付種類支給限度額(UwanoseShokanShuruiShikyuGendoGaku 上乗せ償還払い給付種類支給限度額) {
        requireNonNull(上乗せ償還払い給付種類支給限度額, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_上乗せ償還払い給付種類支給限度額.toString()));
        if (!上乗せ償還払い給付種類支給限度額.hasChanged()) {
            return false;
        }
        return 1 == dac.save(上乗せ償還払い給付種類支給限度額.toEntity());
    }

    /**
     * 上乗せ償還払い給付種類支給限度額{@link UwanoseShokanShuruiShikyuGendoGaku}を保存します。
     *
     * @param 上乗せList {@link UwanoseShokanShuruiShikyuGendoGaku}
     */
    @Transaction
    public void save上乗せList(List<UwanoseShokanShuruiShikyuGendoGaku> 上乗せList) {
        if (!上乗せList.isEmpty()) {
            for (UwanoseShokanShuruiShikyuGendoGaku 上乗せ : 上乗せList) {
                requireNonNull(上乗せ,
                        UrSystemErrorMessages.値がnull.getReplacedMessage(定値_上乗せ償還払い給付種類支給限度額.toString()));
                if (!上乗せ.hasChanged()) {
                    continue;
                }
                dac.save(上乗せ.toEntity());
            }
        }
    }

    /**
     * 上乗せ償還払い給付種類支給限度額{@link UwanoseShokanShuruiShikyuGendoGaku}を保存します。
     *
     * @param insert上乗せList {@link UwanoseShokanShuruiShikyuGendoGaku}
     * @param update上乗せList {@link UwanoseShokanShuruiShikyuGendoGaku}
     */
    @Transaction
    public void insertAndUpdate上乗せ(List<UwanoseShokanShuruiShikyuGendoGaku> insert上乗せList,
            List<UwanoseShokanShuruiShikyuGendoGaku> update上乗せList) {
        if (!insert上乗せList.isEmpty()) {
            for (UwanoseShokanShuruiShikyuGendoGaku insert上乗せ : insert上乗せList) {
                requireNonNull(insert上乗せ, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_上乗せ償還払い給付種類支給限度額.toString()));
                dac.save(insert上乗せ.toEntity());
            }
        }
        if (!update上乗せList.isEmpty()) {
            for (UwanoseShokanShuruiShikyuGendoGaku update上乗せ : update上乗せList) {
                requireNonNull(update上乗せ, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_上乗せ償還払い給付種類支給限度額.toString()));
                if (!update上乗せ.hasChanged()) {
                    return;
                }
                dac.save(update上乗せ.toEntity());
            }
        }
    }

    /**
     * 償還払い給付種類支給限度額{@link ShokanShuruiShikyuGendoGaku}を保存します。
     *
     * @param delete上乗せList {@link UwanoseShokanShuruiShikyuGendoGaku}
     * @param update上乗せList {@link UwanoseShokanShuruiShikyuGendoGaku}
     */
    @Transaction
    public void deleteAndUpdate上乗せ(List<UwanoseShokanShuruiShikyuGendoGaku> delete上乗せList,
            List<UwanoseShokanShuruiShikyuGendoGaku> update上乗せList) {
        if (!delete上乗せList.isEmpty()) {
            for (UwanoseShokanShuruiShikyuGendoGaku delete上乗せ : delete上乗せList) {
                requireNonNull(delete上乗せ, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_上乗せ償還払い給付種類支給限度額.toString()));
                if (delete上乗せ.hasChanged()) {
                    return;
                }
                dac.delete(delete上乗せ.toEntity());
            }
        }
        if (!update上乗せList.isEmpty()) {
            for (UwanoseShokanShuruiShikyuGendoGaku update上乗せ : update上乗せList) {
                requireNonNull(update上乗せ, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_上乗せ償還払い給付種類支給限度額.toString()));
                if (!update上乗せ.hasChanged()) {
                    return;
                }
                dac.save(update上乗せ.toEntity());
            }
        }
    }

    /**
     * 主キーに合致する上乗せ償還払い給付種類支給限度額をを削除する。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return 更新が成功するかどうか
     */
    @Transaction
    public Boolean データを物理削除する(
            ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_サービス種類コード.toString()));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_適用開始年月.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_履歴番号.toString()));

        DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity entity = dac.selectByKey(
                サービス種類コード,
                適用開始年月,
                履歴番号);
        entity.initializeMd5();
        return 1 == dac.delete(entity);
    }
}
