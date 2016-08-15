/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120230;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.seikyugakutsuchisho.SeikyugakuTsuchishReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.service.core.dbc120230.SeikyugakuTsuchishoCsvFileManager;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費等請求額通知書情報取込・ファイル読込を実行する。
 *
 * @reamsid_L DBC-2480-010 jiangwenkai
 */
public class SeikyugakuTsuchishoReadCsvFileProcess extends SimpleBatchProcessBase {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private SeikyugakuTsuchishReadCsvFileProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    OutputParameter<FlowEntity> flowEntity;

    @Override
    protected void process() {
        SeikyugakuTsuchishoCsvFileManager ファイル読込Manager = SeikyugakuTsuchishoCsvFileManager.createInstance();
        FlowEntity flow = ファイル読込Manager.一時TBL作成と読込と登録(
                parameter.get保存先フォルダ(), parameter.getエントリ情報List());
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(flow);
    }

}
