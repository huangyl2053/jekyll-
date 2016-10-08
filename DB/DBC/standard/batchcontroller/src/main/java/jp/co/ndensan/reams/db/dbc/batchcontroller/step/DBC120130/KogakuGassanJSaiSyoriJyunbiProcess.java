/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120130;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120110.KogakuGassanJikofutangakuDoMasterTorokuParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120110.KogakuGassanJikofutangakuDoMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額証明書情報取込のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
public class KogakuGassanJSaiSyoriJyunbiProcess extends BatchProcessBase<DbT3070KogakuGassanJikoFutanGakuEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakugassanjikofutangaku.IKogakuGassanJSaiSyoriJyunbiMapper.do再処理準備");
    private KogakuGassanJikofutangakuDoMasterTorokuProcessParameter parameter;
    private KogakuGassanJikofutangakuDoMasterTorokuParameter dbParameter;

    @BatchWriter
    BatchPermanentTableWriter 高額合算自己負担額TBLWriter;

    @Override
    protected void initialize() {
        dbParameter = new KogakuGassanJikofutangakuDoMasterTorokuParameter();
        dbParameter.set処理年月(parameter.get処理年月());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, dbParameter);
    }

    @Override
    protected void createWriter() {
        高額合算自己負担額TBLWriter
                = new BatchPermanentTableWriter(DbT3070KogakuGassanJikoFutanGakuEntity.class);
    }

    @Override
    protected void process(DbT3070KogakuGassanJikoFutanGakuEntity entity) {
        entity.setJikoFutanSeiriNo(RString.EMPTY);
        entity.setShomeisho_UketoriYM(FlexibleYearMonth.EMPTY);
        高額合算自己負担額TBLWriter.update(entity);
    }

}
