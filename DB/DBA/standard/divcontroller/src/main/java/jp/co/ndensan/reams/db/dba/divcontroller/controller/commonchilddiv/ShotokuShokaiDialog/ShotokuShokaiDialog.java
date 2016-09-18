/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.ShotokuShokaiDialog;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShotokuShokaiDialog.ShotokuShokaiDialogDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 世帯員所得照会共有子Divをダイアログで開いた場合のイベントを定義します。
 *
 * @author n8178
 */
public class ShotokuShokaiDialog {

    /**
     * onLoad時の処理です。ダイアログを開いた際に、親画面側で設定された情報を元に初期化処理を行います。
     *
     * @param div 世帯員所得照会ダイアログ
     * @return ResponseData
     */
    public ResponseData<ShotokuShokaiDialogDiv> onLoad(ShotokuShokaiDialogDiv div) {

        if (isEmptyKeyData(div)) {
            div.getCcdSetaiShotokuIchiran().initialize(ShikibetsuCode.EMPTY, FlexibleDate.getNowDate(),
                    FlexibleDate.getNowDate().getNendo(), YMDHMS.now());
            return ResponseData.of(div).respond();
        }

        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(div.getShikibetsuCode());

        div.getCcdSetaiShotokuIchiran().initialize(shikibetsuCode, FlexibleDate.getNowDate(),
                FlexibleDate.getNowDate().getNendo(), YMDHMS.now());

        return ResponseData.of(div).respond();
    }

    private boolean isEmptyKeyData(ShotokuShokaiDialogDiv div) {
        return (div.getShikibetsuCode() == null || div.getShikibetsuCode().isEmpty());
    }

    /**
     * 閉じるボタンを押した時の処理です。
     *
     * @param div 世帯員所得照会ダイアログ
     * @return ResponseData
     */
    public ResponseData<ShotokuShokaiDialogDiv> onClick_btnClose(ShotokuShokaiDialogDiv div) {
        return ResponseData.of(div).respond();
    }
}
