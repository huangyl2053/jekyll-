/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinHanteiDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinHanteiDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinIkenshoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinIkenshoDataSakuseiA4NihirameProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinIkenshoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinItiziHanteiDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinShinsakaiIinJohoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinShinsakaiIinJohoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinSonotaJohoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinTokkiIranDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinTokkiIranDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinTokkiJikouDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinTokkiJikouDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinTokkiJikouItiziHanteiDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinTokkiJikouItiziHanteiDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinTuikaSiryoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinTuikaSiryoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinTuutishoDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.ShinsakaiKaisaiYoteiJohoUpdateProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.SonotaJohoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.SonotaJohoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shiryoshinsakai.ShiryoShinsakaiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会資料一括作成（委員）のバッチ処理クラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class ShiryoShinsakaiFlow extends BatchFlowBase<ShiryoShinsakaiBatchParameter> {

    private static final String 委員_審査会開催通知書 = "iinTuutisho";
    private static final String 委員_特記事項 = "iinTokkiJikou";
    private static final String 委員_一次判定結果 = "iinItiziHantei";
    private static final String 委員_特記事項_一次判定結果 = "iinTokkiJikouItiziHantei";
    private static final String 委員_主治医意見書 = "iinIkensho";
    private static final String 委員_予備判定一覧 = "iinHantei";
    private static final String 委員_審査対象者一覧 = "iinShinsakaiIinJoho";
    private static final String 委員_追加資料鑑 = "iinTuikaSiryo";
    private static final String 委員_概況特記 = "iinTokkiIran";
    private static final String 委員_その他資料 = "iinSonotaJoho";
    private static final String 審査会開催予定情報更新 = "kousin";
    private static final String JIMU_SHIRYOFLOW = "jimuShiryoShinsakaiFlow";
    private static final RString JIMU_SHIRYOFLOW_FLOWID = new RString("DBE517001_ShinsakaiShiryoJImukyoku");
    private static final RString 選択 = new RString("1");
    private static final RString 作成条件_範囲指定 = new RString("範囲指定");
    private static final RString 作成条件_追加分 = new RString("追加分");

    @Override
    protected void defineFlow() {
//        for (int i = 0; i < getParameter().getChohyoIinHusu().intValue(); i++) {
        if (選択.equals(getParameter().getChohyoIin_tuutishoFalg())
                && !作成条件_範囲指定.equals(getParameter().getSakuseiJoken())) {
            executeStep(委員_審査会開催通知書);
        }
//        // TODO 凌護行　QA回答まち、帳票仕様確認する、2016/07/10
//        if (選択.equals(getParameter().getChohyoIin_tokkiJikouFalg())) {
//            executeStep(委員_特記事項);
//        }
        if (選択.equals(getParameter().getChohyoIin_itiziHanteiFalg())
                && 選択.equals(getParameter().getShuturyokuSutairu())) {
            executeStep(委員_一次判定結果);
        }
//        // TODO 凌護行　QA回答まち、帳票仕様確認する、2016/07/10
//        if (選択.equals(getParameter().getChohyoIin_tokkiJikouHanteiFalg())) {
//            executeStep(委員_特記事項_一次判定結果);
//        }
        if (選択.equals(getParameter().getChohyoIin_ikenshoFalg())) {
            executeStep(委員_主治医意見書);
        }
        if (選択.equals(getParameter().getChohyoIin_hanteiFalg())) {
            executeStep(委員_予備判定一覧);
        }
        if ((選択.equals(getParameter().getChohyoIin_tokkiJikouFalg())
                && 選択.equals(getParameter().getChohyoIin_itiziHanteiFalg())
                && 選択.equals(getParameter().getChohyoIin_ikenshoFalg()))
                || (選択.equals(getParameter().getChohyoIin_tokkiJikouHanteiFalg())
                && 選択.equals(getParameter().getChohyoIin_ikenshoFalg()))
                && 作成条件_追加分.equals(getParameter().getSakuseiJoken())) {
            if (作成条件_追加分.equals(getParameter().getSakuseiJoken())) {
                executeStep(委員_追加資料鑑);
            } else {
                executeStep(委員_審査対象者一覧);
            }
        }
////        // TODO　凌護行　 QA回答まち、帳票にRSE記載が不正、2016/07/10
//////        executeStep(委員_概況特記);
        executeStep(委員_その他資料);
//        }
        executeStep(JIMU_SHIRYOFLOW);
        executeStep(審査会開催予定情報更新);
    }

    /**
     * 審査会開催のお知らせ一覧情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_審査会開催通知書)
    protected IBatchFlowCommand createIinTuutishoData() {
        return loopBatch(IinTuutishoDataSakuseiProcess.class)
                .arguments(getParameter().toIinTuutishoProcessParameter()).define();
    }

    /**
     * 委員用特記事項情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_特記事項)
    protected IBatchFlowCommand createIinTokkiJikouData() {
        if (選択.equals(getParameter().getShuturyokuSutairu())) {
            return loopBatch(IinTokkiJikouDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        } else {
            return loopBatch(IinTokkiJikouDataSakuseiA3Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        }
    }

    /**
     * 委員一次判定結果情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_一次判定結果)
    protected IBatchFlowCommand createIinItiziHanteiData() {
        return loopBatch(IinItiziHanteiDataSakuseiA4Process.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
    }

    /**
     * 委員用特記事項と一次判定結果票情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_特記事項_一次判定結果)
    protected IBatchFlowCommand createIinTokkiJikouItiziHanteiData() {
        if (選択.equals(getParameter().getShuturyokuSutairu())) {
            return loopBatch(IinTokkiJikouItiziHanteiDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        } else {
            return loopBatch(IinTokkiJikouItiziHanteiDataSakuseiA3Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();

        }
    }

    /**
     * 委員用主治医意見書情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_主治医意見書)
    protected IBatchFlowCommand createIinIkenshoData() {
        if (選択.equals(getParameter().getShuturyokuSutairu())) {
            loopBatch(IinIkenshoDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
            return loopBatch(IinIkenshoDataSakuseiA4NihirameProcess.class)
                    .arguments(getParameter().toIinIkenshoDataSakuseiProcessParameter()).define();
        } else {
            return loopBatch(IinIkenshoDataSakuseiA3Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        }
    }

    /**
     * 委員用予備判定一覧情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_予備判定一覧)
    protected IBatchFlowCommand createIinHanteiData() {
        if (選択.equals(getParameter().getShuturyokuSutairu())) {
            return loopBatch(IinHanteiDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        } else {
            return loopBatch(IinHanteiDataSakuseiA3Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        }
    }

    /**
     * 介護認定審査対象者一覧表情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_審査対象者一覧)
    protected IBatchFlowCommand createIinShinsakaiIinJohoData() {
        if (選択.equals(getParameter().getShuturyokuSutairu())) {
            return loopBatch(IinShinsakaiIinJohoDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
        } else {
            return loopBatch(IinShinsakaiIinJohoDataSakuseiA3Process.class)
                    .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
        }
    }

    /**
     * 介護認定追加資料鑑情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_追加資料鑑)
    protected IBatchFlowCommand createIinTuikaSiryoData() {
        if (選択.equals(getParameter().getShuturyokuSutairu())) {
            return loopBatch(IinTuikaSiryoDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinTuikaSiryoProcessParameter()).define();
        } else {
            return loopBatch(IinTuikaSiryoDataSakuseiA3Process.class)
                    .arguments(getParameter().toIinTuikaSiryoProcessParameter()).define();
        }
    }

    /**
     * 概況特記情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_概況特記)
    protected IBatchFlowCommand createIinTokkiIranData() {
        if (選択.equals(getParameter().getShuturyokuSutairu())) {
            return loopBatch(IinTokkiIranDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        } else {
            return loopBatch(IinTokkiIranDataSakuseiA3Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        }
    }

    /**
     * その他資料情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_その他資料)
    protected IBatchFlowCommand createSonotaJohoData() {
        if (選択.equals(getParameter().getShuturyokuSutairu())) {
            loopBatch(SonotaJohoDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
            return loopBatch(IinSonotaJohoDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        } else {
            return loopBatch(SonotaJohoDataSakuseiA3Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        }
    }

    /**
     * 介護認定審査会スケジュール表かがみバッチのです。
     *
     * @return JimuShiryoShinsakaiFlow
     */
    @Step(JIMU_SHIRYOFLOW)
    protected IBatchFlowCommand callJimuShiryoShinsakaiFlow() {
        return otherBatchFlow(JIMU_SHIRYOFLOW_FLOWID, SubGyomuCode.DBE認定支援, getParameter()).define();
    }

    /**
     * 審査会開催予定情報更新の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(審査会開催予定情報更新)
    protected IBatchFlowCommand createKosinData() {
        return loopBatch(ShinsakaiKaisaiYoteiJohoUpdateProcess.class)
                .arguments(getParameter().toIinItiziHanteiProcessParameter()).define();
    }
}
