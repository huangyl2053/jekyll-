/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410031;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.ｋogakuｋyufuｋetteiIn.KogakuKyufuKetteiInBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410031.TsuchishoJoho351Div;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報受取データ取込_[351]高額介護サービス費支給（不支給）決定者一覧表情報のクラスです
 */
public class TsuchishoJoho351 {

    /**
     * 画面初期化
     *
     * @param div TsuchishoJoho351Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho351Div> onLoad(TsuchishoJoho351Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200015_KogakuShikyuFushikyuKetteishaIchiran")));
        div.getCcdKokurenJohoTorikomi().onLoadModeShutsuryokujunJoken2(SubGyomuCode.DBC介護給付, code.get帳票分類ID());
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン事件
     *
     * @param div TsuchishoJoho351Div
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuKetteiInBatchParameter> onClick_btnExcute(TsuchishoJoho351Div div) {
        KogakuKyufuKetteiInBatchParameter parameter = new KogakuKyufuKetteiInBatchParameter();
        RDate 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月();
        long 出力順ID = div.getCcdKokurenJohoTorikomi().get出力順ID();
        parameter.setShoriYM(処理年月.getYearMonth().toDateString());
        parameter.setShutsuryokujun(出力順ID);
        return ResponseData.of(parameter).respond();
    }
}
