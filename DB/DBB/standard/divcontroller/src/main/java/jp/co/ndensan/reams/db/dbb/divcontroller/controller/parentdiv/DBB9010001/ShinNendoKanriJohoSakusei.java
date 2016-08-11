/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB9010001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9010001.ShinNendoKanriJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9010001.ShinNendoKanriJohoSakuseiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 画面設計_DBB9010001_新年度管理情報作成のハンドラクラスです。
 *
 * @reamsid_L DBB-5721-010 chenyadong
 */
public class ShinNendoKanriJohoSakusei {
    /**
     * 画面初期化のメソッドです。
     *@param div ShinNendoKanriJohoSakuseiDiv
     * @return ResponseData
     */
    public ResponseData<ShinNendoKanriJohoSakuseiDiv> onLoad(ShinNendoKanriJohoSakuseiDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div ShinNendoKanriJohoSakuseiDiv
     * @return ResponseData
     */
    public ResponseData<ShinNendoKanriJohoSakuseiDiv> onClick_ShinNendoKanriJohoSakusei(ShinNendoKanriJohoSakuseiDiv div) {
        getHandler(div).実行ボタン押下した時の処理();
        return ResponseData.of(div).respond();
    }

    private ShinNendoKanriJohoSakuseiHandler getHandler(ShinNendoKanriJohoSakuseiDiv div) {
        return new ShinNendoKanriJohoSakuseiHandler(div);
    }
}
