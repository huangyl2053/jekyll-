/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.HokenshaJoho;

import jp.co.ndensan.reams.db.dba.business.core.hokensha.HokenshaModel;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 保険者入力補助のDivControllerです
 *
 */
public class HokenshaJoho {

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
        HokenshaModel serviceType = new HokenshaModel();
        serviceType.set保険者コード(new RString(div.getTxtHokenshaNo().getControlValue().toString()));
        serviceType.set保険者名(new RString(div.getTxtHokenshaMeisho().getControlValue().toString()));
        div.setHokenshaModel(DataPassingConverter.serialize(serviceType));
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索」ボタンをクリック場合、保険者入力ダイアログ画面が表示します。
     *
     * @param div
     * @return HokenshaJohoDiv div
     */
    public ResponseData<HokenshaJohoDiv> onOkClose_btnSearch(HokenshaJohoDiv div) {

        HokenshaModel serviceType = DataPassingConverter.deserialize(div.getHokenshaModel(), HokenshaModel.class);
        div.getTxtHokenshaNo().setValue(serviceType.get保険者コード());
        div.getTxtHokenshaMeisho().setValue(serviceType.get保険者名());
        return ResponseData.of(div).respond();
    }

    private HokenshaJohoHandler getHandler(HokenshaJohoDiv div) {
        return new HokenshaJohoHandler(div);
    }
}
