/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiChukanKogaku8Entity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 給付実績中間高額一時の作成8のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 tianshuai
 */
public class InsKyufuJissekiChukanKogakuTmpProcess8 extends BatchProcessBase<KyufuJissekiChukanKogaku8Entity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select給付実績中間高額一時の作成8");
    private static final RString TABLE_給付実績中間高額一時8 = new RString("TempKyufujissekiTyukann8");
    private static final RString TABLE_給付実績中間高額一時9 = new RString("TempKyufujissekiTyukann9");
    private static final RString 作成区分_取消 = new RString("3");
    private static final FlexibleYearMonth 年月_200510 = new FlexibleYearMonth("200510");
    private static final FlexibleYearMonth 年月_200607 = new FlexibleYearMonth("200607");
    private static final FlexibleYearMonth 年月_200806 = new FlexibleYearMonth("200806");
    private static final Decimal 金額_800000 = new Decimal("800000");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private Decimal サービス費用額合計;
    private Decimal 利用者負担額合計;
    private KyufuJissekiChukanKogaku8Entity beforeEntity;
    private List<TempKyufujissekiTyukannEntity> 給付実績中間高額一時明細List;
    private List<TempKyufujissekiTyukannEntity> 給付実績中間高額一時取消明細List;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter kyufujissekiTyukann8Writer;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter kyufujissekiTyukann9Writer;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
    }

    @Override
    protected void initialize() {
        beforeEntity = null;
        サービス費用額合計 = Decimal.ZERO;
        利用者負担額合計 = Decimal.ZERO;
        給付実績中間高額一時明細List = new ArrayList<>();
        給付実績中間高額一時取消明細List = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void createWriter() {
        kyufujissekiTyukann8Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績中間高額一時8, TempKyufujissekiTyukannEntity.class);
        kyufujissekiTyukann9Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績中間高額一時9, TempKyufujissekiTyukannEntity.class);
    }

    @Override
    protected void process(KyufuJissekiChukanKogaku8Entity entity) {
        if (beforeEntity == null) {
            beforeEntity = entity;
        }
        TempKyufujissekiTyukannEntity before給付実績中間 = beforeEntity.get給付実績中間高額一時();
        TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
        if (作成区分_取消.equals(給付実績中間.getKyufuSakuseiKubunCode())) {
            給付実績中間高額一時取消明細List.add(給付実績中間);
        } else {
            給付実績中間高額一時明細List.add(給付実績中間);
        }
        Decimal 利用者負担額 = get利用者負担額を算出(給付実績中間);
        if (before給付実績中間.getShotokuHantei_setaiCode().equals(給付実績中間.getShotokuHantei_setaiCode())
                && before給付実績中間.getShotokuHantei_jushochiTokureiFlag().equals(給付実績中間.getShotokuHantei_jushochiTokureiFlag())
                && before給付実績中間.getShotokuHantei_shoboKubun().equals(給付実績中間.getShotokuHantei_shoboKubun())
                && before給付実績中間.getServiceTeikyoYM().equals(給付実績中間.getServiceTeikyoYM())
                && before給付実績中間.getHiHokenshaNo().equals(給付実績中間.getHiHokenshaNo())) {
            insert給付実績中間高額一時9(給付実績中間);
            getサービス費用合計を算出(給付実績中間);
            利用者負担額合計 = 利用者負担額合計.add(利用者負担額);
        }
        insert給付実績中間高額一時8();
    }

    private void insert給付実績中間高額一時8() {
        if (!給付実績中間高額一時取消明細List.isEmpty()) {
            return;
        }
        TempKyufujissekiTyukannEntity 給付実績中間高額一時新規8 = 給付実績中間高額一時明細List.get(0);
        給付実績中間高額一時新規8.setShotokuHantei_setaiinShikibetsuCode(null);
        給付実績中間高額一時新規8.setKogakuServicehiJogengakuGengakuGaitoFlag(null);
        給付実績中間高額一時新規8.setKogakuServicehiJogengakuGengakugoJogengaku(null);
        給付実績中間高額一時新規8.setDataKubun(ONE);
        給付実績中間高額一時新規8.setServiceHiyougakuGokei(サービス費用額合計);
        // 支給（予定）額 算定基準額　QA確認中
        給付実績中間高額一時新規8.setSikyugaku(Decimal.ZERO);
        給付実績中間高額一時新規8.setSanteiKijungaku(Decimal.ZERO);
        給付実績中間高額一時新規8.setKogakuHanteiKekka(ONE);
        給付実績中間高額一時新規8.setSagakuKubun(null);
        給付実績中間高額一時新規8.setKoogakuKetteiKubun(null);
        // 備考欄世帯所得区分、備考欄個人所得区分 QA確認中
        給付実績中間高額一時新規8.setBeikoSetaishotokuKubun(null);
        給付実績中間高額一時新規8.setBeikoKojinshotokuKubun(null);
        給付実績中間高額一時新規8.setRiyoFitanDankai2(RString.EMPTY);
        kyufujissekiTyukann8Writer.insert(給付実績中間高額一時新規8);
    }

    private void insert給付実績中間高額一時9(TempKyufujissekiTyukannEntity 給付実績中間高額一時新規9) {
        給付実績中間高額一時新規9.setKyufuSakuseiKubunCode(作成区分_取消);
        給付実績中間高額一時新規9.setShotokuHantei_setaiinShikibetsuCode(null);
        給付実績中間高額一時新規9.setKogakuServicehiJogengakuGengakuGaitoFlag(null);
        給付実績中間高額一時新規9.setKogakuServicehiJogengakuGengakugoJogengaku(null);
        給付実績中間高額一時新規9.setDataKubun(TWO);
        給付実績中間高額一時新規9.setServiceHiyougakuGokei(サービス費用額合計);
        // 支給（予定）額　QA確認中
        給付実績中間高額一時新規9.setSikyugaku(Decimal.ZERO);
        給付実績中間高額一時新規9.setSanteiKijungaku(Decimal.ZERO);
        給付実績中間高額一時新規9.setKogakuHanteiKekka(ZERO);
        給付実績中間高額一時新規9.setSagakuKubun(null);
        給付実績中間高額一時新規9.setKoogakuKetteiKubun(null);
        // 備考欄世帯所得区分、備考欄個人所得区分 QA確認中
        給付実績中間高額一時新規9.setBeikoSetaishotokuKubun(null);
        給付実績中間高額一時新規9.setBeikoKojinshotokuKubun(null);
        // 利用者負担第２段階 QA確認中
        給付実績中間高額一時新規9.setRiyoFitanDankai2(get利用者負担第２段階(給付実績中間高額一時新規9));
        kyufujissekiTyukann9Writer.insert(給付実績中間高額一時新規9);
    }

    @Override
    protected void afterExecute() {
    }

    private void getサービス費用合計を算出(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (作成区分_取消.equals(給付実績中間.getKyufuSakuseiKubunCode())) {
            return;
        }
        サービス費用額合計 = サービス費用額合計.
                add(給付実績中間.getMaeHokenSeikyugaku()).
                add(給付実績中間.getHokenDekidakaSeikyugaku()).
                add(給付実績中間.getHokenDekidakaIryohiRiyoshaFutangaku()).
                add(給付実績中間.getKohi1Seikyugaku()).
                add(給付実績中間.getKohi1HonninFutangaku()).
                add(給付実績中間.getKohi1DekidakaSeikyugaku()).
                add(給付実績中間.getKohi1DekidakaIryohiRiyoshaFutangaku()).
                add(給付実績中間.getKohi2Seikyugaku()).
                add(給付実績中間.getKohi2HonninFutangaku()).
                add(給付実績中間.getKohi2DekidakaSeikyugaku()).
                add(給付実績中間.getKohi2DekidakaIryohiRiyoshaFutangaku()).
                add(給付実績中間.getKohi3Seikyugaku()).
                add(給付実績中間.getKohi3HonninFutangaku()).
                add(給付実績中間.getKohi3DekidakaSeikyugaku()).
                add(給付実績中間.getKohi3DekidakaIryohiRiyoshaFutangaku());
    }

    private Decimal get利用者負担額を算出(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (年月_200510.compareTo(給付実績中間.getServiceTeikyoYM()) <= 0
                && ONE.equals(給付実績中間.getKyufuJissekiShakaiFukushiHojinKeiUmu())) {
            return new Decimal(給付実績中間.getAtoHokenRiyoshaFutangaku()).
                    add(給付実績中間.getGoKeigengoRiyoshaFutangaku());
        } else {
            return new Decimal(給付実績中間.getAtoHokenRiyoshaFutangaku()).
                    add(給付実績中間.getAtoKohi1RiyoshaFutangaku()).
                    add(給付実績中間.getAtoKohi2RiyoshaFutangaku()).
                    add(給付実績中間.getAtoKohi3RiyoshaFutangaku()).
                    add(給付実績中間.getKohi1DekidakaIryohiRiyoshaFutangaku()).
                    add(給付実績中間.getKohi2DekidakaIryohiRiyoshaFutangaku()).
                    add(給付実績中間.getKohi3DekidakaIryohiRiyoshaFutangaku());
        }
    }

    private Decimal get改修前の算定基準額(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (給付実績中間.getServiceTeikyoYM().compareTo(年月_200510) < 0) {
            if (ONE.equals(給付実績中間.getShotokuHantei_shoboKubun())) {
                return get算定基準額コンフィグ(ConfigNameDBC.高額自己負担上限額_15000);
            } else if (ONE.equals(給付実績中間.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
                return 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku();
            } else if (TWO.equals(給付実績中間.getShotokuHantei_kazeiKubunGemmenGo())) {
                return get老齢福祉区分の場合1(給付実績中間);
            } else if (!ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())) {
                return get算定基準額コンフィグ(ConfigNameDBC.高額自己負担上限額_37200);
            }
        } else if (年月_200607.compareTo(給付実績中間.getServiceTeikyoYM()) <= 0
                && 給付実績中間.getServiceTeikyoYM().compareTo(年月_200806) <= 0) {
            if (ONE.equals(給付実績中間.getShotokuHantei_shoboKubun())) {
                return get算定基準額コンフィグ(ConfigNameDBC.高額自己負担上限額_15000);
            } else if (ONE.equals(給付実績中間.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
                return 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku();
            } else if (TWO.equals(給付実績中間.getShotokuHantei_kazeiKubunGemmenGo())) {
                return get老齢福祉区分の場合2(給付実績中間);
            } else if (!ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())) {
                return get算定基準額コンフィグ(ConfigNameDBC.高額自己負担上限額_37200);
            }
        } else {
            if (ONE.equals(給付実績中間.getShotokuHantei_shoboKubun())) {
                return get算定基準額コンフィグ(ConfigNameDBC.高額自己負担上限額_15000);
            } else if (ONE.equals(給付実績中間.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
                return 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku();
            } else if (TWO.equals(給付実績中間.getShotokuHantei_kazeiKubunGemmenGo())) {
                return get老齢福祉区分の場合2(給付実績中間);
            } else if (ONE.equals(給付実績中間.getShotokuHantei_gekihenKanwaKubun())) {
                return get老齢福祉区分の場合2(給付実績中間);
            } else {
                return get算定基準額コンフィグ(ConfigNameDBC.高額自己負担上限額_37200);
            }
        }
        return Decimal.ZERO;
    }

    private RString get利用者負担第２段階(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (年月_200607.compareTo(給付実績中間.getServiceTeikyoYM()) <= 0
                && 給付実績中間.getServiceTeikyoYM().compareTo(年月_200806) <= 0
                && !ONE.equals(給付実績中間.getShotokuHantei_shoboKubun())
                && !ONE.equals(給付実績中間.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
            if (TWO.equals(給付実績中間.getShotokuHantei_kazeiKubunGemmenGo())
                    && !ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())
                    && 給付実績中間.getShotokuHantei_gokeiShotokuGaku().
                    add(給付実績中間.getShotokuHantei_nenkiniShunyuGaku()).compareTo(金額_800000) <= 0) {
                return ONE;
            } else if (!TWO.equals(給付実績中間.getShotokuHantei_kazeiKubunGemmenGo())
                    && !ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())
                    && 給付実績中間.getShotokuHantei_gokeiShotokuGaku().
                    add(給付実績中間.getShotokuHantei_nenkiniShunyuGaku()).compareTo(金額_800000) <= 0
                    && ONE.equals(給付実績中間.getShotokuHantei_gekihenKanwaKubun())) {
                return ONE;
            }
        }
        return RString.EMPTY;
    }

    private Decimal get老齢福祉区分の場合1(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())) {
            return get算定基準額コンフィグ(ConfigNameDBC.高額自己負担上限額_15000);
        } else {
            return get算定基準額コンフィグ(ConfigNameDBC.高額自己負担上限額_24600);
        }
    }

    private Decimal get老齢福祉区分の場合2(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (!ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())
                && 給付実績中間.getShotokuHantei_gokeiShotokuGaku().
                add(給付実績中間.getShotokuHantei_nenkiniShunyuGaku()).compareTo(金額_800000) <= 0) {
            return get算定基準額コンフィグ(ConfigNameDBC.高額自己負担上限額_15000);
        } else {
            return get算定基準額コンフィグ(ConfigNameDBC.高額自己負担上限額_24600);
        }
    }

    private Decimal get算定基準額コンフィグ(Enum キー) {
        RString 高額自己負担上限額 = DbBusinessConfig.get(キー, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        return RString.isNullOrEmpty(高額自己負担上限額) ? Decimal.ZERO : new Decimal(高額自己負担上限額.toString());
    }
}
