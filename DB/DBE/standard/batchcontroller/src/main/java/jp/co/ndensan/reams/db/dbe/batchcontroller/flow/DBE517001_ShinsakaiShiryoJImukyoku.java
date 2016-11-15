/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuGaikyotokkiDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuGaikyotokkiSonotaJohoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuGaikyouTokkiIranDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuGaikyouTokkiIranDataSakuseiImgA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuHanteiDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuIkenshoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuIkenshoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuItiziHanteiDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuItiziHanteiDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuShinsakaiIinJohoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuShinsakaiIinJohoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuShinsakaiSiryouKumiawaseA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuShinsakaiSiryouKumiawaseA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuSonotaJohoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuSonotaJohoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuTokkiJikouDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuTuikaSiryoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.JimuTuikaSiryoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE517001.DBE517001_ShinsakaiShiryoJImukyokuParameter;
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
public class DBE517001_ShinsakaiShiryoJImukyoku extends BatchFlowBase<DBE517001_ShinsakaiShiryoJImukyokuParameter> {

    private static final String 事務局_審査対象者一覧 = "jimuShinsakaiIinJoho";
    private static final String 事務局_追加資料鑑 = "jimuTuikaSiryo";
    private static final String 事務局_予備判定一覧 = "jimuHantei";
    private static final String 事務局_その他資料 = "jimuSonotaJoho";
    private static final String 事務局_主治医意見書_1枚目 = "jimuIkensho_1";
    private static final String 事務局_主治医意見書_A3 = "jimuIkensho";
    private static final String 事務局_概況特記一覧表 = "jimuGaikyouTokkiIran";
    private static final String 事務局_一次判定結果 = "jimuItiziHantei";
    private static final String 事務局_特記事項_一次判定結果 = "jimuTokkiJikouItiziHantei";
    private static final String 事務局_特記事項 = "jimuTokkiJikou";
    private static final String 事務局_概況特記 = "jimuTokkiIran";
    private static final String 事務局_概況特記その他 = "jimuGaikyotokkiSonota";
    private static final String 審査会資料組み合わせ一覧A4版 = "審査会資料組み合わせ一覧A4版";
    private static final String 審査会資料組み合わせ一覧A3版 = "審査会資料組み合わせ一覧A3版";
    private static final RString 選択 = new RString("1");
    private static final RString テキスト = new RString("1");
    private static final RString 作成条件_追加分 = new RString("追加分");

    @Override
    protected void defineFlow() {
        if (選択.equals(getParameter().getChoyoJimu_hanteiFalg())) {
            executeStep(事務局_予備判定一覧);
        }
        if (選択.equals(getParameter().getChoyoJimu_gaikyouTokkiFalg())) {
            executeStep(事務局_概況特記);
            executeStep(事務局_概況特記その他);
        }
        if (選択.equals(getParameter().getChoyoJimu_gaikyouTokkiIranFalg())) {
            executeStep(事務局_概況特記一覧表);
        }
        if (作成条件_追加分.equals(getParameter().getSakuseiJoken())) {
            executeStep(事務局_追加資料鑑);
        }
        if ((選択.equals(getParameter().getChoyoJimu_taishoushaFalg())
                && 選択.equals(getParameter().getChoyoJimu_itiziHanteiFalg())
                && 選択.equals(getParameter().getChoyoJimu_tokkiJikouFalg())
                && 選択.equals(getParameter().getChoyoJimu_ikenshoFalg())
                && 選択.equals(getParameter().getChoyoJimu_sonotaSiryoFalg()))
                || (選択.equals(getParameter().getChoyoJimu_taishoushaFalg())
                && 選択.equals(getParameter().getChoyoJimu_tokkiJikouHanteiFalg())
                && 選択.equals(getParameter().getChoyoJimu_ikenshoFalg())
                && 選択.equals(getParameter().getChoyoJimu_sonotaSiryoFalg()))) {
            if (選択.equals(getParameter().getShuturyokuSutairu())) {
                executeStep(審査会資料組み合わせ一覧A4版);
            } else {
                executeStep(審査会資料組み合わせ一覧A3版);
            }
        } else {
            if (選択.equals(getParameter().getChoyoJimu_tokkiJikouHanteiFalg())) {
                executeStep(事務局_特記事項_一次判定結果);
            }
            if (選択.equals(getParameter().getChoyoJimu_taishoushaFalg())) {
                executeStep(事務局_審査対象者一覧);
            }
            if (選択.equals(getParameter().getChoyoJimu_itiziHanteiFalg())) {
                executeStep(事務局_一次判定結果);
            }
            if (選択.equals(getParameter().getChoyoJimu_tokkiJikouFalg())) {
                executeStep(事務局_特記事項);
            }
            主治医意見書Flow();
        }
    }

    private void 主治医意見書Flow() {
        if (選択.equals(getParameter().getChoyoJimu_ikenshoFalg())) {
            if (選択.equals(getParameter().getShuturyokuSutairu())) {
                executeStep(事務局_主治医意見書_1枚目);
            } else {
                executeStep(事務局_主治医意見書_A3);
            }
        }
        if (選択.equals(getParameter().getChoyoJimu_sonotaSiryoFalg())) {
            executeStep(事務局_その他資料);
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
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
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
     * 事務局用審査会資料組み合わせ一覧A4版データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(審査会資料組み合わせ一覧A4版)
    protected IBatchFlowCommand createJimuShinsakaiSiryouKumiawaseA4() {
        return simpleBatch(JimuShinsakaiSiryouKumiawaseA4Process.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
    }

    /**
     * 事務局用審査会資料組み合わせ一覧A3版データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(審査会資料組み合わせ一覧A3版)
    protected IBatchFlowCommand createJimuShinsakaiSiryouKumiawaseA3() {
        return simpleBatch(JimuShinsakaiSiryouKumiawaseA3Process.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
    }
}
