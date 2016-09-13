/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1100012;

import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoDataResult;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100012.DBC1100012TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100012.KogakuGassanShikyuShinseiTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100012.dgTorokuSearchResult_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1100012.KogakuGassanShikyuShinseiTorokuPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1100012.KogakuGassanShikyuShinseiTorokuPanelValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN61001-12_高額合算支給申請書登録(申請情報検索)のクラスです。
 *
 * @reamsid_L DBC-2040-010 lihang
 */
public class KogakuGassanShikyuShinseiTorokuPanel {

    private static Integer 申請状態;
    private static Integer 申請状況;
    private static final RString 一 = new RString("1");
    private static final RString 二 = new RString("2");
    private static final int 十一 = 11;
    private static final int 十七 = 17;
    private static final RString 高額合算支給申請書訂正2 = new RString("DBCMN61004");
    private static final RString 照会 = new RString("照会");

    /**
     * get申請状態のメソッドです。
     *
     * @return 申請状態
     */
    public static Integer get申請状態() {
        return 申請状態;
    }

    /**
     * get申請状態のメソッドです。
     *
     * @param 申請状態 Integer
     */
    public static void set申請状態(Integer 申請状態) {
        KogakuGassanShikyuShinseiTorokuPanel.申請状態 = 申請状態;
    }

    /**
     * get申請状態のメソッドです。
     *
     * @return 申請状況
     */
    public static Integer get申請状況() {
        return 申請状況;
    }

    /**
     * get申請状態のメソッドです。
     *
     * @param 申請状況 Integer
     */
    public static void set申請状況(Integer 申請状況) {
        KogakuGassanShikyuShinseiTorokuPanel.申請状況 = 申請状況;
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuPanelDiv> onLoad(KogakuGassanShikyuShinseiTorokuPanelDiv div) {

        申請状態 = 0;
        申請状況 = 0;
        RString メニューID = UrControlDataFactory.createInstance().getMenuID();
//        getHandler(div).initialize(メニューID);
        getHandler(div).initialize();
        RString タイトル = getHandler(div).switchFor(new RString("DBCMN61002"));
        return ResponseData.of(div).rootTitle(タイトル).respond();
    }

    /**
     * 申請対象年度のメソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuPanelDiv> onChange_ddlNendo(KogakuGassanShikyuShinseiTorokuPanelDiv div) {

        getHandler(div).changeNendo();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護支給申請書整理番号CHKのメソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuPanelDiv> onChange_cbkKaigoBango(KogakuGassanShikyuShinseiTorokuPanelDiv div) {

        getHandler(div).changeKaigoBango();
        return ResponseData.of(div).respond();
    }

    /**
     * 医療支給申請書整理番号CHKのメソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuPanelDiv> onChange_cbkIryoBango(KogakuGassanShikyuShinseiTorokuPanelDiv div) {

        getHandler(div).changeIryoBango();
        return ResponseData.of(div).respond();
    }

    /**
     * 情報検索ラジオボタン制御のメソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuPanelDiv> onChange_rdbKensaku1(KogakuGassanShikyuShinseiTorokuPanelDiv div) {

        getHandler(div).changerdbKensaku1();
        return ResponseData.of(div).respond();
    }

    /**
     * 情報検索ラジオボタン制御のメソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuPanelDiv> onChange_rdbKensakudai2(KogakuGassanShikyuShinseiTorokuPanelDiv div) {

        getHandler(div).changerdbKensaku2();
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件をクリアする」ボタンのメソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuPanelDiv> onClick_btnClear(KogakuGassanShikyuShinseiTorokuPanelDiv div) {

        getHandler(div).btnClear(UrControlDataFactory.createInstance().getMenuID());
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタンのメソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuPanelDiv> onClick_btnKensaku(KogakuGassanShikyuShinseiTorokuPanelDiv div) {

        ValidationMessageControlPairs validPairs = getValidationHandler(div).validate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).btnKensaku(new RString(Integer.toString(申請状況)));
        return ResponseData.of(div).respond();
    }

    /**
     * 「再検索する」ボタンのメソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuPanelDiv> onClick_btnSaikensaku(KogakuGassanShikyuShinseiTorokuPanelDiv div) {

        div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult().setDataSource(null);
        div.getKogakuGassanShikyuShinseiTorokuSearch().setVisible(true);
        div.getKogakuGassanShikyuShinseiTorokuSearchResult().setVisible(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 検索結果グリッド　「選択」ボタンのメソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuPanelDiv> onSelect(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
        if (UrControlDataFactory.createInstance().getMenuID().equals(高額合算支給申請書訂正2)
                && !div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult()
                .getClickedItem().getTxtSoshin().getValue().isEmpty()
                && !new RString(DbcQuestionMessages.高額合算支給申請検索_訂正.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && !new RString(DbcQuestionMessages.高額合算支給申請検索_処理不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.高額合算支給申請検索_訂正.getMessage()).respond();
        }
        if (new RString(DbcQuestionMessages.高額合算支給申請検索_訂正.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC1100012TransitionEventName.支給申請登録へ).respond();
        }
        if ((div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult()
                .getClickedItem().getTxtShinseiKubun().equals(一)
                || div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult()
                .getClickedItem().getTxtShinseiKubun().equals(二))
                && !div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult()
                .getClickedItem().getTxtSoshin().getValue().isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(DBC1100012TransitionEventName.支給申請登録へ).respond();
        }
        if (!new RString(DbcQuestionMessages.高額合算支給申請検索_訂正.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.高額合算支給申請検索_処理不可.getMessage()).respond();
        }
        if (new RString(DbcQuestionMessages.高額合算支給申請検索_処理不可.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            dgTorokuSearchResult_Row row = div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult().getClickedItem();
            KogakuGassanShinseishoDataResult dataResult = new KogakuGassanShinseishoDataResult();
            dataResult.set被保険者番号(new HihokenshaNo(row.getTxtHihokenshaNo()));
            dataResult.set対象年度(new FlexibleYear(row.getTxtTaishoNendo()));
            dataResult.set保険者番号(new HokenshaNo(row.getTxtHokenshaNo()));
            if (row.getTxtShikyuShinseishoNo() != null) {
                dataResult.set整理番号(row.getTxtShikyuShinseishoNo().substring(十一, 十七));
            }
            dataResult.set履歴番号(new Decimal(row.getTxtRirekiNo().toString()));
            ViewStateHolder.put(ViewStateKeys.高額介護申請書用データ, dataResult);
            ViewStateHolder.put(ViewStateKeys.照会モード, 照会);
            return ResponseData.of(div).forwardWithEventName(DBC1100012TransitionEventName.支給申請登録へ).respond();
        }
        return ResponseData.of(div).respond();
    }

    private KogakuGassanShikyuShinseiTorokuPanelHandler getHandler(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
        return new KogakuGassanShikyuShinseiTorokuPanelHandler(div);
    }

    private KogakuGassanShikyuShinseiTorokuPanelValidationHandler getValidationHandler(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
        return new KogakuGassanShikyuShinseiTorokuPanelValidationHandler(div);
    }
}
