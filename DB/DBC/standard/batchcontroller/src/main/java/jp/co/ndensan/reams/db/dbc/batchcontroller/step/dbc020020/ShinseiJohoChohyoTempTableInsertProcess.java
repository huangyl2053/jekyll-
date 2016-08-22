/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 帳票出力用データの作成の処理クラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class ShinseiJohoChohyoTempTableInsertProcess extends BatchProcessBase<ShinseiJohoChohyoTempEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.get帳票出力用データ");
    private static final RString TABLE_NAME = new RString("ShinseiJohoChohyoTemp");

    private static final RString 申請書電話番号表示 = new RString("0");

    private KogakuKaigoServicehiOshiraseHakkoProcessParameter parameter;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShinseiJohoChohyoTempEntity.class);
    }

    @Override
    protected void process(ShinseiJohoChohyoTempEntity entity) {
        if (申請書電話番号表示.equals(parameter.getShinseishoTelNoHyoji())) {
            entity.setTelNoChohyo(null);
        }
        entity.setIninjoTeishutsusakiChohyo(parameter.getIninjoTeishutsusaki());
        entity.setState(EntityDataState.Added);
        tempDbWriter.insert(entity);
    }
}
