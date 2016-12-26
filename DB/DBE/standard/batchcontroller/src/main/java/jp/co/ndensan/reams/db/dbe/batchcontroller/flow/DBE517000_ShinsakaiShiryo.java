/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.OutputJokenhyoFactoryProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai.ShinsakaiKaisaiYoteiJohoUpdateProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE517000.DBE517000_ShinsakaiShiryoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会資料一括作成のバッチ処理クラスです。
 *
 * @reamsid_L DBE-0150-220 linghuhang
 */
public class DBE517000_ShinsakaiShiryo extends BatchFlowBase<DBE517000_ShinsakaiShiryoParameter> {

    private static final String 事務局_審査会資料一括作成 = "DBE517001_ShinsakaiShiryoJImukyoku";
    private static final RString 事務局_審査会資料一括作成ID = new RString("DBE517001_ShinsakaiShiryoJImukyoku");
    private static final String 委員_審査会資料一括作成 = "DBE517002_ShinsakaiShiryoIin";
    private static final RString 委員_審査会資料一括作成ID = new RString("DBE517002_ShinsakaiShiryoIin");
    private static final String 審査会開催予定情報更新 = "kousin";
    private static final String 出力条件表出力 = "outputJokenhyoFactory";
    private static final RString 選択 = new RString("1");
    private Map<RString, RString> 出力帳票一覧Map = new HashMap<>();

    @Override
    protected void defineFlow() {
        boolean is資料作成済 = false;
        if (選択.equals(getParameter().getChohyoIin_taishoushaFalg())
                || 選択.equals(getParameter().getChohyoIin_tokkiJikouFalg())
                || 選択.equals(getParameter().getChohyoIin_itiziHanteiFalg())
                || 選択.equals(getParameter().getChohyoIin_tokkiJikouHanteiFalg())
                || 選択.equals(getParameter().getChohyoIin_ikenshoFalg())
                || 選択.equals(getParameter().getChohyoIin_sonotaSiryoFalg())
                || 選択.equals(getParameter().getChohyoIin_tuutishoFalg())
                || 選択.equals(getParameter().getChohyoIin_hanteiFalg())) {
            executeStep(委員_審査会資料一括作成);
            is資料作成済 = true;
        }
        if (選択.equals(getParameter().getChoyoJimu_taishoushaFalg())
                || 選択.equals(getParameter().getChoyoJimu_tokkiJikouFalg())
                || 選択.equals(getParameter().getChoyoJimu_itiziHanteiFalg())
                || 選択.equals(getParameter().getChoyoJimu_tokkiJikouHanteiFalg())
                || 選択.equals(getParameter().getChoyoJimu_ikenshoFalg())
                || 選択.equals(getParameter().getChoyoJimu_sonotaSiryoFalg())
                || 選択.equals(getParameter().getChoyoJimu_gaikyouTokkiFalg())
                || 選択.equals(getParameter().getChoyoJimu_hanteiFalg())
                || 選択.equals(getParameter().getChoyoJimu_gaikyouTokkiIranFalg())) {
            executeStep(事務局_審査会資料一括作成);
            is資料作成済 = true;
        }
        if (is資料作成済) {
            executeStep(審査会開催予定情報更新);
            executeStep(出力条件表出力);
        }
    }

    /**
     * 審査会資料一括作成（委員）バッチのです。
     *
     * @return IinShiryoShinsakaiFlow
     */
    @Step(委員_審査会資料一括作成)
    protected IBatchFlowCommand callIinShiryoShinsakaiFlow() {
        出力帳票一覧Map = new HashMap<>();
        return otherBatchFlow(委員_審査会資料一括作成ID, SubGyomuCode.DBE認定支援,
                getParameter().toDBE517002_ShinsakaiShiryoIinParameter(出力帳票一覧Map)).define();
    }

    /**
     * 審査会資料一括作成（事務局）バッチのです。
     *
     * @return JimuShiryoShinsakaiFlow
     */
    @Step(事務局_審査会資料一括作成)
    protected IBatchFlowCommand callJimuShiryoShinsakaiFlow() {
        Map<RString, RString> map = new HashMap<>();
        map.put(new RString(委員_審査会資料一括作成), new RString("出力帳票一覧"));
        出力帳票一覧Map.putAll(map);
        return otherBatchFlow(事務局_審査会資料一括作成ID, SubGyomuCode.DBE認定支援,
                getParameter().toDBE517001_ShinsakaiShiryoJImukyokuParameter(出力帳票一覧Map)).define();
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

    /**
     * 出力条件表の出力を行います。
     *
     * @return バッチコマンド
     */
    @Step(出力条件表出力)
    protected IBatchFlowCommand createOutputJokenhyoFactory() {
        Map<RString, RString> 帳票Map = getResult(Map.class, 事務局_審査会資料一括作成, new RString("出力帳票一覧"));
        return simpleBatch(OutputJokenhyoFactoryProcess.class)
                .arguments(getParameter().toOutputJokenhyoFactoryProcessParameter(帳票Map)).define();
    }
}
