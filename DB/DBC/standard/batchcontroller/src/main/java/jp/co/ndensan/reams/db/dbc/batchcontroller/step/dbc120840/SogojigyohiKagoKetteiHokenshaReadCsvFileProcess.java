/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120840;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kagoketteihokenshaincsvfileread.KagoKetteiHokenshaInCsvFileRead;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過誤決定通知書情報共通バッチ処理クラス．保険者分・ファイル読込を実行する
 *
 * @reamsid_L DBC-2550-011 jiangxiaolong
 */
public class SogojigyohiKagoKetteiHokenshaReadCsvFileProcess extends SimpleBatchProcessBase {

    /**
     * flowEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private KokuhorenkyotsuReadCsvFileProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    OutputParameter<FlowEntity> flowEntity;

    @Override
    protected void process() {
        KagoKetteiHokenshaInCsvFileRead ファイル読込Manager = KagoKetteiHokenshaInCsvFileRead.createInstance();
        FlowEntity entity = ファイル読込Manager.一時TBL作成と読込と登録(parameter.get処理年月(),
                parameter.get保存先フォルダ(), parameter.getエントリ情報List());
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(entity);
    }
}
