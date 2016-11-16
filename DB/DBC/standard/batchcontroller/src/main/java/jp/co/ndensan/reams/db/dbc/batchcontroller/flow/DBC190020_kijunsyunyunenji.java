/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.CreateTaishoSetaiyinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.DelSetaiyinShotokuJyohoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.DelTaishoSeitaiyinTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.InsDbT3116KijunShunyugakuTekiyoKanriProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.InsSetaiyinShotokuJyohoTemp1Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.InsSetaiyinShotokuJyohoTemp2Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.InsTaishoSeitaiyinTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.UpdSetaiyinShotokuJyohoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.UpdShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.UpdTaishoSeitaiyinTemp1Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.UpdTaishoSeitaiyinTemp2Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.UpdTaishoSeitaiyinTemp3Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.UpdTaishoSeitaiyinTemp4Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.UpdTaishoSeitaiyinTemp5Process;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC190020.DBC190020_kijunsyunyunenjiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kijunshunyugaku.ShinseishoHakkoChushutsuJoken;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kijunsyunyunenji.InsSetaiyinShotokuJyohoTemp1ProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kijunsyunyunenji.InsTaishoSeitaiyinTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.DBB002001.DBB002001_SetaiinHaakuParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 基準収入額適用申請書_年次分作成のバッチ処理フロークラスです
 *
 * @reamsid_L DBC-4630-030 jiangwenkai
 */
public class DBC190020_kijunsyunyunenji extends BatchFlowBase<DBC190020_kijunsyunyunenjiParameter> {

    private static final String 世帯員所得情報一時テーブルに登録1 = "InsSetaiyinShotokuJyohoTemp1";
    private static final String 世帯員把握_TEMP_2 = "setaiShotokuKazeiHanteiKogakuKaiko";
    private static final String 世帯員所得情報一時テーブルに更新 = "updSetaiyinShotokuJyohoTemp";
    private static final String 世帯員所得情報一時テーブルに重複削除 = "delSetaiyinShotokuJyohoTemp";
    private static final RString BATCH_ID = new RString("DBB002001_SetaiinHaaku");
    private static final String 対象世帯員クラスに登録 = "insTaishoSeitaiyinTemp";
    private static final String 対象世帯員クラスに更新1 = "updTaishoSeitaiyinTemp1";
    private static final String 対象世帯員クラスに更新2 = "updTaishoSeitaiyinTemp2";
    private static final String 対象世帯員クラスに更新3 = "updTaishoSeitaiyinTemp3";
    private static final String 対象世帯員クラスに削除 = "delTaishoSeitaiyinTemp";
    private static final String 世帯員所得情報一時テーブルに登録2 = "InsSetaiyinShotokuJyohoTemp2";
    private static final String 対象世帯員クラスに登録2 = "insTaishoSeitaiyinTemp2";
    private static final String 対象世帯員クラスに更新4 = "updTaishoSeitaiyinTemp4";
    private static final String 対象世帯員クラスに更新5 = "updTaishoSeitaiyinTemp5";
    private static final String 帳票出力_CSV作成 = "createTaishoSetaiyin";
    private static final String 基準収入額管理マスタに登録 = "insDbT3116KijunShunyugakuTekiyoKanri";
    private static final String 処理日付管理マスタに更新 = "updShoriDateKanri";

    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");

    @Override
    protected void defineFlow() {

        executeStep(世帯員所得情報一時テーブルに登録1);
        executeStep(世帯員把握_TEMP_2);
        executeStep(世帯員所得情報一時テーブルに更新);
        executeStep(世帯員所得情報一時テーブルに重複削除);
        executeStep(対象世帯員クラスに登録);
        executeStep(対象世帯員クラスに更新1);
        executeStep(対象世帯員クラスに更新2);
        executeStep(対象世帯員クラスに更新3);
        executeStep(対象世帯員クラスに削除);

        executeStep(世帯員所得情報一時テーブルに登録2);
        executeStep(世帯員把握_TEMP_2);
        executeStep(世帯員所得情報一時テーブルに更新);
        executeStep(世帯員所得情報一時テーブルに重複削除);
        executeStep(対象世帯員クラスに登録2);
        if (!ShinseishoHakkoChushutsuJoken.白紙印刷.getコード().equals(getParameter().get抽出条件())) {
            executeStep(対象世帯員クラスに更新4);
            executeStep(対象世帯員クラスに更新5);
        }
        executeStep(帳票出力_CSV作成);
        executeStep(基準収入額管理マスタに登録);
        executeStep(処理日付管理マスタに更新);

    }

    /**
     * 世帯員所得情報一時テーブルに登録です。
     *
     * @return InsSetaiyinShotokuJyohoTemp1Process
     */
    @Step(世帯員所得情報一時テーブルに登録1)
    protected IBatchFlowCommand callInsSetaiyinShotokuJyohoTemp1Process() {
        InsSetaiyinShotokuJyohoTemp1ProcessParameter parameter = new InsSetaiyinShotokuJyohoTemp1ProcessParameter();
        parameter.set帳票出力順ID(getParameter().get帳票出力順ID());
        parameter.set帳票ID(ReportIdDBC.DBC100064.getReportId());
        parameter.set抽出条件(getParameter().get抽出条件());
        parameter.set世帯員把握基準日(getParameter().get世帯員把握基準日());
        parameter.set被保険者番号(new HihokenshaNo(getParameter().get被保険者番号()));
        return loopBatch(InsSetaiyinShotokuJyohoTemp1Process.class).arguments(parameter).define();
    }

    /**
     * 世帯員所得情報temp1へ出力する
     *
     * @return 世帯員所得情報一時
     */
    @Step(世帯員把握_TEMP_2)
    protected IBatchFlowCommand callSetaiShotokuKazeiHanteiKogakuKaikoProcess() {
        RString 管理識別区分 = SetaiinHaakuKanriShikibetsuKubun.高額介護.getコード();
        DBB002001_SetaiinHaakuParameter param = new DBB002001_SetaiinHaakuParameter(管理識別区分);
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBZ介護共通, param).define();
    }

    /**
     * 世帯員所得情報一時テーブルに更新です。
     *
     * @return UpdSetaiyinShotokuJyohoTempProcess
     */
    @Step(世帯員所得情報一時テーブルに更新)
    protected IBatchFlowCommand callUpdSetaiyinShotokuJyohoTempProcess() {
        return simpleBatch(UpdSetaiyinShotokuJyohoTempProcess.class).define();
    }

    /**
     * 世帯員所得情報一時テーブルに登録です。
     *
     * @return DelSetaiyinShotokuJyohoTempProcess
     */
    @Step(世帯員所得情報一時テーブルに重複削除)
    protected IBatchFlowCommand callDelSetaiyinShotokuJyohoTempProcess() {
        return loopBatch(DelSetaiyinShotokuJyohoTempProcess.class).define();
    }

    /**
     * 世帯員所得情報一時テーブルに登録です。
     *
     * @return InsTaishoSeitaiyinTempProcess
     */
    @Step(対象世帯員クラスに登録)
    protected IBatchFlowCommand callInsTaishoSeitaiyinTempProcess() {
        InsTaishoSeitaiyinTempProcessParameter parameter = new InsTaishoSeitaiyinTempProcessParameter();
        parameter.set処理区分(RSTRING_1);
        parameter.set処理年度(getParameter().get処理年度());
        parameter.set世帯員把握基準日(getParameter().get世帯員把握基準日());
        parameter.set世帯員把握基準日2(getParameter().get世帯員把握基準日2());
        return loopBatch(InsTaishoSeitaiyinTempProcess.class).arguments(parameter).define();
    }

    /**
     * 対象世帯員クラスTempに更新1です。
     *
     * @return UpdTaishoSeitaiyinTemp1Process
     */
    @Step(対象世帯員クラスに更新1)
    protected IBatchFlowCommand callUpdTaishoSeitaiyinTemp1Process() {
        InsTaishoSeitaiyinTempProcessParameter parameter = new InsTaishoSeitaiyinTempProcessParameter();
        parameter.set世帯員把握基準日(getParameter().get世帯員把握基準日());
        return loopBatch(UpdTaishoSeitaiyinTemp1Process.class).arguments(parameter).define();
    }

    /**
     * 対象世帯員クラスTempに更新2です。
     *
     * @return UpdTaishoSeitaiyinTemp2Process
     */
    @Step(対象世帯員クラスに更新2)
    protected IBatchFlowCommand callUpdTaishoSeitaiyinTemp2Process() {
        return loopBatch(UpdTaishoSeitaiyinTemp2Process.class).define();
    }

    /**
     * 対象世帯員クラスTempに更新3です。
     *
     * @return UpdTaishoSeitaiyinTemp3Process
     */
    @Step(対象世帯員クラスに更新3)
    protected IBatchFlowCommand callUpdTaishoSeitaiyinTemp3Process() {
        return loopBatch(UpdTaishoSeitaiyinTemp3Process.class).define();
    }

    /**
     * 対象世帯員クラスTempに削除です。
     *
     * @return DelTaishoSeitaiyinTempProcess
     */
    @Step(対象世帯員クラスに削除)
    protected IBatchFlowCommand callDelTaishoSeitaiyinTempProcess() {
        return simpleBatch(DelTaishoSeitaiyinTempProcess.class).define();
    }

    /**
     * 世帯員所得情報一時テーブルに登録です。
     *
     * @return InsSetaiyinShotokuJyohoTemp1Process
     */
    @Step(世帯員所得情報一時テーブルに登録2)
    protected IBatchFlowCommand callInsSetaiyinShotokuJyohoTemp2Process() {
        InsSetaiyinShotokuJyohoTemp1ProcessParameter parameter = new InsSetaiyinShotokuJyohoTemp1ProcessParameter();
        parameter.set帳票出力順ID(getParameter().get帳票出力順ID());
        parameter.set帳票ID(ReportIdDBC.DBC100075.getReportId());
        parameter.set抽出条件(getParameter().get抽出条件());
        parameter.set世帯員把握基準日2(getParameter().get世帯員把握基準日2());
        parameter.set被保険者番号(new HihokenshaNo(getParameter().get被保険者番号()));
        return loopBatch(InsSetaiyinShotokuJyohoTemp2Process.class).arguments(parameter).define();
    }

    /**
     * 世帯員所得情報一時テーブルに登録2です。
     *
     * @return InsTaishoSeitaiyinTempProcess
     */
    @Step(対象世帯員クラスに登録2)
    protected IBatchFlowCommand callInsTaishoSeitaiyinTemp2Process() {
        InsTaishoSeitaiyinTempProcessParameter parameter = new InsTaishoSeitaiyinTempProcessParameter();
        parameter.set処理区分(RSTRING_2);
        parameter.set処理年度(getParameter().get処理年度());
        parameter.set世帯員把握基準日(getParameter().get世帯員把握基準日());
        parameter.set世帯員把握基準日2(getParameter().get世帯員把握基準日2());
        return loopBatch(InsTaishoSeitaiyinTempProcess.class).arguments(parameter).define();
    }

    /**
     * 対象世帯員クラスTempに更新4です。
     *
     * @return UpdTaishoSeitaiyinTemp4Process
     */
    @Step(対象世帯員クラスに更新4)
    protected IBatchFlowCommand callUpdTaishoSeitaiyinTemp4Process() {
        return loopBatch(UpdTaishoSeitaiyinTemp4Process.class).define();
    }

    /**
     * 対象世帯員クラスTempに更新5です。
     *
     * @return UpdTaishoSeitaiyinTemp5Process
     */
    @Step(対象世帯員クラスに更新5)
    protected IBatchFlowCommand callUpdTaishoSeitaiyinTemp5Process() {
        InsTaishoSeitaiyinTempProcessParameter parameter = new InsTaishoSeitaiyinTempProcessParameter();
        parameter.set抽出条件(getParameter().get抽出条件());
        parameter.set処理年度(getParameter().get処理年度());
        return loopBatch(UpdTaishoSeitaiyinTemp5Process.class).arguments(parameter).define();
    }

    /**
     * 帳票出力_CSV作成です。
     *
     * @return CreateTaishoSetaiyinProcess
     */
    @Step(帳票出力_CSV作成)
    protected IBatchFlowCommand callCreateTaishoSetaiyinProcess() {
        InsTaishoSeitaiyinTempProcessParameter parameter = new InsTaishoSeitaiyinTempProcessParameter();
        parameter.set抽出条件(getParameter().get抽出条件());
        parameter.set処理年度(getParameter().get処理年度());
        parameter.setお知らせ通知書出力フラグ(getParameter().getお知らせ通知書出力フラグ());
        parameter.set一覧表CSV出力フラグ(getParameter().get一覧表CSV出力フラグ());
        parameter.set申請書出力フラグ(getParameter().get申請書出力フラグ());
        parameter.set作成日(getParameter().get作成日());
        parameter.set世帯員把握基準日(getParameter().get世帯員把握基準日());
        parameter.set世帯員把握基準日2(getParameter().get世帯員把握基準日2());
        parameter.set出力順ID(new RString(getParameter().get帳票出力順ID().toString()));
        parameter.set市町村コード(getParameter().get市町村コード());
        parameter.set市町村名(getParameter().get市町村名());
        parameter.set文書番号(getParameter().get文書番号());
        parameter.set処理年月日(FlexibleDate.getNowDate());
        return loopBatch(CreateTaishoSetaiyinProcess.class).arguments(parameter).define();
    }

    /**
     * 基準収入額管理マスタに登録作成です。
     *
     * @return InsDbT3116KijunShunyugakuTekiyoKanriProcess
     */
    @Step(基準収入額管理マスタに登録)
    protected IBatchFlowCommand callInsDbT3116KijunShunyugakuTekiyoKanriProcess() {
        InsTaishoSeitaiyinTempProcessParameter parameter = new InsTaishoSeitaiyinTempProcessParameter();
        parameter.set処理年度(getParameter().get処理年度());
        return loopBatch(InsDbT3116KijunShunyugakuTekiyoKanriProcess.class).arguments(parameter).define();
    }

    /**
     * 処理日付管理マスタに更新です。
     *
     * @return UpdShoriDateKanriProcess
     */
    @Step(処理日付管理マスタに更新)
    protected IBatchFlowCommand callUpdShoriDateKanriProcess() {
        InsTaishoSeitaiyinTempProcessParameter parameter = new InsTaishoSeitaiyinTempProcessParameter();
        parameter.set処理年度(getParameter().get処理年度());
        parameter.set市町村コード(getParameter().get市町村コード());
        return simpleBatch(UpdShoriDateKanriProcess.class).arguments(parameter).define();
    }

}
