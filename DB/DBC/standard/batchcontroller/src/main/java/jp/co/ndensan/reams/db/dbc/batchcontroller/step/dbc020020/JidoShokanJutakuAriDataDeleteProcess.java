/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoShokanTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 自動償還、受託ありの申請情報償還一時のデータを削除する処理クラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class JidoShokanJutakuAriDataDeleteProcess extends BatchProcessBase<ShinseiJohoShokanTempEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.get自動償還For受託ありの申請情報償還一時");
    private static final RString TABLE_NAME = new RString("ShinseiJohoShokanTemp");

    private KogakuKaigoServicehiOshiraseHakkoProcessParameter parameter;
    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShinseiJohoShokanTempEntity.class);
    }

    @Override
    protected void process(ShinseiJohoShokanTempEntity entity) {
        entity.setState(EntityDataState.Deleted);
        tempDbWriter.delete(entity);
    }
}
