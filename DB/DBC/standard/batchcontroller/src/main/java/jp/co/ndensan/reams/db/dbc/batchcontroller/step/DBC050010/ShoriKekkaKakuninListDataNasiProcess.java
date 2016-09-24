/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiDataSakusei_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理結果確認リスト一時_振込データなし_Process処理クラスです．
 *
 * @reamsid_L DBC-2180-030 x_lilh
 */
public class ShoriKekkaKakuninListDataNasiProcess extends BatchProcessBase<ShoriKekkaKakuninListTempTableEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010.IShoriKekkaKakuninListDataNasiMapper.select振込明細一時情報");

    private static final int 振込明細一時件数なし = 0;
    private int count = 0;
    private OutputParameter<Integer> outputCount;
    public static final RString PARAMETER_OUT_COUNT;

    static {
        PARAMETER_OUT_COUNT = new RString("outputCount");
    }

    @Override
    protected void initialize() {
        outputCount = new OutputParameter<>();
    }

    @BatchWriter
    BatchEntityCreatedTempTableWriter shoriKekkaKakuninListDataNasi;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        shoriKekkaKakuninListDataNasi
                = new BatchEntityCreatedTempTableWriter(ShoriKekkaKakuninListTempTableEntity.TABLE_NAME, ShoriKekkaKakuninListTempTableEntity.class);
    }

    @Override
    protected void process(ShoriKekkaKakuninListTempTableEntity t) {
        count++;
    }

    @Override
    protected void afterExecute() {
        outputCount.setValue(count);
        if (振込明細一時件数なし == count) {
            shoriKekkaKakuninListDataNasi.insert(create処理結果確認_振込データなし());
        }
    }

    private ShoriKekkaKakuninListTempTableEntity create処理結果確認_振込データなし() {
        ShoriKekkaKakuninListTempTableEntity data = new ShoriKekkaKakuninListTempTableEntity();
        data.setErrorKubun(FurikomiDataSakusei_ErrorKubun.振込データなし.getコード());
        return data;
    }
}
