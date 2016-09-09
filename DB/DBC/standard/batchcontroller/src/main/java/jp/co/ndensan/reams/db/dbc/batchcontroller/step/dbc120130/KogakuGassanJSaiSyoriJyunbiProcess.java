/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120130;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120110.KogakuGassanJikofutangakuDoMasterTorokuParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120110.KogakuGassanJikofutangakuDoMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H1KogakuGassanaJikofutangakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額証明書情報取込のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
public class KogakuGassanJSaiSyoriJyunbiProcess extends BatchProcessBase {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakugassanjikofutangaku.IKogakuGassanJSaiSyoriJyunbiMapper.do再処理準備");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 高額合算自己負担額一時_TABLE_NAME = new RString("DbWT37H1KogakuGassanaJikofutangaku");

    @BatchWriter
    BatchPermanentTableWriter 高額合算自己負担額TBLWriter;
    @BatchWriter
    IBatchTableWriter 処理結果リスト一時tbWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算自己負担額一時tableWriter;

    private KogakuGassanJikofutangakuDoMasterTorokuProcessParameter parameter;
    private KogakuGassanJikofutangakuDoMasterTorokuParameter dbParameter;

    @Override
    protected void initialize() {
        dbParameter.set処理年月(parameter.get処理年月());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, dbParameter);
    }

    @Override
    protected void createWriter() {
        高額合算自己負担額TBLWriter = new BatchPermanentTableWriter(DbT3070KogakuGassanJikoFutanGakuEntity.class);
        処理結果リスト一時tbWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME, DbWT0002KokuhorenTorikomiErrorEntity.class);
        高額合算自己負担額一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算自己負担額一時_TABLE_NAME, DbWT37H1KogakuGassanaJikofutangakuTempEntity.class);
    }

    @Override
    protected void process(Object t) {

    }

}
