/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.ChosahyoGaikyochosa_221011Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.ChosahyoKihonchosaProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.ChosahyoSaiCheckhyoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.ChosahyoTokkijiko_221022Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.ChosairairirekiIchiran_DBE220004Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.DbT5201UpdateProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.GaikyoTokki;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.GaikyochosaProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.IchiranhyoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.IraishoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaDesignKatamen;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaDesignRyomen;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaOCRKatamen;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaOCRRyomen;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaSaiCheckhyoKatamen;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaSaiCheckhyoRyomenLeft;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaSaiCheckhyoRyomenRight;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaTokkiJiko;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaTokkiJikoKomokuAri;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaTokkiJikoKomokuAriTenyuryoku;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaTokkiJikoKomokuFree;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaTokkiJikoKomokuFreeTenyuryoku;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaTokkiJikoKomokuNashi;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaTokkiJikoKomokuNashiTenyuryoku;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaTokkiJikoOCRKatamen;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaTokkiJikoOCRRyomen;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.SaiChekkuhyo_292001Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.SaiChekkuhyo_292002Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.SaiChekkuhyo_292003Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.SaiChekkuhyo_292004Process;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.DBE220010_IraishoIkkatuParameter;
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
public class DBE240001_NinteichosaIraisho extends BatchFlowBase<DBE220010_IraishoIkkatuParameter> {

    private static final RString CONFIGVALUE1 = new RString("1");
    private static final RString CONFIGVALUE2 = new RString("2");
    private static final RString CONFIGVALUE3 = new RString("3");
    private static final RString CONFIGVALUE4 = new RString("4");
    private static final RString DBE221012 = new RString("DBE221012_chosahyoKihonchosa.rse");
    private RDate 基準日;
    private static final RString DBE221022 = new RString("DBE221022_chosahyoTokkijiko.rse");
    private static final RString DBE221011 = new RString("DBE221011_chosahyoGaikyochosa.rse");
    private static final String ICHIRANHYOREPORT_PROCESS = "ichiranhyoReport_Process";
    private static final String DBT5201UPDATEPROCESS = "DbT5201UpdateProcess";
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
    private static final String CHOSAIRAIRIREKIICHIRAN = "ChosairairirekiIchiran";
    private static final String 認定調査票_デザイン用紙_片面 = "NinteiChosaDesignKatamen";
    private static final String 認定調査票_デザイン用紙_両面 = "NinteiChosaDesignRyomen";
    private static final String 認定調査票_特記事項 = "NinteiChosaTokkiJiko";
    private static final String 認定調査票_特記事項_項目有り = "NinteiChosaTokkiJikoKomokuAri";
    private static final String 認定調査票_特記事項_項目有り_手入力 = "NinteiChosaTokkiJikoKomokuAriTenyuryoku";
    private static final String 認定調査票_特記事項_項目無し = "NinteiChosaTokkiJikoKomokuNashi";
    private static final String 認定調査票_特記事項_項目無し_手入力 = "NinteiChosaTokkiJikoKomokuNashiTenyuryoku";
    private static final String 認定調査票_特記事項_フリータイプ = "NinteiChosaTokkiJikoKomokuFree";
    private static final String 認定調査票_特記事項_フリータイプ_手入力 = "NinteiChosaTokkiJikoKomokuFreeTenyuryoku";
    private static final String 認定調査差異チェック表_片面 = "NinteiChosaSaiCheckhyoKatamen";
    private static final String 認定調査差異チェック表_両面右 = "NinteiChosaSaiCheckhyoRyomenRight";
    private static final String 認定調査差異チェック表_両面左 = "NinteiChosaSaiCheckhyoRyomenLeft";
    private static final String 認定調査票_OCR_片面 = "NinteiChosaOCRKatamen";
    private static final String 認定調査票_OCR_両面 = "NinteiChosaOCRRyomen";
    private static final String 認定調査票_特記事項_OCR_片面 = "NinteiChosaTokkiJikoOCRKatamen";
    private static final String 認定調査票_特記事項_OCR_両面 = "NinteiChosaTokkiJikoOCRRyomen";
    private static final String 概況特記 = "GaikyoTokki";

    @Override
    protected void defineFlow() {
        基準日 = RDate.getNowDate();
        executeStep(DBT5201UPDATEPROCESS);
        if (getParameter().isNinteiChosaIraiChohyo()) {
            executeStep(CHOSAIRAISHOREPORT_PROCESS);
        }
        if (getParameter().is認定調査依頼書()) {
            executeStep(ICHIRANHYOREPORT_PROCESS);
        }
        if (getParameter().is認定調査票_デザイン用紙()) {
            call認定調査票_デザイン用紙();
        }
        if (getParameter().is特記事項_デザイン用紙()) {
            call認定調査票_特記事項();
        }
        if (getParameter().is特記事項_項目あり()) {
            call認定調査票_特記事項_項目有り();
        }
        if (getParameter().is特記事項_項目無し()) {
            call認定調査票_特記事項_項目無し();
        }
        if (getParameter().is特記事項_フリータイプ()) {
            call認定調査票_特記事項_フリータイプ();
        }
        if (getParameter().is認定調査票OCR()) {
            call認定調査票_OCR();
        }
        if (getParameter().is特記事項OCR()) {
            call認定調査票OCR_特記事項();
        }
        if (getParameter().is認定調査差異チェック票()) {
            call認定調査差異チェック表();
        }
        if (getParameter().is概況特記()) {
            call概況特記();
        }
        if (getParameter().is認定調査依頼履歴一覧()) {
            executeStep(CHOSAIRAIRIREKIICHIRAN);
        }
        if (getParameter().is前回認定調査結果との比較表()) {
            executeStep(CHOSAHYOSAICHECKHYO);
        }

//        
//        if (getParameter().isNinteiChosahyoKihon()) {
//            call認定調査票_基本調査();
//        }
//        if (getParameter().isNinteiChosahyoTokki()) {
//            call認定調査票_特記事項();
//        }
//        if (getParameter().isNinteiChosahyoGaikyou()) {
//            call認定調査票_概況調査();
//        }
//        if (getParameter().isNinteiChosahyoOCRKihon()) {
//            call認定調査票OCR_基本調査();
//        }
//        if (getParameter().isNinteiChosahyoOCRTokki()) {
//            call認定調査票OCR_特記事項();
//        }
//        if (getParameter().isNinteiChosahyoOCRGaikyou()) {
//            call認定調査票OCR_概況調査();
//        }
//        if (getParameter().isGaikyoChosa() || getParameter().isGaikyoChosaOCR()) {
//            executeStep(GAIKYOCHOSA);
//        }
//        if (getParameter().isNinteiChosaCheckHyo()) {
//            call認定調査差異チェック表();
//        }
    }

    private void call概況特記() {
        executeStep(概況特記);
//        printService.print概況特記(getHandler(div).create概況特記_パラメータ(ninteiShinseiJoho));
    }

    private void call認定調査差異チェック表() {
        RDate date = RDate.getNowDate();
        RString 業務コンフィグ認定調査票差異チェック票_印刷タイプ = DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, date, SubGyomuCode.DBE認定支援);
        if (CONFIGVALUE1.equals(業務コンフィグ認定調査票差異チェック票_印刷タイプ)) {
            executeStep(認定調査差異チェック表_片面);
//            ninteiChosaIraiPrintService.print要介護認定調査票差異チェック票(handler.create調査票差異チェック票_DBE292001パラメータ());
        } else if (CONFIGVALUE2.equals(業務コンフィグ認定調査票差異チェック票_印刷タイプ)) {
            executeStep(認定調査差異チェック表_両面右);
//            ninteiChosaIraiPrintService.print要介護認定調査票差異チェック票_両面右(handler.create調査票差異チェック票_DBE292004パラメータ());
        } else if (CONFIGVALUE3.equals(業務コンフィグ認定調査票差異チェック票_印刷タイプ)) {
            executeStep(認定調査差異チェック表_両面左);
//            ninteiChosaIraiPrintService.print要介護認定調査票差異チェック票_両面左(handler.create調査票差異チェック票_DBE292004パラメータ());
        }
    }

    private void call認定調査票_OCR() {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_用紙タイプ, date, SubGyomuCode.DBE認定支援))) {
            RString 業務コンフィグ認定調査票_概況調査_印刷タイプ = DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, date, SubGyomuCode.DBE認定支援);
            if (CONFIGVALUE1.equals(業務コンフィグ認定調査票_概況調査_印刷タイプ)) {
                executeStep(認定調査票_OCR_片面);
//                ninteiChosaIraiPrintService.print認定調査票OCR片面(handler.create認定調査票_概況調査_基本調査パラメータ());
            } else if (CONFIGVALUE2.equals(業務コンフィグ認定調査票_概況調査_印刷タイプ)) {
                executeStep(認定調査票_OCR_両面);
//                ninteiChosaIraiPrintService.print認定調査票OCR両面(handler.create認定調査票_概況調査_基本調査パラメータ());
            }
        }
    }

    private void call認定調査票OCR_特記事項() {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_用紙タイプ, date, SubGyomuCode.DBE認定支援))) {
            RString 業務コンフィグ認定調査票差異チェック票_印刷タイプ = DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, date, SubGyomuCode.DBE認定支援);
            if (CONFIGVALUE1.equals(業務コンフィグ認定調査票差異チェック票_印刷タイプ)) {
                executeStep(認定調査票_特記事項_OCR_片面);
//                ninteiChosaIraiPrintService.print認定調査票_特記事項_OCR片面(handler.create認定調査票_特記事項パラメータ(false));
            } else if (CONFIGVALUE2.equals(業務コンフィグ認定調査票差異チェック票_印刷タイプ)) {
                executeStep(認定調査票_特記事項_OCR_両面);
//                ninteiChosaIraiPrintService.print認定調査票_特記事項_OCR両面(handler.create認定調査票_特記事項パラメータ(true));
            }
        }
    }

    private void call認定調査票_デザイン用紙() {
        RDate date = RDate.getNowDate();
        RString 業務コンフィグ認定調査票_概況調査_印刷タイプ = DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, date, SubGyomuCode.DBE認定支援);
        if (CONFIGVALUE1.equals(業務コンフィグ認定調査票_概況調査_印刷タイプ)) {
            executeStep(認定調査票_デザイン用紙_片面);
//            ninteiChosaIraiPrintService.print認定調査票_デザイン用紙片面(handler.create認定調査票_概況調査_基本調査パラメータ());
        } else if (CONFIGVALUE2.equals(業務コンフィグ認定調査票_概況調査_印刷タイプ)) {
            executeStep(認定調査票_デザイン用紙_両面);
//            ninteiChosaIraiPrintService.print認定調査票_デザイン用紙両面(handler.create認定調査票_概況調査_基本調査パラメータ());
        }
    }

    private void call認定調査票_特記事項() {
        executeStep(認定調査票_特記事項);
//        ninteiChosaIraiPrintService.print認定調査票_特記事項_デザイン用紙(handler.create認定調査票_特記事項パラメータ(false));
    }

    private void call認定調査票_特記事項_項目有り() {
        if (getParameter().is手入力タイプ()) {
            executeStep(認定調査票_特記事項_項目有り_手入力);
//            ninteiChosaIraiPrintService.print認定調査票_特記事項_項目有り_手入力(handler.create認定調査票_特記事項パラメータ(false));
        } else {
            executeStep(認定調査票_特記事項_項目有り);
//            ninteiChosaIraiPrintService.print認定調査票_特記事項_項目有り(handler.create認定調査票_特記事項パラメータ(false));
        }
    }

    private void call認定調査票_特記事項_項目無し() {
        if (getParameter().is手入力タイプ()) {
//            ninteiChosaIraiPrintService.print認定調査票_特記事項_項目無し_手入力(handler.create認定調査票_特記事項パラメータ(false));
            executeStep(認定調査票_特記事項_項目無し_手入力);
        } else {
            executeStep(認定調査票_特記事項_項目無し);
//            ninteiChosaIraiPrintService.print認定調査票_特記事項_項目無し(handler.create認定調査票_特記事項パラメータ(false));
        }
    }

    private void call認定調査票_特記事項_フリータイプ() {
        if (getParameter().is手入力タイプ()) {
            executeStep(認定調査票_特記事項_フリータイプ);
//            ninteiChosaIraiPrintService.print認定調査票_特記事項_フリータイプ_手入力(handler.create認定調査票_特記事項パラメータ(false));
        } else {
            executeStep(認定調査票_特記事項_フリータイプ_手入力);
//            ninteiChosaIraiPrintService.print認定調査票_特記事項_フリータイプ(handler.create認定調査票_特記事項パラメータ(false));
        }
    }

    /**
     * 概況特記のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(概況特記)
    protected IBatchFlowCommand gaikyoTokkiProcess() {
        return loopBatch(GaikyoTokki.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査差異チェック表_片面のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査差異チェック表_片面)
    protected IBatchFlowCommand ninteiChosaSaiCheckhyoKatamenuProcess() {
        return loopBatch(NinteiChosaSaiCheckhyoKatamen.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査差異チェック表_両面右のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査差異チェック表_両面右)
    protected IBatchFlowCommand ninteiChosaSaiCheckhyoRyomenRightProcess() {
        return loopBatch(NinteiChosaSaiCheckhyoRyomenRight.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査差異チェック表_両面左のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査差異チェック表_両面左)
    protected IBatchFlowCommand ninteiChosaSaiCheckhyoRyomenLeftProcess() {
        return loopBatch(NinteiChosaSaiCheckhyoRyomenLeft.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票_OCR_片面のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_OCR_片面)
    protected IBatchFlowCommand ninteiChosaOCRKatamenProcess() {
        return loopBatch(NinteiChosaOCRKatamen.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票_OCR_両面のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_OCR_両面)
    protected IBatchFlowCommand ninteiChosaOCRRyomenProcess() {
        return loopBatch(NinteiChosaOCRRyomen.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票_特記事項_OCR_片面のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_特記事項_OCR_片面)
    protected IBatchFlowCommand ninteiChosaTokkiJikoOCRKatamenProcess() {
        return loopBatch(NinteiChosaTokkiJikoOCRKatamen.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票_特記事項_OCR_両面のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_特記事項_OCR_両面)
    protected IBatchFlowCommand ninteiChosaTokkiJikoOCRRyomenProcess() {
        return loopBatch(NinteiChosaTokkiJikoOCRRyomen.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票_デザイン用紙_片面のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_デザイン用紙_片面)
    protected IBatchFlowCommand ninteiChosaDesignKatamenProcess() {
        return loopBatch(NinteiChosaDesignKatamen.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票_デザイン用紙_両面のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_デザイン用紙_両面)
    protected IBatchFlowCommand ninteiChosaDesignRyomenProcess() {
        return loopBatch(NinteiChosaDesignRyomen.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票_特記事項のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_特記事項)
    protected IBatchFlowCommand ninteiChosaTokkiJikoProcess() {
        return loopBatch(NinteiChosaTokkiJiko.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票_特記事項_項目有り_手入力のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_特記事項_項目有り_手入力)
    protected IBatchFlowCommand ninteiChosaTokkiJikoKomokuAriTenyuryokuProcess() {
        return loopBatch(NinteiChosaTokkiJikoKomokuAriTenyuryoku.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票_特記事項_項目有りのReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_特記事項_項目有り)
    protected IBatchFlowCommand ninteiChosaTokkiJikoKomokuAriProcess() {
        return loopBatch(NinteiChosaTokkiJikoKomokuAri.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票_特記事項_項目無し_手入力のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_特記事項_項目無し_手入力)
    protected IBatchFlowCommand ninteiChosaTokkiJikoKomokuNashiTenyuryokuProcess() {
        return loopBatch(NinteiChosaTokkiJikoKomokuNashiTenyuryoku.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票_特記事項_項目無しのReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_特記事項_項目無し)
    protected IBatchFlowCommand ninteiChosaTokkiJikoKomokuNashiProcess() {
        return loopBatch(NinteiChosaTokkiJikoKomokuNashi.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票_特記事項_フリータイプ_手入力のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_特記事項_フリータイプ_手入力)
    protected IBatchFlowCommand ninteiChosaTokkiJikoKomokuFreeTenyuryokuProcess() {
        return loopBatch(NinteiChosaTokkiJikoKomokuFreeTenyuryoku.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 認定調査票_特記事項_フリータイプのReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_特記事項_フリータイプ)
    protected IBatchFlowCommand ninteiChosaTokkiJikoKomokuFreeProcess() {
        return loopBatch(NinteiChosaTokkiJikoKomokuFree.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
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

    /**
     * DBE220004_認定調査依頼履歴一覧のProcessです。
     *
     * @return ChosairairirekiIchiran_DBE220004Process
     */
    @Step(CHOSAIRAIRIREKIICHIRAN)
    protected IBatchFlowCommand chosairairirekiIchiranProcess() {
        return loopBatch(ChosairairirekiIchiran_DBE220004Process.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * テーブル「DbT5201NinteichosaIraiJoho」の更新処理Processです。
     *
     * @return DbT5201UpdateProcess
     */
    @Step(DBT5201UPDATEPROCESS)
    protected IBatchFlowCommand callDbT5201UpdateProcess() {
        return loopBatch(DbT5201UpdateProcess.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }
}
