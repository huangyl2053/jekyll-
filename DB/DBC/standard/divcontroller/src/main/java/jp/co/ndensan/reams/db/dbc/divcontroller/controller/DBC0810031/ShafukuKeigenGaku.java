/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0810031;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.shafukukeigengaku.ShafukuKeigenGakuRealtEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810031.ShafukuKeigenGakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810031.ShafukuKeigenGakuHandler;
import jp.co.ndensan.reams.db.dbc.service.core.relate.shafukukeigengaku.ShafukuKeigenGakuFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * 償還払い状況照会_社福軽減額画面クラスです。
 */
public class ShafukuKeigenGaku {

    /**
     * 償還払い状況照会_社福軽減額画面を画面初期化処理しました。
     *
     * @param div 社福軽減額画面Div
     * @return response
     */
    public ResponseData<ShafukuKeigenGakuDiv> onLoad(ShafukuKeigenGakuDiv div) {
        div.getPanelShakaiFukushiShokai().setVisible(false);
        List<ShafukuKeigenGakuRealtEntity> shafukuKeigenGakuList = ShafukuKeigenGakuFinder.createInstance().getAll();
        getHandler(div).initialize(shafukuKeigenGakuList);
        return ResponseData.of(div).respond();
    }

    /**
     * 基本情報ボタンを押下した際に実行します。<br/>
     * DBC0810021_基本情報画面へ遷移する
     *
     * @param div {@link ShafukuKeigenGakuDiv 社福軽減額画面Div}
     * @return 社福軽減額画面Divを持つResponseData
     */
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnKihonInfo(ShafukuKeigenGakuDiv div) {
        // TODO DBC0810021_基本情報画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnKihonInfo();
        return ResponseData.of(div).respond();
    }

    /**
     * 特定診療費ボタンを押下した際に実行します。<br/>
     * DBC0810023_特定診療費画面へ遷移する
     *
     * @param div {@link ShafukuKeigenGakuDiv 社福軽減額画面Div}
     * @return 社福軽減額画面Divを持つResponseData
     */
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnTokuteiShinryohi(ShafukuKeigenGakuDiv div) {
        // TODO DBC0810023_特定診療費画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnTokuteiShinryohi();
        return ResponseData.of(div).respond();
    }

    /**
     * サービス計画費ボタンを押下した際に実行します。<br/>
     * DBC0810024_サービス計画費画面へ遷移する
     *
     * @param div {@link ShafukuKeigenGakuDiv 社福軽減額画面Div}
     * @return 社福軽減額画面Divを持つResponseData
     */
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnServiceKeikakuhi(ShafukuKeigenGakuDiv div) {
        // TODO DBC0810024_サービス計画費画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnServiceKeikakuhi();
        return ResponseData.of(div).respond();
    }

    /**
     * 特定入所者費用ボタンを押下した際に実行します。<br/>
     * DBC0810025_特定入所者費用画面へ遷移する
     *
     * @param div {@link ShafukuKeigenGakuDiv 社福軽減額画面Div}
     * @return 社福軽減額画面Divを持つResponseData
     */
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnTokuteiNyushosya(ShafukuKeigenGakuDiv div) {
        // TODO DBC0810025_特定入所者費用画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnTokuteiNyushosya();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計情報ボタンを押下した際に実行します。<br/>
     * DBC0810026_合計情報画面へ遷移する
     *
     * @param div {@link ShafukuKeigenGakuDiv 社福軽減額画面Div}
     * @return 社福軽減額画面Divを持つResponseData
     */
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnGoukeiInfo(ShafukuKeigenGakuDiv div) {
        // TODO DBC0810026_合計情報画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnGoukeiInfo();
        return ResponseData.of(div).respond();
    }

    /**
     * 緊急時施設療養費ボタンを押下した際に実行します。<br/>
     * DBC0810027_緊急時施設療養費画面へ遷移する
     *
     * @param div {@link ShafukuKeigenGakuDiv 社福軽減額画面Div}
     * @return 社福軽減額画面Divを持つResponseData
     */
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnKinkyujiShisetsuRyoyo(ShafukuKeigenGakuDiv div) {
        // TODO DBC0810027_緊急時施設療養費画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnKinkyujiShisetsuRyoyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 食事費用ボタンを押下した際に実行します。<br/>
     * DBC0810029_食事費用画面へ遷移する
     *
     * @param div {@link ShafukuKeigenGakuDiv 社福軽減額画面Div}
     * @return 社福軽減額画面Divを持つResponseData
     */
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnShokujiHiyo(ShafukuKeigenGakuDiv div) {
        // TODO DBC0810029_食事費用画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnShokujiHiyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 請求額集計ボタンを押下した際に実行します。<br/>
     * DBC0810030_請求額集計画面へ遷移する
     *
     * @param div {@link ShafukuKeigenGakuDiv 社福軽減額画面Div}
     * @return 社福軽減額画面Divを持つResponseData
     */
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnSeikyugakuShukei(ShafukuKeigenGakuDiv div) {
        // TODO DBC0810030_請求額集計画面機能から提供されたら対応可能。2015/11/26
        //getHandler(div).btnSeikyugakuShukei();
        return ResponseData.of(div).respond();
    }

    /**
     * 給付費明細(住所地特例)ボタンを押下した際に実行します。<br/>
     * DBC0810032_給付費明細(住所地特例)画面へ遷移する
     *
     * @param div {@link ShafukuKeigenGakuDiv 社福軽減額画面Div}
     * @return 社福軽減額画面Divを持つResponseData
     */
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnKyufuhiMeisaiJyuchi(ShafukuKeigenGakuDiv div) {
        // TODO DBC0810032_給付費明細(住所地特例)画面機能から提供されたら対応可能。2015/11/26
        // getHandler(div).btnKyufuhiMeisaiJyuchi();
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じるボタンを押下した際に実行します。<br/>
     * 社福軽減額照会パネルを閉じる
     *
     * @param div {@link ShafukuKeigenGakuDiv 社福軽減額画面Div}
     * @return 社福軽減額画面Divを持つResponseData
     */
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnClose(ShafukuKeigenGakuDiv div) {
        div.getPanelShakaiFukushiShokai().setVisible(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンを押下した際に実行します。<br/>
     * 社福軽減額一覧グリッドを選択じる
     *
     * @param div {@link ShafukuKeigenGakuDiv 社福軽減額画面Div}
     * @return 社福軽減額画面Divを持つResponseData
     */
    public ResponseData<ShafukuKeigenGakuDiv> onClick_selectButton(ShafukuKeigenGakuDiv div) {
        div.getPanelShakaiFukushiShokai().setVisible(true);
        getHandler(div).selectButton();
        return ResponseData.of(div).respond();
    }

    private ShafukuKeigenGakuHandler getHandler(ShafukuKeigenGakuDiv div) {
        return new ShafukuKeigenGakuHandler(div);
    }
}
