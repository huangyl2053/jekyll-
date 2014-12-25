/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.model.KiwarigakuMeisai;
import jp.co.ndensan.reams.db.dbb.model.relate.KibetsuChoteiKyotsuModel;
import jp.co.ndensan.reams.db.dbb.persistence.relate.KibetsuChoteiKyotsuDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.ItemList;
import jp.co.ndensan.reams.ur.urc.business.IShuno;
import jp.co.ndensan.reams.ur.urc.realservice.IShunoManager;
import jp.co.ndensan.reams.ur.urc.realservice.ShunoService;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 期割額を取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KiwarigakuFinder {

    private final KibetsuChoteiKyotsuDac dac;
    private final IShunoManager manager;

    /**
     * コンストラクタです。
     */
    public KiwarigakuFinder() {
        this.dac = InstanceProvider.create(KibetsuChoteiKyotsuDac.class);
        this.manager = ShunoService.getShunoManager();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param dac 介護期別調定共通Doc
     * @param manager 収納Manager
     */
    KiwarigakuFinder(KibetsuChoteiKyotsuDac dac, IShunoManager manager) {
        this.dac = dac;
        this.manager = manager;
    }

    /**
     * 条件に該当する期割額を取得します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 処理日時 処理日時
     * @return 期割額
     */
    public IItemList<KiwarigakuMeisai> load期割額(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, RDateTime 処理日時) {
        List<KiwarigakuMeisai> 期割額List = new ArrayList<>();
        for (KibetsuChoteiKyotsuModel 期別調定共通 : dac.select介護期別調定共通一覧(調定年度, 賦課年度, 通知書番号, 処理日時)) {
            期割額List.add(to期割額(期別調定共通));
        }
        return ItemList.of(期割額List);
    }

    private KiwarigakuMeisai to期割額(KibetsuChoteiKyotsuModel 期別調定共通) {
        return new KiwarigakuMeisai(期別調定共通, get収入額(期別調定共通.get調定共通モデル().get収納ID()));
    }

    private Decimal get収入額(Long 収納ID) {
        IShuno 収納 = manager.get収納(収納ID);
        return (収納 != null) ? 収納.get収入合計情報().get本税() : null;
    }
}
