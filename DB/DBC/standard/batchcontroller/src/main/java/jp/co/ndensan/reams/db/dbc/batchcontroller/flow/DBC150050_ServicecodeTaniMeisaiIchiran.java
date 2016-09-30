/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050.ChohyouShutsuryokuyouGetProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050.HihokenshaShikibetsuTaishoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050.IchiranServicecodeTaniMeisaiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050.JigyoshoNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050.KyotakuKaiNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050.KyufuJissekiMeisaiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050.KyufuJissekiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050.ServiceKomokuCodeGetNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050.ServiceShuruiCdNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050.ServiceShuruiCdTBLProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050.ShikibetsuTaishoInfoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050.ShoKisaiHokenshaNoNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050.ShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150050.DBC150050_ServicecodeTaniMeisaiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodetanimeisaiichiran.KyufuJissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodetanimeisaiichiran.ServiceShuruiCdNameProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービスコード単位明細リスト作成Flowクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
public class DBC150050_ServicecodeTaniMeisaiIchiran
        extends BatchFlowBase<DBC150050_ServicecodeTaniMeisaiIchiranParameter> {

    private static final String 給付実績情報の取得処理 = "給付実績情報の取得処理";
    private static final String 給付実績明細情報の取得処理 = "給付実績明細情報の取得処理";
    private static final String 被保険者_宛名情報取得 = "被保険者_宛名情報取得";
    private static final String 宛名情報抽出処理 = "宛名情報抽出処理";
    private static final String 事業所名称取得 = "事業所名称取得";
    private static final String 計画事業所名取得 = "計画事業所名取得";
    private static final String 証記載保険者名取得 = "証記載保険者名取得";
    private static final String サービス種類一時TBLの登録処理 = "サービス種類一時TBLの登録処理";
    private static final String サービス種類名称取得 = "サービス種類名称取得";
    private static final String サービス項目名称取得 = "サービス項目名称取得";
    private static final String 帳票出力用一時TBLの登録処理 = "帳票出力用一時TBLの登録処理";
    private static final String 処理結果リスト作成 = "処理結果リスト作成";
    private static final String 一覧表作成 = "一覧表作成";

    private FlowEntity flowEntity;
    private int 明細件数;
    private static final RString アンダーライン = new RString("_");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private RString 種別;

    @Override
    protected void defineFlow() {
        executeStep(給付実績情報の取得処理);
        flowEntity = getResult(FlowEntity.class, 給付実績情報の取得処理,
                KyufuJissekiProcess.PARAMETER_OUT_FLOWENTITY);
        明細件数 = flowEntity.get明細データ登録件数();
        executeStep(給付実績明細情報の取得処理);
        executeStep(被保険者_宛名情報取得);
        executeStep(宛名情報抽出処理);
        executeStep(事業所名称取得);
        executeStep(計画事業所名取得);
        executeStep(証記載保険者名取得);
        種別 = RSTRING_1;
        executeStep(サービス種類一時TBLの登録処理);
        executeStep(サービス種類名称取得);
        種別 = RSTRING_2;
        executeStep(サービス種類一時TBLの登録処理);
        executeStep(サービス項目名称取得);
        executeStep(帳票出力用一時TBLの登録処理);
        executeStep(一覧表作成);
        executeStep(処理結果リスト作成);

    }

    /**
     * 給付実績情報の取得処理。
     *
     * @return KyufuJissekiProcess
     */
    @Step(給付実績情報の取得処理)
    IBatchFlowCommand getKyufuJissekiProcess() {
        KyufuJissekiProcessParameter kyufuJissekiParameter = new KyufuJissekiProcessParameter();
        kyufuJissekiParameter.set対象年月(getParameter().get対象年月());
        kyufuJissekiParameter.set開始年月(getParameter().get開始年月());
        kyufuJissekiParameter.set終了年月(getParameter().get終了年月());
        return loopBatch(KyufuJissekiProcess.class).arguments(kyufuJissekiParameter).define();
    }

    /**
     * 給付実績明細情報の取得処理。
     *
     * @return KyufuJissekiMeisaiProcess
     */
    @Step(給付実績明細情報の取得処理)
    IBatchFlowCommand getKyufuJissekiMeisaiProcess() {
        KyufuJissekiProcessParameter kyufuJissekiParameter = new KyufuJissekiProcessParameter();
        kyufuJissekiParameter.set対象年月(getParameter().get対象年月());
        kyufuJissekiParameter.set開始年月(getParameter().get開始年月());
        kyufuJissekiParameter.set終了年月(getParameter().get終了年月());
        kyufuJissekiParameter.setサービス種類コードリスト(getParameter().getサービス種類コードリスト());
        kyufuJissekiParameter.set地区指定(getParameter().get地区指定());
        kyufuJissekiParameter.set市町村コード(getParameter().get市町村コード());
        kyufuJissekiParameter.set連番(明細件数);
        return loopBatch(KyufuJissekiMeisaiProcess.class).arguments(kyufuJissekiParameter).define();
    }

    /**
     * 被保険者_宛名情報取得。
     *
     * @return HihokenshaShikibetsuTaishoProcess
     */
    @Step(被保険者_宛名情報取得)
    IBatchFlowCommand getHihokenshaShikibetsuTaishoProcess() {
        return loopBatch(HihokenshaShikibetsuTaishoProcess.class).define();
    }

    /**
     * 宛名情報抽出処理
     *
     * @return ShikibetsuTaishoInfoProcess
     */
    @Step(宛名情報抽出処理)
    IBatchFlowCommand getShikibetsuTaishoProcess() {
        KyufuJissekiProcessParameter kyufuJissekiParameter = new KyufuJissekiProcessParameter();
        kyufuJissekiParameter.set対象年月(getParameter().get対象年月());
        kyufuJissekiParameter.set開始年月(getParameter().get開始年月());
        kyufuJissekiParameter.set終了年月(getParameter().get終了年月());
        kyufuJissekiParameter.setサービス種類コードリスト(getParameter().getサービス種類コードリスト());
        kyufuJissekiParameter.set市町村コード(getParameter().get市町村コード());
        kyufuJissekiParameter.set旧市町村コード(getParameter().get旧市町村コード());
        kyufuJissekiParameter.set地区指定(getParameter().get地区指定());
        kyufuJissekiParameter.set選択地区リスト(getParameter().get選択地区リスト());
        return loopBatch(ShikibetsuTaishoInfoProcess.class).arguments(kyufuJissekiParameter).define();
    }

    /**
     * 事業所名称取得を取得。
     *
     * @return JigyoshoNameProcess
     */
    @Step(事業所名称取得)
    IBatchFlowCommand getJigyoshoNameProcess() {
        return loopBatch(JigyoshoNameProcess.class).define();
    }

    /**
     * 計画事業所名取得。
     *
     * @return KyotakuKaiNameProcess
     */
    @Step(計画事業所名取得)
    IBatchFlowCommand getKyotakuKaiNameProcessProcess() {
        return loopBatch(KyotakuKaiNameProcess.class).define();
    }

    /**
     * 証記載保険者名取得。
     *
     * @return ShoKisaiHokenshaNoNameProcess
     */
    @Step(証記載保険者名取得)
    IBatchFlowCommand getShoKisaiHokenshaNoNameProcess() {
        return loopBatch(ShoKisaiHokenshaNoNameProcess.class).define();
    }

    /**
     * サービス種類一時TBLの登録処理
     *
     * @return ServiceShuruiCdTBLProcess
     */
    @Step(サービス種類一時TBLの登録処理)
    IBatchFlowCommand getServiceShuruiTBLProcess() {
        ServiceShuruiCdNameProcessParameter processParameter = new ServiceShuruiCdNameProcessParameter();
        processParameter.set種別(種別);
        return loopBatch(ServiceShuruiCdTBLProcess.class).arguments(processParameter).define();
    }

    /**
     * サービス種類名称取得
     *
     * @return ServiceShuruiCdNameProcess
     */
    @Step(サービス種類名称取得)
    IBatchFlowCommand getServiceShuruiNameProcess() {
        return loopBatch(ServiceShuruiCdNameProcess.class).define();
    }

    /**
     * サービス項目コード名称取得。
     *
     * @return ServiceKomokuCodeGetNameProcess
     */
    @Step(サービス項目名称取得)
    IBatchFlowCommand getServiceKomokuCodeGetNameProcess() {
        return loopBatch(ServiceKomokuCodeGetNameProcess.class).define();
    }

    /**
     * 帳票出力用一時TBLの登録処理。
     *
     * @return ChohyouShutsuryokuyouGetProcess
     */
    @Step(帳票出力用一時TBLの登録処理)
    IBatchFlowCommand getChohyouShutsuryokuyouGetProcess() {
        KyufuJissekiProcessParameter kyufuJissekiParameter = new KyufuJissekiProcessParameter();
        kyufuJissekiParameter.set被保険者番号(getParameter().get被保険者番号());
        kyufuJissekiParameter.set事業者番号(getParameter().get事業者番号());
        kyufuJissekiParameter.set認定結果リスト(getParameter().get認定結果リスト());
        kyufuJissekiParameter.setサービス種類コードリスト(getParameter().getサービス種類コードリスト());
        RString サービス項目コード指定 = getParameter().getサービス項目コード();
        kyufuJissekiParameter.setサービス項目コード(サービス項目コード指定);
        return loopBatch(ChohyouShutsuryokuyouGetProcess.class).arguments(kyufuJissekiParameter).define();
    }

    /**
     * 一覧表作成。
     *
     * @return IchiranServicecodeTaniMeisaiProcess
     */
    @Step(一覧表作成)
    IBatchFlowCommand doIchiranServicecodeTaniMeisaiProcess() {
        KyufuJissekiProcessParameter kyufuJissekiParameter = new KyufuJissekiProcessParameter();
        kyufuJissekiParameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        kyufuJissekiParameter.set帳票ID(new ReportId(ReportIdDBC.DBC200005.getReportId().getColumnValue()));
        kyufuJissekiParameter.set開始年月(getParameter().get開始年月());
        if (getParameter().get出力順ID() != null) {
            kyufuJissekiParameter.set出力順ID(getParameter().get出力順ID());
        }
        return loopBatch(IchiranServicecodeTaniMeisaiProcess.class).arguments(kyufuJissekiParameter).define();
    }

    /**
     * 処理結果リスト作成。
     *
     * @return ShoriKekkaListSakuseiProcess
     */
    @Step(処理結果リスト作成)
    IBatchFlowCommand doShoriKekkaListSakuseiProcess() {
        return loopBatch(ShoriKekkaListSakuseiProcess.class).define();
    }
}
