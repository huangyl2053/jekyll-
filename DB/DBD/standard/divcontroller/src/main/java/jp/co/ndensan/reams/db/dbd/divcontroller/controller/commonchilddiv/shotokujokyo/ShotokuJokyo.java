/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.shotokujokyo;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShotokuJokyo.ShotokuJokyo.ShotokuJokyoDiv;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 【共有子Div】 所得状況のDivControllerです。
 *
 * @reamsid_L DBD-3560-110 liangbc
 */
public class ShotokuJokyo {

    /**
     * 初期化
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData<ShotokuJokyoDiv>
     */
    public ResponseData<ShotokuJokyoDiv> initialize(ShotokuJokyoDiv div) {
        div.initialize(new ShikibetsuCode(div.getTxtShikibetsuCode()), div.get所得基準年月日());
        return ResponseData.of(div).respond();
    }

    /**
     * 再表示する
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData<ShotokuJokyoDiv>
     */
    public ResponseData<ShotokuJokyoDiv> onClick_Saihyoji(ShotokuJokyoDiv div) {
        div.世帯員所得情報の取得(new ShikibetsuCode(div.getTxtShikibetsuCode()), div.get所得基準年月日());
        return ResponseData.of(div).respond();
    }

    /**
     * 所得状況画面を閉じる。
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData<ShotokuJokyoDiv>
     */
    public ResponseData<ShotokuJokyoDiv> onClick_btnRirekiClose(ShotokuJokyoDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * メモダイアログ表示。
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData<ShotokuJokyoDiv>
     */
    public ResponseData<ShotokuJokyoDiv> onBeforeOpenDialog_memo(ShotokuJokyoDiv div) {
        div.setTxtGyomuCode(GyomuCode.DB介護保険.value());
        //TODO QA #88103
        div.setTxtMemoShikibetsuKbn(RString.EMPTY);
        //TODO QA #88103
        div.setTxtMemoShikibetsuTaishoCode(RString.EMPTY);
        return ResponseData.of(div).respond();
    }
}
