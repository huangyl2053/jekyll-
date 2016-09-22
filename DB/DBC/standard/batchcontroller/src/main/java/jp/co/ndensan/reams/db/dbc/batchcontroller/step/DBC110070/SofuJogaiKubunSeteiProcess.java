/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110070;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算計算結果連絡票情報作成のバッチ送付除外区分設定Processです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
public class SofuJogaiKubunSeteiProcess extends BatchProcessBase<DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110070."
            + "IKogakugassanKeisankekkaRenrakuhyoOutMapper.get識別コードがないデータ");
    private static final RString 高額合算支給額計算結果一時 = new RString("DbWT3811KogakuGassanShikyuGakuKeisanKekka");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算支給額計算結果一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void createWriter() {
        高額合算支給額計算結果一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算支給額計算結果一時, DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity.class);
    }

    @Override
    protected void process(DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity entity) {
        entity.setSofuJogaiFlag(true);
        高額合算支給額計算結果一時tableWriter.update(entity);
    }
}
