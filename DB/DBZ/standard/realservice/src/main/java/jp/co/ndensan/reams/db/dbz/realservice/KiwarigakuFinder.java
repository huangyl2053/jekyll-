/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.Kiwarigaku;
import jp.co.ndensan.reams.db.dbz.business.KiwarigakuCalculator;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.model.fuka.KiwarigakuMeisai;
import jp.co.ndensan.reams.db.dbz.model.relate.fuka.KibetsuChoteiKyotsuModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KibetsuChoteiKyotsuDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urc.business.IShuno;
import jp.co.ndensan.reams.ur.urc.realservice.IShunoManager;
import jp.co.ndensan.reams.ur.urc.realservice.ShunoService;
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
        //TODO dacが見つからなくてエラーする。収納で修正中。（1月中）
//        this.manager = ShunoService.getShunoManager();
        this.manager = null;
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
    public IOptional<Kiwarigaku> load期割額(ChoteiNendo 調定年度, FukaNendo 賦課年度, TsuchishoNo 通知書番号, RDateTime 処理日時) {
        List<KiwarigakuMeisai> 期割額List = new ArrayList<>();
        for (KibetsuChoteiKyotsuModel 期別調定共通 : dac.select介護期別調定共通一覧(調定年度, 賦課年度, 通知書番号, 処理日時)) {
            期割額List.add(to期割額(期別調定共通));
        }
        return DbOptional.ofNullable(new KiwarigakuCalculator(期割額List).calculate());
    }

    private KiwarigakuMeisai to期割額(KibetsuChoteiKyotsuModel 期別調定共通) {
        return new KiwarigakuMeisai(期別調定共通, get収入額(期別調定共通.get調定共通モデル().get収納ID()));
    }

    private Decimal get収入額(Long 収納ID) {
        //TODO dacが見つからなくてエラーする。収納で修正中。（1月中）
//        IShuno 収納 = manager.get収納(収納ID);
        IShuno 収納 = null;
        return (収納 != null) ? 収納.get収入合計情報().get本税() : Decimal.ZERO;
    }
}
