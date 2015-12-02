/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.HokenshaJoho;

import jp.co.ndensan.reams.db.dba.business.core.hokensha.ServiceTypeModel;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者入力補助のDivControllerです
 *
 */
public class HokenshaJoho {

//    public ResponseData<HokenshaJohoDiv> onLoad(HokenshaJohoDiv div) {
//        ResponseData<HokenshaJohoDiv> responseData = new ResponseData<>();
//        responseData.data = div;
//        return responseData;
//    }
    /**
     * 保険者コードを入れる。<br/>
     * 保険者名を自動表示します。
     *
     * @param div {@link HokenshaJohoDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<HokenshaJohoDiv> focusOut(HokenshaJohoDiv div) {
        if (div.getTxtHokenshaNo().getValue().isEmpty()) {
            return ResponseData.of(div).respond();
        }
        getHandler(div).onBlur_txtHokenshaNo(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索」ボタンをクリック場合、保険者入力ダイアログ画面が表示します。
     *
     * @param div
     * @return HokenshaJohoDiv div
     */
    public ResponseData<HokenshaJohoDiv> onBeforeOpenDialog_btnSearch(HokenshaJohoDiv div) {
        ServiceTypeModel serviceType = new ServiceTypeModel();
        serviceType.set保険者コード(new RString(div.getTxtHokenshaNo().getValue().toString()));
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索」ボタンをクリック場合、保険者入力ダイアログ画面が表示します。
     *
     * @param div
     * @return HokenshaJohoDiv div
     */
    public ResponseData<HokenshaJohoDiv> onOkClose_btnSearch(HokenshaJohoDiv div) {
        ServiceTypeModel serviceType = new ServiceTypeModel();
        div.getTxtHokenshaNo().setValue(serviceType.get保険者コード());
        div.getTxtHokenshaMeisho().setValue(serviceType.get保険者名());
        return ResponseData.of(div).respond();
    }

    /**
     * 「保険者検索」ボタンされます。<br/>
     * 選択行の情報を明細エリアに表示します。
     *
     * @param div {@link HokenshaJohoDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
//    public ResponseData<HokenshaJohoDiv> onGetHoken(HokenshaJohoDiv div) {
//        ResponseData<HokenshaJohoDiv> responseData = new ResponseData<>();
//        getHandler(div).on保険者検索(div);
//        responseData.data = div;
//        return responseData;
//    }
//
    /**
     * 証回収状況Listの1行を選択した際に実行されます。<br/>
     * 選択行の情報を明細エリアに表示します。
     *
     * @param div {@link HokenshaJohoDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
//    public ResponseData<HokenshaJohoDiv> onSelective(HokenshaJohoDiv div) {
//        ResponseData<HokenshaJohoDiv> responseData = new ResponseData<>();
//        getHandler(div).on選択(div);
//        responseData.data = div;
//        return responseData;
//    }
//
    /**
     * 証回収状況Listの1行を選択した際に実行されます。<br/>
     * 選択行の情報を明細エリアに表示します。
     *
     * @param div {@link HokenshaJohoDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
//    public ResponseData<HokenshaJohoDiv> on保険者を表示する(HokenshaJohoDiv div) {
//        ResponseData<HokenshaJohoDiv> responseData = new ResponseData<>();
//        getHandler(div).on保険者を表示する(div);
//        responseData.data = div;
//        return responseData;
//    }
    private HokenshaJohoHandler getHandler(HokenshaJohoDiv div) {
        return new HokenshaJohoHandler(div);
    }
}
