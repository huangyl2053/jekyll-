/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb1140001;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb1140001.GetJuminjouhouProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb1140001.RinjiCreatTableProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb1140001.ShotokuShokaihyotoReportProcess;
import jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.fuka.SetaiShotokuKazeiHanteiBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT51001_所得照会票一括発行
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class DBB1140001_ShotokuShokaihyoHakkoFlow extends BatchFlowBase<ShotokuShokaihyoHakkoBatchParameter> {

    private static final String GETJUMINJOUHOU_DATA_PROCESS = "getJuminjouhouProcess";
    private static final String RINJICREAT_TABLE_PROCESS = "rinjiCreatTableProcess";
    private static final String PRT_SHOTOKUSHOKAIHYO_PROCESS = "printShotokuShokaihyoProcess";
    private static final String 世帯員把握_TEMP_1 = "setaiShotokuKazeiHanteiFuka";
    private static final String 世帯員把握_TEMP_2 = "setaiShotokuKazeiHanteiKogakuKaiko";

    private static final ReportId 帳票ID = new ReportId("DBB200024_ShotokushokaihyoHakkoIchiran");
    private static final RString BATCH_ID = new RString("SetaiShotokuKazeiHanteiFlow");
    private static final RString 出力対象が_１ = new RString("1");
    private static final RString 出力対象が_２ = new RString("2");
    private static final RString 出力対象が_３ = new RString("3");
    private RString 出力順;
    private RString 改頁項目ID;

    @Override
    protected void defineFlow() {
        RString reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBB介護賦課, 帳票ID, reamsLoginID, getParameter().get出力順ID());
        出力順 = MyBatisOrderByClauseCreator.create(
                ShotokushokaihyoHakkoIchiranProperty.BreakerFieldsEnum.class, outputOrder);
        改頁項目ID = outputOrder.get改頁項目ID();
        RString 出力対象 = getParameter().get出力対象();
        executeStep(RINJICREAT_TABLE_PROCESS);
        executeStep(GETJUMINJOUHOU_DATA_PROCESS);

        if (出力対象.equals(出力対象が_１)) {
            executeStep(世帯員把握_TEMP_1);
            executeStep(世帯員把握_TEMP_2);
        } else if (出力対象.equals(出力対象が_２)) {
            executeStep(世帯員把握_TEMP_1);
        } else if (出力対象.equals(出力対象が_３)) {
            executeStep(世帯員把握_TEMP_2);
        }

        executeStep(PRT_SHOTOKUSHOKAIHYO_PROCESS);
    }

    /**
     * 一時テーブル作成するクラスです。
     *
     * @return IBatchFlowCommand
     */
    @Step(RINJICREAT_TABLE_PROCESS)
    protected IBatchFlowCommand rinjiCreatTableProcess() {
        return loopBatch(RinjiCreatTableProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    /**
     * 世帯員所得情報temp1へ出力する
     *
     * @return 世帯員所得情報一時
     */
    @Step(世帯員把握_TEMP_1)
    protected IBatchFlowCommand setaiShotokuKazeiHanteiFuka() {
        RString 管理識別区分 = SetaiinHaakuKanriShikibetsuKubun.賦課.getコード();
        SetaiShotokuKazeiHanteiBatchParameter param = new SetaiShotokuKazeiHanteiBatchParameter(管理識別区分);
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課, param).define();
    }

    /**
     * 世帯員所得情報temp1へ出力する
     *
     * @return 世帯員所得情報一時
     */
    @Step(世帯員把握_TEMP_2)
    protected IBatchFlowCommand setaiShotokuKazeiHanteiKogakuKaiko() {
        RString 管理識別区分 = SetaiinHaakuKanriShikibetsuKubun.高額介護.getコード();
        SetaiShotokuKazeiHanteiBatchParameter param = new SetaiShotokuKazeiHanteiBatchParameter(管理識別区分);
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課, param).define();
    }

    /**
     * 所得照会票発行一覧のデータ取得
     *
     * @return IBatchFlowCommand
     */
    @Step(GETJUMINJOUHOU_DATA_PROCESS)
    protected IBatchFlowCommand getJuminjouhouProcess() {
        ShotokuShokaihyoHakkoBatchParameter param = new ShotokuShokaihyoHakkoBatchParameter();
        param.set出力順(出力順);
        param.set改頁項目ID(改頁項目ID);
        return loopBatch(GetJuminjouhouProcess.class).arguments(param.toProcessParameter()).define();
    }

    /**
     * 所得照会票の出力するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(PRT_SHOTOKUSHOKAIHYO_PROCESS)
    protected IBatchFlowCommand printShotokuShokaihyoProcess() {
        ShotokuShokaihyoHakkoBatchParameter param = new ShotokuShokaihyoHakkoBatchParameter();
        param.set出力順(出力順);
        param.set改頁項目ID(改頁項目ID);
        return simpleBatch(ShotokuShokaihyotoReportProcess.class).arguments(param.toProcessParameter()).define();
    }

}
