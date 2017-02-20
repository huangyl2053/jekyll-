/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0100002;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
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
        return processKensaku(div, div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv().getTxtHihokenshaNumber().getValue());
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

        RString hihokenshaNo = div.getCcdNinteishinseishaFinder().getSaikinShorishaDiv().getSelectedHihokenshaNo();
        return processKensaku(div, hihokenshaNo);
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
        RString 被保険者番号 = div.getCcdNinteishinseishaFinder().getSaikinShorishaDiv().getSelectedHihokenshaNo();
        DBE010002_ShinseishaDataOutParameter parameter = new DBE010002_ShinseishaDataOutParameter();
        parameter.set検索実行(true);
        parameter.set検索条件(getHandler(div).createSearchParameter(被保険者番号));
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
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, div.getDgShinseiJoho().getClickedItem().getShinseishoKanriNo());
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
        onClick_btnClear(div);
        div.getBtnClear().setDisabled(false);
        return ResponseData.of(div).setState(DBE0100002StateName.申請検索);
    }

    private ResponseData<ShinseishaDataOutputDiv> processKensaku(ShinseishaDataOutputDiv div, RString hihokenshaNo) {
        if (!ResponseHolder.isReRequest()) {
        } else {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = div.getCcdNinteishinseishaFinder().validate();
        if (pairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        SearchResult<ShinseiKensakuBusiness> searchResult
                = ShinseiKensakuFinder.createInstance().getShinseiKensaku(getHandler(div).createSearchParameter(hihokenshaNo));
        if (!searchResult.records().isEmpty()) {
            int lastShinseiYmdIndex = findLastIndex(searchResult);
            div.getCcdNinteishinseishaFinder()
                    .updateSaikinShorisha(hihokenshaNo, searchResult.records().get(lastShinseiYmdIndex).get被保険者氏名().value());
            div.getCcdNinteishinseishaFinder().reloadSaikinShorisha();
            getHandler(div).set申請一覧データグリッド(searchResult);
            for (dgShinseiJoho_Row row : div.getDgShinseiJoho().getDataSource()) {
                DbAccessLogger accessLogger = new DbAccessLogger();
                accessLogger.flushBy(AccessLogType.照会);
                accessLogger.store(new ShoKisaiHokenshaNo(row.getShoKisaiHokenshaNo()), row.getHihokenshaNo());
            }
        } else {
            div.getDgShinseiJoho().setDataSource(Collections.<dgShinseiJoho_Row>emptyList());
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv().setIsOpen(false);
        div.getBtnClear().setDisabled(true);
        div.getTxtMaxDisp().setDisabled(true);
        if (searchResult.records().size() == 1) {
            div.getBtnClear().setDisabled(false);
            div.getTxtMaxDisp().setDisabled(false);
        }
        return ResponseData.of(div).setState(DBE0100002StateName.検索結果一覧);
    }

    private int findLastIndex(SearchResult<ShinseiKensakuBusiness> searchResult) {
        int lastShinseiYmdIndex = 0;
        FlexibleDate lastNinteiShinseiYmd = null;
        for (int i = 0; i < searchResult.records().size(); i++) {
            ShinseiKensakuBusiness rec = searchResult.records().get(i);
            if (lastNinteiShinseiYmd == null) {
                lastNinteiShinseiYmd = rec.get認定申請年月日();
            }
            if (rec.get認定申請年月日().isAfter(lastNinteiShinseiYmd)) {
                lastNinteiShinseiYmd = rec.get認定申請年月日();
                lastShinseiYmdIndex = i;
            }
        }
        return lastShinseiYmdIndex;
    }

    private ShinseishaDataOutputHandler getHandler(ShinseishaDataOutputDiv div) {
        return new ShinseishaDataOutputHandler(div);
    }

    private ShinseishaDataOutputValidationHandler getValidationHandler(ShinseishaDataOutputDiv div) {
        return new ShinseishaDataOutputValidationHandler(div);
    }
}
