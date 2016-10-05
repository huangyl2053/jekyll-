/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kaigohokenryogemmen;

import jp.co.ndensan.reams.db.dbb.business.core.fuka.NendobunFukaGemmenList;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiShorikoaResult;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.NendobunFukaList;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;

/**
 * 介護保険料減免
 *
 * @reamsid_L DBB-1660-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NendobunFukaGemmenListResult {

    private NendobunFukaGemmenList 年度分賦課減免リスト;
    private ChoshuHoho 介護徴収方法;

    /**
     * コンストラクタです。
     */
    public NendobunFukaGemmenListResult() {
    }

    /**
     * コンストラクタです。
     *
     * @param 賦課情報 KoseiShorikoaResult
     * @param 減免情報 NendobunFukaGemmenList
     */
    public NendobunFukaGemmenListResult(KoseiShorikoaResult 賦課情報, NendobunFukaGemmenList 減免情報) {
        this.介護徴収方法 = 賦課情報.get徴収方法の情報_更正後();
        NendobunFukaList 年度分賦課リスト = 賦課情報.get年度分賦課リスト_更正後();
        NendobunFukaGemmenList 年度分減免リスト = new NendobunFukaGemmenList();
        年度分減免リスト.set賦課年度(年度分賦課リスト.get賦課年度());
        年度分減免リスト.setHas過年度賦課(年度分賦課リスト.isHas過年度賦課());
        年度分減免リスト.set通知書番号(年度分賦課リスト.get通知書番号());
        年度分減免リスト.set賦課期日(年度分賦課リスト.get賦課期日());
        FukaJoho fukaJoho = 年度分賦課リスト.get最新賦課の情報();
        if (fukaJoho != null && 減免情報.get最新減免の情報() != null) {
            年度分減免リスト.set最新減免の情報(fukaJoho.get減免の情報(減免情報.get最新減免の情報()));
        }
        FukaJoho 現年度 = 年度分賦課リスト.get現年度();
        if (現年度 != null && 減免情報.get現年度() != null) {
            年度分減免リスト.set現年度(現年度.get減免の情報(減免情報.get現年度()));
        }
        FukaJoho 過年度1 = 年度分賦課リスト.get過年度1();
        if (過年度1 != null && 減免情報.get過年度1() != null) {
            年度分減免リスト.set過年度1(過年度1.get減免の情報(減免情報.get過年度1()));
        }
        FukaJoho 過年度2 = 年度分賦課リスト.get過年度2();
        if (過年度2 != null && 減免情報.get過年度2() != null) {
            年度分減免リスト.set過年度2(過年度2.get減免の情報(減免情報.get過年度2()));
        }
        FukaJoho 過年度3 = 年度分賦課リスト.get過年度3();
        if (過年度3 != null && 減免情報.get過年度3() != null) {
            年度分減免リスト.set過年度3(過年度3.get減免の情報(減免情報.get過年度3()));
        }
        FukaJoho 過年度4 = 年度分賦課リスト.get過年度4();
        if (過年度4 != null && 減免情報.get過年度4() != null) {
            年度分減免リスト.set過年度4(過年度4.get減免の情報(減免情報.get過年度4()));
        }
        FukaJoho 過年度5 = 年度分賦課リスト.get過年度5();
        if (過年度5 != null && 減免情報.get過年度5() != null) {
            年度分減免リスト.set過年度5(過年度5.get減免の情報(減免情報.get過年度5()));
        }
        this.年度分賦課減免リスト = 年度分減免リスト;
    }
}
