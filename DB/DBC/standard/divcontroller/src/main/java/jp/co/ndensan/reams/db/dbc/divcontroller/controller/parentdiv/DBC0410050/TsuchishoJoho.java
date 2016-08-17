/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410050;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.kokuhorendatatorikomi.KokuhorenDataTorikomiBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410050.TsuchishoJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunManagerFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護予防・日常生活支援総合事業費審査決定請求明細表情報のクラスです。
 *
 * @reamsid_L DBC-2500-040 dingminghao
 */
public class TsuchishoJoho {

    /**
     * 画面初期化のメソッド。
     *
     * @param div TsuchishoJohoDiv
     * @return 総合事業費資格総合表情報の画面。
     */
    public ResponseData<TsuchishoJohoDiv> onLoad(TsuchishoJohoDiv div) {

        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200084.getReportId(), parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下。
     *
     * @param div TsuchishoJohoDiv
     * @return KokuhorenDataTorikomiBatchParameter
     */
    public ResponseData<KokuhorenDataTorikomiBatchParameter> onClick_btnExcute(TsuchishoJohoDiv div) {

        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200084.getReportId(),
                div.getCcdKokurenJohoTorikomi().get出力順ID());
        if (outputOrder != null) {
            ChohyoShutsuryokujunManagerFactory.createInstance().save前回出力順(outputOrder);
        }
        KokuhorenDataTorikomiBatchParameter parameter = new KokuhorenDataTorikomiBatchParameter();
        RDate 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月();
        if (処理年月 != null) {
            parameter.setShoriYM(new FlexibleYearMonth(処理年月.getYearMonth().toString()));
        }
        RString 再処理区分 = div.getCcdKokurenJohoTorikomi().get再処理区分();
        if (SaiShoriKubun.再処理.get名称().equals(再処理区分)) {
            parameter.setSaishoriKubun(SaiShoriKubun.再処理);
        } else if (SaiShoriKubun.空白.get名称().equals(再処理区分)) {
            parameter.setSaishoriKubun(SaiShoriKubun.空白);
        }
        if (null != div.getCcdKokurenJohoTorikomi().get出力順ID()) {
            long 出力順ID = div.getCcdKokurenJohoTorikomi().get出力順ID();
            parameter.setShutsuryokujunId(出力順ID);
        }
        return ResponseData.of(parameter).respond();
    }
}
