/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.DBZ5100001;

import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseishafinder.NinteiShinseishaFinderParameter;
import jp.co.ndensan.reams.db.dbz.business.core.shinseikensaku.ShinseiKensakuBusiness;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shinseikensaku.ShinseiKensakuMapperParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ5100001.DBZ5100001StateName;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ5100001.DBZ5100001TransitionEventName;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ5100001.KaigoNinteiShinseiKensakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ5100001.dgShinseiJoho_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ5100001.KaigoNinteiShinseiKensakuHandler;
import jp.co.ndensan.reams.db.dbz.service.core.shinseikensaku.ShinseiKensakuFinder;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 要介護認定申請情報検索クラスです。
 *
 * @reamsid_L DBZ-1300-150 houtianpeng
 */
public class KaigoNinteiShinseiKensaku {

    private final RString 認定メニュー = new RString("DBEUC10101");
    private final RString DBEUC55101 = new RString("DBEUC55101");
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
    private final RString 要介護認定申請認定_新規更新 = new RString("DBDUC50201");
    private final RString 要介護認定申請認定_サービス種類変更 = new RString("DBDUC55105");
    private final RString 要介護認定申請認定_区分変更 = new RString("DBDUC55103");
    private static final RString 認定審査者検索用共有子Div被保険者番号コントロールID = new RString("ccdNinteishinseishaFinder_txtHihokenshaNumber");

    /**
     * コンストラクタです。
     *
     */
    public KaigoNinteiShinseiKensaku() {
    }

    /**
     * 初期化します。
     *
     * @param div KaigoNinteiShinseiKensakuDiv
     * @return ResponseData<KaigoNinteiShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onLoad(KaigoNinteiShinseiKensakuDiv div) {
        KaigoNinteiShinseiKensakuHandler handler = getHandler(div);
        NinteiShinseishaFinderParameter parameter = create検索条件parameter();
        div.getCcdNinteishinseishaFinder().initialize(parameter);
        handler.initialize(
                get検索制御最大取得件数上限(),
                get検索制御最大取得件数(),
                get戻るボタン表示可否(),
                false,
                false);
        return ResponseData.of(div).focusId(認定審査者検索用共有子Div被保険者番号コントロールID).respond();
    }

    /**
     * 検索条件クリア処理です。
     *
     * @param div ShinseiKensakuDiv
     * @return ResponseData<ShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onClick_btnClear(KaigoNinteiShinseiKensakuDiv div) {
        NinteiShinseishaFinderParameter parameter = create検索条件parameter();
        div.getCcdNinteishinseishaFinder().initialize(parameter);
        return ResponseData.of(div).respond();
    }

    /**
     * 検索処理です。
     *
     * @param div ShinseiKensakuDiv
     * @return ResponseData<ShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onClick_btnKensaku(KaigoNinteiShinseiKensakuDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        KaigoNinteiShinseiKensakuHandler handler = getHandler(div);
        ShinseiKensakuMapperParameter parameter = handler.createMapperParameter();
        SearchResult< ShinseiKensakuBusiness> 検索結果
                = (get業務分類() == GyomuBunrui.介護事務) ? search受給(parameter)
                : (get業務分類() == GyomuBunrui.介護認定) ? search認定(parameter)
                : null;
        if (検索結果 == null || 検索結果.records().isEmpty()) {
            handler.clearSearchResult();
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        handler.bindSearchResult(検索結果);
        if (検索結果.records().size() == 1) {
            dgShinseiJoho_Row row = handler.get先頭レコード();
            handler.add最近処理者(row);
            setViewState対象内容(row);
            return ResponseData.of(div).forwardWithEventName(DBZ5100001TransitionEventName.検索結果選択).respond();
        }
        return ResponseData.of(div).setState(DBZ5100001StateName.検索結果一覧);
    }

    /**
     * 最近処理者の「表示する」を押下した時の処理です。
     *
     * @param div ShinseiKensakuDiv
     * @return ResponseData<ShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onSaikinshorishaClick(KaigoNinteiShinseiKensakuDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = div.getCcdNinteishinseishaFinder().getSaikinShorishaDiv().validate();
        if (pairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        KaigoNinteiShinseiKensakuHandler handler = getHandler(div);
        ShinseiKensakuMapperParameter parameter = handler.createMapperParameter最近処理者();
        SearchResult<ShinseiKensakuBusiness> 検索結果
                    = (get業務分類() == GyomuBunrui.介護事務) ? search受給(parameter)
                    : (get業務分類() == GyomuBunrui.介護認定) ? search認定(parameter)
                    : null;
        if (検索結果 == null || 検索結果.records().isEmpty()) {
            handler.clearSearchResult();
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        handler.bindSearchResult(検索結果);
        if (検索結果.records().size() == 1) {
            dgShinseiJoho_Row row = handler.get先頭レコード();
            handler.add最近処理者(row);
            setViewState対象内容(row);
            return ResponseData.of(div).forwardWithEventName(DBZ5100001TransitionEventName.検索結果選択).respond();
        }
        return ResponseData.of(div).setState(DBZ5100001StateName.検索結果一覧);
    }

    /**
     * 申請一覧の「選択」ボタン処理です。
     *
     * @param div ShinseiKensakuDiv
     * @return ResponseData<ShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onSelect_dgShinseiJoho(KaigoNinteiShinseiKensakuDiv div) {
        KaigoNinteiShinseiKensakuHandler handler = getHandler(div);
        dgShinseiJoho_Row row = handler.get選択レコード();
        setViewState対象内容(row);
        return ResponseData.of(div).forwardWithEventName(DBZ5100001TransitionEventName.検索結果選択).respond();
    }

    /**
     * 「戻る」ボタン処理です。「要介護認定進捗データ出力画面へ戻る」
     *
     * @param div ShinseiKensakuDiv
     * @return ResponseData<ShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onClick_btnBack(KaigoNinteiShinseiKensakuDiv div) {
        clearViewState対象内容();
        return ResponseData.of(div).forwardWithEventName(DBZ5100001TransitionEventName.戻る).respond();
    }

    private SearchResult<ShinseiKensakuBusiness> search受給(ShinseiKensakuMapperParameter parameter) {
        ShinseiKensakuFinder finder = ShinseiKensakuFinder.createInstance();
        return finder.search受給(parameter);
    }
    
    private SearchResult<ShinseiKensakuBusiness> search認定(ShinseiKensakuMapperParameter parameter) {
        ShinseiKensakuFinder finder = ShinseiKensakuFinder.createInstance();
            return finder.search認定(parameter);
    }

    private void setViewState対象内容(dgShinseiJoho_Row row) {
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, KaigoNinteiShinseiKensakuHandler.get選択申請書管理番号(row));
        ViewStateHolder.put(ViewStateKeys.被保険者番号, KaigoNinteiShinseiKensakuHandler.get選択被保険者番号(row));
    }

    private void clearViewState対象内容() {
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, null);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, null);
    }

//    private void 介護認定申請情報の検索(KaigoNinteiShinseiKensakuDiv div) {
//        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(get業務分類());
//        if (DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())
//                || DonyuKeitaiCode.事務構成市町村.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())
//                || DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())) {
//
//            SearchResult<HokenshaNinteiShinseiJoho> 介護認定申請情報受給 = finder.
//                    get介護認定申請情報受給(getHandler(div).介護認定申請情報受給Parameter());
//            getHandler(div).介護認定申請情報受給_グリッドの設定(介護認定申請情報受給);
//        } else if (DonyuKeitaiCode.認定広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())
//                || DonyuKeitaiCode.認定単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())) {
//
//            SearchResult<NinteiShinseiJoho> 介護認定申請情報認定 = finder.
//                    get介護認定申請情報認定(getHandler(div).介護認定申請情報認定Parameter());
//            getHandler(div).介護認定申請情報認定_グリッドの設定(介護認定申請情報認定);
//        }
//    }
    private GyomuBunrui get業務分類() {

        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString uiContainerId = controlData.getUIContainerId();
        if (認定メニュー.equals(uiContainerId) || DBEUC55101.equals(uiContainerId)) {
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
                || get受給の判定(uiContainerId)) {

            return GyomuBunrui.介護事務;
        }
        return null;
    }

    private boolean get受給の判定(RString uiContainerId) {

        return 要介護認定申請却下.equals(uiContainerId)
                || 要介護認定申請受付新規.equals(uiContainerId)
                || 要介護認定申請受付更新.equals(uiContainerId)
                || 要介護認定申請受付区分変更.equals(uiContainerId)
                || 要介護認定申請受付サービス種類変更.equals(uiContainerId)
                || 職権記載.equals(uiContainerId)
                || 職権取消全喪失.equals(uiContainerId)
                || 受給者転入.equals(uiContainerId)
                || 要介護認定申請認定_新規更新.equals(uiContainerId)
                || 要介護認定申請認定_サービス種類変更.equals(uiContainerId)
                || 要介護認定申請認定_区分変更.equals(uiContainerId);
    }

    private NinteiShinseishaFinderParameter create検索条件parameter() {
        NinteiShinseishaFinderParameter parameter = new NinteiShinseishaFinderParameter();
        parameter.set業務分類(get業務分類());
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString uiContainerId = controlData.getUIContainerId();
        if (!DBEUC55101.equals(uiContainerId)) {
            parameter.setCheckedみなし2号申請(true);
        }
        if (DBEUC55101.equals(uiContainerId)) {
            parameter.set月例処理未完了(true);
        }
        ShoKisaiHokenshaNo 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);
        if (証記載保険者番号 != null && !証記載保険者番号.isEmpty()) {
            parameter.set証記載保険者番号(証記載保険者番号);
        }

        return parameter;
    }

    private boolean get戻るボタン表示可否() {
        return (get業務分類() != GyomuBunrui.介護事務);
    }

    private Decimal get検索制御最大取得件数上限() {
        RString 検索制御_最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        return new Decimal(検索制御_最大取得件数上限.toString());
    }

    private Decimal get検索制御最大取得件数() {
        RString 検索制御_最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        return new Decimal(検索制御_最大取得件数.toString());
    }

    private KaigoNinteiShinseiKensakuHandler getHandler(KaigoNinteiShinseiKensakuDiv div) {
        return new KaigoNinteiShinseiKensakuHandler(div);
    }

}
