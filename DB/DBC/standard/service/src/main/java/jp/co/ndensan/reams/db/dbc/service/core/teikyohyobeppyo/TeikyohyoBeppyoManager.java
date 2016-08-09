/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.teikyohyobeppyo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBC0150011_サービス提供票別表 印刷処理
 *
 * @reamsid_L DBC-5100-010 xuxin
 */
public class TeikyohyoBeppyoManager {

    private final MapperProvider mapperProvider;
    private static final RString 自己作成0件 = new RString("自己作成0件");
    private static final RString 他事業者 = new RString("他事業者");
    private static final RString 他事業者合計 = new RString("他事業者合計");
    private static final RString 限度額対象外フラグ = new RString("0");
    private static final RString 被保険者番号R = new RString("被保険者番号");
    private static final RString 対象年月R = new RString("対象年月");
    private static final RString 履歴番号R = new RString("履歴番号");
    private static final RString 自己作成計画年月R = new RString("自己作成計画年月");

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
     * 2.1 被保険者情報を取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @param 自己作成計画年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @return TeikyohyoBeppyoEntity
     */
    public TeikyohyoBeppyoEntityResult get被保険者情報(HihokenshaNo 被保険者番号, FlexibleYearMonth 対象年月, int 履歴番号, FlexibleYearMonth 自己作成計画年月) {
        TeikyohyoBeppyoEntityResult result = new TeikyohyoBeppyoEntityResult();
        ITeikyohyoBeppyoMapper mapper = mapperProvider.create(ITeikyohyoBeppyoMapper.class);
        Map<String, Object> param = new HashMap<>();
        param.put(被保険者番号R.toString(), 被保険者番号);
        param.put(対象年月R.toString(), 対象年月);
        param.put(履歴番号R.toString(), 履歴番号);
        param.put(自己作成計画年月R.toString(), 自己作成計画年月);
        TeikyohyoBeppyoEntity entity = mapper.get被保険者情報(param);
        if (entity != null) {
            result.set宛名(entity.get宛名());
            result.set総合事業区分(entity.get総合事業区分());
            result.set被保険者番号(entity.get被保険者番号());
        }
        return result;
    }

    /**
     * 2.2.c 合計Entity取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @param 自己作成計画年月 int
     * @param 履歴番号 FlexibleYearMonth
     * @return KubunGendo
     */
    public KubunGendo get合計Entity(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月, int 履歴番号, FlexibleYearMonth 自己作成計画年月) {
        TeikyohyoBeppyoEntityResult result = get被保険者情報(被保険者番号, 対象年月, 履歴番号, 自己作成計画年月);
        JigoSakuseiMeisaiTouroku jigoSakuseiMeisaiTouroku = JigoSakuseiMeisaiTouroku.createInstance();
        KubunGendo 合計Entity = jigoSakuseiMeisaiTouroku.getKubunGendo(被保険者番号, result.get総合事業区分(), 自己作成計画年月);

        return 合計Entity;
    }

    /**
     * 2.3 - 2.5 事業者別マップは製造します.
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @param 自己作成計画年月 FlexibleYearMonth
     * @return Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>>
     */
    public Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> get事業者別マップ(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月, int 履歴番号, FlexibleYearMonth 自己作成計画年月) {
        Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> 事業者別マップ = new HashMap<>();
        JigoSakuseiMeisaiTouroku touroku = new JigoSakuseiMeisaiTouroku();
        List<KyufuJikoSakuseiEntityResult> 計画EntityResutl = new ArrayList<>();
        List<KyufuJikoSakuseiResult> 計画Entity = touroku.getServiceRiyouHyo(被保険者番号, 対象年月, 履歴番号, 自己作成計画年月);
        if (計画Entity.isEmpty()) {
            throw new ApplicationException(DbcErrorMessages.帳票印刷不可.getMessage().replace(
                    自己作成0件.toString()));
        } else {

            for (KyufuJikoSakuseiResult entity : 計画Entity) {
                KyufuJikoSakuseiEntityResult result = new KyufuJikoSakuseiEntityResult();
//                result.setEntity(entity.getEntity());
                result.setサービス(entity.getサービス());
                result.setサービス単位(entity.getサービス単位());
                result.setサービス種類コード(entity.getサービス種類コード());
                result.setサービス項目コード(entity.getサービス項目コード());
                result.setステータス(entity.getステータス());
                result.set事業者(entity.get事業者());
                result.set事業者コード(entity.get事業者コード());
                result.set保険対象利用者負担額(entity.get保険対象利用者負担額());
                result.set保険給付額(entity.get保険給付額());
                result.set全額利用者負担額(entity.get全額利用者負担額());
                result.set割引適用後単位(entity.get割引適用後単位());
                result.set割引適用後率(entity.get割引適用後率());
                result.set区分限度内単位(entity.get区分限度内単位());
                result.set区分限度超過単位(entity.get区分限度超過単位());
                result.set単位(entity.get単位());
                result.set単位数単価(entity.get単位数単価());
                result.set合計フラグ(entity.is合計フラグ());
                result.set回数(entity.get回数());
                result.set定額利用者負担単価金額(entity.get定額利用者負担単価金額());
                result.set種類限度内単位(entity.get種類限度内単位());
                result.set種類限度超過単位(entity.get種類限度超過単位());
                result.set給付率(entity.get給付率());
                result.set給付計画単位数(entity.get給付計画単位数());
                result.set費用総額(entity.get費用総額());
                result.set限度額対象外フラグ(entity.get限度額対象外フラグ());

                計画EntityResutl.add(result);
            }

            KubunGendo 合計Entity = get合計Entity(被保険者番号, 対象年月, 履歴番号, 自己作成計画年月);
            Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> 事業者別マップResult
                    = getMapマップ(計画EntityResutl, 合計Entity, 事業者別マップ);
            //2.5 map  事業者別マップResultpaixu TODO
            return 事業者別マップResult;
        }
    }

    /**
     * 2.6 種類別支給限度情報の取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @param 自己作成計画年月 FlexibleYearMonth
     * @return List<ServiceTypeTotal>
     */
    public List<ServiceTypeTotal> get種類別支給限度情報(HihokenshaNo 被保険者番号, FlexibleYearMonth 対象年月, int 履歴番号, FlexibleYearMonth 自己作成計画年月) {
        JigoSakuseiMeisaiTouroku touroku = new JigoSakuseiMeisaiTouroku();
        List<ServiceTypeDetails> details = new ArrayList<>();
        List<KyufuJikoSakuseiResult> 計画Entity = touroku.getServiceRiyouHyo(被保険者番号, 対象年月, 履歴番号, 自己作成計画年月);
        if (計画Entity.isEmpty()) {
            throw new ApplicationException(DbcErrorMessages.帳票印刷不可.getMessage().replace(
                    自己作成0件.toString()));
        } else {
            for (KyufuJikoSakuseiResult askuseiEntity : 計画Entity) {
                ServiceTypeDetails detail = new ServiceTypeDetails();
                detail.setサービス単位(askuseiEntity.getサービス単位());
                detail.setサービス種類コード(askuseiEntity.getサービス種類コード());
                detail.setサービス項目コード(askuseiEntity.getサービス項目コード());
                detail.set限度額対象外フラグ(askuseiEntity.get限度額対象外フラグ());
                details.add(detail);
            }

            return touroku.getServiceTypeGendo(自己作成計画年月, details);
        }
    }

    /**
     * 2.7 短期入所利用日数の取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @param 自己作成計画年月 FlexibleYearMonth
     * @return List<TankiRiyoNissuResult>
     */
    public List<TankiRiyoNissuResult> get短期入所利用日数(HihokenshaNo 被保険者番号, FlexibleYearMonth 対象年月, int 履歴番号, FlexibleYearMonth 自己作成計画年月) {
        List<TankiRiyoNissuResult> resultList = new ArrayList<>();
        ITeikyohyoBeppyoMapper mapper = mapperProvider.create(ITeikyohyoBeppyoMapper.class);
        Map<String, Object> param = new HashMap<>();
        param.put(被保険者番号R.toString(), 被保険者番号);
        param.put(対象年月R.toString(), 対象年月);
        param.put(履歴番号R.toString(), 履歴番号);
        param.put(自己作成計画年月R.toString(), 自己作成計画年月);
        List<TankiRiyoNissuEntity> tankiRiyoNissu = mapper.get短期入所利用日数(param);
        for (TankiRiyoNissuEntity entity : tankiRiyoNissu) {
            TankiRiyoNissuResult result = new TankiRiyoNissuResult();
            result.set今回計画利用日数(entity.get今回計画利用日数());
            result.set前回迄利用日数(entity.get前回迄利用日数());
            resultList.add(result);
        }
        return resultList;
    }

    private Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> getMapマップ(List<KyufuJikoSakuseiEntityResult> 計画Entity,
            KubunGendo 合計Entity, Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> 事業者別マップ) {
        for (KyufuJikoSakuseiEntityResult sakusei : 計画Entity) {
            if (事業者別マップ.get(sakusei.get事業者コード()) == null) {
                sakusei.getEntity().set支給限度単位数(合計Entity.get区分支給限度額());
                sakusei.getEntity().set適用終了年月日(合計Entity.get管理期間終了日());
                sakusei.getEntity().set適用開始年月日(合計Entity.get管理期間開始日());
                事業者別マップ.get(sakusei.get事業者コード()).get(0).set事業者(他事業者);
                事業者別マップ.get(sakusei.get事業者コード()).get(0).setサービス(他事業者合計);
                事業者別マップ.get(sakusei.get事業者コード()).get(0).setEntity(sakusei.getEntity());
                事業者別マップ.put(sakusei.get事業者コード(), 計画Entity);
            } else {
                事業者別マップ.get(sakusei.get事業者コード()).add(1, sakusei);
            }

            if (sakusei.is合計フラグ()) {
                if (限度額対象外フラグ.equals(sakusei.get限度額対象外フラグ())) {
                    事業者別マップ.get(sakusei.get事業者コード()).get(0).setサービス単位(
                            事業者別マップ.get(sakusei.get事業者コード()).get(0).getサービス単位().subtract(sakusei.getサービス単位()));
                    事業者別マップ.get(sakusei.get事業者コード()).get(0).setサービス単位(
                            事業者別マップ.get(sakusei.get事業者コード()).get(0).get種類限度内単位().subtract(sakusei.get種類限度内単位()));
                    事業者別マップ.get(sakusei.get事業者コード()).get(0).setサービス単位(
                            事業者別マップ.get(sakusei.get事業者コード()).get(0).get種類限度超過単位().subtract(sakusei.get種類限度超過単位()));
                    事業者別マップ.get(sakusei.get事業者コード()).get(0).setサービス単位(
                            事業者別マップ.get(sakusei.get事業者コード()).get(0).get区分限度内単位().subtract(sakusei.get区分限度内単位()));
                    事業者別マップ.get(sakusei.get事業者コード()).get(0).setサービス単位(
                            事業者別マップ.get(sakusei.get事業者コード()).get(0).get区分限度超過単位().subtract(sakusei.get区分限度超過単位()));
                }
                事業者別マップ.get(sakusei.get事業者コード()).get(0).set費用総額(
                        事業者別マップ.get(sakusei.get事業者コード()).get(0).get費用総額().subtract(sakusei.get費用総額()));
                事業者別マップ.get(sakusei.get事業者コード()).get(0).set保険給付額(
                        事業者別マップ.get(sakusei.get事業者コード()).get(0).get保険給付額().subtract(sakusei.get保険給付額()));
                事業者別マップ.get(sakusei.get事業者コード()).get(0).set保険対象利用者負担額(
                        事業者別マップ.get(sakusei.get事業者コード()).get(0).get保険対象利用者負担額().subtract(sakusei.get保険対象利用者負担額()));
                事業者別マップ.get(sakusei.get事業者コード()).get(0).set全額利用者負担額(
                        事業者別マップ.get(sakusei.get事業者コード()).get(0).get全額利用者負担額().subtract(sakusei.get保険対象利用者負担額()));
            }
        }
        return 事業者別マップ;
    }

//    //2.5 事業者別マップの全てList<給付計画自己作成Entity>を逆順にする。 TODO
//    private void getMap逆順() {
//
//    }
}
