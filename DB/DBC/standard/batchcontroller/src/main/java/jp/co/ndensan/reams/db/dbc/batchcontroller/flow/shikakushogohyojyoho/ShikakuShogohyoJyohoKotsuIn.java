/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.shikakushogohyojyoho;

import java.io.File;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.shikakushogohyojyoho.ShikakuShogohyoJyohoReadCsvFileProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shikakushogohyojyoho.ShikakuShogohyoJyohoKotsuInParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.shikakushogohyojyoho.ShikakuShogohyoJyohoReadCsvFileParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格照合表情報取込共通処理（CSVファイル取込）バッチフロー
 *
 * @reamsid_L DBC-2890-013 wangxue
 */
public class ShikakuShogohyoJyohoKotsuIn extends BatchFlowBase<ShikakuShogohyoJyohoKotsuInParameter> {

    private static final String CSVファイル取込 = "readCsvFile";
    private RString csvFullPath;
    private FlowEntity flowEntity;
    private boolean isLast = false;
    private int 登録件数 = 0;
    private int レコード件数合算 = 0;

    @Override
    protected void defineFlow() {

        int size = getParameter().getFileNameList().size();
        for (int i = 0; i < size; i++) {
            String filePath = getParameter().get保存先フォルダ() + File.separator
                    + getParameter().getFileNameList().get(i);
            File path = new File(filePath);
            csvFullPath = new RString(path.getPath());
            if (size == i + 1) {
                isLast = true;
            }
            executeStep(CSVファイル取込);
            flowEntity = getResult(FlowEntity.class, new RString(CSVファイル取込),
                    ShikakuShogohyoJyohoReadCsvFileProcess.PARAMETER_OUT_FLOWENTITY);
            if (null != flowEntity) {
                登録件数 = flowEntity.get明細データ登録件数();
                レコード件数合算 = flowEntity.getCodeNum();
            }
        }
    }

    /**
     * CSVファイル取込
     *
     * @return ShikakuShogohyoJyohoReadCsvFileProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand readCsvFile() {

        ShikakuShogohyoJyohoReadCsvFileParameter parameter = new ShikakuShogohyoJyohoReadCsvFileParameter();
        parameter.set連番(登録件数);
        parameter.set保存先フォルダ(csvFullPath);
        parameter.setLast(isLast);
        parameter.setCodeNum(レコード件数合算);
        parameter.setエントリ情報List(getParameter().getFileNameList());
        return loopBatch(ShikakuShogohyoJyohoReadCsvFileProcess.class).arguments(parameter).define();
    }

}
