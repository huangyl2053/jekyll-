/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2200001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinnteiChousairaiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.WaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.NinteichosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairai.NinnteiChousairaiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.DBE2200001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.NinteiChosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgChosaItakusakiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgMiwaritsukeShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgWaritsukeZumiShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgchosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2200001.NinteiChosaIraiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2200001.NinteiChosaIraiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ninnteichousairai.NinnteiChousairaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.shishosecurityjoho.ShishoSecurityJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定調査依頼のコントローラです。
 *
 * @reamsid_L DBE-0010-010 sunhaidi
 */
public class NinteiChosaIrai {

    private static final RString 未割付 = new RString("未割付");
    private static final RString 割付解除 = new RString("割付解除");
    private static final RString 調査依頼日より加算する = new RString("1");

    /**
     * 画面初期化処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onLoad(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        handler.load();
        ShoKisaiHokenshaNo 保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
        RString 支所コード = ShishoSecurityJoho.createInstance().getShishoCode(ControlDataHolder.getUserId());
        LasdecCode 市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード();
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, 保険者番号);
        ViewStateHolder.put(ViewStateKeys.支所コード, 支所コード);
        ViewStateHolder.put(ViewStateKeys.市町村コード, 市町村コード);
        NinnteiChousairaiParameter parameter = handler.create調査委託先取得パラメータ(保険者番号, 支所コード, 市町村コード);
        SearchResult<NinnteiChousairaiBusiness> 認定調査委託先List = NinnteiChousairaiFinder.createInstance().get認定調査委託先(parameter);
        getHandler(div).set認定調査委託先一覧(認定調査委託先List);
        return ResponseData.of(div).respond();
    }

    /**
     * 検索するボタンクリックイベントです。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnSearch(NinteiChosaIraiDiv div) {
        ShoKisaiHokenshaNo 保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
        RString 支所コード = ShishoSecurityJoho.createInstance().getShishoCode(ControlDataHolder.getUserId());
        LasdecCode 市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード();
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, 保険者番号);
        ViewStateHolder.put(ViewStateKeys.支所コード, 支所コード);
        ViewStateHolder.put(ViewStateKeys.市町村コード, 市町村コード);
        NinteiChosaIraiHandler handler = getHandler(div);
        NinnteiChousairaiParameter parameter = handler.create調査委託先取得パラメータ(保険者番号, 支所コード, 市町村コード);
        SearchResult<NinnteiChousairaiBusiness> 認定調査委託先List = NinnteiChousairaiFinder.createInstance().get認定調査委託先(parameter);
        if (認定調査委託先List.records().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        handler.set認定調査委託先一覧(認定調査委託先List);
        return ResponseData.of(div).respond();
    }

    /**
     * 条件をクリアするするボタンクリックイベントです。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnKensakuJokenClear(NinteiChosaIraiDiv div) {
        getHandler(div).clear検索条件();
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先一覧の選択処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onSelect_dgChosaItakusakiIchiran(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        dgChosaItakusakiIchiran_Row chosaItakusakiRow = div.getDgChosaItakusakiIchiran().getActiveRow();
        handler.set委託先基本情報(chosaItakusakiRow);
        ChosaItakusakiCode chosaItakusakiCode = new ChosaItakusakiCode(chosaItakusakiRow.getChosaItakusakiCode().getValue());
        ViewStateHolder.put(ViewStateKeys.市町村コード, new LasdecCode(chosaItakusakiRow.getHokenshaCode()));
        ViewStateHolder.put(ViewStateKeys.認定調査委託先コード, chosaItakusakiRow.getChosaItakusakiCode().getValue());
        ViewStateHolder.put(ViewStateKeys.保険者名称, chosaItakusakiRow.getHokenshaName());
        ViewStateHolder.put(ViewStateKeys.認定調査委託先割付定員, chosaItakusakiRow.getWaritsukeTeiin().getText());
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, new ShoKisaiHokenshaNo(chosaItakusakiRow.getShoKisaiHokenshaNo()));

        RString 支所コード = ViewStateHolder.get(ViewStateKeys.支所コード, RString.class);
        ShoKisaiHokenshaNo 保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);
        NinnteiChousairaiParameter parameter = NinnteiChousairaiParameter.createParamfor調査員情報(保険者番号, 支所コード, chosaItakusakiCode);
        List<NinnteiChousairaiBusiness> 調査員情報List = NinnteiChousairaiFinder.createInstance().get調査員(parameter);
        handler.set調査員情報一覧(調査員情報List);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査員一覧の選択処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onSelect_dgchosainIchiran(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        dgchosainIchiran_Row row = div.getChosainIchiran().getDgchosainIchiran().getActiveRow();
        handler.set調査員基本情報(row);

        ViewStateHolder.put(ViewStateKeys.調査員コード, row.getChosainCode().getValue());
        ViewStateHolder.put(ViewStateKeys.調査員割付可能人数_月, row.getChosaKanoNinzuPerMonth());

        ShoKisaiHokenshaNo 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);
        RString 支所コード = ViewStateHolder.get(ViewStateKeys.支所コード, RString.class);
        ChosaItakusakiCode 認定調査委託先コード = new ChosaItakusakiCode(ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class));
        RString 保険者名称 = ViewStateHolder.get(ViewStateKeys.保険者名称, RString.class);
        set割付済み申請者一覧(証記載保険者番号, 支所コード, 認定調査委託先コード, new ChosainCode(row.getChosainCode().getValue()), 保険者名称, handler);
        set未割付申請者一覧(証記載保険者番号, 支所コード, 保険者名称, handler);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査員一覧の選択処理で調査員を選択せず、「調査対象者選択に進む」ボタンをクリックした場合に行う処理を定義します。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnNextChosaTaishoshaSelect(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        handler.clear調査員基本情報();

        ViewStateHolder.put(ViewStateKeys.調査員コード, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.調査員割付可能人数_月, RString.EMPTY);

        ShoKisaiHokenshaNo 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);
        RString 支所コード = ViewStateHolder.get(ViewStateKeys.支所コード, RString.class);
        ChosaItakusakiCode 認定調査委託先コード = new ChosaItakusakiCode(ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class));
        RString 保険者名称 = ViewStateHolder.get(ViewStateKeys.保険者名称, RString.class);
        set割付済み申請者一覧(証記載保険者番号, 支所コード, 認定調査委託先コード, null, 保険者名称, handler);
        set未割付申請者一覧(証記載保険者番号, 支所コード, 保険者名称, handler);
        return ResponseData.of(div).respond();
    }

    /**
     * 「↑申請者を割付ける」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnWaritsuke(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        List<dgMiwaritsukeShinseishaIchiran_Row> selectedItems = div.getDgMiwaritsukeShinseishaIchiran().getSelectedItems();
        if (selectedItems.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.選択されていない.getMessage().replace("未割付申請者"));
        }
        if (div.getTxtChosaIraiDay().getValue() == null) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace("認定調査依頼日"));
        }

        if (is最大割付可能人数超過(div, selectedItems.size())) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbeWarningMessages.割付申請者人数が最大割付可能人数を超過.getMessage()).respond();
            }
            if (new RString(DbeWarningMessages.割付申請者人数が最大割付可能人数を超過.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }

        for (dgMiwaritsukeShinseishaIchiran_Row row : selectedItems) {
            handler.set割付済み申請者一覧(row);
            div.getDgMiwaritsukeShinseishaIchiran().getDataSource().remove(row);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「↓割付けを解除する」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnKaijo(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
        if (selectedItems.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.選択されていない.getMessage().replace("割付済み申請者"));
        }

        boolean exist調査完了申請者 = false;
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            if (row.getJotai().isEmpty()
                    && (row.getNinteichosaKanryoYMD().getValue() != null && !row.getNinteichosaKanryoYMD().getValue().isEmpty())) {
                exist調査完了申請者 = true;
                break;
            }
        }
        if (exist調査完了申請者) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.認定調査完了申請者ですが割付解除.getMessage().getCode(),
                        DbeQuestionMessages.認定調査完了申請者ですが割付解除.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeQuestionMessages.認定調査完了申請者ですが割付解除.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            handler.set未割付申請者一覧(row);
            div.getDgWaritsukeZumiShinseishaIchiran().getDataSource().remove(row);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「依頼書等を印刷する」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnIraishotoPrint(NinteiChosaIraiDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate依頼書等を印刷するボタンクリック();
        if (pairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        IkenshoPrintParameterModel model = new IkenshoPrintParameterModel();
        model.set申請書管理番号リスト(getHandler(div).getSelected申請書管理番号リスト());
        model.set市町村コード(ViewStateHolder.get(ViewStateKeys.市町村コード, LasdecCode.class));
        model.set遷移元画面区分(GamenSeniKbn.認定調査依頼);
        div.setHiddenIuputModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 割付済みの「照会」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_WaritsukeZumiShokai(NinteiChosaIraiDiv div) {
        dgWaritsukeZumiShinseishaIchiran_Row row = div.getDgWaritsukeZumiShinseishaIchiran().getClickedItem();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo(row.getHihokenshaNo()));
        div.setShinseishaKanriNo(row.getShinseishoKanriNo());
        return ResponseData.of(div).respond();
    }

    /**
     * 未割付の「照会」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_MiwaritsukeShokai(NinteiChosaIraiDiv div) {
        dgMiwaritsukeShinseishaIchiran_Row row = div.getDgMiwaritsukeShinseishaIchiran().getClickedItem();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo(row.getHihokenshaNo()));
        div.setShinseishaKanriNo(row.getShinseishoKanriNo());
        return ResponseData.of(div).respond();
    }

    /**
     * 「認定調査員選択へ戻る」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnBackToChosainSentaku(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        if (handler.exist変更()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }

        ChosaItakusakiCode chosaItakusakiCode = new ChosaItakusakiCode(ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class));
        RString 支所コード = ViewStateHolder.get(ViewStateKeys.支所コード, RString.class);
        ShoKisaiHokenshaNo 保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);
        NinnteiChousairaiParameter parameter = NinnteiChousairaiParameter.createParamfor調査員情報(
                保険者番号, 支所コード, chosaItakusakiCode);
        List<NinnteiChousairaiBusiness> 調査員情報一覧 = NinnteiChousairaiFinder.createInstance().get調査員(parameter);
        handler.clear調査員基本情報();
        handler.set調査員情報一覧(調査員情報一覧);
        return ResponseData.of(div).setState(DBE2200001StateName.調査員選択);
    }

    /**
     * 「認定調査委託先選択へ戻る」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnBackToChosaItakusakiSentaku(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        if (handler.exist変更()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).setState(DBE2200001StateName.調査委託先選択);
    }

    /**
     * 「調査委託先選択に戻る」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnBackToItakusakiSentaku(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        handler.clear検索条件();
        ShoKisaiHokenshaNo 保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
        RString 支所コード = ShishoSecurityJoho.createInstance().getShishoCode(ControlDataHolder.getUserId());
        LasdecCode 市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード();
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, 保険者番号);
        ViewStateHolder.put(ViewStateKeys.支所コード, 支所コード);
        ViewStateHolder.put(ViewStateKeys.市町村コード, 市町村コード);
        NinnteiChousairaiParameter parameter = handler.create調査委託先取得パラメータ(保険者番号, 支所コード, 市町村コード);
        SearchResult<NinnteiChousairaiBusiness> 認定調査委託先List = NinnteiChousairaiFinder.createInstance().get認定調査委託先(parameter);
        handler.set認定調査委託先一覧(認定調査委託先List);
        return ResponseData.of(div).setState(DBE2200001StateName.調査委託先選択);
    }

    /**
     * 「割付内容を保存する」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnHozon(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        if (!ResponseHolder.isReRequest() && !handler.exist変更()) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            insert認定調査依頼情報(div);
            update認定調査依頼情報(div);
            ShoKisaiHokenshaNo 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);
            RString 支所コード = ViewStateHolder.get(ViewStateKeys.支所コード, RString.class);
            ChosaItakusakiCode 認定調査委託先コード = new ChosaItakusakiCode(ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class));
            RString 調査員コード = ViewStateHolder.get(ViewStateKeys.調査員コード, RString.class);
            RString 保険者名称 = ViewStateHolder.get(ViewStateKeys.保険者名称, RString.class);
            set割付済み申請者一覧(証記載保険者番号, 支所コード, 認定調査委託先コード, new ChosainCode(調査員コード), 保険者名称, handler);
            div.getKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBE2200001StateName.保存完了);
        }
        return ResponseData.of(div).respond();
    }

    private void insert認定調査依頼情報(NinteiChosaIraiDiv div) {
        List<dgWaritsukeZumiShinseishaIchiran_Row> 割付済み申請者List = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();
        NinteichosaIraiJohoManager ninteichosaIraiJohoManager = NinteichosaIraiJohoManager.createInstance();
        RDate nowDate = RDate.getNowDate();
        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, nowDate, SubGyomuCode.DBE認定支援);
        RString 認定調査期限日数 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数, nowDate, SubGyomuCode.DBE認定支援);
        FlexibleDate 認定調査依頼年月日 = new FlexibleDate(div.getTxtChosaIraiDay().getValue().toDateString());
        for (dgWaritsukeZumiShinseishaIchiran_Row row : 割付済み申請者List) {
            if (未割付.equals(row.getJotai())) {
                ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
                int 認定調査依頼履歴番号 = Integer.parseInt(row.getNinteichosaIraiRirekiNo().toString());
                RString 調査員コード = div.getTxtChosainCode().getValue();
                RString 認定調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class);

                FlexibleDate 認定申請日 = new FlexibleDate(row.getNinteiShinseiDay().getValue().toDateString());
                FlexibleDate 認定調査期限年月日;
                if (調査依頼日より加算する.equals(認定調査期限設定方法)) {
                    認定調査期限年月日 = 認定調査依頼年月日.plusDay(Integer.parseInt(認定調査期限日数.toString()));
                } else {
                    認定調査期限年月日 = 認定申請日.plusDay(Integer.parseInt(認定調査期限日数.toString()));
                }
                if (ChosaKubun.新規調査.get名称().equals(row.getChosaKubun())) {
                    NinteichosaIraiJoho ninteichosaIraiJoho = new NinteichosaIraiJoho(申請書管理番号, 認定調査依頼履歴番号);
                    ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit()
                            .set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                            .set認定調査委託先コード(new JigyoshaNo(認定調査委託先コード))
                            .set認定調査員コード(調査員コード)
                            .set認定調査依頼区分コード(new Code(NinteichosaIraiKubun.初回.getCode()))
                            .set認定調査回数(0)
                            .set認定調査依頼年月日(認定調査依頼年月日)
                            .set認定調査期限年月日(認定調査期限年月日)
                            .set論理削除フラグ(false)
                            .set認定調査依頼履歴番号(認定調査依頼履歴番号 + 1)
                            .build();
                    ninteichosaIraiJohoManager.save認定調査依頼情報(ninteichosaIraiJoho);
                    update要介護認定申請情報(申請書管理番号, 調査員コード, 認定調査委託先コード, row, ChosaKubun.新規調査);
                } else if (ChosaKubun.再調査.get名称().equals(row.getChosaKubun())) {
                    認定調査依頼履歴番号 = Integer.parseInt(row.getNinteichosaIraiRirekiNo().toString()) + 1;
                    NinteichosaIraiJoho ninteichosaIraiJoho = new NinteichosaIraiJoho(申請書管理番号, 認定調査依頼履歴番号);
                    ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit()
                            .set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                            .set認定調査委託先コード(new JigyoshaNo(認定調査委託先コード))
                            .set認定調査員コード(調査員コード)
                            .set認定調査依頼区分コード(new Code(NinteichosaIraiKubun.再調査.getCode()))
                            .set認定調査回数(1)
                            .set認定調査依頼年月日(認定調査依頼年月日)
                            .set認定調査期限年月日(認定調査期限年月日)
                            .set論理削除フラグ(false)
                            .set認定調査依頼履歴番号(認定調査依頼履歴番号 + 1)
                            .build();
                    ninteichosaIraiJohoManager.save認定調査依頼情報(ninteichosaIraiJoho);
                    update要介護認定申請情報(申請書管理番号, 調査員コード, 認定調査委託先コード, row, ChosaKubun.再調査);
                }
            }
        }
        div.getDgWaritsukeZumiShinseishaIchiran().setDataSource(割付済み申請者List);
    }

    private void update要介護認定申請情報(ShinseishoKanriNo 申請書管理番号, RString 調査員コード,
            RString 認定調査委託先コード, dgWaritsukeZumiShinseishaIchiran_Row row, ChosaKubun 調査区分) {
        NinteiShinseiJohoManager manager = NinteiShinseiJohoManager.createInstance();
        NinteiShinseiJoho ninteiShinseiJoho = manager.get要介護認定申請情報(申請書管理番号);
        ninteiShinseiJoho = ninteiShinseiJoho.createBuilderForEdit()
                .set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                .set認定調査委託先コード(new ChosaItakusakiCode(認定調査委託先コード))
                .set認定調査員コード(new ChosainCode(調査員コード))
                .set調査区分(new Code(調査区分.getコード()))
                .build();
        manager.save要介護認定申請情報(ninteiShinseiJoho.modifiedModel());
    }

    private void update認定調査依頼情報(NinteiChosaIraiDiv div) {
        List<dgMiwaritsukeShinseishaIchiran_Row> miwaritsukeShinseishaIchiran = div.getDgMiwaritsukeShinseishaIchiran().getDataSource();
        Models<NinteichosaIraiJohoIdentifier, NinteichosaIraiJoho> ninteichosaIraiJohoList = ViewStateHolder.get(ViewStateKeys.認定調査依頼情報, Models.class);
        Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> ninteiKanryoJohoList = ViewStateHolder.get(ViewStateKeys.要介護認定完了情報, Models.class);
        NinteichosaIraiJohoManager ninteichosaIraiJohoManager = NinteichosaIraiJohoManager.createInstance();
        NinteiKanryoJohoManager ninteiKanryoJohoManager = NinteiKanryoJohoManager.createInstance();
        for (dgMiwaritsukeShinseishaIchiran_Row row : miwaritsukeShinseishaIchiran) {
            if (割付解除.equals(row.getJotai())) {
                ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
                int 認定調査依頼履歴番号 = Integer.parseInt(row.getNinteichosaIraiRirekiNo().toString());
                NinteichosaIraiJohoIdentifier ninteichosaIraiJohoIdentifier = new NinteichosaIraiJohoIdentifier(申請書管理番号, 認定調査依頼履歴番号);
                NinteichosaIraiJoho ninteichosaIraiJoho = ninteichosaIraiJohoList.get(ninteichosaIraiJohoIdentifier);
                if (ninteichosaIraiJoho != null) {
                    ninteichosaIraiJohoManager.saveOrDeletePhysical(ninteichosaIraiJoho.deleted());
                }

                NinteiKanryoJohoIdentifier ninteiKanryoJohoIdentifier = new NinteiKanryoJohoIdentifier(申請書管理番号);
                NinteiKanryoJoho ninteiKanryoJoho = ninteiKanryoJohoList.get(ninteiKanryoJohoIdentifier)
                        .createBuilderForEdit()
                        .set認定調査依頼完了年月日(FlexibleDate.EMPTY)
                        .set認定調査完了年月日(FlexibleDate.EMPTY)
                        .build();
                ninteiKanryoJohoManager.save要介護認定完了情報(ninteiKanryoJoho.modifiedModel());
            }
        }
    }

    private void set割付済み申請者一覧(ShoKisaiHokenshaNo 証記載保険者番号, RString 支所コード, ChosaItakusakiCode 認定調査委託先コード,
            ChosainCode 調査員コード, RString 保険者名称, NinteiChosaIraiHandler handler) {
        NinnteiChousairaiFinder finder = NinnteiChousairaiFinder.createInstance();
        NinnteiChousairaiParameter parameter
                = NinnteiChousairaiParameter.createParamfor割付済み申請者一覧(証記載保険者番号, 支所コード, 認定調査委託先コード, 調査員コード);
        List<WaritsukeBusiness> 割付済み申請者一覧 = finder.get割付済み申請者(parameter);
        handler.set割付済み申請者一覧(割付済み申請者一覧, 保険者名称);

        List<NinteiKanryoJoho> ninteiKanryoJohoList = new ArrayList<>();
        List<NinteichosaIraiJoho> ninteichosaIraiJohoList = new ArrayList<>();
        for (WaritsukeBusiness 割付済み申請者 : 割付済み申請者一覧) {
            ninteiKanryoJohoList.add(割付済み申請者.get認定完了情報());
            if (割付済み申請者.get認定調査依頼情報() != null) {
                ninteichosaIraiJohoList.add(割付済み申請者.get認定調査依頼情報());
            }
        }
        ViewStateHolder.put(ViewStateKeys.要介護認定完了情報, Models.create(ninteiKanryoJohoList));
        ViewStateHolder.put(ViewStateKeys.認定調査依頼情報, Models.create(ninteichosaIraiJohoList));
    }

    private void set未割付申請者一覧(ShoKisaiHokenshaNo 証記載保険者番号, RString 支所コード, RString 保険者名称, NinteiChosaIraiHandler handler) {
        NinnteiChousairaiParameter parameter = NinnteiChousairaiParameter.createParam未割付申請者(証記載保険者番号, 支所コード);
        List<WaritsukeBusiness> 未割付申請者一覧 = NinnteiChousairaiFinder.createInstance().get未割付申請者(parameter);
        handler.set未割付申請者一覧(未割付申請者一覧, 保険者名称);
    }

    private boolean is最大割付可能人数超過(NinteiChosaIraiDiv div, int 割付人数) {
        boolean 最大割付可能人数超過 = false;
        List<dgWaritsukeZumiShinseishaIchiran_Row> 割付済み申請者List = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();
        RString 調査員コード = ViewStateHolder.get(ViewStateKeys.調査員コード, RString.class);
        RString 認定調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class);
        int 認定調査委託先割付定員 = nullToZero(ViewStateHolder.get(ViewStateKeys.認定調査委託先割付定員, RString.class));
        if (!RString.isNullOrEmpty(認定調査委託先コード)
                && RString.isNullOrEmpty(調査員コード)
                && 認定調査委託先割付定員 < (割付人数 + 割付済み申請者List.size())) {
            最大割付可能人数超過 = true;
        }

        int 調査依頼年月割付済み人数 = 0;
        RYearMonth 調査依頼年月 = div.getTxtChosaIraiDay().getValue().getYearMonth();
        for (dgWaritsukeZumiShinseishaIchiran_Row row : 割付済み申請者List) {
            if (row.getChosaIraiDay().isEmpty()
                    || 調査依頼年月.equals(new RDate(row.getChosaIraiDay().toString()).getYearMonth())) {
                調査依頼年月割付済み人数++;
            }
        }
        int 調査員割付可能人数_月 = nullToZero(ViewStateHolder.get(ViewStateKeys.調査員割付可能人数_月, RString.class));
        if (!RString.isNullOrEmpty(認定調査委託先コード)
                && !RString.isNullOrEmpty(調査員コード)
                && 調査員割付可能人数_月 < (割付人数 + 調査依頼年月割付済み人数)) {
            最大割付可能人数超過 = true;
        }
        return 最大割付可能人数超過;
    }

    private int nullToZero(RString obj) {
        if (obj != null && !obj.isEmpty()) {
            return Integer.parseInt(obj.toString());
        }
        return 0;
    }

    private NinteiChosaIraiHandler getHandler(NinteiChosaIraiDiv div) {
        return new NinteiChosaIraiHandler(div);
    }

    private NinteiChosaIraiValidationHandler getValidationHandler(NinteiChosaIraiDiv div) {
        return new NinteiChosaIraiValidationHandler(div);
    }
}
