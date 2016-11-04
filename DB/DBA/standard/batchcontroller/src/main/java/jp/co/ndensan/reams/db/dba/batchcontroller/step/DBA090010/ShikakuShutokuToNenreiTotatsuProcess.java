/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010;

import jp.co.ndensan.reams.db.dba.business.core.atenasealcreate.AtenaSealCreateResult;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.DbTAtenaSealCreateTempTableEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.JukyuNinteiShinseityuIgaiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 宛名識別対象一時テーブル5を作成、データを作成します。
 */
public class ShikakuShutokuToNenreiTotatsuProcess extends BatchProcessBase<JukyuNinteiShinseityuIgaiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.atenasealcreate."
            + "IJukyuNinteiShinseityuIgaiMapper.getTaishouSha5List");
    private static final RString TABLE_宛名識別対象一時テーブル1 = new RString("DbWT2009AtenaShikibetuTaisyou1");
    private static final RString TABLE_宛名識別対象一時テーブル2 = new RString("DbWT2009AtenaShikibetuTaisyou2");
    private static final RString TABLE_宛名識別対象一時テーブル5 = new RString("DbWT2009AtenaShikibetuTaisyou5");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 宛名識別対象一時テーブル1;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 宛名識別対象一時テーブル2;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 宛名識別対象一時テーブル5;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        宛名識別対象一時テーブル1 = new BatchEntityCreatedTempTableWriter(TABLE_宛名識別対象一時テーブル1,
                DbTAtenaSealCreateTempTableEntity.class);
        宛名識別対象一時テーブル2 = new BatchEntityCreatedTempTableWriter(TABLE_宛名識別対象一時テーブル2,
                DbTAtenaSealCreateTempTableEntity.class);
        宛名識別対象一時テーブル5 = new BatchEntityCreatedTempTableWriter(TABLE_宛名識別対象一時テーブル5,
                DbTAtenaSealCreateTempTableEntity.class);
    }

    @Override
    protected void process(JukyuNinteiShinseityuIgaiEntity entity) {
        宛名識別対象一時テーブル5.insert(new AtenaSealCreateResult().set宛名識別対象一時テーブル5(entity));
    }
}
