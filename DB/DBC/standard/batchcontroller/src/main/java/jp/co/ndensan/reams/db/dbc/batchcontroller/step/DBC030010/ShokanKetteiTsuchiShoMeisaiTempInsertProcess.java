/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchisho.ShokanKetteiTsuchiShoMeisaiTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い支給不支給決定通知書明細一時TBLを作成します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class ShokanKetteiTsuchiShoMeisaiTempInsertProcess extends BatchProcessBase<ShokanKetteiTsuchiShoMeisaiTempTableEntity> {

    private static final RString 決定通知書明細情報取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.get決定通知書明細情報");
    private static final RString TABLE_償還払い支給不支給決定通知書明細情報 = new RString("ShokanKetteiTsuchiShoMeisaiTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 償還払支給不支給決定通知書明細情報一時TBL;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(決定通知書明細情報取得SQL);
    }

    @Override
    protected void createWriter() {
        償還払支給不支給決定通知書明細情報一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_償還払い支給不支給決定通知書明細情報,
                ShokanKetteiTsuchiShoMeisaiTempTableEntity.class);
    }

    @Override
    protected void process(ShokanKetteiTsuchiShoMeisaiTempTableEntity entity) {
        償還払支給不支給決定通知書明細情報一時TBL.insert(entity);
    }
}
