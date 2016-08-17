/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5530001;

import java.util.HashMap;
import jp.co.ndensan.reams.db.dbd.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.jukyushajaicho.JukyushaDaichoParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5530001.DBD5530001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5530001.DBD5530001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5530001.YokaigoNinteiTorikeshiTujishoHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5530001.YokaigoNinteiTorikeshiTujishoHakkoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5530001.YokaigoNinteiTorikeshiTujishoHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.jukyushadaicho.JukyushaDaichoService;
import jp.co.ndensan.reams.db.dbd.service.report.dbd550004.YokaigoNinteiTorikeshiTshuchishoPrintService;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.report.hakkorireki.GyomuKoyuJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定取消通知書発行のDivControllerです。
 *
 * @reamsid_L DBD-1440-010 liuyl
 */
public class YokaigoNinteiTorikeshiTujishoHakko {

    /**
     * 画面初期化処理です。
     *
     * @param div YokaigoNinteiTorikeshiTujishoHakkoDiv
     * @return ResponseData<YokaigoNinteiTorikeshiTujishoHakkoDiv>
     */
    public ResponseData<YokaigoNinteiTorikeshiTujishoHakkoDiv> onLoad(YokaigoNinteiTorikeshiTujishoHakkoDiv div) {
        creatYokaigoNinteiTorikeshiTujishoHakkoHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 取消理由に複写するボタンの処理です。
     *
     * @param div YokaigoNinteiTorikeshiTujishoHakkoDiv
     * @return ResponseData<YokaigoNinteiTorikeshiTujishoHakkoDiv>
     */
    public ResponseData<YokaigoNinteiTorikeshiTujishoHakkoDiv> clickOnJiYu(YokaigoNinteiTorikeshiTujishoHakkoDiv div) {

        YokaigoNinteiTorikeshiTujishoHakkoValidationHandler validationHandler = new YokaigoNinteiTorikeshiTujishoHakkoValidationHandler();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        validationHandler.異動事由必須入力チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        div.getTujishoHakkoMeisai().getTxtTorikeshiRiyu().setValue(div.getTujishoHakkoMeisai().getTxtIdoJiyu().getValue());
        return ResponseData.of(div).respond();

    }

    /**
     * 対象者検索にするボタンの処理です。
     *
     * @param div YokaigoNinteiTorikeshiTujishoHakkoDiv
     * @return ResponseData<YokaigoNinteiTorikeshiTujishoHakkoDiv>
     */
    public ResponseData<YokaigoNinteiTorikeshiTujishoHakkoDiv> onClickDbz(YokaigoNinteiTorikeshiTujishoHakkoDiv div) {
        ValidationMessageControlPairs controlPairs選択行存在チェック = new ValidationMessageControlPairs();
        if (controlPairs選択行存在チェック.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs選択行存在チェック).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }

        return ResponseData.of(div).forwardWithEventName(DBD5530001TransitionEventName.対象者検索に戻る).respond();
    }

    /**
     * 「発行する」の前処理です。
     *
     * @param div YokaigoNinteiTorikeshiTujishoHakkoDiv
     * @return ResponseData<YokaigoNinteiTorikeshiTujishoHakkoDiv>
     */
    public ResponseData<YokaigoNinteiTorikeshiTujishoHakkoDiv> before_onClick(YokaigoNinteiTorikeshiTujishoHakkoDiv div) {
        ValidationMessageControlPairs controlPairs選択行存在チェック = new ValidationMessageControlPairs();
        YokaigoNinteiTorikeshiTujishoHakkoValidationHandler handler = new YokaigoNinteiTorikeshiTujishoHakkoValidationHandler();
        handler.期間大小関係チェック(controlPairs選択行存在チェック, div);
        if (controlPairs選択行存在チェック.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs選択行存在チェック).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 帳票を出力する
     *
     * @param div YokaigoNinteiTorikeshiTujishoHakkoDiv
     * @return ResponseData<YokaigoNinteiTorikeshiTujishoHakkoDiv>
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(YokaigoNinteiTorikeshiTujishoHakkoDiv div) {
        RString hihokenshaNo = div.getCcdKaigoninteiShikakuInfo().getTxtHihokenshaNo().getValue();
        RString hihokenshaName = div.getCcdKaigoNinteiAtenaInfo().get被保険者氏名();
        RString teishutsuKigenYMD;
        if (div.getTujishoHakkoMeisai().getTxtHihokenshashoTeishutuKigen().getValue() == null) {
            teishutsuKigenYMD = RString.EMPTY;
        } else {
            teishutsuKigenYMD = div.getTujishoHakkoMeisai().getTxtHihokenshashoTeishutuKigen().getValue().toDateString();
        }
        try (ReportManager reportManager = new ReportManager()) {
            YokaigoNinteiTorikeshiTshuchishoPrintService printService = new YokaigoNinteiTorikeshiTshuchishoPrintService();
            printService.print(reportManager, div.getTujishoHakkoMeisai().getTxtSakuseibi().getValue(), div.getTujishoHakkoMeisai().
                    getCcdBunshoBango().get文書番号(), hihokenshaNo, hihokenshaName, div.getTujishoHakkoMeisai().getTxtTorikeshiRiyu().
                    getValue(), teishutsuKigenYMD);
            HashMap<Code, RString> hashMap = new HashMap();
            hashMap.put(new Code(GyomuKoyuJoho.被保番号.getコード()), div.getCcdKaigoninteiShikakuInfo().getTxtHihokenshaNo().getValue());
            SourceDataCollection collection = reportManager.publish();

            return ResponseData.of(collection).respond();
        }
    }

    /**
     * 「発行する」の後の処理
     *
     * @param div YokaigoNinteiTorikeshiTujishoHakkoDiv
     * @return ResponseData<YokaigoNinteiTorikeshiTujishoHakkoDiv>
     */
    public ResponseData<YokaigoNinteiTorikeshiTujishoHakkoDiv> afterPublish(YokaigoNinteiTorikeshiTujishoHakkoDiv div) {
        creatYokaigoNinteiTorikeshiTujishoHakkoHandler(div).排他の設定(div.getCcdKaigoninteiShikakuInfo().getTxtHihokenshaNo().getValue());
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJohoFinder.createInstance().
                getShichosonSecurityJoho(GyomuBunrui.介護事務);
        LasdecCode 市町村コード = shichosonSecurityJoho.get市町村情報().get市町村コード();
        JukyushaDaichoParameter parameter = new JukyushaDaichoParameter(市町村コード, div.getTujishoHakkoJoken().
                getCcdKaigoninteiShikakuInfo().getTxtHihokenshaNo().getValue(), shichosonSecurityJoho.
                get市町村情報().get証記載保険者番号().value());
        insert(parameter, div);
        creatYokaigoNinteiTorikeshiTujishoHakkoHandler(div).排他制御の解除(div.getCcdKaigoninteiShikakuInfo()
                .getTxtHihokenshaNo().getValue());
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(div.getCcdKaigoninteiShikakuInfo().
                getTxtHihokenshaNo().getValue()), new RString("0003"), div.getCcdKaigoninteiShikakuInfo().
                getTxtHihokenshaNo().getValue());
        AccessLogger.log(AccessLogType.照会, PersonalData.withHojinNo(new ShikibetsuCode(RString.EMPTY), expandedInfo));
        div.getCcdKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY,
                RString.EMPTY, true);
        return ResponseData.of(div).setState(DBD5530001StateName.完了);

    }

    /**
     * 完了ボタンの処理です。
     *
     * @param div YokaigoNinteiTorikeshiTujishoHakkoDiv
     * @return ResponseData<YokaigoNinteiTorikeshiTujishoHakkoDiv>
     */
    public ResponseData<YokaigoNinteiTorikeshiTujishoHakkoDiv> onClick_back(YokaigoNinteiTorikeshiTujishoHakkoDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBD5530001TransitionEventName.完了).respond();
    }

    private YokaigoNinteiTorikeshiTujishoHakkoHandler creatYokaigoNinteiTorikeshiTujishoHakkoHandler(
            YokaigoNinteiTorikeshiTujishoHakkoDiv div) {
        return new YokaigoNinteiTorikeshiTujishoHakkoHandler(div);

    }

    private void insert(JukyushaDaichoParameter parameter, YokaigoNinteiTorikeshiTujishoHakkoDiv div) {
        FlexibleDate 認定有効期間開始年月日;
        FlexibleDate 認定有効期間終了年月日;
        FlexibleDate 認定取消通知書発行年月日;
        RString 異動理由;
        RString 要介護度;
        if (div.getTujishoHakkoMeisai().getTxtYukoKigen2().getFromValue() != null) {
            認定有効期間開始年月日 = new FlexibleDate(div.getTujishoHakkoMeisai().getTxtYukoKigen2().getFromValue().toString());
        } else {
            認定有効期間開始年月日 = FlexibleDate.EMPTY;
        }
        if (div.getTujishoHakkoMeisai().getTxtSakuseibi().getValue() != null) {
            認定有効期間終了年月日 = new FlexibleDate(div.getTujishoHakkoMeisai().getTxtYukoKigen2().getToValue().toString());
        } else {
            認定有効期間終了年月日 = FlexibleDate.EMPTY;
        }
        if (div.getTujishoHakkoMeisai().getTxtSakuseibi().getValue() != null) {
            認定取消通知書発行年月日 = new FlexibleDate(div.getTujishoHakkoMeisai().getTxtSakuseibi().getValue().toString());
        } else {
            認定取消通知書発行年月日 = FlexibleDate.EMPTY;
        }
        if (div.getTujishoHakkoMeisai().getTxtIdoJiyu().getValue() != null) {
            異動理由 = div.getTujishoHakkoMeisai().getTxtIdoJiyu().getValue();
        } else {
            異動理由 = RString.EMPTY;
        }
        if (div.getTujishoHakkoMeisai().getTxtYokaigodo().getValue() != null) {
            要介護度 = div.getTujishoHakkoMeisai().getTxtYokaigodo().getValue();
        } else {
            要介護度 = RString.EMPTY;
        }
        JukyushaDaicho jukyushaDaicho = JukyushaDaichoService.createJukyushaDaichoService().get受給者台帳(parameter);
        JukyushaDaichoService.createJukyushaDaichoService().insert(jukyushaDaicho, 異動理由, 要介護度, 認定有効期間開始年月日,
                認定有効期間終了年月日, 認定取消通知書発行年月日);
    }
}
