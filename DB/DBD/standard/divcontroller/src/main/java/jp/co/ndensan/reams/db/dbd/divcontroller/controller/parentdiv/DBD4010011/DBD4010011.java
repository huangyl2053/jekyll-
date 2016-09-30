/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4010011;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD221010.DBD221010_ShogaishaKojoTaishoshaHaakuParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4010011.DBD4010011Div;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4010011.DBD4010011Handler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4010011.DBD4010011ValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 障がい者控除対象者認定のDivControllerです。
 *
 * @reamsid_L DBD-3850-010 liuwei2
 */
public class DBD4010011 {

    /**
     * 障がい者控除対象者認定の初期化。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<DBD4010011Div> onLoad(DBD4010011Div div) {
        div.getShogaishaKojoNinteiJoho().getKeteiNengabi().setValue(RDate.getNowDate());
        div.getShogaishaKojoNinteiJoho().getSinseiNengabi().setValue(RDate.getNowDate());
        div.getShogaishaKojoNinteiJoho().getTaishoNendo().setValue(RDate.getNowDate());
        div.getShogaishaKojoTaishoshaHaakuJoken().getTxtKijunYMD().setValue(RDate.getNowDate());
        return ResponseData.of(div).respond();
    }

    /**
     * before「実行する」ボタンをクッリク
     *
     * @param div コントロールdiv
     * @return ResponseData<DBD4010011Div>
     */
    public ResponseData<DBD4010011Div> beforeOnClick_btnJiKou(DBD4010011Div div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().基準日の必須入力(pairs, div);
        getValidationHandler().対象年度の必須入力(pairs, div);
        getValidationHandler().申請年月日の必須入力(pairs, div);
        getValidationHandler().決定年月日の必須入力(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンをクッリク
     *
     * @param div コントロールdiv
     * @return ResponseData<ShogaishaKojoTaishoshaHaakuKekkaIchiranParameter>
     */
    public ResponseData<DBD221010_ShogaishaKojoTaishoshaHaakuParameter> onClick_btnJiKou(DBD4010011Div div) {
        DBD221010_ShogaishaKojoTaishoshaHaakuParameter parameter = getHandler(div).getParameter();
        return ResponseData.of(parameter).respond();
    }

    private DBD4010011ValidationHandler getValidationHandler() {
        return new DBD4010011ValidationHandler();
    }

    private DBD4010011Handler getHandler(DBD4010011Div div) {
        return new DBD4010011Handler(div);
    }
}
