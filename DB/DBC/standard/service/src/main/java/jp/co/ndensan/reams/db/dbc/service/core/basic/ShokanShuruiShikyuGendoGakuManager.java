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
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7112ShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.basic.DbT7112ShokanShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払い給付種類支給限度額を管理するクラスです。
 */
public class ShokanShuruiShikyuGendoGakuManager {

    private final DbT7112ShokanShuruiShikyuGendoGakuDac dac;

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
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

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
     * 償還払い給付種類支給限度額{@link ShokanShuruiShikyuGendoGaku}を保存します。
     *
     * @param 償還払い給付種類支給限度額 {@link ShokanShuruiShikyuGendoGaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還払い給付種類支給限度額(ShokanShuruiShikyuGendoGaku 償還払い給付種類支給限度額) {
        requireNonNull(償還払い給付種類支給限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払い給付種類支給限度額"));
        if (!償還払い給付種類支給限度額.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還払い給付種類支給限度額.toEntity());
    }
}
