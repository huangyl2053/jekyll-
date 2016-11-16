/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.DelSetaiyinShotokuJyohoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.DelTaishoSeitaiyinTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.InsTaishoSeitaiyinTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.UpdSetaiyinShotokuJyohoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.UpdTaishoSeitaiyinTemp1Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.UpdTaishoSeitaiyinTemp2Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.UpdTaishoSeitaiyinTemp3Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020.UpdTaishoSeitaiyinTemp4Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030.CreateShoriResultCsvFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030.CreateTaishoSetaiyinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030.InsSetaiyinShotokuJyohoTemp1Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030.InsSetaiyinShotokuJyohoTemp2Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030.InsSetaiyinShotokuJyohoTemp3Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030.UpdShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030.UpdTaishoSeitaiyinTemp5Process;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC190030.DBC190030_kijunsyunygetsujiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kijunshunyugaku.ShinseishoTorokuChushutsuJoken;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc190030.CreateShoriResultCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc190030.DBC190030ProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc190030.UpdTaishoSeitaiyinTemp5ProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kijunsyunyunenji.InsTaishoSeitaiyinTempProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.DBB002001.DBB002001_SetaiinHaakuParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBC110065_基準収入額適用申請書_異動分作成のフロークラスです。
 *
 * @reamsid_L DBC-4640-030 jianglaisheng
 */
public class DBC190030_kijunsyunygetsuji extends BatchFlowBase<DBC190030_kijunsyunygetsujiParameter> {

    private static final RString 世帯員把握BATCHID = new RString("DBB002001_SetaiinHaaku");
    private static final RString 管理識別区分 = SetaiinHaakuKanriShikibetsuKubun.高額介護.getコード();
    private static final String 世帯員把握バッチ = "setaiShotokuKazeiHanteiFlow";
    private static final String INS世帯員所得情報一時表1 = "insSetaiyinShotokuJyohoTemp1Process";
    private static final String INS世帯員所得情報一時表2 = "insSetaiyinShotokuJyohoTemp2Process";
    private static final String UPD世帯員所得情報一時表 = "updSetaiyinShotokuJyohoTempProcess";
    private static final String 世帯員所得情報一時テーブルに重複削除 = "delSetaiyinShotokuJyohoTemp";
    private static final String 対象世帯員クラスに登録 = "insTaishoSeitaiyinTemp";
    private static final String 対象世帯員クラスに更新1 = "updTaishoSeitaiyinTemp1";
    private static final String 対象世帯員クラスに更新2 = "updTaishoSeitaiyinTemp2";
    private static final String 対象世帯員クラスに更新3 = "updTaishoSeitaiyinTemp3";
    private static final String 対象世帯員クラスに削除 = "delTaishoSeitaiyinTemp";
    private static final String 対象世帯員クラスに登録2 = "insTaishoSeitaiyinTemp2";
    private static final String 対象世帯員クラスに更新4 = "updTaishoSeitaiyinTemp4";
    private static final String 対象世帯員クラスに更新5 = "updTaishoSeitaiyinTemp5";
    private static final String 帳票出力_CSV作成 = "createTaishoSetaiyin";
    private static final String 処理結果確認リストの発行 = "createShoriResultCsvFileProcess";
    private static final String 基準収入額管理マスタに登録 = "insDbT3116KijunShunyugakuTekiyoKanri";
    private static final String 処理日付管理マスタに更新 = "updShoriDateKanri";

    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");

    @Override
    protected void defineFlow() {
        executeStep(INS世帯員所得情報一時表1);
        executeStep(世帯員把握バッチ);
        executeStep(UPD世帯員所得情報一時表);
        executeStep(世帯員所得情報一時テーブルに重複削除);
        executeStep(対象世帯員クラスに登録);
        executeStep(対象世帯員クラスに更新1);
        executeStep(対象世帯員クラスに更新2);
        executeStep(対象世帯員クラスに更新3);
        executeStep(対象世帯員クラスに削除);

        executeStep(INS世帯員所得情報一時表2);
        executeStep(世帯員把握バッチ);
        executeStep(UPD世帯員所得情報一時表);
        executeStep(世帯員所得情報一時テーブルに重複削除);
        executeStep(対象世帯員クラスに登録2);
        if (!ShinseishoTorokuChushutsuJoken.白紙印刷.getコード().equals(getParameter().get抽出条件())) {
            executeStep(対象世帯員クラスに更新4);
            executeStep(対象世帯員クラスに更新5);
        }
        executeStep(帳票出力_CSV作成);
        if (ShinseishoTorokuChushutsuJoken.異動分.getコード().equals(getParameter().get抽出条件())) {
            executeStep(処理結果確認リストの発行);
        }
        executeStep(基準収入額管理マスタに登録);
        executeStep(処理日付管理マスタに更新);
    }

    @Step(INS世帯員所得情報一時表1)
    IBatchFlowCommand insSetaiyinShotokuJyohoTemp1Process() {
        RString 抽出条件 = getParameter().get抽出条件();
        RString 抽出対象 = getParameter().get抽出対象();
        FlexibleYear 処理年度 = getParameter().get処理年度();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(getParameter().get被保険者番号());
        FlexibleDate 世帯員把握基準日 = getParameter().get世帯員把握基準日();
        FlexibleDate 世帯員把握基準日2 = getParameter().get世帯員把握基準日2();
        RString 提出期限 = getParameter().get提出期限();
        FlexibleDate 作成日 = getParameter().get作成日();
        Boolean 申請書出力フラグ = getParameter().get申請書出力フラグ();
        Boolean お知らせ通知書出力フラグ = getParameter().getお知らせ通知書出力フラグ();
        Boolean 一覧表CSV出力フラグ = getParameter().get一覧表CSV出力フラグ();
        RString 文書番号 = getParameter().get文書番号();
        Long 帳票出力順ID = getParameter().get帳票出力順ID();
        LasdecCode 市町村コード = getParameter().get市町村コード();
        RString 市町村名 = getParameter().get市町村名();
        DBC190030ProcessParameter processParameter = new DBC190030ProcessParameter(抽出条件, 抽出対象,
                処理年度, 被保険者番号,
                世帯員把握基準日, 世帯員把握基準日2,
                提出期限, 作成日, 申請書出力フラグ,
                お知らせ通知書出力フラグ, 一覧表CSV出力フラグ,
                文書番号, 帳票出力順ID, 市町村コード, 市町村名);
        return loopBatch(InsSetaiyinShotokuJyohoTemp1Process.class).arguments(processParameter).define();
    }

    @Step(世帯員把握バッチ)
    IBatchFlowCommand setaiShotokuKazeiHanteiFlow() {
        return otherBatchFlow(世帯員把握BATCHID, SubGyomuCode.DBZ介護共通,
                new DBB002001_SetaiinHaakuParameter(管理識別区分)).define();
    }

    @Step(UPD世帯員所得情報一時表)
    IBatchFlowCommand updSetaiyinShotokuJyohoTempProcess() {
        return simpleBatch(UpdSetaiyinShotokuJyohoTempProcess.class).define();
    }

    @Step(INS世帯員所得情報一時表2)
    IBatchFlowCommand insSetaiyinShotokuJyohoTemp2Process() {
        RString 抽出条件 = getParameter().get抽出条件();
        RString 抽出対象 = getParameter().get抽出対象();
        FlexibleYear 処理年度 = getParameter().get処理年度();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(getParameter().get被保険者番号());
        FlexibleDate 世帯員把握基準日 = getParameter().get世帯員把握基準日();
        FlexibleDate 世帯員把握基準日2 = getParameter().get世帯員把握基準日2();
        RString 提出期限 = getParameter().get提出期限();
        FlexibleDate 作成日 = getParameter().get作成日();
        Boolean 申請書出力フラグ = getParameter().get申請書出力フラグ();
        Boolean お知らせ通知書出力フラグ = getParameter().getお知らせ通知書出力フラグ();
        Boolean 一覧表CSV出力フラグ = getParameter().get一覧表CSV出力フラグ();
        RString 文書番号 = getParameter().get文書番号();
        Long 帳票出力順ID = getParameter().get帳票出力順ID();
        LasdecCode 市町村コード = getParameter().get市町村コード();
        RString 市町村名 = getParameter().get市町村名();
        DBC190030ProcessParameter processParameter = new DBC190030ProcessParameter(抽出条件, 抽出対象,
                処理年度, 被保険者番号,
                世帯員把握基準日, 世帯員把握基準日2,
                提出期限, 作成日, 申請書出力フラグ,
                お知らせ通知書出力フラグ, 一覧表CSV出力フラグ,
                文書番号, 帳票出力順ID, 市町村コード, 市町村名);
        return loopBatch(InsSetaiyinShotokuJyohoTemp2Process.class).arguments(processParameter).define();
    }

    @Step(世帯員所得情報一時テーブルに重複削除)
    IBatchFlowCommand callDelSetaiyinShotokuJyohoTempProcess() {
        return loopBatch(DelSetaiyinShotokuJyohoTempProcess.class).define();
    }

    @Step(対象世帯員クラスに登録)
    IBatchFlowCommand callInsTaishoSeitaiyinTempProcess() {
        InsTaishoSeitaiyinTempProcessParameter parameter = new InsTaishoSeitaiyinTempProcessParameter();
        parameter.set処理区分(RSTRING_1);
        parameter.set処理年度(getParameter().get処理年度());
        parameter.set世帯員把握基準日(getParameter().get世帯員把握基準日());
        parameter.set世帯員把握基準日2(getParameter().get世帯員把握基準日2());
        return loopBatch(InsTaishoSeitaiyinTempProcess.class).arguments(parameter).define();
    }

    @Step(対象世帯員クラスに更新1)
    IBatchFlowCommand callUpdTaishoSeitaiyinTemp1Process() {
        InsTaishoSeitaiyinTempProcessParameter parameter = new InsTaishoSeitaiyinTempProcessParameter();
        parameter.set世帯員把握基準日(getParameter().get世帯員把握基準日());
        return loopBatch(UpdTaishoSeitaiyinTemp1Process.class).arguments(parameter).define();
    }

    @Step(対象世帯員クラスに更新2)
    IBatchFlowCommand callUpdTaishoSeitaiyinTemp2Process() {
        return loopBatch(UpdTaishoSeitaiyinTemp2Process.class).define();
    }

    @Step(対象世帯員クラスに更新3)
    IBatchFlowCommand callUpdTaishoSeitaiyinTemp3Process() {
        return loopBatch(UpdTaishoSeitaiyinTemp3Process.class).define();
    }

    @Step(対象世帯員クラスに削除)
    IBatchFlowCommand callDelTaishoSeitaiyinTempProcess() {
        return simpleBatch(DelTaishoSeitaiyinTempProcess.class).define();
    }

    @Step(対象世帯員クラスに登録2)
    IBatchFlowCommand callInsTaishoSeitaiyinTemp2Process() {
        InsTaishoSeitaiyinTempProcessParameter parameter = new InsTaishoSeitaiyinTempProcessParameter();
        parameter.set処理区分(RSTRING_2);
        parameter.set処理年度(getParameter().get処理年度());
        parameter.set世帯員把握基準日(getParameter().get世帯員把握基準日());
        parameter.set世帯員把握基準日2(getParameter().get世帯員把握基準日2());
        return loopBatch(InsTaishoSeitaiyinTempProcess.class).arguments(parameter).define();
    }

    @Step(対象世帯員クラスに更新4)
    IBatchFlowCommand callUpdTaishoSeitaiyinTemp4Process() {
        return loopBatch(UpdTaishoSeitaiyinTemp4Process.class).define();
    }

    @Step(対象世帯員クラスに更新5)
    IBatchFlowCommand callUpdTaishoSeitaiyinTemp5Process() {
        UpdTaishoSeitaiyinTemp5ProcessParameter parameter
                = new UpdTaishoSeitaiyinTemp5ProcessParameter(getParameter().get抽出条件(),
                        getParameter().get抽出対象(),
                        getParameter().get世帯員把握基準日());
        return loopBatch(UpdTaishoSeitaiyinTemp5Process.class).arguments(parameter).define();
    }

    @Step(帳票出力_CSV作成)
    IBatchFlowCommand callCreateTaishoSetaiyinProcess() {
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

    @Step(処理結果確認リストの発行)
    IBatchFlowCommand callCreateShoriResultCsvFileProcess() {
        CreateShoriResultCsvFileProcessParameter parameter
                = new CreateShoriResultCsvFileProcessParameter(getParameter().get処理年度());
        return loopBatch(CreateShoriResultCsvFileProcess.class).arguments(parameter).define();
    }

    @Step(基準収入額管理マスタに登録)
    IBatchFlowCommand callInsDbT3116KijunShunyugakuTekiyoKanriProcess() {
        InsTaishoSeitaiyinTempProcessParameter parameter = new InsTaishoSeitaiyinTempProcessParameter();
        parameter.set処理年度(getParameter().get処理年度());
        return loopBatch(InsSetaiyinShotokuJyohoTemp3Process.class).arguments(parameter).define();
    }

    @Step(処理日付管理マスタに更新)
    IBatchFlowCommand callUpdShoriDateKanriProcess() {
        InsTaishoSeitaiyinTempProcessParameter parameter = new InsTaishoSeitaiyinTempProcessParameter();
        parameter.set処理年度(getParameter().get処理年度());
        parameter.set市町村コード(getParameter().get市町村コード());
        return simpleBatch(UpdShoriDateKanriProcess.class).arguments(parameter).define();
    }
}
