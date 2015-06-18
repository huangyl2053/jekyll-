/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TestKaigoNinteiAtenaInfo.TestKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * TestKaigoNinteiAtenaInfoDiv用の処理クラスです。
 * 
 * @author n8223 朴義一
 */
public class TestKaigoNinteiAtenaInfo {
      /**
     * 親画面で業務コードを受け取って（テスト用）設定します。
     *
     * @param div TestChosaItakusakiAndchosainInputDiv
     * @return ResponseData
     */
    public ResponseData<TestKaigoNinteiAtenaInfoDiv> onClickbtnSetinput(TestKaigoNinteiAtenaInfoDiv div) {

        //隠し項目
        div.getCcdKaigoNinteiAtenaInfo().setHdnKaigoDonyuKeitai(div.getTxtHdnKaigoDonyuKeitai().getValue());
        div.getCcdKaigoNinteiAtenaInfo().setHdnShoriType(div.getTxtHdnShoriType().getValue());
        div.getCcdKaigoNinteiAtenaInfo().setHdnSubGyomuCode(div.getTxtHdnSubGyomuCode().getValue());
        div.getCcdKaigoNinteiAtenaInfo().setMemoShikibetsuKubun(div.getTxtMemoShikibetsuKubun().getValue());
        
        //初期化(モード)イベント
        div.getCcdKaigoNinteiAtenaInfo().initialize();
        
        //loadイベント
        //TODO（テスト用） viewStateHolder.put  viewStateHolder.get
        div.getCcdKaigoNinteiAtenaInfo().onLoad(div);
      
        return _createResponseData(div);
    }

    private ResponseData<TestKaigoNinteiAtenaInfoDiv> _createResponseData(TestKaigoNinteiAtenaInfoDiv div) {
        ResponseData<TestKaigoNinteiAtenaInfoDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}

