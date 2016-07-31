/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.taino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.taino.KyufugakuGengakuInfo;
import jp.co.ndensan.reams.db.dbd.business.core.taino.KyufugakuGengakuMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiKikan;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResult;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoKiSummary;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoKiSummaryBuilder;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.taino.TainoJokyoMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.taino.TainoJohoRelateEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.taino.ITainoJokyoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.DateDuration;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 滞納状況取得のビジネスクラスです。
 *
 * @reamsid_L DBD-3620-060 liangbc
 */
public class TainoJokyoResearcher {

    private static final int 十年前 = 10;
    private static final int 小数点以下3桁 = 3;
    private static final int 一年の月数 = 12;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public TainoJokyoResearcher() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TainoJokyoResearcher}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link TainoJokyoResearcher}のインスタンス
     */
    public static TainoJokyoResearcher createInstance() {
        return InstanceProvider.create(TainoJokyoResearcher.class);
    }

    /**
     * 指定の被保険者について、指定の基準日時点の滞納の状況を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準日 基準日
     * @return 滞納の状況
     */
    public TainoHanteiResult research滞納状況(HihokenshaNo 被保険者番号, FlexibleDate 基準日) {
        List<TainoJohoRelateEntity> 滞納情報リスト = get滞納情報リスト(被保険者番号, 基準日);
        List<TainoKiSummary> tainoKiSummarys = getTainoKiSummaryList(滞納情報リスト, 基準日);
        return create給付額減額情報(tainoKiSummarys, 基準日);
    }

    /**
     * 給付額減額に関する情報を計算し、作成します。
     *
     * @param 滞納情報List 滞納情報List
     * @param 基準日 基準日
     * @return 給付額減額情報
     */
    public TainoHanteiResult create給付額減額情報(List<TainoKiSummary> 滞納情報List, FlexibleDate 基準日) {
        if (滞納情報List.isEmpty()) {
            return new TainoHanteiResult(基準日, 基準日, null, null, 滞納情報List, true, null);
        }
        Decimal 徴収権消滅期間合計 = Decimal.ZERO;
        Decimal 納付済期間合計 = Decimal.ZERO;
        FlexibleDate 最古滞納納期限 = FlexibleDate.EMPTY;
        DateDuration 滞納期間 = null;
        boolean is警告対象 = false;
        Decimal 給付額減額期間 = Decimal.ZERO;
        List<TainoKiSummary> new滞納情報List = 滞納情報を整理(滞納情報List, 基準日);
        Map<FlexibleYear, KyufugakuGengakuMeisai> 給付額減額明細Map = new LinkedHashMap<>();
        FlexibleYear 該当調定年度 = FlexibleYear.EMPTY;
        if (!new滞納情報List.isEmpty()) {
            該当調定年度 = new滞納情報List.get(0).get調定年度();
        }
        Decimal 調定額合計 = Decimal.ZERO;
        Decimal 滞納額合計 = Decimal.ZERO;
        Decimal 収入額合計 = Decimal.ZERO;
        for (TainoKiSummary 滞納情報 : new滞納情報List) {
            if (該当調定年度.equals(滞納情報.get調定年度())) {
                調定額合計 = 調定額合計.add(滞納情報.get調定額());
                滞納額合計 = 滞納額合計.add(滞納情報.get滞納額());
                収入額合計 = 収入額合計.add(滞納情報.get収入額());
            } else {
                if (!Decimal.ZERO.equals(調定額合計)) {
                    徴収権消滅期間合計 = 徴収権消滅期間合計.add(滞納額合計.divide(調定額合計));
                    納付済期間合計 = 納付済期間合計.add(収入額合計.divide(調定額合計));
                }
                KyufugakuGengakuMeisai 給付額減額明細entity = new KyufugakuGengakuMeisai(該当調定年度, 滞納額合計, 調定額合計, 収入額合計);
                給付額減額明細Map.put(該当調定年度, 給付額減額明細entity);
                調定額合計 = 滞納情報.get調定額();
                滞納額合計 = 滞納情報.get滞納額();
                収入額合計 = 滞納情報.get収入額();
                該当調定年度 = 滞納情報.get調定年度();
            }
            if (JikoKubun.時効未到来.equals(滞納情報.get時効区分()) && 滞納情報.get滞納額().intValue() > 0) {
                FlexibleDate 納期限 = new FlexibleDate(滞納情報.get納期限().toString());
                if (最古滞納納期限.isEmpty()) {
                    最古滞納納期限 = 納期限;
                } else if (納期限.isBefore(最古滞納納期限)) {
                    最古滞納納期限 = 納期限;
                }
            }
        }
        if (!new滞納情報List.isEmpty()) {
            if (!Decimal.ZERO.equals(調定額合計)) {
                徴収権消滅期間合計 = 徴収権消滅期間合計.add(滞納額合計.divide(調定額合計));
                納付済期間合計 = 納付済期間合計.add(収入額合計.divide(調定額合計));
            }
            KyufugakuGengakuMeisai 給付額減額明細entity = new KyufugakuGengakuMeisai(該当調定年度, 滞納額合計, 調定額合計, 収入額合計);
            給付額減額明細Map.put(該当調定年度, 給付額減額明細entity);
        }
        if (!Decimal.ZERO.equals(徴収権消滅期間合計.add(納付済期間合計))) {
            給付額減額期間 = 徴収権消滅期間合計.multiply(徴収権消滅期間合計).divide(徴収権消滅期間合計.add(納付済期間合計)).divide(2).multiply(一年の月数);
        }

        KyufugakuGengakuInfo 給付額減額情報 = new KyufugakuGengakuInfo(
                徴収権消滅期間合計.roundDownTo(小数点以下3桁), 納付済期間合計.roundDownTo(小数点以下3桁), 給付額減額期間.intValue(), 給付額減額明細Map);

        if (!最古滞納納期限.isEmpty()) {
            滞納期間 = 基準日.getBetweenDuration(最古滞納納期限);
        }

        TainoHanteiKikan 滞納判定期間 = get滞納判定期間();

        if (滞納期間 != null) {
            is警告対象 = 滞納判定期間.get合計月数() <= (滞納期間.getYear() * 一年の月数 + 滞納期間.getMonth());
        }

        TainoHanteiResult 滞納判定結果 = new TainoHanteiResult(
                基準日, 最古滞納納期限, 滞納期間, 給付額減額情報, Collections.unmodifiableList(new滞納情報List), is警告対象, 滞納判定期間);
        return 滞納判定結果;
    }

    private List<TainoJohoRelateEntity> get滞納情報リスト(HihokenshaNo 被保険者番号, FlexibleDate 基準日) {
        FlexibleYear 賦課年度 = 基準日.getYear();
        TainoJokyoMapperParameter parameter
                = TainoJokyoMapperParameter.createParameter(new RDate(基準日.toString()), 被保険者番号, 賦課年度);
        return mapperProvider.create(ITainoJokyoMapper.class).selectTainoJoho(parameter);

    }

    private List<TainoKiSummary> getTainoKiSummaryList(List<TainoJohoRelateEntity> 滞納情報リスト, FlexibleDate 基準日) {
        List<TainoKiSummary> tainoKiSummarys = new ArrayList<>();
        for (TainoJohoRelateEntity relateEntity : 滞納情報リスト) {
            tainoKiSummarys.add(TainoKiSummaryBuilder.createTainoKiSummary(relateEntity, 基準日));
        }
        return tainoKiSummarys;
    }

    private List<TainoKiSummary> 滞納情報を整理(List<TainoKiSummary> 滞納情報List, FlexibleDate 基準日) {
        List<TainoKiSummary> new滞納情報List = new ArrayList<>();
        RDate r基準日 = new RDate(基準日.toString());
        for (TainoKiSummary 滞納情報 : 滞納情報List) {
            if (r基準日.minusYear(十年前).isBeforeOrEquals(滞納情報.get納期限()) && 滞納情報.get納期限().isBeforeOrEquals(r基準日)) {
                new滞納情報List.add(滞納情報);
            }
        }
        Collections.sort(new滞納情報List, new Comparator<TainoKiSummary>() {
            @Override
            public int compare(TainoKiSummary o1, TainoKiSummary o2) {
                return o2.get調定年度().compareTo(o1.get調定年度());
            }
        });
        return new滞納情報List;
    }

    private TainoHanteiKikan get滞納判定期間() {
        int 合計月数;
        try {
            合計月数 = Integer.valueOf(
                    BusinessConfig.get(ConfigNameDBD.支払方法変更_支払方法変更期限, RDate.getNowDate(), SubGyomuCode.DBD介護受給).toString());
        } catch (NullPointerException | NumberFormatException e) {
            合計月数 = 0;
        }
        int 年数 = 合計月数 / 一年の月数;
        int 月数Without年数 = 合計月数 % 一年の月数;
        RStringBuilder 出力文字列 = new RStringBuilder();
        if (年数 > 0) {
            出力文字列 = 出力文字列.append(年数).append("年");
        }
        if (月数Without年数 > 0) {
            出力文字列 = 出力文字列.append(月数Without年数).append("ヶ月");
        }
        if (!出力文字列.toRString().isEmpty()) {
            出力文字列 = 出力文字列.append("以上");
        }
        return new TainoHanteiKikan(合計月数, 年数, 月数Without年数, 出力文字列.toRString());
    }
}
