package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.hoshushiharaijunbi;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbi.ChosaHoshuSeikyuProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbi.ChosaHoshuShiharaiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbi.ChosaHoshumeisaiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbi.HiyobenshotoShiharaiMeisaishoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbi.IinhoshushiharaiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbi.IkenShiharaiuchiwakeProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbi.IkenshoHoshuSeikyuProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbi.ShinsainShiharaiMeisaishoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbi.ShujiiHoshuShiharaiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbi.ShujiiHoshumeisaiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.hoshushiharaijunbi.HoshuShiharaiJunbiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 報酬支払い通知書請求書・確認書のバッチフロークラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
public class HoshuShiharaiJunbiFlow extends BatchFlowBase<HoshuShiharaiJunbiBatchParameter> {

    private static final String CHOSAHOSHUSEIKYU_PROCESS = "ChosaHoshuSeikyuProcess";
    private static final String CHOSAHOSHUSHIHARAI_PROCESS = "ChosaHoshuShiharaiProcess";
    private static final String CHOSAHOSHUMEISAI_PROCESS = "ChosaHoshumeisaiProcess";
    private static final String HIYOBENSHOTOSHIHARAI_PROCESS = "HiyobenshotoShiharaiProcess";
    private static final String IINHOSHUSHIHARAI_PROCESS = "IinhoshushiharaiProcess";
    private static final String IKENSHIHARAIUCHIWAKE_PROCESS = "IkenShiharaiuchiwakeProcess";
    private static final String IKENSHOHOSHUSEIKYU_PROCESS = "IkenshoHoshuSeikyuProcess";
    private static final String SHINSAINSHIHARAI_PROCESS = "ShinsainShiharaiProcess";
    private static final String SHUJIIHOSHUSHIHARAI_PROCESS = "ShujiiHoshuShiharaiProcess";
    private static final String SHUJIIHOSHUMEISAI_PROCESS = "ShujiiHoshumeisaiProcess";

    @Override
    protected void defineFlow() {
        if (getParameter().getChkchosa().contains(new RString("1"))) {
            executeStep(CHOSAHOSHUSEIKYU_PROCESS);
        }
        if (getParameter().getChkchosa().contains(new RString("2"))) {
            executeStep(CHOSAHOSHUSHIHARAI_PROCESS);
        }
        if (getParameter().getChkchosa().contains(new RString("3"))) {
            executeStep(CHOSAHOSHUMEISAI_PROCESS);
        }
        if (getParameter().getChkshujii().contains(new RString("1"))) {
            executeStep(IKENSHOHOSHUSEIKYU_PROCESS);
        }
        if (getParameter().getChkshujii().contains(new RString("2"))) {
            executeStep(SHUJIIHOSHUSHIHARAI_PROCESS);
        }
        if (getParameter().getChkshujii().contains(new RString("3"))) {
            executeStep(IKENSHIHARAIUCHIWAKE_PROCESS);
        }
        if (getParameter().getChkshujii().contains(new RString("4"))) {
            executeStep(SHUJIIHOSHUMEISAI_PROCESS);
        }
        if (getParameter().getChkshinsakai().contains(new RString("1"))) {
            executeStep(IINHOSHUSHIHARAI_PROCESS);
        }
        if (getParameter().getChkshinsakai().contains(new RString("2"))) {
            executeStep(HIYOBENSHOTOSHIHARAI_PROCESS);
        }
        if (getParameter().getChkshinsakai().contains(new RString("3"))) {
            executeStep(SHINSAINSHIHARAI_PROCESS);
        }
    }

    /**
     * 認定調査報酬請求書のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(CHOSAHOSHUSEIKYU_PROCESS)
    protected IBatchFlowCommand createShinseiJouhouInsatuData() {
        return loopBatch(ChosaHoshuSeikyuProcess.class).arguments(
                getParameter().toHoshuShiharaiJunbiProcessParameter()).define();
    }

    /**
     * 認定調査報酬支払通知書のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(CHOSAHOSHUSHIHARAI_PROCESS)
    protected IBatchFlowCommand createChosaHoshuShiharaiData() {
        return loopBatch(ChosaHoshuShiharaiProcess.class).arguments(
                getParameter().toHoshuShiharaiJunbiProcessParameter()).define();
    }

    /**
     * 認定調査報酬支払明細書のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(CHOSAHOSHUMEISAI_PROCESS)
    protected IBatchFlowCommand createChosaHoshumeisaiData() {
        return loopBatch(ChosaHoshumeisaiProcess.class).arguments(
                getParameter().toHoshuShiharaiJunbiProcessParameter()).define();
    }

    /**
     * 介護認定審査委員報酬・費用弁償等支払明細書のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(HIYOBENSHOTOSHIHARAI_PROCESS)
    protected IBatchFlowCommand createHiyobenshotoShiharaiMeisaishoData() {
        return loopBatch(HiyobenshotoShiharaiMeisaishoProcess.class).arguments(
                getParameter().toHoshuShiharaiJunbiProcessParameter()).define();
    }

    /**
     * 介護認定審査会委員報酬支払通知書のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(IINHOSHUSHIHARAI_PROCESS)
    protected IBatchFlowCommand createIinhoshushiharaiData() {
        return loopBatch(IinhoshushiharaiProcess.class).arguments(
                getParameter().toHoshuShiharaiJunbiProcessParameter()).define();
    }

    /**
     * 主治医意見書作成料支払内訳確認書のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(IKENSHIHARAIUCHIWAKE_PROCESS)
    protected IBatchFlowCommand createIkenShiharaiuchiwakeData() {
        return loopBatch(IkenShiharaiuchiwakeProcess.class).arguments(
                getParameter().toHoshuShiharaiJunbiProcessParameter()).define();
    }

    /**
     * 主治医意見書作成報酬請求書のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(IKENSHOHOSHUSEIKYU_PROCESS)
    protected IBatchFlowCommand createIkenshoHoshuSeikyuData() {
        return loopBatch(IkenshoHoshuSeikyuProcess.class).arguments(
                getParameter().toHoshuShiharaiJunbiProcessParameter()).define();
    }

    /**
     * 介護認定審査会委員報酬支払明細書のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHINSAINSHIHARAI_PROCESS)
    protected IBatchFlowCommand createShinsainShiharaiMeisaishoData() {
        return loopBatch(ShinsainShiharaiMeisaishoProcess.class).arguments(
                getParameter().toHoshuShiharaiJunbiProcessParameter()).define();
    }

    /**
     * 主治医意見書作成報酬支払通知書のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHUJIIHOSHUSHIHARAI_PROCESS)
    protected IBatchFlowCommand createShujiiHoshuShiharaiData() {
        return loopBatch(ShujiiHoshuShiharaiProcess.class).arguments(
                getParameter().toHoshuShiharaiJunbiProcessParameter()).define();
    }

    /**
     * 主治医意見書作成報酬支払明細書のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHUJIIHOSHUMEISAI_PROCESS)
    protected IBatchFlowCommand createShujiiHoshumeisaiData() {
        return loopBatch(ShujiiHoshumeisaiProcess.class).arguments(
                getParameter().toHoshuShiharaiJunbiProcessParameter()).define();
    }
}
