/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint;

import jp.co.ndensan.reams.db.dbe.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrintDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrintHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 共有子Div 依頼書・認定調査票(OCR)・主治医意見書印刷のイベントを定義したDivControllerです。
 *
 * @reamsid_L DBE-3000-230 sunhaidi
 */
public class ChosaIraishoAndChosahyoAndIkenshoPrint {

    /**
     * 共通子DIVを初期化します。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onLoad(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        IkenshoPrintParameterModel model = DataPassingConverter.deserialize(div.getHiddenIuputModel(), IkenshoPrintParameterModel.class);
        if (model != null) {
            getHandler(div).initialize(model.get申請書管理番号リスト(), model.get遷移元画面区分());
        }
        getHandler(div).setChkIkenshoSakuseiryoSeikyusho();
        getHandler(div).setRadJyushinKikan();
        getHandler(div).setRadTeishutsuKigen();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護保険診断命令書 チェックボックスのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onChange_chkIkenshoSakuseiryoSeikyusho(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        getHandler(div).setChkIkenshoSakuseiryoSeikyusho();
        return ResponseData.of(div).respond();
    }

    /**
     * 受診期間 ラジオボタンのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onChange_radJyushinKikan(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        getHandler(div).setRadJyushinKikan();
        return ResponseData.of(div).respond();
    }

    /**
     * 提出期限 ラジオボタンのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onChange_radTeishutsuKigen(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        getHandler(div).setRadTeishutsuKigen();
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るボタンを押す処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onClick_btnModoru(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        if (getHandler(div).isUpdate()) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.画面遷移の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).dialogOKClose();
            }
        } else {
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 選択された帳票を発行するボタンを押す処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> onClick_btnPrint(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        try (ReportManager reportManager = new ReportManager()) {
            printData(div, reportManager);
            response.data = reportManager.publish();
        }
        return response;
    }

    private void printData(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ReportManager reportManager) {
    }

    private ChosaIraishoAndChosahyoAndIkenshoPrintHandler getHandler(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        return new ChosaIraishoAndChosahyoAndIkenshoPrintHandler(div);
    }
}
