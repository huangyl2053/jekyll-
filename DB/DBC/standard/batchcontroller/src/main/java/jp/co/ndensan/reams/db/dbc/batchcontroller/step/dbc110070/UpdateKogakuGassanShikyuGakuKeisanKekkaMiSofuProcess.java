/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110070;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenDataSaisoFlag;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanShikyuGakuKeisanKekkaRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanShikyuGakuKeisanKekkaTmpEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給額計算結果更新のProcessです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
public class UpdateKogakuGassanShikyuGakuKeisanKekkaMiSofuProcess extends BatchKeyBreakBase<KogakuGassanShikyuGakuKeisanKekkaTmpEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110070."
            + "IKogakugassanKeisankekkaRenrakuhyoOutMapper.get未送付データ");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private SofuFileSakuseiProcessCore processCore;
    private KogakuGassanShikyuGakuKeisanKekkaRelateEntity 高額合算支給額計算結果;

    private int flag;
    @BatchWriter
    private BatchPermanentTableWriter<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity> dbT3072TableWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity> dbT3073TableWriter;

    @Override
    protected void initialize() {
        flag = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void createWriter() {
        dbT3072TableWriter = new BatchPermanentTableWriter<>(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity.class);
        dbT3073TableWriter = new BatchPermanentTableWriter<>(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.class);
    }

    @Override
    protected void beforeExecute() {
        processCore = new SofuFileSakuseiProcessCore();
    }

    @Override
    protected void usualProcess(KogakuGassanShikyuGakuKeisanKekkaTmpEntity entity) {
        if (flag == 0) {
            flag = INT_1;
        }
    }

    @Override
    protected void keyBreakProcess(KogakuGassanShikyuGakuKeisanKekkaTmpEntity entity) {
        flag = INT_2;
        高額合算支給額計算結果 = processCore.keyBreakProcess２(getBefore(), entity);
        if (高額合算支給額計算結果 != null) {
            高額合算支給額計算結果登録();
        }
    }

    @Override
    protected void afterExecute() {
        if (flag == INT_1) {
            getBefore().get高額合算支給額計算結果().setSofuYM(FlexibleYearMonth.EMPTY);
            getBefore().get高額合算支給額計算結果().setSaisoFG(KokuhorenDataSaisoFlag.再送不要.getコード());
            dbT3072TableWriter.update(getBefore().get高額合算支給額計算結果());
            if (getBefore().get高額合算支給額計算結果明細() != null) {
                getBefore().get高額合算支給額計算結果明細().setSofuYM(FlexibleYearMonth.EMPTY);
                dbT3073TableWriter.update(getBefore().get高額合算支給額計算結果明細());
            }
        }
        if (flag == INT_2) {
            高額合算支給額計算結果 = processCore.getFinal高額合算支給額計算結果();
            高額合算支給額計算結果登録();
        }
    }

    private void 高額合算支給額計算結果登録() {
        高額合算支給額計算結果.get高額合算支給額計算結果().setSofuYM(FlexibleYearMonth.EMPTY);
        高額合算支給額計算結果.get高額合算支給額計算結果().setSaisoFG(KokuhorenDataSaisoFlag.再送不要.getコード());
        dbT3072TableWriter.update(高額合算支給額計算結果.get高額合算支給額計算結果());
        if (高額合算支給額計算結果.get高額合算支給額計算結果明細リスト() != null
                && !高額合算支給額計算結果.get高額合算支給額計算結果明細リスト().isEmpty()) {
            for (DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity 明細
                    : 高額合算支給額計算結果.get高額合算支給額計算結果明細リスト()) {
                if (明細 != null) {
                    明細.setSofuYM(FlexibleYearMonth.EMPTY);
                    dbT3073TableWriter.update(明細);
                }
            }
        }
    }
}
