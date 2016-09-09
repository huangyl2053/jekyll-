/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110060;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenDataSaisoFlag;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110060.KogakugassanShikyushinseishoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給申請書情報作成のDB更新_送付済Process
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
public class KogakugassanShikyushinseishoOutUpdateShinseishoSofuProcess extends BatchProcessBase<DbT3068KogakuGassanShinseishoEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110060."
            + "IKogakugassanShikyushinseishoOutMapper.getDB更新の送付済データ");

    private KogakugassanShikyushinseishoOutProcessParameter parameter;
    @BatchWriter
    BatchPermanentTableWriter 高額合算申請書tableWriter;

    @Override
    protected void initialize() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void createWriter() {
        高額合算申請書tableWriter = new BatchPermanentTableWriter(DbT3068KogakuGassanShinseishoEntity.class);
    }

    @Override
    protected void process(DbT3068KogakuGassanShinseishoEntity entity) {
        entity.setShikyuShinseisho_SofuYM(parameter.get処理年月());
        entity.setSaiSofuFlag(KokuhorenDataSaisoFlag.再送不要.getコード());
        高額合算申請書tableWriter.update(entity);
    }

    @Override
    protected void afterExecute() {
    }
}
