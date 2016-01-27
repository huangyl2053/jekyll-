/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe2210001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe2210001.NinnteiChousaKekkaTouroku1Handler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 認定調査結果登録1のクラスです。
 */
public class NinnteiChousaKekkaTouroku1 {

    public ResponseData<NinnteiChousaKekkaTouroku1Div> onLoad(NinnteiChousaKekkaTouroku1Div div) {
        //TODO DBZ.KaigoNinteiShinseishaInfoのinitializeは未作成です
        //div.getCcdKaigoNinteiShinseishaInfo()
        //TODO DBZ.NinteiShinseiRenrakusakiKihonのinitializeメソッドは未作成です
        //div.getCcdNinteiShinseiRenrakusakiKihon()
        //TODO DBZ.ChosaJisshishaJohoのinitializeメソッドは未作成です
        //div.getCcdChosaJisshishaJoho()
        getHandler(div).予防給付サービス名称取得();
        getHandler(div).介護給付サービス名称取得();
        getHandler(div).施設利用名称取得();
        //TODO DBZ.KihonChosaInputは未作成です
        //div.getCcdIchigunKihonChosa()
        return ResponseData.of(div).respond();
    }

    private NinnteiChousaKekkaTouroku1Handler getHandler(NinnteiChousaKekkaTouroku1Div div) {
        return new NinnteiChousaKekkaTouroku1Handler(div);
    }
}
