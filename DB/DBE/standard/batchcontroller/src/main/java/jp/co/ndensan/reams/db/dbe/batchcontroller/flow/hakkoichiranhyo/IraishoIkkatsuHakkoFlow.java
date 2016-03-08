/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.hakkoichiranhyo;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.IraishoIkkatsuHakkoBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 依頼書一括発行_バッチフロークラスです。
 */
public class IraishoIkkatsuHakkoFlow extends BatchFlowBase<IraishoIkkatsuHakkoBatchParamter> {

    private static final String CALL_HOMONCHOSAIRAISHOFLOW = "homonChosaIraishoFlow";
    private static final String CALL_NINTEICHOSAIRAIFLOW = "ninteiChosaIraiFlow";
    private static final String CALL_SHUJIIIKENSHOSAKUSEIFLOW = "shujiiIkenshoSakuseiFlow";
    private static final String CALL_TEISHUTSUIRAISHOHAKKOFLOW = "teishutsuIraishoHakkoFlow";
    private static final RString HOMONCHOSAIRAISHO_FLOWID = new RString("HomonChosaIraishoFlow");
    private static final RString NINTEICHOSAIRAI_FLOWID = new RString("NinteiChosaIraiFlow");
    private static final RString SHUJIIIKENSHOSAKUSEI_FLOWID = new RString("ShujiiIkenshoSakuseiFlow");
    private static final RString TEISHUTSUIRAISHOHAKKO_FLOWID = new RString("ShujiiIkenshoTeishutsuIraishoHakkoFlow");

    @Override
    protected void defineFlow() {
        if (getParameter().isNinteiChosaIraisyo()
                || getParameter().isNinteiChosahyoKihon()
                || getParameter().isNinteiChosahyoTokki()
                || getParameter().isNinteiChosahyoGaikyou()
                || getParameter().isNinteiChosahyoOCRKihon()
                || getParameter().isNinteiChosahyoOCRTokki()
                || getParameter().isNinteiChosahyoOCRGaikyou()
                || getParameter().isNinteiChosaCheckHyo()
                || getParameter().isZenkoNinteiChosahyo()) {
            executeStep(CALL_HOMONCHOSAIRAISHOFLOW);
        }
        if (getParameter().isIkenshoSakuseiirai()
                || getParameter().isIkenshoSakuseiSeikyuu()
                || getParameter().isShujiiIkenshoSakuseiIraisho()
                || getParameter().isIkenshoKinyuu()
                || getParameter().isIkenshoKinyuuOCR()
                || getParameter().isIkenshoSakuseiSeikyuusho()
                || getParameter().isIkenshoTeishutu()) {

            executeStep(CALL_TEISHUTSUIRAISHOHAKKOFLOW);
        }
        if (getParameter().isNinteiChosairaiHakkou()) {
            executeStep(CALL_NINTEICHOSAIRAIFLOW);
        }
        if (getParameter().isIkenshoSakuseiIraiHakkou()) {
            executeStep(CALL_SHUJIIIKENSHOSAKUSEIFLOW);
        }
    }

    /**
     * 認定調査依頼発行一覧表バッチのです。
     *
     * @return NinteiChosaIraiFlow
     */
    @Step(CALL_NINTEICHOSAIRAIFLOW)
    protected IBatchFlowCommand callNinteiChosaIraiFlow() {
        return otherBatchFlow(NINTEICHOSAIRAI_FLOWID, SubGyomuCode.DBE認定支援, getParameter()).define();
    }

    /**
     * 主治医意見書作成依頼発行一覧表バッチのです。
     *
     * @return ShujiiIkenshoSakuseiFlow
     */
    @Step(CALL_SHUJIIIKENSHOSAKUSEIFLOW)
    protected IBatchFlowCommand callShujiiIkenshoSakuseiFlow() {
        return otherBatchFlow(SHUJIIIKENSHOSAKUSEI_FLOWID, SubGyomuCode.DBE認定支援, getParameter()).define();
    }

    /**
     * 訪問調査依頼書発行バッチのです。
     *
     * @return HomonChosaIraishoFlow
     */
    @Step(CALL_HOMONCHOSAIRAISHOFLOW)
    protected IBatchFlowCommand callHomonChosaIraishoFlow() {
        return otherBatchFlow(HOMONCHOSAIRAISHO_FLOWID, SubGyomuCode.DBE認定支援, getParameter()).define();
    }

    /**
     * 主治医意見書提出依頼書発行バッチのです。
     *
     * @return ShujiiIkenshoTeishutsuIraishoHakkoFlow
     */
    @Step(CALL_TEISHUTSUIRAISHOHAKKOFLOW)
    protected IBatchFlowCommand callShujiiIkenshoTeishutsuIraishoHakkoFlow() {
        return otherBatchFlow(TEISHUTSUIRAISHOHAKKO_FLOWID, SubGyomuCode.DBE認定支援, getParameter()).define();
    }

}
