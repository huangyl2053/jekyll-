/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0150011;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiEntityResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TeikyohyoBeppyoEntityResult;
import jp.co.ndensan.reams.db.dbc.business.core.serviceriyohyobeppyo.ServiceRiyohyoBeppyoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0150011.ServiceTeikyohyoBeppyoPrintMainDiv;
import jp.co.ndensan.reams.db.dbc.service.core.teikyohyobeppyo.TeikyohyoBeppyoManager;
import jp.co.ndensan.reams.db.dbc.service.report.serviceRiyohyoBeppyo.ServiceRiyohyoBeppyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 画面設計_DBC0150011_サービス提供票別表のHandlerクラス。
 *
 * @reamsid_L DBC-5100-010 xuxin
 */
public class ServiceTeikyohyoBeppyoPrintMainHandler {

    private static final RString 合計行名_事業者 = new RString("他事業者");
    private static final RString 合計行名_サービス = new RString("他事業者合計");
    private static final RString 零 = new RString("0");

    private final ServiceTeikyohyoBeppyoPrintMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ServiceTeikyohyoBeppyoPrintMainDiv
     */
    public ServiceTeikyohyoBeppyoPrintMainHandler(ServiceTeikyohyoBeppyoPrintMainDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div ServiceTeikyohyoBeppyoPrintMainDiv
     * @return ServiceTeikyohyoBeppyoPrintMainHandler
     */
    public static ServiceTeikyohyoBeppyoPrintMainHandler of(ServiceTeikyohyoBeppyoPrintMainDiv div) {
        return new ServiceTeikyohyoBeppyoPrintMainHandler(div);
    }

    /**
     * 帳票発行処理時の処理です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param manager TeikyohyoBeppyoManager
     * @return SourceDataCollection
     */
    public SourceDataCollection to帳票発行処理(HihokenshaNo 被保険者番号, TeikyohyoBeppyoManager manager) {

        ServiceRiyohyoBeppyoParameter param = new ServiceRiyohyoBeppyoParameter();
        FlexibleDate 作成年月日 = new FlexibleDate(div.getTxtSakuseiYmd().getValue().toDateString());
        FlexibleYearMonth 自己作成計画年月 = new FlexibleYearMonth(div.getTxtJikoSakuseiKeikakuYm().getValue().
                getYearMonth().toDateString());
        TeikyohyoBeppyoEntityResult 被保険者情報Result = manager.get被保険者情報(被保険者番号, 自己作成計画年月,
                作成年月日);
        被保険者情報Result.set被保険者番号(被保険者番号);
        FlexibleYearMonth 対象年月 = 被保険者情報Result.get対象年月();
        int 履歴番号 = 被保険者情報Result.get履歴番号();
        RString 居宅総合事業区分 = 被保険者情報Result.get総合事業区分();
        List<KyufuJikoSakuseiEntityResult> 帳票データ = manager.帳票データ抽出(被保険者番号, 対象年月, 履歴番号,
                自己作成計画年月);
        KyufuJikoSakuseiEntityResult 合計Entity = 帳票データ.get(帳票データ.size() - 1);
        List<KyufuJikoSakuseiEntityResult> 計画EntityList = 帳票データ.subList(0, 帳票データ.size() - 1);
        合計Entity = manager.合計Entity単位設定(被保険者番号, 居宅総合事業区分, 自己作成計画年月, 合計Entity);
        KyufuJikoSakuseiEntityResult 合計Entity_合計情報用 = result新規(合計Entity);
        KyufuJikoSakuseiEntityResult 合計Entity_帳票情報用 = result新規(合計Entity);
        param.set合計情報(合計Entity_合計情報用);
        param.set帳票情報マップ(creat事業者別マップ(計画EntityList, 合計Entity_帳票情報用));
        param.set帳票ヘッダー(被保険者情報Result);
        param.set作成日時(作成年月日);
        param.set利用年月(自己作成計画年月);
        param.set種類別支給限度情報(manager.get種類別支給限度情報(自己作成計画年月, 計画EntityList));
        param.set短期入所情報(manager.get短期入所利用日数(被保険者番号, 対象年月, 履歴番号, 自己作成計画年月));
        ServiceRiyohyoBeppyoPrintService printService = new ServiceRiyohyoBeppyoPrintService();
        return printService.printSingle(param);
    }

    private Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> creat事業者別マップ(
            List<KyufuJikoSakuseiEntityResult> 計画resultList,
            KyufuJikoSakuseiEntityResult 合計Entity) {

        Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> 事業者別マップ = new TreeMap<>();
        for (KyufuJikoSakuseiEntityResult result : 計画resultList) {
            if (事業者別マップ.get(result.get事業者コード()) == null) {
                List<KyufuJikoSakuseiEntityResult> 新規List = new ArrayList<>();
                KyufuJikoSakuseiEntityResult 新規Result = result新規(合計Entity);
                新規Result.set事業者(合計行名_事業者);
                新規Result.setサービス(合計行名_サービス);
                新規List.add(新規Result);
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
                        get(result.get事業者コード()).get(0).get保険対象利用者負担額().
                        subtract(result.get保険対象利用者負担額()));
                事業者別マップ.get(result.get事業者コード()).get(0).set全額利用者負担額(事業者別マップ.
                        get(result.get事業者コード()).get(0).get全額利用者負担額().subtract(result.get全額利用者負担額()));
            }
        }
        return sortMapByKey逆順(事業者別マップ);
    }

    private KyufuJikoSakuseiEntityResult result新規(KyufuJikoSakuseiEntityResult result) {
        KyufuJikoSakuseiEntityResult 新規Result = new KyufuJikoSakuseiEntityResult();
        新規Result.set事業者(result.get事業者());
        新規Result.setサービス(result.getサービス());
        新規Result.set単位(result.get単位());
        新規Result.set割引適用後率(result.get割引適用後率());
        新規Result.set割引適用後単位(result.get割引適用後単位());
        新規Result.set回数(result.get回数());
        新規Result.setサービス単位(result.getサービス単位());
        新規Result.set種類限度超過単位(result.get種類限度超過単位());
        新規Result.set種類限度内単位(result.get種類限度内単位());
        新規Result.set単位数単価(result.get単位数単価());
        新規Result.set区分限度超過単位(result.get区分限度超過単位());
        新規Result.set区分限度内単位(result.get区分限度内単位());
        新規Result.set給付率(result.get給付率());
        新規Result.set給付計画単位数(result.get給付計画単位数());
        新規Result.set費用総額(result.get費用総額());
        新規Result.set保険給付額(result.get保険給付額());
        新規Result.set保険対象利用者負担額(result.get保険対象利用者負担額());
        新規Result.set全額利用者負担額(result.get全額利用者負担額());
        新規Result.set事業者コード(result.get事業者コード());
        新規Result.setサービス種類コード(result.getサービス種類コード());
        新規Result.setサービス項目コード(result.getサービス項目コード());
        新規Result.setステータス(result.getステータス());
        新規Result.set合計フラグ(result.is合計フラグ());
        新規Result.set限度額対象外フラグ(result.get限度額対象外フラグ());
        新規Result.set定額利用者負担単価金額(result.get定額利用者負担単価金額());
        新規Result.set支給限度単位数(result.get支給限度単位数());
        新規Result.set適用開始年月日(result.get適用開始年月日());
        新規Result.set適用終了年月日(result.get適用終了年月日());
        return 新規Result;
    }

    private Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> sortMapByKey逆順(
            Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> 事業者別Map) {
        if (事業者別Map == null || 事業者別Map.isEmpty()) {
            return null;
        }
        Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> 事業者別Map逆順 = new TreeMap<
                JigyoshaNo, List<KyufuJikoSakuseiEntityResult>>(new MapKeyComparator());
        事業者別Map逆順.putAll(事業者別Map);
        return 事業者別Map逆順;
    }

}

/**
 * カスタムの比較器クラスです。
 */
class MapKeyComparator implements Comparator<JigyoshaNo> {

    @Override
    public int compare(JigyoshaNo arg0, JigyoshaNo arg1) {
        return arg1.compareTo(arg0);
    }

}
