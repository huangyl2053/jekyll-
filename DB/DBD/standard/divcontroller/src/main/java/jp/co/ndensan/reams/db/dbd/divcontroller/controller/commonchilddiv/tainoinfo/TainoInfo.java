/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.tainoinfo;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.tainoinfo.TainoInfo.TainoInfoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 【共有子Div】 滞納情報のDivControllerです。
 *
 * @reamsid_L DBD-3620-010 liangbc
 */
public class TainoInfo {

    /**
     * 初期化
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData<TainoInfoDiv>
     */
    public ResponseData<TainoInfoDiv> initialize(TainoInfoDiv div) {
        div.initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「基準日で検索する」ボタンをクリックする
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData<TainoInfoDiv>
     */
    public ResponseData<TainoInfoDiv> onClick_btnKensaku(TainoInfoDiv div) {
        div.kensaku();
        return ResponseData.of(div).respond();
    }
}
