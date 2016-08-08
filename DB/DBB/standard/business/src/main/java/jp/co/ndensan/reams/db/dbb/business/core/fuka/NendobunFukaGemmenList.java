/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.NendobunFukaList;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmenjoho.GemmenJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 年度分賦課減免リスト
 *
 * @reamsid_L DBB-1660-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NendobunFukaGemmenList implements Serializable {

    private FlexibleYear 賦課年度;
    private TsuchishoNo 通知書番号;
    private GemmenJoho 現年度;
    private GemmenJoho 過年度1;
    private GemmenJoho 過年度2;
    private GemmenJoho 過年度3;
    private GemmenJoho 過年度4;
    private GemmenJoho 過年度5;
    private FlexibleDate 賦課期日;
    private boolean has過年度賦課;
    private GemmenJoho 最新減免の情報;

    /**
     * 年度分賦課減免リストは年度分賦課リストに変換する。
     *
     * @return 年度分賦課リスト NendobunFukaList
     */
    public NendobunFukaList to年度分賦課リスト() {
        NendobunFukaList 年度分賦課リスト = new NendobunFukaList();
        年度分賦課リスト.setHas過年度賦課(has過年度賦課);
        if (最新減免の情報 != null) {
            年度分賦課リスト.set最新賦課の情報(最新減免の情報.get賦課の情報());
        }
        if (現年度 != null) {
            年度分賦課リスト.set現年度(現年度.get賦課の情報());
        }
        if (過年度1 != null) {
            年度分賦課リスト.set過年度1(過年度1.get賦課の情報());
        }
        if (過年度2 != null) {
            年度分賦課リスト.set過年度2(過年度2.get賦課の情報());
        }
        年度分賦課リスト.set賦課年度(賦課年度);
        年度分賦課リスト.set賦課期日(賦課期日);
        年度分賦課リスト.set通知書番号(通知書番号);
        return 年度分賦課リスト;
    }
}
