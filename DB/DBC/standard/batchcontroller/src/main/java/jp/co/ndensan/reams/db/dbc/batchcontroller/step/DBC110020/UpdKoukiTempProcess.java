/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 後期高齢者の情報の抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class UpdKoukiTempProcess extends BatchProcessBase<IdouTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select後期高齢者");
    private static final RString 異動一時_TABLE_NAME = new RString("IdouTemp");
    private static final RString SPLIT = new RString(",");
    private static final RString RST_TRUE = new RString("TRUE");
    private static final RString RST_FALSE = new RString("FALSE");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時tableWriter;

    @Override
    protected void initialize() {
        super.initialize();
    }

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
        RString 全項目 = 後期高齢者全項目(entity.get後期高齢者情報());
        IdouTblEntity update = entity.get異動一時();
        update.set後期高齢者情報(全項目);
        異動一時tableWriter.update(update);
    }

    private RString 後期高齢者全項目(DbT7124KokiKoreishaInfoEntity 後期高齢者) {
        RString 全項目 = RString.EMPTY;
        全項目 = 全項目
                .concat(後期高齢者.getInsertDantaiCd()).concat(SPLIT)
                .concat(後期高齢者.getIsDeleted() ? RST_TRUE : RST_FALSE).concat(SPLIT)
                .concat(後期高齢者.getTorokuKubun()).concat(SPLIT)
                .concat(後期高齢者.getShikibetsuCd().getColumnValue()).concat(SPLIT)
                .concat(後期高齢者.getRirekiNo()).concat(SPLIT)
                .concat(後期高齢者.getKokiHokenshaNoCity()).concat(SPLIT)
                .concat(後期高齢者.getKokiHokenshaNoKoiki()).concat(SPLIT)
                .concat(後期高齢者.getKokikoreiHihokenshaNo()).concat(SPLIT)
                .concat(後期高齢者.getShikakuShutokuJiyuCode()).concat(SPLIT)
                .concat(後期高齢者.getShikakuShutokuYMD()).concat(SPLIT)
                .concat(後期高齢者.getShikakuSoshitsuJiyuCode()).concat(SPLIT)
                .concat(後期高齢者.getShikakuSoshitsuYMD()).concat(SPLIT)
                .concat(後期高齢者.getHokenshaKaishiYMD()).concat(SPLIT)
                .concat(後期高齢者.getHokenshaShuryoYMD()).concat(SPLIT)
                .concat(後期高齢者.getKojinKubunCode()).concat(SPLIT)
                .concat(後期高齢者.getTorokuKubun());
        return 全項目;
    }
}
