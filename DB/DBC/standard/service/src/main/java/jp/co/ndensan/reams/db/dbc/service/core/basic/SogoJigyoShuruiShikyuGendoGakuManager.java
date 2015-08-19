/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7118SogoJigyoShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7118SogoJigyoShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護予防・日常生活支援総合事業種類支給限度額を管理するクラスです。
 */
public class SogoJigyoShuruiShikyuGendoGakuManager {

    private final DbT7118SogoJigyoShuruiShikyuGendoGakuDac dac;

    /**
     * コンストラクタです。
     */
    public SogoJigyoShuruiShikyuGendoGakuManager() {
        dac = InstanceProvider.create(DbT7118SogoJigyoShuruiShikyuGendoGakuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7118SogoJigyoShuruiShikyuGendoGakuDac}
     */
    SogoJigyoShuruiShikyuGendoGakuManager(DbT7118SogoJigyoShuruiShikyuGendoGakuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護予防・日常生活支援総合事業種類支給限度額を返します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return SogoJigyoShuruiShikyuGendoGaku
     */
    @Transaction
    public SogoJigyoShuruiShikyuGendoGaku get介護予防

    ・日常生活支援総合事業種類支給限度額(
            ServiceShuruiCode サービス種類コード,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT7118SogoJigyoShuruiShikyuGendoGakuEntity entity = dac.selectByKey(
                サービス種類コード,
                要介護状態区分,
                適用開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new SogoJigyoShuruiShikyuGendoGaku(entity);
    }

    /**
     * 介護予防・日常生活支援総合事業種類支給限度額を全件返します。
     *
     * @return List<SogoJigyoShuruiShikyuGendoGaku>
     */
    @Transaction
    public List<SogoJigyoShuruiShikyuGendoGaku> get介護予防

    ・日常生活支援総合事業種類支給限度額一覧() {
        List<SogoJigyoShuruiShikyuGendoGaku> businessList = new ArrayList<>();

        for (DbT7118SogoJigyoShuruiShikyuGendoGakuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new SogoJigyoShuruiShikyuGendoGaku(entity));
        }

        return businessList;
    }

    /**
     * 介護予防・日常生活支援総合事業種類支給限度額{@link SogoJigyoShuruiShikyuGendoGaku}を保存します。
     *
     * @param 介護予防・日常生活支援総合事業種類支給限度額 {@link SogoJigyoShuruiShikyuGendoGaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護予防

    ・日常生活支援総合事業種類支給限度額(SogoJigyoShuruiShikyuGendoGaku 介護予防
        ・日常生活支援総合事業種類支給限度額) {
        requireNonNull(介護予防・日常生活支援総合事業種類支給限度額
        , UrSystemErrorMessages.値がnull.getReplacedMessage("介護予防・日常生活支援総合事業種類支給限度額")
        );
        if (!介護予防 {

        }
        ・日常生活支援総合事業種類支給限度額.hasChanged()

            ) {
            return false;
        }
        return 1 == dac.save(介護予防
        ・日常生活支援総合事業種類支給限度額.toEntity()


);
    }
}
