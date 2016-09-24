/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.DbWT3470ServiceMeisaichukanTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.JigyoshoNameEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 介護事業者情報取得Processクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
public class JigyoshoNameProcess
        extends BatchProcessBase<JigyoshoNameEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecodetanimeisaiichiran."
                    + "IServicecodeTaniMeisaiIchiranMapper.get介護事業者情報");
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
    protected void process(JigyoshoNameEntity entity) {
        DbWT3470ServiceMeisaichukanTempEntity tempEntity = entity.getサービス明細();
        if (entity.get介護事業者() != null) {
            tempEntity.setJigyoshoName(getColumnValue(entity.get介護事業者().getJigyoshaName()));
        }
        サービス明細中間一時tableWriter.update(tempEntity);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

}
