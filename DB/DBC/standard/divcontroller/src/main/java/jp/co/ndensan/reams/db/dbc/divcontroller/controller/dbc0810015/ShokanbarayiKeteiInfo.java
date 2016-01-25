/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0810015;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810015.ShokanbarayiKeteiInfoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author yebangqiang
 */
public class ShokanbarayiKeteiInfo {
    
    public ResponseData<ShokanbarayiKeteiInfoDiv> onLoad(ShokanbarayiKeteiInfoDiv div) {
//        // TODO 凌護行 共有子Divデータがない、
//        // サービス提供証明書画面ViewStateより、引き継ぎデータEntityを取得する
//        FalseEntity entity = new FalseEntity();
//        //                = ViewStateHolder.get(DAViewStateKeys.KokuhoShikakuIdo.国保資格異動情報, FalseEntity.class);
//        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("123456"));
//        //                        = ViewStateHolder.get(DAViewStateKeys.KokuhoShikakuIdo.国保資格異動情報, ShikibetsuCode.class);
//        RString 被保険者番号 = entity.get被保険者番号();
//        RDate サービス年月 = new RDate("201504");
//        RString 整理番号 = new RString("123456");
//        
//        // KaigoAtenaInfo  「介護宛名情報」共有子Divの初期化
////        div.getPanelCcd().getCcdKaigoAtenaInfo().load(識別コード);
//        
//        // KaigoShikakuKihon 「介護資格系基本情報」共有子Div の初期化(这个entity中的load方法没写)
//        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
////            div.getPanelCcd().getCcdKaigoShikakuKihon().load(LasdecCode.EMPTY, 識別コード);
//        } else {
//            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
//        }
//        div.getPanelTwo().getBtnShokanbariKeteiInfo().setDisabled(true);
//        div.getPanelTwo().getTxtServiceTeikyoYM().setDomain(new RYearMonth(entity.getサービス年月()));
//        div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
////        div.getCcdShokanbaraiketteiJoho().load(被保険者番号, サービス年月, 整理番号);
////        int count = div.getCcdShokanbaraiketteiJoho().get件数();
////        if(count == 0) {
////            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
////        }
        return ResponseData.of(div).respond();
    }
    
    /**
     * 申請情報ボタンを押下した際に実行します.
     * @param div
     * @return 
     */
    public ResponseData<ShokanbarayiKeteiInfoDiv> onClick_btnShinsei(ShokanbarayiKeteiInfoDiv div) {
        //getHandler(div).btnKihonInfo();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 口座情報ボタンを押下した際に実行します.
     * @param div
     * @return 
     */
    public ResponseData<ShokanbarayiKeteiInfoDiv> onClick_btnKouza(ShokanbarayiKeteiInfoDiv div) {
        //getHandler(div).btnKihonInfo();
        return ResponseData.of(div).respond();
    }
    /**
     * サービス提供証明書ボタンを押下した際に実行します.
     * @param div
     * @return 
     */
    public ResponseData<ShokanbarayiKeteiInfoDiv> onClick_btnServiceTeikyoShomeisyo(ShokanbarayiKeteiInfoDiv div) {
        //getHandler(div).btnKihonInfo();
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
