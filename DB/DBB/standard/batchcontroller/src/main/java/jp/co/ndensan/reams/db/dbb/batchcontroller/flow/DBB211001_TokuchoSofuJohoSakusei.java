/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsChoshuHoho2Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsChoshuHohoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsFukaTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsJushochiTokureiTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsJushochiTokureiTsuikaTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsKaigohokenNenkinTokuchoTaishosha1Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsKaigohokenNenkinTokuchoTaishosha2Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsKariHenkoTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsKariHenkoTsuikaTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsNenkinTokuchoKaifuJoho1Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsNenkinTokuchoKaifuJoho2Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsShikakuSoshitsuTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsTokuchoTeishiTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsTokuchoTsuikaIraiTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsTokuchoTsuikaIraiTsuikaTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.InsTorikomiRirekiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.PrtTokuchoIdojohoIchiranhyoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.PrtTokuchoIdojohoKensuhyoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.PrtTokuchoIraijohoIchiranhyoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.PrtTokuchoIraijohoKensuhyoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.SelShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001.UpdShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB211001.DBB211001_TokuchoSofuJohoSakuseiParameter;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Width;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成クラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class DBB211001_TokuchoSofuJohoSakusei extends BatchFlowBase<DBB211001_TokuchoSofuJohoSakuseiParameter> {

    private static final String 年金特徴回付情報追加用データ作成 = "insNenkinTokuchoKaifuJoho1Process";
    private static final String 介護徴収方法の追加 = "insChoshuHohoProcess";
    private static final String 介護特別徴収情報取込履歴の登録 = "insTorikomiRirekiProcess";
    private static final String 介護保険年金特徴対象者情報の登録 = "insKaigohokenNenkinTokuchoTaishosha1Process";
    private static final String 特別徴収依頼情報一覧表を帳票で作成 = "prtTokuchoIraijohoIchiranhyoProcess";
    private static final String 特別徴収依頼情報件数表を帳票で作成 = "prtTokuchoIraijohoKensuhyoProcess";
    private static final String 資格喪失等のデータ抽出 = "insTokuchoTeishiTempProcess";
    private static final String 資格喪失等_追加用データ作成 = "insShikakuSoshitsuTempProcess";
    private static final String 住所地特例該当のデータ抽出 = "insJushochiTokureiTempProcess";
    private static final String 住所地特例該当_追加用データ作成 = "insJushochiTokureiTsuikaTempProcess";
    private static final String 最新の賦課の情報を取得 = "insFukaTempProcess";
    private static final String 仮徴収額変更データ抽出 = "insKariHenkoTempProcess";
    private static final String 仮徴収額変更_追加用データ作成 = "insKariHenkoTsuikaTempProcess";
    private static final String 特徴追加依頼のデータ抽出 = "insTokuchoTsuikaIraiTempProcess";
    private static final String 特徴追加依頼_追加用データ作成 = "insTokuchoTsuikaIraiTsuikaTempProcess";
    private static final String 特徴異動情報_追加用データの取得 = "insNenkinTokuchoKaifuJoho2Process";
    private static final String 特徴異動_徴収方法の追加 = "insChoshuHoho2Process";
    private static final String 特徴異動_年金特徴対象者情報の登録 = "insKaigohokenNenkinTokuchoTaishosha2Process";
    private static final String 特別徴収異動情報一覧表の発行 = "prtTokuchoIdojohoIchiranhyoProcess";
    private static final String 特徴異動情報件数表の発行 = "prtTokuchoIdojohoKensuhyoProcess";
    private static final String 処理日付管理テーブル更新 = "updShoriDateKanriProcess";
    private static final String 基準日時の取得 = "getShoriDateKanriProcess";

    private static final RString 処理対象月_01月 = new RString("01");
    private static final RString 処理対象月_1月 = new RString("1");
    private static final RString 処理対象月_02月 = new RString("02");
    private static final RString 処理対象月_2月 = new RString("2");
    private static final RString 処理対象月_03月 = new RString("03");
    private static final RString 処理対象月_3月 = new RString("3");
    private static final RString 処理対象月_04月 = new RString("04");
    private static final RString 処理対象月_4月 = new RString("4");
    private static final RString 処理対象月_05月 = new RString("05");
    private static final RString 処理対象月_5月 = new RString("5");
    private static final RString 処理対象月_06月 = new RString("06");
    private static final RString 処理対象月_6月 = new RString("6");
    private static final RString 処理対象月_07月 = new RString("07");
    private static final RString 処理対象月_7月 = new RString("7");
    private static final RString 処理対象月_08月 = new RString("08");
    private static final RString 処理対象月_8月 = new RString("8");
    private static final RString 処理対象月_09月 = new RString("09");
    private static final RString 処理対象月_9月 = new RString("9");
    private static final RString 処理対象月_10月 = new RString("10");
    private static final RString 処理対象月_11月 = new RString("11");
    private static final RString 処理対象月_12月 = new RString("12");

    private static final RString 出力条件_賦課年度 = new RString("【賦課年度】");
    private static final RString 出力条件_出力順 = new RString("【出力順】");
    private YMDHMS システム日時;

    @Override
    protected void initialize() {
        システム日時 = new YMDHMS(RDate.getNowDateTime());
    }

    @Override
    protected void defineFlow() {

        executeStep(基準日時の取得);

        if (is処理対象月が7月()) {
            executeStep(年金特徴回付情報追加用データ作成);
            executeStep(介護徴収方法の追加);
            executeStep(介護特別徴収情報取込履歴の登録);
            executeStep(介護保険年金特徴対象者情報の登録);
            executeStep(特別徴収依頼情報一覧表を帳票で作成);
            executeStep(特別徴収依頼情報件数表を帳票で作成);
        } else {
            executeStep(資格喪失等のデータ抽出);
            executeStep(資格喪失等_追加用データ作成);
            executeStep(住所地特例該当のデータ抽出);
            executeStep(住所地特例該当_追加用データ作成);
            if (is処理対象月が４月から６月まで()) {
                executeStep(最新の賦課の情報を取得);
                executeStep(仮徴収額変更データ抽出);
                executeStep(仮徴収額変更_追加用データ作成);
            }

            if (is処理対象月は８月を除く偶数月の場合()) {
                executeStep(特徴追加依頼のデータ抽出);
                executeStep(特徴追加依頼_追加用データ作成);
            }
            executeStep(特徴異動情報_追加用データの取得);

            if (is処理対象月は８月を除く偶数月の場合()) {
                executeStep(特徴異動_徴収方法の追加);
            }
            executeStep(介護特別徴収情報取込履歴の登録);
            executeStep(特徴異動_年金特徴対象者情報の登録);
            executeStep(特別徴収異動情報一覧表の発行);
            executeStep(特徴異動情報件数表の発行);
        }

        executeStep(処理日付管理テーブル更新);
    }

    /**
     * 基準日時の取得の取得を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(基準日時の取得)
    protected IBatchFlowCommand getShoriDateKanriProcess() {
        return simpleBatch(SelShoriDateKanriProcess.class)
                .arguments(getParameter().toUpdShoriDateKanriProcessParameter(
                                システム日時, is処理対象月が1月(), is処理対象月が2月(),
                                is処理対象月が3月(), is処理対象月が4月(), is処理対象月が5月(),
                                is処理対象月が6月(), is処理対象月が7月(), is処理対象月が8月(),
                                is処理対象月が9月(), is処理対象月が10月(), is処理対象月が11月(),
                                is処理対象月が12月()))
                .define();
    }

    /**
     * 年金特徴回付情報追加用データ作成する。
     *
     * @return IBatchFlowCommand
     */
    @Step(年金特徴回付情報追加用データ作成)
    protected IBatchFlowCommand insNenkinTokuchoKaifuJoho1Process() {
        return loopBatch(InsNenkinTokuchoKaifuJoho1Process.class)
                .arguments(getParameter().toInsNenkinTokuchoKaifuJoho1ProcessParameter(システム日時)).define();
    }

    /**
     * 介護徴収方法の追加する。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護徴収方法の追加)
    protected IBatchFlowCommand insChoshuHohoProcess() {
        return loopBatch(InsChoshuHohoProcess.class).define();
    }

    /**
     * 介護特別徴収情報取込履歴の登録する。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護特別徴収情報取込履歴の登録)
    protected IBatchFlowCommand insTorikomiRirekiProcess() {
        return simpleBatch(InsTorikomiRirekiProcess.class)
                .arguments(getParameter().toInsTorikomiRirekiProcessParameter(システム日時)).define();
    }

    /**
     * 介護保険年金特徴対象者情報の登録する。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護保険年金特徴対象者情報の登録)
    protected IBatchFlowCommand insKaigohokenNenkinTokuchoTaishosha1Process() {
        return loopBatch(InsKaigohokenNenkinTokuchoTaishosha1Process.class)
                .arguments(getParameter().toInsKaigohokenNenkinTaishosha1ProcessParameter(システム日時)).define();
    }

    /**
     * 特別徴収依頼情報一覧表を帳票で作成する。
     *
     * @return IBatchFlowCommand
     */
    @Step(特別徴収依頼情報一覧表を帳票で作成)
    protected IBatchFlowCommand prtTokuchoIraijohoIchiranhyoProcess() {
        return loopBatch(PrtTokuchoIraijohoIchiranhyoProcess.class)
                .arguments(getParameter().toPrtTokuchoIraijohoIchiranhyoProcessParameter(システム日時, 出力条件の編集(true)))
                .define();
    }

    /**
     * 特別徴収依頼情報件数表を帳票で作成する。
     *
     * @return IBatchFlowCommand
     */
    @Step(特別徴収依頼情報件数表を帳票で作成)
    protected IBatchFlowCommand prtTokuchoIraijohoKensuhyoProcess() {
        return loopBatch(PrtTokuchoIraijohoKensuhyoProcess.class)
                .arguments(getParameter().toPrtTokuchoIraijohoKensuhyoProcessParameter(システム日時, 出力条件の編集(false)))
                .define();
    }

    /**
     * 資格喪失等のデータ抽出する。
     *
     * @return IBatchFlowCommand
     */
    @Step(資格喪失等のデータ抽出)
    protected IBatchFlowCommand insTokuchoTeishiTempProcess() {
        return loopBatch(InsTokuchoTeishiTempProcess.class)
                .arguments(getParameter().toInsTokuchoTeishiTempProcessParameter(システム日時))
                .define();
    }

    /**
     * 資格喪失等_追加用データ作成する。
     *
     * @return IBatchFlowCommand
     */
    @Step(資格喪失等_追加用データ作成)
    protected IBatchFlowCommand insShikakuSoshitsuTempProcess() {
        return loopBatch(InsShikakuSoshitsuTempProcess.class)
                .arguments(getParameter().toInsShikakuSoshitsuTempProcessParameter(システム日時))
                .define();
    }

    /**
     * 住所地特例該当のデータ抽出する。
     *
     * @return IBatchFlowCommand
     */
    @Step(住所地特例該当のデータ抽出)
    protected IBatchFlowCommand insJushochiTokureiTempProcess() {
        return loopBatch(InsJushochiTokureiTempProcess.class)
                .arguments(getParameter().toInsJushochiTokureiTempProcessParameter(システム日時))
                .define();
    }

    /**
     * 住所地特例該当_追加用データ作成する。
     *
     * @return IBatchFlowCommand
     */
    @Step(住所地特例該当_追加用データ作成)
    protected IBatchFlowCommand insJushochiTokureiTsuikaTempProcess() {
        return loopBatch(InsJushochiTokureiTsuikaTempProcess.class)
                .arguments(getParameter().toInsJushochiTokureiTsuikaTempProcessParameter(システム日時))
                .define();
    }

    /**
     * 最新の賦課の情報を取得する。
     *
     * @return IBatchFlowCommand
     */
    @Step(最新の賦課の情報を取得)
    protected IBatchFlowCommand insFukaTempProcess() {
        return loopBatch(InsFukaTempProcess.class)
                .arguments(getParameter().toInsFukaTempProcessParameter())
                .define();
    }

    /**
     * 仮徴収額変更データ抽出する。
     *
     * @return IBatchFlowCommand
     */
    @Step(仮徴収額変更データ抽出)
    protected IBatchFlowCommand insKariHenkoTempProcess() {
        return loopBatch(InsKariHenkoTempProcess.class)
                .arguments(getParameter().toInsKariHenkoTempProcessParameter())
                .define();
    }

    /**
     * 仮徴収額変更_追加用データ作成する。
     *
     * @return IBatchFlowCommand
     */
    @Step(仮徴収額変更_追加用データ作成)
    protected IBatchFlowCommand insKariHenkoTsuikaTempProcess() {
        return loopBatch(InsKariHenkoTsuikaTempProcess.class)
                .arguments(getParameter().toInsKariHenkoTsuikaTempProcessParameter(システム日時))
                .define();
    }

    /**
     * 特徴追加依頼のデータ抽出する。
     *
     * @return IBatchFlowCommand
     */
    @Step(特徴追加依頼のデータ抽出)
    protected IBatchFlowCommand insTokuchoTsuikaIraiTempProcess() {
        return loopBatch(InsTokuchoTsuikaIraiTempProcess.class)
                .arguments(getParameter().toInsTokuchoTsuikaIraiTempProcessParameter())
                .define();
    }

    /**
     * 特徴追加依頼_追加用データ作成する。
     *
     * @return IBatchFlowCommand
     */
    @Step(特徴追加依頼_追加用データ作成)
    protected IBatchFlowCommand insTokuchoTsuikaIraiTsuikaTempProcess() {
        return loopBatch(InsTokuchoTsuikaIraiTsuikaTempProcess.class)
                .arguments(getParameter().toInsTokuchoTsuikaIraiTsuikaTempProcessParameter(システム日時))
                .define();
    }

    /**
     * 特徴異動情報_追加用データの取得する。
     *
     * @return IBatchFlowCommand
     */
    @Step(特徴異動情報_追加用データの取得)
    protected IBatchFlowCommand insNenkinTokuchoKaifuJoho2Process() {
        return loopBatch(InsNenkinTokuchoKaifuJoho2Process.class)
                .arguments(getParameter().toInsNenkinTokuchoKaifuJoho2ProcessParameter(
                                is処理対象月が４月_６月(), is処理対象月が5月(), is処理対象月が10月_12月_2月()))
                .define();
    }

    /**
     * 特徴異動_徴収方法の追加する。
     *
     * @return IBatchFlowCommand
     */
    @Step(特徴異動_徴収方法の追加)
    protected IBatchFlowCommand insChoshuHoho2Process() {
        return loopBatch(InsChoshuHoho2Process.class)
                .arguments(getParameter().toInsChoshuHoho2ProcessParameter(
                                is処理対象月が４月_６月(), is処理対象月が2月()))
                .define();
    }

    /**
     * 特徴異動_年金特徴対象者情報の登録する。
     *
     * @return IBatchFlowCommand
     */
    @Step(特徴異動_年金特徴対象者情報の登録)
    protected IBatchFlowCommand insKaigohokenNenkinTokuchoTaishosha2Process() {
        return loopBatch(InsKaigohokenNenkinTokuchoTaishosha2Process.class)
                .arguments(getParameter().toInsKaigohokenNenkinTokuchoTaishosha2ProcessParameter(
                                システム日時))
                .define();
    }

    /**
     * 特別徴収異動情報一覧表の発行する。
     *
     * @return IBatchFlowCommand
     */
    @Step(特別徴収異動情報一覧表の発行)
    protected IBatchFlowCommand prtTokuchoIdojohoIchiranhyoProcess() {
        return loopBatch(PrtTokuchoIdojohoIchiranhyoProcess.class)
                .arguments(getParameter().toPrtTokuchoIdojohoIchiranhyoProcessParameter(
                                システム日時, 出力条件の編集(true)))
                .define();
    }

    /**
     * 特徴異動情報件数表の発行する。
     *
     * @return IBatchFlowCommand
     */
    @Step(特徴異動情報件数表の発行)
    protected IBatchFlowCommand prtTokuchoIdojohoKensuhyoProcess() {
        return loopBatch(PrtTokuchoIdojohoKensuhyoProcess.class)
                .arguments(getParameter().toPrtTokuchoIdojohoKensuhyoProcessParameter(
                                システム日時, 出力条件の編集(false)))
                .define();
    }

    /**
     * 処理日付管理テーブル更新する。
     *
     * @return IBatchFlowCommand
     */
    @Step(処理日付管理テーブル更新)
    protected IBatchFlowCommand updShoriDateKanriProcess() {
        return simpleBatch(UpdShoriDateKanriProcess.class)
                .arguments(getParameter().toUpdShoriDateKanriProcessParameter(
                                システム日時, is処理対象月が1月(), is処理対象月が2月(),
                                is処理対象月が3月(), is処理対象月が4月(), is処理対象月が5月(),
                                is処理対象月が6月(), is処理対象月が7月(), is処理対象月が8月(),
                                is処理対象月が9月(), is処理対象月が10月(), is処理対象月が11月(),
                                is処理対象月が12月()))
                .define();
    }

    private boolean is処理対象月が1月() {
        return 処理対象月_1月.equals(getParameter().get処理対象月())
                || 処理対象月_01月.equals(getParameter().get処理対象月());
    }

    private boolean is処理対象月が2月() {
        return 処理対象月_2月.equals(getParameter().get処理対象月())
                || 処理対象月_02月.equals(getParameter().get処理対象月());
    }

    private boolean is処理対象月が3月() {
        return 処理対象月_3月.equals(getParameter().get処理対象月())
                || 処理対象月_03月.equals(getParameter().get処理対象月());
    }

    private boolean is処理対象月が4月() {
        return 処理対象月_4月.equals(getParameter().get処理対象月())
                || 処理対象月_04月.equals(getParameter().get処理対象月());
    }

    private boolean is処理対象月が5月() {
        return 処理対象月_5月.equals(getParameter().get処理対象月())
                || 処理対象月_05月.equals(getParameter().get処理対象月());
    }

    private boolean is処理対象月が6月() {
        return 処理対象月_6月.equals(getParameter().get処理対象月())
                || 処理対象月_06月.equals(getParameter().get処理対象月());
    }

    private boolean is処理対象月が7月() {
        return 処理対象月_7月.equals(getParameter().get処理対象月())
                || 処理対象月_07月.equals(getParameter().get処理対象月());
    }

    private boolean is処理対象月が8月() {
        return 処理対象月_8月.equals(getParameter().get処理対象月())
                || 処理対象月_08月.equals(getParameter().get処理対象月());
    }

    private boolean is処理対象月が9月() {
        return 処理対象月_9月.equals(getParameter().get処理対象月())
                || 処理対象月_09月.equals(getParameter().get処理対象月());
    }

    private boolean is処理対象月が10月() {
        return 処理対象月_10月.equals(getParameter().get処理対象月());
    }

    private boolean is処理対象月が11月() {
        return 処理対象月_11月.equals(getParameter().get処理対象月());
    }

    private boolean is処理対象月が12月() {
        return 処理対象月_12月.equals(getParameter().get処理対象月());
    }

    private boolean is処理対象月が10月_12月_2月() {
        return 処理対象月_10月.equals(getParameter().get処理対象月())
                || 処理対象月_12月.equals(getParameter().get処理対象月())
                || 処理対象月_2月.equals(getParameter().get処理対象月())
                || 処理対象月_02月.equals(getParameter().get処理対象月());
    }

    private boolean is処理対象月が４月から６月まで() {
        return is処理対象月が４月_６月()
                || is処理対象月が5月();
    }

    private boolean is処理対象月が４月_６月() {
        return 処理対象月_4月.equals(getParameter().get処理対象月())
                || 処理対象月_04月.equals(getParameter().get処理対象月())
                || 処理対象月_6月.equals(getParameter().get処理対象月())
                || 処理対象月_06月.equals(getParameter().get処理対象月());
    }

    private boolean is処理対象月は８月を除く偶数月の場合() {
        return 処理対象月_2月.equals(getParameter().get処理対象月())
                || 処理対象月_02月.equals(getParameter().get処理対象月())
                || 処理対象月_4月.equals(getParameter().get処理対象月())
                || 処理対象月_04月.equals(getParameter().get処理対象月())
                || 処理対象月_6月.equals(getParameter().get処理対象月())
                || 処理対象月_06月.equals(getParameter().get処理対象月())
                || 処理対象月_10月.equals(getParameter().get処理対象月())
                || 処理対象月_12月.equals(getParameter().get処理対象月());
    }

    private List<RString> 出力条件の編集(boolean isHas出力順) {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(賦課年度の編集());
        if (isHas出力順) {
            出力条件.add(出力順の編集(getParameter().get出力順ID(), getParameter().get帳票ID()));
        }
        return 出力条件;
    }

    private RString 賦課年度の編集() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(出力条件_賦課年度);
        builder.append(getParameter().get賦課年度().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.ICHI_NEN).fillType(FillType.ZERO).width(Width.HALF).toDateString());
        return builder.toRString();
    }

    private RString 出力順の編集(RString 出力順, RString reportId) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(出力条件_出力順);
        RString 出力順名称 = get出力順名称(出力順, reportId);
        builder.append(出力順名称);
        return builder.toRString();
    }

    private RString get出力順名称(RString 出力順, RString reportId) {
        RStringBuilder builder = new RStringBuilder();
        if (!RString.isNullOrEmpty(出力順)) {
            IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            IOutputOrder suturyokujun = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBB介護賦課,
                    new ReportId(reportId), Long.valueOf(出力順.toString()));
            if (suturyokujun != null) {
                builder.append(suturyokujun.get出力順名());
            }
        }
        return builder.toRString();
    }
}
