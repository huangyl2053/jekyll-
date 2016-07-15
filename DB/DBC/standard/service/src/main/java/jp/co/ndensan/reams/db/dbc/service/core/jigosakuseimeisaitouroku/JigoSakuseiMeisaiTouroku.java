/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jigosakuseimeisaitouroku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.GokeiKeisan;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KubunGendo;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.ServiceTypeTotal;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.KubunGendoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.KyufuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.ServiceTypeDetails;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.ServiceTypeTotalEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jigosakuseimeisaitouroku.IJigoSakuseiMeisaiTourokuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
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
    private static final Decimal 区分限度単位_0 = new Decimal("0");
    private static final Decimal 給付率_0 = new Decimal("0");
    private static final Decimal 率 = new Decimal("100");
    private static final RString 限度対象外フラグ = new RString("0");
    private static final Decimal 設定してない = Decimal.ZERO;
    private static final RString 設定してないR = new RString("ー");
    private static final RString 事業者 = new RString("合計");
    private static final RString 事業者コード = new RString("ALL*");
    private static final RString サービス種類 = new RString("88");
    private static final RString 総合事業 = new RString("総合事業");
    private static final RString 居宅 = new RString("居宅");
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
     * @param result GokeiKeisan
     * @return GokeiKeisan
     */
    public GokeiKeisan getGokeiKeisan(GokeiKeisan result) {
        GokeiKeisan gokeiKeisan = new GokeiKeisan();
        if (区分限度単位_0.compareTo(result.get区分限度内単位()) == 0) {
            Decimal 費用総額 = result.getサービス単位().multiply(result.get単位数単価());
            gokeiKeisan.set費用総額(toDecimal(費用総額));
        } else {
            Decimal 費用総額 = result.get区分限度内単位().multiply(result.get単位数単価());
            gokeiKeisan.set費用総額(toDecimal(費用総額));
        }

        if (result.get利用者負担額() != null) {
            gokeiKeisan.set保険対象利用者負担額(result.get利用者負担額());
            gokeiKeisan.set保険給付額(gokeiKeisan.get費用総額().subtract(gokeiKeisan.get保険対象利用者負担額()));
        } else {
            if (給付率_0.compareTo(result.get給付率()) == 0) {
                gokeiKeisan.set保険給付額(gokeiKeisan.get費用総額());
            } else {
                Decimal 保険給付額 = gokeiKeisan.get費用総額().divide(率).multiply(result.get給付率());
                gokeiKeisan.set保険給付額(toDecimal(保険給付額));
            }
            gokeiKeisan.set保険対象利用者負担額(gokeiKeisan.get費用総額().subtract(gokeiKeisan.get保険給付額()));
        }

        Decimal 全額利用者負担額 = result.get種類限度超過単位().add(result.get区分限度超過単位()).multiply(result.get単位数単価());
        gokeiKeisan.set全額利用者負担額(toDecimal(全額利用者負担額));

        return gokeiKeisan;
    }

    /**
     * 明細・合計一覧Grid整理処理
     *
     * @param list List<KyufuJikoSakuseiEntity>
     * @return KyufuJikoSakuseiResult
     */
    public KyufuJikoSakuseiResult getMeisaiGoukeiListGridAdjust(List<KyufuJikoSakuseiEntity> list) {
        KyufuJikoSakuseiResult result = new KyufuJikoSakuseiResult();
        KyufuJikoSakuseiEntity resultEntity = new KyufuJikoSakuseiEntity();
        Decimal サービス単位 = Decimal.ZERO;
        Decimal 種類限度内単位 = Decimal.ZERO;
        Decimal 種類限度超過単位 = Decimal.ZERO;
        Decimal 区分限度内単位 = Decimal.ZERO;
        Decimal 区分限度超過単位 = Decimal.ZERO;
        Decimal 費用総額 = Decimal.ZERO;
        Decimal 保険給付額 = Decimal.ZERO;
        Decimal 保険対象利用者負担額 = Decimal.ZERO;
        Decimal 全額利用者負担額 = Decimal.ZERO;

        for (KyufuJikoSakuseiEntity entity : list) {
            if (entity.is合計フラグ() && 限度対象外フラグ.equals(entity.get限度額対象外フラグ())) {
                サービス単位 = entity.getサービス単位().add(サービス単位);
                種類限度内単位 = entity.get種類限度内単位().add(種類限度内単位);
                種類限度超過単位 = entity.get種類限度超過単位().add(種類限度超過単位);
                区分限度内単位 = entity.get区分限度内単位().add(区分限度内単位);
                区分限度超過単位 = entity.get区分限度超過単位().add(区分限度超過単位);
            }
            費用総額 = entity.get費用総額().add(費用総額);
            保険給付額 = entity.get保険給付額().add(保険給付額);
            保険対象利用者負担額 = entity.get保険対象利用者負担額().add(保険対象利用者負担額);
            全額利用者負担額 = entity.get全額利用者負担額().add(全額利用者負担額);
        }
        resultEntity.setサービス単位(サービス単位);
        resultEntity.set種類限度内単位(種類限度内単位);
        resultEntity.set種類限度超過単位(種類限度超過単位);
        resultEntity.set区分限度内単位(区分限度内単位);
        resultEntity.set区分限度超過単位(区分限度超過単位);
        resultEntity.set費用総額(費用総額);
        resultEntity.set保険給付額(保険給付額);
        resultEntity.set保険対象利用者負担額(保険対象利用者負担額);
        resultEntity.set全額利用者負担額(全額利用者負担額);
        resultEntity.set事業者(事業者);
        resultEntity.set事業者コード(new JigyoshaNo(事業者コード));
        resultEntity.setサービス(設定してないR);
        resultEntity.set単位(設定してない);
        resultEntity.set割引適用後率(new HokenKyufuRitsu(設定してない));
        resultEntity.set割引適用後単位(設定してない);
        resultEntity.set回数(設定してない);
        resultEntity.set単位数単価(設定してない);
        resultEntity.set給付率(new HokenKyufuRitsu(設定してない));
        resultEntity.set給付計画単位数(設定してない);
        resultEntity.setサービス種類コード(new ServiceShuruiCode(設定してないR));
        resultEntity.setサービス項目コード(new ServiceKomokuCode(設定してないR));
        resultEntity.setステータス(設定してないR);
        resultEntity.set合計フラグ(false);
        resultEntity.set限度額対象外フラグ(設定してないR);
        result.setEntity(resultEntity);

        return result;

    }

    /**
     * サービス種類限度額統計処理
     *
     * @param 利用年月 FlexibleYearMonth
     * @param list List<ServiceTypeDetails>
     * @return List<ServiceTypeTotal>
     */
    public List<ServiceTypeTotal> getServiceTypeGendo(FlexibleYearMonth 利用年月, List<ServiceTypeDetails> list) {
        List<ServiceTypeTotal> sList1 = new ArrayList<>();
        List<ServiceTypeTotal> sList2 = new ArrayList<>();
        List<ServiceTypeTotal> sList3 = new ArrayList<>();
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

        for (ServiceTypeDetails details : list) {
            if (限度対象外フラグ.equals(details.get限度額対象外フラグ())) {
                RString 種類コード = details.getサービス種類コード().value();
                for (ServiceTypeTotal total : sList1) {
                    if (種類コード.equals(total.getサービス種類コード().value())) {
                        Decimal 合計単位数 = details.getサービス単位().add(total.get合計単位数());
                        total.set合計単位数(合計単位数);
                    }
                    sList2.add(total);
                }
            }
        }

        for (ServiceTypeTotal totals : sList2) {
            Decimal 合計単位数 = totals.get合計単位数();
            Decimal 限度額 = totals.get限度額();
            if (合計単位数 == null) {
                合計単位数 = Decimal.ZERO;
            }
            if (限度額 == null) {
                限度額 = Decimal.ZERO;
            }
            if (合計単位数.compareTo(限度額) > 0) {
                totals.set限度超過単位数(合計単位数.subtract(限度額));
            }
            sList3.add(totals);
        }

        return sList3;
    }

    /**
     * サービス利用票取得処理
     *
     * @param 被保険者番号 RString
     * @param 対象年月 FlexibleYearMonth
     * @param 履歴番号 RString
     * @param 利用年月 FlexibleYearMonth
     * @return List<KyufuJikoSakuseiEntity>
     */
    public List<KyufuJikoSakuseiEntity> getServiceRiyouHyo(RString 被保険者番号, FlexibleYearMonth 対象年月, int 履歴番号, FlexibleYearMonth 利用年月) {
        IJigoSakuseiMeisaiTourokuMapper mapper = mapperProvider.create(IJigoSakuseiMeisaiTourokuMapper.class);
        List<KyufuJikoSakuseiEntity> 給付計画自己作成EntityList = new ArrayList<>();
        List<KyufuJikoSakuseiEntity> 給付計画自己作成EntityList1 = new ArrayList<>();
        List<KyufuJikoSakuseiEntity> 給付計画自己作成EntityList2 = new ArrayList<>();
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_被保険者番号.toString(), new HihokenshaNo(被保険者番号));
        param.put(KEY_対象年月.toString(), 対象年月);
        param.put(KEY_履歴番号.toString(), 履歴番号);
        param.put(KEY_利用年月.toString(), 利用年月);
        List<KyufuJikoSakuseiEntity> entityList = mapper.getサービス利用票データ(param);

        if (entityList.isEmpty()) {
            List<KyufuJikoSakuseiEntity> entityLists = new ArrayList<>();
            KyufuJikoSakuseiResult result = getMeisaiGoukeiListGridAdjust(entityList);
            給付計画自己作成EntityList.add(result.getEntity());
            return entityLists;
        } else {
            for (KyufuJikoSakuseiEntity entity : entityList) {
                KyufuJikoSakuseiEntity 給付計画自己作成Entity = new KyufuJikoSakuseiEntity();
                給付計画自己作成Entity.setステータス(null);
                給付計画自己作成Entity.set事業者(entity.get事業者());
                給付計画自己作成Entity.setサービス(entity.getサービス());
                給付計画自己作成Entity.set単位(entity.get単位());
                給付計画自己作成Entity.set割引適用後率(entity.get割引適用後率());
                給付計画自己作成Entity.set割引適用後単位(entity.get割引適用後単位());
                給付計画自己作成Entity.set回数(entity.get回数());
                //TODO
                if (entity.getサービス項目コード().isEmpty() || entity.getサービス項目コード() == null) {
                    給付計画自己作成Entity.setサービス単位(null);
                } else {
                    給付計画自己作成Entity.setサービス単位(entity.get給付計画単位数());
                }
                給付計画自己作成Entity.set種類限度超過単位(entity.get種類限度超過単位());
                給付計画自己作成Entity.set種類限度内単位(entity.get種類限度内単位());
                給付計画自己作成Entity.set単位数単価(entity.get単位数単価());
                給付計画自己作成Entity.set区分限度超過単位(entity.get区分限度超過単位());
                給付計画自己作成Entity.set区分限度内単位(entity.get区分限度内単位());
                給付計画自己作成Entity.set給付率(entity.get給付率());
                給付計画自己作成Entity.set費用総額(null);
                給付計画自己作成Entity.set保険給付額(null);
                給付計画自己作成Entity.set保険対象利用者負担額(null);
                給付計画自己作成Entity.set全額利用者負担額(null);
                給付計画自己作成Entity.set事業者コード(entity.get事業者コード());
                給付計画自己作成Entity.setサービス種類コード(entity.getサービス種類コード());
                給付計画自己作成Entity.setサービス項目コード(entity.getサービス項目コード());
                給付計画自己作成Entity.set合計フラグ(entity.is合計フラグ());
                給付計画自己作成Entity.set限度額対象外フラグ(entity.get限度額対象外フラグ());
                給付計画自己作成Entity.set定額利用者負担単価金額(entity.get定額利用者負担単価金額());

                給付計画自己作成EntityList.add(給付計画自己作成Entity);
            }
        }

        for (KyufuJikoSakuseiEntity entity : 給付計画自己作成EntityList) {
            if (entity.is合計フラグ()) {
                GokeiKeisan gokeiKeisan = new GokeiKeisan();
                Decimal 利用者負担額 = Decimal.ZERO;
                if (サービス種類.equals(entity.getサービス種類コード().value())) {
                    利用者負担額 = entity.get定額利用者負担単価金額().multiply(entity.get回数());
                }
                gokeiKeisan.set利用者負担額(利用者負担額);
                gokeiKeisan.set種類限度超過単位(entity.get種類限度超過単位());
                gokeiKeisan.set種類限度内単位(entity.get種類限度内単位());
                gokeiKeisan.set単位数単価(entity.get単位数単価());
                gokeiKeisan.set区分限度内単位(entity.get区分限度内単位());
                gokeiKeisan.set区分限度超過単位(entity.get区分限度超過単位());
                gokeiKeisan.set給付率(entity.get給付率().value());
                gokeiKeisan.setサービス単位(entity.getサービス単位());
                GokeiKeisan gokeiKeisanResult = getGokeiKeisan(gokeiKeisan);
                entity.set費用総額(gokeiKeisanResult.get費用総額());
                entity.set保険給付額(gokeiKeisanResult.get保険給付額());
                entity.set保険対象利用者負担額(gokeiKeisanResult.get保険対象利用者負担額());
                entity.set全額利用者負担額(gokeiKeisanResult.get全額利用者負担額());
            }
            給付計画自己作成EntityList1.add(entity);
        }

        KyufuJikoSakuseiResult result = getMeisaiGoukeiListGridAdjust(給付計画自己作成EntityList1);
        給付計画自己作成EntityList2.add(result.getEntity());
        return 給付計画自己作成EntityList2;
    }

    /**
     * 区分限度額統計処理
     *
     * @param 被保険者番号 RString
     * @param 居宅総合事業区分 RString
     * @param 利用年月 FlexibleYearMonth
     * @return KubunGendo
     */
    public KubunGendo getKubunGendo(RString 被保険者番号, RString 居宅総合事業区分, FlexibleYearMonth 利用年月) {
        KubunGendo gendo = new KubunGendo();
        FlexibleDate 開始利用年月 = new FlexibleDate(利用年月.toString().concat(new RString(利用年月.getLastDay()).toString()));
        FlexibleDate 終了利用年月 = new FlexibleDate(利用年月.toString().concat(日_1.toString()));
        if (総合事業.equals(居宅総合事業区分)) {
            IJigoSakuseiMeisaiTourokuMapper mapper = mapperProvider.create(IJigoSakuseiMeisaiTourokuMapper.class);
            Map<String, Object> param = new HashMap<>();
            param.put(KEY_開始利用年月.toString(), 開始利用年月);
            param.put(KEY_終了利用年月.toString(), 終了利用年月);
            param.put(KEY_利用年月.toString(), 利用年月);
            param.put(KEY_被保険者番号.toString(), new HihokenshaNo(被保険者番号));
            KubunGendoEntity entity = mapper.get区分限度額統計処理(param);
            if (entity != null) {
                gendo.set区分支給限度額(entity.get支給限度単位数());
                gendo.set管理期間開始日(entity.get適用開始年月日());
                gendo.set管理期間終了日(entity.get適用終了年月日());
            }
        }
        if (居宅.equals(居宅総合事業区分)) {
            DbT4001JukyushaDaichoEntity entity = dac.select居宅総合事業区分(new HihokenshaNo(被保険者番号), 開始利用年月, 終了利用年月);
            if (entity != null) {
                gendo.set区分支給限度額(entity.getShikyuGendoTanisu());
                gendo.set管理期間開始日(entity.getNinteiYukoKikanKaishiYMD());
                gendo.set管理期間終了日(entity.getNinteiYukoKikanShuryoYMD());
            }
        }
        return gendo;
    }

    private Decimal toDecimal(Decimal num) {
        RString result = DecimalFormatter.toコンマ区切りRString(num, 0);
        return new Decimal(result.toString());
    }
}
