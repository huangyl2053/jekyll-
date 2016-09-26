/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE233001.ShujiiIkenTokusokuTaishoshaIchiranhyoCsvProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE233001.ShujiiIkenTokusokujoHakkoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE233001.ShujiiIkenTokusokujoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE233001.ShujiiUpadteDataProcess;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001.DBE233001_IkenshoTokusokujyoParameter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001.ShujiiCsvProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001.ShujiiUpdateProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書督促状発行のバッチフロークラスです。
 *
 * @reamsid_L DBE-0060-040 zhangzhiming
 */
public class DBE233001_IkenshoTokusokujyo extends BatchFlowBase<DBE233001_IkenshoTokusokujyoParameter> {

    private static final String 主治医意見書督促状の作成 = "shujiiIkenTokusokujoHakkoReport";
    private static final String 主治医意見書督促対象者一覧表の作成 = "shujiiIkenTokusokuTaishoshaIchiranhyoReport";
    private static final String 主治医意見書督促対象者一覧表CSVの作成 = "shujiiIkenTokusokuTaishoshaIchiranhyoCsv";
    private static final String 主治医意見書作成依頼情報の更新 = "updateData";
    private static final String 主治医意見書督促状_選択された = "1";
    private static final String 主治医意見書督促対象者一覧表_選択された = "1";
    private static final String CSV出力_選択された = "1";

    @Override
    protected void defineFlow() {

        if (主治医意見書督促状_選択された.equals(getParameter().getTemp_主治医意見書督促状().toString())) {
            executeStep(主治医意見書督促状の作成);
        }
        if (主治医意見書督促対象者一覧表_選択された.equals(getParameter().getTemp_主治医意見書督促対象者一覧表().toString())) {
            executeStep(主治医意見書督促対象者一覧表の作成);
        }
        if (CSV出力_選択された.equals(getParameter().getTemp_CSV出力().toString())) {
            executeStep(主治医意見書督促対象者一覧表CSVの作成);
        }
        executeStep(主治医意見書作成依頼情報の更新);
    }

    /**
     * 主治医意見書督促状の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(主治医意見書督促状の作成)
    protected IBatchFlowCommand shujiiIkenTokusokujoHakkoReport() {
        return loopBatch(ShujiiIkenTokusokujoReportProcess.class)
                .arguments(getParameter().toShuturyokuJyoukenProcessParamter())
                .define();
    }

    /**
     * 主治医意見書督促対象者一覧表の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(主治医意見書督促対象者一覧表の作成)
    protected IBatchFlowCommand shujiiIkenTokusokuTaishoshaIchiranhyoReport() {
        return loopBatch(ShujiiIkenTokusokujoHakkoReportProcess.class)
                .arguments(getParameter().toShuturyokuJyoukenProcessParamter())
                .define();
    }

    /**
     * 主治医意見書督促対象者一覧表CSVの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(主治医意見書督促対象者一覧表CSVの作成)
    protected IBatchFlowCommand shujiiIkenTokusokuTaishoshaIchiranhyoCsv() {
        return loopBatch(ShujiiIkenTokusokuTaishoshaIchiranhyoCsvProcess.class)
                .arguments(createCsvParameter())
                .define();
    }

    /**
     * 主治医意見書作成依頼情報の更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(主治医意見書作成依頼情報の更新)
    protected IBatchFlowCommand updateData() {
        return loopBatch(ShujiiUpadteDataProcess.class)
                .arguments(createUpdateParameter())
                .define();
    }

    private ShujiiCsvProcessParameter createCsvParameter() {
        ShujiiCsvProcessParameter parameter = new ShujiiCsvProcessParameter();
        List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> itemList = new ArrayList<>();
        if (主治医意見書督促対象者一覧表_選択された.equals(getParameter().getTemp_主治医意見書督促対象者一覧表().toString())) {
            itemList = getResult(List.class, new RString(主治医意見書督促対象者一覧表の作成),
                    ShujiiIkenTokusokujoHakkoReportProcess.SHUJI_DATA_LIST);
        }
        parameter.setShujiiItemList(itemList);
        return parameter;
    }

    private ShujiiUpdateProcessParameter createUpdateParameter() {
        ShujiiUpdateProcessParameter updateProcessParameter = new ShujiiUpdateProcessParameter();
        List<RString> noList = new ArrayList<>();
        if (主治医意見書督促状_選択された.equals(getParameter().getTemp_主治医意見書督促状().toString())) {
            noList = getResult(List.class, new RString(主治医意見書督促状の作成),
                    ShujiiIkenTokusokujoReportProcess.OUT_SHINSEISHO_KANRINO_LIST);
        }
        if (主治医意見書督促対象者一覧表_選択された.equals(getParameter().getTemp_主治医意見書督促対象者一覧表().toString())) {
            noList = getResult(List.class, new RString(主治医意見書督促対象者一覧表の作成),
                    ShujiiIkenTokusokujoHakkoReportProcess.OUT_DATA_LIST);
        }
        updateProcessParameter.set申請書管理番号List(noList);
        updateProcessParameter.setTemp_督促日(new RString(getParameter().getTemp_督促日().toString()));
        updateProcessParameter.setTemp_督促メモ(new RString(String.valueOf(getParameter().getTemp_督促メモ())));
        updateProcessParameter.setTemp_督促方法(new RString(String.valueOf(getParameter().getTemp_督促方法())));

        return updateProcessParameter;
    }
}
