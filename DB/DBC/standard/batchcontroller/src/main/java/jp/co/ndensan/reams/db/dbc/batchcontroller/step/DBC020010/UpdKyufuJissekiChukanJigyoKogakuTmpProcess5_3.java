/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannJigyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_3Entity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績中間事業高額一時の更新３プロセスのクラスです。
 *
 * @reamsid_L DBC-2010-040 zhouchuanlin
 */
public class UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_3 extends BatchProcessBase<UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_3Entity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select高額介護サービス費給付対象者合計");
    private static final RString TABLE_給付実績中間事業高額一時5 = new RString("TempKyufujissekiTyukannJigyo5");
    private KyufuJissekiKihonKogakuProcessParameter processParameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter kyufujissekiTyukannJigyo5Writer;

    @Override
    protected void initialize() {
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        kyufujissekiTyukannJigyo5Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績中間事業高額一時5, TempKyufujissekiTyukannJigyoEntity.class);
    }

    @Override
    protected void process(UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_3Entity entity) {
        TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額一時５ = entity.get給付実績中間事業高額一時５();
        DbT3055KogakuKyufuTaishoshaGokeiEntity 給付対象者合計 = entity.get高額介護サービス費給付対象者合計();
        Decimal 高額介護サービス費 = Decimal.ZERO;
        Decimal 給付実績中間事業高額一時５_高額介護サービス費 = 給付実績中間事業高額一時５.getKogakuKaigoServicehi();
        Decimal 高額支給額 = Decimal.ZERO;
        if (給付対象者合計 != null) {
            高額支給額 = 給付対象者合計.getKogakuShikyuGaku();
        }
        if (高額支給額 != null) {
            高額介護サービス費 = 給付実績中間事業高額一時５_高額介護サービス費.add(高額支給額);
        }
        給付実績中間事業高額一時５.setKogakuKaigoServicehi(高額介護サービス費);
        kyufujissekiTyukannJigyo5Writer.update(給付実績中間事業高額一時５);
    }

    @Override
    protected void afterExecute() {
    }
}
