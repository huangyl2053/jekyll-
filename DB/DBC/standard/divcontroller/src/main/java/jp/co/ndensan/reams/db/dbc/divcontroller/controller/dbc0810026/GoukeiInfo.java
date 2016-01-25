/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0810026;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810026.GoukeiInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810026.GoukeiInfoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author yebangqiang
 */
public class GoukeiInfo {
    
    public  ResponseData<GoukeiInfoDiv> onLoad(GoukeiInfoDiv div) {
//        // TODO 凌護行 共有子Divデータがない、
//        // サービス提供証明書画面ViewStateより、引き継ぎデータEntityを取得する
//        FalseEntity entity = new FalseEntity();
//        //                = ViewStateHolder.get(DAViewStateKeys.KokuhoShikakuIdo.国保資格異動情報, FalseEntity.class);
//        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("125636"));
//        //                        = ViewStateHolder.get(DAViewStateKeys.KokuhoShikakuIdo.国保資格異動情報, ShikibetsuCode.class);
//        HihokenshaNo 様式番号 = new HihokenshaNo("1");
//        //                   = ViewStateHolder.get(DAViewStateKeys.KokuhoShikakuIdo.国保資格異動情報, HihokenshaNo.class);
//        RDate  申請日 = new RDate("1");
//        //           = ViewStateHolder.get(DAViewStateKeys.KokuhoShikakuIdo.国保資格異動情報, HihokenshaNo.class);         
//        RString 被保険者番号 = entity.get被保険者番号();
//        // KaigoAtenaInfo  「介護宛名情報」共有子Divの初期化
////        div.getPanelCcd().getCcdKaigoAtenaInfo().load(識別コード);
//        
//        // KaigoShikakuKihon 「介護資格系基本情報」共有子Div の初期化(这个entity中的load方法没写)
//        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
////            div.getPanelCcd().getCcdKaigoShikakuKihon().load(LasdecCode.EMPTY, 識別コード);
//        } else {
//            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
//        }
//        List<DbT3038ShokanKihonEntity> shokanKihonList = new ArrayList();
////                business.getShokanbarayiSeikyukihonDetail(被保険者番号, entity.getサービス年月(), entity.get整理番号(), entity.get事業者番号(), entity.get明細番号(),様式番号);
//        if (shokanKihonList == null || shokanKihonList.size() == 0) {
//            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
//        }
//        List<DbT3043ShokanShokujiHiyoEntity> shokanShokujiHiyoList = new ArrayList();
////                business.getSeikyuShokujiHiyoTanjyunSearch(被保険者番号, entity.getサービス年月(), entity.get整理番号(), entity.get事業者番号(), entity.get明細番号(),様式番号);
//        getHandler(div).initialize(shokanKihonList, shokanShokujiHiyoList);
//        div.getPanelHead().getTxtServiceTeikyoYM().setDomain(new RYearMonth(entity.getサービス年月()));
//        div.getPanelHead().getTxtShinseiYMD().setValue(申請日);
//        div.getPanelHead().getTxtJigyoshaBango().setValue(entity.get事業者番号());
//        div.getPanelHead().getTxtMeisaiBango().setValue(entity.get明細番号());
//        div.getPanelHead().getTxtShomeisho().setValue(entity.get証明書());
//          
//        // 调用别人用的business里面的方法；
////        ShikibetsuNoKanri shikibetsuNoKanri = business.getShikibetsubangoKanri(entity.getサービス年月(), 様式番号);
//        getHandler(div).setボタン表示制御処理();
        
        return ResponseData.of(div).respond();        
    }
    
     /**
     * 基本情報ボタンを押下した際に実行します。
     * @param div 
     * @return  
     */
    public ResponseData<GoukeiInfoDiv> onClick_btnKihonInfo(GoukeiInfoDiv div) {
        // TODO DBC0810021_基本情報画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnKihonInfo();
        return ResponseData.of(div).respond();
    }
    
     /**
     * 給付費明細ボタンを押下した際に実行します。
     * @param div 
     * @return  
     */
    public ResponseData<GoukeiInfoDiv> onClick_btnKyufuhiMeisai(GoukeiInfoDiv div) {
        // TODO DBC0810021_基本情報画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnKihonInfo();
        return ResponseData.of(div).respond();
    }

    /**
     * 特定診療費ボタンを押下した際に実行します。
     * @param div 
     * @return 
     */
    public ResponseData<GoukeiInfoDiv> onClick_btnTokuteiShinryohi(GoukeiInfoDiv div) {
        // TODO DBC0810023_特定診療費画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnTokuteiShinryohi();
        return ResponseData.of(div).respond();
    }

    /**
     * サービス計画費ボタンを押下した際に実行します。
     * @param div
     * @return 
     */
    public ResponseData<GoukeiInfoDiv> onClick_btnServiceKeikakuhi(GoukeiInfoDiv div) {
        // TODO DBC0810024_サービス計画費画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnServiceKeikakuhi();
        return ResponseData.of(div).respond();
    }

    /**
     * 特定入所者費用ボタンを押下した際に実行します。
     * @param div 
     * @return
     */
    public ResponseData<GoukeiInfoDiv> onClick_btnTokuteiNyushosya(GoukeiInfoDiv div) {
        // TODO DBC0810025_特定入所者費用画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnTokuteiNyushosya();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 給付費明細(住所地特例)ボタンを押下した際に実行します。
     * @param div 
     * @return 
     */
    public ResponseData<GoukeiInfoDiv> onClick_btnKyufuhiMeisaiJyuchi(GoukeiInfoDiv div) {
        // TODO DBC0810032_給付費明細(住所地特例)画面機能から提供されたら対応可能。2015/11/26
        // getHandler(div).btnKyufuhiMeisaiJyuchi();
        return ResponseData.of(div).respond();
    }

    /**
     * 緊急時施設療養費ボタンを押下した際に実行します。
     * @param div
     * @return
     */
    public ResponseData<GoukeiInfoDiv> onClick_btnKinkyujiShisetsuRyoyo(GoukeiInfoDiv div) {
        // TODO DBC0810027_緊急時施設療養費画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnKinkyujiShisetsuRyoyo();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 緊急時・所定疾患ボタンを押下した際に実行します。
     * @param div
     * @return
     */
    public ResponseData<GoukeiInfoDiv> onClick_btnKinkyujiShoteiShikkan(GoukeiInfoDiv div) {
        // TODO DBC0810027_緊急時施設療養費画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnKinkyujiShisetsuRyoyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 食事費用ボタンを押下した際に実行します。
     * @param div
     * @return
     */
    public ResponseData<GoukeiInfoDiv> onClick_btnShokujiHiyo(GoukeiInfoDiv div) {
        // TODO DBC0810029_食事費用画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnShokujiHiyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 請求額集計ボタンを押下した際に実行します。
     * @param div 
     * @return
     */
    public ResponseData<GoukeiInfoDiv> onClick_btnSeikyugakuShukei(GoukeiInfoDiv div) {
        // TODO DBC0810030_請求額集計画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnSeikyugakuShukei();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 社福軽減額ボタンを押下した際に実行します。
     * @param div 
     * @return
     */
    public ResponseData<GoukeiInfoDiv> onClick_btnShafukukeigengaku(GoukeiInfoDiv div) {
        // TODO DBC0810030_請求額集計画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnSeikyugakuShukei();
        return ResponseData.of(div).respond();
    }
    
    /**
     * サービス提供証明書へ戻るボタンを押下した際に実行します。
     * @param div 
     * @return
     */
    public ResponseData<GoukeiInfoDiv> onClick_btnBack(GoukeiInfoDiv div) {
        // TODO DBC0810030_請求額集計画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnSeikyugakuShukei();
        return ResponseData.of(div).respond();
    }

    
    private GoukeiInfoHandler getHandler(GoukeiInfoDiv div) {
        return new GoukeiInfoHandler(div);
    }
}
