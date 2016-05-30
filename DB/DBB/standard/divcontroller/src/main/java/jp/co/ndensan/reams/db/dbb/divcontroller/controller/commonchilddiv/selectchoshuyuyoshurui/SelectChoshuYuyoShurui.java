/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.commonchilddiv.selectchoshuyuyoshurui;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.selectchoshuyuyoshurui.SelectChoshuYuyoShurui.SelectChoshuYuyoShuruiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.selectchoshuyuyoshurui.SelectChoshuYuyoShurui.SelectChoshuYuyoShuruiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 徴収猶予種類選択の画面
 *
 * @reamsid_L DBB-1680-030 xupeng
 */
public class SelectChoshuYuyoShurui {

    /**
     * 初期化のンメソッドます。
     *
     * @param div 徴収猶予種類選択の画面
     * @return ResponseData
     */
    public ResponseData<SelectChoshuYuyoShuruiDiv> onLoad(SelectChoshuYuyoShuruiDiv div) {
        getHandler(div).init();
        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンのンメソッドます。
     *
     * @param div 徴収猶予種類選択の画面
     * @return ResponseData
     */
    public ResponseData<SelectChoshuYuyoShuruiDiv> onClick_btnSelect(SelectChoshuYuyoShuruiDiv div) {
        getHandler(div).setSelect();
        return ResponseData.of(div).respond();
    }

    /**
     * 取消ボタンのンメソッドます。
     *
     * @param div 徴収猶予種類選択の画面
     * @return ResponseData
     */
    public ResponseData<SelectChoshuYuyoShuruiDiv> onClick_btnCancel(SelectChoshuYuyoShuruiDiv div) {
        return ResponseData.of(div).respond();
    }

    private SelectChoshuYuyoShuruiHandler getHandler(SelectChoshuYuyoShuruiDiv div) {
        return new SelectChoshuYuyoShuruiHandler(div);
    }
}
