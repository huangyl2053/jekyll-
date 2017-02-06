/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2400001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.iraisho.IraishoIkkatsuHakkoResult;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.DBE220010_IraishoIkkatuParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.iraisho.IraishoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.DBE2400001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.IraishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2400001.IraishoIkkatsuHakkoHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2400001.IraishoIkkatsuHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.iraisho.IraishoIkkatsuHakkoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 依頼書一括発行のコントローラです。
 *
 * @reamsid_L DBE-0080-010 duanzhanli
 */
public class IraishoIkkatsuHakko {

    private static final RString SELECTED_KEY0 = new RString("key0");
    private static final RString SELECTED_KEY1 = new RString("key1");
    private static final RString SELECTED_KEY2 = new RString("key2");
    private static final RString COMMON_DATE = new RString("2");
    private static final RString COMMON_PRINT = new RString("0");
    private static final RString COMMON_NO_PRINT = new RString("1");
    private static final RString KEY2 = new RString("2");
    private final IraishoIkkatsuHakkoFinder service;

    /**
     * コンストラクタです。
     *
     */
    public IraishoIkkatsuHakko() {
        service = IraishoIkkatsuHakkoFinder.createInstance();
    }

    /**
     * 依頼書一括発行初期化の設定します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onLoad(IraishoIkkatsuHakkoDiv div) {
        getHandler(div).load();
        getHandler(div).loadNinteiChosa();
        return ResponseData.of(div).setState(DBE2400001StateName.認定調査依頼);
    }

    /**
     * 対象選択ラジオボタン選択を設定します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onChange_radTaishoSentaku(IraishoIkkatsuHakkoDiv div) {
        if (SELECTED_KEY0.equals(div.getRadTaishoSentaku().getSelectedKey())) {
            getHandler(div).loadNinteiChosa();
            return ResponseData.of(div).setState(DBE2400001StateName.認定調査依頼);
        }
        if (SELECTED_KEY1.equals(div.getRadTaishoSentaku().getSelectedKey())) {
            getHandler(div).loadShuJiiIKensho();
            return ResponseData.of(div).setState(DBE2400001StateName.主治医意見書作成依頼);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 検索するボタン押下の場合、一覧を設定します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onClick_btnKensanku(IraishoIkkatsuHakkoDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        List<IraishoIkkatsuHakkoResult> resultList = new ArrayList<>();
        DBE2400001StateName resultState = null;
        if (new RString(DBE2400001StateName.認定調査依頼.name()).equals(ResponseHolder.getState())) {
            IraishoIkkatsuHakkoParameter param
                    = IraishoIkkatsuHakkoParameter.createIraishoIkkatsuHakkoParameter(
                            div.getTxtNinteiChosaIraibi().getFromValue(),
                            div.getTxtNinteiChosaIraibi().getToValue(),
                            div.getChkNinteiChosaIraisho().getSelectedKeys(),
                            div.getCcdNinteiChosaHokensha().getSelectedItem().get証記載保険者番号(),
                            div.getChkNinteiChosahyo().getSelectedKeys(),
                            Collections.<RString>emptyList(),
                            Collections.<RString>emptyList(),
                            div.getTxtChosaDispMax().getValue());
            resultList = service.getNinteiChousaIrai(param).records();
            resultState = DBE2400001StateName.認定調査依頼_検索結果;
        }
        if (new RString(DBE2400001StateName.主治医意見書作成依頼.name()).equals(ResponseHolder.getState())) {
            IraishoIkkatsuHakkoParameter param
                    = IraishoIkkatsuHakkoParameter.createIraishoIkkatsuHakkoParameter(
                            div.getTxtShujiiIkenshoSakuseiIraibi().getFromValue(),
                            div.getTxtShujiiIkenshoSakuseiIraibi().getToValue(),
                            Collections.<RString>emptyList(),
                            div.getCcdShujiiIkenshoHokensha().getSelectedItem().get証記載保険者番号(),
                            Collections.<RString>emptyList(),
                            div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys(),
                            div.getChkShujiiIkensho().getSelectedKeys(),
                            div.getTxtIkenshoDispMax().getValue());
            resultList = service.getShuziiIkenshoIrai(param).records();
            resultState = DBE2400001StateName.主治医意見書作成依頼_検索結果;
        }
        if (resultList.isEmpty()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        if (DBE2400001StateName.認定調査依頼_検索結果.equals(resultState)) {
            getHandler(div).setNinteiChosa();
        } else if (DBE2400001StateName.主治医意見書作成依頼_検索結果.equals(resultState)) {
            getHandler(div).setShuJiiIKensho();
        }
        getHandler(div).setDataGrid(resultList);
        return ResponseData.of(div).setState(resultState);
    }

    /**
     * 条件をクリアするボタン押下します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onClick_btnJokenClear(IraishoIkkatsuHakkoDiv div) {
        getHandler(div).clearJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 提出期限ラジオボタン選択の場合、共通日付txtの使用可否などを設定します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onChange_radTeishutsuKigen(IraishoIkkatsuHakkoDiv div) {
        getHandler(div).setTxtKyotsuHizuke();
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択された帳票を発行するボタン」を押下場合、入力チェックを実行します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onClick_btnCheck(IraishoIkkatsuHakkoDiv div) {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler(div).iraiItiranCheck());
        validationMessages.add(getValidationHandler(div).printChouhyouSentakuCheck());
        validationMessages.add(getValidationHandler(div).commonDateCheck());
        validationMessages.add(getValidationHandler(div).validateIkenshoIraisho());
        validationMessages.add(getValidationHandler(div).validateTokkijiko());

        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 依頼書一括発行バッチを起動します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<DBE220010_IraishoIkkatuParameter> onClick_btnBatchRegister(IraishoIkkatsuHakkoDiv div) {
        DBE220010_IraishoIkkatuParameter param = new DBE220010_IraishoIkkatuParameter();
        if (new RString(DBE2400001StateName.認定調査依頼_検索結果.name()).equals(ResponseHolder.getState())) {
            param.setIraiFromYMD(div.getTxtNinteiChosaIraibi().getFromValue() == null
                    ? RString.EMPTY : div.getTxtNinteiChosaIraibi().getFromValue().toDateString());
            param.setIraiToYMD(div.getTxtNinteiChosaIraibi().getToValue() == null
                    ? RString.EMPTY : div.getTxtNinteiChosaIraibi().getToValue().toDateString());
            getHandler(div).setNinteParam(param);
        }
        if (new RString(DBE2400001StateName.主治医意見書作成依頼_検索結果.name()).equals(ResponseHolder.getState())) {
            param.setIraiFromYMD(div.getTxtShujiiIkenshoSakuseiIraibi().getFromValue() == null
                    ? RString.EMPTY : div.getTxtShujiiIkenshoSakuseiIraibi().getFromValue().toDateString());
            param.setIraiToYMD(div.getTxtShujiiIkenshoSakuseiIraibi().getToValue() == null
                    ? RString.EMPTY : div.getTxtShujiiIkenshoSakuseiIraibi().getToValue().toDateString());
            getHandler(div).setShujiiParam(param);
        }
        param.setHakkobi(div.getTxtHakkobi().getValue() == null
                ? RString.EMPTY : div.getTxtHakkobi().getValue().toDateString());
        if (SELECTED_KEY0.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            param.setTeishutsuKigen(COMMON_PRINT);
        } else if (SELECTED_KEY1.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            param.setTeishutsuKigen(COMMON_NO_PRINT);
        } else if (SELECTED_KEY2.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            param.setTeishutsuKigen(COMMON_DATE);
        } else {
            param.setTeishutsuKigen(RString.EMPTY);
        }
        if (SELECTED_KEY2.equals(div.getRadTeishutsuKigen().getSelectedKey()) && div.getTxtKyotsuHizuke().getValue() != null) {
            param.setKyotsuHizuke(div.getTxtKyotsuHizuke().getValue().toDateString());
        } else {
            param.setKyotsuHizuke(RString.EMPTY);
        }
        param.setBunshoNo(div.getCcdBunshoNo().get文書番号());
        param.setShichosonCode(div.getCcdNinteiChosaHokensha().getSelectedItem().get市町村コード().value());
        param.setShoKisaiHokenshaNo(div.getCcdNinteiChosaHokensha().getSelectedItem().get証記載保険者番号().value());
        param.setHokenshaName(div.getCcdNinteiChosaHokensha().getSelectedItem().get市町村名称());
        return ResponseData.of(param).respond();
    }

    /**
     * 主事意見書請求書 チェックボックスのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onChange_chkIkenshoSeikyusho(IraishoIkkatsuHakkoDiv div) {
        List<RString> 請求書選択selectedKeys = div.getChkIkenshoSeikyusho().getSelectedKeys();
        if (請求書選択selectedKeys.isEmpty()) {
            getHandler(div).setChkIkenshoIraisho();
        } else {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateIkenshoIraisho();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査票(特記事項) チェックボックスのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onChange_chkChosahyoKatamen(IraishoIkkatsuHakkoDiv div) {
        List<RString> 調査票選択selectedKeys = div.getChkChosahyoKatamen().getSelectedKeys();
        if (調査票選択selectedKeys.contains(KEY2)) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateTokkijiko();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査票(特記事項) チェックボックスのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onChange_chkChosahyoRyomen(IraishoIkkatsuHakkoDiv div) {
        List<RString> 調査票両面選択selectedKeys = div.getChkChosahyoRyomen().getSelectedKeys();
        if (調査票両面選択selectedKeys.contains(KEY2)) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateTokkijiko();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査票(特記事項) チェックボックスのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onChange_chkChosahyoTokki(IraishoIkkatsuHakkoDiv div) {
        List<RString> 委託特記事項選択selectedKeys = div.getChkChosahyoTokki().getSelectedKeys();
        if (!委託特記事項選択selectedKeys.isEmpty()) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateTokkijiko();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主事意見書作成依頼書 チェックボックスのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onChange_chkIkenshoIraisho(IraishoIkkatsuHakkoDiv div) {
        getHandler(div).setChkIkenshoSeikyusho();
        return ResponseData.of(div).respond();
    }

    private IraishoIkkatsuHakkoHandler getHandler(IraishoIkkatsuHakkoDiv div) {
        return new IraishoIkkatsuHakkoHandler(div);
    }

    private IraishoIkkatsuHakkoValidationHandler getValidationHandler(IraishoIkkatsuHakkoDiv div) {
        return new IraishoIkkatsuHakkoValidationHandler(div);
    }

}
