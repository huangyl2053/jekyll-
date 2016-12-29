/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.Hokensha;

import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.definition.core.koseishichosonselector.KoseiShiChosonSelectorModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoHandler;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 保険者入力補助のDivControllerです
 *
 * @reamsid_L DBA-0180-010 lishengli
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
        Hokensha hokensha = HokenshaNyuryokuHojoFinder.createInstance().getHokensha(new HokenjaNo(div.getTxtHokenshaNo().getValue()));
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
        KoseiShiChosonSelectorModel model = ViewStateHolder.get(ViewStateKeys.引き継ぎデータ, KoseiShiChosonSelectorModel.class);
        div.getTxtHokenshaNo().setValue(model.get証記載保険者番号());
        div.getTxtHokenshaMeisho().setValue(model.get市町村名称());
        return ResponseData.of(div).respond();
    }

    private HokenshaJohoHandler getHandler(HokenshaJohoDiv div) {
        return new HokenshaJohoHandler(div);
    }
}
