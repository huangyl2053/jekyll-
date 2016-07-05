/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0050001;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050001.KakushuShinseishoHakkoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0050001.KakushuShinseishoHakkoHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 各種申請書の発行処理です。
 *
 * @reamsid_L DBA-0540-680 dongyabin
 */
public class KakushuShinseishoHakko {

    /**
     * 各種申請書発行の初期化処理です。
     *
     * @param div 各種申請書Div
     * @return ResponseData<KakushuShinseishoHakkoDiv>
     */
    public ResponseData<KakushuShinseishoHakkoDiv> onLoad(KakushuShinseishoHakkoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 操作可否確認します。
     *
     * @param div 各種申請書Div
     * @return ResponseData<KakushuShinseishoHakkoDiv>
     */
    public ResponseData<KakushuShinseishoHakkoDiv> click_validate(KakushuShinseishoHakkoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 各種申請書発行の帳票発行処理です。
     *
     * @param div 各種申請書Div
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> click_btnReportPublish(KakushuShinseishoHakkoDiv div) {
        SourceDataCollection sourceData = getHandler(div).click_帳票発行();
        return ResponseData.of(sourceData).respond();

    }

    private KakushuShinseishoHakkoHandler getHandler(KakushuShinseishoHakkoDiv div) {
        return new KakushuShinseishoHakkoHandler(div,
                ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class));
    }

}
