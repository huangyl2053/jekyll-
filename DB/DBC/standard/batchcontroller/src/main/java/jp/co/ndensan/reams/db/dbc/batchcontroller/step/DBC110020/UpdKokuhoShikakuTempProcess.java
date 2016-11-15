/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7123KokuhoShikakuInfoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保資格の情報の抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class UpdKokuhoShikakuTempProcess extends BatchProcessBase<IdouTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select国保資格");
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

        RString 全項目 = 国保資格全項目(entity.get国保資格情報());
        IdouTblEntity update = entity.get異動一時();
        update.set国保資格情報(全項目);
        異動一時tableWriter.update(update);
    }

    private RString 国保資格全項目(DbT7123KokuhoShikakuInfoEntity 国保資格) {
        RString 全項目 = RString.EMPTY;
        全項目 = cancatRString(国保資格.getKokuhoHokenshaNo(), 全項目);
        全項目 = cancatRString(国保資格.getKokuhoHokenshoNo(), 全項目);
        全項目 = cancatRString(国保資格.getKokuhoKojinNo(), 全項目);
        全項目 = cancatRString(国保資格.getShikakuSoshitsuYMD(), 全項目);
        return 全項目;
    }

    private RString cancatRString(RString 項目, RString 全項目) {
        if (!RString.isNullOrEmpty(項目)) {
            return 全項目.concat(項目).concat(SPLIT);
        }
        return 全項目.concat(RString.EMPTY).concat(SPLIT);
    }
}
