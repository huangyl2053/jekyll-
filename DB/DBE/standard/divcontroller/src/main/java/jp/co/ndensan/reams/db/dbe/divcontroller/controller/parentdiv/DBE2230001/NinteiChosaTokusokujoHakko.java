/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2230001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE223001.DBE223001_NinteichosaTokusokujyoParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.ninteichosatokusokujohakko.NinteiChosaTokusokujoHakkoTempData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2230001.NinteiChosaTokusokujoHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2230001.NinteiChosaTokusokujoHakkoHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 認定調査督促状発行のコントローラです。
 *
 * @reamsid_L DBE-0030-010 liangbc
 */
public class NinteiChosaTokusokujoHakko {

    /**
     * サービスコード検索一覧初期化の設定します。
     *
     * @param div NinteiChosaTokusokujoHakkoDiv
     * @return ResponseData<NinteiChosaTokusokujoHakkoDiv>
     */
    public ResponseData<NinteiChosaTokusokujoHakkoDiv> onLoad(NinteiChosaTokusokujoHakkoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタンをクリックの設定します。
     *
     * @param div NinteiChosaTokusokujoHakkoDiv
     * @return ResponseData<NinteiChosaTokusokujoHakkoDiv>
     */
    public ResponseData<NinteiChosaTokusokujoHakkoDiv> beforeJikkou(NinteiChosaTokusokujoHakkoDiv div) {
        if (div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getChkInsatsuChohyo().getSelectedKeys().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.未指定.getMessage().replace("認定調査督促状対象者一覧の印刷書類を"));
        }
        RDate 開始日 = div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getFromValue() == null
                ? RDate.MIN : div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getFromValue();
        RDate 終了日 = div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getToValue() == null
                ? RDate.MIN : div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getToValue();
        if (終了日.isBefore(開始日)) {
            throw new ApplicationException(UrErrorMessages.終了日が開始日以前.getMessage());
        }
        int 該当データ件数 = getHandler(div).該当データ件数取得(getHandler(div).getTempData());
        if (該当データ件数 > 0) {
            return ResponseData.of(div).respond();
        } else {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
    }

    /**
     * 印刷書類区分を選択します。
     *
     * @param div NinteiChosaTokusokujoHakkoDiv
     * @return ResponseData<NinteiChosaTokusokujoHakkoDiv>
     */
    public ResponseData<NinteiChosaTokusokujoHakkoDiv> onChange_radChohyo(NinteiChosaTokusokujoHakkoDiv div) {
        getHandler(div).onChange_radChohyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 保険者選択時のイベントです。
     *
     * @param div NinteiChosaTokusokujoHakkoDiv
     * @return ResponseData<NinteiChosaTokusokujoHakkoDiv>
     */
    public ResponseData<NinteiChosaTokusokujoHakkoDiv> onChange_ddlHokenshaList(NinteiChosaTokusokujoHakkoDiv div) {
        getHandler(div).changeHokensha();
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタンをクリックの設定します。
     *
     * @param div NinteiChosaTokusokujoHakkoDiv
     * @return ResponseData<NinteiChosaTokusokujoHakkoDiv>
     */
    public ResponseData<DBE223001_NinteichosaTokusokujyoParameter> jikkou(NinteiChosaTokusokujoHakkoDiv div) {
        DBE223001_NinteichosaTokusokujyoParameter parameter = new DBE223001_NinteichosaTokusokujyoParameter();
        NinteiChosaTokusokujoHakkoTempData tempData = getHandler(div).getTempData();
        parameter.toDBE223001Parameter(tempData);
        return ResponseData.of(parameter).respond();
    }

    private NinteiChosaTokusokujoHakkoHandler getHandler(NinteiChosaTokusokujoHakkoDiv div) {
        return new NinteiChosaTokusokujoHakkoHandler(div);
    }

}
