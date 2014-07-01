/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KozaPayment.KozaPaymentDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3317 塚田 萌
 */
public final class KozaPayment {

    private KozaPayment() {
    }

    /**
     * 共有子Div KozaPayment にYamlデータをセットします。
     *
     * @param kozaDiv KozaPaymentDiv
     * @param rowId YamlデータのId
     */
    public static void setData(KozaPaymentDiv kozaDiv, int rowId) {

        List<HashMap> targetSource = YamlLoader.DBZ.loadAsList(new RString("KozaPayment.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(rowId));

        kozaDiv.getTxtKinyuKikanCode().setValue(cg.getAsRString("kinyuKikanCode"));
        kozaDiv.getTxtKinyuKikanName().setValue(cg.getAsRString("kinyuKikanName"));
        kozaDiv.getTxtKinyuKikanBrunchCode().setValue(cg.getAsRString("kinyuBranchCode"));
        kozaDiv.getTxtKinyuKikanBrunchName().setValue(cg.getAsRString("kinyuBranchName"));
        kozaDiv.getRadKozaShubetsu().setSelectedItem(cg.getAsRString("kozaShubetsu"));
        kozaDiv.getTxtKozaNo().setValue(cg.getAsRString("kozaNo"));
        kozaDiv.getTxtKozaMeigininKana().setValue(cg.getAsRString("kozaMeigininKanaName"));
        kozaDiv.getTxtKozaMeiginin().setValue(cg.getAsRString("kozaMeigininName"));
    }
}
