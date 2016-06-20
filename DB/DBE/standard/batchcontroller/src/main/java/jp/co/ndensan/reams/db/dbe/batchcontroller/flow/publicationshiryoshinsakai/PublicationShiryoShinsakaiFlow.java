/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.publicationshiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai.IinHanteiDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai.IinIkenshoDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai.IinItiziHanteiDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai.IinShinsakaiIinJohoDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai.IinTokkiIranDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai.IinTokkiJikouDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai.IinTokkiJikouItiziHanteiDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai.IinTuikaSiryoDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai.IinTuutishoDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai.SonotaJohoDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.publicationshiryoshinsakai.PublicationShiryoShinsakaiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会資料一括作成（委員）のバッチ処理クラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class PublicationShiryoShinsakaiFlow extends BatchFlowBase<PublicationShiryoShinsakaiBatchParameter> {

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
    private static final RString 選択 = new RString("1");
    private static final RString 作成条件_範囲指定 = new RString("範囲指定");
    private static final RString 作成条件_追加分 = new RString("追加分");

    @Override
    protected void defineFlow() {
        if (選択.equals(getParameter().getChohyoIin_tuutishoFalg())
                && !作成条件_範囲指定.equals(getParameter().getSakuseiJoken())) {
            executeStep(委員_審査会開催通知書);
        }
        if (選択.equals(getParameter().getChohyoIin_tokkiJikouFalg())) {
            executeStep(委員_特記事項);
        }
        if (選択.equals(getParameter().getChohyoIin_itiziHanteiFalg())) {
            executeStep(委員_一次判定結果);
        }
        if (選択.equals(getParameter().getChohyoIin_tokkiJikouHanteiFalg())) {
            executeStep(委員_特記事項_一次判定結果);
        }
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
                && 選択.equals(getParameter().getChohyoIin_ikenshoFalg()))) {
            if (!作成条件_追加分.equals(getParameter().getSakuseiJoken())) {
                executeStep(委員_審査対象者一覧);
            } else {
                executeStep(委員_追加資料鑑);
            }
        }
        executeStep(委員_概況特記);
        executeStep(委員_その他資料);
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
        return loopBatch(IinTokkiJikouDataSakuseiProcess.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
    }

    /**
     * 委員一次判定結果情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_一次判定結果)
    protected IBatchFlowCommand createIinItiziHanteiData() {
        return loopBatch(IinItiziHanteiDataSakuseiProcess.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
    }

    /**
     * 委員用特記事項と一次判定結果票情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_特記事項_一次判定結果)
    protected IBatchFlowCommand createIinTokkiJikouItiziHanteiData() {
        return loopBatch(IinTokkiJikouItiziHanteiDataSakuseiProcess.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
    }

    /**
     * 委員用主治医意見書情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_主治医意見書)
    protected IBatchFlowCommand createIinIkenshoData() {
        return loopBatch(IinIkenshoDataSakuseiProcess.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
    }

    /**
     * 委員用予備判定一覧情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_予備判定一覧)
    protected IBatchFlowCommand createIinHanteiData() {
        return loopBatch(IinHanteiDataSakuseiProcess.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
    }

    /**
     * 介護認定審査対象者一覧表情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_審査対象者一覧)
    protected IBatchFlowCommand createIinShinsakaiIinJohoData() {
        return loopBatch(IinShinsakaiIinJohoDataSakuseiProcess.class)
                .arguments(getParameter().toIinShinsakaiIinJohoProcessParameter()).define();
    }

    /**
     * 介護認定追加資料鑑情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_追加資料鑑)
    protected IBatchFlowCommand createIinTuikaSiryoData() {
        return loopBatch(IinTuikaSiryoDataSakuseiProcess.class)
                .arguments(getParameter().toIinTuikaSiryoProcessParameter()).define();
    }

    /**
     * 概況特記情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_概況特記)
    protected IBatchFlowCommand createIinTokkiIranData() {
        return loopBatch(IinTokkiIranDataSakuseiProcess.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
    }

    /**
     * その他資料情報データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(委員_その他資料)
    protected IBatchFlowCommand createSonotaJohoData() {
        return loopBatch(SonotaJohoDataSakuseiProcess.class)
                .arguments(getParameter().toIinTokkiJikouItiziHanteiProcessParameter()).define();
    }
}
