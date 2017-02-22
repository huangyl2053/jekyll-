/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2410002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran.IkenshoirairirekiichiranShudou;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002.DBE2410002StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002.IkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2410002.IkenshoSakuseiIraiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2410002.IkenshoSakuseiIraiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoget.IkenshogetManager;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshosakuseiirai.IkenshoSakuseiIraiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 主治医意見書作成依頼(手動)のクラスです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
public class IkenshoSakuseiIrai {

    private static final RString 指定医 = new RString("2");
    private static final RString 保存するボタン名 = new RString("btnUpdate");

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
            throw new PessimisticLockingException();
        }
        createHandler(div).initialize(主治医意見書作成依頼);
        div.getCcdShujiiInput().getBtnIryokikanGuide().setDisabled(true);

        if (NinteiShinseiShinseijiKubunCode.転入申請.get名称().equals(
                div.getCcdNinteiShinseishaKihonInfo().get申請区分申請時())) {
            div.setDisabled(false);
            div.getIkenshoIraiTorokuPanel().setDisabled(true);
            return ResponseData.of(div).setState(DBE2410002StateName.ReadOnly);
        }
        div.setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存するボタン名, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタン押下時、意見書作成依頼情報を更新します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshoSakuseiIraiDiv> onClick_btnUpdate(IkenshoSakuseiIraiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs validPairs = createValidationHandler(div).check保存();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            保存処理(div);
            if (createHandler(div).結果データ有無()) {
                完了データ更新();
            }
//            onLoad(div);
            RealInitialLocker.release(get排他キー());
            div.getIkenshoIraiTorokuPanel().setDisabled(true);
            div.getKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBE2410002StateName.Kanryo);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「依頼書等を印刷する」ボタン押下時
     *
     * @param div IkenshoSakuseiIraiDiv
     * @return ResponseData<IkenshoSakuseiIraiDiv>
     */
    public ResponseData<IkenshoSakuseiIraiDiv> onBeforeOpen_btnPrint(IkenshoSakuseiIraiDiv div) {
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        申請書管理番号リスト.add(ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class));
        IkenshoPrintParameterModel model = new IkenshoPrintParameterModel();
        model.set申請書管理番号リスト(申請書管理番号リスト);
        model.set市町村コード(ViewStateHolder.get(ViewStateKeys.市町村コード, LasdecCode.class));
        model.set遷移元画面区分(GamenSeniKbn.主治医意見書依頼);
        div.setHiddenIuputModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 「戻る」ボタンを押す処理です。
     *
     * @param div IkenshoSakuseiIraiDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<IkenshoSakuseiIraiDiv> onClick_btnBack(IkenshoSakuseiIraiDiv div) {
        RealInitialLocker.release(get排他キー());
        return ResponseData.of(div).respond();
    }

    private LockingKey get排他キー() {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        RStringBuilder lockingKey = new RStringBuilder(SubGyomuCode.DBE認定支援.getColumnValue());
        lockingKey.append(new RString("ShinseishoKanriNo"));
        lockingKey.append(申請書管理番号.value());
        return new LockingKey(lockingKey.toRString());
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

    private void 完了データ更新() {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        NinteiKanryoJohoManager manager = new NinteiKanryoJohoManager();
        NinteiKanryoJoho ninteiKanryoJoho = manager.get要介護認定完了情報(申請書管理番号);
        ninteiKanryoJoho = ninteiKanryoJoho.createBuilderForEdit()
                .set主治医意見書作成依頼完了年月日(null)
                .set主治医意見書登録完了年月日(null)
                .set要介護認定一次判定完了年月日(null)
                .setマスキング完了年月日(null)
                .set認定審査会割当完了年月日(null)
                .set認定審査会完了年月日(null)
                .build();
        IkenshogetManager.createInstance().要介護認定完了情報更新(ninteiKanryoJoho);
    }

    private IkenshoSakuseiIraiHandler createHandler(IkenshoSakuseiIraiDiv div) {
        return new IkenshoSakuseiIraiHandler(div);
    }

    private IkenshoSakuseiIraiValidationHandler createValidationHandler(IkenshoSakuseiIraiDiv div) {
        return new IkenshoSakuseiIraiValidationHandler(div);
    }
}
