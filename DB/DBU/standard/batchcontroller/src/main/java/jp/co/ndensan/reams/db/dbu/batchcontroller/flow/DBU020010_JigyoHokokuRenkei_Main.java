/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkei11_14GassanProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkei11_14GenbutsuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkei11_14ShokanProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkeiGassanYousikiNi_GoToRokuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkeiGassanYousikiNi_IchiToYonProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkeiGassanYousikiNi_SitiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkeiGenbutsuYousikiNi_GoToRokuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkeiGenbutsuYousikiNi_IchiToYonProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkeiGenbutsuYousikiNi_SitiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkeiHokenYousikiIchiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkeiHokenYousikiIchi_NiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkeiHokenYousikiIchi_SanProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkeiHokenYousikiIchi_YonProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkeiShokanYousikiNi_GoToRokuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkeiShokanYousikiNi_IchiToYonProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010.JigyoHokokuRenkeiShokanYousikiNi_SitiProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU020010.DBU020010_JigyoHokokuRenkei_MainParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.ZipUtil;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 様式別連携情報作成のバッチフ処理クラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 *
 */
public class DBU020010_JigyoHokokuRenkei_Main extends BatchFlowBase<DBU020010_JigyoHokokuRenkei_MainParameter> {

    private static final String YOUSIKIICHIPROCESS = "yousikiIchiProcess";
    private static final String YOUSIKIICHI_NIPROCESS = "yousikiIchi_NiProcess";
    private static final String YOUSIKIICHI_SANPROCESS = "yousikiIchi_SanProcess";
    private static final String YOUSIKIICHI_YONPROCESS = "yousikiIchi_YonProcess";
    private static final String SHOKANPROCESS = "shokanProcess";
    private static final String GENBUTSUPROCESS = "genbutsuProcess";
    private static final String GASSANPROCESS = "gassanProcess";
    private static final String GASSANYOUSIKINI_GOPROCESS = "gassanYousikiNi_GoProcess";
    private static final String GASSANYOUSIKINI_ICHIPROCESS = "gassanYousikiNi_IchiProcess";
    private static final String GASSANYOUSIKINI_SITIPROCESS = "gassanYousikiNi_SitiProcess";
    private static final String GENBUTSUYOUSIKINI_GOPROCESS = "genbutsuYousikiNi_GoProcess";
    private static final String GENBUTSUYOUSIKINI_ICHIPROCESS = "genbutsuYousikiNi_IchiProcess";
    private static final String GENBUTSUYOUSIKINI_SITIPROCESS = "genbutsuYousikiNi_SitiProcess";
    private static final String SHOKANYOUSIKINI_GOPROCESS = "shokanYousikiNi_GoProcess";
    private static final String SHOKANYOUSIKINI_ICHIPROCESS = "shokanYousikiNi_IchiProcess";
    private static final String SHOKANYOUSIKINI_SITIPROCESS = "shokanYousikiNi_SitiProcess";
    private FileSpoolManager manager;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBU020011"));

    @Override
    protected void defineFlow() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
                
        getParameter().setSpoolWorkPath(spoolWorkPath);
        if (getParameter().is出力_一般状況1_10()) {
            executeStep(YOUSIKIICHIPROCESS);
            executeStep(YOUSIKIICHI_NIPROCESS);
            executeStep(YOUSIKIICHI_SANPROCESS);
            executeStep(YOUSIKIICHI_YONPROCESS);
        }

        if (getParameter().is出力_一般状況11_14償還分_審査年月() || getParameter().is出力_一般状況11_14償還分_決定年月()) {
            executeStep(SHOKANPROCESS);
        }
        if (getParameter().is出力_一般状況11_14現物分()) {
            executeStep(GENBUTSUPROCESS);
        }
        if (getParameter().is出力_一般状況11_14合算_審査年月() || getParameter().is出力_一般状況11_14合算_決定年月()) {
            executeStep(GASSANPROCESS);
        }

        if (getParameter().is出力_保険給付決定状況償還分_審査年月() || getParameter().is出力_保険給付決定状況償還分_決定年月()) {
            executeStep(SHOKANYOUSIKINI_GOPROCESS);
            executeStep(SHOKANYOUSIKINI_ICHIPROCESS);
            executeStep(SHOKANYOUSIKINI_SITIPROCESS);
        }

        if (getParameter().is出力_保険給付決定状況現物分()) {
            executeStep(GENBUTSUYOUSIKINI_GOPROCESS);
            executeStep(GENBUTSUYOUSIKINI_ICHIPROCESS);
            executeStep(GENBUTSUYOUSIKINI_SITIPROCESS);
        }

        if (getParameter().is出力_保険給付決定状況合算_審査年月() || getParameter().is出力_保険給付決定状況合算_決定年月()) {
            executeStep(GASSANYOUSIKINI_GOPROCESS);
            executeStep(GASSANYOUSIKINI_ICHIPROCESS);
            executeStep(GASSANYOUSIKINI_SITIPROCESS);
        }
        RString csvFileName = new RString("jigyoJokyoHokoku_"
                + getParameter().get過去集計年月()
                + "_"
                + DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告) + ".zip");
        RString zipPath = Path.combinePath(spoolWorkPath, csvFileName);
        ZipUtil.createFromFolder(zipPath, spoolWorkPath);
        manager.spool(zipPath);
    }

    /**
     * 様式別連携情報作成のバッチ処理・一般状況（１）～（１０）に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(YOUSIKIICHIPROCESS)
    protected IBatchFlowCommand createYousikiIchiProcess() {
        return loopBatch(JigyoHokokuRenkeiHokenYousikiIchiProcess.class).arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・一般状況（１）～（１０）に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(YOUSIKIICHI_NIPROCESS)
    protected IBatchFlowCommand createYousikiIchi_NiProcess() {
        return loopBatch(JigyoHokokuRenkeiHokenYousikiIchi_NiProcess.class).arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・一般状況（１）～（１０）に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(YOUSIKIICHI_SANPROCESS)
    protected IBatchFlowCommand createYousikiIchi_SanProcess() {
        return loopBatch(JigyoHokokuRenkeiHokenYousikiIchi_SanProcess.class).arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・一般状況（１）～（１０）に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(YOUSIKIICHI_YONPROCESS)
    protected IBatchFlowCommand createYousikiIchi_YonProcess() {
        return loopBatch(JigyoHokokuRenkeiHokenYousikiIchi_YonProcess.class).arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・一般状況１１～１４償還分に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(SHOKANPROCESS)
    protected IBatchFlowCommand createShokanProcess() {
        return loopBatch(JigyoHokokuRenkei11_14ShokanProcess.class).arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・一般状況１１～１４現物分に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(GENBUTSUPROCESS)
    protected IBatchFlowCommand createGenbutsuProcess() {
        return loopBatch(JigyoHokokuRenkei11_14GenbutsuProcess.class).arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・一般状況１１～１４合算分に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(GASSANPROCESS)
    protected IBatchFlowCommand createGassanProcess() {
        return loopBatch(JigyoHokokuRenkei11_14GassanProcess.class).arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・保険給付決定状況償還分に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(SHOKANYOUSIKINI_GOPROCESS)
    protected IBatchFlowCommand createShokanYousikiNi_GoProcess() {
        return loopBatch(JigyoHokokuRenkeiShokanYousikiNi_GoToRokuProcess.class).
                arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・保険給付決定状況償還分に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(SHOKANYOUSIKINI_ICHIPROCESS)
    protected IBatchFlowCommand createShokanYousikiNi_IchiProcess() {
        return loopBatch(JigyoHokokuRenkeiShokanYousikiNi_IchiToYonProcess.class).
                arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・保険給付決定状況償還分に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(SHOKANYOUSIKINI_SITIPROCESS)
    protected IBatchFlowCommand createShokanYousikiNi_SitiProcess() {
        return loopBatch(JigyoHokokuRenkeiShokanYousikiNi_SitiProcess.class).
                arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・保険給付決定状況現物分に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(GENBUTSUYOUSIKINI_GOPROCESS)
    protected IBatchFlowCommand createGenbutsuYousikiNi_GoProcess() {
        return loopBatch(JigyoHokokuRenkeiGenbutsuYousikiNi_GoToRokuProcess.class).
                arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・保険給付決定状況現物分に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(GENBUTSUYOUSIKINI_ICHIPROCESS)
    protected IBatchFlowCommand createGenbutsuYousikiNi_IchiProcess() {
        return loopBatch(JigyoHokokuRenkeiGenbutsuYousikiNi_IchiToYonProcess.class).
                arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・保険給付決定状況現物分に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(GENBUTSUYOUSIKINI_SITIPROCESS)
    protected IBatchFlowCommand createGenbutsuYousikiNi_SitiProcess() {
        return loopBatch(JigyoHokokuRenkeiGenbutsuYousikiNi_SitiProcess.class).
                arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・保険給付決定状況合算分に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(GASSANYOUSIKINI_GOPROCESS)
    protected IBatchFlowCommand createGassanYousikiNi_GoProcess() {
        return loopBatch(JigyoHokokuRenkeiGassanYousikiNi_GoToRokuProcess.class).
                arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・保険給付決定状況合算分に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(GASSANYOUSIKINI_ICHIPROCESS)
    protected IBatchFlowCommand createGassanYousikiNi_IchiProcess() {
        return loopBatch(JigyoHokokuRenkeiGassanYousikiNi_IchiToYonProcess.class).
                arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }

    /**
     * 様式別連携情報作成のバッチ処理・保険給付決定状況合算分に対応するのCSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(GASSANYOUSIKINI_SITIPROCESS)
    protected IBatchFlowCommand createGassanYousikiNi_SitiProcess() {
        return loopBatch(JigyoHokokuRenkeiGassanYousikiNi_SitiProcess.class).
                arguments(getParameter().toJigyoHokokuRenkeiProcessParameter()).define();
    }
}
