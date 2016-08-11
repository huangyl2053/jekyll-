/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuGaikyotokkiDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuGaikyotokkiSonotaJohoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuGaikyouTokkiIranDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuGaikyouTokkiIranDataSakuseiImgA4Process;
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
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuTokkiJikouDataSakuseiA42Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuTokkiJikouDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuTuikaSiryoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuTuikaSiryoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shiryoshinsakai.ShiryoShinsakaiBatchParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
    private static final String 事務局_主治医意見書_1枚目 = "jimuIkensho_1";
    private static final String 事務局_主治医意見書_2枚目以降 = "jimuIkensho_2";
    private static final String 事務局_主治医意見書_A3 = "jimuIkensho";
    private static final String 事務局_概況特記一覧表 = "jimuGaikyouTokkiIran";
    private static final String 事務局_一次判定結果 = "jimuItiziHantei";
    private static final String 事務局_特記事項_一次判定結果 = "jimuTokkiJikouItiziHantei";
    private static final String 事務局_特記事項 = "jimuTokkiJikou";
    private static final String 事務局_特記事項_2枚目以降 = "jimuTokkiJikou_2";
    private static final String 事務局_概況特記 = "jimuTokkiIran";
    private static final String 事務局_概況特記その他 = "jimuGaikyotokkiSonota";
    private static final RString 選択 = new RString("1");
    private static final RString テキスト = new RString("1");
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
            if (選択.equals(getParameter().getShuturyokuSutairu())) {
                executeStep(事務局_主治医意見書_1枚目);
                executeStep(事務局_主治医意見書_2枚目以降);
            } else {
                executeStep(事務局_主治医意見書_A3);
            }
        }
        if (選択.equals(getParameter().getChoyoJimu_gaikyouTokkiIranFalg())) {
            executeStep(事務局_概況特記一覧表);
        }
        if (選択.equals(getParameter().getChoyoJimu_itiziHanteiFalg())) {
            executeStep(事務局_一次判定結果);
        }
        if (選択.equals(getParameter().getChoyoJimu_gaikyouTokkiFalg())) {
            executeStep(事務局_概況特記);
            executeStep(事務局_概況特記その他);
        }
        if (選択.equals(getParameter().getChoyoJimu_tokkiJikouFalg())) {
            executeStep(事務局_特記事項);
            executeStep(事務局_特記事項_2枚目以降);
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
    @Step(事務局_主治医意見書_1枚目)
    protected IBatchFlowCommand createJimuIkenshoData_A4_1() {
        return loopBatch(JimuIkenshoDataSakuseiA4Process.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
    }

    /**
     * 事務局用主治医意見書情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_主治医意見書_2枚目以降)
    protected IBatchFlowCommand createJimuIkenshoData_A4_2() {
        // TODO　凌護行 主治医意見書2枚目の出力方法が不正です。　
        return loopBatch(JimuIkenshoDataSakuseiA42Process.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
    }

    /**
     * 事務局用主治医意見書情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_主治医意見書_A3)
    protected IBatchFlowCommand createJimuIkenshoData_A3() {
        return loopBatch(JimuIkenshoDataSakuseiA3Process.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
    }

    /**
     * 事務局用概況特記一覧表情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_概況特記一覧表)
    protected IBatchFlowCommand createJimuGaikyouTokkiIranData() {
        if (テキスト.equals(DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            return loopBatch(JimuGaikyouTokkiIranDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        } else {
            return loopBatch(JimuGaikyouTokkiIranDataSakuseiImgA4Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        }
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
        return loopBatch(JimuGaikyotokkiDataSakuseiA4Process.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
    }

    /**
     * 事務局概況特記情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_概況特記その他)
    protected IBatchFlowCommand createJimuGaikyotokkiSonotaData() {
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
        return loopBatch(JimuItiziHanteiDataSakuseiA3Process.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
        // TODO　凌護行 特記事項2枚目の出力方法が不正です。実装ない。
//         loopBatch(JimuTokkiJikouDataSakuseiA3Process.class)
//                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
    }

    /**
     * 事務局用介護認定審査対象者一覧データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_特記事項)
    protected IBatchFlowCommand createJimuTokkiJikouData() {
        return loopBatch(JimuTokkiJikouDataSakuseiA4Process.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
    }

    /**
     * 事務局用介護認定審査対象者一覧データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事務局_特記事項_2枚目以降)
    protected IBatchFlowCommand createJimuTokkiJikouNiData() {
        // TODO　凌護行 特記事項2枚目の出力方法が不正です。　　
        return loopBatch(JimuTokkiJikouDataSakuseiA42Process.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
    }
}
