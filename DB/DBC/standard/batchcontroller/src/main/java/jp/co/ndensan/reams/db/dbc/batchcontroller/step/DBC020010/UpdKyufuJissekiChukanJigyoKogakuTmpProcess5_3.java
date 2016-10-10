/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannJigyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_3Entity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
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
    private KyufuJissekiKihonKogakuProcessParameter processParameter;
    private IKogakuKaigoServicehiKyufugakuSanshutsuMapper mapper;

    @Override
    protected void initialize() {
        mapper = getMapper(IKogakuKaigoServicehiKyufugakuSanshutsuMapper.class);
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected IBatchReader createReader() {
        KyufuJissekiKihonKogakuMybatisParameter mybatisParameter = new KyufuJissekiKihonKogakuMybatisParameter();
        mybatisParameter.set最古のサービス提供年月(processParameter.get最古のサービス高額提供年月());
        mybatisParameter.set最新のサービス提供年月(processParameter.get最新のサービス高額提供年月());
        return new BatchDbReader(MYBATIS_ID, mybatisParameter);
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
        if (給付実績中間事業高額一時５_高額介護サービス費 != null) {
            高額介護サービス費 = 給付実績中間事業高額一時５_高額介護サービス費.add(高額支給額);
        }
        給付実績中間事業高額一時５.setKogakuKaigoServicehi(高額介護サービス費);
        mapper.update給付実績中間事業高額一時(給付実績中間事業高額一時５);
    }

    @Override
    protected void afterExecute() {
    }
}
