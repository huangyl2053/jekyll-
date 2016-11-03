/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050022;

import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請データ有無確認（高額合算）です。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public class JigyoKogakuSinseiDataProcess extends BatchProcessBase<DbWT0510FurikomiMeisaiTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050021."
            + "IFurikomimeisaiFurikomiDataMapper.select申請データ有無確認情報");
    private static final RString 振込明細一時NAME = new RString("DbWT0510FurikomiMeisai");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 振込明細一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        振込明細一時tableWriter = new BatchEntityCreatedTempTableWriter(振込明細一時NAME, DbWT0510FurikomiMeisaiTempEntity.class);
    }

    @Override
    protected void process(DbWT0510FurikomiMeisaiTempEntity t) {
        t.setShinseiDataFlag(true);
        振込明細一時tableWriter.update(t);
    }
}
