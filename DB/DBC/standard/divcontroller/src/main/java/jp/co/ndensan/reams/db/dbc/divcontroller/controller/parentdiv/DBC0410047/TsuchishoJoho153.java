/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410047;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.SogojigyohiSeikyugakuTsuchishoIn.DBC120890_SogojigyohiSeikyugakuTsuchishoInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410047.DBC0410047TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410047.TsuchishoJoho153Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    public ResponseData<DBC120890_SogojigyohiSeikyugakuTsuchishoInParameter> onClick_btnExcute(TsuchishoJoho153Div div) {
        DBC120890_SogojigyohiSeikyugakuTsuchishoInParameter parameter = setBatchParameter(div);
        return ResponseData.of(parameter).respond();
    }

    /**
     * 「実行する」を処理します。
     *
     * @param div TsuchishoJoho153Div
     * @return DBC120890_SogojigyohiSeikyugakuTsuchishoInParameter
     */
    public DBC120890_SogojigyohiSeikyugakuTsuchishoInParameter setBatchParameter(TsuchishoJoho153Div div) {
        DBC120890_SogojigyohiSeikyugakuTsuchishoInParameter parameter = new DBC120890_SogojigyohiSeikyugakuTsuchishoInParameter();
        SaiShoriKubun 再処理区分 = null;
        if (SaiShoriKubun.再処理.get名称().equals(div.getCcdKokurenJohoTorikomi().get再処理区分())) {
            再処理区分 = SaiShoriKubun.再処理;
        } else if (SaiShoriKubun.空白.get名称().equals(div.getCcdKokurenJohoTorikomi().get再処理区分())) {
            再処理区分 = SaiShoriKubun.空白;
        }
        parameter.setSaishoriKubun(再処理区分);
        parameter.setShoriYM(new FlexibleYearMonth(div.getCcdKokurenJohoTorikomi().get処理年月().getYearMonth().toString()));
        parameter.setShutsuryokujunId(RString.EMPTY);
        return parameter;
    }

    /**
     * 国保連情報データ取込画面へ遷移する。
     *
     * @param div 画面DIV
     * @return 国保連情報データ取込へ遷移
     */
    public ResponseData<TsuchishoJoho153Div> onClick_btnBack(TsuchishoJoho153Div div) {
        return ResponseData.of(div).forwardWithEventName(DBC0410047TransitionEventName.戻る).respond();
    }

}
