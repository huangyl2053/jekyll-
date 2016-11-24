/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.saishinsaketteidbtoroku;

import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsaketteidbtoroku.SaishinsaKetteiDBProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3063SaishinsaKetteiShukeiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査決定通知書情報取込共通処理（マスタ登録）集計削除
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaKetteiShukeiSakujoProcess extends BatchProcessBase<DbT3063SaishinsaKetteiShukeiEntity> {

    private SaishinsaKetteiDBProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "saishinsaketteihokenshainmasutatoroku.ISaishinsaKetteiHokenshaInMasutaTorokuMapper.getDbT3063SaishinsaKetteiShukei");


    @BatchWriter
    private BatchPermanentTableWriter 再審査決定集計TBLtableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toSaishinsaKetteiDBTorokuMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        再審査決定集計TBLtableWriter = new BatchPermanentTableWriter(DbT3063SaishinsaKetteiShukeiEntity.class);
    }

    @Override
    protected void process(DbT3063SaishinsaKetteiShukeiEntity t) {
        再審査決定集計TBLtableWriter.delete(t);
    }

}
