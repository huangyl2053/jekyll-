/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jigyobunshikyugakucalc.HihokenshaFutangaku;
import jp.co.ndensan.reams.db.dbc.business.core.jigyobunshikyugakucalc.JigyobunShikyugakuCalcResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigyobunshikyugakucalc.ShikyugakuCalcKey;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020070.JigyobunShikyugakuKeisanProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuCalcTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuUpdateTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 支給額の計算処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class ShikyugakuCalcProcess extends BatchKeyBreakBase<ShikyugakuCalcTempEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get支給額の計算");
    private static final RString 区分1 = new RString(1);
    private static final RString 区分2 = new RString(2);
    private static final RString 区分3 = new RString(3);
    private static final RString 区分4 = new RString(4);
    private static final RString 区分5 = new RString(5);
    private static final RString 区分6 = new RString(6);
    private static final RString ZERO = new RString(0);
    private static final RString ONE = new RString(1);
    private static final RString TWO = new RString(2);
    private static final RString THREE = new RString(3);
    private static final RString 給付額減額 = new RString("給付額減額");
    private static final RString 保険制度コード_3 = new RString("3");
    private static final RString TABLE_NAME = new RString("ShikyugakuUpdateTemp");

    private JigyobunShikyugakuKeisanProcessParameter parameter;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    private JigyobunShikyugakuCalcResult 計算用明細データ;

    private List<HihokenshaFutangaku> 支給額明細List;
    private List<HihokenshaFutangaku> 事業高額合算List;
    private List<HihokenshaFutangaku> 転入前事業高額合算List;
    private List<ShikyugakuCalcKey> 登録済キー;

    private ShikyugakuCalcTempEntity 支給額計算一時_区分1;
    private ShikyugakuCalcTempEntity 支給額計算一時_自己負担額;
    private HihokenshaNo 負担額_被保険者番号;
    private HokenshaNo 負担額_保険者番号;
    private HihokenshaNo 前負担額_被保険者番号;
    private HokenshaNo 前負担額_転入前保険者番号;

    private Decimal 負担額_70歳以上;
    private Decimal 負担額_70歳以上_合計;

    private Decimal 転入前_負担額_70歳以上;
    private Decimal 転入前_負担額_70歳以上_合計;

    private Decimal 高額合算70歳以上負担額合計;
    private Decimal 高額合算70歳未満負担額合計;

    private RString 抽出対象支給基準額;
    private RString 事業分高額合算支給額計算_給付の種類;
    private RString 事業分高額合算支給額計算_不支給理由;

    @Override
    protected void initialize() {
        init();
        抽出対象支給基準額 = DbBusinessConfig.get(ConfigNameDBC.事業分高額合算支給額計算_抽出対象支給基準額, RDate.getNowDate());
        事業分高額合算支給額計算_給付の種類 = DbBusinessConfig.get(ConfigNameDBC.事業分高額合算支給額計算_給付の種類, RDate.getNowDate());
        事業分高額合算支給額計算_不支給理由 = DbBusinessConfig.get(ConfigNameDBC.事業分高額合算支給額計算_不支給理由, RDate.getNowDate());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShikyugakuUpdateTempEntity.class);
    }

    @Override
    protected void keyBreakProcess(ShikyugakuCalcTempEntity entity) {
        if (is同じキー項目(entity)) {
            if (区分2.equals(entity.getKubun())) {
                set支給額明細List(entity);
            }
            if (区分3.equals(entity.getKubun())) {
                set事業高額合算List(entity);
            }
            if (区分4.equals(entity.getKubun())) {
                set転入前事業高額合算List(entity);
            }
            calc事業_負担額_70歳以上(entity);
            calc転入前_負担額_70歳以上(entity);
        } else {
            insertTbl();
            init();
        }
    }

    private void insertTbl() {
        if (支給額明細List.isEmpty()) {
            支給額明細List.add(get0件のデータ());
        }
        if (事業高額合算List.isEmpty()) {
            事業高額合算List.add(get0件のデータ());
        }
        if (転入前事業高額合算List.isEmpty()) {
            転入前事業高額合算List.add(get0件のデータ());
        }
        List<HihokenshaFutangaku> 転入前List = new ArrayList<>();
        for (HihokenshaFutangaku 転入前 : 転入前事業高額合算List) {
            if (転入前.get明細被保険者番号() != null && !転入前.get明細被保険者番号().isEmpty()
                    && 転入前.get明細保険者番号() != null && !転入前.get明細保険者番号().isEmpty()) {
                転入前List.add(転入前);
            }
        }
        転入前事業高額合算List = 転入前List;
        事業高額合算分の明細データの集計(事業高額合算List);
        事業高額合算分の明細データの集計(転入前事業高額合算List);
        insert計算結果の更新用データ();
        insert計算結果明細の更新用データ();
    }

    @Override
    protected void usualProcess(ShikyugakuCalcTempEntity entity) {
        if (区分1.equals(entity.getKubun())) {
            set計算用明細データ(entity);
            支給額計算一時_区分1 = entity;
        }
    }

    @Override
    protected void afterExecute() {
        insertTbl();
    }

    private boolean is同じキー項目(ShikyugakuCalcTempEntity entity) {
        return 支給額計算一時_区分1.getHihokenshaNo().equals(entity.getHihokenshaNo())
                && 支給額計算一時_区分1.getTaishoNendo().equals(entity.getTaishoNendo())
                && 支給額計算一時_区分1.getShoKisaiHokenshaNo().equals(entity.getShoKisaiHokenshaNo())
                && 支給額計算一時_区分1.getShikyuShinseishoSeiriNo().equals(entity.getShikyuShinseishoSeiriNo());
    }

    private void init() {
        計算用明細データ = new JigyobunShikyugakuCalcResult();
        支給額計算一時_区分1 = new ShikyugakuCalcTempEntity();
        支給額計算一時_自己負担額 = new ShikyugakuCalcTempEntity();

        負担額_被保険者番号 = null;
        前負担額_被保険者番号 = null;
        前負担額_転入前保険者番号 = null;

        支給額明細List = new ArrayList<>();
        事業高額合算List = new ArrayList<>();
        転入前事業高額合算List = new ArrayList<>();
        登録済キー = new ArrayList<>();

        負担額_70歳以上 = Decimal.ZERO;
        負担額_70歳以上_合計 = Decimal.ZERO;

        転入前_負担額_70歳以上 = Decimal.ZERO;
        転入前_負担額_70歳以上_合計 = Decimal.ZERO;

        高額合算70歳以上負担額合計 = Decimal.ZERO;
        高額合算70歳未満負担額合計 = Decimal.ZERO;
    }

    private void set計算用明細データ(ShikyugakuCalcTempEntity entity) {
        計算用明細データ.set被保険者番号(entity.getHihokenshaNo());
        計算用明細データ.set対象年度(entity.getTaishoNendo());
        計算用明細データ.set支給申請書整理番号(entity.getShikyuShinseishoSeiriNo());
        計算用明細データ.set証記載保険者番号(entity.getShoKisaiHokenshaNo());
        計算用明細データ.set算定基準額(entity.getShikyugaku_santeiKijunGaku());
        計算用明細データ.set算定基準額_70以上(entity.getShikyugaku_over70_SanteiKijyunGaku());
        計算用明細データ.set支給額(entity.getShikyugaku_setaiShikyuSogaku());
        計算用明細データ.set支給額_70以上(entity.getShikyugaku_over70_SetaiShikyuSogaku());
    }

    private void set支給額明細List(ShikyugakuCalcTempEntity entity) {
        HihokenshaFutangaku 明細 = new HihokenshaFutangaku();
        明細.set明細被保険者番号(entity.getShikyugakuMeisai_hihokenshaNo());
        明細.set明細保険者番号(entity.getShikyugakuMeisai_shoKisaiHokenshaNo());
        明細.set明細番号(entity.getShikyugakuMeisai_meisanNo());
        明細.set負担額_70歳以上(rStringToDecimal(entity.getShikyugakuMeisai_over70_Futangaku()));
        明細.set按分率_70歳以上(rStringToDecimal(entity.getShikyugakuMeisai_over70_AmbunRitsu()));
        明細.set支給額_70歳以上(rStringToDecimal(entity.getShikyugakuMeisai_over70_Shikyugaku()));
        明細.set負担額_70歳未満(rStringToDecimal(entity.getShikyugakuMeisai_under70_Futangaku()));
        明細.set負担額(rStringToDecimal(entity.getShikyugakuMeisai_futangaku()));
        明細.set按分率(rStringToDecimal(entity.getShikyugakuMeisai_ambunRitsu()));
        明細.set支給額_70歳未満(rStringToDecimal(entity.getShikyugakuMeisai_under70_Shikyugaku()));
        明細.set支給額(rStringToDecimal(entity.getShikyugakuMeisai_shikyugaku()));

        明細.set計算結果明細(entity);
        支給額明細List.add(明細);

        高額合算70歳以上負担額合計 = 高額合算70歳以上負担額合計.add(明細.get負担額_70歳以上());
        高額合算70歳未満負担額合計 = 高額合算70歳未満負担額合計.add(明細.get負担額_70歳未満());
    }

    private void set事業高額合算List(ShikyugakuCalcTempEntity entity) {
        HihokenshaFutangaku 明細 = new HihokenshaFutangaku();
        明細.set明細被保険者番号(entity.getFutangaku_hihokenshaNo());
        明細.set明細保険者番号(entity.getFutangaku_hokenshaNo());
        明細.set明細番号(ZERO);
        明細.set負担額_70歳以上(Decimal.ZERO);
        明細.set按分率_70歳以上(Decimal.ONE);
        明細.set支給額_70歳以上(Decimal.ZERO);
        明細.set負担額_70歳未満(minusDecimal(entity.getFutangaku_sumi_Gokei_JikoFutanGaku(),
                entity.getFutangaku_sumi_Gokei_Under70KogakuShikyuGaku()));
        明細.set負担額(Decimal.ZERO);
        明細.set按分率(Decimal.ONE);
        明細.set支給額_70歳未満(Decimal.ZERO);
        明細.set支給額(Decimal.ZERO);
        if (entity.getHihokenshaNo().equals(entity.getFutangaku_hihokenshaNo())) {
            支給額計算一時_自己負担額 = entity;
        }
        明細.set自己負担額(entity);
        事業高額合算List.add(明細);
    }

    private void set転入前事業高額合算List(ShikyugakuCalcTempEntity entity) {
        HihokenshaFutangaku 明細 = new HihokenshaFutangaku();
        明細.set明細被保険者番号(entity.getZenFutangaku_hihokenshaNo());
        明細.set明細保険者番号(entity.getZenFutangaku_tennyumaeHokenshaNo());
        明細.set明細番号(ZERO);
        明細.set負担額_70歳以上(Decimal.ZERO);
        明細.set按分率_70歳以上(Decimal.ONE);
        明細.set支給額_70歳以上(Decimal.ZERO);
        明細.set負担額_70歳未満(minusDecimal(entity.getZenFutangaku_gokei_JikoFutanGaku(),
                entity.getZenFutangaku_gokei_Under70KogakuShikyuGaku()));
        明細.set負担額(Decimal.ZERO);
        明細.set按分率(Decimal.ONE);
        明細.set支給額_70歳未満(Decimal.ZERO);
        明細.set支給額(Decimal.ZERO);

        明細.set証明書(entity);
        転入前事業高額合算List.add(明細);
    }

    private void calc事業_負担額_70歳以上(ShikyugakuCalcTempEntity entity) {
        if (!区分5.equals(entity.getKubun())) {
            return;
        }
        if (負担額_被保険者番号 == null) {
            負担額_被保険者番号 = entity.getFutangakuMeisai_hihokenshaNo();
            負担額_保険者番号 = entity.getFutangakuMeisai_hokenshaNo();
        }
        if (負担額_被保険者番号.equals(entity.getFutangakuMeisai_hihokenshaNo())
                && 負担額_保険者番号.equals(entity.getFutangakuMeisai_hokenshaNo())) {
            if (Decimal.ZERO.compareTo(entity.getFutangakuMeisai_sumi_70_74JikoFutanGaku()) < 0
                    && !給付額減額.equals(entity.getFutangakuMeisai_sumi_Tekiyo())) {
                負担額_70歳以上 = 負担額_70歳以上.add(minusDecimal(entity.getFutangakuMeisai_sumi_70_74JikoFutanGaku(),
                        entity.getFutangakuMeisai_sumi_under_70KogakuShikyuGaku()));
            }
            負担額_70歳以上_合計 = 負担額_70歳以上_合計.add(minusDecimal(entity.getFutangakuMeisai_sumi_70_74JikoFutanGaku(),
                    entity.getFutangakuMeisai_sumi_under_70KogakuShikyuGaku()));
            for (HihokenshaFutangaku 事業高額合算 : 事業高額合算List) {
                if (負担額_被保険者番号.equals(事業高額合算.get明細被保険者番号())
                        && 負担額_保険者番号.equals(事業高額合算.get明細保険者番号())) {
                    事業高額合算.set負担額_70歳以上(負担額_70歳以上);
                    事業高額合算.set負担額_70歳以上_合計(負担額_70歳以上_合計);
                    break;
                }
            }
        } else {
            負担額_被保険者番号 = entity.getFutangakuMeisai_hihokenshaNo();
            負担額_保険者番号 = entity.getFutangakuMeisai_hokenshaNo();
            負担額_70歳以上 = Decimal.ZERO;
            if (Decimal.ZERO.compareTo(entity.getFutangakuMeisai_sumi_70_74JikoFutanGaku()) < 0
                    && !給付額減額.equals(entity.getFutangakuMeisai_sumi_Tekiyo())) {
                負担額_70歳以上 = 負担額_70歳以上.add(minusDecimal(entity.getFutangakuMeisai_sumi_70_74JikoFutanGaku(),
                        entity.getFutangakuMeisai_sumi_under_70KogakuShikyuGaku()));
            }
            負担額_70歳以上_合計 = minusDecimal(entity.getFutangakuMeisai_sumi_70_74JikoFutanGaku(),
                    entity.getFutangakuMeisai_sumi_under_70KogakuShikyuGaku());
        }
    }

    private void calc転入前_負担額_70歳以上(ShikyugakuCalcTempEntity entity) {
        if (!区分6.equals(entity.getKubun())) {
            return;
        }
        if (前負担額_被保険者番号 == null) {
            前負担額_被保険者番号 = entity.getZenFutangakuMeisai_hihokenshaNo();
            前負担額_転入前保険者番号 = entity.getZenFutangakuMeisai_tennyumaeHokenshaNo();
        }

        if (前負担額_被保険者番号.equals(entity.getZenFutangakuMeisai_hihokenshaNo())
                && 前負担額_転入前保険者番号.equals(entity.getZenFutangakuMeisai_tennyumaeHokenshaNo())) {
            if (Decimal.ZERO.compareTo(entity.getZenFutangakuMeisai_uchisu_70_74JikoFutanGaku()) < 0
                    && !給付額減額.equals(entity.getZenFutangakuMeisai_tekiyo())) {
                転入前_負担額_70歳以上 = 転入前_負担額_70歳以上.add(minusDecimal(entity.getZenFutangakuMeisai_uchisu_70_74JikoFutanGaku(),
                        entity.getZenFutangakuMeisai_under_70KogakuShikyuGaku()));
            }
            転入前_負担額_70歳以上_合計 = 転入前_負担額_70歳以上_合計.add(minusDecimal(entity.getZenFutangakuMeisai_uchisu_70_74JikoFutanGaku(),
                    entity.getZenFutangakuMeisai_under_70KogakuShikyuGaku()));
            for (HihokenshaFutangaku 転入前 : 転入前事業高額合算List) {
                if (前負担額_被保険者番号.equals(転入前.get明細被保険者番号())
                        && 前負担額_転入前保険者番号.equals(転入前.get明細保険者番号())) {
                    転入前.set負担額_70歳以上(転入前_負担額_70歳以上);
                    転入前.set負担額_70歳以上_合計(転入前_負担額_70歳以上_合計);
                    break;
                }
            }
        } else {
            前負担額_被保険者番号 = entity.getZenFutangakuMeisai_hihokenshaNo();
            前負担額_転入前保険者番号 = entity.getZenFutangakuMeisai_tennyumaeHokenshaNo();
            転入前_負担額_70歳以上 = Decimal.ZERO;
            if (Decimal.ZERO.compareTo(entity.getZenFutangakuMeisai_uchisu_70_74JikoFutanGaku()) < 0
                    && !給付額減額.equals(entity.getZenFutangakuMeisai_tekiyo())) {
                転入前_負担額_70歳以上 = 転入前_負担額_70歳以上.add(minusDecimal(entity.getZenFutangakuMeisai_uchisu_70_74JikoFutanGaku(),
                        entity.getZenFutangakuMeisai_under_70KogakuShikyuGaku()));
            }
            転入前_負担額_70歳以上_合計 = minusDecimal(entity.getZenFutangakuMeisai_uchisu_70_74JikoFutanGaku(),
                    entity.getZenFutangakuMeisai_under_70KogakuShikyuGaku());
        }
    }

    private void 事業高額合算分の明細データの集計(List<HihokenshaFutangaku> 高額合算List) {
        Decimal 支給額_差分;
        Decimal 支給額_70歳以上の合計 = Decimal.ZERO;
        for (HihokenshaFutangaku 高額合算 : 高額合算List) {
            if (Decimal.ZERO.compareTo(計算用明細データ.get算定基準額_70以上()) == 0) {
                高額合算.set負担額_70歳以上(Decimal.ZERO);
                高額合算.set按分率_70歳以上(Decimal.ONE);
                高額合算.set支給額_70歳以上(Decimal.ZERO);
                continue;
            }
            高額合算.set按分率_70歳以上(divideDecimal(高額合算.get負担額_70歳以上(), 高額合算.get負担額_70歳以上_合計()));
            支給額_差分 = minusDecimal(addDecimal(高額合算70歳以上負担額合計, 高額合算.get負担額_70歳以上_合計()),
                    addDecimal(計算用明細データ.get算定基準額_70以上(), 計算用明細データ.get支給額_70以上()));
            if (Decimal.ONE.compareTo(支給額_差分) <= 0) {
                高額合算.set支給額_70歳以上(支給額_差分.multiply(高額合算.get按分率_70歳以上()));
            }
            if (Decimal.ZERO.compareTo(支給額_差分) >= 0) {
                高額合算.set支給額_70歳以上(Decimal.ZERO);
            }
            支給額_70歳以上の合計 = addDecimal(支給額_70歳以上の合計, 高額合算.get支給額_70歳以上());
        }
        for (HihokenshaFutangaku 高額合算 : 高額合算List) {
            if (Decimal.ZERO.compareTo(計算用明細データ.get算定基準額()) == 0) {
                高額合算.set支給額_70歳未満(Decimal.ZERO);
                高額合算.set負担額(Decimal.ZERO);
                高額合算.set按分率(Decimal.ONE);
            } else {
                高額合算.set負担額(minusDecimal(addDecimal(高額合算.get負担額_70歳未満(), 高額合算.get負担額_70歳以上()),
                        高額合算.get支給額_70歳以上()));
                Decimal 負担額合計 = minusDecimal(addDecimal(高額合算.get負担額_70歳以上_合計(), 高額合算.get負担額_70歳未満()),
                        支給額_70歳以上の合計);
                高額合算.set按分率(divideDecimal(高額合算.get負担額(), 負担額合計));
                支給額_差分 = minusDecimal(addDecimal(高額合算70歳未満負担額合計, 高額合算.get負担額_70歳未満()),
                        addDecimal(計算用明細データ.get算定基準額(), 計算用明細データ.get支給額()));
                if (Decimal.ONE.compareTo(支給額_差分) <= 0) {
                    高額合算.set支給額_70歳未満(支給額_差分.multiply(高額合算.get按分率()));
                }
                if (Decimal.ZERO.compareTo(支給額_差分) >= 0) {
                    高額合算.set支給額_70歳未満(Decimal.ZERO);
                }
            }
            高額合算.set支給額(addDecimal(高額合算.get支給額_70歳以上(), 高額合算.get支給額_70歳未満()));
            if (rStringToDecimal(抽出対象支給基準額).compareTo(高額合算.get支給額()) >= 0) {
                高額合算.set按分率_70歳以上(Decimal.ONE);
                高額合算.set按分率(Decimal.ONE);
                高額合算.set支給額_70歳以上(Decimal.ZERO);
                高額合算.set支給額_70歳未満(Decimal.ZERO);
                高額合算.set支給額(Decimal.ZERO);
            }
        }
    }

    private void insert計算結果の更新用データ() {
        List<HihokenshaFutangaku> 事業高額合算 = new ArrayList<>();
        Decimal 事業_負担額_70歳以上 = Decimal.ZERO;
        Decimal 事業_支給額_70歳以上 = Decimal.ZERO;
        Decimal 事業_負担額_70歳未満 = Decimal.ZERO;
        Decimal 事業_支給額_70歳未満 = Decimal.ZERO;
        Decimal 事業_支給額 = Decimal.ZERO;
        Decimal 事業_負担額 = Decimal.ZERO;
        Decimal 事業_支給額_対象者分のみ = Decimal.ZERO;
        Decimal 事業_支給額_70歳以上_対象者分のみ = Decimal.ZERO;
        for (HihokenshaFutangaku 高額合算 : 事業高額合算List) {
            if (計算用明細データ.get被保険者番号().equals(高額合算.get明細被保険者番号())
                    && 計算用明細データ.get証記載保険者番号().equals(高額合算.get明細保険者番号())) {
                事業高額合算.add(高額合算);
                事業_支給額_対象者分のみ = addDecimal(事業_支給額_対象者分のみ, 高額合算.get支給額());
                事業_支給額_70歳以上_対象者分のみ = addDecimal(事業_支給額_70歳以上_対象者分のみ, 高額合算.get支給額_70歳以上());
            }
            事業_負担額_70歳以上 = addDecimal(事業_負担額_70歳以上, 高額合算.get負担額_70歳以上());
            事業_支給額_70歳以上 = addDecimal(事業_支給額_70歳以上, 高額合算.get支給額_70歳以上());
            事業_負担額_70歳未満 = addDecimal(事業_負担額_70歳未満, 高額合算.get負担額_70歳未満());
            事業_支給額_70歳未満 = addDecimal(事業_支給額_70歳未満, 高額合算.get支給額_70歳未満());
            事業_負担額 = addDecimal(事業_負担額, 高額合算.get負担額());
            事業_支給額 = addDecimal(事業_支給額, 高額合算.get支給額());
        }
        Decimal 支給額_負担額_70歳以上 = Decimal.ZERO;
        Decimal 支給額_支給額_70歳以上 = Decimal.ZERO;
        Decimal 支給額_負担額_70歳未満 = Decimal.ZERO;
        Decimal 支給額_支給額_70歳未満 = Decimal.ZERO;
        Decimal 支給額_支給額 = Decimal.ZERO;
        Decimal 支給額_負担額 = Decimal.ZERO;
        for (HihokenshaFutangaku 高額合算 : 支給額明細List) {
            支給額_負担額_70歳以上 = addDecimal(支給額_負担額_70歳以上, 高額合算.get負担額_70歳以上());
            支給額_支給額_70歳以上 = addDecimal(支給額_支給額_70歳以上, 高額合算.get支給額_70歳以上());
            支給額_負担額_70歳未満 = addDecimal(支給額_負担額_70歳未満, 高額合算.get負担額_70歳未満());
            支給額_支給額_70歳未満 = addDecimal(支給額_支給額_70歳未満, 高額合算.get支給額_70歳未満());
            支給額_支給額 = addDecimal(支給額_支給額, 高額合算.get支給額());
            支給額_負担額 = addDecimal(支給額_負担額, 高額合算.get負担額());
        }
        Decimal 前事業_負担額_70歳以上 = Decimal.ZERO;
        Decimal 前事業_支給額_70歳以上 = Decimal.ZERO;
        Decimal 前事業_負担額_70歳未満 = Decimal.ZERO;
        Decimal 前事業_支給額_70歳未満 = Decimal.ZERO;
        Decimal 前事業_支給額 = Decimal.ZERO;
        Decimal 前事業_負担額 = Decimal.ZERO;
        Decimal 前事業_支給額_対象者分のみ = Decimal.ZERO;
        Decimal 前事業_支給額_70歳以上_対象者分のみ = Decimal.ZERO;
        for (HihokenshaFutangaku 高額合算 : 転入前事業高額合算List) {
            if (計算用明細データ.get被保険者番号().equals(高額合算.get明細被保険者番号())
                    && 計算用明細データ.get証記載保険者番号().equals(高額合算.get明細保険者番号())) {
                前事業_支給額_対象者分のみ = addDecimal(前事業_支給額_対象者分のみ, 高額合算.get支給額());
                前事業_支給額_70歳以上_対象者分のみ = addDecimal(前事業_支給額_70歳以上_対象者分のみ, 高額合算.get支給額_70歳以上());
            }
            前事業_負担額_70歳以上 = addDecimal(前事業_負担額_70歳以上, 高額合算.get負担額_70歳以上());
            前事業_支給額_70歳以上 = addDecimal(前事業_支給額_70歳以上, 高額合算.get支給額_70歳以上());
            前事業_負担額_70歳未満 = addDecimal(前事業_負担額_70歳未満, 高額合算.get負担額_70歳未満());
            前事業_支給額_70歳未満 = addDecimal(前事業_支給額_70歳未満, 高額合算.get支給額_70歳未満());
            前事業_負担額 = addDecimal(前事業_負担額, 高額合算.get負担額());
            前事業_支給額 = addDecimal(前事業_支給額, 高額合算.get支給額());
        }
        Decimal 全明細_負担額_70歳以上_合計 = addDecimal(addDecimal(事業_負担額_70歳以上, 支給額_負担額_70歳以上), 前事業_負担額_70歳以上);
        Decimal 全明細_負担額_70歳未満_合計 = addDecimal(addDecimal(事業_負担額_70歳未満, 支給額_負担額_70歳未満), 前事業_負担額_70歳未満);
        Decimal 全明細_負担額_合計 = addDecimal(addDecimal(事業_負担額, 支給額_負担額), 前事業_負担額);
        Decimal 全明細_支給額_70歳以上_合計 = addDecimal(addDecimal(事業_支給額_70歳以上, 支給額_支給額_70歳以上), 前事業_支給額_70歳以上);
        Decimal 全明細_支給額_70歳未満_合計 = addDecimal(addDecimal(事業_支給額_70歳未満, 支給額_支給額_70歳未満), 前事業_支給額_70歳未満);
        Decimal 全明細_支給額_合計 = addDecimal(addDecimal(事業_支給額, 支給額_支給額), 前事業_支給額);
        for (HihokenshaFutangaku 高額合算 : 事業高額合算) {
            if (is登録済(高額合算.get明細被保険者番号(), 支給額計算一時_区分1.getTaishoNendo(),
                    高額合算.get明細保険者番号(), 支給額計算一時_区分1.getShikyuShinseishoSeiriNo())) {
                continue;
            }
            ShikyugakuUpdateTempEntity entity = new ShikyugakuUpdateTempEntity();
            entity.setHihokenshaNo(高額合算.get明細被保険者番号());
            entity.setShoKisaiHokenshaNo(高額合算.get明細保険者番号());
            entity.setKubun(区分1);
            entity.setShikyugaku_hihokenshaNo(高額合算.get明細被保険者番号());
            entity.setShikyugaku_shoKisaiHokenshaNo(高額合算.get明細保険者番号());
            entity.setShikyugaku_rirekiNo(1);
            entity.setShikyugaku_hokenSeidoCode(保険制度コード_3);
            entity.setShikyugaku_setaiFutanSogaku(addDecimal(全明細_負担額_70歳以上_合計, 全明細_負担額_70歳未満_合計));
            entity.setShikyugaku_setaiGassanGaku(全明細_負担額_合計);
            entity.setShikyugaku_over70_SetaiGassanGaku(全明細_負担額_70歳以上_合計);
            entity.setShikyugaku_setaiShikyuSogaku(事業_支給額);
            entity.setShikyugaku_over70_SetaiShikyuSogaku(事業_支給額_70歳以上);
            entity.setShikyugaku_honninShikyugaku(事業_支給額_対象者分のみ);
            entity.setShikyugaku_over70_honninShikyugaku(事業_支給額_70歳以上_対象者分のみ);
            set事業高額合算For更新用一時(entity);
            entity.setShikyugaku_over70_FutangakuGokei(全明細_負担額_70歳以上_合計);
            entity.setShikyugaku_over70_ShikyugakuGokei(全明細_支給額_70歳以上_合計);
            entity.setShikyugaku_under70_FutangakuGokei(全明細_負担額_70歳未満_合計);
            entity.setShikyugaku_under70_ShikyugakuGokei(全明細_支給額_70歳未満_合計);
            entity.setShikyugaku_futangakuGokei(全明細_負担額_合計);
            entity.setShikyugaku_shikyugakuGokei(全明細_支給額_合計);
            update更新用一時Entity(entity, 全明細_負担額_合計);
            entity.setState(EntityDataState.Added);
            tempDbWriter.insert(entity);
        }

        for (HihokenshaFutangaku 高額合算 : 転入前事業高額合算List) {
            if (is登録済(高額合算.get明細被保険者番号(), 支給額計算一時_区分1.getTaishoNendo(),
                    高額合算.get明細保険者番号(), 支給額計算一時_区分1.getShikyuShinseishoSeiriNo())) {
                continue;
            }
            ShikyugakuUpdateTempEntity entity = new ShikyugakuUpdateTempEntity();
            entity.setHihokenshaNo(高額合算.get明細被保険者番号());
            entity.setTaishoNendo(支給額計算一時_区分1.getTaishoNendo());
            entity.setShoKisaiHokenshaNo(高額合算.get明細保険者番号());
            entity.setShikyuShinseishoSeiriNo(支給額計算一時_区分1.getShikyuShinseishoSeiriNo());
            entity.setKubun(区分1);
            entity.setShikyugaku_hihokenshaNo(高額合算.get明細被保険者番号());
            entity.setShikyugaku_taishoNendo(支給額計算一時_区分1.getTaishoNendo());
            entity.setShikyugaku_shoKisaiHokenshaNo(高額合算.get明細保険者番号());
            entity.setShikyugaku_shikyuShinseishoSeiriNo(支給額計算一時_区分1.getShikyugaku_shikyuShinseishoSeiriNo());
            entity.setShikyugaku_rirekiNo(1);
            entity.setShikyugaku_hokenSeidoCode(保険制度コード_3);
            entity.setShikyugaku_jikoFutanSeiriNo(高額合算.get証明書().getZenFutangaku_jikoFutanSeiriNo());
            entity.setShikyugaku_taishoKeisanKaishiYMD(高額合算.get証明書().getZenFutangaku_taishoKeisanKaishiYMD());
            entity.setShikyugaku_taishoKeisanShuryoYMD(高額合算.get証明書().getZenFutangaku_taishoKeisanShuryoYMD());
            entity.setShikyugaku_setaiFutanSogaku(addDecimal(全明細_負担額_70歳以上_合計, 全明細_負担額_70歳未満_合計));
            entity.setShikyugaku_setaiGassanGaku(全明細_負担額_合計);
            entity.setShikyugaku_over70_SetaiGassanGaku(全明細_負担額_70歳以上_合計);
            entity.setShikyugaku_shotokuKubun(支給額計算一時_区分1.getShikyugaku_shotokuKubun());
            entity.setShikyugaku_over70_ShotokuKubun(支給額計算一時_区分1.getShikyugaku_over70_ShotokuKubun());
            entity.setShikyugaku_santeiKijunGaku(支給額計算一時_区分1.getShikyugaku_santeiKijunGaku());
            entity.setShikyugaku_over70_SanteiKijyunGaku(支給額計算一時_区分1.getShikyugaku_over70_SanteiKijyunGaku());
            entity.setShikyugaku_setaiShikyuSogaku(前事業_支給額);
            entity.setShikyugaku_over70_SetaiShikyuSogaku(前事業_支給額_70歳以上);
            entity.setShikyugaku_honninShikyugaku(前事業_支給額_対象者分のみ);
            entity.setShikyugaku_over70_honninShikyugaku(前事業_支給額_70歳以上_対象者分のみ);
            entity.setShikyugaku_teiShotoku_1_SaiKeisanUmu(ONE);
            entity.setShikyugaku_kekkaRenrakusakiYubinNo(高額合算.get証明書().getZenFutangaku_atesakiYubinNo());
            entity.setShikyugaku_kekkaRenrakusakiJusho(高額合算.get証明書().getZenFutangaku_atesakiJusho());
            entity.setShikyugaku_kekkaRenrakusakiMeisho2(高額合算.get証明書().getZenFutangaku_madoguchi_TaishoshaHanteiCode());
            entity.setShikyugaku_kettaRenrakusakiMeisho1(高額合算.get証明書().getZenFutangaku_atesakiShimei());
            entity.setShikyugaku_over70_FutangakuGokei(全明細_負担額_70歳以上_合計);
            entity.setShikyugaku_over70_ShikyugakuGokei(全明細_支給額_70歳以上_合計);
            entity.setShikyugaku_under70_FutangakuGokei(全明細_負担額_70歳未満_合計);
            entity.setShikyugaku_under70_ShikyugakuGokei(全明細_支給額_70歳未満_合計);
            entity.setShikyugaku_futangakuGokei(全明細_負担額_合計);
            entity.setShikyugaku_shikyugakuGokei(全明細_支給額_合計);
            entity.setShikyugaku_dataKubun(支給額計算一時_区分1.getShikyugaku_dataKubun());
            entity.setShikyugaku_saisoFG(支給額計算一時_区分1.getShikyugaku_saisoFG());
            update更新用一時Entity(entity, 全明細_負担額_合計);
            entity.setState(EntityDataState.Added);
            tempDbWriter.insert(entity);
        }
    }

    private void set事業高額合算For更新用一時(ShikyugakuUpdateTempEntity entity) {
        entity.setTaishoNendo(支給額計算一時_区分1.getTaishoNendo());
        entity.setShikyuShinseishoSeiriNo(支給額計算一時_区分1.getShikyuShinseishoSeiriNo());
        entity.setShikyugaku_taishoNendo(支給額計算一時_区分1.getTaishoNendo());
        entity.setShikyugaku_shikyuShinseishoSeiriNo(支給額計算一時_区分1.getShikyugaku_shikyuShinseishoSeiriNo());
        entity.setShikyugaku_jikoFutanSeiriNo(支給額計算一時_区分1.getShikyugaku_jikoFutanSeiriNo());
        entity.setShikyugaku_taishoKeisanKaishiYMD(支給額計算一時_区分1.getShikyugaku_taishoKeisanKaishiYMD());
        entity.setShikyugaku_taishoKeisanShuryoYMD(支給額計算一時_区分1.getShikyugaku_taishoKeisanShuryoYMD());
        entity.setShikyugaku_shotokuKubun(支給額計算一時_区分1.getShikyugaku_shotokuKubun());
        entity.setShikyugaku_over70_ShotokuKubun(支給額計算一時_区分1.getShikyugaku_over70_ShotokuKubun());
        entity.setShikyugaku_santeiKijunGaku(支給額計算一時_区分1.getShikyugaku_santeiKijunGaku());
        entity.setShikyugaku_over70_SanteiKijyunGaku(支給額計算一時_区分1.getShikyugaku_over70_SanteiKijyunGaku());
        entity.setShikyugaku_teiShotoku_1_SaiKeisanUmu(支給額計算一時_区分1.getShikyugaku_teiShotoku_1_SaiKeisanUmu());
        entity.setShikyugaku_biko(支給額計算一時_区分1.getShikyugaku_biko());
        entity.setShikyugaku_kekkaRenrakusakiYubinNo(支給額計算一時_区分1.getShikyugaku_kekkaRenrakusakiYubinNo());
        entity.setShikyugaku_kekkaRenrakusakiJusho(支給額計算一時_区分1.getShikyugaku_kekkaRenrakusakiJusho());
        entity.setShikyugaku_kekkaRenrakusakiMeisho2(支給額計算一時_区分1.getShikyugaku_kekkaRenrakusakiMeisho2());
        entity.setShikyugaku_kettaRenrakusakiMeisho1(支給額計算一時_区分1.getShikyugaku_kettaRenrakusakiMeisho1());
        entity.setShikyugaku_tsuchiYMD(支給額計算一時_区分1.getShikyugaku_tsuchiYMD());
        entity.setShikyugaku_renrakuhyoHakkoshaMei(支給額計算一時_区分1.getShikyugaku_renrakuhyoHakkoshaMei());
        entity.setShikyugaku_renrakuhyoHakkoshaYubinNo(支給額計算一時_区分1.getShikyugaku_renrakuhyoHakkoshaYubinNo());
        entity.setShikyugaku_renrakuhyoHakkoshaJusho(支給額計算一時_区分1.getShikyugaku_renrakuhyoHakkoshaJusho());
        entity.setShikyugaku_toiawasesakiYobinNo(支給額計算一時_区分1.getShikyugaku_toiawasesakiYobinNo());
        entity.setShikyugaku_toiawasesakiJusho(支給額計算一時_区分1.getShikyugaku_toiawasesakiJusho());
        entity.setShikyugaku_toiawasesakiMeisho1(支給額計算一時_区分1.getShikyugaku_toiawasesakiMeisho1());
        entity.setShikyugaku_toiawasesakiMeisho2(支給額計算一時_区分1.getShikyugaku_toiawasesakiMeisho2());
        entity.setShikyugaku_toiawasesakiTelNo(支給額計算一時_区分1.getShikyugaku_toiawasesakiTelNo());
        entity.setShikyugaku_dataKubun(支給額計算一時_区分1.getShikyugaku_dataKubun());
        entity.setShikyugaku_saisoFG(支給額計算一時_区分1.getShikyugaku_saisoFG());
    }

    private void insert計算結果明細の更新用データ() {
        Decimal meisaiNo = Decimal.ZERO;
        for (HihokenshaFutangaku 高額合算 : 支給額明細List) {
            if (高額合算.get計算結果明細() == null || !(高額合算.get明細被保険者番号().equals(高額合算.get計算結果明細().getShikyugakuMeisai_hihokenshaNo())
                    && 計算用明細データ.get対象年度().equals(高額合算.get計算結果明細().getShikyugakuMeisai_taishoNendo())
                    && 高額合算.get明細保険者番号().equals(高額合算.get計算結果明細().getShikyugakuMeisai_shoKisaiHokenshaNo())
                    && 計算用明細データ.get支給申請書整理番号().equals(高額合算.get計算結果明細().getShikyugakuMeisai_shikyuShinseishoSeiriNo())
                    && 高額合算.get明細番号().equals(高額合算.get計算結果明細().getMeisaiNo()))) {
                continue;
            }
            if (is登録済(高額合算.get明細被保険者番号(), 支給額計算一時_区分1.getTaishoNendo(),
                    高額合算.get明細保険者番号(), 支給額計算一時_区分1.getShikyuShinseishoSeiriNo())) {
                continue;
            }
            ShikyugakuUpdateTempEntity entity = new ShikyugakuUpdateTempEntity();
            entity.setHihokenshaNo(高額合算.get明細被保険者番号());
            entity.setTaishoNendo(支給額計算一時_区分1.getTaishoNendo());
            entity.setShoKisaiHokenshaNo(高額合算.get明細保険者番号());
            entity.setShikyuShinseishoSeiriNo(支給額計算一時_区分1.getShikyuShinseishoSeiriNo());
            entity.setKubun(区分2);
            entity.setMeisaiNo(高額合算.get計算結果明細().getMeisaiNo());
            entity.setMeisaiHihokenshaNo(高額合算.get計算結果明細().getMeisaiHihokenshaNo());

            entity.setShikyugakuMeisai_hihokenshaNo(高額合算.get明細被保険者番号());
            entity.setShikyugakuMeisai_taishoNendo(支給額計算一時_区分1.getTaishoNendo());
            entity.setShikyugakuMeisai_shoKisaiHokenshaNo(高額合算.get明細保険者番号());
            entity.setShikyugakuMeisai_shikyuShinseishoSeiriNo(支給額計算一時_区分1.getShikyugaku_shikyuShinseishoSeiriNo());

            entity.setShikyugakuMeisai_meisanNo(高額合算.get計算結果明細().getShikyugakuMeisai_meisanNo());
            entity.setShikyugakuMeisai_rirekiNo(高額合算.get計算結果明細().getShikyugakuMeisai_rirekiNo().intValue());
            entity.setShikyugakuMeisai_hokenSeidoCode(高額合算.get計算結果明細().getShikyugakuMeisai_hokenSeidoCode());
            entity.setShikyugakuMeisai_uchiwakeHokenshaNo(高額合算.get計算結果明細().getShikyugakuMeisai_uchiwakeHokenshaNo());
            entity.setShikyugakuMeisai_kokuho_HihokenshaShoKigo(高額合算.get計算結果明細().getShikyugakuMeisai_kokuho_HihokenshaShoKigo());
            entity.setShikyugakuMeisai_hiHokenshaShoNo(高額合算.get計算結果明細().getShikyugakuMeisai_hiHokenshaShoNo());
            entity.setShikyugakuMeisai_uchiwakeHokenshaMei(高額合算.get計算結果明細().getShikyugakuMeisai_uchiwakeHokenshaMei());
            entity.setShikyugakuMeisai_jikoFutanSeiriNo(高額合算.get計算結果明細().getShikyugakuMeisai_jikoFutanSeiriNo());
            entity.setShikyugakuMeisai_taishoshaShimei(高額合算.get計算結果明細().getShikyugakuMeisai_taishoshaShimei());
            entity.setShikyugakuMeisai_over70_Futangaku(高額合算.get計算結果明細().getShikyugakuMeisai_over70_Futangaku());
            entity.setShikyugakuMeisai_over70_AmbunRitsu(高額合算.get計算結果明細().getShikyugakuMeisai_over70_AmbunRitsu());
            entity.setShikyugakuMeisai_over70_Shikyugaku(高額合算.get計算結果明細().getShikyugakuMeisai_over70_Shikyugaku());
            entity.setShikyugakuMeisai_under70_Futangaku(高額合算.get計算結果明細().getShikyugakuMeisai_under70_Futangaku());
            entity.setShikyugakuMeisai_futangaku(高額合算.get計算結果明細().getShikyugakuMeisai_futangaku());
            entity.setShikyugakuMeisai_ambunRitsu(高額合算.get計算結果明細().getShikyugakuMeisai_ambunRitsu());
            entity.setShikyugakuMeisai_under70_Shikyugaku(高額合算.get計算結果明細().getShikyugakuMeisai_under70_Shikyugaku());
            entity.setShikyugakuMeisai_shikyugaku(高額合算.get計算結果明細().getShikyugakuMeisai_shikyugaku());
            entity.setShikyugakuMeisai_over70_Biko(高額合算.get計算結果明細().getShikyugakuMeisai_over70_Biko());
            entity.setShikyugakuMeisai_under70_Biko(高額合算.get計算結果明細().getShikyugakuMeisai_under70_Biko());
            if (parameter.get受取年月() != null) {
                entity.setShikyugakuMeisai_uketoriYM(parameter.get受取年月());
            }
            entity.setShikyugakuMeisai_dataKubun(TWO);
            entity.setState(EntityDataState.Added);
            tempDbWriter.insert(entity);
            if (meisaiNo.compareTo(rStringToDecimal(高額合算.get計算結果明細().getMeisaiNo())) < 0) {
                meisaiNo = rStringToDecimal(高額合算.get計算結果明細().getShikyugakuMeisai_meisanNo());
            }
        }
        for (HihokenshaFutangaku 高額合算 : 事業高額合算List) {
            if (高額合算.get自己負担額() == null || is登録済(高額合算.get明細被保険者番号(), 支給額計算一時_区分1.getTaishoNendo(),
                    高額合算.get明細保険者番号(), 支給額計算一時_区分1.getShikyuShinseishoSeiriNo())) {
                continue;
            }
            meisaiNo = Decimal.ONE.add(meisaiNo);
            ShikyugakuUpdateTempEntity entity = new ShikyugakuUpdateTempEntity();
            entity.setHihokenshaNo(高額合算.get明細被保険者番号());
            entity.setTaishoNendo(支給額計算一時_区分1.getTaishoNendo());
            entity.setShoKisaiHokenshaNo(高額合算.get明細保険者番号());
            entity.setShikyuShinseishoSeiriNo(支給額計算一時_区分1.getShikyuShinseishoSeiriNo());
            entity.setKubun(区分3);
            entity.setMeisaiNo(new RString(meisaiNo.toString()));
            entity.setMeisaiHihokenshaNo(高額合算.get自己負担額().getFutangaku_hihokenshaNo());

            entity.setShikyugakuMeisai_hihokenshaNo(高額合算.get明細被保険者番号());
            entity.setShikyugakuMeisai_taishoNendo(支給額計算一時_区分1.getTaishoNendo());
            entity.setShikyugakuMeisai_shoKisaiHokenshaNo(高額合算.get明細保険者番号());
            entity.setShikyugakuMeisai_shikyuShinseishoSeiriNo(支給額計算一時_区分1.getShikyugaku_shikyuShinseishoSeiriNo());

            entity.setShikyugakuMeisai_meisanNo(new RString(meisaiNo.toString()));
            entity.setShikyugakuMeisai_rirekiNo(1);
            entity.setShikyugakuMeisai_hokenSeidoCode(保険制度コード_3);
            entity.setShikyugakuMeisai_uchiwakeHokenshaNo(高額合算.get自己負担額().getFutangaku_hokenshaNo().value());
            entity.setShikyugakuMeisai_kokuho_HihokenshaShoKigo(高額合算.get自己負担額().getFutangaku_kokuho_HihokenshaShoKigo());
            entity.setShikyugakuMeisai_hiHokenshaShoNo(高額合算.get自己負担額().getFutangaku_hihokenshaNo().getColumnValue());
            entity.setShikyugakuMeisai_uchiwakeHokenshaMei(高額合算.get自己負担額().getFutangaku_hokenshaMei());
            entity.setShikyugakuMeisai_jikoFutanSeiriNo(高額合算.get自己負担額().getFutangaku_jikoFutanSeiriNo());
            entity.setShikyugakuMeisai_taishoshaShimei(get被保険者氏名(高額合算.get自己負担額().getFutangaku_hihokenshaShimei()));
            entity.setShikyugakuMeisai_over70_Futangaku(new RString(高額合算.get負担額_70歳以上().toString()));
            entity.setShikyugakuMeisai_over70_AmbunRitsu(new RString(高額合算.get按分率_70歳以上().toString()));
            entity.setShikyugakuMeisai_over70_Shikyugaku(new RString(高額合算.get支給額_70歳以上().toString()));
            entity.setShikyugakuMeisai_under70_Futangaku(new RString(高額合算.get負担額_70歳未満().toString()));
            entity.setShikyugakuMeisai_futangaku(new RString(高額合算.get負担額().toString()));
            entity.setShikyugakuMeisai_ambunRitsu(new RString(高額合算.get按分率().toString()));
            entity.setShikyugakuMeisai_under70_Shikyugaku(new RString(高額合算.get支給額_70歳未満().toString()));
            entity.setShikyugakuMeisai_shikyugaku(new RString(高額合算.get支給額().toString()));
            if (parameter.get受取年月() != null) {
                entity.setShikyugakuMeisai_uketoriYM(parameter.get受取年月());
            }
            entity.setShikyugakuMeisai_dataKubun(TWO);
            entity.setState(EntityDataState.Added);
            tempDbWriter.insert(entity);
        }
        for (HihokenshaFutangaku 高額合算 : 転入前事業高額合算List) {
            if (高額合算.get証明書() == null || is登録済(高額合算.get明細被保険者番号(), 支給額計算一時_区分1.getTaishoNendo(),
                    高額合算.get明細保険者番号(), 支給額計算一時_区分1.getShikyuShinseishoSeiriNo())) {
                continue;
            }
            meisaiNo = Decimal.ONE.add(meisaiNo);
            ShikyugakuUpdateTempEntity entity = new ShikyugakuUpdateTempEntity();
            entity.setHihokenshaNo(高額合算.get明細被保険者番号());
            entity.setTaishoNendo(支給額計算一時_区分1.getTaishoNendo());
            entity.setShoKisaiHokenshaNo(高額合算.get明細保険者番号());
            entity.setShikyuShinseishoSeiriNo(支給額計算一時_区分1.getShikyuShinseishoSeiriNo());
            entity.setKubun(区分4);
            entity.setMeisaiNo(new RString(meisaiNo.toString()));
            entity.setMeisaiHihokenshaNo(高額合算.get証明書().getZenFutangaku_hihokenshaNo());

            entity.setShikyugakuMeisai_hihokenshaNo(高額合算.get明細被保険者番号());
            entity.setShikyugakuMeisai_taishoNendo(支給額計算一時_区分1.getTaishoNendo());
            entity.setShikyugakuMeisai_shoKisaiHokenshaNo(高額合算.get明細保険者番号());
            entity.setShikyugakuMeisai_shikyuShinseishoSeiriNo(支給額計算一時_区分1.getShikyugaku_shikyuShinseishoSeiriNo());

            entity.setShikyugakuMeisai_meisanNo(new RString(meisaiNo.toString()));
            entity.setShikyugakuMeisai_rirekiNo(1);
            entity.setShikyugakuMeisai_hokenSeidoCode(保険制度コード_3);
            entity.setShikyugakuMeisai_uchiwakeHokenshaNo(高額合算.get証明書().getZenFutangaku_tennyumaeHokenshaMei());
            entity.setShikyugakuMeisai_hiHokenshaShoNo(高額合算.get証明書().getZenFutangaku_hihokenshaNo().getColumnValue());
            entity.setShikyugakuMeisai_uchiwakeHokenshaMei(高額合算.get証明書().getZenFutangaku_tennyumaeHokenshaMei());
            entity.setShikyugakuMeisai_jikoFutanSeiriNo(高額合算.get証明書().getZenFutangaku_jikoFutanSeiriNo());
            entity.setShikyugakuMeisai_over70_Futangaku(new RString(高額合算.get負担額_70歳以上().toString()));
            entity.setShikyugakuMeisai_over70_AmbunRitsu(new RString(高額合算.get按分率_70歳以上().toString()));
            entity.setShikyugakuMeisai_over70_Shikyugaku(new RString(高額合算.get支給額_70歳以上().toString()));
            entity.setShikyugakuMeisai_under70_Futangaku(new RString(高額合算.get負担額_70歳未満().toString()));
            entity.setShikyugakuMeisai_futangaku(new RString(高額合算.get負担額().toString()));
            entity.setShikyugakuMeisai_ambunRitsu(new RString(高額合算.get按分率().toString()));
            entity.setShikyugakuMeisai_under70_Shikyugaku(new RString(高額合算.get支給額_70歳未満().toString()));
            entity.setShikyugakuMeisai_shikyugaku(new RString(高額合算.get支給額().toString()));
            if (parameter.get受取年月() != null) {
                entity.setShikyugakuMeisai_uketoriYM(parameter.get受取年月());
            }
            entity.setShikyugakuMeisai_dataKubun(TWO);
            entity.setState(EntityDataState.Added);
            tempDbWriter.insert(entity);
        }
    }

    private boolean is登録済(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号, RString 支給申請書整理番号) {
        for (ShikyugakuCalcKey key : 登録済キー) {
            if (key.get対象年度().equals(対象年度) && key.get支給申請書整理番号().equals(支給申請書整理番号)
                    && key.get被保険者番号().equals(被保険者番号) && key.get証記載保険者番号().equals(保険者番号)) {
                return true;
            }
        }
        ShikyugakuCalcKey key = new ShikyugakuCalcKey();
        key.set被保険者番号(被保険者番号);
        key.set対象年度(対象年度);
        key.set証記載保険者番号(保険者番号);
        key.set支給申請書整理番号(支給申請書整理番号);
        登録済キー.add(key);
        return false;
    }

    private void update更新用一時Entity(ShikyugakuUpdateTempEntity entity, Decimal 負担額合計) {
        if (計算用明細データ.get被保険者番号().equals(entity.getHihokenshaNo())
                && 計算用明細データ.get対象年度().equals(entity.getTaishoNendo())
                && 計算用明細データ.get証記載保険者番号().equals(entity.getShoKisaiHokenshaNo())
                && 計算用明細データ.get支給申請書整理番号().equals(entity.getShikyuShinseishoSeiriNo())) {
            entity.setKettei_hihokenshaNo(entity.getHihokenshaNo());
            entity.setKettei_taishoNendo(entity.getTaishoNendo());
            entity.setKettei_hokenshaNo(entity.getShoKisaiHokenshaNo());
            entity.setKettei_shikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
            entity.setKettei_rirekiNo(1);
            entity.setKettei_jikoFutanSeiriNo(支給額計算一時_自己負担額.getFutangaku_jikoFutanSeiriNo());
            entity.setKettei_hokenSeidoCode(保険制度コード_3);
            entity.setKettei_kokuho_HihokenshaShoKigo(支給額計算一時_自己負担額.getFutangaku_kokuho_HihokenshaShoKigo());
            entity.setKettei_taishoKeisanKaishiYMD(支給額計算一時_自己負担額.getFutangaku_taishoKeisanKaishiYMD());
            entity.setKettei_taishoKeisanShuryoYMD(支給額計算一時_自己負担額.getFutangaku_taishoKeisanShuryoYMD());
            entity.setKettei_shinseiYMD(支給額計算一時_自己負担額.getFutangaku_shinseiYMD());
            entity.setKettei_ketteiYMD(parameter.get決定年月日());
            entity.setKettei_jikoFutanSogaku(負担額合計);
            entity.setKettei_kyufuShurui(事業分高額合算支給額計算_給付の種類);
            set支給情報(entity);
            if (TWO.equals(entity.getKettei_shikyuKubun())) {
                entity.setKettei_fushikyuRiyu(事業分高額合算支給額計算_不支給理由);
            }
        }
    }

    private void set支給情報(ShikyugakuUpdateTempEntity entity) {
        if (entity.getShikyugaku_shikyugakuGokei() == null || Decimal.ZERO.equals(entity.getShikyugaku_shikyugakuGokei())) {
            entity.setSaiShikyuKubun(TWO);
        } else if (rStringToDecimal(抽出対象支給基準額).compareTo(entity.getShikyugaku_shikyugakuGokei()) <= 0) {
            entity.setSaiShikyuKubun(ONE);
        } else {
            entity.setSaiShikyuKubun(THREE);
        }
        if (rStringToDecimal(抽出対象支給基準額).compareTo(entity.getShikyugaku_shikyugakuGokei()) >= 0) {
            entity.setKettei_shikyuKubun(TWO);
            entity.setKettei_shikyugaku(rStringToDecimal(抽出対象支給基準額));
        } else {
            entity.setKettei_shikyuKubun(ONE);
            entity.setKettei_shikyugaku(entity.getShikyugaku_shikyugakuGokei());
        }
    }

    private Decimal divideDecimal(Decimal data1, Decimal data2) {
        if (data1 == null || Decimal.ZERO.equals(data1) || data2 == null || Decimal.ZERO.equals(data2)) {
            return Decimal.ZERO;
        }
        return data1.divide(data2).roundHalfUpTo(2);
    }

    private RString get被保険者氏名(AtenaMeisho hihokenshaShimei) {
        return hihokenshaShimei == null ? RString.EMPTY : hihokenshaShimei.getColumnValue();
    }

    private HihokenshaFutangaku get0件のデータ() {
        HihokenshaFutangaku 明細 = new HihokenshaFutangaku();
        明細.set明細被保険者番号(HihokenshaNo.EMPTY);
        明細.set明細保険者番号(HokenshaNo.EMPTY);
        明細.set明細番号(ZERO);
        明細.set負担額_70歳以上(Decimal.ZERO);
        明細.set按分率_70歳以上(Decimal.ONE);
        明細.set支給額_70歳以上(Decimal.ZERO);
        明細.set負担額_70歳未満(Decimal.ZERO);
        明細.set負担額(Decimal.ZERO);
        明細.set按分率(Decimal.ONE);
        明細.set支給額_70歳未満(Decimal.ZERO);
        明細.set支給額(Decimal.ZERO);
        return 明細;
    }

    private Decimal addDecimal(Decimal data1, Decimal data2) {
        Decimal data1Tmp = data1 == null ? Decimal.ZERO : data1;
        Decimal data2Tmp = data2 == null ? Decimal.ZERO : data2;
        return data1Tmp.add(data2Tmp);
    }

    private Decimal minusDecimal(Decimal data1, Decimal data2) {
        Decimal data1Tmp = data1 == null ? Decimal.ZERO : data1;
        Decimal data2Tmp = data2 == null ? Decimal.ZERO : data2;
        return data1Tmp.subtract(data2Tmp);
    }

    private Decimal rStringToDecimal(RString data) {
        if (RString.isNullOrEmpty(data)) {
            return Decimal.ZERO;
        }
        return new Decimal(data.toString());
    }
}
