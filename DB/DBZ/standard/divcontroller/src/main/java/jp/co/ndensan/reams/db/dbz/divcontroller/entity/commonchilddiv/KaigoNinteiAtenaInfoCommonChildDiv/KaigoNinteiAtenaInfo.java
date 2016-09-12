/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfoCommonChildDiv;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 介護認定宛名情報の取得処理。
 *
 * @reamsid_L DBZ-1300-050 lizhuoxuan
 */
public class KaigoNinteiAtenaInfo {

    /**
     * 「個人メモ」ボタンをクリック場合、介護認定宛名情報画面が表示します。
     *
     * @param div KaigoNinteiAtenaInfoDiv
     * @return ResponseData<KaigoNinteiAtenaInfoDiv>
     */
    public ResponseData<KaigoNinteiAtenaInfoDiv> onBeforeOpenDialog_btnSearchShiki(KaigoNinteiAtenaInfoDiv div) {
        getHandler(div).setShikiParam();
        return ResponseData.of(div).respond();
    }

    /**
     * 「個人メモ」ボタンをクリック場合、介護認定宛名情報画面が表示します。
     *
     * @param div KaigoNinteiAtenaInfoDiv
     * @return ResponseData<KaigoNinteiAtenaInfoDiv>
     */
    public ResponseData<KaigoNinteiAtenaInfoDiv> onOkClose_btnSearchShiki(KaigoNinteiAtenaInfoDiv div) {
        getHandler(div).getShikiParam();
        return ResponseData.of(div).respond();
    }

    /**
     * 「世帯メモ」ボタンをクリック場合、介護認定宛名情報画面が表示します。
     *
     * @param div KaigoNinteiAtenaInfoDiv
     * @return ResponseData<KaigoNinteiAtenaInfoDiv>
     */
    public ResponseData<KaigoNinteiAtenaInfoDiv> onBeforeOpenDialog_btnSearchSetai(KaigoNinteiAtenaInfoDiv div) {
        getHandler(div).setSetaiParam();
        return ResponseData.of(div).respond();
    }

    /**
     * 「世帯メモ」ボタンをクリック場合、介護認定宛名情報画面が表示します。
     *
     * @param div KaigoNinteiAtenaInfoDiv
     * @return ResponseData<KaigoNinteiAtenaInfoDiv>
     */
    public ResponseData<KaigoNinteiAtenaInfoDiv> onOkClose_btnSearchSetai(KaigoNinteiAtenaInfoDiv div) {
        getHandler(div).geSetaiParam();
        return ResponseData.of(div).respond();
    }

    private KaigoNinteiAtenaInfoHandler getHandler(KaigoNinteiAtenaInfoDiv nijiDiv) {
        return new KaigoNinteiAtenaInfoHandler(nijiDiv);
    }

}
