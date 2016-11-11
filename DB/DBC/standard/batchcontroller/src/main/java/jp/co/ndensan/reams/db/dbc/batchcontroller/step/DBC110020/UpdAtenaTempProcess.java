/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.PSMInfoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名の情報の抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class UpdAtenaTempProcess extends BatchProcessBase<IdouTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select宛名情報");
    private static final RString 異動一時_TABLE_NAME = new RString("IdouTemp");

    private static final RString SPLIT = new RString(",");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        異動一時tableWriter
                = new BatchEntityCreatedTempTableWriter(異動一時_TABLE_NAME, IdouTblEntity.class);
    }

    @Override
    protected void process(IdouTempEntity entity) {
        RString 全項目 = 宛名情報全項目(entity.get宛名情報());
        IdouTblEntity update = entity.get異動一時();
        update.set宛名(全項目);
        異動一時tableWriter.update(update);
    }

    private RString 宛名情報全項目(PSMInfoEntity 宛名情報) {
        RString 全項目 = RString.EMPTY;
        全項目 = 全項目
                .concat(宛名情報.getカナ名称().getColumnValue()).concat(SPLIT)
                .concat(宛名情報.get名称().getColumnValue()).concat(SPLIT)
                .concat(宛名情報.get生年月日().toString()).concat(SPLIT)
                .concat(宛名情報.get性別());
        return 全項目;
    }
}
