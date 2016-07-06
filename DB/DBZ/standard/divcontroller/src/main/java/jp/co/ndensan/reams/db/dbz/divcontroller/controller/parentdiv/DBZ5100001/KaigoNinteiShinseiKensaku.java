/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.DBZ5100001;

import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HokenshaNinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ5100001.DBZ5100001StateName;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ5100001.KaigoNinteiShinseiKensakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ5100001.KaigoNinteiShinseiKensakuHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ5100001.KaigoNinteiValidatisonHandler;
import jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteishinseijyohokensaku.YokaigoninteishinseijyohokensakuFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 要介護認定申請情報検索クラスです。
 *
 * @reamsid_L DBZ-1300-150 houtianpeng
 */
public class KaigoNinteiShinseiKensaku {

    private final YokaigoninteishinseijyohokensakuFinder finder;

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
        return ResponseData.of(div).setState(DBZ5100001StateName.初期表示);
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
     * 検索ボタンを押下した、DataGridを設定する。
     *
     * @param div KaigoNinteiShinseiKensakuDiv
     * @return ResponseData<KaigoNinteiShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onClick_btnKensaku(KaigoNinteiShinseiKensakuDiv div) {
        介護認定申請情報の検索(div);
        ValidationMessageControlPairs validationMessage = getValidatisonHandler(div).データ空のチェック();
        if (validationMessage.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessage).respond();
        }
        return ResponseData.of(div).setState(DBZ5100001StateName.一覧表示);
    }

    /**
     * 検索結果一覧に選択ボタンの処理。
     *
     * @param div KaigoNinteiShinseiKensakuDiv
     * @return ResponseData<KaigoNinteiShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onSelect_dgKensakuKekkaIchiran(KaigoNinteiShinseiKensakuDiv div) {

        // TODO QA1366 UIコンテナが不正です。
        return ResponseData.of(div).respond();
    }

    /**
     * 最近処理者に表示ボタンの処理。
     *
     * @param div KaigoNinteiShinseiKensakuDiv
     * @return ResponseData<KaigoNinteiShinseiKensakuDiv>
     */
    public ResponseData<KaigoNinteiShinseiKensakuDiv> onClick_btnHoji(KaigoNinteiShinseiKensakuDiv div) {

        // TODO QA1366 最近処理者情報に申請書管理番号が存在しない。
//        RecentUsedDdlValue 最近処理者情報 = div.getCcdSaikinShorisha().getRecentUsed();
//        最近処理者情報.get有効範囲コード()
        return ResponseData.of(div).respond();
    }

    private void 介護認定申請情報の検索(KaigoNinteiShinseiKensakuDiv div) {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
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

    private KaigoNinteiShinseiKensakuHandler getHandler(KaigoNinteiShinseiKensakuDiv div) {
        return new KaigoNinteiShinseiKensakuHandler(div);
    }

    private KaigoNinteiValidatisonHandler getValidatisonHandler(KaigoNinteiShinseiKensakuDiv div) {
        return new KaigoNinteiValidatisonHandler(div);
    }
}
