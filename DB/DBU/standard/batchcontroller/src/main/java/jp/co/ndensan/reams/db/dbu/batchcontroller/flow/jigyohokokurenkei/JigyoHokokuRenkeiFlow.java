/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow.jigyohokokurenkei;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkei11_14GassanProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkei11_14GenbutsuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkei11_14ShokanProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkeiGassanYousikiNi_GoToRokuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkeiGassanYousikiNi_IchiToYonProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkeiGassanYousikiNi_SitiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkeiGenbutsuYousikiNi_GoToRokuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkeiGenbutsuYousikiNi_IchiToYonProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkeiGenbutsuYousikiNi_SitiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkeiHokenYousikiIchiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkeiHokenYousikiIchi_NiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkeiHokenYousikiIchi_SanProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkeiHokenYousikiIchi_YonProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkeiShokanYousikiNi_GoToRokuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkeiShokanYousikiNi_IchiToYonProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei.JigyoHokokuRenkeiShokanYousikiNi_SitiProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.jigyohokokurenkei.JigyoHokokuRenkeiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.ZipUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 様式別連携情報作成のバッチフ処理クラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 *
 */
public class JigyoHokokuRenkeiFlow extends BatchFlowBase<JigyoHokokuRenkeiBatchParameter> {

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

    @Override
    protected void defineFlow() {
        RString spoolWorkPath = Directory.createTmpDirectory();
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
        RString zipPath = Path.combinePath(spoolWorkPath, new RString("spoolWorkPath.zip"));
        ZipUtil.createFromFolder(zipPath, spoolWorkPath);
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
