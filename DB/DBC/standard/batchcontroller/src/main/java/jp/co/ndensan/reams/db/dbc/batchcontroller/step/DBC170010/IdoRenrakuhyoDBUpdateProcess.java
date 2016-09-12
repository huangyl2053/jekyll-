/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170010;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.ServiceCode_IdoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.ServiceCode_SofuKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc170010.ServicecodeIdoRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7122SogoJigyoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc170010.ServicecodeIdoRenrakuhyoSofuZumiDataEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業分サービスコード異動連絡票作成のProcessクラスです。
 *
 * @reamsid_L DBC-4740-030 zhaowei
 */
public class IdoRenrakuhyoDBUpdateProcess extends BatchProcessBase<ServicecodeIdoRenrakuhyoSofuZumiDataEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc170010."
            + "IServicecodeIdoRenrakuhyoOutMapper.get送付済データ");

    private ServicecodeIdoRenrakuhyoOutProcessParameter processParameter;
    @BatchWriter
    BatchPermanentTableWriter dbt7122TableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void createWriter() {
        dbt7122TableWriter = new BatchPermanentTableWriter(DbT7122SogoJigyoServiceCodeEntity.class);
    }

    @Override
    protected void process(ServicecodeIdoRenrakuhyoSofuZumiDataEntity entity) {
        entity.get支援総合事業サービスコード().setSofuKubun(ServiceCode_SofuKubun.送付済み.getコード());
        entity.get支援総合事業サービスコード().setSofuYM(new FlexibleYearMonth(processParameter.get処理年月().toDateString()));
        if (ServiceCode_IdoKubun.新規.getコード().equals(entity.get異動区分コード())
                || ServiceCode_IdoKubun.修正.getコード().equals(entity.get異動区分コード())) {
            entity.get支援総合事業サービスコード().setShinkiHenkoIdoYMD(entity.get新規変更異動年月日());
        }
        if (ServiceCode_IdoKubun.終了.getコード().equals(entity.get異動区分コード())) {
            entity.get支援総合事業サービスコード().setShuryoIdoYMD(entity.get終了異動年月日());
        }
        dbt7122TableWriter.update(entity.get支援総合事業サービスコード());
    }
}
