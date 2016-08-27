package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd1080001;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd1080001.GemmenGengakuTaishoGaiShaListCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd1080001.GemmenShinseishoTaishohaakuProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd1080001.KousinSinseiTaishougaishaJohoProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd1080001.ShinseishoHakkoTaishoJohoSakuseiProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd1080001.ShinseishoHakkoTaishoshaHaakuParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmenGengakuTaishoShaHanteiYoukonSakusei.GemmenGengakuTaishoShaHanteiYoukonSakuseiParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1080001.GemmenShinseishoTaishohaakuProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1080001.KousinSinseiTaishougaishaJohoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1080001.ShinseishoHakkoTaishoJohoSakuseiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * DBDBT12021_1_減免減額申請書発行用対象者把握のバッチフロークラスです。
 *
 * @reamsid_L DBD-3530-030 liuwei2
 */
public class GemmenShinseishoTaishohaakuFlow extends BatchFlowBase<ShinseishoHakkoTaishoshaHaakuParameter> {

    private static final String 減免減額対象者判定用根拠作成対象者を作成 = "get減免減額対象者判定用根拠作成対象者";
    private static final String 減免減額対象者判定用根拠を作成 = "GemmenGengakuTaishoShaHanteiYoukonSakuseiFlow";
    private static final RString TAISSHAHANTYOUKSAKUSFLOW = new RString("GemmenGengakuTaishoShaHanteiYoukonSakuseiFlow");
    private static final String 申請書発行対象者情報を作成する = "get申請書発行対象者情報";
    private static final String 更新申請対象外者情報を取得する = "get更新申請対象外者情報";
    private static final String 減免減額更新申請対象外者一覧CSV = "CSV_PROCESS";

    @Override
    protected void defineFlow() {
        executeStep(減免減額対象者判定用根拠作成対象者を作成);
        executeStep(減免減額対象者判定用根拠を作成);
        executeStep(申請書発行対象者情報を作成する);
        if (getResult(UUID.class, new RString(申請書発行対象者情報を作成する), ShinseishoHakkoTaishoJohoSakuseiProcess.OUT_把握処理ID) != null) {
            executeStep(更新申請対象外者情報を取得する);
            executeStep(減免減額対象者判定用根拠を作成);
            executeStep(減免減額更新申請対象外者一覧CSV);
        }
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(減免減額対象者判定用根拠作成対象者を作成)
    protected IBatchFlowCommand get減免減額対象者判定用根拠作成対象者() {
        return loopBatch(GemmenShinseishoTaishohaakuProcess.class)
                .arguments(createGemmenShinseishoTaishohaakuProcessParameter())
                .define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(減免減額対象者判定用根拠を作成)
    protected IBatchFlowCommand call減免減額対象者判定用根拠を作成() {
        return otherBatchFlow(TAISSHAHANTYOUKSAKUSFLOW, SubGyomuCode.DBD介護受給,
                getGemmenGengakuTaishoShaHanteiYoukonSakuseiBatchParameter()).define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(申請書発行対象者情報を作成する)
    protected IBatchFlowCommand get申請書発行対象者情報() {
        return loopBatch(ShinseishoHakkoTaishoJohoSakuseiProcess.class)
                .arguments(createShinseishoHakkoTaishoJohoSakuseiProcessParameter())
                .define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(更新申請対象外者情報を取得する)
    protected IBatchFlowCommand get更新申請対象外者情報() {
        return loopBatch(KousinSinseiTaishougaishaJohoProcess.class)
                .arguments(createKousinSinseiTaishougaishaJohoProcessParameter())
                .define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(減免減額更新申請対象外者一覧CSV)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(GemmenGengakuTaishoGaiShaListCsvProcess.class)
                .arguments(getParameter().toGemmenGengakuTaishoGaiShaListProcessParameter())
                .define();
    }

    private GemmenShinseishoTaishohaakuProcessParameter createGemmenShinseishoTaishohaakuProcessParameter() {
        ShinseishoHakkoTaishoshaHaakuParameter parameter = getParameter();
        GemmenShinseishoTaishohaakuProcessParameter processParameter = new GemmenShinseishoTaishohaakuProcessParameter();
        processParameter.set基準日(parameter.get基準日());
        processParameter.set新規更新区分(parameter.get新規更新区分());
        processParameter.set施設入所区分(parameter.get施設入所区分());
        processParameter.set旧措置区分(parameter.get旧措置区分());
        processParameter.set減免減額種類(parameter.get減免減額種類());
        return processParameter;
    }

    private ShinseishoHakkoTaishoJohoSakuseiProcessParameter createShinseishoHakkoTaishoJohoSakuseiProcessParameter() {
        ShinseishoHakkoTaishoshaHaakuParameter parameter = getParameter();
        ShinseishoHakkoTaishoJohoSakuseiProcessParameter processParameter = new ShinseishoHakkoTaishoJohoSakuseiProcessParameter();
        processParameter.set基準日(parameter.get基準日());
        processParameter.set減免減額種類(parameter.get減免減額種類());
        processParameter.set利用者負担段階(parameter.get利用者負担段階());
        processParameter.set市町村民税本人非課税者(parameter.is市町村民税本人非課税者());
        processParameter.set市町村民税非課税世帯(parameter.is市町村民税非課税世帯());
        processParameter.set生活保護受給者(parameter.is生活保護受給者());
        processParameter.set老齢福祉年金受給者(parameter.is老齢福祉年金受給者());
        processParameter.set課税世帯の被保険者を含む(parameter.is課税世帯の被保険者を含む());
        processParameter.set所得年度(parameter.get所得年度());
        return processParameter;
    }

    private GemmenGengakuTaishoShaHanteiYoukonSakuseiParameter getGemmenGengakuTaishoShaHanteiYoukonSakuseiBatchParameter() {
        ShinseishoHakkoTaishoshaHaakuParameter parameter = getParameter();
        return new GemmenGengakuTaishoShaHanteiYoukonSakuseiParameter(parameter.get所得年度());
    }

    private KousinSinseiTaishougaishaJohoProcessParameter createKousinSinseiTaishougaishaJohoProcessParameter() {
        ShinseishoHakkoTaishoshaHaakuParameter parameter = getParameter();
        KousinSinseiTaishougaishaJohoProcessParameter processParameter = new KousinSinseiTaishougaishaJohoProcessParameter();
        processParameter.set基準日(parameter.get基準日());
        processParameter.set減免減額種類(parameter.get減免減額種類());
        processParameter.set把握処理ID(getResult(UUID.class, new RString(申請書発行対象者情報を作成する), ShinseishoHakkoTaishoJohoSakuseiProcess.OUT_把握処理ID));
        return processParameter;
    }
}
