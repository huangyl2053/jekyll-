/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteisumidataif;

import jp.co.ndensan.reams.db.dbe.definition.processprm.ichijihanteisumidataif.IchijihanteiSumidataIftProcessParamter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7211GaibuRenkeiDataoutputJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定データ出力Processです。
 *
 * @reamsid_L DBE-1610-020 wanghui
 */
public class IchijihanteiSumidataIfDBUpdateProcess extends BatchProcessBase<DbT7211GaibuRenkeiDataoutputJohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijihanteisumidataif."
            + "IchijihanteiSumidataIDataShutsuryokuMapper.get宛名連動介護保険更新");
    @BatchWriter
    private BatchPermanentTableWriter<DbT7211GaibuRenkeiDataoutputJohoEntity> tableWrite;
    private RDate 処理日時;
    private IchijihanteiSumidataIftProcessParamter paramter;

    @Override
    protected void initialize() {
        処理日時 = RDate.getNowDate();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toIchijihanteiSumidataIftMybitisParamter());
    }

    @Override
    protected void createWriter() {
        tableWrite = new BatchPermanentTableWriter<>(DbT7211GaibuRenkeiDataoutputJohoEntity.class);
    }

    @Override
    protected void process(DbT7211GaibuRenkeiDataoutputJohoEntity item) {
        item.setIchijihanteiChushutsuYMD(new FlexibleDate(処理日時.toString()));
        tableWrite.update(item);
    }
}
