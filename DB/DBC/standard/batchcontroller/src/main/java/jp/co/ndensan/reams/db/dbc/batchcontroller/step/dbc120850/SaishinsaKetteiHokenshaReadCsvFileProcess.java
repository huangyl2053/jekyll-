/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120850;

import jp.co.ndensan.reams.db.dbc.definition.processprm.sogojigyohisaishinsaketteihokenshain.SaishinsaKetteiHokenshaReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.service.core.saishinsaketteihokenshaincsvfileread.SaishinsaKetteiHokenshaInCsvFileRead;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査決定通知書情報取込共通処理（保険者分・ファイル読込）を実行する
 *
 * @reamsid_L DBC-4680-030 wangxue
 */
public class SaishinsaKetteiHokenshaReadCsvFileProcess extends SimpleBatchProcessBase {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private SaishinsaKetteiHokenshaReadCsvFileProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }
    OutputParameter<FlowEntity> flowEntity;

    @Override
    protected void process() {

        SaishinsaKetteiHokenshaInCsvFileRead ファイル読込Manager = SaishinsaKetteiHokenshaInCsvFileRead.createInstance();
        FlowEntity entity = ファイル読込Manager.一時TBL作成と読込と登録(parameter.get処理年月(),
                parameter.get保存先フォルダ(), parameter.getエントリ情報List());
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(entity);
    }

}
