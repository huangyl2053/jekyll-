/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.HokenshaJoho;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaInputGuide.HokenshaInputGuideDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaInputGuide.HokenshaInputGuideHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * 保険者入力補助のダイアログのDivControllerです
 */
public class HokenshaInputGuide {

    /**
     * 「保険者検索」ボタンされます。<br/>
     * 選択行の情報を明細エリアに表示します。
     *
     * @param div {@link HokenshaJohoDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<HokenshaInputGuideDiv> onGetHoken(HokenshaInputGuideDiv div) {
        ResponseData<HokenshaInputGuideDiv> responseData = new ResponseData<>();
        getHandler(div).on保険者検索(div);
        responseData.data = div;
        return responseData;
    }

    /**
     * 証回収状況Listの1行を選択した際に実行されます。<br/>
     * 選択行の情報を明細エリアに表示します。
     *
     * @param div {@link HokenshaJohoDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<HokenshaInputGuideDiv> onSelective(HokenshaInputGuideDiv div) {
        ResponseData<HokenshaInputGuideDiv> responseData = new ResponseData<>();
        getHandler(div).on選択(div);
        responseData.data = div;
        return responseData;
    }

    /**
     * 証回収状況Listの1行を選択した際に実行されます。<br/>
     * 選択行の情報を明細エリアに表示します。
     *
     * @param div {@link HokenshaJohoDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<HokenshaInputGuideDiv> on保険者を表示する(HokenshaInputGuideDiv div) {
        ResponseData<HokenshaInputGuideDiv> responseData = new ResponseData<>();
        getHandler(div).on保険者を表示する(div);
        responseData.data = div;
        return responseData;
    }

    private HokenshaInputGuideHandler getHandler(HokenshaInputGuideDiv div) {
        return new HokenshaInputGuideHandler(div);
    }
}
