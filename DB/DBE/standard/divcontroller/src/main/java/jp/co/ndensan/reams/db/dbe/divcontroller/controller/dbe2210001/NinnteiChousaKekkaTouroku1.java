/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe2210001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe2210001.NinnteiChousaKekkaTouroku1Handler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 認定調査結果登録1のクラスです。
 */
public class NinnteiChousaKekkaTouroku1 {

    public ResponseData<NinnteiChousaKekkaTouroku1Div> onLoad(NinnteiChousaKekkaTouroku1Div div) {
        
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }
    
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_radGenzaiService(NinnteiChousaKekkaTouroku1Div div) {
        if (!ResponseHolder.isReRequest()) {
            
        }
        
        return ResponseData.of(div).respond();
    }

    private NinnteiChousaKekkaTouroku1Handler getHandler(NinnteiChousaKekkaTouroku1Div div) {
        return new NinnteiChousaKekkaTouroku1Handler(div);
    }
}
