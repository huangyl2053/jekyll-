/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD3010002;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3010002.DBD3010002StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3010002.DBD3010002TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3010002.JukyushaShokaiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD3010002.JukyushaShokaiHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 「受給照会」画面のControllerクラスです。
 *
 * @reamsid_L DBD-3560-010 xuyue
 */
public class JukyushaShokai {

    private static final RString 状態_照会 = new RString("照会");

    /**
     * 受給照会の初期化。(オンロード)
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onLoad(JukyushaShokaiDiv div) {

        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        // TODO こちらのメソッドが呼ばれる前にダイアログのinitializeが実行されている。そのため、識別コードのセットをonloadで行う。フレームワークの対応が完了後修正。
        div.setHiddenShikibetsuCode(識別コード.getColumnValue());

        return getHandler(div).initialize(識別コード, 被保険者番号);
    }

    /**
     * 受給照会の初期化。(オンアクティブ)
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onActive(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();

        return getHandler(div).initialize(識別コード, 被保険者番号);
    }

    /**
     * 「履歴一覧へ戻る」ボタンの処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onClick_btnCommonBackToHistoryList(JukyushaShokaiDiv div) {
        return ResponseData.of(div).setState(DBD3010002StateName.認定履歴一覧);
    }

    /**
     * 一覧の選択ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onClick_btnSelect(JukyushaShokaiDiv div) {
        getHandler(div).選択ボタンをクリック();
        return ResponseData.of(div).setState(DBD3010002StateName.詳細確認);
    }

    /**
     * 「利用減免」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnRiyogenmen(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.setHiddenHihokenshaNo(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「訪問介護」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnHomonKaigo(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.setHiddenHihokenshaNo(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「社福軽減」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnShafukuKeigen(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.setHiddenHihokenshaNo(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「特地減免」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnTochiGemmen(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.setHiddenHihokenshaNo(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「負担限度額」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnFutanGendogaku(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.setHiddenHihokenshaNo(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「所得状況」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnShotokuJokyo(JukyushaShokaiDiv div) {
        // TODO こちらのメソッドが呼ばれる前にダイアログのinitializeが実行されている。そのため、識別コードのセットをonloadで行う。フレームワークの対応が完了後修正。
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        div.setHiddenShikibetsuCode(識別コード.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「非課税年金」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnHikazeiNenkin(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.setHiddenHihokenshaNo(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「滞納状況」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnTainoJokyo(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.setHiddenHihokenshaNo(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「生活保護」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnSeikatsuHogo(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        div.setHiddenShikibetsuCode(識別コード.getColumnValue());
        div.setHiddenGyomuCode(GyomuCode.DB介護保険.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「老齢福祉」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnRoreiFukushi(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.setHiddenHihokenshaNo(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「医療保険」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnIryoHoken(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        div.setHiddenモード(状態_照会);
        div.setHiddenShikibetsuCode(識別コード.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「施設入退」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnShisetsuNyutai(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        div.setHiddenShikibetsuCode(識別コード.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「居宅計画」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnKyotakuKeikaku(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.setHiddenHihokenshaNo(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「事業対象者」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnJigyouTaishosha(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.setHiddenHihokenshaNo(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 調査状況ボタン用のデータを準備する
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<JukyushaShokaiDiv> onBeforeOpenDialog_btnChosaJokyo(JukyushaShokaiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.setHiddenHihokenshaNo(被保険者番号.getColumnValue());
        getHandler(div).onBeforeOpenDialog_btnChosaJokyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索結果一覧へ」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onClick_btnBatchToSearchResult(JukyushaShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBD3010002TransitionEventName.検索結果一覧に戻る).respond();
    }

    /**
     * 「再検索する」ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> onClick_btnCommonBackToSearch(JukyushaShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBD3010002TransitionEventName.検索に戻る).respond();
    }

    private JukyushaShokaiHandler getHandler(JukyushaShokaiDiv div) {
        return new JukyushaShokaiHandler(div);
    }

}
