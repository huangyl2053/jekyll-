/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410047;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.SogojigyohiSeikyugakuTsuchishoIn.DBC120890_SogojigyohiSeikyugakuTsuchishoInBacthParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410047.TsuchishoJoho153Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 国保連情報受取データ取込_[153]総合事業費等請求額通知書情報
 *
 * @reamsid_L DBC-2480-040 changying
 */
public class TsuchishoJoho153 {

    /**
     * onLoad
     *
     * @param div TsuchishoJoho153Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho153Div> onLoad(TsuchishoJoho153Div div) {
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div TsuchishoJoho153Div
     * @return ResponseData
     */
    public ResponseData<DBC120890_SogojigyohiSeikyugakuTsuchishoInBacthParameter> onClick_btnExcute(TsuchishoJoho153Div div) {
        RYearMonth 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月().getYearMonth();
        RString 再処理区分 = div.getCcdKokurenJohoTorikomi().get再処理区分();
        Long 出力順ID = div.getCcdKokurenJohoTorikomi().get出力順ID();
        DBC120890_SogojigyohiSeikyugakuTsuchishoInBacthParameter parameter = new DBC120890_SogojigyohiSeikyugakuTsuchishoInBacthParameter();
        parameter.setShoriYM(処理年月);
        parameter.setSaishoriKubun(再処理区分);
        parameter.setShutsuryokujunId(出力順ID);
        return ResponseData.of(parameter).respond();
    }
}
