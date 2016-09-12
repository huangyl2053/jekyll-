/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ca.cax.business.core.shuno.Shuno;
import jp.co.ndensan.reams.ca.cax.service.core.shuno.ShunoManager;
import jp.co.ndensan.reams.ca.cax.service.core.shuno.ShunoService;
import jp.co.ndensan.reams.db.dbb.business.core.Kiwarigaku;
import jp.co.ndensan.reams.db.dbb.business.core.KiwarigakuCalculator;
import jp.co.ndensan.reams.db.dbx.business.core.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbx.business.core.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KibetsuChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KiwarigakuMeisai;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.relate.KibetsuChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.relate.KibetsuChoteiKyotsuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 期割額を取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KiwarigakuManager {

    private final KibetsuChoteiKyotsuDac dac;
    private final ShunoManager manager;

    /**
     * コンストラクタです。
     */
    public KiwarigakuManager() {
        this.dac = InstanceProvider.create(KibetsuChoteiKyotsuDac.class);
        this.manager = ShunoService.getShunoManager();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param dac 介護期別調定共通Doc
     * @param manager 収納Manager
     */
    KiwarigakuManager(KibetsuChoteiKyotsuDac dac, ShunoManager manager) {
        this.dac = dac;
        this.manager = manager;
    }

    /**
     * 条件に該当する期割額を取得します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @return 期割額
     */
    public Optional<Kiwarigaku> load期割額(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, int 履歴番号) {
        List<KiwarigakuMeisai> 期割額List = new ArrayList<>();
        for (KibetsuChoteiKyotsuEntity 期別調定共通 : dac.select介護期別調定共通一覧(調定年度, 賦課年度, 通知書番号, 履歴番号)) {

            期割額List.add(to期割額(期別調定共通));
        }
        return Optional.ofNullable(new KiwarigakuCalculator(期割額List).calculate());
    }

    private KiwarigakuMeisai to期割額(KibetsuChoteiKyotsuEntity entity) {
        KibetsuChoteiKyotsu 期別調定共通 = new KibetsuChoteiKyotsu(
                new Kibetsu(entity.get介護期別Entity()),
                new ChoteiKyotsu(entity.get調定共通Entity()));
        return new KiwarigakuMeisai(期別調定共通, get収入額(期別調定共通.get調定共通モデル().get収納ID()));
    }

    private Decimal get収入額(Long 収納ID) {
        Shuno 収納 = manager.get収納(収納ID);
        return (収納 != null) ? 収納.get収入合計情報().get本税() : Decimal.ZERO;
    }
}
