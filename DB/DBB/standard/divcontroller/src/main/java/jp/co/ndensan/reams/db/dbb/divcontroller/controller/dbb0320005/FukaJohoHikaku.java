/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320005;

import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.DbbViewStateKey;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbInformationMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320005.input.FukaHikakuInput;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320005.input.FukaHikakuTargets;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320005.DBB0320005TransitionEventName.選択画面に戻る;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320005.FukaJohoHikakuDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 賦課照会の比較Divのコントローラです。
 */
public class FukaJohoHikaku {

    /**
     * 初期処理です。<br />
     * 比較できない場合はメッセージを表示して前の画面へ戻ります。
     *
     * @param div 賦課照会比較Div
     * @return レスポンスデータ
     */
    public ResponseData<FukaJohoHikakuDiv> initialize(FukaJohoHikakuDiv div) {
        if (ResponseHolder.isReRequest()) {
            return onClick_btnBack(div);
        }

        FukaHikakuInput input = ViewStateHolder.get(DbbViewStateKey.FukaHikakuInput, FukaHikakuInput.class);
        FukaHikakuTargets 比較対象 = input.get比較対象();
        if (!ResponseHolder.isReRequest() && !比較対象.canCompare()) {
            return ResponseData.of(div).addMessage(DbbInformationMessages.比較対象データなし.getMessage()).respond();
        }
        new FukaHikakuHandler(div).diplayComparingValues(比較対象);
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るボタン押下時の処理です。<br />
     * 賦課照会画面または世帯員所得画面に画面遷移します。
     *
     * @param div 賦課照会比較Div
     * @return レスポンスデータ
     */
    public ResponseData<FukaJohoHikakuDiv> onClick_btnBack(FukaJohoHikakuDiv div) {
        RString eventName;
        FukaHikakuInput input = ViewStateHolder.get(DbbViewStateKey.FukaHikakuInput, FukaHikakuInput.class);
        if (input.isBackTo賦課照会画面()) {
            eventName = new RString("賦課照会に戻る");
        } else {
            eventName = new RString("世帯員所得に戻る");
        }

        return ResponseData.of(div).forwardWithEventName(選択画面に戻る).parameter(eventName);
    }
}
