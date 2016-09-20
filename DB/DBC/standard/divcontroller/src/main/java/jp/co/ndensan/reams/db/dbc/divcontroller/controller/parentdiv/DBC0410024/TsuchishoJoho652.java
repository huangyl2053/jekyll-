/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410024;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120200.DBC120200_SaishinsaKetteiKohifutanshaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410024.TsuchishoJoho652Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 国保連情報受取データ取込_[652]介護給付費再審査決定通知書（公費）情報のクラスです。
 *
 * @reamsid_L DBC-0980-270 wangkanglei
 */
public class TsuchishoJoho652 {

    private static final RString 帳票ID = new RString("DBC200049_SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBun");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div TsuchishoJoho652Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho652Div> onLoad(TsuchishoJoho652Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(帳票ID));
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(SubGyomuCode.DBC介護給付, code.get帳票分類ID(), parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン事件のメソッドます。
     *
     * @param div TsuchishoJoho652Div
     * @return ResponseData
     */
    public ResponseData<DBC120200_SaishinsaKetteiKohifutanshaInParameter> onClick_btnExcute(TsuchishoJoho652Div div) {
        DBC120200_SaishinsaKetteiKohifutanshaInParameter parameter = new DBC120200_SaishinsaKetteiKohifutanshaInParameter();
        RDate 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月();
        Long 出力順ID = div.getCcdKokurenJohoTorikomi().get出力順ID();
        RString 再処理区分 = div.getCcdKokurenJohoTorikomi().get再処理区分();
        parameter.setShoriYM(new FlexibleYearMonth(処理年月.getYearMonth().toDateString()));
        parameter.setShutsuryokujunId(出力順ID);
        if (SaiShoriKubun.再処理.get名称().equals(再処理区分)) {
            parameter.setSaishoriKubun(SaiShoriKubun.再処理);
        } else if (SaiShoriKubun.空白.get名称().equals(再処理区分)) {
            parameter.setSaishoriKubun(SaiShoriKubun.空白);
        }
        return ResponseData.of(parameter).respond();
    }
}
