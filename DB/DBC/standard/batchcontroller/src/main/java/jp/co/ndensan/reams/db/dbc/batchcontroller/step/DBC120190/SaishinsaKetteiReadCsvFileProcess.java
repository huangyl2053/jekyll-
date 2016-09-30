/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120190;

import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsaketteihokenshain.SaishinsaKetteiReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.service.core.saishinsaketteihokenshaincsvfileread.SaishinsaKetteiHokenshaInCsvFileRead;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * CSVファイル取込を実行する。
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaKetteiReadCsvFileProcess extends SimpleBatchProcessBase {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private SaishinsaKetteiReadCsvFileProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("returnEntity");
    }

    OutputParameter<FlowEntity> returnEntity;

    @Override
    protected void process() {
        SaishinsaKetteiHokenshaInCsvFileRead ファイル取得Manager = SaishinsaKetteiHokenshaInCsvFileRead.createInstance();
        FlowEntity entity = ファイル取得Manager.一時TBL作成と読込と登録(parameter.get処理年月(), parameter.get保存先フォルダ(),
                parameter.getエントリ情報List());
        returnEntity = new OutputParameter<>();
        returnEntity.setValue(entity);
    }

}
