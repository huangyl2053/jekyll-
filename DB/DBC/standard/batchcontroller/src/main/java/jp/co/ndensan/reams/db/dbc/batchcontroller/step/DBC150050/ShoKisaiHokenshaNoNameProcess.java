/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.DbWT3470ServiceMeisaichukanTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.ShoKisaiHokenshaNoNameEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 証記載保険者名取得Processクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
public class ShoKisaiHokenshaNoNameProcess
        extends BatchProcessBase<ShoKisaiHokenshaNoNameEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecodetanimeisaiichiran."
                    + "IServicecodeTaniMeisaiIchiranMapper.get証記載保険者名");
    @BatchWriter
    BatchEntityCreatedTempTableWriter サービス明細中間一時tableWriter;
    private static final RString サービス明細中間一時_TABLE_NAME = new RString("DbWT3470ServiceMeisaichukan");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        サービス明細中間一時tableWriter = new BatchEntityCreatedTempTableWriter(
                サービス明細中間一時_TABLE_NAME, DbWT3470ServiceMeisaichukanTempEntity.class);
    }

    @Override
    protected void process(ShoKisaiHokenshaNoNameEntity entity) {
        DbWT3470ServiceMeisaichukanTempEntity tempEntity = entity.getサービス明細();
        tempEntity.setShokisaiHokenshaName(entity.get証記載保険者().getShichosonMeisho());
        サービス明細中間一時tableWriter.update(tempEntity);
    }

}
