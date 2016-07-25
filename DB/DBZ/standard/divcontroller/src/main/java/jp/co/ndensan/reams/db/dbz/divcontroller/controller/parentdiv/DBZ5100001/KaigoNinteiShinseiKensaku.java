/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.DBZ5100001;

import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HokenshaNinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ5100001.DBZ5100001TransitionEventName;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ5100001.KaigoNinteiShinseiKensakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ5100001.KaigoNinteiShinseiKensakuHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ5100001.KaigoNinteiValidatisonHandler;
import jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteishinseijyohokensaku.YokaigoninteishinseijyohokensakuFinder;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 要介護認定申請情報検索クラスです。
 *
 * @reamsid_L DBZ-1300-150 houtianpeng
 */
public class KaigoNinteiShinseiKensaku {

    private final YokaigoninteishinseijyohokensakuFinder finder;

    private final RString 認定メニュー = new RString("DBEUC10101");
    private final RString 要介護認定申請修正_新規 = new RString("DBDUC51206");
    private final RString 要介護認定申請修正_更新 = new RString("DBDUC51207");
    private final RString 要介護認定申請修正_区分変更 = new RString("DBDUC51208");
    private final RString 要介護認定申請修正_サービス種類変更 = new RString("DBDUC51209");
    private final RString 要介護認定申請取下_新規 = new RString("DBDUC51210");
    private final RString 要介護認定申請取下_更新 = new RString("DBDUC51211");
    private final RString 要介護認定申請取下_区分変更 = new RString("DBDUC51212");
    private final RString 要介護認定申請取下_サービス種類変更 = new RString("DBDUC51213");
    private final RString 要介護認定申請延期 = new RString("DBDUC51214");
    private final RString 要介護認定申請却下 = new RString("DBDUC51215");
    private final RString 要介護認定申請受付新規 = new RString("DBDUC51201");
    private final RString 要介護認定申請受付更新 = new RString("DBDUC51202");
    private final RString 要介護認定申請受付区分変更 = new RString("DBDUC51203");
    private final RString 要介護認定申請受付サービス種類変更 = new RString("DBDUC51204");
    private final RString 職権記載 = new RString("DBDUC51216");
    private final RString 職権取消全喪失 = new RString("DBDUC51217");
    private final RString 受給者転入 = new RString("DBDUC51205");

    private final RString 検索状態 = new RString("検索状態");

    /**
     * コンストラクタです。
     *
     */
    public KaigoNinteiShinseiKensaku() {
        this.finder = YokaigoninteishinseijyohokensakuFinder.createInstance();
    }

    /**
     * 初期化します。
     *
     * @param div KaigoNinteiShinseiKensakuDiv
     * @return ResponseData<KaigoNinteiShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onLoad(KaigoNinteiShinseiKensakuDiv div) {

        getHandler(div).initialize();
        getHandler(div).setJyoTai(get受給と認定の判定(), RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 条件をクリアする。
     *
     * @param div KaigoNinteiShinseiKensakuDiv
     * @return ResponseData<KaigoNinteiShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onClick_btnJokenClear(KaigoNinteiShinseiKensakuDiv div) {
        div.getCcdNinteiShinseishaFinder().initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索ボタン。
     *
     * @param div KaigoNinteiShinseiKensakuDiv
     * @return ResponseData<KaigoNinteiShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onClick_btnSaiKensaku(KaigoNinteiShinseiKensakuDiv div) {
        div.getCcdNinteiShinseishaFinder().initialize();
        getHandler(div).setJyoTai(get受給と認定の判定(), RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 検索ボタンを押下した、DataGridを設定する。
     *
     * @param div KaigoNinteiShinseiKensakuDiv
     * @return ResponseData<KaigoNinteiShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onClick_btnKensaku(KaigoNinteiShinseiKensakuDiv div) {
        // TODO. for test
//        介護認定申請情報の検索(div);
//        ValidationMessageControlPairs validationMessage = getValidatisonHandler(div).データ空のチェック();
//        if (validationMessage.iterator().hasNext()) {
//            return ResponseData.of(div).addValidationMessages(validationMessage).respond();
//        }
//        getHandler(div).setJyoTai(get受給と認定の判定(), 検索状態);
//        return ResponseData.of(div).respond();
        return ResponseData.of(div).forwardWithEventName(DBZ5100001TransitionEventName.検索結果選択).respond();
    }

    /**
     * 検索結果一覧に選択ボタンの処理。
     *
     * @param div KaigoNinteiShinseiKensakuDiv
     * @return ResponseData<KaigoNinteiShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onSelect_dgKensakuKekkaIchiran(KaigoNinteiShinseiKensakuDiv div) {

        ViewStateHolder.put(ViewStateKeys.申請書管理番号, div.getKensakuKekka().
                getDgKensakuKekkaIchiran().getActiveRow().getShinseishoKnriNo());
        GyomuBunrui bunrui = get受給と認定の判定();
        if (GyomuBunrui.介護事務.equals(bunrui)
                || GyomuBunrui.介護認定.equals(bunrui)) {

            return ResponseData.of(div).forwardWithEventName(DBZ5100001TransitionEventName.検索結果選択).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るボタンの処理。
     *
     * @param div KaigoNinteiShinseiKensakuDiv
     * @return ResponseData<KaigoNinteiShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onClick_btnModoru(KaigoNinteiShinseiKensakuDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBZ5100001TransitionEventName.検索結果選択).respond();
    }

    private void 介護認定申請情報の検索(KaigoNinteiShinseiKensakuDiv div) {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(get受給と認定の判定());
        if (DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())
                || DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())) {

            SearchResult<HokenshaNinteiShinseiJoho> 介護認定申請情報受給 = finder.
                    get介護認定申請情報受給(getHandler(div).介護認定申請情報受給Parameter());
            getHandler(div).介護認定申請情報受給_グリッドの設定(介護認定申請情報受給);
        } else if (DonyuKeitaiCode.認定広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())
                || DonyuKeitaiCode.認定単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())) {

            SearchResult<NinteiShinseiJoho> 介護認定申請情報認定 = finder.
                    get介護認定申請情報認定(getHandler(div).介護認定申請情報認定Parameter());
            getHandler(div).介護認定申請情報認定_グリッドの設定(介護認定申請情報認定);
        }
    }

    private GyomuBunrui get受給と認定の判定() {

        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString uiContainerId = controlData.getUIContainerId();
        if (認定メニュー.equals(uiContainerId)) {

            return GyomuBunrui.介護認定;
        }
        if (要介護認定申請修正_新規.equals(uiContainerId)
                || 要介護認定申請修正_更新.equals(uiContainerId)
                || 要介護認定申請修正_区分変更.equals(uiContainerId)
                || 要介護認定申請修正_サービス種類変更.equals(uiContainerId)
                || 要介護認定申請取下_新規.equals(uiContainerId)
                || 要介護認定申請取下_更新.equals(uiContainerId)
                || 要介護認定申請取下_区分変更.equals(uiContainerId)
                || 要介護認定申請取下_サービス種類変更.equals(uiContainerId)
                || 要介護認定申請延期.equals(uiContainerId)
                || 要介護認定申請却下.equals(uiContainerId)
                || 要介護認定申請受付新規.equals(uiContainerId)
                || 要介護認定申請受付更新.equals(uiContainerId)
                || 要介護認定申請受付区分変更.equals(uiContainerId)
                || 要介護認定申請受付サービス種類変更.equals(uiContainerId)
                || 職権記載.equals(uiContainerId)
                || 職権取消全喪失.equals(uiContainerId)
                || 受給者転入.equals(uiContainerId)) {

            return GyomuBunrui.介護事務;
        }
        return null;
    }

    private KaigoNinteiShinseiKensakuHandler getHandler(KaigoNinteiShinseiKensakuDiv div) {
        return new KaigoNinteiShinseiKensakuHandler(div);
    }

    private KaigoNinteiValidatisonHandler getValidatisonHandler(KaigoNinteiShinseiKensakuDiv div) {
        return new KaigoNinteiValidatisonHandler(div);
    }
}
