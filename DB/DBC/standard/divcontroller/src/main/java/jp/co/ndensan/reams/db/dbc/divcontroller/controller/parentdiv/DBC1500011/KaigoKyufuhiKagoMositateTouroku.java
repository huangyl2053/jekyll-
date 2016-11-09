/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1500011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KagoMoshitate;
import jp.co.ndensan.reams.db.dbc.business.core.kaigokyufuhikagomositatetouroku.KagoMoshitateCollect;
import jp.co.ndensan.reams.db.dbc.business.core.kaigokyufuhikagomositatetouroku.KagoMoshitateGamenData;
import jp.co.ndensan.reams.db.dbc.business.core.kaigokyufuhikagomositatetouroku.KaigoKyufuhiKagoMositateTourokuResult;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigokyufuhikagomositatetouroku.KaigoKyufuhiParamter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1500011.DBC1500011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1500011.DBC1500011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1500011.KaigoKyufuhiKagoMositateTourokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1500011.KaigoKyufuhiKagoMositateTourokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1500011.KaigoKyufuhiKagoMositateTourokuValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KagoMoshitateManager;
import jp.co.ndensan.reams.db.dbc.service.core.kaigokyufuhikagomositatetouroku.KaigoKyufuhiKagoMositateTourokuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.IShikibetsuTaishoFinder;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護給付費過誤申立登録（事業分、経過措置分含む）のコントローラクラスです。
 *
 * @reamsid_L DBC-2220-010 dongyabin
 */
public class KaigoKyufuhiKagoMositateTouroku {

    private static final int 提供年月 = 6;
    private static final RString 新規モード = new RString("新規");
    private static final RString 修正モード = new RString("修正");
    private static final RString 削除モード = new RString("削除");
    private static final RString 再検索フラグ = new RString("TRUE");
    private static final RString MENUID_DBCMN91001 = new RString("DBCMN91001");
    private static final RString MENUID_DBCMN91002 = new RString("DBCMN91002");
    private static final RString MENUID_DBCMN91003 = new RString("DBCMN91003");
    private static final List<RString> 同月審査用_EMPTY = new ArrayList<>();
    private static final RString 介護給付費過誤申立書 = new RString("介護給付費過誤申立書");
    private static final RString 総合事業費過誤申立書_経過措置 = new RString("総合事業費過誤申立書情報作成（経過措置）");
    private static final RString 総合事業費過誤申立書 = new RString("総合事業費過誤申立書");
    private static final RString 台帳種別表示無し = new RString("台帳種別表示無し");
    private static final RString MESSAGE_REPLACE_コンフィグのキー = new RString("該当の給付実績データ");
    private static final RString 申立理由_12 = new RString("12");
    private static final RString 申立理由_49 = new RString("49");
    private static final RString 申立理由_59 = new RString("59");
    private static final RString 申立理由_69 = new RString("69");
    private static final RString 申立理由_4A = new RString("4A");
    private static final RString 申立理由_4B = new RString("4B");
    private static final RString 申立理由_4C = new RString("4C");
    private static final RString 申立理由_4D = new RString("4D");
    private static final RString 申立理由_4E = new RString("4E");
    private static final RString 申立理由_5A = new RString("5A");
    private static final RString 申立理由_5B = new RString("5B");
    private static final RString 申立理由_5C = new RString("5C");
    private static final RString 申立理由_5D = new RString("5D");
    private static final RString 申立理由_5E = new RString("5E");

    /**
     * 画面初期化します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoKyufuhiKagoMositateTouroku>
     */
    public ResponseData<KaigoKyufuhiKagoMositateTourokuDiv> onLoad(KaigoKyufuhiKagoMositateTourokuDiv div) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        if (is単一()) {
            div.getHokenshalist().setVisible(false);
        } else {
            div.getHokenshalist().setVisible(true);
            div.getHokenshalist().loadHokenshaList(GyomuBunrui.介護事務);
        }
        getHandler(div).onLoad();
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, 台帳種別表示無し);
        div.getCcdJigyoshaSentaku().initialize();
        get給付実績一覧(div, controlData);
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        KagoMoshitateGamenData 画面データ = ViewStateHolder.get(ViewStateKeys.介護給付費過誤申立登録, KagoMoshitateGamenData.class);
        if (画面データ != null) {
            div.getCcdJigyoshaSentaku().setNyuryokuShisetsuKodo(画面データ.get事業者());
            div.getCcdJigyoshaSentaku().setShisetsuMeisho(画面データ.get事業者名());
            div.getTxtTeikyoYMRange().setFromValue(画面データ.get提供年月From());
            div.getTxtTeikyoYMRange().setToValue(画面データ.get提供年月To());
            div.getMoshitateshoSakuseiZumi().setSelectedItemsByKey(画面データ.get申立書作成済());
        }
        if (資格対象者 != null) {
            div.getTxtHihoNo().setValue(資格対象者.get被保険者番号().value());
            div.getTxtHihoName().setValue(get被保名称(資格対象者.get識別コード()));
        }
        div.getKyufuJissekiGaitoshaListPanel().setIsOpen(false);
        if (MENUID_DBCMN91001.equals(menuID)) {
            return ResponseData.of(div).rootTitle(介護給付費過誤申立書).respond();
        } else if (MENUID_DBCMN91002.equals(menuID)) {
            return ResponseData.of(div).rootTitle(総合事業費過誤申立書_経過措置).respond();
        } else if (MENUID_DBCMN91003.equals(menuID)) {
            return ResponseData.of(div).rootTitle(総合事業費過誤申立書).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 画面onActiveのメソッドです。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoKyufuhiKagoMositateTouroku>
     */
    public ResponseData<KaigoKyufuhiKagoMositateTourokuDiv> onActive(KaigoKyufuhiKagoMositateTourokuDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (資格対象者 != null) {
            div.getTxtHihoNo().setValue(資格対象者.get被保険者番号().value());
            div.getTxtHihoName().setValue(get被保名称(資格対象者.get識別コード()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「被保番号検索」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoKyufuhiKagoMositateTourokuDiv>
     */
    public ResponseData<KaigoKyufuhiKagoMositateTourokuDiv> onClick_BtnSearchHihokensha(KaigoKyufuhiKagoMositateTourokuDiv div) {
        KagoMoshitateGamenData 画面データ = new KagoMoshitateGamenData();
        画面データ.set事業者(div.getCcdJigyoshaSentaku().getNyuryokuShisetsuKodo());
        画面データ.set事業者名(div.getCcdJigyoshaSentaku().getNyuryokuShisetsuMeisho());
        画面データ.set被保番号(div.getTxtHihoNo().getValue());
        画面データ.set被保番名(div.getTxtHihoName().getValue());
        画面データ.set提供年月From(div.getTxtTeikyoYMRange().getFromValue());
        画面データ.set提供年月To(div.getTxtTeikyoYMRange().getToValue());
        画面データ.set申立書作成済(div.getMoshitateshoSakuseiZumi().getSelectedKeys());
        ViewStateHolder.put(ViewStateKeys.介護給付費過誤申立登録, 画面データ);
        return ResponseData.of(div).forwardWithEventName(DBC1500011TransitionEventName.対象者検索).respond();
    }

    /**
     * 被保番号をOnBlurです。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoKyufuhiKagoMositateTourokuDiv>
     */
    public ResponseData<KaigoKyufuhiKagoMositateTourokuDiv> onBlur_BtnSearchHihokensha(KaigoKyufuhiKagoMositateTourokuDiv div) {
        RString 被保険者番号 = div.getTxtHihoNo().getValue();
        if (!RString.isNullOrEmpty(被保険者番号)) {
            if (getService().get識別コード(new HihokenshaNo(被保険者番号)).isEmpty()) {
                div.getTxtHihoName().clearValue();
            } else {
                div.getTxtHihoName().setValue(get被保名称(getService().get識別コード(new HihokenshaNo(被保険者番号))));
            }
        } else {
            div.getTxtHihoName().clearValue();
        }
        return ResponseData.of(div).respond();
    }

    private RString get被保名称(ShikibetsuCode 識別コード) {
        IShikibetsuTaishoFinder findler = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
        IShikibetsuTaisho iShikibe = findler.get識別対象(GyomuCode.DB介護保険, 識別コード, KensakuYusenKubun.住登外優先);
        if (iShikibe != null) {
            return iShikibe.get名称().getName().value();
        }
        return RString.EMPTY;
    }

    /**
     * 「給付実績を検索する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoKyufuhiKagoMositateTourokuDiv>
     */
    public ResponseData<KaigoKyufuhiKagoMositateTourokuDiv> onClick_BtnSearch(KaigoKyufuhiKagoMositateTourokuDiv div) {
        ValidationMessageControlPairs メッセージ = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getCcdJigyoshaSentaku().getNyuryokuShisetsuKodo())
                && RString.isNullOrEmpty(div.getTxtHihoNo().getValue())) {
            メッセージ.add(getValidation(div).check必須項目を入力(new RString("被保番号、支援事業者番号")));
        }
        if (div.getTxtTeikyoYMRange().getFromValue() == null
                || div.getTxtTeikyoYMRange().getToValue() == null) {
            メッセージ.add(getValidation(div).check必須項目を入力(new RString("提供年月開始、提供年月終了")));
        } else {
            if (div.getTxtTeikyoYMRange().getToValue().isBefore(div.getTxtTeikyoYMRange().getFromValue())) {
                メッセージ.add(getValidation(div).check終了日が開始日以前());
            }
        }
        if (メッセージ.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(メッセージ).respond();
        }
        IUrControlData controlData = UrControlDataFactory.createInstance();
        div.setHdnKensaku(再検索フラグ);
        get給付実績一覧(div, controlData);
        if (ViewStateHolder.get(ViewStateKeys.給付実績一覧, KagoMoshitateCollect.class).get給付実績情報List().isEmpty()) {
            return ResponseData.of(div).addValidationMessages(getValidation(div).check存在しない(MESSAGE_REPLACE_コンフィグのキー)).respond();
        }
        return ResponseData.of(div).setState(DBC1500011StateName.search);
    }

    /**
     * 「選択」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoKyufuhiKagoMositateTourokuDiv>
     */
    public ResponseData<KaigoKyufuhiKagoMositateTourokuDiv> onClick_BtnSentaku(KaigoKyufuhiKagoMositateTourokuDiv div) {
        div.getTxtMeisaiMoshitateDate().setDisabled(false);
        div.getDdlMeisaiKagoMoshitateRiyu().setDisabled(false);
        div.getChkMeisaiForDogetsuShinsa().setDisabled(false);
        div.getKokuhirenSaiSofu().setDisabled(false);
        if (div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getChkCreateMoshitatesho()) {
            div.setHdnState(修正モード);
        } else {
            div.setHdnState(新規モード);
        }
        set修正給付実績明細(div);
        return ResponseData.of(div).setState(DBC1500011StateName.meisai);
    }

    /**
     * 「削除」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoKyufuhiKagoMositateTourokuDiv>
     */
    public ResponseData<KaigoKyufuhiKagoMositateTourokuDiv> onClick_BtnSakujo(KaigoKyufuhiKagoMositateTourokuDiv div) {
        div.setHdnState(削除モード);
        div.getTxtMeisaiMoshitateDate().setDisabled(true);
        div.getDdlMeisaiKagoMoshitateRiyu().setDisabled(true);
        div.getChkMeisaiForDogetsuShinsa().setDisabled(true);
        div.getKokuhirenSaiSofu().setDisabled(true);
        set修正給付実績明細(div);
        return ResponseData.of(div).setState(DBC1500011StateName.meisai);
    }

    /**
     * 「保存する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoKyufuhiKagoMositateTourokuDiv>
     */
    public ResponseData<KaigoKyufuhiKagoMositateTourokuDiv> onClick_BtnSave(KaigoKyufuhiKagoMositateTourokuDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (is送付済みチェック(div)) {
            validationMessages.add(getValidation(div).check送付済みチェック());
        }
        if (!削除モード.equals(div.getHdnState())) {
            if (is申立日の年月と提供年月の関連チェック(div)) {
                validationMessages.add(getValidation(div).check申立日エラー());
            }
            if (is同月審査用と申立理由の関連チェック(div)) {
                validationMessages.add(getValidation(div).check同月審査申立理由整合性エラー());
            }
        }
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return setデータ保存(div);
        }
        if (new RString(DbcQuestionMessages.同月審査用の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            int index = div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getClickedRowId();
            KaigoKyufuhiKagoMositateTourokuResult 給付実績情報 = ViewStateHolder
                    .get(ViewStateKeys.給付実績一覧, KagoMoshitateCollect.class).get給付実績情報List().get(index);
            int 最大履歴番号 = getService().selectKyufuKanrihyoList(new JigyoshaNo(給付実績情報.get事業所番号()),
                    new HihokenshaNo(給付実績情報.get被保険者番号()),
                    new FlexibleYearMonth(給付実績情報.getサービス提供年月()));
            KagoMoshitate data = getHandler(div).setDB出力データ(給付実績情報, 最大履歴番号);
            KagoMoshitateManager service = new KagoMoshitateManager();
            service.saveOrdelete過誤申立(data);
            div.getCommonKiagoKanryoMessageChildDiv1().setSuccessMessage(new RString("保存は正常に終了しました。"));
            return ResponseData.of(div).setState(DBC1500011StateName.kanryoumessage);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<KaigoKyufuhiKagoMositateTourokuDiv> setデータ保存(KaigoKyufuhiKagoMositateTourokuDiv div) {
        if (!削除モード.equals(div.getHdnState())
                && !div.getChkMeisaiForDogetsuShinsa().getSelectedKeys().contains(new RString("forDogetsuShinsa"))
                && (申立理由_12.equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())
                || 申立理由_49.equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())
                || 申立理由_59.equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())
                || 申立理由_69.equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())
                || 申立理由_4A.equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())
                || 申立理由_4B.equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())
                || 申立理由_4C.equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())
                || 申立理由_4D.equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())
                || 申立理由_4E.equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())
                || 申立理由_5A.equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())
                || 申立理由_5B.equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())
                || 申立理由_5C.equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())
                || 申立理由_5D.equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())
                || 申立理由_5E.equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey()))) {
            QuestionMessage message = new QuestionMessage(DbcQuestionMessages.同月審査用の確認.getMessage().getCode(),
                    DbcQuestionMessages.同月審査用の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        } else {
            int index = div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getClickedRowId();
            KaigoKyufuhiKagoMositateTourokuResult 給付実績情報 = ViewStateHolder
                    .get(ViewStateKeys.給付実績一覧, KagoMoshitateCollect.class).get給付実績情報List().get(index);
            int 最大履歴番号 = getService().selectKyufuKanrihyoList(new JigyoshaNo(給付実績情報.get事業所番号()),
                    new HihokenshaNo(給付実績情報.get被保険者番号()),
                    new FlexibleYearMonth(給付実績情報.getサービス提供年月()));
            KagoMoshitate data = getHandler(div).setDB出力データ(給付実績情報, 最大履歴番号);
            KagoMoshitateManager service = new KagoMoshitateManager();
            service.saveOrdelete過誤申立(data);
            div.getCommonKiagoKanryoMessageChildDiv1().setSuccessMessage(new RString("保存は正常に終了しました。"));
            return ResponseData.of(div).setState(DBC1500011StateName.kanryoumessage);
        }
    }

    /**
     * 更新結果状況画面の「検索結果一覧へ」ボタン押します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoKyufuhiKagoMositateTourokuDiv>
     */
    public ResponseData<KaigoKyufuhiKagoMositateTourokuDiv> onClick_BtnModuro(KaigoKyufuhiKagoMositateTourokuDiv div) {
        div.setHdnKensaku(再検索フラグ);
        div.getTxtMeisaiMoshitateDate().clearValue();
        div.getDdlMeisaiKagoMoshitateRiyu().setSelectedIndex(0);
        div.getChkMeisaiForDogetsuShinsa().setSelectedItemsByKey(同月審査用_EMPTY);
        div.getKokuhirenSaiSofu().setSelectedItemsByKey(同月審査用_EMPTY);
        IUrControlData controlData = UrControlDataFactory.createInstance();
        get給付実績一覧(div, controlData);
        return ResponseData.of(div).setState(DBC1500011StateName.search);
    }

    private boolean is申立日の年月と提供年月の関連チェック(KaigoKyufuhiKagoMositateTourokuDiv div) {
        RDate 申立日の年月 = RDate.MIN;
        if (div.getTxtMeisaiMoshitateDate().getValue() != null) {
            申立日の年月 = div.getTxtMeisaiMoshitateDate().getValue();
        }
        return 申立日の年月.isBefore(div.getTxtMeisaiTeikyoYM().getValue());
    }

    private boolean is同月審査用と申立理由の関連チェック(KaigoKyufuhiKagoMositateTourokuDiv div) {
        return div.getChkMeisaiForDogetsuShinsa().getSelectedKeys().contains(new RString("forDogetsuShinsa"))
                && new RString("01").equals(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey());
    }

    private boolean is送付済みチェック(KaigoKyufuhiKagoMositateTourokuDiv div) {
        return 削除モード.equals(div.getHdnState())
                && div.getTxtMeisaiSendYM().getValue() != null;
    }

    private void set修正給付実績明細(KaigoKyufuhiKagoMositateTourokuDiv div) {
        int index = div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getClickedRowId();
        List<KaigoKyufuhiKagoMositateTourokuResult> resultList = ViewStateHolder
                .get(ViewStateKeys.給付実績一覧, KagoMoshitateCollect.class).get給付実績情報List();
        KaigoKyufuhiKagoMositateTourokuResult 給付実績情報 = resultList.get(index);
        ShikibetsuCode 識別コード = 給付実績情報.get識別コード();
        div.getCommonKaigpAtenainfoChildDiv1().initialize(識別コード);
        div.getCommonKaigoshikakuKihonChildDiv2().initialize(識別コード);
        getHandler(div).set給付実績明細(給付実績情報);
        set証記載保険者名(div);
    }

    private void set証記載保険者名(KaigoKyufuhiKagoMositateTourokuDiv div) {
        RString 証記載保険者名;
        RString 証記載保険者番号 = div.getTxtMeisaiShokisaiHokenshaNo().getValue();
        if (is単一()) {
            if (DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).equals(証記載保険者番号)) {
                証記載保険者名 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            } else {
                証記載保険者名 = getService().get旧市町村名称(証記載保険者番号);
            }
        } else {
            証記載保険者名 = getService().get市町村名称(証記載保険者番号);
        }
        div.getTxtMeisaiShokisaiHokenshaName().setValue(証記載保険者名);
    }

    private boolean is単一() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString loginUserId = controlData.getLoginInfo().getUserId();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務, loginUserId);
        return DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())
                || DonyuKeitaiCode.認定単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(市町村セキュリティ情報.get導入形態コード().value());
    }

    private void get給付実績一覧(KaigoKyufuhiKagoMositateTourokuDiv div, IUrControlData controlData) {
        LasdecCode 保険者番号 = null;
        if (!is単一()) {
            if (RString.isNullOrEmpty(div.getHokenshalist().getSelectedItem().get市町村コード().value())) {
                保険者番号 = new LasdecCode("000000");
            } else {
                保険者番号 = div.getHokenshalist().getSelectedItem().get市町村コード();
            }
        }
        if (再検索フラグ.equals(div.getHdnKensaku())) {
            RString 提供年月開始 = div.getTxtTeikyoYMRange().getFromValue().seireki().separator(Separator.NONE).fillType(FillType.ZERO)
                    .toDateString().substring(0, 提供年月);
            RString 提供年月終了 = div.getTxtTeikyoYMRange().getToValue().seireki().separator(Separator.NONE).fillType(FillType.ZERO)
                    .toDateString().substring(0, 提供年月);
            KaigoKyufuhiParamter param = KaigoKyufuhiParamter.createParem(div.getTxtHihoNo().getValue(),
                    div.getCcdJigyoshaSentaku().getNyuryokuShisetsuKodo(),
                    提供年月開始,
                    提供年月終了,
                    保険者番号,
                    div.getMoshitateshoSakuseiZumi().getSelectedKeys().contains(new RString("key0")),
                    controlData.getMenuID());
            List<KaigoKyufuhiKagoMositateTourokuResult> resultList = getService().selectKyufuJissekiList(param).records();
            if (!resultList.isEmpty()) {
                div.getKyufuJissekiGaitoshaListPanel().setIsOpen(true);
            } else {
                div.getKyufuJissekiGaitoshaListPanel().setIsOpen(false);
            }
            ViewStateHolder.put(ViewStateKeys.給付実績一覧, getHandler(div).set画面一覧(resultList));
        }
    }

    private KaigoKyufuhiKagoMositateTourokuFinder getService() {
        return KaigoKyufuhiKagoMositateTourokuFinder.createInstance();
    }

    private KaigoKyufuhiKagoMositateTourokuHandler getHandler(KaigoKyufuhiKagoMositateTourokuDiv div) {
        return new KaigoKyufuhiKagoMositateTourokuHandler(div);
    }

    private KaigoKyufuhiKagoMositateTourokuValidationHandler getValidation(KaigoKyufuhiKagoMositateTourokuDiv div) {
        return new KaigoKyufuhiKagoMositateTourokuValidationHandler(div);
    }
}
