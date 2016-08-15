/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120890;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.service.core.dbc120230.SeikyugakuTsuchishoCsvFileManager;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費等請求額通知書情報取込のCSVファイル読取
 *
 * @reamsid_L DBC-2480-012 sunqingzhu
 */
public class SogojigyohiSeikyugakuTsuchishoInReadCsvFileProcess extends SimpleBatchProcessBase {

    /**
     * CSVファイル取込後の返したエンティティ
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private KohifutanshaReadCsvFileProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    OutputParameter<FlowEntity> flowEntity;

    @Override
    protected void process() {
        SeikyugakuTsuchishoCsvFileManager ファイル読込Manager = SeikyugakuTsuchishoCsvFileManager.createInstance();
        FlowEntity entity = ファイル読込Manager.一時TBL作成と読込と登録(
                parameter.get保存先フォルダ(), parameter.getエントリ情報List());
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(entity);
    }
}
