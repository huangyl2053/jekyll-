/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110910;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.setaiyin.SetaiYinEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 各住民の所得情報の取得の作成クラスです。
 *
 * @reamsid_L DBC-2770-060 jinjue
 */
public class SetaiinHaakuSubCProcess extends BatchProcessBase<SetaiYinEntity> {

    private static final RString 老齢福祉区分 = new RString("1");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.fuka.ISetaiShotokuKazeiHanteiMapper.select老齢福祉区分");
    private static final RString 世帯員所得情報一時 = new RString("SetaiYinShiyoTokuJyoHoTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 世帯員所得一時;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        世帯員所得一時 = new BatchEntityCreatedTempTableWriter(世帯員所得情報一時,
                SetaiYinEntity.class);
    }

    @Override
    protected void process(SetaiYinEntity entity) {
        entity.setRoureifukusikubun(老齢福祉区分);
        世帯員所得一時.update(entity);
    }
}
