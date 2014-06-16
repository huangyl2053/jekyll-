/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;

/**
 * 資格得喪の履歴をグリッドで表示する共有子DivのDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class ShikakuTokusoRireki {

    /**
     * 引数に渡されたモードによって、コントロールの表示非表示を切り替えます。<br/>
     * 照会モードが設定されていた場合、グリッド上の修正・削除ボタンが非表示になります。
     *
     * @param rirekiDiv 資格得喪履歴Div
     * @param mode モード
     */
    public static void setMode(ShikakuTokusoRirekiDiv rirekiDiv, ModeType mode) {

        rirekiDiv.setMode(mode.toValue());
        if (ModeType.SHOKAI_MODE.toValue().equals(rirekiDiv.getMode())) {
            rirekiDiv.getDgShikakuShutokuRireki().getGridSetting().setIsShowDeleteButtonColumn(false);
            rirekiDiv.getDgShikakuShutokuRireki().getGridSetting().setIsShowModifyButtonColumn(false);
        } else {
            rirekiDiv.getDgShikakuShutokuRireki().getGridSetting().setIsShowDeleteButtonColumn(true);
            rirekiDiv.getDgShikakuShutokuRireki().getGridSetting().setIsShowModifyButtonColumn(true);
        }
    }

}
