/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimusha;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.rentainofugimusha.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2009RentaiGimushaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 連帯納付義務者を管理するクラスです。
 */
public class RentaiGimushaManager {

    private final DbT2009RentaiGimushaDac dac;

    /**
     * コンストラクタです。
     */
    public RentaiGimushaManager() {
        dac = InstanceProvider.create(DbT2009RentaiGimushaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2009RentaiGimushaDac}
     */
    RentaiGimushaManager(DbT2009RentaiGimushaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する連帯納付義務者を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return RentaiGimusha
     */
    @Transaction
    public RentaiGimusha get連帯納付義務者(
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT2009RentaiGimushaEntity entity = dac.selectByKey(
                被保険者番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new RentaiGimusha(entity);
    }

    /**
     * 連帯納付義務者を全件返します。
     *
     * @return List<RentaiGimusha>
     */
    @Transaction
    public List<RentaiGimusha> get連帯納付義務者一覧() {
        List<RentaiGimusha> businessList = new ArrayList<>();

        for (DbT2009RentaiGimushaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new RentaiGimusha(entity));
        }

        return businessList;
    }

    /**
     * 連帯納付義務者{@link RentaiGimusha}を保存します。
     *
     * @param 連帯納付義務者 {@link RentaiGimusha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save連帯納付義務者(RentaiGimusha 連帯納付義務者) {
        requireNonNull(連帯納付義務者, UrSystemErrorMessages.値がnull.getReplacedMessage("連帯納付義務者"));
        if (!連帯納付義務者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(連帯納付義務者.toEntity());
    }
}
