/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.JushochitokureiInfoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例の情報の抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class UpdJutokuTempProcess extends BatchProcessBase<IdouTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select住所地特例");
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
        RString 全項目 = 住所地特例全項目(entity.get住所地特例());
        IdouTblEntity update = entity.get異動一時();
        update.set住所地特例(全項目);
        異動一時tableWriter.update(update);

    }

    private RString 住所地特例全項目(JushochitokureiInfoEntity 住所地特例) {
        RString 全項目 = RString.EMPTY;
        全項目 = concatDate(全項目, 住所地特例.get住所地特例適用開始日());
        全項目 = 全項目.concat(SPLIT);
        全項目 = concatDate(全項目, 住所地特例.get住所地特例適用終了日());
        全項目 = 全項目.concat(SPLIT);
        全項目 = 全項目.concat(住所地特例.get被保険者番号().getColumnValue());
        全項目 = 全項目.concat(SPLIT);
        if (住所地特例.get転出先保険者番号() != null) {
            全項目 = 全項目.concat(住所地特例.get転出先保険者番号().getColumnValue());
        } else {
            全項目 = 全項目.concat(RString.EMPTY);
        }
        return 全項目;
    }

    private RString concatDate(RString 全項目, FlexibleDate date) {
        if (date == null) {
            全項目 = 全項目.concat(RString.EMPTY);
        } else {
            全項目 = 全項目.concat(date.toString());
        }
        return 全項目;
    }
}
