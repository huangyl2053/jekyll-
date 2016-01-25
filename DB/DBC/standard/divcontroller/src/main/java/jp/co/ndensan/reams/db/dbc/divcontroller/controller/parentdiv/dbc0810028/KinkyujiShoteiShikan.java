/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810028;

import jp.co.ndensan.reams.db.dbc.business.TestEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810028.KinkyujiShoteiShikanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810028.KinkyujiShoteiShikanHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い状況照会_緊急時・所定疾患画面クラスです
 *
 * @author XuPeng
 */
public class KinkyujiShoteiShikan {

    /**
     * 償還払い状況照会_緊急時・所定疾患画面初期化する
     *
     * @param div 緊急時・所定疾患画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onLoad(KinkyujiShoteiShikanDiv div) {
        TestEntity entity = new TestEntity();
        RString 申請書検索ViewSate_様式番号 = new RString("123");
        //介護宛名情報」共有子Divの初期化
//        div.getPanelCcd().getCcdKaigoAtenaInfo().load(entity.get識別コード());
        //介護資格系基本情報」共有子Div の初期化
        if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()) {
//            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(entity.get被保険者番号()被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoAtenaInfo().setVisible(false);
        }
        KinkyujiShoteiShikanHandler handler = getHandler(div);
        handler.initPanelHead(entity.getサービス年月(),
                entity.get申請日(),
                entity.get事業者番号(),
                entity.get明細番号(),
                entity.get証明書(),
                申請書検索ViewSate_様式番号);
        handler.initList();
        //償還払請求所定疾患施設療養費等データ取得
//        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
//        List<ShokanShoteiShikkanShisetsuRyoyo> businessList = finder.getKinkyujiShisetsuRyoyoData1(
//                entity.get被保険者番号(),
//                entity.getサービス年月(),
//                entity.get整理番号(),
//                entity.get事業者番号(),
//                entity.get様式番号(),
//                entity.get明細番号(),
//                null);
//        if (businessList == null || businessList.isEmpty()) {
//            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
//        }
//        handler.initDgdKinkyujiShoteiList(businessList);
//        ShikibetsuNoKanriEntity 識別番号 = finder.getShikibetsubangoKanri(entity.getサービス年月(),
//                ViewStateHolder.get(ViewStateKeys.償還払申請一覧_様式番号, RString.class));
//        handler.setボタン表示制御処理(識別番号, entity.getサービス年月());
        return ResponseData.of(div).respond();
    }

    /**
     * 基本情報ボタンを押下した際に実行します。<br/>
     * DBC0810021_基本情報画面へ遷移する
     *
     * @param div {@link KinkyujiShoteiShikanDiv 緊急時・所定疾患画面Div}
     * @return 緊急時・所定疾患画面Divを持つResponseData
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnKihonInfo(KinkyujiShoteiShikanDiv div) {
        // TODO DBC0810021_基本情報画面機能から提供されたら対応可能。
        //getHandler(div).btnKihonInfo();
        return ResponseData.of(div).respond();
    }

    /**
     * 特定診療費ボタンを押下した際に実行します。<br/>
     * DBC0810023_特定診療費画面へ遷移する
     *
     * @param div {@link KinkyujiShoteiShikanDiv 緊急時・所定疾患画面Div}
     * @return 緊急時・所定疾患画面Divを持つResponseData
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnTokuteiShinryohi(KinkyujiShoteiShikanDiv div) {
        // TODO DBC0810023_特定診療費画面機能から提供されたら対応可能
        //getHandler(div).btnTokuteiShinryohi();
        return ResponseData.of(div).respond();
    }

    /**
     * サービス計画費ボタンを押下した際に実行します。<br/>
     * DBC0810024_サービス計画費画面へ遷移する
     *
     * @param div {@link KinkyujiShoteiShikanDiv 緊急時・所定疾患画面Div}
     * @return 緊急時・所定疾患画面Divを持つResponseData
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnServiceKeikakuhi(KinkyujiShoteiShikanDiv div) {
        // TODO DBC0810024_サービス計画費画面機能から提供されたら対応可能
        //getHandler(div).btnServiceKeikakuhi();
        return ResponseData.of(div).respond();
    }

    /**
     * 特定入所者費用ボタンを押下した際に実行します。<br/>
     * DBC0810025_特定入所者費用画面へ遷移する
     *
     * @param div {@link KinkyujiShoteiShikanDiv 緊急時・所定疾患画面Div}
     * @return 緊急時・所定疾患画面Divを持つResponseData
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnTokuteiNyushosya(KinkyujiShoteiShikanDiv div) {
        // TODO DBC0810025_特定入所者費用画面機能から提供されたら対応可能。
        //getHandler(div).btnTokuteiNyushosya();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計情報ボタンを押下した際に実行します。<br/>
     * DBC0810026_合計情報画面へ遷移する
     *
     * @param div {@link KinkyujiShoteiShikanDiv 緊急時・所定疾患画面Div}
     * @return 緊急時・所定疾患画面Divを持つResponseData
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnGoukeiInfo(KinkyujiShoteiShikanDiv div) {
        // TODO DBC0810026_合計情報画面機能から提供されたら対応可能
        //getHandler(div).btnGoukeiInfo();
        return ResponseData.of(div).respond();
    }

    /**
     * 給付費明細(住所地特例)ボタンを押下した際に実行します。<br/>
     * DBC0810032_給付費明細(住所地特例)画面へ遷移する
     *
     * @param div {@link KinkyujiShoteiShikanDiv 緊急時・所定疾患画面Div}
     * @return 緊急時・所定疾患画面Divを持つResponseData
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnKyufuhiMeisaiJyuchi(KinkyujiShoteiShikanDiv div) {
        // DBC0810032_給付費明細(住所地特例)画面へ遷移する
        return ResponseData.of(div).respond();
    }

    /**
     * 食事費用ボタンを押下した際に実行します。<br/>
     * DBC0810029_食事費用画面へ遷移する
     *
     * @param div {@link KinkyujiShoteiShikanDiv 緊急時・所定疾患画面Div}
     * @return 緊急時・所定疾患画面Divを持つResponseData
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnShokujiHiyo(KinkyujiShoteiShikanDiv div) {
        // TODO DBC0810029_食事費用画面機能から提供されたら対応可能。
        //getHandler(div).btnShokujiHiyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 請求額集計ボタンを押下した際に実行します。<br/>
     * DBC0810030_請求額集計画面へ遷移する
     *
     * @param div {@link KinkyujiShoteiShikanDiv 緊急時・所定疾患画面Div}
     * @return 緊急時・所定疾患画面Divを持つResponseData
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnSeikyugakuShukei(KinkyujiShoteiShikanDiv div) {
        // TODO DBC0810030_請求額集計画面機能から提供されたら対応可能
        //getHandler(div).btnSeikyugakuShukei();
        return ResponseData.of(div).respond();
    }

    /**
     * 社福軽減額ボタンを押下した際に実行します。<br/>
     * DBC0810031_社福軽減額画面へ遷移する
     *
     * @param div {@link KinkyujiShoteiShikanDiv 緊急時・所定疾患画面Div}
     * @return 緊急時・所定疾患画面Divを持つResponseData
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnShafukukeigenGaku(KinkyujiShoteiShikanDiv div) {
        // DBC0810031_社福軽減額画面へ遷移する
        return ResponseData.of(div).respond();
    }

    /**
     * 「サービス提供証明書へ戻る」ボタン。<br/>
     * DBC0810014_サービス提供証明書画面へ遷移する
     *
     * @param div {@link KinkyujiShoteiShikanDiv 緊急時・所定疾患画面Div}
     * @return 緊急時・所定疾患画面Divを持つResponseData
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnServiceTeikyoShomeisho(KinkyujiShoteiShikanDiv div) {
        // DBC0810014_サービス提供証明書画面へ遷移する
        return ResponseData.of(div).respond();
    }

    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnSelectButton(KinkyujiShoteiShikanDiv div) {
        div.getPanelDetail().setDisplayNone(false);
        TestEntity entity = new TestEntity();
        RString 連番 = div.getDgdKinkyujiShoteiList().getClickedItem().getDefaultDataName8();
//        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
//        List<ShokanShoteiShikkanShisetsuRyoyo> list = finder.getKinkyujiShisetsuRyoyoData1(
//                entity.get被保険者番号(),
//                entity.getサービス年月(),
//                entity.get整理番号(),
//                entity.get事業者番号(),
//                entity.get明細番号(),
//                申請書検索ViewSate_様式番号,
//                連番);
//        getHandler(div).set傷病名(list.get(0));
//        getHandler(div).set往診通院(list.get(0));
//        getHandler(div).set治療点数(list.get(0));
        return ResponseData.of(div).respond();
    }

    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnClose(KinkyujiShoteiShikanDiv div) {
        div.getPanelDetail().setDisplayNone(true);
        return ResponseData.of(div).respond();
    }

    private KinkyujiShoteiShikanHandler getHandler(KinkyujiShoteiShikanDiv div) {
        return KinkyujiShoteiShikanHandler.of(div);
    }
}
