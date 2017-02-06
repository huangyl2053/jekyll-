/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE1020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.seikatsuhogotoroku.Minashi2shisaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.seikatsuhogotoroku.SeikatsuhogoTorokuResult;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1020001.DBE1020001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1020001.SeikatsuhogoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1020001.SeikatsuhogoTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1020001.SeikatsuhogoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.seikatsuhogotoroku.SeikatsuhogoTorokuFinder;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KoseiShichosonShishoMasterManager;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.shishosecurityjoho.ShishoSecurityJoho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.ZenkokuJushoInputDiv;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * みなし2号登録のコントローラです。
 *
 * @reamsid_L DBE-1310-020 chengsanyuan
 */
public class SeikatsuhogoToroku {

    private final ShishoSecurityJoho shishoSecurity;
    private final KoseiShichosonShishoMasterManager manager;
    private final SeikatsuhogoTorokuFinder finder;
    private final NinteiShinseiJohoManager shinseiJohoManager;
    private boolean ninteiTandokuDounyuFlag;

    /**
     * コンストラクタです。
     *
     */
    public SeikatsuhogoToroku() {
        shishoSecurity = ShishoSecurityJoho.createInstance();
        manager = KoseiShichosonShishoMasterManager.createInstance();
        finder = SeikatsuhogoTorokuFinder.createInstance();
        shinseiJohoManager = NinteiShinseiJohoManager.createInstance();
        ShichosonSecurityJoho security = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        ninteiTandokuDounyuFlag = Boolean.FALSE;
        if (security.get導入形態コード().equals(new Code("111"))) {
            ninteiTandokuDounyuFlag = Boolean.TRUE;

        } else {
            security = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
            if (security.get導入形態コード().equals(new Code("211"))) {
                ninteiTandokuDounyuFlag = Boolean.TRUE;
            }
        }
    }

    /**
     * みなし2号登録初期化の設定します。
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onLoad(SeikatsuhogoTorokuDiv div) {
        RString code = shishoSecurity.getShishoCode(ControlDataHolder.getUserId());
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        List<KoseiShichosonShishoMaster> list = getList(null, code, div);
        SeikatsuhogoTorokuResult result = null;
        if (!RString.isNullOrEmpty(申請書管理番号)) {
            div.getBtnSaiban().setDisabled(true);
            result = finder.get申請情報(申請書管理番号);
        } else {
            div.getBtnSaiban().setDisabled(false);
        }
        getHandler(div).load(result, list, ninteiTandokuDounyuFlag);
        RStringBuilder 前排他制御 = new RStringBuilder();
        前排他制御.append("DBEShinseishoKanriNo");
        前排他制御.append(申請書管理番号);
        前排他ロックキー(前排他制御.toRString());
        return ResponseData.of(div).respond();
    }

    /**
     * みなし2号登録onActive事件。
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onActive(SeikatsuhogoTorokuDiv div) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
        NinteiShinseiJoho ninteiShinseiJoho = null;
        if (申請書管理番号 != null && !申請書管理番号.isEmpty()) {
            ninteiShinseiJoho = shinseiJohoManager.get要介護認定申請情報(new ShinseishoKanriNo(申請書管理番号));
        }
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            div.getHihokenshaNoSaiban().getTxtHihokenshaNo().setValue(被保険者番号);
        }
        if (ninteiShinseiJoho != null) {
            div.getTxtShimei().setValue(ninteiShinseiJoho.get被保険者氏名().value());
            if (ninteiShinseiJoho.get被保険者氏名カナ() != null) {
                div.getTxtKanaShimei().setValue(ninteiShinseiJoho.get被保険者氏名カナ().value());
            }
            if (ninteiShinseiJoho.get生年月日() != null && !ninteiShinseiJoho.get生年月日().isEmpty()) {
                div.getTxtBirthYMD().setValue(ninteiShinseiJoho.get生年月日().toRDate());
            }

            if (ninteiShinseiJoho.get性別() != null) {
                div.getRadSeibetsu().setSelectedKey(ninteiShinseiJoho.get性別().getKey());
            }
            div.getTxtYubinNo().setValue(ninteiShinseiJoho.get郵便番号());
            div.getSeikatsuHogoshaJohoInput().getCcdZenkokuJushoInput().load(ZenkokuJushoCode.EMPTY, ninteiShinseiJoho.get住所().value());
            div.getTxtTelNo().setDomain(ninteiShinseiJoho.get電話番号());
            if (ninteiShinseiJoho.get識別コード() != null) {
                div.getTxtShikibetsuCode().setValue(ninteiShinseiJoho.get識別コード().value());
            }
        }
        if (ninteiTandokuDounyuFlag) {
            ((ZenkokuJushoInputDiv) div.getCcdZenkokuJushoInput()).getBtnZenkokuJushoGuide().setDisplayNone(true);
            ((ZenkokuJushoInputDiv) div.getCcdZenkokuJushoInput()).getTxtZenkokuJushoCode().setDisplayNone(true);
            div.getBtnAtenaKensaku().setVisible(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 選択されている保険者に該当する支所情報をセットします。
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onChange_ddlHokenshaList(SeikatsuhogoTorokuDiv div) {
        List<KoseiShichosonShishoMaster> list = getList(div.getCcdHokenshaList().getSelectedItem().get市町村コード(),
                shishoSecurity.getShishoCode(ControlDataHolder.getUserId()), div);
        List<KeyValueDataSource> sourceList = new ArrayList<>();
        for (KoseiShichosonShishoMaster master : list) {
            sourceList.add(new KeyValueDataSource(master.get支所名(), master.get支所コード().value()));
        }
        div.getDdlShisho().setDataSource(sourceList);
        return ResponseData.of(div).respond();
    }

    /**
     * 選択されている住所に該当する郵便番号をセットします。
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onOkClose_txtZenkokuJushoCode(SeikatsuhogoTorokuDiv div) {
        if (!div.getCcdZenkokuJushoInput().get郵便番号().isEmpty()) {
            div.getTxtYubinNo().setValue(div.getCcdZenkokuJushoInput().get郵便番号());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * みなし２号被保険者番号を採番する　ボタン、自動採番を行う
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onClick_btnSaiban(SeikatsuhogoTorokuDiv div) {
        RString 被保険者番号 = Saiban.get(SubGyomuCode.DBE認定支援, SaibanHanyokeyName.みなし2号被保険者番号自動採番.getコード()).nextString();
        div.getTxtHihokenshaNo().setValue(被保険者番号);
        return ResponseData.of(div).respond();
    }
    /**
     * クリアする　ボタン、入力内容をEmpty設定
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onClick_btnClear(SeikatsuhogoTorokuDiv div) {
        div.getTxtHihokenshaNo().clearValue();
        div.getTxtBirthYMD().clearValue();
        div.getTxtGyoseiku().clearValue();
        div.getTxtKanaShimei().clearValue();
        div.getTxtKojinNo().clearValue();
        div.getTxtSetaiCode().clearValue();
        div.getTxtShikibetsuCode().clearValue();
        div.getTxtShimei().clearValue();
        div.getTxtTelNo().clearDomain();
        div.getTxtYubinNo().clearValue();
        div.getCcdZenkokuJushoInput().clear();
        div.getRadSeibetsu().clearSelectedItem();
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getDdlShisho().setSelectedIndex(0);
        return ResponseData.of(div).respond();
    }

    /**
     * 申請情報入力へボタン押下の場合、審査依頼受付／みなし２号審査受付画面へ遷移する。
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onClick_btnToNinteiShinseiToroku(SeikatsuhogoTorokuDiv div) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        ShinseishoKanriNo 前回申請書管理番号 = ShinseishoKanriNo.EMPTY;
        if (!RString.isNullOrEmpty(申請書管理番号)) {
            前回申請書管理番号 = finder.get前回申請書管理番号(new ShinseishoKanriNo(申請書管理番号));
        }
        Minashi2shisaiJoho minashi2shisaiJoho = getHandler(div).setBusiness(前回申請書管理番号);
        ViewStateHolder.put(ViewStateKeys.みなし2号登録情報, minashi2shisaiJoho);

        if (is年齢範囲外(minashi2shisaiJoho.get年齢())) {
           if (!ResponseHolder.isReRequest()) {
               return ResponseData.of(div).addMessage(DbeWarningMessages.年齢が40歳以上65歳未満.getMessage()).respond();
           }
           if (new RString(DbeWarningMessages.年齢が40歳以上65歳未満.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                   && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
               return ResponseData.of(div).respond();
           }
        }
        
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler(div).allCheck());
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        RStringBuilder 前排他制御 = new RStringBuilder();
        前排他制御.append("DBEShinseishoKanriNo");
        前排他制御.append(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
        前排他キーの解除(前排他制御.toRString());
        return ResponseData.of(div).forwardWithEventName(DBE1020001TransitionEventName.申請情報入力へ).respond();
    }

    private boolean is年齢範囲外(RString 年齢) {
        if (!RString.isNullOrEmpty(年齢)) {
            int age = Integer.parseInt(年齢.toString());
            return age < 40 || age >= 65;
        }
        return true;
    }

    /**
     * 宛名共通検索条件を入力する共有子を閉じるの場合、個人番号と行政区の設定です。
     *
     * @param div みなし2号登録Div
     * @return ResponseData<SeikatsuhogoTorokuDiv>
     */
    public ResponseData<SeikatsuhogoTorokuDiv> onOkClose_btnAtenaKensaku(SeikatsuhogoTorokuDiv div) {
        if (!RString.isNullOrEmpty(div.getTxtShikibetsuCode().getValue())
                && !div.getTxtShikibetsuCode().getValue().equals(div.getHdnKey_OutShikibetsuCode())) {
            div.getTxtHihokenshaNo().clearValue();
            div.getBtnSaiban().setDisabled(false);
        }
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getHdnKey_OutShikibetsuCode());
        div.getTxtShikibetsuCode().setValue(div.getHdnKey_OutShikibetsuCode());
        IKojin kojin = finder.getPsmData(識別コード);
        if (kojin != null) {
            div.getTxtKojinNo().setValue(kojin.get個人番号().value());
            div.getTxtGyoseiku().setValue(kojin.get行政区画().getGyoseiku().get名称());
            div.setHdnGyoseikuCode(kojin.get行政区画().getGyoseiku().getコード().value());
            if (kojin.get生年月日().toFlexibleDate() != null && !kojin.get生年月日().toFlexibleDate().isEmpty()) {
                div.getTxtBirthYMD().setValue(flexToRdate(kojin.get生年月日().toFlexibleDate()));
            }
            div.getRadSeibetsu().setSelectedKey(kojin.get性別().getCode());
            div.getTxtYubinNo().setValue(kojin.get住所().get郵便番号());
            div.getCcdZenkokuJushoInput().load(kojin.get住所().get全国住所コード());
            div.getTxtTelNo().setDomain(kojin.get連絡先１());
        }
        return ResponseData.of(div).respond();
    }

    private SeikatsuhogoTorokuHandler getHandler(SeikatsuhogoTorokuDiv div) {
        return new SeikatsuhogoTorokuHandler(div);
    }

    private SeikatsuhogoTorokuValidationHandler getValidationHandler(SeikatsuhogoTorokuDiv div) {
        return new SeikatsuhogoTorokuValidationHandler(div);
    }

    private RDate flexToRdate(FlexibleDate before) {
        return new RDate(before.wareki().toDateString().toString());
    }

    private List<KoseiShichosonShishoMaster> getList(LasdecCode 市町村コード, RString 支所コード, SeikatsuhogoTorokuDiv div) {
        List<KoseiShichosonShishoMaster> list = new ArrayList<>();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (!市町村セキュリティ情報.get支所管理有無フラグ()) {
            div.getDdlShisho().setDisabled(true);
        } else {
            div.getDdlShisho().setDisabled(false);
            if (市町村コード != null) {
                list = manager.get構成市町村支所マスタ一覧By市町村コード(
                        市町村コード, new ShishoCode(支所コード)).records();
            } else {
                list = manager.get構成市町村支所マスタ一覧By支所コード(new ShishoCode(支所コード)).records();
            }
        }
        return list;
    }

    private void 前排他ロックキー(RString 排他ロックキー) {
        LockingKey 前排他ロックキー = new LockingKey(排他ロックキー);
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            throw new PessimisticLockingException();
        }
    }

    private void 前排他キーの解除(RString 排他) {
        LockingKey 排他キー = new LockingKey(排他);
        RealInitialLocker.release(排他キー);
    }
}
