/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jigosakuseimeisaitouroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.GokeiKeisan;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KubunGendo;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.ServiceTypeDetails;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.ServiceTypeTotal;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.KubunGendoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.KyufuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.ServiceRiyohyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.ServiceTypeTotalEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jigosakuseimeisaitouroku.IJigoSakuseiMeisaiTourokuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * ビジネス設計_DBC0120031_サービス利用票情報
 *
 * @reamsid_L DBC-1930-060 xupeng
 */
public class JigoSakuseiMeisaiTouroku {

    private final MapperProvider mapperProvider;
    private final DbT4001JukyushaDaichoDac dac;
    private static final Decimal 率 = new Decimal("100");
    private static final RString 限度対象外フラグ = new RString("0");
    private static final RString 設定してないR = new RString("ー");
    private static final RString 事業者 = new RString("合計");
    private static final RString 事業者コード = new RString("*******");
    private static final RString 総合事業 = new RString("2");
    private static final RString 居宅 = new RString("1");
    private static final RString 日_1 = new RString("01");
    private static final RString KEY_開始利用年月 = new RString("開始利用年月");
    private static final RString KEY_終了利用年月 = new RString("終了利用年月");
    private static final RString KEY_利用年月 = new RString("利用年月");
    private static final RString KEY_被保険者番号 = new RString("被保険者番号");
    private static final RString KEY_対象年月 = new RString("対象年月");
    private static final RString KEY_履歴番号 = new RString("履歴番号");

    /**
     * コンストラクタです。
     */
    public JigoSakuseiMeisaiTouroku() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    JigoSakuseiMeisaiTouroku(MapperProvider mapperProvider,
            DbT4001JukyushaDaichoDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JigoSakuseiMeisaiTouroku}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JigoSakuseiMeisaiTouroku}のインスタンス
     */
    public static JigoSakuseiMeisaiTouroku createInstance() {
        return InstanceProvider.create(JigoSakuseiMeisaiTouroku.class);
    }

    /**
     * 合計計算処理
     *
     * @param 利用者負担額 Decimal
     * @param 種類限度超過単位 Decimal
     * @param 種類限度内単位 Decimal
     * @param 単位数単価 Decimal
     * @param 区分限度超過単位 Decimal
     * @param 区分限度内単位 Decimal
     * @param 給付率 HokenKyufuRitsu
     * @param サービス単位 Decimal
     * @return GokeiKeisan
     */
    public GokeiKeisan getGokeiKeisan(Decimal 利用者負担額,
            Decimal 種類限度超過単位,
            Decimal 種類限度内単位,
            Decimal 単位数単価,
            Decimal 区分限度超過単位,
            Decimal 区分限度内単位,
            HokenKyufuRitsu 給付率,
            Decimal サービス単位) {
        GokeiKeisan 合計計算情報 = new GokeiKeisan();
        if (Decimal.ZERO.equals(区分限度内単位)) {
            Decimal 費用総額 = サービス単位.multiply(単位数単価);
            合計計算情報.set費用総額(toDecimal(費用総額));
        } else {
            Decimal 費用総額 = 区分限度内単位.multiply(単位数単価);
            合計計算情報.set費用総額(toDecimal(費用総額));
        }

        if (利用者負担額 != null) {
            合計計算情報.set保険対象利用者負担額(利用者負担額);
            合計計算情報.set保険給付額(合計計算情報.get費用総額().subtract(合計計算情報.get保険対象利用者負担額()));
        } else {
            if (Decimal.ZERO.equals(給付率)) {
                合計計算情報.set保険給付額(合計計算情報.get費用総額());
            } else {
                Decimal 保険給付額 = 合計計算情報.get費用総額().divide(率).multiply(給付率.getColumnValue());
                合計計算情報.set保険給付額(toDecimal(保険給付額));
            }
            合計計算情報.set保険対象利用者負担額(合計計算情報.get費用総額().subtract(合計計算情報.get保険給付額()));
        }

        Decimal 全額利用者負担額 = (種類限度超過単位.add(区分限度超過単位)).multiply(単位数単価);
        合計計算情報.set全額利用者負担額(toDecimal(全額利用者負担額));

        return 合計計算情報;
    }

    /**
     * 明細・合計一覧Grid整理処理
     *
     * @param 明細合計リスト List<KyufuJikoSakuseiResult>
     * @return KyufuJikoSakuseiResult
     */
    public KyufuJikoSakuseiResult getMeisaiGoukeiListGridAdjust(List<KyufuJikoSakuseiResult> 明細合計リスト) {
        Decimal サービス単位 = Decimal.ZERO;
        Decimal 種類限度内単位 = Decimal.ZERO;
        Decimal 種類限度超過単位 = Decimal.ZERO;
        Decimal 区分限度内単位 = Decimal.ZERO;
        Decimal 区分限度超過単位 = Decimal.ZERO;
        Decimal 費用総額 = Decimal.ZERO;
        Decimal 保険給付額 = Decimal.ZERO;
        Decimal 保険対象利用者負担額 = Decimal.ZERO;
        Decimal 全額利用者負担額 = Decimal.ZERO;

        for (KyufuJikoSakuseiResult result : 明細合計リスト) {
            KyufuJikoSakuseiEntity entity = result.getEntity();
            if (entity.is合計フラグ() && 限度対象外フラグ.equals(entity.get限度額対象外フラグ())) {
                サービス単位 = entity.getサービス単位().add(サービス単位);
                種類限度内単位 = nullToZero(entity.get種類限度内単位()).add(種類限度内単位);
                種類限度超過単位 = nullToZero(entity.get種類限度超過単位()).add(種類限度超過単位);
                区分限度内単位 = nullToZero(entity.get区分限度内単位()).add(区分限度内単位);
                区分限度超過単位 = nullToZero(entity.get区分限度超過単位()).add(区分限度超過単位);
            }
            費用総額 = nullToZero(entity.get費用総額()).add(費用総額);
            保険給付額 = nullToZero(entity.get保険給付額()).add(保険給付額);
            保険対象利用者負担額 = nullToZero(entity.get保険対象利用者負担額()).add(保険対象利用者負担額);
            全額利用者負担額 = nullToZero(entity.get全額利用者負担額()).add(全額利用者負担額);
        }
        KyufuJikoSakuseiEntity resultEntity = new KyufuJikoSakuseiEntity();
        resultEntity.setサービス単位(サービス単位);
        resultEntity.set種類限度内単位(種類限度内単位);
        resultEntity.set種類限度超過単位(種類限度超過単位);
        resultEntity.set区分限度内単位(区分限度内単位);
        resultEntity.set区分限度超過単位(区分限度超過単位);
        resultEntity.set費用総額(費用総額);
        resultEntity.set保険給付額(保険給付額);
        resultEntity.set保険対象利用者負担額(保険対象利用者負担額);
        resultEntity.set全額利用者負担額(全額利用者負担額);
        // TODO QAのNo.975 (Redmine#92977)
        resultEntity.set事業者(事業者);
        resultEntity.set事業者コード(new JigyoshaNo(事業者コード));
        resultEntity.setサービス(設定してないR);
        resultEntity.set単位(Decimal.ZERO);
        resultEntity.set割引適用後率(new HokenKyufuRitsu(Decimal.ZERO));
        resultEntity.set割引適用後単位(Decimal.ZERO);
        resultEntity.set回数(Decimal.ZERO);
        resultEntity.set単位数単価(Decimal.ZERO);
        resultEntity.set給付率(new HokenKyufuRitsu(Decimal.ZERO));
        resultEntity.set給付計画単位数(Decimal.ZERO);
        resultEntity.setサービス種類コード(new ServiceShuruiCode(設定してないR));
        resultEntity.setサービス項目コード(new ServiceKomokuCode(設定してないR));
        resultEntity.setステータス(設定してないR);
        resultEntity.set合計フラグ(false);
        resultEntity.set限度額対象外フラグ(設定してないR);

        KyufuJikoSakuseiResult kyufuJikoSakuseiResult = new KyufuJikoSakuseiResult();
        kyufuJikoSakuseiResult.setEntity(resultEntity);
        return kyufuJikoSakuseiResult;

    }

    private Decimal nullToZero(Decimal decimal) {
        return decimal == null ? Decimal.ZERO : decimal;
    }

    /**
     * サービス種類限度額統計処理
     *
     * @param 利用年月 FlexibleYearMonth
     * @param サービス種類詳細List List<ServiceTypeDetails>
     * @return List<ServiceTypeTotal>
     */
    public List<ServiceTypeTotal> getServiceTypeGendo(FlexibleYearMonth 利用年月, List<ServiceTypeDetails> サービス種類詳細List) {
        List<ServiceTypeTotal> sList1 = new ArrayList<>();
        List<ServiceTypeTotal> sList2 = new ArrayList<>();
        IJigoSakuseiMeisaiTourokuMapper mapper = mapperProvider.create(IJigoSakuseiMeisaiTourokuMapper.class);
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_利用年月.toString(), 利用年月);
        List<ServiceTypeTotalEntity> entityList = mapper.getサービス種類支給額(param);

        for (ServiceTypeTotalEntity entity : entityList) {
            ServiceTypeTotal stotal = new ServiceTypeTotal();
            stotal.setサービス種類(entity.getサービス種類略称());
            stotal.setサービス種類コード(entity.getサービス種類コード());
            stotal.set合計単位数(null);
            stotal.set限度超過単位数(null);
            stotal.set限度額(entity.get支給限度単位数());
            sList1.add(stotal);
        }

        Decimal 合計単位数 = Decimal.ZERO;
        for (ServiceTypeDetails details : サービス種類詳細List) {
            if (限度対象外フラグ.equals(details.get限度額対象外フラグ())) {
                RString 種類コード = details.getサービス種類コード().getColumnValue();
                for (ServiceTypeTotal total : sList1) {
                    if (種類コード.equals(total.getサービス種類コード().getColumnValue())) {
                        合計単位数 = 合計単位数.add(details.getサービス単位());
                    }
                }
            }
        }

        for (ServiceTypeTotal totals : sList1) {
            Decimal 限度額 = nullToZero(totals.get限度額());
            if (合計単位数.compareTo(限度額) > 0) {
                totals.set限度超過単位数(合計単位数.subtract(限度額));
            }
            totals.set合計単位数(合計単位数);
            sList2.add(totals);
        }

        return sList2;
    }

    /**
     * サービス利用票取得処理
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @param 履歴番号 RString
     * @param 利用年月 FlexibleYearMonth
     * @return List<KyufuJikoSakuseiResult>
     */
    public List<KyufuJikoSakuseiResult> getServiceRiyouHyo(HihokenshaNo 被保険者番号, FlexibleYearMonth 対象年月,
            int 履歴番号, FlexibleYearMonth 利用年月) {
        IJigoSakuseiMeisaiTourokuMapper mapper = mapperProvider.create(IJigoSakuseiMeisaiTourokuMapper.class);
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_被保険者番号.toString(), 被保険者番号);
        param.put(KEY_対象年月.toString(), 対象年月);
        param.put(KEY_履歴番号.toString(), 履歴番号);
        param.put(KEY_利用年月.toString(), 利用年月);
        List<ServiceRiyohyoEntity> entityList = mapper.getサービス利用票データ(param);

        if (entityList.isEmpty()) {
            return Collections.emptyList();
        }
        List<KyufuJikoSakuseiEntity> 給付計画自己作成EntityList = new ArrayList<>();
        for (ServiceRiyohyoEntity entity : entityList) {
            KyufuJikoSakuseiEntity 給付計画自己作成Entity = new KyufuJikoSakuseiEntity();
            給付計画自己作成Entity.set事業者(entity.get事業者());
            給付計画自己作成Entity.setサービス(entity.getサービス());
            給付計画自己作成Entity.set単位(entity.get単位());
            給付計画自己作成Entity.set割引適用後率(entity.get割引適用後率());
            給付計画自己作成Entity.set割引適用後単位(entity.get割引適用後単位());
            給付計画自己作成Entity.set回数(entity.get回数());

            // TODO
//            if (entity.getサービス項目コード().isEmpty() || entity.getサービス項目コード() == null) {
            給付計画自己作成Entity.setサービス単位(entity.getサービス単位());

            給付計画自己作成Entity.set種類限度超過単位(entity.get種類限度超過単位());
            給付計画自己作成Entity.set種類限度内単位(entity.get種類限度内単位());
            給付計画自己作成Entity.set単位数単価(entity.get単位数単価());
            給付計画自己作成Entity.set区分限度超過単位(entity.get区分限度超過単位());
            給付計画自己作成Entity.set区分限度内単位(entity.get区分限度内単位());
            給付計画自己作成Entity.set給付率(entity.get給付率());
            給付計画自己作成Entity.set事業者コード(entity.get事業者コード());
            給付計画自己作成Entity.setサービス種類コード(entity.getサービス種類コード());
            給付計画自己作成Entity.setサービス項目コード(entity.getサービス項目コード());
            給付計画自己作成Entity.set合計フラグ(entity.is合計フラグ());
            給付計画自己作成Entity.set限度額対象外フラグ(entity.get限度額対象外フラグ());
            給付計画自己作成Entity.set定額利用者負担単価金額(entity.get定額利用者負担単価金額());

            給付計画自己作成EntityList.add(給付計画自己作成Entity);
        }

        List<KyufuJikoSakuseiResult> 明細合計リスト = new ArrayList<>();
        for (KyufuJikoSakuseiEntity entity : 給付計画自己作成EntityList) {
            if (entity.is合計フラグ()) {
                Decimal 利用者負担額;
                if (ServiceCategoryShurui.総用貸与.getコード().equals(entity.getサービス種類コード().getColumnValue())) {
                    利用者負担額 = entity.get定額利用者負担単価金額();
                } else {
                    利用者負担額 = entity.get定額利用者負担単価金額().multiply(entity.get回数());
                }
                GokeiKeisan gokeiKeisanResult = getGokeiKeisan(利用者負担額, entity.get種類限度超過単位(),
                        entity.get種類限度内単位(), entity.get単位数単価(), entity.get区分限度超過単位(),
                        entity.get区分限度内単位(), entity.get給付率(), entity.getサービス単位());
                entity.set費用総額(gokeiKeisanResult.get費用総額());
                entity.set保険給付額(gokeiKeisanResult.get保険給付額());
                entity.set保険対象利用者負担額(gokeiKeisanResult.get保険対象利用者負担額());
                entity.set全額利用者負担額(gokeiKeisanResult.get全額利用者負担額());
            }
            KyufuJikoSakuseiResult result = new KyufuJikoSakuseiResult();
            result.setEntity(entity);
            明細合計リスト.add(result);
        }

        KyufuJikoSakuseiResult kyufuJikoSakuseiResult = getMeisaiGoukeiListGridAdjust(明細合計リスト);

        List<KyufuJikoSakuseiResult> resultList = new ArrayList<>();
        resultList.add(kyufuJikoSakuseiResult);
        return resultList;
    }

    /**
     * 区分限度額統計処理
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 居宅総合事業区分 RString
     * @param 利用年月 FlexibleYearMonth
     * @return KubunGendo
     */
    public KubunGendo getKubunGendo(HihokenshaNo 被保険者番号, RString 居宅総合事業区分, FlexibleYearMonth 利用年月) {
        KubunGendo gendo = new KubunGendo();
        FlexibleDate 開始利用年月 = new FlexibleDate(利用年月.toString().concat(new RString(利用年月.getLastDay()).toString()));
        FlexibleDate 終了利用年月 = new FlexibleDate(利用年月.toString().concat(日_1.toString()));
        if (総合事業.equals(居宅総合事業区分)) {
            IJigoSakuseiMeisaiTourokuMapper mapper = mapperProvider.create(IJigoSakuseiMeisaiTourokuMapper.class);
            Map<String, Object> param = new HashMap<>();
            param.put(KEY_開始利用年月.toString(), 開始利用年月);
            param.put(KEY_終了利用年月.toString(), 終了利用年月);
            param.put(KEY_利用年月.toString(), 利用年月);
            param.put(KEY_被保険者番号.toString(), 被保険者番号);
            KubunGendoEntity entity = mapper.get区分限度額統計処理(param);
            if (entity != null) {
                gendo.set区分支給限度額(entity.get支給限度単位数());
                gendo.set管理期間開始日(entity.get適用開始年月日());
                gendo.set管理期間終了日(entity.get適用終了年月日());
            }
        }
        if (居宅.equals(居宅総合事業区分)) {
            DbT4001JukyushaDaichoEntity entity = dac.select居宅総合事業区分(被保険者番号, 開始利用年月, 終了利用年月);
            if (entity != null) {
                gendo.set区分支給限度額(entity.getShikyuGendoTanisu());
                gendo.set管理期間開始日(entity.getNinteiYukoKikanKaishiYMD());
                gendo.set管理期間終了日(entity.getNinteiYukoKikanShuryoYMD());
            }
        }
        return gendo;
    }

    private Decimal toDecimal(Decimal decimal) {
        if (decimal == null) {
            return null;
        }
        return new Decimal(DecimalFormatter.toコンマ区切りRString(decimal, 0).toString());
    }
}
