package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbbbt36001;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.CaluculateFukaKozaIdoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.CaluculateFukaShikakuShutokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.CaluculateFukaShikakuSoshitsuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.CaluculateFukaTokuchoTeishiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.CaluculateIraiKinTokuchoHatiKaishiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.HatiGatuTokuchoKaishiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.IdoFukaKeisanProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.IraikinKeisanShoriKubunProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.KozaIdoshaChushutsuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.SetaiinHakuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.ShikakuIdoshaChushutsuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.SpoolKariSanteiIdoKekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.SystemTimeShutokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.TokuchoKaishishaChushutsuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.TokuchoTeishishaChushutsuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001.TsuchishoBangoHatubanProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.fuka.SetaiShotokuKazeiHanteiBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.fukajohotoroku.FukaJohoTorokuBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.KarisanteiIdoFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.TyouhyouEntity;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.karisanteiidokekka.KarisanteiIdoKekkaProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.karisanteiidofuka.IKariSanteiIdoFukaBatchMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 仮算定異動賦課のバッチフロークラスです。
 *
 * @reamsid_L DBB-0850-010 zhaowei
 */
public class KarisanteiIdoKekkaFlow extends BatchFlowBase<KarisanteiIdoFukaParameter> {

    private static final RString RSTZERO = new RString("0");
    private static final RString RSTONE = new RString("1");
    private static final RString RSTELEVEN = new RString("11");
    private static final int INT_EIGHT = 8;
    private static final int INT_NINE = 9;
    private static final int INT_TEN = 10;
    private static final RString BATCH_ID = new RString("KeisangoJohoSakuseiFlow");
    private static final RString 世帯員把握BATCHID = new RString("SetaiShotokuKazeiHanteiFlow");
    private static final RString 仮算定異動通知書一括発行BATCHID = new RString("DBB015003_KarisanteiIdoTsuchishoHakko");
    private static final RString 賦課の情報登録フローBATCHID = new RString("FukaJohoTorokuFlow");

    private static final String システム日時の取得 = "getSystemDate";
    private static final String 資格異動者抽出 = "getShikakuIdosha";
    private static final String 特別徴収開始者抽出 = "getTokuchoKaishishaChushutsu";
    private static final String 特別徴収停止者抽出 = "getTokuchoTeishishaChushutsu";
    private static final String 口座異動者抽出 = "getKozaIdoshaChushutsu";
    private static final String 通知書番号発番 = "getTsuchishoBangoHatuban";
    private static final String 世帯員把握 = "getSetaiinHaku";
    private static final String 世帯員把握バッチ = "callSetaiShotokuKazeiHanteiFlow";
    private static final String 賦課計算_資格喪失 = "caluculateFukaShikakuSoshitsu";
    private static final String 賦課計算_特別徴収停止 = "caluculateFukaTokuchoTeishi";
    private static final String 賦課計算_資格取得 = "caluculateFukaShikakuShutoku";
    private static final String 賦課計算_口座異動のみ反映 = "caluculateFukaKozaIdo";
    private static final String 賦課の情報登録フロー = "callChoteiToroku";
    private static final String 依頼金額計算区分 = "getIraikinKeisanShoriKubun";
    private static final String 依頼金額計算_8月特徴開始 = "caluculateIraiKinTokucho8gatuKaishi";
    private static final String 計算後情報作成 = "keisangoJohoSakusei";
    private static final String 仮算定異動一括結果一覧表出力 = "spoolKariSanteiIdoKekkaIchiran";
    private static final String 異動賦課計算 = "idoFukaKeisan";
    private static final String 八月特徴開始 = "hatiGatuTokuchoKaishi";
    private static final String 仮算定異動通知書一括発行 = "karisanteiIdoTsuchishoIkkatsuHakko";

    private static final ReportId ID = new ReportId("DBB200013_KarisanteiIdoKekkaIchiran");

    private KarisanteiIdoKekkaProcessParameter parameter;
    private IKariSanteiIdoFukaBatchMapper mapper;

    @Override
    protected void initialize() {
        mapper = getMapper(IKariSanteiIdoFukaBatchMapper.class);
    }

    @Override
    protected void defineFlow() {
        executeStep(システム日時の取得);
        createKarisanteiIdoKekkaProcessParameter();
        parameter.set調定日時(getResult(YMDHMS.class,
                new RString(システム日時の取得), SystemTimeShutokuProcess.SYSTEM_TIME).getRDateTime());
        executeStep(資格異動者抽出);
        executeStep(特別徴収開始者抽出);
        executeStep(特別徴収停止者抽出);
        executeStep(口座異動者抽出);
        if (RSTONE.equals(DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定異動新規資格賦課,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課))) {
            executeStep(通知書番号発番);
            if (RSTELEVEN.equals(DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定異動新規賦課方法,
                    RDate.getNowDate(), SubGyomuCode.DBB介護賦課))) {
                executeStep(世帯員把握);
                executeStep(世帯員把握バッチ);
            }
        }
        if (RSTZERO.equals(getParameter().get特徴捕捉対象者の依頼金額計算区分())) {
            executeStep(賦課計算_資格喪失);
            executeStep(賦課の情報登録フロー);
            mapper.delete賦課の情報一時テーブル();

            executeStep(賦課計算_特別徴収停止);
            executeStep(賦課の情報登録フロー);
            mapper.delete賦課の情報一時テーブル();

            executeStep(賦課計算_資格取得);
            executeStep(賦課の情報登録フロー);
            mapper.delete賦課の情報一時テーブル();

            executeStep(賦課計算_口座異動のみ反映);
            executeStep(賦課の情報登録フロー);
            mapper.delete賦課の情報一時テーブル();
        }

        executeStep(依頼金額計算区分);
        RString 依頼金計算処理区分 = getResult(RString.class,
                new RString(依頼金額計算区分), IraikinKeisanShoriKubunProcess.依頼金計算処理区分);
        if (RSTONE.equals(依頼金計算処理区分)) {
            executeStep(依頼金額計算_8月特徴開始);
        }
        executeStep(計算後情報作成);
        for (TyouhyouEntity result : getParameter().get出力帳票一覧List()) {
            if (result.get帳票分類ID().value().equals(ID.value())) {
                executeStep(仮算定異動一括結果一覧表出力);
            }
        }
        executeStep(異動賦課計算);
        if (RSTONE.equals(依頼金計算処理区分)) {
            executeStep(八月特徴開始);
        }

        if (getParameter().isバッチ起動フラグ()) {
            executeStep(仮算定異動通知書一括発行);
        }
    }

    /**
     * システム日時の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(システム日時の取得)
    protected IBatchFlowCommand getSystemDate() {
        return simpleBatch(SystemTimeShutokuProcess.class).define();
    }

    /**
     * 資格異動者抽出を行います。
     *
     * @return バッチコマンド
     */
    @Step(資格異動者抽出)
    protected IBatchFlowCommand getShikakuIdosha() {
        return simpleBatch(ShikakuIdoshaChushutsuProcess.class).arguments(parameter).define();
    }

    /**
     * 特別徴収開始者抽出を行います。
     *
     * @return バッチコマンド
     */
    @Step(特別徴収開始者抽出)
    protected IBatchFlowCommand getTokuchoKaishishaChushutsu() {
        return simpleBatch(TokuchoKaishishaChushutsuProcess.class).arguments(parameter).define();
    }

    /**
     * 特別徴収停止者抽出を行います。
     *
     * @return バッチコマンド
     */
    @Step(特別徴収停止者抽出)
    protected IBatchFlowCommand getTokuchoTeishishaChushutsu() {
        return simpleBatch(TokuchoTeishishaChushutsuProcess.class).arguments(parameter).define();
    }

    /**
     * 口座異動者抽出を行います。
     *
     * @return バッチコマンド
     */
    @Step(口座異動者抽出)
    protected IBatchFlowCommand getKozaIdoshaChushutsu() {
        return simpleBatch(KozaIdoshaChushutsuProcess.class).arguments(parameter).define();
    }

    /**
     * 通知書番号発番を行います。
     *
     * @return バッチコマンド
     */
    @Step(通知書番号発番)
    protected IBatchFlowCommand getTsuchishoBangoHatuban() {
        return simpleBatch(TsuchishoBangoHatubanProcess.class).arguments(parameter).define();
    }

    /**
     * 世帯員把握を行います。
     *
     * @return バッチコマンド
     */
    @Step(世帯員把握)
    protected IBatchFlowCommand getSetaiinHaku() {
        return simpleBatch(SetaiinHakuProcess.class).define();
    }

    /**
     * 世帯員把握バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(世帯員把握バッチ)
    protected IBatchFlowCommand callSetaiShotokuKazeiHanteiFlow() {
        return otherBatchFlow(世帯員把握BATCHID, SubGyomuCode.DBB介護賦課,
                getSetaiShotokuKazeiHanteiBatchParameter()).define();
    }

    /**
     * 賦課計算(資格喪失)を行います。
     *
     * @return バッチコマンド
     */
    @Step(賦課計算_資格喪失)
    protected IBatchFlowCommand caluculateFukaShikakuSoshitsu() {
        return simpleBatch(CaluculateFukaShikakuSoshitsuProcess.class).arguments(parameter).define();
    }

    /**
     * 賦課計算(特別徴収停止)を行います。
     *
     * @return バッチコマンド
     */
    @Step(賦課計算_特別徴収停止)
    protected IBatchFlowCommand caluculateFukaTokuchoTeishi() {
        return simpleBatch(CaluculateFukaTokuchoTeishiProcess.class).arguments(parameter).define();
    }

    /**
     * 賦課計算(資格取得)を行います。
     *
     * @return バッチコマンド
     */
    @Step(賦課計算_資格取得)
    protected IBatchFlowCommand caluculateFukaShikakuShutoku() {
        return simpleBatch(CaluculateFukaShikakuShutokuProcess.class).arguments(parameter).define();
    }

    /**
     * 賦課計算(口座異動のみ反映)を行います。
     *
     * @return バッチコマンド
     */
    @Step(賦課計算_口座異動のみ反映)
    protected IBatchFlowCommand caluculateFukaKozaIdo() {
        return simpleBatch(CaluculateFukaKozaIdoProcess.class).arguments(parameter).define();
    }

    /**
     * 賦課の情報登録フローを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(賦課の情報登録フロー)
    protected IBatchFlowCommand callChoteiToroku() {
        return otherBatchFlow(賦課の情報登録フローBATCHID, SubGyomuCode.DBB介護賦課,
                new FukaJohoTorokuBatchParameter(true)).define();
    }

    /**
     * 依頼金額計算区分を行います。
     *
     * @return バッチコマンド
     */
    @Step(依頼金額計算区分)
    protected IBatchFlowCommand getIraikinKeisanShoriKubun() {
        return simpleBatch(IraikinKeisanShoriKubunProcess.class).arguments(parameter).define();
    }

    /**
     * 依頼金額計算（8月特徴開始）を行います。
     *
     * @return バッチコマンド
     */
    @Step(依頼金額計算_8月特徴開始)
    protected IBatchFlowCommand caluculateIraiKinTokucho8gatuKaishi() {
        return simpleBatch(CaluculateIraiKinTokuchoHatiKaishiProcess.class).arguments(parameter).define();
    }

    /**
     * 計算後情報作成バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成)
    protected IBatchFlowCommand keisangoJohoSakusei() {
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課,
                getKeisangoJohoSakuseiBatchParamter()).define();
    }

    /**
     * 仮算定異動結（一括）果一覧表出力を行います。
     *
     * @return バッチコマンド
     */
    @Step(仮算定異動一括結果一覧表出力)
    protected IBatchFlowCommand spoolKariSanteiIdoKekkaIchiran() {
        return simpleBatch(SpoolKariSanteiIdoKekkaIchiranProcess.class).arguments(parameter).define();
    }

    /**
     * 異動賦課計算を行います。
     *
     * @return バッチコマンド
     */
    @Step(異動賦課計算)
    protected IBatchFlowCommand idoFukaKeisan() {
        return simpleBatch(IdoFukaKeisanProcess.class).arguments(parameter).define();
    }

    /**
     * 八月特徴開始を行います。
     *
     * @return バッチコマンド
     */
    @Step(八月特徴開始)
    protected IBatchFlowCommand hatiGatuTokuchoKaishi() {
        return simpleBatch(HatiGatuTokuchoKaishiProcess.class).arguments(parameter).define();
    }

    /**
     * 仮算定異動通知書一括発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(仮算定異動通知書一括発行)
    protected IBatchFlowCommand karisanteiIdoTsuchishoIkkatsuHakko() {
        return otherBatchFlow(仮算定異動通知書一括発行BATCHID, SubGyomuCode.DBB介護賦課,
                getParameter()).define();
    }

    private SetaiShotokuKazeiHanteiBatchParameter getSetaiShotokuKazeiHanteiBatchParameter() {
        return new SetaiShotokuKazeiHanteiBatchParameter(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード());
    }

    private KeisangoJohoSakuseiBatchParamter getKeisangoJohoSakuseiBatchParamter() {
        return new KeisangoJohoSakuseiBatchParamter(getParameter().get調定年度(),
                getParameter().get賦課年度(),
                new RString(getResult(YMDHMS.class, new RString(システム日時の取得),
                                SystemTimeShutokuProcess.SYSTEM_TIME).toString()),
                ShoriName.仮算定異動賦課.get名称(), RString.EMPTY);
    }

    private void createKarisanteiIdoKekkaProcessParameter() {
        parameter = new KarisanteiIdoKekkaProcessParameter();
        parameter.set調定年度(new FlexibleYear(getParameter().get調定年度()));
        parameter.set賦課年度(new FlexibleYear(getParameter().get賦課年度()));
        parameter.set処理対象月(getParameter().get処理対象月());
        RDate 年月日1 = new RDate(getParameter().get抽出開始日時().substring(0, INT_EIGHT).toString());
        RTime 時刻1 = new RTime(getParameter().get抽出開始日時().substring(INT_EIGHT));
        parameter.set抽出開始日時(RDateTime.of(年月日1.toDateString(), 時刻1.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        RDate 年月日2 = new RDate(getParameter().get抽出終了日時().substring(0, INT_EIGHT).toString());
        RTime 時刻2 = new RTime(getParameter().get抽出終了日時().substring(INT_EIGHT));
        parameter.set抽出終了日時(RDateTime.of(年月日2.toDateString(), 時刻2.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        parameter.set出力帳票List(getParameter().get出力帳票一覧List());
        RDate 年月日3 = new RDate(getParameter().get普徴仮算定賦課処理日時().substring(0, INT_NINE).toString());
        RTime 時刻3 = new RTime(getParameter().get普徴仮算定賦課処理日時().substring(INT_TEN));
        parameter.set普徴仮算定賦課処理日時(RDateTime.of(年月日3.toDateString(), 時刻3.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        parameter.set依頼金額計算区分(getParameter().get特徴捕捉対象者の依頼金額計算区分());
    }
}
