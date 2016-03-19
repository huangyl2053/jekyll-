/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410023;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.kagoketteikohifutanshain.DBC120170_KagoKetteiKohifutanshaInBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410023.TsuchishoJoho651Div;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報受取データ取込_[651]介護給付費過誤決定通知書（公費）情報のクラスです
 */
public class TsuchishoJoho651 {

    /**
     * 画面初期化
     *
     * @param div TsuchishoJoho651Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho651Div> onLoad(TsuchishoJoho651Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200051_KagoKetteitsuchishoTorikomiIchiranKohifutanshaBun")));
        div.getCcdKokurenJohoTorikomi().onLoadModeShutsuryokujunJoken2(SubGyomuCode.DBC介護給付, code.get帳票分類ID());
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン事件
     *
     * @param div TsuchishoJoho651Div
     * @return ResponseData
     */
    public ResponseData<DBC120170_KagoKetteiKohifutanshaInBatchParameter> onClick_btnExcute(TsuchishoJoho651Div div) {
        DBC120170_KagoKetteiKohifutanshaInBatchParameter parameter = new DBC120170_KagoKetteiKohifutanshaInBatchParameter();
        RDate 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月();
        long 出力順ID = div.getCcdKokurenJohoTorikomi().get出力順ID();
        parameter.setShoriYM(new FlexibleYearMonth(処理年月.getYearMonth().toString()));
        parameter.setShutsuryokujunId(出力順ID);
        return ResponseData.of(parameter).respond();
    }
}
