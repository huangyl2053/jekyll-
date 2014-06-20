/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceSearchDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービス計画検索のクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuServiceSearch {

    /**
     * 画面ロード時の処理。
     *
     * @param panel
     * @return ResponseData
     */
    public ResponseData getOnLoad(KyotakuServiceSearchDiv panel) {
        ResponseData<KyotakuServiceSearchDiv> response = new ResponseData<>();
        // TODO N8187 久保田英男 デモ用に初期値を設定。デモ後に削除する。
        panel.getTxtSearchName().setValue(new RString("電算 太郎"));
        panel.getTxtSearchHihokenshaNo().setValue(new RString("99999"));
        panel.getTxtSearchShokisaiHokenshaNo().setValue(new RString("123456"));
        response.data = panel;

        return response;
    }

    /**
     * 検索ボタン押下時の処理。
     *
     * @param panel
     * @return ResponseData
     */
    public ResponseData onClick_SearchIchiran(KyotakuServiceSearchDiv panel) {
        // TODO N8187 久保田英男 DB検索処理を実装する。 デモ後に対応
        ResponseData<KyotakuServiceSearchDiv> response = new ResponseData<>();
        response.data = panel;

        return response;
    }
}
