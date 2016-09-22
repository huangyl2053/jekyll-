/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.FurikomiDataTourokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.KozaFurikomiTempTableEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.kozafurikomi.kozafurikomi.KozaFurikomiManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込データ登録_口座振込一時処理_Processクラスです．
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
public class FurikomiDataTourokuProcess extends BatchProcessBase<KozaFurikomiTempTableEntity> {

    private static final RString 処理区分_振込指定日修正_2 = new RString("2");
    private static final RString 処理区分_明細一覧表作成_3 = new RString("3");

    private OutputParameter<Integer> outputCount;
    private FurikomiDataTourokuProcessParameter parameter;
    public static final RString PARAMETER_OUT_COUNT;

    private int count = 0;
    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.dbc050010.IFurikomiDataTourokuMapper.select口座振込一時情報");

    static {
        PARAMETER_OUT_COUNT = new RString("outputCount");
    }

    @Override
    protected void beforeExecute() {
        if (!処理区分_明細一覧表作成_3.equals(parameter.get処理区分())) {
            if (処理区分_振込指定日修正_2.equals(parameter.get処理区分())) {
                if (!parameter.is再処理フラグ()) {
                    KozaFurikomiManager manager = new KozaFurikomiManager();

                    // KozaFurikomiManager.createInstance().;
                    // TODO 5.1　再処理準備
                }
            }
        }
    }

    @Override
    protected void initialize() {
        outputCount = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(KozaFurikomiTempTableEntity t) {
        count++;
    }

    @Override
    protected void afterExecute() {
        outputCount.setValue(count);
    }
}
