/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.hakkoichiranhyo;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.ChosahyoGaikyochosa_221001Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.ChosahyoGaikyochosa_221011Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.ChosahyoKihonchosaKatamenProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.ChosahyoKihonchosaProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.ChosahyoKihonchosaRyomenProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.ChosahyoSaiCheckhyoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.ChosahyoTokkijiko_221021Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.ChosahyoTokkijiko_221022Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.ChosahyoTokkijiko_221023Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.ChosahyoTokkijiko_221024Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.IchiranhyoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.IraishoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.SaiChekkuhyo_292001Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.SaiChekkuhyo_292002Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.SaiChekkuhyo_292003Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.SaiChekkuhyo_292004Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.TokkijikoOCR_221041Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.TokkijikoOCR_221042Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho.TokkijikoOCR_221043Process;
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
    private static final RString DBE221002 = new RString("DBE221002_ChosahyoKihonchosaKatamen.rse");
    private static final RString DBE221003 = new RString("DBE221003_ChosahyoKihonchosaRyomen.rse");
    private static final RString DBE221012 = new RString("DBE221012_chosahyoKihonchosa.rse");
    private RDate 基準日;

    private static final RString DBE221021 = new RString("DBE221021_chosahyoTokkijiko.rse");
    private static final RString DBE221022 = new RString("DBE221022_chosahyoTokkijiko.rse");
    private static final RString DBE221023 = new RString("DBE221023_chosahyoTokkijiko.rse");
    private static final RString DBE221024 = new RString("DBE221024_chosahyoTokkijiko.rse");
    private static final RString DBE221041 = new RString("DBE221041_tokkijikoOCR.rse");
    private static final RString DBE221042 = new RString("DBE221042_tokkijikoOCR.rse");
    private static final RString DBE221043 = new RString("DBE221043_tokkijikoOCR.rse");

    private static final RString DBE221001 = new RString("DBE221001_ChosahyoGaikyochosa.rse");
    private static final RString DBE221011 = new RString("DBE221011_chosahyoGaikyochosa.rse");

    private static final String ICHIRANHYOREPORT_PROCESS = "ichiranhyoReport_Process";
    private static final String CHOSAIRAISHOREPORT_PROCESS = "chosaIraishoReport_Process";
    private static final String CHOSAHYOKIHONCHOSAKATAMEN = "ChosahyoKihonchosaKatamen";
    private static final String CHOSAHYOKIHONCHOSARYOMEN = "ChosahyoKihonchosaRyomen";
    private static final String CHOSAHYOKIHONCHOSA = "chosahyoKihonchosa";
    private static final String CHOSAHYOTOKKIJIKO21 = "chosahyoTokkijiko21";
    private static final String CHOSAHYOTOKKIJIKO22 = "chosahyoTokkijiko22";
    private static final String CHOSAHYOTOKKIJIKO23 = "chosahyoTokkijiko23";
    private static final String CHOSAHYOTOKKIJIKO24 = "chosahyoTokkijiko24";
    private static final String TOKKIJIKOOCR41 = "tokkijikoOCR41";
    private static final String TOKKIJIKOOCR42 = "tokkijikoOCR42";
    private static final String TOKKIJIKOOCR43 = "tokkijikoOCR43";
    private static final String CHOSAHYOGAIKYOCHOSA01 = "chosahyoGaikyochosa01";
    private static final String CHOSAHYOGAIKYOCHOSA11 = "chosahyoGaikyochosa11";
    private static final String SAICHEKKUHYO1 = "SaiChekkuhyo1";
    private static final String SAICHEKKUHYO2 = "SaiChekkuhyo2";
    private static final String SAICHEKKUHYO3 = "SaiChekkuhyo3";
    private static final String SAICHEKKUHYO4 = "SaiChekkuhyo4";
    private static final String CHOSAHYOSAICHECKHYO = "chosahyoSaiCheckhyo";

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
        if (DBE221002.equals(rseValue)) {
            executeStep(CHOSAHYOKIHONCHOSAKATAMEN);
        } else if (DBE221003.equals(rseValue)) {
            executeStep(CHOSAHYOKIHONCHOSARYOMEN);
        } else if (DBE221012.equals(rseValue)) {
            executeStep(CHOSAHYOKIHONCHOSA);
        } else if (DBE221021.equals(rseValue)) {
            executeStep(CHOSAHYOTOKKIJIKO21);
        } else if (DBE221022.equals(rseValue)) {
            executeStep(CHOSAHYOTOKKIJIKO22);
        } else if (DBE221023.equals(rseValue)) {
            executeStep(CHOSAHYOTOKKIJIKO23);
        } else if (DBE221024.equals(rseValue)) {
            executeStep(CHOSAHYOTOKKIJIKO24);
        } else if (DBE221041.equals(rseValue)) {
            executeStep(TOKKIJIKOOCR41);
        } else if (DBE221042.equals(rseValue)) {
            executeStep(TOKKIJIKOOCR42);
        } else if (DBE221043.equals(rseValue)) {
            executeStep(TOKKIJIKOOCR43);
        } else if (DBE221001.equals(rseValue)) {
            executeStep(CHOSAHYOGAIKYOCHOSA01);
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
     * 要介護認定調査票（基本調査）のDBE221002ReportProcessです。
     *
     * @return ChosahyoKihonchosaKatamenProcess
     */
    @Step(CHOSAHYOKIHONCHOSAKATAMEN)
    protected IBatchFlowCommand chosahyoKihonchosaKatamenProcess() {
        return loopBatch(ChosahyoKihonchosaKatamenProcess.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 要介護認定調査票（基本調査）のDBE221003ReportProcessです。
     *
     * @return ChosahyoKihonchosaRyomenProcess
     */
    @Step(CHOSAHYOKIHONCHOSARYOMEN)
    protected IBatchFlowCommand chosahyoKihonchosaRyomenProcess() {
        return loopBatch(ChosahyoKihonchosaRyomenProcess.class)
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
     * 要介護認定調査票（特記事項）のDBE221021ReportProcessです。
     *
     * @return ChosahyoTokkijiko_221021Process
     */
    @Step(CHOSAHYOTOKKIJIKO21)
    protected IBatchFlowCommand chosahyoTokkijiko21Process() {
        return loopBatch(ChosahyoTokkijiko_221021Process.class)
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
     * 要介護認定調査票（特記事項）のDBE2210223ReportProcessです。
     *
     * @return ChosahyoTokkijiko_221023Process
     */
    @Step(CHOSAHYOTOKKIJIKO23)
    protected IBatchFlowCommand chosahyoTokkijiko23Process() {
        return loopBatch(ChosahyoTokkijiko_221023Process.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 要介護認定調査票（特記事項）のDBE2210224ReportProcessです。
     *
     * @return ChosahyoTokkijiko_221024Process
     */
    @Step(CHOSAHYOTOKKIJIKO24)
    protected IBatchFlowCommand chosahyoTokkijiko24Process() {
        return loopBatch(ChosahyoTokkijiko_221024Process.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 要介護認定調査票（特記事項）のDBE221041ReportProcessです。
     *
     * @return TokkijikoOCR_221041Process
     */
    @Step(TOKKIJIKOOCR41)
    protected IBatchFlowCommand tokkijikoOCR41Process() {
        return loopBatch(TokkijikoOCR_221041Process.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 要介護認定調査票（特記事項）のDBE221042ReportProcessです。
     *
     * @return TokkijikoOCR_221042Process
     */
    @Step(TOKKIJIKOOCR42)
    protected IBatchFlowCommand tokkijikoOCR42Process() {
        return loopBatch(TokkijikoOCR_221042Process.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 要介護認定調査票（特記事項）のDBE221043ReportProcessです。
     *
     * @return TokkijikoOCR_221043Process
     */
    @Step(TOKKIJIKOOCR43)
    protected IBatchFlowCommand tokkijikoOCR43Process() {
        return loopBatch(TokkijikoOCR_221043Process.class)
                .arguments(getParameter().toHomonChosaIraishoProcessParamter()).define();
    }

    /**
     * 要介護認定調査票（概況調査）のDBE221001ReportProcessです。
     *
     * @return ChosahyoGaikyochosa_221001Process
     */
    @Step(CHOSAHYOGAIKYOCHOSA01)
    protected IBatchFlowCommand chosahyoGaikyochosa01Process() {
        return loopBatch(ChosahyoGaikyochosa_221001Process.class)
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
