/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiChukanKogaku8Entity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
    private static final RString 作成区分_取消 = new RString("3");
    private static final RString TEXT_現 = new RString("現");
    private static final RString TEXT_般 = new RString("般");
    private static final FlexibleYearMonth 年月_200508 = new FlexibleYearMonth("200508");
    private static final FlexibleYearMonth 年月_200510 = new FlexibleYearMonth("200510");
    private static final FlexibleYearMonth 年月_200607 = new FlexibleYearMonth("200607");
    private static final FlexibleYearMonth 年月_200806 = new FlexibleYearMonth("200806");
    private static final FlexibleYearMonth 年月_201508 = new FlexibleYearMonth("200518");
    private static final Decimal 金額_800000 = new Decimal("800000");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final int INT_1 = 1;
    private static final int INT_8 = 8;
    private Decimal サービス費用額合計;
    private Decimal 利用者負担額合計;
    private KyufuJissekiChukanKogaku8Entity beforeEntity;
    private KyufuJissekiChukanKogaku8Entity before処理対象;
    private List<KyufuJissekiChukanKogaku8Entity> 処理対象List;
    private List<KyufuJissekiChukanKogaku8Entity> 給付実績中間高額一時明細List;
    private List<KyufuJissekiChukanKogaku8Entity> 給付実績中間高額一時取消明細List;
    private RString 高額自己負担上限額_15000;
    private RString 高額自己負担上限額_24600;
    private RString 高額自己負担上限額_37200;
    private RString 高額自己負担上限額_44000;
    private RDate sysDate;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter kyufujissekiTyukann8Writer;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
    }

    @Override
    protected void initialize() {
        sysDate = RDate.getNowDate();
        beforeEntity = null;
        before処理対象 = null;
        サービス費用額合計 = Decimal.ZERO;
        利用者負担額合計 = Decimal.ZERO;
        処理対象List = new ArrayList<>();
        給付実績中間高額一時明細List = new ArrayList<>();
        給付実績中間高額一時取消明細List = new ArrayList<>();
        高額自己負担上限額_15000 = DbBusinessConfig.get(ConfigNameDBC.高額自己負担上限額_15000,
                sysDate, SubGyomuCode.DBC介護給付);
        高額自己負担上限額_24600 = DbBusinessConfig.get(ConfigNameDBC.高額自己負担上限額_24600,
                sysDate, SubGyomuCode.DBC介護給付);
        高額自己負担上限額_37200 = DbBusinessConfig.get(ConfigNameDBC.高額自己負担上限額_37200,
                sysDate, SubGyomuCode.DBC介護給付);
        高額自己負担上限額_44000 = DbBusinessConfig.get(ConfigNameDBC.高額自己負担上限額_44000,
                sysDate, SubGyomuCode.DBC介護給付);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void createWriter() {
        kyufujissekiTyukann8Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績中間高額一時8, TempKyufujissekiTyukannEntity.class);
    }

    @Override
    protected void process(KyufuJissekiChukanKogaku8Entity entity) {
        if (beforeEntity == null) {
            beforeEntity = entity;
        }
        TempKyufujissekiTyukannEntity before給付実績中間 = beforeEntity.get給付実績中間高額一時();
        TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
        if (before給付実績中間.getShotokuHantei_setaiCode().equals(給付実績中間.getShotokuHantei_setaiCode())
                && before給付実績中間.getServiceTeikyoYM().equals(給付実績中間.getServiceTeikyoYM())) {
            処理対象List.add(entity);
            return;
        }
        List<KyufuJissekiChukanKogaku8Entity> 処理対象リスト = get処理対象List();
        処理対象List = new ArrayList<>();
        処理対象List.add(entity);
        for (KyufuJissekiChukanKogaku8Entity 処理対象 : 処理対象リスト) {
            do給付実績中間高額一時の作成(処理対象);
        }
    }

    @Override
    protected void afterExecute() {
        List<KyufuJissekiChukanKogaku8Entity> 処理対象リスト = get処理対象List();
        for (KyufuJissekiChukanKogaku8Entity 処理対象 : 処理対象リスト) {
            do給付実績中間高額一時の作成(処理対象);
        }
        do取消分合計と明細追加();
    }

    private void do給付実績中間高額一時の作成(KyufuJissekiChukanKogaku8Entity 処理対象) {
        if (before処理対象 == null) {
            before処理対象 = 処理対象;
        }
        TempKyufujissekiTyukannEntity before給付実績中間 = before処理対象.get給付実績中間高額一時();
        TempKyufujissekiTyukannEntity 給付実績中間 = 処理対象.get給付実績中間高額一時();
        if (!before給付実績中間.getShotokuHantei_setaiCode().equals(給付実績中間.getShotokuHantei_setaiCode())
                || !before給付実績中間.getShotokuHantei_jushochiTokureiFlag().equals(給付実績中間.getShotokuHantei_jushochiTokureiFlag())
                || !before給付実績中間.getShotokuHantei_shoboKubun().equals(給付実績中間.getShotokuHantei_shoboKubun())
                || !before給付実績中間.getServiceTeikyoYM().equals(給付実績中間.getServiceTeikyoYM())) {
            do取消分合計と明細追加();
            給付実績中間高額一時明細List = new ArrayList<>();
            給付実績中間高額一時取消明細List = new ArrayList<>();
            サービス費用額合計 = Decimal.ZERO;
            利用者負担額合計 = Decimal.ZERO;
        }
        Decimal 利用者負担額 = get利用者負担額を算出(給付実績中間);
        利用者負担額合計 = 利用者負担額合計.add(利用者負担額);
        getサービス費用合計を算出(給付実績中間);
        if (作成区分_取消.equals(給付実績中間.getKyufuSakuseiKubunCode())) {
            給付実績中間高額一時取消明細List.add(処理対象);
        } else {
            給付実績中間高額一時明細List.add(処理対象);
        }
        before処理対象 = 処理対象;
    }

    private List<KyufuJissekiChukanKogaku8Entity> get処理対象List() {
        List<KyufuJissekiChukanKogaku8Entity> 処理対象 = new ArrayList<>();
        if (処理対象List.isEmpty()) {
            return 処理対象;
        }
        List<KyufuJissekiChukanKogaku8Entity> 処理対象Comparator = get処理対象Comparator(処理対象List);
        HihokenshaNo 被保険者番号 = 処理対象Comparator.get(0).get基準収入額適用管理一時().getHihokenshaNo();
        FlexibleYearMonth 適用開始年月 = 処理対象Comparator.get(0).get基準収入額適用管理一時().getTekiyoKaishiYMD();
        for (KyufuJissekiChukanKogaku8Entity entity : 処理対象List) {
            if (被保険者番号.equals(entity.get基準収入額適用管理一時().getHihokenshaNo())
                    && 適用開始年月.equals(entity.get基準収入額適用管理一時().getTekiyoKaishiYMD())) {
                処理対象.add(entity);
            }
        }
        return 処理対象;
    }

    private List<KyufuJissekiChukanKogaku8Entity> get処理対象Comparator(List<KyufuJissekiChukanKogaku8Entity> 処理対象List) {
        if (処理対象List.isEmpty()) {
            return 処理対象List;
        }
        Collections.sort(処理対象List, new Comparator<KyufuJissekiChukanKogaku8Entity>() {
            @Override
            public int compare(KyufuJissekiChukanKogaku8Entity arg0, KyufuJissekiChukanKogaku8Entity arg1) {
                if (arg0.get基準収入額適用管理一時().getHihokenshaNo().getColumnValue().
                        compareTo(arg1.get基準収入額適用管理一時().getHihokenshaNo().getColumnValue()) == 0) {
                    return arg1.get基準収入額適用管理一時().getTekiyoKaishiYMD().
                            compareTo(arg0.get基準収入額適用管理一時().getTekiyoKaishiYMD());
                }
                return arg0.get基準収入額適用管理一時().getHihokenshaNo().getColumnValue().
                        compareTo(arg1.get基準収入額適用管理一時().getHihokenshaNo().getColumnValue());
            }
        });
        return 処理対象List;
    }

    private void do取消分合計と明細追加() {
        List<KyufuJissekiChukanKogaku8Entity> 給付実績中間高額一時List = new ArrayList<>();
        for (KyufuJissekiChukanKogaku8Entity entity : 給付実績中間高額一時取消明細List) {
            HihokenshaNo 被保険者番号 = entity.get給付実績中間高額一時().getHiHokenshaNo();
            if (!is明細に存在する(被保険者番号)) {
                insert給付実績中間高額一時8の新規2(entity.get給付実績中間高額一時());
                給付実績中間高額一時List.add(entity);
            }
        }
        if (給付実績中間高額一時List.isEmpty()) {
            return;
        }
        insert給付実績中間高額一時8の新規1();
        get世帯合算処理(給付実績中間高額一時List);
    }

    private boolean is明細に存在する(HihokenshaNo 被保険者番号) {
        for (KyufuJissekiChukanKogaku8Entity entity : 給付実績中間高額一時明細List) {
            if (被保険者番号.equals(entity.get給付実績中間高額一時().getHiHokenshaNo())) {
                return true;
            }
        }
        return false;
    }

    private void get世帯合算処理(List<KyufuJissekiChukanKogaku8Entity> 給付実績中間高額一時List) {
        List<KyufuJissekiChukanKogaku8Entity> 単独分List = new ArrayList<>();
        List<KyufuJissekiChukanKogaku8Entity> 世帯分List = new ArrayList<>();
        if (給付実績中間高額一時List.size() == INT_1) {
            単独分List.add(給付実績中間高額一時List.get(0));
            return;
        }
        for (KyufuJissekiChukanKogaku8Entity entity : 給付実績中間高額一時List) {
            TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
            if (ONE.equals(給付実績中間.getShotokuHantei_jushochiTokureiFlag())
                    && ONE.equals(給付実績中間.getShotokuHantei_shoboKubun())) {
                単独分List.add(entity);
            } else {
                世帯分List.add(entity);
            }
        }
        if (!単独分List.isEmpty()) {
            do単独分合計と明細追加(単独分List);
        }
        if (!世帯分List.isEmpty()) {
            do世帯分合計と明細追加(世帯分List);
        }
    }

    private void do単独分合計と明細追加(List<KyufuJissekiChukanKogaku8Entity> 単独分List) {
        for (KyufuJissekiChukanKogaku8Entity entity : 単独分List) {
            insert給付実績中間高額一時8の新規4(entity.get給付実績中間高額一時());
        }
    }

    private void do世帯分合計と明細追加(List<KyufuJissekiChukanKogaku8Entity> 世帯分List) {

    }
//
//    private Decimal get現システム算定基準額(KyufuJissekiChukanKogaku8Entity entity) {
//        TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
//        DbT3116KijunShunyugakuTekiyoKanriEntity 基準収入額適用管理一時 = entity.get基準収入額適用管理一時();
//        if (基準収入額適用管理一時 != null) {
//            if (SetaiKazeiKubun.非課税.getコード().equals(給付実績中間.getShotokuHantei_setaiKazeiKubun())) {
//                return get単独改修前の算定基準額(給付実績中間);
//            } else {
//                return get課税世帯基準額パターン1(entity);
//            }
//        } else {
//            if (SetaiKazeiKubun.非課税.getコード().equals(給付実績中間.getShotokuHantei_setaiKazeiKubun())) {
//                return get単独改修前の算定基準額(給付実績中間);
//            } else {
//                return get課税世帯基準額パターン2(entity);
//            }
//        }
//    }

    private Decimal get課税世帯基準額パターン1(KyufuJissekiChukanKogaku8Entity entity) {
        TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
        if (!is課税世帯パターン1(entity)) {
            return Decimal.ZERO;
        }
        if (給付実績中間.getServiceTeikyoYM().compareTo(年月_200508) < 0) {
            return get単独改修前の算定基準額(給付実績中間);
        } else {
            return get算定基準額コンフィグ(高額自己負担上限額_37200);
        }
    }

//    private Decimal get課税世帯基準額パターン2(KyufuJissekiChukanKogaku8Entity entity) {
//        if () {
//
//        }
//    }
    private boolean is課税世帯パターン1(KyufuJissekiChukanKogaku8Entity entity) {
        TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
        DbT3116KijunShunyugakuTekiyoKanriEntity 基準収入額適用管理一時 = entity.get基準収入額適用管理一時();
        if (!給付実績中間.getHiHokenshaNo().equals(基準収入額適用管理一時.getHihokenshaNo())) {
            return false;
        }
        if (!給付実績中間.getShotokuHantei_setaiCode().equals(基準収入額適用管理一時.getSetaiCode())) {
            return true;
        }
        FlexibleYear 年度 = getサービス提供年月より求めた年度(給付実績中間.getServiceTeikyoYM());
        if (!年度.equals(基準収入額適用管理一時.getNendo())) {
            return true;
        }
        return 給付実績中間.getServiceTeikyoYM().compareTo(基準収入額適用管理一時.getTekiyoKaishiYMD()) <= 0;
    }

//    private boolean is課税世帯パターン2(KyufuJissekiChukanKogaku8Entity entity) {
//        TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
//        DbT3116KijunShunyugakuTekiyoKanriEntity 基準収入額適用管理一時 = entity.get基準収入額適用管理一時();
//        if () {
//
//        }
//    }
    private FlexibleYear getサービス提供年月より求めた年度(FlexibleYearMonth サービス提供年月) {
        if (サービス提供年月.getMonthValue() < INT_8) {
            return サービス提供年月.getYear().minusYear(INT_1);
        } else {
            return サービス提供年月.getYear();
        }
    }

    private void insert給付実績中間高額一時8の新規1() {
        TempKyufujissekiTyukannEntity 給付実績中間高額一時
                = 給付実績中間高額一時取消明細List.get(0).get給付実績中間高額一時();
        給付実績中間高額一時.setShotokuHantei_setaiinShikibetsuCode(null);
        給付実績中間高額一時.setKogakuServicehiJogengakuGengakuGaitoFlag(null);
        給付実績中間高額一時.setKogakuServicehiJogengakuGengakugoJogengaku(null);
        給付実績中間高額一時.setHokenRiyoshaFutangaku(利用者負担額合計);
        給付実績中間高額一時.setDataKubun(ONE);
        給付実績中間高額一時.setServiceHiyougakuGokei(サービス費用額合計);
        給付実績中間高額一時.setSikyugaku(Decimal.ZERO);
        給付実績中間高額一時.setSanteiKijungaku(Decimal.ZERO);
        給付実績中間高額一時.setKogakuHanteiKekka(ONE);
        給付実績中間高額一時.setSagakuKubun(null);
        給付実績中間高額一時.setKoogakuKetteiKubun(null);
        給付実績中間高額一時.setBeikoSetaishotokuKubun(get備考欄世帯所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setBeikoKojinshotokuKubun(get備考欄個人所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setRiyoFitanDankai2(RString.EMPTY);
        kyufujissekiTyukann8Writer.insert(給付実績中間高額一時);
    }

    private void insert給付実績中間高額一時8の新規2(TempKyufujissekiTyukannEntity 給付実績中間高額一時) {
        給付実績中間高額一時.setKyufuSakuseiKubunCode(作成区分_取消);
        給付実績中間高額一時.setShotokuHantei_setaiinShikibetsuCode(null);
        給付実績中間高額一時.setKogakuServicehiJogengakuGengakuGaitoFlag(null);
        給付実績中間高額一時.setKogakuServicehiJogengakuGengakugoJogengaku(null);
        Decimal 利用者負担額 = get利用者負担額を算出(給付実績中間高額一時);
        給付実績中間高額一時.setHokenRiyoshaFutangaku(利用者負担額);
        給付実績中間高額一時.setDataKubun(TWO);
        給付実績中間高額一時.setServiceHiyougakuGokei(サービス費用額合計);
        // 支給（予定）額　QA確認中
        給付実績中間高額一時.setSikyugaku(Decimal.ZERO);
        給付実績中間高額一時.setSanteiKijungaku(Decimal.ZERO);
        給付実績中間高額一時.setKogakuHanteiKekka(ZERO);
        給付実績中間高額一時.setSagakuKubun(null);
        給付実績中間高額一時.setKoogakuKetteiKubun(null);
        給付実績中間高額一時.setBeikoSetaishotokuKubun(get備考欄世帯所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setBeikoKojinshotokuKubun(get備考欄個人所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setRiyoFitanDankai2(get利用者負担第２段階(給付実績中間高額一時));
        kyufujissekiTyukann8Writer.insert(給付実績中間高額一時);
    }

    private void insert給付実績中間高額一時8の新規4(TempKyufujissekiTyukannEntity 給付実績中間高額一時) {
//        RString 利用者負担第２段階 = get利用者負担第２段階(給付実績中間);
        RString 激変緩和区分 = get激変緩和区分(給付実績中間高額一時);
//        Decimal 算定基準額 = get単独改修前の算定基準額(給付実績中間);
        給付実績中間高額一時.setShotokuHantei_setaiinShikibetsuCode(null);
        給付実績中間高額一時.setShotokuHantei_gekihenKanwaKubun(激変緩和区分);
        給付実績中間高額一時.setKogakuServicehiJogengakuGengakuGaitoFlag(null);
        給付実績中間高額一時.setKogakuServicehiJogengakuGengakugoJogengaku(null);
        Decimal 利用者負担額 = get利用者負担額を算出(給付実績中間高額一時);
        給付実績中間高額一時.setHokenRiyoshaFutangaku(利用者負担額);
        給付実績中間高額一時.setDataKubun(TWO);
        給付実績中間高額一時.setServiceHiyougakuGokei(サービス費用額合計);
        // 支給（予定）額　QA確認中
        給付実績中間高額一時.setSikyugaku(Decimal.ZERO);
        給付実績中間高額一時.setSanteiKijungaku(Decimal.ZERO);
        給付実績中間高額一時.setKogakuHanteiKekka(ZERO);
        給付実績中間高額一時.setSagakuKubun(null);
        給付実績中間高額一時.setKoogakuKetteiKubun(null);
        給付実績中間高額一時.setBeikoSetaishotokuKubun(get備考欄世帯所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setBeikoKojinshotokuKubun(get備考欄個人所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setRiyoFitanDankai2(get利用者負担第２段階(給付実績中間高額一時));
        kyufujissekiTyukann8Writer.insert(給付実績中間高額一時);
    }

    private void getサービス費用合計を算出(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (作成区分_取消.equals(給付実績中間.getKyufuSakuseiKubunCode())) {
            return;
        }
        サービス費用額合計 = サービス費用額合計.
                add(formatByNull(給付実績中間.getServiceHiyougakuGokei())).
                add(formatByNull(給付実績中間.getMaeHokenSeikyugaku())).
                add(formatByNull(給付実績中間.getHokenDekidakaSeikyugaku())).
                add(formatByNull(給付実績中間.getHokenDekidakaIryohiRiyoshaFutangaku())).
                add(formatByNull(給付実績中間.getKohi1Seikyugaku())).
                add(formatByNull(給付実績中間.getKohi1HonninFutangaku())).
                add(formatByNull(給付実績中間.getKohi1DekidakaSeikyugaku())).
                add(formatByNull(給付実績中間.getKohi1DekidakaIryohiRiyoshaFutangaku())).
                add(formatByNull(給付実績中間.getKohi2Seikyugaku())).
                add(formatByNull(給付実績中間.getKohi2HonninFutangaku())).
                add(formatByNull(給付実績中間.getKohi2DekidakaSeikyugaku())).
                add(formatByNull(給付実績中間.getKohi2DekidakaIryohiRiyoshaFutangaku())).
                add(formatByNull(給付実績中間.getKohi3Seikyugaku())).
                add(formatByNull(給付実績中間.getKohi3HonninFutangaku())).
                add(formatByNull(給付実績中間.getKohi3DekidakaSeikyugaku())).
                add(formatByNull(給付実績中間.getKohi3DekidakaIryohiRiyoshaFutangaku()));
    }

    private Decimal get利用者負担額を算出(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (年月_200510.compareTo(給付実績中間.getServiceTeikyoYM()) <= 0
                && ONE.equals(給付実績中間.getKyufuJissekiShakaiFukushiHojinKeiUmu())) {
            return new Decimal(給付実績中間.getAtoHokenRiyoshaFutangaku()).
                    add(formatByNull(給付実績中間.getGoKeigengoRiyoshaFutangaku()));
        } else {
            return new Decimal(給付実績中間.getAtoHokenRiyoshaFutangaku()).
                    add(給付実績中間.getAtoKohi1RiyoshaFutangaku()).
                    add(給付実績中間.getAtoKohi2RiyoshaFutangaku()).
                    add(給付実績中間.getAtoKohi3RiyoshaFutangaku()).
                    add(formatByNull(給付実績中間.getKohi1DekidakaIryohiRiyoshaFutangaku())).
                    add(formatByNull(給付実績中間.getKohi2DekidakaIryohiRiyoshaFutangaku())).
                    add(formatByNull(給付実績中間.getKohi3DekidakaIryohiRiyoshaFutangaku()));
        }
    }

    private Decimal get単独改修前の算定基準額(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (給付実績中間.getServiceTeikyoYM().compareTo(年月_200510) < 0) {
            if (ONE.equals(給付実績中間.getShotokuHantei_shoboKubun())) {
                return get算定基準額コンフィグ(高額自己負担上限額_15000);
            } else if (ONE.equals(給付実績中間.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
                return 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku();
            } else if (TWO.equals(給付実績中間.getShotokuHantei_kazeiKubunGemmenGo())) {
                return get老齢福祉区分の場合1(給付実績中間);
            } else if (!ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())) {
                return get算定基準額コンフィグ(高額自己負担上限額_37200);
            }
        } else if (年月_200607.compareTo(給付実績中間.getServiceTeikyoYM()) <= 0
                && 給付実績中間.getServiceTeikyoYM().compareTo(年月_200806) <= 0) {
            if (ONE.equals(給付実績中間.getShotokuHantei_shoboKubun())) {
                return get算定基準額コンフィグ(高額自己負担上限額_15000);
            } else if (ONE.equals(給付実績中間.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
                return 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku();
            } else if (TWO.equals(給付実績中間.getShotokuHantei_kazeiKubunGemmenGo())) {
                return get老齢福祉区分の場合2(給付実績中間);
            } else if (!ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())) {
                return get算定基準額コンフィグ(高額自己負担上限額_37200);
            }
        } else {
            if (ONE.equals(給付実績中間.getShotokuHantei_shoboKubun())) {
                return get算定基準額コンフィグ(高額自己負担上限額_15000);
            } else if (ONE.equals(給付実績中間.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
                return 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku();
            } else if (TWO.equals(給付実績中間.getShotokuHantei_kazeiKubunGemmenGo())) {
                return get老齢福祉区分の場合2(給付実績中間);
            } else if (ONE.equals(給付実績中間.getShotokuHantei_gekihenKanwaKubun())) {
                return get老齢福祉区分の場合2(給付実績中間);
            } else {
                return get算定基準額コンフィグ(高額自己負担上限額_37200);
            }
        }
        return Decimal.ZERO;
    }

    private Decimal get世帯合算処理の算定基準額(TempKyufujissekiTyukannEntity 給付実績中間,
            List<KyufuJissekiChukanKogaku8Entity> 世帯分List) {
        Decimal 世帯算定基準額 = Decimal.ZERO;
        RString 利用者負担第2段階 = RString.EMPTY;
        RString 激変緩和区分 = RString.EMPTY;
        // TODO 給付実績中間高額一時.生活保護＝"1" QA確認中
        if (ONE.equals(給付実績中間.getTaishogoJotaiCode())
                && TWO.equals(給付実績中間.getShotokuHantei_kazeiKubunGemmenGo())) {
            世帯算定基準額 = get算定基準額コンフィグ(高額自己負担上限額_15000);
        }
        if (Decimal.ZERO.equals(給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku())) {
            if (TWO.equals(給付実績中間.getShotokuHantei_kazeiKubunGemmenGo())) {
                世帯算定基準額 = get算定基準額コンフィグ(高額自己負担上限額_24600);
            } else {
                世帯算定基準額 = get算定基準額コンフィグ(高額自己負担上限額_37200);
            }
        } else {
            世帯算定基準額 = 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku();
        }
        Decimal 最小の個人算定基準額 = Decimal.ZERO;
        Decimal 個人算定基準額合計 = Decimal.ZERO;
        for (KyufuJissekiChukanKogaku8Entity entity : 世帯分List) {
            Decimal 利用者負担額 = get利用者負担額を算出(entity.get給付実績中間高額一時());
            Decimal 個人算定基準額 = new Decimal(世帯算定基準額.multiply(利用者負担額).subtract(利用者負担額合計).intValue());
            if (個人算定基準額.compareTo(最小の個人算定基準額) < 0) {
                最小の個人算定基準額 = 個人算定基準額;
            }
            個人算定基準額合計 = 個人算定基準額合計.add(個人算定基準額);
        }
        Decimal 利用者負担額 = get利用者負担額を算出(給付実績中間);
        Decimal 個人算定基準額 = new Decimal(世帯算定基準額.multiply(利用者負担額).subtract(利用者負担額合計).intValue());
        if (最小の個人算定基準額.equals(個人算定基準額)
                && 個人算定基準額合計.compareTo(世帯算定基準額) < 0) {
            個人算定基準額 = 個人算定基準額.add(世帯算定基準額.multiply(個人算定基準額合計));
        }
        // 境界層区分、世帯所得区分 QA確認中
        if (ZERO.equals(給付実績中間.getChushiRiyuNyushomaeJyokyoCode())) {
            if (世帯算定基準額.equals(get算定基準額コンフィグ(高額自己負担上限額_24600))
                    && ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())
                    && get算定基準額コンフィグ(高額自己負担上限額_15000).compareTo(個人算定基準額) < 0) {
                個人算定基準額 = get算定基準額コンフィグ(高額自己負担上限額_15000);
            } else {
                Decimal ＷＫ金額 = 給付実績中間.getShotokuHantei_gokeiShotokuGaku().
                        add(給付実績中間.getShotokuHantei_nenkiniShunyuGaku());
                if (年月_200510.compareTo(給付実績中間.getServiceTeikyoYM()) <= 0
                        && get算定基準額コンフィグ(高額自己負担上限額_15000).equals(個人算定基準額)
                        && ＷＫ金額.compareTo(金額_800000) < 0) {
                    利用者負担第2段階 = ONE;
                    if (get算定基準額コンフィグ(高額自己負担上限額_15000).compareTo(個人算定基準額) < 0) {
                        個人算定基準額 = get算定基準額コンフィグ(高額自己負担上限額_15000);
                    }
                } else {
                    // ａ．共通管理の激変緩和適用開始年月≦サービス提供年月（ｎ）≦共通管理の激変緩和適用終了年月かつ
                    // QA確認中
                    if (ONE.equals(給付実績中間.getShotokuHantei_gekihenKanwaKubun())
                            && ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())) {
                        激変緩和区分 = ONE;
                        if (get算定基準額コンフィグ(高額自己負担上限額_15000).compareTo(個人算定基準額) < 0) {
                            個人算定基準額 = get算定基準額コンフィグ(高額自己負担上限額_15000);
                        }
                    } else {
                        激変緩和区分 = TWO;
                        if (get算定基準額コンフィグ(高額自己負担上限額_24600).compareTo(個人算定基準額) < 0) {
                            個人算定基準額 = get算定基準額コンフィグ(高額自己負担上限額_24600);
                        }
                    }
                }
            }
        }
        return 世帯算定基準額;
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

    private RString get激変緩和区分(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (年月_200607.compareTo(給付実績中間.getServiceTeikyoYM()) <= 0
                && 給付実績中間.getServiceTeikyoYM().compareTo(年月_200806) <= 0
                && !ONE.equals(給付実績中間.getShotokuHantei_shoboKubun())
                && !ONE.equals(給付実績中間.getKogakuServicehiJogengakuGengakuGaitoFlag())
                && !TWO.equals(給付実績中間.getShotokuHantei_kazeiKubunGemmenGo())
                && ONE.equals(給付実績中間.getShotokuHantei_gekihenKanwaKubun())) {
            if (ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())) {
                return ONE;
            } else {
                return TWO;
            }
        }
        return RString.EMPTY;
    }

    private Decimal get老齢福祉区分の場合1(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())) {
            return get算定基準額コンフィグ(高額自己負担上限額_15000);
        } else {
            return get算定基準額コンフィグ(高額自己負担上限額_24600);
        }
    }

    private Decimal get老齢福祉区分の場合2(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (!ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())
                && 給付実績中間.getShotokuHantei_gokeiShotokuGaku().
                add(給付実績中間.getShotokuHantei_nenkiniShunyuGaku()).compareTo(金額_800000) <= 0) {
            return get算定基準額コンフィグ(高額自己負担上限額_15000);
        } else {
            return get算定基準額コンフィグ(高額自己負担上限額_24600);
        }
    }

    private Decimal get算定基準額コンフィグ(RString 高額自己負担上限額) {
        return RString.isNullOrEmpty(高額自己負担上限額) ? Decimal.ZERO : new Decimal(高額自己負担上限額.toString());
    }

    private RString get備考欄世帯所得区分(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (ONE.equals(給付実績中間.getShotokuHantei_honninKubun())) {
            return get備考欄(給付実績中間);
        } else {
            return RString.EMPTY;
        }
    }

    private RString get備考欄個人所得区分(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (ONE.equals(給付実績中間.getShotokuHantei_honninKubun())) {
            return RString.EMPTY;
        } else {
            return get備考欄(給付実績中間);
        }
    }

    private RString get備考欄(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (年月_201508.compareTo(給付実績中間.getServiceTeikyoYM()) < 0) {
            if (get算定基準額コンフィグ(高額自己負担上限額_44000).equals(給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku())) {
                return TEXT_現;
            } else if (get算定基準額コンフィグ(高額自己負担上限額_37200).equals(給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku())) {
                return TEXT_般;
            }
        }
        return RString.EMPTY;
    }

    private Decimal formatByNull(Decimal 金額) {
        return 金額 == null ? Decimal.ZERO : 金額;
    }
}
