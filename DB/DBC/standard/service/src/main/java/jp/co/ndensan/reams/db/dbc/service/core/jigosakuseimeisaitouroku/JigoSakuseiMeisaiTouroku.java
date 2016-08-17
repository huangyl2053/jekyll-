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
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyotakuServiceRirekiIchiranEntityResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.RiyoNentstsuIchiranEntityResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.ServiceTypeDetails;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.ServiceTypeTotal;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TankiNyushoResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigosakuseimeisaitouroku.KubunGendoParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigosakuseimeisaitouroku.KyufuJikoSakuseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigosakuseimeisaitouroku.TankiNyushoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.KubunGendoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.KyotakuServiceRirekiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.KyufuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.RiyoNentstsuIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.ServiceTypeTotalEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.TankiNyushoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jigosakuseimeisaitouroku.IJigoSakuseiMeisaiTourokuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3114RiyoshaFutanWariaiMeisaiDac;
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

/**
 * サービス利用票情報のビジネスクラスです。
 *
 * @reamsid_L DBC-1930-060 cuilin
 */
public class JigoSakuseiMeisaiTouroku {

    private final MapperProvider mapperProvider;
    private final DbT4001JukyushaDaichoDac 受給者台帳dac;
    private final DbT3114RiyoshaFutanWariaiMeisaiDac 利用者負担割合明細Dac;
    private static final Decimal 定値_100 = new Decimal("100");
    private static final RString 限度対象外フラグ = new RString("0");
    private static final RString 定値_合計 = new RString("合計");
    private static final RString 定値_ホシ = new RString("*");
    private static final RString 定値_ハイフン = new RString("ー");
    private static final RString 区分_居宅 = new RString("1");
    private static final RString 区分_総合事業 = new RString("2");
    private static final RString 定値_01 = new RString("01");
    private static final RString KEY_利用年月 = new RString("利用年月");
    private static final RString KEY_被保険者番号 = new RString("被保険者番号");
    private static final RString KEY_対象年月 = new RString("対象年月");
    private static final RString KEY_履歴番号 = new RString("履歴番号");

    /**
     * コンストラクタです。
     */
    public JigoSakuseiMeisaiTouroku() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.受給者台帳dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.利用者負担割合明細Dac = InstanceProvider.create(DbT3114RiyoshaFutanWariaiMeisaiDac.class);
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
     * 合計計算処理メソッドです。
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
        if (Decimal.ZERO.equals(nullToZero(区分限度内単位))) {
            Decimal 費用総額 = nullToZero(サービス単位).multiply(nullToZero(単位数単価));
            合計計算情報.set費用総額(小数点以下を切り(費用総額));
        } else {
            Decimal 費用総額 = 区分限度内単位.multiply(nullToZero(単位数単価));
            合計計算情報.set費用総額(小数点以下を切り(費用総額));
        }

        if (利用者負担額 != null && !Decimal.ZERO.equals(利用者負担額)) {
            合計計算情報.set保険対象利用者負担額(利用者負担額);
            合計計算情報.set保険給付額(合計計算情報.get費用総額().subtract(nullToZero(合計計算情報.get保険対象利用者負担額())));
        } else {
            if (給付率 == null) {
                給付率 = HokenKyufuRitsu.ZERO;
            }
            if (Decimal.ZERO.equals(給付率.getColumnValue())) {
                合計計算情報.set保険給付額(合計計算情報.get費用総額());
            } else {
                Decimal 保険給付額 = 合計計算情報.get費用総額().divide(定値_100).multiply(給付率.getColumnValue());
                合計計算情報.set保険給付額(小数点以下を切り(保険給付額));
            }
            合計計算情報.set保険対象利用者負担額(合計計算情報.get費用総額().subtract(合計計算情報.get保険給付額()));
        }

        Decimal 全額利用者負担額 = (種類限度超過単位.add(区分限度超過単位)).multiply(単位数単価);
        合計計算情報.set全額利用者負担額(小数点以下を切り(全額利用者負担額));

        return 合計計算情報;
    }

    /**
     * 明細・合計一覧Grid整理処理メソッドです。
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
            if (result.is合計フラグ()) {
                if (限度対象外フラグ.equals(result.get限度額対象外フラグ())) {
                    サービス単位 = nullToZero(result.getサービス単位()).add(サービス単位);
                    種類限度内単位 = nullToZero(result.get種類限度内単位()).add(種類限度内単位);
                    種類限度超過単位 = nullToZero(result.get種類限度超過単位()).add(種類限度超過単位);
                    区分限度内単位 = nullToZero(result.get区分限度内単位()).add(区分限度内単位);
                    区分限度超過単位 = nullToZero(result.get区分限度超過単位()).add(区分限度超過単位);
                }
                費用総額 = nullToZero(result.get費用総額()).add(費用総額);
                保険給付額 = nullToZero(result.get保険給付額()).add(保険給付額);
                保険対象利用者負担額 = nullToZero(result.get保険対象利用者負担額()).add(保険対象利用者負担額);
                全額利用者負担額 = nullToZero(result.get全額利用者負担額()).add(全額利用者負担額);
            }
        }
        KyufuJikoSakuseiResult kyufuJikoSakuseiResult = new KyufuJikoSakuseiResult();
        kyufuJikoSakuseiResult.setサービス単位(サービス単位);
        kyufuJikoSakuseiResult.set種類限度内単位(種類限度内単位);
        kyufuJikoSakuseiResult.set種類限度超過単位(種類限度超過単位);
        kyufuJikoSakuseiResult.set区分限度内単位(区分限度内単位);
        kyufuJikoSakuseiResult.set区分限度超過単位(区分限度超過単位);
        kyufuJikoSakuseiResult.set費用総額(費用総額);
        kyufuJikoSakuseiResult.set保険給付額(保険給付額);
        kyufuJikoSakuseiResult.set保険対象利用者負担額(保険対象利用者負担額);
        kyufuJikoSakuseiResult.set全額利用者負担額(全額利用者負担額);
        // TODO QAのNo.975 (Redmine#92977)
        kyufuJikoSakuseiResult.set事業者(定値_合計);
        kyufuJikoSakuseiResult.setサービス(定値_ハイフン);
        kyufuJikoSakuseiResult.set事業者コード(new JigyoshaNo(定値_ホシ));
        kyufuJikoSakuseiResult.setサービス種類コード(new ServiceShuruiCode(定値_ハイフン));
        kyufuJikoSakuseiResult.setサービス項目コード(new ServiceKomokuCode(定値_ハイフン));
        kyufuJikoSakuseiResult.setステータス(定値_ハイフン);
        kyufuJikoSakuseiResult.set限度額対象外フラグ(定値_ハイフン);
        return kyufuJikoSakuseiResult;

    }

    private Decimal nullToZero(Decimal decimal) {
        return decimal == null ? Decimal.ZERO : decimal;
    }

    /**
     * サービス種類限度額統計処理メソッドです。
     *
     * @param 利用年月 FlexibleYearMonth
     * @param サービス種類詳細List List<ServiceTypeDetails>
     * @return List<ServiceTypeTotal>
     */
    public List<ServiceTypeTotal> getServiceTypeGendo(FlexibleYearMonth 利用年月,
            List<ServiceTypeDetails> サービス種類詳細List) {
        IJigoSakuseiMeisaiTourokuMapper mapper = mapperProvider.create(IJigoSakuseiMeisaiTourokuMapper.class);
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_利用年月.toString(), 利用年月);
        List<ServiceTypeTotalEntity> entityList = mapper.getサービス種類支給額(param);
        if (entityList == null || entityList.isEmpty()) {
            return Collections.emptyList();
        }
        List<ServiceTypeTotal> sList1 = new ArrayList<>();
        for (ServiceTypeTotalEntity entity : entityList) {
            ServiceTypeTotal stotal = new ServiceTypeTotal();
            stotal.setサービス種類(entity.getサービス種類略称());
            stotal.setサービス種類コード(entity.getサービス種類コード());
            stotal.set合計単位数(null);
            stotal.set限度超過単位数(null);
            stotal.set限度額(entity.get支給限度単位数());
            sList1.add(stotal);
        }

        List<ServiceTypeTotal> sList2 = new ArrayList<>();
        for (ServiceTypeTotal total : sList1) {
            Decimal 合計単位数 = Decimal.ZERO;
            for (ServiceTypeDetails details : サービス種類詳細List) {
                if (限度対象外フラグ.equals(details.get限度額対象外フラグ())
                        && total.getサービス種類コード().getColumnValue().equals(details.getサービス種類コード().getColumnValue())) {
                    合計単位数 = 合計単位数.add(nullToZero(details.getサービス単位()));
                }
            }
            total.set合計単位数(合計単位数);
            Decimal 限度額 = nullToZero(total.get限度額());
            if (合計単位数.compareTo(限度額) > 0) {
                total.set限度超過単位数(合計単位数.subtract(限度額));
            }
            sList2.add(total);
        }
        return sList2;
    }

    /**
     * サービス利用票取得処理メソッドです。
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
        KyufuJikoSakuseiParameter param = KyufuJikoSakuseiParameter.createParam(被保険者番号, 対象年月, 履歴番号, 利用年月);
        List<KyufuJikoSakuseiEntity> entityList = mapper.getサービス利用票データ(param);
        if (entityList == null || entityList.isEmpty()) {
            return Collections.emptyList();
        }
        List<KyufuJikoSakuseiResult> 給付計画自己作成情報 = new ArrayList<>();
        for (KyufuJikoSakuseiEntity entity : entityList) {
            KyufuJikoSakuseiResult result = new KyufuJikoSakuseiResult();
            result.set事業者(entity.get事業者());
            result.setサービス(entity.getサービス());
            result.set単位(entity.get単位());
            result.set割引適用後率(entity.get割引適用後率());
            result.set割引適用後単位(entity.get割引適用後単位());
            result.set回数(entity.get回数());
            result.setサービス単位(entity.get給付計画単位数());
            result.set種類限度超過単位(entity.get種類限度超過単位());
            result.set種類限度内単位(entity.get種類限度内単位());
            result.set単位数単価(entity.get単位数単価());
            result.set区分限度超過単位(entity.get区分限度超過単位());
            result.set区分限度内単位(entity.get区分限度内単位());
            result.set給付率(entity.get給付率());
            result.set事業者コード(entity.get事業者コード());
            result.setサービス種類コード(entity.getサービス種類コード());
            result.setサービス項目コード(entity.getサービス項目コード());
            result.set合計フラグ(entity.is合計フラグ());
            result.set限度額対象外フラグ(entity.get限度額対象外フラグ());
            result.set定額利用者負担単価金額(entity.get定額利用者負担単価金額());
            if (entity.is合計フラグ()) {
                Decimal 利用者負担額;
                if (ServiceCategoryShurui.総用貸与.getコード().equals(entity.getサービス種類コード().getColumnValue())) {
                    利用者負担額 = entity.get定額利用者負担単価金額();
                } else {
                    利用者負担額 = nullToZero(entity.get定額利用者負担単価金額()).multiply(nullToZero(entity.get回数()));
                }
                GokeiKeisan gokeiKeisanResult = getGokeiKeisan(利用者負担額, entity.get種類限度超過単位(),
                        entity.get種類限度内単位(), entity.get単位数単価(), entity.get区分限度超過単位(),
                        entity.get区分限度内単位(), entity.get給付率(), entity.getサービス単位());
                result.set費用総額(gokeiKeisanResult.get費用総額());
                result.set保険給付額(gokeiKeisanResult.get保険給付額());
                result.set保険対象利用者負担額(gokeiKeisanResult.get保険対象利用者負担額());
                result.set全額利用者負担額(gokeiKeisanResult.get全額利用者負担額());
            }
            給付計画自己作成情報.add(result);
        }
        KyufuJikoSakuseiResult kyufuJikoSakuseiResult = getMeisaiGoukeiListGridAdjust(給付計画自己作成情報);
        給付計画自己作成情報.add(kyufuJikoSakuseiResult);
        return 給付計画自己作成情報;
    }

    /**
     * 区分限度額統計処理メソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 居宅総合事業区分 RString
     * @param 利用年月 FlexibleYearMonth
     * @return KubunGendo
     */
    public KubunGendo getKubunGendo(HihokenshaNo 被保険者番号, RString 居宅総合事業区分, FlexibleYearMonth 利用年月) {
        KubunGendo gendo = new KubunGendo();
        FlexibleDate 開始利用年月 = (利用年月 == null) ? null
                : new FlexibleDate(利用年月.toString().concat(new RString(利用年月.getLastDay()).toString()));
        FlexibleDate 終了利用年月 = (利用年月 == null) ? null
                : new FlexibleDate(利用年月.toString().concat(定値_01.toString()));
        if (区分_総合事業.equals(居宅総合事業区分)) {
            IJigoSakuseiMeisaiTourokuMapper mapper = mapperProvider.create(IJigoSakuseiMeisaiTourokuMapper.class);
            KubunGendoParameter param = KubunGendoParameter.createParam(被保険者番号, 利用年月, 開始利用年月, 終了利用年月);
            KubunGendoEntity entity = mapper.get区分限度額統計処理(param);
            if (entity != null) {
                gendo.set区分支給限度額(entity.get支給限度単位数());
                gendo.set管理期間開始日(entity.get適用開始年月日());
                gendo.set管理期間終了日(entity.get適用終了年月日());
            }
        } else if (区分_居宅.equals(居宅総合事業区分)) {
            DbT4001JukyushaDaichoEntity entity = 受給者台帳dac.select居宅総合事業区分(被保険者番号, 開始利用年月, 終了利用年月);
            if (entity != null) {
                gendo.set区分支給限度額(entity.getShikyuGendoTanisu());
                gendo.set管理期間開始日(entity.getNinteiYukoKikanKaishiYMD());
                gendo.set管理期間終了日(entity.getNinteiYukoKikanShuryoYMD());
            }
        }
        return gendo;
    }

    private Decimal 小数点以下を切り(Decimal decimal) {
        if (decimal == null) {
            return null;
        }
        return new Decimal((int) Math.floor(decimal.doubleValue()));
    }

    /**
     * 短期入所情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @param 利用年月 FlexibleYearMonth
     * @return TankiNyushoResult
     */
    public TankiNyushoResult getTankiNyuryo(HihokenshaNo 被保険者番号, FlexibleYearMonth 対象年月, int 履歴番号,
            FlexibleYearMonth 利用年月) {
        IJigoSakuseiMeisaiTourokuMapper mapper = mapperProvider.create(IJigoSakuseiMeisaiTourokuMapper.class);
        TankiNyushoParameter param = TankiNyushoParameter.creatParam(被保険者番号, 対象年月, 履歴番号, 利用年月);
        TankiNyushoEntity entity = mapper.get短期入所情報(param);
        if (entity == null) {
            return null;
        }
        TankiNyushoResult result = new TankiNyushoResult();
        result.setEntity(entity);
        return result;
    }

    /**
     * 利用年月チェックメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @return int
     */
    public int load利用年月チェック(HihokenshaNo 被保険者番号, FlexibleYearMonth 対象年月) {
        FlexibleDate 開始利用年月 = (対象年月 == null) ? null
                : new FlexibleDate(対象年月.toString().concat(new RString(対象年月.getLastDay()).toString()));
        FlexibleDate 終了利用年月 = (対象年月 == null) ? null
                : new FlexibleDate(対象年月.toString().concat(定値_01.toString()));
        List<DbT4001JukyushaDaichoEntity> entityList
                = 受給者台帳dac.select受給者台帳By被保険者番号(被保険者番号, 開始利用年月, 終了利用年月);
        if (entityList == null || entityList.isEmpty()) {
            return 0;
        }
        return entityList.size();
    }

    /**
     * 給付率取得のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 利用年月 FlexibleYearMonth
     * @return List<RiyoshaFutanWariaiMeisai>
     */
    public List<RiyoshaFutanWariaiMeisai> get給付率(HihokenshaNo 被保険者番号, FlexibleYearMonth 利用年月) {
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> entityList = 利用者負担割合明細Dac.select負担割合区分(被保険者番号, 利用年月);
        if (entityList == null || entityList.isEmpty()) {
            return Collections.emptyList();
        }
        List<RiyoshaFutanWariaiMeisai> businessList = new ArrayList<>();
        for (DbT3114RiyoshaFutanWariaiMeisaiEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new RiyoshaFutanWariaiMeisai(entity));
        }
        return businessList;
    }

    /**
     * 居宅サービス履歴一覧取得
     *
     * @param 被保険者番号 RString
     * @return List<KyotakuHistoryDataEntity>
     */
    public List<KyotakuServiceRirekiIchiranEntityResult> getKyotakuServiceRirekiIchiran(HihokenshaNo 被保険者番号) {
        IJigoSakuseiMeisaiTourokuMapper mapper = mapperProvider.create(IJigoSakuseiMeisaiTourokuMapper.class);
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_被保険者番号.toString(), 被保険者番号);
        List<KyotakuServiceRirekiIchiranEntity> entityList = mapper.get居宅サービス履歴一覧(param);
        if (entityList.isEmpty()) {
            return Collections.emptyList();
        }
        List<KyotakuServiceRirekiIchiranEntityResult> 居宅サービス履歴一覧List = new ArrayList<>();
        for (KyotakuServiceRirekiIchiranEntity entity : entityList) {
            KyotakuServiceRirekiIchiranEntityResult entityResult = new KyotakuServiceRirekiIchiranEntityResult();
            entityResult.setEntity(entity);
            居宅サービス履歴一覧List.add(entityResult);
        }
        return 居宅サービス履歴一覧List;
    }

    /**
     * 対象情報一覧を取得
     *
     * @param 対象年月　FlexibleYearMonth
     * @param 履歴番号　int
     * @param 被保険者番号　HihokenshaNo
     * @return List<NotificationEntity>
     */
    public List<RiyoNentstsuIchiranEntityResult> getRiyoNentstsuIchiran(HihokenshaNo 被保険者番号, FlexibleYearMonth 対象年月, int 履歴番号) {
        IJigoSakuseiMeisaiTourokuMapper mapper = mapperProvider.create(IJigoSakuseiMeisaiTourokuMapper.class);
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_被保険者番号.toString(), 被保険者番号);
        param.put(KEY_対象年月.toString(), 対象年月);
        param.put(KEY_履歴番号.toString(), 履歴番号);
        List<RiyoNentstsuIchiranEntity> entityList = mapper.get対象情報一覧(param);
        if (entityList.isEmpty()) {
            return Collections.emptyList();
        }
        List<RiyoNentstsuIchiranEntityResult> 対象情報一覧List = new ArrayList<>();
        for (RiyoNentstsuIchiranEntity entity : entityList) {
            RiyoNentstsuIchiranEntityResult entityResult = new RiyoNentstsuIchiranEntityResult();
            entityResult.setEntity(entity);
            対象情報一覧List.add(entityResult);
        }
        return 対象情報一覧List;
    }
}
