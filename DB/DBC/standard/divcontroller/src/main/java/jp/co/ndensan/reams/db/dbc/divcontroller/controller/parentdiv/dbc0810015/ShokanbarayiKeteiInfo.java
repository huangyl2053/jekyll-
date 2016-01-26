/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810015;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810015.ShokanbarayiKeteiInfoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 償還払い状況照会_償還払決定情報のクラスです。
 * @author yebangqiang
 */
public class ShokanbarayiKeteiInfo {
    
    public ResponseData<ShokanbarayiKeteiInfoDiv> onLoad(ShokanbarayiKeteiInfoDiv div) {
        // TODO 引き継ぎデータの取得
        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("123456"));
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200405"));
        HihokenshaNo 被保険者番号 = new HihokenshaNo("1");
        RString 整理番号 = new RString("123456");
        JigyoshaNo 事業者番号 = new JigyoshaNo("2");
        RString 様式番号 = new RString("2345");
        RString 申請日 = new RString("20151124");
        RString 明細番号 = new RString("3456");
        RString 証明書 = new RString("証明書");
        // TODO 凌護行 共有子Divデータがない、
        // KaigoAtenaInfo  「介護宛名情報」共有子Divの初期化
//        div.getPanelCcd().getCcdKaigoAtenaInfo().load(識別コード);
        
        // KaigoShikakuKihon 「介護資格系基本情報」共有子Div の初期化(这个entity中的load方法没写)
        if (!被保険者番号.isEmpty()) {
//            div.getPanelCcd().getCcdKaigoShikakuKihon().load(LasdecCode.EMPTY, 識別コード);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
        div.getPanelTwo().getTxtServiceTeikyoYM().setDomain(new RYearMonth(サービス年月.wareki().toDateString()));
        div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
//        div.getCcdShokanbaraiketteiJoho().load(被保険者番号, サービス年月, 整理番号);
//        int count = div.getCcdShokanbaraiketteiJoho().get件数();
//        if(count == 0) {
//            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
//        }
        div.getPanelTwo().getBtnShokanbariKeteiInfo().setDisabled(true);
        return ResponseData.of(div).respond();
    }
    
    /**
     * 申請情報ボタンを押下した際に実行します.
     * @param div
     * @return 
     */
    public ResponseData<ShokanbarayiKeteiInfoDiv> onClick_btnShinsei(ShokanbarayiKeteiInfoDiv div) {
        return ResponseData.of(div).respond();
    }
    
    /**
     * 口座情報ボタンを押下した際に実行します.
     * @param div
     * @return 
     */
    public ResponseData<ShokanbarayiKeteiInfoDiv> onClick_btnKouza(ShokanbarayiKeteiInfoDiv div) {
        return ResponseData.of(div).respond();
    }
    /**
     * サービス提供証明書ボタンを押下した際に実行します.
     * @param div
     * @return 
     */
    public ResponseData<ShokanbarayiKeteiInfoDiv> onClick_btnServiceTeikyoShomeisyo(ShokanbarayiKeteiInfoDiv div) {
        return ResponseData.of(div).respond();
    }
    
    /**
     * 申請情報検索へ戻るボタンを押下した際に実行します.
     * @param div
     * @return 
     */
    public ResponseData<ShokanbarayiKeteiInfoDiv> onClick_btnBack(ShokanbarayiKeteiInfoDiv div) {
        //getHandler(div).btnKihonInfo();
        return ResponseData.of(div).respond();
    }
}
