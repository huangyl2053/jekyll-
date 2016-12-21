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
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.iraisho.IraishoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.DBE2400001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.IraishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.dgNinteiChosaIraiTaishoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2400001.IraishoIkkatsuHakkoHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2400001.IraishoIkkatsuHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.iraisho.IraishoIkkatsuHakkoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
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
    private static final RString SELECTED_KEY3 = new RString("key3");
    private static final RString NO_PRINT = new RString("1");
    private static final RString PRINT = new RString("2");
    private static final RString PRINT_AND_NOPRINT = new RString("3");
    private static final RString COMMON_DATE = new RString("2");
    private static final RString COMMON_PRINT = new RString("1");
    private static final RString COMMON_NO_PRINT = new RString("0");
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
        getHandler(div).load(DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
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
            getHandler(div).load(DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
            return ResponseData.of(div).setState(DBE2400001StateName.認定調査依頼);
        }
        if (SELECTED_KEY1.equals(div.getRadTaishoSentaku().getSelectedKey())) {
            getHandler(div).shuziiiKenshoLoad(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法,
                    RDate.getNowDate(),
                    SubGyomuCode.DBE認定支援));
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
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler(div).iraibiZengoJunCheck());
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        List<IraishoIkkatsuHakkoResult> resultList = new ArrayList<>();
        DBE2400001StateName resultState = null;
        if (new RString(DBE2400001StateName.認定調査依頼.name()).equals(ResponseHolder.getState())) {
            IraishoIkkatsuHakkoParameter param
                    = IraishoIkkatsuHakkoParameter.createIraishoIkkatsuHakkoParameter(
                            div.getTxtIraibiFrom().getValue(),
                            div.getTxtIraibiTo().getValue(),
                            div.getChkNinteioChosaIraisho().getSelectedKeys(),
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
                            div.getTxtShujiiIkenshoSakuseiIraibiFrom().getValue(),
                            div.getTxtShujiiIkenshoSakuseiIraibiTo().getValue(),
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
     * 申請単位チェックボックス選択の場合、同Div内のチェックボックスの使用可不可を設定します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onChange_chkShinseiTani(IraishoIkkatsuHakkoDiv div) {
        getHandler(div).setChkShinseiTani();
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
        validationMessages.add(getValidationHandler(div).iraibiZengoJunCheck());
        validationMessages.add(getValidationHandler(div).iraiItiranCheck());
        validationMessages.add(getValidationHandler(div).printChouhyouSentakuCheck());
        validationMessages.add(getValidationHandler(div).commonDateCheck());

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
        if (new RString(DBE2400001StateName.認定調査依頼_検索結果.name()).equals(div.getState())) {
            param.setIraiFromYMD(div.getTxtIraibiFrom().getValue() == null
                    ? RString.EMPTY : div.getTxtIraibiFrom().getValue().toDateString());
            param.setIraiToYMD(div.getTxtIraibiTo().getValue() == null
                    ? RString.EMPTY : div.getTxtIraibiTo().getValue().toDateString());
            setNinteParam(param, div);
        }
        if (new RString(DBE2400001StateName.主治医意見書作成依頼_検索結果.name()).equals(div.getState())) {
            param.setIraiFromYMD(div.getTxtShujiiIkenshoSakuseiIraibiFrom().getValue() == null
                    ? RString.EMPTY : div.getTxtShujiiIkenshoSakuseiIraibiFrom().getValue().toDateString());
            param.setIraiToYMD(div.getTxtShujiiIkenshoSakuseiIraibiTo().getValue() == null
                    ? RString.EMPTY : div.getTxtShujiiIkenshoSakuseiIraibiTo().getValue().toDateString());
            setShujiiParam(param, div);
        }
        param.setHakkobi(div.getTxtHakkobi().getValue() == null
                ? RString.EMPTY : div.getTxtHakkobi().getValue().toDateString());
        if (SELECTED_KEY0.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            param.setTeishutsuKigen(COMMON_NO_PRINT);
        } else if (SELECTED_KEY1.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            param.setTeishutsuKigen(COMMON_PRINT);
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
        return ResponseData.of(param).respond();
    }

    private void setNinteParam(DBE220010_IraishoIkkatuParameter param, IraishoIkkatsuHakkoDiv div) {
        if (div.getChkNinteioChosaIraisho().getSelectedKeys().size() == 2) {
            param.setNinteioChosaIraisho(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkNinteioChosaIraisho().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setNinteioChosaIraisho(NO_PRINT);
            }
            if (div.getChkNinteioChosaIraisho().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setNinteioChosaIraisho(PRINT);
            }
        }
        if (div.getChkNinteiChosahyo().getSelectedKeys().size() == 2) {
            param.setNinteiChosahyo(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkNinteiChosahyo().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setNinteiChosahyo(NO_PRINT);
            }
            if (div.getChkNinteiChosahyo().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setNinteiChosahyo(PRINT);
            }
        }
        List<GridParameter> ninteiChosaIraiList = new ArrayList<>();
        for (dgNinteiChosaIraiTaishoIchiran_Row row : div.getDgNinteiChosaIraiTaishoIchiran().getSelectedItems()) {
            GridParameter gridParameter = new GridParameter();
            gridParameter.setNinteichosaItakusakiCode(row.getNinteiChosaitakusaki());
            gridParameter.setNinteiChosainCode(row.getNinteiChosainNo());
            gridParameter.setShoKisaiHokenshaNo(row.getShoKisaiHokenshaNo());
            ninteiChosaIraiList.add(gridParameter);
        }
        param.setNinteiChosaIraiList(ninteiChosaIraiList);
        param.setNinteiChosaIraiChohyo(div.getChkNinteiChosaIraiChohyo().getSelectedKeys().contains(SELECTED_KEY0));
        if (div.getChkNinteiChosaIraiChohyo().getSelectedKeys().contains(SELECTED_KEY1)) {
            param.set認定調査依頼書(is適用(div.getChkChosaIrai()));
            param.set認定調査票_デザイン用紙(is適用(div.getChkChosaDesign()));
            param.set特記事項_デザイン用紙(is適用(div.getChkTokkiDesign()));
            param.set認定調査票OCR(is適用(div.getChkChosaOcr()));
            param.set特記事項OCR(is適用(div.getChkTokkiOcr()));
            param.set認定調査差異チェック票(is適用(div.getChkSaiCheck()));
            param.set概況特記(is適用(div.getChkGaikyoTokki()));
            param.set特記事項_項目あり(is適用(div.getChkTokkiKomokuAri()));
            param.set特記事項_項目無し(is適用(div.getChkTokkiKomokuNashi()));
            param.set特記事項_フリータイプ(is適用(div.getChkTokkiFree()));
            param.set手入力タイプ(is適用(div.getChkTokkijikoTenyuryoku()));
            param.set前回認定調査結果との比較表(is適用(div.getChkNinteiChosahyoSonota()));
        }
        param.setNinteiChosairaiHakkou(div.getChkchosairaihakko().getSelectedKeys().contains(SELECTED_KEY0));
        param.set認定調査依頼履歴一覧(div.getChkchosairaiRireki().getSelectedKeys().contains(SELECTED_KEY0));
    }
    
    private boolean is適用(CheckBoxList chk) {
        return !chk.getSelectedKeys().isEmpty();
    }

    private void setShujiiParam(DBE220010_IraishoIkkatuParameter param, IraishoIkkatsuHakkoDiv div) {
        if (div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys().size() == 2) {
            param.setShujiiikenshoSakuseiIrai(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setShujiiikenshoSakuseiIrai(NO_PRINT);
            }
            if (div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setShujiiikenshoSakuseiIrai(PRINT);
            }
        }
        if (div.getChkShujiiIkensho().getSelectedKeys().size() == 2) {
            param.setShujiiIkensho(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkShujiiIkensho().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setShujiiIkensho(NO_PRINT);
            }
            if (div.getChkShujiiIkensho().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setShujiiIkensho(PRINT);
            }
        }
        List<GridParameter> shujiiIkenshoSakuseiIraiList = new ArrayList<>();
        for (dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row row : div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran().getSelectedItems()) {
            GridParameter gridParameter = new GridParameter();
            gridParameter.setShujiiIryoKikanCode(row.getShujiiIryoKikanCode());
            gridParameter.setIshiNo(row.getIshiNo());
            gridParameter.setShoKisaiHokenshaNo(row.getShoKisaiHokenshaNo());
            shujiiIkenshoSakuseiIraiList.add(gridParameter);
        }
        param.setShujiiIkenshoSakuseiIraiList(shujiiIkenshoSakuseiIraiList);
        param.setIkenshoSakuseiirai(div.getChkShujiiIkenshoShutsuryoku().getSelectedKeys().contains(SELECTED_KEY0));
        param.setIkenshoSakuseiSeikyuu(div.getChkShujiiIkenshoShutsuryoku().getSelectedKeys().contains(SELECTED_KEY1));
        if (div.getChkShujiiIkenshoShutsuryoku().getSelectedKeys().contains(SELECTED_KEY2)) {
            param.setShujiiIkenshoSakuseiIraisho(div.getChkShujiiIkenshoSakuseiIraisho().getSelectedKeys().contains(SELECTED_KEY0));
            param.setIkenshoKinyuu(div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().getSelectedKeys().contains(SELECTED_KEY0));
            param.setIkenshoKinyuuOCR(div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().getSelectedKeys().contains(SELECTED_KEY1));
            param.setIkenshoKinyuuDesign(div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().getSelectedKeys().contains(SELECTED_KEY3));
            param.setIkenshoSakuseiSeikyuusho(div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().getSelectedKeys().contains(SELECTED_KEY2));
            param.setIkenshoTeishutu(div.getChkShindanMeireishoAndTeishutsuIraisho().getSelectedKeys().contains(SELECTED_KEY0));
        }
        param.setIkenshoSakuseiIraiHakkou(div.getChkikenshiiraihakko().getSelectedKeys().contains(SELECTED_KEY0));
        param.set主治医意見書依頼履歴一覧(div.getChkikenshiiraiRireki().getSelectedKeys().contains(SELECTED_KEY0));
    }

    private IraishoIkkatsuHakkoHandler getHandler(IraishoIkkatsuHakkoDiv div) {
        return new IraishoIkkatsuHakkoHandler(div);
    }

    private IraishoIkkatsuHakkoValidationHandler getValidationHandler(IraishoIkkatsuHakkoDiv div) {
        return new IraishoIkkatsuHakkoValidationHandler(div);
    }

}
