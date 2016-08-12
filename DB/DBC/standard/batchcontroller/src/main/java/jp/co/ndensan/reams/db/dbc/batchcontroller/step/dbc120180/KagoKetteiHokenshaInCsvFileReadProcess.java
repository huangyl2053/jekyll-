/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120180;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kagoketteihokenshaincsvfileread.KagoKetteiHokenshaInCsvFileRead;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費（経過措置）過誤決定通知書情報取込のCSVファイル読取
 *
 * @reamsid_L DBC-2550-010 fzou
 */
public class KagoKetteiHokenshaInCsvFileReadProcess extends SimpleBatchProcessBase {

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
        KagoKetteiHokenshaInCsvFileRead ファイル読込Manager = KagoKetteiHokenshaInCsvFileRead.createInstance();
        FlowEntity entity = ファイル読込Manager.一時TBL作成と読込と登録(
                parameter.get処理年月(),
                parameter.get保存先フォルダ(), parameter.getエントリ情報List());
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(entity);
    }

}
