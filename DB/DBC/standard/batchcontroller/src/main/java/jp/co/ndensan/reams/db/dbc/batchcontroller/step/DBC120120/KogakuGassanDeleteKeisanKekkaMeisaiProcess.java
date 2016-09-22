/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120120;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120120.KogakuGassanShikyugakuKeisanKekkaInParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計書_DBCMNF2002-386_高額合算支給額計算結果連絡票情報取込の高額合算支給額計算結果明細TBLを物理削除するクラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
public class KogakuGassanDeleteKeisanKekkaMeisaiProcess extends BatchProcessBase<DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakugassan.IKogakuGassanShikyugakuKeisanKekkaInMapper.select高額合算支給額計算結果明細情報");

    private KogakuGassanShikyugakuKeisanKekkaInParameter processprm;

    @BatchWriter
    BatchPermanentTableWriter 高額合算支給額計算結果tableWriter;

    @Override
    protected void createWriter() {
        高額合算支給額計算結果tableWriter = new BatchPermanentTableWriter(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        KokuhorenIchiranhyoMybatisParameter parameter = new KokuhorenIchiranhyoMybatisParameter();
        parameter.set処理区分(processprm.get処理区分());
        parameter.set処理年月(processprm.get処理年月());
        return new BatchDbReader(MAPPERPATH, parameter);
    }

    @Override
    protected void process(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity) {
        高額合算支給額計算結果tableWriter.delete(entity);
    }
}
