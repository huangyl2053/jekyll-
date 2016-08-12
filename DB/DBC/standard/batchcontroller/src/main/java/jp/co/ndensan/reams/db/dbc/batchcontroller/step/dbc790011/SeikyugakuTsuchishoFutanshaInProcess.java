/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc790011;

import jp.co.ndensan.reams.db.dbc.definition.processprm.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.FlowEntity;
import jp.co.ndensan.reams.db.dbc.service.core.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInManager;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 請求額通知書情報取込共通処理（CSVファイル取込・公費負担者分）processクラスです
 *
 * @reamsid_L DBC-2790-011 hemin
 */
public class SeikyugakuTsuchishoFutanshaInProcess extends SimpleBatchProcessBase {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private SeikyugakuTsuchishoFutanshaInProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    OutputParameter<FlowEntity> flowEntity;

    @Override
    protected void process() {
        SeikyugakuTsuchishoFutanshaInManager ファイル登録Manager = SeikyugakuTsuchishoFutanshaInManager.createInstance();
        FlowEntity entity = ファイル登録Manager.一時TBL作成と読込と登録(parameter.get保存先フォルダ(),
                parameter.getエントリ情報List());
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(entity);
    }

}
