/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7109KubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7109KubunShikyuGendoGakuDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅サービス区分支給限度額を管理するクラスです。
 */
public class KubunShikyuGendoGakuManager {

    private final DbT7109KubunShikyuGendoGakuDac dac;

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
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

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
     * 居宅サービス区分支給限度額{@link KubunShikyuGendoGaku}を保存します。
     *
     * @param 居宅サービス区分支給限度額 {@link KubunShikyuGendoGaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save居宅サービス区分支給限度額(KubunShikyuGendoGaku 居宅サービス区分支給限度額) {
        requireNonNull(居宅サービス区分支給限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分支給限度額"));
        if (!居宅サービス区分支給限度額.hasChanged()) {
            return false;
        }
        return 1 == dac.save(居宅サービス区分支給限度額.toEntity());
    }
}
