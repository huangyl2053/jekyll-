/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kogakushinsei.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3056KogakuShikyuShinseiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額介護サービス費支給申請を管理するクラスです。
 */
public class KogakuShikyuShinseiManager {

    private final DbT3056KogakuShikyuShinseiDac dac;

    /**
     * コンストラクタです。
     */
    public KogakuShikyuShinseiManager() {
        dac = InstanceProvider.create(DbT3056KogakuShikyuShinseiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3056KogakuShikyuShinseiDac}
     */
    KogakuShikyuShinseiManager(DbT3056KogakuShikyuShinseiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する高額介護サービス費支給申請を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 履歴番号 RirekiNo
     * @return KogakuShikyuShinsei
     */
    @Transaction
    public KogakuShikyuShinsei get高額介護サービス費支給申請(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3056KogakuShikyuShinseiEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                証記載保険者番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KogakuShikyuShinsei(entity);
    }

    /**
     * 高額介護サービス費支給申請を全件返します。
     *
     * @return List<KogakuShikyuShinsei>
     */
    @Transaction
    public List<KogakuShikyuShinsei> get高額介護サービス費支給申請一覧() {
        List<KogakuShikyuShinsei> businessList = new ArrayList<>();

        for (DbT3056KogakuShikyuShinseiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KogakuShikyuShinsei(entity));
        }

        return businessList;
    }

    /**
     * 高額介護サービス費支給申請{@link KogakuShikyuShinsei}を保存します。
     *
     * @param 高額介護サービス費支給申請 {@link KogakuShikyuShinsei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save高額介護サービス費支給申請(KogakuShikyuShinsei 高額介護サービス費支給申請) {
        requireNonNull(高額介護サービス費支給申請, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費支給申請"));
        if (!高額介護サービス費支給申請.hasChanged()) {
            return false;
        }
        return 1 == dac.save(高額介護サービス費支給申請.toEntity());
    }
}
