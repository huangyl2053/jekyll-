/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kogakushinsei.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3057KogakuShikyuHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額介護サービス費支給判定結果を管理するクラスです。
 */
public class KogakuShikyuHanteiKekkaManager {

    private final DbT3057KogakuShikyuHanteiKekkaDac dac;

    /**
     * コンストラクタです。
     */
    public KogakuShikyuHanteiKekkaManager() {
        dac = InstanceProvider.create(DbT3057KogakuShikyuHanteiKekkaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3057KogakuShikyuHanteiKekkaDac}
     */
    KogakuShikyuHanteiKekkaManager(DbT3057KogakuShikyuHanteiKekkaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する高額介護サービス費支給判定結果を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 履歴番号 RirekiNo
     * @return KogakuShikyuHanteiKekka
     */
    @Transaction
    public KogakuShikyuHanteiKekka get高額介護サービス費支給判定結果(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3057KogakuShikyuHanteiKekkaEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                証記載保険者番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KogakuShikyuHanteiKekka(entity);
    }

    /**
     * 高額介護サービス費支給判定結果を全件返します。
     *
     * @return List<KogakuShikyuHanteiKekka>
     */
    @Transaction
    public List<KogakuShikyuHanteiKekka> get高額介護サービス費支給判定結果一覧() {
        List<KogakuShikyuHanteiKekka> businessList = new ArrayList<>();

        for (DbT3057KogakuShikyuHanteiKekkaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KogakuShikyuHanteiKekka(entity));
        }

        return businessList;
    }

    /**
     * 高額介護サービス費支給判定結果{@link KogakuShikyuHanteiKekka}を保存します。
     *
     * @param 高額介護サービス費支給判定結果 {@link KogakuShikyuHanteiKekka}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save高額介護サービス費支給判定結果(KogakuShikyuHanteiKekka 高額介護サービス費支給判定結果) {
        requireNonNull(高額介護サービス費支給判定結果, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費支給判定結果"));
        if (!高額介護サービス費支給判定結果.hasChanged()) {
            return false;
        }
        return 1 == dac.save(高額介護サービス費支給判定結果.toEntity());
    }
}
