/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuGaikyotokkiDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuGaikyotokkiSonotaJohoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuGaikyouTokkiIranDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuHanteiDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuIkenshoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuIkenshoDataSakuseiA42Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuIkenshoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuItiziHanteiDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuItiziHanteiDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuShinsakaiIinJohoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuShinsakaiIinJohoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuSonotaJohoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuSonotaJohoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuTokkiJikouDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuTokkiJikouDataSakuseiA42Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuTokkiJikouDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuTuikaSiryoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuTuikaSiryoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shiryoshinsakai.ShiryoShinsakaiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会資料一括作成（事務局）のバッチ処理クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuShiryoShinsakaiFlow extends BatchFlowBase<ShiryoShinsakaiBatchParameter> {

    private static final String 事務局_審査対象者一覧 = "jimuShinsakaiIinJoho";
    private static final String 事務局_追加資料鑑 = "jimuTuikaSiryo";
    private static final String 事務局_予備判定一覧 = "jimuHantei";
    private static final String 事務局_その他資料 = "jimuSonotaJoho";
    private static final String 事務局_主治医意見書 = "jimuIkensho";
    private static final String 事務局_概況特記一覧表 = "jimuGaikyouTokkiIran";
    private static final String 事務局_一次判定結果 = "jimuItiziHantei";
    private static final String 事務局_特記事項_一次判定結果 = "jimuTokkiJikouItiziHantei";
    private static final String 事務局_特記事項 = "jimuTokkiJikou";
    private static final String 事務局_概況特記 = "jimuTokkiIran";
    private static final RString 選択 = new RString("1");
    private static final RString 作成条件_追加分 = new RString("追加分");

    @Override
    protected void defineFlow() {
        if (選択.equals(getParameter().getChoyoJimu_taishoushaFalg())) {
            executeStep(事務局_審査対象者一覧);
        }
        if (選択.equals(getParameter().getChoyoJimu_hanteiFalg())) {
            executeStep(事務局_予備判定一覧);
        }
        if (選択.equals(getParameter().getChoyoJimu_sonotaSiryoFalg())) {
            executeStep(事務局_その他資料);
        }
        if (選択.equals(getParameter().getChoyoJimu_ikenshoFalg())) {
            executeStep(事務局_主治医意見書);
        }
        if (選択.equals(getParameter().getChoyoJimu_gaikyouTokkiIranFalg())) {
            executeStep(事務局_概況特記一覧表);
        }
        if (選択.equals(getParameter().getChoyoJimu_itiziHanteiFalg())) {
            executeStep(事務局_一次判定結果);
        }
        if (選択.equals(getParameter().getChoyoJimu_gaikyouTokkiFalg())) {
            executeStep(事務局_概況特記);
        }
        if (選択.equals(getParameter().getChoyoJimu_taishoushaFalg())) {
            executeStep(事務局_特記事項);
        }
        if (選択.equals(getParameter().getChoyoJimu_tokkiJikouHanteiFalg())) {
            executeStep(事務局_特記事項_一次判定結果);
        }
        if (作成条件_追加分.equals(getParameter().getSakuseiJoken())) {
            executeStep(事務局_追加資料鑑);
        }
    }

    /**
     * 事務局用介護認定審査対象者一覧データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_審査対象者一覧)
    protected IBatchFlowCommand createJimuShinsakaiIinJohoData() {
        if (選択.equals(getParameter().getShuturyokuSutairu())) {
            return loopBatch(JimuShinsakaiIinJohoDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
        } else {
            return loopBatch(JimuShinsakaiIinJohoDataSakuseiA3Process.class)
                    .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
        }
    }

    /**
     * 事務局介護認定追加資料鑑情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_追加資料鑑)
    protected IBatchFlowCommand createJimuTuikaSiryoData() {
        if (選択.equals(getParameter().getShuturyokuSutairu())) {
            return loopBatch(JimuTuikaSiryoDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
        } else {
            return loopBatch(JimuTuikaSiryoDataSakuseiA3Process.class)
                    .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
        }
    }

    /**
     * 事務局用予備判定一覧情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_予備判定一覧)
    protected IBatchFlowCommand createJimuHanteiData() {
        return loopBatch(JimuHanteiDataSakuseiA4Process.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
    }

    /**
     * その他資料情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_その他資料)
    protected IBatchFlowCommand createJimuSonotaJohoData() {
        if (選択.equals(getParameter().getShuturyokuSutairu())) {
            return loopBatch(JimuSonotaJohoDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
        } else {
            return loopBatch(JimuSonotaJohoDataSakuseiA3Process.class)
                    .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
        }
    }

    /**
     * 事務局用主治医意見書情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_主治医意見書)
    protected IBatchFlowCommand createJimuIkenshoData() {
        if (選択.equals(getParameter().getShuturyokuSutairu())) {
            loopBatch(JimuIkenshoDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
            return loopBatch(JimuIkenshoDataSakuseiA42Process.class)
                    .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
        } else {
            return loopBatch(JimuIkenshoDataSakuseiA3Process.class)
                    .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
        }
    }

    /**
     * 事務局用概況特記一覧表情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_概況特記一覧表)
    protected IBatchFlowCommand createJimuGaikyouTokkiIranData() {
        return loopBatch(JimuGaikyouTokkiIranDataSakuseiA4Process.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
    }

    /**
     * 事務局一次判定結果情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_一次判定結果)
    protected IBatchFlowCommand createJimuItiziHanteiData() {
        return loopBatch(JimuItiziHanteiDataSakuseiA4Process.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
    }

    /**
     * 事務局概況特記情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_概況特記)
    protected IBatchFlowCommand createJimuTokkiIranData() {
        loopBatch(JimuGaikyotokkiDataSakuseiA4Process.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        return loopBatch(JimuGaikyotokkiSonotaJohoDataSakuseiA4Process.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
    }

    /**
     * 事務局概況特記情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_特記事項_一次判定結果)
    protected IBatchFlowCommand createJimuTokkiJikouItiziHanteiData() {
        loopBatch(JimuItiziHanteiDataSakuseiA3Process.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
        return loopBatch(JimuTokkiJikouDataSakuseiA3Process.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
    }

    /**
     * 事務局用介護認定審査対象者一覧データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_特記事項)
    protected IBatchFlowCommand createJimuTokkiJikouData() {
        // TODO 特記事項A3の実装しない。　
//        if (選択.equals(getParameter().getShuturyokuSutairu())) {
        loopBatch(JimuTokkiJikouDataSakuseiA4Process.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
        return loopBatch(JimuTokkiJikouDataSakuseiA42Process.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
//        } else {
//            return loopBatch(JimuTokkiJikouDataSakuseiA32Process.class)
//                    .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
//        }
    }
}
