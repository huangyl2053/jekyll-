/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBE9040001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.mainPanelDiv;
import jp.co.ndensan.reams.db.dbe.service.core.konicho.KoNiChoManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 一次判定結果をダイアログ使用する際の処理を表します。
 *
 * @author N1013 松本直樹
 */
public class mainPanel {

    private KoNiChoManager service;

    /**
     * コンストラクタです。
     *
     */
    public mainPanel() {
        service = KoNiChoManager.createInstance();

    }

    /**
     * サービスコード検索一覧初期化の設定します。
     *
     * @param div IchijiHanteiKekkaInfoDiv
     * @return ResponseData
     */
    public ResponseData<mainPanelDiv> initialize(mainPanelDiv div) {

//        getHandler(div).onClick_クリア();
//        getHandler(div).initialize();
        return ResponseData.of(div).respond();

    }

    /**
     * ボタン押下で検索条件入力項目をクリアするの設定します。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_クリア(mainPanelDiv div) {
        ResponseData<mainPanelDiv> response = new ResponseData<>();

        //getHandler(div).onClick_クリア();
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン押下で検索条件に従い、調査員情報を検索する。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_ボタン検索(mainPanelDiv div) {

        // getHandler(div).onClick_ボタン検索();
        return ResponseData.of(div).respond();
    }

    /**
     * 追加ボタンが押下され、調査員情報を追加する。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_ボタン追加(mainPanelDiv div) {
        // getHandler(div).onClick_ボタン追加();
        return ResponseData.of(div).respond();
    }

    /**
     * 修正アイコンを押下、調査員情報を修正する。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_ボタン修正(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 削除アイコンを押下、調査員情報を削除する。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_ボタン削除(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 行ダブルクリック、選択行の内容を検索する。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_一覧行選択検索(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン押下、ＣＳＶを出力する。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_ＣＳＶを出力(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 入力した市町村コードにして市町村名を取得する。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_市町村名を取得(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村選択ダイアログを表示する
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_市町村検索ダイアログ表示(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 入力した調査委託先コードにして調査委託先名を取得する。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_調査委託先名を取得(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先選択ダイアログを表示する.
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_調査委託先検索ダイアログ表示(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 入力した地区コードにして地区名を取得する。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_地区名を取得(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 地区選択ダイアログを表示する。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_地区検索ダイアログ表示(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 取消ボタン押下、調査員一覧エリアへ戻る画面が「一覧照会状態」よりを表示する。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_ボタン取消(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「確定する」ボタン押下場合、調査員一覧に反映させる。。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_ボタン確定(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 共通ボタンので、共通処理を行う。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_ボタン終了(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 共通ボタンので、共通処理を行う。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_ボタン中断(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先登録へ戻るする。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_ボタン登録へ戻る(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 調査員検索、「画面初期化」へ戻る。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_ボタン再検索(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 保存ボタン押下、入力データをＤＢに保存する。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<mainPanelDiv> onClick_ボタン保存(mainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

//    private KoNiChoHandler getHandler(mainPanelDiv div) {
//        return new KoNiChoHandler(div);
//    }
}
