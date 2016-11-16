/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1100012;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoDataResult;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_ShikyushinseishoTorokugamenTitle;
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
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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

    private Integer 申請状態;
    private Integer 申請状況;
    private static final RString 一 = new RString("1");
    private static final RString 二 = new RString("2");
    private static final int ぜろ = 0;
    private static final int WK申請状況_１ = 1;
    private static final int 十一 = 11;
    private static final int 十七 = 17;
    private static final RString 高額合算支給申請書訂正_メニューID = new RString("DBCMN61004");
    private static final RString 照会 = new RString("照会");

    /**
     * get申請状態のメソッドです。
     *
     * @return 申請状態
     */
    public Integer get申請状態() {
        return 申請状態;
    }

    /**
     * get申請状態のメソッドです。
     *
     * @param 申請状態 Integer
     */
    public void set申請状態(Integer 申請状態) {
        this.申請状態 = 申請状態;
    }

    /**
     * get申請状態のメソッドです。
     *
     * @return 申請状況
     */
    public Integer get申請状況() {
        return 申請状況;
    }

    /**
     * get申請状態のメソッドです。
     *
     * @param 申請状況 Integer
     */
    public void set申請状況(Integer 申請状況) {
        this.申請状況 = 申請状況;
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuPanelDiv> onLoad(KogakuGassanShikyuShinseiTorokuPanelDiv div) {

        set申請状態(ぜろ);
        set申請状況(ぜろ);
        RString メニューID = UrControlDataFactory.createInstance().getMenuID();
        RString タイトル = switchFor(メニューID);
        getHandler(div).initialize();
        if (WK申請状況_１ != get申請状況()) {
            div.getBtnSaikensaku().setVisible(false);
        }
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
        set申請状態(ぜろ);
        set申請状況(ぜろ);
        RString メニューID = UrControlDataFactory.createInstance().getMenuID();
        switchFor(メニューID);
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validate();
        if (validPairs.iterator().hasNext()) {
            div.getKogakuGassanShikyuShinseiTorokuSearch().setIsOpen(true);
            div.getKogakuGassanShikyuShinseiTorokuSearchResult().setIsOpen(false);
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        div.getKogakuGassanShikyuShinseiTorokuSearch().setIsOpen(false);
        div.getKogakuGassanShikyuShinseiTorokuSearchResult().setIsOpen(true);
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

        div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult().setDataSource(Collections.EMPTY_LIST);
        div.getKogakuGassanShikyuShinseiTorokuSearch().setIsOpen(true);
        div.getKogakuGassanShikyuShinseiTorokuSearchResult().setIsOpen(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 検索結果グリッド　「選択」ボタンのメソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuPanelDiv> onSelect(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
        if (高額合算支給申請書訂正_メニューID.equals(UrControlDataFactory.createInstance().getMenuID())
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
            KogakuGassanShinseishoDataResult dataResult = session作成(div);
            ViewStateHolder.put(ViewStateKeys.高額介護申請書用データ, dataResult);
            ViewStateHolder.put(ViewStateKeys.照会モード, null);
            return ResponseData.of(div).forwardWithEventName(DBC1100012TransitionEventName.選択).respond();
        } else if (new RString(DbcQuestionMessages.高額合算支給申請検索_訂正.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        if ((div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult()
                .getClickedItem().getTxtShinseiKubun().equals(一)
                || div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult()
                .getClickedItem().getTxtShinseiKubun().equals(二))
                && div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult()
                .getClickedItem().getTxtSoshin().getValue() != null
                && !div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult()
                .getClickedItem().getTxtSoshin().getValue().isEmpty()) {
            KogakuGassanShinseishoDataResult dataResult = session作成(div);
            ViewStateHolder.put(ViewStateKeys.高額介護申請書用データ, dataResult);
            ViewStateHolder.put(ViewStateKeys.照会モード, null);
            return ResponseData.of(div).forwardWithEventName(DBC1100012TransitionEventName.選択).respond();
        }
        if (!ResponseHolder.isReRequest() && !new RString(DbcQuestionMessages.高額合算支給申請検索_訂正.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.高額合算支給申請検索_処理不可.getMessage()).respond();
        }
        if (new RString(DbcQuestionMessages.高額合算支給申請検索_処理不可.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            KogakuGassanShinseishoDataResult dataResult = session作成(div);
            ViewStateHolder.put(ViewStateKeys.高額介護申請書用データ, dataResult);
            ViewStateHolder.put(ViewStateKeys.照会モード, 照会);
            return ResponseData.of(div).forwardWithEventName(DBC1100012TransitionEventName.選択).respond();
        }
        return ResponseData.of(div).respond();
    }

    private KogakuGassanShinseishoDataResult session作成(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
        dgTorokuSearchResult_Row row = div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult().getClickedItem();
        KogakuGassanShinseishoDataResult dataResult = new KogakuGassanShinseishoDataResult();
        if (row.getTxtHihokenshaNo() != null) {
            dataResult.set被保険者番号(new HihokenshaNo(row.getTxtHihokenshaNo()));
        }
        if (row.getTxtTaishoNendo() != null) {
            dataResult.set対象年度(new FlexibleYear(row.getTxtTaishoNendo()));
        }
        if (row.getTxtHokenshaNo() != null) {
            dataResult.set保険者番号(new HokenshaNo(row.getTxtHokenshaNo()));
        }
        if (row.getTxtShikyuShinseishoNo() != null) {
            dataResult.set整理番号(row.getTxtShikyuShinseishoNo().substring(十一, 十七));
        }
        if (row.getTxtShinseiDaihyoshaName() != null) {
            dataResult.set申請代表者氏名(new AtenaMeisho(row.getTxtShinseiDaihyoshaName()));
        }
        if (row.getTxtBango() != null) {
            dataResult.set申請代表者郵便番号(new YubinNo(row.getTxtBango()));
        }
        if (row.getTxtSyusyou() != null) {
            dataResult.set申請代表者住所(row.getTxtSyusyou());
        }
        if (row.getTxtTelbanngo() != null) {
            dataResult.set申請代表者電話番号(new TelNo(row.getTxtTelbanngo()));
        }
        if (row.getTxtRirekiNo().toString() != null) {
            dataResult.set履歴番号(new Decimal(row.getTxtRirekiNo().toString()));
        }
        return dataResult;
    }

    private KogakuGassanShikyuShinseiTorokuPanelHandler getHandler(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
        return new KogakuGassanShikyuShinseiTorokuPanelHandler(div);
    }

    private KogakuGassanShikyuShinseiTorokuPanelValidationHandler getValidationHandler(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
        return new KogakuGassanShikyuShinseiTorokuPanelValidationHandler(div);
    }

    private RString switchFor(RString メニューID) {
        final Integer one = 1;
        final Integer two = 2;
        final Integer three = 3;
        RString タイトル = RString.EMPTY;

        switch (メニューID.toString()) {
            case "DBCMN61002":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.高額合算支給申請書登録_変更申請.get略称();
                set申請状態(two);
                set申請状況(one);
                break;
            case "DBCMN61003":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.高額合算支給申請書登録_取下げ申請.get略称();
                set申請状態(three);
                set申請状況(one);
                break;
            case "DBCMN61004":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.高額合算支給申請書訂正.get略称();
                set申請状況(one);
                break;
            case "DBCMN61006":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.高額合算支給申請書_写_登録_変更申請.get略称();
                set申請状態(two);
                set申請状況(three);
                break;
            case "DBCMN61007":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.高額合算支給申請書_写_登録_取下げ申請.get略称();
                set申請状態(three);
                set申請状況(three);
                break;
            case "DBCMN61008":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.高額合算支給申請書_写_訂正.get名称();
                set申請状況(three);
                break;
            case "DBCMN61010":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.自己負担額証明書交付申請書登録_変更申請.get略称();
                set申請状態(two);
                set申請状況(two);
                break;
            case "DBCMN61011":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.自己負担額証明書交付申請書登録_取下げ申請.get略称();
                set申請状態(three);
                set申請状況(two);
                break;
            case "DBCMN61012":
                タイトル = Kaigogassan_ShikyushinseishoTorokugamenTitle.自己負担額証明書交付申請書訂正.get名称();
                set申請状況(two);
                break;
            default:
                break;
        }
        return タイトル;
    }
}
