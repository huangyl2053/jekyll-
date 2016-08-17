/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.teikyohyobeppyo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KubunGendo;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiEntityResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.ServiceTypeDetails;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.ServiceTypeTotal;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TankiRiyoNissuResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TeikyohyoBeppyoEntityResult;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.teikyohyobeppyo.TankiRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.teikyohyobeppyo.TeikyohyoBeppyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.teikyohyobeppyo.ITeikyohyoBeppyoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.jigosakuseimeisaitouroku.JigoSakuseiMeisaiTouroku;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBC0150011_サービス提供票別表の印刷処理です。
 *
 * @reamsid_L DBC-5100-010 xuxin
 */
public class TeikyohyoBeppyoManager {

    private static final RString 他事業者 = new RString("他事業者");
    private static final RString 他事業者合計 = new RString("他事業者合計");
    private static final RString 零 = new RString("0");
    private static final RString 基準日R = new RString("基準日");
    private static final RString 被保険者番号R = new RString("被保険者番号");
    private static final RString 自己作成計画年月R = new RString("自己作成計画年月");
    private static final RString 対象年月R = new RString("対象年月");
    private static final RString 履歴番号R = new RString("履歴番号");
    private static final RString 引数_自己作成0件 = new RString("自己作成0件");

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    TeikyohyoBeppyoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TeikyohyoBeppyoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TeikyohyoBeppyoManager}のインスタンス
     */
    public static TeikyohyoBeppyoManager createInstance() {
        return InstanceProvider.create(TeikyohyoBeppyoManager.class);
    }

    /**
     * 2.1 被保険者情報の取得です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 自己作成計画年月 FlexibleYearMonth
     * @return TeikyohyoBeppyoEntityResult
     */
    public TeikyohyoBeppyoEntityResult get被保険者情報(HihokenshaNo 被保険者番号, FlexibleYearMonth 自己作成計画年月) {

        TeikyohyoBeppyoEntityResult result = new TeikyohyoBeppyoEntityResult();
        ITeikyohyoBeppyoMapper mapper = mapperProvider.create(ITeikyohyoBeppyoMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put(基準日R.toString(), RDate.getNowDate().toDateString());
        map.put(被保険者番号R.toString(), 被保険者番号);
        map.put(自己作成計画年月R.toString(), 自己作成計画年月);
        TeikyohyoBeppyoEntity entity = mapper.get被保険者情報(map);
        if (entity != null) {
            result.set対象年月(entity.get対象年月());
            result.set履歴番号(entity.get履歴番号());
            result.set総合事業区分(entity.get総合事業区分());
            result.set宛名(entity.get宛名());
        }
        return result;
    }

    /**
     * 2.2.a ビジネス「DBC0120031_サービス利用票情報」のサービス利用票取得処理を呼出します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @param 自己作成計画年月 int
     * @param 履歴番号 FlexibleYearMonth
     * @return List<KyufuJikoSakuseiResult>
     */
    public List<KyufuJikoSakuseiEntityResult> 帳票データ抽出(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月, int 履歴番号, FlexibleYearMonth 自己作成計画年月) {

        JigoSakuseiMeisaiTouroku manage = JigoSakuseiMeisaiTouroku.createInstance();
        List<KyufuJikoSakuseiResult> 帳票データ = manage.getServiceRiyouHyo(被保険者番号, 対象年月, 履歴番号,
                自己作成計画年月);
        List<KyufuJikoSakuseiEntityResult> 帳票データresult = new ArrayList<>();
        if (帳票データ.isEmpty()) {
            throw new ApplicationException(DbcErrorMessages.帳票印刷不可.getMessage().replace(引数_自己作成0件.toString()));
        } else {
            for (KyufuJikoSakuseiResult result : 帳票データ) {
                帳票データresult.add(entity変換(result));
            }
        }
        return 帳票データresult;
    }

    private KyufuJikoSakuseiEntityResult entity変換(KyufuJikoSakuseiResult result) {
        KyufuJikoSakuseiEntityResult entityResult = new KyufuJikoSakuseiEntityResult();
        entityResult.set事業者(result.get事業者());
        entityResult.setサービス(result.getサービス());
        entityResult.set単位(result.get単位());
        entityResult.set割引適用後率(result.get割引適用後率());
        entityResult.set割引適用後単位(result.get割引適用後単位());
        entityResult.set回数(result.get回数());
        entityResult.setサービス単位(result.getサービス単位());
        entityResult.set種類限度超過単位(result.get種類限度超過単位());
        entityResult.set種類限度内単位(result.get種類限度内単位());
        entityResult.set単位数単価(result.get単位数単価());
        entityResult.set区分限度超過単位(result.get区分限度超過単位());
        entityResult.set区分限度内単位(result.get区分限度内単位());
        entityResult.set給付率(result.get給付率());
        entityResult.set給付計画単位数(result.get給付計画単位数());
        entityResult.set費用総額(result.get費用総額());
        entityResult.set保険給付額(result.get保険給付額());
        entityResult.set保険対象利用者負担額(result.get保険対象利用者負担額());
        entityResult.set全額利用者負担額(result.get全額利用者負担額());
        entityResult.set事業者コード(result.get事業者コード());
        entityResult.setサービス種類コード(result.getサービス種類コード());
        entityResult.setサービス項目コード(result.getサービス項目コード());
        entityResult.setステータス(result.getステータス());
        entityResult.set合計フラグ(result.is合計フラグ());
        entityResult.set限度額対象外フラグ(result.get限度額対象外フラグ());
        entityResult.set定額利用者負担単価金額(result.get定額利用者負担単価金額());
        return entityResult;
    }

    /**
     * 2.2.c ビジネス「DBC0120031_サービス利用票情報」の区分限度額統計処理を呼出します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 居宅総合事業区分 RString
     * @param 利用年月 FlexibleYearMonth
     * @param 合計Entity KyufuJikoSakuseiEntityResult
     * @return KubunGendo
     */
    public KyufuJikoSakuseiEntityResult 合計Entity単位設定(HihokenshaNo 被保険者番号, RString 居宅総合事業区分,
            FlexibleYearMonth 利用年月, KyufuJikoSakuseiEntityResult 合計Entity) {

        JigoSakuseiMeisaiTouroku manage = JigoSakuseiMeisaiTouroku.createInstance();
        KubunGendo 単位データ = manage.getKubunGendo(被保険者番号, 居宅総合事業区分, 利用年月);
        合計Entity.set支給限度単位数(単位データ.get区分支給限度額());
        合計Entity.set適用開始年月日(単位データ.get管理期間開始日());
        合計Entity.set適用終了年月日(単位データ.get管理期間終了日());
        return 合計Entity;
    }

    /**
     * 2.3 - 2.4 事業者別マップの製造です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @param 自己作成計画年月 FlexibleYearMonth
     * @param 計画resultList List<KyufuJikoSakuseiResult>
     * @param 合計Entity KyufuJikoSakuseiResult
     * @return Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>>
     */
    public Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> creat事業者別マップ(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月, int 履歴番号, FlexibleYearMonth 自己作成計画年月,
            List<KyufuJikoSakuseiEntityResult> 計画resultList, KyufuJikoSakuseiEntityResult 合計Entity) {

        Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> 事業者別マップ = new HashMap<>();
        for (KyufuJikoSakuseiEntityResult result : 計画resultList) {
            List<KyufuJikoSakuseiEntityResult> 新規List = new ArrayList<>();
            if (事業者別マップ.get(result.get事業者コード()) == null) {
                合計Entity.set事業者(他事業者);
                合計Entity.setサービス(他事業者合計);
                新規List.add(合計Entity);
                新規List.add(result);
                事業者別マップ.put(result.get事業者コード(), 新規List);
            } else {
                事業者別マップ.get(result.get事業者コード()).add(1, result);
            }
            if (result.is合計フラグ()) {
                if (零.equals(result.get限度額対象外フラグ())) {
                    事業者別マップ.get(result.get事業者コード()).get(0).setサービス単位(事業者別マップ.
                            get(result.get事業者コード()).get(0).getサービス単位().subtract(result.getサービス単位()));
                    事業者別マップ.get(result.get事業者コード()).get(0).set種類限度内単位(事業者別マップ.
                            get(result.get事業者コード()).get(0).get種類限度内単位().subtract(result.get種類限度内単位()));
                    事業者別マップ.get(result.get事業者コード()).get(0).set種類限度超過単位(事業者別マップ.
                            get(result.get事業者コード()).get(0).get種類限度超過単位().subtract(result.get種類限度超過単位()));
                    事業者別マップ.get(result.get事業者コード()).get(0).set区分限度内単位(事業者別マップ.
                            get(result.get事業者コード()).get(0).get区分限度内単位().subtract(result.get区分限度内単位()));
                    事業者別マップ.get(result.get事業者コード()).get(0).set区分限度超過単位(事業者別マップ.
                            get(result.get事業者コード()).get(0).get区分限度超過単位().subtract(result.get区分限度超過単位()));
                }
                事業者別マップ.get(result.get事業者コード()).get(0).set費用総額(事業者別マップ.
                        get(result.get事業者コード()).get(0).get費用総額().subtract(result.get費用総額()));
                事業者別マップ.get(result.get事業者コード()).get(0).set保険給付額(事業者別マップ.
                        get(result.get事業者コード()).get(0).get保険給付額().subtract(result.get保険給付額()));
                事業者別マップ.get(result.get事業者コード()).get(0).set保険対象利用者負担額(事業者別マップ.
                        get(result.get事業者コード()).get(0).get保険対象利用者負担額().subtract(result.get保険対象利用者負担額()));
                事業者別マップ.get(result.get事業者コード()).get(0).set全額利用者負担額(事業者別マップ.
                        get(result.get事業者コード()).get(0).get全額利用者負担額().subtract(result.get全額利用者負担額()));
            }
        }
        return setMap逆順(事業者別マップ);
    }

    /**
     * 2.5 事業者別マップの全てList<給付計画自己作成Entity>を逆順にします。
     */
    private Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> setMap逆順(
            Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> 事業者別マップ) {

        Set<JigyoshaNo> keySet = 事業者別マップ.keySet();
        List<JigyoshaNo> keyList = new ArrayList<>();
        for (JigyoshaNo key : keySet) {
            keyList.add(key);
        }
        List<JigyoshaNo> keyList逆順 = setKeyListComparator(keyList);
        Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> 事業者別マップ逆順 = new HashMap<>();
        for (int i = 0; i < keyList逆順.size(); i++) {
            事業者別マップ逆順.put(keyList逆順.get(i), 事業者別マップ.get(keyList逆順.get(i)));
        }
        return 事業者別マップ逆順;
    }

    private List<JigyoshaNo> setKeyListComparator(List<JigyoshaNo> 事業者番号List) {
        if (事業者番号List.isEmpty()) {
            return 事業者番号List;
        }
        Collections.sort(事業者番号List,
                new Comparator<JigyoshaNo>() {
                    @Override
                    public int compare(JigyoshaNo arg0, JigyoshaNo arg1) {
                        return arg1.compareTo(arg0);
                    }
                }
        );
        return 事業者番号List;
    }

    /**
     * 2.6 種類別支給限度情報の取得です。
     *
     * @param 自己作成計画年月 FlexibleYearMonth
     * @param 帳票データ List<KyufuJikoSakuseiEntityResult>
     * @return List<ServiceTypeTotal>
     */
    public List<ServiceTypeTotal> get種類別支給限度情報(FlexibleYearMonth 自己作成計画年月,
            List<KyufuJikoSakuseiEntityResult> 帳票データ) {

        JigoSakuseiMeisaiTouroku manage = JigoSakuseiMeisaiTouroku.createInstance();
        List<ServiceTypeDetails> details = new ArrayList<>();
        for (KyufuJikoSakuseiEntityResult result : 帳票データ) {
            ServiceTypeDetails detail = new ServiceTypeDetails();
            detail.setサービス単位(result.getサービス単位());
            detail.setサービス種類コード(result.getサービス種類コード());
            detail.setサービス項目コード(result.getサービス項目コード());
            detail.set限度額対象外フラグ(result.get限度額対象外フラグ());
            details.add(detail);
        }
        List<ServiceTypeTotal> totals = new ArrayList<>();
        for (ServiceTypeTotal total : manage.getServiceTypeGendo(自己作成計画年月, details)) {
            if (total.get限度超過単位数() == null) {
                total.set限度超過単位数(Decimal.ZERO);
            }
            totals.add(total);
        }
        return totals;
    }

    /**
     * 2.7 短期入所利用日数の取得です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @param 自己作成計画年月 FlexibleYearMonth
     * @return List<TankiRiyoNissuResult>
     */
    public List<TankiRiyoNissuResult> get短期入所利用日数(HihokenshaNo 被保険者番号, FlexibleYearMonth 対象年月,
            int 履歴番号, FlexibleYearMonth 自己作成計画年月) {

        List<TankiRiyoNissuResult> resultList = new ArrayList<>();
        ITeikyohyoBeppyoMapper mapper = mapperProvider.create(ITeikyohyoBeppyoMapper.class
        );
        Map<String, Object> map = new HashMap<>();
        map.put(被保険者番号R.toString(), 被保険者番号);
        map.put(対象年月R.toString(), 対象年月);
        map.put(履歴番号R.toString(), 履歴番号);
        map.put(自己作成計画年月R.toString(), 自己作成計画年月);
        List<TankiRiyoNissuEntity> tankiRiyoNissu = mapper.get短期入所利用日数(map);
        for (TankiRiyoNissuEntity entity : tankiRiyoNissu) {
            TankiRiyoNissuResult result = new TankiRiyoNissuResult();
            result.set今回計画利用日数(entity.get今回計画利用日数());
            result.set前回迄利用日数(entity.get前回迄利用日数());
            result.set累積利用日数(entity.get今回計画利用日数().add(entity.get前回迄利用日数()));
            resultList.add(result);
        }
        return resultList;
    }

}
