/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0400011;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kogakukaigokyufuhitaishoshatoroku.KogakuKaigoKyufuhiTaishoshaBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0400011.KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukaigoservicehikyufutaishoshatoroku.KogakuKaigoServicehiKyufuTaishoshaToroku;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * {@link KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv}のHandlerクラスです。
 *
 * @reamsid_L DBC-2010-030 huzongcheng
 */
public class KogakuKaigoKyufuhiTaishoshaTorokuHandler {

    private final KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv div;

    private static final RString 高額介護サービス費給付対象者登録自庁 = new RString("DBCMN41002");
    private static final RString 総合事業高額介護サービス費給付対象者登録自庁 = new RString("DBCMN41004");
    private static final RString 実行ボタン_DBCMN41002 = new RString("btnBatch41002");
    private static final RString 実行ボタン_DBCMN41004 = new RString("btnBatch41004");

    /**
     * コンストラクタです。
     *
     * @param div KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv
     */
    public KogakuKaigoKyufuhiTaishoshaTorokuHandler(KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv
     * @return KogakuKaigoKyufuhiTaishoshaTorokuHandler
     */
    public static KogakuKaigoKyufuhiTaishoshaTorokuHandler of(KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv div) {
        return new KogakuKaigoKyufuhiTaishoshaTorokuHandler(div);
    }

    /**
     * 初期化のメソッドです。
     */
    public void initializeDisplay() {
        RString uiContainerId = ResponseHolder.getUIContainerId();
        KogakuKaigoServicehiKyufuTaishoshaToroku business = new KogakuKaigoServicehiKyufuTaishoshaToroku();
        KokuhorenInterfaceKanri result = business.getSinsaYM(uiContainerId);
        div.getKogakuKaigoKyufuhiTaishoshaTorokuPanel().getTxtShinsaYM().setFromValue(result.get抽出開始日時().getDate());
        div.getKogakuKaigoKyufuhiTaishoshaTorokuPanel().getTxtShinsaYM().setToValue(result.get抽出開始日時().getDate());
        div.getPublishIchiranhyo().setIsPublish(true);
        if (高額介護サービス費給付対象者登録自庁.equals(uiContainerId)) {
            div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200016.getReportId());
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(実行ボタン_DBCMN41004, true);
        } else if (総合事業高額介護サービス費給付対象者登録自庁.equals(uiContainerId)) {
            div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200077.getReportId());
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(実行ボタン_DBCMN41002, true);
        }
        set画面初期化制御();
    }

    /**
     * バッチパラメータ取得します。
     *
     * @return KogakuKaigoKyufuhiTaishoshaBatchParameter
     */
    public KogakuKaigoKyufuhiTaishoshaBatchParameter getBatchParameter() {
        RString 審査年月From = div.getKogakuKaigoKyufuhiTaishoshaTorokuPanel()
                .getTxtShinsaYM().getFromValue().getYearMonth().toDateString();
        RString 審査年月To = div.getKogakuKaigoKyufuhiTaishoshaTorokuPanel()
                .getTxtShinsaYM().getToValue().getYearMonth().toDateString();
        boolean flg = div.getPublishIchiranhyo().isIsPublish();
        Long shuturyokuJunn = div.getCcdChohyoShutsuryokujun().get出力順ID();

        KogakuKaigoServicehiKyufuTaishoshaToroku business = new KogakuKaigoServicehiKyufuTaishoshaToroku();
        KogakuKaigoKyufuhiTaishoshaBatchParameter parameter
                = business.getKogakuKaigoServicehiKyufuTaishoshaTorokuBatchParameter(
                        審査年月From,
                        審査年月To,
                        flg,
                        shuturyokuJunn);
        return parameter;
    }

    private void set画面初期化制御() {
        div.getKogakuKaigoKyufuhiTaishoshaTorokuPanel().getTxtShinsaYM().setDisabled(true);
    }

}
