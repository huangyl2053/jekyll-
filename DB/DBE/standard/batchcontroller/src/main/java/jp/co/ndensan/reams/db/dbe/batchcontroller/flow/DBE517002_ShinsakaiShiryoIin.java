/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinHanteiDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinIkenshoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinIkenshoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinItiziHanteiDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinShinsakaiIinJohoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinShinsakaiIinJohoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinShinsakaiSiryouKumiawaseA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinShinsakaiSiryouKumiawaseA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinSonotaJohoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinSonotaJohoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinTokkiJikouDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinTokkiJikouItiziHanteiDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinTuikaSiryoDataSakuseiA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinTuikaSiryoDataSakuseiA4Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.IinTuutishoDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE517002.DBE517002_ShinsakaiShiryoIinParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会資料一括作成（委員）のバッチ処理クラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class DBE517002_ShinsakaiShiryoIin extends BatchFlowBase<DBE517002_ShinsakaiShiryoIinParameter> {

    private static final String 委員_審査会開催通知書 = "iinTuutisho";
    private static final String 委員_特記事項 = "iinTokkiJikou";
    private static final String 委員_一次判定結果 = "iinItiziHantei";
    private static final String 委員_主治医意見書_1枚目 = "iinIkensho_1";
    private static final String 委員_主治医意見書_A3 = "iinIkensho";
    private static final String 委員_予備判定一覧 = "iinHantei";
    private static final String 委員_審査対象者一覧 = "iinShinsakaiIinJoho";
    private static final String 委員_追加資料鑑 = "iinTuikaSiryo";
    private static final String 委員_その他資料 = "iinSonotaJoho";
    private static final String 委員_特記事項_一次判定結果 = "iinTokkiJikouItiziHantei";
    private static final String 審査会資料組み合わせ一覧A3版 = "審査会資料組み合わせ一覧A3版";
    private static final String 審査会資料組み合わせ一覧A4版 = "審査会資料組み合わせ一覧A4版";
    private static final RString 選択 = new RString("1");
    private static final RString 作成条件_追加分 = new RString("追加分");

    @Override
    protected void defineFlow() {
        if (選択.equals(getParameter().getChohyoIin_tuutishoFalg())) {
            executeStep(委員_審査会開催通知書);
        }
        if (選択.equals(getParameter().getChohyoIin_hanteiFalg())) {
            executeStep(委員_予備判定一覧);
        }
        if ((選択.equals(getParameter().getChohyoIin_taishoushaFalg())
                && 選択.equals(getParameter().getChohyoIin_itiziHanteiFalg())
                && 選択.equals(getParameter().getChohyoIin_tokkiJikouFalg())
                && 選択.equals(getParameter().getChohyoIin_ikenshoFalg())
                && 選択.equals(getParameter().getChohyoIin_sonotaSiryoFalg()))
                || (選択.equals(getParameter().getChohyoIin_taishoushaFalg())
                && 選択.equals(getParameter().getChohyoIin_tokkiJikouHanteiFalg())
                && 選択.equals(getParameter().getChohyoIin_ikenshoFalg())
                && 選択.equals(getParameter().getChohyoIin_sonotaSiryoFalg()))) {
            if (選択.equals(getParameter().getShuturyokuSutairu())) {
                executeStep(審査会資料組み合わせ一覧A4版);
            } else {
                executeStep(審査会資料組み合わせ一覧A3版);
            }
        } else {
            if (選択.equals(getParameter().getChohyoIin_tokkiJikouHanteiFalg())) {
                executeStep(委員_特記事項_一次判定結果);
            }
            if (選択.equals(getParameter().getChohyoIin_taishoushaFalg())) {
                executeStep(委員_審査対象者一覧);
            }
            if (選択.equals(getParameter().getChohyoIin_tokkiJikouFalg())) {
                executeStep(委員_特記事項);
            }
            if (選択.equals(getParameter().getChohyoIin_itiziHanteiFalg())) {
                executeStep(委員_一次判定結果);
            }
            if (選択.equals(getParameter().getChohyoIin_sonotaSiryoFalg())) {
                executeStep(委員_その他資料);
            }
            主治医意見書Flow();
            if (作成条件_追加分.equals(getParameter().getSakuseiJoken())) {
                executeStep(委員_追加資料鑑);
            }
        }
    }

    private void 主治医意見書Flow() {
        if (選択.equals(getParameter().getChohyoIin_ikenshoFalg())) {
            if (選択.equals(getParameter().getShuturyokuSutairu())) {
                executeStep(委員_主治医意見書_1枚目);
            } else {
                executeStep(委員_主治医意見書_A3);
            }
        }
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
        return loopBatch(IinTokkiJikouDataSakuseiA4Process.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
    }

    /**
     * 委員特記事項+一次判定結果情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_特記事項_一次判定結果)
    protected IBatchFlowCommand createIinTokkiJikouItiziHanteiData() {
        return loopBatch(IinTokkiJikouItiziHanteiDataSakuseiA3Process.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
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
     * 委員用主治医意見書情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_主治医意見書_1枚目)
    protected IBatchFlowCommand createIinIkenshoData_A4_1() {
        return loopBatch(IinIkenshoDataSakuseiA4Process.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
    }

    /**
     * 委員用主治医意見書情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_主治医意見書_A3)
    protected IBatchFlowCommand createIinIkenshoData_A3() {
        return loopBatch(IinIkenshoDataSakuseiA3Process.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
    }

    /**
     * 委員用予備判定一覧情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_予備判定一覧)
    protected IBatchFlowCommand createIinHanteiData() {
        return loopBatch(IinHanteiDataSakuseiA4Process.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
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
                    .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
        } else {
            return loopBatch(IinTuikaSiryoDataSakuseiA3Process.class)
                    .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
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
            return loopBatch(IinSonotaJohoDataSakuseiA4Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        } else {
            return loopBatch(IinSonotaJohoDataSakuseiA3Process.class)
                    .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
        }
    }

    /**
     * 委員用審査会資料組み合わせ一覧A3版データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(審査会資料組み合わせ一覧A3版)
    protected IBatchFlowCommand createJimuShinsakaiSiryouKumiawaseA3() {
        return simpleBatch(IinShinsakaiSiryouKumiawaseA3Process.class)
                .arguments(getParameter().toShinsakaiSiryouKumiawaseA3ProcessParameter()).define();
    }

    /**
     * 委員用審査会資料組み合わせ一覧A4版データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(審査会資料組み合わせ一覧A4版)
    protected IBatchFlowCommand createJimuShinsakaiSiryouKumiawaseA4() {
        return simpleBatch(IinShinsakaiSiryouKumiawaseA4Process.class)
                .arguments(getParameter().toShinsakaiSiryouKumiawaseA3ProcessParameter()).define();
    }

}
