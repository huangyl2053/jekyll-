/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 上乗せ償還払い給付種類支給限度額を管理するクラスです。
 */
public class UwanoseShokanShuruiShikyuGendoGakuManager {

    private final DbT7115UwanoseShokanShuruiShikyuGendoGakuDac dac;

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
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

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
     * 上乗せ償還払い給付種類支給限度額{@link UwanoseShokanShuruiShikyuGendoGaku}を保存します。
     *
     * @param 上乗せ償還払い給付種類支給限度額 {@link UwanoseShokanShuruiShikyuGendoGaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save上乗せ償還払い給付種類支給限度額(UwanoseShokanShuruiShikyuGendoGaku 上乗せ償還払い給付種類支給限度額) {
        requireNonNull(上乗せ償還払い給付種類支給限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("上乗せ償還払い給付種類支給限度額"));
        if (!上乗せ償還払い給付種類支給限度額.hasChanged()) {
            return false;
        }
        return 1 == dac.save(上乗せ償還払い給付種類支給限度額.toEntity());
    }
}
