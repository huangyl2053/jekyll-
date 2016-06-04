/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.commonchilddiv.gemmentorikeshishurui;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.gemmentorikeshishurui.GemmenTorikeshiShurui.GemmenTorikeshiShuruiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.gemmentorikeshishurui.GemmenTorikeshiShurui.GemmenTorikeshiShuruiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 介護保険料減免の取消種類選択の画面
 *
 * @reamsid_L DBB-1660-040 xupeng
 */
public class GemmenTorikeshiShurui {

    /**
     * 初期化のンメソッドます。
     *
     * @param div 取消種類選択の画面
     * @return ResponseData
     */
    public ResponseData<GemmenTorikeshiShuruiDiv> onLoad(GemmenTorikeshiShuruiDiv div) {
        getHandler(div).init();
        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンのンメソッドます。
     *
     * @param div 取消種類選択の画面
     * @return ResponseData
     */
    public ResponseData<GemmenTorikeshiShuruiDiv> onClick_btnSelect(GemmenTorikeshiShuruiDiv div) {
        getHandler(div).setSelect();
        return ResponseData.of(div).respond();
    }

    /**
     * 取消ボタンのンメソッドます。
     *
     * @param div 取消種類選択の画面
     * @return ResponseData
     */
    public ResponseData<GemmenTorikeshiShuruiDiv> onClick_btnCancel(GemmenTorikeshiShuruiDiv div) {
        return ResponseData.of(div).respond();
    }

    private GemmenTorikeshiShuruiHandler getHandler(GemmenTorikeshiShuruiDiv div) {
        return new GemmenTorikeshiShuruiHandler(div);
    }
}
