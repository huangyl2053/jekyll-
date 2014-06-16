/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.ShoKaishuKirokuKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.dgShoKaishuJokyo_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 証回収履歴管理を行う享有子DivのControllerです。
 *
 * @author n8178 城間篤人
 */
public class ShoKaishuKirokuKanri {

    /**
     * 入力モードに合わせて、コントロールの表示非表示を切り替えます。
     *
     * @param kanriDiv 証回収記録管理Div
     * @param mode モード
     * @return レスポンス
     */
    public static ShoKaishuKirokuKanriDiv setMode(ShoKaishuKirokuKanriDiv kanriDiv, ModeType mode) {

        kanriDiv.setMode(mode.toValue());
        if (ModeType.SHOKAI_MODE.toValue().equals(kanriDiv.getMode())) {
            kanriDiv.getBtnUpdateShoKaishuJokyo().setDisplayNone(true);
            kanriDiv.getShoKaishuJokyoShosai().setDisplayNone(true);
            kanriDiv.getShoKaishuJokyoList().getDgShoKaishuJokyo().getGridSetting().getColumn("btnSelect").setVisible(false);
        } else {

        }
        return kanriDiv;
    }

    public ResponseData onClick_btnSelect(ShoKaishuKirokuKanriDiv kanriDiv) {
        ResponseData<ShoKaishuKirokuKanriDiv> response = new ResponseData<>();

        response.data = kanriDiv;
        return response;
    }

}
