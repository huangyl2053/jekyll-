/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5610001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE561001.DBE561001_CenterTransmissionParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001.DBE0220001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5610001.DBE5610001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5610001.NinteiShienCenterSoshinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5610001.NinteiShienCenterSoshinHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * センター送信準備のクラスです。
 *
 * @reamsid_L DBE-1520-011 lishengli
 */
public class NinteiShienCenterSoshin {

    /**
     * センター送信準備の初期化。
     *
     * @param div NinteiShienCenterSoshinDiv
     * @return レスポンスデータ
     */
    public ResponseData<NinteiShienCenterSoshinDiv> onLoad(NinteiShienCenterSoshinDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBE5610001StateName.初期表示);
    }

    /**
     * 送信データの作成を実行するボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<DBE561001_CenterTransmissionParameter> onClick_BtnDataoutput(NinteiShienCenterSoshinDiv div) {
        return ResponseData.of(getHandler(div).setParameter()).forwardWithEventName(DBE0220001TransitionEventName.センター送信).respond();
    }

    /**
     * 送信データの作成を実行するボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinteiShienCenterSoshinDiv> onClick_BtnDataoutputCheck(NinteiShienCenterSoshinDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(), UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    private NinteiShienCenterSoshinHandler getHandler(NinteiShienCenterSoshinDiv div) {
        return new NinteiShienCenterSoshinHandler(div);
    }
}
