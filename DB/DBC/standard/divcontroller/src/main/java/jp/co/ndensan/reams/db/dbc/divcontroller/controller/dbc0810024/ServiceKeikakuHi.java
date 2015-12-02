/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0810024;

import java.util.List;
import jp.co.ndensan.reams.da.dab.divcontroller.handler.parentdiv.dbc0810024.ServiceKeikakuHiPanelHandler;
import jp.co.ndensan.reams.db.dbc.business.core.servicekeikakuHi.ServiceKeikakuHiRealtEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810024.ServiceKeikakuHiDiv;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.service.core.serviceKeikakuHi.ServiceKeikakuHiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い状況照会_サービス計画費のクラスです。
 */
public class ServiceKeikakuHi {

    private static final FlexibleYearMonth サービス年月_200904 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth サービス年月_200903 = new FlexibleYearMonth("200903");
    private static final FlexibleYearMonth サービス年月_200604 = new FlexibleYearMonth("200604");
    private static final RString 設定不可 = new RString("0");

    /**
     * 償還払い状況照会_サービス計画費の画面初期化する。
     *
     * @param div ServiceKeikakuHiDiv
     * @return PanelDivのResponseData
     */
    //デモでは初期値を出しておかないので、requestSettingsにセットしていない。
    public ResponseData<ServiceKeikakuHiDiv> onLoad(ServiceKeikakuHiDiv div) {
//        ResponseData<ServiceKeikakuHiDiv> response = new ResponseData<>();
        // TODO 凌護行 パラメーター取得方針不明、課題提出中

        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("123456"));
        //                = ViewStateHolder.get(DAViewStateKeys.KokuhoShikakuIdo.国保資格異動情報,
        //                        HijihatsutekiShitsugyoshaNyuryokuModel.class);

        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200904"));
        HihokenshaNo 被保険者番号 = new HihokenshaNo("1");
        RString 整理番号 = new RString("123456");
        JigyoshaNo 事業者番号 = new JigyoshaNo("2");
        RString 様式番号 = new RString("2345");
        RString 申請日 = new RString("20151124");
        RString 明細番号 = new RString("3456");
        RString 証明書 = new RString("証明書");

        // TODO 凌護行 共有子Divデータがない、
//        div.getPanelCcd().getCcdKaigoAtenaInfo().load(識別コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            // TODO 凌護行 param不正、 QA回答まち
//            div.getPanelCcd().getCcdKaigoShikakuKihon().load(LasdecCode.EMPTY, 識別コード);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }

        // TODO 凌護行 ビジネス設計_DBCMN11006_償還払い状況照会を実装しない
        DbT3118ShikibetsuNoKanriEntity dbt3118Entity = new DbT3118ShikibetsuNoKanriEntity();
//               = ServiceKeikakuHiFinder.createInstance().getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(dbt3118Entity);

        if (!サービス年月_200904.isBefore(サービス年月)) {
            List<ServiceKeikakuHiRealtEntity> entity200904List
                    = ServiceKeikakuHiFinder.createInstance().selectShokanServicePlan200904(サービス年月, 被保険者番号, 整理番号, 事業者番号, 様式番号);
            if (entity200904List == null || entity200904List.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            div.getPanelServiceKeikakuhiDown().setVisible(false);
            div.getPanelServiceKeikakuHiUp().setVisible(true);
            getHandler(div).onLoad(
                    entity200904List,
                    サービス年月,
                    事業者番号,
                    様式番号,
                    申請日,
                    明細番号,
                    証明書);
        } else {
            if (!サービス年月_200604.isBefore(サービス年月) && サービス年月_200903.isBefore(サービス年月)) {
                ServiceKeikakuHiRealtEntity entity200604
                        = ServiceKeikakuHiFinder.createInstance().selectShokanServicePlan200604(サービス年月, 被保険者番号, 整理番号, 事業者番号, 様式番号);
                if (entity200604 == null) {
                    throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
                }
                getHandler(div).onLoad(
                        entity200604,
                        サービス年月,
                        事業者番号,
                        様式番号,
                        申請日,
                        明細番号,
                        証明書);
            } else {
                ServiceKeikakuHiRealtEntity entity200004
                        = ServiceKeikakuHiFinder.createInstance().selectShokanServicePlan200004(サービス年月, 被保険者番号, 整理番号, 事業者番号, 様式番号);
                if (entity200004 == null) {
                    throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
                }
                getHandler(div).onLoad20004(
                        entity200004,
                        サービス年月,
                        事業者番号,
                        様式番号,
                        申請日,
                        明細番号,
                        証明書);
            }
            div.getPanelServiceKeikakuhiDown().setVisible(true);
            div.getPanelServiceKeikakuHiUp().setVisible(false);
        }

        return createResponse(div);
    }

    /**
     * 基本情報ボタンを押下した際に実行します。<br/>
     * DBC0810021_基本情報画面へ遷移する
     *
     * @param div {@link ServiceKeikakuHiDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_btnKihonInfo(ServiceKeikakuHiDiv div) {
        // TODO DBC0810021_基本情報画面へ遷移する
        return createResponse(div);
    }

    /**
     * 給付費明細ボタンを押下した際に実行します。<br/>
     * DBC0810022_給付費明細画面へ遷移する
     *
     * @param div {@link ServiceKeikakuHiDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_btnKyufuhiMeisai(ServiceKeikakuHiDiv div) {
        // DBC0810022_給付費明細画面へ遷移する
        return createResponse(div);
    }

    /**
     * 特定診療費ボタンを押下した際に実行します。<br/>
     * DBC0810023_特定診療費画面へ遷移する
     *
     * @param div {@link ServiceKeikakuHiDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_btnTokuteiShinryo(ServiceKeikakuHiDiv div) {
        // DBC0810023_特定診療費画面へ遷移する
        return createResponse(div);
    }

    /**
     * 特定入所者費用ボタンを押下した際に実行します。<br/>
     * DBC0810025_特定入所者費用画面へ遷移する
     *
     * @param div {@link ServiceKeikakuHiDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_btnTokuteiNyushosha(ServiceKeikakuHiDiv div) {
        // DBC0810025_特定入所者費用画面へ遷移する
        return createResponse(div);
    }

    /**
     * 合計情報ボタンを押下した際に実行します。<br/>
     * DBC0810026_合計情報画面へ遷移する
     *
     * @param div {@link ServiceKeikakuHiDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_btnGokeiInfo(ServiceKeikakuHiDiv div) {
        // DBC0810026_合計情報画面へ遷移する
        return createResponse(div);
    }

    /**
     * 緊急時施設療養費ボタンを押下した際に実行します。<br/>
     * DBC0810027_緊急時施設療養費画面へ遷移する
     *
     * @param div {@link ServiceKeikakuHiDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_btnKinkyujiShisetsu(ServiceKeikakuHiDiv div) {
        // DBC0810027_緊急時施設療養費画面へ遷移する
        return createResponse(div);
    }

    // TODO 凌護行 「緊急時・所定疾患」ボタンがない、　QA回答まち。
//        /**
//     * 緊急時施設療養費ボタンを押下した際に実行します。<br/>
//     * DBC0810027_緊急時施設療養費画面へ遷移する
//     *
//     * @param div {@link ServiceKeikakuHiDiv サービス計画費画面Div}
//     * @return サービス計画費画面Divを持つResponseData
//     */
//    public ResponseData<ServiceKeikakuHiDiv> onClick_btnKinkyujiShisetsu(ServiceKeikakuHiDiv div) {
//        // DBC0810027_緊急時施設療養費画面へ遷移する
//        return createResponse(div);
//    }
    /**
     * 食事費用ボタンを押下した際に実行します。<br/>
     * DBC0810029_食事費用画面へ遷移する
     *
     * @param div {@link ServiceKeikakuHiDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_btnShokujiHiyo(ServiceKeikakuHiDiv div) {
        // DBC0810029_食事費用画面へ遷移する
        return createResponse(div);
    }

    /**
     * 請求額集計ボタンを押下した際に実行します。<br/>
     * DBC0810030_請求額集計画面へ遷移する
     *
     * @param div {@link ServiceKeikakuHiDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_btnSeikyugakuShukei(ServiceKeikakuHiDiv div) {
        // DBC0810030_請求額集計画面へ遷移する
        return createResponse(div);
    }

    /**
     * 社福軽減額ボタンを押下した際に実行します。<br/>
     * DBC0810031_社福軽減額画面へ遷移する
     *
     * @param div {@link ServiceKeikakuHiDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_btnShafukukeigenGaku(ServiceKeikakuHiDiv div) {
        // DBC0810031_社福軽減額画面へ遷移する
        return createResponse(div);
    }

    /**
     * 給付費明細(住所地特例)ボタンを押下した際に実行します。<br/>
     * DBC0810032_給付費明細(住所地特例)画面へ遷移する
     *
     * @param div {@link ServiceKeikakuHiDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_btnKyufuhiMeisaiJyuchi(ServiceKeikakuHiDiv div) {
        // DBC0810032_給付費明細(住所地特例)画面へ遷移する
        return createResponse(div);
    }

    /**
     * サービス提供証明書へ戻るを押下した際に実行します。<br/>
     * DBC0810014_サービス提供証明書画面へ遷移する
     *
     * @param div {@link ServiceKeikakuHiDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_btnBack(ServiceKeikakuHiDiv div) {
        // DBC0810014_サービス提供証明書画面へ遷移する
        return createResponse(div);
    }

    /**
     * 閉じるボタンを押下した際に実行します。<br/>
     * サービス計画費(200904)パネルを表示しないを閉じる
     *
     * @param div {@link ServiceKeikakuHiDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_btnClose(ServiceKeikakuHiDiv div) {
        div.getPanelServiceKeikakuHiUp().setVisible(false);
        return createResponse(div);
    }

    /**
     * 選択ボタンを押下した際に実行します。<br/>
     * サービス計画費(200904)パネル一覧グリッドを選択じる
     *
     * @param div {@link ServiceKeikakuHiDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_SelectButton(ServiceKeikakuHiDiv div) {
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200904"));
        HihokenshaNo 被保険者番号 = new HihokenshaNo("1");
        RString 整理番号 = new RString("123456");
        JigyoshaNo 事業者番号 = new JigyoshaNo("2");
        RString 様式番号 = new RString("2345");
        RString 明細番号 = new RString("3456");
        RString 連番 = div.getPanelServiceKeikakuHiUp().getDgdYichiran().getClickedItem().getDefaultDataName7();
        ServiceKeikakuHiRealtEntity entity200904
                = ServiceKeikakuHiFinder.createInstance().selectByKey(サービス年月, 被保険者番号, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
        // TODO 凌護行 画面一覧に連番がない、QA回答まち
        getHandler(div).onClick_SelectButton(entity200904);
        return createResponse(div);
    }

    private ServiceKeikakuHiPanelHandler getHandler(ServiceKeikakuHiDiv div) {
        return new ServiceKeikakuHiPanelHandler(div);
    }

    private ResponseData<ServiceKeikakuHiDiv> createResponse(ServiceKeikakuHiDiv div) {
        return ResponseData.of(div).respond();
    }
}
