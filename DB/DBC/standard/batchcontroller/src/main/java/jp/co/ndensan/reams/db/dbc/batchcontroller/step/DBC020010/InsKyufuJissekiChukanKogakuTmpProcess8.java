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
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinShotokuHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiChukanKogaku8Entity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
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
    private static final RString 日期_1231 = new RString("1231");
    private static final RString TEXT_現 = new RString("現");
    private static final RString TEXT_般 = new RString("般");
    private static final RString KEY_利用者負担第2段階 = new RString("利用者負担第2段階");
    private static final RString KEY_激変緩和区分 = new RString("激変緩和区分");
    private static final RString KEY_個人算定基準額 = new RString("個人算定基準額");
    private static final FlexibleYearMonth 年月_200510 = new FlexibleYearMonth("200510");
    private static final FlexibleYearMonth 年月_200607 = new FlexibleYearMonth("200607");
    private static final FlexibleYearMonth 年月_200806 = new FlexibleYearMonth("200806");
    private static final FlexibleYearMonth 年月_201508 = new FlexibleYearMonth("200508");
    private static final Decimal 金額_800000 = new Decimal("800000");
    private static final Decimal 金額_145万 = new Decimal("1450000");
    private static final Decimal 金額_144万 = new Decimal("1440000");
    private static final Decimal 金額_38万 = new Decimal("380000");
    private static final Decimal 金額_33万 = new Decimal("330000");
    private static final Decimal 金額_12万 = new Decimal("120000");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_8 = 8;
    private static final int INT_15 = 15;
    private static final int INT_18 = 18;
    private Decimal 利用者負担額合計;
    private Decimal 支給予定額合計;
    private Decimal 算定基準額合計;
    private KyufuJissekiChukanKogaku8Entity beforeEntity;
    private KyufuJissekiChukanKogaku8Entity before処理対象;
    private List<KyufuJissekiChukanKogaku8Entity> 処理対象List;
    private List<KyufuJissekiChukanKogaku8Entity> 給付実績中間高額一時明細List;
    private List<KyufuJissekiChukanKogaku8Entity> 給付実績中間高額一時取消明細List;
    private RString 高額自己負担上限額_15000;
    private RString 高額自己負担上限額_24600;
    private RString 高額自己負担上限額_37200;
    private RString 高額自己負担上限額_44000;
    private RString 高額自己負担上限額_44400;
    private RString 平１８激変緩和期間_適用開始年月;
    private RString 平１８激変緩和期間_適用終了年月;
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
        高額自己負担上限額_44400 = DbBusinessConfig.get(ConfigNameDBC.高額自己負担上限額_44400,
                sysDate, SubGyomuCode.DBC介護給付);
        平１８激変緩和期間_適用開始年月 = DbBusinessConfig.get(ConfigNameDBU.平１８激変緩和期間_適用開始年月,
                sysDate, SubGyomuCode.DBU介護統計報告);
        平１８激変緩和期間_適用終了年月 = DbBusinessConfig.get(ConfigNameDBU.平１８激変緩和期間_適用終了年月,
                sysDate, SubGyomuCode.DBU介護統計報告);
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
        if (給付実績中間.getShotokuHantei_shoboKubun() == null) {
            return;
        }
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
            clear合計();
        }
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
        if (処理対象Comparator.get(0).get基準収入額適用管理一時() == null) {
            return 処理対象List;
        }
        HihokenshaNo 被保険者番号 = 処理対象Comparator.get(0).get基準収入額適用管理一時().getHihokenshaNo();
        FlexibleYearMonth 適用開始年月 = 処理対象Comparator.get(0).get基準収入額適用管理一時().getTekiyoKaishiYMD();
        FlexibleYearMonth 最小の適用開始年月 = 処理対象Comparator.get(処理対象Comparator.size() - INT_1).
                get基準収入額適用管理一時().getTekiyoKaishiYMD();
        for (KyufuJissekiChukanKogaku8Entity entity : 処理対象List) {
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

    private List<KyufuJissekiChukanKogaku8Entity> get処理対象Comparator(List<KyufuJissekiChukanKogaku8Entity> 処理対象List) {
        if (処理対象List.isEmpty()) {
            return 処理対象List;
        }
        Collections.sort(処理対象List, new Comparator<KyufuJissekiChukanKogaku8Entity>() {
            @Override
            public int compare(KyufuJissekiChukanKogaku8Entity arg0, KyufuJissekiChukanKogaku8Entity arg1) {
                if (arg0.get基準収入額適用管理一時() == null || arg1.get基準収入額適用管理一時() == null) {
                    return -1;
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
        insert給付実績中間高額一時8の新規1(給付実績中間高額一時List.get(0));
        clear合計();
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
        } else {
            for (KyufuJissekiChukanKogaku8Entity entity : 給付実績中間高額一時List) {
                TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
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

    private void do単独分合計と明細追加(List<KyufuJissekiChukanKogaku8Entity> 単独分List) {
        for (KyufuJissekiChukanKogaku8Entity entity : 単独分List) {
            insert給付実績中間高額一時8の新規4(entity);
        }
        insert給付実績中間高額一時8の新規3(単独分List.get(0));
        clear合計();
    }

    private void do世帯分合計と明細追加(List<KyufuJissekiChukanKogaku8Entity> 世帯分List) {
        for (KyufuJissekiChukanKogaku8Entity entity : 世帯分List) {
            Decimal 利用者負担額 = get利用者負担額を算出(entity.get給付実績中間高額一時());
            利用者負担額合計 = 利用者負担額合計.add(利用者負担額);
        }
        for (KyufuJissekiChukanKogaku8Entity entity : 世帯分List) {
            insert給付実績中間高額一時8の新規6(entity, 世帯分List);
        }
        insert給付実績中間高額一時8の新規5(世帯分List.get(0));
        clear合計();
    }

    private Decimal get現システム算定基準額(KyufuJissekiChukanKogaku8Entity entity, Decimal 算定基準額) {
        TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
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

    private Decimal get課税世帯基準額パターン1(KyufuJissekiChukanKogaku8Entity entity, Decimal 算定基準額) {
        TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
        if (!is課税世帯パターン1(entity)) {
            return Decimal.ZERO;
        }
        if (給付実績中間.getServiceTeikyoYM().compareTo(年月_201508) < 0) {
            return 算定基準額;
        } else {
            return get算定基準額コンフィグ(高額自己負担上限額_37200);
        }
    }

    private Decimal get課税世帯基準額パターン2(KyufuJissekiChukanKogaku8Entity entity, Decimal 算定基準額) {
        TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
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
        List<KyufuJissekiChukanKogaku8Entity> 世帯内給付実績中間高額一時 = new ArrayList<>();
        世帯内給付実績中間高額一時.addAll(給付実績中間高額一時明細List);
        世帯内給付実績中間高額一時.addAll(給付実績中間高額一時取消明細List);
        for (KyufuJissekiChukanKogaku8Entity entity : 世帯内給付実績中間高額一時) {
            TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
            if (金額_145万.compareTo(給付実績中間.getShotokuHantei_kazeiShotokuGaku()) < 0) {
                課税所得145万円以上存在Count++;
            }
            if (金額_144万.compareTo(給付実績中間.getShotokuHantei_kazeiShotokuGaku()) == 0) {
                課税所得144万円存在Count++;
            }
        }
        return 課税所得145万円以上存在Count == INT_1 && 課税所得144万円存在Count == INT_1;
    }

    private boolean is145万円以上の世帯主が存在しない() {
        List<KyufuJissekiChukanKogaku8Entity> 世帯内給付実績中間高額一時 = new ArrayList<>();
        世帯内給付実績中間高額一時.addAll(給付実績中間高額一時明細List);
        世帯内給付実績中間高額一時.addAll(給付実績中間高額一時取消明細List);
        for (KyufuJissekiChukanKogaku8Entity entity : 世帯内給付実績中間高額一時) {
            TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
            if (金額_145万.compareTo(給付実績中間.getShotokuHantei_kazeiShotokuGaku()) < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean is145万円以上の世帯主が2名存在する() {
        int 課税所得145万円以上存在Count = INT_0;
        List<KyufuJissekiChukanKogaku8Entity> 世帯内給付実績中間高額一時 = new ArrayList<>();
        世帯内給付実績中間高額一時.addAll(給付実績中間高額一時明細List);
        世帯内給付実績中間高額一時.addAll(給付実績中間高額一時取消明細List);
        for (KyufuJissekiChukanKogaku8Entity entity : 世帯内給付実績中間高額一時) {
            TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
            if (金額_145万.compareTo(給付実績中間.getShotokuHantei_kazeiShotokuGaku()) < 0) {
                課税所得145万円以上存在Count++;
            }
        }
        return 課税所得145万円以上存在Count == INT_2;
    }

    private Decimal get年少扶養控除の計算が必要なパターン(KyufuJissekiChukanKogaku8Entity entity) {
        FlexibleDate 基準年月日 = new FlexibleDate(getサービス提供年月より求めた年度(entity.get給付実績中間高額一時().
                getServiceTeikyoYM()).minusYear(INT_1).toDateString().concat(日期_1231));
        if (is世帯主である(基準年月日)) {
            int 十五歳以下の人数 = get十五歳以下の人数(基準年月日);
            int 十八歳以下の人数 = get十八歳以下の人数(基準年月日);
            Decimal 年少扶養控除後の課税所得 = entity.get給付実績中間高額一時().getShotokuHantei_kazeiShotokuGaku().
                    subtract(金額_33万.multiply(十五歳以下の人数).add(金額_12万.multiply(十八歳以下の人数)));
            if (年少扶養控除後の課税所得.compareTo(金額_145万) < 0) {
                return get算定基準額コンフィグ(高額自己負担上限額_37200);
            } else {
                return get算定基準額コンフィグ(高額自己負担上限額_44400);
            }
        } else {
            return get算定基準額コンフィグ(高額自己負担上限額_44400);
        }
    }

    private boolean is世帯主である(FlexibleDate 基準年月日) {
        List<KyufuJissekiChukanKogaku8Entity> 世帯内給付実績中間高額一時 = new ArrayList<>();
        世帯内給付実績中間高額一時.addAll(給付実績中間高額一時明細List);
        世帯内給付実績中間高額一時.addAll(給付実績中間高額一時取消明細List);
        for (KyufuJissekiChukanKogaku8Entity entity : 世帯内給付実績中間高額一時) {
            TempSetaiinShotokuHanteiEntity 世帯員所得判定明細高額一時３ = entity.get世帯員所得判定明細高額一時３();
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
        List<KyufuJissekiChukanKogaku8Entity> 世帯内給付実績中間高額一時 = new ArrayList<>();
        世帯内給付実績中間高額一時.addAll(給付実績中間高額一時明細List);
        世帯内給付実績中間高額一時.addAll(給付実績中間高額一時取消明細List);
        for (KyufuJissekiChukanKogaku8Entity entity : 世帯内給付実績中間高額一時) {
            TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
            TempSetaiinShotokuHanteiEntity 世帯員所得判定明細高額一時３ = entity.get世帯員所得判定明細高額一時３();
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
        List<KyufuJissekiChukanKogaku8Entity> 世帯内給付実績中間高額一時 = new ArrayList<>();
        世帯内給付実績中間高額一時.addAll(給付実績中間高額一時明細List);
        世帯内給付実績中間高額一時.addAll(給付実績中間高額一時取消明細List);
        for (KyufuJissekiChukanKogaku8Entity entity : 世帯内給付実績中間高額一時) {
            TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
            TempSetaiinShotokuHanteiEntity 世帯員所得判定明細高額一時３ = entity.get世帯員所得判定明細高額一時３();
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

    private boolean is課税世帯パターン1(KyufuJissekiChukanKogaku8Entity entity) {
        TempKyufujissekiTyukannEntity 給付実績中間 = entity.get給付実績中間高額一時();
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

    private FlexibleYear getサービス提供年月より求めた年度(FlexibleYearMonth サービス提供年月) {
        if (サービス提供年月.getMonthValue() < INT_8) {
            return サービス提供年月.getYear().minusYear(INT_1);
        } else {
            return サービス提供年月.getYear();
        }
    }

    private void insert給付実績中間高額一時8の新規1(KyufuJissekiChukanKogaku8Entity entity) {
        TempKyufujissekiTyukannEntity 給付実績中間高額一時 = entity.get給付実績中間高額一時();
        Decimal サービス費用額合計 = getサービス費用額(給付実績中間高額一時);
        給付実績中間高額一時.setShotokuHantei_setaiinShikibetsuCode(null);
        給付実績中間高額一時.setHokenRiyoshaFutangaku(利用者負担額合計);
        給付実績中間高額一時.setDataKubun(ONE);
        給付実績中間高額一時.setServiceHiyougakuGokei(サービス費用額合計);
        給付実績中間高額一時.setSikyugaku(Decimal.ZERO);
        給付実績中間高額一時.setSanteiKijungaku(Decimal.ZERO);
        給付実績中間高額一時.setKogakuHanteiKekka(ONE);
        給付実績中間高額一時.setSagakuKubun(RString.EMPTY);
        給付実績中間高額一時.setKoogakuKetteiKubun(RString.EMPTY);
        給付実績中間高額一時.setBeikoSetaishotokuKubun(get備考欄世帯所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setBeikoKojinshotokuKubun(get備考欄個人所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setRiyoFitanDankai2(RString.EMPTY);
        kyufujissekiTyukann8Writer.insert(給付実績中間高額一時);
    }

    private void insert給付実績中間高額一時8の新規2(TempKyufujissekiTyukannEntity 給付実績中間高額一時) {
        給付実績中間高額一時.setKyufuSakuseiKubunCode(作成区分_取消);
        給付実績中間高額一時.setShotokuHantei_setaiinShikibetsuCode(null);
        Decimal 利用者負担額 = get利用者負担額を算出(給付実績中間高額一時);
        利用者負担額合計 = 利用者負担額合計.add(利用者負担額);
        Decimal サービス費用額合計 = getサービス費用額(給付実績中間高額一時);
        給付実績中間高額一時.setHokenRiyoshaFutangaku(利用者負担額);
        給付実績中間高額一時.setDataKubun(TWO);
        給付実績中間高額一時.setServiceHiyougakuGokei(サービス費用額合計);
        給付実績中間高額一時.setSikyugaku(Decimal.ZERO);
        給付実績中間高額一時.setSanteiKijungaku(Decimal.ZERO);
        給付実績中間高額一時.setKogakuHanteiKekka(ZERO);
        給付実績中間高額一時.setSagakuKubun(RString.EMPTY);
        給付実績中間高額一時.setKoogakuKetteiKubun(RString.EMPTY);
        給付実績中間高額一時.setBeikoSetaishotokuKubun(get備考欄世帯所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setBeikoKojinshotokuKubun(get備考欄個人所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setRiyoFitanDankai2(get利用者負担第２段階(給付実績中間高額一時));
        kyufujissekiTyukann8Writer.insert(給付実績中間高額一時);
    }

    private void insert給付実績中間高額一時8の新規3(KyufuJissekiChukanKogaku8Entity entity) {
        TempKyufujissekiTyukannEntity 給付実績中間高額一時 = entity.get給付実績中間高額一時();
        Decimal サービス費用額合計 = getサービス費用額(給付実績中間高額一時);
        給付実績中間高額一時.setShotokuHantei_setaiinShikibetsuCode(null);
        給付実績中間高額一時.setShotokuHantei_gekihenKanwaKubun(RString.EMPTY);
        給付実績中間高額一時.setHokenRiyoshaFutangaku(利用者負担額合計);
        給付実績中間高額一時.setDataKubun(ONE);
        給付実績中間高額一時.setServiceHiyougakuGokei(サービス費用額合計);
        給付実績中間高額一時.setSikyugaku(支給予定額合計);
        給付実績中間高額一時.setSanteiKijungaku(算定基準額合計);
        給付実績中間高額一時.setKogakuHanteiKekka(ONE);
        給付実績中間高額一時.setSagakuKubun(RString.EMPTY);
        給付実績中間高額一時.setKoogakuKetteiKubun(RString.EMPTY);
        給付実績中間高額一時.setBeikoSetaishotokuKubun(get備考欄世帯所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setBeikoKojinshotokuKubun(get備考欄個人所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setRiyoFitanDankai2(RString.EMPTY);
        kyufujissekiTyukann8Writer.insert(給付実績中間高額一時);
    }

    private void insert給付実績中間高額一時8の新規4(KyufuJissekiChukanKogaku8Entity entity) {
        TempKyufujissekiTyukannEntity 給付実績中間高額一時 = entity.get給付実績中間高額一時();
        RString 激変緩和区分 = get激変緩和区分(給付実績中間高額一時);
        Decimal 算定基準額 = get単独改修前の算定基準額(給付実績中間高額一時);
        Decimal 利用者負担額 = get利用者負担額を算出(給付実績中間高額一時);
        利用者負担額合計 = 利用者負担額合計.add(利用者負担額);
        Decimal サービス費用額合計 = getサービス費用額(給付実績中間高額一時);
        Decimal 支給予定額 = Decimal.ZERO;
        Decimal 現システム算定基準額 = get現システム算定基準額(entity, 算定基準額);
        if (算定基準額.compareTo(利用者負担額) < 0) {
            支給予定額 = 利用者負担額.subtract(算定基準額);
        }
        支給予定額合計 = 支給予定額合計.add(支給予定額);
        算定基準額合計 = 算定基準額合計.add(現システム算定基準額);
        給付実績中間高額一時.setShotokuHantei_setaiinShikibetsuCode(null);
        給付実績中間高額一時.setShotokuHantei_gekihenKanwaKubun(激変緩和区分);
        給付実績中間高額一時.setHokenRiyoshaFutangaku(利用者負担額);
        給付実績中間高額一時.setDataKubun(TWO);
        給付実績中間高額一時.setServiceHiyougakuGokei(サービス費用額合計);
        給付実績中間高額一時.setSikyugaku(支給予定額);
        給付実績中間高額一時.setSanteiKijungaku(現システム算定基準額);
        給付実績中間高額一時.setKogakuHanteiKekka(ZERO);
        給付実績中間高額一時.setSagakuKubun(RString.EMPTY);
        給付実績中間高額一時.setKoogakuKetteiKubun(RString.EMPTY);
        給付実績中間高額一時.setBeikoSetaishotokuKubun(get備考欄世帯所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setBeikoKojinshotokuKubun(get備考欄個人所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setRiyoFitanDankai2(get利用者負担第２段階(給付実績中間高額一時));
        kyufujissekiTyukann8Writer.insert(給付実績中間高額一時);
    }

    private void insert給付実績中間高額一時8の新規5(KyufuJissekiChukanKogaku8Entity entity) {
        TempKyufujissekiTyukannEntity 給付実績中間高額一時 = entity.get給付実績中間高額一時();
        Decimal サービス費用額合計 = getサービス費用額(給付実績中間高額一時);
        給付実績中間高額一時.setShotokuHantei_setaiinShikibetsuCode(null);
        給付実績中間高額一時.setShotokuHantei_gekihenKanwaKubun(RString.EMPTY);
        給付実績中間高額一時.setHokenRiyoshaFutangaku(利用者負担額合計);
        給付実績中間高額一時.setDataKubun(ONE);
        給付実績中間高額一時.setServiceHiyougakuGokei(サービス費用額合計);
        給付実績中間高額一時.setSikyugaku(支給予定額合計);
        給付実績中間高額一時.setSanteiKijungaku(算定基準額合計);
        給付実績中間高額一時.setKogakuHanteiKekka(TWO);
        給付実績中間高額一時.setSagakuKubun(RString.EMPTY);
        給付実績中間高額一時.setKoogakuKetteiKubun(RString.EMPTY);
        給付実績中間高額一時.setBeikoSetaishotokuKubun(get備考欄世帯所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setBeikoKojinshotokuKubun(get備考欄個人所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setRiyoFitanDankai2(RString.EMPTY);
        kyufujissekiTyukann8Writer.insert(給付実績中間高額一時);
    }

    private void insert給付実績中間高額一時8の新規6(KyufuJissekiChukanKogaku8Entity entity,
            List<KyufuJissekiChukanKogaku8Entity> 世帯分List) {
        TempKyufujissekiTyukannEntity 給付実績中間高額一時 = entity.get給付実績中間高額一時();

        Decimal 支給予定額 = Decimal.ZERO;
        Map 出力Map = get世帯合算処理の算定基準額(給付実績中間高額一時, 世帯分List);
        RString 激変緩和区分 = (RString) 出力Map.get(KEY_激変緩和区分);
        Decimal 算定基準額 = (Decimal) 出力Map.get(KEY_個人算定基準額);
        RString 利用者負担第2段階 = (RString) 出力Map.get(KEY_利用者負担第2段階);
        Decimal 利用者負担額 = get利用者負担額を算出(給付実績中間高額一時);
        Decimal 現システム算定基準額 = get現システム算定基準額(entity, 算定基準額);
        if (算定基準額.compareTo(利用者負担額) < 0) {
            支給予定額 = 利用者負担額.subtract(算定基準額);
        }
        支給予定額合計 = 支給予定額合計.add(支給予定額);
        算定基準額合計 = 算定基準額合計.add(現システム算定基準額);
        給付実績中間高額一時.setShotokuHantei_gekihenKanwaKubun(激変緩和区分);
        給付実績中間高額一時.setHokenRiyoshaFutangaku(利用者負担額);
        給付実績中間高額一時.setDataKubun(TWO);
        給付実績中間高額一時.setServiceHiyougakuGokei(Decimal.ZERO);
        給付実績中間高額一時.setSikyugaku(支給予定額);
        給付実績中間高額一時.setSanteiKijungaku(現システム算定基準額);
        給付実績中間高額一時.setKogakuHanteiKekka(RString.EMPTY);
        給付実績中間高額一時.setSagakuKubun(RString.EMPTY);
        給付実績中間高額一時.setKoogakuKetteiKubun(ZERO);
        給付実績中間高額一時.setBeikoSetaishotokuKubun(get備考欄世帯所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setBeikoKojinshotokuKubun(get備考欄個人所得区分(給付実績中間高額一時));
        給付実績中間高額一時.setRiyoFitanDankai2(利用者負担第2段階);
        kyufujissekiTyukann8Writer.insert(給付実績中間高額一時);
    }

    private Decimal getサービス費用額(TempKyufujissekiTyukannEntity 給付実績中間) {
        return formatByNull(給付実績中間.getServiceHiyougakuGokei()).
                add(formatByNull(給付実績中間.getHokenSeikyugaku())).
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
            } else if (ONE.equals(給付実績中間.getShotokuHantei_gekihenKanwaKubun())) {
                return get老齢福祉区分の場合3(給付実績中間);
            } else {
                return get算定基準額コンフィグ(高額自己負担上限額_37200);
            }
        } else {
            if (ONE.equals(給付実績中間.getShotokuHantei_shoboKubun())) {
                return get算定基準額コンフィグ(高額自己負担上限額_15000);
            } else if (ONE.equals(給付実績中間.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
                return 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku();
            } else if (TWO.equals(給付実績中間.getShotokuHantei_kazeiKubunGemmenGo())) {
                return get老齢福祉区分の場合2(給付実績中間);
            } else {
                return get算定基準額コンフィグ(高額自己負担上限額_37200);
            }
        }
        return Decimal.ZERO;
    }

    private Map get世帯合算処理の算定基準額(TempKyufujissekiTyukannEntity 給付実績中間,
            List<KyufuJissekiChukanKogaku8Entity> 世帯分List) {
        Map 出力Map = new HashMap<>();
        出力Map.put(KEY_利用者負担第2段階, RString.EMPTY);
        出力Map.put(KEY_激変緩和区分, RString.EMPTY);
        Decimal 世帯算定基準額 = Decimal.ZERO;
        if (ONE.equals(給付実績中間.getShotokuHantei_shoboKubun())
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
            世帯算定基準額 = 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku() == null ? Decimal.ZERO
                    : 給付実績中間.getKogakuServicehiJogengakuGengakugoJogengaku();
        }
        boolean is最小の個人算定基準額 = true;
        Decimal 最小の個人算定基準額 = new Decimal(世帯算定基準額.multiply(get利用者負担額を算出(給付実績中間)).
                divide(利用者負担額合計).intValue());
        Decimal 個人算定基準額合計 = Decimal.ZERO;
        for (KyufuJissekiChukanKogaku8Entity entity : 世帯分List) {
            Decimal 利用者負担額 = get利用者負担額を算出(entity.get給付実績中間高額一時());
            Decimal 個人算定基準額 = new Decimal(世帯算定基準額.multiply(利用者負担額).subtract(利用者負担額合計).intValue());
            if (個人算定基準額.compareTo(最小の個人算定基準額) < 0) {
                最小の個人算定基準額 = 個人算定基準額;
                is最小の個人算定基準額 = false;
            }
            個人算定基準額合計 = 個人算定基準額合計.add(個人算定基準額);
        }
        Decimal 利用者負担額 = get利用者負担額を算出(給付実績中間);
        Decimal 個人算定基準額 = new Decimal(世帯算定基準額.multiply(利用者負担額).subtract(利用者負担額合計).intValue());
        if (is最小の個人算定基準額 && 個人算定基準額合計.compareTo(世帯算定基準額) < 0) {
            個人算定基準額 = 個人算定基準額.add(世帯算定基準額.multiply(個人算定基準額合計));
        }
        if (ZERO.equals(給付実績中間.getChushiRiyuNyushomaeJyokyoCode())) {
            if (世帯算定基準額.equals(get算定基準額コンフィグ(高額自己負担上限額_24600))
                    && TWO.equals(給付実績中間.getShotokuHantei_setaiKazeiKubun())
                    && ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())
                    && get算定基準額コンフィグ(高額自己負担上限額_15000).compareTo(個人算定基準額) < 0) {
                個人算定基準額 = get算定基準額コンフィグ(高額自己負担上限額_15000);
            } else {
                return get算定基準額ByＷＫ金額(給付実績中間, 個人算定基準額, 世帯算定基準額, 出力Map);
            }
        }
        出力Map.put(KEY_個人算定基準額, 個人算定基準額);
        return 出力Map;
    }

    private Map get算定基準額ByＷＫ金額(TempKyufujissekiTyukannEntity 給付実績中間,
            Decimal 個人算定基準額, Decimal 世帯算定基準額, Map 出力Map) {
        RString 利用者負担第2段階 = RString.EMPTY;
        RString 激変緩和区分 = RString.EMPTY;
        Decimal ＷＫ金額 = 給付実績中間.getShotokuHantei_gokeiShotokuGaku().
                add(給付実績中間.getShotokuHantei_nenkiniShunyuGaku());
        if (年月_200510.compareTo(給付実績中間.getServiceTeikyoYM()) <= 0
                && get算定基準額コンフィグ(高額自己負担上限額_24600).equals(世帯算定基準額)
                && TWO.equals(給付実績中間.getShotokuHantei_setaiKazeiKubun())
                && ＷＫ金額.compareTo(金額_800000) <= 0) {
            利用者負担第2段階 = ONE;
            if (get算定基準額コンフィグ(高額自己負担上限額_15000).compareTo(個人算定基準額) < 0) {
                個人算定基準額 = get算定基準額コンフィグ(高額自己負担上限額_15000);
            }
        } else if (new FlexibleYearMonth(平１８激変緩和期間_適用開始年月).compareTo(給付実績中間.getServiceTeikyoYM()) <= 0
                && 給付実績中間.getServiceTeikyoYM().compareTo(new FlexibleYearMonth(平１８激変緩和期間_適用終了年月)) <= 0
                && ONE.equals(給付実績中間.getShotokuHantei_setaiKazeiKubun())
                && ONE.equals(給付実績中間.getShotokuHantei_gekihenKanwaKubun())
                && ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())) {
            激変緩和区分 = ONE;
            if (get算定基準額コンフィグ(高額自己負担上限額_15000).compareTo(個人算定基準額) < 0) {
                個人算定基準額 = get算定基準額コンフィグ(高額自己負担上限額_15000);
            }
        } else if (new FlexibleYearMonth(平１８激変緩和期間_適用開始年月).compareTo(給付実績中間.getServiceTeikyoYM()) <= 0
                && 給付実績中間.getServiceTeikyoYM().compareTo(new FlexibleYearMonth(平１８激変緩和期間_適用終了年月)) <= 0
                && ONE.equals(給付実績中間.getShotokuHantei_setaiKazeiKubun())
                && ONE.equals(給付実績中間.getShotokuHantei_gekihenKanwaKubun())
                && ＷＫ金額.compareTo(金額_800000) <= 0) {
            激変緩和区分 = TWO;
            if (get算定基準額コンフィグ(高額自己負担上限額_24600).compareTo(個人算定基準額) < 0) {
                個人算定基準額 = get算定基準額コンフィグ(高額自己負担上限額_24600);
            }
        }
        出力Map.put(KEY_利用者負担第2段階, 利用者負担第2段階);
        出力Map.put(KEY_激変緩和区分, 激変緩和区分);
        出力Map.put(KEY_個人算定基準額, 個人算定基準額);
        return 出力Map;
    }

    private RString get利用者負担第２段階(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (年月_200510.compareTo(給付実績中間.getServiceTeikyoYM()) <= 0
                && !ONE.equals(給付実績中間.getShotokuHantei_shoboKubun())
                && !ONE.equals(給付実績中間.getKogakuServicehiJogengakuGengakuGaitoFlag())) {
            if (TWO.equals(給付実績中間.getShotokuHantei_kazeiKubunGemmenGo())
                    && !ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())
                    && 給付実績中間.getShotokuHantei_gokeiShotokuGaku().
                    add(給付実績中間.getShotokuHantei_nenkiniShunyuGaku()).compareTo(金額_800000) <= 0) {
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
            } else if (給付実績中間.getShotokuHantei_gokeiShotokuGaku().
                    add(給付実績中間.getShotokuHantei_nenkiniShunyuGaku()).compareTo(金額_800000) <= 0) {
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
                && 金額_800000.compareTo(給付実績中間.getShotokuHantei_gokeiShotokuGaku().
                        add(給付実績中間.getShotokuHantei_nenkiniShunyuGaku())) < 0) {
            return get算定基準額コンフィグ(高額自己負担上限額_24600);
        } else {
            return get算定基準額コンフィグ(高額自己負担上限額_15000);
        }
    }

    private Decimal get老齢福祉区分の場合3(TempKyufujissekiTyukannEntity 給付実績中間) {
        if (ONE.equals(給付実績中間.getShotokuHantei_roreiFukushi())) {
            return get算定基準額コンフィグ(高額自己負担上限額_15000);
        } else if (金額_800000.compareTo(給付実績中間.getShotokuHantei_gokeiShotokuGaku().
                add(給付実績中間.getShotokuHantei_nenkiniShunyuGaku())) < 0) {
            return get算定基準額コンフィグ(高額自己負担上限額_37200);
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

    private void clear合計() {
        利用者負担額合計 = Decimal.ZERO;
        支給予定額合計 = Decimal.ZERO;
        算定基準額合計 = Decimal.ZERO;
    }
}
