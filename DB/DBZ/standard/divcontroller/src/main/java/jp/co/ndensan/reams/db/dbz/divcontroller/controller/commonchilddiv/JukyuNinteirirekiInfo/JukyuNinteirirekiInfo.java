/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.JukyuNinteirirekiInfo;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteirirekiichiran.NinteiRirekiIchiranBusiness;
import jp.co.ndensan.reams.db.dbz.definition.param.ninteirirekiichiran.NinteiRirekiIchiranParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JukyuNinteirirekiInfo.JukyuNinteirirekiInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.JukyuNinteirirekiInfo.JukyuNinteirirekiInfoHandler;
import jp.co.ndensan.reams.db.dbz.service.NinteiRirekiIchiran;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * 受給者台帳情報のダイアログのDivControllerです。
 */
public class JukyuNinteirirekiInfo {

    /**
     * 受給者台帳情報の初期化処理します。
     *
     * @param div JukyuNinteirirekiInfoDiv
     * @return 受給者台帳情報div
     */
    public ResponseData<JukyuNinteirirekiInfoDiv> onLoad(JukyuNinteirirekiInfoDiv div) {
        NinteiRirekiIchiranParameter parameter = NinteiRirekiIchiranParameter.createParam(new HihokenshaNo(div.getHdHihokenshaNo()));
        List<NinteiRirekiIchiranBusiness> ninteiChosaList
                = NinteiRirekiIchiran.createInstance().getJyukyuuSyaDaiTyouJyoho(parameter).records();
        getHandler(div).onLoad(ninteiChosaList);
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じるボタンを押下する場合、本画面を閉じます。
     *
     * @param div JukyuNinteirirekiInfoDiv
     * @return 受給者台帳情報div
     */
    public ResponseData<JukyuNinteirirekiInfoDiv> onClick_btnClose(JukyuNinteirirekiInfoDiv div) {
        return ResponseData.of(div).respond();
    }

    private JukyuNinteirirekiInfoHandler getHandler(JukyuNinteirirekiInfoDiv div) {
        return new JukyuNinteirirekiInfoHandler(div);
    }
}
