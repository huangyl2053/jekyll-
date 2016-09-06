/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7112ShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7112ShokanShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払い給付種類支給限度額を管理するクラスです。
 */
public class ShokanShuruiShikyuGendoGakuManager {

    private final DbT7112ShokanShuruiShikyuGendoGakuDac dac;
    private static final RString 定値_サービス種類コード = new RString("サービス種類コード");
    private static final RString 定値_適用開始年月 = new RString("適用開始年月");
    private static final RString 定値_履歴番号 = new RString("履歴番号");
    private static final RString 定値_償還払い給付種類支給限度額 = new RString("償還払い給付種類支給限度額");

    /**
     * コンストラクタです。
     */
    public ShokanShuruiShikyuGendoGakuManager() {
        dac = InstanceProvider.create(DbT7112ShokanShuruiShikyuGendoGakuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7112ShokanShuruiShikyuGendoGakuDac}
     */
    ShokanShuruiShikyuGendoGakuManager(DbT7112ShokanShuruiShikyuGendoGakuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する償還払い給付種類支給限度額を返します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return ShokanShuruiShikyuGendoGaku
     */
    @Transaction
    public ShokanShuruiShikyuGendoGaku get償還払い給付種類支給限度額(
            ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_サービス種類コード.toString()));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_適用開始年月.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_履歴番号.toString()));

        DbT7112ShokanShuruiShikyuGendoGakuEntity entity = dac.selectByKey(
                サービス種類コード,
                適用開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanShuruiShikyuGendoGaku(entity);
    }

    /**
     * キーに合致する償還払い給付種類支給限度額を返します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @return ShokanShuruiShikyuGendoGaku
     */
    @Transaction
    public ShokanShuruiShikyuGendoGaku get償還払い給付種類支給限度額ByValue(
            ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 適用開始年月) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_サービス種類コード.toString()));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_適用開始年月.toString()));

        DbT7112ShokanShuruiShikyuGendoGakuEntity entity = dac.selectByValue(
                サービス種類コード,
                適用開始年月);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanShuruiShikyuGendoGaku(entity);
    }

    /**
     * 償還払い給付種類支給限度額を全件返します。
     *
     * @return List<ShokanShuruiShikyuGendoGaku>
     */
    @Transaction
    public List<ShokanShuruiShikyuGendoGaku> get償還払い給付種類支給限度額一覧() {
        List<ShokanShuruiShikyuGendoGaku> businessList = new ArrayList<>();

        for (DbT7112ShokanShuruiShikyuGendoGakuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanShuruiShikyuGendoGaku(entity));
        }

        return businessList;
    }

    /**
     * 償還払い給付種類支給限度額を全件返します。
     *
     * @return List<ShokanShuruiShikyuGendoGaku>
     */
    @Transaction
    public List<ShokanShuruiShikyuGendoGaku> get償還払い給付種類支給限度額データ() {
        List<ShokanShuruiShikyuGendoGaku> businessList = new ArrayList<>();

        for (DbT7112ShokanShuruiShikyuGendoGakuEntity entity : dac.selectAllOrder()) {
            entity.initializeMd5();
            businessList.add(new ShokanShuruiShikyuGendoGaku(entity));
        }

        return businessList;
    }

    /**
     * 償還払い給付種類支給限度額{@link ShokanShuruiShikyuGendoGaku}を保存します。
     *
     * @param 償還払い給付種類支給限度額 {@link ShokanShuruiShikyuGendoGaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還払い給付種類支給限度額(ShokanShuruiShikyuGendoGaku 償還払い給付種類支給限度額) {
        requireNonNull(償還払い給付種類支給限度額, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_償還払い給付種類支給限度額.toString()));
        if (!償還払い給付種類支給限度額.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還払い給付種類支給限度額.toEntity());
    }

    /**
     * 償還払い給付種類支給限度額{@link ShokanShuruiShikyuGendoGaku}を保存します。
     *
     * @param 償還List {@link ShokanShuruiShikyuGendoGaku}
     */
    @Transaction
    public void save償還List(List<ShokanShuruiShikyuGendoGaku> 償還List) {
        if (!償還List.isEmpty()) {
            for (ShokanShuruiShikyuGendoGaku 償還 : 償還List) {
                requireNonNull(償還, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_償還払い給付種類支給限度額.toString()));
                if (!償還.hasChanged()) {
                    continue;
                }
                dac.save(償還.toEntity());
            }
        }
    }

    /**
     * 償還払い給付種類支給限度額{@link ShokanShuruiShikyuGendoGaku}を保存します。
     *
     * @param insert償還List {@link ShokanShuruiShikyuGendoGaku}
     * @param update償還List {@link ShokanShuruiShikyuGendoGaku}
     */
    @Transaction
    public void insertAndUpdate償還(List<ShokanShuruiShikyuGendoGaku> insert償還List, List<ShokanShuruiShikyuGendoGaku> update償還List) {
        if (!insert償還List.isEmpty()) {
            for (ShokanShuruiShikyuGendoGaku insert償還 : insert償還List) {
                requireNonNull(insert償還, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_償還払い給付種類支給限度額.toString()));
                dac.save(insert償還.toEntity());
            }
        }
        if (!update償還List.isEmpty()) {
            for (ShokanShuruiShikyuGendoGaku update償還 : update償還List) {
                requireNonNull(update償還, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_償還払い給付種類支給限度額.toString()));
                if (!update償還.hasChanged()) {
                    return;
                }
                dac.save(update償還.toEntity());
            }
        }
    }

    /**
     * 償還払い給付種類支給限度額{@link ShokanShuruiShikyuGendoGaku}を保存します。
     *
     * @param delete償還List {@link ShokanShuruiShikyuGendoGaku}
     * @param update償還List {@link ShokanShuruiShikyuGendoGaku}
     */
    @Transaction
    public void deleteAndUpdate償還(List<ShokanShuruiShikyuGendoGaku> delete償還List, List<ShokanShuruiShikyuGendoGaku> update償還List) {
        if (!delete償還List.isEmpty()) {
            for (ShokanShuruiShikyuGendoGaku delete償還 : delete償還List) {
                requireNonNull(delete償還, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_償還払い給付種類支給限度額.toString()));
                if (delete償還.hasChanged()) {
                    return;
                }
                dac.delete(delete償還.toEntity());
            }
        }
        if (!update償還List.isEmpty()) {
            for (ShokanShuruiShikyuGendoGaku update償還 : update償還List) {
                requireNonNull(update償還, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_償還払い給付種類支給限度額.toString()));
                if (!update償還.hasChanged()) {
                    return;
                }
                dac.save(update償還.toEntity());
            }
        }
    }

    /**
     * 主キーに合致する償還払い給付種類支給限度額を削除する。
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

        DbT7112ShokanShuruiShikyuGendoGakuEntity entity = dac.selectByKey(
                サービス種類コード,
                適用開始年月,
                履歴番号);
        entity.initializeMd5();
        return 1 == dac.delete(entity);
    }
}
