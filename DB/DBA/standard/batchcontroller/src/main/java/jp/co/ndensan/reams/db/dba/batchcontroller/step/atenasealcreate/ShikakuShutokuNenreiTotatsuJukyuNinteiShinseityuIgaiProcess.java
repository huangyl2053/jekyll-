/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.atenasealcreate;

import jp.co.ndensan.reams.db.dba.business.core.atenasealcreate.AtenaSealCreateResult;
import jp.co.ndensan.reams.db.dba.definition.processprm.atenasealcreate.AtenaSealCreateProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.DbTAtenaSealCreateTempTableEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.JukyuNinteiShinseityuIgaiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール作成、抽出対象者が資格取得者＋年齢到達予定者または抽出対象者に受給認定申請中を除くの場合、データを作成します。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
public class ShikakuShutokuNenreiTotatsuJukyuNinteiShinseityuIgaiProcess extends BatchProcessBase<JukyuNinteiShinseityuIgaiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.atenasealcreate.IJukyuNinteiShinseityuIgaiMapper.getList");
    private static final RString TABLE_宛名識別対象一時テーブル4 = new RString("DbWT2009AtenaShikibetuTaisyou4");
    private static final RString TABLE_宛名識別対象一時テーブル3 = new RString("DbWT2009AtenaShikibetuTaisyou3");
    private static final RString 抽出対象者_資格取得者_年齢到達予定者 = new RString("3");
    private AtenaSealCreateProcessParameter processParamter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 宛名識別対象一時テーブル3;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 宛名識別対象一時テーブル4;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        if (抽出対象者_資格取得者_年齢到達予定者.equals(processParamter.getChuushutsutaishousha())) {
            宛名識別対象一時テーブル3 = new BatchEntityCreatedTempTableWriter(TABLE_宛名識別対象一時テーブル3,
                    DbTAtenaSealCreateTempTableEntity.class);
        }
        宛名識別対象一時テーブル4 = new BatchEntityCreatedTempTableWriter(TABLE_宛名識別対象一時テーブル4,
                DbTAtenaSealCreateTempTableEntity.class);
    }

    @Override
    protected void process(JukyuNinteiShinseityuIgaiEntity entity) {
        宛名識別対象一時テーブル4.insert(new AtenaSealCreateResult().set宛名識別対象一時テーブル4(entity));
    }

}
