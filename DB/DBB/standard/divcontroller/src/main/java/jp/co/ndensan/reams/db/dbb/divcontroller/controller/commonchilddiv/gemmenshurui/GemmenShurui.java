/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.commonchilddiv.gemmenshurui;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.gemmenshurui.GemmenShurui.GemmenShuruiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.gemmenshurui.GemmenShurui.GemmenShuruiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 介護保険料減免の減免種類選択の画面
 *
 * @reamsid_L DBB-1660-030 xupeng
 */
public class GemmenShurui {

    /**
     * 初期化のンメソッドます。
     *
     * @param div 減免種類選択の画面
     * @return ResponseData
     */
    public ResponseData<GemmenShuruiDiv> onLoad(GemmenShuruiDiv div) {
        getHandler(div).init();
        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンのンメソッドます。
     *
     * @param div 減免種類選択の画面
     * @return ResponseData
     */
    public ResponseData<GemmenShuruiDiv> onClick_btnSelect(GemmenShuruiDiv div) {
        getHandler(div).setSelect();
        return ResponseData.of(div).respond();
    }

    /**
     * 取消ボタンのンメソッドます。
     *
     * @param div 減免種類選択の画面
     * @return ResponseData
     */
    public ResponseData<GemmenShuruiDiv> onClick_btnCancel(GemmenShuruiDiv div) {
        return ResponseData.of(div).respond();
    }

    private GemmenShuruiHandler getHandler(GemmenShuruiDiv div) {
        return new GemmenShuruiHandler(div);
    }
}
