/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.HokenshaJoho;

import jp.co.ndensan.reams.db.dba.business.core.hokensha.Hokensha;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hokensha.HokenshaMapperParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoHandler;
import jp.co.ndensan.reams.db.dba.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者入力補助のDivControllerです
 *
 */
public class HokenshaJoho {

    /**
     * 保険者コードを入れる、保険者名を自動表示します。
     *
     * @param div {@link HokenshaJohoDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<HokenshaJohoDiv> lostfocus_txtHokenshaNo(HokenshaJohoDiv div) {
        if (div.getTxtHokenshaNo().getValue().isEmpty()) {
            div.getTxtHokenshaMeisho().setValue(RString.EMPTY);
            return ResponseData.of(div).respond();
        }
        HokenshaMapperParameter parameter = HokenshaMapperParameter.createHokenjaNoParam(
                new HokenjaNo(div.getTxtHokenshaNo().getValue()));
        Hokensha hokensha = HokenshaNyuryokuHojoFinder.createInstance().getHokensha(parameter);
        getHandler(div).onBlur_txtHokenshaNo(hokensha);
        return ResponseData.of(div).respond();
    }

    /**
     * 保険者入力ダイアログ画面開く前に処理します。
     *
     * @param div {@link HokenshaJohoDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<HokenshaJohoDiv> onBeforeOpenDialog_btnSearch(HokenshaJohoDiv div) {
        div.setTxtHokenshaNo(div.getTxtHokenshaNo());
        div.setTxtHokenshaMeisho(div.getTxtHokenshaMeisho());
        return ResponseData.of(div).respond();
    }

    /**
     * 保険者入力ダイアログ画面閉じる前に処理します。
     *
     * @param div {@link HokenshaJohoDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<HokenshaJohoDiv> onOkClose_btnSearch(HokenshaJohoDiv div) {

        return ResponseData.of(div).respond();
    }

    private HokenshaJohoHandler getHandler(HokenshaJohoDiv div) {
        return new HokenshaJohoHandler(div);
    }
}
