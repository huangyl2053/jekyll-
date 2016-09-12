/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120200;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.service.core.saishinsaketteihokenshainkouhifutann.SaishinsaKetteiHokenshaInKouhiFutann;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査決定通知書情報共通バッチ処理クラス．保険者分・ファイル読込を実行する
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
public class SaishinsaKohifutanshaReadCsvFileProcess extends SimpleBatchProcessBase {

    /**
     * flowEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private KohifutanshaReadCsvFileProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    OutputParameter<FlowEntity> flowEntity;

    @Override
    protected void process() {
        SaishinsaKetteiHokenshaInKouhiFutann ファイル読込Manager = SaishinsaKetteiHokenshaInKouhiFutann.createInstance();
        FlowEntity entity = ファイル読込Manager.一時TBL作成と読込と登録(parameter.get処理年月(),
                parameter.get保存先フォルダ(), parameter.getエントリ情報List());
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(entity);
    }
}
