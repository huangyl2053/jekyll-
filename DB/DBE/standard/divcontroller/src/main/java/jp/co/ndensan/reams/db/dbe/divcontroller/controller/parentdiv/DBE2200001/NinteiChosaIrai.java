/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2200001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinnteiChousairaiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinteichosaIraiJohoRelateBusiness;
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
import jp.co.ndensan.reams.db.dbe.service.report.ninnteichousairai.NinteiChosaIraiPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.message.DbxErrorMessages;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJohoIdentifier;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 認定調査依頼のコントローラです。
 *
 * @reamsid_L DBE-0010-010 sunhaidi
 */
public class NinteiChosaIrai {

    private static final RString WARITSUKE_ZUMI = new RString("割付済み");
    private static final RString MIWARITSUKE = new RString("未割付");
    private static final RString 設定方法 = new RString("1");
    private static final RString 提出期限_0 = new RString("0");
    private static final RString 提出期限_1 = new RString("1");
    private static final RString 提出期限_2 = new RString("2");
    private static final RString CHKNAME_認定調査依頼書 = new RString("認定調査依頼書");
    private static final RString CHKNAME_認定調査票デザイン用紙 = new RString("認定調査票（デザイン用紙）");
    private static final RString CHKNAME_特記事項デザイン用紙 = new RString("特記事項（デザイン用紙）");
    private static final RString CHKNAME_特記事項_項目有り = new RString("特記事項（項目有り）");
    private static final RString CHKNAME_特記事項_項目無し = new RString("特記事項（項目無し）");
    private static final RString CHKNAME_特記事項_項目フリータイプ = new RString("特記事項（フリータイプ）");
    private static final RString CHKNAME_認定調査票OCR = new RString("認定調査票OCR");
    private static final RString CHKNAME_特記事項OCR = new RString("特記事項OCR");
    private static final RString CHKNAME_差異チェック票 = new RString("認定調査差異チェック票");
    private static final RString CHKNAME_概況特記 = new RString("概況特記");
    private static final RString CONFIGVALUE1 = new RString("1");
    private static final RString CONFIGVALUE2 = new RString("2");
    private static final RString CONFIGVALUE3 = new RString("3");

    /**
     * 画面初期化処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onLoad(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        handler.load(true);
        ShoKisaiHokenshaNo 保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
        RString 支所コード = ShishoSecurityJoho.createInstance().getShishoCode(ControlDataHolder.getUserId());
        ViewStateHolder.put(ViewStateKeys.支所コード, 支所コード);
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, 保険者番号);
        NinnteiChousairaiParameter parameter = NinnteiChousairaiParameter.createParam調査委託先Or未割付申請者(保険者番号, 支所コード);
        List<NinnteiChousairaiBusiness> 認定調査委託先List = NinnteiChousairaiFinder.createInstance().get認定調査委託先(parameter);
        handler.set認定調査委託先一覧(認定調査委託先List);
        return ResponseData.of(div).respond();
    }

    /**
     * 保険者リストの選択処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onChange_ccdHokenshaList(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        handler.load(false);
        ShoKisaiHokenshaNo 保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
        RString 支所コード = ShishoSecurityJoho.createInstance().getShishoCode(ControlDataHolder.getUserId());
        ViewStateHolder.put(ViewStateKeys.支所コード, 支所コード);
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, 保険者番号);
        NinnteiChousairaiParameter parameter = NinnteiChousairaiParameter.createParam調査委託先Or未割付申請者(保険者番号, 支所コード);
        List<NinnteiChousairaiBusiness> 認定調査委託先List = NinnteiChousairaiFinder.createInstance().get認定調査委託先(parameter);
        handler.set認定調査委託先一覧(認定調査委託先List);
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
        dgChosaItakusakiIchiran_Row row = div.getDgChosaItakusakiIchiran().getSelectedItems().get(0);
        handler.set委託先基本情報(row);
        ChosaItakusakiCode chosaItakusakiCode = new ChosaItakusakiCode(row.getChosaItakusakiCode().getValue());
        ViewStateHolder.put(ViewStateKeys.認定調査委託先コード, row.getChosaItakusakiCode().getValue());
        ViewStateHolder.put(ViewStateKeys.保険者名称, row.getHokenshaName());
        ViewStateHolder.put(ViewStateKeys.認定調査委託先割付定員, row.getWaritsukeTeiin().getText());

        RString 支所コード = ViewStateHolder.get(ViewStateKeys.支所コード, RString.class);
        ShoKisaiHokenshaNo 保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);
        NinnteiChousairaiParameter parameter = NinnteiChousairaiParameter.createParamfor調査員情報(保険者番号, 支所コード, chosaItakusakiCode);
        List<NinnteiChousairaiBusiness> 調査員情報List = NinnteiChousairaiFinder.createInstance().get調査員(parameter);
        handler.set調査員情報一覧(調査員情報List, row);
        setData(null, handler);
        try {
            handler.init印刷条件DIV();
        } catch (SystemException e) {
            throw new ApplicationException(DbxErrorMessages.業務コンフィグなし.getMessage().replace(ConfigNameDBE.認定調査期限設定方法.name()));
        }
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
        handler.set委託先基本情報(row);

        ViewStateHolder.put(ViewStateKeys.調査員コード, row.getChosainCode().getValue());
        ViewStateHolder.put(ViewStateKeys.調査員割付可能人数_月, row.getChosaKanoNinzuPerMonth());
        setData(new ChosainCode(row.getChosainCode().getValue()), handler);
        handler.init印刷条件DIV();
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査員一覧の選択処理で調査員を選択せず、「調査対象者選択に進む」BTNをクリックした場合に行う処理を定義します。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnNextChosaTaishoshaSelect(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        handler.reset委託先基本情報();

        ViewStateHolder.put(ViewStateKeys.調査員コード, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.調査員割付可能人数_月, RString.EMPTY);
        setData(null, handler);
        handler.init印刷条件DIV();
        return ResponseData.of(div).respond();
    }

    private void setData(ChosainCode 調査員コード, NinteiChosaIraiHandler handler) {
        ChosaItakusakiCode 認定調査委託先コード = new ChosaItakusakiCode(ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class));
        RString 支所コード = ViewStateHolder.get(ViewStateKeys.支所コード, RString.class);
        ShoKisaiHokenshaNo 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);
        RString 保険者名称 = ViewStateHolder.get(ViewStateKeys.保険者名称, RString.class);

        NinnteiChousairaiParameter parameter
                = NinnteiChousairaiParameter.createParamfor割付済み申請者一覧(証記載保険者番号, 支所コード, 認定調査委託先コード, 調査員コード);
        List<WaritsukeBusiness> 割付済み申請者一覧 = NinnteiChousairaiFinder.createInstance().get割付済み申請者(parameter);
        handler.set割付済み申請者一覧(割付済み申請者一覧, 保険者名称);

        parameter = NinnteiChousairaiParameter.createParam調査委託先Or未割付申請者(証記載保険者番号, 支所コード);
        List<WaritsukeBusiness> 未割付申請者一覧 = NinnteiChousairaiFinder.createInstance().get新規依頼未割付申請者(parameter);

        parameter = NinnteiChousairaiParameter.createParam調査委託先Or未割付申請者(証記載保険者番号, 支所コード);
        List<WaritsukeBusiness> 未割付再依頼一覧 = NinnteiChousairaiFinder.createInstance().get再依頼未割付申請者(parameter);
        List<WaritsukeBusiness> 申請者一覧 = new ArrayList<>();
        申請者一覧.addAll(未割付申請者一覧);
        申請者一覧.addAll(未割付再依頼一覧);
        handler.set未割付申請者一覧(申請者一覧, 保険者名称);

        parameter = NinnteiChousairaiParameter.createParamfor割付済み申請者一覧(証記載保険者番号, 支所コード, 認定調査委託先コード, 調査員コード);
        List<NinteichosaIraiJohoRelateBusiness> 割付済み一覧 = NinnteiChousairaiFinder.createInstance().getNinteichosaIraiJohoList(parameter);
        List<NinteiKanryoJoho> ninteiKanryoJohoList = new ArrayList<>();
        List<NinteichosaIraiJoho> ninteichosaIraiJohoList = new ArrayList<>();
        if (!割付済み一覧.isEmpty()) {
            ninteiKanryoJohoList = 割付済み一覧.get(0).getNinteiKanryoJohoList();
            ninteichosaIraiJohoList = 割付済み一覧.get(0).getNinteichosaIraiJohoList();
        }
        ViewStateHolder.put(ViewStateKeys.認定調査依頼情報, Models.create(ninteichosaIraiJohoList));
        ViewStateHolder.put(ViewStateKeys.要介護認定完了情報, Models.create(ninteiKanryoJohoList));
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
        handler.initIndex();
        return ResponseData.of(div).respond();
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
        boolean isSonzai = false;
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            if (WARITSUKE_ZUMI.equals(row.getJotai())) {
                isSonzai = true;
                break;
            }
        }

        if (isSonzai) {
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
        handler.initIndex();
        return ResponseData.of(div).respond();
    }

    /**
     * 「認定調査委託先選択へ戻る」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnBackToChosaItakusakiSentaku(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        if (handler.isUpdate()) {
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
        handler.load(false);
        return ResponseData.of(div).setState(DBE2200001StateName.初期表示);
    }

    /**
     * 「調査委託先選択に戻る」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnBackToItakusakiSentaku(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        handler.load(false);
        ShoKisaiHokenshaNo 保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
        RString 支所コード = ShishoSecurityJoho.createInstance().getShishoCode(ControlDataHolder.getUserId());
        ViewStateHolder.put(ViewStateKeys.支所コード, 支所コード);
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, 保険者番号);
        NinnteiChousairaiParameter parameter = NinnteiChousairaiParameter.createParam調査委託先Or未割付申請者(保険者番号, 支所コード);
        List<NinnteiChousairaiBusiness> 認定調査委託先List = NinnteiChousairaiFinder.createInstance().get認定調査委託先(parameter);
        handler.set認定調査委託先一覧(認定調査委託先List);
        return ResponseData.of(div).setState(DBE2200001StateName.初期表示);
    }

    /**
     * 「認定調査員選択へ戻る」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnBackToChosainSentaku(NinteiChosaIraiDiv div) {
        NinteiChosaIraiHandler handler = getHandler(div);
        if (handler.isUpdate()) {
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
        dgChosaItakusakiIchiran_Row row = div.getDgChosaItakusakiIchiran().getActiveRow();
        ChosaItakusakiCode chosaItakusakiCode = new ChosaItakusakiCode(row.getChosaItakusakiCode().getValue());
        ViewStateHolder.put(ViewStateKeys.認定調査委託先コード, row.getChosaItakusakiCode().getValue());

        ViewStateHolder.put(ViewStateKeys.保険者名称, row.getHokenshaName());
        ViewStateHolder.put(ViewStateKeys.認定調査委託先割付定員, row.getWaritsukeTeiin().getText());
        RString 支所コード = ViewStateHolder.get(ViewStateKeys.支所コード, RString.class);
        ShoKisaiHokenshaNo 保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);
        NinnteiChousairaiParameter parameter = NinnteiChousairaiParameter.createParamfor調査員情報(
                保険者番号, 支所コード, chosaItakusakiCode);
        List<NinnteiChousairaiBusiness> 調査員情報一覧 = NinnteiChousairaiFinder.createInstance().get調査員(parameter);
        handler.set調査員情報一覧(調査員情報一覧, row);
        setData(null, handler);
        return ResponseData.of(div).setState(DBE2200001StateName.委託先選択後);
    }

    /**
     * 「割付内容を保存する」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnHozon(NinteiChosaIraiDiv div) {
        if (!ResponseHolder.isReRequest() && !getHandler(div).isUpdateForHozon()) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            insertNinteichosaIraiJoho(div);
            updateNinteichosaIraiJoho(div);
            div.getKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBE2200001StateName.保存完了);
        }
        return ResponseData.of(div).respond();
    }

    private void insertNinteichosaIraiJoho(NinteiChosaIraiDiv div) {
        List<dgWaritsukeZumiShinseishaIchiran_Row> 割付済み申請者List = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();
        NinteichosaIraiJohoManager ninteichosaIraiJohoManager = NinteichosaIraiJohoManager.createInstance();
        RDate nowDate = RDate.getNowDate();
        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, nowDate, SubGyomuCode.DBE認定支援);
        RString 認定調査期限日数 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数, nowDate, SubGyomuCode.DBE認定支援);
        FlexibleDate 認定調査依頼年月日 = new FlexibleDate(div.getTxtChosaIraiDay().getValue().toDateString());
        for (dgWaritsukeZumiShinseishaIchiran_Row row : 割付済み申請者List) {
            if (MIWARITSUKE.equals(row.getJotai())) {
                ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
                int 認定調査依頼履歴番号 = Integer.parseInt(row.getNinteichosaIraiRirekiNo().toString());
                RString 調査員コード = div.getTxtChosainCode().getValue();
                RString 認定調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class);

                FlexibleDate 認定申請日 = new FlexibleDate(row.getNinteiShinseiDay().getValue().toDateString());
                FlexibleDate 認定調査期限年月日;
                if (設定方法.equals(認定調査期限設定方法)) {
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
                    update要介護認定申請情報(申請書管理番号, 調査員コード, 認定調査委託先コード);
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
                }
                row.setJotai(WARITSUKE_ZUMI);
            }
        }
        div.getDgWaritsukeZumiShinseishaIchiran().setDataSource(割付済み申請者List);
    }

    private void update要介護認定申請情報(ShinseishoKanriNo 申請書管理番号, RString 調査員コード, RString 認定調査委託先コード) {
        NinteiShinseiJohoManager manager = NinteiShinseiJohoManager.createInstance();
        NinteiShinseiJoho ninteiShinseiJoho = manager.get要介護認定申請情報(申請書管理番号);
        ninteiShinseiJoho = ninteiShinseiJoho.createBuilderForEdit()
                .set認定調査委託先コード(new ChosaItakusakiCode(認定調査委託先コード))
                .set認定調査員コード(new ChosainCode(調査員コード))
                .build();
        manager.save要介護認定申請情報(ninteiShinseiJoho.modifiedModel());
    }

    private void updateNinteichosaIraiJoho(NinteiChosaIraiDiv div) {
        List<dgMiwaritsukeShinseishaIchiran_Row> miwaritsukeShinseishaIchiran = div.getDgMiwaritsukeShinseishaIchiran().getDataSource();
        Models<NinteichosaIraiJohoIdentifier, NinteichosaIraiJoho> ninteichosaIraiJohoList = ViewStateHolder.get(ViewStateKeys.認定調査依頼情報, Models.class);
        Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> ninteiKanryoJohoList = ViewStateHolder.get(ViewStateKeys.要介護認定完了情報, Models.class);
        NinteichosaIraiJohoManager ninteichosaIraiJohoManager = NinteichosaIraiJohoManager.createInstance();
        NinteiKanryoJohoManager ninteiKanryoJohoManager = NinteiKanryoJohoManager.createInstance();
        for (dgMiwaritsukeShinseishaIchiran_Row row : miwaritsukeShinseishaIchiran) {
            if (WARITSUKE_ZUMI.equals(row.getJotai())) {
                ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
                int 認定調査依頼履歴番号 = Integer.parseInt(row.getNinteichosaIraiRirekiNo().toString());
                NinteichosaIraiJohoIdentifier ninteichosaIraiJohoIdentifier = new NinteichosaIraiJohoIdentifier(申請書管理番号, 認定調査依頼履歴番号);
                NinteichosaIraiJoho ninteichosaIraiJoho
                        = ninteichosaIraiJohoList.get(ninteichosaIraiJohoIdentifier).createBuilderForEdit().set論理削除フラグ(true).build();
                ninteichosaIraiJohoManager.save認定調査依頼情報(ninteichosaIraiJoho.modifiedModel());

                NinteiKanryoJohoIdentifier ninteiKanryoJohoIdentifier = new NinteiKanryoJohoIdentifier(申請書管理番号);
                NinteiKanryoJoho ninteiKanryoJoho = ninteiKanryoJohoList.get(ninteiKanryoJohoIdentifier).createBuilderForEdit().set認定調査依頼完了年月日(FlexibleDate.EMPTY)
                        .set認定調査完了年月日(FlexibleDate.EMPTY).build();
                ninteiKanryoJohoManager.save要介護認定完了情報(ninteiKanryoJoho.modifiedModel());
                row.setJotai(MIWARITSUKE);
            }
        }
    }

    /**
     * 提出期限のonChange処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onChange_radKigen(NinteiChosaIraiDiv div) {
        getHandler(div).onChange_radKigen();
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択した帳票を発行する」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<NinteiChosaIraiDiv> onBeforeClick_BtnPrint(NinteiChosaIraiDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        NinteiChosaIraiValidationHandler handler = new NinteiChosaIraiValidationHandler();
        pairs = handler.validate割付済申請者未指定(pairs, div);
        pairs = handler.validate認定調査依頼未割付(pairs, div);
        return ResponseData.of(div).addValidationMessages(pairs).respond();
    }

    /**
     * 「選択した帳票を発行する」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> onClick_BtnPrint(NinteiChosaIraiDiv div) {
        List<RString> list = new ArrayList<>();
        List<RString> chkirai = div.getChkirai().getSelectedKeys();
        if (!chkirai.isEmpty()) {
            list.add(CHKNAME_認定調査依頼書);
        }
        List<RString> chkchosa = div.getChkchosa().getSelectedValues();
        List<RString> chktokkijiko = div.getChkChosahyoTokkijiko().getSelectedValues();
        List<RString> chkchosaOcr = div.getChkchosaOcr().getSelectedValues();
        List<RString> chkchosaSonota = div.getChkchosaSonota().getSelectedValues();
        list.addAll(chkchosa);
        list.addAll(chktokkijiko);
        list.addAll(chkchosaOcr);
        list.addAll(chkchosaSonota);
        if (list.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.未指定.getMessage().replace("発行書類を"));
        }
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        try (ReportManager reportManager = new ReportManager()) {
            printData(list, div, reportManager, getHandler(div));
            response.data = reportManager.publish();
        }
        return response;
    }

    private void printData(List<RString> checkList, NinteiChosaIraiDiv div, ReportManager reportManager, NinteiChosaIraiHandler handler) {
        updateNinteichosaIraiJohoForPrint(div);
        NinteiChosaIraiPrintService ninteiChosaIraiPrintService = new NinteiChosaIraiPrintService(reportManager);
        if (checkList.contains(CHKNAME_認定調査依頼書)) {
            ninteiChosaIraiPrintService.print要介護認定調査依頼書(handler.create認定調査依頼書印刷用パラメータ());
        }
        if (checkList.contains(CHKNAME_認定調査票デザイン用紙)) {
            call認定調査票_デザイン用紙(ninteiChosaIraiPrintService, handler);
        }
        if (checkList.contains(CHKNAME_特記事項デザイン用紙)) {
            call認定調査票_特記事項(ninteiChosaIraiPrintService, handler);
        }
        if (checkList.contains(CHKNAME_特記事項_項目有り)) {
            call認定調査票_特記事項_項目有り(div, ninteiChosaIraiPrintService, handler);
        }
        if (checkList.contains(CHKNAME_特記事項_項目無し)) {
            call認定調査票_特記事項_項目無し(div, ninteiChosaIraiPrintService, handler);
        }
        if (checkList.contains(CHKNAME_特記事項_項目フリータイプ)) {
            call認定調査票_特記事項_フリータイプ(div, ninteiChosaIraiPrintService, handler);
        }
        if (checkList.contains(CHKNAME_認定調査票OCR)) {
            call認定調査票_OCR(ninteiChosaIraiPrintService, handler);
        }
        if (checkList.contains(CHKNAME_特記事項OCR)) {
            call認定調査票OCR_特記事項(ninteiChosaIraiPrintService, handler);
        }
        if (checkList.contains(CHKNAME_差異チェック票)) {
            call認定調査差異チェック表(ninteiChosaIraiPrintService, handler);
        }
        if (checkList.contains(CHKNAME_概況特記)) {
            call概況特記(ninteiChosaIraiPrintService, handler);
        }
    }

    private void call概況特記(NinteiChosaIraiPrintService ninteiChosaIraiPrintService, NinteiChosaIraiHandler handler) {
        ninteiChosaIraiPrintService.print概況特記(handler.create概況特記_パラメータ());
    }

    private void call認定調査差異チェック表(NinteiChosaIraiPrintService ninteiChosaIraiPrintService, NinteiChosaIraiHandler handler) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            ninteiChosaIraiPrintService.print要介護認定調査票差異チェック票(handler.create調査票差異チェック票_DBE292001パラメータ());
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            ninteiChosaIraiPrintService.print要介護認定調査票差異チェック票_両面右(handler.create調査票差異チェック票_DBE292004パラメータ());
        } else if (CONFIGVALUE3.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            ninteiChosaIraiPrintService.print要介護認定調査票差異チェック票_両面左(handler.create調査票差異チェック票_DBE292004パラメータ());
        }
    }

    private void call認定調査票_OCR(NinteiChosaIraiPrintService ninteiChosaIraiPrintService, NinteiChosaIraiHandler handler) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_用紙タイプ, date, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                ninteiChosaIraiPrintService.print認定調査票OCR片面(handler.create認定調査票_概況調査_基本調査パラメータ());
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                ninteiChosaIraiPrintService.print認定調査票OCR両面(handler.create認定調査票_概況調査_基本調査パラメータ());
            }
        }
    }

    private void call認定調査票OCR_特記事項(NinteiChosaIraiPrintService ninteiChosaIraiPrintService, NinteiChosaIraiHandler handler) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_用紙タイプ, date, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                ninteiChosaIraiPrintService.print認定調査票_特記事項_OCR片面(handler.create認定調査票_特記事項パラメータ(false));
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                ninteiChosaIraiPrintService.print認定調査票_特記事項_OCR両面(handler.create認定調査票_特記事項パラメータ(true));
            }
        }
    }

    private void call認定調査票_デザイン用紙(NinteiChosaIraiPrintService ninteiChosaIraiPrintService, NinteiChosaIraiHandler handler) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            ninteiChosaIraiPrintService.print認定調査票_デザイン用紙片面(handler.create認定調査票_概況調査_基本調査パラメータ());
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            ninteiChosaIraiPrintService.print認定調査票_デザイン用紙両面(handler.create認定調査票_概況調査_基本調査パラメータ());
        }
    }

    private void call認定調査票_特記事項(NinteiChosaIraiPrintService ninteiChosaIraiPrintService, NinteiChosaIraiHandler handler) {
        ninteiChosaIraiPrintService.print認定調査票_特記事項_デザイン用紙(handler.create認定調査票_特記事項パラメータ(false));
    }

    private void call認定調査票_特記事項_項目有り(NinteiChosaIraiDiv div,
            NinteiChosaIraiPrintService ninteiChosaIraiPrintService, NinteiChosaIraiHandler handler) {
        if (div.getChkTokkijikoTenyuryoku().getSelectedItems().isEmpty()) {
            ninteiChosaIraiPrintService.print認定調査票_特記事項_項目有り(handler.create認定調査票_特記事項パラメータ(false));
        } else {
            ninteiChosaIraiPrintService.print認定調査票_特記事項_項目有り_手入力(handler.create認定調査票_特記事項パラメータ(false));
        }

    }

    private void call認定調査票_特記事項_項目無し(NinteiChosaIraiDiv div,
            NinteiChosaIraiPrintService ninteiChosaIraiPrintService, NinteiChosaIraiHandler handler) {
        if (div.getChkTokkijikoTenyuryoku().getSelectedItems().isEmpty()) {
            ninteiChosaIraiPrintService.print認定調査票_特記事項_項目無し(handler.create認定調査票_特記事項パラメータ(false));
        } else {
            ninteiChosaIraiPrintService.print認定調査票_特記事項_項目無し_手入力(handler.create認定調査票_特記事項パラメータ(false));
        }
    }

    private void call認定調査票_特記事項_フリータイプ(NinteiChosaIraiDiv div,
            NinteiChosaIraiPrintService ninteiChosaIraiPrintService, NinteiChosaIraiHandler handler) {
        if (div.getChkTokkijikoTenyuryoku().getSelectedItems().isEmpty()) {
            ninteiChosaIraiPrintService.print認定調査票_特記事項_フリータイプ(handler.create認定調査票_特記事項パラメータ(false));
        } else {
            ninteiChosaIraiPrintService.print認定調査票_特記事項_フリータイプ_手入力(handler.create認定調査票_特記事項パラメータ(false));
        }
    }

    private void updateNinteichosaIraiJohoForPrint(NinteiChosaIraiDiv div) {
        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
        NinnteiChousairaiFinder ninnteiChousairaiFinder = NinnteiChousairaiFinder.createInstance();
        NinteichosaIraiJohoManager ninteichosaIraiJohoManager = NinteichosaIraiJohoManager.createInstance();
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            NinteichosaIraiJoho 認定調査依頼情報 = ninnteiChousairaiFinder.get認定調査依頼情報(row.getShinseishoKanriNo());
            if (認定調査依頼情報 == null) {
                continue;
            }
            RString 提出期限 = div.getRadkigen().getSelectedKey();
            FlexibleDate 発行日 = new FlexibleDate(div.getTxthokkoymd().getValue().toDateString());
            if (div.getChkirai().getSelectedValues().contains(CHKNAME_認定調査依頼書)) {
                FlexibleDate 認定調査期限年月日 = 認定調査依頼情報.get認定調査依頼年月日();
                RDate date = RDate.getNowDate();
                RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, date, SubGyomuCode.DBE認定支援);
                RString 認定調査作成期限日数 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数, date, SubGyomuCode.DBE認定支援);
                if (設定方法.equals(認定調査期限設定方法) && 提出期限_0.equals(提出期限)) {
                    認定調査期限年月日 = 認定調査期限年月日.plusDay(Integer.parseInt(認定調査作成期限日数.toString()));
                } else if (設定方法.equals(認定調査期限設定方法) && 提出期限_1.equals(提出期限)) {
                    認定調査期限年月日 = FlexibleDate.EMPTY;
                } else if (設定方法.equals(認定調査期限設定方法) && 提出期限_2.equals(提出期限)) {
                    認定調査期限年月日 = new FlexibleDate(div.getTxtkigenymd().getValue().toDateString());
                }
                認定調査依頼情報 = 認定調査依頼情報.createBuilderForEdit().set依頼書出力年月日(発行日)
                        .set認定調査期限年月日(認定調査期限年月日).build();
                ninteichosaIraiJohoManager.save認定調査依頼情報(認定調査依頼情報.modifiedModel());
            } else {
                認定調査依頼情報 = 認定調査依頼情報.createBuilderForEdit().set依頼書出力年月日(発行日)
                        .set調査票等出力年月日(発行日).build();
                ninteichosaIraiJohoManager.save認定調査依頼情報(認定調査依頼情報.modifiedModel());
            }
        }
    }

    /**
     * 割付済みの「照会」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_WaritsukeZumiShokai(NinteiChosaIraiDiv div) {
        dgWaritsukeZumiShinseishaIchiran_Row row = div.getDgWaritsukeZumiShinseishaIchiran().getActiveRow();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo(row.getHihokenshaNo()));
        return ResponseData.of(div).respond();
    }

    /**
     * 未割付の「照会」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_MiwaritsukeShokai(NinteiChosaIraiDiv div) {
        dgMiwaritsukeShinseishaIchiran_Row row = div.getDgMiwaritsukeShinseishaIchiran().getActiveRow();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo(row.getHihokenshaNo()));
        return ResponseData.of(div).respond();
    }

    private NinteiChosaIraiHandler getHandler(NinteiChosaIraiDiv div) {
        return new NinteiChosaIraiHandler(div);
    }
}
