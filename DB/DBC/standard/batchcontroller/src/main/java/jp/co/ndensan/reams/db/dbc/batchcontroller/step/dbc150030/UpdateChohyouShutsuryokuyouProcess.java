/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150030;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.ChohyouShutsuryokuyouTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470chohyouShutsuryokuyouTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力用一時TBLの取得処理Processクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
public class UpdateChohyouShutsuryokuyouProcess
        extends BatchProcessBase<ChohyouShutsuryokuyouTempEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecoderiyojokyo."
                    + "IServicecodeRiyojokyoMapper.update帳票出力用一時TBL");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 帳票出力用一時tableWriter;
    private static final RString 帳票出力用一時_TABLE_NAME = new RString("DbWT3470chohyouShutsuryokuyou");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        帳票出力用一時tableWriter = new BatchEntityCreatedTempTableWriter(
                帳票出力用一時_TABLE_NAME, DbWT3470chohyouShutsuryokuyouTempEntity.class);
    }

    @Override
    protected void process(ChohyouShutsuryokuyouTempEntity entity) {

        DbWT3470chohyouShutsuryokuyouTempEntity tempEntity = entity.get帳票出力();
        tempEntity.setServiceRyakushou(entity.getサービス名称());
        帳票出力用一時tableWriter.update(tempEntity);
    }

}
