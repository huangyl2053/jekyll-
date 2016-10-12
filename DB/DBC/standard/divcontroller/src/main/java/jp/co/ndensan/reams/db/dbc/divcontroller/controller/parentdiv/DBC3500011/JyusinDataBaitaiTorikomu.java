/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC3500011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3500011.JyusinDataBaitaiTorikomuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC3500011.HokenshaSofuListHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 国保連情報データ媒体取込のクラスです。
 *
 * @reamsid_L DBC-3030-010 lihang
 */
public class JyusinDataBaitaiTorikomu {

    private static final int ゼロ = 0;

    /**
     * 画面初期化のメソッドです。
     *
     * @param div JyusinDataBaitaiTorikomuDiv
     *
     * @return ResponseData
     */
    public ResponseData<JyusinDataBaitaiTorikomuDiv> onLoad(JyusinDataBaitaiTorikomuDiv div) {

        div.getPanelUpload().setVisible(false);
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 受信データリスト.「削除」ボタンのメソッドです。
     *
     * @param div JyusinDataBaitaiTorikomuDiv
     *
     * @return ResponseData
     */
    public ResponseData<JyusinDataBaitaiTorikomuDiv> onClick_delete(JyusinDataBaitaiTorikomuDiv div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                    UrQuestionMessages.削除の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).deleteCsv();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 受信データ媒体取込の「受信データを取り込む」ボタンのメソッドです。
     *
     * @param div JyusinDataBaitaiTorikomuDiv
     *
     * @return ResponseData
     */
    public ResponseData<JyusinDataBaitaiTorikomuDiv> onClick_torikomu(JyusinDataBaitaiTorikomuDiv div) {

        div.getPanelUpload().setVisible(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 受信データアップロードダイアログ「閉じる」ボタンのメソッドです。
     *
     * @param div JyusinDataBaitaiTorikomuDiv
     *
     * @return ResponseData
     */
    public ResponseData<JyusinDataBaitaiTorikomuDiv> onClick_close(JyusinDataBaitaiTorikomuDiv div) {

        div.getPanelUpload().setVisible(false);
        return ResponseData.of(div).respond();
    }

    /**
     * アップロードButtonaを押します.
     *
     * @param div JyusinDataBaitaiTorikomuDiv
     * @param files FileData[]
     * @return ResponseData<JyusinDataBaitaiTorikomuDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<JyusinDataBaitaiTorikomuDiv> onClick_btnUpload(JyusinDataBaitaiTorikomuDiv div, FileData[] files) {
        getHandler(div).upLoadCsv(files[ゼロ]);
        return ResponseData.of(div).respond();
    }

    private HokenshaSofuListHandler getHandler(JyusinDataBaitaiTorikomuDiv div) {

        return new HokenshaSofuListHandler(div);
    }
}
