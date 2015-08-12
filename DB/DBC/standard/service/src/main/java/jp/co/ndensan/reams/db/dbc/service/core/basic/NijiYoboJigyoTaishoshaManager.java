/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3100NijiYoboJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 二次予防事業対象者を管理するクラスです。
 */
public class NijiYoboJigyoTaishoshaManager {

    private final DbT3100NijiYoboJigyoTaishoshaDac dac;

    /**
     * コンストラクタです。
     */
    public NijiYoboJigyoTaishoshaManager() {
        dac = InstanceProvider.create(DbT3100NijiYoboJigyoTaishoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3100NijiYoboJigyoTaishoshaDac}
     */
    NijiYoboJigyoTaishoshaManager(DbT3100NijiYoboJigyoTaishoshaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する二次予防事業対象者を返します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return NijiYoboJigyoTaishosha
     */
    @Transaction
    public NijiYoboJigyoTaishosha get二次予防事業対象者(
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3100NijiYoboJigyoTaishoshaEntity entity = dac.selectByKey(
                証記載保険者番号,
                被保険者番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NijiYoboJigyoTaishosha(entity);
    }

    /**
     * 二次予防事業対象者を全件返します。
     *
     * @return List<NijiYoboJigyoTaishosha>
     */
    @Transaction
    public List<NijiYoboJigyoTaishosha> get二次予防事業対象者一覧() {
        List<NijiYoboJigyoTaishosha> businessList = new ArrayList<>();

        for (DbT3100NijiYoboJigyoTaishoshaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NijiYoboJigyoTaishosha(entity));
        }

        return businessList;
    }

    /**
     * 二次予防事業対象者{@link NijiYoboJigyoTaishosha}を保存します。
     *
     * @param 二次予防事業対象者 {@link NijiYoboJigyoTaishosha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save二次予防事業対象者(NijiYoboJigyoTaishosha 二次予防事業対象者) {
        requireNonNull(二次予防事業対象者, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防事業対象者"));
        if (!二次予防事業対象者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(二次予防事業対象者.toEntity());
    }
}
