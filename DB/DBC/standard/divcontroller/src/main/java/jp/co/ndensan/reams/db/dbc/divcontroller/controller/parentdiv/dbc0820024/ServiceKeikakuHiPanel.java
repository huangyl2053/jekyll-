/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820024;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.servicekeikakuHi.ServiceKeikakuHiRealtEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.ServiceKeikakuHiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.ServiceKeikakuHiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820024.ServiceKeikakuHiPanelHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(サービス計画費)のクラスです。												
 */
public class ServiceKeikakuHiPanel {

    private static final FlexibleYearMonth サービス年月_200904 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth サービス年月_200903 = new FlexibleYearMonth("200903");
    private static final FlexibleYearMonth サービス年月_200604 = new FlexibleYearMonth("200604");
    private static final RString 登録モード = new RString("登録");
    private static final RString 削除モード = new RString("削除");
    private static final RString 追加 = new RString("追加");
    private static final RString 更新 = new RString("更新");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 修正 = new RString("修正");

    /**
     * 償還払い費支給申請決定_サービス提供証明書(サービス計画費)の画面初期化する。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onLoad(ServiceKeikakuHiPanelDiv div) {
//        Entity entity =ViewStateHolder.get(ViewStateKeys.償還払請求基本, Entity.class);
//          HihokenshaNo 被保険者番号 = entity.get();
          HihokenshaNo 被保険者番号 = new HihokenshaNo("1");
          // TODO 凌護行 共有子Divデータがない、
//        div.getPanelCcd().getCcdKaigoAtenaInfo().load(被保険者番号);
//          div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
//          RString 明細番号 = entity.明細番号;
        RString 明細番号 = new RString("3456");
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200904"));
        RString 整理番号 = new RString("123456");
        JigyoshaNo 事業者番号 = new JigyoshaNo("2");
        RString 様式番号 = new RString("2545");
        RString 申請日 = new RString("20151124");
        RString 証明書 = new RString("証明書");
//        if (明細番号 == null || 明細番号.isEmpty()) {
//            // TODO 処理が中止する、償還払支給申請_サービス提供証明書画面へ遷移する
//        }else {
//            if (!サービス年月_200904.isBefore(サービス年月)) {
//                List<ServiceKeikakuHiRealtEntity> entity200904List
//                  = ServiceKeikakuHiFinder.createInstance().selectShokanServicePlan200904(サービス年月, 被保険者番号, 整理番号, 事業者番号, 様式番号);
//                if (entity200904List == null || entity200904List.isEmpty()) {
//                    throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
//                }
//                div.getPanelServiceKeikakuhiDown().setVisible(false);
//                div.getPanelServiceKeikakuHiUp().setVisible(true);
//                div.getPanelServiceKeikakuhiUp().setVisible(false);
//                getHandler(div).onLoad(
//                  entity200904List,
//                  サービス年月,
//                  事業者番号,
//                  様式番号,
//                  申請日,
//                  明細番号,
//                  証明書);
//            } else{
//                if (!サービス年月_200604.isBefore(サービス年月) && サービス年月_200903.isBefore(サービス年月)) {
//                    ServiceKeikakuHiRealtEntity entity200604
//                            = ServiceKeikakuHiFinder.createInstance().selectShokanServicePlan200604(サービス年月, 被保険者番号, 整理番号, 事業者番号, 様式番号);
//                    if (entity200604 == null) {
//                        throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
//                    }
//                    getHandler(div).onLoad(
//                            entity200604,
//                            サービス年月,
//                            事業者番号,
//                            様式番号,
//                            申請日,
//                            明細番号,
//                            証明書);
//                } else {
//                    ServiceKeikakuHiRealtEntity entity200004
//                            = ServiceKeikakuHiFinder.createInstance().selectShokanServicePlan200004(サービス年月, 被保険者番号, 整理番号, 事業者番号, 様式番号);
//                    if (entity200004 == null) {
//                        throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
//                    }
//                    getHandler(div).onLoad20004(
//                            entity200004,
//                            サービス年月,
//                            事業者番号,
//                            様式番号,
//                            申請日,
//                            明細番号,
//                            証明書);
//                    }
//                div.getPanelServiceKeikakuhiDown().setVisible(true);
//                div.getPanelServiceKeikakuHiUp().setVisible(false);
//            }
//        }

        // TODO 凌護行 ビジネス設計_DBCMN11006_償還払い状況照会を実装しない
//        DbT3118ShikibetsuNoKanriEntity dbt3118Entity = new DbT3118ShikibetsuNoKanriEntity();
//               = ServiceKeikakuHiFinder.createInstance().getShikibetsubangoKanri(サービス年月, 様式番号);
//        getHandler(div).setボタン表示制御処理(dbt3118Entity);
        getHandler(div).setボタン表示制御処理();
        return createResponse(div);
    }

    /**
     * 保存ボタンを押下した際に実行します。<br/>
     * DBC0810023_特定診療費画面へ遷移する
     *
     * @param div {@link ServiceKeikakuHiPanelDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnUpdate(ServiceKeikakuHiPanelDiv div) {
//        RString model = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if(登録モード.equals(new RString("登録"))) {// viewState里的状态获得
            // TODO サービス計画費登録更新 実装しない
        }else if(削除モード.equals(new RString("削除"))) {
            // TODO 証明書削除処理 実装しない
        }
        return createResponse(div); 
    }

    /**
     * 追加するボタンを押下した際に実行します。
     *
     * @param div {@link ServiceKeikakuHiPanelDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnAdd(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).onClick_btnAdd();
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        return createResponse(div); 
    }

    /**
     * 修正ボタンを押下した際に実行します。
     * 
     * @param div {@link ServiceKeikakuHiPanelDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_dgList_modify(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).putViewStateHolder(修正);
        return ResponseData.of(div).respond();
    }

    /**
     * 削除ボタンを押下した際に実行します。
     * 
     * @param div {@link ServiceKeikakuHiPanelDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_dgList_delete(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).putViewStateHolder(削除);
        return ResponseData.of(div).respond();
    }

    /**
     * 削除ボタンを押下した際に実行します。
     * 
     * @param div {@link ServiceKeikakuHiPanelDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKeisan(ServiceKeikakuHiPanelDiv div) {
        // 单位数不知在哪里
        Decimal serviceTanyiSu = div.getTxtKaisu().getValue().multiply(Decimal.ZERO);
        div.getTxtServiceTanyiSu().setValue(serviceTanyiSu);
        return ResponseData.of(div).respond();
    }

    /**
     * クリアするボタンを押下した際に実行します。
     * 
     * @param div {@link ServiceKeikakuHiPanelDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnClear(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).setサービス計画費登録エリア(null, null, null, null);
        return ResponseData.of(div).respond();
    }

    /**
     * 取消するボタンを押下した際に実行します。
     * 
     * @param div {@link ServiceKeikakuHiPanelDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnCancel(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).setサービス計画費登録エリア(null, null, null, null);
        div.getPanelServiceKeikakuhiUp().setVisible(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 確定するボタンを押下した際に実行します。
     * 
     * @param div {@link ServiceKeikakuHiPanelDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnConfirm(ServiceKeikakuHiPanelDiv div) {
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            
        }else if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            
        }else if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            
        }
        return ResponseData.of(div).respond();
    }

    private ServiceKeikakuHiPanelHandler getHandler(ServiceKeikakuHiPanelDiv div) {
        return new ServiceKeikakuHiPanelHandler(div);
    }

    private ResponseData<ServiceKeikakuHiPanelDiv> createResponse(ServiceKeikakuHiPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
