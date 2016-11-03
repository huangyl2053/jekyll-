/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050021.FurikomiDataErrorListProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050021.FurikomimeisaiDataEraTourokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050021.FurikomimeisaiDataHihokenshaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050021.FurikomimeisaiDataKozaJohoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050021.FurikomimeisaiDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050021.FurikomimeisaiDataSyoriResultProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050021.FurikomimeisaiDataUpdateToSakusProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050022.DelJigyoKogakuKekkaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050022.InsJigyoKogakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050022.JigyoKogakuJukyushaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050022.JigyoKogakuReportProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050022.JigyoKogakuSinseiDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050022.UpdJigyoKogakuKekkaProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC050022.DBC050022_FurikomimeisaiFurikomiDataJigyoKogakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiGyomunaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050021.FurikomimeisaiFurikomiDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ux.uxx.definition.batchprm.kozafurikomi.UXX000A10_KozaFurikomiRegisterParameter;
import jp.co.ndensan.reams.ux.uxx.service.core.kozafurikomi.kozafurikomi.KozaFurikomiManager;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 振込明細・振込みデータ作成（事業高額）のバッチフロークラスです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public class DBC050022_FurikomimeisaiFurikomiDataJigyoKogaku extends BatchFlowBase<DBC050022_FurikomimeisaiFurikomiDataJigyoKogakuParameter> {

    private static final String 事業高額データ取得 = "insJigyoKogakuProcess";
    private static final String 被保険者台帳_宛名情報 = "furikomimeisaiDataHihokenshaProcess";
    private static final String 被保険者台帳_宛名情報_エラー登録 = "furikomimeisaiDataEraTourokuProcess";
    private static final String 口座情報取得 = "furikomimeisaiDataKozaJohoProcess";
    private static final String 振込データ作成 = "furikomimeisaiDataSakuseiProcess";
    private static final String 口座振込データの登録処理 = "kouzaFurikomiDataInsert";
    private static final String 依頼済登録_事業高額 = "updJigyoKogakuKekkaProcess";
    private static final String 依頼済取消_事業高額 = "delJigyoKogakuKekkaProcess";
    private static final String 振込明細一覧表作成_受給取得状況 = "jigyoKogakuJukyushaProcess";
    private static final String 振込明細一覧表作成_申請データ有無確認 = "jigyoKogakuSinseiDataProcess";
    private static final String 振込明細一覧表作成 = "jigyoKogakuReportProcess";
    private static final String 振込エラーリスト作成 = "furikomiDataErrorListProcess";
    private static final String 処理結果確認リスト作成 = "furikomimeisaiDataSyoriResultProcess";
    private static final String 処理日付管理マスタの更新と出力条件表作成 = "furikomimeisaiDataUpdateToSakusProcess";

    private FurikomimeisaiFurikomiDataProcessParameter processParameter;

    private static final RString メッセージ引数 = new RString("帳票出力順の取得");
    private static final RString 事業高額KUNBUN = new RString("事業高額");
    private static final RString 口座振込データの登録処理BATCH_ID = new RString("UXX000A10_KozaFurikomiRegister");
    private static final RString 口座振込一時名称 = new RString("DbWT0511KozaFurikomi");
    private static final RString 登録区分_通常 = new RString("1");
    private static final RString 登録区分_差分 = new RString("2");
    private static final int INT_0 = 0;
    private int 出力ページ数;

    @Override
    protected void initialize() {
        出力ページ数 = INT_0;
        processParameter = getParameter().toProcessParameter();
        processParameter.setBatchKunbun(事業高額KUNBUN);
        processParameter.set振込業務内区分(FurikomiGyomunaiKubun.事業高額);
        processParameter.setシステム日時(YMDHMS.now());
        processParameter.set処理名(ShoriName.給付振込データ作成_事業高額);
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (!RString.isNullOrEmpty(getParameter().get出力順ID())) {
            IOutputOrder 出力順情報 = finder.get出力順(
                    SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200102.getReportId(), Long.parseLong(getParameter().get出力順ID().toString()));
            if (出力順情報 == null) {
                throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage().replace(メッセージ引数.toString()).evaluate());
            }
        }
    }

    @Override
    protected void defineFlow() {
        executeStep(事業高額データ取得);
        int 登録件数 = getResult(
                Integer.class, new RString(事業高額データ取得), InsJigyoKogakuProcess.PARAMETER_OUT_登録件数);
        if (登録件数 != INT_0) {
            executeStep(被保険者台帳_宛名情報);
            executeStep(被保険者台帳_宛名情報_エラー登録);
            executeStep(口座情報取得);
            if (!Furikomi_ShoriKubun.明細一覧表作成.getコード().equals(getParameter().get処理区分())) {
                executeStep(振込データ作成);
                splitBatch();
            }
        }
        executeStep(処理結果確認リスト作成);
        executeStep(処理日付管理マスタの更新と出力条件表作成);
    }

    private void splitBatch() {
        if (Furikomi_ShoriKubun.振込指定日修正.getコード().equals(getParameter().get処理区分())) {
            Decimal 委託者コード = getParameter().get委託者コード() == null || getParameter().get委託者コード().isEmpty()
                    ? null : new Decimal(getParameter().get委託者コード().toString());
            KozaFurikomiManager.createInstance().deleteBy委託者IDAnd振込年月日(委託者コード, getParameter().get誤振込指定年月日());
        }
        int 件数 = getResult(
                Integer.class, new RString(振込データ作成), FurikomimeisaiDataSakuseiProcess.PARAMETER_OUT_件数);
        if (件数 != INT_0) {
            executeStep(口座振込データの登録処理);
        }
        executeStep(依頼済登録_事業高額);
        executeStep(依頼済取消_事業高額);
        if (Furikomi_ShoriKubun.明細一覧表作成.getコード().equals(getParameter().get処理区分()) || 件数 != INT_0) {
            executeStep(振込明細一覧表作成_受給取得状況);
            executeStep(振込明細一覧表作成_申請データ有無確認);
            executeStep(振込明細一覧表作成);
            出力ページ数 = getResult(
                    Integer.class, new RString(振込明細一覧表作成), JigyoKogakuReportProcess.PAGECOUNT);
            processParameter.set出力ページ数(出力ページ数);
        }
        if (!(Furikomi_ShoriKubun.明細一覧表作成.getコード().equals(getParameter().get処理区分()))
                || !(Furikomi_ShihraiHohoShitei.窓口.getコード().equals(getParameter().get支払方法()))) {
            executeStep(振込エラーリスト作成);
        }
    }

    /**
     * 事業高額データ取得する。
     *
     * @return IBatchFlowCommand
     */
    @Step(事業高額データ取得)
    protected IBatchFlowCommand callInsJigyoKogakuProcess() {
        return loopBatch(InsJigyoKogakuProcess.class).arguments(processParameter).define();
    }

    /**
     * 被保険者台帳_宛名情報する。
     *
     * @return IBatchFlowCommand
     */
    @Step(被保険者台帳_宛名情報)
    protected IBatchFlowCommand callFurikomimeisaiDataHihokenshaProcess() {
        return loopBatch(FurikomimeisaiDataHihokenshaProcess.class).define();
    }

    /**
     * 被保険者台帳_宛名情報_エラー登録する。
     *
     * @return IBatchFlowCommand
     */
    @Step(被保険者台帳_宛名情報_エラー登録)
    protected IBatchFlowCommand callFurikomimeisaiDataEraTourokuProcess() {
        return loopBatch(FurikomimeisaiDataEraTourokuProcess.class).define();
    }

    /**
     * 口座情報取得する。
     *
     * @return IBatchFlowCommand
     */
    @Step(口座情報取得)
    protected IBatchFlowCommand callFurikomimeisaiDataKozaJohoProcess() {
        return loopBatch(FurikomimeisaiDataKozaJohoProcess.class).arguments(processParameter).define();
    }

    /**
     * 振込データ作成する。
     *
     * @return IBatchFlowCommand
     */
    @Step(振込データ作成)
    protected IBatchFlowCommand callFurikomimeisaiDataSakuseiProcess() {
        return loopBatch(FurikomimeisaiDataSakuseiProcess.class).arguments(processParameter).define();
    }

    /**
     * 口座振込データの登録処理
     *
     * @return IBatchFlowCommand
     */
    @Step(口座振込データの登録処理)
    protected IBatchFlowCommand callGetKouzaFurikomiProcess() {
        return otherBatchFlow(口座振込データの登録処理BATCH_ID, SubGyomuCode.UXX公開共通, createKozaFurikomiRegisterParameter()).define();
    }

    private UXX000A10_KozaFurikomiRegisterParameter createKozaFurikomiRegisterParameter() {
        UXX000A10_KozaFurikomiRegisterParameter parameter = new UXX000A10_KozaFurikomiRegisterParameter();
        parameter.setTempTableName(口座振込一時名称);
        parameter.setDaihyoKinyuKikanCode(getParameter().get代表金融機関コード());
        parameter.setFurikomiGroupCode(getParameter().get振込グループコード());
        parameter.setFurikomiYMD(getParameter().get振込指定年月日());
        if (getParameter().is再処理フラグ()) {
            parameter.setTourokuKubun(登録区分_通常);
        } else {
            parameter.setTourokuKubun(登録区分_差分);
        }
        return parameter;
    }

    /**
     * 依頼済登録_事業高額する。
     *
     * @return IBatchFlowCommand
     */
    @Step(依頼済登録_事業高額)
    protected IBatchFlowCommand callUpdJigyoKogakuKekkaProcess() {
        return loopBatch(UpdJigyoKogakuKekkaProcess.class).define();
    }

    /**
     * 依頼済取消_事業高額する。
     *
     * @return IBatchFlowCommand
     */
    @Step(依頼済取消_事業高額)
    protected IBatchFlowCommand callDelJigyoKogakuKekkaProcess() {
        return loopBatch(DelJigyoKogakuKekkaProcess.class).define();
    }

    /**
     * 振込明細一覧表作成_受給取得状況する。
     *
     * @return IBatchFlowCommand
     */
    @Step(振込明細一覧表作成_受給取得状況)
    protected IBatchFlowCommand callJigyoKogakuJukyushaProcess() {
        return loopBatch(JigyoKogakuJukyushaProcess.class).arguments(processParameter).define();
    }

    /**
     * 振込明細一覧表作成_申請データ有無確認する。
     *
     * @return IBatchFlowCommand
     */
    @Step(振込明細一覧表作成_申請データ有無確認)
    protected IBatchFlowCommand callJigyoKogakuSinseiDataProcess() {
        return loopBatch(JigyoKogakuSinseiDataProcess.class).define();
    }

    /**
     * 振込明細一覧表作成する。
     *
     * @return IBatchFlowCommand
     */
    @Step(振込明細一覧表作成)
    protected IBatchFlowCommand callJigyoKogakuReportProcess() {
        processParameter.set出力順ID(getParameter().get出力順ID());
        return loopBatch(JigyoKogakuReportProcess.class).arguments(processParameter).define();
    }

    /**
     * 振込エラーリスト作成する。
     *
     * @return IBatchFlowCommand
     */
    @Step(振込エラーリスト作成)
    protected IBatchFlowCommand callFurikomiDataErrorListProcess() {
        return loopBatch(FurikomiDataErrorListProcess.class).arguments(processParameter).define();
    }

    /**
     * 処理結果確認リスト作成
     *
     * @return IBatchFlowCommand
     */
    @Step(処理結果確認リスト作成)
    protected IBatchFlowCommand callFurikomimeisaiDataSyoriResultProcess() {
        return loopBatch(FurikomimeisaiDataSyoriResultProcess.class).arguments(processParameter).define();
    }

    /**
     * 処理日付管理マスタの更新と出力条件表作成
     *
     * @return IBatchFlowCommand
     */
    @Step(処理日付管理マスタの更新と出力条件表作成)
    protected IBatchFlowCommand callFurikomimeisaiDataUpdateToSakusProcess() {
        return loopBatch(FurikomimeisaiDataUpdateToSakusProcess.class).arguments(processParameter).define();
    }
}
