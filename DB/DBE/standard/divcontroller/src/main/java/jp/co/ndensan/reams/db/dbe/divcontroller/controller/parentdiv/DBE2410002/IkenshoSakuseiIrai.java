/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2410002;

import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran.IkenshoirairirekiichiranShudou;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002.DBE2410002StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002.DBE2410002TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002.IkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2410002.IkenshoSakuseiIraiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2410002.IkenshoSakuseiIraiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshosakuseiirai.IkenshoSakuseiIraiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 主治医意見書作成依頼(手動)のクラスです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
public class IkenshoSakuseiIrai {

    private static final RString SELECTED_KEY0 = new RString("key0");
    private static final RString SELECTED_KEY1 = new RString("key1");
    private static final RString SELECTED_KEY2 = new RString("key2");
    private static final RString CONFIGVALUE1 = new RString("1");
    private static final RString 指定医 = new RString("2");
    private static RDate 認定申請年月日 = null;

    /**
     * 主治医意見書作成依頼(手動)の初期化です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshoSakuseiIraiDiv> onLoad(IkenshoSakuseiIraiDiv div) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        div.getCcdNinteiShinseishaKihonInfo().initialize(申請書管理番号);
        IkenshoSakuseiIraiManager manager = IkenshoSakuseiIraiManager.createInstance();
        IkenshoirairirekiichiranShudou 主治医意見書作成依頼 = manager.get主治医意見書作成依頼(申請書管理番号.value());
        NinteiShinseiJoho 要介護認定申請情報 = manager.get要介護認定申請情報(申請書管理番号.value());
        ViewStateHolder.put(ViewStateKeys.要介護認定申請情報, 要介護認定申請情報);
        div.getCcdShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.SimpleInputMode);
        div.getCcdShujiiInput().initialize(主治医意見書作成依頼.get市町村コード(), 申請書管理番号, SubGyomuCode.DBE認定支援,
                主治医意見書作成依頼.get主治医医療機関コード(), 主治医意見書作成依頼.get医療機関名称(),
                主治医意見書作成依頼.get主治医コード(), 主治医意見書作成依頼.get主治医氏名());
        boolean is指定医 = false;
        if (主治医意見書作成依頼.get医師区分コード() != null && 指定医.equals(主治医意見書作成依頼.get医師区分コード().value())) {
            is指定医 = true;
        }
        div.getCcdShujiiInput().setShiteii(is指定医);
        if (!RealInitialLocker.tryGetLock(get排他キー())) {
            div.setReadOnly(true);
            throw new PessimisticLockingException();
        }
        認定申請年月日 = new RDate(主治医意見書作成依頼.get認定申請年月日().toString());
        createHandler(div).initialize(主治医意見書作成依頼);
        div.getCcdShujiiInput().getBtnIryokikanGuide().setDisabled(true);
        onChange_radKigen(div);
        
        if (NinteiShinseiShinseijiKubunCode.転入申請.get名称().equals(
                div.getCcdNinteiShinseishaKihonInfo().get申請区分申請時())) {
            div.getIkenshoIraiTorokuPanel().setDisabled(true);
            div.getIraiprintPanel().setDisabled(true);
            return ResponseData.of(div).setState(DBE2410002StateName.ReadOnly);
        }

        return ResponseData.of(div).respond();
    }

    private LockingKey get排他キー() {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        RStringBuilder lockingKey = new RStringBuilder(SubGyomuCode.DBE認定支援.getColumnValue());
        lockingKey.append(new RString("ShinseishoKanriNo"));
        lockingKey.append(申請書管理番号.value());
        return new LockingKey(lockingKey.toRString());
    }

    /**
     * 提出期限変更時、画面状態を制御します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshoSakuseiIraiDiv> onChange_radKigen(IkenshoSakuseiIraiDiv div) {
        RString コンフィグ_主治医意見書作成期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString key = div.getRadKigen().getSelectedKey();
        int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        if (CONFIGVALUE1.equals(コンフィグ_主治医意見書作成期限設定方法)) {
            if (SELECTED_KEY0.equals(key)) {
                div.getTxtKigenymd().setDisabled(true);
                if (div.getTxtSakuseiIraiD().getValue() != null) {
                    div.getTxtKigenymd().setValue(div.getTxtSakuseiIraiD().getValue().plusDay(期限日数));
                }
            } else if (SELECTED_KEY1.equals(key)) {
                div.getTxtKigenymd().setDisabled(true);
                div.getTxtKigenymd().clearValue();
            } else if (SELECTED_KEY2.equals(key)) {
                div.getTxtKigenymd().setDisabled(false);
            }
        } else if (認定申請年月日 != null) {
            div.getTxtKigenymd().setValue(認定申請年月日.plusDay(期限日数));
            div.getRadKigen().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }
    
    /**
     * 「保存する」ボタン押下時、意見書作成依頼情報を更新します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshoSakuseiIraiDiv> onClick_btnUpdate(IkenshoSakuseiIraiDiv div) {
        ValidationMessageControlPairs validPairs = createValidationHandler(div).check保存();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            保存処理(div);
            onLoad(div);
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
        if (new RString(UrInformationMessages.保存終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode()) 
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBE2410002TransitionEventName.個人依頼内容更新に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void 保存処理(IkenshoSakuseiIraiDiv div) {
        NinteiShinseiJoho 要介護認定申請情報 = ViewStateHolder.get(ViewStateKeys.要介護認定申請情報, NinteiShinseiJoho.class);
        NinteiShinseiJohoBuilder builder = 要介護認定申請情報.createBuilderForEdit();
        builder.set主治医医療機関コード(div.getCcdShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiInput().getShujiiCode());
        builder.set指定医フラグ(div.getCcdShujiiInput().hasShiteii());
        builder.setShujiiIkenshoIraiJoho(createHandler(div)
                .create主治医意見書作成依頼(要介護認定申請情報, ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class).value()));
        IkenshoSakuseiIraiManager.createInstance().saveList(builder.build().modifiedModel());
    }

    private IkenshoSakuseiIraiHandler createHandler(IkenshoSakuseiIraiDiv div) {
        return new IkenshoSakuseiIraiHandler(div);
    }

    private IkenshoSakuseiIraiValidationHandler createValidationHandler(IkenshoSakuseiIraiDiv div) {
        return new IkenshoSakuseiIraiValidationHandler(div);
    }
}
