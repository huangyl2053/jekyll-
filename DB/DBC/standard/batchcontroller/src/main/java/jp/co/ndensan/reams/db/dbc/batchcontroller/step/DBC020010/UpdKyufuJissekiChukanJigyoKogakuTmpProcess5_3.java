/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannJigyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.UpdKyufuJissekiChukanJigyoKogakuTmpProcessEntity3;
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
public class UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_3 extends BatchProcessBase<UpdKyufuJissekiChukanJigyoKogakuTmpProcessEntity3> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select高額介護サービス費給付対象者合計");
    private KyufuJissekiKihonKogakuProcessParameter processParameter;
    private IKogakuKaigoServicehiKyufugakuSanshutsuMapper mapper;
    private TempKyufujissekiTyukannJigyoEntity beforeEntity;
    private Decimal 高額介護サービス費;

    @Override
    protected void initialize() {
        mapper = getMapper(IKogakuKaigoServicehiKyufugakuSanshutsuMapper.class);
        beforeEntity = null;
        高額介護サービス費 = Decimal.ZERO;
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
    protected void process(UpdKyufuJissekiChukanJigyoKogakuTmpProcessEntity3 entity) {
        TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額一時５ = entity.get給付実績中間事業高額一時５();
        DbT3055KogakuKyufuTaishoshaGokeiEntity 給付対象者合計 = entity.get高額介護サービス費給付対象者合計();
        if (給付対象者合計 == null) {
            return;
        }
        if (beforeEntity == null) {
            beforeEntity = 給付実績中間事業高額一時５;
        }
        if (!getキー(beforeEntity).equals(getキー(給付実績中間事業高額一時５))) {
            beforeEntity.setKogakuKaigoServicehi(高額介護サービス費);
            mapper.update給付実績中間事業高額一時(beforeEntity);
            高額介護サービス費 = Decimal.ZERO;
        }
        Decimal 高額支給額 = 給付対象者合計.getKogakuShikyuGaku();
        高額介護サービス費 = 高額介護サービス費.add(高額支給額 == null ? Decimal.ZERO : 高額支給額);
    }

    @Override
    protected void afterExecute() {
        beforeEntity.setKogakuKaigoServicehi(高額介護サービス費);
        mapper.update給付実績中間事業高額一時(beforeEntity);
    }

    private RString getキー(TempKyufujissekiTyukannJigyoEntity entity) {
        return entity.getInputShikibetsuNo().getColumnValue().
                concat(entity.getHiHokenshaNo().getColumnValue()).
                concat(entity.getServiceTeikyoYM().toDateString()).
                concat(entity.getShokisaiHokenshaNo().getColumnValue()).
                concat(entity.getJigyoshoNo().getColumnValue()).
                concat(entity.getToshiNo());
    }
}
