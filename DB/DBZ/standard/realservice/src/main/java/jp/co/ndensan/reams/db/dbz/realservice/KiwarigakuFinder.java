/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.Kiwarigaku;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KibetsuChoteiKyotsuDac;
import jp.co.ndensan.reams.ur.urc.realservice.IShunoManager;
import jp.co.ndensan.reams.ur.urc.realservice.ShunoService;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

// TODO N8156 宮本 康 別ブランチで対応中。マージ時にget期割額()の戻り値を変更する。
public class KiwarigakuFinder {

    private final KibetsuChoteiKyotsuDac dac;
    private final IShunoManager manager;

    public KiwarigakuFinder() {
        this.dac = InstanceProvider.create(KibetsuChoteiKyotsuDac.class);
        this.manager = ShunoService.getShunoManager();
    }

    KiwarigakuFinder(KibetsuChoteiKyotsuDac dac, IShunoManager manager) {
        this.dac = dac;
        this.manager = manager;
    }

    public IOptional<Kiwarigaku> get期割額(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, RDateTime 処理日時) {
        return null;
    }
}
