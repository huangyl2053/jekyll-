/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4030011;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.shogaishakojotaishoshalist.ShogaishaKojoTaishoshaListParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4030011.ShogaishaKoujoTaishoNinteiShoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4030011.ShogaishaKoujoTaishoNinteiShoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4030011.ShogaishaKoujoTaishoNinteiShoValidationHandler;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 障がい者控除対象者認定書一括発行画面のDivControllerです
 *
 * @reamsid_L DBD-3860-010 donghj
 */
public class ShogaishaKoujoTaishoNinteiSho {

    /**
     * 画面初期化
     *
     * @param div ShogaishaKoujoTaishoNinteiShoDiv
     * @return ResponseData<ShogaishaKoujoTaishoNinteiShoDiv>
     */
    public ResponseData<ShogaishaKoujoTaishoNinteiShoDiv> onLoad(ShogaishaKoujoTaishoNinteiShoDiv div) {
        ShogaishaKoujoTaishoNinteiShoHandler handler = getHandler(div);
        handler.onLoad();
        RDate rDate = RDate.getNowDate();
        div.getShogaishaKojoNinteishoOutput().getTxtKofuDay().setValue(rDate);
        div.getShogaishaKojoNinteishoOutput().getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100025.getReportId());
        return ResponseData.of(div).respond();

    }

    /**
     * 「実行」ボタン押下時の処理です。
     *
     * @param div ShogaishaKoujoTaishoNinteiShoDiv
     * @return レスポンスデータ
     */
    public ResponseData<ShogaishaKoujoTaishoNinteiShoDiv> onClick_btnNintei(ShogaishaKoujoTaishoNinteiShoDiv div) {

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor対象年度の必須入力(pairs, div);
        getValidationHandler().validateFor出力順序の必須入力(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行確認ダイアログYesを実行する。
     *
     * @param div ShogaishaKoujoTaishoNinteiShoDiv
     * @return ResponseData<ShogaishaKojoTaishoshaListParameter>
     */
    public ResponseData<ShogaishaKojoTaishoshaListParameter> onClick_btnJiko(ShogaishaKoujoTaishoNinteiShoDiv div) {
        ShogaishaKojoTaishoshaListParameter parameter = getHandler(div).getParameter();
        return ResponseData.of(parameter).respond();
    }

    private ShogaishaKoujoTaishoNinteiShoHandler getHandler(ShogaishaKoujoTaishoNinteiShoDiv div) {
        return new ShogaishaKoujoTaishoNinteiShoHandler(div);
    }

    private ShogaishaKoujoTaishoNinteiShoValidationHandler getValidationHandler() {
        return new ShogaishaKoujoTaishoNinteiShoValidationHandler();
    }

}
