/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.HikazeiNenkinKensaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.houshold.HousholdBusiness;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HikazeiNenkinKensaku.HikazeiNenkinKensakuDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HikazeiNenkinKensaku.HikazeiNenkinKensakuHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
        List<HousholdBusiness> 非課税年金検索 = getHandler(div).onLoad();
        ViewStateHolder.put(ViewStateKey.非課税年金検索, new ArrayList(非課税年金検索));
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択」ボタンを押下します。
     *
     * @param div HikazeiNenkinKensakuDiv
     * @return ResponseData<HikazeiNenkinKensakuDiv>
     */
    public ResponseData<HikazeiNenkinKensakuDiv> onClick_SelectedItem(HikazeiNenkinKensakuDiv div) {
        ArrayList<HousholdBusiness> 非課税年金検索 = ViewStateHolder.get(ViewStateKey.非課税年金検索, ArrayList.class);
        getHandler(div).onClick_SelectedItem(非課税年金検索);
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

    private enum ViewStateKey {

        /**
         * 非課税年金検索
         */
        非課税年金検索;
    }
}
