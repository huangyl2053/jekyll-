/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.HikazeiNenkinKensaku;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HikazeiNenkinKensaku.HikazeiNenkinKensakuDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HikazeiNenkinKensaku.HikazeiNenkinKensakuHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * 【共有子Div】非課税年金検索のハンドラクラスです。
 *
 * @reamsid_L DBD-4930-030 panxiaobo
 *
 */
public class HikazeiNenkinKensaku {

    /**
     * 画面初期化です。
     *
     * @param div HikazeiNenkinKensakuDiv
     * @return ResponseData<HikazeiNenkinKensakuDiv>
     */
    public ResponseData<HikazeiNenkinKensakuDiv> onLoad(HikazeiNenkinKensakuDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択」ボタンを押下します。
     *
     * @param div HikazeiNenkinKensakuDiv
     * @return ResponseData<HikazeiNenkinKensakuDiv>
     */
    public ResponseData<HikazeiNenkinKensakuDiv> onClick_SelectedItem(HikazeiNenkinKensakuDiv div) {
        getHandler(div).onClick_SelectedItem();
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 所得状況画面を閉じる。
     *
     * @param div HikazeiNenkinKensakuDiv
     * @return ResponseData<HikazeiNenkinKensakuDiv>
     */
    public ResponseData<HikazeiNenkinKensakuDiv> onClick_btnClose(HikazeiNenkinKensakuDiv div) {
        return ResponseData.of(div).dialogNGClose();
    }

    private HikazeiNenkinKensakuHandler getHandler(HikazeiNenkinKensakuDiv div) {
        return new HikazeiNenkinKensakuHandler(div);
    }
}
