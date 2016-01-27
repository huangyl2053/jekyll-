/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820013;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820013.KouzaInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820013.KouzaInfoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**												
 * 償還払い費支給申請決定_口座情報のクラス
 */
public class KouzaInfoPanel {

/**
     * 償還払い費支給申請決定_口座情報の画面初期化する。
     *
     * @param div KouzaInfoDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<KouzaInfoDiv> onLoad(KouzaInfoDiv div) {

        // TODO 引き継ぎデータの取得
        ServiceTeiKyoShomeishoParameter parmeter = new ServiceTeiKyoShomeishoParameter(
                new HihokenshaNo("000000003"), new FlexibleYearMonth(new RString("201601")),
                new RString("0000000003"), new JigyoshaNo("0000000003"), new RString("事業者名"),
                new RString("0003"), new RString("証明書"));
        ViewStateHolder.put(ViewStateKeys.基本情報パラメータ, parmeter);
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();

        // TODO 該当者検索画面ViewState．識別コード
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("123456"));
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        //                = ViewStateHolder.get(DAViewStateKeys.KokuhoShikakuIdo.国保資格異動情報,
        //                        HijihatsutekiShitsugyoshaNyuryokuModel.class);

        // TODO 申請書検索ViewSate．様式番号
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("0003"));
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);

        RString 申請日 = new RString("");
        // TODO 这里连番不是我的参数
        RString 連番 = new RString("");

          // TODO 凌護行 共有子Divデータがない、
        //div.getPanelOne().getCcdKaigoAtenaInfo().load(識別コード);
          div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);


        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            // TODO 凌護行 param不正、 QA回答まち
            // LasdecCode.市町村コード
            div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
            // TODO 凌護行 ビジネス設計_DBCMN11006_償還払い費支給申請決定を実装しない 
             //List<ShokanShinsei> shokanShinseiList = ShokanShiseiFinder.createInstance().getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
//        if(shokanShinseiList.isEmpty()) {
//            // TODO エラーメッセジを表示して
//        }
        getHandler(div).setヘッダ_エリア(サービス年月, 整理番号);
        // TODO 共有子div调用不可
//        div.getPanelShinseiNaiyo().getCcdShiharaiHohoJyoho().load(識別コード, 被保険者番号, サービス提供年月
//                , 整理番号, 支払方法区分コード, 支払場所, 支払期間開始年月日
//                , 支払期間終了年月日, 支払窓口開始時間, 支払窓口終了期間, 口座ID, 受領委任契約番号);
        return createResponse(div);
    }

    /**
     * 申請情報ボタンを押下した際に実行します。<br/>
     * DBC0810012_申請情報照会画面へ遷移する
     *
     * @param div {@link KouzaInfoDiv 口座情報画面Div}
     * @return 口座情報画面Divを持つResponseData
     */
    public ResponseData<KouzaInfoDiv> onClick_btnShinseiInfo(KouzaInfoDiv div) {
        //  DBC0810012_申請情報照会画面へ遷移する
        return createResponse(div);
    }
    
    /**
     * サービス提供証明書ボタンを押下した際に実行します。<br/>
     * DBC0810014_サービス提供証明書情報画面へ遷移する
     *
     * @param div {@link KouzaInfoDiv 口座情報画面Div}
     * @return 口座情報画面Divを持つResponseData
     */
    public ResponseData<KouzaInfoDiv> onClick_btnServiceTeikyoShomeisyo(KouzaInfoDiv div) {
        // DBC0810014_サービス提供証明書情報画面へ遷移する
        return createResponse(div);
    }
    
    /**
     * 償還払決定情報ボタンを押下した際に実行します。<br/>
     * DBC0810015_償還払決定情報画面へ遷移する
     *
     * @param div {@link KouzaInfoDiv 口座情報画面Div}
     * @return 口座情報画面Divを持つResponseData
     */
    public ResponseData<KouzaInfoDiv> onClick_btnShokanbaraiKeiteInfo(KouzaInfoDiv div) {
        // DBC0810015_償還払決定情報画面へ遷移する
        return createResponse(div);
    }

    private KouzaInfoHandler getHandler(KouzaInfoDiv div) {
        return new KouzaInfoHandler(div);
    }

       private ResponseData<KouzaInfoDiv> createResponse(KouzaInfoDiv div) {
        return ResponseData.of(div).respond();
    }
}

