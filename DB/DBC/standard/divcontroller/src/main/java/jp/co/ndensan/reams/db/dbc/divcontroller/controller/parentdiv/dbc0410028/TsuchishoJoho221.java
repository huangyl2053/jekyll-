/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410028;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanshikyuketteiin.DBC120090_ShokanShikyuKetteiInBacthParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410028.TsuchishoJoho221Div;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報受取データ取込_[221]償還払支給決定者一覧情報
 */
public class TsuchishoJoho221 {

    /**
     * onLoad
     *
     * @param div TsuchishoJoho221Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho221Div> onLoad(TsuchishoJoho221Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200021_ShokanbaraiShikyuKetteishaIchiran")));
        div.getCcdKokurenJohoTorikomi().onLoadModeShutsuryokujunJoken2(SubGyomuCode.DBC介護給付, code.get帳票分類ID());
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div TsuchishoJoho221Div
     * @return ResponseData
     */
    public ResponseData<DBC120090_ShokanShikyuKetteiInBacthParameter> onClick_btnExcute(TsuchishoJoho221Div div) {
        RDate 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月();
        RString 再処理区分 = div.getCcdKokurenJohoTorikomi().get再処理区分();
        long 出力順ID = div.getCcdKokurenJohoTorikomi().get出力順ID();
        DBC120090_ShokanShikyuKetteiInBacthParameter parameter = new DBC120090_ShokanShikyuKetteiInBacthParameter();
        parameter.setShoriYearMonth(処理年月);
        parameter.setSaishoriKubun(再処理区分);
        parameter.setShutsuryokujun(new RString(String.valueOf(出力順ID)));
        return ResponseData.of(parameter).respond();
    }

}
