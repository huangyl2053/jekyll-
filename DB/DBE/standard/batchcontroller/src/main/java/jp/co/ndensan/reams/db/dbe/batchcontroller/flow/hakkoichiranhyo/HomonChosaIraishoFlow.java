/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.hakkoichiranhyo;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.ChosahyoGaikyochosa_221011Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.ChosahyoKihonchosaProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.ChosahyoSaiCheckhyoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.ChosahyoTokkijiko_221022Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.GaikyochosaProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.IchiranhyoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.IraishoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.SaiChekkuhyo_292001Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.SaiChekkuhyo_292002Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.SaiChekkuhyo_292003Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.SaiChekkuhyo_292004Process;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.IraishoIkkatsuHakkoBatchParamter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 訪問調査依頼書発行_バッチフロークラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public class HomonChosaIraishoFlow extends BatchFlowBase<IraishoIkkatsuHakkoBatchParamter> {

    private static final RString CONFIGVALUE1 = new RString("1");
    private static final RString CONFIGVALUE2 = new RString("2");
    private static final RString CONFIGVALUE3 = new RString("3");
    private static final RString CONFIGVALUE4 = new RString("4");

    private static final RString DBE221012 = new RString("DBE221012_chosahyoKihonchosa.rse");
    private RDate 基準日;
    private static final RString DBE221022 = new RString("DBE221022_chosahyoTokkijiko.rse");
    private static final RString DBE221011 = new RString("DBE221011_chosahyoGaikyochosa.rse");
    private static final String ICHIRANHYOREPORT_PROCESS = "ichiranhyoReport_Process";
    private static final String CHOSAIRAISHOREPORT_PROCESS = "chosaIraishoReport_Process";
    private static final String CHOSAHYOKIHONCHOSA = "chosahyoKihonchosa";
    private static final String CHOSAHYOTOKKIJIKO22 = "chosahyoTokkijiko22";
    private static final String CHOSAHYOGAIKYOCHOSA11 = "chosahyoGaikyochosa11";
    private static final String SAICHEKKUHYO1 = "SaiChekkuhyo1";
    private static final String SAICHEKKUHYO2 = "SaiChekkuhyo2";
    private static final String SAICHEKKUHYO3 = "SaiChekkuhyo3";
    private static final String SAICHEKKUHYO4 = "SaiChekkuhyo4";
    private static final String CHOSAHYOSAICHECKHYO = "chosahyoSaiCheckhyo";
    private static final String GAIKYOCHOSA = "GaikyoChosa";

    @Override
    protected void defineFlow() {
        基準日 = RDate.getNowDate();
        if (getParameter().isNinteiChosaIraiChohyo()) {
            executeStep(CHOSAIRAISHOREPORT_PROCESS);
        }
        if (getParameter().isNinteiChosahyoKihon()) {
            call認定調査票_基本調査();
        }
        if (getParameter().isNinteiChosahyoTokki()) {
            call認定調査票_特記事項();
        }
        if (getParameter().isNinteiChosahyoGaikyou()) {
            call認定調査票_概況調査();
        }
        if (getParameter().isNinteiChosahyoOCRKihon()) {
            call認定調査票OCR_基本調査();
        }
        if (getParameter().isNinteiChosahyoOCRTokki()) {
            call認定調査票OCR_特記事項();
        }
        if (getParameter().isNinteiChosahyoOCRGaikyou()) {
            call認定調査票OCR_概況調査();
        }
        if (getParameter().isGaikyoChosa() || getParameter().isGaikyoChosaOCR()) {
            executeStep(GAIKYOCHOSA);
        }
        if (getParameter().isNinteiChosaCheckHyo()) {
            call認定調査差異チェック表();
        }
        if (getParameter().isZenkoNinteiChosahyo()) {
            executeStep(CHOSAHYOSAICHECKHYO);
        }
        if (getParameter().isNinteiChosaIraisyo()) {
            executeStep(ICHIRANHYOREPORT_PROCESS);
        }

    }

    private void call認定調査差異チェック表() {
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            executeStep(SAICHEKKUHYO1);
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            executeStep(SAICHEKKUHYO3);
            executeStep(SAICHEKKUHYO4);
        } else if (CONFIGVALUE3.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            executeStep(SAICHEKKUHYO2);
            executeStep(SAICHEKKUHYO4);
        }
    }

    private void call認定調査票OCR_概況調査() {
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォームデザインシート片面1枚目1,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォームデザインシート片面1枚目2,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォームデザインシート片面1枚目3,
                    基準日, SubGyomuCode.DBE認定支援));
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォームデザインシート両面1,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォームデザインシート両面2,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォームデザインシート両面3,
                    基準日, SubGyomuCode.DBE認定支援));
        }
    }

    private void call認定調査票OCR_特記事項() {
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_用紙タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォームデザインシート片面1,
                        基準日, SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォームデザインシート片面2,
                        基準日, SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォームデザインシート片面3,
                        基準日, SubGyomuCode.DBE認定支援));
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォームデザインシート両面1,
                        基準日, SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォームデザインシート両面2,
                        基準日, SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォームデザインシート両面3,
                        基準日, SubGyomuCode.DBE認定支援));
            }
        }
    }

    private void call認定調査票OCR_基本調査() {
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォームデザインシート片面1枚目1,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォームデザインシート片面1枚目2,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォームデザインシート片面1枚目3,
                    基準日, SubGyomuCode.DBE認定支援));
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォームデザインシート両面1,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォームデザインシート両面2,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォームデザインシート両面3,
                    基準日, SubGyomuCode.DBE認定支援));
        }
    }

    private void call認定調査票_概況調査() {
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォーム白紙カラー片面1枚目1,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォーム白紙カラー片面1枚目2,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォーム白紙カラー片面1枚目3,
                    基準日, SubGyomuCode.DBE認定支援));
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォーム白紙カラー両面1,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォーム白紙カラー両面2,
                    基準日, SubGyomuCode.DBE認定支援));
        }
    }

    private void call認定調査票_特記事項() {
        if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_用紙タイプ, 基準日, SubGyomuCode.DBE認定支援))
                && CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム白紙カラー片面1,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム白紙カラー片面2,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム白紙カラー片面3,
                    基準日, SubGyomuCode.DBE認定支援));
        }
        if (CONFIGVALUE3.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_用紙タイプ, 基準日, SubGyomuCode.DBE認定支援))
                && CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム白紙モノクロ片面1,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム白紙モノクロ片面2,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム白紙モノクロ片面3,
                    基準日, SubGyomuCode.DBE認定支援));
        }
        if (CONFIGVALUE4.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_用紙タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム独自片面1,
                        基準日, SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム独自片面2,
                        基準日, SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム独自片面3,
                        基準日, SubGyomuCode.DBE認定支援));
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム独自両面1,
                        基準日, SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム独自両面2,
                        基準日, SubGyomuCode.DBE認定支援));
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム独自両面3,
                        基準日, SubGyomuCode.DBE認定支援));
            }
        }
    }

    private void call認定調査票_基本調査() {
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォーム白紙カラー片面1枚目1,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォーム白紙カラー片面1枚目2,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォーム白紙カラー片面1枚目3,
                    基準日, SubGyomuCode.DBE認定支援));
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォーム白紙カラー両面1,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォーム白紙カラー両面2,
                    基準日, SubGyomuCode.DBE認定支援));
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォーム白紙カラー両面3,
                    基準日, SubGyomuCode.DBE認定支援));
        }
    }

    private void getExecuteStep(RString rseValue) {
        if (DBE221012.equals(rseValue)) {
            executeStep(CHOSAHYOKIHONCHOSA);
        } else if (DBE221022.equals(rseValue)) {
            executeStep(CHOSAHYOTOKKIJIKO22);
        } else if (DBE221011.equals(rseValue)) {
            executeStep(CHOSAHYOGAIKYOCHOSA11);
        }
    }

    /**
     * 認定調査依頼一覧表のProcessです。
     *
     * @return IraishoReportProcess
     */
    @Step(CHOSAIRAISHOREPORT_PROCESS)
    protected IBatchFlowCommand ichiranhyoReportProcess() {
        return loopBatch(IchiranhyoReportProcess.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査依頼書のReportProcessです。
     *
     * @return IraishoReportProcess
     */
    @Step(ICHIRANHYOREPORT_PROCESS)
    protected IBatchFlowCommand iraishoReportProcess() {
        return loopBatch(IraishoReportProcess.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 要介護認定調査票（基本調査）のDBE221012ReportProcessです。
     *
     * @return ChosahyoKihonchosaProcess
     */
    @Step(CHOSAHYOKIHONCHOSA)
    protected IBatchFlowCommand chosahyoKihonchosaProcess() {
        return loopBatch(ChosahyoKihonchosaProcess.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 要介護認定調査票（特記事項）のDBE221022ReportProcessです。
     *
     * @return ChosahyoTokkijiko_221022Process
     */
    @Step(CHOSAHYOTOKKIJIKO22)
    protected IBatchFlowCommand chosahyoTokkijiko22Process() {
        return loopBatch(ChosahyoTokkijiko_221022Process.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 要介護認定調査票（概況調査）のDBE221011ReportProcessです。
     *
     * @return ChosahyoGaikyochosa_221011Process
     */
    @Step(CHOSAHYOGAIKYOCHOSA11)
    protected IBatchFlowCommand chosahyoGaikyochosa11Process() {
        return loopBatch(ChosahyoGaikyochosa_221011Process.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票(概況特記)のDBE221051ReportProcessです。
     *
     * @return GaikyochosaProcess
     */
    @Step(GAIKYOCHOSA)
    protected IBatchFlowCommand callGaikyochosaProcess() {
        return loopBatch(GaikyochosaProcess.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 前回認定調査結果との比較表のDBE293001ReportProcessです。
     *
     * @return ChosahyoSaiCheckhyoReportProcess
     */
    @Step(CHOSAHYOSAICHECKHYO)
    protected IBatchFlowCommand chosahyoSaiCheckhyoReportProcess() {
        return loopBatch(ChosahyoSaiCheckhyoReportProcess.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票差異チェック票のDBE292001ReportProcessです。
     *
     * @return SaiChekkuhyo_292001Process
     */
    @Step(SAICHEKKUHYO1)
    protected IBatchFlowCommand saiChekkuhyoProcess1() {
        return loopBatch(SaiChekkuhyo_292001Process.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票差異チェック票のDBE292002ReportProcessです。
     *
     * @return SaiChekkuhyo_292002Process
     */
    @Step(SAICHEKKUHYO2)
    protected IBatchFlowCommand saiChekkuhyoProcess2() {
        return loopBatch(SaiChekkuhyo_292002Process.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票差異チェック票のDBE292002ReportProcessです。
     *
     * @return SaiChekkuhyo_292003Process
     */
    @Step(SAICHEKKUHYO3)
    protected IBatchFlowCommand saiChekkuhyoProcess3() {
        return loopBatch(SaiChekkuhyo_292003Process.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票差異チェック票のDBE292004ReportProcessです。
     *
     * @return SaiChekkuhyo_292004Process
     */
    @Step(SAICHEKKUHYO4)
    protected IBatchFlowCommand saiChekkuhyoProcess4() {
        return loopBatch(SaiChekkuhyo_292004Process.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

}
