/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.InsKyufuJissekiKihonKogakuTmp4Param;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.InsKyufuJissekiKihonKogakuTmpProcess4Param;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 給付実績基本抽出03のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 jianglaisheng
 */
public class InsKyufuJissekiKihonJigyoKogakuTmpProcess4 extends BatchProcessBase<DbT3017KyufujissekiKihonEntity> {

    private static final RString 給付実績基本2 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper.get給付実績基本2");
    private static final RString TABLE_給付実績基本情報事業高額一時4 = new RString("TempKyufujissekiKihonJigyo4");

    private InsKyufuJissekiKihonKogakuTmpProcess4Param processParameter;
    private RString breakKey;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 給付実績基本情報事業高額一時;

    @Override
    protected IBatchReader createReader() {
        InsKyufuJissekiKihonKogakuTmp4Param parameterDB = new InsKyufuJissekiKihonKogakuTmp4Param(
                processParameter.get最古のサービス提供年月(), processParameter.get最新のサービス提供年月());
        return new BatchDbReader(給付実績基本2, parameterDB);
    }

    @Override
    protected void createWriter() {
        給付実績基本情報事業高額一時 = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績基本情報事業高額一時4, DbT3017KyufujissekiKihonEntity.class);
    }

    @Override
    protected void process(DbT3017KyufujissekiKihonEntity entity) {
        if (breakKey != null && breakKey.equals(getBreakKey(entity))) {
            return;
        }
        if (processParameter.get処理年月().isBeforeOrEquals(entity.getShinsaYM())) {
            return;
        }
        給付実績基本情報事業高額一時.insert(entity);
        breakKey = getBreakKey(entity);

    }

    private RString getBreakKey(DbT3017KyufujissekiKihonEntity entity) {
        return entity.getInputShikibetsuNo().getColumnValue()
                .concat(entity.getHiHokenshaNo().getColumnValue())
                .concat(entity.getServiceTeikyoYM().toDateString())
                .concat(entity.getKyufuJissekiKubunCode())
                .concat(entity.getJigyoshoNo().getColumnValue());
    }

}
