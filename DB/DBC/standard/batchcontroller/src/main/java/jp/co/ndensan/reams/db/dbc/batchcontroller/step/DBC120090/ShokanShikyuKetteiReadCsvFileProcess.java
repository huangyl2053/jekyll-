/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120090;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukyufuketteiin.KogakuKyufuKetteiReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanshikyuketteiin.ShokanShikyuKetteiJohoManager;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給決定情報取込・ファイル読込を実行する。
 *
 * @reamsid_L DBC-0980-330 gongliang
 */
public class ShokanShikyuKetteiReadCsvFileProcess extends SimpleBatchProcessBase {

    //パラメータ名
    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private KogakuKyufuKetteiReadCsvFileProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    OutputParameter<FlowEntity> flowEntity;

    @Override
    protected void process() {
        ShokanShikyuKetteiJohoManager ファイル読込Manager = ShokanShikyuKetteiJohoManager.createInstance();
        FlowEntity flow = ファイル読込Manager.一時TBL作成と読込と登録(parameter.get処理年月(),
                parameter.get保存先フォルダ(), parameter.getエントリ情報List());
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(flow);
    }

}
