/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannJigyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.UpdKyufuJissekiChukanJigyoKogakuTmpProcessEntity2;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績中間事業高額一時の更新２プロセスのクラスです。
 *
 * @reamsid_L DBC-2010-040 zhouchuanlin
 */
public class UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_2 extends BatchProcessBase<UpdKyufuJissekiChukanJigyoKogakuTmpProcessEntity2> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select高額介護サービス費支給判定結果と支給審査決定");
    private static final RString 審査方法区分_依頼 = new RString("1");
    private static final RString 審査方法区分_済み = new RString("2");
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
    protected void process(UpdKyufuJissekiChukanJigyoKogakuTmpProcessEntity2 entity) {
        TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額一時５ = entity.get給付実績中間事業高額一時５();
        DbT3057KogakuShikyuHanteiKekkaEntity 支給判定結果 = entity.get高額介護サービス費支給判定結果();
        DbT3058KogakuShikyuShinsaKetteiEntity 支給審査決定 = entity.get高額介護サービス費支給審査決定();
        if (beforeEntity == null) {
            beforeEntity = 給付実績中間事業高額一時５;
        }
        if (!getキー(beforeEntity).equals(getキー(給付実績中間事業高額一時５))) {
            beforeEntity.setKogakuKaigoServicehi(高額介護サービス費);
            mapper.update給付実績中間事業高額一時(beforeEntity);
            高額介護サービス費 = Decimal.ZERO;
        }
        if (支給判定結果 == null || 支給審査決定 == null) {
            return;
        }
        Decimal 高額支給額 = Decimal.ZERO;
        Decimal 支給金額 = Decimal.ZERO;
        RString 審査方法区分 = RString.EMPTY;
        FlexibleYearMonth 決定者受取年月 = FlexibleYearMonth.EMPTY;
        審査方法区分 = 支給判定結果.getShinsaHohoKubun();
        支給金額 = 支給判定結果.getShikyuKingaku();
        決定者受取年月 = 支給審査決定.getKetteishaUketoriYM();
        高額支給額 = 支給審査決定.getKogakuShikyuGaku();
        if (!RString.isNullOrEmpty(審査方法区分) && 審査方法区分_依頼.equals(審査方法区分)) {
            if (決定者受取年月 != null && !決定者受取年月.isEmpty()) {
                高額介護サービス費 = 高額介護サービス費.add(高額支給額 == null ? Decimal.ZERO : 高額支給額);
            } else {
                高額介護サービス費 = 高額介護サービス費.add(支給金額 == null ? Decimal.ZERO : 支給金額);
            }
        } else if (!RString.isNullOrEmpty(審査方法区分) && 審査方法区分_済み.equals(審査方法区分)) {
            高額介護サービス費 = 高額介護サービス費.add(支給金額 == null ? Decimal.ZERO : 支給金額);
        }
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
