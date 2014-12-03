/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.testshisetsujoho;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TestShisetsuJoho.TestShisetsuJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設情報共有子Divのテスト画面のコントローラクラスです。
 *
 * @author N8187 久保田 英男
 */
public class TestShisetsuJoho {

    /**
     * set台帳種別ボタン押下時の処理です。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSetDaicho(TestShisetsuJohoDiv div) {
        RString key = div.getRadSetDaicho().getSelectedKey();
        div.getCcdShisetsuJoho().set台帳種別(key);

        return createResponse(div);
    }

    /**
     * set施設種類ボタン押下時の処理です。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSetShisetsu(TestShisetsuJohoDiv div) {
        RString key = div.getRadSetShisetsu().getSelectedKey();
        div.getCcdShisetsuJoho().set施設種類(key);

        return createResponse(div);
    }

    /**
     * set入所施設ボタン押下時の処理です。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSetCode(TestShisetsuJohoDiv div) {
        RString code = div.getTxtSetCode().getValue();
        div.getCcdShisetsuJoho().set入所施設コード(code);

        return createResponse(div);
    }

    /**
     * set施設名称ボタン押下時の処理です。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSetMeisho(TestShisetsuJohoDiv div) {
        RString meisho = div.getTxtSetMeisho().getValue();
        div.getCcdShisetsuJoho().set施設名称(meisho);

        return createResponse(div);
    }

    /**
     * get台帳種別ボタン押下時の処理です。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnGetDaicho(TestShisetsuJohoDiv div) {
        RString result = div.getCcdShisetsuJoho().get台帳種別();
        div.getTxtDaicho().setValue(result);

        return createResponse(div);
    }

    /**
     * get台帳キーボタン押下時の処理です。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnGetDaichoKey(TestShisetsuJohoDiv div) {
        RString result = div.getCcdShisetsuJoho().get台帳種別キー();
        div.getTxtDaichoKey().setValue(result);

        return createResponse(div);
    }

    /**
     * get施設種類ボタン押下時の処理です。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnGetShisetsu(TestShisetsuJohoDiv div) {
        RString result = div.getCcdShisetsuJoho().get施設種類();
        div.getTxtShisetsu().setValue(result);

        return createResponse(div);
    }

    /**
     * get施設キーボタン押下時の処理です。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnGetShisetsuKey(TestShisetsuJohoDiv div) {
        RString result = div.getCcdShisetsuJoho().get施設種類キー();
        div.getTxtShisetsuKey().setValue(result);

        return createResponse(div);
    }

    /**
     * get入所施設ボタン押下時の処理です。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnGetCode(TestShisetsuJohoDiv div) {
        RString result = div.getCcdShisetsuJoho().get入所施設コード();
        div.getTxtCode().setValue(result);

        return createResponse(div);
    }

    /**
     * get施設名称ボタン押下時の処理です。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnGetMeisho(TestShisetsuJohoDiv div) {
        RString result = div.getCcdShisetsuJoho().get施設名称();
        div.getTxtMeisho().setValue(result);

        return createResponse(div);
    }

    /**
     * initializeボタン押下時の処理です。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnInitialize(TestShisetsuJohoDiv div) {
        div.getCcdShisetsuJoho().initialize();

        return createResponse(div);
    }

    /**
     * clearボタン押下時の処理です。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnClear(TestShisetsuJohoDiv div) {
        div.getCcdShisetsuJoho().clear();

        return createResponse(div);
    }

    /**
     * set入力可ボタン押下時の処理です。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSetInputEnable(TestShisetsuJohoDiv div) {
        div.getCcdShisetsuJoho().set入力可();

        return createResponse(div);
    }

    /**
     * set入力不可ボタン押下時の処理です。
     *
     * @param div テスト施設情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSetInputDisable(TestShisetsuJohoDiv div) {
        div.getCcdShisetsuJoho().set入力不可();

        return createResponse(div);
    }

    private ResponseData<TestShisetsuJohoDiv> createResponse(TestShisetsuJohoDiv div) {

        ResponseData<TestShisetsuJohoDiv> response = new ResponseData();
        response.data = div;
        return response;
    }

}
