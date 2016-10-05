/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100020;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc100020.KaishuriyushoShikyuKetteitsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料請求決定更新のProcessクラスです。
 *
 * @reamsid_L DBC-2850-030 zuotao
 */
public class DBUpdateProcess extends BatchProcessBase<DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kaishuriyushoshikyuketteitsuchishosakusei.IKaishuriyushoShikyuKetteitsuchishoSakuseiMapper.get住宅改修理由書作成手数料請求決定");
    private KaishuriyushoShikyuKetteitsuchishoProcessParameter processParameter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity> dbT3094Writer;

    @Override
    protected IBatchReader createReader() {
        dbT3094Writer = new BatchPermanentTableWriter<>(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity.class);
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMybatisPatameter());
    }

    @Override
    protected void process(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity) {
        entity.setKetteiTsuchiSakuseiYMD(FlexibleDate.getNowDate());
        dbT3094Writer.update(entity);
    }
}
