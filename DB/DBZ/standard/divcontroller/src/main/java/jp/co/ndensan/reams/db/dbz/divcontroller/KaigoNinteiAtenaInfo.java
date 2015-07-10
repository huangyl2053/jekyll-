/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.divcontroller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「介護認定宛名情報」のイベントを定義したクラスです。
 * 
 * @author n8223 朴義一
 */
public class KaigoNinteiAtenaInfo {

//TODO  onload
//    public ResponseData<KaigoNinteiAtenaInfoDiv> onload(KaigoNinteiAtenaInfoDiv kaigoNinteiAtenaInfoDiv) {
//       createHandOf(kaigoNinteiAtenaInfoDiv).initialize();
//       createHandOf(kaigoNinteiAtenaInfoDiv).onload();
//       return createSettingData(kaigoNinteiAtenaInfoDiv);
//    }
 
//TODO     onClick_KojinMemo
//public ResponseData<KaigoNinteiAtenaInfoDiv> onClick_KojinMemo(KaigoNinteiAtenaInfoDiv kaigoNinteiAtenaInfoDiv) { }
//TODO     onClick_SetaiMem
//public ResponseData<KaigoNinteiAtenaInfoDiv> onClick_SetaiMem(KaigoNinteiAtenaInfoDiv kaigoNinteiAtenaInfoDiv) { }
    
    private KaigoNinteiAtenaInfoHandler createHandOf(KaigoNinteiAtenaInfoDiv div) {
        return new KaigoNinteiAtenaInfoHandler(div);
    }

    private <T> ResponseData<T> createSettingData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }
}