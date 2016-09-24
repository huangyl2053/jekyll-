/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiDataSakusei_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.EraTourokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者・宛名情報_振込明細一時データをエラー登録する。
 *
 * @reamsid_L DBC-2830-030 donghj
 */
public class EraTourokuProcess extends BatchProcessBase<EraTourokuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.dbc050010.IEraTourokuMapper.エラー登録");

    @BatchWriter
    BatchEntityCreatedTempTableWriter shoriKekkaKakuninListTempTable;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        shoriKekkaKakuninListTempTable = new BatchEntityCreatedTempTableWriter(ShoriKekkaKakuninListTempTableEntity.TABLE_NAME,
                ShoriKekkaKakuninListTempTableEntity.class);
    }

    @Override
    protected void process(EraTourokuEntity entity) {
        ShoriKekkaKakuninListTempTableEntity tempTableEntity = new ShoriKekkaKakuninListTempTableEntity();
        tempTableEntity.setErrorKubun(FurikomiDataSakusei_ErrorKubun.被保険者宛名情報取得.getコード());
        if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()) {
            tempTableEntity.setHiHokenshaNo(entity.get被保険者番号());
        }

        shoriKekkaKakuninListTempTable.insert(tempTableEntity);
    }

}
