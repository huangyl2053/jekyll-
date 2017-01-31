/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.DBE220010_IraishoIkkatuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 依頼書一括発行_バッチフロークラスです。
 *
 * @reamsid_L DBE-0080-180 duanzhanli
 */
public class DBE220010_IraishoIkkatu extends BatchFlowBase<DBE220010_IraishoIkkatuParameter> {

    private static final String CALL_HOMONCHOSAIRAISHOFLOW = "DBE240001_NinteichosaIraisho";
    private static final String CALL_NINTEICHOSAIRAIFLOW = "DBE220003_NinteichosaIraiHakko";
    private static final String CALL_SHUJIIIKENSHOSAKUSEIFLOW = "DBE230003_IkenshoIraiHakko";
    private static final String CALL_TEISHUTSUIRAISHOHAKKOFLOW = "DBE240002_IkenshoIraisho";
    private static final RString HOMONCHOSAIRAISHO_FLOWID = new RString("DBE240001_NinteichosaIraisho");
    private static final RString NINTEICHOSAIRAI_FLOWID = new RString("DBE220003_NinteichosaIraiHakko");
    private static final RString SHUJIIIKENSHOSAKUSEI_FLOWID = new RString("DBE230003_IkenshoIraiHakko");
    private static final RString TEISHUTSUIRAISHOHAKKO_FLOWID = new RString("DBE240002_IkenshoIraisho");

    @Override
    protected void defineFlow() {
        call訪問調査依頼書発行バッチ();
        call主治医意見書提出依頼書発行バッチ();
        if (getParameter().is認定調査依頼発行一覧()) {
            executeStep(CALL_NINTEICHOSAIRAIFLOW);
        }
        if (getParameter().isIkenshoSakuseiHakkoIchiran()) {
            executeStep(CALL_SHUJIIIKENSHOSAKUSEIFLOW);
        }
    }

    private void call訪問調査依頼書発行バッチ() {
        if (getParameter().is認定調査依頼書()
                || getParameter().is認定調査依頼一覧()
                || getParameter().is認定調査票_概況調査()
                || getParameter().is認定調査票_基本調査()
                || getParameter().is認定調査票_概況基本()
                || getParameter().is認定調査票_特記事項()
                || getParameter().is認定調査票_概況特記()
                || getParameter().is認定調査差異チェック票()
                || getParameter().is特記事項_調査群()
                || getParameter().is特記事項_フリータイプ()
                || getParameter().is認定調査依頼履歴一覧()) {
            executeStep(CALL_HOMONCHOSAIRAISHOFLOW);
        }
    }

    private void call主治医意見書提出依頼書発行バッチ() {
        if (getParameter().isShujiiIkenshoSakuseiIraisho()
                || getParameter().isIkenshoSakuseiIraiIchiran()
                || getParameter().isIkenshoKinyu()
                || getParameter().isIkenshoSakuseiSeikyusho()
                || getParameter().isIkenshoSakuseiSeikyuIchiran()
                || getParameter().isIkenshoSakuseiRirekiIchiran()) {
            executeStep(CALL_TEISHUTSUIRAISHOHAKKOFLOW);
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
