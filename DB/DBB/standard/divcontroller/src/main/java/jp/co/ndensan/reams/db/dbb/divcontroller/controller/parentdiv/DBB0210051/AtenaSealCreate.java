/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0210051;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021051.DBB021051_AtenaSealSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210051.AtenaSealCreateDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210051.AtenaSealCreateHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 画面設計_DBB0210051_宛名シール作成（介護賦課）のクラスです。
 *
 * @reamsid_L DBB-5660-010 wangxingpeng
 */
public class AtenaSealCreate {

    /**
     * 初期化のンメソッドます。
     *
     * @param div AtenaSealCreateDiv
     * @return ResponseData AtenaSealCreateDiv
     */
    public ResponseData<AtenaSealCreateDiv> onLoad(AtenaSealCreateDiv div) {
        getHandler(div).onload();
        return ResponseData.of(div).respond();
    }

    /**
     * setバッチのメソッドます。
     *
     * @param div AtenaSealCreateDiv
     * @return ResponseData DBB021051_AtenaSealSakuseiParameter
     */
    public ResponseData<DBB021051_AtenaSealSakuseiParameter> onClick_btnBatchExecute(AtenaSealCreateDiv div) {
        DBB021051_AtenaSealSakuseiParameter parameter = getHandler(div).setバッチパラメータ();
        return ResponseData.of(parameter).respond();
    }

    /**
     * onChangeのメソッドます。
     *
     * @param div AtenaSealCreateDiv
     * @return ResponseData AtenaSealCreateDiv
     */
    public ResponseData<AtenaSealCreateDiv> onChange(AtenaSealCreateDiv div) {
        getHandler(div).onChange();
        return ResponseData.of(div).respond();
    }

    private AtenaSealCreateHandler getHandler(AtenaSealCreateDiv div) {
        return AtenaSealCreateHandler.of(div);
    }
}
