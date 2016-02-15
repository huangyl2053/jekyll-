/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2330001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001.Dbe233001FlowParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shujiiikentokusokujohakko.ShujiiIkenTokusokujoHakkoTempData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2330001.ShujiiIkenTokusokujoHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2330001.ShujiiIkenTokusokujoHakkoHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 主治医意見書督促状発行のコントローラです。
 *
 */
public class ShujiiIkenTokusokujoHakko {

    /**
     * 初期化の設定します。
     *
     * @param div ShujiiIkenTokusokujoHakkoDiv
     * @return ResponseData<ShujiiIkenTokusokujoHakkoDiv>
     */
    public ResponseData<ShujiiIkenTokusokujoHakkoDiv> onLoad(ShujiiIkenTokusokujoHakkoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 印刷書類区分の設定します。
     *
     * @param div ShujiiIkenTokusokujoHakkoDiv
     * @return ResponseData<ShujiiIkenTokusokujoHakkoDiv>
     */
    public ResponseData<ShujiiIkenTokusokujoHakkoDiv> onChange_radChohyo(ShujiiIkenTokusokujoHakkoDiv div) {
        getHandler(div).onChange_radChohyo();
        return ResponseData.of(div).respond();
    }

    private ShujiiIkenTokusokujoHakkoHandler getHandler(ShujiiIkenTokusokujoHakkoDiv div) {
        return new ShujiiIkenTokusokujoHakkoHandler(div);
    }

    /**
     * 「発行する」ボタンをクリックの設定します。
     *
     * @param div ShujiiIkenTokusokujoHakkoDiv
     * @return ResponseData<ShujiiIkenTokusokujoHakkoDiv>
     */
    public ResponseData<ShujiiIkenTokusokujoHakkoDiv> beforeHakkou(ShujiiIkenTokusokujoHakkoDiv div) {
        RDate 開始日 = div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getFromValue() == null
                ? RDate.MIN : div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getFromValue();
        RDate 終了日 = div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getToValue() == null
                ? RDate.MIN : div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getToValue();
        if (終了日.isBefore(開始日)) {
            throw new ApplicationException(UrErrorMessages.終了日が開始日以前.getMessage());
        }
        if (div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getChkInsatsuChohyo().getSelectedKeys().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.未指定.getMessage().replace("主治医意見書督促状対象者一覧の印刷書類を"));
        }
        int 該当データ件数 = getHandler(div).該当データ件数取得(getHandler(div).getTempData());
        if (該当データ件数 > 0) {
            return ResponseData.of(div).respond();
        } else {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
    }

    /**
     * バッチパラメータの設定します。
     *
     * @param div ShujiiIkenTokusokujoHakkoDiv
     * @return ResponseData<ShujiiIkenTokusokujoHakkoDiv>
     */
    public ResponseData<Dbe233001FlowParameter> hakkou(ShujiiIkenTokusokujoHakkoDiv div) {
        Dbe233001FlowParameter parameter = new Dbe233001FlowParameter();
        ShujiiIkenTokusokujoHakkoTempData tempData = getHandler(div).getTempData();
        parameter.toDBE233001Parameter(tempData);
        return ResponseData.of(parameter).respond();
    }
}
