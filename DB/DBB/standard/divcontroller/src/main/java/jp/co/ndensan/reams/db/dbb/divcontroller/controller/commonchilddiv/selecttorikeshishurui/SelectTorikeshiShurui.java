/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.commonchilddiv.selecttorikeshishurui;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.selecttorikeshishurui.SelectTorikeshiShurui.SelectTorikeshiShuruiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.selecttorikeshishurui.SelectTorikeshiShurui.SelectTorikeshiShuruiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 取消種類選択の画面
 *
 * @reamsid_L DBB-1680-040 xupeng
 */
public class SelectTorikeshiShurui {

    /**
     * 初期化のンメソッドます。
     *
     * @param div 取消種類選択の画面
     * @return ResponseData
     */
    public ResponseData<SelectTorikeshiShuruiDiv> onLoad(SelectTorikeshiShuruiDiv div) {
        getHandler(div).init();
        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンのンメソッドます。
     *
     * @param div 取消種類選択の画面
     * @return ResponseData
     */
    public ResponseData<SelectTorikeshiShuruiDiv> onClick_btnSelect(SelectTorikeshiShuruiDiv div) {
        getHandler(div).setSelect();
        return ResponseData.of(div).respond();
    }

    /**
     * 取消ボタンのンメソッドます。
     *
     * @param div SelectTorikeshiShuruiDiv
     * @return ResponseData
     */
    public ResponseData<SelectTorikeshiShuruiDiv> onClick_btnCancel(SelectTorikeshiShuruiDiv div) {
        return ResponseData.of(div).respond();
    }

    private SelectTorikeshiShuruiHandler getHandler(SelectTorikeshiShuruiDiv div) {
        return new SelectTorikeshiShuruiHandler(div);
    }
}
