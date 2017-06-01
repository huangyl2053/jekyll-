/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0100002;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.business.core.shinseikensaku.ShinseiKensakuBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE010002.DBE010002_ShinseishaDataOutParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100002.DBE0100002StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100002.ShinseishaDataOutputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100002.dgShinseiJoho_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0100002.ShinseishaDataOutputHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0100002.ShinseishaDataOutputValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinseikensaku.ShinseiKensakuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.ninteisaikinshorisha.NinteiSaikinShorisha;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Comparators;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 要介護認定申請検索のクラスです。
 *
 * @author N3212 竹内 和紀
 */
public class ShinseishaDataOutput {

    private static final RString 基本情報 = new RString("0");
    private static final RString 調査票情報 = new RString("1");
    private static final RString 意見書情報 = new RString("2");

    /**
     * ページロードイベントです。
     *
     * @param div ShinseishaDataOutputDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishaDataOutputDiv> onLoad(ShinseishaDataOutputDiv div) {
        getHandler(div).initialize();
        ShoKisaiHokenshaNo 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);
        if (証記載保険者番号 != null && !証記載保険者番号.isEmpty()) {
            div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv().getDdlHokenshaNumber().setSelectedShoKisaiHokenshaNoIfExist(証記載保険者番号);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 条件をクリアするボタンクリックイベントです。
     *
     * @param div ShinseishaDataOutputDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishaDataOutputDiv> onClick_btnClear(ShinseishaDataOutputDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索するボタンクリックイベントです。
     *
     * @param div ShinseishaDataOutputDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishaDataOutputDiv> onClick_btnKensaku(ShinseishaDataOutputDiv div) {
        return new KensakuProcess(div).exec(
                div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv()
                .getDdlHokenshaNumber().getSelectedItem().get証記載保険者番号(),
                div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv()
                .getTxtHihokenshaNumber().getValue());
    }

    /**
     * 最近処理者の表示するボタンクリックイベントです。
     *
     * @param div ShinseishaDataOutputDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishaDataOutputDiv> onSaikinshorishaClick(ShinseishaDataOutputDiv div) {
        ValidationMessageControlPairs pairs = div.getCcdNinteishinseishaFinder().getSaikinShorishaDiv().validate();
        if (pairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        NinteiSaikinShorisha saikinShorisha = div.getCcdNinteishinseishaFinder().getSaikinShorishaDiv().getSelectedItem();
        return new SaikinShorishaKensakuProcess(div).exec(saikinShorisha.getShoKisaiHokenshaNo(), saikinShorisha.getHihokenshaNo());
    }

    /**
     * 申請検索状態の「CSV出力を実行する」ボタンクリックイベントです。
     *
     * @param div ShinseishaDataOutputDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishaDataOutputDiv> onClick_btnBatchRegister(ShinseishaDataOutputDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validateBtnBatchRegister();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 申請一覧状態の「CSV出力を実行する」ボタンクリックイベントです。
     *
     * @param div ShinseishaDataOutputDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishaDataOutputDiv> onClick_btnBatchRegister2(ShinseishaDataOutputDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validateBtnBatchRegister2();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件入力状態の「CSV出力を実行する」ボタンクリック時のバッチパラメータ作成処理です。
     *
     * @param div ShinseishaDataOutputDiv
     * @return ResponseData
     */
    public ResponseData<DBE010002_ShinseishaDataOutParameter> createBatchParameter(ShinseishaDataOutputDiv div) {
        NinteiSaikinShorisha saikinShorisha = div.getCcdNinteishinseishaFinder().getSaikinShorishaDiv().getSelectedItem();
        DBE010002_ShinseishaDataOutParameter parameter = new DBE010002_ShinseishaDataOutParameter();
        parameter.set検索実行(true);
        parameter.set検索条件(getHandler(div).createSearchParameter(saikinShorisha.getShoKisaiHokenshaNo(), saikinShorisha.getHihokenshaNo()));
        parameter.set基本情報出力(div.getChkOutputCsv().getSelectedKeys().contains(基本情報));
        parameter.set調査票情報出力(div.getChkOutputCsv().getSelectedKeys().contains(調査票情報));
        parameter.set意見書情報出力(div.getChkOutputCsv().getSelectedKeys().contains(意見書情報));
        return ResponseData.of(parameter).respond();
    }

    /**
     * 申請一覧状態の「CSV出力を実行する」ボタンクリック時のバッチパラメータ作成処理です。
     *
     * @param div ShinseishaDataOutputDiv
     * @return ResponseData
     */
    public ResponseData<DBE010002_ShinseishaDataOutParameter> createBatchParameter2(ShinseishaDataOutputDiv div) {
        DBE010002_ShinseishaDataOutParameter parameter = new DBE010002_ShinseishaDataOutParameter();
        List<RString> 申請書管理番号リスト = new ArrayList<>();
        for (dgShinseiJoho_Row row : div.getDgShinseiJoho().getSelectedItems()) {
            申請書管理番号リスト.add(row.getShinseishoKanriNo());
        }
        parameter.set検索実行(false);
        parameter.set申請書管理番号リスト(申請書管理番号リスト);
        parameter.set基本情報出力(div.getChkOutputCsv().getSelectedKeys().contains(基本情報));
        parameter.set調査票情報出力(div.getChkOutputCsv().getSelectedKeys().contains(調査票情報));
        parameter.set意見書情報出力(div.getChkOutputCsv().getSelectedKeys().contains(意見書情報));
        return ResponseData.of(parameter).respond();
    }

    /**
     * 申請一覧データグリッドの照会ボタンクリックイベントです。
     *
     * @param div ShinseishaDataOutputDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishaDataOutputDiv> onClick_btnShokai(ShinseishaDataOutputDiv div) {
        dgShinseiJoho_Row row = div.getDgShinseiJoho().getClickedItem();
        div.getCcdNinteishinseishaFinder().updateSaikinShorisha(new ShoKisaiHokenshaNo(row.getShoKisaiHokenshaNo()), row.getHihokenshaNo(), row.getShimei());
        div.getCcdNinteishinseishaFinder().reloadSaikinShorisha();
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, row.getShinseishoKanriNo());
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索条件に戻る」ボタンクリックイベントです。
     *
     * @param div ShinseishaDataOutputDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishaDataOutputDiv> onClick_btnModoru(ShinseishaDataOutputDiv div) {
        div.getDgShinseiJoho().setDataSource(Collections.<dgShinseiJoho_Row>emptyList());
        div.getBtnClear().setDisabled(false);
        div.getTxtMaxDisp().setDisabled(false);
        return ResponseData.of(div).setState(DBE0100002StateName.申請検索);
    }
    
    private static class KensakuProcess {

        protected final ShinseishaDataOutputDiv div;

        protected KensakuProcess(ShinseishaDataOutputDiv div) {
            this.div = div;
        }

        ResponseData<ShinseishaDataOutputDiv> exec(ShoKisaiHokenshaNo shoKisaiHokenshaNo, RString hihokenshaNo) {
            if (ResponseHolder.isReRequest()) {
                return ResponseData.of(div).respond();
            }
            /* 検索条件のバリデーション */
            ValidationMessageControlPairs pairs = div.getCcdNinteishinseishaFinder().validate();
            if (pairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            /* 検索を実施 */
            SearchResult<ShinseiKensakuBusiness> searchResult = ShinseiKensakuFinder.createInstance()
                    .getShinseiKensakuForList(getHandler(div).createSearchParameter(shoKisaiHokenshaNo, hihokenshaNo));
            /* 検索結果が存在しない場合 */
            if (searchResult.records().isEmpty()) {
                div.getDgShinseiJoho().setDataSource(Collections.<dgShinseiJoho_Row>emptyList());
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
            }
            /* 検索結果が存在する場合 */
            if (updateSaikinShorisha(searchResult)) {
                div.getCcdNinteishinseishaFinder().reloadSaikinShorisha();
            }
            getHandler(div).set申請一覧データグリッド(searchResult);
            div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv().setIsOpen(false);
            div.getBtnClear().setDisabled(true);
            div.getTxtMaxDisp().setDisabled(true);
            return ResponseData.of(div).setState(DBE0100002StateName.検索結果一覧);
        }

        private ShinseishaDataOutputHandler getHandler(ShinseishaDataOutputDiv div) {
            return new ShinseishaDataOutputHandler(div);
        }

        protected boolean updateSaikinShorisha(SearchResult<ShinseiKensakuBusiness> searchResult) {
            return false;
        }

    }
    
    private static class SaikinShorishaKensakuProcess extends KensakuProcess {

        protected SaikinShorishaKensakuProcess(ShinseishaDataOutputDiv div) {
            super(div);
        }

        @Override
        protected boolean updateSaikinShorisha(SearchResult<ShinseiKensakuBusiness> searchResult) {
            ShinseiKensakuBusiness skb = findLast(searchResult.records());
            if (skb == null) {
                return false;
            }
            div.getCcdNinteishinseishaFinder().updateSaikinShorisha(
                    new ShoKisaiHokenshaNo(skb.get証記載保険者番号()), skb.get被保険者番号(), skb.get被保険者氏名().value());
            return true;
        }

        private static ShinseiKensakuBusiness findLast(Collection<? extends ShinseiKensakuBusiness> searchResult) {
            List<ShinseiKensakuBusiness> list = new ArrayList<>(searchResult);
            if (list.isEmpty()) {
                return null;
            }
            Collections.sort(list, new Comparator<ShinseiKensakuBusiness>() {
                @Override
                public int compare(ShinseiKensakuBusiness o1, ShinseiKensakuBusiness o2) {
                    return Objects.compare(o1.get認定申請年月日(), o2.get認定申請年月日(), Comparators.reverseOrder());
                }
            });
            return list.get(0);
        }

    }

    private ShinseishaDataOutputHandler getHandler(ShinseishaDataOutputDiv div) {
        return new ShinseishaDataOutputHandler(div);
    }

    private ShinseishaDataOutputValidationHandler getValidationHandler(ShinseishaDataOutputDiv div) {
        return new ShinseishaDataOutputValidationHandler(div);
    }
}
