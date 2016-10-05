/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410026;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120030.DBC120030_JukyushaKoshinKekkaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410026.TsuchishoJoho533Div;
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
 * 国保連情報受取データ取込_[533]受給者情報更新結果情報のクラスです。
 *
 * @reamsid_L DBC-0980-240 wangkanglei
 */
public class TsuchishoJoho533 {

    private static final RString 帳票ID = new RString("DBC200055_JukyushaKoshinkekkaIchiran");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div TsuchishoJoho533Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho533Div> onLoad(TsuchishoJoho533Div div) {
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
     * @param div TsuchishoJoho533Div
     * @return ResponseData
     */
    public ResponseData<DBC120030_JukyushaKoshinKekkaInParameter> onClick_btnExcute(TsuchishoJoho533Div div) {
        DBC120030_JukyushaKoshinKekkaInParameter parameter = new DBC120030_JukyushaKoshinKekkaInParameter();
        RDate 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月();
        Long 出力順ID = div.getCcdKokurenJohoTorikomi().get出力順ID();
        RString 再処理区分 = div.getCcdKokurenJohoTorikomi().get再処理区分();
        parameter.set処理年月(new FlexibleYearMonth(処理年月.getYearMonth().toDateString()));
        parameter.set出力順ID(出力順ID);
        if (SaiShoriKubun.再処理.get名称().equals(再処理区分)) {
            parameter.set再処理区分(SaiShoriKubun.再処理.getコード());
        } else if (SaiShoriKubun.空白.get名称().equals(再処理区分)) {
            parameter.set再処理区分(SaiShoriKubun.空白.getコード());
        }
        return ResponseData.of(parameter).respond();
    }
}
