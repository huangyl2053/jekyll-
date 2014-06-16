/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki.IryoHokenRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;

/**
 * 医療保険履歴をグリッドで表示する共有子DivのDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class IryoHokenRireki {

    /**
     * 引数から渡されたモードに合わせて、コントロールの表示非表示を切り替えます。<br/>
     * 照会モードが設定されていた場合、グリッド上の修正・削除ボタンが非表示になります。
     *
     * @param rirekiDiv 医療保険履歴Div
     * @param mode モード
     */
    public static void setMode(IryoHokenRirekiDiv rirekiDiv, ModeType mode) {

        rirekiDiv.setMode(mode.toValue());
        if (ModeType.SHOKAI_MODE.toValue().equals(rirekiDiv.getMode())) {
            rirekiDiv.getDgIryoHokenRireki().getGridSetting().setIsShowDeleteButtonColumn(false);
            rirekiDiv.getDgIryoHokenRireki().getGridSetting().setIsShowModifyButtonColumn(false);
        } else {
            rirekiDiv.getDgIryoHokenRireki().getGridSetting().setIsShowDeleteButtonColumn(true);
            rirekiDiv.getDgIryoHokenRireki().getGridSetting().setIsShowModifyButtonColumn(true);
        }
    }

}
