/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.ChosairairirekiIchiran_DBE220004Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.DbT5201UpdateProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.GaikyoTokki;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.IchiranhyoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.IraishoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaKatamenGaikyo;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaRyomen;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaKatamenKihon;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaSaiCheckhyoKatamen;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaSaiCheckhyoRyomenLeft;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaSaiCheckhyoRyomenRight;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaTokkiJiko;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaTokkiJikoChosagun;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaTokkiJikoFree;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001.NinteiChosaTokkiJikoUra;
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
    private final RDate 基準日 = RDate.getNowDate();
    private static final String DBT5201UPDATEPROCESS = "DbT5201UpdateProcess";
    private static final String CHOSAIRAISHOREPORT_PROCESS = "chosaIraishoReport_Process";
    private static final String ICHIRANHYOREPORT_PROCESS = "ichiranhyoReport_Process";
    private static final String 認定調査票_片面_概況調査 = "NinteiChosaKatamenGaikyoChosa";
    private static final String 認定調査票_片面_基本調査 = "NinteiChosaKatamenKihonChosa";
    private static final String 認定調査票_両面 = "NinteiChosaRyomen";
    private static final String 認定調査票_特記事項 = "NinteiChosaTokkiJiko";
    private static final String 認定調査票_特記事項_裏 = "NinteiChosaTokkiJiko_Ura";
    private static final String 概況特記 = "GaikyoTokki";
    private static final String 認定調査差異チェック表_片面 = "NinteiChosaSaiCheckhyoKatamen";
    private static final String 認定調査差異チェック表_両面右 = "NinteiChosaSaiCheckhyoRyomenRight";
    private static final String 認定調査差異チェック表_両面左 = "NinteiChosaSaiCheckhyoRyomenLeft";
    private static final String 認定調査票_特記事項_調査群 = "NinteiChosaTokkiJikoChosagun";
    private static final String 認定調査票_特記事項_フリータイプ = "NinteiChosaTokkiJikoKomokuFree";
    private static final String CHOSAIRAIRIREKIICHIRAN = "ChosairairirekiIchiran";

    @Override
    protected void defineFlow() {
        executeStep(DBT5201UPDATEPROCESS);
        if (getParameter().is認定調査依頼書()) {
            executeStep(CHOSAIRAISHOREPORT_PROCESS);
        }
        if (getParameter().is認定調査依頼一覧()) {
            executeStep(ICHIRANHYOREPORT_PROCESS);
        }
        if (getParameter().is認定調査票_概況調査() && getParameter().is認定調査票_基本調査()) {
            call概況基本片面();
        } else if (getParameter().is認定調査票_概況調査()) {
            executeStep(認定調査票_片面_概況調査);
        } else if (getParameter().is認定調査票_基本調査()) {
            executeStep(認定調査票_片面_基本調査);
        }
        if (getParameter().is認定調査票_概況基本()) {
            executeStep(認定調査票_両面);
        }
        if (getParameter().is認定調査票_特記事項()) {
            call認定調査票_特記事項();
        }
        if (getParameter().is認定調査票_概況特記()) {
            executeStep(概況特記);
        }
        if (getParameter().is認定調査差異チェック票()) {
            call認定調査差異チェック表();
        }
        if (getParameter().is特記事項_調査群()) {
            executeStep(認定調査票_特記事項_調査群);
        }
        if (getParameter().is特記事項_フリータイプ()) {
            executeStep(認定調査票_特記事項_フリータイプ);
        }
        if (getParameter().is認定調査依頼履歴一覧()) {
            executeStep(CHOSAIRAIRIREKIICHIRAN);
        }
    }

    private void call概況基本片面() {
        RString 帳票ID_表 = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_概況基本_帳票ID_表, RDate.getNowDate(), SubGyomuCode.DBE認定支援, getParameter().getShichosonCode());
        RString 帳票ID_裏 = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_概況基本_帳票ID_裏, RDate.getNowDate(), SubGyomuCode.DBE認定支援, getParameter().getShichosonCode());
        if (!帳票ID_表.equals(帳票ID_裏)) {
            executeStep(認定調査票_片面_概況調査);
            executeStep(認定調査票_片面_基本調査);
        } else {
            executeStep(認定調査票_両面);
        }
    }

    private void call認定調査差異チェック表() {
        RString 差異チェック票_印刷タイプ = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, 基準日, SubGyomuCode.DBE認定支援, getParameter().getShichosonCode());
        if (CONFIGVALUE1.equals(差異チェック票_印刷タイプ)) {
            executeStep(認定調査差異チェック表_片面);
        } else if (CONFIGVALUE3.equals(差異チェック票_印刷タイプ)) {
            executeStep(認定調査差異チェック表_両面左);
        } else if (CONFIGVALUE2.equals(差異チェック票_印刷タイプ)) {
            executeStep(認定調査差異チェック表_両面右);
        }
    }

    private void call認定調査票_特記事項() {
        RString 表_帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_特記事項_帳票ID_表, 基準日, SubGyomuCode.DBE認定支援, getParameter().getShichosonCode());
        RString 裏_帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_特記事項_帳票ID_裏, 基準日, SubGyomuCode.DBE認定支援, getParameter().getShichosonCode());
        executeStep(認定調査票_特記事項);
        if (!表_帳票ID.equals(裏_帳票ID)) {
            executeStep(認定調査票_特記事項_裏);
        }
    }

    /**
     * テーブル「DbT5201NinteichosaIraiJoho」の更新処理Processです。
     *
     * @return DbT5201UpdateProcess
     */
    @Step(DBT5201UPDATEPROCESS)
    protected IBatchFlowCommand callDbT5201UpdateProcess() {
        return loopBatch(DbT5201UpdateProcess.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

    /**
     * 認定調査依頼書のReportProcessです。
     *
     * @return IraishoReportProcess
     */
    @Step(CHOSAIRAISHOREPORT_PROCESS)
    protected IBatchFlowCommand iraishoReportProcess() {
        return loopBatch(IraishoReportProcess.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

    /**
     * 認定調査依頼一覧表のProcessです。
     *
     * @return IraishoReportProcess
     */
    @Step(ICHIRANHYOREPORT_PROCESS)
    protected IBatchFlowCommand ichiranhyoReportProcess() {
        return loopBatch(IchiranhyoReportProcess.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

    /**
     * 認定調査票_デザイン用紙_片面のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_片面_概況調査)
    protected IBatchFlowCommand ninteiChosaKatamenGaikyoProcess() {
        return loopBatch(NinteiChosaKatamenGaikyo.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

    /**
     * 認定調査票_OCR_片面のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_片面_基本調査)
    protected IBatchFlowCommand ninteiChosaOCRKatamenProcess() {
        return loopBatch(NinteiChosaKatamenKihon.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

    /**
     * 認定調査票_デザイン用紙_両面のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_両面)
    protected IBatchFlowCommand ninteiChosaDesignRyomenProcess() {
        return loopBatch(NinteiChosaRyomen.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

    /**
     * 認定調査票_特記事項のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_特記事項)
    protected IBatchFlowCommand ninteiChosaTokkiJikoProcess() {
        return loopBatch(NinteiChosaTokkiJiko.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

    /**
     * 認定調査票_特記事項のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_特記事項_裏)
    protected IBatchFlowCommand ninteiChosaTokkiJikoUraProcess() {
        return loopBatch(NinteiChosaTokkiJikoUra.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

    /**
     * 概況特記のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(概況特記)
    protected IBatchFlowCommand gaikyoTokkiProcess() {
        return loopBatch(GaikyoTokki.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

    /**
     * 認定調査差異チェック表_片面のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査差異チェック表_片面)
    protected IBatchFlowCommand ninteiChosaSaiCheckhyoKatamenuProcess() {
        return loopBatch(NinteiChosaSaiCheckhyoKatamen.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

    /**
     * 認定調査差異チェック表_両面右のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査差異チェック表_両面右)
    protected IBatchFlowCommand ninteiChosaSaiCheckhyoRyomenRightProcess() {
        return loopBatch(NinteiChosaSaiCheckhyoRyomenRight.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

    /**
     * 認定調査差異チェック表_両面左のReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査差異チェック表_両面左)
    protected IBatchFlowCommand ninteiChosaSaiCheckhyoRyomenLeftProcess() {
        return loopBatch(NinteiChosaSaiCheckhyoRyomenLeft.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

    /**
     * 認定調査票_特記事項_項目有りのReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_特記事項_調査群)
    protected IBatchFlowCommand ninteiChosaTokkiJikoKomokuAriProcess() {
        return loopBatch(NinteiChosaTokkiJikoChosagun.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

    /**
     * 認定調査票_特記事項_フリータイプのReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査票_特記事項_フリータイプ)
    protected IBatchFlowCommand ninteiChosaTokkiJikoKomokuFreeProcess() {
        return loopBatch(NinteiChosaTokkiJikoFree.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

    /**
     * DBE220004_認定調査依頼履歴一覧のProcessです。
     *
     * @return ChosairairirekiIchiran_DBE220004Process
     */
    @Step(CHOSAIRAIRIREKIICHIRAN)
    protected IBatchFlowCommand chosairairirekiIchiranProcess() {
        return loopBatch(ChosairairirekiIchiran_DBE220004Process.class)
                .arguments(getParameter().toNinteiChosaProcessParamter()).define();
    }

}
