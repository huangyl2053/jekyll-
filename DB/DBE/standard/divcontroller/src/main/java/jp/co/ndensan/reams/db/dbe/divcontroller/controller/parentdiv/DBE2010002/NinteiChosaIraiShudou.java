/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2010002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairaishudou.NinnteiChousairaiShudouBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaijoho.ninteichosairaijoho.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaijoho.ninteichosairaijoho.NinteichosaIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaijoho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaijoho.ninteishinseijoho.NinteiShinseiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho2;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairaishudou.NinnteiChousairaiShudouParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010002.DBE2010002StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010002.NinteiChosaIraiShudouDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010002.NinteiChosaIraiShudouHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010002.NinteiChosaIraiShudouValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ninnteichousairaishudou.NinnteiChousairaiShudouFinder;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ninnteichousairaishudou.NinnteiChousairaiShudouPrintService;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosairaijoho.ninteichosairaijoho.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.ninteishinseijoho.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.message.DbQuestionMessages;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 認定調査依頼(手動)のコントローラです。
 *
 * @reamsid_L DBE-1590-010 sunhaidi
 */
public class NinteiChosaIraiShudou {

    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");
    private static final RString KEY2 = new RString("2");
    private static final RString CONFIGVALUE1 = new RString("1");
    private static final RString CONFIGVALUE2 = new RString("2");
    private static final RString CONFIGVALUE3 = new RString("3");
    private static final RString 新規モード = new RString("新規");
    private static final RString 修正モード = new RString("修正");
    private static final RString CHKNAME_認定調査票デザイン用紙 = new RString("認定調査票（デザイン用紙）");
    private static final RString CHKNAME_特記事項デザイン用紙 = new RString("特記事項（デザイン用紙）");
    private static final RString CHKNAME_特記事項_項目有り = new RString("特記事項（項目有り）");
    private static final RString CHKNAME_特記事項_項目無し = new RString("特記事項（項目無し）");
    private static final RString CHKNAME_特記事項_項目フリータイプ = new RString("特記事項（フリータイプ）");
    private static final RString CHKNAME_認定調査票OCR = new RString("認定調査票OCR");
    private static final RString CHKNAME_特記事項OCR = new RString("特記事項OCR");
    private static final RString CHKNAME_差異チェック票 = new RString("認定調査差異チェック票");
    private static final RString CHKNAME_概況特記 = new RString("概況特記");
    private static final RString CHKNAME_認定調査依頼該当者履歴一覧 = new RString("認定調査依頼該当者履歴一覧");

    /**
     * 画面初期化処理です。
     *
     * @param div NinteiChosaIraiShudouDiv
     * @return ResponseData<NinteiChosaIraiShudouDiv>
     */
    public ResponseData<NinteiChosaIraiShudouDiv> onLoad(NinteiChosaIraiShudouDiv div) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        if (!RealInitialLocker.tryGetLock(get排他キー())) {
            throw new PessimisticLockingException();
        }
        div.setReadOnly(false);
        NinnteiChousairaiShudouFinder finder = NinnteiChousairaiShudouFinder.createInstance();
        NinnteiChousairaiShudouParameter parameter = NinnteiChousairaiShudouParameter.createParameterBy申請書管理番号(申請書管理番号.value());
        List<NinnteiChousairaiShudouBusiness> 認定調査依頼List = finder.get認定調査依頼情報(parameter).records();
        List<NinteiShinseiJoho> 更新用認定調査依頼List = finder.get更新用認定調査依頼情報(parameter).records();
        getHandler(div).onLoad(認定調査依頼List);
        ViewStateHolder.put(ViewStateKeys.認定調査依頼情報, Models.create(更新用認定調査依頼List));
        if (!認定調査依頼List.isEmpty()) {
            NinnteiChousairaiShudouBusiness 認定調査依頼 = 認定調査依頼List.get(0);
            ViewStateHolder.put(ViewStateKeys.厚労省IF識別コード, 認定調査依頼.get厚労省IF識別コード());
            ViewStateHolder.put(ViewStateKeys.認定申請年月日, 認定調査依頼.get認定申請年月日());
            ViewStateHolder.put(ViewStateKeys.認定調査依頼履歴番号, 認定調査依頼.get認定調査依頼履歴番号());

            if (RString.isNullOrEmpty(認定調査依頼.get認定調査依頼履歴番号())) {
                ViewStateHolder.put(ViewStateKeys.モード, 新規モード);
            } else {
                ViewStateHolder.put(ViewStateKeys.モード, 修正モード);
            }
        }

        div.getCcdItakusakiAndChosainInput().getBtnChosaItakusakiGuide().setDisabled(true);

        if (NinteiShinseiShinseijiKubunCode.転入申請.get名称().equals(
                div.getCcdNinteiShinseishaKihonInfo().get申請区分申請時())) {
            div.getNinteichosaIraiByHand().setDisabled(true);
            div.getIraiprintPanel().setDisabled(true);
            return ResponseData.of(div).setState(DBE2010002StateName.ReadOnly);
        }

        return ResponseData.of(div).respond();
    }

    private LockingKey get排他キー() {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        RStringBuilder lockingKey = new RStringBuilder(new RString("ShinseishoKanriNo"));
        lockingKey.append(申請書管理番号);
        return new LockingKey(lockingKey.toRString());
    }

    /**
     * 提出期限のonChange処理です。
     *
     * @param div NinteiChosaIraiShudouDiv
     * @return ResponseData<NinteiChosaIraiShudouDiv>
     */
    public ResponseData<NinteiChosaIraiShudouDiv> onChange_radKigen(NinteiChosaIraiShudouDiv div) {
        getHandler(div).onChange_radKigen();
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押す処理です。
     *
     * @param div NinteiChosaIraiShudouDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<NinteiChosaIraiShudouDiv> onClick_btnCommonSaveChosaIrai(NinteiChosaIraiShudouDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).checkForUpdate();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {            
            saveData(div);
            ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
            List<NinteiShinseiJoho> 更新用認定調査依頼List = NinnteiChousairaiShudouFinder.createInstance().get更新用認定調査依頼情報(
                    NinnteiChousairaiShudouParameter.createParameterBy申請書管理番号(申請書管理番号.value())).records();
            ViewStateHolder.put(ViewStateKeys.認定調査依頼情報, Models.create(更新用認定調査依頼List));
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void saveData(NinteiChosaIraiShudouDiv div) {
        Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> 認定調査依頼情報List = ViewStateHolder.get(ViewStateKeys.認定調査依頼情報, Models.class);
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        RString 認定調査依頼履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査依頼履歴番号, RString.class);

        RString 厚労省IF識別コード = ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class);
        JigyoshaNo 認定調査委託先コード = new JigyoshaNo(div.getNinteichosaIraiByHand().getCcdItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue());
        RString 認定調査員コード = div.getNinteichosaIraiByHand().getCcdItakusakiAndChosainInput().getTxtChosainCode().getValue();
        Code 認定調査依頼区分コード = new Code(div.getNinteichosaIraiByHand().getDdlIraiKubun().getSelectedKey());
        FlexibleDate 認定調査依頼年月日 = FlexibleDate.EMPTY;
        if (div.getNinteichosaIraiByHand().getTxtChosaIraiD().getValue() != null) {
            認定調査依頼年月日 = new FlexibleDate(div.getNinteichosaIraiByHand().getTxtChosaIraiD().getValue().toDateString());
        }
        NinteiShinseiJohoIdentifier ninteiShinseiJohoIdentifier = new NinteiShinseiJohoIdentifier(申請書管理番号);

        NinteiShinseiJoho 要介護認定申請情報 = 認定調査依頼情報List.get(ninteiShinseiJohoIdentifier);
        要介護認定申請情報 = 要介護認定申請情報.createBuilderForEdit()
                .set認定調査委託先コード(new ChosaItakusakiCode(認定調査委託先コード.value()))
                .set認定調査員コード(new ChosainCode(認定調査員コード)).build();
        jp.co.ndensan.reams.db.dbe.service.core.ninteichosairaijoho.ninteishinseijoho.NinteiShinseiJohoManager
                .createInstance().save(要介護認定申請情報.modifiedModel());
        RString モード = ViewStateHolder.get(ViewStateKeys.モード, RString.class);
        if (新規モード.equals(モード)) {
            NinteichosaIraiJoho 認定調査依頼情報 = new NinteichosaIraiJoho(申請書管理番号, 1);
            認定調査依頼情報 = 認定調査依頼情報.createBuilderForEdit().set厚労省IF識別コード(new Code(厚労省IF識別コード))
                    .set認定調査委託先コード(認定調査委託先コード)
                    .set認定調査員コード(認定調査員コード)
                    .set認定調査依頼区分コード(認定調査依頼区分コード)
                    .set認定調査回数(1)
                    .set認定調査依頼年月日(認定調査依頼年月日)
                    .set認定調査期限年月日(get認定調査期限年月日(div, 認定調査依頼年月日)).set論理削除フラグ(false)
                    .set認定調査督促年月日(FlexibleDate.EMPTY).set認定調査督促メモ(RString.EMPTY).build();
            NinteichosaIraiJohoManager.createInstance().save認定調査依頼情報(認定調査依頼情報);
        } else if (修正モード.equals(モード)) {
            NinteichosaIraiJohoIdentifier ninteichosaIraiJohoIdentifier = new NinteichosaIraiJohoIdentifier(申請書管理番号,
                    Integer.parseInt(認定調査依頼履歴番号.toString()));
            NinteichosaIraiJoho ninteichosaIraiJoho = 要介護認定申請情報.getNinteichosaIraiJoho(ninteichosaIraiJohoIdentifier);

            ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit().set厚労省IF識別コード(new Code(厚労省IF識別コード))
                    .set認定調査委託先コード(認定調査委託先コード)
                    .set認定調査員コード(認定調査員コード)
                    .set認定調査依頼年月日(認定調査依頼年月日)
                    .set認定調査期限年月日(get認定調査期限年月日(div, 認定調査依頼年月日))
                    .set論理削除フラグ(false).build();
            if (RString.isNullOrEmpty(ninteichosaIraiJoho.get認定調査督促メモ())) {
                ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit().set認定調査督促メモ(RString.EMPTY).build();
            }
            if (ninteichosaIraiJoho.get認定調査督促年月日() == null) {
                ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit().set認定調査督促年月日(FlexibleDate.EMPTY).build();
            }
            if (ninteichosaIraiJoho.get認定調査回数() == 0) {
                ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit().set認定調査回数(認定調査依頼履歴番号.toInt()).build();
            }
            RString 依頼書出力年月日_更新区分 = ViewStateHolder.get(ViewStateKeys.依頼書出力年月日_更新区分, RString.class);
            RString 調査票等出力年月日_更新区分 = ViewStateHolder.get(ViewStateKeys.調査票等出力年月日_更新区分, RString.class);
            FlexibleDate 発行日 = FlexibleDate.EMPTY;
            if (div.getTxtHokkoymd().getValue() != null) {
                発行日 = new FlexibleDate(div.getTxtHokkoymd().getValue().toDateString());
            }
            if (!RString.isNullOrEmpty(依頼書出力年月日_更新区分)) {
                ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit().set依頼書出力年月日(発行日).build();
            }
            if (!RString.isNullOrEmpty(調査票等出力年月日_更新区分)) {
                ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit().set調査票等出力年月日(発行日).build();
            }
            NinteichosaIraiJohoManager.createInstance().save認定調査依頼情報(ninteichosaIraiJoho.modifiedModel());
        }
    }

    private FlexibleDate get認定調査期限年月日(NinteiChosaIraiShudouDiv div, FlexibleDate 認定調査依頼年月日) {
        FlexibleDate 認定調査期限年月日 = FlexibleDate.EMPTY;
        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString key = div.getRadKigen().getSelectedKey();
        int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        if (CONFIGVALUE1.equals(認定調査期限設定方法)) {
            if (KEY0.equals(key)) {
                認定調査期限年月日 = 認定調査依頼年月日.plusDay(期限日数);
            } else if (KEY1.equals(key)) {
                認定調査期限年月日 = FlexibleDate.EMPTY;
            } else if (KEY2.equals(key)) {
                RDate 共通日 = div.getTxtKigenymd().getValue();
                認定調査期限年月日 = (共通日 != null ? new FlexibleDate(共通日.plusDay(期限日数).toString()) : FlexibleDate.EMPTY);
            }
        } else {
            RString 認定申請年月日 = ViewStateHolder.get(ViewStateKeys.認定申請年月日, RString.class);
            認定調査期限年月日 = !RString.isNullOrEmpty(認定申請年月日)
                    ? new FlexibleDate(認定申請年月日).plusDay(期限日数) : FlexibleDate.EMPTY;
        }
        return 認定調査期限年月日;
    }

    /**
     * 「発行するボタンを押すチェック処理です。
     *
     * @param div NinteiChosaIraiShudouDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<NinteiChosaIraiShudouDiv> onClick_btnPrint_check(NinteiChosaIraiShudouDiv div) {

        ValidationMessageControlPairs validPairs = getValidationHandler(div).印刷帳票チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbQuestionMessages.処理実行の確認.getMessage()).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 選択された帳票を発行するボタンを押す処理です。
     *
     * @param div NinteiChosaIraiShudouDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> onClick_btnPrint(NinteiChosaIraiShudouDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        updateData(div);
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        AccessLogger.log(AccessLogType.照会, toPersonalData(申請書管理番号.value()));
        try (ReportManager reportManager = new ReportManager()) {
            printData(div, reportManager);
            response.data = reportManager.publish();
        }
        List<NinteiShinseiJoho> 更新用認定調査依頼List = NinnteiChousairaiShudouFinder.createInstance().get更新用認定調査依頼情報(
                NinnteiChousairaiShudouParameter.createParameterBy申請書管理番号(申請書管理番号.value())).records();
        ViewStateHolder.put(ViewStateKeys.認定調査依頼情報, Models.create(更新用認定調査依頼List));
        return response;
    }

    private void updateData(NinteiChosaIraiShudouDiv div) {
        Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> 認定調査依頼情報List = ViewStateHolder.get(ViewStateKeys.認定調査依頼情報, Models.class);
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        RString 認定調査依頼履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査依頼履歴番号, RString.class);
        JigyoshaNo 認定調査委託先コード = new JigyoshaNo(div.getNinteichosaIraiByHand().getCcdItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue());
        RString 認定調査員コード = div.getNinteichosaIraiByHand().getCcdItakusakiAndChosainInput().getTxtChosainCode().getValue();
        FlexibleDate 認定調査依頼年月日 = FlexibleDate.EMPTY;
        if (div.getNinteichosaIraiByHand().getTxtChosaIraiD().getValue() != null) {
            認定調査依頼年月日 = new FlexibleDate(div.getNinteichosaIraiByHand().getTxtChosaIraiD().getValue().toDateString());
        }

        NinteiShinseiJohoIdentifier ninteiShinseiJohoIdentifier = new NinteiShinseiJohoIdentifier(申請書管理番号);
        NinteiShinseiJoho 要介護認定申請情報 = 認定調査依頼情報List.get(ninteiShinseiJohoIdentifier);
        RString モード = ViewStateHolder.get(ViewStateKeys.モード, RString.class);
        if (修正モード.equals(モード)) {
            FlexibleDate 発行日 = FlexibleDate.EMPTY;
            if (div.getTxtHokkoymd().getValue() != null) {
                発行日 = new FlexibleDate(div.getTxtHokkoymd().getValue().toDateString());
            }
            NinteichosaIraiJohoIdentifier ninteichosaIraiJohoIdentifier = new NinteichosaIraiJohoIdentifier(
                    申請書管理番号, Integer.parseInt(認定調査依頼履歴番号.toString()));
            NinteichosaIraiJoho ninteichosaIraiJoho = 要介護認定申請情報.getNinteichosaIraiJoho(ninteichosaIraiJohoIdentifier);

            if (!div.getChkIrai().getSelectedKeys().isEmpty()) {
                ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit()
                        .set依頼書出力年月日(発行日).build();
            }
            if (!(div.getChkNinteichosaDesign().getSelectedKeys().isEmpty()
                    && div.getChkNinteichosaOcr().getSelectedKeys().isEmpty()
                    && div.getChkSaiCheck().getSelectedKeys().isEmpty()
                    && div.getChkTokkiJko().getSelectedKeys().isEmpty())) {
                ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit()
                        .set調査票等出力年月日(発行日).build();
            }
            ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit()
                    .set認定調査委託先コード(認定調査委託先コード)
                    .set認定調査員コード(認定調査員コード)
                    .set認定調査依頼年月日(認定調査依頼年月日)
                    .set認定調査期限年月日(get認定調査期限年月日(div, 認定調査依頼年月日)).build();
            NinteichosaIraiJohoManager.createInstance().save認定調査依頼情報(ninteichosaIraiJoho.modifiedModel());
        }
    }

    private void printData(NinteiChosaIraiShudouDiv div, ReportManager reportManager) {
        NinnteiChousairaiShudouPrintService printService = new NinnteiChousairaiShudouPrintService(reportManager);
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        NinnteiChousairaiShudouFinder finder = NinnteiChousairaiShudouFinder.createInstance();

        if (!div.getChkIrai().getSelectedKeys().isEmpty()) {
            NinnteiChousairaiShudouParameter parameter = NinnteiChousairaiShudouParameter.createParameterBy申請書管理番号(申請書管理番号.value());
            List<NinnteiChousairaiShudouBusiness> 認定調査依頼書List = finder.get認定調査依頼書(parameter).records();
            if (!認定調査依頼書List.isEmpty()) {
                printService.print要介護認定調査依頼書(getHandler(div).create認定調査依頼書印刷用パラメータ(認定調査依頼書List.get(0)));
            }
        }
        if (div.getChkNinteichosaDesign().getSelectedValues().contains(CHKNAME_認定調査票デザイン用紙)) {
            call認定調査票_デザイン用紙(div, printService);
        }
        if (div.getChkNinteichosaDesign().getSelectedValues().contains(CHKNAME_特記事項デザイン用紙)) {
            call認定調査票_特記事項(div, printService);
        }
        if (div.getChkTokkiJko().getSelectedValues().contains(CHKNAME_特記事項_項目有り)) {
            call認定調査票_特記事項_項目有り(div, printService);
        }
        if (div.getChkTokkiJko().getSelectedValues().contains(CHKNAME_特記事項_項目無し)) {
            call認定調査票_特記事項_項目無し(div, printService);
        }
        if (div.getChkTokkiJko().getSelectedValues().contains(CHKNAME_特記事項_項目フリータイプ)) {
            call認定調査票_特記事項_フリータイプ(div, printService);
        }
        if (div.getChkNinteichosaOcr().getSelectedValues().contains(CHKNAME_認定調査票OCR)) {
            call認定調査票_OCR(div, printService);
        }
        if (div.getChkNinteichosaOcr().getSelectedValues().contains(CHKNAME_特記事項OCR)) {
            call認定調査票OCR_特記事項(div, printService);
        }
        if (div.getChkSaiCheck().getSelectedValues().contains(CHKNAME_差異チェック票)) {
            call認定調査差異チェック表(div, printService);
        }
        if (div.getChkSaiCheck().getSelectedValues().contains(CHKNAME_概況特記)) {
            call概況特記(div, printService);
        }

        if (div.getChkSaiCheck().getSelectedValues().contains(CHKNAME_認定調査依頼該当者履歴一覧)) {
            NinnteiChousairaiShudouParameter parameter = NinnteiChousairaiShudouParameter.createParameterBy被保険者番号(div.getCcdNinteiShinseishaKihonInfo().get被保険者番号());
            List<NinnteiChousairaiShudouBusiness> 認定調査依頼該当者履歴一覧 = finder.get認定調査依頼該当者履歴一覧(parameter).records();
            if (!認定調査依頼該当者履歴一覧.isEmpty()) {
                printService.print認定調査依頼該当者履歴一覧(
                        getHandler(div).create調査依頼該当者履歴一覧印刷用パラメータ(認定調査依頼該当者履歴一覧));
            }
        }
    }

    private void call概況特記(NinteiChosaIraiShudouDiv div, NinnteiChousairaiShudouPrintService printService) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        NinteiShinseiJoho2 ninteiShinseiJoho = NinteiShinseiJohoManager.createInstance().get要介護認定申請情報(申請書管理番号);
        printService.print概況特記(getHandler(div).create概況特記_パラメータ(ninteiShinseiJoho));
    }

    private void call認定調査票_デザイン用紙(NinteiChosaIraiShudouDiv div, NinnteiChousairaiShudouPrintService printService) {
        RDate date = RDate.getNowDate();
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        List<NinnteiChousairaiShudouBusiness> 概況調査List = NinnteiChousairaiShudouFinder.createInstance()
                .get認定調査票_概況調査(NinnteiChousairaiShudouParameter.createParameterBy申請書管理番号(申請書管理番号.value())).records();
        if (!概況調査List.isEmpty()) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                printService.print認定調査票_デザイン用紙片面(getHandler(div).create認定調査票_概況調査_基本調査パラメータ(概況調査List.get(0)));
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                printService.print認定調査票_デザイン用紙両面(getHandler(div).create認定調査票_概況調査_基本調査パラメータ(概況調査List.get(0)));
            }
        }
    }

    private void call認定調査票_特記事項(NinteiChosaIraiShudouDiv div, NinnteiChousairaiShudouPrintService printService) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        List<NinnteiChousairaiShudouBusiness> 概況調査List = NinnteiChousairaiShudouFinder.createInstance()
                .get認定調査票_概況調査(NinnteiChousairaiShudouParameter.createParameterBy申請書管理番号(申請書管理番号.value())).records();
        if (!概況調査List.isEmpty()) {
            printService.print認定調査票_特記事項_デザイン用紙(getHandler(div).create認定調査票_特記事項パラメータ(概況調査List.get(0), false));
        }
    }

    private void call認定調査票_特記事項_項目有り(NinteiChosaIraiShudouDiv div, NinnteiChousairaiShudouPrintService printService) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        List<NinnteiChousairaiShudouBusiness> 概況調査List = NinnteiChousairaiShudouFinder.createInstance()
                .get認定調査票_概況調査(NinnteiChousairaiShudouParameter.createParameterBy申請書管理番号(申請書管理番号.value())).records();
        if (!概況調査List.isEmpty()) {
            if (div.getChkTenyuryoku().getSelectedItems().isEmpty()) {
                printService.print認定調査票_特記事項_項目有り(getHandler(div).create認定調査票_特記事項パラメータ(概況調査List.get(0), false));
            } else {
                printService.print認定調査票_特記事項_項目有り_手入力(getHandler(div).create認定調査票_特記事項パラメータ(概況調査List.get(0), false));
            }
        }
    }

    private void call認定調査票_特記事項_項目無し(NinteiChosaIraiShudouDiv div, NinnteiChousairaiShudouPrintService printService) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        List<NinnteiChousairaiShudouBusiness> 概況調査List = NinnteiChousairaiShudouFinder.createInstance()
                .get認定調査票_概況調査(NinnteiChousairaiShudouParameter.createParameterBy申請書管理番号(申請書管理番号.value())).records();
        if (!概況調査List.isEmpty()) {
            if (div.getChkTenyuryoku().getSelectedItems().isEmpty()) {
                printService.print認定調査票_特記事項_項目無し(getHandler(div).create認定調査票_特記事項パラメータ(概況調査List.get(0), false));
            } else {
                printService.print認定調査票_特記事項_項目無し_手入力(getHandler(div).create認定調査票_特記事項パラメータ(概況調査List.get(0), false));
            }
        }
    }

    private void call認定調査票_特記事項_フリータイプ(NinteiChosaIraiShudouDiv div, NinnteiChousairaiShudouPrintService printService) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        List<NinnteiChousairaiShudouBusiness> 概況調査List = NinnteiChousairaiShudouFinder.createInstance()
                .get認定調査票_概況調査(NinnteiChousairaiShudouParameter.createParameterBy申請書管理番号(申請書管理番号.value())).records();
        if (!概況調査List.isEmpty()) {
            if (div.getChkTenyuryoku().getSelectedItems().isEmpty()) {
                printService.print認定調査票_特記事項_フリータイプ(getHandler(div).create認定調査票_特記事項パラメータ(概況調査List.get(0), false));
            } else {
                printService.print認定調査票_特記事項_フリータイプ_手入力(getHandler(div).create認定調査票_特記事項パラメータ(概況調査List.get(0), false));
            }
        }
    }

    private void call認定調査差異チェック表(NinteiChosaIraiShudouDiv div, NinnteiChousairaiShudouPrintService printService) {
        RDate date = RDate.getNowDate();
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        List<NinnteiChousairaiShudouBusiness> businessList = NinnteiChousairaiShudouFinder.createInstance()
                .get認定調査票差異チェック票(NinnteiChousairaiShudouParameter.createParameterBy申請書管理番号(申請書管理番号.value())).records();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            printService.print要介護認定調査票差異チェック票_片面(getHandler(div).create調査票差異チェック票_DBE292004パラメータ(businessList));
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            printService.print要介護認定調査票差異チェック票_両面右(getHandler(div).create調査票差異チェック票_DBE292004パラメータ(businessList));
        } else if (CONFIGVALUE3.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            printService.print要介護認定調査票差異チェック票_両面左(getHandler(div).create調査票差異チェック票_DBE292004パラメータ(businessList));
        }
    }

    private void call認定調査票_OCR(NinteiChosaIraiShudouDiv div, NinnteiChousairaiShudouPrintService printService) {
        RDate date = RDate.getNowDate();
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        List<NinnteiChousairaiShudouBusiness> 概況調査List = NinnteiChousairaiShudouFinder.createInstance()
                .get認定調査票_概況調査(NinnteiChousairaiShudouParameter.createParameterBy申請書管理番号(申請書管理番号.value())).records();
        if (!概況調査List.isEmpty() && CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_用紙タイプ, date, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                printService.print認定調査票OCR片面(getHandler(div).create認定調査票_概況調査_基本調査パラメータ(概況調査List.get(0)));
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                printService.print認定調査票OCR両面(getHandler(div).create認定調査票_概況調査_基本調査パラメータ(概況調査List.get(0)));
            }
        }
    }

    private void call認定調査票OCR_特記事項(NinteiChosaIraiShudouDiv div, NinnteiChousairaiShudouPrintService printService) {
        RDate date = RDate.getNowDate();
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        List<NinnteiChousairaiShudouBusiness> 概況調査List = NinnteiChousairaiShudouFinder.createInstance()
                .get認定調査票_概況調査(NinnteiChousairaiShudouParameter.createParameterBy申請書管理番号(申請書管理番号.value())).records();
        if (!概況調査List.isEmpty() && CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_用紙タイプ, date, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                printService.print認定調査票_特記事項_OCR片面(getHandler(div).create認定調査票_特記事項パラメータ(概況調査List.get(0), false));
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                printService.print認定調査票_特記事項_OCR両面(getHandler(div).create認定調査票_特記事項パラメータ(概況調査List.get(0), true));
            }
        }
    }

    /**
     * 「選択した帳票を発行する」ボタンを押すAfter処理です。
     *
     * @param div NinteiChosaIraiShudouDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<NinteiChosaIraiShudouDiv> onClick_btnPrint_after(NinteiChosaIraiShudouDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (!div.getChkIrai().getSelectedKeys().isEmpty()) {
                ViewStateHolder.put(ViewStateKeys.依頼書出力年月日_更新区分, CONFIGVALUE1);
            } else {
                ViewStateHolder.put(ViewStateKeys.依頼書出力年月日_更新区分, RString.EMPTY);
            }
            if (div.getChkNinteichosaDesign().getSelectedKeys().isEmpty()
                    && div.getChkNinteichosaOcr().getSelectedKeys().isEmpty()
                    && div.getChkSaiCheck().getSelectedKeys().isEmpty()
                    && div.getChkTokkiJko().getSelectedKeys().isEmpty()) {
                ViewStateHolder.put(ViewStateKeys.調査票等出力年月日_更新区分, RString.EMPTY);
            } else {
                ViewStateHolder.put(ViewStateKeys.調査票等出力年月日_更新区分, CONFIGVALUE1);
            }
            RealInitialLocker.release(get排他キー());
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace("発行処理")).respond();
        }
        return ResponseData.of(div).respond();
    }

    private PersonalData toPersonalData(RString shinsei) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0001")), new RString("申請書管理番号"), shinsei);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    /**
     * 「戻る」ボタンを押す処理です。
     *
     * @param div NinteiChosaIraiShudouDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<NinteiChosaIraiShudouDiv> onClick_btnBack(NinteiChosaIraiShudouDiv div) {
        return ResponseData.of(div).respond();
    }

    private NinteiChosaIraiShudouHandler getHandler(NinteiChosaIraiShudouDiv div) {
        return new NinteiChosaIraiShudouHandler(div);
    }

    private NinteiChosaIraiShudouValidationHandler getValidationHandler(NinteiChosaIraiShudouDiv div) {
        return new NinteiChosaIraiShudouValidationHandler(div);
    }
}
