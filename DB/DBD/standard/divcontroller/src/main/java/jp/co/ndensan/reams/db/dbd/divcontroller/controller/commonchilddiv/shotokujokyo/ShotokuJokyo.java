/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.shotokujokyo;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShotokuJokyo.ShotokuJokyo.ShotokuJokyoDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * 【共有子Div】 所得状況のDivControllerです。
 *
 * @reamsid_L DBD-3650-110 liangbc
 */
public class ShotokuJokyo {

    /**
     * 初期化
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData<GemmenShokaiDiv>
     */
    public ResponseData<ShotokuJokyoDiv> onLoad(ShotokuJokyoDiv div) {
        div.load(new ShikibetsuCode(div.getTxtShikibetsuCode()));
        return ResponseData.of(div).respond();
    }

    /**
     * 再表示する
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData<GemmenShokaiDiv>
     */
    public ResponseData<ShotokuJokyoDiv> onClick_Saihyoji(ShotokuJokyoDiv div) {
        div.世帯員所得情報の取得(new ShikibetsuCode(div.getTxtShikibetsuCode()), true);
        return ResponseData.of(div).respond();
    }

    /**
     * 所得状況画面を閉じる。
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData<GemmenShokaiDiv>
     */
    public ResponseData<ShotokuJokyoDiv> onClick_btnRirekiClose(ShotokuJokyoDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }
}
