/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannJigyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinShotokuHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiChukanKogakuJigyo8Entity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 給付実績中間事業高額一時の作成8のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 tianshuai
 */
public class InsKyufuJissekiChukanJigyoKogakuTmpProcess8 extends BatchProcessBase<KyufuJissekiChukanKogakuJigyo8Entity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select給付実績中間事業高額一時の作成8");
    private static final RString TABLE_給付実績基本情報事業高額一時8 = new RString("TempKyufujissekiTyukannJigyo8");
    private static final RString 作成区分_取消 = new RString("3");
    private static final RString TEXT_現 = new RString("現");
    private static final RString TEXT_般 = new RString("般");
    private static final RString KEY_利用者負担第2段階 = new RString("利用者負担第2段階");
    private static final RString KEY_支給予定額 = new RString("支給予定額");
    private static final RString KEY_個人算定基準額 = new RString("個人算定基準額");
    private static final FlexibleYearMonth 年月_201508 = new FlexibleYearMonth("200518");
    private static final RString 日期_1231 = new RString("1231");
    private static final Decimal 金額_800000 = new Decimal("800000");
    private static final Decimal 金額_145万 = new Decimal("1450000");
    private static final Decimal 金額_144万 = new Decimal("1440000");
    private static final Decimal 金額_38万 = new Decimal("380000");
    private static final Decimal 金額_33万 = new Decimal("330000");
    private static final Decimal 金額_12万 = new Decimal("120000");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString FIVE = new RString("5");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_8 = 8;
    private static final int INT_15 = 15;
    private static final int INT_18 = 18;
    private Decimal サービス費用額合計;
    private Decimal 利用者負担額合計;
    private Decimal 利用者負担額合計_総合事業分;
    private Decimal 支給予定額合計;
    private Decimal 算定基準額合計;
    private KyufuJissekiChukanKogakuJigyo8Entity beforeEntity;
    private KyufuJissekiChukanKogakuJigyo8Entity before処理対象;
    private List<KyufuJissekiChukanKogakuJigyo8Entity> 処理対象List;
    private List<KyufuJissekiChukanKogakuJigyo8Entity> 給付実績中間事業高額一時明細List;
    private List<KyufuJissekiChukanKogakuJigyo8Entity> 給付実績中間事業高額一時取消明細List;
    private RString 高額自己負担上限額_15000;
    private RString 高額自己負担上限額_24600;
    private RString 高額自己負担上限額_37200;
    private RString 高額自己負担上限額_44000;
    private RString 高額自己負担上限額_44400;
    private RDate sysDate;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter kyufujissekiTyukann8Writer;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void initialize() {
        sysDate = RDate.getNowDate();
        beforeEntity = null;
        before処理対象 = null;
        clear合計();
        処理対象List = new ArrayList<>();
        給付実績中間事業高額一時明細List = new ArrayList<>();
        給付実績中間事業高額一時取消明細List = new ArrayList<>();
        高額自己負担上限額_15000 = DbBusinessConfig.get(ConfigNameDBC.高額自己負担上限額_15000,
                sysDate, SubGyomuCode.DBC介護給付);
        高額自己負担上限額_24600 = DbBusinessConfig.get(ConfigNameDBC.高額自己負担上限額_24600,
                sysDate, SubGyomuCode.DBC介護給付);
        高額自己負担上限額_37200 = DbBusinessConfig.get(ConfigNameDBC.高額自己負担上限額_37200,
                sysDate, SubGyomuCode.DBC介護給付);
        高額自己負担上限額_44000 = DbBusinessConfig.get(ConfigNameDBC.高額自己負担上限額_44000,
                sysDate, SubGyomuCode.DBC介護給付);
        高額自己負担上限額_44400 = DbBusinessConfig.get(ConfigNameDBC.高額自己負担上限額_44400,
                sysDate, SubGyomuCode.DBC介護給付);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void createWriter() {
        kyufujissekiTyukann8Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_給付実績基本情報事業高額一時8, TempKyufujissekiTyukannJigyoEntity.class);
    }

    @Override
    protected void process(KyufuJissekiChukanKogakuJigyo8Entity entity) {
        if (beforeEntity == null) {
            beforeEntity = entity;
        }
        TempKyufujissekiTyukannJigyoEntity before給付実績中間 = beforeEntity.get給付実績基本情報事業高額一時();
        TempKyufujissekiTyukannJigyoEntity 給付実績中間 = entity.get給付実績基本情報事業高額一時();
        if (給付実績中間.getShotokuHantei_shoboKubun() == null) {
            return;
        }
        if (before給付実績中間.getShotokuHantei_setaiCode().equals(給付実績中間.getShotokuHantei_setaiCode())
                && before給付実績中間.getServiceTeikyoYM().equals(給付実績中間.getServiceTeikyoYM())) {
            処理対象List.add(entity);
            return;
        }
        List<KyufuJissekiChukanKogakuJigyo8Entity> 処理対象リスト = get処理対象List();
        処理対象List = new ArrayList<>();
        for (KyufuJissekiChukanKogakuJigyo8Entity 処理対象 : 処理対象リスト) {
            do給付実績中間事業高額一時の作成(処理対象);
        }
    }

    @Override
    protected void afterExecute() {
        List<KyufuJissekiChukanKogakuJigyo8Entity> 処理対象リスト = get処理対象List();
        for (KyufuJissekiChukanKogakuJigyo8Entity 処理対象 : 処理対象リスト) {
            do給付実績中間事業高額一時の作成(処理対象);
        }
        do取消分合計と明細追加();
    }

    private void do給付実績中間事業高額一時の作成(KyufuJissekiChukanKogakuJigyo8Entity 処理対象) {
        if (before処理対象 == null) {
            before処理対象 = 処理対象;
        }
        TempKyufujissekiTyukannJigyoEntity before給付実績中間 = before処理対象.get給付実績基本情報事業高額一時();
        TempKyufujissekiTyukannJigyoEntity 給付実績中間 = 処理対象.get給付実績基本情報事業高額一時();
        if (!before給付実績中間.getShotokuHantei_setaiCode().equals(給付実績中間.getShotokuHantei_setaiCode())
                || !before給付実績中間.getShotokuHantei_jushochiTokureiFlag().equals(給付実績中間.getShotokuHantei_jushochiTokureiFlag())
                || !before給付実績中間.getShotokuHantei_shoboKubun().equals(給付実績中間.getShotokuHantei_shoboKubun())
                || !before給付実績中間.getServiceTeikyoYM().equals(給付実績中間.getServiceTeikyoYM())) {
            do取消分合計と明細追加();
            給付実績中間事業高額一時明細List = new ArrayList<>();
            給付実績中間事業高額一時取消明細List = new ArrayList<>();
            clear合計();
        }
        if (作成区分_取消.equals(給付実績中間.getKyufuSakuseiKubunCode())) {
            給付実績中間事業高額一時取消明細List.add(処理対象);
        } else {
            給付実績中間事業高額一時明細List.add(処理対象);
        }
        before処理対象 = 処理対象;
    }

    private List<KyufuJissekiChukanKogakuJigyo8Entity> get処理対象List() {
        List<KyufuJissekiChukanKogakuJigyo8Entity> 処理対象 = new ArrayList<>();
        if (処理対象List.isEmpty()) {
            return 処理対象;
        }
        List<KyufuJissekiChukanKogakuJigyo8Entity> 処理対象Comparator = get処理対象Comparator(処理対象List);
        if (処理対象Comparator.get(0).get基準収入額適用管理一時() == null) {
            return 処理対象List;
        }
        HihokenshaNo 被保険者番号 = 処理対象Comparator.get(0).get基準収入額適用管理一時().getHihokenshaNo();
        FlexibleYearMonth 適用開始年月 = 処理対象Comparator.get(0).get基準収入額適用管理一時().getTekiyoKaishiYMD();
        FlexibleYearMonth 最小の適用開始年月 = 処理対象Comparator.get(処理対象Comparator.size() - INT_1).
                get基準収入額適用管理一時().getTekiyoKaishiYMD();
        for (KyufuJissekiChukanKogakuJigyo8Entity entity : 処理対象List) {
            if (!適用開始年月.equals(最小の適用開始年月)
                    && 適用開始年月.equals(entity.get基準収入額適用管理一時().getTekiyoKaishiYMD())) {
                処理対象.add(entity);
                continue;
            }
            if (適用開始年月.equals(最小の適用開始年月)
                    && 被保険者番号.equals(entity.get基準収入額適用管理一時().getHihokenshaNo())) {
                処理対象.add(entity);
            }
        }
        return 処理対象;
    }

    private List<KyufuJissekiChukanKogakuJigyo8Entity> get処理対象Comparator(List<KyufuJissekiChukanKogakuJigyo8Entity> 処理対象List) {
        if (処理対象List.isEmpty()) {
            return 処理対象List;
        }
        Collections.sort(処理対象List, new Comparator<KyufuJissekiChukanKogakuJigyo8Entity>() {
            @Override
            public int compare(KyufuJissekiChukanKogakuJigyo8Entity arg0, KyufuJissekiChukanKogakuJigyo8Entity arg1) {
                if (arg1.get基準収入額適用管理一時() == null
                        || arg0.get基準収入額適用管理一時() == null) {
                    return -1;
                }
                if (arg0.get基準収入額適用管理一時().getTekiyoKaishiYMD() == null
                        || arg1.get基準収入額適用管理一時().getTekiyoKaishiYMD() == null) {
                    return arg0.get基準収入額適用管理一時().getHihokenshaNo().getColumnValue().
                            compareTo(arg1.get基準収入額適用管理一時().getHihokenshaNo().getColumnValue());
                }
                if (arg1.get基準収入額適用管理一時().getTekiyoKaishiYMD().
                        compareTo(arg0.get基準収入額適用管理一時().getTekiyoKaishiYMD()) == 0) {
                    return arg0.get基準収入額適用管理一時().getHihokenshaNo().getColumnValue().
                            compareTo(arg1.get基準収入額適用管理一時().getHihokenshaNo().getColumnValue());
                }
                return arg1.get基準収入額適用管理一時().getTekiyoKaishiYMD().
                        compareTo(arg0.get基準収入額適用管理一時().getTekiyoKaishiYMD());

            }
        });
        return 処理対象List;
    }

    private void do取消分合計と明細追加() {
        List<KyufuJissekiChukanKogakuJigyo8Entity> 給付実績中間事業高額一時List = new ArrayList<>();
        for (KyufuJissekiChukanKogakuJigyo8Entity entity : 給付実績中間事業高額一時取消明細List) {
            HihokenshaNo 被保険者番号 = entity.get給付実績基本情報事業高額一時().getHiHokenshaNo();
            if (!is明細に存在する(被保険者番号)) {
                insert給付実績中間事業高額一時8の新規2(entity);
                給付実績中間事業高額一時List.add(entity);
            }
        }
        if (!給付実績中間事業高額一時List.isEmpty()) {
            insert給付実績中間事業高額一時8の新規1(給付実績中間事業高額一時List.get(0));
        }
        clear合計();
        get世帯合算処理();
    }

    private boolean is明細に存在する(HihokenshaNo 被保険者番号) {
        for (KyufuJissekiChukanKogakuJigyo8Entity entity : 給付実績中間事業高額一時明細List) {
            if (被保険者番号.equals(entity.get給付実績基本情報事業高額一時().getHiHokenshaNo())) {
                return true;
            }
        }
        return false;
    }

    private void get世帯合算処理() {
        List<KyufuJissekiChukanKogakuJigyo8Entity> 単独分List = new ArrayList<>();
        List<KyufuJissekiChukanKogakuJigyo8Entity> 世帯分List = new ArrayList<>();
        if (給付実績中間事業高額一時明細List.size() == INT_1) {
            単独分List.add(給付実績中間事業高額一時明細List.get(0));
        } else {
            for (KyufuJissekiChukanKogakuJigyo8Entity entity : 給付実績中間事業高額一時明細List) {
                TempKyufujissekiTyukannJigyoEntity 給付実績中間 = entity.get給付実績基本情報事業高額一時();
                if (ONE.equals(給付実績中間.getShotokuHantei_jushochiTokureiFlag())
                        && ONE.equals(給付実績中間.getShotokuHantei_shoboKubun())) {
                    単独分List.add(entity);
                } else {
                    世帯分List.add(entity);
                }
            }
        }
        if (!単独分List.isEmpty()) {
            do単独分合計と明細追加(単独分List);
        }
        if (!世帯分List.isEmpty()) {
            do世帯分合計と明細追加(世帯分List);
        }
    }

    private void do単独分合計と明細追加(List<KyufuJissekiChukanKogakuJigyo8Entity> 単独分List) {
        for (KyufuJissekiChukanKogakuJigyo8Entity entity : 単独分List) {
            TempKyufujissekiTyukannJigyoEntity 給付実績中間 = entity.get給付実績基本情報事業高額一時();
            Decimal 利用者負担額 = get利用者負担額を算出(給付実績中間);
            Decimal 総合事業分利用者負担額 = get総合事業分利用者負担額を算出(給付実績中間);
            if (is総合事業分(entity)) {
                利用者負担額合計_総合事業分 = 利用者負担額合計_総合事業分.add(総合事業分利用者負担額);
            } else {
                利用者負担額合計 = 利用者負担額合計.add(利用者負担額);
            }
        }
        for (KyufuJissekiChukanKogakuJigyo8Entity entity : 単独分List) {
            insert給付実績中間事業高額一時8の新規4(entity);
        }
        insert給付実績中間事業高額一時8の新規3(単独分List.get(0));
        clear合計();
    }

    private void do世帯分合計と明細追加(List<KyufuJissekiChukanKogakuJigyo8Entity> 世帯分List) {
        for (KyufuJissekiChukanKogakuJigyo8Entity entity : 世帯分List) {
            TempKyufujissekiTyukannJigyoEntity 給付実績中間 = entity.get給付実績基本情報事業高額一時();
            Decimal 利用者負担額 = get利用者負担額を算出(給付実績中間);
            Decimal 総合事業分利用者負担額 = get総合事業分利用者負担額を算出(給付実績中間);
            if (is総合事業分(entity)) {
                利用者負担額合計_総合事業分 = 利用者負担額合計_総合事業分.add(総合事業分利用者負担額);
            } else {
                利用者負担額合計 = 利用者負担額合計.add(利用者負担額);
            }
        }
        for (KyufuJissekiChukanKogakuJigyo8Entity entity : 世帯分List) {
            insert給付実績中間事業高額一時8の新規6(entity, 世帯分List);
        }
        insert給付実績中間事業高額一時8の新規5(世帯分List.get(0));
        clear合計();
    }

    private FlexibleYear getサービス提供年月より求めた年度(FlexibleYearMonth サービス提供年月) {
        if (サービス提供年月.getMonthValue() < INT_8) {
            return サービス提供年月.getYear().minusYear(INT_1);
        } else {
            return サービス提供年月.getYear();
        }
    }

    private void insert給付実績中間事業高額一時8の新規1(KyufuJissekiChukanKogakuJigyo8Entity entity) {
        TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額一時
                = 給付実績中間事業高額一時取消明細List.get(0).get給付実績基本情報事業高額一時();
        Decimal サービス費用額;
        if (is総合事業分(entity)) {
            サービス費用額 = get総合事業分サービス費用合計を算出(給付実績中間事業高額一時);
        } else {
            サービス費用額 = getサービス費用合計を算出(給付実績中間事業高額一時);
        }
        給付実績中間事業高額一時.setHokenRiyoshaFutangaku(利用者負担額合計);
        給付実績中間事業高額一時.setDataKubun(ONE);
        給付実績中間事業高額一時.setServiceHiyougakuGokei(サービス費用額);
        給付実績中間事業高額一時.setSikyugaku(Decimal.ZERO);
        給付実績中間事業高額一時.setSanteiKijungaku(Decimal.ZERO);
        給付実績中間事業高額一時.setKogakuHanteiKekka(ONE);
        給付実績中間事業高額一時.setSagakuKubun(RString.EMPTY);
        給付実績中間事業高額一時.setKoogakuKetteiKubun(RString.EMPTY);
        給付実績中間事業高額一時.setBeikoSetaishotokuKubun(RString.EMPTY);
        給付実績中間事業高額一時.setBeikoKojinshotokuKubun(RString.EMPTY);
        給付実績中間事業高額一時.setRiyoFitanDankai2(RString.EMPTY);
        kyufujissekiTyukann8Writer.insert(給付実績中間事業高額一時);
    }

    private void insert給付実績中間事業高額一時8の新規2(KyufuJissekiChukanKogakuJigyo8Entity entity) {
        TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額一時 = entity.get給付実績基本情報事業高額一時();
        Decimal サービス費用額;
        Decimal 利用者負担額;
        if (is総合事業分(entity)) {
            サービス費用額 = get総合事業分サービス費用合計を算出(給付実績中間事業高額一時);
            利用者負担額 = get総合事業分利用者負担額を算出(給付実績中間事業高額一時);
            利用者負担額合計_総合事業分 = 利用者負担額合計.add(利用者負担額);
        } else {
            サービス費用額 = getサービス費用合計を算出(給付実績中間事業高額一時);
            利用者負担額 = get利用者負担額を算出(給付実績中間事業高額一時);
            利用者負担額合計 = 利用者負担額合計.add(利用者負担額);
        }
        給付実績中間事業高額一時.setKyufuSakuseiKubunCode(作成区分_取消);
        給付実績中間事業高額一時.setHokenRiyoshaFutangaku(利用者負担額);
        給付実績中間事業高額一時.setDataKubun(TWO);
        給付実績中間事業高額一時.setServiceHiyougakuGokei(サービス費用額);
        給付実績中間事業高額一時.setSikyugaku(Decimal.ZERO);
        給付実績中間事業高額一時.setSanteiKijungaku(Decimal.ZERO);
        給付実績中間事業高額一時.setKogakuHanteiKekka(get備考欄1(給付実績中間事業高額一時));
        給付実績中間事業高額一時.setSagakuKubun(RString.EMPTY);
        給付実績中間事業高額一時.setKoogakuKetteiKubun(ZERO);
        給付実績中間事業高額一時.setBeikoSetaishotokuKubun(get備考欄(給付実績中間事業高額一時));
        給付実績中間事業高額一時.setBeikoKojinshotokuKubun(RString.EMPTY);
        給付実績中間事業高額一時.setRiyoFitanDankai2(RString.EMPTY);
        kyufujissekiTyukann8Writer.insert(給付実績中間事業高額一時);
    }

    private void insert給付実績中間事業高額一時8の新規3(KyufuJissekiChukanKogakuJigyo8Entity entity) {
        TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額一時 = entity.get給付実績基本情報事業高額一時();
        給付実績中間事業高額一時.setHokenRiyoshaFutangaku(利用者負担額合計);
        給付実績中間事業高額一時.setDataKubun(ONE);
        給付実績中間事業高額一時.setServiceHiyougakuGokei(サービス費用額合計);
        給付実績中間事業高額一時.setSikyugaku(支給予定額合計);
        給付実績中間事業高額一時.setSanteiKijungaku(算定基準額合計);
        給付実績中間事業高額一時.setKogakuHanteiKekka(ONE);
        給付実績中間事業高額一時.setSagakuKubun(RString.EMPTY);
        給付実績中間事業高額一時.setKoogakuKetteiKubun(RString.EMPTY);
        給付実績中間事業高額一時.setBeikoSetaishotokuKubun(RString.EMPTY);
        給付実績中間事業高額一時.setBeikoKojinshotokuKubun(RString.EMPTY);
        給付実績中間事業高額一時.setRiyoFitanDankai2(RString.EMPTY);
        kyufujissekiTyukann8Writer.insert(給付実績中間事業高額一時);
    }

    private void insert給付実績中間事業高額一時8の新規4(KyufuJissekiChukanKogakuJigyo8Entity entity) {
        TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額一時 = entity.get給付実績基本情報事業高額一時();
        Decimal 算定基準額 = get単一合算の算定基準額(給付実績中間事業高額一時);
        Decimal 高額ｻｰﾋﾞｽ費支給額 = 給付実績中間事業高額一時.getKogakuKaigoServicehi();
        Decimal 支給予定額 = Decimal.ZERO;
        Decimal サービス費用額;
        if (is総合事業分(entity)) {
            サービス費用額 = get総合事業分サービス費用合計を算出(給付実績中間事業高額一時);
        } else {
            サービス費用額 = getサービス費用合計を算出(給付実績中間事業高額一時);
        }
        if (nullToZero(算定基準額).compareTo(nullToZero(利用者負担額合計_総合事業分)
                .subtract(nullToZero(高額ｻｰﾋﾞｽ費支給額))) < 0) {
            支給予定額 = nullToZero(利用者負担額合計_総合事業分)
                    .subtract(nullToZero(高額ｻｰﾋﾞｽ費支給額)).subtract(nullToZero(算定基準額));
        }
        Decimal 現システム算定基準額 = get現システム算定基準額(entity, 算定基準額);
        サービス費用額合計 = サービス費用額合計.add(サービス費用額);
        支給予定額合計 = 支給予定額合計.add(支給予定額);
        算定基準額合計 = 算定基準額合計.add(現システム算定基準額);
        給付実績中間事業高額一時.setShotokuHantei_gekihenKanwaKubun(RString.EMPTY);
        Decimal 利用者負担額 = get利用者負担額を算出(給付実績中間事業高額一時);
        給付実績中間事業高額一時.setHokenRiyoshaFutangaku(利用者負担額);
        給付実績中間事業高額一時.setDataKubun(TWO);
        給付実績中間事業高額一時.setServiceHiyougakuGokei(サービス費用額);
        給付実績中間事業高額一時.setSikyugaku(支給予定額);
        給付実績中間事業高額一時.setSanteiKijungaku(現システム算定基準額);
        給付実績中間事業高額一時.setKogakuHanteiKekka(ZERO);
        給付実績中間事業高額一時.setSagakuKubun(RString.EMPTY);
        給付実績中間事業高額一時.setKoogakuKetteiKubun(get備考欄1(給付実績中間事業高額一時));
        給付実績中間事業高額一時.setBeikoSetaishotokuKubun(get備考欄(給付実績中間事業高額一時));
        給付実績中間事業高額一時.setBeikoKojinshotokuKubun(RString.EMPTY);
        給付実績中間事業高額一時.setRiyoFitanDankai2(RString.EMPTY);
        kyufujissekiTyukann8Writer.insert(給付実績中間事業高額一時);
    }

    private void insert給付実績中間事業高額一時8の新規5(KyufuJissekiChukanKogakuJigyo8Entity entity) {
        TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額一時 = entity.get給付実績基本情報事業高額一時();
        給付実績中間事業高額一時.setKogakuServicehiJogengakuGengakuGaitoFlag(null);
        給付実績中間事業高額一時.setKogakuServicehiJogengakuGengakugoJogengaku(null);
        給付実績中間事業高額一時.setKogakuKaigoServicehi(null);
        給付実績中間事業高額一時.setHokenRiyoshaFutangaku(利用者負担額合計);
        給付実績中間事業高額一時.setDataKubun(ONE);
        給付実績中間事業高額一時.setServiceHiyougakuGokei(サービス費用額合計);
        給付実績中間事業高額一時.setSikyugaku(支給予定額合計);
        給付実績中間事業高額一時.setSanteiKijungaku(算定基準額合計);
        給付実績中間事業高額一時.setKogakuHanteiKekka(ONE);
        給付実績中間事業高額一時.setSagakuKubun(RString.EMPTY);
        給付実績中間事業高額一時.setKoogakuKetteiKubun(RString.EMPTY);
        給付実績中間事業高額一時.setBeikoSetaishotokuKubun(RString.EMPTY);
        給付実績中間事業高額一時.setBeikoKojinshotokuKubun(RString.EMPTY);
        給付実績中間事業高額一時.setRiyoFitanDankai2(RString.EMPTY);
        kyufujissekiTyukann8Writer.insert(給付実績中間事業高額一時);
    }

    private void insert給付実績中間事業高額一時8の新規6(KyufuJissekiChukanKogakuJigyo8Entity entity,
            List<KyufuJissekiChukanKogakuJigyo8Entity> 世帯分List) {
        TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額一時 = entity.get給付実績基本情報事業高額一時();
        Map 出力Map = get世帯合算処理の算定基準額(給付実績中間事業高額一時, 世帯分List);
        Decimal 算定基準額 = (Decimal) 出力Map.get(KEY_個人算定基準額);
        Decimal 支給予定額 = (Decimal) 出力Map.get(KEY_支給予定額);
        Decimal 利用者負担額 = get利用者負担額を算出(給付実績中間事業高額一時);
        Decimal 現システム算定基準額 = get現システム算定基準額(entity, 算定基準額);
        Decimal サービス費用額;
        if (is総合事業分(entity)) {
            サービス費用額 = get総合事業分サービス費用合計を算出(給付実績中間事業高額一時);
        } else {
            サービス費用額 = getサービス費用合計を算出(給付実績中間事業高額一時);
        }
        支給予定額合計 = 支給予定額合計.add(支給予定額);
        算定基準額合計 = 算定基準額合計.add(現システム算定基準額);
        サービス費用額合計 = サービス費用額合計.add(サービス費用額);
        給付実績中間事業高額一時.setShotokuHantei_gekihenKanwaKubun(RString.EMPTY);
        給付実績中間事業高額一時.setHokenRiyoshaFutangaku(利用者負担額);
        給付実績中間事業高額一時.setDataKubun(TWO);
        給付実績中間事業高額一時.setServiceHiyougakuGokei(サービス費用額);
        給付実績中間事業高額一時.setSikyugaku(支給予定額);
        給付実績中間事業高額一時.setSanteiKijungaku(現システム算定基準額);
        給付実績中間事業高額一時.setKogakuHanteiKekka(RString.EMPTY);
        給付実績中間事業高額一時.setSagakuKubun(get備考欄2(給付実績中間事業高額一時));
        給付実績中間事業高額一時.setKoogakuKetteiKubun(ZERO);
        給付実績中間事業高額一時.setBeikoSetaishotokuKubun(get備考欄(給付実績中間事業高額一時));
        給付実績中間事業高額一時.setBeikoKojinshotokuKubun(RString.EMPTY);
        給付実績中間事業高額一時.setRiyoFitanDankai2(RString.EMPTY);
        kyufujissekiTyukann8Writer.insert(給付実績中間事業高額一時);
    }

    private Decimal getサービス費用合計を算出(TempKyufujissekiTyukannJigyoEntity 給付実績中間) {
        if (作成区分_取消.equals(給付実績中間.getKyufuSakuseiKubunCode())) {
            return Decimal.ZERO;
        }
        return nullToZero(給付実績中間.getServiceHiyougakuGokei()).
                add(nullToZero(給付実績中間.getServiceHiyougakuGokei())).
                add(nullToZero(給付実績中間.getHokenSeikyugaku())).
                add(nullToZero(給付実績中間.getHokenDekidakaSeikyugaku())).
                add(nullToZero(給付実績中間.getHokenDekidakaIryohiRiyoshaFutangaku())).
                add(nullToZero(給付実績中間.getKohi1Seikyugaku())).
                add(nullToZero(給付実績中間.getKohi1HonninFutangaku())).
                add(nullToZero(給付実績中間.getKohi1DekidakaSeikyugaku())).
                add(nullToZero(給付実績中間.getKohi1DekidakaIryohiRiyoshaFutangaku())).
                add(nullToZero(給付実績中間.getKohi2Seikyugaku())).
                add(nullToZero(給付実績中間.getKohi2HonninFutangaku())).
                add(nullToZero(給付実績中間.getKohi2DekidakaSeikyugaku())).
                add(nullToZero(給付実績中間.getKohi2DekidakaIryohiRiyoshaFutangaku())).
                add(nullToZero(給付実績中間.getKohi3Seikyugaku())).
                add(nullToZero(給付実績中間.getKohi3HonninFutangaku())).
                add(nullToZero(給付実績中間.getKohi3DekidakaSeikyugaku())).
                add(nullToZero(給付実績中間.getKohi3DekidakaIryohiRiyoshaFutangaku()));
    }

    private Decimal get総合事業分サービス費用合計を算出(TempKyufujissekiTyukannJigyoEntity 給付実績中間) {
        if (作成区分_取消.equals(給付実績中間.getKyufuSakuseiKubunCode())) {
            return Decimal.ZERO;
        }
        return nullToZero(給付実績中間.getServiceHiyougakuGokei()).
                add(nullToZero(給付実績中間.getHokenSeikyugaku())).
                add(nullToZero(給付実績中間.getHokenDekidakaSeikyugaku())).
                add(nullToZero(給付実績中間.getHokenDekidakaIryohiRiyoshaFutangaku())).
                add(nullToZero(給付実績中間.getKohi1Seikyugaku())).
                add(nullToZero(給付実績中間.getKohi1HonninFutangaku())).
                add(nullToZero(給付実績中間.getKohi1DekidakaSeikyugaku())).
                add(nullToZero(給付実績中間.getKohi1DekidakaIryohiRiyoshaFutangaku())).
                add(nullToZero(給付実績中間.getKohi2Seikyugaku())).
                add(nullToZero(給付実績中間.getKohi2HonninFutangaku())).
                add(nullToZero(給付実績中間.getKohi2DekidakaSeikyugaku())).
                add(nullToZero(給付実績中間.getKohi2DekidakaIryohiRiyoshaFutangaku())).
                add(nullToZero(給付実績中間.getKohi3Seikyugaku())).
                add(nullToZero(給付実績中間.getKohi3HonninFutangaku())).
                add(nullToZero(給付実績中間.getKohi3DekidakaSeikyugaku())).
                add(nullToZero(給付実績中間.getKohi3DekidakaIryohiRiyoshaFutangaku()));
    }

    private boolean is総合事業分(KyufuJissekiChukanKogakuJigyo8Entity 処理対象) {
        if (処理対象.get識別番号管理() == null) {
            return false;
        }
        return FIVE.equals(処理対象.get識別番号管理().getKyufuBunruiKubun());
    }

    private Decimal get利用者負担額を算出(TempKyufujissekiTyukannJigyoEntity 給付実績中間) {
        return new Decimal(給付実績中間.getAtoHokenRiyoshaFutangaku()).
                add(給付実績中間.getAtoHokenRiyoshaFutangaku()).
                add(給付実績中間.getAtoKohi1RiyoshaFutangaku()).
                add(給付実績中間.getAtoKohi2RiyoshaFutangaku()).
                add(給付実績中間.getAtoKohi3RiyoshaFutangaku()).
                add(nullToZero(給付実績中間.getKohi1DekidakaIryohiRiyoshaFutangaku())).
                add(nullToZero(給付実績中間.getKohi2DekidakaIryohiRiyoshaFutangaku())).
                add(nullToZero(給付実績中間.getKohi3DekidakaIryohiRiyoshaFutangaku()));
    }

    private Decimal get総合事業分利用者負担額を算出(TempKyufujissekiTyukannJigyoEntity 給付実績中間) {
        return new Decimal(給付実績中間.getAtoHokenRiyoshaFutangaku()).
                add(給付実績中間.getAtoKohi1RiyoshaFutangaku()).
                add(給付実績中間.getAtoKohi2RiyoshaFutangaku()).
                add(給付実績中間.getAtoKohi3RiyoshaFutangaku()).
                add(nullToZero(給付実績中間.getKohi1DekidakaIryohiRiyoshaFutangaku())).
                add(nullToZero(給付実績中間.getKohi2DekidakaIryohiRiyoshaFutangaku())).
                add(nullToZero(給付実績中間.getKohi3DekidakaIryohiRiyoshaFutangaku()));
    }

    private Decimal get単一合算の算定基準額(TempKyufujissekiTyukannJigyoEntity 給付実績中間) {
        if (ONE.equals(給付実績中間.getShotokuHantei_shoboKubun())) {
            return get算定基準額コンフィグ(高額自己負担上限額_15000);
        } else if (ONE.equals(給付実績中間.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
            return 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku();
        } else if (TWO.equals(給付実績中間.getShotokuHantei_kazeiKubunGemmenGo())) {
            return get老齢福祉区分の場合1(給付実績中間);
        } else if (!ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())) {
            return get算定基準額コンフィグ(高額自己負担上限額_37200);
        }
        return Decimal.ZERO;
    }

    private Decimal get老齢福祉区分の場合1(TempKyufujissekiTyukannJigyoEntity 給付実績中間) {
        if (ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())) {
            return get算定基準額コンフィグ(高額自己負担上限額_15000);
        } else {
            if (給付実績中間.getShotokuHantei_gokeiShotokuGaku().
                    add(給付実績中間.getShotokuHantei_nenkiniShunyuGaku()).compareTo(金額_800000) <= 0) {
                return get算定基準額コンフィグ(高額自己負担上限額_15000);
            } else {
                return get算定基準額コンフィグ(高額自己負担上限額_24600);
            }
        }
    }

    private Map get世帯合算処理の算定基準額(TempKyufujissekiTyukannJigyoEntity 給付実績中間,
            List<KyufuJissekiChukanKogakuJigyo8Entity> 世帯分List) {
        Map 出力Map = new HashMap<>();
        Decimal 世帯算定基準額 = Decimal.ZERO;
        RString 利用者負担第2段階 = RString.EMPTY;
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
            世帯算定基準額 = 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku() == null
                    ? Decimal.ZERO : 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku();
        }
        Decimal 世帯全体の支給予定額 = 利用者負担額合計.subtract(サービス費用額合計).subtract(世帯算定基準額);
        Decimal 総合事業分利用者負担額 = get総合事業分利用者負担額を算出(給付実績中間);
        Decimal 利用者負担額 = get利用者負担額を算出(給付実績中間);
        Decimal 個人の支給予定額 = Decimal.ZERO;
        if (!Decimal.ZERO.equals(利用者負担額合計_総合事業分)) {
            個人の支給予定額 = new Decimal(世帯全体の支給予定額.multiply(総合事業分利用者負担額).
                    divide(利用者負担額合計_総合事業分).intValue());
        }
        boolean is支給予定額が最大の世帯員 = true;
        for (KyufuJissekiChukanKogakuJigyo8Entity entity : 世帯分List) {
            Decimal 支給予定額 = Decimal.ZERO;
            if (!Decimal.ZERO.equals(利用者負担額合計_総合事業分)) {
                支給予定額 = new Decimal(世帯全体の支給予定額.multiply(get利用者負担額を算出(
                        entity.get給付実績基本情報事業高額一時())).
                        divide(利用者負担額合計_総合事業分).intValue());
            }
            if (Decimal.ZERO.compareTo(個人の支給予定額) < 0
                    && 個人の支給予定額.compareTo(世帯全体の支給予定額) < 0
                    && 個人の支給予定額.compareTo(支給予定額) < 0) {
                is支給予定額が最大の世帯員 = false;
                break;
            }
        }
        if (is支給予定額が最大の世帯員) {
            個人の支給予定額 = 個人の支給予定額.add(Decimal.ONE);
        }
        Decimal kogakuServicehiJogengakuGengakugoJogengaku = 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku() == null
                ? Decimal.ZERO : 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku();
        if (kogakuServicehiJogengakuGengakugoJogengaku.equals(
                get算定基準額コンフィグ(高額自己負担上限額_15000))) {
            出力Map.put(KEY_利用者負担第2段階, 利用者負担第2段階);
            出力Map.put(KEY_支給予定額, 個人の支給予定額);
            出力Map.put(KEY_個人算定基準額, 世帯算定基準額);
            return 出力Map;
        }
        return 個人の支給予定額の調整(給付実績中間, 利用者負担額, 世帯算定基準額, 個人の支給予定額);
    }

    private Map 個人の支給予定額の調整(TempKyufujissekiTyukannJigyoEntity 給付実績中間,
            Decimal 利用者負担額,
            Decimal 世帯算定基準額,
            Decimal 個人の支給予定額) {
        Map 出力Map = new HashMap<>();
        RString 利用者負担第2段階 = RString.EMPTY;
        Decimal 高額ｻｰﾋﾞｽ費支給額 = 給付実績中間.getKogakuKaigoServicehi() == null
                ? Decimal.ZERO : 給付実績中間.getKogakuKaigoServicehi();
        Decimal 実質的な利用者負担額 = 利用者負担額.subtract(高額ｻｰﾋﾞｽ費支給額).subtract(個人の支給予定額);
        Decimal decWKGokeiGK = 給付実績中間.getShotokuHantei_gokeiShotokuGaku().
                add(給付実績中間.getShotokuHantei_nenkiniShunyuGaku());
        Decimal kogakuServicehiJogengakuGengakugoJogengaku = 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku() == null
                ? Decimal.ZERO : 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku();
        if (世帯算定基準額.equals(get算定基準額コンフィグ(高額自己負担上限額_24600))
                && (TWO.equals(給付実績中間.getShotokuHantei_setaiKazeiKubun())
                || kogakuServicehiJogengakuGengakugoJogengaku.equals(
                        get算定基準額コンフィグ(高額自己負担上限額_24600)))
                && ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())
                && get算定基準額コンフィグ(高額自己負担上限額_15000).compareTo(実質的な利用者負担額) < 0) {
            個人の支給予定額 = 実質的な利用者負担額.subtract(get算定基準額コンフィグ(高額自己負担上限額_15000));
            世帯算定基準額 = get算定基準額コンフィグ(高額自己負担上限額_15000);
        } else if (世帯算定基準額.equals(get算定基準額コンフィグ(高額自己負担上限額_24600))
                && (TWO.equals(給付実績中間.getShotokuHantei_setaiKazeiKubun())
                || kogakuServicehiJogengakuGengakugoJogengaku.equals(
                        get算定基準額コンフィグ(高額自己負担上限額_24600)))
                && decWKGokeiGK.compareTo(金額_800000) <= 0
                && get算定基準額コンフィグ(高額自己負担上限額_15000).compareTo(実質的な利用者負担額) < 0) {
            個人の支給予定額 = 実質的な利用者負担額.subtract(get算定基準額コンフィグ(高額自己負担上限額_15000));
            世帯算定基準額 = get算定基準額コンフィグ(高額自己負担上限額_15000);
            利用者負担第2段階 = ONE;
        }
        出力Map.put(KEY_利用者負担第2段階, 利用者負担第2段階);
        出力Map.put(KEY_支給予定額, 個人の支給予定額);
        出力Map.put(KEY_個人算定基準額, 世帯算定基準額);
        return 出力Map;
    }

    private Decimal get算定基準額コンフィグ(RString 高額自己負担上限額) {
        return RString.isNullOrEmpty(高額自己負担上限額) ? Decimal.ZERO : new Decimal(高額自己負担上限額.toString());
    }

    private RString get備考欄2(TempKyufujissekiTyukannJigyoEntity 給付実績中間) {
        if (ONE.equals(給付実績中間.getShotokuHantei_honninKubun())) {
            return get備考欄(給付実績中間);
        } else {
            return RString.EMPTY;
        }
    }

    private RString get備考欄1(TempKyufujissekiTyukannJigyoEntity 給付実績中間) {
        if (ONE.equals(給付実績中間.getShotokuHantei_honninKubun())) {
            return RString.EMPTY;
        } else {
            return get備考欄(給付実績中間);
        }
    }

    private RString get備考欄(TempKyufujissekiTyukannJigyoEntity 給付実績中間) {
        if (年月_201508.compareTo(給付実績中間.getServiceTeikyoYM()) < 0) {
            if (get算定基準額コンフィグ(高額自己負担上限額_44000).equals(給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku())) {
                return TEXT_現;
            } else if (get算定基準額コンフィグ(高額自己負担上限額_37200).equals(給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku())) {
                return TEXT_般;
            }
        }
        return RString.EMPTY;
    }

    private Decimal get現システム算定基準額(KyufuJissekiChukanKogakuJigyo8Entity entity, Decimal 算定基準額) {
        TempKyufujissekiTyukannJigyoEntity 給付実績中間 = entity.get給付実績基本情報事業高額一時();
        DbT3116KijunShunyugakuTekiyoKanriEntity 基準収入額適用管理一時 = entity.get基準収入額適用管理一時();
        if (基準収入額適用管理一時 != null) {
            if (SetaiKazeiKubun.非課税.getコード().equals(給付実績中間.getShotokuHantei_setaiKazeiKubun())) {
                return 算定基準額;
            } else {
                return get課税世帯基準額パターン1(entity, 算定基準額);
            }
        } else {
            if (SetaiKazeiKubun.非課税.getコード().equals(給付実績中間.getShotokuHantei_setaiKazeiKubun())) {
                return 算定基準額;
            } else {
                return get課税世帯基準額パターン2(entity, 算定基準額);
            }
        }
    }

    private Decimal get課税世帯基準額パターン1(KyufuJissekiChukanKogakuJigyo8Entity entity, Decimal 算定基準額) {
        TempKyufujissekiTyukannJigyoEntity 給付実績中間 = entity.get給付実績基本情報事業高額一時();
        if (!is課税世帯パターン1(entity)) {
            return Decimal.ZERO;
        }
        if (給付実績中間.getServiceTeikyoYM().compareTo(年月_201508) < 0) {
            return 算定基準額;
        } else {
            return get算定基準額コンフィグ(高額自己負担上限額_37200);
        }
    }

    private Decimal get課税世帯基準額パターン2(KyufuJissekiChukanKogakuJigyo8Entity entity, Decimal 算定基準額) {
        TempKyufujissekiTyukannJigyoEntity 給付実績中間 = entity.get給付実績基本情報事業高額一時();
        if (給付実績中間.getServiceTeikyoYM().compareTo(年月_201508) < 0) {
            return 算定基準額;
        } else if (is145万円以上と144万円の世帯主1名存在する()) {
            return get年少扶養控除の計算が必要なパターン(entity);
        } else if (is145万円以上の世帯主が存在しない()
                || is145万円以上の世帯主が2名存在する()) {
            return get算定基準額コンフィグ(高額自己負担上限額_37200);
        }
        return Decimal.ZERO;
    }

    private boolean is145万円以上と144万円の世帯主1名存在する() {
        int 課税所得145万円以上存在Count = INT_0;
        int 課税所得144万円存在Count = INT_0;
        List<KyufuJissekiChukanKogakuJigyo8Entity> 世帯内給付実績中間事業高額一時 = new ArrayList<>();
        世帯内給付実績中間事業高額一時.addAll(給付実績中間事業高額一時明細List);
        世帯内給付実績中間事業高額一時.addAll(給付実績中間事業高額一時取消明細List);
        for (KyufuJissekiChukanKogakuJigyo8Entity entity : 世帯内給付実績中間事業高額一時) {
            TempKyufujissekiTyukannJigyoEntity 給付実績中間 = entity.get給付実績基本情報事業高額一時();
            if (金額_145万.compareTo(nullToZero(給付実績中間.getShotokuHantei_kazeiShotokuGaku())) < 0) {
                課税所得145万円以上存在Count++;
            }
            if (金額_144万.compareTo(nullToZero(給付実績中間.getShotokuHantei_kazeiShotokuGaku())) == 0) {
                課税所得144万円存在Count++;
            }
        }
        return 課税所得145万円以上存在Count == INT_1 && 課税所得144万円存在Count == INT_1;
    }

    private boolean is145万円以上の世帯主が存在しない() {
        List<KyufuJissekiChukanKogakuJigyo8Entity> 世帯内給付実績中間事業高額一時 = new ArrayList<>();
        世帯内給付実績中間事業高額一時.addAll(給付実績中間事業高額一時明細List);
        世帯内給付実績中間事業高額一時.addAll(給付実績中間事業高額一時取消明細List);
        for (KyufuJissekiChukanKogakuJigyo8Entity entity : 世帯内給付実績中間事業高額一時) {
            TempKyufujissekiTyukannJigyoEntity 給付実績中間 = entity.get給付実績基本情報事業高額一時();
            if (金額_145万.compareTo(nullToZero(給付実績中間.getShotokuHantei_kazeiShotokuGaku())) < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean is145万円以上の世帯主が2名存在する() {
        int 課税所得145万円以上存在Count = INT_0;
        List<KyufuJissekiChukanKogakuJigyo8Entity> 世帯内給付実績中間事業高額一時 = new ArrayList<>();
        世帯内給付実績中間事業高額一時.addAll(給付実績中間事業高額一時明細List);
        世帯内給付実績中間事業高額一時.addAll(給付実績中間事業高額一時取消明細List);
        for (KyufuJissekiChukanKogakuJigyo8Entity entity : 世帯内給付実績中間事業高額一時) {
            TempKyufujissekiTyukannJigyoEntity 給付実績中間 = entity.get給付実績基本情報事業高額一時();
            if (金額_145万.compareTo(給付実績中間.getShotokuHantei_kazeiShotokuGaku()) < 0) {
                課税所得145万円以上存在Count++;
            }
        }
        return 課税所得145万円以上存在Count == INT_2;
    }

    private Decimal get年少扶養控除の計算が必要なパターン(KyufuJissekiChukanKogakuJigyo8Entity entity) {
        FlexibleDate 基準年月日 = new FlexibleDate(getサービス提供年月より求めた年度(entity.get給付実績基本情報事業高額一時().
                getServiceTeikyoYM()).minusYear(INT_1).toDateString().concat(日期_1231));
        if (is世帯主である(基準年月日)) {
            int 十五歳以下の人数 = get十五歳以下の人数(基準年月日);
            int 十八歳以下の人数 = get十八歳以下の人数(基準年月日);
            Decimal 年少扶養控除後の課税所得 = entity.get給付実績基本情報事業高額一時().getShotokuHantei_kazeiShotokuGaku().
                    subtract(金額_33万.multiply(十五歳以下の人数).add(金額_12万.multiply(十八歳以下の人数)));
            if (nullToZero(年少扶養控除後の課税所得).compareTo(金額_145万) < 0) {
                return get算定基準額コンフィグ(高額自己負担上限額_37200);
            } else {
                return get算定基準額コンフィグ(高額自己負担上限額_44400);
            }
        } else {
            return get算定基準額コンフィグ(高額自己負担上限額_44400);
        }
    }

    private boolean is世帯主である(FlexibleDate 基準年月日) {
        List<KyufuJissekiChukanKogakuJigyo8Entity> 世帯内給付実績中間事業高額一時 = new ArrayList<>();
        世帯内給付実績中間事業高額一時.addAll(給付実績中間事業高額一時明細List);
        世帯内給付実績中間事業高額一時.addAll(給付実績中間事業高額一時取消明細List);
        for (KyufuJissekiChukanKogakuJigyo8Entity entity : 世帯内給付実績中間事業高額一時) {
            TempSetaiinShotokuHanteiEntity 世帯員所得判定明細高額一時３ = entity.get世帯員所得判定明細事業高額一時３();
            if (世帯員所得判定明細高額一時３ == null) {
                break;
            }
            if (基準年月日.equals(世帯員所得判定明細高額一時３.getKijunYMD())) {
                return true;
            }
        }
        return false;
    }

    private int get十五歳以下の人数(FlexibleDate 基準年月日) {
        int 十五歳以下の人数 = 0;
        List<KyufuJissekiChukanKogakuJigyo8Entity> 世帯内給付実績中間事業高額一時 = new ArrayList<>();
        世帯内給付実績中間事業高額一時.addAll(給付実績中間事業高額一時明細List);
        世帯内給付実績中間事業高額一時.addAll(給付実績中間事業高額一時取消明細List);
        for (KyufuJissekiChukanKogakuJigyo8Entity entity : 世帯内給付実績中間事業高額一時) {
            TempKyufujissekiTyukannJigyoEntity 給付実績中間 = entity.get給付実績基本情報事業高額一時();
            TempSetaiinShotokuHanteiEntity 世帯員所得判定明細高額一時３ = entity.get世帯員所得判定明細事業高額一時３();
            if (世帯員所得判定明細高額一時３ == null) {
                break;
            }
            if (基準年月日.equals(世帯員所得判定明細高額一時３.getKijunYMD())
                    && 給付実績中間.getShotokuHantei_gokeiShotokuGaku().compareTo(金額_38万) < 0
                    && get年齢(世帯員所得判定明細高額一時３.getAtena_seinengappiYMD(), 基準年月日) <= INT_15) {
                十五歳以下の人数++;
            }
        }
        return 十五歳以下の人数;
    }

    private int get十八歳以下の人数(FlexibleDate 基準年月日) {
        int 十八歳以下の人数 = 0;
        List<KyufuJissekiChukanKogakuJigyo8Entity> 世帯内給付実績中間事業高額一時 = new ArrayList<>();
        世帯内給付実績中間事業高額一時.addAll(給付実績中間事業高額一時明細List);
        世帯内給付実績中間事業高額一時.addAll(給付実績中間事業高額一時取消明細List);
        for (KyufuJissekiChukanKogakuJigyo8Entity entity : 世帯内給付実績中間事業高額一時) {
            TempKyufujissekiTyukannJigyoEntity 給付実績中間 = entity.get給付実績基本情報事業高額一時();
            TempSetaiinShotokuHanteiEntity 世帯員所得判定明細高額一時３ = entity.get世帯員所得判定明細事業高額一時３();
            if (世帯員所得判定明細高額一時３ == null) {
                break;
            }
            if (基準年月日.equals(世帯員所得判定明細高額一時３.getKijunYMD())
                    && 給付実績中間.getShotokuHantei_gokeiShotokuGaku().compareTo(金額_38万) < 0
                    && get年齢(世帯員所得判定明細高額一時３.getAtena_seinengappiYMD(), 基準年月日) <= INT_18
                    && INT_15 <= get年齢(世帯員所得判定明細高額一時３.getAtena_seinengappiYMD(), 基準年月日)) {
                十八歳以下の人数++;
            }
        }
        return 十八歳以下の人数;
    }

    private int get年齢(FlexibleDate 生年月日, FlexibleDate 基準年月日) {
        AgeCalculator calculator = new AgeCalculator(DateOfBirthFactory.createInstance(生年月日), JuminJotai.住民,
                FlexibleDate.EMPTY, 基準年月日);
        return Integer.parseInt(calculator.get年齢().toString());
    }

    private boolean is課税世帯パターン1(KyufuJissekiChukanKogakuJigyo8Entity entity) {
        TempKyufujissekiTyukannJigyoEntity 給付実績中間 = entity.get給付実績基本情報事業高額一時();
        DbT3116KijunShunyugakuTekiyoKanriEntity 基準収入額適用管理一時 = entity.get基準収入額適用管理一時();
        if (給付実績中間.getHiHokenshaNo().equals(基準収入額適用管理一時.getHihokenshaNo())
                && !給付実績中間.getShotokuHantei_setaiCode().equals(基準収入額適用管理一時.getSetaiCode())) {
            return true;
        }
        FlexibleYear 年度 = getサービス提供年月より求めた年度(給付実績中間.getServiceTeikyoYM());
        if (!給付実績中間.getHiHokenshaNo().equals(基準収入額適用管理一時.getHihokenshaNo())
                && 給付実績中間.getShotokuHantei_setaiCode().equals(基準収入額適用管理一時.getSetaiCode())
                && !年度.equals(基準収入額適用管理一時.getNendo())) {
            return true;
        }
        return !給付実績中間.getHiHokenshaNo().equals(基準収入額適用管理一時.getHihokenshaNo())
                && 給付実績中間.getShotokuHantei_setaiCode().equals(基準収入額適用管理一時.getSetaiCode())
                && 年度.equals(基準収入額適用管理一時.getNendo())
                && 給付実績中間.getServiceTeikyoYM().compareTo(基準収入額適用管理一時.getTekiyoKaishiYMD()) <= 0;
    }

    private void clear合計() {
        サービス費用額合計 = Decimal.ZERO;
        利用者負担額合計 = Decimal.ZERO;
        利用者負担額合計_総合事業分 = Decimal.ZERO;
        支給予定額合計 = Decimal.ZERO;
        算定基準額合計 = Decimal.ZERO;
    }

    private Decimal nullToZero(Decimal num) {
        if (num == null) {
            return Decimal.ZERO;
        }
        return num;
    }

}
